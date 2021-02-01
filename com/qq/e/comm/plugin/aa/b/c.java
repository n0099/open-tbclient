package com.qq.e.comm.plugin.aa.b;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes15.dex */
public class c extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private long f11670a;

    /* renamed from: b  reason: collision with root package name */
    private a f11671b;

    /* loaded from: classes15.dex */
    public interface a {
        void h();
    }

    public c(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.f11671b = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f11671b != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - this.f11670a > 1000) {
                this.f11670a = elapsedRealtime;
                this.f11671b.h();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
