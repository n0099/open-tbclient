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
/* loaded from: classes3.dex */
public class GDTADManager {
    public static final ExecutorService INIT_EXECUTOR = Executors.newSingleThreadExecutor();

    /* renamed from: a  reason: collision with root package name */
    public volatile Boolean f35482a;

    /* renamed from: b  reason: collision with root package name */
    public volatile Context f35483b;

    /* renamed from: c  reason: collision with root package name */
    public volatile SM f35484c;

    /* renamed from: d  reason: collision with root package name */
    public volatile PM f35485d;

    /* renamed from: e  reason: collision with root package name */
    public volatile DevTools f35486e;

    /* renamed from: f  reason: collision with root package name */
    public volatile APPStatus f35487f;

    /* renamed from: g  reason: collision with root package name */
    public volatile DeviceStatus f35488g;

    /* renamed from: h  reason: collision with root package name */
    public volatile String f35489h;

    /* renamed from: i  reason: collision with root package name */
    public PM.a.InterfaceC0418a f35490i;

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static GDTADManager f35491a = new GDTADManager((byte) 0);
    }

    public GDTADManager() {
        this.f35482a = Boolean.FALSE;
    }

    public /* synthetic */ GDTADManager(byte b2) {
        this();
    }

    public static GDTADManager getInstance() {
        return a.f35491a;
    }

    public JSONObject buildS2SSBaseInfo() throws JSONException {
        if (isInitialized()) {
            JSONObject a2 = com.qq.e.comm.net.a.a(this.f35484c);
            a2.put("app", com.qq.e.comm.net.a.a(this.f35487f));
            a2.put("c", com.qq.e.comm.net.a.a(this.f35488g));
            a2.put("sdk", com.qq.e.comm.net.a.a(this.f35485d));
            return a2;
        }
        return null;
    }

    public String getADActivityClazz() {
        return CustomPkgConstants.getADActivityName();
    }

    public Context getAppContext() {
        return this.f35483b;
    }

    public APPStatus getAppStatus() {
        return this.f35487f;
    }

    public DevTools getDevTools() {
        if (this.f35486e == null) {
            this.f35486e = new DevTools();
        }
        return this.f35486e;
    }

    public DeviceStatus getDeviceStatus() {
        return this.f35488g;
    }

    public String getDownLoadClazz() {
        return CustomPkgConstants.getDownLoadServiceName();
    }

    public String getLandscapeADActivityClazz() {
        return CustomPkgConstants.getLandscapeADActivityName();
    }

    public PM getPM() {
        return this.f35485d;
    }

    public String getPortraitADActivityClazz() {
        return CustomPkgConstants.getPortraitADActivityName();
    }

    public String getProcessName() {
        return this.f35489h;
    }

    public String getRewardvideoLandscapeADActivityClazz() {
        return CustomPkgConstants.getRewardvideoLandscapeADActivityName();
    }

    public String getRewardvideoPortraitADActivityClazz() {
        return CustomPkgConstants.getRewardvideoPortraitADActivityName();
    }

    public SM getSM() {
        return this.f35484c;
    }

    public synchronized boolean initWith(Context context, String str) {
        if (Build.VERSION.SDK_INT < 14) {
            GDTLogger.e("system version not support !");
            return false;
        } else if (this.f35482a.booleanValue()) {
            return true;
        } else {
            if (context == null || StringUtil.isEmpty(str)) {
                GDTLogger.e("Context And APPID should Never Be NULL while init GDTADManager");
                return false;
            }
            long nanoTime = System.nanoTime();
            this.f35489h = SystemUtil.getProcessName(context);
            this.f35483b = context.getApplicationContext();
            this.f35484c = new SM(this.f35483b);
            this.f35485d = new PM(this.f35483b, this.f35490i);
            this.f35487f = new APPStatus(str, this.f35483b);
            this.f35488g = new DeviceStatus(this.f35483b);
            if (Build.VERSION.SDK_INT > 7) {
                com.qq.e.comm.services.a.a().a(this.f35483b, this.f35484c, this.f35485d, this.f35488g, this.f35487f, nanoTime);
            }
            this.f35482a = Boolean.TRUE;
            return true;
        }
    }

    public boolean isInitialized() {
        if (this.f35482a == null) {
            return false;
        }
        return this.f35482a.booleanValue();
    }

    public void setPluginLoadListener(PM.a.InterfaceC0418a interfaceC0418a) {
        this.f35490i = interfaceC0418a;
    }
}
