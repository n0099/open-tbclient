package d.b.c.e.f;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import d.b.c.e.f.b;
/* loaded from: classes.dex */
public abstract class a {
    public static final int DEF_CRASHTIME_LIMIT = 10;
    public static final int OFF_TYPE = 0;
    public static final int ON_TYPE = 1;
    public String[] mKey;
    public String mName;
    public int mDefaultType = 0;
    public int mOffType = 1;
    public int mMaxCrashTimes = 10;
    public b.a mSwitchListener = new C0553a();

    /* renamed from: d.b.c.e.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0553a implements b.a {
        public C0553a() {
        }

        @Override // d.b.c.e.f.b.a
        public void a(String str, int i, boolean z) {
            a.this.changeSettingByType(i);
        }
    }

    public a() {
        initData();
        addToManager();
    }

    public void addToManager() {
        b bVar = new b(this.mName, this.mDefaultType, this.mSwitchListener);
        bVar.i(this.mMaxCrashTimes, this.mKey, this.mOffType);
        bVar.k(getSwitchLibs());
        SwitchManager.getInstance().addSwitchData(bVar);
    }

    public abstract void changeSettingByType(int i);

    public abstract String[] getCrashKeys();

    public abstract int getDefaultType();

    public abstract int getMaxCrashTimes();

    public abstract String getName();

    public abstract int getOffType();

    public String[] getSwitchLibs() {
        return null;
    }

    public void initData() {
        this.mName = getName();
        this.mKey = getCrashKeys();
        this.mDefaultType = getDefaultType();
        this.mOffType = getOffType();
        this.mMaxCrashTimes = getMaxCrashTimes();
    }
}
