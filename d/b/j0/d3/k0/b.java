package d.b.j0.d3.k0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Rect f55344a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f55345b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f55346c = new Rect();

    /* renamed from: d  reason: collision with root package name */
    public Context f55347d;

    /* renamed from: e  reason: collision with root package name */
    public Bundle f55348e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f55349f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f55350g;

    public b(Context context) {
        this.f55347d = context;
    }

    public void a(Canvas canvas) {
        this.f55347d.getResources().getDisplayMetrics();
        this.f55346c.set(0, 0, this.f55345b.getWidth(), this.f55345b.getHeight());
        canvas.drawBitmap(this.f55345b, this.f55346c, this.f55344a, (Paint) null);
    }
}
