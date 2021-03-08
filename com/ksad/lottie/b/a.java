package com.ksad.lottie.b;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import com.ksad.lottie.model.f;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {
    private final AssetManager d;
    @Nullable
    private com.ksad.lottie.a e;

    /* renamed from: a  reason: collision with root package name */
    private final f<String> f5325a = new f<>();
    private final Map<f<String>, Typeface> b = new HashMap();
    private final Map<String, Typeface> c = new HashMap();
    private String f = ".ttf";

    public a(Drawable.Callback callback, @Nullable com.ksad.lottie.a aVar) {
        this.e = aVar;
        if (callback instanceof View) {
            this.d = ((View) callback).getContext().getAssets();
            return;
        }
        Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
        this.d = null;
    }

    private Typeface a(Typeface typeface, String str) {
        int i = 0;
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        if (contains && contains2) {
            i = 3;
        } else if (contains) {
            i = 2;
        } else if (contains2) {
            i = 1;
        }
        return typeface.getStyle() == i ? typeface : Typeface.create(typeface, i);
    }

    private Typeface a(String str) {
        String b;
        Typeface typeface = this.c.get(str);
        if (typeface == null) {
            typeface = this.e != null ? this.e.a(str) : null;
            if (this.e != null && typeface == null && (b = this.e.b(str)) != null) {
                typeface = Typeface.createFromAsset(this.d, b);
            }
            if (typeface == null) {
                typeface = Typeface.createFromAsset(this.d, "fonts/" + str + this.f);
            }
            this.c.put(str, typeface);
        }
        return typeface;
    }

    public Typeface a(String str, String str2) {
        this.f5325a.a(str, str2);
        Typeface typeface = this.b.get(this.f5325a);
        if (typeface != null) {
            return typeface;
        }
        Typeface a2 = a(a(str), str2);
        this.b.put(this.f5325a, a2);
        return a2;
    }

    public void a(@Nullable com.ksad.lottie.a aVar) {
        this.e = aVar;
    }
}
