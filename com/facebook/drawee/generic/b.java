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
    public static final p.b oGB = p.b.oGr;
    public static final p.b oGC = p.b.oGs;
    private Drawable mBackground;
    private Resources mResources;
    private int oGD;
    private boolean oGE;
    private float oGF;
    private Drawable oGG;
    @Nullable
    private p.b oGH;
    private Drawable oGI;
    private p.b oGJ;
    private Drawable oGK;
    private p.b oGL;
    private Drawable oGM;
    private p.b oGN;
    private p.b oGO;
    private Matrix oGP;
    private PointF oGQ;
    private ColorFilter oGR;
    private List<Drawable> oGS;
    private Drawable oGT;
    private RoundingParams oGx;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.oGD = 150;
        this.oGE = true;
        this.oGF = 0.0f;
        this.oGG = null;
        this.oGH = oGB;
        this.oGI = null;
        this.oGJ = oGB;
        this.oGK = null;
        this.oGL = oGB;
        this.oGM = null;
        this.oGN = oGB;
        this.oGO = oGC;
        this.oGP = null;
        this.oGQ = null;
        this.oGR = null;
        this.mBackground = null;
        this.oGS = null;
        this.oGT = null;
        this.oGx = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b Oq(int i) {
        this.oGD = i;
        return this;
    }

    public int eio() {
        return this.oGD;
    }

    public boolean eip() {
        return this.oGE;
    }

    public b bk(float f) {
        this.oGF = f;
        return this;
    }

    public float eiq() {
        return this.oGF;
    }

    public b s(@Nullable Drawable drawable) {
        this.oGG = drawable;
        return this;
    }

    public b Or(int i) {
        this.oGG = this.mResources.getDrawable(i);
        return this;
    }

    @Nullable
    public Drawable eir() {
        return this.oGG;
    }

    public b c(@Nullable p.b bVar) {
        this.oGH = bVar;
        return this;
    }

    @Nullable
    public p.b eis() {
        return this.oGH;
    }

    public b t(@Nullable Drawable drawable) {
        this.oGI = drawable;
        return this;
    }

    @Nullable
    public Drawable eit() {
        return this.oGI;
    }

    public b d(@Nullable p.b bVar) {
        this.oGJ = bVar;
        return this;
    }

    @Nullable
    public p.b eiu() {
        return this.oGJ;
    }

    public b u(@Nullable Drawable drawable) {
        this.oGK = drawable;
        return this;
    }

    @Nullable
    public Drawable eiv() {
        return this.oGK;
    }

    public b e(@Nullable p.b bVar) {
        this.oGL = bVar;
        return this;
    }

    @Nullable
    public p.b eiw() {
        return this.oGL;
    }

    public b v(@Nullable Drawable drawable) {
        this.oGM = drawable;
        return this;
    }

    @Nullable
    public Drawable eix() {
        return this.oGM;
    }

    public b f(@Nullable p.b bVar) {
        this.oGN = bVar;
        return this;
    }

    @Nullable
    public p.b eiy() {
        return this.oGN;
    }

    public b g(@Nullable p.b bVar) {
        this.oGO = bVar;
        this.oGP = null;
        return this;
    }

    @Nullable
    public p.b eiz() {
        return this.oGO;
    }

    @Nullable
    public PointF eiA() {
        return this.oGQ;
    }

    @Nullable
    public ColorFilter eiB() {
        return this.oGR;
    }

    public b w(@Nullable Drawable drawable) {
        this.mBackground = drawable;
        return this;
    }

    @Nullable
    public Drawable getBackground() {
        return this.mBackground;
    }

    public b x(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.oGS = null;
        } else {
            this.oGS = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> getOverlays() {
        return this.oGS;
    }

    public b y(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.oGT = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.oGT = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable eiC() {
        return this.oGT;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.oGx = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams ein() {
        return this.oGx;
    }

    private void validate() {
        if (this.oGS != null) {
            for (Drawable drawable : this.oGS) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a eiD() {
        validate();
        return new a(this);
    }
}
