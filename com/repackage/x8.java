package com.repackage;

import android.app.Activity;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
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

    public static x8 f() {
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
        int g = f().g();
        while (g > i) {
            g--;
            Activity k = f().k(1);
            if (k != null) {
                k.finish();
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

    public String d() {
        InterceptResult invokeV;
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
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

    public Activity e(int i) {
        InterceptResult invokeI;
        SoftReference<Activity> softReference;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            int size = c.size();
            if (size != 0 && i >= 0 && i < size && (softReference = c.get(i)) != null) {
                return softReference.get();
            }
            return null;
        }
        return (Activity) invokeI.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? c.size() : invokeV.intValue;
    }

    public boolean h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
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

    public int i(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, activity)) == null) {
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

    public Activity j() {
        InterceptResult invokeV;
        SoftReference<Activity> remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int size = c.size();
            if (size == 0 || (remove = c.remove(size - 1)) == null) {
                return null;
            }
            return remove.get();
        }
        return (Activity) invokeV.objValue;
    }

    public Activity k(int i) {
        InterceptResult invokeI;
        SoftReference<Activity> remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            int size = c.size();
            if (size != 0 && i >= 0 && i < size && (remove = c.remove(i)) != null) {
                return remove.get();
            }
            return null;
        }
        return (Activity) invokeI.objValue;
    }

    public void l(Activity activity) {
        a aVar;
        a aVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, activity) == null) || activity == null) {
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

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            for (int i2 = 0; i2 < i; i2++) {
                Activity j = j();
                if (j != null) {
                    j.finish();
                }
            }
        }
    }

    public void n(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, activity) == null) || activity == null) {
            return;
        }
        c.add(new SoftReference<>(activity));
        a(this.b);
    }

    public void o() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
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

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            a(3);
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            if (i >= 10 || i == 0) {
                this.b = i;
            }
        }
    }

    public void r(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) {
            this.a = aVar;
        }
    }
}
