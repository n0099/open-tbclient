package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public abstract class ll4 {
    public static /* synthetic */ Interceptable $ic;
    public static WeakReference<TbPageContext<?>> a;
    public static boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface a {
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755525251, "Lcom/repackage/ll4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755525251, "Lcom/repackage/ll4;");
        }
    }

    public ll4() {
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
        new ArrayList(5);
    }

    public static ll4 a(BaseFragmentActivity baseFragmentActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, baseFragmentActivity)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2004505, ll4.class, baseFragmentActivity);
            if (runTask == null || runTask.getData() == null) {
                return null;
            }
            return (ll4) runTask.getData();
        }
        return (ll4) invokeL.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? b : invokeV.booleanValue;
    }

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract void g(int i);

    public void h() {
        WeakReference<TbPageContext<?>> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (weakReference = a) == null) {
            return;
        }
        weakReference.get();
        a.clear();
        a = null;
    }

    public abstract void i();

    public void j(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbPageContext) == null) {
            WeakReference<TbPageContext<?>> weakReference = a;
            if (weakReference == null) {
                a = new WeakReference<>(tbPageContext);
                return;
            }
            weakReference.clear();
            a = null;
            a = new WeakReference<>(tbPageContext);
        }
    }

    public abstract void k(a aVar);

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
        }
    }

    public abstract void m();
}
