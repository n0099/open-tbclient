package d.a.j0.r.u;

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
    public RectF A;

    /* renamed from: f  reason: collision with root package name */
    public View f50257f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f50258g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f50259h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f50260i;
    public int n;
    public int o;
    public int s;
    public int t;
    public LinearGradient v;
    public RectF z;

    /* renamed from: e  reason: collision with root package name */
    public int f50256e = 0;
    public float j = 1.0f;
    public int k = 0;
    public float l = 1.0f;
    public float m = 0.0f;
    public int p = 1;
    public float[] q = new float[8];
    public float[] r = new float[8];
    public int[] u = {0};
    public float[] w = {0.0f, 1.0f};
    public float[] x = {0.0f, 1.0f};
    public String y = TipsConfigItem.TipConfigData.BOTTOM;
    public Path B = new Path();
    public Path C = new Path();
    public Path D = new Path();
    public View.OnLayoutChangeListener E = new a();
    public int F = ShadowDrawable.ALL;

    /* loaded from: classes3.dex */
    public class a implements View.OnLayoutChangeListener {

        /* renamed from: d.a.j0.r.u.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1140a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ View f50262e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ ViewGroup.MarginLayoutParams f50263f;

            public RunnableC1140a(View view, ViewGroup.MarginLayoutParams marginLayoutParams) {
                this.f50262e = view;
                this.f50263f = marginLayoutParams;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f50262e.setLayoutParams(this.f50263f);
            }
        }

        public a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            if (view.getBackground() instanceof b) {
                b bVar = (b) view.getBackground();
                b.this.n = bVar.n;
                b.this.s = bVar.s;
                b.this.t = bVar.t;
                b.this.r = bVar.r;
            }
            float[] u = b.this.u();
            if (b.this.p == 1) {
                u[0] = (b.this.F & 1) == 1 ? u[0] : 0.0f;
                u[1] = (b.this.F & 16) == 16 ? u[1] : 0.0f;
                u[2] = (b.this.F & 256) == 256 ? u[2] : 0.0f;
                u[3] = (b.this.F & 4096) == 4096 ? u[3] : 0.0f;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.leftMargin -= (int) u[0];
                marginLayoutParams.topMargin -= (int) u[1];
                marginLayoutParams.rightMargin -= (int) u[2];
                marginLayoutParams.bottomMargin -= (int) u[3];
                marginLayoutParams.width = (i4 - i2) + ((int) u[0]) + ((int) u[2]);
                marginLayoutParams.height = (i5 - i3) + ((int) u[1]) + ((int) u[3]);
                view.post(new RunnableC1140a(view, marginLayoutParams));
            }
            view.removeOnLayoutChangeListener(this);
        }
    }

    public b() {
        Paint paint = new Paint();
        this.f50259h = paint;
        paint.setColor(0);
        this.f50259h.setAntiAlias(true);
        this.f50259h.setShadowLayer(this.n, this.s, this.t, this.o);
        this.f50259h.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        Paint paint2 = new Paint();
        this.f50258g = paint2;
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.f50260i = paint3;
        paint3.setColor(this.k);
        this.f50260i.setAlpha((int) (this.l * 255.0f));
        this.f50260i.setStrokeWidth(this.m);
        this.f50260i.setStyle(Paint.Style.STROKE);
        this.f50260i.setAntiAlias(true);
    }

    public static b y() {
        return new b();
    }

    public b A(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.j != f2) {
            this.j = f2;
        }
        return this;
    }

    public b B(int i2) {
        int[] iArr = this.u;
        if (iArr.length == 1 && iArr[0] == i2) {
            return this;
        }
        this.u = r0;
        int[] iArr2 = {i2};
        return this;
    }

    public b C(int[] iArr) {
        if (Arrays.equals(this.u, iArr)) {
            return this;
        }
        this.u = iArr;
        return this;
    }

    public b D(float f2) {
        if (this.l == f2) {
            return this;
        }
        this.l = f2;
        return this;
    }

    public b E(int i2) {
        if (this.k == i2) {
            return this;
        }
        this.k = i2;
        return this;
    }

    public b F(float f2) {
        if (this.m == f2) {
            return this;
        }
        this.m = f2;
        return this;
    }

    public b G(int i2) {
        if (this.f50256e == i2) {
            return this;
        }
        this.f50256e = i2;
        Q();
        return this;
    }

    public b H(String str) {
        if (this.y.equals(str)) {
            return this;
        }
        this.y = str;
        return this;
    }

    public b I(int i2) {
        if (this.s == i2) {
            return this;
        }
        this.s = i2;
        this.f50259h.setShadowLayer(this.n, i2, this.t, this.o);
        return this;
    }

    public b J(int i2) {
        int i3 = this.s;
        if (i3 == i2) {
            return this;
        }
        this.t = i2;
        this.f50259h.setShadowLayer(this.n, i3, i2, this.o);
        return this;
    }

    public b K(float[] fArr) {
        if (Arrays.equals(this.w, fArr)) {
            return this;
        }
        this.w = fArr;
        return this;
    }

    public b L(int i2) {
        if (this.o == i2) {
            return this;
        }
        this.o = i2;
        this.f50259h.setShadowLayer(this.n, this.s, this.t, i2);
        return this;
    }

    public b M(int i2) {
        if (this.n == i2) {
            return this;
        }
        this.n = i2;
        this.f50259h.setShadowLayer(i2, this.s, this.t, this.o);
        return this;
    }

    public b N(int i2) {
        if (this.F == i2) {
            return this;
        }
        this.F = i2;
        return this;
    }

    public b O(int i2) {
        if (this.p == i2) {
            return this;
        }
        this.p = i2;
        return this;
    }

    public b P(float[] fArr) {
        if (Arrays.equals(this.q, fArr)) {
            return this;
        }
        System.arraycopy(fArr, 0, this.q, 0, Math.min(fArr.length, 8));
        Q();
        return this;
    }

    public final void Q() {
        float[] fArr = this.q;
        float[] fArr2 = this.r;
        System.arraycopy(fArr, 0, fArr2, 0, Math.min(fArr2.length, 8));
        int i2 = this.f50256e;
        if (i2 == 1) {
            for (int i3 = 4; i3 < 8; i3++) {
                this.r[i3] = 0.0f;
            }
        } else if (i2 == 2) {
            for (int i4 = 0; i4 < 4; i4++) {
                this.r[i4] = 0.0f;
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
        bVar.O(this.p);
        bVar.N(this.F);
        bVar.G(this.f50256e);
        bVar.P((float[]) this.q.clone());
        bVar.L(this.o);
        bVar.M(this.n);
        bVar.I(this.s);
        bVar.J(this.t);
        bVar.C((int[]) this.u.clone());
        bVar.K((float[]) this.w.clone());
        bVar.H(this.y);
        bVar.E(this.k);
        bVar.D(this.l);
        bVar.F(this.m);
        bVar.A(this.j);
        return bVar;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        int[] q = q();
        if (q != null) {
            if (q.length == 1) {
                this.f50258g.setColor(q[0]);
            } else {
                PointF w = w(this.z, this.y);
                PointF v = v(this.z, this.y);
                LinearGradient linearGradient = new LinearGradient(w.x, w.y, v.x, v.y, q, this.x, Shader.TileMode.CLAMP);
                this.v = linearGradient;
                this.f50258g.setShader(linearGradient);
            }
        }
        this.f50260i.setColor(d.a.k0.d3.c.a(this.k, this.j));
        this.f50260i.setAlpha((int) (this.l * 255.0f));
        this.f50260i.setStrokeWidth(this.m);
        int i2 = this.p;
        if (i2 == 1) {
            p(canvas);
            canvas.drawPath(this.C, this.f50258g);
            o(canvas);
        } else if (i2 == 2) {
            canvas.drawCircle(this.z.centerX(), this.z.centerY(), Math.min(this.z.width(), this.z.height()) / 2.0f, this.f50259h);
            canvas.drawCircle(this.z.centerX(), this.z.centerY(), Math.min(this.z.width(), this.z.height()) / 2.0f, this.f50258g);
            canvas.drawCircle(this.z.centerX(), this.z.centerY(), (Math.min(this.z.width(), this.z.height()) / 2.0f) - (this.m * 0.5f), this.f50260i);
        } else {
            canvas.drawRect(this.z, this.f50258g);
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
        return hashCode() == bVar.hashCode() && this.f50256e == bVar.f50256e && this.n == bVar.n && this.o == bVar.o && this.p == bVar.p && this.s == bVar.s && this.t == bVar.t && this.F == bVar.F && Arrays.equals(this.q, bVar.q) && Arrays.equals(this.r, bVar.r) && Arrays.equals(this.u, bVar.u) && Arrays.equals(this.w, bVar.w) && this.y.equals(bVar.y) && this.k == bVar.k && this.l == bVar.l && this.m == bVar.m && this.j == bVar.j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public int hashCode() {
        return (((((((Objects.hash(Integer.valueOf(this.f50256e), Integer.valueOf(this.n), Integer.valueOf(this.o), Integer.valueOf(this.p), Integer.valueOf(this.s), Integer.valueOf(this.t), this.y, Integer.valueOf(this.F), Integer.valueOf(this.k), Float.valueOf(this.l), Float.valueOf(this.m), Float.valueOf(this.j)) * 31) + Arrays.hashCode(this.q)) * 31) + Arrays.hashCode(this.r)) * 31) + Arrays.hashCode(this.u)) * 31) + Arrays.hashCode(this.w);
    }

    public GradientDrawable l(int i2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        int length = this.r.length;
        for (int i3 = 0; i3 < length; i3++) {
            float[] fArr = this.r;
            if (fArr[i3] > 0.0f && fArr[i3] < 1.0f) {
                fArr[i3] = fArr[i3] * i2;
            }
        }
        gradientDrawable.setCornerRadii(this.r);
        gradientDrawable.setAlpha((int) (this.j * 255.0f));
        return gradientDrawable;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void m(float[] fArr, float[] fArr2) {
        char c2;
        String str = this.y;
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
            RectF rectF = this.z;
            float f2 = rectF.top;
            float height = rectF.height();
            float[] fArr3 = this.w;
            rectF.bottom = f2 + (height * fArr3[fArr3.length - 1]);
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
        } else if (c2 == 1) {
            RectF rectF2 = this.z;
            float f3 = rectF2.bottom;
            float height2 = rectF2.height();
            float[] fArr4 = this.w;
            rectF2.top = f3 - (height2 * fArr4[fArr4.length - 1]);
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
        } else if (c2 == 2) {
            RectF rectF3 = this.z;
            float f4 = rectF3.right;
            float width = rectF3.width();
            float[] fArr5 = this.w;
            rectF3.left = f4 - (width * fArr5[fArr5.length - 1]);
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
        } else if (c2 == 3) {
            RectF rectF4 = this.z;
            float f5 = rectF4.left;
            float width2 = rectF4.width();
            float[] fArr6 = this.w;
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
        this.f50257f = view;
        if (equals(view.getBackground())) {
            return null;
        }
        this.f50257f.removeOnLayoutChangeListener(this.E);
        this.f50257f.addOnLayoutChangeListener(this.E);
        return this;
    }

    public void o(Canvas canvas) {
        if (this.m == 0.0f || this.l == 0.0f || this.k == 0) {
            return;
        }
        canvas.drawPath(this.D, this.f50260i);
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int length = this.r.length;
        for (int i2 = 0; i2 < length; i2++) {
            float[] fArr = this.r;
            if (fArr[i2] > 0.0f && fArr[i2] < 1.0f) {
                fArr[i2] = fArr[i2] * rect.height();
            }
        }
        float[] u = u();
        this.z = new RectF(rect.left + u[0], rect.top + u[1], rect.right - u[2], rect.bottom - u[3]);
        this.B.reset();
        this.B.addRoundRect(this.z, this.r, Path.Direction.CW);
        this.x = (float[]) this.w.clone();
        float[] fArr2 = (float[]) this.r.clone();
        int[] iArr = this.u;
        if (iArr != null && iArr.length > 1 && x()) {
            m(fArr2, this.x);
        }
        this.C.reset();
        this.C.addRoundRect(this.z, fArr2, Path.Direction.CW);
        float f2 = this.m * 0.5f;
        float[] fArr3 = (float[]) this.r.clone();
        for (int i3 = 0; i3 < fArr3.length; i3++) {
            fArr3[i3] = fArr3[i3] - this.m;
            if (fArr3[i3] < 0.0f) {
                fArr3[i3] = 0.0f;
            }
        }
        RectF rectF = this.z;
        this.A = new RectF(rectF.left + f2, rectF.top + f2, rectF.right - f2, rectF.bottom - f2);
        this.D.reset();
        this.D.addRoundRect(this.A, fArr3, Path.Direction.CW);
    }

    public void p(Canvas canvas) {
        if (this.n == 0 && this.s == 0 && this.t == 0) {
            return;
        }
        canvas.drawPath(this.B, this.f50259h);
    }

    public final int[] q() {
        int[] iArr = this.u;
        if (iArr == null) {
            return iArr;
        }
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr2[i2] = d.a.k0.d3.c.a(this.u[i2], this.j);
        }
        return iArr2;
    }

    public float r() {
        return this.l;
    }

    public int s() {
        return this.k;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i2) {
        this.f50259h.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f50259h.setColorFilter(colorFilter);
    }

    public float t() {
        return this.m;
    }

    public final float[] u() {
        float[] fArr = new float[4];
        int i2 = this.p;
        if (i2 == 1) {
            fArr[0] = (this.F & 1) == 1 ? this.n - this.s : -this.r[0];
            fArr[1] = (this.F & 16) == 16 ? this.n - this.t : -this.r[2];
            fArr[2] = (this.F & 256) == 256 ? this.n + this.s : -this.r[4];
            fArr[3] = (this.F & 4096) == 4096 ? this.n + this.t : -this.r[6];
        } else if (i2 == 2) {
            Arrays.fill(fArr, this.n);
        }
        return fArr;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final PointF v(RectF rectF, String str) {
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final PointF w(RectF rectF, String str) {
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

    public final boolean x() {
        float[] fArr = this.w;
        return fArr != null && fArr.length >= 1 && fArr[fArr.length - 1] < 1.0f;
    }

    public void z() {
        View view = this.f50257f;
        if (view == null) {
            return;
        }
        view.removeOnLayoutChangeListener(this.E);
        this.f50257f.setLayerType(0, null);
        this.f50257f = null;
    }
}
