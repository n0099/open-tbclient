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
    public DragLayer f53471a;

    /* renamed from: b  reason: collision with root package name */
    public Context f53472b;

    /* renamed from: c  reason: collision with root package name */
    public Vibrator f53473c;

    /* renamed from: d  reason: collision with root package name */
    public d f53474d;

    /* renamed from: e  reason: collision with root package name */
    public c f53475e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f53476f;

    /* renamed from: g  reason: collision with root package name */
    public float f53477g;

    /* renamed from: h  reason: collision with root package name */
    public float f53478h;
    public b i;
    public Rect j = new Rect();
    public Rect k;
    public int l;
    public int m;

    public a(Context context) {
        this.f53472b = context;
        this.f53473c = (Vibrator) context.getSystemService("vibrator");
        this.f53478h = this.f53472b.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a() {
        if (this.f53476f) {
            this.f53476f = false;
            this.i = null;
            this.f53474d.c();
            this.f53474d.e();
            this.f53471a.a();
            this.f53471a.invalidate();
        }
    }

    public final void b(b bVar) {
        bVar.f53484f = false;
        bVar.f53485g = false;
        Rect rect = bVar.f53479a;
        int width = rect.width();
        int width2 = this.f53471a.getWidth();
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
        if (rect.left < this.l + this.f53478h) {
            bVar.f53484f = true;
            bVar.f53485g = false;
        }
        if (rect.right > (this.l + i2) - this.f53478h) {
            bVar.f53484f = false;
            bVar.f53485g = true;
        }
    }

    public boolean c(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f53477g = motionEvent.getX(0);
        } else if (action == 1 || action == 3 || action == 4 || action == 6) {
            a();
        }
        return this.f53476f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
        if (r0 != 6) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean d(MotionEvent motionEvent) {
        if (this.f53476f) {
            if (this.k == null) {
                Rect rect = new Rect();
                this.k = rect;
                this.f53471a.getDrawingRect(rect);
                Rect rect2 = this.k;
                float f2 = this.f53478h;
                rect2.top = (int) (rect2.top - f2);
                rect2.bottom = (int) (rect2.bottom + f2);
            }
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        float x = motionEvent.getX(0);
                        this.f53477g = x;
                        this.i.f53479a.offset((int) (x - this.f53477g), 0);
                        b(this.i);
                        i();
                    } else if (action != 3) {
                        if (action != 4) {
                        }
                    }
                }
                a();
            } else {
                this.f53477g = motionEvent.getX(0);
            }
            return true;
        }
        return false;
    }

    public void e(DragLayer dragLayer) {
        this.f53471a = dragLayer;
        dragLayer.setDragController(this);
        this.l = this.f53471a.getPaddingLeft();
        this.m = this.f53471a.getPaddingRight();
    }

    public void f(c cVar) {
        this.f53475e = cVar;
        cVar.setDragController(this);
    }

    public void g(d dVar) {
        this.f53474d = dVar;
    }

    public void h(View view, Bundle bundle) {
        if (this.f53471a == null || view == null || view.getDrawingCache() == null) {
            return;
        }
        this.f53476f = true;
        this.i = new b(this.f53472b);
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        this.f53471a.offsetDescendantRectToMyCoords(view, rect);
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        this.i.f53480b = Bitmap.createBitmap(view.getDrawingCache());
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        b bVar = this.i;
        bVar.f53479a = rect;
        bVar.f53483e = bundle;
        view.setVisibility(4);
        b(this.i);
        this.f53471a.setDragObject(this.i);
        this.f53473c.vibrate(300L);
    }

    public void i() {
        this.j.set(this.i.f53479a);
        this.f53471a.offsetRectIntoDescendantCoords((View) this.f53474d, this.j);
        this.f53474d.a(this.j);
        this.f53471a.invalidate();
        b bVar = this.i;
        if (bVar.f53484f) {
            this.f53474d.b();
        } else if (bVar.f53485g) {
            this.f53474d.d();
        } else {
            this.f53474d.c();
        }
    }
}
