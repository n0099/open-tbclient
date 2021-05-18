package com.sdk.base.module.b;

import android.content.Context;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.c.e;
import com.sdk.base.framework.c.f;
import com.sdk.base.framework.c.g;
import com.sdk.base.module.manager.SDKManager;
/* loaded from: classes7.dex */
public class a<T> extends com.sdk.base.framework.d.a<T> {
    public a(Context context, com.sdk.base.framework.b.a<T> aVar, e eVar) {
        super(context, aVar, eVar);
        if (!f.f35735d) {
            this.f35742b = g.f35738b.a();
            this.f35743c = g.f35737a.a();
            return;
        }
        String testHost = SDKManager.getTestHost();
        String statisticalTestHost = SDKManager.getStatisticalTestHost();
        this.f35743c = c.b(statisticalTestHost).booleanValue() ? statisticalTestHost : g.f35737a.a();
        if (c.b(testHost).booleanValue()) {
            this.f35742b = testHost;
        } else {
            this.f35742b = g.f35738b.a();
        }
    }
}
