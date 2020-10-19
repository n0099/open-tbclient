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
    private final GestureDetector oYV;
    private f oYW;
    private final GestureDetector.OnGestureListener oYY = new GestureDetector.SimpleOnGestureListener() { // from class: master.flame.danmaku.ui.widget.a.1
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return a.this.ao(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            l H = a.this.H(motionEvent.getX(), motionEvent.getY());
            boolean z = false;
            if (H != null && !H.isEmpty()) {
                z = a.this.b(H);
            }
            if (!z) {
                return a.this.eqB();
            }
            return z;
        }
    };
    private RectF oYX = new RectF();

    private a(f fVar) {
        this.oYW = fVar;
        this.oYV = new GestureDetector(((View) fVar).getContext(), this.oYY);
    }

    public static synchronized a b(f fVar) {
        a aVar;
        synchronized (a.class) {
            aVar = new a(fVar);
        }
        return aVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.oYV.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(l lVar) {
        f.a onDanmakuClickListener = this.oYW.getOnDanmakuClickListener();
        if (onDanmakuClickListener != null) {
            return onDanmakuClickListener.a(lVar);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eqB() {
        f.a onDanmakuClickListener = this.oYW.getOnDanmakuClickListener();
        if (onDanmakuClickListener != null) {
            return onDanmakuClickListener.a(this.oYW);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l H(final float f, final float f2) {
        final d dVar = new d();
        this.oYX.setEmpty();
        l currentVisibleDanmakus = this.oYW.getCurrentVisibleDanmakus();
        if (currentVisibleDanmakus != null && !currentVisibleDanmakus.isEmpty()) {
            currentVisibleDanmakus.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.ui.widget.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bT(master.flame.danmaku.danmaku.model.d dVar2) {
                    if (dVar2 != null) {
                        a.this.oYX.set(dVar2.epw(), dVar2.epx(), dVar2.epy(), dVar2.epz());
                        if (a.this.oYX.contains(f, f2)) {
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
    public boolean ao(MotionEvent motionEvent) {
        master.flame.danmaku.danmaku.model.d epK;
        l H = H(motionEvent.getX(), motionEvent.getY());
        return (H == null || H.isEmpty() || (epK = H.epK()) == null || epK.tag == null) ? false : true;
    }
}
