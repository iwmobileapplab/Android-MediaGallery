package com.google.samples.gridtopager.impl;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import net.mobileapplab.library.GalleryItem;
import net.mobileapplab.library.gallery.AbstractImageFragment;

public class ImageFragment extends AbstractImageFragment {
    public static ImageFragment newInstance(@NonNull GalleryItem item) {
        ImageFragment fragment = new ImageFragment();
        fragment.setArguments(createArgsBundle(item));
        return fragment;
    }

    @Override
    public void onRequestImage(@NonNull Uri uri, @NonNull ImageView imageView) {
        Glide.with(this)
                .load(uri)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable>
                            target, boolean isFirstResource) {
                        onFinishImageLoading();
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable>
                            target, DataSource dataSource, boolean isFirstResource) {
                        onFinishImageLoading();
                        return false;
                    }
                })
                .into(imageView);
    }

    @Override
    public void onDismiss() {
        super.onDismiss();
    }

    @Override
    public void onMove(float translationY) {
        super.onMove(translationY);
    }
}
