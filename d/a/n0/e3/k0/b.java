package d.a.n0.e3.k0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Rect f57794a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f57795b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f57796c = new Rect();

    /* renamed from: d  reason: collision with root package name */
    public Context f57797d;

    /* renamed from: e  reason: collision with root package name */
    public Bundle f57798e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f57799f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f57800g;

    public b(Context context) {
        this.f57797d = context;
    }

    public void a(Canvas canvas) {
        this.f57797d.getResources().getDisplayMetrics();
        this.f57796c.set(0, 0, this.f57795b.getWidth(), this.f57795b.getHeight());
        canvas.drawBitmap(this.f57795b, this.f57796c, this.f57794a, (Paint) null);
    }
}
