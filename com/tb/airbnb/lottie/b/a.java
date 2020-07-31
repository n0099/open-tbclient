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
/* loaded from: classes5.dex */
public class a {
    private final AssetManager assetManager;
    @Nullable
    private com.tb.airbnb.lottie.a nOY;
    private final h<String> nOX = new h<>();
    private final Map<h<String>, Typeface> Do = new HashMap();
    private final Map<String, Typeface> Dp = new HashMap();
    private String Dr = ".ttf";

    public a(Drawable.Callback callback, @Nullable com.tb.airbnb.lottie.a aVar) {
        this.nOY = aVar;
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.assetManager = null;
            return;
        }
        this.assetManager = ((View) callback).getContext().getAssets();
    }

    public void a(@Nullable com.tb.airbnb.lottie.a aVar) {
        this.nOY = aVar;
    }

    public Typeface n(String str, String str2) {
        this.nOX.set(str, str2);
        Typeface typeface = this.Do.get(this.nOX);
        if (typeface == null) {
            Typeface a = a(bd(str), str2);
            this.Do.put(this.nOX, a);
            return a;
        }
        return typeface;
    }

    private Typeface bd(String str) {
        String aV;
        Typeface typeface = this.Dp.get(str);
        if (typeface == null) {
            typeface = null;
            if (this.nOY != null) {
                typeface = this.nOY.aU(str);
            }
            if (this.nOY != null && typeface == null && (aV = this.nOY.aV(str)) != null) {
                typeface = Typeface.createFromAsset(this.assetManager, aV);
            }
            if (typeface == null) {
                typeface = Typeface.createFromAsset(this.assetManager, "fonts/" + str + this.Dr);
            }
            this.Dp.put(str, typeface);
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
