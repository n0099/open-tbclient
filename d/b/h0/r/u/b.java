package d.b.h0.r.u;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.kwad.sdk.core.config.item.TipsConfigItem;
import java.util.Arrays;
import java.util.Objects;
/* loaded from: classes3.dex */
public class b extends Drawable implements Cloneable {

    /* renamed from: f  reason: collision with root package name */
    public View f51048f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f51049g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f51050h;
    public Paint i;
    public int m;
    public int n;
    public int r;
    public int s;
    public LinearGradient u;
    public RectF y;
    public RectF z;

    /* renamed from: e  reason: collision with root package name */
    public int f51047e = 0;
    public float j = 1.0f;
    public int k = 0;
    public float l = 0.0f;
    public int o = 1;
    public float[] p = new float[8];
    public float[] q = new float[8];
    public int[] t = {0};
    public float[] v = {0.0f, 1.0f};
    public float[] w = {0.0f, 1.0f};
    public String x = TipsConfigItem.TipConfigData.BOTTOM;
    public Path A = new Path();
    public Path B = new Path();
    public Path C = new Path();
    public View.OnLayoutChangeListener D = new a();
    public int E = ShadowDrawable.ALL;

    /* loaded from: classes3.dex */
    public class a implements View.OnLayoutChangeListener {

        /* renamed from: d.b.h0.r.u.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1091a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ View f51052e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ ViewGroup.MarginLayoutParams f51053f;

            public RunnableC1091a(View view, ViewGroup.MarginLayoutParams marginLayoutParams) {
                this.f51052e = view;
                this.f51053f = marginLayoutParams;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f51052e.setLayoutParams(this.f51053f);
            }
        }

        public a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (view.getBackground() instanceof b) {
                b bVar = (b) view.getBackground();
                b.this.m = bVar.m;
                b.this.r = bVar.r;
                b.this.s = bVar.s;
                b.this.q = bVar.q;
            }
            float[] r = b.this.r();
            if (b.this.o == 1) {
                r[0] = (b.this.E & 1) == 1 ? r[0] : 0.0f;
                r[1] = (b.this.E & 16) == 16 ? r[1] : 0.0f;
                r[2] = (b.this.E & 256) == 256 ? r[2] : 0.0f;
                r[3] = (b.this.E & 4096) == 4096 ? r[3] : 0.0f;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.leftMargin -= (int) r[0];
                marginLayoutParams.topMargin -= (int) r[1];
                marginLayoutParams.rightMargin -= (int) r[2];
                marginLayoutParams.bottomMargin -= (int) r[3];
                marginLayoutParams.width = (i3 - i) + ((int) r[0]) + ((int) r[2]);
                marginLayoutParams.height = (i4 - i2) + ((int) r[1]) + ((int) r[3]);
                view.post(new RunnableC1091a(view, marginLayoutParams));
            }
            view.removeOnLayoutChangeListener(this);
        }
    }

    public b() {
        Paint paint = new Paint();
        this.f51050h = paint;
        paint.setColor(0);
        this.f51050h.setAntiAlias(true);
        this.f51050h.setShadowLayer(this.m, this.r, this.s, this.n);
        this.f51050h.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        Paint paint2 = new Paint();
        this.f51049g = paint2;
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.i = paint3;
        paint3.setColor(this.k);
        this.i.setStrokeWidth(this.l);
        this.i.setStyle(Paint.Style.STROKE);
        this.i.setAntiAlias(true);
    }

    public static b v() {
        return new b();
    }

    public b A(int i) {
        if (this.k == i) {
            return this;
        }
        this.k = i;
        return this;
    }

    public b B(float f2) {
        if (this.l == f2) {
            return this;
        }
        this.l = f2;
        return this;
    }

    public b C(int i) {
        if (this.f51047e == i) {
            return this;
        }
        this.f51047e = i;
        M();
        return this;
    }

    public b D(String str) {
        if (this.x.equals(str)) {
            return this;
        }
        this.x = str;
        return this;
    }

    public b E(int i) {
        if (this.r == i) {
            return this;
        }
        this.r = i;
        this.f51050h.setShadowLayer(this.m, i, this.s, this.n);
        return this;
    }

    public b F(int i) {
        int i2 = this.r;
        if (i2 == i) {
            return this;
        }
        this.s = i;
        this.f51050h.setShadowLayer(this.m, i2, i, this.n);
        return this;
    }

    public b G(float[] fArr) {
        if (Arrays.equals(this.v, fArr)) {
            return this;
        }
        this.v = fArr;
        return this;
    }

    public b H(int i) {
        if (this.n == i) {
            return this;
        }
        this.n = i;
        this.f51050h.setShadowLayer(this.m, this.r, this.s, i);
        return this;
    }

    public b I(int i) {
        if (this.m == i) {
            return this;
        }
        this.m = i;
        this.f51050h.setShadowLayer(i, this.r, this.s, this.n);
        return this;
    }

    public b J(int i) {
        if (this.E == i) {
            return this;
        }
        this.E = i;
        return this;
    }

    public b K(int i) {
        if (this.o == i) {
            return this;
        }
        this.o = i;
        return this;
    }

    public b L(float[] fArr) {
        if (Arrays.equals(this.p, fArr)) {
            return this;
        }
        System.arraycopy(fArr, 0, this.p, 0, Math.min(fArr.length, 8));
        M();
        return this;
    }

    public final void M() {
        float[] fArr = this.p;
        float[] fArr2 = this.q;
        System.arraycopy(fArr, 0, fArr2, 0, Math.min(fArr2.length, 8));
        int i = this.f51047e;
        if (i == 1) {
            for (int i2 = 4; i2 < 8; i2++) {
                this.q[i2] = 0.0f;
            }
        } else if (i == 2) {
            for (int i3 = 0; i3 < 4; i3++) {
                this.q[i3] = 0.0f;
            }
        }
    }

    public Object clone() {
        b bVar;
        try {
            bVar = (b) super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            bVar = null;
        }
        if (bVar == null) {
            return this;
        }
        bVar.K(this.o);
        bVar.J(this.E);
        bVar.C(this.f51047e);
        bVar.L((float[]) this.p.clone());
        bVar.H(this.n);
        bVar.I(this.m);
        bVar.E(this.r);
        bVar.F(this.s);
        bVar.z((int[]) this.t.clone());
        bVar.G((float[]) this.v.clone());
        bVar.D(this.x);
        bVar.A(this.k);
        bVar.B(this.l);
        bVar.x(this.j);
        return bVar;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        int[] q = q();
        if (q != null) {
            if (q.length == 1) {
                this.f51049g.setColor(q[0]);
            } else {
                PointF t = t(this.y, this.x);
                PointF s = s(this.y, this.x);
                LinearGradient linearGradient = new LinearGradient(t.x, t.y, s.x, s.y, q, this.w, Shader.TileMode.CLAMP);
                this.u = linearGradient;
                this.f51049g.setShader(linearGradient);
            }
        }
        this.i.setColor(d.b.i0.c3.c.a(this.k, this.j));
        this.i.setStrokeWidth(this.l);
        int i = this.o;
        if (i == 1) {
            p(canvas);
            canvas.drawPath(this.B, this.f51049g);
            o(canvas);
        } else if (i == 2) {
            canvas.drawCircle(this.y.centerX(), this.y.centerY(), Math.min(this.y.width(), this.y.height()) / 2.0f, this.f51050h);
            canvas.drawCircle(this.y.centerX(), this.y.centerY(), Math.min(this.y.width(), this.y.height()) / 2.0f, this.f51049g);
            canvas.drawCircle(this.y.centerX(), this.y.centerY(), (Math.min(this.y.width(), this.y.height()) / 2.0f) - (this.l * 0.5f), this.i);
        } else {
            canvas.drawRect(this.y, this.f51049g);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return hashCode() == bVar.hashCode() && this.f51047e == bVar.f51047e && this.m == bVar.m && this.n == bVar.n && this.o == bVar.o && this.r == bVar.r && this.s == bVar.s && this.E == bVar.E && Arrays.equals(this.p, bVar.p) && Arrays.equals(this.q, bVar.q) && Arrays.equals(this.t, bVar.t) && Arrays.equals(this.v, bVar.v) && this.x.equals(bVar.x) && this.k == bVar.k && this.l == bVar.l && this.j == bVar.j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public int hashCode() {
        return (((((((Objects.hash(Integer.valueOf(this.f51047e), Integer.valueOf(this.m), Integer.valueOf(this.n), Integer.valueOf(this.o), Integer.valueOf(this.r), Integer.valueOf(this.s), this.x, Integer.valueOf(this.E), Integer.valueOf(this.k), Float.valueOf(this.l), Float.valueOf(this.j)) * 31) + Arrays.hashCode(this.p)) * 31) + Arrays.hashCode(this.q)) * 31) + Arrays.hashCode(this.t)) * 31) + Arrays.hashCode(this.v);
    }

    public GradientDrawable l() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(this.q);
        return gradientDrawable;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void m(float[] fArr, float[] fArr2) {
        char c2;
        String str = this.x;
        switch (str.hashCode()) {
            case -1383228885:
                if (str.equals(TipsConfigItem.TipConfigData.BOTTOM)) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 115029:
                if (str.equals("top")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 3317767:
                if (str.equals(CustomDialogData.POS_LEFT)) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 108511772:
                if (str.equals("right")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 == 0) {
            RectF rectF = this.y;
            float f2 = rectF.top;
            float height = rectF.height();
            float[] fArr3 = this.v;
            rectF.bottom = f2 + (height * fArr3[fArr3.length - 1]);
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
        } else if (c2 == 1) {
            RectF rectF2 = this.y;
            float f3 = rectF2.bottom;
            float height2 = rectF2.height();
            float[] fArr4 = this.v;
            rectF2.top = f3 - (height2 * fArr4[fArr4.length - 1]);
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
        } else if (c2 == 2) {
            RectF rectF3 = this.y;
            float f4 = rectF3.right;
            float width = rectF3.width();
            float[] fArr5 = this.v;
            rectF3.left = f4 - (width * fArr5[fArr5.length - 1]);
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
        } else if (c2 == 3) {
            RectF rectF4 = this.y;
            float f5 = rectF4.left;
            float width2 = rectF4.width();
            float[] fArr6 = this.v;
            rectF4.right = f5 + (width2 * fArr6[fArr6.length - 1]);
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
        }
        fArr2[fArr2.length - 1] = 1.0f;
    }

    public b n(View view) {
        if (view == null) {
            return null;
        }
        this.f51048f = view;
        if (equals(view.getBackground())) {
            return null;
        }
        this.f51048f.removeOnLayoutChangeListener(this.D);
        this.f51048f.addOnLayoutChangeListener(this.D);
        return this;
    }

    public void o(Canvas canvas) {
        if (this.l == 0.0f || this.k == 0) {
            return;
        }
        canvas.drawPath(this.C, this.i);
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int length = this.q.length;
        for (int i = 0; i < length; i++) {
            float[] fArr = this.q;
            if (fArr[i] > 0.0f && fArr[i] < 1.0f) {
                fArr[i] = fArr[i] * rect.height();
            }
        }
        float[] r = r();
        this.y = new RectF(rect.left + r[0], rect.top + r[1], rect.right - r[2], rect.bottom - r[3]);
        this.A.reset();
        this.A.addRoundRect(this.y, this.q, Path.Direction.CW);
        this.w = (float[]) this.v.clone();
        float[] fArr2 = (float[]) this.q.clone();
        int[] iArr = this.t;
        if (iArr != null && iArr.length > 1 && u()) {
            m(fArr2, this.w);
        }
        this.B.reset();
        this.B.addRoundRect(this.y, fArr2, Path.Direction.CW);
        float f2 = this.l * 0.5f;
        float[] fArr3 = (float[]) this.q.clone();
        for (int i2 = 0; i2 < fArr3.length; i2++) {
            fArr3[i2] = fArr3[i2] - this.l;
            if (fArr3[i2] < 0.0f) {
                fArr3[i2] = 0.0f;
            }
        }
        RectF rectF = this.y;
        this.z = new RectF(rectF.left + f2, rectF.top + f2, rectF.right - f2, rectF.bottom - f2);
        this.C.reset();
        this.C.addRoundRect(this.z, fArr3, Path.Direction.CW);
    }

    public void p(Canvas canvas) {
        if (this.m == 0 && this.r == 0 && this.s == 0) {
            return;
        }
        canvas.drawPath(this.A, this.f51050h);
    }

    public final int[] q() {
        int[] iArr = this.t;
        if (iArr == null) {
            return iArr;
        }
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i = 0; i < length; i++) {
            iArr2[i] = d.b.i0.c3.c.a(this.t[i], this.j);
        }
        return iArr2;
    }

    public final float[] r() {
        float[] fArr = new float[4];
        int i = this.o;
        if (i == 1) {
            fArr[0] = (this.E & 1) == 1 ? this.m - this.r : -this.q[0];
            fArr[1] = (this.E & 16) == 16 ? this.m - this.s : -this.q[2];
            fArr[2] = (this.E & 256) == 256 ? this.m + this.r : -this.q[4];
            fArr[3] = (this.E & 4096) == 4096 ? this.m + this.s : -this.q[6];
        } else if (i == 2) {
            Arrays.fill(fArr, this.m);
        }
        return fArr;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final PointF s(RectF rectF, String str) {
        char c2;
        switch (str.hashCode()) {
            case -1383228885:
                if (str.equals(TipsConfigItem.TipConfigData.BOTTOM)) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 115029:
                if (str.equals("top")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 3317767:
                if (str.equals(CustomDialogData.POS_LEFT)) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 108511772:
                if (str.equals("right")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 != 0) {
            if (c2 != 1) {
                if (c2 != 2) {
                    if (c2 != 3) {
                        return new PointF();
                    }
                    return new PointF(rectF.right, rectF.height() / 2.0f);
                }
                return new PointF(rectF.left, rectF.height() / 2.0f);
            }
            return new PointF(rectF.width() / 2.0f, rectF.top);
        }
        return new PointF(rectF.width() / 2.0f, rectF.bottom);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        this.f51050h.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f51050h.setColorFilter(colorFilter);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final PointF t(RectF rectF, String str) {
        char c2;
        switch (str.hashCode()) {
            case -1383228885:
                if (str.equals(TipsConfigItem.TipConfigData.BOTTOM)) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 115029:
                if (str.equals("top")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 3317767:
                if (str.equals(CustomDialogData.POS_LEFT)) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 108511772:
                if (str.equals("right")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 != 0) {
            if (c2 != 1) {
                if (c2 != 2) {
                    if (c2 != 3) {
                        return new PointF();
                    }
                    return new PointF(rectF.left, rectF.height() / 2.0f);
                }
                return new PointF(rectF.right, rectF.height() / 2.0f);
            }
            return new PointF(rectF.width() / 2.0f, rectF.bottom);
        }
        return new PointF(rectF.width() / 2.0f, rectF.top);
    }

    public final boolean u() {
        float[] fArr = this.v;
        return fArr != null && fArr.length >= 1 && fArr[fArr.length - 1] < 1.0f;
    }

    public void w() {
        View view = this.f51048f;
        if (view == null) {
            return;
        }
        view.removeOnLayoutChangeListener(this.D);
        this.f51048f.setLayerType(0, null);
        this.f51048f = null;
    }

    public b x(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.j != f2) {
            this.j = f2;
        }
        return this;
    }

    public b y(int i) {
        int[] iArr = this.t;
        if (iArr.length == 1 && iArr[0] == i) {
            return this;
        }
        this.t = r0;
        int[] iArr2 = {i};
        return this;
    }

    public b z(int[] iArr) {
        if (Arrays.equals(this.t, iArr)) {
            return this;
        }
        this.t = iArr;
        return this;
    }
}
