package d.b.i0.c3.k0;

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
    public DragLayer f53470a;

    /* renamed from: b  reason: collision with root package name */
    public Context f53471b;

    /* renamed from: c  reason: collision with root package name */
    public Vibrator f53472c;

    /* renamed from: d  reason: collision with root package name */
    public d f53473d;

    /* renamed from: e  reason: collision with root package name */
    public c f53474e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f53475f;

    /* renamed from: g  reason: collision with root package name */
    public float f53476g;

    /* renamed from: h  reason: collision with root package name */
    public float f53477h;
    public b i;
    public Rect j = new Rect();
    public Rect k;
    public int l;
    public int m;

    public a(Context context) {
        this.f53471b = context;
        this.f53472c = (Vibrator) context.getSystemService("vibrator");
        this.f53477h = this.f53471b.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a() {
        if (this.f53475f) {
            this.f53475f = false;
            this.i = null;
            this.f53473d.c();
            this.f53473d.e();
            this.f53470a.a();
            this.f53470a.invalidate();
        }
    }

    public final void b(b bVar) {
        bVar.f53483f = false;
        bVar.f53484g = false;
        Rect rect = bVar.f53478a;
        int width = rect.width();
        int width2 = this.f53470a.getWidth();
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
        if (rect.left < this.l + this.f53477h) {
            bVar.f53483f = true;
            bVar.f53484g = false;
        }
        if (rect.right > (this.l + i2) - this.f53477h) {
            bVar.f53483f = false;
            bVar.f53484g = true;
        }
    }

    public boolean c(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f53476g = motionEvent.getX(0);
        } else if (action == 1 || action == 3 || action == 4 || action == 6) {
            a();
        }
        return this.f53475f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
        if (r0 != 6) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean d(MotionEvent motionEvent) {
        if (this.f53475f) {
            if (this.k == null) {
                Rect rect = new Rect();
                this.k = rect;
                this.f53470a.getDrawingRect(rect);
                Rect rect2 = this.k;
                float f2 = this.f53477h;
                rect2.top = (int) (rect2.top - f2);
                rect2.bottom = (int) (rect2.bottom + f2);
            }
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        float x = motionEvent.getX(0);
                        this.f53476g = x;
                        this.i.f53478a.offset((int) (x - this.f53476g), 0);
                        b(this.i);
                        i();
                    } else if (action != 3) {
                        if (action != 4) {
                        }
                    }
                }
                a();
            } else {
                this.f53476g = motionEvent.getX(0);
            }
            return true;
        }
        return false;
    }

    public void e(DragLayer dragLayer) {
        this.f53470a = dragLayer;
        dragLayer.setDragController(this);
        this.l = this.f53470a.getPaddingLeft();
        this.m = this.f53470a.getPaddingRight();
    }

    public void f(c cVar) {
        this.f53474e = cVar;
        cVar.setDragController(this);
    }

    public void g(d dVar) {
        this.f53473d = dVar;
    }

    public void h(View view, Bundle bundle) {
        if (this.f53470a == null || view == null || view.getDrawingCache() == null) {
            return;
        }
        this.f53475f = true;
        this.i = new b(this.f53471b);
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        this.f53470a.offsetDescendantRectToMyCoords(view, rect);
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        this.i.f53479b = Bitmap.createBitmap(view.getDrawingCache());
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        b bVar = this.i;
        bVar.f53478a = rect;
        bVar.f53482e = bundle;
        view.setVisibility(4);
        b(this.i);
        this.f53470a.setDragObject(this.i);
        this.f53472c.vibrate(300L);
    }

    public void i() {
        this.j.set(this.i.f53478a);
        this.f53470a.offsetRectIntoDescendantCoords((View) this.f53473d, this.j);
        this.f53473d.a(this.j);
        this.f53470a.invalidate();
        b bVar = this.i;
        if (bVar.f53483f) {
            this.f53473d.b();
        } else if (bVar.f53484g) {
            this.f53473d.d();
        } else {
            this.f53473d.c();
        }
    }
}
