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
    public static final n.b jWi = n.b.jVZ;
    public static final n.b jWj = n.b.jWa;
    private RoundingParams jWe;
    private int jWk;
    private float jWl;
    private Drawable jWm;
    @Nullable
    private n.b jWn;
    private Drawable jWo;
    private n.b jWp;
    private Drawable jWq;
    private n.b jWr;
    private Drawable jWs;
    private n.b jWt;
    private n.b jWu;
    private Matrix jWv;
    private PointF jWw;
    private ColorFilter jWx;
    private List<Drawable> jWy;
    private Drawable jWz;
    private Drawable mBackground;
    private Resources mResources;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.jWk = 300;
        this.jWl = 0.0f;
        this.jWm = null;
        this.jWn = jWi;
        this.jWo = null;
        this.jWp = jWi;
        this.jWq = null;
        this.jWr = jWi;
        this.jWs = null;
        this.jWt = jWi;
        this.jWu = jWj;
        this.jWv = null;
        this.jWw = null;
        this.jWx = null;
        this.mBackground = null;
        this.jWy = null;
        this.jWz = null;
        this.jWe = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b Dd(int i) {
        this.jWk = i;
        return this;
    }

    public int cDv() {
        return this.jWk;
    }

    public b ba(float f) {
        this.jWl = f;
        return this;
    }

    public float cDw() {
        return this.jWl;
    }

    public b m(@Nullable Drawable drawable) {
        this.jWm = drawable;
        return this;
    }

    @Nullable
    public Drawable cDx() {
        return this.jWm;
    }

    public b c(@Nullable n.b bVar) {
        this.jWn = bVar;
        return this;
    }

    @Nullable
    public n.b cDy() {
        return this.jWn;
    }

    public b n(@Nullable Drawable drawable) {
        this.jWo = drawable;
        return this;
    }

    @Nullable
    public Drawable cDz() {
        return this.jWo;
    }

    public b d(@Nullable n.b bVar) {
        this.jWp = bVar;
        return this;
    }

    @Nullable
    public n.b cDA() {
        return this.jWp;
    }

    public b o(@Nullable Drawable drawable) {
        this.jWq = drawable;
        return this;
    }

    @Nullable
    public Drawable cDB() {
        return this.jWq;
    }

    public b e(@Nullable n.b bVar) {
        this.jWr = bVar;
        return this;
    }

    @Nullable
    public n.b cDC() {
        return this.jWr;
    }

    public b p(@Nullable Drawable drawable) {
        this.jWs = drawable;
        return this;
    }

    @Nullable
    public Drawable cDD() {
        return this.jWs;
    }

    public b f(@Nullable n.b bVar) {
        this.jWt = bVar;
        return this;
    }

    @Nullable
    public n.b cDE() {
        return this.jWt;
    }

    public b g(@Nullable n.b bVar) {
        this.jWu = bVar;
        this.jWv = null;
        return this;
    }

    @Nullable
    public n.b cDF() {
        return this.jWu;
    }

    @Nullable
    public Matrix cDG() {
        return this.jWv;
    }

    @Nullable
    public PointF cDH() {
        return this.jWw;
    }

    @Nullable
    public ColorFilter cDI() {
        return this.jWx;
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
            this.jWy = null;
        } else {
            this.jWy = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> cDJ() {
        return this.jWy;
    }

    public b s(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.jWz = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.jWz = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable cDK() {
        return this.jWz;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.jWe = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams cDL() {
        return this.jWe;
    }

    private void validate() {
        if (this.jWy != null) {
            for (Drawable drawable : this.jWy) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a cDM() {
        validate();
        return new a(this);
    }
}
