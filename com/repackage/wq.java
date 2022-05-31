package com.repackage;

import androidx.core.view.InputDeviceCompat;
import androidx.transition.Transition;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public abstract class wq implements vq {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static vq b;
    public static final a c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static final class a implements vq {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // com.repackage.vq
        public zr a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? m().a() : (zr) invokeV.objValue;
        }

        @Override // com.repackage.vq
        public as b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? m().b() : (as) invokeV.objValue;
        }

        @Override // com.repackage.vq
        public tr c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? m().c() : (tr) invokeV.objValue;
        }

        @Override // com.repackage.vq
        public ds e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? m().e() : (ds) invokeV.objValue;
        }

        @Override // com.repackage.vq
        public wr g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? m().g() : (wr) invokeV.objValue;
        }

        @Override // com.repackage.vq
        public ur h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? m().h() : (ur) invokeV.objValue;
        }

        @Override // com.repackage.vq
        public yr i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? m().i() : (yr) invokeV.objValue;
        }

        public final void j(vq vqVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, vqVar) == null) {
                n(vqVar);
                k(true);
            }
        }

        public final void k(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
                wq.a = z;
            }
        }

        public final boolean l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? wq.a : invokeV.booleanValue;
        }

        public final vq m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? wq.m() : (vq) invokeV.objValue;
        }

        public final void n(vq vqVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, vqVar) == null) {
                wq.b = vqVar;
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964023701, "Lcom/repackage/wq;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964023701, "Lcom/repackage/wq;");
                return;
            }
        }
        c = new a(null);
    }

    public wq() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static final /* synthetic */ vq m() {
        vq vqVar = b;
        if (vqVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Transition.MATCH_INSTANCE_STR);
        }
        return vqVar;
    }
}
