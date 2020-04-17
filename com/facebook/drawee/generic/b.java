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
/* loaded from: classes13.dex */
public class b {
    public static final p.b lWp = p.b.lWf;
    public static final p.b lWq = p.b.lWg;
    private Drawable lWA;
    private p.b lWB;
    private p.b lWC;
    private Matrix lWD;
    private PointF lWE;
    private ColorFilter lWF;
    private List<Drawable> lWG;
    private Drawable lWH;
    private RoundingParams lWl;
    private int lWr;
    private boolean lWs;
    private float lWt;
    private Drawable lWu;
    @Nullable
    private p.b lWv;
    private Drawable lWw;
    private p.b lWx;
    private Drawable lWy;
    private p.b lWz;
    private Drawable mBackground;
    private Resources mResources;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.lWr = 150;
        this.lWs = true;
        this.lWt = 0.0f;
        this.lWu = null;
        this.lWv = lWp;
        this.lWw = null;
        this.lWx = lWp;
        this.lWy = null;
        this.lWz = lWp;
        this.lWA = null;
        this.lWB = lWp;
        this.lWC = lWq;
        this.lWD = null;
        this.lWE = null;
        this.lWF = null;
        this.mBackground = null;
        this.lWG = null;
        this.lWH = null;
        this.lWl = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b Gu(int i) {
        this.lWr = i;
        return this;
    }

    public int dpa() {
        return this.lWr;
    }

    public boolean dpb() {
        return this.lWs;
    }

    public b aD(float f) {
        this.lWt = f;
        return this;
    }

    public float dpc() {
        return this.lWt;
    }

    public b n(@Nullable Drawable drawable) {
        this.lWu = drawable;
        return this;
    }

    public b Gv(int i) {
        this.lWu = this.mResources.getDrawable(i);
        return this;
    }

    @Nullable
    public Drawable dpd() {
        return this.lWu;
    }

    public b c(@Nullable p.b bVar) {
        this.lWv = bVar;
        return this;
    }

    @Nullable
    public p.b dpe() {
        return this.lWv;
    }

    public b o(@Nullable Drawable drawable) {
        this.lWw = drawable;
        return this;
    }

    @Nullable
    public Drawable dpf() {
        return this.lWw;
    }

    public b d(@Nullable p.b bVar) {
        this.lWx = bVar;
        return this;
    }

    @Nullable
    public p.b dpg() {
        return this.lWx;
    }

    public b p(@Nullable Drawable drawable) {
        this.lWy = drawable;
        return this;
    }

    @Nullable
    public Drawable dph() {
        return this.lWy;
    }

    public b e(@Nullable p.b bVar) {
        this.lWz = bVar;
        return this;
    }

    @Nullable
    public p.b dpi() {
        return this.lWz;
    }

    public b q(@Nullable Drawable drawable) {
        this.lWA = drawable;
        return this;
    }

    @Nullable
    public Drawable dpj() {
        return this.lWA;
    }

    public b f(@Nullable p.b bVar) {
        this.lWB = bVar;
        return this;
    }

    @Nullable
    public p.b dpk() {
        return this.lWB;
    }

    public b g(@Nullable p.b bVar) {
        this.lWC = bVar;
        this.lWD = null;
        return this;
    }

    @Nullable
    public p.b dpl() {
        return this.lWC;
    }

    @Nullable
    public PointF dpm() {
        return this.lWE;
    }

    @Nullable
    public ColorFilter dpn() {
        return this.lWF;
    }

    public b r(@Nullable Drawable drawable) {
        this.mBackground = drawable;
        return this;
    }

    @Nullable
    public Drawable getBackground() {
        return this.mBackground;
    }

    public b s(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.lWG = null;
        } else {
            this.lWG = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> dpo() {
        return this.lWG;
    }

    public b t(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.lWH = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.lWH = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable dpp() {
        return this.lWH;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.lWl = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams doZ() {
        return this.lWl;
    }

    private void validate() {
        if (this.lWG != null) {
            for (Drawable drawable : this.lWG) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a dpq() {
        validate();
        return new a(this);
    }
}
