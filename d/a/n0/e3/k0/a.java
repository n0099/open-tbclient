package d.a.n0.e3.k0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tieba.tbadkCore.imgView.DragLayer;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public DragLayer f57785a;

    /* renamed from: b  reason: collision with root package name */
    public Context f57786b;

    /* renamed from: c  reason: collision with root package name */
    public Vibrator f57787c;

    /* renamed from: d  reason: collision with root package name */
    public d f57788d;

    /* renamed from: e  reason: collision with root package name */
    public c f57789e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f57790f;

    /* renamed from: g  reason: collision with root package name */
    public float f57791g;

    /* renamed from: h  reason: collision with root package name */
    public float f57792h;

    /* renamed from: i  reason: collision with root package name */
    public b f57793i;
    public Rect j = new Rect();
    public Rect k;
    public int l;
    public int m;

    public a(Context context) {
        this.f57786b = context;
        this.f57787c = (Vibrator) context.getSystemService("vibrator");
        this.f57792h = this.f57786b.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a() {
        if (this.f57790f) {
            this.f57790f = false;
            this.f57793i = null;
            this.f57788d.c();
            this.f57788d.e();
            this.f57785a.a();
            this.f57785a.invalidate();
        }
    }

    public final void b(b bVar) {
        bVar.f57799f = false;
        bVar.f57800g = false;
        Rect rect = bVar.f57794a;
        int width = rect.width();
        int width2 = this.f57785a.getWidth();
        int i2 = this.l;
        int i3 = (width2 - i2) - this.m;
        if (rect.left < i2) {
            rect.left = i2;
            rect.right = i2 + width;
        }
        int i4 = rect.right;
        int i5 = this.l;
        if (i4 > i5 + i3) {
            int i6 = i5 + i3;
            rect.right = i6;
            rect.left = i6 - width;
        }
        if (rect.left < this.l + this.f57792h) {
            bVar.f57799f = true;
            bVar.f57800g = false;
        }
        if (rect.right > (this.l + i3) - this.f57792h) {
            bVar.f57799f = false;
            bVar.f57800g = true;
        }
    }

    public boolean c(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f57791g = motionEvent.getX(0);
        } else if (action == 1 || action == 3 || action == 4 || action == 6) {
            a();
        }
        return this.f57790f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
        if (r0 != 6) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean d(MotionEvent motionEvent) {
        if (this.f57790f) {
            if (this.k == null) {
                Rect rect = new Rect();
                this.k = rect;
                this.f57785a.getDrawingRect(rect);
                Rect rect2 = this.k;
                float f2 = this.f57792h;
                rect2.top = (int) (rect2.top - f2);
                rect2.bottom = (int) (rect2.bottom + f2);
            }
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        float x = motionEvent.getX(0);
                        this.f57791g = x;
                        this.f57793i.f57794a.offset((int) (x - this.f57791g), 0);
                        b(this.f57793i);
                        i();
                    } else if (action != 3) {
                        if (action != 4) {
                        }
                    }
                }
                a();
            } else {
                this.f57791g = motionEvent.getX(0);
            }
            return true;
        }
        return false;
    }

    public void e(DragLayer dragLayer) {
        this.f57785a = dragLayer;
        dragLayer.setDragController(this);
        this.l = this.f57785a.getPaddingLeft();
        this.m = this.f57785a.getPaddingRight();
    }

    public void f(c cVar) {
        this.f57789e = cVar;
        cVar.setDragController(this);
    }

    public void g(d dVar) {
        this.f57788d = dVar;
    }

    public void h(View view, Bundle bundle) {
        if (this.f57785a == null || view == null || view.getDrawingCache() == null) {
            return;
        }
        this.f57790f = true;
        this.f57793i = new b(this.f57786b);
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        this.f57785a.offsetDescendantRectToMyCoords(view, rect);
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        this.f57793i.f57795b = Bitmap.createBitmap(view.getDrawingCache());
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        b bVar = this.f57793i;
        bVar.f57794a = rect;
        bVar.f57798e = bundle;
        view.setVisibility(4);
        b(this.f57793i);
        this.f57785a.setDragObject(this.f57793i);
        this.f57787c.vibrate(300L);
    }

    public void i() {
        this.j.set(this.f57793i.f57794a);
        this.f57785a.offsetRectIntoDescendantCoords((View) this.f57788d, this.j);
        this.f57788d.a(this.j);
        this.f57785a.invalidate();
        b bVar = this.f57793i;
        if (bVar.f57799f) {
            this.f57788d.b();
        } else if (bVar.f57800g) {
            this.f57788d.d();
        } else {
            this.f57788d.c();
        }
    }
}
