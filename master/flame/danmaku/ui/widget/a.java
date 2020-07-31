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
    private final GestureDetector ofM;
    private f ofN;
    private final GestureDetector.OnGestureListener ofP = new GestureDetector.SimpleOnGestureListener() { // from class: master.flame.danmaku.ui.widget.a.1
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
                return a.this.dWE();
            }
            return z;
        }
    };
    private RectF ofO = new RectF();

    private a(f fVar) {
        this.ofN = fVar;
        this.ofM = new GestureDetector(((View) fVar).getContext(), this.ofP);
    }

    public static synchronized a b(f fVar) {
        a aVar;
        synchronized (a.class) {
            aVar = new a(fVar);
        }
        return aVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.ofM.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(l lVar) {
        f.a onDanmakuClickListener = this.ofN.getOnDanmakuClickListener();
        if (onDanmakuClickListener != null) {
            return onDanmakuClickListener.a(lVar);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dWE() {
        f.a onDanmakuClickListener = this.ofN.getOnDanmakuClickListener();
        if (onDanmakuClickListener != null) {
            return onDanmakuClickListener.a(this.ofN);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l B(final float f, final float f2) {
        final d dVar = new d();
        this.ofO.setEmpty();
        l currentVisibleDanmakus = this.ofN.getCurrentVisibleDanmakus();
        if (currentVisibleDanmakus != null && !currentVisibleDanmakus.isEmpty()) {
            currentVisibleDanmakus.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.ui.widget.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bM(master.flame.danmaku.danmaku.model.d dVar2) {
                    if (dVar2 != null) {
                        a.this.ofO.set(dVar2.dVz(), dVar2.dVA(), dVar2.dVB(), dVar2.dVC());
                        if (a.this.ofO.contains(f, f2)) {
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
        master.flame.danmaku.danmaku.model.d dVN;
        l B = B(motionEvent.getX(), motionEvent.getY());
        return (B == null || B.isEmpty() || (dVN = B.dVN()) == null || dVN.tag == null) ? false : true;
    }
}
