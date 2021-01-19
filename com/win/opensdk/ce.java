package com.win.opensdk;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewTreeObserver;
import com.baidu.mapapi.UIMsg;
import com.win.opensdk.core.Info;
/* loaded from: classes3.dex */
public final class ce {
    boolean pYM;
    Handler pZR = new Handler(Looper.getMainLooper()) { // from class: com.win.opensdk.ce.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case UIMsg.f_FUN.FUN_ID_SCH_POI /* 1101 */:
                    ce.this.pZR.removeMessages(UIMsg.f_FUN.FUN_ID_SCH_POI);
                    if (!ce.this.pYM && ce.this.eA(ce.this.qaU)) {
                        if (ce.this.qbj != null) {
                            ce.this.qbj.eGz();
                        }
                        ce.this.pYM = true;
                        return;
                    }
                    ce.this.pZR.sendEmptyMessageDelayed(UIMsg.f_FUN.FUN_ID_SCH_POI, 300L);
                    return;
                default:
                    return;
            }
        }
    };
    private Info pZe;
    View qaU;
    a qbj;

    /* loaded from: classes3.dex */
    public interface a {
        void eGz();
    }

    public final void a(View view, Info info, final a aVar) {
        this.qaU = view;
        this.qbj = aVar;
        this.pZe = info;
        try {
            if (!this.pYM) {
                this.pZR.sendEmptyMessage(UIMsg.f_FUN.FUN_ID_SCH_POI);
            }
            this.qaU.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.win.opensdk.ce.2
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    try {
                        if (!ce.this.pYM && ce.this.eA(ce.this.qaU)) {
                            ce.this.pZR.removeMessages(UIMsg.f_FUN.FUN_ID_SCH_POI);
                            ce.this.qaU.getViewTreeObserver().removeOnScrollChangedListener(this);
                            if (aVar != null) {
                                aVar.eGz();
                            }
                            ce.this.pYM = true;
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
            return !(!view.getGlobalVisibleRect(rect) || this.pZe == null || (((double) rect.width()) > (((double) view.getMeasuredWidth()) * this.pZe.getSper()) ? 1 : (((double) rect.width()) == (((double) view.getMeasuredWidth()) * this.pZe.getSper()) ? 0 : -1)) < 0 || (((double) rect.height()) > (((double) view.getMeasuredHeight()) * this.pZe.getSper()) ? 1 : (((double) rect.height()) == (((double) view.getMeasuredHeight()) * this.pZe.getSper()) ? 0 : -1)) < 0);
        }
        return false;
    }
}
