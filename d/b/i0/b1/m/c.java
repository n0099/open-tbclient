package d.b.i0.b1.m;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class c extends ReplacementSpan {
    public static final int n = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds5);
    public static final int o = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds11);
    public static final int p = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds12);
    public static final int q = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);

    /* renamed from: e  reason: collision with root package name */
    public int f50692e;

    /* renamed from: f  reason: collision with root package name */
    public int f50693f;

    /* renamed from: g  reason: collision with root package name */
    public int f50694g;

    /* renamed from: h  reason: collision with root package name */
    public int f50695h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;

    public c(b bVar) {
        this.f50692e = TbadkCoreApplication.getInst().getResources().getColor(R.color.white_alpha100);
        this.f50693f = R.color.CAM_X0305;
        this.f50694g = n;
        this.f50695h = o;
        this.i = q;
        this.j = 0;
        this.k = p;
        this.l = 0;
        if (bVar != null) {
            this.f50692e = bVar.f50684a;
            this.f50693f = bVar.f50685b;
            this.f50694g = bVar.f50686c;
            this.i = bVar.f50687d;
            this.f50695h = bVar.f50688e;
            this.j = bVar.f50689f;
            this.k = bVar.f50690g;
            this.l = bVar.f50691h;
        }
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f2, int i3, int i4, int i5, Paint paint) {
        canvas.save();
        canvas.translate(0.0f, this.l);
        paint.setColor(SkinManager.getColor(this.f50693f));
        paint.setAntiAlias(true);
        float descent = this.i - (paint.descent() - paint.ascent());
        float f3 = i4;
        RectF rectF = new RectF(this.j + f2, (paint.ascent() + f3) - descent, this.j + f2 + this.m + (this.f50695h * 2), paint.descent() + f3);
        int i6 = this.f50694g;
        canvas.drawRoundRect(rectF, i6, i6, paint);
        paint.setColor(this.f50692e);
        canvas.drawText(charSequence, i, i2, this.f50695h + f2 + this.j, f3 - (descent / 2.0f), paint);
        canvas.restore();
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        int measureText = (int) paint.measureText(charSequence, i, i2);
        this.m = measureText;
        return measureText + (this.f50695h * 2) + this.j + this.k;
    }
}
