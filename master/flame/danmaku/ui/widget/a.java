package master.flame.danmaku.ui.widget;

import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import master.flame.danmaku.a.f;
import master.flame.danmaku.danmaku.model.android.d;
import master.flame.danmaku.danmaku.model.l;
/* loaded from: classes5.dex */
public class a {
    private final GestureDetector nWY;
    private f nWZ;
    private final GestureDetector.OnGestureListener nXb = new GestureDetector.SimpleOnGestureListener() { // from class: master.flame.danmaku.ui.widget.a.1
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return a.this.U(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            l B = a.this.B(motionEvent.getX(), motionEvent.getY());
            boolean z = false;
            if (B != null && !B.isEmpty()) {
                z = a.this.b(B);
            }
            if (!z) {
                return a.this.dTe();
            }
            return z;
        }
    };
    private RectF nXa = new RectF();

    private a(f fVar) {
        this.nWZ = fVar;
        this.nWY = new GestureDetector(((View) fVar).getContext(), this.nXb);
    }

    public static synchronized a b(f fVar) {
        a aVar;
        synchronized (a.class) {
            aVar = new a(fVar);
        }
        return aVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.nWY.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(l lVar) {
        f.a onDanmakuClickListener = this.nWZ.getOnDanmakuClickListener();
        if (onDanmakuClickListener != null) {
            return onDanmakuClickListener.a(lVar);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dTe() {
        f.a onDanmakuClickListener = this.nWZ.getOnDanmakuClickListener();
        if (onDanmakuClickListener != null) {
            return onDanmakuClickListener.a(this.nWZ);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l B(final float f, final float f2) {
        final d dVar = new d();
        this.nXa.setEmpty();
        l currentVisibleDanmakus = this.nWZ.getCurrentVisibleDanmakus();
        if (currentVisibleDanmakus != null && !currentVisibleDanmakus.isEmpty()) {
            currentVisibleDanmakus.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.ui.widget.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bM(master.flame.danmaku.danmaku.model.d dVar2) {
                    if (dVar2 != null) {
                        a.this.nXa.set(dVar2.dRZ(), dVar2.dSa(), dVar2.dSb(), dVar2.dSc());
                        if (a.this.nXa.contains(f, f2)) {
                            dVar.k(dVar2);
                            return 0;
                        }
                        return 0;
                    }
                    return 0;
                }
            });
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean U(MotionEvent motionEvent) {
        master.flame.danmaku.danmaku.model.d dSn;
        l B = B(motionEvent.getX(), motionEvent.getY());
        return (B == null || B.isEmpty() || (dSn = B.dSn()) == null || dSn.tag == null) ? false : true;
    }
}
