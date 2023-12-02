package com.yy.gslbsdk;

import com.yy.gslbsdk.cache.DataCacheMgr;
import com.yy.gslbsdk.util.GlobalTools;
/* loaded from: classes10.dex */
public enum GslbEvent {
    INSTANCE;
    
    public GslbEventListener listener;

    /* loaded from: classes10.dex */
    public interface GslbEventListener {
        void onMessage(String str);
    }

    public void onMessage(String str) {
        GslbEventListener gslbEventListener = this.listener;
        if (gslbEventListener != null) {
            gslbEventListener.onMessage("gslb id:" + DataCacheMgr.INSTANCE.getIdentity(GlobalTools.APP_CONTEXT) + " msg:" + str);
        }
    }

    public void setListener(GslbEventListener gslbEventListener) {
        this.listener = gslbEventListener;
    }
}
