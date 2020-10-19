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
/* loaded from: classes15.dex */
public class b {
    public static final p.b nPi = p.b.nOY;
    public static final p.b nPj = p.b.nOZ;
    private Drawable mBackground;
    private Resources mResources;
    private Drawable nPA;
    private RoundingParams nPe;
    private int nPk;
    private boolean nPl;
    private float nPm;
    private Drawable nPn;
    @Nullable
    private p.b nPo;
    private Drawable nPp;
    private p.b nPq;
    private Drawable nPr;
    private p.b nPs;
    private Drawable nPt;
    private p.b nPu;
    private p.b nPv;
    private Matrix nPw;
    private PointF nPx;
    private ColorFilter nPy;
    private List<Drawable> nPz;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.nPk = 150;
        this.nPl = true;
        this.nPm = 0.0f;
        this.nPn = null;
        this.nPo = nPi;
        this.nPp = null;
        this.nPq = nPi;
        this.nPr = null;
        this.nPs = nPi;
        this.nPt = null;
        this.nPu = nPi;
        this.nPv = nPj;
        this.nPw = null;
        this.nPx = null;
        this.nPy = null;
        this.mBackground = null;
        this.nPz = null;
        this.nPA = null;
        this.nPe = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b Mz(int i) {
        this.nPk = i;
        return this;
    }

    public int dYq() {
        return this.nPk;
    }

    public boolean dYr() {
        return this.nPl;
    }

    public b aT(float f) {
        this.nPm = f;
        return this;
    }

    public float dYs() {
        return this.nPm;
    }

    public b n(@Nullable Drawable drawable) {
        this.nPn = drawable;
        return this;
    }

    public b MA(int i) {
        this.nPn = this.mResources.getDrawable(i);
        return this;
    }

    @Nullable
    public Drawable dYt() {
        return this.nPn;
    }

    public b c(@Nullable p.b bVar) {
        this.nPo = bVar;
        return this;
    }

    @Nullable
    public p.b dYu() {
        return this.nPo;
    }

    public b o(@Nullable Drawable drawable) {
        this.nPp = drawable;
        return this;
    }

    @Nullable
    public Drawable dYv() {
        return this.nPp;
    }

    public b d(@Nullable p.b bVar) {
        this.nPq = bVar;
        return this;
    }

    @Nullable
    public p.b dYw() {
        return this.nPq;
    }

    public b p(@Nullable Drawable drawable) {
        this.nPr = drawable;
        return this;
    }

    @Nullable
    public Drawable dYx() {
        return this.nPr;
    }

    public b e(@Nullable p.b bVar) {
        this.nPs = bVar;
        return this;
    }

    @Nullable
    public p.b dYy() {
        return this.nPs;
    }

    public b q(@Nullable Drawable drawable) {
        this.nPt = drawable;
        return this;
    }

    @Nullable
    public Drawable dYz() {
        return this.nPt;
    }

    public b f(@Nullable p.b bVar) {
        this.nPu = bVar;
        return this;
    }

    @Nullable
    public p.b dYA() {
        return this.nPu;
    }

    public b g(@Nullable p.b bVar) {
        this.nPv = bVar;
        this.nPw = null;
        return this;
    }

    @Nullable
    public p.b dYB() {
        return this.nPv;
    }

    @Nullable
    public PointF dYC() {
        return this.nPx;
    }

    @Nullable
    public ColorFilter dYD() {
        return this.nPy;
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
            this.nPz = null;
        } else {
            this.nPz = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> getOverlays() {
        return this.nPz;
    }

    public b t(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.nPA = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.nPA = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable dYE() {
        return this.nPA;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.nPe = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams dYp() {
        return this.nPe;
    }

    private void validate() {
        if (this.nPz != null) {
            for (Drawable drawable : this.nPz) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a dYF() {
        validate();
        return new a(this);
    }
}
