package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.facebook.common.internal.g;
import com.facebook.drawee.drawable.n;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    public static final n.b jEi = n.b.jDZ;
    public static final n.b jEj = n.b.jEa;
    private RoundingParams jEe;
    private int jEk;
    private float jEl;
    private Drawable jEm;
    @Nullable
    private n.b jEn;
    private Drawable jEo;
    private n.b jEp;
    private Drawable jEq;
    private n.b jEr;
    private Drawable jEs;
    private n.b jEt;
    private n.b jEu;
    private Matrix jEv;
    private PointF jEw;
    private ColorFilter jEx;
    private List<Drawable> jEy;
    private Drawable jEz;
    private Drawable mBackground;
    private Resources mResources;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.jEk = 300;
        this.jEl = 0.0f;
        this.jEm = null;
        this.jEn = jEi;
        this.jEo = null;
        this.jEp = jEi;
        this.jEq = null;
        this.jEr = jEi;
        this.jEs = null;
        this.jEt = jEi;
        this.jEu = jEj;
        this.jEv = null;
        this.jEw = null;
        this.jEx = null;
        this.mBackground = null;
        this.jEy = null;
        this.jEz = null;
        this.jEe = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b Cj(int i) {
        this.jEk = i;
        return this;
    }

    public int cvD() {
        return this.jEk;
    }

    public b aW(float f) {
        this.jEl = f;
        return this;
    }

    public float cvE() {
        return this.jEl;
    }

    public b n(@Nullable Drawable drawable) {
        this.jEm = drawable;
        return this;
    }

    @Nullable
    public Drawable cvF() {
        return this.jEm;
    }

    public b c(@Nullable n.b bVar) {
        this.jEn = bVar;
        return this;
    }

    @Nullable
    public n.b cvG() {
        return this.jEn;
    }

    public b o(@Nullable Drawable drawable) {
        this.jEo = drawable;
        return this;
    }

    @Nullable
    public Drawable cvH() {
        return this.jEo;
    }

    public b d(@Nullable n.b bVar) {
        this.jEp = bVar;
        return this;
    }

    @Nullable
    public n.b cvI() {
        return this.jEp;
    }

    public b p(@Nullable Drawable drawable) {
        this.jEq = drawable;
        return this;
    }

    @Nullable
    public Drawable cvJ() {
        return this.jEq;
    }

    public b e(@Nullable n.b bVar) {
        this.jEr = bVar;
        return this;
    }

    @Nullable
    public n.b cvK() {
        return this.jEr;
    }

    public b q(@Nullable Drawable drawable) {
        this.jEs = drawable;
        return this;
    }

    @Nullable
    public Drawable cvL() {
        return this.jEs;
    }

    public b f(@Nullable n.b bVar) {
        this.jEt = bVar;
        return this;
    }

    @Nullable
    public n.b cvM() {
        return this.jEt;
    }

    public b g(@Nullable n.b bVar) {
        this.jEu = bVar;
        this.jEv = null;
        return this;
    }

    @Nullable
    public n.b cvN() {
        return this.jEu;
    }

    @Nullable
    public Matrix cvO() {
        return this.jEv;
    }

    @Nullable
    public PointF cvP() {
        return this.jEw;
    }

    @Nullable
    public ColorFilter cvQ() {
        return this.jEx;
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
            this.jEy = null;
        } else {
            this.jEy = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> cvR() {
        return this.jEy;
    }

    public b t(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.jEz = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.jEz = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable cvS() {
        return this.jEz;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.jEe = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams cvT() {
        return this.jEe;
    }

    private void validate() {
        if (this.jEy != null) {
            for (Drawable drawable : this.jEy) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a cvU() {
        validate();
        return new a(this);
    }
}
