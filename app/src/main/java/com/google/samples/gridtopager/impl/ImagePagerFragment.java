package com.google.samples.gridtopager.impl;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import net.mobileapplab.library.GalleryItem;
import net.mobileapplab.library.gallery.AbstractImageFragment;
import net.mobileapplab.library.gallery.AbstractImagePagerAdapter;
import net.mobileapplab.library.gallery.AbstractImagePagerFragment;

import java.util.ArrayList;

public class ImagePagerFragment extends AbstractImagePagerFragment {
    public static ImagePagerFragment newInstance(@NonNull ArrayList<GalleryItem> gallery) {
        final ImagePagerFragment fragment = new ImagePagerFragment();
        fragment.setArguments(createArgsBundle(gallery));
        return fragment;
    }

    @Override
    public AbstractImagePagerAdapter getAdapter(ArrayList<GalleryItem> list) {
        return new ImagePagerAdapter(this, list);
    }

    private static class ImagePagerAdapter extends AbstractImagePagerAdapter {
        ImagePagerAdapter(Fragment fragment, @NonNull ArrayList<GalleryItem> list) {
            super(fragment, list);
        }

        @Override
        public AbstractImageFragment getItemFragment(GalleryItem galleryItem) {
            return ImageFragment.newInstance(galleryItem);
        }
    }
}
