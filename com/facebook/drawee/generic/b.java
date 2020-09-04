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
    public static final p.b npR = p.b.npH;
    public static final p.b npS = p.b.npI;
    private Drawable mBackground;
    private Resources mResources;
    private RoundingParams npN;
    private int npT;
    private boolean npU;
    private float npV;
    private Drawable npW;
    @Nullable
    private p.b npX;
    private Drawable npY;
    private p.b npZ;
    private Drawable nqa;
    private p.b nqb;
    private Drawable nqc;
    private p.b nqd;
    private p.b nqe;
    private Matrix nqf;
    private PointF nqg;
    private ColorFilter nqh;
    private List<Drawable> nqi;
    private Drawable nqj;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.npT = 150;
        this.npU = true;
        this.npV = 0.0f;
        this.npW = null;
        this.npX = npR;
        this.npY = null;
        this.npZ = npR;
        this.nqa = null;
        this.nqb = npR;
        this.nqc = null;
        this.nqd = npR;
        this.nqe = npS;
        this.nqf = null;
        this.nqg = null;
        this.nqh = null;
        this.mBackground = null;
        this.nqi = null;
        this.nqj = null;
        this.npN = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b Lo(int i) {
        this.npT = i;
        return this;
    }

    public int dQH() {
        return this.npT;
    }

    public boolean dQI() {
        return this.npU;
    }

    public b aN(float f) {
        this.npV = f;
        return this;
    }

    public float dQJ() {
        return this.npV;
    }

    public b n(@Nullable Drawable drawable) {
        this.npW = drawable;
        return this;
    }

    public b Lp(int i) {
        this.npW = this.mResources.getDrawable(i);
        return this;
    }

    @Nullable
    public Drawable dQK() {
        return this.npW;
    }

    public b c(@Nullable p.b bVar) {
        this.npX = bVar;
        return this;
    }

    @Nullable
    public p.b dQL() {
        return this.npX;
    }

    public b o(@Nullable Drawable drawable) {
        this.npY = drawable;
        return this;
    }

    @Nullable
    public Drawable dQM() {
        return this.npY;
    }

    public b d(@Nullable p.b bVar) {
        this.npZ = bVar;
        return this;
    }

    @Nullable
    public p.b dQN() {
        return this.npZ;
    }

    public b p(@Nullable Drawable drawable) {
        this.nqa = drawable;
        return this;
    }

    @Nullable
    public Drawable dQO() {
        return this.nqa;
    }

    public b e(@Nullable p.b bVar) {
        this.nqb = bVar;
        return this;
    }

    @Nullable
    public p.b dQP() {
        return this.nqb;
    }

    public b q(@Nullable Drawable drawable) {
        this.nqc = drawable;
        return this;
    }

    @Nullable
    public Drawable dQQ() {
        return this.nqc;
    }

    public b f(@Nullable p.b bVar) {
        this.nqd = bVar;
        return this;
    }

    @Nullable
    public p.b dQR() {
        return this.nqd;
    }

    public b g(@Nullable p.b bVar) {
        this.nqe = bVar;
        this.nqf = null;
        return this;
    }

    @Nullable
    public p.b dQS() {
        return this.nqe;
    }

    @Nullable
    public PointF dQT() {
        return this.nqg;
    }

    @Nullable
    public ColorFilter dQU() {
        return this.nqh;
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
            this.nqi = null;
        } else {
            this.nqi = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> getOverlays() {
        return this.nqi;
    }

    public b t(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.nqj = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.nqj = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable dQV() {
        return this.nqj;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.npN = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams dQG() {
        return this.npN;
    }

    private void validate() {
        if (this.nqi != null) {
            for (Drawable drawable : this.nqi) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a dQW() {
        validate();
        return new a(this);
    }
}
