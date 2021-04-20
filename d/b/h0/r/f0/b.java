package d.b.h0.r.f0;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.style.ReplacementSpan;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.tieba.R;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class b extends ReplacementSpan {

    /* renamed from: f  reason: collision with root package name */
    public int f50888f;

    /* renamed from: h  reason: collision with root package name */
    public int f50890h;
    public int i;
    public int j;
    public int k;
    public int l;
    public Paint m;
    public String n;
    public int o;
    public int p;
    public boolean q;

    /* renamed from: e  reason: collision with root package name */
    public float[] f50887e = new float[8];

    /* renamed from: g  reason: collision with root package name */
    public RectF f50889g = new RectF();
    public int r = 255;
    public boolean s = false;
    public int t = 0;

    public b(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i2 > 0) {
            c(i2);
        }
        this.f50888f = i3;
        this.f50890h = i4;
        this.i = i5;
        this.j = i6;
        this.l = i7;
        Paint paint = new Paint();
        this.m = paint;
        paint.setAntiAlias(true);
        this.m.setStyle(Paint.Style.STROKE);
        this.m.setTextSize(this.f50890h);
    }

    public void a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.r = (int) (f2 * 255.0f);
    }

    public void b(int i) {
        Arrays.fill(this.f50887e, i);
    }

    public void c(int i) {
        float[] u = d.b.h0.r.u.a.u(i);
        if (Arrays.equals(this.f50887e, u)) {
            return;
        }
        this.f50887e = u;
    }

    public void d(int i) {
        this.t = i;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f2, int i3, int i4, int i5, @NonNull Paint paint) {
        int dimenPixelSize;
        int color;
        int color2;
        this.m.setColor(SkinManager.getColor(this.f50888f));
        this.m.setAlpha(this.r);
        if (this.q) {
            this.m.setStyle(Paint.Style.FILL);
        } else {
            this.m.setStyle(Paint.Style.STROKE);
        }
        if (this.s) {
            RectF rectF = this.f50889g;
            int i6 = this.o;
            rectF.left = f2 + i6;
            int i7 = this.t;
            rectF.top = (i4 - this.l) + i7;
            rectF.right = f2 + this.k + i6;
            rectF.bottom = i4 + i7;
        } else {
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            if (d.b.h0.r.u.e.a.b(charSequence)) {
                d.b.h0.r.u.e.a.a(fontMetricsInt, (int) paint.getTextSize());
                dimenPixelSize = 0 - UtilHelper.getDimenPixelSize(R.dimen.tbds3);
            } else {
                dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds3) + 0;
            }
            int i8 = dimenPixelSize + i4 + fontMetricsInt.ascent;
            RectF rectF2 = this.f50889g;
            int i9 = this.o;
            rectF2.left = f2 + i9;
            rectF2.top = i8;
            rectF2.right = f2 + this.k + i9;
            rectF2.bottom = i8 + this.l;
        }
        String str = this.n;
        if (str != null) {
            if (" 吧主".equals(str)) {
                color = SelectorHelper.getResources().getColor(R.color.CAM_X0302);
                color2 = SelectorHelper.getResources().getColor(R.color.CAM_X0302);
            } else if (" 小吧主".equals(this.n)) {
                color = SelectorHelper.getResources().getColor(R.color.CAM_X0302);
                color2 = SelectorHelper.getResources().getColor(R.color.CAM_X0302);
            } else if (" 楼主".equals(this.n)) {
                color = SelectorHelper.getResources().getColor(R.color.CAM_X0302);
                color2 = SelectorHelper.getResources().getColor(R.color.CAM_X0302);
            } else {
                color = SelectorHelper.getResources().getColor(R.color.CAM_X0302);
                color2 = SelectorHelper.getResources().getColor(R.color.CAM_X0302);
            }
            int i10 = color;
            int i11 = color2;
            RectF rectF3 = this.f50889g;
            this.m.setShader(new LinearGradient(rectF3.left, rectF3.top, rectF3.right, rectF3.bottom, i10, i11, Shader.TileMode.CLAMP));
        }
        Path path = new Path();
        path.addRoundRect(this.f50889g, this.f50887e, Path.Direction.CW);
        canvas.drawPath(path, this.m);
        this.m.setShader(null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if ((skinType == 1 || skinType == 4) && this.n != null) {
            this.m.setColor(SelectorHelper.getResources().getColor(R.color.mask));
            if (this.q) {
                this.m.setStyle(Paint.Style.FILL);
            } else {
                this.m.setStyle(Paint.Style.STROKE);
            }
            Path path2 = new Path();
            path2.addRoundRect(this.f50889g, this.f50887e, Path.Direction.CW);
            canvas.drawPath(path2, this.m);
        }
        Paint.FontMetricsInt fontMetricsInt2 = this.m.getFontMetricsInt();
        int i12 = this.i;
        if (i12 != 0) {
            this.m.setColor(SkinManager.getColor(i12));
        } else {
            this.m.setColor(SelectorHelper.getResources().getColor(R.color.CAM_X0201));
        }
        this.m.setStyle(Paint.Style.FILL);
        float centerY = this.f50889g.centerY();
        int i13 = fontMetricsInt2.bottom;
        canvas.drawText(charSequence, i, i2, f2 + this.j + this.o, (int) ((centerY + ((i13 - fontMetricsInt2.top) / 2)) - i13), this.m);
    }

    public void e(String str) {
        this.n = str;
    }

    public void f(boolean z) {
        Paint paint = this.m;
        if (paint == null) {
            return;
        }
        this.q = z;
        if (z) {
            paint.setStyle(Paint.Style.FILL);
        } else {
            paint.setStyle(Paint.Style.STROKE);
        }
    }

    public void g(boolean z) {
        this.s = z;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        int measureText = ((int) this.m.measureText(charSequence, i, i2)) + (this.j * 2);
        this.k = measureText;
        return measureText + this.o + this.p;
    }

    public void h(int i) {
        this.o = i;
    }

    public void i(int i) {
        this.p = i;
    }
}
