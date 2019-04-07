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
    public static final n.b jDu = n.b.jDl;
    public static final n.b jDv = n.b.jDm;
    private Drawable jDA;
    private n.b jDB;
    private Drawable jDC;
    private n.b jDD;
    private Drawable jDE;
    private n.b jDF;
    private n.b jDG;
    private Matrix jDH;
    private PointF jDI;
    private ColorFilter jDJ;
    private List<Drawable> jDK;
    private Drawable jDL;
    private RoundingParams jDq;
    private int jDw;
    private float jDx;
    private Drawable jDy;
    @Nullable
    private n.b jDz;
    private Drawable mBackground;
    private Resources mResources;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.jDw = 300;
        this.jDx = 0.0f;
        this.jDy = null;
        this.jDz = jDu;
        this.jDA = null;
        this.jDB = jDu;
        this.jDC = null;
        this.jDD = jDu;
        this.jDE = null;
        this.jDF = jDu;
        this.jDG = jDv;
        this.jDH = null;
        this.jDI = null;
        this.jDJ = null;
        this.mBackground = null;
        this.jDK = null;
        this.jDL = null;
        this.jDq = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b BZ(int i) {
        this.jDw = i;
        return this;
    }

    public int cvz() {
        return this.jDw;
    }

    public b aW(float f) {
        this.jDx = f;
        return this;
    }

    public float cvA() {
        return this.jDx;
    }

    public b n(@Nullable Drawable drawable) {
        this.jDy = drawable;
        return this;
    }

    @Nullable
    public Drawable cvB() {
        return this.jDy;
    }

    public b c(@Nullable n.b bVar) {
        this.jDz = bVar;
        return this;
    }

    @Nullable
    public n.b cvC() {
        return this.jDz;
    }

    public b o(@Nullable Drawable drawable) {
        this.jDA = drawable;
        return this;
    }

    @Nullable
    public Drawable cvD() {
        return this.jDA;
    }

    public b d(@Nullable n.b bVar) {
        this.jDB = bVar;
        return this;
    }

    @Nullable
    public n.b cvE() {
        return this.jDB;
    }

    public b p(@Nullable Drawable drawable) {
        this.jDC = drawable;
        return this;
    }

    @Nullable
    public Drawable cvF() {
        return this.jDC;
    }

    public b e(@Nullable n.b bVar) {
        this.jDD = bVar;
        return this;
    }

    @Nullable
    public n.b cvG() {
        return this.jDD;
    }

    public b q(@Nullable Drawable drawable) {
        this.jDE = drawable;
        return this;
    }

    @Nullable
    public Drawable cvH() {
        return this.jDE;
    }

    public b f(@Nullable n.b bVar) {
        this.jDF = bVar;
        return this;
    }

    @Nullable
    public n.b cvI() {
        return this.jDF;
    }

    public b g(@Nullable n.b bVar) {
        this.jDG = bVar;
        this.jDH = null;
        return this;
    }

    @Nullable
    public n.b cvJ() {
        return this.jDG;
    }

    @Nullable
    public Matrix cvK() {
        return this.jDH;
    }

    @Nullable
    public PointF cvL() {
        return this.jDI;
    }

    @Nullable
    public ColorFilter cvM() {
        return this.jDJ;
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
            this.jDK = null;
        } else {
            this.jDK = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> cvN() {
        return this.jDK;
    }

    public b t(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.jDL = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.jDL = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable cvO() {
        return this.jDL;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.jDq = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams cvP() {
        return this.jDq;
    }

    private void validate() {
        if (this.jDK != null) {
            for (Drawable drawable : this.jDK) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a cvQ() {
        validate();
        return new a(this);
    }
}
