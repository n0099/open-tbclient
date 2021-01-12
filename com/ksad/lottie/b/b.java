package com.ksad.lottie.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import com.ksad.lottie.g;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f7965a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final Context f7966b;
    private String c;
    @Nullable
    private com.ksad.lottie.b d;
    private final Map<String, g> e;

    public b(Drawable.Callback callback, String str, com.ksad.lottie.b bVar, Map<String, g> map) {
        this.c = str;
        if (!TextUtils.isEmpty(str) && this.c.charAt(this.c.length() - 1) != '/') {
            this.c += '/';
        }
        if (callback instanceof View) {
            this.f7966b = ((View) callback).getContext();
            this.e = map;
            a(bVar);
            return;
        }
        Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
        this.e = new HashMap();
        this.f7966b = null;
    }

    private Bitmap a(String str, @Nullable Bitmap bitmap) {
        synchronized (f7965a) {
            this.e.get(str).a(bitmap);
        }
        return bitmap;
    }

    @Nullable
    public Bitmap a(String str) {
        g gVar = this.e.get(str);
        if (gVar == null) {
            return null;
        }
        Bitmap c = gVar.c();
        if (c != null) {
            return c;
        }
        if (this.d != null) {
            Bitmap a2 = this.d.a(gVar);
            if (a2 != null) {
                a(str, a2);
                return a2;
            }
            return a2;
        }
        String b2 = gVar.b();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (b2.startsWith("data:") && b2.indexOf("base64,") > 0) {
            try {
                byte[] decode = Base64.decode(b2.substring(b2.indexOf(44) + 1), 0);
                return a(str, BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
            } catch (IllegalArgumentException e) {
                Log.w("LOTTIE", "data URL did not have correct base64 format.", e);
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(this.c)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            return a(str, BitmapFactory.decodeStream(this.f7966b.getAssets().open(this.c + b2), null, options));
        } catch (IOException e2) {
            Log.w("LOTTIE", "Unable to open asset.", e2);
            return null;
        }
    }

    public void a() {
        synchronized (f7965a) {
            for (Map.Entry<String, g> entry : this.e.entrySet()) {
                g value = entry.getValue();
                Bitmap c = value.c();
                if (c != null) {
                    c.recycle();
                    value.a(null);
                }
            }
        }
    }

    public void a(@Nullable com.ksad.lottie.b bVar) {
        this.d = bVar;
    }

    public boolean a(Context context) {
        return (context == null && this.f7966b == null) || this.f7966b.equals(context);
    }
}
