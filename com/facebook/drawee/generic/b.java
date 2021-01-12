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
/* loaded from: classes3.dex */
public class b {
    public static final p.b ptw = p.b.ptl;
    public static final p.b ptx = p.b.ptm;
    private Drawable mBackground;
    private Resources mResources;
    private float ptA;
    private Drawable ptB;
    @Nullable
    private p.b ptC;
    private Drawable ptD;
    private p.b ptE;
    private Drawable ptF;
    private p.b ptG;
    private Drawable ptH;
    private p.b ptI;
    private p.b ptJ;
    private Matrix ptK;
    private PointF ptL;
    private ColorFilter ptM;
    private List<Drawable> ptN;
    private Drawable ptO;
    private RoundingParams ptr;
    private int pty;
    private boolean ptz;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.pty = 150;
        this.ptz = true;
        this.ptA = 0.0f;
        this.ptB = null;
        this.ptC = ptw;
        this.ptD = null;
        this.ptE = ptw;
        this.ptF = null;
        this.ptG = ptw;
        this.ptH = null;
        this.ptI = ptw;
        this.ptJ = ptx;
        this.ptK = null;
        this.ptL = null;
        this.ptM = null;
        this.mBackground = null;
        this.ptN = null;
        this.ptO = null;
        this.ptr = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b OS(int i) {
        this.pty = i;
        return this;
    }

    public int esi() {
        return this.pty;
    }

    public boolean esj() {
        return this.ptz;
    }

    public b bG(float f) {
        this.ptA = f;
        return this;
    }

    public float esk() {
        return this.ptA;
    }

    public b B(@Nullable Drawable drawable) {
        this.ptB = drawable;
        return this;
    }

    public b OT(int i) {
        this.ptB = this.mResources.getDrawable(i);
        return this;
    }

    @Nullable
    public Drawable esl() {
        return this.ptB;
    }

    public b c(@Nullable p.b bVar) {
        this.ptC = bVar;
        return this;
    }

    @Nullable
    public p.b esm() {
        return this.ptC;
    }

    public b C(@Nullable Drawable drawable) {
        this.ptD = drawable;
        return this;
    }

    @Nullable
    public Drawable esn() {
        return this.ptD;
    }

    public b d(@Nullable p.b bVar) {
        this.ptE = bVar;
        return this;
    }

    @Nullable
    public p.b eso() {
        return this.ptE;
    }

    public b D(@Nullable Drawable drawable) {
        this.ptF = drawable;
        return this;
    }

    @Nullable
    public Drawable esp() {
        return this.ptF;
    }

    public b e(@Nullable p.b bVar) {
        this.ptG = bVar;
        return this;
    }

    @Nullable
    public p.b esq() {
        return this.ptG;
    }

    public b E(@Nullable Drawable drawable) {
        this.ptH = drawable;
        return this;
    }

    @Nullable
    public Drawable esr() {
        return this.ptH;
    }

    public b f(@Nullable p.b bVar) {
        this.ptI = bVar;
        return this;
    }

    @Nullable
    public p.b ess() {
        return this.ptI;
    }

    public b g(@Nullable p.b bVar) {
        this.ptJ = bVar;
        this.ptK = null;
        return this;
    }

    @Nullable
    public p.b est() {
        return this.ptJ;
    }

    @Nullable
    public PointF esu() {
        return this.ptL;
    }

    @Nullable
    public ColorFilter esv() {
        return this.ptM;
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
            this.ptN = null;
        } else {
            this.ptN = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> esw() {
        return this.ptN;
    }

    public b H(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.ptO = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.ptO = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable esx() {
        return this.ptO;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.ptr = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams esh() {
        return this.ptr;
    }

    private void validate() {
        if (this.ptN != null) {
            for (Drawable drawable : this.ptN) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a esy() {
        validate();
        return new a(this);
    }
}
