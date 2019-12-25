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
/* loaded from: classes2.dex */
public class a {
    private final AssetManager assetManager;
    @Nullable
    private com.tb.airbnb.lottie.b mNK;
    private final i<String> mNJ = new i<>();
    private final Map<i<String>, Typeface> hc = new HashMap();
    private final Map<String, Typeface> hd = new HashMap();
    private String hg = ".ttf";

    public a(Drawable.Callback callback, @Nullable com.tb.airbnb.lottie.b bVar) {
        this.mNK = bVar;
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.assetManager = null;
            return;
        }
        this.assetManager = ((View) callback).getContext().getAssets();
    }

    public void a(@Nullable com.tb.airbnb.lottie.b bVar) {
        this.mNK = bVar;
    }

    public Typeface g(String str, String str2) {
        this.mNJ.set(str, str2);
        Typeface typeface = this.hc.get(this.mNJ);
        if (typeface == null) {
            Typeface a = a(M(str), str2);
            this.hc.put(this.mNJ, a);
            return a;
        }
        return typeface;
    }

    private Typeface M(String str) {
        String E;
        Typeface typeface = this.hd.get(str);
        if (typeface == null) {
            typeface = null;
            if (this.mNK != null) {
                typeface = this.mNK.D(str);
            }
            if (this.mNK != null && typeface == null && (E = this.mNK.E(str)) != null) {
                typeface = Typeface.createFromAsset(this.assetManager, E);
            }
            if (typeface == null) {
                typeface = Typeface.createFromAsset(this.assetManager, "fonts/" + str + this.hg);
            }
            this.hd.put(str, typeface);
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
