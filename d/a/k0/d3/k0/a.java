package d.a.k0.d3.k0;

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
    public DragLayer f53883a;

    /* renamed from: b  reason: collision with root package name */
    public Context f53884b;

    /* renamed from: c  reason: collision with root package name */
    public Vibrator f53885c;

    /* renamed from: d  reason: collision with root package name */
    public d f53886d;

    /* renamed from: e  reason: collision with root package name */
    public c f53887e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f53888f;

    /* renamed from: g  reason: collision with root package name */
    public float f53889g;

    /* renamed from: h  reason: collision with root package name */
    public float f53890h;

    /* renamed from: i  reason: collision with root package name */
    public b f53891i;
    public Rect j = new Rect();
    public Rect k;
    public int l;
    public int m;

    public a(Context context) {
        this.f53884b = context;
        this.f53885c = (Vibrator) context.getSystemService("vibrator");
        this.f53890h = this.f53884b.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a() {
        if (this.f53888f) {
            this.f53888f = false;
            this.f53891i = null;
            this.f53886d.c();
            this.f53886d.e();
            this.f53883a.a();
            this.f53883a.invalidate();
        }
    }

    public final void b(b bVar) {
        bVar.f53897f = false;
        bVar.f53898g = false;
        Rect rect = bVar.f53892a;
        int width = rect.width();
        int width2 = this.f53883a.getWidth();
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
        if (rect.left < this.l + this.f53890h) {
            bVar.f53897f = true;
            bVar.f53898g = false;
        }
        if (rect.right > (this.l + i3) - this.f53890h) {
            bVar.f53897f = false;
            bVar.f53898g = true;
        }
    }

    public boolean c(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f53889g = motionEvent.getX(0);
        } else if (action == 1 || action == 3 || action == 4 || action == 6) {
            a();
        }
        return this.f53888f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
        if (r0 != 6) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean d(MotionEvent motionEvent) {
        if (this.f53888f) {
            if (this.k == null) {
                Rect rect = new Rect();
                this.k = rect;
                this.f53883a.getDrawingRect(rect);
                Rect rect2 = this.k;
                float f2 = this.f53890h;
                rect2.top = (int) (rect2.top - f2);
                rect2.bottom = (int) (rect2.bottom + f2);
            }
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        float x = motionEvent.getX(0);
                        this.f53889g = x;
                        this.f53891i.f53892a.offset((int) (x - this.f53889g), 0);
                        b(this.f53891i);
                        i();
                    } else if (action != 3) {
                        if (action != 4) {
                        }
                    }
                }
                a();
            } else {
                this.f53889g = motionEvent.getX(0);
            }
            return true;
        }
        return false;
    }

    public void e(DragLayer dragLayer) {
        this.f53883a = dragLayer;
        dragLayer.setDragController(this);
        this.l = this.f53883a.getPaddingLeft();
        this.m = this.f53883a.getPaddingRight();
    }

    public void f(c cVar) {
        this.f53887e = cVar;
        cVar.setDragController(this);
    }

    public void g(d dVar) {
        this.f53886d = dVar;
    }

    public void h(View view, Bundle bundle) {
        if (this.f53883a == null || view == null || view.getDrawingCache() == null) {
            return;
        }
        this.f53888f = true;
        this.f53891i = new b(this.f53884b);
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        this.f53883a.offsetDescendantRectToMyCoords(view, rect);
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        this.f53891i.f53893b = Bitmap.createBitmap(view.getDrawingCache());
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        b bVar = this.f53891i;
        bVar.f53892a = rect;
        bVar.f53896e = bundle;
        view.setVisibility(4);
        b(this.f53891i);
        this.f53883a.setDragObject(this.f53891i);
        this.f53885c.vibrate(300L);
    }

    public void i() {
        this.j.set(this.f53891i.f53892a);
        this.f53883a.offsetRectIntoDescendantCoords((View) this.f53886d, this.j);
        this.f53886d.a(this.j);
        this.f53883a.invalidate();
        b bVar = this.f53891i;
        if (bVar.f53897f) {
            this.f53886d.b();
        } else if (bVar.f53898g) {
            this.f53886d.d();
        } else {
            this.f53886d.c();
        }
    }
}
