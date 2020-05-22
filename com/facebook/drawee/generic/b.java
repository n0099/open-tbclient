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
    public static final p.b mqn = p.b.mqd;
    public static final p.b mqo = p.b.mqe;
    private Drawable mBackground;
    private Resources mResources;
    private p.b mqA;
    private Matrix mqB;
    private PointF mqC;
    private ColorFilter mqD;
    private List<Drawable> mqE;
    private Drawable mqF;
    private RoundingParams mqj;
    private int mqp;
    private boolean mqq;
    private float mqr;
    private Drawable mqs;
    @Nullable
    private p.b mqt;
    private Drawable mqu;
    private p.b mqv;
    private Drawable mqw;
    private p.b mqx;
    private Drawable mqy;
    private p.b mqz;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.mqp = 150;
        this.mqq = true;
        this.mqr = 0.0f;
        this.mqs = null;
        this.mqt = mqn;
        this.mqu = null;
        this.mqv = mqn;
        this.mqw = null;
        this.mqx = mqn;
        this.mqy = null;
        this.mqz = mqn;
        this.mqA = mqo;
        this.mqB = null;
        this.mqC = null;
        this.mqD = null;
        this.mBackground = null;
        this.mqE = null;
        this.mqF = null;
        this.mqj = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b Hg(int i) {
        this.mqp = i;
        return this;
    }

    public int dwq() {
        return this.mqp;
    }

    public boolean dwr() {
        return this.mqq;
    }

    public b aC(float f) {
        this.mqr = f;
        return this;
    }

    public float dws() {
        return this.mqr;
    }

    public b n(@Nullable Drawable drawable) {
        this.mqs = drawable;
        return this;
    }

    public b Hh(int i) {
        this.mqs = this.mResources.getDrawable(i);
        return this;
    }

    @Nullable
    public Drawable dwt() {
        return this.mqs;
    }

    public b c(@Nullable p.b bVar) {
        this.mqt = bVar;
        return this;
    }

    @Nullable
    public p.b dwu() {
        return this.mqt;
    }

    public b o(@Nullable Drawable drawable) {
        this.mqu = drawable;
        return this;
    }

    @Nullable
    public Drawable dwv() {
        return this.mqu;
    }

    public b d(@Nullable p.b bVar) {
        this.mqv = bVar;
        return this;
    }

    @Nullable
    public p.b dww() {
        return this.mqv;
    }

    public b p(@Nullable Drawable drawable) {
        this.mqw = drawable;
        return this;
    }

    @Nullable
    public Drawable dwx() {
        return this.mqw;
    }

    public b e(@Nullable p.b bVar) {
        this.mqx = bVar;
        return this;
    }

    @Nullable
    public p.b dwy() {
        return this.mqx;
    }

    public b q(@Nullable Drawable drawable) {
        this.mqy = drawable;
        return this;
    }

    @Nullable
    public Drawable dwz() {
        return this.mqy;
    }

    public b f(@Nullable p.b bVar) {
        this.mqz = bVar;
        return this;
    }

    @Nullable
    public p.b dwA() {
        return this.mqz;
    }

    public b g(@Nullable p.b bVar) {
        this.mqA = bVar;
        this.mqB = null;
        return this;
    }

    @Nullable
    public p.b dwB() {
        return this.mqA;
    }

    @Nullable
    public PointF dwC() {
        return this.mqC;
    }

    @Nullable
    public ColorFilter dwD() {
        return this.mqD;
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
            this.mqE = null;
        } else {
            this.mqE = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> dwE() {
        return this.mqE;
    }

    public b t(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.mqF = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.mqF = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable dwF() {
        return this.mqF;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.mqj = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams dwp() {
        return this.mqj;
    }

    private void validate() {
        if (this.mqE != null) {
            for (Drawable drawable : this.mqE) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a dwG() {
        validate();
        return new a(this);
    }
}
