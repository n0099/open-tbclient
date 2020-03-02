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
    public static final p.b lNc = p.b.lMS;
    public static final p.b lNd = p.b.lMT;
    private RoundingParams lMY;
    private int lNe;
    private boolean lNf;
    private float lNg;
    private Drawable lNh;
    @Nullable
    private p.b lNi;
    private Drawable lNj;
    private p.b lNk;
    private Drawable lNl;
    private p.b lNm;
    private Drawable lNn;
    private p.b lNo;
    private p.b lNp;
    private Matrix lNq;
    private PointF lNr;
    private ColorFilter lNs;
    private List<Drawable> lNt;
    private Drawable lNu;
    private Drawable mBackground;
    private Resources mResources;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.lNe = 150;
        this.lNf = true;
        this.lNg = 0.0f;
        this.lNh = null;
        this.lNi = lNc;
        this.lNj = null;
        this.lNk = lNc;
        this.lNl = null;
        this.lNm = lNc;
        this.lNn = null;
        this.lNo = lNc;
        this.lNp = lNd;
        this.lNq = null;
        this.lNr = null;
        this.lNs = null;
        this.mBackground = null;
        this.lNt = null;
        this.lNu = null;
        this.lMY = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b HN(int i) {
        this.lNe = i;
        return this;
    }

    public int dmI() {
        return this.lNe;
    }

    public boolean dmJ() {
        return this.lNf;
    }

    public b bn(float f) {
        this.lNg = f;
        return this;
    }

    public float dmK() {
        return this.lNg;
    }

    public b r(@Nullable Drawable drawable) {
        this.lNh = drawable;
        return this;
    }

    public b HO(int i) {
        this.lNh = this.mResources.getDrawable(i);
        return this;
    }

    @Nullable
    public Drawable dmL() {
        return this.lNh;
    }

    public b c(@Nullable p.b bVar) {
        this.lNi = bVar;
        return this;
    }

    @Nullable
    public p.b dmM() {
        return this.lNi;
    }

    public b s(@Nullable Drawable drawable) {
        this.lNj = drawable;
        return this;
    }

    @Nullable
    public Drawable dmN() {
        return this.lNj;
    }

    public b d(@Nullable p.b bVar) {
        this.lNk = bVar;
        return this;
    }

    @Nullable
    public p.b dmO() {
        return this.lNk;
    }

    public b t(@Nullable Drawable drawable) {
        this.lNl = drawable;
        return this;
    }

    @Nullable
    public Drawable dmP() {
        return this.lNl;
    }

    public b e(@Nullable p.b bVar) {
        this.lNm = bVar;
        return this;
    }

    @Nullable
    public p.b dmQ() {
        return this.lNm;
    }

    public b u(@Nullable Drawable drawable) {
        this.lNn = drawable;
        return this;
    }

    @Nullable
    public Drawable dmR() {
        return this.lNn;
    }

    public b f(@Nullable p.b bVar) {
        this.lNo = bVar;
        return this;
    }

    @Nullable
    public p.b dmS() {
        return this.lNo;
    }

    public b g(@Nullable p.b bVar) {
        this.lNp = bVar;
        this.lNq = null;
        return this;
    }

    @Nullable
    public p.b dmT() {
        return this.lNp;
    }

    @Nullable
    public PointF dmU() {
        return this.lNr;
    }

    @Nullable
    public ColorFilter dmV() {
        return this.lNs;
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
            this.lNt = null;
        } else {
            this.lNt = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> dmW() {
        return this.lNt;
    }

    public b x(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.lNu = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.lNu = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable dmX() {
        return this.lNu;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.lMY = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams dmH() {
        return this.lMY;
    }

    private void validate() {
        if (this.lNt != null) {
            for (Drawable drawable : this.lNt) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a dmY() {
        validate();
        return new a(this);
    }
}
