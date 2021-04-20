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
    public final AssetManager f31609d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public com.ksad.lottie.a f31610e;

    /* renamed from: a  reason: collision with root package name */
    public final f<String> f31606a = new f<>();

    /* renamed from: b  reason: collision with root package name */
    public final Map<f<String>, Typeface> f31607b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, Typeface> f31608c = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public String f31611f = ".ttf";

    public a(Drawable.Callback callback, @Nullable com.ksad.lottie.a aVar) {
        AssetManager assets;
        this.f31610e = aVar;
        if (callback instanceof View) {
            assets = ((View) callback).getContext().getAssets();
        } else {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            assets = null;
        }
        this.f31609d = assets;
    }

    private Typeface a(Typeface typeface, String str) {
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        int i = (contains && contains2) ? 3 : contains ? 2 : contains2 ? 1 : 0;
        return typeface.getStyle() == i ? typeface : Typeface.create(typeface, i);
    }

    private Typeface a(String str) {
        String b2;
        Typeface typeface = this.f31608c.get(str);
        if (typeface != null) {
            return typeface;
        }
        com.ksad.lottie.a aVar = this.f31610e;
        Typeface a2 = aVar != null ? aVar.a(str) : null;
        com.ksad.lottie.a aVar2 = this.f31610e;
        if (aVar2 != null && a2 == null && (b2 = aVar2.b(str)) != null) {
            a2 = Typeface.createFromAsset(this.f31609d, b2);
        }
        if (a2 == null) {
            a2 = Typeface.createFromAsset(this.f31609d, "fonts/" + str + this.f31611f);
        }
        this.f31608c.put(str, a2);
        return a2;
    }

    public Typeface a(String str, String str2) {
        this.f31606a.a(str, str2);
        Typeface typeface = this.f31607b.get(this.f31606a);
        if (typeface != null) {
            return typeface;
        }
        Typeface a2 = a(a(str), str2);
        this.f31607b.put(this.f31606a, a2);
        return a2;
    }

    public void a(@Nullable com.ksad.lottie.a aVar) {
        this.f31610e = aVar;
    }
}
