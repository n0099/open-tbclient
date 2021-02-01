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
    public static final p.b pDF = p.b.pDv;
    public static final p.b pDG = p.b.pDw;
    private Drawable mBackground;
    private Resources mResources;
    private RoundingParams pDB;
    private int pDH;
    private boolean pDI;
    private float pDJ;
    private Drawable pDK;
    @Nullable
    private p.b pDL;
    private Drawable pDM;
    private p.b pDN;
    private Drawable pDO;
    private p.b pDP;
    private Drawable pDQ;
    private p.b pDR;
    private p.b pDS;
    private Matrix pDT;
    private PointF pDU;
    private ColorFilter pDV;
    private List<Drawable> pDW;
    private Drawable pDX;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.pDH = 150;
        this.pDI = true;
        this.pDJ = 0.0f;
        this.pDK = null;
        this.pDL = pDF;
        this.pDM = null;
        this.pDN = pDF;
        this.pDO = null;
        this.pDP = pDF;
        this.pDQ = null;
        this.pDR = pDF;
        this.pDS = pDG;
        this.pDT = null;
        this.pDU = null;
        this.pDV = null;
        this.mBackground = null;
        this.pDW = null;
        this.pDX = null;
        this.pDB = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b Pn(int i) {
        this.pDH = i;
        return this;
    }

    public int euA() {
        return this.pDH;
    }

    public boolean euB() {
        return this.pDI;
    }

    public b bJ(float f) {
        this.pDJ = f;
        return this;
    }

    public float euC() {
        return this.pDJ;
    }

    public b B(@Nullable Drawable drawable) {
        this.pDK = drawable;
        return this;
    }

    public b Po(int i) {
        this.pDK = this.mResources.getDrawable(i);
        return this;
    }

    @Nullable
    public Drawable euD() {
        return this.pDK;
    }

    public b c(@Nullable p.b bVar) {
        this.pDL = bVar;
        return this;
    }

    @Nullable
    public p.b euE() {
        return this.pDL;
    }

    public b C(@Nullable Drawable drawable) {
        this.pDM = drawable;
        return this;
    }

    @Nullable
    public Drawable euF() {
        return this.pDM;
    }

    public b d(@Nullable p.b bVar) {
        this.pDN = bVar;
        return this;
    }

    @Nullable
    public p.b euG() {
        return this.pDN;
    }

    public b D(@Nullable Drawable drawable) {
        this.pDO = drawable;
        return this;
    }

    @Nullable
    public Drawable euH() {
        return this.pDO;
    }

    public b e(@Nullable p.b bVar) {
        this.pDP = bVar;
        return this;
    }

    @Nullable
    public p.b euI() {
        return this.pDP;
    }

    public b E(@Nullable Drawable drawable) {
        this.pDQ = drawable;
        return this;
    }

    @Nullable
    public Drawable euJ() {
        return this.pDQ;
    }

    public b f(@Nullable p.b bVar) {
        this.pDR = bVar;
        return this;
    }

    @Nullable
    public p.b euK() {
        return this.pDR;
    }

    public b g(@Nullable p.b bVar) {
        this.pDS = bVar;
        this.pDT = null;
        return this;
    }

    @Nullable
    public p.b euL() {
        return this.pDS;
    }

    @Nullable
    public PointF euM() {
        return this.pDU;
    }

    @Nullable
    public ColorFilter euN() {
        return this.pDV;
    }

    public b F(@Nullable Drawable drawable) {
        this.mBackground = drawable;
        return this;
    }

    @Nullable
    public Drawable getBackground() {
        return this.mBackground;
    }

    public b G(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.pDW = null;
        } else {
            this.pDW = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> euO() {
        return this.pDW;
    }

    public b H(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.pDX = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.pDX = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable euP() {
        return this.pDX;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.pDB = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams euz() {
        return this.pDB;
    }

    private void validate() {
        if (this.pDW != null) {
            for (Drawable drawable : this.pDW) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a euQ() {
        validate();
        return new a(this);
    }
}
