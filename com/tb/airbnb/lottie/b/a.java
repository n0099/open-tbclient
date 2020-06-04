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
    private com.tb.airbnb.lottie.a nky;
    private final h<String> nkx = new h<>();
    private final Map<h<String>, Typeface> CH = new HashMap();
    private final Map<String, Typeface> CI = new HashMap();
    private String CK = ".ttf";

    public a(Drawable.Callback callback, @Nullable com.tb.airbnb.lottie.a aVar) {
        this.nky = aVar;
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.assetManager = null;
            return;
        }
        this.assetManager = ((View) callback).getContext().getAssets();
    }

    public void a(@Nullable com.tb.airbnb.lottie.a aVar) {
        this.nky = aVar;
    }

    public Typeface n(String str, String str2) {
        this.nkx.set(str, str2);
        Typeface typeface = this.CH.get(this.nkx);
        if (typeface == null) {
            Typeface a = a(bc(str), str2);
            this.CH.put(this.nkx, a);
            return a;
        }
        return typeface;
    }

    private Typeface bc(String str) {
        String aU;
        Typeface typeface = this.CI.get(str);
        if (typeface == null) {
            typeface = null;
            if (this.nky != null) {
                typeface = this.nky.aT(str);
            }
            if (this.nky != null && typeface == null && (aU = this.nky.aU(str)) != null) {
                typeface = Typeface.createFromAsset(this.assetManager, aU);
            }
            if (typeface == null) {
                typeface = Typeface.createFromAsset(this.assetManager, "fonts/" + str + this.CK);
            }
            this.CI.put(str, typeface);
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
