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
    private final GestureDetector nIF;
    private f nIG;
    private final GestureDetector.OnGestureListener nII = new GestureDetector.SimpleOnGestureListener() { // from class: master.flame.danmaku.ui.widget.a.1
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
                return a.this.dLD();
            }
            return z;
        }
    };
    private RectF nIH = new RectF();

    private a(f fVar) {
        this.nIG = fVar;
        this.nIF = new GestureDetector(((View) fVar).getContext(), this.nII);
    }

    public static synchronized a b(f fVar) {
        a aVar;
        synchronized (a.class) {
            aVar = new a(fVar);
        }
        return aVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.nIF.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(l lVar) {
        f.a onDanmakuClickListener = this.nIG.getOnDanmakuClickListener();
        if (onDanmakuClickListener != null) {
            return onDanmakuClickListener.a(lVar);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dLD() {
        f.a onDanmakuClickListener = this.nIG.getOnDanmakuClickListener();
        if (onDanmakuClickListener != null) {
            return onDanmakuClickListener.a(this.nIG);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l G(final float f, final float f2) {
        final d dVar = new d();
        this.nIH.setEmpty();
        l currentVisibleDanmakus = this.nIG.getCurrentVisibleDanmakus();
        if (currentVisibleDanmakus != null && !currentVisibleDanmakus.isEmpty()) {
            currentVisibleDanmakus.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.ui.widget.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bU(master.flame.danmaku.danmaku.model.d dVar2) {
                    if (dVar2 != null) {
                        a.this.nIH.set(dVar2.dKy(), dVar2.dKz(), dVar2.dKA(), dVar2.dKB());
                        if (a.this.nIH.contains(f, f2)) {
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
        master.flame.danmaku.danmaku.model.d dKM;
        l G = G(motionEvent.getX(), motionEvent.getY());
        return (G == null || G.isEmpty() || (dKM = G.dKM()) == null || dKM.tag == null) ? false : true;
    }
}
