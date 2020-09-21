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
    private final GestureDetector oJH;
    private f oJI;
    private final GestureDetector.OnGestureListener oJK = new GestureDetector.SimpleOnGestureListener() { // from class: master.flame.danmaku.ui.widget.a.1
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return a.this.ao(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            l G = a.this.G(motionEvent.getX(), motionEvent.getY());
            boolean z = false;
            if (G != null && !G.isEmpty()) {
                z = a.this.b(G);
            }
            if (!z) {
                return a.this.emO();
            }
            return z;
        }
    };
    private RectF oJJ = new RectF();

    private a(f fVar) {
        this.oJI = fVar;
        this.oJH = new GestureDetector(((View) fVar).getContext(), this.oJK);
    }

    public static synchronized a b(f fVar) {
        a aVar;
        synchronized (a.class) {
            aVar = new a(fVar);
        }
        return aVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.oJH.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(l lVar) {
        f.a onDanmakuClickListener = this.oJI.getOnDanmakuClickListener();
        if (onDanmakuClickListener != null) {
            return onDanmakuClickListener.a(lVar);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean emO() {
        f.a onDanmakuClickListener = this.oJI.getOnDanmakuClickListener();
        if (onDanmakuClickListener != null) {
            return onDanmakuClickListener.a(this.oJI);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l G(final float f, final float f2) {
        final d dVar = new d();
        this.oJJ.setEmpty();
        l currentVisibleDanmakus = this.oJI.getCurrentVisibleDanmakus();
        if (currentVisibleDanmakus != null && !currentVisibleDanmakus.isEmpty()) {
            currentVisibleDanmakus.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.ui.widget.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bQ(master.flame.danmaku.danmaku.model.d dVar2) {
                    if (dVar2 != null) {
                        a.this.oJJ.set(dVar2.elJ(), dVar2.elK(), dVar2.elL(), dVar2.elM());
                        if (a.this.oJJ.contains(f, f2)) {
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
        master.flame.danmaku.danmaku.model.d elX;
        l G = G(motionEvent.getX(), motionEvent.getY());
        return (G == null || G.isEmpty() || (elX = G.elX()) == null || elX.tag == null) ? false : true;
    }
}
