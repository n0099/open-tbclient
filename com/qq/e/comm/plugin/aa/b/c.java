package com.qq.e.comm.plugin.aa.b;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class c extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private long f11668a;

    /* renamed from: b  reason: collision with root package name */
    private a f11669b;

    /* loaded from: classes3.dex */
    public interface a {
        void h();
    }

    public c(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.f11669b = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f11669b != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - this.f11668a > 1000) {
                this.f11668a = elapsedRealtime;
                this.f11669b.h();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
