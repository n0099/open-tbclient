package com.repackage;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public abstract class bm4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, boolean z2, String str);
    }

    public bm4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static bm4 b(BaseActivity baseActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, baseActivity)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001279, bm4.class, baseActivity);
            if (runTask == null || runTask.getData() == null) {
                return null;
            }
            return (bm4) runTask.getData();
        }
        return (bm4) invokeL.objValue;
    }

    public static bm4 c(BaseFragmentActivity baseFragmentActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, baseFragmentActivity)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921318, bm4.class, baseFragmentActivity);
            if (runTask == null || runTask.getData() == null) {
                return null;
            }
            return (bm4) runTask.getData();
        }
        return (bm4) invokeL.objValue;
    }

    public abstract void a();

    public abstract void d();

    public abstract boolean e();

    public abstract MarkData f();

    public abstract String g();

    public abstract void h(boolean z);

    public abstract void i(MarkData markData);

    public abstract void j(a aVar);
}
