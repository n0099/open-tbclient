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
    public static final p.b lMo = p.b.lMe;
    public static final p.b lMp = p.b.lMf;
    private p.b lMA;
    private p.b lMB;
    private Matrix lMC;
    private PointF lMD;
    private ColorFilter lME;
    private List<Drawable> lMF;
    private Drawable lMG;
    private RoundingParams lMk;
    private int lMq;
    private boolean lMr;
    private float lMs;
    private Drawable lMt;
    @Nullable
    private p.b lMu;
    private Drawable lMv;
    private p.b lMw;
    private Drawable lMx;
    private p.b lMy;
    private Drawable lMz;
    private Drawable mBackground;
    private Resources mResources;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.lMq = 150;
        this.lMr = true;
        this.lMs = 0.0f;
        this.lMt = null;
        this.lMu = lMo;
        this.lMv = null;
        this.lMw = lMo;
        this.lMx = null;
        this.lMy = lMo;
        this.lMz = null;
        this.lMA = lMo;
        this.lMB = lMp;
        this.lMC = null;
        this.lMD = null;
        this.lME = null;
        this.mBackground = null;
        this.lMF = null;
        this.lMG = null;
        this.lMk = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b HI(int i) {
        this.lMq = i;
        return this;
    }

    public int dls() {
        return this.lMq;
    }

    public boolean dlt() {
        return this.lMr;
    }

    public b bo(float f) {
        this.lMs = f;
        return this;
    }

    public float dlu() {
        return this.lMs;
    }

    public b r(@Nullable Drawable drawable) {
        this.lMt = drawable;
        return this;
    }

    public b HJ(int i) {
        this.lMt = this.mResources.getDrawable(i);
        return this;
    }

    @Nullable
    public Drawable dlv() {
        return this.lMt;
    }

    public b c(@Nullable p.b bVar) {
        this.lMu = bVar;
        return this;
    }

    @Nullable
    public p.b dlw() {
        return this.lMu;
    }

    public b s(@Nullable Drawable drawable) {
        this.lMv = drawable;
        return this;
    }

    @Nullable
    public Drawable dlx() {
        return this.lMv;
    }

    public b d(@Nullable p.b bVar) {
        this.lMw = bVar;
        return this;
    }

    @Nullable
    public p.b dly() {
        return this.lMw;
    }

    public b t(@Nullable Drawable drawable) {
        this.lMx = drawable;
        return this;
    }

    @Nullable
    public Drawable dlz() {
        return this.lMx;
    }

    public b e(@Nullable p.b bVar) {
        this.lMy = bVar;
        return this;
    }

    @Nullable
    public p.b dlA() {
        return this.lMy;
    }

    public b u(@Nullable Drawable drawable) {
        this.lMz = drawable;
        return this;
    }

    @Nullable
    public Drawable dlB() {
        return this.lMz;
    }

    public b f(@Nullable p.b bVar) {
        this.lMA = bVar;
        return this;
    }

    @Nullable
    public p.b dlC() {
        return this.lMA;
    }

    public b g(@Nullable p.b bVar) {
        this.lMB = bVar;
        this.lMC = null;
        return this;
    }

    @Nullable
    public p.b dlD() {
        return this.lMB;
    }

    @Nullable
    public PointF dlE() {
        return this.lMD;
    }

    @Nullable
    public ColorFilter dlF() {
        return this.lME;
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
            this.lMF = null;
        } else {
            this.lMF = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> dlG() {
        return this.lMF;
    }

    public b x(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.lMG = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.lMG = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable dlH() {
        return this.lMG;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.lMk = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams dlr() {
        return this.lMk;
    }

    private void validate() {
        if (this.lMF != null) {
            for (Drawable drawable : this.lMF) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a dlI() {
        validate();
        return new a(this);
    }
}
