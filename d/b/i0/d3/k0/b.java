package d.b.i0.d3.k0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Rect f54923a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f54924b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f54925c = new Rect();

    /* renamed from: d  reason: collision with root package name */
    public Context f54926d;

    /* renamed from: e  reason: collision with root package name */
    public Bundle f54927e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f54928f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f54929g;

    public b(Context context) {
        this.f54926d = context;
    }

    public void a(Canvas canvas) {
        this.f54926d.getResources().getDisplayMetrics();
        this.f54925c.set(0, 0, this.f54924b.getWidth(), this.f54924b.getHeight());
        canvas.drawBitmap(this.f54924b, this.f54925c, this.f54923a, (Paint) null);
    }
}
