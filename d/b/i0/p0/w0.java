package d.b.i0.p0;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
/* loaded from: classes4.dex */
public class w0 extends d.b.b.e.f.a {
    public static boolean isOn() {
        return SwitchManager.getInstance().findType("official_thread_enable_delete_switch") == 1;
    }

    @Override // d.b.b.e.f.a
    public void changeSettingByType(int i) {
    }

    @Override // d.b.b.e.f.a
    public String[] getCrashKeys() {
        return null;
    }

    @Override // d.b.b.e.f.a
    public int getDefaultType() {
        return 0;
    }

    @Override // d.b.b.e.f.a
    public int getMaxCrashTimes() {
        return 10;
    }

    @Override // d.b.b.e.f.a
    public String getName() {
        return "official_thread_enable_delete_switch";
    }

    @Override // d.b.b.e.f.a
    public int getOffType() {
        return 0;
    }
}
