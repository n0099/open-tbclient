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
/* loaded from: classes9.dex */
public class b {
    public static final p.b mVH = p.b.mVx;
    public static final p.b mVI = p.b.mVy;
    private Drawable mBackground;
    private Resources mResources;
    private RoundingParams mVD;
    private int mVJ;
    private boolean mVK;
    private float mVL;
    private Drawable mVM;
    @Nullable
    private p.b mVN;
    private Drawable mVO;
    private p.b mVP;
    private Drawable mVQ;
    private p.b mVR;
    private Drawable mVS;
    private p.b mVT;
    private p.b mVU;
    private Matrix mVV;
    private PointF mVW;
    private ColorFilter mVX;
    private List<Drawable> mVY;
    private Drawable mVZ;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.mVJ = 150;
        this.mVK = true;
        this.mVL = 0.0f;
        this.mVM = null;
        this.mVN = mVH;
        this.mVO = null;
        this.mVP = mVH;
        this.mVQ = null;
        this.mVR = mVH;
        this.mVS = null;
        this.mVT = mVH;
        this.mVU = mVI;
        this.mVV = null;
        this.mVW = null;
        this.mVX = null;
        this.mBackground = null;
        this.mVY = null;
        this.mVZ = null;
        this.mVD = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b IK(int i) {
        this.mVJ = i;
        return this;
    }

    public int dEx() {
        return this.mVJ;
    }

    public boolean dEy() {
        return this.mVK;
    }

    public b aH(float f) {
        this.mVL = f;
        return this;
    }

    public float dEz() {
        return this.mVL;
    }

    public b n(@Nullable Drawable drawable) {
        this.mVM = drawable;
        return this;
    }

    public b IL(int i) {
        this.mVM = this.mResources.getDrawable(i);
        return this;
    }

    @Nullable
    public Drawable dEA() {
        return this.mVM;
    }

    public b c(@Nullable p.b bVar) {
        this.mVN = bVar;
        return this;
    }

    @Nullable
    public p.b dEB() {
        return this.mVN;
    }

    public b o(@Nullable Drawable drawable) {
        this.mVO = drawable;
        return this;
    }

    @Nullable
    public Drawable dEC() {
        return this.mVO;
    }

    public b d(@Nullable p.b bVar) {
        this.mVP = bVar;
        return this;
    }

    @Nullable
    public p.b dED() {
        return this.mVP;
    }

    public b p(@Nullable Drawable drawable) {
        this.mVQ = drawable;
        return this;
    }

    @Nullable
    public Drawable dEE() {
        return this.mVQ;
    }

    public b e(@Nullable p.b bVar) {
        this.mVR = bVar;
        return this;
    }

    @Nullable
    public p.b dEF() {
        return this.mVR;
    }

    public b q(@Nullable Drawable drawable) {
        this.mVS = drawable;
        return this;
    }

    @Nullable
    public Drawable dEG() {
        return this.mVS;
    }

    public b f(@Nullable p.b bVar) {
        this.mVT = bVar;
        return this;
    }

    @Nullable
    public p.b dEH() {
        return this.mVT;
    }

    public b g(@Nullable p.b bVar) {
        this.mVU = bVar;
        this.mVV = null;
        return this;
    }

    @Nullable
    public p.b dEI() {
        return this.mVU;
    }

    @Nullable
    public PointF dEJ() {
        return this.mVW;
    }

    @Nullable
    public ColorFilter dEK() {
        return this.mVX;
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
            this.mVY = null;
        } else {
            this.mVY = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> dEL() {
        return this.mVY;
    }

    public b t(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.mVZ = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.mVZ = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable dEM() {
        return this.mVZ;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.mVD = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams dEw() {
        return this.mVD;
    }

    private void validate() {
        if (this.mVY != null) {
            for (Drawable drawable : this.mVY) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a dEN() {
        validate();
        return new a(this);
    }
}
