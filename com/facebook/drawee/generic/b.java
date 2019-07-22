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
    public static final n.b kdq = n.b.kdh;
    public static final n.b kdr = n.b.kdi;
    private Drawable kdA;
    private n.b kdB;
    private n.b kdC;
    private Matrix kdD;
    private PointF kdE;
    private ColorFilter kdF;
    private List<Drawable> kdG;
    private Drawable kdH;
    private RoundingParams kdm;
    private int kds;
    private float kdt;
    private Drawable kdu;
    @Nullable
    private n.b kdv;
    private Drawable kdw;
    private n.b kdx;
    private Drawable kdy;
    private n.b kdz;
    private Drawable mBackground;
    private Resources mResources;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.kds = 300;
        this.kdt = 0.0f;
        this.kdu = null;
        this.kdv = kdq;
        this.kdw = null;
        this.kdx = kdq;
        this.kdy = null;
        this.kdz = kdq;
        this.kdA = null;
        this.kdB = kdq;
        this.kdC = kdr;
        this.kdD = null;
        this.kdE = null;
        this.kdF = null;
        this.mBackground = null;
        this.kdG = null;
        this.kdH = null;
        this.kdm = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b DK(int i) {
        this.kds = i;
        return this;
    }

    public int cGz() {
        return this.kds;
    }

    public b bb(float f) {
        this.kdt = f;
        return this;
    }

    public float cGA() {
        return this.kdt;
    }

    public b m(@Nullable Drawable drawable) {
        this.kdu = drawable;
        return this;
    }

    @Nullable
    public Drawable cGB() {
        return this.kdu;
    }

    public b c(@Nullable n.b bVar) {
        this.kdv = bVar;
        return this;
    }

    @Nullable
    public n.b cGC() {
        return this.kdv;
    }

    public b n(@Nullable Drawable drawable) {
        this.kdw = drawable;
        return this;
    }

    @Nullable
    public Drawable cGD() {
        return this.kdw;
    }

    public b d(@Nullable n.b bVar) {
        this.kdx = bVar;
        return this;
    }

    @Nullable
    public n.b cGE() {
        return this.kdx;
    }

    public b o(@Nullable Drawable drawable) {
        this.kdy = drawable;
        return this;
    }

    @Nullable
    public Drawable cGF() {
        return this.kdy;
    }

    public b e(@Nullable n.b bVar) {
        this.kdz = bVar;
        return this;
    }

    @Nullable
    public n.b cGG() {
        return this.kdz;
    }

    public b p(@Nullable Drawable drawable) {
        this.kdA = drawable;
        return this;
    }

    @Nullable
    public Drawable cGH() {
        return this.kdA;
    }

    public b f(@Nullable n.b bVar) {
        this.kdB = bVar;
        return this;
    }

    @Nullable
    public n.b cGI() {
        return this.kdB;
    }

    public b g(@Nullable n.b bVar) {
        this.kdC = bVar;
        this.kdD = null;
        return this;
    }

    @Nullable
    public n.b cGJ() {
        return this.kdC;
    }

    @Nullable
    public Matrix cGK() {
        return this.kdD;
    }

    @Nullable
    public PointF cGL() {
        return this.kdE;
    }

    @Nullable
    public ColorFilter cGM() {
        return this.kdF;
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
            this.kdG = null;
        } else {
            this.kdG = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> cGN() {
        return this.kdG;
    }

    public b s(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.kdH = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.kdH = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable cGO() {
        return this.kdH;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.kdm = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams cGP() {
        return this.kdm;
    }

    private void validate() {
        if (this.kdG != null) {
            for (Drawable drawable : this.kdG) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a cGQ() {
        validate();
        return new a(this);
    }
}
