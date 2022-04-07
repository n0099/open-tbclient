package com.yy.mobile.framework.revenuesdk.payapi.bean;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes8.dex */
public class MyBalanceInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long imid;
    public long minAmountLimit;
    public Map<Integer, AccountPeriod> myAccountPeriodMap;
    public Map<Integer, Account> myBalanceMap;

    /* loaded from: classes8.dex */
    public static class Account {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int accountFrozen;
        public long amount;
        public int currencyType;
        public long expireAmount;
        public String expireDate;
        public long freezed;

        public Account() {
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

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "Account{currencyType=" + this.currencyType + ", amount=" + this.amount + ", freezed=" + this.freezed + ", accountFrozen=" + this.accountFrozen + ", expireAmount = " + this.expireAmount + ", expireDate = " + this.expireDate + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class AccountPeriod {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int amount;
        public int currencyType;
        public long endTime;
        public long startTime;

        public AccountPeriod() {
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

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "AccountPeriod{currencyType=" + this.currencyType + ", amount=" + this.amount + ", startTime=" + this.startTime + ", endTime=" + this.endTime + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    public MyBalanceInfo(Map<Integer, Account> map, Map<Integer, AccountPeriod> map2, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map, map2, Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.myBalanceMap = map;
        this.myAccountPeriodMap = map2;
        this.minAmountLimit = j;
        this.imid = j2;
    }

    public long getImid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.imid : invokeV.longValue;
    }

    public long getMinAmountLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.minAmountLimit : invokeV.longValue;
    }

    public AccountPeriod getMyAccountPeriod(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            Map<Integer, AccountPeriod> map = this.myAccountPeriodMap;
            if (map != null && map.containsKey(Integer.valueOf(i))) {
                return this.myAccountPeriodMap.get(Integer.valueOf(i));
            }
            return new AccountPeriod();
        }
        return (AccountPeriod) invokeI.objValue;
    }

    public Account getMyBalance(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            Map<Integer, Account> map = this.myBalanceMap;
            if (map != null && map.containsKey(Integer.valueOf(i))) {
                return this.myBalanceMap.get(Integer.valueOf(i));
            }
            return new Account();
        }
        return (Account) invokeI.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return "MyBalanceInfo{myBalanceMap=" + this.myBalanceMap + "minAmountLimit=" + this.minAmountLimit + "imid=" + this.imid + '}';
        }
        return (String) invokeV.objValue;
    }
}
