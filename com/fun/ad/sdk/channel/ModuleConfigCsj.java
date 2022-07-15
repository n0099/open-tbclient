package com.fun.ad.sdk.channel;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.fun.ad.sdk.ModuleAdConfig;
/* loaded from: classes4.dex */
public class ModuleConfigCsj extends ModuleAdConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TITLE_BAR_THEME_DARK = 1;
    public static final int TITLE_BAR_THEME_LIGHT = 0;
    public static final int TITLE_BAR_THEME_NO_TITLE_BAR = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public final int titleBarTheme;
    public final TTCustomController ttCustomCtr;
    public final TTAdSdk.InitCallback ttInitCallback;
    public final boolean ttSupportMultiProcess;

    /* renamed from: com.fun.ad.sdk.channel.ModuleConfigCsj$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TTCustomController mTTCustomCtr;
        public int titleBarTheme;
        public TTAdSdk.InitCallback ttInitCallback;
        public boolean ttSupportMultiProcess;

        public Builder() {
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
            this.mTTCustomCtr = null;
            this.ttInitCallback = null;
            this.titleBarTheme = -1;
        }

        public ModuleConfigCsj build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new ModuleConfigCsj(this, null) : (ModuleConfigCsj) invokeV.objValue;
        }

        public Builder setTTCustomController(TTCustomController tTCustomController) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tTCustomController)) == null) {
                this.mTTCustomCtr = tTCustomController;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setTitleBarTheme(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                this.titleBarTheme = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setTtInitCallback(TTAdSdk.InitCallback initCallback) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, initCallback)) == null) {
                this.ttInitCallback = initCallback;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setTtSupportMultiProcess(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.ttSupportMultiProcess = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }
    }

    public ModuleConfigCsj(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.titleBarTheme = builder.titleBarTheme;
        this.ttSupportMultiProcess = builder.ttSupportMultiProcess;
        this.ttCustomCtr = builder.mTTCustomCtr;
        this.ttInitCallback = builder.ttInitCallback;
    }

    public /* synthetic */ ModuleConfigCsj(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }
}
