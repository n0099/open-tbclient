package com.win.opensdk;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewTreeObserver;
import com.win.opensdk.core.Info;
/* loaded from: classes4.dex */
public final class ce {
    private Info qdE;
    boolean qdm;
    Handler qer = new Handler(Looper.getMainLooper()) { // from class: com.win.opensdk.ce.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1101:
                    ce.this.qer.removeMessages(1101);
                    if (!ce.this.qdm && ce.this.eA(ce.this.qfu)) {
                        if (ce.this.qfJ != null) {
                            ce.this.qfJ.eKp();
                        }
                        ce.this.qdm = true;
                        return;
                    }
                    ce.this.qer.sendEmptyMessageDelayed(1101, 300L);
                    return;
                default:
                    return;
            }
        }
    };
    a qfJ;
    View qfu;

    /* loaded from: classes4.dex */
    public interface a {
        void eKp();
    }

    public final void a(View view, Info info, final a aVar) {
        this.qfu = view;
        this.qfJ = aVar;
        this.qdE = info;
        try {
            if (!this.qdm) {
                this.qer.sendEmptyMessage(1101);
            }
            this.qfu.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.win.opensdk.ce.2
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    try {
                        if (!ce.this.qdm && ce.this.eA(ce.this.qfu)) {
                            ce.this.qer.removeMessages(1101);
                            ce.this.qfu.getViewTreeObserver().removeOnScrollChangedListener(this);
                            if (aVar != null) {
                                aVar.eKp();
                            }
                            ce.this.qdm = true;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final boolean eA(View view) {
        if (view != null && view.isShown()) {
            Rect rect = new Rect();
            return !(!view.getGlobalVisibleRect(rect) || this.qdE == null || (((double) rect.width()) > (((double) view.getMeasuredWidth()) * this.qdE.getSper()) ? 1 : (((double) rect.width()) == (((double) view.getMeasuredWidth()) * this.qdE.getSper()) ? 0 : -1)) < 0 || (((double) rect.height()) > (((double) view.getMeasuredHeight()) * this.qdE.getSper()) ? 1 : (((double) rect.height()) == (((double) view.getMeasuredHeight()) * this.qdE.getSper()) ? 0 : -1)) < 0);
        }
        return false;
    }
}
