package com.sdk.base.module.b;

import android.content.Context;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.c.e;
import com.sdk.base.framework.c.f;
import com.sdk.base.framework.c.g;
import com.sdk.base.module.manager.SDKManager;
/* loaded from: classes6.dex */
public class a<T> extends com.sdk.base.framework.d.a<T> {
    public a(Context context, com.sdk.base.framework.b.a<T> aVar, e eVar) {
        super(context, aVar, eVar);
        if (!f.f36490d) {
            this.f36497b = g.f36493b.a();
            this.f36498c = g.f36492a.a();
            return;
        }
        String testHost = SDKManager.getTestHost();
        String statisticalTestHost = SDKManager.getStatisticalTestHost();
        this.f36498c = c.b(statisticalTestHost).booleanValue() ? statisticalTestHost : g.f36492a.a();
        if (c.b(testHost).booleanValue()) {
            this.f36497b = testHost;
        } else {
            this.f36497b = g.f36493b.a();
        }
    }
}
