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
    boolean qiQ;
    Handler qjV = new Handler(Looper.getMainLooper()) { // from class: com.win.opensdk.ce.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case UIMsg.f_FUN.FUN_ID_SCH_POI /* 1101 */:
                    ce.this.qjV.removeMessages(UIMsg.f_FUN.FUN_ID_SCH_POI);
                    if (!ce.this.qiQ && ce.this.ey(ce.this.qkY)) {
                        if (ce.this.qln != null) {
                            ce.this.qln.eIP();
                        }
                        ce.this.qiQ = true;
                        return;
                    }
                    ce.this.qjV.sendEmptyMessageDelayed(UIMsg.f_FUN.FUN_ID_SCH_POI, 300L);
                    return;
                default:
                    return;
            }
        }
    };
    private Info qji;
    View qkY;
    a qln;

    /* loaded from: classes3.dex */
    public interface a {
        void eIP();
    }

    public final void a(View view, Info info, final a aVar) {
        this.qkY = view;
        this.qln = aVar;
        this.qji = info;
        try {
            if (!this.qiQ) {
                this.qjV.sendEmptyMessage(UIMsg.f_FUN.FUN_ID_SCH_POI);
            }
            this.qkY.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.win.opensdk.ce.2
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    try {
                        if (!ce.this.qiQ && ce.this.ey(ce.this.qkY)) {
                            ce.this.qjV.removeMessages(UIMsg.f_FUN.FUN_ID_SCH_POI);
                            ce.this.qkY.getViewTreeObserver().removeOnScrollChangedListener(this);
                            if (aVar != null) {
                                aVar.eIP();
                            }
                            ce.this.qiQ = true;
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
            return !(!view.getGlobalVisibleRect(rect) || this.qji == null || (((double) rect.width()) > (((double) view.getMeasuredWidth()) * this.qji.getSper()) ? 1 : (((double) rect.width()) == (((double) view.getMeasuredWidth()) * this.qji.getSper()) ? 0 : -1)) < 0 || (((double) rect.height()) > (((double) view.getMeasuredHeight()) * this.qji.getSper()) ? 1 : (((double) rect.height()) == (((double) view.getMeasuredHeight()) * this.qji.getSper()) ? 0 : -1)) < 0);
        }
        return false;
    }
}
