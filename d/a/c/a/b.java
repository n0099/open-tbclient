package d.a.c.a;

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
    public static ArrayList<SoftReference<Activity>> f42052c;

    /* renamed from: d  reason: collision with root package name */
    public static b f42053d;

    /* renamed from: a  reason: collision with root package name */
    public a f42054a;

    /* renamed from: b  reason: collision with root package name */
    public int f42055b = 0;

    /* loaded from: classes.dex */
    public interface a {
        void onActivityClosed();
    }

    public b() {
        if (f42052c == null) {
            f42052c = new ArrayList<>(20);
        }
    }

    public static b f() {
        if (f42053d == null) {
            f42053d = new b();
        }
        return f42053d;
    }

    public final void a(int i2) {
        if (i2 == 0) {
            return;
        }
        int g2 = f().g();
        while (g2 > i2) {
            g2--;
            Activity k = f().k(1);
            if (k != null) {
                k.finish();
            }
        }
    }

    public Activity b() {
        SoftReference<Activity> softReference;
        int size = f42052c.size();
        if (size == 0 || (softReference = f42052c.get(size - 1)) == null) {
            return null;
        }
        return softReference.get();
    }

    public String c() {
        ActivityManager activityManager;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        String str;
        Activity activity;
        ArrayList<SoftReference<Activity>> arrayList = f42052c;
        if (arrayList != null && arrayList.size() != 0) {
            StringBuilder sb = new StringBuilder();
            Iterator<SoftReference<Activity>> it = f42052c.iterator();
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
        return this.f42055b;
    }

    public Activity e(int i2) {
        SoftReference<Activity> softReference;
        int size = f42052c.size();
        if (size != 0 && i2 >= 0 && i2 < size && (softReference = f42052c.get(i2)) != null) {
            return softReference.get();
        }
        return null;
    }

    public int g() {
        return f42052c.size();
    }

    public boolean h(String str) {
        if (f42052c.size() == 0) {
            return false;
        }
        Iterator<SoftReference<Activity>> it = f42052c.iterator();
        while (it.hasNext()) {
            SoftReference<Activity> next = it.next();
            if (next != null && next.get() != null && next.get().getClass().getSimpleName() != null && next.get().getClass().getSimpleName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public int i(Activity activity) {
        int size = f42052c.size();
        if (size <= 0 || activity == null) {
            return -1;
        }
        for (int i2 = size - 1; i2 >= 0; i2--) {
            SoftReference<Activity> softReference = f42052c.get(i2);
            if (softReference == null) {
                f42052c.remove(i2);
            } else if (activity.equals(softReference.get())) {
                return i2;
            }
        }
        return -1;
    }

    public Activity j() {
        SoftReference<Activity> remove;
        int size = f42052c.size();
        if (size == 0 || (remove = f42052c.remove(size - 1)) == null) {
            return null;
        }
        return remove.get();
    }

    public Activity k(int i2) {
        SoftReference<Activity> remove;
        int size = f42052c.size();
        if (size != 0 && i2 >= 0 && i2 < size && (remove = f42052c.remove(i2)) != null) {
            return remove.get();
        }
        return null;
    }

    public void l(Activity activity) {
        a aVar;
        a aVar2;
        if (activity != null) {
            int size = f42052c.size();
            if (size == 0) {
                a aVar3 = this.f42054a;
                if (aVar3 != null) {
                    aVar3.onActivityClosed();
                    return;
                }
                return;
            }
            for (int i2 = size - 1; i2 >= 0; i2--) {
                SoftReference<Activity> softReference = f42052c.get(i2);
                if (softReference == null) {
                    f42052c.remove(i2);
                } else if (activity.equals(softReference.get())) {
                    f42052c.remove(i2);
                    if (f42052c.size() != 0 || (aVar = this.f42054a) == null) {
                        return;
                    }
                    aVar.onActivityClosed();
                    return;
                } else if (f42052c.size() == 0 && (aVar2 = this.f42054a) != null) {
                    aVar2.onActivityClosed();
                }
            }
        }
    }

    public void m(int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            Activity j = j();
            if (j != null) {
                j.finish();
            }
        }
    }

    public void n(Activity activity) {
        if (activity != null) {
            f42052c.add(new SoftReference<>(activity));
            a(this.f42055b);
        }
    }

    public void o() {
        Activity activity;
        if (f42052c != null) {
            while (!f42052c.isEmpty()) {
                SoftReference<Activity> remove = f42052c.remove(0);
                if (remove != null && remove.get() != null && (activity = remove.get()) != null) {
                    activity.finish();
                }
            }
        }
        a aVar = this.f42054a;
        if (aVar != null) {
            aVar.onActivityClosed();
        }
    }

    public void p() {
        a(3);
    }

    public void q(int i2) {
        if (i2 >= 10 || i2 == 0) {
            this.f42055b = i2;
        }
    }

    public void r(a aVar) {
        this.f42054a = aVar;
    }
}
