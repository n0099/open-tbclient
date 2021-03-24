package d.b.i0.c3.k0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Rect f53478a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f53479b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f53480c = new Rect();

    /* renamed from: d  reason: collision with root package name */
    public Context f53481d;

    /* renamed from: e  reason: collision with root package name */
    public Bundle f53482e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f53483f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f53484g;

    public b(Context context) {
        this.f53481d = context;
    }

    public void a(Canvas canvas) {
        this.f53481d.getResources().getDisplayMetrics();
        this.f53480c.set(0, 0, this.f53479b.getWidth(), this.f53479b.getHeight());
        canvas.drawBitmap(this.f53479b, this.f53480c, this.f53478a, (Paint) null);
    }
}
