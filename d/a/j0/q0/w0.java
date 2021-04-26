package d.a.j0.q0;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
/* loaded from: classes4.dex */
public class w0 extends d.a.c.e.f.a {
    public static boolean isOn() {
        return SwitchManager.getInstance().findType("official_thread_enable_delete_switch") == 1;
    }

    @Override // d.a.c.e.f.a
    public void changeSettingByType(int i2) {
    }

    @Override // d.a.c.e.f.a
    public String[] getCrashKeys() {
        return null;
    }

    @Override // d.a.c.e.f.a
    public int getDefaultType() {
        return 0;
    }

    @Override // d.a.c.e.f.a
    public int getMaxCrashTimes() {
        return 10;
    }

    @Override // d.a.c.e.f.a
    public String getName() {
        return "official_thread_enable_delete_switch";
    }

    @Override // d.a.c.e.f.a
    public int getOffType() {
        return 0;
    }
}
