package com.repackage;

import android.view.ViewGroup;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.wt0;
/* loaded from: classes7.dex */
public abstract class xt0<VG extends ViewGroup, BE extends wt0> extends bu0<VG, BE> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public xt0() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.rt0
    /* renamed from: S */
    public lo0 v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ko0 v = super.v();
            if (v != null) {
                return (lo0) v;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.nadcore.player.BaseVideoPlayer");
        }
        return (lo0) invokeV.objValue;
    }
}
