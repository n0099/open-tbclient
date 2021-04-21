package d.b.i0.b1.e;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListAdapter;
import android.widget.ListView;
/* loaded from: classes3.dex */
public interface c {
    void a();

    void b(Canvas canvas);

    void c(ListAdapter listAdapter);

    void d(ListView listView, Context context, AttributeSet attributeSet);

    void onDraw(Canvas canvas);

    boolean onInterceptTouchEvent(MotionEvent motionEvent);

    void onMeasure(int i, int i2);

    void onSizeChanged(int i, int i2, int i3, int i4);

    boolean onTouchEvent(MotionEvent motionEvent);

    void requestLayout();
}
