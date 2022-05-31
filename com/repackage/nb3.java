package com.repackage;

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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanRelayActivity;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.model.SwanTaskDeadEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ek2;
import com.repackage.fk2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class nb3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public static final boolean g;
    public static volatile nb3 h;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public ActivityManager a;
    public List<ActivityManager.AppTask> b;
    @Nullable
    public ArrayList<Integer> c;
    public final SparseIntArray d;
    public final SparseArray<SwanTaskDeadEvent> e;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ek2.a a;
        public final /* synthetic */ int b;
        public final /* synthetic */ nb3 c;

        public a(nb3 nb3Var, ek2.a aVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nb3Var, aVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = nb3Var;
            this.a = aVar;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.i();
                ek2.a aVar = this.a;
                if (aVar != null && "1202000800000000".equals(aVar.T())) {
                    SwanTaskDeadEvent swanTaskDeadEvent = (SwanTaskDeadEvent) this.a.m("key_stack_info");
                    if (swanTaskDeadEvent != null) {
                        this.c.c = swanTaskDeadEvent.getStackList();
                        SparseArray<SwanTaskDeadEvent> historyCache = swanTaskDeadEvent.getHistoryCache();
                        if (historyCache != null) {
                            for (int i = 0; i < historyCache.size(); i++) {
                                int keyAt = historyCache.keyAt(i);
                                SwanTaskDeadEvent valueAt = historyCache.valueAt(i);
                                if (valueAt != null && valueAt.getAppId() != null) {
                                    this.c.e.put(keyAt, valueAt);
                                    this.c.d.put(valueAt.getAppId().hashCode(), keyAt);
                                }
                            }
                        }
                        this.c.h(null, swanTaskDeadEvent.getTaskId(), this.b);
                    }
                    if (nb3.f) {
                        Log.d("SwanActivityTaskManager", "stack back: " + this.c.c);
                        return;
                    }
                    return;
                }
                ek2.a aVar2 = this.a;
                if (aVar2 != null) {
                    this.c.h(aVar2.H(), -1, this.b);
                }
                nb3 nb3Var = this.c;
                nb3Var.c = nb3Var.o();
                if (nb3.f) {
                    Log.d("SwanActivityTaskManager", "getLaunchTask=" + this.c.c);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755475310, "Lcom/repackage/nb3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755475310, "Lcom/repackage/nb3;");
                return;
            }
        }
        f = rf1.a;
        g = ob3.f();
    }

    public nb3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = new SparseIntArray();
        this.e = new SparseArray<>();
        Application c = oi2.c();
        if (c != null) {
            this.a = (ActivityManager) c.getSystemService("activity");
        }
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public static nb3 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (h == null) {
                synchronized (nb3.class) {
                    if (h == null) {
                        h = new nb3();
                    }
                }
            }
            return h;
        }
        return (nb3) invokeV.objValue;
    }

    public static void q(@NonNull Message message) {
        ArrayList<Integer> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65548, null, message) == null) && j()) {
            nb3 m = m();
            Object obj = message.obj;
            if (obj instanceof Bundle) {
                Bundle bundle = (Bundle) obj;
                bundle.setClassLoader(SwanTaskDeadEvent.class.getClassLoader());
                SwanTaskDeadEvent swanTaskDeadEvent = (SwanTaskDeadEvent) bundle.getParcelable("key_stack_info");
                if (swanTaskDeadEvent == null || TextUtils.isEmpty(swanTaskDeadEvent.getAppId())) {
                    return;
                }
                if (ProcessUtils.isMainProcess() || ((arrayList = m.c) != null && arrayList.contains(Integer.valueOf(swanTaskDeadEvent.getTaskId())))) {
                    m.d.put(swanTaskDeadEvent.getAppId().hashCode(), swanTaskDeadEvent.getTaskId());
                    m.e.put(swanTaskDeadEvent.getTaskId(), swanTaskDeadEvent);
                }
            }
        }
    }

    public static void r(@NonNull Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65549, null, message) == null) && j()) {
            m().A((Bundle) message.obj);
        }
    }

    public final void A(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) || bundle == null || this.c == null) {
            return;
        }
        String string = bundle.getString("app_id");
        int i = bundle.getInt("key_task_id", -1);
        if (!TextUtils.isEmpty(string)) {
            int i2 = this.d.get(string.hashCode(), -1);
            if (i2 > -1) {
                this.c.remove(Integer.valueOf(i2));
                this.d.delete(string.hashCode());
                this.e.remove(i2);
                if (f) {
                    Log.d("SwanActivityTaskManager", "removeTaskFromCache: " + string + ", oldTask=" + i2);
                }
            }
            this.c.remove(Integer.valueOf(i));
            return;
        }
        int i3 = bundle.getInt("key_task_id_old", -1);
        if (i3 == -1) {
            this.c.remove(Integer.valueOf(i));
        } else {
            int i4 = 0;
            while (true) {
                if (i4 >= this.c.size()) {
                    break;
                } else if (this.c.get(i4).intValue() == i3) {
                    this.c.set(i4, Integer.valueOf(i));
                    break;
                } else {
                    i4++;
                }
            }
            SwanTaskDeadEvent swanTaskDeadEvent = this.e.get(i3);
            if (swanTaskDeadEvent != null) {
                if (swanTaskDeadEvent.getAppId() != null) {
                    this.d.delete(swanTaskDeadEvent.getAppId().hashCode());
                }
                this.e.remove(i3);
            }
        }
        if (f) {
            Log.d("SwanActivityTaskManager", "removeTaskFromCache nowTask=" + i + ", old=" + i3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.c);
        }
    }

    public final void h(@Nullable String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i, i2) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("key_task_id", i2);
            bundle.putInt("key_task_id_old", i);
            bundle.putString("app_id", str);
            xv2 e = xv2.e();
            zv2 zv2Var = new zv2(123, bundle);
            zv2Var.f(true);
            e.h(zv2Var);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.e.clear();
            this.d.clear();
        }
    }

    public boolean l(int i) {
        InterceptResult invokeI;
        ActivityManager activityManager;
        List<ActivityManager.AppTask> appTasks;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (j() && g && (activityManager = this.a) != null && (appTasks = activityManager.getAppTasks()) != null) {
                int i2 = 0;
                for (ActivityManager.AppTask appTask : appTasks) {
                    if (i2 > 0 && n(appTask) == i) {
                        appTask.finishAndRemoveTask();
                        return true;
                    }
                    i2++;
                }
                return false;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @RequiresApi(api = 21)
    public final int n(ActivityManager.AppTask appTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, appTask)) == null) {
            if (appTask != null) {
                try {
                    ActivityManager.RecentTaskInfo taskInfo = appTask.getTaskInfo();
                    if (taskInfo != null) {
                        return taskInfo.id;
                    }
                    return -1;
                } catch (Exception e) {
                    if (f) {
                        Log.e("SwanActivityTaskManager", "getTaskId", e);
                        return -1;
                    }
                    return -1;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    @Nullable
    public final ArrayList<Integer> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList<Integer> arrayList = null;
            if (g) {
                ActivityManager activityManager = this.a;
                if (activityManager != null) {
                    List<ActivityManager.AppTask> appTasks = activityManager.getAppTasks();
                    int size = appTasks.size();
                    if (size < 2) {
                        return null;
                    }
                    arrayList = new ArrayList<>(size - 1);
                    for (int i = 1; i < size; i++) {
                        int n = n(appTasks.get(i));
                        if (n != -1) {
                            arrayList.add(Integer.valueOf(n));
                        }
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int p() {
        InterceptResult invokeV;
        ActivityManager activityManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (g && (activityManager = this.a) != null) {
                try {
                    return n(activityManager.getAppTasks().get(0));
                } catch (Exception e) {
                    if (f) {
                        Log.e("SwanActivityTaskManager", "getTopTaskId", e);
                    }
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final boolean s(int i, boolean z) {
        InterceptResult invokeCommon;
        ActivityManager activityManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (g) {
                List<ActivityManager.AppTask> list = this.b;
                if ((!z || list == null) && (activityManager = this.a) != null) {
                    list = activityManager.getAppTasks();
                    if (z) {
                        this.b = list;
                    }
                }
                if (list != null) {
                    for (ActivityManager.AppTask appTask : list) {
                        if (i == n(appTask)) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean t(List<Integer> list, List<Integer> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, list2)) == null) {
            if (list == null || list2 == null || list.size() != list2.size()) {
                return false;
            }
            for (int i = 0; i < list.size(); i++) {
                if (!TextUtils.equals(String.valueOf(list.get(i)), String.valueOf(list2.get(i)))) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @AnyThread
    public synchronized boolean u(int i, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            synchronized (this) {
                if (i > -1) {
                    if (this.a != null) {
                        if (s(i, z)) {
                            if (f) {
                                Log.i("SwanActivityTaskManager", "moveTaskToFront:" + i);
                            }
                            try {
                                this.a.moveTaskToFront(i, 2, null);
                                return true;
                            } catch (Exception e) {
                                hw1.d("SwanActivityTaskManager", "moveTaskToFront", e);
                            }
                        } else if (this.e.indexOfKey(i) >= 0) {
                            SwanTaskDeadEvent swanTaskDeadEvent = this.e.get(i);
                            if (swanTaskDeadEvent != null) {
                                fk2.a aVar = (fk2.a) ((fk2.a) ((fk2.a) new fk2.a().v0(swanTaskDeadEvent.getAppId())).R0(swanTaskDeadEvent.getPageScheme())).I0("1202000800000000");
                                Bundle bundle = new Bundle();
                                ArrayList<Integer> stackList = swanTaskDeadEvent.getStackList();
                                if (stackList != null && !stackList.isEmpty()) {
                                    SparseArray<SwanTaskDeadEvent> sparseArray = new SparseArray<>();
                                    Iterator<Integer> it = stackList.iterator();
                                    while (it.hasNext()) {
                                        Integer next = it.next();
                                        SwanTaskDeadEvent swanTaskDeadEvent2 = this.e.get(next.intValue(), null);
                                        if (swanTaskDeadEvent2 != null) {
                                            sparseArray.put(next.intValue(), swanTaskDeadEvent2);
                                        }
                                    }
                                    swanTaskDeadEvent.setHistoryCache(sparseArray);
                                }
                                bundle.putParcelable("key_stack_info", swanTaskDeadEvent);
                                SwanLauncher.j().n(aVar, bundle);
                                if (f) {
                                    Log.i("SwanActivityTaskManager", "launch dead app:" + swanTaskDeadEvent.getAppId());
                                }
                                return true;
                            }
                        } else if (f) {
                            Log.d("SwanActivityTaskManager", "Not Found taskId:" + i + " cacheSize:" + this.e.size());
                        }
                        return false;
                    }
                }
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public synchronized boolean v(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
            synchronized (this) {
                ArrayList<Integer> arrayList = this.c;
                if (z) {
                    arrayList = o();
                }
                if (arrayList != null && !arrayList.isEmpty() && this.a != null) {
                    this.b = null;
                    Iterator<Integer> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (u(it.next().intValue(), true, true)) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        return invokeZ.booleanValue;
    }

    public boolean w(@NonNull Context context, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{context, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            try {
                Intent intent = new Intent(context, SwanRelayActivity.class);
                intent.putExtra("key_task_id", i);
                intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                PendingIntent.getActivity(context, 0, intent, 134217728).send();
                return true;
            } catch (Exception e) {
                if (f) {
                    Log.e("SwanActivityTaskManager", "moveTaskToFrontByActivity", e);
                }
                return u(i, z, false);
            }
        }
        return invokeCommon.booleanValue;
    }

    public void x(@Nullable SwanAppActivity swanAppActivity) {
        qy1 swanAppFragmentManager;
        py1 py1Var;
        ip2 M1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, swanAppActivity) == null) || !j() || swanAppActivity == null || (swanAppFragmentManager = swanAppActivity.getSwanAppFragmentManager()) == null || (py1Var = (py1) swanAppFragmentManager.n(py1.class)) == null || (M1 = py1Var.M1()) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        String activedAppId = swanAppActivity.getActivedAppId();
        int taskId = swanAppActivity.getTaskId();
        bundle.putParcelable("key_stack_info", new SwanTaskDeadEvent(activedAppId, taskId, M1.i() + "?" + M1.j(), this.c));
        bundle.setClassLoader(SwanTaskDeadEvent.class.getClassLoader());
        xv2 e = xv2.e();
        zv2 zv2Var = new zv2(124, bundle);
        zv2Var.f(true);
        e.h(zv2Var);
        if (f) {
            Log.d("SwanActivityTaskManager", "notify dead " + swanAppActivity.getActivedAppId() + StringUtil.ARRAY_ELEMENT_SEPARATOR + swanAppActivity.getTaskId());
        }
    }

    public void y(@Nullable ek2.a aVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, aVar, i) == null) {
            bc3.l(new a(this, aVar, i), "getLaunchTask");
        }
    }

    public void z(@Nullable Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, intent, i) == null) {
            ArrayList<Integer> o = o();
            if (!t(this.c, o)) {
                i();
                h(null, -1, i);
            }
            if (f) {
                int flags = intent != null ? intent.getFlags() : -1;
                Log.d("SwanActivityTaskManager", "onNewIntent: " + i + ", newTaskList=" + o + ", mLaunchTaskList=" + this.c + ", flag=" + flags);
            }
            this.c = o;
        }
    }
}
