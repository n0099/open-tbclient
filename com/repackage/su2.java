package com.repackage;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AnyThread;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes7.dex */
public class su2 implements ml2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap<Integer, CopyOnWriteArrayList<View>> c;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final su2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1656029, "Lcom/repackage/su2$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1656029, "Lcom/repackage/su2$b;");
                    return;
                }
            }
            a = new su2(null);
        }
    }

    public /* synthetic */ su2(a aVar) {
        this();
    }

    public static su2 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (su2) invokeV.objValue;
    }

    @Nullable
    @UiThread
    public View b(@LayoutRes int i, @Nullable ViewGroup viewGroup, boolean z) {
        InterceptResult invokeCommon;
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), viewGroup, Boolean.valueOf(z)})) == null) {
            View d = d(i);
            if (d != null && viewGroup != null && (layoutParams = viewGroup.getLayoutParams()) != null) {
                ViewGroup.LayoutParams layoutParams2 = d.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(layoutParams);
                } else {
                    layoutParams2.width = layoutParams.width;
                    layoutParams2.height = layoutParams.height;
                }
                d.setLayoutParams(layoutParams2);
            }
            if (d == null) {
                long currentTimeMillis = System.currentTimeMillis();
                View inflate = LayoutInflater.from(pj2.c()).inflate(i, viewGroup, z);
                long currentTimeMillis2 = System.currentTimeMillis();
                if (ml2.a) {
                    Log.d("SwanPerformance", "getView resId = " + i + " ；inflate new view cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                }
                return inflate;
            }
            return d;
        }
        return (View) invokeCommon.objValue;
    }

    @AnyThread
    public void c(@LayoutRes int... iArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iArr) == null) || iArr == null || iArr.length == 0) {
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            int length = iArr.length;
            LayoutInflater from = LayoutInflater.from(pj2.c());
            for (int i : iArr) {
                View inflate = from.inflate(i, (ViewGroup) null);
                CopyOnWriteArrayList<View> copyOnWriteArrayList = this.c.get(Integer.valueOf(i));
                if (copyOnWriteArrayList == null) {
                    copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                }
                copyOnWriteArrayList.add(inflate);
                this.c.put(Integer.valueOf(i), copyOnWriteArrayList);
            }
            if (ml2.a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SwanPerformance", "inflateLayoutRes count = " + length + "; cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
        } catch (Exception e) {
            if (ml2.a) {
                Log.d("SwanPerformance", Log.getStackTraceString(e));
            }
        }
    }

    @Nullable
    @AnyThread
    public View d(@LayoutRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            View view2 = null;
            try {
                CopyOnWriteArrayList<View> copyOnWriteArrayList = this.c.get(Integer.valueOf(i));
                if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                    view2 = copyOnWriteArrayList.remove(0);
                }
            } catch (Exception e) {
                if (ml2.a) {
                    Log.d("SwanPerformance", Log.getStackTraceString(e));
                }
            }
            if (ml2.a) {
                StringBuilder sb = new StringBuilder();
                sb.append("tryObtainLayoutByResId resId = ");
                sb.append(i);
                sb.append(view2 == null ? " cache view is null" : " adopt cached view");
                Log.d("SwanPerformance", sb.toString());
            }
            return view2;
        }
        return (View) invokeI.objValue;
    }

    public su2() {
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
        this.c = new ConcurrentHashMap<>();
    }
}
