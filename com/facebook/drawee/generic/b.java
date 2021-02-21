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
    public static final p.b pEf = p.b.pDV;
    public static final p.b pEg = p.b.pDW;
    private Drawable mBackground;
    private Resources mResources;
    private RoundingParams pEb;
    private int pEh;
    private boolean pEi;
    private float pEj;
    private Drawable pEk;
    @Nullable
    private p.b pEl;
    private Drawable pEm;
    private p.b pEn;
    private Drawable pEo;
    private p.b pEp;
    private Drawable pEq;
    private p.b pEr;
    private p.b pEs;
    private Matrix pEt;
    private PointF pEu;
    private ColorFilter pEv;
    private List<Drawable> pEw;
    private Drawable pEx;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.pEh = 150;
        this.pEi = true;
        this.pEj = 0.0f;
        this.pEk = null;
        this.pEl = pEf;
        this.pEm = null;
        this.pEn = pEf;
        this.pEo = null;
        this.pEp = pEf;
        this.pEq = null;
        this.pEr = pEf;
        this.pEs = pEg;
        this.pEt = null;
        this.pEu = null;
        this.pEv = null;
        this.mBackground = null;
        this.pEw = null;
        this.pEx = null;
        this.pEb = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b Po(int i) {
        this.pEh = i;
        return this;
    }

    public int euI() {
        return this.pEh;
    }

    public boolean euJ() {
        return this.pEi;
    }

    public b bJ(float f) {
        this.pEj = f;
        return this;
    }

    public float euK() {
        return this.pEj;
    }

    public b B(@Nullable Drawable drawable) {
        this.pEk = drawable;
        return this;
    }

    public b Pp(int i) {
        this.pEk = this.mResources.getDrawable(i);
        return this;
    }

    @Nullable
    public Drawable euL() {
        return this.pEk;
    }

    public b c(@Nullable p.b bVar) {
        this.pEl = bVar;
        return this;
    }

    @Nullable
    public p.b euM() {
        return this.pEl;
    }

    public b C(@Nullable Drawable drawable) {
        this.pEm = drawable;
        return this;
    }

    @Nullable
    public Drawable euN() {
        return this.pEm;
    }

    public b d(@Nullable p.b bVar) {
        this.pEn = bVar;
        return this;
    }

    @Nullable
    public p.b euO() {
        return this.pEn;
    }

    public b D(@Nullable Drawable drawable) {
        this.pEo = drawable;
        return this;
    }

    @Nullable
    public Drawable euP() {
        return this.pEo;
    }

    public b e(@Nullable p.b bVar) {
        this.pEp = bVar;
        return this;
    }

    @Nullable
    public p.b euQ() {
        return this.pEp;
    }

    public b E(@Nullable Drawable drawable) {
        this.pEq = drawable;
        return this;
    }

    @Nullable
    public Drawable euR() {
        return this.pEq;
    }

    public b f(@Nullable p.b bVar) {
        this.pEr = bVar;
        return this;
    }

    @Nullable
    public p.b euS() {
        return this.pEr;
    }

    public b g(@Nullable p.b bVar) {
        this.pEs = bVar;
        this.pEt = null;
        return this;
    }

    @Nullable
    public p.b euT() {
        return this.pEs;
    }

    @Nullable
    public PointF euU() {
        return this.pEu;
    }

    @Nullable
    public ColorFilter euV() {
        return this.pEv;
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
            this.pEw = null;
        } else {
            this.pEw = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> euW() {
        return this.pEw;
    }

    public b H(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.pEx = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.pEx = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable euX() {
        return this.pEx;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.pEb = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams euH() {
        return this.pEb;
    }

    private void validate() {
        if (this.pEw != null) {
            for (Drawable drawable : this.pEw) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a euY() {
        validate();
        return new a(this);
    }
}
