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
    public static final n.b ijV = n.b.ijM;
    public static final n.b ijW = n.b.ijN;
    private RoundingParams ijR;
    private int ijX;
    private float ijY;
    private Drawable ijZ;
    @Nullable
    private n.b ika;
    private Drawable ikb;
    private n.b ikc;
    private Drawable ikd;
    private n.b ike;
    private Drawable ikf;
    private n.b ikg;
    private n.b ikh;
    private Matrix iki;
    private PointF ikj;
    private ColorFilter ikk;
    private List<Drawable> ikl;
    private Drawable ikm;
    private Drawable mBackground;
    private Resources mResources;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.ijX = 300;
        this.ijY = 0.0f;
        this.ijZ = null;
        this.ika = ijV;
        this.ikb = null;
        this.ikc = ijV;
        this.ikd = null;
        this.ike = ijV;
        this.ikf = null;
        this.ikg = ijV;
        this.ikh = ijW;
        this.iki = null;
        this.ikj = null;
        this.ikk = null;
        this.mBackground = null;
        this.ikl = null;
        this.ikm = null;
        this.ijR = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b yh(int i) {
        this.ijX = i;
        return this;
    }

    public int bUV() {
        return this.ijX;
    }

    public b aJ(float f) {
        this.ijY = f;
        return this;
    }

    public float bUW() {
        return this.ijY;
    }

    public b m(@Nullable Drawable drawable) {
        this.ijZ = drawable;
        return this;
    }

    @Nullable
    public Drawable bUX() {
        return this.ijZ;
    }

    public b c(@Nullable n.b bVar) {
        this.ika = bVar;
        return this;
    }

    @Nullable
    public n.b bUY() {
        return this.ika;
    }

    public b n(@Nullable Drawable drawable) {
        this.ikb = drawable;
        return this;
    }

    @Nullable
    public Drawable bUZ() {
        return this.ikb;
    }

    public b d(@Nullable n.b bVar) {
        this.ikc = bVar;
        return this;
    }

    @Nullable
    public n.b bVa() {
        return this.ikc;
    }

    public b o(@Nullable Drawable drawable) {
        this.ikd = drawable;
        return this;
    }

    @Nullable
    public Drawable bVb() {
        return this.ikd;
    }

    public b e(@Nullable n.b bVar) {
        this.ike = bVar;
        return this;
    }

    @Nullable
    public n.b bVc() {
        return this.ike;
    }

    public b p(@Nullable Drawable drawable) {
        this.ikf = drawable;
        return this;
    }

    @Nullable
    public Drawable bVd() {
        return this.ikf;
    }

    public b f(@Nullable n.b bVar) {
        this.ikg = bVar;
        return this;
    }

    @Nullable
    public n.b bVe() {
        return this.ikg;
    }

    public b g(@Nullable n.b bVar) {
        this.ikh = bVar;
        this.iki = null;
        return this;
    }

    @Nullable
    public n.b bVf() {
        return this.ikh;
    }

    @Nullable
    public Matrix bVg() {
        return this.iki;
    }

    @Nullable
    public PointF bVh() {
        return this.ikj;
    }

    @Nullable
    public ColorFilter bVi() {
        return this.ikk;
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
            this.ikl = null;
        } else {
            this.ikl = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> bVj() {
        return this.ikl;
    }

    public b s(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.ikm = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.ikm = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable bVk() {
        return this.ikm;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.ijR = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams bVl() {
        return this.ijR;
    }

    private void validate() {
        if (this.ikl != null) {
            for (Drawable drawable : this.ikl) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a bVm() {
        validate();
        return new a(this);
    }
}
