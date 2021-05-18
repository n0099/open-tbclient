package d.a.i0.a.v2;

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
import d.a.i0.a.f1.e.b;
import d.a.i0.a.f1.e.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f45186f = d.a.i0.a.k.f43025a;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f45187g = d.f();

    /* renamed from: h  reason: collision with root package name */
    public static volatile c f45188h;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public ActivityManager f45189a;

    /* renamed from: b  reason: collision with root package name */
    public List<ActivityManager.AppTask> f45190b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<Integer> f45191c;

    /* renamed from: d  reason: collision with root package name */
    public final SparseIntArray f45192d = new SparseIntArray();

    /* renamed from: e  reason: collision with root package name */
    public final SparseArray<SwanTaskDeadEvent> f45193e = new SparseArray<>();

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a f45194e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f45195f;

        public a(b.a aVar, int i2) {
            this.f45194e = aVar;
            this.f45195f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.i();
            b.a aVar = this.f45194e;
            if (aVar != null && "1202000800000000".equals(aVar.T())) {
                SwanTaskDeadEvent swanTaskDeadEvent = (SwanTaskDeadEvent) this.f45194e.m("key_stack_info");
                if (swanTaskDeadEvent != null) {
                    c.this.f45191c = swanTaskDeadEvent.d();
                    SparseArray<SwanTaskDeadEvent> b2 = swanTaskDeadEvent.b();
                    if (b2 != null) {
                        for (int i2 = 0; i2 < b2.size(); i2++) {
                            int keyAt = b2.keyAt(i2);
                            SwanTaskDeadEvent valueAt = b2.valueAt(i2);
                            if (valueAt != null && valueAt.a() != null) {
                                c.this.f45193e.put(keyAt, valueAt);
                                c.this.f45192d.put(valueAt.a().hashCode(), keyAt);
                            }
                        }
                    }
                    c.this.h(null, swanTaskDeadEvent.e(), this.f45195f);
                }
                if (c.f45186f) {
                    Log.d("SwanActivityTaskManager", "stack back: " + c.this.f45191c);
                    return;
                }
                return;
            }
            b.a aVar2 = this.f45194e;
            if (aVar2 != null) {
                c.this.h(aVar2.H(), -1, this.f45195f);
            }
            c cVar = c.this;
            cVar.f45191c = cVar.o();
            if (c.f45186f) {
                Log.d("SwanActivityTaskManager", "getLaunchTask=" + c.this.f45191c);
            }
        }
    }

    public c() {
        Application b2 = d.a.i0.a.c1.a.b();
        if (b2 != null) {
            this.f45189a = (ActivityManager) b2.getSystemService("activity");
        }
    }

    public static boolean j() {
        return true;
    }

    public static boolean k() {
        return true;
    }

    public static c m() {
        if (f45188h == null) {
            synchronized (c.class) {
                if (f45188h == null) {
                    f45188h = new c();
                }
            }
        }
        return f45188h;
    }

    public static void q(@NonNull Message message) {
        ArrayList<Integer> arrayList;
        if (j()) {
            c m = m();
            Object obj = message.obj;
            if (obj instanceof Bundle) {
                Bundle bundle = (Bundle) obj;
                bundle.setClassLoader(SwanTaskDeadEvent.class.getClassLoader());
                SwanTaskDeadEvent swanTaskDeadEvent = (SwanTaskDeadEvent) bundle.getParcelable("key_stack_info");
                if (swanTaskDeadEvent == null || TextUtils.isEmpty(swanTaskDeadEvent.a())) {
                    return;
                }
                if (ProcessUtils.isMainProcess() || ((arrayList = m.f45191c) != null && arrayList.contains(Integer.valueOf(swanTaskDeadEvent.e())))) {
                    m.f45192d.put(swanTaskDeadEvent.a().hashCode(), swanTaskDeadEvent.e());
                    m.f45193e.put(swanTaskDeadEvent.e(), swanTaskDeadEvent);
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
        if (bundle == null || this.f45191c == null) {
            return;
        }
        String string = bundle.getString(Constants.APP_ID);
        int i2 = bundle.getInt("key_task_id", -1);
        if (!TextUtils.isEmpty(string)) {
            int i3 = this.f45192d.get(string.hashCode(), -1);
            if (i3 > -1) {
                this.f45191c.remove(Integer.valueOf(i3));
                this.f45192d.delete(string.hashCode());
                this.f45193e.remove(i3);
                if (f45186f) {
                    Log.d("SwanActivityTaskManager", "removeTaskFromCache: " + string + ", oldTask=" + i3);
                }
            }
            this.f45191c.remove(Integer.valueOf(i2));
            return;
        }
        int i4 = bundle.getInt("key_task_id_old", -1);
        if (i4 == -1) {
            this.f45191c.remove(Integer.valueOf(i2));
        } else {
            int i5 = 0;
            while (true) {
                if (i5 >= this.f45191c.size()) {
                    break;
                } else if (this.f45191c.get(i5).intValue() == i4) {
                    this.f45191c.set(i5, Integer.valueOf(i2));
                    break;
                } else {
                    i5++;
                }
            }
            SwanTaskDeadEvent swanTaskDeadEvent = this.f45193e.get(i4);
            if (swanTaskDeadEvent != null) {
                if (swanTaskDeadEvent.a() != null) {
                    this.f45192d.delete(swanTaskDeadEvent.a().hashCode());
                }
                this.f45193e.remove(i4);
            }
        }
        if (f45186f) {
            Log.d("SwanActivityTaskManager", "removeTaskFromCache nowTask=" + i2 + ", old=" + i4 + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.f45191c);
        }
    }

    public final void h(@Nullable String str, int i2, int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt("key_task_id", i3);
        bundle.putInt("key_task_id_old", i2);
        bundle.putString(Constants.APP_ID, str);
        d.a.i0.a.v1.c.a e2 = d.a.i0.a.v1.c.a.e();
        d.a.i0.a.v1.c.c cVar = new d.a.i0.a.v1.c.c(123, bundle);
        cVar.f(true);
        e2.h(cVar);
    }

    public void i() {
        this.f45193e.clear();
        this.f45192d.clear();
    }

    public boolean l(int i2) {
        ActivityManager activityManager;
        List<ActivityManager.AppTask> appTasks;
        if (j() && f45187g && (activityManager = this.f45189a) != null && (appTasks = activityManager.getAppTasks()) != null) {
            int i3 = 0;
            for (ActivityManager.AppTask appTask : appTasks) {
                if (i3 > 0 && n(appTask) == i2) {
                    appTask.finishAndRemoveTask();
                    return true;
                }
                i3++;
            }
            return false;
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
                if (f45186f) {
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
        if (f45187g) {
            ActivityManager activityManager = this.f45189a;
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
        if (f45187g && (activityManager = this.f45189a) != null) {
            try {
                return n(activityManager.getAppTasks().get(0));
            } catch (Exception e2) {
                if (f45186f) {
                    Log.e("SwanActivityTaskManager", "getTopTaskId", e2);
                }
            }
        }
        return -1;
    }

    public final boolean s(int i2, boolean z) {
        ActivityManager activityManager;
        if (f45187g) {
            List<ActivityManager.AppTask> list = this.f45190b;
            if ((!z || list == null) && (activityManager = this.f45189a) != null) {
                list = activityManager.getAppTasks();
                if (z) {
                    this.f45190b = list;
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
            if (this.f45189a != null) {
                if (s(i2, z)) {
                    if (f45186f) {
                        Log.i("SwanActivityTaskManager", "moveTaskToFront:" + i2);
                    }
                    try {
                        this.f45189a.moveTaskToFront(i2, 2, null);
                        return true;
                    } catch (Exception e2) {
                        d.a.i0.a.e0.d.c("SwanActivityTaskManager", "moveTaskToFront", e2);
                    }
                } else if (this.f45193e.indexOfKey(i2) >= 0) {
                    SwanTaskDeadEvent swanTaskDeadEvent = this.f45193e.get(i2);
                    if (swanTaskDeadEvent != null) {
                        c.a aVar = (c.a) ((c.a) ((c.a) new c.a().u0(swanTaskDeadEvent.a())).Q0(swanTaskDeadEvent.c())).H0("1202000800000000");
                        Bundle bundle = new Bundle();
                        ArrayList<Integer> d2 = swanTaskDeadEvent.d();
                        if (d2 != null && !d2.isEmpty()) {
                            SparseArray<SwanTaskDeadEvent> sparseArray = new SparseArray<>();
                            Iterator<Integer> it = d2.iterator();
                            while (it.hasNext()) {
                                Integer next = it.next();
                                SwanTaskDeadEvent swanTaskDeadEvent2 = this.f45193e.get(next.intValue(), null);
                                if (swanTaskDeadEvent2 != null) {
                                    sparseArray.put(next.intValue(), swanTaskDeadEvent2);
                                }
                            }
                            swanTaskDeadEvent.g(sparseArray);
                        }
                        bundle.putParcelable("key_stack_info", swanTaskDeadEvent);
                        SwanLauncher.j().n(aVar, bundle);
                        if (f45186f) {
                            Log.i("SwanActivityTaskManager", "launch dead app:" + swanTaskDeadEvent.a());
                        }
                        return true;
                    }
                } else if (f45186f) {
                    Log.d("SwanActivityTaskManager", "Not Found taskId:" + i2 + " cacheSize:" + this.f45193e.size());
                }
                return false;
            }
        }
        return false;
    }

    public synchronized boolean v(boolean z) {
        ArrayList<Integer> arrayList = this.f45191c;
        if (z) {
            arrayList = o();
        }
        if (arrayList != null && !arrayList.isEmpty() && this.f45189a != null) {
            this.f45190b = null;
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
            if (f45186f) {
                Log.e("SwanActivityTaskManager", "moveTaskToFrontByActivity", e2);
            }
            return u(i2, z, false);
        }
    }

    public void x(@Nullable SwanAppActivity swanAppActivity) {
        d.a.i0.a.h0.g.g swanAppFragmentManager;
        d.a.i0.a.h0.g.f fVar;
        d.a.i0.a.l1.c K1;
        if (!j() || swanAppActivity == null || (swanAppFragmentManager = swanAppActivity.getSwanAppFragmentManager()) == null || (fVar = (d.a.i0.a.h0.g.f) swanAppFragmentManager.n(d.a.i0.a.h0.g.f.class)) == null || (K1 = fVar.K1()) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        String activedAppId = swanAppActivity.getActivedAppId();
        int taskId = swanAppActivity.getTaskId();
        bundle.putParcelable("key_stack_info", new SwanTaskDeadEvent(activedAppId, taskId, K1.g() + "?" + K1.h(), this.f45191c));
        bundle.setClassLoader(SwanTaskDeadEvent.class.getClassLoader());
        d.a.i0.a.v1.c.a e2 = d.a.i0.a.v1.c.a.e();
        d.a.i0.a.v1.c.c cVar = new d.a.i0.a.v1.c.c(124, bundle);
        cVar.f(true);
        e2.h(cVar);
        if (f45186f) {
            Log.d("SwanActivityTaskManager", "notify dead " + swanAppActivity.getActivedAppId() + StringUtil.ARRAY_ELEMENT_SEPARATOR + swanAppActivity.getTaskId());
        }
    }

    public void y(@Nullable b.a aVar, int i2) {
        q.k(new a(aVar, i2), "getLaunchTask");
    }

    public void z(@Nullable Intent intent, int i2) {
        ArrayList<Integer> o = o();
        if (!t(this.f45191c, o)) {
            i();
            h(null, -1, i2);
        }
        if (f45186f) {
            int flags = intent != null ? intent.getFlags() : -1;
            Log.d("SwanActivityTaskManager", "onNewIntent: " + i2 + ", newTaskList=" + o + ", mLaunchTaskList=" + this.f45191c + ", flag=" + flags);
        }
        this.f45191c = o;
    }
}
