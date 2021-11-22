package com.fun.ad.sdk;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class FunAdSlot {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f63627a;

    /* renamed from: b  reason: collision with root package name */
    public int f63628b;

    /* renamed from: c  reason: collision with root package name */
    public int f63629c;

    /* renamed from: d  reason: collision with root package name */
    public int f63630d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f63631e;

    /* renamed from: com.fun.ad.sdk.FunAdSlot$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes11.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f63632a;

        /* renamed from: b  reason: collision with root package name */
        public int f63633b;

        /* renamed from: c  reason: collision with root package name */
        public int f63634c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f63635d;

        /* renamed from: e  reason: collision with root package name */
        public int f63636e;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public FunAdSlot build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FunAdSlot funAdSlot = new FunAdSlot();
                funAdSlot.f63627a = this.f63632a;
                funAdSlot.f63628b = this.f63633b;
                funAdSlot.f63629c = this.f63634c;
                funAdSlot.f63631e = this.f63635d;
                funAdSlot.f63630d = this.f63636e;
                return funAdSlot;
            }
            return (FunAdSlot) invokeV.objValue;
        }

        public Builder setAdCount(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                this.f63636e = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setExpressHeight(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                this.f63634c = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setExpressWidth(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                this.f63633b = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSid(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f63632a = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setSmallImgStyle(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                this.f63635d = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }
    }

    public FunAdSlot() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public int getAdCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f63630d : invokeV.intValue;
    }

    public int getExpressHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f63629c : invokeV.intValue;
    }

    public int getExpressWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f63628b : invokeV.intValue;
    }

    public String getSid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f63627a : (String) invokeV.objValue;
    }

    public boolean isSmallImgStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f63631e : invokeV.booleanValue;
    }
}
