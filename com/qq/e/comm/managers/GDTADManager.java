package com.qq.e.comm.managers;

import android.content.Context;
import android.os.Build;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import com.qq.e.comm.constants.CustomPkgConstants;
import com.qq.e.comm.managers.devtool.DevTools;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.managers.status.APPStatus;
import com.qq.e.comm.managers.status.DeviceStatus;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.qq.e.comm.util.SystemUtil;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GDTADManager {
    public static final ExecutorService INIT_EXECUTOR = Executors.newSingleThreadExecutor();

    /* renamed from: a  reason: collision with root package name */
    private volatile Boolean f11843a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Context f11844b;
    private volatile SM c;
    private volatile PM d;
    private volatile DevTools e;
    private volatile APPStatus f;
    private volatile DeviceStatus g;
    private volatile String h;
    private PM.a.InterfaceC1157a i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static GDTADManager f11845a = new GDTADManager((byte) 0);
    }

    private GDTADManager() {
        this.f11843a = Boolean.FALSE;
    }

    /* synthetic */ GDTADManager(byte b2) {
        this();
    }

    public static GDTADManager getInstance() {
        return a.f11845a;
    }

    public JSONObject buildS2SSBaseInfo() throws JSONException {
        if (isInitialized()) {
            JSONObject a2 = com.qq.e.comm.net.a.a(this.c);
            a2.put("app", com.qq.e.comm.net.a.a(this.f));
            a2.put("c", com.qq.e.comm.net.a.a(this.g));
            a2.put(CashierData.SDK, com.qq.e.comm.net.a.a(this.d));
            return a2;
        }
        return null;
    }

    public String getADActivityClazz() {
        return CustomPkgConstants.getADActivityName();
    }

    public Context getAppContext() {
        return this.f11844b;
    }

    public APPStatus getAppStatus() {
        return this.f;
    }

    public DevTools getDevTools() {
        if (this.e == null) {
            this.e = new DevTools();
        }
        return this.e;
    }

    public DeviceStatus getDeviceStatus() {
        return this.g;
    }

    public String getDownLoadClazz() {
        return CustomPkgConstants.getDownLoadServiceName();
    }

    public String getLandscapeADActivityClazz() {
        return CustomPkgConstants.getLandscapeADActivityName();
    }

    public PM getPM() {
        return this.d;
    }

    public String getPortraitADActivityClazz() {
        return CustomPkgConstants.getPortraitADActivityName();
    }

    public String getProcessName() {
        return this.h;
    }

    public String getRewardvideoLandscapeADActivityClazz() {
        return CustomPkgConstants.getRewardvideoLandscapeADActivityName();
    }

    public String getRewardvideoPortraitADActivityClazz() {
        return CustomPkgConstants.getRewardvideoPortraitADActivityName();
    }

    public SM getSM() {
        return this.c;
    }

    public boolean initWith(Context context, String str) {
        boolean z;
        synchronized (this) {
            if (Build.VERSION.SDK_INT < 14) {
                GDTLogger.e("system version not support !");
                z = false;
            } else if (this.f11843a.booleanValue()) {
                z = true;
            } else if (context == null || StringUtil.isEmpty(str)) {
                GDTLogger.e("Context And APPID should Never Be NULL while init GDTADManager");
                z = false;
            } else {
                long nanoTime = System.nanoTime();
                this.h = SystemUtil.getProcessName(context);
                this.f11844b = context.getApplicationContext();
                this.c = new SM(this.f11844b);
                this.d = new PM(this.f11844b, this.i);
                this.f = new APPStatus(str, this.f11844b);
                this.g = new DeviceStatus(this.f11844b);
                if (Build.VERSION.SDK_INT > 7) {
                    com.qq.e.comm.services.a.a().a(this.f11844b, this.c, this.d, this.g, this.f, nanoTime);
                }
                this.f11843a = Boolean.TRUE;
                z = true;
            }
        }
        return z;
    }

    public boolean isInitialized() {
        if (this.f11843a == null) {
            return false;
        }
        return this.f11843a.booleanValue();
    }

    public void setPluginLoadListener(PM.a.InterfaceC1157a interfaceC1157a) {
        this.i = interfaceC1157a;
    }
}
