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
/* loaded from: classes6.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public final AssetManager f31319d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public com.ksad.lottie.a f31320e;

    /* renamed from: a  reason: collision with root package name */
    public final f<String> f31316a = new f<>();

    /* renamed from: b  reason: collision with root package name */
    public final Map<f<String>, Typeface> f31317b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, Typeface> f31318c = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public String f31321f = ".ttf";

    public a(Drawable.Callback callback, @Nullable com.ksad.lottie.a aVar) {
        AssetManager assets;
        this.f31320e = aVar;
        if (callback instanceof View) {
            assets = ((View) callback).getContext().getAssets();
        } else {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            assets = null;
        }
        this.f31319d = assets;
    }

    private Typeface a(Typeface typeface, String str) {
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        int i = (contains && contains2) ? 3 : contains ? 2 : contains2 ? 1 : 0;
        return typeface.getStyle() == i ? typeface : Typeface.create(typeface, i);
    }

    private Typeface a(String str) {
        String b2;
        Typeface typeface = this.f31318c.get(str);
        if (typeface != null) {
            return typeface;
        }
        com.ksad.lottie.a aVar = this.f31320e;
        Typeface a2 = aVar != null ? aVar.a(str) : null;
        com.ksad.lottie.a aVar2 = this.f31320e;
        if (aVar2 != null && a2 == null && (b2 = aVar2.b(str)) != null) {
            a2 = Typeface.createFromAsset(this.f31319d, b2);
        }
        if (a2 == null) {
            a2 = Typeface.createFromAsset(this.f31319d, "fonts/" + str + this.f31321f);
        }
        this.f31318c.put(str, a2);
        return a2;
    }

    public Typeface a(String str, String str2) {
        this.f31316a.a(str, str2);
        Typeface typeface = this.f31317b.get(this.f31316a);
        if (typeface != null) {
            return typeface;
        }
        Typeface a2 = a(a(str), str2);
        this.f31317b.put(this.f31316a, a2);
        return a2;
    }

    public void a(@Nullable com.ksad.lottie.a aVar) {
        this.f31320e = aVar;
    }
}
