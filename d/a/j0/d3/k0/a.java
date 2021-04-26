package d.a.j0.d3.k0;

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
    public DragLayer f53176a;

    /* renamed from: b  reason: collision with root package name */
    public Context f53177b;

    /* renamed from: c  reason: collision with root package name */
    public Vibrator f53178c;

    /* renamed from: d  reason: collision with root package name */
    public d f53179d;

    /* renamed from: e  reason: collision with root package name */
    public c f53180e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f53181f;

    /* renamed from: g  reason: collision with root package name */
    public float f53182g;

    /* renamed from: h  reason: collision with root package name */
    public float f53183h;

    /* renamed from: i  reason: collision with root package name */
    public b f53184i;
    public Rect j = new Rect();
    public Rect k;
    public int l;
    public int m;

    public a(Context context) {
        this.f53177b = context;
        this.f53178c = (Vibrator) context.getSystemService("vibrator");
        this.f53183h = this.f53177b.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a() {
        if (this.f53181f) {
            this.f53181f = false;
            this.f53184i = null;
            this.f53179d.c();
            this.f53179d.e();
            this.f53176a.a();
            this.f53176a.invalidate();
        }
    }

    public final void b(b bVar) {
        bVar.f53190f = false;
        bVar.f53191g = false;
        Rect rect = bVar.f53185a;
        int width = rect.width();
        int width2 = this.f53176a.getWidth();
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
        if (rect.left < this.l + this.f53183h) {
            bVar.f53190f = true;
            bVar.f53191g = false;
        }
        if (rect.right > (this.l + i3) - this.f53183h) {
            bVar.f53190f = false;
            bVar.f53191g = true;
        }
    }

    public boolean c(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f53182g = motionEvent.getX(0);
        } else if (action == 1 || action == 3 || action == 4 || action == 6) {
            a();
        }
        return this.f53181f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
        if (r0 != 6) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean d(MotionEvent motionEvent) {
        if (this.f53181f) {
            if (this.k == null) {
                Rect rect = new Rect();
                this.k = rect;
                this.f53176a.getDrawingRect(rect);
                Rect rect2 = this.k;
                float f2 = this.f53183h;
                rect2.top = (int) (rect2.top - f2);
                rect2.bottom = (int) (rect2.bottom + f2);
            }
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        float x = motionEvent.getX(0);
                        this.f53182g = x;
                        this.f53184i.f53185a.offset((int) (x - this.f53182g), 0);
                        b(this.f53184i);
                        i();
                    } else if (action != 3) {
                        if (action != 4) {
                        }
                    }
                }
                a();
            } else {
                this.f53182g = motionEvent.getX(0);
            }
            return true;
        }
        return false;
    }

    public void e(DragLayer dragLayer) {
        this.f53176a = dragLayer;
        dragLayer.setDragController(this);
        this.l = this.f53176a.getPaddingLeft();
        this.m = this.f53176a.getPaddingRight();
    }

    public void f(c cVar) {
        this.f53180e = cVar;
        cVar.setDragController(this);
    }

    public void g(d dVar) {
        this.f53179d = dVar;
    }

    public void h(View view, Bundle bundle) {
        if (this.f53176a == null || view == null || view.getDrawingCache() == null) {
            return;
        }
        this.f53181f = true;
        this.f53184i = new b(this.f53177b);
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        this.f53176a.offsetDescendantRectToMyCoords(view, rect);
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        this.f53184i.f53186b = Bitmap.createBitmap(view.getDrawingCache());
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        b bVar = this.f53184i;
        bVar.f53185a = rect;
        bVar.f53189e = bundle;
        view.setVisibility(4);
        b(this.f53184i);
        this.f53176a.setDragObject(this.f53184i);
        this.f53178c.vibrate(300L);
    }

    public void i() {
        this.j.set(this.f53184i.f53185a);
        this.f53176a.offsetRectIntoDescendantCoords((View) this.f53179d, this.j);
        this.f53179d.a(this.j);
        this.f53176a.invalidate();
        b bVar = this.f53184i;
        if (bVar.f53190f) {
            this.f53179d.b();
        } else if (bVar.f53191g) {
            this.f53179d.d();
        } else {
            this.f53179d.c();
        }
    }
}
