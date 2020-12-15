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
/* loaded from: classes8.dex */
public class b {
    public static final p.b pgI = p.b.pgy;
    public static final p.b pgJ = p.b.pgz;
    private Drawable mBackground;
    private Resources mResources;
    private RoundingParams pgE;
    private int pgK;
    private boolean pgL;
    private float pgM;
    private Drawable pgN;
    @Nullable
    private p.b pgO;
    private Drawable pgP;
    private p.b pgQ;
    private Drawable pgR;
    private p.b pgS;
    private Drawable pgT;
    private p.b pgU;
    private p.b pgV;
    private Matrix pgW;
    private PointF pgX;
    private ColorFilter pgY;
    private List<Drawable> pgZ;
    private Drawable pha;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.pgK = 150;
        this.pgL = true;
        this.pgM = 0.0f;
        this.pgN = null;
        this.pgO = pgI;
        this.pgP = null;
        this.pgQ = pgI;
        this.pgR = null;
        this.pgS = pgI;
        this.pgT = null;
        this.pgU = pgI;
        this.pgV = pgJ;
        this.pgW = null;
        this.pgX = null;
        this.pgY = null;
        this.mBackground = null;
        this.pgZ = null;
        this.pha = null;
        this.pgE = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b Ql(int i) {
        this.pgK = i;
        return this;
    }

    public int erR() {
        return this.pgK;
    }

    public boolean erS() {
        return this.pgL;
    }

    public b bu(float f) {
        this.pgM = f;
        return this;
    }

    public float erT() {
        return this.pgM;
    }

    public b t(@Nullable Drawable drawable) {
        this.pgN = drawable;
        return this;
    }

    public b Qm(int i) {
        this.pgN = this.mResources.getDrawable(i);
        return this;
    }

    @Nullable
    public Drawable erU() {
        return this.pgN;
    }

    public b c(@Nullable p.b bVar) {
        this.pgO = bVar;
        return this;
    }

    @Nullable
    public p.b erV() {
        return this.pgO;
    }

    public b u(@Nullable Drawable drawable) {
        this.pgP = drawable;
        return this;
    }

    @Nullable
    public Drawable erW() {
        return this.pgP;
    }

    public b d(@Nullable p.b bVar) {
        this.pgQ = bVar;
        return this;
    }

    @Nullable
    public p.b erX() {
        return this.pgQ;
    }

    public b v(@Nullable Drawable drawable) {
        this.pgR = drawable;
        return this;
    }

    @Nullable
    public Drawable erY() {
        return this.pgR;
    }

    public b e(@Nullable p.b bVar) {
        this.pgS = bVar;
        return this;
    }

    @Nullable
    public p.b erZ() {
        return this.pgS;
    }

    public b w(@Nullable Drawable drawable) {
        this.pgT = drawable;
        return this;
    }

    @Nullable
    public Drawable esa() {
        return this.pgT;
    }

    public b f(@Nullable p.b bVar) {
        this.pgU = bVar;
        return this;
    }

    @Nullable
    public p.b esb() {
        return this.pgU;
    }

    public b g(@Nullable p.b bVar) {
        this.pgV = bVar;
        this.pgW = null;
        return this;
    }

    @Nullable
    public p.b esc() {
        return this.pgV;
    }

    @Nullable
    public PointF esd() {
        return this.pgX;
    }

    @Nullable
    public ColorFilter ese() {
        return this.pgY;
    }

    public b x(@Nullable Drawable drawable) {
        this.mBackground = drawable;
        return this;
    }

    @Nullable
    public Drawable getBackground() {
        return this.mBackground;
    }

    public b y(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.pgZ = null;
        } else {
            this.pgZ = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> getOverlays() {
        return this.pgZ;
    }

    public b z(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.pha = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.pha = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable esf() {
        return this.pha;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.pgE = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams erQ() {
        return this.pgE;
    }

    private void validate() {
        if (this.pgZ != null) {
            for (Drawable drawable : this.pgZ) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a esg() {
        validate();
        return new a(this);
    }
}
