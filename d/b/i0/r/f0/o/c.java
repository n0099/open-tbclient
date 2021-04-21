package d.b.i0.r.f0.o;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class c extends ReplacementSpan {
    public Drawable i;
    public Drawable j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int r;
    public boolean s;

    /* renamed from: e  reason: collision with root package name */
    public int f51276e = R.drawable.icon_pure_evaluation_star24_n;

    /* renamed from: f  reason: collision with root package name */
    public int f51277f = R.color.CAM_X0112;

    /* renamed from: g  reason: collision with root package name */
    public int f51278g = R.drawable.icon_pure_evaluation_star24_n;

    /* renamed from: h  reason: collision with root package name */
    public int f51279h = R.color.CAM_X0305;
    public int q = 5;

    public c(int i, int i2, int i3, int i4, int i5, boolean z) {
        this.r = i;
        this.k = i2;
        this.l = i3;
        this.m = i4;
        this.o = i5;
        this.s = z;
    }

    public final void a() {
        this.i = SvgManager.getInstance().getPureDrawable(this.f51276e, this.f51277f, null);
        this.j = SvgManager.getInstance().getPureDrawable(this.f51278g, this.f51279h, null);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f2, int i3, int i4, int i5, @NonNull Paint paint) {
        int dimenPixelSize;
        int i6;
        a();
        this.n = (int) paint.getTextSize();
        int i7 = ((int) f2) + this.o;
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int i8 = 0;
        if (d.b.i0.r.u.e.a.b(charSequence)) {
            d.b.i0.r.u.e.a.a(fontMetricsInt, (int) paint.getTextSize());
            dimenPixelSize = 0 - UtilHelper.getDimenPixelSize(R.dimen.tbds3);
        } else {
            dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds3) + 0;
        }
        int max = dimenPixelSize + fontMetricsInt.ascent + i4 + Math.max(0, ((this.n - this.l) / 2) + (this.s ? (i5 - i4) / 2 : 0));
        while (true) {
            i6 = this.r;
            if (i8 >= i6) {
                break;
            }
            Drawable drawable = this.j;
            int i9 = this.l;
            drawable.setBounds(i7, max, i7 + i9, i9 + max);
            this.j.draw(canvas);
            i7 += this.k + this.l;
            i8++;
        }
        while (i6 < this.q) {
            Drawable drawable2 = this.i;
            int i10 = this.l;
            drawable2.setBounds(i7, max, i7 + i10, i10 + max);
            this.i.draw(canvas);
            i7 += this.k + this.l;
            i6++;
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        int i3 = this.q;
        int i4 = (this.l * i3) + (this.k * (i3 - 1)) + this.m + this.o;
        this.p = i4;
        return i4;
    }
}
