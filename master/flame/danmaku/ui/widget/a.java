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
    private final GestureDetector pQr;
    private f pQs;
    private final GestureDetector.OnGestureListener olQ = new GestureDetector.SimpleOnGestureListener() { // from class: master.flame.danmaku.ui.widget.a.1
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return a.this.aq(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            l I = a.this.I(motionEvent.getX(), motionEvent.getY());
            boolean z = false;
            if (I != null && !I.isEmpty()) {
                z = a.this.b(I);
            }
            if (!z) {
                return a.this.eAz();
            }
            return z;
        }
    };
    private RectF pQt = new RectF();

    private a(f fVar) {
        this.pQs = fVar;
        this.pQr = new GestureDetector(((View) fVar).getContext(), this.olQ);
    }

    public static synchronized a b(f fVar) {
        a aVar;
        synchronized (a.class) {
            aVar = new a(fVar);
        }
        return aVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.pQr.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(l lVar) {
        f.a onDanmakuClickListener = this.pQs.getOnDanmakuClickListener();
        if (onDanmakuClickListener != null) {
            return onDanmakuClickListener.a(lVar);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eAz() {
        f.a onDanmakuClickListener = this.pQs.getOnDanmakuClickListener();
        if (onDanmakuClickListener != null) {
            return onDanmakuClickListener.a(this.pQs);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l I(final float f, final float f2) {
        final d dVar = new d();
        this.pQt.setEmpty();
        l currentVisibleDanmakus = this.pQs.getCurrentVisibleDanmakus();
        if (currentVisibleDanmakus != null && !currentVisibleDanmakus.isEmpty()) {
            currentVisibleDanmakus.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.ui.widget.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bX(master.flame.danmaku.danmaku.model.d dVar2) {
                    if (dVar2 != null) {
                        a.this.pQt.set(dVar2.ezu(), dVar2.ezv(), dVar2.ezw(), dVar2.ezx());
                        if (a.this.pQt.contains(f, f2)) {
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
    public boolean aq(MotionEvent motionEvent) {
        master.flame.danmaku.danmaku.model.d ezI;
        l I = I(motionEvent.getX(), motionEvent.getY());
        return (I == null || I.isEmpty() || (ezI = I.ezI()) == null || ezI.tag == null) ? false : true;
    }
}
