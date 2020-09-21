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
/* loaded from: classes11.dex */
public class b {
    public static final p.b nzP = p.b.nzF;
    public static final p.b nzQ = p.b.nzG;
    private Drawable mBackground;
    private Resources mResources;
    private Drawable nAa;
    private p.b nAb;
    private p.b nAc;
    private Matrix nAd;
    private PointF nAe;
    private ColorFilter nAf;
    private List<Drawable> nAg;
    private Drawable nAh;
    private RoundingParams nzL;
    private int nzR;
    private boolean nzS;
    private float nzT;
    private Drawable nzU;
    @Nullable
    private p.b nzV;
    private Drawable nzW;
    private p.b nzX;
    private Drawable nzY;
    private p.b nzZ;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.nzR = 150;
        this.nzS = true;
        this.nzT = 0.0f;
        this.nzU = null;
        this.nzV = nzP;
        this.nzW = null;
        this.nzX = nzP;
        this.nzY = null;
        this.nzZ = nzP;
        this.nAa = null;
        this.nAb = nzP;
        this.nAc = nzQ;
        this.nAd = null;
        this.nAe = null;
        this.nAf = null;
        this.mBackground = null;
        this.nAg = null;
        this.nAh = null;
        this.nzL = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b LT(int i) {
        this.nzR = i;
        return this;
    }

    public int dUF() {
        return this.nzR;
    }

    public boolean dUG() {
        return this.nzS;
    }

    public b aN(float f) {
        this.nzT = f;
        return this;
    }

    public float dUH() {
        return this.nzT;
    }

    public b n(@Nullable Drawable drawable) {
        this.nzU = drawable;
        return this;
    }

    public b LU(int i) {
        this.nzU = this.mResources.getDrawable(i);
        return this;
    }

    @Nullable
    public Drawable dUI() {
        return this.nzU;
    }

    public b c(@Nullable p.b bVar) {
        this.nzV = bVar;
        return this;
    }

    @Nullable
    public p.b dUJ() {
        return this.nzV;
    }

    public b o(@Nullable Drawable drawable) {
        this.nzW = drawable;
        return this;
    }

    @Nullable
    public Drawable dUK() {
        return this.nzW;
    }

    public b d(@Nullable p.b bVar) {
        this.nzX = bVar;
        return this;
    }

    @Nullable
    public p.b dUL() {
        return this.nzX;
    }

    public b p(@Nullable Drawable drawable) {
        this.nzY = drawable;
        return this;
    }

    @Nullable
    public Drawable dUM() {
        return this.nzY;
    }

    public b e(@Nullable p.b bVar) {
        this.nzZ = bVar;
        return this;
    }

    @Nullable
    public p.b dUN() {
        return this.nzZ;
    }

    public b q(@Nullable Drawable drawable) {
        this.nAa = drawable;
        return this;
    }

    @Nullable
    public Drawable dUO() {
        return this.nAa;
    }

    public b f(@Nullable p.b bVar) {
        this.nAb = bVar;
        return this;
    }

    @Nullable
    public p.b dUP() {
        return this.nAb;
    }

    public b g(@Nullable p.b bVar) {
        this.nAc = bVar;
        this.nAd = null;
        return this;
    }

    @Nullable
    public p.b dUQ() {
        return this.nAc;
    }

    @Nullable
    public PointF dUR() {
        return this.nAe;
    }

    @Nullable
    public ColorFilter dUS() {
        return this.nAf;
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
            this.nAg = null;
        } else {
            this.nAg = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> getOverlays() {
        return this.nAg;
    }

    public b t(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.nAh = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.nAh = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable dUT() {
        return this.nAh;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.nzL = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams dUE() {
        return this.nzL;
    }

    private void validate() {
        if (this.nAg != null) {
            for (Drawable drawable : this.nAg) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a dUU() {
        validate();
        return new a(this);
    }
}
