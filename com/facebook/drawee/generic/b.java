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
    public static final n.b iaY = n.b.iaP;
    public static final n.b iaZ = n.b.iaQ;
    private RoundingParams iaU;
    private int iba;
    private float ibb;
    private Drawable ibc;
    @Nullable
    private n.b ibd;
    private Drawable ibe;
    private n.b ibf;
    private Drawable ibg;
    private n.b ibh;
    private Drawable ibi;
    private n.b ibj;
    private n.b ibk;
    private Matrix ibl;
    private PointF ibm;
    private ColorFilter ibn;
    private List<Drawable> ibo;
    private Drawable ibp;
    private Drawable mBackground;
    private Resources mResources;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.iba = 300;
        this.ibb = 0.0f;
        this.ibc = null;
        this.ibd = iaY;
        this.ibe = null;
        this.ibf = iaY;
        this.ibg = null;
        this.ibh = iaY;
        this.ibi = null;
        this.ibj = iaY;
        this.ibk = iaZ;
        this.ibl = null;
        this.ibm = null;
        this.ibn = null;
        this.mBackground = null;
        this.ibo = null;
        this.ibp = null;
        this.iaU = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b xr(int i) {
        this.iba = i;
        return this;
    }

    public int bTv() {
        return this.iba;
    }

    public b aH(float f) {
        this.ibb = f;
        return this;
    }

    public float bTw() {
        return this.ibb;
    }

    public b m(@Nullable Drawable drawable) {
        this.ibc = drawable;
        return this;
    }

    @Nullable
    public Drawable bTx() {
        return this.ibc;
    }

    public b c(@Nullable n.b bVar) {
        this.ibd = bVar;
        return this;
    }

    @Nullable
    public n.b bTy() {
        return this.ibd;
    }

    public b n(@Nullable Drawable drawable) {
        this.ibe = drawable;
        return this;
    }

    @Nullable
    public Drawable bTz() {
        return this.ibe;
    }

    public b d(@Nullable n.b bVar) {
        this.ibf = bVar;
        return this;
    }

    @Nullable
    public n.b bTA() {
        return this.ibf;
    }

    public b o(@Nullable Drawable drawable) {
        this.ibg = drawable;
        return this;
    }

    @Nullable
    public Drawable bTB() {
        return this.ibg;
    }

    public b e(@Nullable n.b bVar) {
        this.ibh = bVar;
        return this;
    }

    @Nullable
    public n.b bTC() {
        return this.ibh;
    }

    public b p(@Nullable Drawable drawable) {
        this.ibi = drawable;
        return this;
    }

    @Nullable
    public Drawable bTD() {
        return this.ibi;
    }

    public b f(@Nullable n.b bVar) {
        this.ibj = bVar;
        return this;
    }

    @Nullable
    public n.b bTE() {
        return this.ibj;
    }

    public b g(@Nullable n.b bVar) {
        this.ibk = bVar;
        this.ibl = null;
        return this;
    }

    @Nullable
    public n.b bTF() {
        return this.ibk;
    }

    @Nullable
    public Matrix bTG() {
        return this.ibl;
    }

    @Nullable
    public PointF bTH() {
        return this.ibm;
    }

    @Nullable
    public ColorFilter bTI() {
        return this.ibn;
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
            this.ibo = null;
        } else {
            this.ibo = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> bTJ() {
        return this.ibo;
    }

    public b s(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.ibp = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.ibp = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable bTK() {
        return this.ibp;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.iaU = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams bTL() {
        return this.iaU;
    }

    private void validate() {
        if (this.ibo != null) {
            for (Drawable drawable : this.ibo) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a bTM() {
        validate();
        return new a(this);
    }
}
