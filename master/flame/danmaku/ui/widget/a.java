package master.flame.danmaku.ui.widget;

import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import master.flame.danmaku.a.f;
import master.flame.danmaku.danmaku.model.android.d;
import master.flame.danmaku.danmaku.model.l;
/* loaded from: classes4.dex */
public class a {
    private final GestureDetector nIA;
    private f nIB;
    private final GestureDetector.OnGestureListener nID = new GestureDetector.SimpleOnGestureListener() { // from class: master.flame.danmaku.ui.widget.a.1
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return a.this.ab(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            l G = a.this.G(motionEvent.getX(), motionEvent.getY());
            boolean z = false;
            if (G != null && !G.isEmpty()) {
                z = a.this.b(G);
            }
            if (!z) {
                return a.this.dLB();
            }
            return z;
        }
    };
    private RectF nIC = new RectF();

    private a(f fVar) {
        this.nIB = fVar;
        this.nIA = new GestureDetector(((View) fVar).getContext(), this.nID);
    }

    public static synchronized a b(f fVar) {
        a aVar;
        synchronized (a.class) {
            aVar = new a(fVar);
        }
        return aVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.nIA.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(l lVar) {
        f.a onDanmakuClickListener = this.nIB.getOnDanmakuClickListener();
        if (onDanmakuClickListener != null) {
            return onDanmakuClickListener.a(lVar);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dLB() {
        f.a onDanmakuClickListener = this.nIB.getOnDanmakuClickListener();
        if (onDanmakuClickListener != null) {
            return onDanmakuClickListener.a(this.nIB);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l G(final float f, final float f2) {
        final d dVar = new d();
        this.nIC.setEmpty();
        l currentVisibleDanmakus = this.nIB.getCurrentVisibleDanmakus();
        if (currentVisibleDanmakus != null && !currentVisibleDanmakus.isEmpty()) {
            currentVisibleDanmakus.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.ui.widget.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bU(master.flame.danmaku.danmaku.model.d dVar2) {
                    if (dVar2 != null) {
                        a.this.nIC.set(dVar2.dKw(), dVar2.dKx(), dVar2.dKy(), dVar2.dKz());
                        if (a.this.nIC.contains(f, f2)) {
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
    public boolean ab(MotionEvent motionEvent) {
        master.flame.danmaku.danmaku.model.d dKK;
        l G = G(motionEvent.getX(), motionEvent.getY());
        return (G == null || G.isEmpty() || (dKK = G.dKK()) == null || dKK.tag == null) ? false : true;
    }
}
