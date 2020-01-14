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
/* loaded from: classes12.dex */
public class b {
    public static final p.b lMt = p.b.lMj;
    public static final p.b lMu = p.b.lMk;
    private Drawable lMA;
    private p.b lMB;
    private Drawable lMC;
    private p.b lMD;
    private Drawable lME;
    private p.b lMF;
    private p.b lMG;
    private Matrix lMH;
    private PointF lMI;
    private ColorFilter lMJ;
    private List<Drawable> lMK;
    private Drawable lML;
    private RoundingParams lMp;
    private int lMv;
    private boolean lMw;
    private float lMx;
    private Drawable lMy;
    @Nullable
    private p.b lMz;
    private Drawable mBackground;
    private Resources mResources;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.lMv = 150;
        this.lMw = true;
        this.lMx = 0.0f;
        this.lMy = null;
        this.lMz = lMt;
        this.lMA = null;
        this.lMB = lMt;
        this.lMC = null;
        this.lMD = lMt;
        this.lME = null;
        this.lMF = lMt;
        this.lMG = lMu;
        this.lMH = null;
        this.lMI = null;
        this.lMJ = null;
        this.mBackground = null;
        this.lMK = null;
        this.lML = null;
        this.lMp = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b HI(int i) {
        this.lMv = i;
        return this;
    }

    public int dlu() {
        return this.lMv;
    }

    public boolean dlv() {
        return this.lMw;
    }

    public b bo(float f) {
        this.lMx = f;
        return this;
    }

    public float dlw() {
        return this.lMx;
    }

    public b r(@Nullable Drawable drawable) {
        this.lMy = drawable;
        return this;
    }

    public b HJ(int i) {
        this.lMy = this.mResources.getDrawable(i);
        return this;
    }

    @Nullable
    public Drawable dlx() {
        return this.lMy;
    }

    public b c(@Nullable p.b bVar) {
        this.lMz = bVar;
        return this;
    }

    @Nullable
    public p.b dly() {
        return this.lMz;
    }

    public b s(@Nullable Drawable drawable) {
        this.lMA = drawable;
        return this;
    }

    @Nullable
    public Drawable dlz() {
        return this.lMA;
    }

    public b d(@Nullable p.b bVar) {
        this.lMB = bVar;
        return this;
    }

    @Nullable
    public p.b dlA() {
        return this.lMB;
    }

    public b t(@Nullable Drawable drawable) {
        this.lMC = drawable;
        return this;
    }

    @Nullable
    public Drawable dlB() {
        return this.lMC;
    }

    public b e(@Nullable p.b bVar) {
        this.lMD = bVar;
        return this;
    }

    @Nullable
    public p.b dlC() {
        return this.lMD;
    }

    public b u(@Nullable Drawable drawable) {
        this.lME = drawable;
        return this;
    }

    @Nullable
    public Drawable dlD() {
        return this.lME;
    }

    public b f(@Nullable p.b bVar) {
        this.lMF = bVar;
        return this;
    }

    @Nullable
    public p.b dlE() {
        return this.lMF;
    }

    public b g(@Nullable p.b bVar) {
        this.lMG = bVar;
        this.lMH = null;
        return this;
    }

    @Nullable
    public p.b dlF() {
        return this.lMG;
    }

    @Nullable
    public PointF dlG() {
        return this.lMI;
    }

    @Nullable
    public ColorFilter dlH() {
        return this.lMJ;
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
            this.lMK = null;
        } else {
            this.lMK = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> dlI() {
        return this.lMK;
    }

    public b x(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.lML = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.lML = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable dlJ() {
        return this.lML;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.lMp = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams dlt() {
        return this.lMp;
    }

    private void validate() {
        if (this.lMK != null) {
            for (Drawable drawable : this.lMK) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a dlK() {
        validate();
        return new a(this);
    }
}
