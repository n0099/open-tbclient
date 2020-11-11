package master.flame.danmaku.ui.widget;

import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import master.flame.danmaku.a.f;
import master.flame.danmaku.danmaku.model.android.d;
import master.flame.danmaku.danmaku.model.l;
/* loaded from: classes6.dex */
public class a {
    private final GestureDetector pZL;
    private f pZM;
    private final GestureDetector.OnGestureListener ovm = new GestureDetector.SimpleOnGestureListener() { // from class: master.flame.danmaku.ui.widget.a.1
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return a.this.ar(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            l K = a.this.K(motionEvent.getX(), motionEvent.getY());
            boolean z = false;
            if (K != null && !K.isEmpty()) {
                z = a.this.b(K);
            }
            if (!z) {
                return a.this.eEo();
            }
            return z;
        }
    };
    private RectF pZN = new RectF();

    private a(f fVar) {
        this.pZM = fVar;
        this.pZL = new GestureDetector(((View) fVar).getContext(), this.ovm);
    }

    public static synchronized a b(f fVar) {
        a aVar;
        synchronized (a.class) {
            aVar = new a(fVar);
        }
        return aVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.pZL.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(l lVar) {
        f.a onDanmakuClickListener = this.pZM.getOnDanmakuClickListener();
        if (onDanmakuClickListener != null) {
            return onDanmakuClickListener.a(lVar);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eEo() {
        f.a onDanmakuClickListener = this.pZM.getOnDanmakuClickListener();
        if (onDanmakuClickListener != null) {
            return onDanmakuClickListener.a(this.pZM);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l K(final float f, final float f2) {
        final d dVar = new d();
        this.pZN.setEmpty();
        l currentVisibleDanmakus = this.pZM.getCurrentVisibleDanmakus();
        if (currentVisibleDanmakus != null && !currentVisibleDanmakus.isEmpty()) {
            currentVisibleDanmakus.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.ui.widget.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bX(master.flame.danmaku.danmaku.model.d dVar2) {
                    if (dVar2 != null) {
                        a.this.pZN.set(dVar2.eDj(), dVar2.eDk(), dVar2.eDl(), dVar2.eDm());
                        if (a.this.pZN.contains(f, f2)) {
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
    public boolean ar(MotionEvent motionEvent) {
        master.flame.danmaku.danmaku.model.d eDx;
        l K = K(motionEvent.getX(), motionEvent.getY());
        return (K == null || K.isEmpty() || (eDx = K.eDx()) == null || eDx.tag == null) ? false : true;
    }
}
