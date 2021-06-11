package d.a.m0.b1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: d  reason: collision with root package name */
    public final View f52635d;

    /* renamed from: e  reason: collision with root package name */
    public int f52636e;

    /* renamed from: f  reason: collision with root package name */
    public int f52637f;

    /* renamed from: g  reason: collision with root package name */
    public int f52638g;

    /* renamed from: h  reason: collision with root package name */
    public int f52639h;

    /* renamed from: i  reason: collision with root package name */
    public int f52640i;
    public int j;
    public int k;
    public float l;
    public int q;
    public int r;
    public int s;
    public int t;
    public float[] u;
    public int v;

    /* renamed from: a  reason: collision with root package name */
    public final Paint f52632a = new Paint();

    /* renamed from: b  reason: collision with root package name */
    public final Paint f52633b = new Paint();

    /* renamed from: c  reason: collision with root package name */
    public final Paint f52634c = new Paint();
    public final Paint m = new Paint();
    public int n = 3;
    public int o = R.color.CAM_X0101;
    public int p = R.color.CAM_X0305;

    public c(View view) {
        this.f52636e = 16;
        this.f52637f = 16;
        this.f52638g = -1;
        this.f52639h = 1711276032;
        this.f52640i = 20;
        this.j = 20;
        this.k = 36;
        this.l = 0.0f;
        this.q = 20;
        this.r = 20;
        this.s = 36;
        this.t = 0;
        this.v = 0;
        this.f52635d = view;
        int color = c().getResources().getColor(R.color.black_alpha40);
        this.f52639h = color;
        this.f52633b.setColor(color);
        this.f52633b.setAntiAlias(true);
        this.f52640i = (int) c().getResources().getDimension(R.dimen.tbfontsize26);
        int color2 = c().getResources().getColor(R.color.CAM_X0101);
        this.f52638g = color2;
        this.f52632a.setColor(color2);
        this.f52632a.setTextSize(this.f52640i);
        this.f52632a.setAntiAlias(true);
        this.f52632a.setTypeface(d.a.m0.r.u.a.E(d.a.m0.r.u.a.B(R.string.F_X02)));
        this.f52636e = l.g(c(), R.dimen.tbds16);
        this.f52637f = l.g(c(), R.dimen.tbds16);
        this.j = l.g(c(), R.dimen.tbds22);
        this.k = l.g(c(), R.dimen.tbds40);
        this.l = d.a.m0.r.u.a.v(R.string.J_X01)[0];
        int dimension = (int) c().getResources().getDimension(R.dimen.tbfontsize26);
        this.q = dimension;
        this.f52634c.setTextSize(dimension);
        this.f52632a.setAntiAlias(true);
        this.m.setAntiAlias(true);
        this.r = l.g(c(), R.dimen.tbds16);
        this.s = l.g(c(), R.dimen.tbds22);
        this.t = l.g(c(), R.dimen.tbds5);
        this.v = l.g(c(), R.dimen.M_W_X006);
        l.g(c(), R.dimen.M_H_X004);
        j(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(Canvas canvas, String str, boolean z) {
        int i2;
        if (canvas == null || this.f52635d == null || TextUtils.isEmpty(str)) {
            return;
        }
        int save = canvas.save();
        this.f52635d.getPaddingLeft();
        int paddingRight = this.f52635d.getPaddingRight();
        this.f52635d.getPaddingTop();
        int paddingBottom = this.f52635d.getPaddingBottom();
        int left = this.f52635d.getLeft();
        int right = this.f52635d.getRight();
        int top = this.f52635d.getTop();
        int bottom = this.f52635d.getBottom();
        float measureText = this.f52632a.measureText(str);
        Paint.FontMetrics fontMetrics = this.f52632a.getFontMetrics();
        if (z) {
            if (this.u == null) {
                this.u = d.a.m0.r.u.a.y(R.array.S_O_X001);
            }
            float[] fArr = this.u;
            if (fArr == null || fArr.length < 4) {
                i2 = save;
            } else {
                i2 = save;
                this.f52632a.setShadowLayer(fArr[1], fArr[2], fArr[3], (int) fArr[0]);
            }
            int i3 = this.v;
            canvas.drawText(str, (((right - left) - paddingRight) - i3) - measureText, (((bottom - top) - paddingBottom) - i3) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.f52632a);
        } else {
            i2 = save;
            float f2 = this.k + measureText;
            float f3 = this.f52640i + this.j;
            canvas.translate((((right - left) - paddingRight) - f2) - this.f52637f, (((bottom - top) - paddingBottom) - f3) - this.f52636e);
            RectF rectF = new RectF(0.0f, 0.0f, f2, f3);
            float f4 = this.l;
            if (f4 < 1.0f) {
                this.l = f4 * f3;
            }
            float f5 = this.l;
            canvas.drawRoundRect(rectF, f5, f5, this.f52633b);
            this.f52632a.clearShadowLayer();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.f52632a);
        }
        int i4 = i2;
        if (i4 < 1 || i4 > canvas.getSaveCount()) {
            return;
        }
        canvas.restoreToCount(i4);
    }

    public void b(Canvas canvas, String str, int i2) {
        if (canvas == null || this.f52635d == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (i2 != 0) {
            this.p = i2;
            this.m.setColor(SkinManager.getColor(i2));
        }
        int save = canvas.save();
        int paddingLeft = this.f52635d.getPaddingLeft();
        this.f52635d.getPaddingRight();
        int paddingTop = this.f52635d.getPaddingTop();
        this.f52635d.getPaddingBottom();
        float measureText = this.f52634c.measureText(str);
        canvas.translate(paddingLeft, paddingTop);
        RectF rectF = new RectF(0.0f, 0.0f, this.s + measureText, this.q + this.r);
        int i3 = this.t;
        canvas.drawRoundRect(rectF, i3, i3, this.m);
        Paint.FontMetrics fontMetrics = this.f52634c.getFontMetrics();
        canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.f52634c);
        if (save < 1 || save > canvas.getSaveCount()) {
            return;
        }
        canvas.restoreToCount(save);
    }

    public final Context c() {
        View view = this.f52635d;
        if (view != null && view.getContext() != null) {
            return this.f52635d.getContext();
        }
        return TbadkCoreApplication.getInst().getContext();
    }

    public float d(String str) {
        return l.E(this.f52632a, str).height() + this.j;
    }

    public float e(String str) {
        return l.F(this.f52632a, str) + this.k;
    }

    public final void f() {
        View view = this.f52635d;
        if (view != null) {
            view.invalidate();
        }
    }

    public void g(int i2, int i3) {
        this.f52637f = i2;
        this.f52636e = i3;
        f();
    }

    public void h(int i2) {
        this.f52638g = i2;
        this.f52632a.setColor(i2);
        f();
    }

    public void i(int i2) {
        this.f52640i = i2;
        this.f52632a.setTextSize(i2);
        f();
    }

    public void j(int i2) {
        if (this.n == i2) {
            return;
        }
        this.n = i2;
        this.f52634c.setColor(SkinManager.getColor(i2, this.o));
        this.m.setColor(SkinManager.getColor(i2, this.p));
    }
}
