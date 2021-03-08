package com.davemorrissey.labs.subscaleview.decoder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import java.util.List;
/* loaded from: classes14.dex */
public class SkiaImageDecoder implements ImageDecoder {
    private static final String ASSET_PREFIX = "file:///android_asset/";
    public static final String FILE_PREFIX = "file://";
    private static final String RESOURCE_PREFIX = "android.resource://";

    @Override // com.davemorrissey.labs.subscaleview.decoder.ImageDecoder
    public Bitmap decode(Context context, Uri uri) throws Exception {
        Bitmap decodeStream;
        Resources resourcesForApplication;
        int i;
        String uri2 = uri.toString();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        if (uri2.startsWith(RESOURCE_PREFIX)) {
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
            } else if (size == 1 && TextUtils.isDigitsOnly(pathSegments.get(0))) {
                try {
                    i = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException e) {
                    i = 0;
                }
            } else {
                i = 0;
            }
            decodeStream = BitmapFactory.decodeResource(context.getResources(), i, options);
        } else if (uri2.startsWith(ASSET_PREFIX)) {
            decodeStream = BitmapFactory.decodeStream(context.getAssets().open(uri2.substring(ASSET_PREFIX.length())), null, options);
        } else if (uri2.startsWith("file://")) {
            decodeStream = BitmapFactory.decodeFile(uri2.substring("file://".length()), options);
        } else {
            decodeStream = BitmapFactory.decodeStream(context.getContentResolver().openInputStream(uri), null, options);
        }
        if (decodeStream == null) {
            throw new RuntimeException("Skia image region decoder returned null bitmap - image format may not be supported");
        }
        return decodeStream;
    }
}
