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
    public static final n.b kel = n.b.kec;
    public static final n.b kem = n.b.ked;
    private PointF keA;
    private ColorFilter keB;
    private List<Drawable> keC;
    private Drawable keD;
    private RoundingParams keh;
    private int ken;
    private float keo;
    private Drawable kep;
    @Nullable
    private n.b keq;
    private Drawable ker;
    private n.b kes;
    private Drawable ket;
    private n.b keu;
    private Drawable kev;
    private n.b kew;
    private n.b kex;
    private Matrix kez;
    private Drawable mBackground;
    private Resources mResources;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.ken = 300;
        this.keo = 0.0f;
        this.kep = null;
        this.keq = kel;
        this.ker = null;
        this.kes = kel;
        this.ket = null;
        this.keu = kel;
        this.kev = null;
        this.kew = kel;
        this.kex = kem;
        this.kez = null;
        this.keA = null;
        this.keB = null;
        this.mBackground = null;
        this.keC = null;
        this.keD = null;
        this.keh = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b Cl(int i) {
        this.ken = i;
        return this;
    }

    public int cEE() {
        return this.ken;
    }

    public b aF(float f) {
        this.keo = f;
        return this;
    }

    public float cEF() {
        return this.keo;
    }

    public b l(@Nullable Drawable drawable) {
        this.kep = drawable;
        return this;
    }

    @Nullable
    public Drawable cEG() {
        return this.kep;
    }

    public b c(@Nullable n.b bVar) {
        this.keq = bVar;
        return this;
    }

    @Nullable
    public n.b cEH() {
        return this.keq;
    }

    public b m(@Nullable Drawable drawable) {
        this.ker = drawable;
        return this;
    }

    @Nullable
    public Drawable cEI() {
        return this.ker;
    }

    public b d(@Nullable n.b bVar) {
        this.kes = bVar;
        return this;
    }

    @Nullable
    public n.b cEJ() {
        return this.kes;
    }

    public b n(@Nullable Drawable drawable) {
        this.ket = drawable;
        return this;
    }

    @Nullable
    public Drawable cEK() {
        return this.ket;
    }

    public b e(@Nullable n.b bVar) {
        this.keu = bVar;
        return this;
    }

    @Nullable
    public n.b cEL() {
        return this.keu;
    }

    public b o(@Nullable Drawable drawable) {
        this.kev = drawable;
        return this;
    }

    @Nullable
    public Drawable cEM() {
        return this.kev;
    }

    public b f(@Nullable n.b bVar) {
        this.kew = bVar;
        return this;
    }

    @Nullable
    public n.b cEN() {
        return this.kew;
    }

    public b g(@Nullable n.b bVar) {
        this.kex = bVar;
        this.kez = null;
        return this;
    }

    @Nullable
    public n.b cEO() {
        return this.kex;
    }

    @Nullable
    public Matrix cEP() {
        return this.kez;
    }

    @Nullable
    public PointF cEQ() {
        return this.keA;
    }

    @Nullable
    public ColorFilter cER() {
        return this.keB;
    }

    public b p(@Nullable Drawable drawable) {
        this.mBackground = drawable;
        return this;
    }

    @Nullable
    public Drawable getBackground() {
        return this.mBackground;
    }

    public b q(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.keC = null;
        } else {
            this.keC = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> cES() {
        return this.keC;
    }

    public b r(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.keD = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.keD = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable cET() {
        return this.keD;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.keh = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams cEU() {
        return this.keh;
    }

    private void validate() {
        if (this.keC != null) {
            for (Drawable drawable : this.keC) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a cEV() {
        validate();
        return new a(this);
    }
}
