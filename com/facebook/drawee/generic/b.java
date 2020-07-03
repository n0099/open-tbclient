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
    public static final p.b mNv = p.b.mNl;
    public static final p.b mNw = p.b.mNm;
    private Drawable mBackground;
    private Drawable mNA;
    @Nullable
    private p.b mNB;
    private Drawable mNC;
    private p.b mND;
    private Drawable mNE;
    private p.b mNF;
    private Drawable mNG;
    private p.b mNH;
    private p.b mNI;
    private Matrix mNJ;
    private PointF mNK;
    private ColorFilter mNL;
    private List<Drawable> mNM;
    private Drawable mNN;
    private RoundingParams mNr;
    private int mNx;
    private boolean mNy;
    private float mNz;
    private Resources mResources;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.mNx = 150;
        this.mNy = true;
        this.mNz = 0.0f;
        this.mNA = null;
        this.mNB = mNv;
        this.mNC = null;
        this.mND = mNv;
        this.mNE = null;
        this.mNF = mNv;
        this.mNG = null;
        this.mNH = mNv;
        this.mNI = mNw;
        this.mNJ = null;
        this.mNK = null;
        this.mNL = null;
        this.mBackground = null;
        this.mNM = null;
        this.mNN = null;
        this.mNr = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b Ip(int i) {
        this.mNx = i;
        return this;
    }

    public int dBh() {
        return this.mNx;
    }

    public boolean dBi() {
        return this.mNy;
    }

    public b aI(float f) {
        this.mNz = f;
        return this;
    }

    public float dBj() {
        return this.mNz;
    }

    public b n(@Nullable Drawable drawable) {
        this.mNA = drawable;
        return this;
    }

    public b Iq(int i) {
        this.mNA = this.mResources.getDrawable(i);
        return this;
    }

    @Nullable
    public Drawable dBk() {
        return this.mNA;
    }

    public b c(@Nullable p.b bVar) {
        this.mNB = bVar;
        return this;
    }

    @Nullable
    public p.b dBl() {
        return this.mNB;
    }

    public b o(@Nullable Drawable drawable) {
        this.mNC = drawable;
        return this;
    }

    @Nullable
    public Drawable dBm() {
        return this.mNC;
    }

    public b d(@Nullable p.b bVar) {
        this.mND = bVar;
        return this;
    }

    @Nullable
    public p.b dBn() {
        return this.mND;
    }

    public b p(@Nullable Drawable drawable) {
        this.mNE = drawable;
        return this;
    }

    @Nullable
    public Drawable dBo() {
        return this.mNE;
    }

    public b e(@Nullable p.b bVar) {
        this.mNF = bVar;
        return this;
    }

    @Nullable
    public p.b dBp() {
        return this.mNF;
    }

    public b q(@Nullable Drawable drawable) {
        this.mNG = drawable;
        return this;
    }

    @Nullable
    public Drawable dBq() {
        return this.mNG;
    }

    public b f(@Nullable p.b bVar) {
        this.mNH = bVar;
        return this;
    }

    @Nullable
    public p.b dBr() {
        return this.mNH;
    }

    public b g(@Nullable p.b bVar) {
        this.mNI = bVar;
        this.mNJ = null;
        return this;
    }

    @Nullable
    public p.b dBs() {
        return this.mNI;
    }

    @Nullable
    public PointF dBt() {
        return this.mNK;
    }

    @Nullable
    public ColorFilter dBu() {
        return this.mNL;
    }

    public b r(@Nullable Drawable drawable) {
        this.mBackground = drawable;
        return this;
    }

    @Nullable
    public Drawable getBackground() {
        return this.mBackground;
    }

    public b s(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.mNM = null;
        } else {
            this.mNM = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> dBv() {
        return this.mNM;
    }

    public b t(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.mNN = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.mNN = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable dBw() {
        return this.mNN;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.mNr = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams dBg() {
        return this.mNr;
    }

    private void validate() {
        if (this.mNM != null) {
            for (Drawable drawable : this.mNM) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a dBx() {
        validate();
        return new a(this);
    }
}
