package d.a.n0.b1.m;

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
    public int f52892e;

    /* renamed from: f  reason: collision with root package name */
    public int f52893f;

    /* renamed from: g  reason: collision with root package name */
    public int f52894g;

    /* renamed from: h  reason: collision with root package name */
    public int f52895h;

    /* renamed from: i  reason: collision with root package name */
    public int f52896i;
    public int j;
    public int k;
    public int l;
    public int m;

    public c(b bVar) {
        this.f52892e = TbadkCoreApplication.getInst().getResources().getColor(R.color.white_alpha100);
        this.f52893f = R.color.CAM_X0305;
        this.f52894g = n;
        this.f52895h = o;
        this.f52896i = q;
        this.j = 0;
        this.k = p;
        this.l = 0;
        if (bVar != null) {
            this.f52892e = bVar.f52883a;
            this.f52893f = bVar.f52884b;
            this.f52894g = bVar.f52885c;
            this.f52896i = bVar.f52886d;
            this.f52895h = bVar.f52887e;
            this.j = bVar.f52888f;
            this.k = bVar.f52889g;
            this.l = bVar.f52890h;
        }
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        canvas.save();
        canvas.translate(0.0f, this.l);
        paint.setColor(SkinManager.getColor(this.f52893f));
        paint.setAntiAlias(true);
        float descent = this.f52896i - (paint.descent() - paint.ascent());
        float f3 = i5;
        RectF rectF = new RectF(this.j + f2, (paint.ascent() + f3) - descent, this.j + f2 + this.m + (this.f52895h * 2), paint.descent() + f3);
        int i7 = this.f52894g;
        canvas.drawRoundRect(rectF, i7, i7, paint);
        paint.setColor(this.f52892e);
        canvas.drawText(charSequence, i2, i3, this.f52895h + f2 + this.j, f3 - (descent / 2.0f), paint);
        canvas.restore();
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        int measureText = (int) paint.measureText(charSequence, i2, i3);
        this.m = measureText;
        return measureText + (this.f52895h * 2) + this.j + this.k;
    }
}
