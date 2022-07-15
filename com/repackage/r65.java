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
/* loaded from: classes7.dex */
public class r65 {
    public static /* synthetic */ Interceptable $ic;
    public static r65 h;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public final Map<Class<? extends k65>, l65> b;
    public final Map<Class<? extends k65>, LinkedList<s65>> c;
    public final Handler d;
    public n65 e;
    public final m65 f;
    public final km4 g;

    /* loaded from: classes7.dex */
    public class a implements m65 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r65 a;

        public a(r65 r65Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r65Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r65Var;
        }

        @Override // com.repackage.m65
        public void a(k65 k65Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, k65Var) == null) {
                this.a.d(k65Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k65 a;
        public final /* synthetic */ r65 b;

        public b(r65 r65Var, k65 k65Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r65Var, k65Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r65Var;
            this.a = k65Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.c(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends km4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r65 a;

        public c(r65 r65Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r65Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r65Var;
        }

        @Override // com.repackage.km4, android.app.Application.ActivityLifecycleCallbacks
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755398368, "Lcom/repackage/r65;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755398368, "Lcom/repackage/r65;");
        }
    }

    public r65() {
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

    public static r65 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (h == null) {
                synchronized (r65.class) {
                    if (h == null) {
                        h = new r65();
                    }
                }
            }
            return h;
        }
        return (r65) invokeV.objValue;
    }

    public static void i(@NonNull k65 k65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, k65Var) == null) {
            f().h(k65Var);
        }
    }

    public final void c(k65 k65Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, k65Var) == null) || k65Var == null) {
            return;
        }
        Class<?> cls = k65Var.getClass();
        try {
            l65 l65Var = this.b.get(cls);
            if (l65Var != null) {
                l65Var.onEvent(k65Var);
            }
        } catch (Exception e) {
            BdLog.detailException(cls.getName(), e);
        }
        try {
            LinkedList<s65> linkedList = this.c.get(cls);
            if (ListUtils.isEmpty(linkedList)) {
                return;
            }
            int myPid = Process.myPid();
            for (s65 s65Var : linkedList) {
                if (s65Var != null && (!s65Var.isSelfListener() || (k65Var.getPid() == myPid && s65Var.getTag() != null && s65Var.getTag().getId() == k65Var.getTag()))) {
                    try {
                        s65Var.onEvent(k65Var);
                    } catch (Exception e2) {
                        BdLog.detailException(cls.getName(), e2);
                    }
                }
            }
        } catch (Exception e3) {
            BdLog.detailException(cls.getName(), e3);
        }
    }

    public final void d(k65 k65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k65Var) == null) {
            if (pi.C()) {
                c(k65Var);
            } else {
                this.d.post(new b(this, k65Var));
            }
        }
    }

    public final void e(@NonNull Class<? extends k65> cls, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cls, bdUniqueId) == null) && StickyEvent.class.isAssignableFrom(cls)) {
            OrmObject c2 = q65.c(cls.getSimpleName(), cls);
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
        p65.g();
        k(application);
        o65 o65Var = new o65(application);
        this.e = o65Var;
        o65Var.b(this.f);
        this.e.startService();
        this.a = true;
    }

    public void h(@NonNull k65 k65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, k65Var) == null) {
            if (!p65.i()) {
                String c2 = p65.c();
                p65.m(c2 + " Process Not In WhiteList，Ignore Event!");
                return;
            }
            int myPid = Process.myPid();
            int pid = k65Var.getPid();
            if (k65Var.getType() == 2 && myPid == pid) {
                d(k65Var);
            } else {
                j(k65Var);
            }
        }
    }

    public final void j(k65 k65Var) {
        n65 n65Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, k65Var) == null) || (n65Var = this.e) == null) {
            return;
        }
        n65Var.a(k65Var);
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

    public void l(@NonNull Class<? extends k65> cls, @NonNull l65 l65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, cls, l65Var) == null) {
            if (this.b.containsKey(cls)) {
                BdLog.e(cls + " has existed, Please unRegister old listener first！");
                return;
            }
            this.b.put(cls, l65Var);
        }
    }

    public void m(@NonNull Class<? extends k65> cls, @NonNull s65 s65Var, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cls, s65Var, bdUniqueId) == null) {
            LinkedList<s65> linkedList = this.c.get(cls);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.c.put(cls, linkedList);
            }
            if (linkedList.contains(s65Var)) {
                BdLog.e("listener has existed, Please unRegister old listener first！");
                return;
            }
            s65Var.setTag(bdUniqueId);
            FrameHelper.insert(linkedList, s65Var);
            e(cls, bdUniqueId);
        }
    }

    public void n(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        for (Map.Entry<Class<? extends k65>, LinkedList<s65>> entry : this.c.entrySet()) {
            LinkedList<s65> value = entry.getValue();
            if (!ListUtils.isEmpty(value)) {
                Iterator<s65> it = value.iterator();
                while (it.hasNext()) {
                    s65 next = it.next();
                    if (next != null && next.getTag() != null && next.getTag() == bdUniqueId) {
                        it.remove();
                    }
                }
            }
        }
    }
}
