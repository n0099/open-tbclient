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
    public static final p.b mVJ = p.b.mVz;
    public static final p.b mVK = p.b.mVA;
    private Drawable mBackground;
    private Resources mResources;
    private RoundingParams mVF;
    private int mVL;
    private boolean mVM;
    private float mVN;
    private Drawable mVO;
    @Nullable
    private p.b mVP;
    private Drawable mVQ;
    private p.b mVR;
    private Drawable mVS;
    private p.b mVT;
    private Drawable mVU;
    private p.b mVV;
    private p.b mVW;
    private Matrix mVX;
    private PointF mVY;
    private ColorFilter mVZ;
    private List<Drawable> mWa;
    private Drawable mWb;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.mVL = 150;
        this.mVM = true;
        this.mVN = 0.0f;
        this.mVO = null;
        this.mVP = mVJ;
        this.mVQ = null;
        this.mVR = mVJ;
        this.mVS = null;
        this.mVT = mVJ;
        this.mVU = null;
        this.mVV = mVJ;
        this.mVW = mVK;
        this.mVX = null;
        this.mVY = null;
        this.mVZ = null;
        this.mBackground = null;
        this.mWa = null;
        this.mWb = null;
        this.mVF = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b IK(int i) {
        this.mVL = i;
        return this;
    }

    public int dEy() {
        return this.mVL;
    }

    public boolean dEz() {
        return this.mVM;
    }

    public b aH(float f) {
        this.mVN = f;
        return this;
    }

    public float dEA() {
        return this.mVN;
    }

    public b n(@Nullable Drawable drawable) {
        this.mVO = drawable;
        return this;
    }

    public b IL(int i) {
        this.mVO = this.mResources.getDrawable(i);
        return this;
    }

    @Nullable
    public Drawable dEB() {
        return this.mVO;
    }

    public b c(@Nullable p.b bVar) {
        this.mVP = bVar;
        return this;
    }

    @Nullable
    public p.b dEC() {
        return this.mVP;
    }

    public b o(@Nullable Drawable drawable) {
        this.mVQ = drawable;
        return this;
    }

    @Nullable
    public Drawable dED() {
        return this.mVQ;
    }

    public b d(@Nullable p.b bVar) {
        this.mVR = bVar;
        return this;
    }

    @Nullable
    public p.b dEE() {
        return this.mVR;
    }

    public b p(@Nullable Drawable drawable) {
        this.mVS = drawable;
        return this;
    }

    @Nullable
    public Drawable dEF() {
        return this.mVS;
    }

    public b e(@Nullable p.b bVar) {
        this.mVT = bVar;
        return this;
    }

    @Nullable
    public p.b dEG() {
        return this.mVT;
    }

    public b q(@Nullable Drawable drawable) {
        this.mVU = drawable;
        return this;
    }

    @Nullable
    public Drawable dEH() {
        return this.mVU;
    }

    public b f(@Nullable p.b bVar) {
        this.mVV = bVar;
        return this;
    }

    @Nullable
    public p.b dEI() {
        return this.mVV;
    }

    public b g(@Nullable p.b bVar) {
        this.mVW = bVar;
        this.mVX = null;
        return this;
    }

    @Nullable
    public p.b dEJ() {
        return this.mVW;
    }

    @Nullable
    public PointF dEK() {
        return this.mVY;
    }

    @Nullable
    public ColorFilter dEL() {
        return this.mVZ;
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
            this.mWa = null;
        } else {
            this.mWa = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> dEM() {
        return this.mWa;
    }

    public b t(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.mWb = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.mWb = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable dEN() {
        return this.mWb;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.mVF = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams dEx() {
        return this.mVF;
    }

    private void validate() {
        if (this.mWa != null) {
            for (Drawable drawable : this.mWa) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a dEO() {
        validate();
        return new a(this);
    }
}
