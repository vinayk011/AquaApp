package com.aqua.binding;

import android.widget.ImageView;

import com.aqua.util.ImageUtil;

import androidx.databinding.BindingAdapter;

public class AquaBindings {
    @BindingAdapter("img_src")
    public static void setSrc(ImageView imageView, int resId) {
        imageView.setImageBitmap(ImageUtil.decodeSampledBitmapFromResource(imageView.getResources(), resId, 100, 100));
    }
}
