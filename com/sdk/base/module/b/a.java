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
        if (!f.f38521d) {
            this.f38528b = g.f38524b.a();
            this.f38529c = g.f38523a.a();
            return;
        }
        String testHost = SDKManager.getTestHost();
        String statisticalTestHost = SDKManager.getStatisticalTestHost();
        this.f38529c = c.b(statisticalTestHost).booleanValue() ? statisticalTestHost : g.f38523a.a();
        if (c.b(testHost).booleanValue()) {
            this.f38528b = testHost;
        } else {
            this.f38528b = g.f38524b.a();
        }
    }
}
