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
/* loaded from: classes14.dex */
public class b {
    public static final p.b oRx = p.b.oRn;
    public static final p.b oRy = p.b.oRo;
    private Drawable mBackground;
    private Resources mResources;
    private boolean oRA;
    private float oRB;
    private Drawable oRC;
    @Nullable
    private p.b oRD;
    private Drawable oRE;
    private p.b oRF;
    private Drawable oRG;
    private p.b oRH;
    private Drawable oRI;
    private p.b oRJ;
    private p.b oRK;
    private Matrix oRL;
    private PointF oRM;
    private ColorFilter oRN;
    private List<Drawable> oRO;
    private Drawable oRP;
    private RoundingParams oRt;
    private int oRz;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.oRz = 150;
        this.oRA = true;
        this.oRB = 0.0f;
        this.oRC = null;
        this.oRD = oRx;
        this.oRE = null;
        this.oRF = oRx;
        this.oRG = null;
        this.oRH = oRx;
        this.oRI = null;
        this.oRJ = oRx;
        this.oRK = oRy;
        this.oRL = null;
        this.oRM = null;
        this.oRN = null;
        this.mBackground = null;
        this.oRO = null;
        this.oRP = null;
        this.oRt = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b Po(int i) {
        this.oRz = i;
        return this;
    }

    public int emb() {
        return this.oRz;
    }

    public boolean emc() {
        return this.oRA;
    }

    public b bt(float f) {
        this.oRB = f;
        return this;
    }

    public float emd() {
        return this.oRB;
    }

    public b t(@Nullable Drawable drawable) {
        this.oRC = drawable;
        return this;
    }

    public b Pp(int i) {
        this.oRC = this.mResources.getDrawable(i);
        return this;
    }

    @Nullable
    public Drawable eme() {
        return this.oRC;
    }

    public b c(@Nullable p.b bVar) {
        this.oRD = bVar;
        return this;
    }

    @Nullable
    public p.b emf() {
        return this.oRD;
    }

    public b u(@Nullable Drawable drawable) {
        this.oRE = drawable;
        return this;
    }

    @Nullable
    public Drawable emg() {
        return this.oRE;
    }

    public b d(@Nullable p.b bVar) {
        this.oRF = bVar;
        return this;
    }

    @Nullable
    public p.b emh() {
        return this.oRF;
    }

    public b v(@Nullable Drawable drawable) {
        this.oRG = drawable;
        return this;
    }

    @Nullable
    public Drawable emi() {
        return this.oRG;
    }

    public b e(@Nullable p.b bVar) {
        this.oRH = bVar;
        return this;
    }

    @Nullable
    public p.b emj() {
        return this.oRH;
    }

    public b w(@Nullable Drawable drawable) {
        this.oRI = drawable;
        return this;
    }

    @Nullable
    public Drawable emk() {
        return this.oRI;
    }

    public b f(@Nullable p.b bVar) {
        this.oRJ = bVar;
        return this;
    }

    @Nullable
    public p.b eml() {
        return this.oRJ;
    }

    public b g(@Nullable p.b bVar) {
        this.oRK = bVar;
        this.oRL = null;
        return this;
    }

    @Nullable
    public p.b emm() {
        return this.oRK;
    }

    @Nullable
    public PointF emn() {
        return this.oRM;
    }

    @Nullable
    public ColorFilter emo() {
        return this.oRN;
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
            this.oRO = null;
        } else {
            this.oRO = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> getOverlays() {
        return this.oRO;
    }

    public b z(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.oRP = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.oRP = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable emp() {
        return this.oRP;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.oRt = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams ema() {
        return this.oRt;
    }

    private void validate() {
        if (this.oRO != null) {
            for (Drawable drawable : this.oRO) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a emq() {
        validate();
        return new a(this);
    }
}
