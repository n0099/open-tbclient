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
        if (!f.f39441d) {
            this.f39448b = g.f39444b.a();
            this.f39449c = g.f39443a.a();
            return;
        }
        String testHost = SDKManager.getTestHost();
        String statisticalTestHost = SDKManager.getStatisticalTestHost();
        this.f39449c = c.b(statisticalTestHost).booleanValue() ? statisticalTestHost : g.f39443a.a();
        if (c.b(testHost).booleanValue()) {
            this.f39448b = testHost;
        } else {
            this.f39448b = g.f39444b.a();
        }
    }
}
