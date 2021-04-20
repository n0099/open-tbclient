package com.davemorrissey.labs.subscaleview.decoder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import java.util.List;
/* loaded from: classes5.dex */
public class SkiaImageRegionDecoder implements ImageRegionDecoder {
    public static final String ASSET_PREFIX = "file:///android_asset/";
    public static final String FILE_PREFIX = "file://";
    public static final String RESOURCE_PREFIX = "android.resource://";
    public BitmapRegionDecoder decoder;
    public final Object decoderLock = new Object();

    @Override // com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder
    public Bitmap decodeRegion(Rect rect, int i) {
        Bitmap decodeRegion;
        synchronized (this.decoderLock) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = i;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            decodeRegion = this.decoder.decodeRegion(rect, options);
            if (decodeRegion == null) {
                throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
            }
        }
        return decodeRegion;
    }

    @Override // com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder
    public Point init(Context context, Uri uri) throws Exception {
        Resources resourcesForApplication;
        int i;
        String uri2 = uri.toString();
        if (uri2.startsWith("android.resource://")) {
            String authority = uri.getAuthority();
            if (context.getPackageName().equals(authority)) {
                resourcesForApplication = context.getResources();
            } else {
                resourcesForApplication = context.getPackageManager().getResourcesForApplication(authority);
            }
            List<String> pathSegments = uri.getPathSegments();
            int size = pathSegments.size();
            if (size == 2 && pathSegments.get(0).equals("drawable")) {
                i = resourcesForApplication.getIdentifier(pathSegments.get(1), "drawable", authority);
            } else {
                if (size == 1 && TextUtils.isDigitsOnly(pathSegments.get(0))) {
                    try {
                        i = Integer.parseInt(pathSegments.get(0));
                    } catch (NumberFormatException unused) {
                    }
                }
                i = 0;
            }
            this.decoder = BitmapRegionDecoder.newInstance(context.getResources().openRawResource(i), false);
        } else if (uri2.startsWith("file:///android_asset/")) {
            this.decoder = BitmapRegionDecoder.newInstance(context.getAssets().open(uri2.substring(22), 1), false);
        } else if (uri2.startsWith("file://")) {
            this.decoder = BitmapRegionDecoder.newInstance(uri2.substring(7), false);
        } else {
            this.decoder = BitmapRegionDecoder.newInstance(context.getContentResolver().openInputStream(uri), false);
        }
        return new Point(this.decoder.getWidth(), this.decoder.getHeight());
    }

    @Override // com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder
    public boolean isReady() {
        BitmapRegionDecoder bitmapRegionDecoder = this.decoder;
        return (bitmapRegionDecoder == null || bitmapRegionDecoder.isRecycled()) ? false : true;
    }

    @Override // com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder
    public void recycle() {
        this.decoder.recycle();
    }
}
