package tv.athena.revenue;

import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.cia;
import com.baidu.tieba.jda;
import com.baidu.tieba.kda;
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
public class RevenueManager implements jda {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String TAG;
    public jda revenueService;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final RevenueManager a;
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
            a = new RevenueManager(null);
        }
    }

    public RevenueManager() {
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
        this.TAG = "RevenueManager";
        RLog.info("RevenueManager", "create RevenueManager");
        this.revenueService = new cia();
    }

    public static RevenueManager instance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (RevenueManager) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jda
    public List<IRevenue> getAllRevenue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            RLog.debug("RevenueManager", "getAllRevenue");
            return this.revenueService.getAllRevenue();
        }
        return (List) invokeV.objValue;
    }

    public /* synthetic */ RevenueManager(a aVar) {
        this();
    }

    @Override // com.baidu.tieba.jda
    public void addLogDelegate(IRLogDelegate iRLogDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iRLogDelegate) == null) {
            RLog.info("RevenueManager", "addLogDelegate");
            this.revenueService.addLogDelegate(iRLogDelegate);
        }
    }

    @Override // com.baidu.tieba.jda
    public void addRevenueConfig(MiddleRevenueConfig middleRevenueConfig) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, middleRevenueConfig) == null) {
            if (middleRevenueConfig != null) {
                str = middleRevenueConfig.toString();
            } else {
                str = "config null";
            }
            RLog.info("RevenueManager", "addRevenueConfig config:" + str);
            this.revenueService.addRevenueConfig(middleRevenueConfig);
        }
    }

    @Override // com.baidu.tieba.jda
    public IMiddleRevenue getMiddleRevenue(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i, i2)) == null) {
            RLog.debug("RevenueManager", "getMiddleRevenue");
            return this.revenueService.getMiddleRevenue(i, i2);
        }
        return (IMiddleRevenue) invokeII.objValue;
    }

    @Override // com.baidu.tieba.jda
    public IRevenue getRevenue(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048580, this, i, i2)) == null) {
            return this.revenueService.getRevenue(i, i2);
        }
        return (IRevenue) invokeII.objValue;
    }

    @Override // com.baidu.tieba.jda
    public kda getYYPayMiddleService(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048581, this, i, i2)) == null) {
            return this.revenueService.getYYPayMiddleService(i, i2);
        }
        return (kda) invokeII.objValue;
    }

    @Override // com.baidu.tieba.jda
    public void removeRevenueConfig(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i, i2) == null) {
            RLog.info("RevenueManager", "removeRevenueConfig appId=" + i + " useChannel=" + i2);
            this.revenueService.removeRevenueConfig(i, i2);
        }
    }

    @Override // com.baidu.tieba.jda
    public void updateMiddleRevenueConfig(int i, int i2, Long l, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), l, str}) == null) {
            RLog.info("RevenueManager", "updateMiddleRevenueConfig");
            this.revenueService.updateMiddleRevenueConfig(i, i2, l, str);
        }
    }
}
