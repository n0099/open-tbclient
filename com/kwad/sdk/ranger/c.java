package com.kwad.sdk.ranger;

import okhttp3.EventListener;
/* loaded from: classes10.dex */
public class c implements EventListener.Factory {
    public static final String TAG = "Ranger_" + c.class.getSimpleName();
    public EventListener aLA;
    public a aLB;

    /* loaded from: classes10.dex */
    public interface a {
    }

    public c(Object obj, a aVar) {
        this.aLA = (EventListener) obj;
        this.aLB = aVar;
    }
}
