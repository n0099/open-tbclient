package com.repackage;

import android.app.Activity;
import android.app.ActivityManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public final class x8 {
    public static /* synthetic */ Interceptable $ic;
    public static ArrayList<SoftReference<Activity>> c;
    public static x8 d;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;
    public int b;

    /* loaded from: classes7.dex */
    public interface a {
        void onActivityClosed();
    }

    public x8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 0;
        if (c == null) {
            c = new ArrayList<>(20);
        }
    }

    public static x8 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (d == null) {
                d = new x8();
            }
            return d;
        }
        return (x8) invokeV.objValue;
    }

    public final void a(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || i == 0) {
            return;
        }
        int h = g().h();
        while (h > i) {
            h--;
            Activity l = g().l(1);
            if (l != null) {
                l.finish();
            }
        }
    }

    public Activity b() {
        InterceptResult invokeV;
        SoftReference<Activity> softReference;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int size = c.size();
            if (size == 0 || (softReference = c.get(size - 1)) == null) {
                return null;
            }
            return softReference.get();
        }
        return (Activity) invokeV.objValue;
    }

    public Activity c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (c.size() == 0) {
                return null;
            }
            Iterator<SoftReference<Activity>> it = c.iterator();
            while (it.hasNext()) {
                SoftReference<Activity> next = it.next();
                if (next != null && next.get() != null && next.get().getClass().getSimpleName() != null && next.get().getClass().getSimpleName().equals(str)) {
                    return next.get();
                }
            }
            return null;
        }
        return (Activity) invokeL.objValue;
    }

    public ArrayList<SoftReference<Activity>> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? c : (ArrayList) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ArrayList arrayList = new ArrayList();
            ArrayList<SoftReference<Activity>> arrayList2 = c;
            if (arrayList2 == null || arrayList2.size() == 0) {
                return "";
            }
            Iterator<SoftReference<Activity>> it = c.iterator();
            while (it.hasNext()) {
                SoftReference<Activity> next = it.next();
                if (next != null && (activity = next.get()) != null) {
                    arrayList.add(activity.getClass().getName());
                }
            }
            return TextUtils.join("_", arrayList);
        }
        return (String) invokeV.objValue;
    }

    public Activity f(int i) {
        InterceptResult invokeI;
        SoftReference<Activity> softReference;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            int size = c.size();
            if (size != 0 && i >= 0 && i < size && (softReference = c.get(i)) != null) {
                return softReference.get();
            }
            return null;
        }
        return (Activity) invokeI.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? c.size() : invokeV.intValue;
    }

    public boolean i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (c.size() == 0) {
                return false;
            }
            Iterator<SoftReference<Activity>> it = c.iterator();
            while (it.hasNext()) {
                SoftReference<Activity> next = it.next();
                if (next != null && next.get() != null && next.get().getClass().getSimpleName() != null && next.get().getClass().getSimpleName().equals(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int j(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity)) == null) {
            int size = c.size();
            if (size <= 0 || activity == null) {
                return -1;
            }
            for (int i = size - 1; i >= 0; i--) {
                SoftReference<Activity> softReference = c.get(i);
                if (softReference == null) {
                    c.remove(i);
                } else if (activity.equals(softReference.get())) {
                    return i;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public Activity k() {
        InterceptResult invokeV;
        SoftReference<Activity> remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int size = c.size();
            if (size == 0 || (remove = c.remove(size - 1)) == null) {
                return null;
            }
            return remove.get();
        }
        return (Activity) invokeV.objValue;
    }

    public Activity l(int i) {
        InterceptResult invokeI;
        SoftReference<Activity> remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            int size = c.size();
            if (size != 0 && i >= 0 && i < size && (remove = c.remove(i)) != null) {
                return remove.get();
            }
            return null;
        }
        return (Activity) invokeI.objValue;
    }

    public void m(Activity activity) {
        a aVar;
        a aVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, activity) == null) || activity == null) {
            return;
        }
        int size = c.size();
        if (size == 0) {
            a aVar3 = this.a;
            if (aVar3 != null) {
                aVar3.onActivityClosed();
                return;
            }
            return;
        }
        for (int i = size - 1; i >= 0; i--) {
            SoftReference<Activity> softReference = c.get(i);
            if (softReference == null) {
                c.remove(i);
            } else if (activity.equals(softReference.get())) {
                c.remove(i);
                if (c.size() != 0 || (aVar = this.a) == null) {
                    return;
                }
                aVar.onActivityClosed();
                return;
            } else if (c.size() == 0 && (aVar2 = this.a) != null) {
                aVar2.onActivityClosed();
            }
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            for (int i2 = 0; i2 < i; i2++) {
                Activity k = k();
                if (k != null) {
                    k.finish();
                }
            }
        }
    }

    public void o(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, activity) == null) || activity == null) {
            return;
        }
        c.add(new SoftReference<>(activity));
        a(this.b);
    }

    public void p() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (c != null) {
                while (!c.isEmpty()) {
                    SoftReference<Activity> remove = c.remove(0);
                    if (remove != null && remove.get() != null && (activity = remove.get()) != null) {
                        activity.finish();
                    }
                }
            }
            a aVar = this.a;
            if (aVar != null) {
                aVar.onActivityClosed();
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            a(3);
        }
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            if (i >= 10 || i == 0) {
                this.b = i;
            }
        }
    }

    public void s(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) {
            this.a = aVar;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        ActivityManager activityManager;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        String str;
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            ArrayList<SoftReference<Activity>> arrayList = c;
            if (arrayList != null && arrayList.size() != 0) {
                StringBuilder sb = new StringBuilder();
                Iterator<SoftReference<Activity>> it = c.iterator();
                while (it.hasNext()) {
                    SoftReference<Activity> next = it.next();
                    if (next != null && (activity = next.get()) != null) {
                        String simpleName = (activity == null || activity.getClass() == null) ? "" : activity.getClass().getSimpleName();
                        if (!StringUtils.isNull(simpleName)) {
                            sb.append(simpleName + ParamableElem.DIVIDE_PARAM);
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
                            sb2.append(str + ParamableElem.DIVIDE_PARAM);
                        }
                    }
                    return sb2.toString();
                }
            } catch (Exception unused) {
            }
            return "";
        }
        return (String) invokeV.objValue;
    }
}
