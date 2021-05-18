package d.a.j0.r.f0.o;

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

    /* renamed from: i  reason: collision with root package name */
    public Drawable f49721i;
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
    public int f49717e = R.drawable.icon_pure_evaluation_star24_n;

    /* renamed from: f  reason: collision with root package name */
    public int f49718f = R.color.CAM_X0112;

    /* renamed from: g  reason: collision with root package name */
    public int f49719g = R.drawable.icon_pure_evaluation_star24_n;

    /* renamed from: h  reason: collision with root package name */
    public int f49720h = R.color.CAM_X0305;
    public int q = 5;

    public c(int i2, int i3, int i4, int i5, int i6, boolean z) {
        this.r = i2;
        this.k = i3;
        this.l = i4;
        this.m = i5;
        this.o = i6;
        this.s = z;
    }

    public final void a() {
        this.f49721i = SvgManager.getInstance().getPureDrawable(this.f49717e, this.f49718f, null);
        this.j = SvgManager.getInstance().getPureDrawable(this.f49719g, this.f49720h, null);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, @NonNull Paint paint) {
        int dimenPixelSize;
        int i7;
        a();
        this.n = (int) paint.getTextSize();
        int i8 = ((int) f2) + this.o;
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int i9 = 0;
        if (d.a.j0.r.u.e.a.b(charSequence)) {
            d.a.j0.r.u.e.a.a(fontMetricsInt, (int) paint.getTextSize());
            dimenPixelSize = 0 - UtilHelper.getDimenPixelSize(R.dimen.tbds3);
        } else {
            dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds3) + 0;
        }
        int max = dimenPixelSize + fontMetricsInt.ascent + i5 + Math.max(0, ((this.n - this.l) / 2) + (this.s ? (i6 - i5) / 2 : 0));
        while (true) {
            i7 = this.r;
            if (i9 >= i7) {
                break;
            }
            Drawable drawable = this.j;
            int i10 = this.l;
            drawable.setBounds(i8, max, i8 + i10, i10 + max);
            this.j.draw(canvas);
            i8 += this.k + this.l;
            i9++;
        }
        while (i7 < this.q) {
            Drawable drawable2 = this.f49721i;
            int i11 = this.l;
            drawable2.setBounds(i8, max, i8 + i11, i11 + max);
            this.f49721i.draw(canvas);
            i8 += this.k + this.l;
            i7++;
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i2, int i3, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        int i4 = this.q;
        int i5 = (this.l * i4) + (this.k * (i4 - 1)) + this.m + this.o;
        this.p = i5;
        return i5;
    }
}
