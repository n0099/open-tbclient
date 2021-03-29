package d.b.b.a;

import android.app.Activity;
import android.app.ActivityManager;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.StringUtils;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: c  reason: collision with root package name */
    public static ArrayList<SoftReference<Activity>> f41465c;

    /* renamed from: d  reason: collision with root package name */
    public static b f41466d;

    /* renamed from: a  reason: collision with root package name */
    public a f41467a;

    /* renamed from: b  reason: collision with root package name */
    public int f41468b = 0;

    /* loaded from: classes.dex */
    public interface a {
        void onActivityClosed();
    }

    public b() {
        if (f41465c == null) {
            f41465c = new ArrayList<>(20);
        }
    }

    public static b f() {
        if (f41466d == null) {
            f41466d = new b();
        }
        return f41466d;
    }

    public final void a(int i) {
        if (i == 0) {
            return;
        }
        int g2 = f().g();
        while (g2 > i) {
            g2--;
            Activity k = f().k(1);
            if (k != null) {
                k.finish();
            }
        }
    }

    public Activity b() {
        SoftReference<Activity> softReference;
        int size = f41465c.size();
        if (size == 0 || (softReference = f41465c.get(size - 1)) == null) {
            return null;
        }
        return softReference.get();
    }

    public String c() {
        ActivityManager activityManager;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        String str;
        Activity activity;
        ArrayList<SoftReference<Activity>> arrayList = f41465c;
        if (arrayList != null && arrayList.size() != 0) {
            StringBuilder sb = new StringBuilder();
            Iterator<SoftReference<Activity>> it = f41465c.iterator();
            while (it.hasNext()) {
                SoftReference<Activity> next = it.next();
                if (next != null && (activity = next.get()) != null) {
                    String simpleName = (activity == null || activity.getClass() == null) ? "" : activity.getClass().getSimpleName();
                    if (!StringUtils.isNull(simpleName)) {
                        sb.append(simpleName + ";");
                    }
                }
            }
            return sb.toString();
        }
        try {
            if (BdBaseApplication.getInst() != null && (activityManager = (ActivityManager) BdBaseApplication.getInst().getSystemService("activity")) != null && (runningTasks = activityManager.getRunningTasks(1)) != null && runningTasks.size() > 0) {
                StringBuilder sb2 = new StringBuilder();
                for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                    if (runningTaskInfo != null) {
                        String str2 = runningTaskInfo.topActivity != null ? "top:" + runningTaskInfo.topActivity.getClassName() : "";
                        if (runningTaskInfo.baseActivity != null) {
                            str2 = str2 + "&base:" + runningTaskInfo.baseActivity.getClassName();
                        }
                        str = str2 + "&numbers:" + runningTaskInfo.numActivities;
                    } else {
                        str = "";
                    }
                    if (!StringUtils.isNull(str)) {
                        sb2.append(str + ";");
                    }
                }
                return sb2.toString();
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public int d() {
        return this.f41468b;
    }

    public Activity e(int i) {
        SoftReference<Activity> softReference;
        int size = f41465c.size();
        if (size != 0 && i >= 0 && i < size && (softReference = f41465c.get(i)) != null) {
            return softReference.get();
        }
        return null;
    }

    public int g() {
        return f41465c.size();
    }

    public boolean h(String str) {
        if (f41465c.size() == 0) {
            return false;
        }
        Iterator<SoftReference<Activity>> it = f41465c.iterator();
        while (it.hasNext()) {
            SoftReference<Activity> next = it.next();
            if (next != null && next.get() != null && next.get().getClass().getSimpleName() != null && next.get().getClass().getSimpleName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public int i(Activity activity) {
        int size = f41465c.size();
        if (size <= 0 || activity == null) {
            return -1;
        }
        for (int i = size - 1; i >= 0; i--) {
            SoftReference<Activity> softReference = f41465c.get(i);
            if (softReference == null) {
                f41465c.remove(i);
            } else if (activity.equals(softReference.get())) {
                return i;
            }
        }
        return -1;
    }

    public Activity j() {
        SoftReference<Activity> remove;
        int size = f41465c.size();
        if (size == 0 || (remove = f41465c.remove(size - 1)) == null) {
            return null;
        }
        return remove.get();
    }

    public Activity k(int i) {
        SoftReference<Activity> remove;
        int size = f41465c.size();
        if (size != 0 && i >= 0 && i < size && (remove = f41465c.remove(i)) != null) {
            return remove.get();
        }
        return null;
    }

    public void l(Activity activity) {
        a aVar;
        a aVar2;
        if (activity != null) {
            int size = f41465c.size();
            if (size == 0) {
                a aVar3 = this.f41467a;
                if (aVar3 != null) {
                    aVar3.onActivityClosed();
                    return;
                }
                return;
            }
            for (int i = size - 1; i >= 0; i--) {
                SoftReference<Activity> softReference = f41465c.get(i);
                if (softReference == null) {
                    f41465c.remove(i);
                } else if (activity.equals(softReference.get())) {
                    f41465c.remove(i);
                    if (f41465c.size() != 0 || (aVar = this.f41467a) == null) {
                        return;
                    }
                    aVar.onActivityClosed();
                    return;
                } else if (f41465c.size() == 0 && (aVar2 = this.f41467a) != null) {
                    aVar2.onActivityClosed();
                }
            }
        }
    }

    public void m(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            Activity j = j();
            if (j != null) {
                j.finish();
            }
        }
    }

    public void n(Activity activity) {
        if (activity != null) {
            f41465c.add(new SoftReference<>(activity));
            a(this.f41468b);
        }
    }

    public void o() {
        Activity activity;
        if (f41465c != null) {
            while (!f41465c.isEmpty()) {
                SoftReference<Activity> remove = f41465c.remove(0);
                if (remove != null && remove.get() != null && (activity = remove.get()) != null) {
                    activity.finish();
                }
            }
        }
        a aVar = this.f41467a;
        if (aVar != null) {
            aVar.onActivityClosed();
        }
    }

    public void p() {
        a(3);
    }

    public void q(int i) {
        if (i >= 10 || i == 0) {
            this.f41468b = i;
        }
    }

    public void r(a aVar) {
        this.f41467a = aVar;
    }
}
