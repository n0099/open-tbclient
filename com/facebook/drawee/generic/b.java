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
/* loaded from: classes4.dex */
public class b {
    private Drawable mBackground;
    private Resources mResources;
    private int npB;
    private boolean npC;
    private float npD;
    private Drawable npE;
    @Nullable
    private p.b npF;
    private Drawable npG;
    private p.b npH;
    private Drawable npI;
    private p.b npJ;
    private Drawable npK;
    private p.b npL;
    private p.b npM;
    private Matrix npN;
    private PointF npO;
    private ColorFilter npP;
    private List<Drawable> npQ;
    private Drawable npR;
    private RoundingParams npv;
    public static final p.b npz = p.b.npp;
    public static final p.b npA = p.b.npq;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.npB = 150;
        this.npC = true;
        this.npD = 0.0f;
        this.npE = null;
        this.npF = npz;
        this.npG = null;
        this.npH = npz;
        this.npI = null;
        this.npJ = npz;
        this.npK = null;
        this.npL = npz;
        this.npM = npA;
        this.npN = null;
        this.npO = null;
        this.npP = null;
        this.mBackground = null;
        this.npQ = null;
        this.npR = null;
        this.npv = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b Lo(int i) {
        this.npB = i;
        return this;
    }

    public int dQy() {
        return this.npB;
    }

    public boolean dQz() {
        return this.npC;
    }

    public b aN(float f) {
        this.npD = f;
        return this;
    }

    public float dQA() {
        return this.npD;
    }

    public b n(@Nullable Drawable drawable) {
        this.npE = drawable;
        return this;
    }

    public b Lp(int i) {
        this.npE = this.mResources.getDrawable(i);
        return this;
    }

    @Nullable
    public Drawable dQB() {
        return this.npE;
    }

    public b c(@Nullable p.b bVar) {
        this.npF = bVar;
        return this;
    }

    @Nullable
    public p.b dQC() {
        return this.npF;
    }

    public b o(@Nullable Drawable drawable) {
        this.npG = drawable;
        return this;
    }

    @Nullable
    public Drawable dQD() {
        return this.npG;
    }

    public b d(@Nullable p.b bVar) {
        this.npH = bVar;
        return this;
    }

    @Nullable
    public p.b dQE() {
        return this.npH;
    }

    public b p(@Nullable Drawable drawable) {
        this.npI = drawable;
        return this;
    }

    @Nullable
    public Drawable dQF() {
        return this.npI;
    }

    public b e(@Nullable p.b bVar) {
        this.npJ = bVar;
        return this;
    }

    @Nullable
    public p.b dQG() {
        return this.npJ;
    }

    public b q(@Nullable Drawable drawable) {
        this.npK = drawable;
        return this;
    }

    @Nullable
    public Drawable dQH() {
        return this.npK;
    }

    public b f(@Nullable p.b bVar) {
        this.npL = bVar;
        return this;
    }

    @Nullable
    public p.b dQI() {
        return this.npL;
    }

    public b g(@Nullable p.b bVar) {
        this.npM = bVar;
        this.npN = null;
        return this;
    }

    @Nullable
    public p.b dQJ() {
        return this.npM;
    }

    @Nullable
    public PointF dQK() {
        return this.npO;
    }

    @Nullable
    public ColorFilter dQL() {
        return this.npP;
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
            this.npQ = null;
        } else {
            this.npQ = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> getOverlays() {
        return this.npQ;
    }

    public b t(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.npR = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.npR = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable dQM() {
        return this.npR;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.npv = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams dQx() {
        return this.npv;
    }

    private void validate() {
        if (this.npQ != null) {
            for (Drawable drawable : this.npQ) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a dQN() {
        validate();
        return new a(this);
    }
}
