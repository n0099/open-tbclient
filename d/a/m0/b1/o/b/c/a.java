package d.a.m0.b1.o.b.c;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
/* loaded from: classes3.dex */
public final class a extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: e  reason: collision with root package name */
    public final WheelView f52865e;

    public a(WheelView wheelView) {
        this.f52865e = wheelView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        this.f52865e.q(f3);
        return true;
    }
}
