package com.kwad.sdk.contentalliance.home.swipe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class SwipeLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public int f33388a;

    /* renamed from: b  reason: collision with root package name */
    public float f33389b;

    /* renamed from: c  reason: collision with root package name */
    public float f33390c;

    /* renamed from: d  reason: collision with root package name */
    public int f33391d;

    /* renamed from: e  reason: collision with root package name */
    public d f33392e;

    /* renamed from: f  reason: collision with root package name */
    public List<a> f33393f;

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void b();
    }

    public SwipeLayout(@NonNull Context context) {
        super(context);
        this.f33391d = 0;
        this.f33393f = new ArrayList();
        a(context);
    }

    public SwipeLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33391d = 0;
        this.f33393f = new ArrayList();
        a(context);
    }

    public SwipeLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f33391d = 0;
        this.f33393f = new ArrayList();
        a(context);
    }

    private void a(Context context) {
        this.f33388a = ViewConfiguration.get(context).getScaledPagingTouchSlop();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0084 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(MotionEvent motionEvent) {
        StringBuilder sb;
        float f2;
        String str;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f33389b = motionEvent.getX();
            this.f33390c = motionEvent.getY();
            this.f33391d = 0;
            sb = new StringBuilder();
            sb.append("onInterceptTouchEvent ACTION_DOWN mInitialMotionX=");
            f2 = this.f33389b;
        } else if (action == 1) {
            this.f33391d = 0;
            str = "onInterceptTouchEvent ACTION_UP";
            com.kwad.sdk.core.d.a.a("SwipeLayout", str);
            if (this.f33391d != 0) {
            }
        } else if (action != 2) {
            if (action == 3) {
                this.f33391d = 0;
            }
            return this.f33391d != 0;
        } else {
            f2 = motionEvent.getX() - this.f33389b;
            float abs = Math.abs(f2);
            float abs2 = Math.abs(motionEvent.getY() - this.f33390c);
            if (abs > this.f33388a && abs > abs2) {
                if (f2 > 0.0f) {
                    this.f33391d = 1;
                } else {
                    this.f33391d = 2;
                }
            }
            sb = new StringBuilder();
            sb.append("onInterceptTouchEvent ACTION_MOVE mDragState=");
            sb.append(this.f33391d);
            sb.append("--dx=");
        }
        sb.append(f2);
        str = sb.toString();
        com.kwad.sdk.core.d.a.a("SwipeLayout", str);
        if (this.f33391d != 0) {
        }
    }

    private synchronized void b() {
        for (a aVar : this.f33393f) {
            aVar.b();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0010, code lost:
        if (r0 != 3) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a6 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b(MotionEvent motionEvent) {
        StringBuilder sb;
        float f2;
        int i2;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                com.kwad.sdk.core.d.a.a("SwipeLayout", "onTouchEvent ACTION_UP mDragState=" + this.f33391d);
                List<a> list = this.f33393f;
                if (list != null && !list.isEmpty() && (i2 = this.f33391d) != 0) {
                    if (i2 == 1) {
                        c();
                    } else if (i2 == 2) {
                        b();
                    }
                }
            } else if (action == 2) {
                f2 = motionEvent.getX() - this.f33389b;
                float abs = Math.abs(f2);
                float abs2 = Math.abs(motionEvent.getY() - this.f33390c);
                if (this.f33391d == 0 && abs > this.f33388a && abs > abs2) {
                    if (f2 > 0.0f) {
                        this.f33391d = 1;
                    } else {
                        this.f33391d = 2;
                    }
                }
                sb = new StringBuilder();
                sb.append("onTouchEvent ACTION_MOVE mDragState=");
                sb.append(this.f33391d);
                sb.append("--dx=");
            }
            this.f33391d = 0;
            return this.f33391d == 0;
        }
        sb = new StringBuilder();
        sb.append("onTouchEvent ACTION_DOWN mInitialMotionX=");
        f2 = this.f33389b;
        sb.append(f2);
        com.kwad.sdk.core.d.a.a("SwipeLayout", sb.toString());
        if (this.f33391d == 0) {
        }
    }

    private synchronized void c() {
        for (a aVar : this.f33393f) {
            aVar.a();
        }
    }

    public synchronized void a() {
        this.f33393f.clear();
    }

    public synchronized void a(@NonNull a aVar) {
        this.f33393f.add(aVar);
    }

    public synchronized boolean b(a aVar) {
        return this.f33393f.contains(aVar);
    }

    public synchronized void c(a aVar) {
        this.f33393f.remove(aVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        d dVar = this.f33392e;
        if (dVar != null) {
            dVar.d(this, motionEvent);
        }
        List<a> list = this.f33393f;
        if (list != null && !list.isEmpty()) {
            int action = motionEvent.getAction();
            boolean z = true;
            if (action == 0) {
                parent = getParent();
            } else if (action == 1 || action == 3) {
                parent = getParent();
                z = false;
            }
            parent.requestDisallowInterceptTouchEvent(z);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public synchronized List<a> getOnSwipedListeners() {
        return this.f33393f;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        d dVar = this.f33392e;
        if (dVar == null || !dVar.e(this, motionEvent)) {
            List<a> list = this.f33393f;
            return (list == null || list.isEmpty()) ? super.onInterceptTouchEvent(motionEvent) : a(motionEvent);
        }
        com.kwad.sdk.core.d.a.a("SwipeLayout", "onInterceptTouchEvent true");
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        d dVar = this.f33392e;
        if (dVar == null || !dVar.f(this, motionEvent)) {
            List<a> list = this.f33393f;
            return (list == null || list.isEmpty()) ? super.onTouchEvent(motionEvent) : b(motionEvent);
        }
        com.kwad.sdk.core.d.a.a("SwipeLayout", "handlerTouchEvent true");
        return true;
    }

    public void setTouchDetector(d dVar) {
        this.f33392e = dVar;
    }
}
