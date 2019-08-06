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
    public static final n.b kew = n.b.ken;
    public static final n.b kex = n.b.keo;
    private float keA;
    private Drawable keB;
    @Nullable
    private n.b keC;
    private Drawable keD;
    private n.b keE;
    private Drawable keF;
    private n.b keG;
    private Drawable keH;
    private n.b keI;
    private n.b keJ;
    private Matrix keK;
    private PointF keL;
    private ColorFilter keM;
    private List<Drawable> keN;
    private Drawable keO;
    private RoundingParams kes;
    private int kez;
    private Drawable mBackground;
    private Resources mResources;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.kez = 300;
        this.keA = 0.0f;
        this.keB = null;
        this.keC = kew;
        this.keD = null;
        this.keE = kew;
        this.keF = null;
        this.keG = kew;
        this.keH = null;
        this.keI = kew;
        this.keJ = kex;
        this.keK = null;
        this.keL = null;
        this.keM = null;
        this.mBackground = null;
        this.keN = null;
        this.keO = null;
        this.kes = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b DM(int i) {
        this.kez = i;
        return this;
    }

    public int cGU() {
        return this.kez;
    }

    public b bb(float f) {
        this.keA = f;
        return this;
    }

    public float cGV() {
        return this.keA;
    }

    public b m(@Nullable Drawable drawable) {
        this.keB = drawable;
        return this;
    }

    @Nullable
    public Drawable cGW() {
        return this.keB;
    }

    public b c(@Nullable n.b bVar) {
        this.keC = bVar;
        return this;
    }

    @Nullable
    public n.b cGX() {
        return this.keC;
    }

    public b n(@Nullable Drawable drawable) {
        this.keD = drawable;
        return this;
    }

    @Nullable
    public Drawable cGY() {
        return this.keD;
    }

    public b d(@Nullable n.b bVar) {
        this.keE = bVar;
        return this;
    }

    @Nullable
    public n.b cGZ() {
        return this.keE;
    }

    public b o(@Nullable Drawable drawable) {
        this.keF = drawable;
        return this;
    }

    @Nullable
    public Drawable cHa() {
        return this.keF;
    }

    public b e(@Nullable n.b bVar) {
        this.keG = bVar;
        return this;
    }

    @Nullable
    public n.b cHb() {
        return this.keG;
    }

    public b p(@Nullable Drawable drawable) {
        this.keH = drawable;
        return this;
    }

    @Nullable
    public Drawable cHc() {
        return this.keH;
    }

    public b f(@Nullable n.b bVar) {
        this.keI = bVar;
        return this;
    }

    @Nullable
    public n.b cHd() {
        return this.keI;
    }

    public b g(@Nullable n.b bVar) {
        this.keJ = bVar;
        this.keK = null;
        return this;
    }

    @Nullable
    public n.b cHe() {
        return this.keJ;
    }

    @Nullable
    public Matrix cHf() {
        return this.keK;
    }

    @Nullable
    public PointF cHg() {
        return this.keL;
    }

    @Nullable
    public ColorFilter cHh() {
        return this.keM;
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
            this.keN = null;
        } else {
            this.keN = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> cHi() {
        return this.keN;
    }

    public b s(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.keO = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.keO = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable cHj() {
        return this.keO;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.kes = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams cHk() {
        return this.kes;
    }

    private void validate() {
        if (this.keN != null) {
            for (Drawable drawable : this.keN) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a cHl() {
        validate();
        return new a(this);
    }
}
