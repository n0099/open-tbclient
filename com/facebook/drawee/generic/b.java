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
    public static final p.b lNn = p.b.lNd;
    public static final p.b lNo = p.b.lNe;
    private p.b lNA;
    private Matrix lNB;
    private PointF lNC;
    private ColorFilter lND;
    private List<Drawable> lNE;
    private Drawable lNF;
    private RoundingParams lNj;
    private int lNp;
    private boolean lNq;
    private float lNr;
    private Drawable lNs;
    @Nullable
    private p.b lNt;
    private Drawable lNu;
    private p.b lNv;
    private Drawable lNw;
    private p.b lNx;
    private Drawable lNy;
    private p.b lNz;
    private Drawable mBackground;
    private Resources mResources;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.lNp = 150;
        this.lNq = true;
        this.lNr = 0.0f;
        this.lNs = null;
        this.lNt = lNn;
        this.lNu = null;
        this.lNv = lNn;
        this.lNw = null;
        this.lNx = lNn;
        this.lNy = null;
        this.lNz = lNn;
        this.lNA = lNo;
        this.lNB = null;
        this.lNC = null;
        this.lND = null;
        this.mBackground = null;
        this.lNE = null;
        this.lNF = null;
        this.lNj = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b HN(int i) {
        this.lNp = i;
        return this;
    }

    public int dmJ() {
        return this.lNp;
    }

    public boolean dmK() {
        return this.lNq;
    }

    public b bn(float f) {
        this.lNr = f;
        return this;
    }

    public float dmL() {
        return this.lNr;
    }

    public b r(@Nullable Drawable drawable) {
        this.lNs = drawable;
        return this;
    }

    public b HO(int i) {
        this.lNs = this.mResources.getDrawable(i);
        return this;
    }

    @Nullable
    public Drawable dmM() {
        return this.lNs;
    }

    public b c(@Nullable p.b bVar) {
        this.lNt = bVar;
        return this;
    }

    @Nullable
    public p.b dmN() {
        return this.lNt;
    }

    public b s(@Nullable Drawable drawable) {
        this.lNu = drawable;
        return this;
    }

    @Nullable
    public Drawable dmO() {
        return this.lNu;
    }

    public b d(@Nullable p.b bVar) {
        this.lNv = bVar;
        return this;
    }

    @Nullable
    public p.b dmP() {
        return this.lNv;
    }

    public b t(@Nullable Drawable drawable) {
        this.lNw = drawable;
        return this;
    }

    @Nullable
    public Drawable dmQ() {
        return this.lNw;
    }

    public b e(@Nullable p.b bVar) {
        this.lNx = bVar;
        return this;
    }

    @Nullable
    public p.b dmR() {
        return this.lNx;
    }

    public b u(@Nullable Drawable drawable) {
        this.lNy = drawable;
        return this;
    }

    @Nullable
    public Drawable dmS() {
        return this.lNy;
    }

    public b f(@Nullable p.b bVar) {
        this.lNz = bVar;
        return this;
    }

    @Nullable
    public p.b dmT() {
        return this.lNz;
    }

    public b g(@Nullable p.b bVar) {
        this.lNA = bVar;
        this.lNB = null;
        return this;
    }

    @Nullable
    public p.b dmU() {
        return this.lNA;
    }

    @Nullable
    public PointF dmV() {
        return this.lNC;
    }

    @Nullable
    public ColorFilter dmW() {
        return this.lND;
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
            this.lNE = null;
        } else {
            this.lNE = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> dmX() {
        return this.lNE;
    }

    public b x(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.lNF = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.lNF = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable dmY() {
        return this.lNF;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.lNj = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams dmI() {
        return this.lNj;
    }

    private void validate() {
        if (this.lNE != null) {
            for (Drawable drawable : this.lNE) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a dmZ() {
        validate();
        return new a(this);
    }
}
