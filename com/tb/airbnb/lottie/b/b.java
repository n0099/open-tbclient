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
import com.tb.airbnb.lottie.c;
import com.tb.airbnb.lottie.h;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes20.dex */
public class b {
    private static final Object Fi = new Object();
    private String Fj;
    private final Map<String, h> Fl;
    private final Context context;
    @Nullable
    private c pBL;

    public b(Drawable.Callback callback, String str, c cVar, Map<String, h> map) {
        this.Fj = str;
        if (!TextUtils.isEmpty(str) && this.Fj.charAt(this.Fj.length() - 1) != '/') {
            this.Fj += '/';
        }
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.Fl = new HashMap();
            this.context = null;
            return;
        }
        this.context = ((View) callback).getContext();
        this.Fl = map;
        a(cVar);
    }

    public void a(@Nullable c cVar) {
        this.pBL = cVar;
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        if (bitmap == null) {
            h hVar = this.Fl.get(str);
            Bitmap bitmap2 = hVar.getBitmap();
            hVar.setBitmap(null);
            return bitmap2;
        }
        return b(str, bitmap);
    }

    @Nullable
    public Bitmap bm(String str) {
        h hVar = this.Fl.get(str);
        if (hVar == null) {
            return null;
        }
        Bitmap bitmap = hVar.getBitmap();
        if (bitmap != null) {
            return bitmap;
        }
        if (this.pBL != null) {
            Bitmap fetchBitmap = this.pBL.fetchBitmap(hVar);
            if (fetchBitmap != null) {
                b(str, fetchBitmap);
                return fetchBitmap;
            }
            return fetchBitmap;
        }
        String fileName = hVar.getFileName();
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
            if (TextUtils.isEmpty(this.Fj)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            return b(str, BitmapFactory.decodeStream(this.context.getAssets().open(this.Fj + fileName), null, options));
        } catch (IOException e2) {
            Log.w("LOTTIE", "Unable to open asset.", e2);
            return null;
        }
    }

    public void recycleBitmaps() {
        synchronized (Fi) {
            for (Map.Entry<String, h> entry : this.Fl.entrySet()) {
                h value = entry.getValue();
                Bitmap bitmap = value.getBitmap();
                if (bitmap != null) {
                    bitmap.recycle();
                    value.setBitmap(null);
                }
            }
        }
    }

    public boolean G(Context context) {
        return (context == null && this.context == null) || this.context.equals(context);
    }

    private Bitmap b(String str, @Nullable Bitmap bitmap) {
        synchronized (Fi) {
            this.Fl.get(str).setBitmap(bitmap);
        }
        return bitmap;
    }
}
