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
    private final GestureDetector nfc;
    private f nfd;
    private final GestureDetector.OnGestureListener nff = new GestureDetector.SimpleOnGestureListener() { // from class: master.flame.danmaku.ui.widget.a.1
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
                return a.this.dGq();
            }
            return z;
        }
    };
    private RectF nfe = new RectF();

    private a(f fVar) {
        this.nfd = fVar;
        this.nfc = new GestureDetector(((View) fVar).getContext(), this.nff);
    }

    public static synchronized a b(f fVar) {
        a aVar;
        synchronized (a.class) {
            aVar = new a(fVar);
        }
        return aVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.nfc.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(l lVar) {
        f.a onDanmakuClickListener = this.nfd.getOnDanmakuClickListener();
        if (onDanmakuClickListener != null) {
            return onDanmakuClickListener.a(lVar);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dGq() {
        f.a onDanmakuClickListener = this.nfd.getOnDanmakuClickListener();
        if (onDanmakuClickListener != null) {
            return onDanmakuClickListener.a(this.nfd);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l B(final float f, final float f2) {
        final d dVar = new d();
        this.nfe.setEmpty();
        l currentVisibleDanmakus = this.nfd.getCurrentVisibleDanmakus();
        if (currentVisibleDanmakus != null && !currentVisibleDanmakus.isEmpty()) {
            currentVisibleDanmakus.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.ui.widget.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bF(master.flame.danmaku.danmaku.model.d dVar2) {
                    if (dVar2 != null) {
                        a.this.nfe.set(dVar2.dFl(), dVar2.dFm(), dVar2.dFn(), dVar2.dFo());
                        if (a.this.nfe.contains(f, f2)) {
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
        master.flame.danmaku.danmaku.model.d dFz;
        l B = B(motionEvent.getX(), motionEvent.getY());
        return (B == null || B.isEmpty() || (dFz = B.dFz()) == null || dFz.tag == null) ? false : true;
    }
}
