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
    public static final n.b jDP = n.b.jDG;
    public static final n.b jDQ = n.b.jDH;
    private RoundingParams jDL;
    private int jDR;
    private float jDS;
    private Drawable jDT;
    @Nullable
    private n.b jDU;
    private Drawable jDV;
    private n.b jDW;
    private Drawable jDX;
    private n.b jDY;
    private Drawable jDZ;
    private n.b jEa;
    private n.b jEb;
    private Matrix jEc;
    private PointF jEd;
    private ColorFilter jEe;
    private List<Drawable> jEf;
    private Drawable jEg;
    private Drawable mBackground;
    private Resources mResources;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.jDR = 300;
        this.jDS = 0.0f;
        this.jDT = null;
        this.jDU = jDP;
        this.jDV = null;
        this.jDW = jDP;
        this.jDX = null;
        this.jDY = jDP;
        this.jDZ = null;
        this.jEa = jDP;
        this.jEb = jDQ;
        this.jEc = null;
        this.jEd = null;
        this.jEe = null;
        this.mBackground = null;
        this.jEf = null;
        this.jEg = null;
        this.jDL = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b Ci(int i) {
        this.jDR = i;
        return this;
    }

    public int cvt() {
        return this.jDR;
    }

    public b aW(float f) {
        this.jDS = f;
        return this;
    }

    public float cvu() {
        return this.jDS;
    }

    public b n(@Nullable Drawable drawable) {
        this.jDT = drawable;
        return this;
    }

    @Nullable
    public Drawable cvv() {
        return this.jDT;
    }

    public b c(@Nullable n.b bVar) {
        this.jDU = bVar;
        return this;
    }

    @Nullable
    public n.b cvw() {
        return this.jDU;
    }

    public b o(@Nullable Drawable drawable) {
        this.jDV = drawable;
        return this;
    }

    @Nullable
    public Drawable cvx() {
        return this.jDV;
    }

    public b d(@Nullable n.b bVar) {
        this.jDW = bVar;
        return this;
    }

    @Nullable
    public n.b cvy() {
        return this.jDW;
    }

    public b p(@Nullable Drawable drawable) {
        this.jDX = drawable;
        return this;
    }

    @Nullable
    public Drawable cvz() {
        return this.jDX;
    }

    public b e(@Nullable n.b bVar) {
        this.jDY = bVar;
        return this;
    }

    @Nullable
    public n.b cvA() {
        return this.jDY;
    }

    public b q(@Nullable Drawable drawable) {
        this.jDZ = drawable;
        return this;
    }

    @Nullable
    public Drawable cvB() {
        return this.jDZ;
    }

    public b f(@Nullable n.b bVar) {
        this.jEa = bVar;
        return this;
    }

    @Nullable
    public n.b cvC() {
        return this.jEa;
    }

    public b g(@Nullable n.b bVar) {
        this.jEb = bVar;
        this.jEc = null;
        return this;
    }

    @Nullable
    public n.b cvD() {
        return this.jEb;
    }

    @Nullable
    public Matrix cvE() {
        return this.jEc;
    }

    @Nullable
    public PointF cvF() {
        return this.jEd;
    }

    @Nullable
    public ColorFilter cvG() {
        return this.jEe;
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
            this.jEf = null;
        } else {
            this.jEf = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> cvH() {
        return this.jEf;
    }

    public b t(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.jEg = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.jEg = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable cvI() {
        return this.jEg;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.jDL = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams cvJ() {
        return this.jDL;
    }

    private void validate() {
        if (this.jEf != null) {
            for (Drawable drawable : this.jEf) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a cvK() {
        validate();
        return new a(this);
    }
}
