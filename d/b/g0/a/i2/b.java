package d.b.g0.a.i2;

import android.app.ActivityManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanRelayActivity;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.model.SwanTaskDeadEvent;
import com.xiaomi.mipush.sdk.Constants;
import d.b.g0.a.y0.e.b;
import d.b.g0.a.y0.e.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f45054f = d.b.g0.a.k.f45443a;

    /* renamed from: g  reason: collision with root package name */
    public static volatile int f45055g = -1;

    /* renamed from: h  reason: collision with root package name */
    public static volatile int f45056h = -1;
    public static final boolean i = c.f();
    public static volatile b j;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public ActivityManager f45057a;

    /* renamed from: b  reason: collision with root package name */
    public List<ActivityManager.AppTask> f45058b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<Integer> f45059c;

    /* renamed from: d  reason: collision with root package name */
    public final SparseIntArray f45060d = new SparseIntArray();

    /* renamed from: e  reason: collision with root package name */
    public final SparseArray<SwanTaskDeadEvent> f45061e = new SparseArray<>();

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a f45062e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f45063f;

        public a(b.a aVar, int i) {
            this.f45062e = aVar;
            this.f45063f = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.i();
            b.a aVar = this.f45062e;
            if (aVar != null && "1202000800000000".equals(aVar.S())) {
                SwanTaskDeadEvent swanTaskDeadEvent = (SwanTaskDeadEvent) this.f45062e.l("key_stack_info");
                if (swanTaskDeadEvent != null) {
                    b.this.f45059c = swanTaskDeadEvent.d();
                    SparseArray<SwanTaskDeadEvent> b2 = swanTaskDeadEvent.b();
                    if (b2 != null) {
                        for (int i = 0; i < b2.size(); i++) {
                            int keyAt = b2.keyAt(i);
                            SwanTaskDeadEvent valueAt = b2.valueAt(i);
                            if (valueAt != null && valueAt.a() != null) {
                                b.this.f45061e.put(keyAt, valueAt);
                                b.this.f45060d.put(valueAt.a().hashCode(), keyAt);
                            }
                        }
                    }
                    b.this.h(null, swanTaskDeadEvent.e(), this.f45063f);
                }
                if (b.f45054f) {
                    Log.d("SwanActivityTaskManager", "stack back: " + b.this.f45059c);
                    return;
                }
                return;
            }
            b.a aVar2 = this.f45062e;
            if (aVar2 != null) {
                b.this.h(aVar2.G(), -1, this.f45063f);
            }
            b bVar = b.this;
            bVar.f45059c = bVar.o();
            if (b.f45054f) {
                Log.d("SwanActivityTaskManager", "getLaunchTask=" + b.this.f45059c);
            }
        }
    }

    public b() {
        Application c2 = d.b.g0.a.w0.a.c();
        if (c2 != null) {
            this.f45057a = (ActivityManager) c2.getSystemService("activity");
        }
    }

    public static boolean j() {
        if (f45055g == -1) {
            synchronized (b.class) {
                if (f45055g == -1) {
                    if (f45054f && d.b.g0.a.m1.a.a.r().getBoolean("swan_page_stack_optimize", false)) {
                        f45055g = 1;
                        return true;
                    }
                    d.b.g0.a.w0.a.N().getSwitch("swan_page_stack_optimize", true);
                    f45055g = i ? 1 : 0;
                }
            }
        }
        return f45055g == 1;
    }

    public static boolean k() {
        if (f45056h == -1) {
            d.b.g0.a.w0.a.N().getSwitch("swan_move_task_optimize", 1);
            f45056h = 1;
        }
        return f45056h == 1;
    }

    public static b m() {
        if (j == null) {
            synchronized (b.class) {
                if (j == null) {
                    j = new b();
                }
            }
        }
        return j;
    }

    public static void q(@NonNull Message message) {
        ArrayList<Integer> arrayList;
        if (j()) {
            b m = m();
            Object obj = message.obj;
            if (obj instanceof Bundle) {
                Bundle bundle = (Bundle) obj;
                bundle.setClassLoader(SwanTaskDeadEvent.class.getClassLoader());
                SwanTaskDeadEvent swanTaskDeadEvent = (SwanTaskDeadEvent) bundle.getParcelable("key_stack_info");
                if (swanTaskDeadEvent == null || TextUtils.isEmpty(swanTaskDeadEvent.a())) {
                    return;
                }
                if (ProcessUtils.isMainProcess() || ((arrayList = m.f45059c) != null && arrayList.contains(Integer.valueOf(swanTaskDeadEvent.e())))) {
                    m.f45060d.put(swanTaskDeadEvent.a().hashCode(), swanTaskDeadEvent.e());
                    m.f45061e.put(swanTaskDeadEvent.e(), swanTaskDeadEvent);
                }
            }
        }
    }

    public static void r(@NonNull Message message) {
        if (j()) {
            m().A((Bundle) message.obj);
        }
    }

    public final void A(@Nullable Bundle bundle) {
        if (bundle == null || this.f45059c == null) {
            return;
        }
        String string = bundle.getString(Constants.APP_ID);
        int i2 = bundle.getInt("key_task_id", -1);
        if (!TextUtils.isEmpty(string)) {
            int i3 = this.f45060d.get(string.hashCode(), -1);
            if (i3 > -1) {
                this.f45059c.remove(Integer.valueOf(i3));
                this.f45060d.delete(string.hashCode());
                this.f45061e.remove(i3);
                if (f45054f) {
                    Log.d("SwanActivityTaskManager", "removeTaskFromCache: " + string + ", oldTask=" + i3);
                }
            }
            this.f45059c.remove(Integer.valueOf(i2));
            return;
        }
        int i4 = bundle.getInt("key_task_id_old", -1);
        if (i4 == -1) {
            this.f45059c.remove(Integer.valueOf(i2));
        } else {
            int i5 = 0;
            while (true) {
                if (i5 >= this.f45059c.size()) {
                    break;
                } else if (this.f45059c.get(i5).intValue() == i4) {
                    this.f45059c.set(i5, Integer.valueOf(i2));
                    break;
                } else {
                    i5++;
                }
            }
            SwanTaskDeadEvent swanTaskDeadEvent = this.f45061e.get(i4);
            if (swanTaskDeadEvent != null) {
                if (swanTaskDeadEvent.a() != null) {
                    this.f45060d.delete(swanTaskDeadEvent.a().hashCode());
                }
                this.f45061e.remove(i4);
            }
        }
        if (f45054f) {
            Log.d("SwanActivityTaskManager", "removeTaskFromCache nowTask=" + i2 + ", old=" + i4 + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.f45059c);
        }
    }

    public final void h(@Nullable String str, int i2, int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt("key_task_id", i3);
        bundle.putInt("key_task_id_old", i2);
        bundle.putString(Constants.APP_ID, str);
        d.b.g0.a.n1.c.a e2 = d.b.g0.a.n1.c.a.e();
        d.b.g0.a.n1.c.c cVar = new d.b.g0.a.n1.c.c(com.baidu.android.imsdk.internal.Constants.METHOD_IM_FRIEND_GROUP_QUERY, bundle);
        cVar.f(true);
        e2.h(cVar);
    }

    public void i() {
        this.f45061e.clear();
        this.f45060d.clear();
    }

    public boolean l(int i2) {
        ActivityManager activityManager;
        if (j() && i && (activityManager = this.f45057a) != null) {
            int i3 = 0;
            for (ActivityManager.AppTask appTask : activityManager.getAppTasks()) {
                if (i3 > 0 && n(appTask) == i2) {
                    appTask.finishAndRemoveTask();
                    return true;
                }
                i3++;
            }
        }
        return false;
    }

    @RequiresApi(api = 21)
    public final int n(ActivityManager.AppTask appTask) {
        if (appTask != null) {
            try {
                ActivityManager.RecentTaskInfo taskInfo = appTask.getTaskInfo();
                if (taskInfo != null) {
                    return taskInfo.id;
                }
                return -1;
            } catch (Exception e2) {
                if (f45054f) {
                    Log.e("SwanActivityTaskManager", "getTaskId", e2);
                    return -1;
                }
                return -1;
            }
        }
        return -1;
    }

    @Nullable
    public final ArrayList<Integer> o() {
        ArrayList<Integer> arrayList = null;
        if (i) {
            ActivityManager activityManager = this.f45057a;
            if (activityManager != null) {
                List<ActivityManager.AppTask> appTasks = activityManager.getAppTasks();
                int size = appTasks.size();
                if (size < 2) {
                    return null;
                }
                arrayList = new ArrayList<>(size - 1);
                for (int i2 = 1; i2 < size; i2++) {
                    int n = n(appTasks.get(i2));
                    if (n != -1) {
                        arrayList.add(Integer.valueOf(n));
                    }
                }
            }
            return arrayList;
        }
        return null;
    }

    public int p() {
        ActivityManager activityManager;
        if (i && (activityManager = this.f45057a) != null) {
            try {
                return n(activityManager.getAppTasks().get(0));
            } catch (Exception e2) {
                if (f45054f) {
                    Log.e("SwanActivityTaskManager", "getTopTaskId", e2);
                }
            }
        }
        return -1;
    }

    public final boolean s(int i2, boolean z) {
        ActivityManager activityManager;
        if (i) {
            List<ActivityManager.AppTask> list = this.f45058b;
            if ((!z || list == null) && (activityManager = this.f45057a) != null) {
                list = activityManager.getAppTasks();
                if (z) {
                    this.f45058b = list;
                }
            }
            if (list != null) {
                for (ActivityManager.AppTask appTask : list) {
                    if (i2 == n(appTask)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public final boolean t(List<Integer> list, List<Integer> list2) {
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (!TextUtils.equals(String.valueOf(list.get(i2)), String.valueOf(list2.get(i2)))) {
                return false;
            }
        }
        return true;
    }

    @AnyThread
    public synchronized boolean u(int i2, boolean z, boolean z2) {
        if (i2 > -1) {
            if (this.f45057a != null) {
                if (s(i2, z)) {
                    if (f45054f) {
                        Log.i("SwanActivityTaskManager", "moveTaskToFront:" + i2);
                    }
                    try {
                        this.f45057a.moveTaskToFront(i2, 2, null);
                        return true;
                    } catch (Exception e2) {
                        d.b.g0.a.c0.c.c("SwanActivityTaskManager", "moveTaskToFront", e2);
                    }
                } else if (this.f45061e.indexOfKey(i2) >= 0) {
                    SwanTaskDeadEvent swanTaskDeadEvent = this.f45061e.get(i2);
                    if (swanTaskDeadEvent != null) {
                        c.a aVar = (c.a) ((c.a) ((c.a) new c.a().q0(swanTaskDeadEvent.a())).J0(swanTaskDeadEvent.c())).D0("1202000800000000");
                        Bundle bundle = new Bundle();
                        ArrayList<Integer> d2 = swanTaskDeadEvent.d();
                        if (d2 != null && !d2.isEmpty()) {
                            SparseArray<SwanTaskDeadEvent> sparseArray = new SparseArray<>();
                            Iterator<Integer> it = d2.iterator();
                            while (it.hasNext()) {
                                Integer next = it.next();
                                SwanTaskDeadEvent swanTaskDeadEvent2 = this.f45061e.get(next.intValue(), null);
                                if (swanTaskDeadEvent2 != null) {
                                    sparseArray.put(next.intValue(), swanTaskDeadEvent2);
                                }
                            }
                            swanTaskDeadEvent.g(sparseArray);
                        }
                        bundle.putParcelable("key_stack_info", swanTaskDeadEvent);
                        SwanLauncher.j().n(aVar, bundle);
                        if (f45054f) {
                            Log.i("SwanActivityTaskManager", "launch dead app:" + swanTaskDeadEvent.a());
                        }
                        return true;
                    }
                } else if (f45054f) {
                    Log.d("SwanActivityTaskManager", "Not Found taskId:" + i2 + " cacheSize:" + this.f45061e.size());
                }
                return false;
            }
        }
        return false;
    }

    public synchronized boolean v(boolean z) {
        ArrayList<Integer> arrayList = this.f45059c;
        if (z) {
            arrayList = o();
        }
        if (arrayList != null && !arrayList.isEmpty() && this.f45057a != null) {
            this.f45058b = null;
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                if (u(it.next().intValue(), true, true)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean w(@NonNull Context context, int i2, boolean z) {
        try {
            Intent intent = new Intent(context, SwanRelayActivity.class);
            intent.putExtra("key_task_id", i2);
            intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            PendingIntent.getActivity(context, 0, intent, 134217728).send();
            return true;
        } catch (Exception e2) {
            if (f45054f) {
                Log.e("SwanActivityTaskManager", "moveTaskToFrontByActivity", e2);
            }
            return u(i2, z, false);
        }
    }

    public void x(@Nullable SwanAppActivity swanAppActivity) {
        d.b.g0.a.e0.l.f swanAppFragmentManager;
        d.b.g0.a.e0.l.e eVar;
        d.b.g0.a.e1.c G1;
        if (!j() || swanAppActivity == null || (swanAppFragmentManager = swanAppActivity.getSwanAppFragmentManager()) == null || (eVar = (d.b.g0.a.e0.l.e) swanAppFragmentManager.n(d.b.g0.a.e0.l.e.class)) == null || (G1 = eVar.G1()) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        String activedAppId = swanAppActivity.getActivedAppId();
        int taskId = swanAppActivity.getTaskId();
        bundle.putParcelable("key_stack_info", new SwanTaskDeadEvent(activedAppId, taskId, G1.g() + "?" + G1.h(), this.f45059c));
        bundle.setClassLoader(SwanTaskDeadEvent.class.getClassLoader());
        d.b.g0.a.n1.c.a e2 = d.b.g0.a.n1.c.a.e();
        d.b.g0.a.n1.c.c cVar = new d.b.g0.a.n1.c.c(com.baidu.android.imsdk.internal.Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER, bundle);
        cVar.f(true);
        e2.h(cVar);
        if (f45054f) {
            Log.d("SwanActivityTaskManager", "notify dead " + swanAppActivity.getActivedAppId() + StringUtil.ARRAY_ELEMENT_SEPARATOR + swanAppActivity.getTaskId());
        }
    }

    public void y(@Nullable b.a aVar, int i2) {
        p.l(new a(aVar, i2), "getLaunchTask");
    }

    public void z(@Nullable Intent intent, int i2) {
        ArrayList<Integer> o = o();
        if (!t(this.f45059c, o)) {
            i();
            h(null, -1, i2);
        }
        if (f45054f) {
            int flags = intent != null ? intent.getFlags() : -1;
            Log.d("SwanActivityTaskManager", "onNewIntent: " + i2 + ", newTaskList=" + o + ", mLaunchTaskList=" + this.f45059c + ", flag=" + flags);
        }
        this.f45059c = o;
    }
}
