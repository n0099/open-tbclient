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
    public static final p.b lOT = p.b.lOJ;
    public static final p.b lOU = p.b.lOK;
    private RoundingParams lOP;
    private int lOV;
    private boolean lOW;
    private float lOX;
    private Drawable lOY;
    @Nullable
    private p.b lOZ;
    private Drawable lPa;
    private p.b lPb;
    private Drawable lPc;
    private p.b lPd;
    private Drawable lPe;
    private p.b lPf;
    private p.b lPg;
    private Matrix lPh;
    private PointF lPi;
    private ColorFilter lPj;
    private List<Drawable> lPk;
    private Drawable lPl;
    private Drawable mBackground;
    private Resources mResources;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.lOV = 150;
        this.lOW = true;
        this.lOX = 0.0f;
        this.lOY = null;
        this.lOZ = lOT;
        this.lPa = null;
        this.lPb = lOT;
        this.lPc = null;
        this.lPd = lOT;
        this.lPe = null;
        this.lPf = lOT;
        this.lPg = lOU;
        this.lPh = null;
        this.lPi = null;
        this.lPj = null;
        this.mBackground = null;
        this.lPk = null;
        this.lPl = null;
        this.lOP = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b HT(int i) {
        this.lOV = i;
        return this;
    }

    public int dng() {
        return this.lOV;
    }

    public boolean dnh() {
        return this.lOW;
    }

    public b bn(float f) {
        this.lOX = f;
        return this;
    }

    public float dni() {
        return this.lOX;
    }

    public b r(@Nullable Drawable drawable) {
        this.lOY = drawable;
        return this;
    }

    public b HU(int i) {
        this.lOY = this.mResources.getDrawable(i);
        return this;
    }

    @Nullable
    public Drawable dnj() {
        return this.lOY;
    }

    public b c(@Nullable p.b bVar) {
        this.lOZ = bVar;
        return this;
    }

    @Nullable
    public p.b dnk() {
        return this.lOZ;
    }

    public b s(@Nullable Drawable drawable) {
        this.lPa = drawable;
        return this;
    }

    @Nullable
    public Drawable dnl() {
        return this.lPa;
    }

    public b d(@Nullable p.b bVar) {
        this.lPb = bVar;
        return this;
    }

    @Nullable
    public p.b dnm() {
        return this.lPb;
    }

    public b t(@Nullable Drawable drawable) {
        this.lPc = drawable;
        return this;
    }

    @Nullable
    public Drawable dnn() {
        return this.lPc;
    }

    public b e(@Nullable p.b bVar) {
        this.lPd = bVar;
        return this;
    }

    @Nullable
    public p.b dno() {
        return this.lPd;
    }

    public b u(@Nullable Drawable drawable) {
        this.lPe = drawable;
        return this;
    }

    @Nullable
    public Drawable dnp() {
        return this.lPe;
    }

    public b f(@Nullable p.b bVar) {
        this.lPf = bVar;
        return this;
    }

    @Nullable
    public p.b dnq() {
        return this.lPf;
    }

    public b g(@Nullable p.b bVar) {
        this.lPg = bVar;
        this.lPh = null;
        return this;
    }

    @Nullable
    public p.b dnr() {
        return this.lPg;
    }

    @Nullable
    public PointF dnt() {
        return this.lPi;
    }

    @Nullable
    public ColorFilter dnu() {
        return this.lPj;
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
            this.lPk = null;
        } else {
            this.lPk = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> dnv() {
        return this.lPk;
    }

    public b x(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.lPl = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.lPl = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable dnw() {
        return this.lPl;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.lOP = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams dnf() {
        return this.lOP;
    }

    private void validate() {
        if (this.lPk != null) {
            for (Drawable drawable : this.lPk) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a dnx() {
        validate();
        return new a(this);
    }
}
