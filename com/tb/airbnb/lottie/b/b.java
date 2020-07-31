package com.tb.airbnb.lottie.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import com.tb.airbnb.lottie.g;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class b {
    private static final Object Ds = new Object();
    private String Dt;
    private final Map<String, g> Dv;
    private final Context context;
    @Nullable
    private com.tb.airbnb.lottie.b nOZ;

    public b(Drawable.Callback callback, String str, com.tb.airbnb.lottie.b bVar, Map<String, g> map) {
        this.Dt = str;
        if (!TextUtils.isEmpty(str) && this.Dt.charAt(this.Dt.length() - 1) != '/') {
            this.Dt += '/';
        }
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.Dv = new HashMap();
            this.context = null;
            return;
        }
        this.context = ((View) callback).getContext();
        this.Dv = map;
        a(bVar);
    }

    public void a(@Nullable com.tb.airbnb.lottie.b bVar) {
        this.nOZ = bVar;
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        if (bitmap == null) {
            g gVar = this.Dv.get(str);
            Bitmap bitmap2 = gVar.getBitmap();
            gVar.setBitmap(null);
            return bitmap2;
        }
        return b(str, bitmap);
    }

    @Nullable
    public Bitmap be(String str) {
        g gVar = this.Dv.get(str);
        if (gVar == null) {
            return null;
        }
        Bitmap bitmap = gVar.getBitmap();
        if (bitmap != null) {
            return bitmap;
        }
        if (this.nOZ != null) {
            Bitmap fetchBitmap = this.nOZ.fetchBitmap(gVar);
            if (fetchBitmap != null) {
                b(str, fetchBitmap);
                return fetchBitmap;
            }
            return fetchBitmap;
        }
        String fileName = gVar.getFileName();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (fileName.startsWith("data:") && fileName.indexOf("base64,") > 0) {
            try {
                byte[] decode = Base64.decode(fileName.substring(fileName.indexOf(44) + 1), 0);
                return b(str, BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
            } catch (IllegalArgumentException e) {
                Log.w("LOTTIE", "data URL did not have correct base64 format.", e);
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(this.Dt)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            return b(str, BitmapFactory.decodeStream(this.context.getAssets().open(this.Dt + fileName), null, options));
        } catch (IOException e2) {
            Log.w("LOTTIE", "Unable to open asset.", e2);
            return null;
        }
    }

    public void recycleBitmaps() {
        synchronized (Ds) {
            for (Map.Entry<String, g> entry : this.Dv.entrySet()) {
                g value = entry.getValue();
                Bitmap bitmap = value.getBitmap();
                if (bitmap != null) {
                    bitmap.recycle();
                    value.setBitmap(null);
                }
            }
        }
    }

    public boolean D(Context context) {
        return (context == null && this.context == null) || this.context.equals(context);
    }

    private Bitmap b(String str, @Nullable Bitmap bitmap) {
        synchronized (Ds) {
            this.Dv.get(str).setBitmap(bitmap);
        }
        return bitmap;
    }
}
