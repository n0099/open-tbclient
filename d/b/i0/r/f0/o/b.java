package d.b.i0.r.f0.o;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public class b extends ReplacementSpan {

    /* renamed from: e  reason: collision with root package name */
    public int f51274e;

    /* renamed from: f  reason: collision with root package name */
    public final Paint f51275f;

    public b(int i) {
        this(i, 0);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f2, int i3, int i4, int i5, @NonNull Paint paint) {
        canvas.drawRect(f2, i3, f2 + this.f51274e, i5, this.f51275f);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        return this.f51274e;
    }

    public b(int i, int i2) {
        Paint paint = new Paint();
        this.f51275f = paint;
        this.f51274e = i;
        paint.setColor(i2);
    }
}
