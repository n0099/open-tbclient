package d.a.o0.e3.k0;

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
    public DragLayer f57910a;

    /* renamed from: b  reason: collision with root package name */
    public Context f57911b;

    /* renamed from: c  reason: collision with root package name */
    public Vibrator f57912c;

    /* renamed from: d  reason: collision with root package name */
    public d f57913d;

    /* renamed from: e  reason: collision with root package name */
    public c f57914e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f57915f;

    /* renamed from: g  reason: collision with root package name */
    public float f57916g;

    /* renamed from: h  reason: collision with root package name */
    public float f57917h;

    /* renamed from: i  reason: collision with root package name */
    public b f57918i;
    public Rect j = new Rect();
    public Rect k;
    public int l;
    public int m;

    public a(Context context) {
        this.f57911b = context;
        this.f57912c = (Vibrator) context.getSystemService("vibrator");
        this.f57917h = this.f57911b.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a() {
        if (this.f57915f) {
            this.f57915f = false;
            this.f57918i = null;
            this.f57913d.c();
            this.f57913d.e();
            this.f57910a.a();
            this.f57910a.invalidate();
        }
    }

    public final void b(b bVar) {
        bVar.f57924f = false;
        bVar.f57925g = false;
        Rect rect = bVar.f57919a;
        int width = rect.width();
        int width2 = this.f57910a.getWidth();
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
        if (rect.left < this.l + this.f57917h) {
            bVar.f57924f = true;
            bVar.f57925g = false;
        }
        if (rect.right > (this.l + i3) - this.f57917h) {
            bVar.f57924f = false;
            bVar.f57925g = true;
        }
    }

    public boolean c(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f57916g = motionEvent.getX(0);
        } else if (action == 1 || action == 3 || action == 4 || action == 6) {
            a();
        }
        return this.f57915f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
        if (r0 != 6) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean d(MotionEvent motionEvent) {
        if (this.f57915f) {
            if (this.k == null) {
                Rect rect = new Rect();
                this.k = rect;
                this.f57910a.getDrawingRect(rect);
                Rect rect2 = this.k;
                float f2 = this.f57917h;
                rect2.top = (int) (rect2.top - f2);
                rect2.bottom = (int) (rect2.bottom + f2);
            }
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        float x = motionEvent.getX(0);
                        this.f57916g = x;
                        this.f57918i.f57919a.offset((int) (x - this.f57916g), 0);
                        b(this.f57918i);
                        i();
                    } else if (action != 3) {
                        if (action != 4) {
                        }
                    }
                }
                a();
            } else {
                this.f57916g = motionEvent.getX(0);
            }
            return true;
        }
        return false;
    }

    public void e(DragLayer dragLayer) {
        this.f57910a = dragLayer;
        dragLayer.setDragController(this);
        this.l = this.f57910a.getPaddingLeft();
        this.m = this.f57910a.getPaddingRight();
    }

    public void f(c cVar) {
        this.f57914e = cVar;
        cVar.setDragController(this);
    }

    public void g(d dVar) {
        this.f57913d = dVar;
    }

    public void h(View view, Bundle bundle) {
        if (this.f57910a == null || view == null || view.getDrawingCache() == null) {
            return;
        }
        this.f57915f = true;
        this.f57918i = new b(this.f57911b);
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        this.f57910a.offsetDescendantRectToMyCoords(view, rect);
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        this.f57918i.f57920b = Bitmap.createBitmap(view.getDrawingCache());
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        b bVar = this.f57918i;
        bVar.f57919a = rect;
        bVar.f57923e = bundle;
        view.setVisibility(4);
        b(this.f57918i);
        this.f57910a.setDragObject(this.f57918i);
        this.f57912c.vibrate(300L);
    }

    public void i() {
        this.j.set(this.f57918i.f57919a);
        this.f57910a.offsetRectIntoDescendantCoords((View) this.f57913d, this.j);
        this.f57913d.a(this.j);
        this.f57910a.invalidate();
        b bVar = this.f57918i;
        if (bVar.f57924f) {
            this.f57913d.b();
        } else if (bVar.f57925g) {
            this.f57913d.d();
        } else {
            this.f57913d.c();
        }
    }
}
