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
/* loaded from: classes13.dex */
public class b {
    public static final p.b mrx = p.b.mrn;
    public static final p.b mry = p.b.mro;
    private Drawable mBackground;
    private Resources mResources;
    private boolean mrA;
    private float mrB;
    private Drawable mrC;
    @Nullable
    private p.b mrD;
    private Drawable mrE;
    private p.b mrF;
    private Drawable mrG;
    private p.b mrH;
    private Drawable mrI;
    private p.b mrJ;
    private p.b mrK;
    private Matrix mrL;
    private PointF mrM;
    private ColorFilter mrN;
    private List<Drawable> mrO;
    private Drawable mrP;
    private RoundingParams mrt;
    private int mrz;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.mrz = 150;
        this.mrA = true;
        this.mrB = 0.0f;
        this.mrC = null;
        this.mrD = mrx;
        this.mrE = null;
        this.mrF = mrx;
        this.mrG = null;
        this.mrH = mrx;
        this.mrI = null;
        this.mrJ = mrx;
        this.mrK = mry;
        this.mrL = null;
        this.mrM = null;
        this.mrN = null;
        this.mBackground = null;
        this.mrO = null;
        this.mrP = null;
        this.mrt = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b Hi(int i) {
        this.mrz = i;
        return this;
    }

    public int dwE() {
        return this.mrz;
    }

    public boolean dwF() {
        return this.mrA;
    }

    public b aC(float f) {
        this.mrB = f;
        return this;
    }

    public float dwG() {
        return this.mrB;
    }

    public b n(@Nullable Drawable drawable) {
        this.mrC = drawable;
        return this;
    }

    public b Hj(int i) {
        this.mrC = this.mResources.getDrawable(i);
        return this;
    }

    @Nullable
    public Drawable dwH() {
        return this.mrC;
    }

    public b c(@Nullable p.b bVar) {
        this.mrD = bVar;
        return this;
    }

    @Nullable
    public p.b dwI() {
        return this.mrD;
    }

    public b o(@Nullable Drawable drawable) {
        this.mrE = drawable;
        return this;
    }

    @Nullable
    public Drawable dwJ() {
        return this.mrE;
    }

    public b d(@Nullable p.b bVar) {
        this.mrF = bVar;
        return this;
    }

    @Nullable
    public p.b dwK() {
        return this.mrF;
    }

    public b p(@Nullable Drawable drawable) {
        this.mrG = drawable;
        return this;
    }

    @Nullable
    public Drawable dwL() {
        return this.mrG;
    }

    public b e(@Nullable p.b bVar) {
        this.mrH = bVar;
        return this;
    }

    @Nullable
    public p.b dwM() {
        return this.mrH;
    }

    public b q(@Nullable Drawable drawable) {
        this.mrI = drawable;
        return this;
    }

    @Nullable
    public Drawable dwN() {
        return this.mrI;
    }

    public b f(@Nullable p.b bVar) {
        this.mrJ = bVar;
        return this;
    }

    @Nullable
    public p.b dwO() {
        return this.mrJ;
    }

    public b g(@Nullable p.b bVar) {
        this.mrK = bVar;
        this.mrL = null;
        return this;
    }

    @Nullable
    public p.b dwP() {
        return this.mrK;
    }

    @Nullable
    public PointF dwQ() {
        return this.mrM;
    }

    @Nullable
    public ColorFilter dwR() {
        return this.mrN;
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
            this.mrO = null;
        } else {
            this.mrO = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> dwS() {
        return this.mrO;
    }

    public b t(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.mrP = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.mrP = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable dwT() {
        return this.mrP;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.mrt = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams dwD() {
        return this.mrt;
    }

    private void validate() {
        if (this.mrO != null) {
            for (Drawable drawable : this.mrO) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a dwU() {
        validate();
        return new a(this);
    }
}
