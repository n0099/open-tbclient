package tv.athena.revenue;

import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.IRevenue;
import com.yy.mobile.framework.revenuesdk.baseapi.log.IRLogDelegate;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import java.util.List;
import tv.athena.revenue.api.IMiddleRevenue;
import tv.athena.revenue.api.MiddleRevenueConfig;
@Keep
/* loaded from: classes9.dex */
public class RevenueManager implements i.a.a.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String TAG;
    public i.a.a.b.a revenueService;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final RevenueManager f73716a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-882684018, "Ltv/athena/revenue/RevenueManager$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-882684018, "Ltv/athena/revenue/RevenueManager$b;");
                    return;
                }
            }
            f73716a = new RevenueManager(null);
        }
    }

    public /* synthetic */ RevenueManager(a aVar) {
        this();
    }

    public static RevenueManager instance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.f73716a : (RevenueManager) invokeV.objValue;
    }

    @Override // i.a.a.b.a
    public void addLogDelegate(IRLogDelegate iRLogDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iRLogDelegate) == null) {
            RLog.info("RevenueManager", "addLogDelegate");
            this.revenueService.addLogDelegate(iRLogDelegate);
        }
    }

    @Override // i.a.a.b.a
    public void addRevenueConfig(MiddleRevenueConfig middleRevenueConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, middleRevenueConfig) == null) {
            String middleRevenueConfig2 = middleRevenueConfig != null ? middleRevenueConfig.toString() : "config null";
            RLog.info("RevenueManager", "addRevenueConfig config:" + middleRevenueConfig2);
            this.revenueService.addRevenueConfig(middleRevenueConfig);
        }
    }

    @Override // i.a.a.b.a
    public List<IRevenue> getAllRevenue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            RLog.debug("RevenueManager", "getAllRevenue");
            return this.revenueService.getAllRevenue();
        }
        return (List) invokeV.objValue;
    }

    @Override // i.a.a.b.a
    public IMiddleRevenue getMiddleRevenue(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i2, i3)) == null) {
            RLog.debug("RevenueManager", "getMiddleRevenue");
            return this.revenueService.getMiddleRevenue(i2, i3);
        }
        return (IMiddleRevenue) invokeII.objValue;
    }

    @Override // i.a.a.b.a
    public IRevenue getRevenue(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048580, this, i2, i3)) == null) {
            RLog.debug("RevenueManager", "getRevenue");
            return this.revenueService.getRevenue(i2, i3);
        }
        return (IRevenue) invokeII.objValue;
    }

    @Override // i.a.a.b.a
    public void removeRevenueConfig(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            RLog.info("RevenueManager", "removeRevenueConfig appId=" + i2 + " useChannel=" + i3);
            this.revenueService.removeRevenueConfig(i2, i3);
        }
    }

    @Override // i.a.a.b.a
    public void updateMiddleRevenueConfig(int i2, int i3, Long l, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), l, str}) == null) {
            RLog.info("RevenueManager", "updateMiddleRevenueConfig");
            this.revenueService.updateMiddleRevenueConfig(i2, i3, l, str);
        }
    }

    public RevenueManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.TAG = "RevenueManager";
        RLog.info("RevenueManager", "RevenueManager construct");
        this.revenueService = new i.a.a.f.b();
    }
}
