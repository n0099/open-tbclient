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
    public static final p.b oPU = p.b.oPK;
    public static final p.b oPV = p.b.oPL;
    private Drawable mBackground;
    private Resources mResources;
    private RoundingParams oPQ;
    private int oPW;
    private boolean oPX;
    private float oPY;
    private Drawable oPZ;
    @Nullable
    private p.b oQa;
    private Drawable oQb;
    private p.b oQc;
    private Drawable oQd;
    private p.b oQe;
    private Drawable oQf;
    private p.b oQg;
    private p.b oQh;
    private Matrix oQi;
    private PointF oQj;
    private ColorFilter oQk;
    private List<Drawable> oQl;
    private Drawable oQm;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.oPW = 150;
        this.oPX = true;
        this.oPY = 0.0f;
        this.oPZ = null;
        this.oQa = oPU;
        this.oQb = null;
        this.oQc = oPU;
        this.oQd = null;
        this.oQe = oPU;
        this.oQf = null;
        this.oQg = oPU;
        this.oQh = oPV;
        this.oQi = null;
        this.oQj = null;
        this.oQk = null;
        this.mBackground = null;
        this.oQl = null;
        this.oQm = null;
        this.oPQ = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b OL(int i) {
        this.oPW = i;
        return this;
    }

    public int emd() {
        return this.oPW;
    }

    public boolean eme() {
        return this.oPX;
    }

    public b bm(float f) {
        this.oPY = f;
        return this;
    }

    public float emf() {
        return this.oPY;
    }

    public b s(@Nullable Drawable drawable) {
        this.oPZ = drawable;
        return this;
    }

    public b OM(int i) {
        this.oPZ = this.mResources.getDrawable(i);
        return this;
    }

    @Nullable
    public Drawable emg() {
        return this.oPZ;
    }

    public b c(@Nullable p.b bVar) {
        this.oQa = bVar;
        return this;
    }

    @Nullable
    public p.b emh() {
        return this.oQa;
    }

    public b t(@Nullable Drawable drawable) {
        this.oQb = drawable;
        return this;
    }

    @Nullable
    public Drawable emi() {
        return this.oQb;
    }

    public b d(@Nullable p.b bVar) {
        this.oQc = bVar;
        return this;
    }

    @Nullable
    public p.b emj() {
        return this.oQc;
    }

    public b u(@Nullable Drawable drawable) {
        this.oQd = drawable;
        return this;
    }

    @Nullable
    public Drawable emk() {
        return this.oQd;
    }

    public b e(@Nullable p.b bVar) {
        this.oQe = bVar;
        return this;
    }

    @Nullable
    public p.b eml() {
        return this.oQe;
    }

    public b v(@Nullable Drawable drawable) {
        this.oQf = drawable;
        return this;
    }

    @Nullable
    public Drawable emm() {
        return this.oQf;
    }

    public b f(@Nullable p.b bVar) {
        this.oQg = bVar;
        return this;
    }

    @Nullable
    public p.b emn() {
        return this.oQg;
    }

    public b g(@Nullable p.b bVar) {
        this.oQh = bVar;
        this.oQi = null;
        return this;
    }

    @Nullable
    public p.b emo() {
        return this.oQh;
    }

    @Nullable
    public PointF emp() {
        return this.oQj;
    }

    @Nullable
    public ColorFilter emq() {
        return this.oQk;
    }

    public b w(@Nullable Drawable drawable) {
        this.mBackground = drawable;
        return this;
    }

    @Nullable
    public Drawable getBackground() {
        return this.mBackground;
    }

    public b x(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.oQl = null;
        } else {
            this.oQl = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> getOverlays() {
        return this.oQl;
    }

    public b y(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.oQm = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.oQm = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable emr() {
        return this.oQm;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.oPQ = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams emc() {
        return this.oPQ;
    }

    private void validate() {
        if (this.oQl != null) {
            for (Drawable drawable : this.oQl) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a ems() {
        validate();
        return new a(this);
    }
}
