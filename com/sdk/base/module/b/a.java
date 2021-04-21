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
        if (!f.f38906d) {
            this.f38913b = g.f38909b.a();
            this.f38914c = g.f38908a.a();
            return;
        }
        String testHost = SDKManager.getTestHost();
        String statisticalTestHost = SDKManager.getStatisticalTestHost();
        this.f38914c = c.b(statisticalTestHost).booleanValue() ? statisticalTestHost : g.f38908a.a();
        if (c.b(testHost).booleanValue()) {
            this.f38913b = testHost;
        } else {
            this.f38913b = g.f38909b.a();
        }
    }
}
