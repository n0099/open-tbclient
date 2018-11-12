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
    public static final n.b icI = n.b.icz;
    public static final n.b icJ = n.b.icA;
    private RoundingParams icE;
    private int icK;
    private float icL;
    private Drawable icM;
    @Nullable
    private n.b icN;
    private Drawable icO;
    private n.b icP;
    private Drawable icQ;
    private n.b icR;
    private Drawable icS;
    private n.b icT;
    private n.b icU;
    private Matrix icV;
    private PointF icW;
    private ColorFilter icX;
    private List<Drawable> icY;
    private Drawable icZ;
    private Drawable mBackground;
    private Resources mResources;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.icK = 300;
        this.icL = 0.0f;
        this.icM = null;
        this.icN = icI;
        this.icO = null;
        this.icP = icI;
        this.icQ = null;
        this.icR = icI;
        this.icS = null;
        this.icT = icI;
        this.icU = icJ;
        this.icV = null;
        this.icW = null;
        this.icX = null;
        this.mBackground = null;
        this.icY = null;
        this.icZ = null;
        this.icE = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b xK(int i) {
        this.icK = i;
        return this;
    }

    public int bSQ() {
        return this.icK;
    }

    public b aJ(float f) {
        this.icL = f;
        return this;
    }

    public float bSR() {
        return this.icL;
    }

    public b m(@Nullable Drawable drawable) {
        this.icM = drawable;
        return this;
    }

    @Nullable
    public Drawable bSS() {
        return this.icM;
    }

    public b c(@Nullable n.b bVar) {
        this.icN = bVar;
        return this;
    }

    @Nullable
    public n.b bST() {
        return this.icN;
    }

    public b n(@Nullable Drawable drawable) {
        this.icO = drawable;
        return this;
    }

    @Nullable
    public Drawable bSU() {
        return this.icO;
    }

    public b d(@Nullable n.b bVar) {
        this.icP = bVar;
        return this;
    }

    @Nullable
    public n.b bSV() {
        return this.icP;
    }

    public b o(@Nullable Drawable drawable) {
        this.icQ = drawable;
        return this;
    }

    @Nullable
    public Drawable bSW() {
        return this.icQ;
    }

    public b e(@Nullable n.b bVar) {
        this.icR = bVar;
        return this;
    }

    @Nullable
    public n.b bSX() {
        return this.icR;
    }

    public b p(@Nullable Drawable drawable) {
        this.icS = drawable;
        return this;
    }

    @Nullable
    public Drawable bSY() {
        return this.icS;
    }

    public b f(@Nullable n.b bVar) {
        this.icT = bVar;
        return this;
    }

    @Nullable
    public n.b bSZ() {
        return this.icT;
    }

    public b g(@Nullable n.b bVar) {
        this.icU = bVar;
        this.icV = null;
        return this;
    }

    @Nullable
    public n.b bTa() {
        return this.icU;
    }

    @Nullable
    public Matrix bTb() {
        return this.icV;
    }

    @Nullable
    public PointF bTc() {
        return this.icW;
    }

    @Nullable
    public ColorFilter bTd() {
        return this.icX;
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
            this.icY = null;
        } else {
            this.icY = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> bTe() {
        return this.icY;
    }

    public b s(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.icZ = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.icZ = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable bTf() {
        return this.icZ;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.icE = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams bTg() {
        return this.icE;
    }

    private void validate() {
        if (this.icY != null) {
            for (Drawable drawable : this.icY) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a bTh() {
        validate();
        return new a(this);
    }
}
