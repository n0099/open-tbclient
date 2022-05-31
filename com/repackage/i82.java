package com.repackage;

import android.text.TextUtils;
import androidx.collection.ArraySet;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.di2;
/* loaded from: classes6.dex */
public class i82 implements g82 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String[] a;

    public i82() {
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
        this.a = new String[]{di2.i(), di2.l(), di2.r(), di2.b.f(), ax1.f(), ax1.d(), lw1.c(), di2.f.f(), di2.f.d(), zc2.d};
    }

    @Override // com.repackage.g82
    public ArraySet<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArraySet<String> arraySet = new ArraySet<>();
            for (String str : this.a) {
                String K = kf4.K(str);
                if (!TextUtils.isEmpty(K)) {
                    arraySet.add(K);
                }
            }
            hw1.k("SwanSandboxFileCollector", "recovery renameAllFiles:" + arraySet.toString());
            return arraySet;
        }
        return (ArraySet) invokeV.objValue;
    }
}
