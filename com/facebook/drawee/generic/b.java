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
    public static final n.b iop = n.b.iog;
    public static final n.b ioq = n.b.ioh;
    private n.b ioA;
    private n.b ioB;
    private Matrix ioC;
    private PointF ioD;
    private ColorFilter ioE;
    private List<Drawable> ioF;
    private Drawable ioG;
    private RoundingParams iol;
    private int ior;
    private float ios;
    private Drawable iot;
    @Nullable
    private n.b iou;
    private Drawable iov;
    private n.b iow;
    private Drawable iox;
    private n.b ioy;
    private Drawable ioz;
    private Drawable mBackground;
    private Resources mResources;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.ior = 300;
        this.ios = 0.0f;
        this.iot = null;
        this.iou = iop;
        this.iov = null;
        this.iow = iop;
        this.iox = null;
        this.ioy = iop;
        this.ioz = null;
        this.ioA = iop;
        this.ioB = ioq;
        this.ioC = null;
        this.ioD = null;
        this.ioE = null;
        this.mBackground = null;
        this.ioF = null;
        this.ioG = null;
        this.iol = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b yw(int i) {
        this.ior = i;
        return this;
    }

    public int bWu() {
        return this.ior;
    }

    public b aJ(float f) {
        this.ios = f;
        return this;
    }

    public float bWv() {
        return this.ios;
    }

    public b m(@Nullable Drawable drawable) {
        this.iot = drawable;
        return this;
    }

    @Nullable
    public Drawable bWw() {
        return this.iot;
    }

    public b c(@Nullable n.b bVar) {
        this.iou = bVar;
        return this;
    }

    @Nullable
    public n.b bWx() {
        return this.iou;
    }

    public b n(@Nullable Drawable drawable) {
        this.iov = drawable;
        return this;
    }

    @Nullable
    public Drawable bWy() {
        return this.iov;
    }

    public b d(@Nullable n.b bVar) {
        this.iow = bVar;
        return this;
    }

    @Nullable
    public n.b bWz() {
        return this.iow;
    }

    public b o(@Nullable Drawable drawable) {
        this.iox = drawable;
        return this;
    }

    @Nullable
    public Drawable bWA() {
        return this.iox;
    }

    public b e(@Nullable n.b bVar) {
        this.ioy = bVar;
        return this;
    }

    @Nullable
    public n.b bWB() {
        return this.ioy;
    }

    public b p(@Nullable Drawable drawable) {
        this.ioz = drawable;
        return this;
    }

    @Nullable
    public Drawable bWC() {
        return this.ioz;
    }

    public b f(@Nullable n.b bVar) {
        this.ioA = bVar;
        return this;
    }

    @Nullable
    public n.b bWD() {
        return this.ioA;
    }

    public b g(@Nullable n.b bVar) {
        this.ioB = bVar;
        this.ioC = null;
        return this;
    }

    @Nullable
    public n.b bWE() {
        return this.ioB;
    }

    @Nullable
    public Matrix bWF() {
        return this.ioC;
    }

    @Nullable
    public PointF bWG() {
        return this.ioD;
    }

    @Nullable
    public ColorFilter bWH() {
        return this.ioE;
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
            this.ioF = null;
        } else {
            this.ioF = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> bWI() {
        return this.ioF;
    }

    public b s(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.ioG = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.ioG = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable bWJ() {
        return this.ioG;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.iol = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams bWK() {
        return this.iol;
    }

    private void validate() {
        if (this.ioF != null) {
            for (Drawable drawable : this.ioF) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a bWL() {
        validate();
        return new a(this);
    }
}
