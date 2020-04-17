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
    private final GestureDetector neZ;
    private f nfa;
    private final GestureDetector.OnGestureListener nfc = new GestureDetector.SimpleOnGestureListener() { // from class: master.flame.danmaku.ui.widget.a.1
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return a.this.P(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            l B = a.this.B(motionEvent.getX(), motionEvent.getY());
            boolean z = false;
            if (B != null && !B.isEmpty()) {
                z = a.this.b(B);
            }
            if (!z) {
                return a.this.dGt();
            }
            return z;
        }
    };
    private RectF nfb = new RectF();

    private a(f fVar) {
        this.nfa = fVar;
        this.neZ = new GestureDetector(((View) fVar).getContext(), this.nfc);
    }

    public static synchronized a b(f fVar) {
        a aVar;
        synchronized (a.class) {
            aVar = new a(fVar);
        }
        return aVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.neZ.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(l lVar) {
        f.a onDanmakuClickListener = this.nfa.getOnDanmakuClickListener();
        if (onDanmakuClickListener != null) {
            return onDanmakuClickListener.a(lVar);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dGt() {
        f.a onDanmakuClickListener = this.nfa.getOnDanmakuClickListener();
        if (onDanmakuClickListener != null) {
            return onDanmakuClickListener.a(this.nfa);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l B(final float f, final float f2) {
        final d dVar = new d();
        this.nfb.setEmpty();
        l currentVisibleDanmakus = this.nfa.getCurrentVisibleDanmakus();
        if (currentVisibleDanmakus != null && !currentVisibleDanmakus.isEmpty()) {
            currentVisibleDanmakus.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.ui.widget.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bE(master.flame.danmaku.danmaku.model.d dVar2) {
                    if (dVar2 != null) {
                        a.this.nfb.set(dVar2.dFo(), dVar2.dFp(), dVar2.dFq(), dVar2.dFr());
                        if (a.this.nfb.contains(f, f2)) {
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
    public boolean P(MotionEvent motionEvent) {
        master.flame.danmaku.danmaku.model.d dFC;
        l B = B(motionEvent.getX(), motionEvent.getY());
        return (B == null || B.isEmpty() || (dFC = B.dFC()) == null || dFC.tag == null) ? false : true;
    }
}
