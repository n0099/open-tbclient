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
    private Info qjI;
    boolean qjq;
    Handler qkv = new Handler(Looper.getMainLooper()) { // from class: com.win.opensdk.ce.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case UIMsg.f_FUN.FUN_ID_SCH_POI /* 1101 */:
                    ce.this.qkv.removeMessages(UIMsg.f_FUN.FUN_ID_SCH_POI);
                    if (!ce.this.qjq && ce.this.ey(ce.this.qly)) {
                        if (ce.this.qlN != null) {
                            ce.this.qlN.eIX();
                        }
                        ce.this.qjq = true;
                        return;
                    }
                    ce.this.qkv.sendEmptyMessageDelayed(UIMsg.f_FUN.FUN_ID_SCH_POI, 300L);
                    return;
                default:
                    return;
            }
        }
    };
    a qlN;
    View qly;

    /* loaded from: classes3.dex */
    public interface a {
        void eIX();
    }

    public final void a(View view, Info info, final a aVar) {
        this.qly = view;
        this.qlN = aVar;
        this.qjI = info;
        try {
            if (!this.qjq) {
                this.qkv.sendEmptyMessage(UIMsg.f_FUN.FUN_ID_SCH_POI);
            }
            this.qly.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.win.opensdk.ce.2
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    try {
                        if (!ce.this.qjq && ce.this.ey(ce.this.qly)) {
                            ce.this.qkv.removeMessages(UIMsg.f_FUN.FUN_ID_SCH_POI);
                            ce.this.qly.getViewTreeObserver().removeOnScrollChangedListener(this);
                            if (aVar != null) {
                                aVar.eIX();
                            }
                            ce.this.qjq = true;
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

    public final boolean ey(View view) {
        if (view != null && view.isShown()) {
            Rect rect = new Rect();
            return !(!view.getGlobalVisibleRect(rect) || this.qjI == null || (((double) rect.width()) > (((double) view.getMeasuredWidth()) * this.qjI.getSper()) ? 1 : (((double) rect.width()) == (((double) view.getMeasuredWidth()) * this.qjI.getSper()) ? 0 : -1)) < 0 || (((double) rect.height()) > (((double) view.getMeasuredHeight()) * this.qjI.getSper()) ? 1 : (((double) rect.height()) == (((double) view.getMeasuredHeight()) * this.qjI.getSper()) ? 0 : -1)) < 0);
        }
        return false;
    }
}
