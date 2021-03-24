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
    public volatile Boolean f38277a;

    /* renamed from: b  reason: collision with root package name */
    public volatile Context f38278b;

    /* renamed from: c  reason: collision with root package name */
    public volatile SM f38279c;

    /* renamed from: d  reason: collision with root package name */
    public volatile PM f38280d;

    /* renamed from: e  reason: collision with root package name */
    public volatile DevTools f38281e;

    /* renamed from: f  reason: collision with root package name */
    public volatile APPStatus f38282f;

    /* renamed from: g  reason: collision with root package name */
    public volatile DeviceStatus f38283g;

    /* renamed from: h  reason: collision with root package name */
    public volatile String f38284h;
    public PM.a.InterfaceC0469a i;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static GDTADManager f38285a = new GDTADManager((byte) 0);
    }

    public GDTADManager() {
        this.f38277a = Boolean.FALSE;
    }

    public /* synthetic */ GDTADManager(byte b2) {
        this();
    }

    public static GDTADManager getInstance() {
        return a.f38285a;
    }

    public JSONObject buildS2SSBaseInfo() throws JSONException {
        if (isInitialized()) {
            JSONObject a2 = com.qq.e.comm.net.a.a(this.f38279c);
            a2.put("app", com.qq.e.comm.net.a.a(this.f38282f));
            a2.put("c", com.qq.e.comm.net.a.a(this.f38283g));
            a2.put("sdk", com.qq.e.comm.net.a.a(this.f38280d));
            return a2;
        }
        return null;
    }

    public String getADActivityClazz() {
        return CustomPkgConstants.getADActivityName();
    }

    public Context getAppContext() {
        return this.f38278b;
    }

    public APPStatus getAppStatus() {
        return this.f38282f;
    }

    public DevTools getDevTools() {
        if (this.f38281e == null) {
            this.f38281e = new DevTools();
        }
        return this.f38281e;
    }

    public DeviceStatus getDeviceStatus() {
        return this.f38283g;
    }

    public String getDownLoadClazz() {
        return CustomPkgConstants.getDownLoadServiceName();
    }

    public String getLandscapeADActivityClazz() {
        return CustomPkgConstants.getLandscapeADActivityName();
    }

    public PM getPM() {
        return this.f38280d;
    }

    public String getPortraitADActivityClazz() {
        return CustomPkgConstants.getPortraitADActivityName();
    }

    public String getProcessName() {
        return this.f38284h;
    }

    public String getRewardvideoLandscapeADActivityClazz() {
        return CustomPkgConstants.getRewardvideoLandscapeADActivityName();
    }

    public String getRewardvideoPortraitADActivityClazz() {
        return CustomPkgConstants.getRewardvideoPortraitADActivityName();
    }

    public SM getSM() {
        return this.f38279c;
    }

    public synchronized boolean initWith(Context context, String str) {
        if (Build.VERSION.SDK_INT < 14) {
            GDTLogger.e("system version not support !");
            return false;
        } else if (this.f38277a.booleanValue()) {
            return true;
        } else {
            if (context == null || StringUtil.isEmpty(str)) {
                GDTLogger.e("Context And APPID should Never Be NULL while init GDTADManager");
                return false;
            }
            long nanoTime = System.nanoTime();
            this.f38284h = SystemUtil.getProcessName(context);
            this.f38278b = context.getApplicationContext();
            this.f38279c = new SM(this.f38278b);
            this.f38280d = new PM(this.f38278b, this.i);
            this.f38282f = new APPStatus(str, this.f38278b);
            this.f38283g = new DeviceStatus(this.f38278b);
            if (Build.VERSION.SDK_INT > 7) {
                com.qq.e.comm.services.a.a().a(this.f38278b, this.f38279c, this.f38280d, this.f38283g, this.f38282f, nanoTime);
            }
            this.f38277a = Boolean.TRUE;
            return true;
        }
    }

    public boolean isInitialized() {
        if (this.f38277a == null) {
            return false;
        }
        return this.f38277a.booleanValue();
    }

    public void setPluginLoadListener(PM.a.InterfaceC0469a interfaceC0469a) {
        this.i = interfaceC0469a;
    }
}
