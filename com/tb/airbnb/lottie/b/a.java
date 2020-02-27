package com.tb.airbnb.lottie.b;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import com.tb.airbnb.lottie.model.h;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {
    private final AssetManager assetManager;
    @Nullable
    private com.tb.airbnb.lottie.a nqx;
    private final h<String> nqw = new h<>();
    private final Map<h<String>, Typeface> hh = new HashMap();
    private final Map<String, Typeface> hi = new HashMap();
    private String hk = ".ttf";

    public a(Drawable.Callback callback, @Nullable com.tb.airbnb.lottie.a aVar) {
        this.nqx = aVar;
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.assetManager = null;
            return;
        }
        this.assetManager = ((View) callback).getContext().getAssets();
    }

    public void a(@Nullable com.tb.airbnb.lottie.a aVar) {
        this.nqx = aVar;
    }

    public Typeface j(String str, String str2) {
        this.nqw.set(str, str2);
        Typeface typeface = this.hh.get(this.nqw);
        if (typeface == null) {
            Typeface a = a(M(str), str2);
            this.hh.put(this.nqw, a);
            return a;
        }
        return typeface;
    }

    private Typeface M(String str) {
        String E;
        Typeface typeface = this.hi.get(str);
        if (typeface == null) {
            typeface = null;
            if (this.nqx != null) {
                typeface = this.nqx.D(str);
            }
            if (this.nqx != null && typeface == null && (E = this.nqx.E(str)) != null) {
                typeface = Typeface.createFromAsset(this.assetManager, E);
            }
            if (typeface == null) {
                typeface = Typeface.createFromAsset(this.assetManager, "fonts/" + str + this.hk);
            }
            this.hi.put(str, typeface);
        }
        return typeface;
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
}
