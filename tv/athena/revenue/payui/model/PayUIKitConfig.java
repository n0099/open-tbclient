package tv.athena.revenue.payui.model;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tv.athena.revenue.api.MiddleRevenueConfig;
/* loaded from: classes9.dex */
public class PayUIKitConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageLoaderSupplier imageLoaderSupplier;
    public MiddleRevenueConfig revenueConfig;
    public ThemeColorConfig themeColorConfig;

    /* loaded from: classes9.dex */
    public class PayUIKitConfigBuilder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ImageLoaderSupplier imageLoaderSupplier;
        public MiddleRevenueConfig revenueConfig;
        public ThemeColorConfig themeColorConfig;

        public PayUIKitConfigBuilder() {
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

        public PayUIKitConfig builder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new PayUIKitConfig(this);
            }
            return (PayUIKitConfig) invokeV.objValue;
        }

        public PayUIKitConfigBuilder setImageLoaderSupplier(ImageLoaderSupplier imageLoaderSupplier) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageLoaderSupplier)) == null) {
                this.imageLoaderSupplier = imageLoaderSupplier;
                return this;
            }
            return (PayUIKitConfigBuilder) invokeL.objValue;
        }

        public PayUIKitConfigBuilder setRevenueConfig(MiddleRevenueConfig middleRevenueConfig) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, middleRevenueConfig)) == null) {
                this.revenueConfig = middleRevenueConfig;
                return this;
            }
            return (PayUIKitConfigBuilder) invokeL.objValue;
        }

        public PayUIKitConfigBuilder setThemeColorConfig(ThemeColorConfig themeColorConfig) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, themeColorConfig)) == null) {
                this.themeColorConfig = themeColorConfig;
                return this;
            }
            return (PayUIKitConfigBuilder) invokeL.objValue;
        }
    }

    public PayUIKitConfig(PayUIKitConfigBuilder payUIKitConfigBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {payUIKitConfigBuilder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.revenueConfig = payUIKitConfigBuilder.revenueConfig;
        this.themeColorConfig = payUIKitConfigBuilder.themeColorConfig;
        this.imageLoaderSupplier = payUIKitConfigBuilder.imageLoaderSupplier;
    }
}
