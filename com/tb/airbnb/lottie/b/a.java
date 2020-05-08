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
    private com.tb.airbnb.lottie.a mPj;
    private final h<String> mPi = new h<>();
    private final Map<h<String>, Typeface> CH = new HashMap();
    private final Map<String, Typeface> CI = new HashMap();
    private String CK = ".ttf";

    public a(Drawable.Callback callback, @Nullable com.tb.airbnb.lottie.a aVar) {
        this.mPj = aVar;
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.assetManager = null;
            return;
        }
        this.assetManager = ((View) callback).getContext().getAssets();
    }

    public void a(@Nullable com.tb.airbnb.lottie.a aVar) {
        this.mPj = aVar;
    }

    public Typeface n(String str, String str2) {
        this.mPi.set(str, str2);
        Typeface typeface = this.CH.get(this.mPi);
        if (typeface == null) {
            Typeface a = a(bc(str), str2);
            this.CH.put(this.mPi, a);
            return a;
        }
        return typeface;
    }

    private Typeface bc(String str) {
        String aU;
        Typeface typeface = this.CI.get(str);
        if (typeface == null) {
            typeface = null;
            if (this.mPj != null) {
                typeface = this.mPj.aT(str);
            }
            if (this.mPj != null && typeface == null && (aU = this.mPj.aU(str)) != null) {
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
