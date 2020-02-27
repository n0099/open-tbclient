package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.facebook.common.internal.g;
import com.facebook.drawee.drawable.p;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class b {
    public static final p.b lNa = p.b.lMQ;
    public static final p.b lNb = p.b.lMR;
    private RoundingParams lMW;
    private int lNc;
    private boolean lNd;
    private float lNe;
    private Drawable lNf;
    @Nullable
    private p.b lNg;
    private Drawable lNh;
    private p.b lNi;
    private Drawable lNj;
    private p.b lNk;
    private Drawable lNl;
    private p.b lNm;
    private p.b lNn;
    private Matrix lNo;
    private PointF lNp;
    private ColorFilter lNq;
    private List<Drawable> lNr;
    private Drawable lNs;
    private Drawable mBackground;
    private Resources mResources;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.lNc = 150;
        this.lNd = true;
        this.lNe = 0.0f;
        this.lNf = null;
        this.lNg = lNa;
        this.lNh = null;
        this.lNi = lNa;
        this.lNj = null;
        this.lNk = lNa;
        this.lNl = null;
        this.lNm = lNa;
        this.lNn = lNb;
        this.lNo = null;
        this.lNp = null;
        this.lNq = null;
        this.mBackground = null;
        this.lNr = null;
        this.lNs = null;
        this.lMW = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b HN(int i) {
        this.lNc = i;
        return this;
    }

    public int dmG() {
        return this.lNc;
    }

    public boolean dmH() {
        return this.lNd;
    }

    public b bn(float f) {
        this.lNe = f;
        return this;
    }

    public float dmI() {
        return this.lNe;
    }

    public b r(@Nullable Drawable drawable) {
        this.lNf = drawable;
        return this;
    }

    public b HO(int i) {
        this.lNf = this.mResources.getDrawable(i);
        return this;
    }

    @Nullable
    public Drawable dmJ() {
        return this.lNf;
    }

    public b c(@Nullable p.b bVar) {
        this.lNg = bVar;
        return this;
    }

    @Nullable
    public p.b dmK() {
        return this.lNg;
    }

    public b s(@Nullable Drawable drawable) {
        this.lNh = drawable;
        return this;
    }

    @Nullable
    public Drawable dmL() {
        return this.lNh;
    }

    public b d(@Nullable p.b bVar) {
        this.lNi = bVar;
        return this;
    }

    @Nullable
    public p.b dmM() {
        return this.lNi;
    }

    public b t(@Nullable Drawable drawable) {
        this.lNj = drawable;
        return this;
    }

    @Nullable
    public Drawable dmN() {
        return this.lNj;
    }

    public b e(@Nullable p.b bVar) {
        this.lNk = bVar;
        return this;
    }

    @Nullable
    public p.b dmO() {
        return this.lNk;
    }

    public b u(@Nullable Drawable drawable) {
        this.lNl = drawable;
        return this;
    }

    @Nullable
    public Drawable dmP() {
        return this.lNl;
    }

    public b f(@Nullable p.b bVar) {
        this.lNm = bVar;
        return this;
    }

    @Nullable
    public p.b dmQ() {
        return this.lNm;
    }

    public b g(@Nullable p.b bVar) {
        this.lNn = bVar;
        this.lNo = null;
        return this;
    }

    @Nullable
    public p.b dmR() {
        return this.lNn;
    }

    @Nullable
    public PointF dmS() {
        return this.lNp;
    }

    @Nullable
    public ColorFilter dmT() {
        return this.lNq;
    }

    public b v(@Nullable Drawable drawable) {
        this.mBackground = drawable;
        return this;
    }

    @Nullable
    public Drawable getBackground() {
        return this.mBackground;
    }

    public b w(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.lNr = null;
        } else {
            this.lNr = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> dmU() {
        return this.lNr;
    }

    public b x(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.lNs = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.lNs = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable dmV() {
        return this.lNs;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.lMW = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams dmF() {
        return this.lMW;
    }

    private void validate() {
        if (this.lNr != null) {
            for (Drawable drawable : this.lNr) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a dmW() {
        validate();
        return new a(this);
    }
}
