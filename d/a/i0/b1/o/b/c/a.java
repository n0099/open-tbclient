package d.a.i0.b1.o.b.c;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
/* loaded from: classes3.dex */
public final class a extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: e  reason: collision with root package name */
    public final WheelView f48338e;

    public a(WheelView wheelView) {
        this.f48338e = wheelView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        this.f48338e.q(f3);
        return true;
    }
}
