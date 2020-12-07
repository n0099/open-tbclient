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
/* loaded from: classes20.dex */
public class a {
    private final AssetManager assetManager;
    @Nullable
    private com.tb.airbnb.lottie.b pBK;
    private final h<String> pBJ = new h<>();
    private final Map<h<String>, Typeface> Fe = new HashMap();
    private final Map<String, Typeface> Ff = new HashMap();
    private String Fh = ".ttf";

    public a(Drawable.Callback callback, @Nullable com.tb.airbnb.lottie.b bVar) {
        this.pBK = bVar;
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.assetManager = null;
            return;
        }
        this.assetManager = ((View) callback).getContext().getAssets();
    }

    public void a(@Nullable com.tb.airbnb.lottie.b bVar) {
        this.pBK = bVar;
    }

    public Typeface q(String str, String str2) {
        this.pBJ.set(str, str2);
        Typeface typeface = this.Fe.get(this.pBJ);
        if (typeface == null) {
            Typeface a2 = a(bl(str), str2);
            this.Fe.put(this.pBJ, a2);
            return a2;
        }
        return typeface;
    }

    private Typeface bl(String str) {
        String bd;
        Typeface typeface = this.Ff.get(str);
        if (typeface == null) {
            typeface = null;
            if (this.pBK != null) {
                typeface = this.pBK.bc(str);
            }
            if (this.pBK != null && typeface == null && (bd = this.pBK.bd(str)) != null) {
                typeface = Typeface.createFromAsset(this.assetManager, bd);
            }
            if (typeface == null) {
                typeface = Typeface.createFromAsset(this.assetManager, "fonts/" + str + this.Fh);
            }
            this.Ff.put(str, typeface);
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
