package d.a.n0.r.f0.o;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public class b extends ReplacementSpan {

    /* renamed from: e  reason: collision with root package name */
    public int f53541e;

    /* renamed from: f  reason: collision with root package name */
    public final Paint f53542f;

    public b(int i2) {
        this(i2, 0);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, @NonNull Paint paint) {
        canvas.drawRect(f2, i4, f2 + this.f53541e, i6, this.f53542f);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i2, int i3, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        return this.f53541e;
    }

    public b(int i2, int i3) {
        Paint paint = new Paint();
        this.f53542f = paint;
        this.f53541e = i2;
        paint.setColor(i3);
    }
}
