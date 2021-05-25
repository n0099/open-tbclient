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
    public Rect f54105a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f54106b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f54107c = new Rect();

    /* renamed from: d  reason: collision with root package name */
    public Context f54108d;

    /* renamed from: e  reason: collision with root package name */
    public Bundle f54109e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f54110f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f54111g;

    public b(Context context) {
        this.f54108d = context;
    }

    public void a(Canvas canvas) {
        this.f54108d.getResources().getDisplayMetrics();
        this.f54107c.set(0, 0, this.f54106b.getWidth(), this.f54106b.getHeight());
        canvas.drawBitmap(this.f54106b, this.f54107c, this.f54105a, (Paint) null);
    }
}
