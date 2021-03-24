package d.b.h0.b1.e;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.widget.ListAdapter;
/* loaded from: classes3.dex */
public interface d {
    void a();

    void b(Canvas canvas);

    void c(ListAdapter listAdapter);

    void onDraw(Canvas canvas);

    boolean onInterceptTouchEvent(MotionEvent motionEvent);

    void onMeasure(int i, int i2);

    void onSizeChanged(int i, int i2, int i3, int i4);

    boolean onTouchEvent(MotionEvent motionEvent);

    void requestLayout();
}
