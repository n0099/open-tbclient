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
    public static final n.b jDv = n.b.jDm;
    public static final n.b jDw = n.b.jDn;
    @Nullable
    private n.b jDA;
    private Drawable jDB;
    private n.b jDC;
    private Drawable jDD;
    private n.b jDE;
    private Drawable jDF;
    private n.b jDG;
    private n.b jDH;
    private Matrix jDI;
    private PointF jDJ;
    private ColorFilter jDK;
    private List<Drawable> jDL;
    private Drawable jDM;
    private RoundingParams jDr;
    private int jDx;
    private float jDy;
    private Drawable jDz;
    private Drawable mBackground;
    private Resources mResources;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.jDx = 300;
        this.jDy = 0.0f;
        this.jDz = null;
        this.jDA = jDv;
        this.jDB = null;
        this.jDC = jDv;
        this.jDD = null;
        this.jDE = jDv;
        this.jDF = null;
        this.jDG = jDv;
        this.jDH = jDw;
        this.jDI = null;
        this.jDJ = null;
        this.jDK = null;
        this.mBackground = null;
        this.jDL = null;
        this.jDM = null;
        this.jDr = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b BZ(int i) {
        this.jDx = i;
        return this;
    }

    public int cvz() {
        return this.jDx;
    }

    public b aW(float f) {
        this.jDy = f;
        return this;
    }

    public float cvA() {
        return this.jDy;
    }

    public b n(@Nullable Drawable drawable) {
        this.jDz = drawable;
        return this;
    }

    @Nullable
    public Drawable cvB() {
        return this.jDz;
    }

    public b c(@Nullable n.b bVar) {
        this.jDA = bVar;
        return this;
    }

    @Nullable
    public n.b cvC() {
        return this.jDA;
    }

    public b o(@Nullable Drawable drawable) {
        this.jDB = drawable;
        return this;
    }

    @Nullable
    public Drawable cvD() {
        return this.jDB;
    }

    public b d(@Nullable n.b bVar) {
        this.jDC = bVar;
        return this;
    }

    @Nullable
    public n.b cvE() {
        return this.jDC;
    }

    public b p(@Nullable Drawable drawable) {
        this.jDD = drawable;
        return this;
    }

    @Nullable
    public Drawable cvF() {
        return this.jDD;
    }

    public b e(@Nullable n.b bVar) {
        this.jDE = bVar;
        return this;
    }

    @Nullable
    public n.b cvG() {
        return this.jDE;
    }

    public b q(@Nullable Drawable drawable) {
        this.jDF = drawable;
        return this;
    }

    @Nullable
    public Drawable cvH() {
        return this.jDF;
    }

    public b f(@Nullable n.b bVar) {
        this.jDG = bVar;
        return this;
    }

    @Nullable
    public n.b cvI() {
        return this.jDG;
    }

    public b g(@Nullable n.b bVar) {
        this.jDH = bVar;
        this.jDI = null;
        return this;
    }

    @Nullable
    public n.b cvJ() {
        return this.jDH;
    }

    @Nullable
    public Matrix cvK() {
        return this.jDI;
    }

    @Nullable
    public PointF cvL() {
        return this.jDJ;
    }

    @Nullable
    public ColorFilter cvM() {
        return this.jDK;
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
            this.jDL = null;
        } else {
            this.jDL = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> cvN() {
        return this.jDL;
    }

    public b t(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.jDM = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.jDM = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable cvO() {
        return this.jDM;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.jDr = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams cvP() {
        return this.jDr;
    }

    private void validate() {
        if (this.jDL != null) {
            for (Drawable drawable : this.jDL) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a cvQ() {
        validate();
        return new a(this);
    }
}
