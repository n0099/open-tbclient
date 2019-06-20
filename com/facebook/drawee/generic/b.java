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
    public static final n.b jWm = n.b.jWd;
    public static final n.b jWn = n.b.jWe;
    private PointF jWA;
    private ColorFilter jWB;
    private List<Drawable> jWC;
    private Drawable jWD;
    private RoundingParams jWi;
    private int jWo;
    private float jWp;
    private Drawable jWq;
    @Nullable
    private n.b jWr;
    private Drawable jWs;
    private n.b jWt;
    private Drawable jWu;
    private n.b jWv;
    private Drawable jWw;
    private n.b jWx;
    private n.b jWy;
    private Matrix jWz;
    private Drawable mBackground;
    private Resources mResources;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.jWo = 300;
        this.jWp = 0.0f;
        this.jWq = null;
        this.jWr = jWm;
        this.jWs = null;
        this.jWt = jWm;
        this.jWu = null;
        this.jWv = jWm;
        this.jWw = null;
        this.jWx = jWm;
        this.jWy = jWn;
        this.jWz = null;
        this.jWA = null;
        this.jWB = null;
        this.mBackground = null;
        this.jWC = null;
        this.jWD = null;
        this.jWi = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b Dd(int i) {
        this.jWo = i;
        return this;
    }

    public int cDw() {
        return this.jWo;
    }

    public b ba(float f) {
        this.jWp = f;
        return this;
    }

    public float cDx() {
        return this.jWp;
    }

    public b m(@Nullable Drawable drawable) {
        this.jWq = drawable;
        return this;
    }

    @Nullable
    public Drawable cDy() {
        return this.jWq;
    }

    public b c(@Nullable n.b bVar) {
        this.jWr = bVar;
        return this;
    }

    @Nullable
    public n.b cDz() {
        return this.jWr;
    }

    public b n(@Nullable Drawable drawable) {
        this.jWs = drawable;
        return this;
    }

    @Nullable
    public Drawable cDA() {
        return this.jWs;
    }

    public b d(@Nullable n.b bVar) {
        this.jWt = bVar;
        return this;
    }

    @Nullable
    public n.b cDB() {
        return this.jWt;
    }

    public b o(@Nullable Drawable drawable) {
        this.jWu = drawable;
        return this;
    }

    @Nullable
    public Drawable cDC() {
        return this.jWu;
    }

    public b e(@Nullable n.b bVar) {
        this.jWv = bVar;
        return this;
    }

    @Nullable
    public n.b cDD() {
        return this.jWv;
    }

    public b p(@Nullable Drawable drawable) {
        this.jWw = drawable;
        return this;
    }

    @Nullable
    public Drawable cDE() {
        return this.jWw;
    }

    public b f(@Nullable n.b bVar) {
        this.jWx = bVar;
        return this;
    }

    @Nullable
    public n.b cDF() {
        return this.jWx;
    }

    public b g(@Nullable n.b bVar) {
        this.jWy = bVar;
        this.jWz = null;
        return this;
    }

    @Nullable
    public n.b cDG() {
        return this.jWy;
    }

    @Nullable
    public Matrix cDH() {
        return this.jWz;
    }

    @Nullable
    public PointF cDI() {
        return this.jWA;
    }

    @Nullable
    public ColorFilter cDJ() {
        return this.jWB;
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
            this.jWC = null;
        } else {
            this.jWC = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> cDK() {
        return this.jWC;
    }

    public b s(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.jWD = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.jWD = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable cDL() {
        return this.jWD;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.jWi = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams cDM() {
        return this.jWi;
    }

    private void validate() {
        if (this.jWC != null) {
            for (Drawable drawable : this.jWC) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a cDN() {
        validate();
        return new a(this);
    }
}
