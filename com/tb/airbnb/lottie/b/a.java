package com.tb.airbnb.lottie.b;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import com.tb.airbnb.lottie.model.i;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {
    private final AssetManager fu;
    @Nullable
    private com.tb.airbnb.lottie.b ksV;
    private final i<String> ksU = new i<>();
    private final Map<i<String>, Typeface> fs = new HashMap();
    private final Map<String, Typeface> ft = new HashMap();
    private String fw = ".ttf";

    public a(Drawable.Callback callback, @Nullable com.tb.airbnb.lottie.b bVar) {
        this.ksV = bVar;
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.fu = null;
            return;
        }
        this.fu = ((View) callback).getContext().getAssets();
    }

    public void a(@Nullable com.tb.airbnb.lottie.b bVar) {
        this.ksV = bVar;
    }

    public Typeface g(String str, String str2) {
        this.ksU.set(str, str2);
        Typeface typeface = this.fs.get(this.ksU);
        if (typeface == null) {
            Typeface a = a(K(str), str2);
            this.fs.put(this.ksU, a);
            return a;
        }
        return typeface;
    }

    private Typeface K(String str) {
        String C;
        Typeface typeface = this.ft.get(str);
        if (typeface == null) {
            typeface = null;
            if (this.ksV != null) {
                typeface = this.ksV.B(str);
            }
            if (this.ksV != null && typeface == null && (C = this.ksV.C(str)) != null) {
                typeface = Typeface.createFromAsset(this.fu, C);
            }
            if (typeface == null) {
                typeface = Typeface.createFromAsset(this.fu, "fonts/" + str + this.fw);
            }
            this.ft.put(str, typeface);
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
