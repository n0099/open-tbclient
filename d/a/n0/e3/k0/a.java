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
    public DragLayer f54096a;

    /* renamed from: b  reason: collision with root package name */
    public Context f54097b;

    /* renamed from: c  reason: collision with root package name */
    public Vibrator f54098c;

    /* renamed from: d  reason: collision with root package name */
    public d f54099d;

    /* renamed from: e  reason: collision with root package name */
    public c f54100e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f54101f;

    /* renamed from: g  reason: collision with root package name */
    public float f54102g;

    /* renamed from: h  reason: collision with root package name */
    public float f54103h;

    /* renamed from: i  reason: collision with root package name */
    public b f54104i;
    public Rect j = new Rect();
    public Rect k;
    public int l;
    public int m;

    public a(Context context) {
        this.f54097b = context;
        this.f54098c = (Vibrator) context.getSystemService("vibrator");
        this.f54103h = this.f54097b.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a() {
        if (this.f54101f) {
            this.f54101f = false;
            this.f54104i = null;
            this.f54099d.c();
            this.f54099d.e();
            this.f54096a.a();
            this.f54096a.invalidate();
        }
    }

    public final void b(b bVar) {
        bVar.f54110f = false;
        bVar.f54111g = false;
        Rect rect = bVar.f54105a;
        int width = rect.width();
        int width2 = this.f54096a.getWidth();
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
        if (rect.left < this.l + this.f54103h) {
            bVar.f54110f = true;
            bVar.f54111g = false;
        }
        if (rect.right > (this.l + i3) - this.f54103h) {
            bVar.f54110f = false;
            bVar.f54111g = true;
        }
    }

    public boolean c(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f54102g = motionEvent.getX(0);
        } else if (action == 1 || action == 3 || action == 4 || action == 6) {
            a();
        }
        return this.f54101f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
        if (r0 != 6) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean d(MotionEvent motionEvent) {
        if (this.f54101f) {
            if (this.k == null) {
                Rect rect = new Rect();
                this.k = rect;
                this.f54096a.getDrawingRect(rect);
                Rect rect2 = this.k;
                float f2 = this.f54103h;
                rect2.top = (int) (rect2.top - f2);
                rect2.bottom = (int) (rect2.bottom + f2);
            }
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        float x = motionEvent.getX(0);
                        this.f54102g = x;
                        this.f54104i.f54105a.offset((int) (x - this.f54102g), 0);
                        b(this.f54104i);
                        i();
                    } else if (action != 3) {
                        if (action != 4) {
                        }
                    }
                }
                a();
            } else {
                this.f54102g = motionEvent.getX(0);
            }
            return true;
        }
        return false;
    }

    public void e(DragLayer dragLayer) {
        this.f54096a = dragLayer;
        dragLayer.setDragController(this);
        this.l = this.f54096a.getPaddingLeft();
        this.m = this.f54096a.getPaddingRight();
    }

    public void f(c cVar) {
        this.f54100e = cVar;
        cVar.setDragController(this);
    }

    public void g(d dVar) {
        this.f54099d = dVar;
    }

    public void h(View view, Bundle bundle) {
        if (this.f54096a == null || view == null || view.getDrawingCache() == null) {
            return;
        }
        this.f54101f = true;
        this.f54104i = new b(this.f54097b);
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        this.f54096a.offsetDescendantRectToMyCoords(view, rect);
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        this.f54104i.f54106b = Bitmap.createBitmap(view.getDrawingCache());
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        b bVar = this.f54104i;
        bVar.f54105a = rect;
        bVar.f54109e = bundle;
        view.setVisibility(4);
        b(this.f54104i);
        this.f54096a.setDragObject(this.f54104i);
        this.f54098c.vibrate(300L);
    }

    public void i() {
        this.j.set(this.f54104i.f54105a);
        this.f54096a.offsetRectIntoDescendantCoords((View) this.f54099d, this.j);
        this.f54099d.a(this.j);
        this.f54096a.invalidate();
        b bVar = this.f54104i;
        if (bVar.f54110f) {
            this.f54099d.b();
        } else if (bVar.f54111g) {
            this.f54099d.d();
        } else {
            this.f54099d.c();
        }
    }
}
