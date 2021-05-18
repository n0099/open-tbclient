package d.a.k0.d3.k0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Rect f53892a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f53893b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f53894c = new Rect();

    /* renamed from: d  reason: collision with root package name */
    public Context f53895d;

    /* renamed from: e  reason: collision with root package name */
    public Bundle f53896e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f53897f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f53898g;

    public b(Context context) {
        this.f53895d = context;
    }

    public void a(Canvas canvas) {
        this.f53895d.getResources().getDisplayMetrics();
        this.f53894c.set(0, 0, this.f53893b.getWidth(), this.f53893b.getHeight());
        canvas.drawBitmap(this.f53893b, this.f53894c, this.f53892a, (Paint) null);
    }
}
