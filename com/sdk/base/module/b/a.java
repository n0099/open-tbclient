package com.sdk.base.module.b;

import android.content.Context;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.c.e;
import com.sdk.base.framework.c.f;
import com.sdk.base.framework.c.g;
import com.sdk.base.module.manager.SDKManager;
/* loaded from: classes15.dex */
public class a<T> extends com.sdk.base.framework.d.a<T> {
    public a(Context context, com.sdk.base.framework.b.a<T> aVar, e eVar) {
        super(context, aVar, eVar);
        if (!f.d) {
            this.f13122b = g.f13120b.a();
            this.c = g.f13119a.a();
            return;
        }
        String testHost = SDKManager.getTestHost();
        String statisticalTestHost = SDKManager.getStatisticalTestHost();
        if (c.b(statisticalTestHost).booleanValue()) {
            this.c = statisticalTestHost;
        } else {
            this.c = g.f13119a.a();
        }
        if (c.b(testHost).booleanValue()) {
            this.f13122b = testHost;
        } else {
            this.f13122b = g.f13120b.a();
        }
    }
}
