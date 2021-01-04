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
    boolean qbE;
    private Info qbW;
    Handler qcJ = new Handler(Looper.getMainLooper()) { // from class: com.win.opensdk.ce.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1101:
                    ce.this.qcJ.removeMessages(1101);
                    if (!ce.this.qbE && ce.this.eA(ce.this.qdM)) {
                        if (ce.this.qeb != null) {
                            ce.this.qeb.eJL();
                        }
                        ce.this.qbE = true;
                        return;
                    }
                    ce.this.qcJ.sendEmptyMessageDelayed(1101, 300L);
                    return;
                default:
                    return;
            }
        }
    };
    View qdM;
    a qeb;

    /* loaded from: classes4.dex */
    public interface a {
        void eJL();
    }

    public final void a(View view, Info info, final a aVar) {
        this.qdM = view;
        this.qeb = aVar;
        this.qbW = info;
        try {
            if (!this.qbE) {
                this.qcJ.sendEmptyMessage(1101);
            }
            this.qdM.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.win.opensdk.ce.2
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    try {
                        if (!ce.this.qbE && ce.this.eA(ce.this.qdM)) {
                            ce.this.qcJ.removeMessages(1101);
                            ce.this.qdM.getViewTreeObserver().removeOnScrollChangedListener(this);
                            if (aVar != null) {
                                aVar.eJL();
                            }
                            ce.this.qbE = true;
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
            return !(!view.getGlobalVisibleRect(rect) || this.qbW == null || (((double) rect.width()) > (((double) view.getMeasuredWidth()) * this.qbW.getSper()) ? 1 : (((double) rect.width()) == (((double) view.getMeasuredWidth()) * this.qbW.getSper()) ? 0 : -1)) < 0 || (((double) rect.height()) > (((double) view.getMeasuredHeight()) * this.qbW.getSper()) ? 1 : (((double) rect.height()) == (((double) view.getMeasuredHeight()) * this.qbW.getSper()) ? 0 : -1)) < 0);
        }
        return false;
    }
}
