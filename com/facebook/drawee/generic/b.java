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
    public static final n.b ioo = n.b.iof;
    public static final n.b iop = n.b.iog;
    private n.b ioA;
    private Matrix ioB;
    private PointF ioC;
    private ColorFilter ioD;
    private List<Drawable> ioE;
    private Drawable ioF;
    private RoundingParams iok;
    private int ioq;
    private float ior;
    private Drawable ios;
    @Nullable
    private n.b iot;
    private Drawable iou;
    private n.b iov;
    private Drawable iow;
    private n.b iox;
    private Drawable ioy;
    private n.b ioz;
    private Drawable mBackground;
    private Resources mResources;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.ioq = 300;
        this.ior = 0.0f;
        this.ios = null;
        this.iot = ioo;
        this.iou = null;
        this.iov = ioo;
        this.iow = null;
        this.iox = ioo;
        this.ioy = null;
        this.ioz = ioo;
        this.ioA = iop;
        this.ioB = null;
        this.ioC = null;
        this.ioD = null;
        this.mBackground = null;
        this.ioE = null;
        this.ioF = null;
        this.iok = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b yw(int i) {
        this.ioq = i;
        return this;
    }

    public int bWu() {
        return this.ioq;
    }

    public b aJ(float f) {
        this.ior = f;
        return this;
    }

    public float bWv() {
        return this.ior;
    }

    public b m(@Nullable Drawable drawable) {
        this.ios = drawable;
        return this;
    }

    @Nullable
    public Drawable bWw() {
        return this.ios;
    }

    public b c(@Nullable n.b bVar) {
        this.iot = bVar;
        return this;
    }

    @Nullable
    public n.b bWx() {
        return this.iot;
    }

    public b n(@Nullable Drawable drawable) {
        this.iou = drawable;
        return this;
    }

    @Nullable
    public Drawable bWy() {
        return this.iou;
    }

    public b d(@Nullable n.b bVar) {
        this.iov = bVar;
        return this;
    }

    @Nullable
    public n.b bWz() {
        return this.iov;
    }

    public b o(@Nullable Drawable drawable) {
        this.iow = drawable;
        return this;
    }

    @Nullable
    public Drawable bWA() {
        return this.iow;
    }

    public b e(@Nullable n.b bVar) {
        this.iox = bVar;
        return this;
    }

    @Nullable
    public n.b bWB() {
        return this.iox;
    }

    public b p(@Nullable Drawable drawable) {
        this.ioy = drawable;
        return this;
    }

    @Nullable
    public Drawable bWC() {
        return this.ioy;
    }

    public b f(@Nullable n.b bVar) {
        this.ioz = bVar;
        return this;
    }

    @Nullable
    public n.b bWD() {
        return this.ioz;
    }

    public b g(@Nullable n.b bVar) {
        this.ioA = bVar;
        this.ioB = null;
        return this;
    }

    @Nullable
    public n.b bWE() {
        return this.ioA;
    }

    @Nullable
    public Matrix bWF() {
        return this.ioB;
    }

    @Nullable
    public PointF bWG() {
        return this.ioC;
    }

    @Nullable
    public ColorFilter bWH() {
        return this.ioD;
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
            this.ioE = null;
        } else {
            this.ioE = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> bWI() {
        return this.ioE;
    }

    public b s(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.ioF = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.ioF = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable bWJ() {
        return this.ioF;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.iok = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams bWK() {
        return this.iok;
    }

    private void validate() {
        if (this.ioE != null) {
            for (Drawable drawable : this.ioE) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a bWL() {
        validate();
        return new a(this);
    }
}
