package d.a.j0.d3.k0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Rect f53185a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f53186b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f53187c = new Rect();

    /* renamed from: d  reason: collision with root package name */
    public Context f53188d;

    /* renamed from: e  reason: collision with root package name */
    public Bundle f53189e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f53190f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f53191g;

    public b(Context context) {
        this.f53188d = context;
    }

    public void a(Canvas canvas) {
        this.f53188d.getResources().getDisplayMetrics();
        this.f53187c.set(0, 0, this.f53186b.getWidth(), this.f53186b.getHeight());
        canvas.drawBitmap(this.f53186b, this.f53187c, this.f53185a, (Paint) null);
    }
}
