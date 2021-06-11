package d.a.m0.r.f0;

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
    public int f53380f;

    /* renamed from: h  reason: collision with root package name */
    public int f53382h;

    /* renamed from: i  reason: collision with root package name */
    public int f53383i;
    public int j;
    public int k;
    public int l;
    public Paint m;
    public String n;
    public int o;
    public int p;
    public boolean q;

    /* renamed from: e  reason: collision with root package name */
    public float[] f53379e = new float[8];

    /* renamed from: g  reason: collision with root package name */
    public RectF f53381g = new RectF();
    public int r = 255;
    public boolean s = false;
    public int t = 0;

    public b(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i3 > 0) {
            c(i3);
        }
        this.f53380f = i4;
        this.f53382h = i5;
        this.f53383i = i6;
        this.j = i7;
        this.l = i8;
        Paint paint = new Paint();
        this.m = paint;
        paint.setAntiAlias(true);
        this.m.setStyle(Paint.Style.STROKE);
        this.m.setTextSize(this.f53382h);
    }

    public void a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.r = (int) (f2 * 255.0f);
    }

    public void b(int i2) {
        Arrays.fill(this.f53379e, i2);
    }

    public void c(int i2) {
        float[] v = d.a.m0.r.u.a.v(i2);
        if (Arrays.equals(this.f53379e, v)) {
            return;
        }
        this.f53379e = v;
    }

    public void d(int i2) {
        this.t = i2;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, @NonNull Paint paint) {
        int dimenPixelSize;
        int color;
        int color2;
        this.m.setColor(SkinManager.getColor(this.f53380f));
        this.m.setAlpha(this.r);
        if (this.q) {
            this.m.setStyle(Paint.Style.FILL);
        } else {
            this.m.setStyle(Paint.Style.STROKE);
        }
        if (this.s) {
            RectF rectF = this.f53381g;
            int i7 = this.o;
            rectF.left = f2 + i7;
            int i8 = this.t;
            rectF.top = (i5 - this.l) + i8;
            rectF.right = f2 + this.k + i7;
            rectF.bottom = i5 + i8;
        } else {
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            if (d.a.m0.r.u.e.a.b(charSequence)) {
                d.a.m0.r.u.e.a.a(fontMetricsInt, (int) paint.getTextSize());
                dimenPixelSize = 0 - UtilHelper.getDimenPixelSize(R.dimen.tbds3);
            } else {
                dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds3) + 0;
            }
            int i9 = dimenPixelSize + i5 + fontMetricsInt.ascent;
            RectF rectF2 = this.f53381g;
            int i10 = this.o;
            rectF2.left = f2 + i10;
            rectF2.top = i9;
            rectF2.right = f2 + this.k + i10;
            rectF2.bottom = i9 + this.l;
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
            int i11 = color;
            int i12 = color2;
            RectF rectF3 = this.f53381g;
            this.m.setShader(new LinearGradient(rectF3.left, rectF3.top, rectF3.right, rectF3.bottom, i11, i12, Shader.TileMode.CLAMP));
        }
        Path path = new Path();
        path.addRoundRect(this.f53381g, this.f53379e, Path.Direction.CW);
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
            path2.addRoundRect(this.f53381g, this.f53379e, Path.Direction.CW);
            canvas.drawPath(path2, this.m);
        }
        Paint.FontMetricsInt fontMetricsInt2 = this.m.getFontMetricsInt();
        int i13 = this.f53383i;
        if (i13 != 0) {
            this.m.setColor(SkinManager.getColor(i13));
        } else {
            this.m.setColor(SelectorHelper.getResources().getColor(R.color.CAM_X0201));
        }
        this.m.setStyle(Paint.Style.FILL);
        float centerY = this.f53381g.centerY();
        int i14 = fontMetricsInt2.bottom;
        canvas.drawText(charSequence, i2, i3, f2 + this.j + this.o, (int) ((centerY + ((i14 - fontMetricsInt2.top) / 2)) - i14), this.m);
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
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i2, int i3, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        int measureText = ((int) this.m.measureText(charSequence, i2, i3)) + (this.j * 2);
        this.k = measureText;
        return measureText + this.o + this.p;
    }

    public void h(int i2) {
        this.o = i2;
    }

    public void i(int i2) {
        this.p = i2;
    }
}
