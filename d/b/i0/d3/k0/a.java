package d.b.i0.d3.k0;

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
    public DragLayer f54915a;

    /* renamed from: b  reason: collision with root package name */
    public Context f54916b;

    /* renamed from: c  reason: collision with root package name */
    public Vibrator f54917c;

    /* renamed from: d  reason: collision with root package name */
    public d f54918d;

    /* renamed from: e  reason: collision with root package name */
    public c f54919e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f54920f;

    /* renamed from: g  reason: collision with root package name */
    public float f54921g;

    /* renamed from: h  reason: collision with root package name */
    public float f54922h;
    public b i;
    public Rect j = new Rect();
    public Rect k;
    public int l;
    public int m;

    public a(Context context) {
        this.f54916b = context;
        this.f54917c = (Vibrator) context.getSystemService("vibrator");
        this.f54922h = this.f54916b.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a() {
        if (this.f54920f) {
            this.f54920f = false;
            this.i = null;
            this.f54918d.c();
            this.f54918d.e();
            this.f54915a.a();
            this.f54915a.invalidate();
        }
    }

    public final void b(b bVar) {
        bVar.f54928f = false;
        bVar.f54929g = false;
        Rect rect = bVar.f54923a;
        int width = rect.width();
        int width2 = this.f54915a.getWidth();
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
        if (rect.left < this.l + this.f54922h) {
            bVar.f54928f = true;
            bVar.f54929g = false;
        }
        if (rect.right > (this.l + i2) - this.f54922h) {
            bVar.f54928f = false;
            bVar.f54929g = true;
        }
    }

    public boolean c(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f54921g = motionEvent.getX(0);
        } else if (action == 1 || action == 3 || action == 4 || action == 6) {
            a();
        }
        return this.f54920f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
        if (r0 != 6) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean d(MotionEvent motionEvent) {
        if (this.f54920f) {
            if (this.k == null) {
                Rect rect = new Rect();
                this.k = rect;
                this.f54915a.getDrawingRect(rect);
                Rect rect2 = this.k;
                float f2 = this.f54922h;
                rect2.top = (int) (rect2.top - f2);
                rect2.bottom = (int) (rect2.bottom + f2);
            }
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        float x = motionEvent.getX(0);
                        this.f54921g = x;
                        this.i.f54923a.offset((int) (x - this.f54921g), 0);
                        b(this.i);
                        i();
                    } else if (action != 3) {
                        if (action != 4) {
                        }
                    }
                }
                a();
            } else {
                this.f54921g = motionEvent.getX(0);
            }
            return true;
        }
        return false;
    }

    public void e(DragLayer dragLayer) {
        this.f54915a = dragLayer;
        dragLayer.setDragController(this);
        this.l = this.f54915a.getPaddingLeft();
        this.m = this.f54915a.getPaddingRight();
    }

    public void f(c cVar) {
        this.f54919e = cVar;
        cVar.setDragController(this);
    }

    public void g(d dVar) {
        this.f54918d = dVar;
    }

    public void h(View view, Bundle bundle) {
        if (this.f54915a == null || view == null || view.getDrawingCache() == null) {
            return;
        }
        this.f54920f = true;
        this.i = new b(this.f54916b);
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        this.f54915a.offsetDescendantRectToMyCoords(view, rect);
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        this.i.f54924b = Bitmap.createBitmap(view.getDrawingCache());
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        b bVar = this.i;
        bVar.f54923a = rect;
        bVar.f54927e = bundle;
        view.setVisibility(4);
        b(this.i);
        this.f54915a.setDragObject(this.i);
        this.f54917c.vibrate(300L);
    }

    public void i() {
        this.j.set(this.i.f54923a);
        this.f54915a.offsetRectIntoDescendantCoords((View) this.f54918d, this.j);
        this.f54918d.a(this.j);
        this.f54915a.invalidate();
        b bVar = this.i;
        if (bVar.f54928f) {
            this.f54918d.b();
        } else if (bVar.f54929g) {
            this.f54918d.d();
        } else {
            this.f54918d.c();
        }
    }
}
