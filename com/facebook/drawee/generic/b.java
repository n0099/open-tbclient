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
    public static final p.b ptx = p.b.ptm;
    public static final p.b pty = p.b.ptn;
    private Drawable mBackground;
    private Resources mResources;
    private boolean ptA;
    private float ptB;
    private Drawable ptC;
    @Nullable
    private p.b ptD;
    private Drawable ptE;
    private p.b ptF;
    private Drawable ptG;
    private p.b ptH;
    private Drawable ptI;
    private p.b ptJ;
    private p.b ptK;
    private Matrix ptL;
    private PointF ptM;
    private ColorFilter ptN;
    private List<Drawable> ptO;
    private Drawable ptP;
    private RoundingParams ptt;
    private int ptz;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.ptz = 150;
        this.ptA = true;
        this.ptB = 0.0f;
        this.ptC = null;
        this.ptD = ptx;
        this.ptE = null;
        this.ptF = ptx;
        this.ptG = null;
        this.ptH = ptx;
        this.ptI = null;
        this.ptJ = ptx;
        this.ptK = pty;
        this.ptL = null;
        this.ptM = null;
        this.ptN = null;
        this.mBackground = null;
        this.ptO = null;
        this.ptP = null;
        this.ptt = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b OS(int i) {
        this.ptz = i;
        return this;
    }

    public int esi() {
        return this.ptz;
    }

    public boolean esj() {
        return this.ptA;
    }

    public b bG(float f) {
        this.ptB = f;
        return this;
    }

    public float esk() {
        return this.ptB;
    }

    public b B(@Nullable Drawable drawable) {
        this.ptC = drawable;
        return this;
    }

    public b OT(int i) {
        this.ptC = this.mResources.getDrawable(i);
        return this;
    }

    @Nullable
    public Drawable esl() {
        return this.ptC;
    }

    public b c(@Nullable p.b bVar) {
        this.ptD = bVar;
        return this;
    }

    @Nullable
    public p.b esm() {
        return this.ptD;
    }

    public b C(@Nullable Drawable drawable) {
        this.ptE = drawable;
        return this;
    }

    @Nullable
    public Drawable esn() {
        return this.ptE;
    }

    public b d(@Nullable p.b bVar) {
        this.ptF = bVar;
        return this;
    }

    @Nullable
    public p.b eso() {
        return this.ptF;
    }

    public b D(@Nullable Drawable drawable) {
        this.ptG = drawable;
        return this;
    }

    @Nullable
    public Drawable esp() {
        return this.ptG;
    }

    public b e(@Nullable p.b bVar) {
        this.ptH = bVar;
        return this;
    }

    @Nullable
    public p.b esq() {
        return this.ptH;
    }

    public b E(@Nullable Drawable drawable) {
        this.ptI = drawable;
        return this;
    }

    @Nullable
    public Drawable esr() {
        return this.ptI;
    }

    public b f(@Nullable p.b bVar) {
        this.ptJ = bVar;
        return this;
    }

    @Nullable
    public p.b ess() {
        return this.ptJ;
    }

    public b g(@Nullable p.b bVar) {
        this.ptK = bVar;
        this.ptL = null;
        return this;
    }

    @Nullable
    public p.b est() {
        return this.ptK;
    }

    @Nullable
    public PointF esu() {
        return this.ptM;
    }

    @Nullable
    public ColorFilter esv() {
        return this.ptN;
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
            this.ptO = null;
        } else {
            this.ptO = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> esw() {
        return this.ptO;
    }

    public b H(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.ptP = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.ptP = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable esx() {
        return this.ptP;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.ptt = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams esh() {
        return this.ptt;
    }

    private void validate() {
        if (this.ptO != null) {
            for (Drawable drawable : this.ptO) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a esy() {
        validate();
        return new a(this);
    }
}
