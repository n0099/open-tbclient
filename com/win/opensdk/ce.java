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
    boolean pYL;
    Handler pZQ = new Handler(Looper.getMainLooper()) { // from class: com.win.opensdk.ce.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case UIMsg.f_FUN.FUN_ID_SCH_POI /* 1101 */:
                    ce.this.pZQ.removeMessages(UIMsg.f_FUN.FUN_ID_SCH_POI);
                    if (!ce.this.pYL && ce.this.eA(ce.this.qaT)) {
                        if (ce.this.qbi != null) {
                            ce.this.qbi.eGz();
                        }
                        ce.this.pYL = true;
                        return;
                    }
                    ce.this.pZQ.sendEmptyMessageDelayed(UIMsg.f_FUN.FUN_ID_SCH_POI, 300L);
                    return;
                default:
                    return;
            }
        }
    };
    private Info pZd;
    View qaT;
    a qbi;

    /* loaded from: classes3.dex */
    public interface a {
        void eGz();
    }

    public final void a(View view, Info info, final a aVar) {
        this.qaT = view;
        this.qbi = aVar;
        this.pZd = info;
        try {
            if (!this.pYL) {
                this.pZQ.sendEmptyMessage(UIMsg.f_FUN.FUN_ID_SCH_POI);
            }
            this.qaT.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.win.opensdk.ce.2
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    try {
                        if (!ce.this.pYL && ce.this.eA(ce.this.qaT)) {
                            ce.this.pZQ.removeMessages(UIMsg.f_FUN.FUN_ID_SCH_POI);
                            ce.this.qaT.getViewTreeObserver().removeOnScrollChangedListener(this);
                            if (aVar != null) {
                                aVar.eGz();
                            }
                            ce.this.pYL = true;
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
            return !(!view.getGlobalVisibleRect(rect) || this.pZd == null || (((double) rect.width()) > (((double) view.getMeasuredWidth()) * this.pZd.getSper()) ? 1 : (((double) rect.width()) == (((double) view.getMeasuredWidth()) * this.pZd.getSper()) ? 0 : -1)) < 0 || (((double) rect.height()) > (((double) view.getMeasuredHeight()) * this.pZd.getSper()) ? 1 : (((double) rect.height()) == (((double) view.getMeasuredHeight()) * this.pZd.getSper()) ? 0 : -1)) < 0);
        }
        return false;
    }
}
