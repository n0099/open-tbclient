package d.a.h0.a.q1.a.f.c;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
/* loaded from: classes3.dex */
public final class a extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: e  reason: collision with root package name */
    public final WheelView3d f43599e;

    public a(WheelView3d wheelView3d) {
        this.f43599e = wheelView3d;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        this.f43599e.q(f3);
        return true;
    }
}
