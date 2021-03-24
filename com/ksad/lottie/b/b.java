package com.ksad.lottie.b;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.ksad.lottie.g;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f31322a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final Context f31323b;

    /* renamed from: c  reason: collision with root package name */
    public String f31324c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public com.ksad.lottie.b f31325d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, g> f31326e;

    public b(Drawable.Callback callback, String str, com.ksad.lottie.b bVar, Map<String, g> map) {
        String str2;
        this.f31324c = str;
        if (!TextUtils.isEmpty(str)) {
            if (this.f31324c.charAt(str2.length() - 1) != '/') {
                this.f31324c += '/';
            }
        }
        if (callback instanceof View) {
            this.f31323b = ((View) callback).getContext();
            this.f31326e = map;
            a(bVar);
            return;
        }
        Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
        this.f31326e = new HashMap();
        this.f31323b = null;
    }

    private Bitmap a(String str, @Nullable Bitmap bitmap) {
        synchronized (f31322a) {
            this.f31326e.get(str).a(bitmap);
        }
        return bitmap;
    }

    @Nullable
    public Bitmap a(String str) {
        String str2;
        Bitmap decodeStream;
        g gVar = this.f31326e.get(str);
        if (gVar == null) {
            return null;
        }
        Bitmap c2 = gVar.c();
        if (c2 != null) {
            return c2;
        }
        com.ksad.lottie.b bVar = this.f31325d;
        if (bVar != null) {
            Bitmap a2 = bVar.a(gVar);
            if (a2 != null) {
                a(str, a2);
            }
            return a2;
        }
        String b2 = gVar.b();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (!b2.startsWith(WebGLImageLoader.DATA_URL) || b2.indexOf("base64,") <= 0) {
            try {
                if (TextUtils.isEmpty(this.f31324c)) {
                    throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
                }
                AssetManager assets = this.f31323b.getAssets();
                decodeStream = BitmapFactory.decodeStream(assets.open(this.f31324c + b2), null, options);
            } catch (IOException e2) {
                e = e2;
                str2 = "Unable to open asset.";
                Log.w("LOTTIE", str2, e);
                return null;
            }
        } else {
            try {
                byte[] decode = Base64.decode(b2.substring(b2.indexOf(44) + 1), 0);
                decodeStream = BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
            } catch (IllegalArgumentException e3) {
                e = e3;
                str2 = "data URL did not have correct base64 format.";
                Log.w("LOTTIE", str2, e);
                return null;
            }
        }
        return a(str, decodeStream);
    }

    public void a() {
        synchronized (f31322a) {
            for (Map.Entry<String, g> entry : this.f31326e.entrySet()) {
                g value = entry.getValue();
                Bitmap c2 = value.c();
                if (c2 != null) {
                    c2.recycle();
                    value.a(null);
                }
            }
        }
    }

    public void a(@Nullable com.ksad.lottie.b bVar) {
        this.f31325d = bVar;
    }

    public boolean a(Context context) {
        return (context == null && this.f31323b == null) || this.f31323b.equals(context);
    }
}
