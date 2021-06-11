package com.yy.hiidostatis.inner.util.hdid;

import android.app.Application;
import android.content.Context;
import com.yy.hiidostatis.inner.util.log.L;
/* loaded from: classes7.dex */
public class ClientIdProxy {
    public static volatile boolean isInit = false;

    public static String getClientId(Context context) {
        init(context);
        return ClientIdHelper.getInstance().getClientId();
    }

    public static void init(final Context context) {
        if (isInit) {
            return;
        }
        synchronized (ClientIdProxy.class) {
            if (!isInit) {
                ClientIdHelper.init(new IClientIdConfig() { // from class: com.yy.hiidostatis.inner.util.hdid.ClientIdProxy.1
                    @Override // com.yy.hiidostatis.inner.util.hdid.IClientIdConfig
                    public Application getAppContext() {
                        Context context2 = context;
                        if (!(context2 instanceof Application)) {
                            context2 = context2.getApplicationContext();
                        }
                        return (Application) context2;
                    }

                    @Override // com.yy.hiidostatis.inner.util.hdid.IClientIdConfig
                    public boolean logEnable() {
                        return false;
                    }

                    @Override // com.yy.hiidostatis.inner.util.hdid.IClientIdConfig
                    public boolean sdReadGranted() {
                        return false;
                    }

                    @Override // com.yy.hiidostatis.inner.util.hdid.IClientIdConfig
                    public boolean sdWriteGranted() {
                        return false;
                    }
                });
                isInit = true;
            }
        }
    }

    public static void test(Context context) {
        L.debug("DeviceProxy", "ClientIdProxyTest:%d==>%s,%d", Long.valueOf(Thread.currentThread().getId()), getClientId(context), Long.valueOf(System.currentTimeMillis() - System.currentTimeMillis()));
    }
}
