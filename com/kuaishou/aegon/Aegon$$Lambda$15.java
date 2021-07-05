package com.kuaishou.aegon;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final /* synthetic */ class Aegon$$Lambda$15 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String arg$1;
    public final String arg$2;

    public Aegon$$Lambda$15(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.arg$1 = str;
        this.arg$2 = str2;
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.kuaishou.aegon.Aegon.addExtraRequestHeader(java.lang.String, java.lang.String):void] */
    public static Runnable lambdaFactory$(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) ? new Aegon$$Lambda$15(str, str2) : (Runnable) invokeLL.objValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Aegon.nativeAddExtraRequestHeader(this.arg$1, this.arg$2);
        }
    }
}
