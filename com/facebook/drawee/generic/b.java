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
    public static final p.b pxX = p.b.pxN;
    public static final p.b pxY = p.b.pxO;
    private Drawable mBackground;
    private Resources mResources;
    private RoundingParams pxT;
    private int pxZ;
    private boolean pya;
    private float pyb;
    private Drawable pyc;
    @Nullable
    private p.b pyd;
    private Drawable pye;
    private p.b pyf;
    private Drawable pyg;
    private p.b pyh;
    private Drawable pyi;
    private p.b pyj;
    private p.b pyk;
    private Matrix pyl;
    private PointF pym;
    private ColorFilter pyn;
    private List<Drawable> pyo;
    private Drawable pyp;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.pxZ = 150;
        this.pya = true;
        this.pyb = 0.0f;
        this.pyc = null;
        this.pyd = pxX;
        this.pye = null;
        this.pyf = pxX;
        this.pyg = null;
        this.pyh = pxX;
        this.pyi = null;
        this.pyj = pxX;
        this.pyk = pxY;
        this.pyl = null;
        this.pym = null;
        this.pyn = null;
        this.mBackground = null;
        this.pyo = null;
        this.pyp = null;
        this.pxT = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b Qz(int i) {
        this.pxZ = i;
        return this;
    }

    public int ewb() {
        return this.pxZ;
    }

    public boolean ewc() {
        return this.pya;
    }

    public b bG(float f) {
        this.pyb = f;
        return this;
    }

    public float ewd() {
        return this.pyb;
    }

    public b B(@Nullable Drawable drawable) {
        this.pyc = drawable;
        return this;
    }

    public b QA(int i) {
        this.pyc = this.mResources.getDrawable(i);
        return this;
    }

    @Nullable
    public Drawable ewe() {
        return this.pyc;
    }

    public b c(@Nullable p.b bVar) {
        this.pyd = bVar;
        return this;
    }

    @Nullable
    public p.b ewf() {
        return this.pyd;
    }

    public b C(@Nullable Drawable drawable) {
        this.pye = drawable;
        return this;
    }

    @Nullable
    public Drawable ewg() {
        return this.pye;
    }

    public b d(@Nullable p.b bVar) {
        this.pyf = bVar;
        return this;
    }

    @Nullable
    public p.b ewh() {
        return this.pyf;
    }

    public b D(@Nullable Drawable drawable) {
        this.pyg = drawable;
        return this;
    }

    @Nullable
    public Drawable ewi() {
        return this.pyg;
    }

    public b e(@Nullable p.b bVar) {
        this.pyh = bVar;
        return this;
    }

    @Nullable
    public p.b ewj() {
        return this.pyh;
    }

    public b E(@Nullable Drawable drawable) {
        this.pyi = drawable;
        return this;
    }

    @Nullable
    public Drawable ewk() {
        return this.pyi;
    }

    public b f(@Nullable p.b bVar) {
        this.pyj = bVar;
        return this;
    }

    @Nullable
    public p.b ewl() {
        return this.pyj;
    }

    public b g(@Nullable p.b bVar) {
        this.pyk = bVar;
        this.pyl = null;
        return this;
    }

    @Nullable
    public p.b ewm() {
        return this.pyk;
    }

    @Nullable
    public PointF ewn() {
        return this.pym;
    }

    @Nullable
    public ColorFilter ewo() {
        return this.pyn;
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
            this.pyo = null;
        } else {
            this.pyo = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> getOverlays() {
        return this.pyo;
    }

    public b H(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.pyp = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.pyp = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable ewp() {
        return this.pyp;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.pxT = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams ewa() {
        return this.pxT;
    }

    private void validate() {
        if (this.pyo != null) {
            for (Drawable drawable : this.pyo) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a ewq() {
        validate();
        return new a(this);
    }
}
