package com.kwad.sdk.contentalliance.home.swipe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class SwipeLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f9044a;

    /* renamed from: b  reason: collision with root package name */
    private float f9045b;
    private float c;
    private int d;
    private d e;
    private List<a> f;

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void b();
    }

    public SwipeLayout(@NonNull Context context) {
        super(context);
        this.d = 0;
        this.f = new ArrayList();
        a(context);
    }

    public SwipeLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 0;
        this.f = new ArrayList();
        a(context);
    }

    public SwipeLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 0;
        this.f = new ArrayList();
        a(context);
    }

    private void a(Context context) {
        this.f9044a = ViewConfiguration.get(context).getScaledPagingTouchSlop();
    }

    private boolean a(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.f9045b = motionEvent.getX();
                this.c = motionEvent.getY();
                this.d = 0;
                com.kwad.sdk.core.d.a.a("SwipeLayout", "onInterceptTouchEvent ACTION_DOWN mInitialMotionX=" + this.f9045b);
                break;
            case 1:
                this.d = 0;
                com.kwad.sdk.core.d.a.a("SwipeLayout", "onInterceptTouchEvent ACTION_UP");
                break;
            case 2:
                float x = motionEvent.getX() - this.f9045b;
                float abs = Math.abs(x);
                float abs2 = Math.abs(motionEvent.getY() - this.c);
                if (abs > this.f9044a && abs > abs2) {
                    if (x > 0.0f) {
                        this.d = 1;
                    } else {
                        this.d = 2;
                    }
                }
                com.kwad.sdk.core.d.a.a("SwipeLayout", "onInterceptTouchEvent ACTION_MOVE mDragState=" + this.d + "--dx=" + x);
                break;
            case 3:
                this.d = 0;
                break;
        }
        return this.d != 0;
    }

    private synchronized void b() {
        for (a aVar : this.f) {
            aVar.b();
        }
    }

    private boolean b(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                com.kwad.sdk.core.d.a.a("SwipeLayout", "onTouchEvent ACTION_DOWN mInitialMotionX=" + this.f9045b);
                break;
            case 1:
                com.kwad.sdk.core.d.a.a("SwipeLayout", "onTouchEvent ACTION_UP mDragState=" + this.d);
                if (this.f != null && !this.f.isEmpty() && this.d != 0) {
                    if (this.d == 1) {
                        c();
                    } else if (this.d == 2) {
                        b();
                    }
                }
                this.d = 0;
                break;
            case 2:
                float x = motionEvent.getX() - this.f9045b;
                float abs = Math.abs(x);
                float abs2 = Math.abs(motionEvent.getY() - this.c);
                if (this.d == 0 && abs > this.f9044a && abs > abs2) {
                    if (x > 0.0f) {
                        this.d = 1;
                    } else {
                        this.d = 2;
                    }
                }
                com.kwad.sdk.core.d.a.a("SwipeLayout", "onTouchEvent ACTION_MOVE mDragState=" + this.d + "--dx=" + x);
                break;
            case 3:
                this.d = 0;
                break;
        }
        return this.d != 0;
    }

    private synchronized void c() {
        for (a aVar : this.f) {
            aVar.a();
        }
    }

    public synchronized void a() {
        this.f.clear();
    }

    public synchronized void a(@NonNull a aVar) {
        this.f.add(aVar);
    }

    public synchronized boolean b(a aVar) {
        return this.f.contains(aVar);
    }

    public synchronized void c(a aVar) {
        this.f.remove(aVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.e != null) {
            this.e.d(this, motionEvent);
        }
        if (this.f != null && !this.f.isEmpty()) {
            switch (motionEvent.getAction()) {
                case 0:
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                case 1:
                case 3:
                    getParent().requestDisallowInterceptTouchEvent(false);
                    break;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public synchronized List<a> getOnSwipedListeners() {
        return this.f;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.e == null || !this.e.e(this, motionEvent)) {
            return (this.f == null || this.f.isEmpty()) ? super.onInterceptTouchEvent(motionEvent) : a(motionEvent);
        }
        com.kwad.sdk.core.d.a.a("SwipeLayout", "onInterceptTouchEvent true");
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.e == null || !this.e.f(this, motionEvent)) {
            return (this.f == null || this.f.isEmpty()) ? super.onTouchEvent(motionEvent) : b(motionEvent);
        }
        com.kwad.sdk.core.d.a.a("SwipeLayout", "handlerTouchEvent true");
        return true;
    }

    public void setTouchDetector(d dVar) {
        this.e = dVar;
    }
}
