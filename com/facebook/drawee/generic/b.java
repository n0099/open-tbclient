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
    public static final p.b mNy = p.b.mNo;
    public static final p.b mNz = p.b.mNp;
    private Drawable mBackground;
    private int mNA;
    private boolean mNB;
    private float mNC;
    private Drawable mND;
    @Nullable
    private p.b mNE;
    private Drawable mNF;
    private p.b mNG;
    private Drawable mNH;
    private p.b mNI;
    private Drawable mNJ;
    private p.b mNK;
    private p.b mNL;
    private Matrix mNM;
    private PointF mNN;
    private ColorFilter mNO;
    private List<Drawable> mNP;
    private Drawable mNQ;
    private RoundingParams mNu;
    private Resources mResources;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.mNA = 150;
        this.mNB = true;
        this.mNC = 0.0f;
        this.mND = null;
        this.mNE = mNy;
        this.mNF = null;
        this.mNG = mNy;
        this.mNH = null;
        this.mNI = mNy;
        this.mNJ = null;
        this.mNK = mNy;
        this.mNL = mNz;
        this.mNM = null;
        this.mNN = null;
        this.mNO = null;
        this.mBackground = null;
        this.mNP = null;
        this.mNQ = null;
        this.mNu = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b Ip(int i) {
        this.mNA = i;
        return this;
    }

    public int dBl() {
        return this.mNA;
    }

    public boolean dBm() {
        return this.mNB;
    }

    public b aI(float f) {
        this.mNC = f;
        return this;
    }

    public float dBn() {
        return this.mNC;
    }

    public b n(@Nullable Drawable drawable) {
        this.mND = drawable;
        return this;
    }

    public b Iq(int i) {
        this.mND = this.mResources.getDrawable(i);
        return this;
    }

    @Nullable
    public Drawable dBo() {
        return this.mND;
    }

    public b c(@Nullable p.b bVar) {
        this.mNE = bVar;
        return this;
    }

    @Nullable
    public p.b dBp() {
        return this.mNE;
    }

    public b o(@Nullable Drawable drawable) {
        this.mNF = drawable;
        return this;
    }

    @Nullable
    public Drawable dBq() {
        return this.mNF;
    }

    public b d(@Nullable p.b bVar) {
        this.mNG = bVar;
        return this;
    }

    @Nullable
    public p.b dBr() {
        return this.mNG;
    }

    public b p(@Nullable Drawable drawable) {
        this.mNH = drawable;
        return this;
    }

    @Nullable
    public Drawable dBs() {
        return this.mNH;
    }

    public b e(@Nullable p.b bVar) {
        this.mNI = bVar;
        return this;
    }

    @Nullable
    public p.b dBt() {
        return this.mNI;
    }

    public b q(@Nullable Drawable drawable) {
        this.mNJ = drawable;
        return this;
    }

    @Nullable
    public Drawable dBu() {
        return this.mNJ;
    }

    public b f(@Nullable p.b bVar) {
        this.mNK = bVar;
        return this;
    }

    @Nullable
    public p.b dBv() {
        return this.mNK;
    }

    public b g(@Nullable p.b bVar) {
        this.mNL = bVar;
        this.mNM = null;
        return this;
    }

    @Nullable
    public p.b dBw() {
        return this.mNL;
    }

    @Nullable
    public PointF dBx() {
        return this.mNN;
    }

    @Nullable
    public ColorFilter dBy() {
        return this.mNO;
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
            this.mNP = null;
        } else {
            this.mNP = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> dBz() {
        return this.mNP;
    }

    public b t(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.mNQ = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.mNQ = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable dBA() {
        return this.mNQ;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.mNu = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams dBk() {
        return this.mNu;
    }

    private void validate() {
        if (this.mNP != null) {
            for (Drawable drawable : this.mNP) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a dBB() {
        validate();
        return new a(this);
    }
}
