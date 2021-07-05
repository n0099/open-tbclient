package com.fun.ad.sdk;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class FunAdSlot {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int adCount;
    public int expressHeight;
    public int expressWidth;
    public String sid;
    public boolean smallImgStyle;

    /* loaded from: classes6.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int adCount;
        public int expressHeight;
        public int expressWidth;
        public String sid;
        public boolean smallImgStyle;

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
                FunAdSlot funAdSlot = new FunAdSlot(null);
                funAdSlot.sid = this.sid;
                funAdSlot.expressWidth = this.expressWidth;
                funAdSlot.expressHeight = this.expressHeight;
                funAdSlot.smallImgStyle = this.smallImgStyle;
                funAdSlot.adCount = this.adCount;
                return funAdSlot;
            }
            return (FunAdSlot) invokeV.objValue;
        }

        public Builder setAdCount(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                this.adCount = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setExpressHeight(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                this.expressHeight = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setExpressWidth(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                this.expressWidth = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSid(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.sid = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setSmallImgStyle(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                this.smallImgStyle = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
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

    public /* synthetic */ FunAdSlot(a aVar) {
        this();
    }

    public int getAdCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.adCount : invokeV.intValue;
    }

    public int getExpressHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.expressHeight : invokeV.intValue;
    }

    public int getExpressWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.expressWidth : invokeV.intValue;
    }

    public String getSid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.sid : (String) invokeV.objValue;
    }

    public boolean isSmallImgStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.smallImgStyle : invokeV.booleanValue;
    }
}
