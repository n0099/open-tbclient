package tv.athena.revenue.api;

import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.IReporter;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.ReportConfig;
import kotlin.Deprecated;
import kotlin.Metadata;
@Deprecated(message = "废弃不再使用")
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Ltv/athena/revenue/api/MiddleReportConfig;", "Lcom/yy/mobile/framework/revenuesdk/baseapi/reporter/ReportConfig;", "Ltv/athena/revenue/api/MiddleReportConfig$MiddleReportConfigBuilder;", "builder", "<init>", "(Ltv/athena/revenue/api/MiddleReportConfig$MiddleReportConfigBuilder;)V", "MiddleReportConfigBuilder", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class MiddleReportConfig extends ReportConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u0000B\u0007¢\u0006\u0004\b\u001f\u0010 J\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u0007J\u0015\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0006\u0010\u0015R\"\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014\"\u0004\b\t\u0010\u0015R\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\f\u0010\u001aR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u0010\u0010\u001e¨\u0006!"}, d2 = {"Ltv/athena/revenue/api/MiddleReportConfig$MiddleReportConfigBuilder;", "Ltv/athena/revenue/api/MiddleReportConfig;", "build", "()Ltv/athena/revenue/api/MiddleReportConfig;", "", "appName", "setAppName", "(Ljava/lang/String;)Ltv/athena/revenue/api/MiddleReportConfig$MiddleReportConfigBuilder;", "deviceId", "setDeviceId", "", "reportRatio", "setReportRatio", "(F)Ltv/athena/revenue/api/MiddleReportConfig$MiddleReportConfigBuilder;", "Lcom/yy/mobile/framework/revenuesdk/baseapi/reporter/IReporter;", "reporter", "setReporter", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/reporter/IReporter;)Ltv/athena/revenue/api/MiddleReportConfig$MiddleReportConfigBuilder;", "Ljava/lang/String;", "getAppName", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "getDeviceId", "F", "getReportRatio", "()F", "(F)V", "Lcom/yy/mobile/framework/revenuesdk/baseapi/reporter/IReporter;", "getReporter", "()Lcom/yy/mobile/framework/revenuesdk/baseapi/reporter/IReporter;", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/reporter/IReporter;)V", "<init>", "()V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes9.dex */
    public static final class MiddleReportConfigBuilder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String appName;
        public String deviceId;
        public float reportRatio;
        public IReporter reporter;

        public MiddleReportConfigBuilder() {
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
            this.appName = "";
            this.reportRatio = 1.0f;
            this.deviceId = "";
        }

        public final MiddleReportConfig build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new MiddleReportConfig(this);
            }
            return (MiddleReportConfig) invokeV.objValue;
        }

        public final String getAppName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.appName;
            }
            return (String) invokeV.objValue;
        }

        public final String getDeviceId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.deviceId;
            }
            return (String) invokeV.objValue;
        }

        public final float getReportRatio() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.reportRatio;
            }
            return invokeV.floatValue;
        }

        public final IReporter getReporter() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.reporter;
            }
            return (IReporter) invokeV.objValue;
        }

        public final MiddleReportConfigBuilder setAppName(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.appName = str;
                return this;
            }
            return (MiddleReportConfigBuilder) invokeL.objValue;
        }

        public final MiddleReportConfigBuilder setDeviceId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                this.deviceId = str;
                return this;
            }
            return (MiddleReportConfigBuilder) invokeL.objValue;
        }

        public final MiddleReportConfigBuilder setReportRatio(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048585, this, f)) == null) {
                this.reportRatio = f;
                return this;
            }
            return (MiddleReportConfigBuilder) invokeF.objValue;
        }

        public final MiddleReportConfigBuilder setReporter(IReporter iReporter) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, iReporter)) == null) {
                this.reporter = iReporter;
                return this;
            }
            return (MiddleReportConfigBuilder) invokeL.objValue;
        }

        /* renamed from: setAppName  reason: collision with other method in class */
        public final void m2117setAppName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                this.appName = str;
            }
        }

        /* renamed from: setDeviceId  reason: collision with other method in class */
        public final void m2118setDeviceId(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
                this.deviceId = str;
            }
        }

        /* renamed from: setReportRatio  reason: collision with other method in class */
        public final void m2119setReportRatio(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048586, this, f) == null) {
                this.reportRatio = f;
            }
        }

        /* renamed from: setReporter  reason: collision with other method in class */
        public final void m2120setReporter(IReporter iReporter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, iReporter) == null) {
                this.reporter = iReporter;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiddleReportConfig(MiddleReportConfigBuilder middleReportConfigBuilder) {
        super(middleReportConfigBuilder.getAppName(), middleReportConfigBuilder.getDeviceId(), middleReportConfigBuilder.getReportRatio(), middleReportConfigBuilder.getReporter());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {middleReportConfigBuilder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (String) objArr2[1], ((Float) objArr2[2]).floatValue(), (IReporter) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        setAppName(middleReportConfigBuilder.getAppName());
        setReportRatio(middleReportConfigBuilder.getReportRatio());
        setReporter(middleReportConfigBuilder.getReporter());
    }
}
