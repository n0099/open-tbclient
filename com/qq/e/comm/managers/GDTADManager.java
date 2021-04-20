package com.qq.e.comm.managers;

import android.content.Context;
import android.os.Build;
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
/* loaded from: classes6.dex */
public class GDTADManager {
    public static final ExecutorService INIT_EXECUTOR = Executors.newSingleThreadExecutor();

    /* renamed from: a  reason: collision with root package name */
    public volatile Boolean f38567a;

    /* renamed from: b  reason: collision with root package name */
    public volatile Context f38568b;

    /* renamed from: c  reason: collision with root package name */
    public volatile SM f38569c;

    /* renamed from: d  reason: collision with root package name */
    public volatile PM f38570d;

    /* renamed from: e  reason: collision with root package name */
    public volatile DevTools f38571e;

    /* renamed from: f  reason: collision with root package name */
    public volatile APPStatus f38572f;

    /* renamed from: g  reason: collision with root package name */
    public volatile DeviceStatus f38573g;

    /* renamed from: h  reason: collision with root package name */
    public volatile String f38574h;
    public PM.a.InterfaceC0484a i;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static GDTADManager f38575a = new GDTADManager((byte) 0);
    }

    public GDTADManager() {
        this.f38567a = Boolean.FALSE;
    }

    public /* synthetic */ GDTADManager(byte b2) {
        this();
    }

    public static GDTADManager getInstance() {
        return a.f38575a;
    }

    public JSONObject buildS2SSBaseInfo() throws JSONException {
        if (isInitialized()) {
            JSONObject a2 = com.qq.e.comm.net.a.a(this.f38569c);
            a2.put("app", com.qq.e.comm.net.a.a(this.f38572f));
            a2.put("c", com.qq.e.comm.net.a.a(this.f38573g));
            a2.put("sdk", com.qq.e.comm.net.a.a(this.f38570d));
            return a2;
        }
        return null;
    }

    public String getADActivityClazz() {
        return CustomPkgConstants.getADActivityName();
    }

    public Context getAppContext() {
        return this.f38568b;
    }

    public APPStatus getAppStatus() {
        return this.f38572f;
    }

    public DevTools getDevTools() {
        if (this.f38571e == null) {
            this.f38571e = new DevTools();
        }
        return this.f38571e;
    }

    public DeviceStatus getDeviceStatus() {
        return this.f38573g;
    }

    public String getDownLoadClazz() {
        return CustomPkgConstants.getDownLoadServiceName();
    }

    public String getLandscapeADActivityClazz() {
        return CustomPkgConstants.getLandscapeADActivityName();
    }

    public PM getPM() {
        return this.f38570d;
    }

    public String getPortraitADActivityClazz() {
        return CustomPkgConstants.getPortraitADActivityName();
    }

    public String getProcessName() {
        return this.f38574h;
    }

    public String getRewardvideoLandscapeADActivityClazz() {
        return CustomPkgConstants.getRewardvideoLandscapeADActivityName();
    }

    public String getRewardvideoPortraitADActivityClazz() {
        return CustomPkgConstants.getRewardvideoPortraitADActivityName();
    }

    public SM getSM() {
        return this.f38569c;
    }

    public synchronized boolean initWith(Context context, String str) {
        if (Build.VERSION.SDK_INT < 14) {
            GDTLogger.e("system version not support !");
            return false;
        } else if (this.f38567a.booleanValue()) {
            return true;
        } else {
            if (context == null || StringUtil.isEmpty(str)) {
                GDTLogger.e("Context And APPID should Never Be NULL while init GDTADManager");
                return false;
            }
            long nanoTime = System.nanoTime();
            this.f38574h = SystemUtil.getProcessName(context);
            this.f38568b = context.getApplicationContext();
            this.f38569c = new SM(this.f38568b);
            this.f38570d = new PM(this.f38568b, this.i);
            this.f38572f = new APPStatus(str, this.f38568b);
            this.f38573g = new DeviceStatus(this.f38568b);
            if (Build.VERSION.SDK_INT > 7) {
                com.qq.e.comm.services.a.a().a(this.f38568b, this.f38569c, this.f38570d, this.f38573g, this.f38572f, nanoTime);
            }
            this.f38567a = Boolean.TRUE;
            return true;
        }
    }

    public boolean isInitialized() {
        if (this.f38567a == null) {
            return false;
        }
        return this.f38567a.booleanValue();
    }

    public void setPluginLoadListener(PM.a.InterfaceC0484a interfaceC0484a) {
        this.i = interfaceC0484a;
    }
}
