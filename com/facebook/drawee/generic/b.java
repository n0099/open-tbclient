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
    public static final n.b jEa = n.b.jDR;
    public static final n.b jEb = n.b.jDS;
    private RoundingParams jDW;
    private int jEc;
    private float jEd;
    private Drawable jEe;
    @Nullable
    private n.b jEf;
    private Drawable jEg;
    private n.b jEh;
    private Drawable jEi;
    private n.b jEj;
    private Drawable jEk;
    private n.b jEl;
    private n.b jEm;
    private Matrix jEn;
    private PointF jEo;
    private ColorFilter jEp;
    private List<Drawable> jEq;
    private Drawable jEr;
    private Drawable mBackground;
    private Resources mResources;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.jEc = 300;
        this.jEd = 0.0f;
        this.jEe = null;
        this.jEf = jEa;
        this.jEg = null;
        this.jEh = jEa;
        this.jEi = null;
        this.jEj = jEa;
        this.jEk = null;
        this.jEl = jEa;
        this.jEm = jEb;
        this.jEn = null;
        this.jEo = null;
        this.jEp = null;
        this.mBackground = null;
        this.jEq = null;
        this.jEr = null;
        this.jDW = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b Cj(int i) {
        this.jEc = i;
        return this;
    }

    public int cvG() {
        return this.jEc;
    }

    public b aW(float f) {
        this.jEd = f;
        return this;
    }

    public float cvH() {
        return this.jEd;
    }

    public b n(@Nullable Drawable drawable) {
        this.jEe = drawable;
        return this;
    }

    @Nullable
    public Drawable cvI() {
        return this.jEe;
    }

    public b c(@Nullable n.b bVar) {
        this.jEf = bVar;
        return this;
    }

    @Nullable
    public n.b cvJ() {
        return this.jEf;
    }

    public b o(@Nullable Drawable drawable) {
        this.jEg = drawable;
        return this;
    }

    @Nullable
    public Drawable cvK() {
        return this.jEg;
    }

    public b d(@Nullable n.b bVar) {
        this.jEh = bVar;
        return this;
    }

    @Nullable
    public n.b cvL() {
        return this.jEh;
    }

    public b p(@Nullable Drawable drawable) {
        this.jEi = drawable;
        return this;
    }

    @Nullable
    public Drawable cvM() {
        return this.jEi;
    }

    public b e(@Nullable n.b bVar) {
        this.jEj = bVar;
        return this;
    }

    @Nullable
    public n.b cvN() {
        return this.jEj;
    }

    public b q(@Nullable Drawable drawable) {
        this.jEk = drawable;
        return this;
    }

    @Nullable
    public Drawable cvO() {
        return this.jEk;
    }

    public b f(@Nullable n.b bVar) {
        this.jEl = bVar;
        return this;
    }

    @Nullable
    public n.b cvP() {
        return this.jEl;
    }

    public b g(@Nullable n.b bVar) {
        this.jEm = bVar;
        this.jEn = null;
        return this;
    }

    @Nullable
    public n.b cvQ() {
        return this.jEm;
    }

    @Nullable
    public Matrix cvR() {
        return this.jEn;
    }

    @Nullable
    public PointF cvS() {
        return this.jEo;
    }

    @Nullable
    public ColorFilter cvT() {
        return this.jEp;
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
            this.jEq = null;
        } else {
            this.jEq = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> cvU() {
        return this.jEq;
    }

    public b t(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.jEr = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.jEr = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable cvV() {
        return this.jEr;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.jDW = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams cvW() {
        return this.jDW;
    }

    private void validate() {
        if (this.jEq != null) {
            for (Drawable drawable : this.jEq) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a cvX() {
        validate();
        return new a(this);
    }
}
