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
    public volatile Boolean f39090a;

    /* renamed from: b  reason: collision with root package name */
    public volatile Context f39091b;

    /* renamed from: c  reason: collision with root package name */
    public volatile SM f39092c;

    /* renamed from: d  reason: collision with root package name */
    public volatile PM f39093d;

    /* renamed from: e  reason: collision with root package name */
    public volatile DevTools f39094e;

    /* renamed from: f  reason: collision with root package name */
    public volatile APPStatus f39095f;

    /* renamed from: g  reason: collision with root package name */
    public volatile DeviceStatus f39096g;

    /* renamed from: h  reason: collision with root package name */
    public volatile String f39097h;

    /* renamed from: i  reason: collision with root package name */
    public PM.a.InterfaceC0470a f39098i;

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static GDTADManager f39099a = new GDTADManager((byte) 0);
    }

    public GDTADManager() {
        this.f39090a = Boolean.FALSE;
    }

    public /* synthetic */ GDTADManager(byte b2) {
        this();
    }

    public static GDTADManager getInstance() {
        return a.f39099a;
    }

    public JSONObject buildS2SSBaseInfo() throws JSONException {
        if (isInitialized()) {
            JSONObject a2 = com.qq.e.comm.net.a.a(this.f39092c);
            a2.put("app", com.qq.e.comm.net.a.a(this.f39095f));
            a2.put("c", com.qq.e.comm.net.a.a(this.f39096g));
            a2.put("sdk", com.qq.e.comm.net.a.a(this.f39093d));
            return a2;
        }
        return null;
    }

    public String getADActivityClazz() {
        return CustomPkgConstants.getADActivityName();
    }

    public Context getAppContext() {
        return this.f39091b;
    }

    public APPStatus getAppStatus() {
        return this.f39095f;
    }

    public DevTools getDevTools() {
        if (this.f39094e == null) {
            this.f39094e = new DevTools();
        }
        return this.f39094e;
    }

    public DeviceStatus getDeviceStatus() {
        return this.f39096g;
    }

    public String getDownLoadClazz() {
        return CustomPkgConstants.getDownLoadServiceName();
    }

    public String getLandscapeADActivityClazz() {
        return CustomPkgConstants.getLandscapeADActivityName();
    }

    public PM getPM() {
        return this.f39093d;
    }

    public String getPortraitADActivityClazz() {
        return CustomPkgConstants.getPortraitADActivityName();
    }

    public String getProcessName() {
        return this.f39097h;
    }

    public String getRewardvideoLandscapeADActivityClazz() {
        return CustomPkgConstants.getRewardvideoLandscapeADActivityName();
    }

    public String getRewardvideoPortraitADActivityClazz() {
        return CustomPkgConstants.getRewardvideoPortraitADActivityName();
    }

    public SM getSM() {
        return this.f39092c;
    }

    public synchronized boolean initWith(Context context, String str) {
        if (Build.VERSION.SDK_INT < 14) {
            GDTLogger.e("system version not support !");
            return false;
        } else if (this.f39090a.booleanValue()) {
            return true;
        } else {
            if (context == null || StringUtil.isEmpty(str)) {
                GDTLogger.e("Context And APPID should Never Be NULL while init GDTADManager");
                return false;
            }
            long nanoTime = System.nanoTime();
            this.f39097h = SystemUtil.getProcessName(context);
            this.f39091b = context.getApplicationContext();
            this.f39092c = new SM(this.f39091b);
            this.f39093d = new PM(this.f39091b, this.f39098i);
            this.f39095f = new APPStatus(str, this.f39091b);
            this.f39096g = new DeviceStatus(this.f39091b);
            if (Build.VERSION.SDK_INT > 7) {
                com.qq.e.comm.services.a.a().a(this.f39091b, this.f39092c, this.f39093d, this.f39096g, this.f39095f, nanoTime);
            }
            this.f39090a = Boolean.TRUE;
            return true;
        }
    }

    public boolean isInitialized() {
        if (this.f39090a == null) {
            return false;
        }
        return this.f39090a.booleanValue();
    }

    public void setPluginLoadListener(PM.a.InterfaceC0470a interfaceC0470a) {
        this.f39098i = interfaceC0470a;
    }
}
