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
    public static final p.b pxQ = p.b.pxG;
    public static final p.b pxR = p.b.pxH;
    private Drawable mBackground;
    private Resources mResources;
    private RoundingParams pxM;
    private int pxS;
    private boolean pxT;
    private float pxU;
    private Drawable pxV;
    @Nullable
    private p.b pxW;
    private Drawable pxX;
    private p.b pxY;
    private Drawable pxZ;
    private p.b pya;
    private Drawable pyb;
    private p.b pyc;
    private p.b pyd;
    private Matrix pye;
    private PointF pyf;
    private ColorFilter pyg;
    private List<Drawable> pyh;
    private Drawable pyi;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.pxS = 150;
        this.pxT = true;
        this.pxU = 0.0f;
        this.pxV = null;
        this.pxW = pxQ;
        this.pxX = null;
        this.pxY = pxQ;
        this.pxZ = null;
        this.pya = pxQ;
        this.pyb = null;
        this.pyc = pxQ;
        this.pyd = pxR;
        this.pye = null;
        this.pyf = null;
        this.pyg = null;
        this.mBackground = null;
        this.pyh = null;
        this.pyi = null;
        this.pxM = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b Qu(int i) {
        this.pxS = i;
        return this;
    }

    public int evU() {
        return this.pxS;
    }

    public boolean evV() {
        return this.pxT;
    }

    public b bG(float f) {
        this.pxU = f;
        return this;
    }

    public float evW() {
        return this.pxU;
    }

    public b B(@Nullable Drawable drawable) {
        this.pxV = drawable;
        return this;
    }

    public b Qv(int i) {
        this.pxV = this.mResources.getDrawable(i);
        return this;
    }

    @Nullable
    public Drawable evX() {
        return this.pxV;
    }

    public b c(@Nullable p.b bVar) {
        this.pxW = bVar;
        return this;
    }

    @Nullable
    public p.b evY() {
        return this.pxW;
    }

    public b C(@Nullable Drawable drawable) {
        this.pxX = drawable;
        return this;
    }

    @Nullable
    public Drawable evZ() {
        return this.pxX;
    }

    public b d(@Nullable p.b bVar) {
        this.pxY = bVar;
        return this;
    }

    @Nullable
    public p.b ewa() {
        return this.pxY;
    }

    public b D(@Nullable Drawable drawable) {
        this.pxZ = drawable;
        return this;
    }

    @Nullable
    public Drawable ewb() {
        return this.pxZ;
    }

    public b e(@Nullable p.b bVar) {
        this.pya = bVar;
        return this;
    }

    @Nullable
    public p.b ewc() {
        return this.pya;
    }

    public b E(@Nullable Drawable drawable) {
        this.pyb = drawable;
        return this;
    }

    @Nullable
    public Drawable ewd() {
        return this.pyb;
    }

    public b f(@Nullable p.b bVar) {
        this.pyc = bVar;
        return this;
    }

    @Nullable
    public p.b ewe() {
        return this.pyc;
    }

    public b g(@Nullable p.b bVar) {
        this.pyd = bVar;
        this.pye = null;
        return this;
    }

    @Nullable
    public p.b ewf() {
        return this.pyd;
    }

    @Nullable
    public PointF ewg() {
        return this.pyf;
    }

    @Nullable
    public ColorFilter ewh() {
        return this.pyg;
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
            this.pyh = null;
        } else {
            this.pyh = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> getOverlays() {
        return this.pyh;
    }

    public b H(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.pyi = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.pyi = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable ewi() {
        return this.pyi;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.pxM = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams evT() {
        return this.pxM;
    }

    private void validate() {
        if (this.pyh != null) {
            for (Drawable drawable : this.pyh) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a ewj() {
        validate();
        return new a(this);
    }
}
