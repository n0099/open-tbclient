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
    public static final n.b jWj = n.b.jWa;
    public static final n.b jWk = n.b.jWb;
    private Drawable jWA;
    private RoundingParams jWf;
    private int jWl;
    private float jWm;
    private Drawable jWn;
    @Nullable
    private n.b jWo;
    private Drawable jWp;
    private n.b jWq;
    private Drawable jWr;
    private n.b jWs;
    private Drawable jWt;
    private n.b jWu;
    private n.b jWv;
    private Matrix jWw;
    private PointF jWx;
    private ColorFilter jWy;
    private List<Drawable> jWz;
    private Drawable mBackground;
    private Resources mResources;

    public b(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.jWl = 300;
        this.jWm = 0.0f;
        this.jWn = null;
        this.jWo = jWj;
        this.jWp = null;
        this.jWq = jWj;
        this.jWr = null;
        this.jWs = jWj;
        this.jWt = null;
        this.jWu = jWj;
        this.jWv = jWk;
        this.jWw = null;
        this.jWx = null;
        this.jWy = null;
        this.mBackground = null;
        this.jWz = null;
        this.jWA = null;
        this.jWf = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public b Dd(int i) {
        this.jWl = i;
        return this;
    }

    public int cDx() {
        return this.jWl;
    }

    public b ba(float f) {
        this.jWm = f;
        return this;
    }

    public float cDy() {
        return this.jWm;
    }

    public b m(@Nullable Drawable drawable) {
        this.jWn = drawable;
        return this;
    }

    @Nullable
    public Drawable cDz() {
        return this.jWn;
    }

    public b c(@Nullable n.b bVar) {
        this.jWo = bVar;
        return this;
    }

    @Nullable
    public n.b cDA() {
        return this.jWo;
    }

    public b n(@Nullable Drawable drawable) {
        this.jWp = drawable;
        return this;
    }

    @Nullable
    public Drawable cDB() {
        return this.jWp;
    }

    public b d(@Nullable n.b bVar) {
        this.jWq = bVar;
        return this;
    }

    @Nullable
    public n.b cDC() {
        return this.jWq;
    }

    public b o(@Nullable Drawable drawable) {
        this.jWr = drawable;
        return this;
    }

    @Nullable
    public Drawable cDD() {
        return this.jWr;
    }

    public b e(@Nullable n.b bVar) {
        this.jWs = bVar;
        return this;
    }

    @Nullable
    public n.b cDE() {
        return this.jWs;
    }

    public b p(@Nullable Drawable drawable) {
        this.jWt = drawable;
        return this;
    }

    @Nullable
    public Drawable cDF() {
        return this.jWt;
    }

    public b f(@Nullable n.b bVar) {
        this.jWu = bVar;
        return this;
    }

    @Nullable
    public n.b cDG() {
        return this.jWu;
    }

    public b g(@Nullable n.b bVar) {
        this.jWv = bVar;
        this.jWw = null;
        return this;
    }

    @Nullable
    public n.b cDH() {
        return this.jWv;
    }

    @Nullable
    public Matrix cDI() {
        return this.jWw;
    }

    @Nullable
    public PointF cDJ() {
        return this.jWx;
    }

    @Nullable
    public ColorFilter cDK() {
        return this.jWy;
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
            this.jWz = null;
        } else {
            this.jWz = Arrays.asList(drawable);
        }
        return this;
    }

    @Nullable
    public List<Drawable> cDL() {
        return this.jWz;
    }

    public b s(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.jWA = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.jWA = stateListDrawable;
        }
        return this;
    }

    @Nullable
    public Drawable cDM() {
        return this.jWA;
    }

    public b b(@Nullable RoundingParams roundingParams) {
        this.jWf = roundingParams;
        return this;
    }

    @Nullable
    public RoundingParams cDN() {
        return this.jWf;
    }

    private void validate() {
        if (this.jWz != null) {
            for (Drawable drawable : this.jWz) {
                g.checkNotNull(drawable);
            }
        }
    }

    public a cDO() {
        validate();
        return new a(this);
    }
}
