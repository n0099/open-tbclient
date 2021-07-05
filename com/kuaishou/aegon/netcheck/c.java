package com.kuaishou.aegon.netcheck;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.EnumSet;
/* loaded from: classes7.dex */
public final /* synthetic */ class c implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final NetcheckTaskListenerWrapper f34037a;

    /* renamed from: b  reason: collision with root package name */
    public final EnumSet f34038b;

    /* renamed from: c  reason: collision with root package name */
    public final String f34039c;

    public c(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, EnumSet enumSet, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {netcheckTaskListenerWrapper, enumSet, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34037a = netcheckTaskListenerWrapper;
        this.f34038b = enumSet;
        this.f34039c = str;
    }

    public static Runnable a(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, EnumSet enumSet, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, netcheckTaskListenerWrapper, enumSet, str)) == null) ? new c(netcheckTaskListenerWrapper, enumSet, str) : (Runnable) invokeLLL.objValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f34037a.f34026a.a(this.f34038b, this.f34039c);
        }
    }
}
