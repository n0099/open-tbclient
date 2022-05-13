package com.repackage;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.mutiprocess.StickyEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes5.dex */
public class e65 {
    public static /* synthetic */ Interceptable $ic;
    public static e65 h;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public final Map<Class<? extends x55>, y55> b;
    public final Map<Class<? extends x55>, LinkedList<f65>> c;
    public final Handler d;
    public a65 e;
    public final z55 f;
    public final wm4 g;

    /* loaded from: classes5.dex */
    public class a implements z55 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e65 a;

        public a(e65 e65Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e65Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e65Var;
        }

        @Override // com.repackage.z55
        public void a(x55 x55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, x55Var) == null) {
                this.a.d(x55Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x55 a;
        public final /* synthetic */ e65 b;

        public b(e65 e65Var, x55 x55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e65Var, x55Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = e65Var;
            this.a = x55Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.c(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends wm4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e65 a;

        public c(e65 e65Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e65Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e65Var;
        }

        @Override // com.repackage.wm4, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, activity) == null) && (activity instanceof TbPageContextSupport)) {
                this.a.n(((TbPageContextSupport) activity).getPageContext().getUniqueId());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755785651, "Lcom/repackage/e65;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755785651, "Lcom/repackage/e65;");
        }
    }

    public e65() {
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
        this.a = false;
        this.d = new Handler(Looper.getMainLooper());
        this.f = new a(this);
        this.g = new c(this);
        this.b = new HashMap();
        this.c = new HashMap();
    }

    public static e65 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (h == null) {
                synchronized (e65.class) {
                    if (h == null) {
                        h = new e65();
                    }
                }
            }
            return h;
        }
        return (e65) invokeV.objValue;
    }

    public static void i(@NonNull x55 x55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, x55Var) == null) {
            f().h(x55Var);
        }
    }

    public final void c(x55 x55Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, x55Var) == null) || x55Var == null) {
            return;
        }
        Class<?> cls = x55Var.getClass();
        try {
            y55 y55Var = this.b.get(cls);
            if (y55Var != null) {
                y55Var.onEvent(x55Var);
            }
        } catch (Exception e) {
            BdLog.detailException(cls.getName(), e);
        }
        try {
            LinkedList<f65> linkedList = this.c.get(cls);
            if (ListUtils.isEmpty(linkedList)) {
                return;
            }
            int myPid = Process.myPid();
            for (f65 f65Var : linkedList) {
                if (f65Var != null && (!f65Var.isSelfListener() || (x55Var.getPid() == myPid && f65Var.getTag() != null && f65Var.getTag().getId() == x55Var.getTag()))) {
                    try {
                        f65Var.onEvent(x55Var);
                    } catch (Exception e2) {
                        BdLog.detailException(cls.getName(), e2);
                    }
                }
            }
        } catch (Exception e3) {
            BdLog.detailException(cls.getName(), e3);
        }
    }

    public final void d(x55 x55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x55Var) == null) {
            if (mi.B()) {
                c(x55Var);
            } else {
                this.d.post(new b(this, x55Var));
            }
        }
    }

    public final void e(@NonNull Class<? extends x55> cls, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cls, bdUniqueId) == null) && StickyEvent.class.isAssignableFrom(cls)) {
            OrmObject c2 = d65.c(cls.getSimpleName(), cls);
            if (c2 instanceof StickyEvent) {
                StickyEvent stickyEvent = (StickyEvent) c2;
                stickyEvent.resetPid();
                stickyEvent.setTag(bdUniqueId);
                stickyEvent.setType(2);
                i(stickyEvent);
            }
        }
    }

    public void g(@NonNull Application application) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, application) == null) || this.a) {
            return;
        }
        c65.g();
        k(application);
        b65 b65Var = new b65(application);
        this.e = b65Var;
        b65Var.b(this.f);
        this.e.startService();
        this.a = true;
    }

    public void h(@NonNull x55 x55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, x55Var) == null) {
            if (!c65.i()) {
                String c2 = c65.c();
                c65.m(c2 + " Process Not In WhiteList，Ignore Event!");
                return;
            }
            int myPid = Process.myPid();
            int pid = x55Var.getPid();
            if (x55Var.getType() == 2 && myPid == pid) {
                d(x55Var);
            } else {
                j(x55Var);
            }
        }
    }

    public final void j(x55 x55Var) {
        a65 a65Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, x55Var) == null) || (a65Var = this.e) == null) {
            return;
        }
        a65Var.a(x55Var);
    }

    public final void k(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, application) == null) {
            try {
                application.registerActivityLifecycleCallbacks(this.g);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void l(@NonNull Class<? extends x55> cls, @NonNull y55 y55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, cls, y55Var) == null) {
            if (this.b.containsKey(cls)) {
                BdLog.e(cls + " has existed, Please unRegister old listener first！");
                return;
            }
            this.b.put(cls, y55Var);
        }
    }

    public void m(@NonNull Class<? extends x55> cls, @NonNull f65 f65Var, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cls, f65Var, bdUniqueId) == null) {
            LinkedList<f65> linkedList = this.c.get(cls);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.c.put(cls, linkedList);
            }
            if (linkedList.contains(f65Var)) {
                BdLog.e("listener has existed, Please unRegister old listener first！");
                return;
            }
            f65Var.setTag(bdUniqueId);
            FrameHelper.insert(linkedList, f65Var);
            e(cls, bdUniqueId);
        }
    }

    public void n(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        for (Map.Entry<Class<? extends x55>, LinkedList<f65>> entry : this.c.entrySet()) {
            LinkedList<f65> value = entry.getValue();
            if (!ListUtils.isEmpty(value)) {
                Iterator<f65> it = value.iterator();
                while (it.hasNext()) {
                    f65 next = it.next();
                    if (next != null && next.getTag() != null && next.getTag() == bdUniqueId) {
                        it.remove();
                    }
                }
            }
        }
    }
}
