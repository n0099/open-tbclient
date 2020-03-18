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
    private com.tb.airbnb.lottie.a nsx;
    private final h<String> nsw = new h<>();
    private final Map<h<String>, Typeface> hg = new HashMap();
    private final Map<String, Typeface> hh = new HashMap();
    private String hj = ".ttf";

    public a(Drawable.Callback callback, @Nullable com.tb.airbnb.lottie.a aVar) {
        this.nsx = aVar;
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.assetManager = null;
            return;
        }
        this.assetManager = ((View) callback).getContext().getAssets();
    }

    public void a(@Nullable com.tb.airbnb.lottie.a aVar) {
        this.nsx = aVar;
    }

    public Typeface j(String str, String str2) {
        this.nsw.set(str, str2);
        Typeface typeface = this.hg.get(this.nsw);
        if (typeface == null) {
            Typeface a = a(M(str), str2);
            this.hg.put(this.nsw, a);
            return a;
        }
        return typeface;
    }

    private Typeface M(String str) {
        String E;
        Typeface typeface = this.hh.get(str);
        if (typeface == null) {
            typeface = null;
            if (this.nsx != null) {
                typeface = this.nsx.D(str);
            }
            if (this.nsx != null && typeface == null && (E = this.nsx.E(str)) != null) {
                typeface = Typeface.createFromAsset(this.assetManager, E);
            }
            if (typeface == null) {
                typeface = Typeface.createFromAsset(this.assetManager, "fonts/" + str + this.hj);
            }
            this.hh.put(str, typeface);
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
