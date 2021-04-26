package d.a.j0.d2.i;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class c implements View.OnTouchListener, GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener {

    /* renamed from: e  reason: collision with root package name */
    public GestureDetector f52085e = new GestureDetector(TbadkCoreApplication.getInst(), this);

    /* renamed from: f  reason: collision with root package name */
    public a f52086f;

    /* renamed from: g  reason: collision with root package name */
    public View f52087g;

    /* loaded from: classes3.dex */
    public interface a {
        boolean a(View view, MotionEvent motionEvent);

        boolean b(View view, MotionEvent motionEvent);

        boolean c(View view, MotionEvent motionEvent);
    }

    public c(a aVar) {
        this.f52086f = aVar;
    }

    public void a(View view) {
        this.f52087g = view;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        a aVar = this.f52086f;
        if (aVar != null) {
            return aVar.c(this.f52087g, motionEvent);
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        a aVar = this.f52086f;
        if (aVar != null) {
            return aVar.a(this.f52087g, motionEvent);
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        a aVar = this.f52086f;
        if (aVar != null) {
            return aVar.b(this.f52087g, motionEvent);
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.f52087g = view;
        GestureDetector gestureDetector = this.f52085e;
        if (gestureDetector != null) {
            return gestureDetector.onTouchEvent(motionEvent);
        }
        return true;
    }
}
