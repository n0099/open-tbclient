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
    public static final n.b kfd = n.b.keU;
    public static final n.b kfe = n.b.keV;
    private RoundingParams keZ;
    private int kff;
    private float kfg;
    private Drawable kfh;
    @Nullable
    private n.b kfi;
    private Drawable kfj;
    private n.b kfk;
    private Drawable kfl;
    private n.b kfm;
    private Drawable kfn;
    private n.b kfo;
    private n.b kfp;
    private Matrix kfq;
    private PointF kfr;
    private ColorFilter kfs;
    private List<Drawable> kft;
    private Drawable kfu;
    private Drawable mBackground;
    private Resources mResources;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.kff = 300;
        this.kfg = 0.0f;
        this.kfh = null;
        this.kfi = kfd;
        this.kfj = null;
        this.kfk = kfd;
        this.kfl = null;
        this.kfm = kfd;
        this.kfn = null;
        this.kfo = kfd;
        this.kfp = kfe;
        this.kfq = null;
        this.kfr = null;
        this.kfs = null;
        this.mBackground = null;
        this.kft = null;
        this.kfu = null;
        this.keZ = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b Cm(int i) {
        this.kff = i;
        return this;
    }

    public int cEG() {
        return this.kff;
    }

    public b aF(float f) {
        this.kfg = f;
        return this;
    }

    public float cEH() {
        return this.kfg;
    }

    public b k(@Nullable Drawable drawable) {
        this.kfh = drawable;
        return this;
    }

    @Nullable
    public Drawable cEI() {
        return this.kfh;
    }

    public b c(@Nullable n.b bVar) {
        this.kfi = bVar;
        return this;
    }

    @Nullable
    public n.b cEJ() {
        return this.kfi;
    }

    public b l(@Nullable Drawable drawable) {
        this.kfj = drawable;
        return this;
    }

    @Nullable
    public Drawable cEK() {
        return this.kfj;
    }

    public b d(@Nullable n.b bVar) {
        this.kfk = bVar;
        return this;
    }

    @Nullable
    public n.b cEL() {
        return this.kfk;
    }

    public b m(@Nullable Drawable drawable) {
        this.kfl = drawable;
        return this;
    }

    @Nullable
    public Drawable cEM() {
        return this.kfl;
    }

    public b e(@Nullable n.b bVar) {
        this.kfm = bVar;
        return this;
    }

    @Nullable
    public n.b cEN() {
        return this.kfm;
    }

    public b n(@Nullable Drawable drawable) {
        this.kfn = drawable;
        return this;
    }

    @Nullable
    public Drawable cEO() {
        return this.kfn;
    }

    public b f(@Nullable n.b bVar) {
        this.kfo = bVar;
        return this;
    }

    @Nullable
    public n.b cEP() {
        return this.kfo;
    }

    public b g(@Nullable n.b bVar) {
        this.kfp = bVar;
        this.kfq = null;
        return this;
    }

    @Nullable
    public n.b cEQ() {
        return this.kfp;
    }

    @Nullable
    public Matrix cER() {
        return this.kfq;
    }

    @Nullable
    public PointF cES() {
        return this.kfr;
    }

    @Nullable
    public ColorFilter cET() {
        return this.kfs;
    }

    public b o(@Nullable Drawable drawable) {
        this.mBackground = drawable;
        return this;
    }

    @Nullable
    public Drawable getBackground() {
        return this.mBackground;
    }

    public b p(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.kft = null;
        } else {
            this.kft = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> cEU() {
        return this.kft;
    }

    public b q(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.kfu = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.kfu = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable cEV() {
        return this.kfu;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.keZ = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams cEW() {
        return this.keZ;
    }

    private void validate() {
        if (this.kft != null) {
            for (Drawable drawable : this.kft) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a cEX() {
        validate();
        return new a(this);
    }
}
