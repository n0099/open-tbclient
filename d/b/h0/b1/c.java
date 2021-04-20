package d.b.h0.b1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: d  reason: collision with root package name */
    public final View f50216d;

    /* renamed from: e  reason: collision with root package name */
    public int f50217e;

    /* renamed from: f  reason: collision with root package name */
    public int f50218f;

    /* renamed from: g  reason: collision with root package name */
    public int f50219g;

    /* renamed from: h  reason: collision with root package name */
    public int f50220h;
    public int i;
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
    public final Paint f50213a = new Paint();

    /* renamed from: b  reason: collision with root package name */
    public final Paint f50214b = new Paint();

    /* renamed from: c  reason: collision with root package name */
    public final Paint f50215c = new Paint();
    public final Paint m = new Paint();
    public int n = 3;
    public int o = R.color.CAM_X0101;
    public int p = R.color.CAM_X0305;

    public c(View view) {
        this.f50217e = 16;
        this.f50218f = 16;
        this.f50219g = -1;
        this.f50220h = 1711276032;
        this.i = 20;
        this.j = 20;
        this.k = 36;
        this.l = 0.0f;
        this.q = 20;
        this.r = 20;
        this.s = 36;
        this.t = 0;
        this.v = 0;
        this.f50216d = view;
        int color = c().getResources().getColor(R.color.black_alpha40);
        this.f50220h = color;
        this.f50214b.setColor(color);
        this.f50214b.setAntiAlias(true);
        this.i = (int) c().getResources().getDimension(R.dimen.tbfontsize26);
        int color2 = c().getResources().getColor(R.color.CAM_X0101);
        this.f50219g = color2;
        this.f50213a.setColor(color2);
        this.f50213a.setTextSize(this.i);
        this.f50213a.setAntiAlias(true);
        this.f50213a.setTypeface(d.b.h0.r.u.a.C(d.b.h0.r.u.a.z(R.string.F_X02)));
        this.f50217e = l.g(c(), R.dimen.tbds16);
        this.f50218f = l.g(c(), R.dimen.tbds16);
        this.j = l.g(c(), R.dimen.tbds22);
        this.k = l.g(c(), R.dimen.tbds40);
        this.l = d.b.h0.r.u.a.u(R.string.J_X01)[0];
        int dimension = (int) c().getResources().getDimension(R.dimen.tbfontsize26);
        this.q = dimension;
        this.f50215c.setTextSize(dimension);
        this.f50213a.setAntiAlias(true);
        this.m.setAntiAlias(true);
        this.r = l.g(c(), R.dimen.tbds16);
        this.s = l.g(c(), R.dimen.tbds22);
        this.t = l.g(c(), R.dimen.tbds5);
        this.v = l.g(c(), R.dimen.M_W_X006);
        l.g(c(), R.dimen.M_H_X004);
        j(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(Canvas canvas, String str, boolean z) {
        int i;
        if (canvas == null || this.f50216d == null || TextUtils.isEmpty(str)) {
            return;
        }
        int save = canvas.save();
        this.f50216d.getPaddingLeft();
        int paddingRight = this.f50216d.getPaddingRight();
        this.f50216d.getPaddingTop();
        int paddingBottom = this.f50216d.getPaddingBottom();
        int left = this.f50216d.getLeft();
        int right = this.f50216d.getRight();
        int top = this.f50216d.getTop();
        int bottom = this.f50216d.getBottom();
        float measureText = this.f50213a.measureText(str);
        Paint.FontMetrics fontMetrics = this.f50213a.getFontMetrics();
        if (z) {
            if (this.u == null) {
                this.u = d.b.h0.r.u.a.x(R.array.S_O_X001);
            }
            float[] fArr = this.u;
            if (fArr == null || fArr.length < 4) {
                i = save;
            } else {
                i = save;
                this.f50213a.setShadowLayer(fArr[1], fArr[2], fArr[3], (int) fArr[0]);
            }
            int i2 = this.v;
            canvas.drawText(str, (((right - left) - paddingRight) - i2) - measureText, (((bottom - top) - paddingBottom) - i2) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.f50213a);
        } else {
            i = save;
            float f2 = this.k + measureText;
            float f3 = this.i + this.j;
            canvas.translate((((right - left) - paddingRight) - f2) - this.f50218f, (((bottom - top) - paddingBottom) - f3) - this.f50217e);
            RectF rectF = new RectF(0.0f, 0.0f, f2, f3);
            float f4 = this.l;
            if (f4 < 1.0f) {
                this.l = f4 * f3;
            }
            float f5 = this.l;
            canvas.drawRoundRect(rectF, f5, f5, this.f50214b);
            this.f50213a.clearShadowLayer();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.f50213a);
        }
        int i3 = i;
        if (i3 < 1 || i3 > canvas.getSaveCount()) {
            return;
        }
        canvas.restoreToCount(i3);
    }

    public void b(Canvas canvas, String str, int i) {
        if (canvas == null || this.f50216d == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (i != 0) {
            this.p = i;
            this.m.setColor(SkinManager.getColor(i));
        }
        int save = canvas.save();
        int paddingLeft = this.f50216d.getPaddingLeft();
        this.f50216d.getPaddingRight();
        int paddingTop = this.f50216d.getPaddingTop();
        this.f50216d.getPaddingBottom();
        float measureText = this.f50215c.measureText(str);
        canvas.translate(paddingLeft, paddingTop);
        RectF rectF = new RectF(0.0f, 0.0f, this.s + measureText, this.q + this.r);
        int i2 = this.t;
        canvas.drawRoundRect(rectF, i2, i2, this.m);
        Paint.FontMetrics fontMetrics = this.f50215c.getFontMetrics();
        canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.f50215c);
        if (save < 1 || save > canvas.getSaveCount()) {
            return;
        }
        canvas.restoreToCount(save);
    }

    public final Context c() {
        View view = this.f50216d;
        if (view != null && view.getContext() != null) {
            return this.f50216d.getContext();
        }
        return TbadkCoreApplication.getInst().getContext();
    }

    public float d(String str) {
        return l.D(this.f50213a, str).height() + this.j;
    }

    public float e(String str) {
        return l.E(this.f50213a, str) + this.k;
    }

    public final void f() {
        View view = this.f50216d;
        if (view != null) {
            view.invalidate();
        }
    }

    public void g(int i, int i2) {
        this.f50218f = i;
        this.f50217e = i2;
        f();
    }

    public void h(int i) {
        this.f50219g = i;
        this.f50213a.setColor(i);
        f();
    }

    public void i(int i) {
        this.i = i;
        this.f50213a.setTextSize(i);
        f();
    }

    public void j(int i) {
        if (this.n == i) {
            return;
        }
        this.n = i;
        this.f50215c.setColor(SkinManager.getColor(i, this.o));
        this.m.setColor(SkinManager.getColor(i, this.p));
    }
}
