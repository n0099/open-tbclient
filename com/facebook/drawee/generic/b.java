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
    public static final p.b pgG = p.b.pgw;
    public static final p.b pgH = p.b.pgx;
    private Drawable mBackground;
    private Resources mResources;
    private RoundingParams pgC;
    private int pgI;
    private boolean pgJ;
    private float pgK;
    private Drawable pgL;
    @Nullable
    private p.b pgM;
    private Drawable pgN;
    private p.b pgO;
    private Drawable pgP;
    private p.b pgQ;
    private Drawable pgR;
    private p.b pgS;
    private p.b pgT;
    private Matrix pgU;
    private PointF pgV;
    private ColorFilter pgW;
    private List<Drawable> pgX;
    private Drawable pgY;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.pgI = 150;
        this.pgJ = true;
        this.pgK = 0.0f;
        this.pgL = null;
        this.pgM = pgG;
        this.pgN = null;
        this.pgO = pgG;
        this.pgP = null;
        this.pgQ = pgG;
        this.pgR = null;
        this.pgS = pgG;
        this.pgT = pgH;
        this.pgU = null;
        this.pgV = null;
        this.pgW = null;
        this.mBackground = null;
        this.pgX = null;
        this.pgY = null;
        this.pgC = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b Ql(int i) {
        this.pgI = i;
        return this;
    }

    public int erQ() {
        return this.pgI;
    }

    public boolean erR() {
        return this.pgJ;
    }

    public b bu(float f) {
        this.pgK = f;
        return this;
    }

    public float erS() {
        return this.pgK;
    }

    public b t(@Nullable Drawable drawable) {
        this.pgL = drawable;
        return this;
    }

    public b Qm(int i) {
        this.pgL = this.mResources.getDrawable(i);
        return this;
    }

    @Nullable
    public Drawable erT() {
        return this.pgL;
    }

    public b c(@Nullable p.b bVar) {
        this.pgM = bVar;
        return this;
    }

    @Nullable
    public p.b erU() {
        return this.pgM;
    }

    public b u(@Nullable Drawable drawable) {
        this.pgN = drawable;
        return this;
    }

    @Nullable
    public Drawable erV() {
        return this.pgN;
    }

    public b d(@Nullable p.b bVar) {
        this.pgO = bVar;
        return this;
    }

    @Nullable
    public p.b erW() {
        return this.pgO;
    }

    public b v(@Nullable Drawable drawable) {
        this.pgP = drawable;
        return this;
    }

    @Nullable
    public Drawable erX() {
        return this.pgP;
    }

    public b e(@Nullable p.b bVar) {
        this.pgQ = bVar;
        return this;
    }

    @Nullable
    public p.b erY() {
        return this.pgQ;
    }

    public b w(@Nullable Drawable drawable) {
        this.pgR = drawable;
        return this;
    }

    @Nullable
    public Drawable erZ() {
        return this.pgR;
    }

    public b f(@Nullable p.b bVar) {
        this.pgS = bVar;
        return this;
    }

    @Nullable
    public p.b esa() {
        return this.pgS;
    }

    public b g(@Nullable p.b bVar) {
        this.pgT = bVar;
        this.pgU = null;
        return this;
    }

    @Nullable
    public p.b esb() {
        return this.pgT;
    }

    @Nullable
    public PointF esc() {
        return this.pgV;
    }

    @Nullable
    public ColorFilter esd() {
        return this.pgW;
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
            this.pgX = null;
        } else {
            this.pgX = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> getOverlays() {
        return this.pgX;
    }

    public b z(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.pgY = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.pgY = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable ese() {
        return this.pgY;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.pgC = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams erP() {
        return this.pgC;
    }

    private void validate() {
        if (this.pgX != null) {
            for (Drawable drawable : this.pgX) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a esf() {
        validate();
        return new a(this);
    }
}
