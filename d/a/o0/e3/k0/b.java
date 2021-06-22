package d.a.o0.e3.k0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Rect f57919a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f57920b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f57921c = new Rect();

    /* renamed from: d  reason: collision with root package name */
    public Context f57922d;

    /* renamed from: e  reason: collision with root package name */
    public Bundle f57923e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f57924f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f57925g;

    public b(Context context) {
        this.f57922d = context;
    }

    public void a(Canvas canvas) {
        this.f57922d.getResources().getDisplayMetrics();
        this.f57921c.set(0, 0, this.f57920b.getWidth(), this.f57920b.getHeight());
        canvas.drawBitmap(this.f57920b, this.f57921c, this.f57919a, (Paint) null);
    }
}
