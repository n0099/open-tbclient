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
    public static final n.b kgU = n.b.kgL;
    public static final n.b kgV = n.b.kgM;
    private RoundingParams kgQ;
    private int kgW;
    private float kgX;
    private Drawable kgY;
    @Nullable
    private n.b kgZ;
    private Drawable kha;
    private n.b khb;
    private Drawable khc;
    private n.b khd;
    private Drawable khe;
    private n.b khf;
    private n.b khg;
    private Matrix khh;
    private PointF khi;
    private ColorFilter khj;
    private List<Drawable> khk;
    private Drawable khl;
    private Drawable mBackground;
    private Resources mResources;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.kgW = 300;
        this.kgX = 0.0f;
        this.kgY = null;
        this.kgZ = kgU;
        this.kha = null;
        this.khb = kgU;
        this.khc = null;
        this.khd = kgU;
        this.khe = null;
        this.khf = kgU;
        this.khg = kgV;
        this.khh = null;
        this.khi = null;
        this.khj = null;
        this.mBackground = null;
        this.khk = null;
        this.khl = null;
        this.kgQ = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b DQ(int i) {
        this.kgW = i;
        return this;
    }

    public int cHI() {
        return this.kgW;
    }

    public b bc(float f) {
        this.kgX = f;
        return this;
    }

    public float cHJ() {
        return this.kgX;
    }

    public b m(@Nullable Drawable drawable) {
        this.kgY = drawable;
        return this;
    }

    @Nullable
    public Drawable cHK() {
        return this.kgY;
    }

    public b c(@Nullable n.b bVar) {
        this.kgZ = bVar;
        return this;
    }

    @Nullable
    public n.b cHL() {
        return this.kgZ;
    }

    public b n(@Nullable Drawable drawable) {
        this.kha = drawable;
        return this;
    }

    @Nullable
    public Drawable cHM() {
        return this.kha;
    }

    public b d(@Nullable n.b bVar) {
        this.khb = bVar;
        return this;
    }

    @Nullable
    public n.b cHN() {
        return this.khb;
    }

    public b o(@Nullable Drawable drawable) {
        this.khc = drawable;
        return this;
    }

    @Nullable
    public Drawable cHO() {
        return this.khc;
    }

    public b e(@Nullable n.b bVar) {
        this.khd = bVar;
        return this;
    }

    @Nullable
    public n.b cHP() {
        return this.khd;
    }

    public b p(@Nullable Drawable drawable) {
        this.khe = drawable;
        return this;
    }

    @Nullable
    public Drawable cHQ() {
        return this.khe;
    }

    public b f(@Nullable n.b bVar) {
        this.khf = bVar;
        return this;
    }

    @Nullable
    public n.b cHR() {
        return this.khf;
    }

    public b g(@Nullable n.b bVar) {
        this.khg = bVar;
        this.khh = null;
        return this;
    }

    @Nullable
    public n.b cHS() {
        return this.khg;
    }

    @Nullable
    public Matrix cHT() {
        return this.khh;
    }

    @Nullable
    public PointF cHU() {
        return this.khi;
    }

    @Nullable
    public ColorFilter cHV() {
        return this.khj;
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
            this.khk = null;
        } else {
            this.khk = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> cHW() {
        return this.khk;
    }

    public b s(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.khl = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.khl = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable cHX() {
        return this.khl;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.kgQ = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams cHY() {
        return this.kgQ;
    }

    private void validate() {
        if (this.khk != null) {
            for (Drawable drawable : this.khk) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a cHZ() {
        validate();
        return new a(this);
    }
}
