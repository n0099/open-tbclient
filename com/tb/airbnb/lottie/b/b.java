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
/* loaded from: classes6.dex */
public class b {
    private static final Object CL = new Object();
    private String CN;
    private final Map<String, g> CP;
    private final Context context;
    @Nullable
    private com.tb.airbnb.lottie.b njp;

    public b(Drawable.Callback callback, String str, com.tb.airbnb.lottie.b bVar, Map<String, g> map) {
        this.CN = str;
        if (!TextUtils.isEmpty(str) && this.CN.charAt(this.CN.length() - 1) != '/') {
            this.CN += '/';
        }
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.CP = new HashMap();
            this.context = null;
            return;
        }
        this.context = ((View) callback).getContext();
        this.CP = map;
        a(bVar);
    }

    public void a(@Nullable com.tb.airbnb.lottie.b bVar) {
        this.njp = bVar;
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        if (bitmap == null) {
            g gVar = this.CP.get(str);
            Bitmap bitmap2 = gVar.getBitmap();
            gVar.setBitmap(null);
            return bitmap2;
        }
        return b(str, bitmap);
    }

    @Nullable
    public Bitmap bd(String str) {
        g gVar = this.CP.get(str);
        if (gVar == null) {
            return null;
        }
        Bitmap bitmap = gVar.getBitmap();
        if (bitmap != null) {
            return bitmap;
        }
        if (this.njp != null) {
            Bitmap fetchBitmap = this.njp.fetchBitmap(gVar);
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
            if (TextUtils.isEmpty(this.CN)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            return b(str, BitmapFactory.decodeStream(this.context.getAssets().open(this.CN + fileName), null, options));
        } catch (IOException e2) {
            Log.w("LOTTIE", "Unable to open asset.", e2);
            return null;
        }
    }

    public void recycleBitmaps() {
        synchronized (CL) {
            for (Map.Entry<String, g> entry : this.CP.entrySet()) {
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
        synchronized (CL) {
            this.CP.get(str).setBitmap(bitmap);
        }
        return bitmap;
    }
}
