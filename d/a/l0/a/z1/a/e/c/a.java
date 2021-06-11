package d.a.l0.a.z1.a.e.c;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
/* loaded from: classes3.dex */
public final class a extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: e  reason: collision with root package name */
    public final WheelView3d f49704e;

    public a(WheelView3d wheelView3d) {
        this.f49704e = wheelView3d;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        this.f49704e.q(f3);
        return true;
    }
}
