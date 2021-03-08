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
/* loaded from: classes4.dex */
public class b {
    public static final p.b pGk = p.b.pGa;
    public static final p.b pGl = p.b.pGb;
    private Drawable mBackground;
    private Resources mResources;
    private ColorFilter pGA;
    private List<Drawable> pGB;
    private Drawable pGC;
    private RoundingParams pGg;
    private int pGm;
    private boolean pGn;
    private float pGo;
    private Drawable pGp;
    @Nullable
    private p.b pGq;
    private Drawable pGr;
    private p.b pGs;
    private Drawable pGt;
    private p.b pGu;
    private Drawable pGv;
    private p.b pGw;
    private p.b pGx;
    private Matrix pGy;
    private PointF pGz;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.pGm = 150;
        this.pGn = true;
        this.pGo = 0.0f;
        this.pGp = null;
        this.pGq = pGk;
        this.pGr = null;
        this.pGs = pGk;
        this.pGt = null;
        this.pGu = pGk;
        this.pGv = null;
        this.pGw = pGk;
        this.pGx = pGl;
        this.pGy = null;
        this.pGz = null;
        this.pGA = null;
        this.mBackground = null;
        this.pGB = null;
        this.pGC = null;
        this.pGg = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b Ps(int i) {
        this.pGm = i;
        return this;
    }

    public int euR() {
        return this.pGm;
    }

    public boolean euS() {
        return this.pGn;
    }

    public b bN(float f) {
        this.pGo = f;
        return this;
    }

    public float euT() {
        return this.pGo;
    }

    public b B(@Nullable Drawable drawable) {
        this.pGp = drawable;
        return this;
    }

    public b Pt(int i) {
        this.pGp = this.mResources.getDrawable(i);
        return this;
    }

    @Nullable
    public Drawable euU() {
        return this.pGp;
    }

    public b c(@Nullable p.b bVar) {
        this.pGq = bVar;
        return this;
    }

    @Nullable
    public p.b euV() {
        return this.pGq;
    }

    public b C(@Nullable Drawable drawable) {
        this.pGr = drawable;
        return this;
    }

    @Nullable
    public Drawable euW() {
        return this.pGr;
    }

    public b d(@Nullable p.b bVar) {
        this.pGs = bVar;
        return this;
    }

    @Nullable
    public p.b euX() {
        return this.pGs;
    }

    public b D(@Nullable Drawable drawable) {
        this.pGt = drawable;
        return this;
    }

    @Nullable
    public Drawable euY() {
        return this.pGt;
    }

    public b e(@Nullable p.b bVar) {
        this.pGu = bVar;
        return this;
    }

    @Nullable
    public p.b euZ() {
        return this.pGu;
    }

    public b E(@Nullable Drawable drawable) {
        this.pGv = drawable;
        return this;
    }

    @Nullable
    public Drawable eva() {
        return this.pGv;
    }

    public b f(@Nullable p.b bVar) {
        this.pGw = bVar;
        return this;
    }

    @Nullable
    public p.b evb() {
        return this.pGw;
    }

    public b g(@Nullable p.b bVar) {
        this.pGx = bVar;
        this.pGy = null;
        return this;
    }

    @Nullable
    public p.b evc() {
        return this.pGx;
    }

    @Nullable
    public PointF evd() {
        return this.pGz;
    }

    @Nullable
    public ColorFilter eve() {
        return this.pGA;
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
            this.pGB = null;
        } else {
            this.pGB = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> evf() {
        return this.pGB;
    }

    public b H(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.pGC = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.pGC = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable evg() {
        return this.pGC;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.pGg = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams euQ() {
        return this.pGg;
    }

    private void validate() {
        if (this.pGB != null) {
            for (Drawable drawable : this.pGB) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a evh() {
        validate();
        return new a(this);
    }
}
