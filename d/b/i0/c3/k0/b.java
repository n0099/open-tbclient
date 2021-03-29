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
    public Rect f53479a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f53480b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f53481c = new Rect();

    /* renamed from: d  reason: collision with root package name */
    public Context f53482d;

    /* renamed from: e  reason: collision with root package name */
    public Bundle f53483e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f53484f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f53485g;

    public b(Context context) {
        this.f53482d = context;
    }

    public void a(Canvas canvas) {
        this.f53482d.getResources().getDisplayMetrics();
        this.f53481c.set(0, 0, this.f53480b.getWidth(), this.f53480b.getHeight());
        canvas.drawBitmap(this.f53480b, this.f53481c, this.f53479a, (Paint) null);
    }
}
