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
    public static final p.b lWt = p.b.lWj;
    public static final p.b lWu = p.b.lWk;
    private Drawable lWA;
    private p.b lWB;
    private Drawable lWC;
    private p.b lWD;
    private Drawable lWE;
    private p.b lWF;
    private p.b lWG;
    private Matrix lWH;
    private PointF lWI;
    private ColorFilter lWJ;
    private List<Drawable> lWK;
    private Drawable lWL;
    private RoundingParams lWp;
    private int lWv;
    private boolean lWw;
    private float lWx;
    private Drawable lWy;
    @Nullable
    private p.b lWz;
    private Drawable mBackground;
    private Resources mResources;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.lWv = 150;
        this.lWw = true;
        this.lWx = 0.0f;
        this.lWy = null;
        this.lWz = lWt;
        this.lWA = null;
        this.lWB = lWt;
        this.lWC = null;
        this.lWD = lWt;
        this.lWE = null;
        this.lWF = lWt;
        this.lWG = lWu;
        this.lWH = null;
        this.lWI = null;
        this.lWJ = null;
        this.mBackground = null;
        this.lWK = null;
        this.lWL = null;
        this.lWp = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b Gu(int i) {
        this.lWv = i;
        return this;
    }

    public int doY() {
        return this.lWv;
    }

    public boolean doZ() {
        return this.lWw;
    }

    public b aD(float f) {
        this.lWx = f;
        return this;
    }

    public float dpa() {
        return this.lWx;
    }

    public b n(@Nullable Drawable drawable) {
        this.lWy = drawable;
        return this;
    }

    public b Gv(int i) {
        this.lWy = this.mResources.getDrawable(i);
        return this;
    }

    @Nullable
    public Drawable dpb() {
        return this.lWy;
    }

    public b c(@Nullable p.b bVar) {
        this.lWz = bVar;
        return this;
    }

    @Nullable
    public p.b dpc() {
        return this.lWz;
    }

    public b o(@Nullable Drawable drawable) {
        this.lWA = drawable;
        return this;
    }

    @Nullable
    public Drawable dpd() {
        return this.lWA;
    }

    public b d(@Nullable p.b bVar) {
        this.lWB = bVar;
        return this;
    }

    @Nullable
    public p.b dpe() {
        return this.lWB;
    }

    public b p(@Nullable Drawable drawable) {
        this.lWC = drawable;
        return this;
    }

    @Nullable
    public Drawable dpf() {
        return this.lWC;
    }

    public b e(@Nullable p.b bVar) {
        this.lWD = bVar;
        return this;
    }

    @Nullable
    public p.b dpg() {
        return this.lWD;
    }

    public b q(@Nullable Drawable drawable) {
        this.lWE = drawable;
        return this;
    }

    @Nullable
    public Drawable dph() {
        return this.lWE;
    }

    public b f(@Nullable p.b bVar) {
        this.lWF = bVar;
        return this;
    }

    @Nullable
    public p.b dpi() {
        return this.lWF;
    }

    public b g(@Nullable p.b bVar) {
        this.lWG = bVar;
        this.lWH = null;
        return this;
    }

    @Nullable
    public p.b dpj() {
        return this.lWG;
    }

    @Nullable
    public PointF dpk() {
        return this.lWI;
    }

    @Nullable
    public ColorFilter dpl() {
        return this.lWJ;
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
            this.lWK = null;
        } else {
            this.lWK = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> dpm() {
        return this.lWK;
    }

    public b t(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.lWL = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.lWL = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable dpn() {
        return this.lWL;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.lWp = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams doX() {
        return this.lWp;
    }

    private void validate() {
        if (this.lWK != null) {
            for (Drawable drawable : this.lWK) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a dpo() {
        validate();
        return new a(this);
    }
}
