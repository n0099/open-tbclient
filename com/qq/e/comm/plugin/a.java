package com.qq.e.comm.plugin;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.managers.status.SDKStatus;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f11885a;

    private a() {
    }

    public static a a() {
        if (f11885a == null) {
            synchronized (a.class) {
                try {
                    if (f11885a == null) {
                        f11885a = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f11885a;
    }

    public String b() {
        return SDKStatus.getSDKVersionCode() >= 60 ? GDTADManager.getInstance().getSM().getSettingDir() : "e_qq_com_setting";
    }

    public Integer c() {
        if (SDKStatus.getSDKVersionCode() >= 50) {
            try {
                return GlobalSetting.getChannel();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public boolean d() {
        return (GDTADManager.getInstance().getSM().getInteger("ubulap", 1) == 1) && SDKStatus.getSDKVersionCode() >= 120;
    }

    public boolean e() {
        return (GDTADManager.getInstance().getSM().getInteger("rvaulap", 1) == 1) && SDKStatus.getSDKVersionCode() >= 120;
    }
}
