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
    public volatile Boolean f36237a;

    /* renamed from: b  reason: collision with root package name */
    public volatile Context f36238b;

    /* renamed from: c  reason: collision with root package name */
    public volatile SM f36239c;

    /* renamed from: d  reason: collision with root package name */
    public volatile PM f36240d;

    /* renamed from: e  reason: collision with root package name */
    public volatile DevTools f36241e;

    /* renamed from: f  reason: collision with root package name */
    public volatile APPStatus f36242f;

    /* renamed from: g  reason: collision with root package name */
    public volatile DeviceStatus f36243g;

    /* renamed from: h  reason: collision with root package name */
    public volatile String f36244h;

    /* renamed from: i  reason: collision with root package name */
    public PM.a.InterfaceC0431a f36245i;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static GDTADManager f36246a = new GDTADManager((byte) 0);
    }

    public GDTADManager() {
        this.f36237a = Boolean.FALSE;
    }

    public /* synthetic */ GDTADManager(byte b2) {
        this();
    }

    public static GDTADManager getInstance() {
        return a.f36246a;
    }

    public JSONObject buildS2SSBaseInfo() throws JSONException {
        if (isInitialized()) {
            JSONObject a2 = com.qq.e.comm.net.a.a(this.f36239c);
            a2.put("app", com.qq.e.comm.net.a.a(this.f36242f));
            a2.put("c", com.qq.e.comm.net.a.a(this.f36243g));
            a2.put("sdk", com.qq.e.comm.net.a.a(this.f36240d));
            return a2;
        }
        return null;
    }

    public String getADActivityClazz() {
        return CustomPkgConstants.getADActivityName();
    }

    public Context getAppContext() {
        return this.f36238b;
    }

    public APPStatus getAppStatus() {
        return this.f36242f;
    }

    public DevTools getDevTools() {
        if (this.f36241e == null) {
            this.f36241e = new DevTools();
        }
        return this.f36241e;
    }

    public DeviceStatus getDeviceStatus() {
        return this.f36243g;
    }

    public String getDownLoadClazz() {
        return CustomPkgConstants.getDownLoadServiceName();
    }

    public String getLandscapeADActivityClazz() {
        return CustomPkgConstants.getLandscapeADActivityName();
    }

    public PM getPM() {
        return this.f36240d;
    }

    public String getPortraitADActivityClazz() {
        return CustomPkgConstants.getPortraitADActivityName();
    }

    public String getProcessName() {
        return this.f36244h;
    }

    public String getRewardvideoLandscapeADActivityClazz() {
        return CustomPkgConstants.getRewardvideoLandscapeADActivityName();
    }

    public String getRewardvideoPortraitADActivityClazz() {
        return CustomPkgConstants.getRewardvideoPortraitADActivityName();
    }

    public SM getSM() {
        return this.f36239c;
    }

    public synchronized boolean initWith(Context context, String str) {
        if (Build.VERSION.SDK_INT < 14) {
            GDTLogger.e("system version not support !");
            return false;
        } else if (this.f36237a.booleanValue()) {
            return true;
        } else {
            if (context == null || StringUtil.isEmpty(str)) {
                GDTLogger.e("Context And APPID should Never Be NULL while init GDTADManager");
                return false;
            }
            long nanoTime = System.nanoTime();
            this.f36244h = SystemUtil.getProcessName(context);
            this.f36238b = context.getApplicationContext();
            this.f36239c = new SM(this.f36238b);
            this.f36240d = new PM(this.f36238b, this.f36245i);
            this.f36242f = new APPStatus(str, this.f36238b);
            this.f36243g = new DeviceStatus(this.f36238b);
            if (Build.VERSION.SDK_INT > 7) {
                com.qq.e.comm.services.a.a().a(this.f36238b, this.f36239c, this.f36240d, this.f36243g, this.f36242f, nanoTime);
            }
            this.f36237a = Boolean.TRUE;
            return true;
        }
    }

    public boolean isInitialized() {
        if (this.f36237a == null) {
            return false;
        }
        return this.f36237a.booleanValue();
    }

    public void setPluginLoadListener(PM.a.InterfaceC0431a interfaceC0431a) {
        this.f36245i = interfaceC0431a;
    }
}
