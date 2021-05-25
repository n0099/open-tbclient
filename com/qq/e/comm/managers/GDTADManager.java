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
/* loaded from: classes7.dex */
public class GDTADManager {
    public static final ExecutorService INIT_EXECUTOR = Executors.newSingleThreadExecutor();

    /* renamed from: a  reason: collision with root package name */
    public volatile Boolean f35411a;

    /* renamed from: b  reason: collision with root package name */
    public volatile Context f35412b;

    /* renamed from: c  reason: collision with root package name */
    public volatile SM f35413c;

    /* renamed from: d  reason: collision with root package name */
    public volatile PM f35414d;

    /* renamed from: e  reason: collision with root package name */
    public volatile DevTools f35415e;

    /* renamed from: f  reason: collision with root package name */
    public volatile APPStatus f35416f;

    /* renamed from: g  reason: collision with root package name */
    public volatile DeviceStatus f35417g;

    /* renamed from: h  reason: collision with root package name */
    public volatile String f35418h;

    /* renamed from: i  reason: collision with root package name */
    public PM.a.InterfaceC0419a f35419i;

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static GDTADManager f35420a = new GDTADManager((byte) 0);
    }

    public GDTADManager() {
        this.f35411a = Boolean.FALSE;
    }

    public /* synthetic */ GDTADManager(byte b2) {
        this();
    }

    public static GDTADManager getInstance() {
        return a.f35420a;
    }

    public JSONObject buildS2SSBaseInfo() throws JSONException {
        if (isInitialized()) {
            JSONObject a2 = com.qq.e.comm.net.a.a(this.f35413c);
            a2.put("app", com.qq.e.comm.net.a.a(this.f35416f));
            a2.put("c", com.qq.e.comm.net.a.a(this.f35417g));
            a2.put("sdk", com.qq.e.comm.net.a.a(this.f35414d));
            return a2;
        }
        return null;
    }

    public String getADActivityClazz() {
        return CustomPkgConstants.getADActivityName();
    }

    public Context getAppContext() {
        return this.f35412b;
    }

    public APPStatus getAppStatus() {
        return this.f35416f;
    }

    public DevTools getDevTools() {
        if (this.f35415e == null) {
            this.f35415e = new DevTools();
        }
        return this.f35415e;
    }

    public DeviceStatus getDeviceStatus() {
        return this.f35417g;
    }

    public String getDownLoadClazz() {
        return CustomPkgConstants.getDownLoadServiceName();
    }

    public String getLandscapeADActivityClazz() {
        return CustomPkgConstants.getLandscapeADActivityName();
    }

    public PM getPM() {
        return this.f35414d;
    }

    public String getPortraitADActivityClazz() {
        return CustomPkgConstants.getPortraitADActivityName();
    }

    public String getProcessName() {
        return this.f35418h;
    }

    public String getRewardvideoLandscapeADActivityClazz() {
        return CustomPkgConstants.getRewardvideoLandscapeADActivityName();
    }

    public String getRewardvideoPortraitADActivityClazz() {
        return CustomPkgConstants.getRewardvideoPortraitADActivityName();
    }

    public SM getSM() {
        return this.f35413c;
    }

    public synchronized boolean initWith(Context context, String str) {
        if (Build.VERSION.SDK_INT < 14) {
            GDTLogger.e("system version not support !");
            return false;
        } else if (this.f35411a.booleanValue()) {
            return true;
        } else {
            if (context == null || StringUtil.isEmpty(str)) {
                GDTLogger.e("Context And APPID should Never Be NULL while init GDTADManager");
                return false;
            }
            long nanoTime = System.nanoTime();
            this.f35418h = SystemUtil.getProcessName(context);
            this.f35412b = context.getApplicationContext();
            this.f35413c = new SM(this.f35412b);
            this.f35414d = new PM(this.f35412b, this.f35419i);
            this.f35416f = new APPStatus(str, this.f35412b);
            this.f35417g = new DeviceStatus(this.f35412b);
            if (Build.VERSION.SDK_INT > 7) {
                com.qq.e.comm.services.a.a().a(this.f35412b, this.f35413c, this.f35414d, this.f35417g, this.f35416f, nanoTime);
            }
            this.f35411a = Boolean.TRUE;
            return true;
        }
    }

    public boolean isInitialized() {
        if (this.f35411a == null) {
            return false;
        }
        return this.f35411a.booleanValue();
    }

    public void setPluginLoadListener(PM.a.InterfaceC0419a interfaceC0419a) {
        this.f35419i = interfaceC0419a;
    }
}
