package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.facebook.common.internal.g;
import com.facebook.drawee.drawable.n;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    public static final n.b ing = n.b.imX;
    public static final n.b inh = n.b.imY;
    private RoundingParams inc;
    private int ini;
    private float inj;
    private Drawable ink;
    @Nullable
    private n.b inl;
    private Drawable inm;
    private n.b inn;
    private Drawable ino;
    private n.b inp;
    private Drawable inq;
    private n.b inr;

    /* renamed from: int  reason: not valid java name */
    private n.b f1int;
    private Matrix inu;
    private PointF inv;
    private ColorFilter inw;
    private List<Drawable> inx;
    private Drawable iny;
    private Drawable mBackground;
    private Resources mResources;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.ini = 300;
        this.inj = 0.0f;
        this.ink = null;
        this.inl = ing;
        this.inm = null;
        this.inn = ing;
        this.ino = null;
        this.inp = ing;
        this.inq = null;
        this.inr = ing;
        this.f1int = inh;
        this.inu = null;
        this.inv = null;
        this.inw = null;
        this.mBackground = null;
        this.inx = null;
        this.iny = null;
        this.inc = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b yu(int i) {
        this.ini = i;
        return this;
    }

    public int bVM() {
        return this.ini;
    }

    public b aJ(float f) {
        this.inj = f;
        return this;
    }

    public float bVN() {
        return this.inj;
    }

    public b m(@Nullable Drawable drawable) {
        this.ink = drawable;
        return this;
    }

    @Nullable
    public Drawable bVO() {
        return this.ink;
    }

    public b c(@Nullable n.b bVar) {
        this.inl = bVar;
        return this;
    }

    @Nullable
    public n.b bVP() {
        return this.inl;
    }

    public b n(@Nullable Drawable drawable) {
        this.inm = drawable;
        return this;
    }

    @Nullable
    public Drawable bVQ() {
        return this.inm;
    }

    public b d(@Nullable n.b bVar) {
        this.inn = bVar;
        return this;
    }

    @Nullable
    public n.b bVR() {
        return this.inn;
    }

    public b o(@Nullable Drawable drawable) {
        this.ino = drawable;
        return this;
    }

    @Nullable
    public Drawable bVS() {
        return this.ino;
    }

    public b e(@Nullable n.b bVar) {
        this.inp = bVar;
        return this;
    }

    @Nullable
    public n.b bVT() {
        return this.inp;
    }

    public b p(@Nullable Drawable drawable) {
        this.inq = drawable;
        return this;
    }

    @Nullable
    public Drawable bVU() {
        return this.inq;
    }

    public b f(@Nullable n.b bVar) {
        this.inr = bVar;
        return this;
    }

    @Nullable
    public n.b bVV() {
        return this.inr;
    }

    public b g(@Nullable n.b bVar) {
        this.f1int = bVar;
        this.inu = null;
        return this;
    }

    @Nullable
    public n.b bVW() {
        return this.f1int;
    }

    @Nullable
    public Matrix bVX() {
        return this.inu;
    }

    @Nullable
    public PointF bVY() {
        return this.inv;
    }

    @Nullable
    public ColorFilter bVZ() {
        return this.inw;
    }

    public b q(@Nullable Drawable drawable) {
        this.mBackground = drawable;
        return this;
    }

    @Nullable
    public Drawable getBackground() {
        return this.mBackground;
    }

    public b r(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.inx = null;
        } else {
            this.inx = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> bWa() {
        return this.inx;
    }

    public b s(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.iny = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.iny = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable bWb() {
        return this.iny;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.inc = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams bWc() {
        return this.inc;
    }

    private void validate() {
        if (this.inx != null) {
            for (Drawable drawable : this.inx) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a bWd() {
        validate();
        return new a(this);
    }
}
