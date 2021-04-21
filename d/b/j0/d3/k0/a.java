package d.b.j0.d3.k0;

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
    public DragLayer f55336a;

    /* renamed from: b  reason: collision with root package name */
    public Context f55337b;

    /* renamed from: c  reason: collision with root package name */
    public Vibrator f55338c;

    /* renamed from: d  reason: collision with root package name */
    public d f55339d;

    /* renamed from: e  reason: collision with root package name */
    public c f55340e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f55341f;

    /* renamed from: g  reason: collision with root package name */
    public float f55342g;

    /* renamed from: h  reason: collision with root package name */
    public float f55343h;
    public b i;
    public Rect j = new Rect();
    public Rect k;
    public int l;
    public int m;

    public a(Context context) {
        this.f55337b = context;
        this.f55338c = (Vibrator) context.getSystemService("vibrator");
        this.f55343h = this.f55337b.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a() {
        if (this.f55341f) {
            this.f55341f = false;
            this.i = null;
            this.f55339d.c();
            this.f55339d.e();
            this.f55336a.a();
            this.f55336a.invalidate();
        }
    }

    public final void b(b bVar) {
        bVar.f55349f = false;
        bVar.f55350g = false;
        Rect rect = bVar.f55344a;
        int width = rect.width();
        int width2 = this.f55336a.getWidth();
        int i = this.l;
        int i2 = (width2 - i) - this.m;
        if (rect.left < i) {
            rect.left = i;
            rect.right = i + width;
        }
        int i3 = rect.right;
        int i4 = this.l;
        if (i3 > i4 + i2) {
            int i5 = i4 + i2;
            rect.right = i5;
            rect.left = i5 - width;
        }
        if (rect.left < this.l + this.f55343h) {
            bVar.f55349f = true;
            bVar.f55350g = false;
        }
        if (rect.right > (this.l + i2) - this.f55343h) {
            bVar.f55349f = false;
            bVar.f55350g = true;
        }
    }

    public boolean c(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f55342g = motionEvent.getX(0);
        } else if (action == 1 || action == 3 || action == 4 || action == 6) {
            a();
        }
        return this.f55341f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
        if (r0 != 6) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean d(MotionEvent motionEvent) {
        if (this.f55341f) {
            if (this.k == null) {
                Rect rect = new Rect();
                this.k = rect;
                this.f55336a.getDrawingRect(rect);
                Rect rect2 = this.k;
                float f2 = this.f55343h;
                rect2.top = (int) (rect2.top - f2);
                rect2.bottom = (int) (rect2.bottom + f2);
            }
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        float x = motionEvent.getX(0);
                        this.f55342g = x;
                        this.i.f55344a.offset((int) (x - this.f55342g), 0);
                        b(this.i);
                        i();
                    } else if (action != 3) {
                        if (action != 4) {
                        }
                    }
                }
                a();
            } else {
                this.f55342g = motionEvent.getX(0);
            }
            return true;
        }
        return false;
    }

    public void e(DragLayer dragLayer) {
        this.f55336a = dragLayer;
        dragLayer.setDragController(this);
        this.l = this.f55336a.getPaddingLeft();
        this.m = this.f55336a.getPaddingRight();
    }

    public void f(c cVar) {
        this.f55340e = cVar;
        cVar.setDragController(this);
    }

    public void g(d dVar) {
        this.f55339d = dVar;
    }

    public void h(View view, Bundle bundle) {
        if (this.f55336a == null || view == null || view.getDrawingCache() == null) {
            return;
        }
        this.f55341f = true;
        this.i = new b(this.f55337b);
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        this.f55336a.offsetDescendantRectToMyCoords(view, rect);
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        this.i.f55345b = Bitmap.createBitmap(view.getDrawingCache());
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        b bVar = this.i;
        bVar.f55344a = rect;
        bVar.f55348e = bundle;
        view.setVisibility(4);
        b(this.i);
        this.f55336a.setDragObject(this.i);
        this.f55338c.vibrate(300L);
    }

    public void i() {
        this.j.set(this.i.f55344a);
        this.f55336a.offsetRectIntoDescendantCoords((View) this.f55339d, this.j);
        this.f55339d.a(this.j);
        this.f55336a.invalidate();
        b bVar = this.i;
        if (bVar.f55349f) {
            this.f55339d.b();
        } else if (bVar.f55350g) {
            this.f55339d.d();
        } else {
            this.f55339d.c();
        }
    }
}
