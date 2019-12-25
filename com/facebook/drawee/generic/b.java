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
/* loaded from: classes11.dex */
public class b {
    public static final p.b lIR = p.b.lIH;
    public static final p.b lIS = p.b.lII;
    private RoundingParams lIN;
    private int lIT;
    private boolean lIU;
    private float lIV;
    private Drawable lIW;
    @Nullable
    private p.b lIX;
    private Drawable lIY;
    private p.b lIZ;
    private Drawable lJa;
    private p.b lJb;
    private Drawable lJc;
    private p.b lJd;
    private p.b lJe;
    private Matrix lJf;
    private PointF lJg;
    private ColorFilter lJh;
    private List<Drawable> lJi;
    private Drawable lJj;
    private Drawable mBackground;
    private Resources mResources;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.lIT = 150;
        this.lIU = true;
        this.lIV = 0.0f;
        this.lIW = null;
        this.lIX = lIR;
        this.lIY = null;
        this.lIZ = lIR;
        this.lJa = null;
        this.lJb = lIR;
        this.lJc = null;
        this.lJd = lIR;
        this.lJe = lIS;
        this.lJf = null;
        this.lJg = null;
        this.lJh = null;
        this.mBackground = null;
        this.lJi = null;
        this.lJj = null;
        this.lIN = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b HB(int i) {
        this.lIT = i;
        return this;
    }

    public int dkq() {
        return this.lIT;
    }

    public boolean dkr() {
        return this.lIU;
    }

    public b bp(float f) {
        this.lIV = f;
        return this;
    }

    public float dks() {
        return this.lIV;
    }

    public b r(@Nullable Drawable drawable) {
        this.lIW = drawable;
        return this;
    }

    @Nullable
    public Drawable dkt() {
        return this.lIW;
    }

    public b c(@Nullable p.b bVar) {
        this.lIX = bVar;
        return this;
    }

    @Nullable
    public p.b dku() {
        return this.lIX;
    }

    public b s(@Nullable Drawable drawable) {
        this.lIY = drawable;
        return this;
    }

    @Nullable
    public Drawable dkv() {
        return this.lIY;
    }

    public b d(@Nullable p.b bVar) {
        this.lIZ = bVar;
        return this;
    }

    @Nullable
    public p.b dkw() {
        return this.lIZ;
    }

    public b t(@Nullable Drawable drawable) {
        this.lJa = drawable;
        return this;
    }

    @Nullable
    public Drawable dkx() {
        return this.lJa;
    }

    public b e(@Nullable p.b bVar) {
        this.lJb = bVar;
        return this;
    }

    @Nullable
    public p.b dky() {
        return this.lJb;
    }

    public b u(@Nullable Drawable drawable) {
        this.lJc = drawable;
        return this;
    }

    @Nullable
    public Drawable dkz() {
        return this.lJc;
    }

    public b f(@Nullable p.b bVar) {
        this.lJd = bVar;
        return this;
    }

    @Nullable
    public p.b dkA() {
        return this.lJd;
    }

    public b g(@Nullable p.b bVar) {
        this.lJe = bVar;
        this.lJf = null;
        return this;
    }

    @Nullable
    public p.b dkB() {
        return this.lJe;
    }

    @Nullable
    public PointF dkC() {
        return this.lJg;
    }

    @Nullable
    public ColorFilter dkD() {
        return this.lJh;
    }

    public b v(@Nullable Drawable drawable) {
        this.mBackground = drawable;
        return this;
    }

    @Nullable
    public Drawable getBackground() {
        return this.mBackground;
    }

    public b w(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.lJi = null;
        } else {
            this.lJi = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> dkE() {
        return this.lJi;
    }

    public b x(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.lJj = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.lJj = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable dkF() {
        return this.lJj;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.lIN = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams dkG() {
        return this.lIN;
    }

    private void validate() {
        if (this.lJi != null) {
            for (Drawable drawable : this.lJi) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a dkH() {
        validate();
        return new a(this);
    }
}
