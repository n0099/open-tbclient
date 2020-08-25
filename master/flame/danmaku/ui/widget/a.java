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
    private final GestureDetector ozK;
    private f ozL;
    private final GestureDetector.OnGestureListener ozN = new GestureDetector.SimpleOnGestureListener() { // from class: master.flame.danmaku.ui.widget.a.1
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return a.this.ao(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            l F = a.this.F(motionEvent.getX(), motionEvent.getY());
            boolean z = false;
            if (F != null && !F.isEmpty()) {
                z = a.this.b(F);
            }
            if (!z) {
                return a.this.eiI();
            }
            return z;
        }
    };
    private RectF ozM = new RectF();

    private a(f fVar) {
        this.ozL = fVar;
        this.ozK = new GestureDetector(((View) fVar).getContext(), this.ozN);
    }

    public static synchronized a b(f fVar) {
        a aVar;
        synchronized (a.class) {
            aVar = new a(fVar);
        }
        return aVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.ozK.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(l lVar) {
        f.a onDanmakuClickListener = this.ozL.getOnDanmakuClickListener();
        if (onDanmakuClickListener != null) {
            return onDanmakuClickListener.a(lVar);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eiI() {
        f.a onDanmakuClickListener = this.ozL.getOnDanmakuClickListener();
        if (onDanmakuClickListener != null) {
            return onDanmakuClickListener.a(this.ozL);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l F(final float f, final float f2) {
        final d dVar = new d();
        this.ozM.setEmpty();
        l currentVisibleDanmakus = this.ozL.getCurrentVisibleDanmakus();
        if (currentVisibleDanmakus != null && !currentVisibleDanmakus.isEmpty()) {
            currentVisibleDanmakus.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.ui.widget.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bO(master.flame.danmaku.danmaku.model.d dVar2) {
                    if (dVar2 != null) {
                        a.this.ozM.set(dVar2.ehD(), dVar2.ehE(), dVar2.ehF(), dVar2.ehG());
                        if (a.this.ozM.contains(f, f2)) {
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
        master.flame.danmaku.danmaku.model.d ehR;
        l F = F(motionEvent.getX(), motionEvent.getY());
        return (F == null || F.isEmpty() || (ehR = F.ehR()) == null || ehR.tag == null) ? false : true;
    }
}
