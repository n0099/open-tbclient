package com.yy.hiidostatis.defs.controller;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.bun.miitmdid.core.IIdentifierListener;
import com.bun.miitmdid.core.JLibrary;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.supplier.IdSupplier;
import com.google.android.material.internal.ManufacturerUtils;
import com.yy.hiidostatis.inner.util.ArdUtil;
import com.yy.hiidostatis.inner.util.ThreadPool;
import com.yy.hiidostatis.inner.util.log.L;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public enum OaidController {
    INSTANCE;
    
    public OaidHelper oaidHelper = new OaidHelper();

    /* loaded from: classes8.dex */
    public interface OaidInitListener {
        void initFinish(boolean z, String str, String str2);
    }

    /* loaded from: classes8.dex */
    public final class OaidHelper {
        public static final long TIME_OUT = 20000;
        public volatile int beginTime;
        public volatile boolean init;
        public List<OaidInitListener> listeners;
        public volatile String oaid;

        public OaidHelper() {
            this.listeners = new ArrayList();
            this.oaid = "";
        }

        private int callFromReflect(Context context) {
            return MdidSdkHelper.InitSdk(context, true, new IIdentifierListener() { // from class: com.yy.hiidostatis.defs.controller.OaidController.OaidHelper.2
                public void OnSupport(boolean z, IdSupplier idSupplier) {
                    try {
                        if (idSupplier != null) {
                            OaidHelper.this.initFinish(true, idSupplier.getOAID(), null);
                            if (idSupplier != null) {
                                try {
                                    idSupplier.shutDown();
                                    return;
                                } catch (Throwable th) {
                                    L.debug(this, th.getMessage(), new Object[0]);
                                    return;
                                }
                            }
                            return;
                        }
                        OaidHelper.this.initFinish(false, "", "获取OAID失败");
                        if (idSupplier != null) {
                            try {
                                idSupplier.shutDown();
                            } catch (Throwable th2) {
                                L.debug(this, th2.getMessage(), new Object[0]);
                            }
                        }
                    } catch (Throwable th3) {
                        try {
                            L.debug(this, th3.getMessage(), new Object[0]);
                            OaidHelper.this.initFinish(false, "", "获取OAID失败");
                            if (idSupplier != null) {
                                try {
                                    idSupplier.shutDown();
                                } catch (Throwable th4) {
                                    L.debug(this, th4.getMessage(), new Object[0]);
                                }
                            }
                        } catch (Throwable th5) {
                            if (idSupplier != null) {
                                try {
                                    idSupplier.shutDown();
                                } catch (Throwable th6) {
                                    L.debug(this, th6.getMessage(), new Object[0]);
                                }
                            }
                            throw th5;
                        }
                    }
                }
            });
        }

        public synchronized void addListener(OaidInitListener oaidInitListener) {
            if (this.init) {
                if (this.oaid != null && !this.oaid.isEmpty()) {
                    oaidInitListener.initFinish(true, this.oaid, null);
                } else {
                    oaidInitListener.initFinish(false, "", null);
                }
                return;
            }
            this.listeners.add(oaidInitListener);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void initFinish(boolean z, String str, String str2) {
            boolean z2 = true;
            if (this.init) {
                if (z && ((this.oaid == null || this.oaid.isEmpty()) && str != null && !str.isEmpty())) {
                    this.oaid = str;
                }
                if (!z || str == null || str.isEmpty()) {
                    z2 = false;
                }
                noticeListener(z2, str, str2);
                return;
            }
            if (str2 != null && !str2.isEmpty()) {
                Log.e("OAID", str2);
            }
            this.init = true;
            this.oaid = str;
            if (!z || str == null || str.isEmpty()) {
                z2 = false;
            }
            noticeListener(z2, str, str2);
        }

        private synchronized void noticeListener(boolean z, String str, String str2) {
            for (OaidInitListener oaidInitListener : this.listeners) {
                oaidInitListener.initFinish(z, str, str2);
            }
            this.listeners.clear();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void timeOut() {
            ThreadPool.getPool().execute(new Runnable() { // from class: com.yy.hiidostatis.defs.controller.OaidController.OaidHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                    if (currentTimeMillis - OaidHelper.this.beginTime < 20 && currentTimeMillis - OaidHelper.this.beginTime > 0) {
                        Log.e("OAID", "定时器时间错误:" + OaidHelper.this.beginTime + "-" + currentTimeMillis + "-" + (currentTimeMillis - OaidHelper.this.beginTime));
                        OaidHelper.this.timeOut();
                    } else if (OaidHelper.this.init) {
                    } else {
                        OaidHelper.this.initFinish(false, "", "获取OAID超时");
                    }
                }
            }, 20000L);
        }

        public String getOaid() {
            if (this.oaid == null) {
                return "";
            }
            return this.oaid;
        }

        public boolean isInit() {
            return this.init;
        }

        public void initOaid(Context context, OaidInitListener oaidInitListener) {
            try {
                if (OaidController.ignore(context)) {
                    this.init = true;
                    noticeListener(false, "", "ignore sjm");
                    return;
                }
                this.beginTime = (int) (System.currentTimeMillis() / 1000);
                addListener(oaidInitListener);
                timeOut();
                int callFromReflect = callFromReflect(context);
                if (callFromReflect != 1008612) {
                    if (callFromReflect != 1008613) {
                        if (callFromReflect != 1008611) {
                            if (callFromReflect != 1008614 && callFromReflect == 1008615) {
                                throw new Exception("反射调用出错");
                            }
                            return;
                        }
                        throw new Exception("不支持的设备厂商");
                    }
                    throw new Exception("加载配置文件出错");
                }
                throw new Exception("不支持的设备");
            } catch (Throwable th) {
                initFinish(false, "", th.getMessage());
            }
        }
    }

    public boolean isLoaded() {
        return this.oaidHelper.isInit();
    }

    public String oaid() {
        return this.oaidHelper.getOaid();
    }

    OaidController() {
    }

    public void initOaidAsyn(Context context, OaidInitListener oaidInitListener) {
        this.oaidHelper.initOaid(context, oaidInitListener);
    }

    public static boolean ignore(Context context) {
        String str;
        try {
            str = ArdUtil.getSjp(context);
        } catch (Throwable th) {
            th.printStackTrace();
            str = null;
        }
        if ((str != null && (str.trim().equalsIgnoreCase(ManufacturerUtils.SAMSUNG) || str.trim().equalsIgnoreCase("YUFLY"))) || Build.VERSION.SDK_INT < 28) {
            return true;
        }
        return false;
    }

    public static void loadLib(Context context) {
        try {
            if (ignore(context)) {
                return;
            }
            JLibrary.InitEntry(context);
        } catch (Throwable th) {
            Log.e("OaidController", "JLibrary.InitEntry(context)", th);
        }
    }

    public void addListener(OaidInitListener oaidInitListener) {
        this.oaidHelper.addListener(oaidInitListener);
    }
}
