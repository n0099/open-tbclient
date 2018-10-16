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
    public static final n.b iaX = n.b.iaO;
    public static final n.b iaY = n.b.iaP;
    private RoundingParams iaT;
    private int iaZ;
    private float iba;
    private Drawable ibb;
    @Nullable
    private n.b ibc;
    private Drawable ibd;
    private n.b ibe;
    private Drawable ibf;
    private n.b ibg;
    private Drawable ibh;
    private n.b ibi;
    private n.b ibj;
    private Matrix ibk;
    private PointF ibl;
    private ColorFilter ibm;
    private List<Drawable> ibn;
    private Drawable ibo;
    private Drawable mBackground;
    private Resources mResources;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.iaZ = 300;
        this.iba = 0.0f;
        this.ibb = null;
        this.ibc = iaX;
        this.ibd = null;
        this.ibe = iaX;
        this.ibf = null;
        this.ibg = iaX;
        this.ibh = null;
        this.ibi = iaX;
        this.ibj = iaY;
        this.ibk = null;
        this.ibl = null;
        this.ibm = null;
        this.mBackground = null;
        this.ibn = null;
        this.ibo = null;
        this.iaT = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b xr(int i) {
        this.iaZ = i;
        return this;
    }

    public int bTv() {
        return this.iaZ;
    }

    public b aH(float f) {
        this.iba = f;
        return this;
    }

    public float bTw() {
        return this.iba;
    }

    public b m(@Nullable Drawable drawable) {
        this.ibb = drawable;
        return this;
    }

    @Nullable
    public Drawable bTx() {
        return this.ibb;
    }

    public b c(@Nullable n.b bVar) {
        this.ibc = bVar;
        return this;
    }

    @Nullable
    public n.b bTy() {
        return this.ibc;
    }

    public b n(@Nullable Drawable drawable) {
        this.ibd = drawable;
        return this;
    }

    @Nullable
    public Drawable bTz() {
        return this.ibd;
    }

    public b d(@Nullable n.b bVar) {
        this.ibe = bVar;
        return this;
    }

    @Nullable
    public n.b bTA() {
        return this.ibe;
    }

    public b o(@Nullable Drawable drawable) {
        this.ibf = drawable;
        return this;
    }

    @Nullable
    public Drawable bTB() {
        return this.ibf;
    }

    public b e(@Nullable n.b bVar) {
        this.ibg = bVar;
        return this;
    }

    @Nullable
    public n.b bTC() {
        return this.ibg;
    }

    public b p(@Nullable Drawable drawable) {
        this.ibh = drawable;
        return this;
    }

    @Nullable
    public Drawable bTD() {
        return this.ibh;
    }

    public b f(@Nullable n.b bVar) {
        this.ibi = bVar;
        return this;
    }

    @Nullable
    public n.b bTE() {
        return this.ibi;
    }

    public b g(@Nullable n.b bVar) {
        this.ibj = bVar;
        this.ibk = null;
        return this;
    }

    @Nullable
    public n.b bTF() {
        return this.ibj;
    }

    @Nullable
    public Matrix bTG() {
        return this.ibk;
    }

    @Nullable
    public PointF bTH() {
        return this.ibl;
    }

    @Nullable
    public ColorFilter bTI() {
        return this.ibm;
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
            this.ibn = null;
        } else {
            this.ibn = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> bTJ() {
        return this.ibn;
    }

    public b s(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.ibo = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.ibo = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable bTK() {
        return this.ibo;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.iaT = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams bTL() {
        return this.iaT;
    }

    private void validate() {
        if (this.ibn != null) {
            for (Drawable drawable : this.ibn) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a bTM() {
        validate();
        return new a(this);
    }
}
