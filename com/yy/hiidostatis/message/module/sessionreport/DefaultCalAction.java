package com.yy.hiidostatis.message.module.sessionreport;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class DefaultCalAction {
    public static /* synthetic */ Interceptable $ic;
    public static final CalAction AVERAGE;
    public static final CalAction MAX;
    public static final CalAction MIN;
    public static final CalAction SUM;
    public static final CalAction SUM_DEVIATION;
    public static final CalAction SUM_DEVIATION_AND_UPDATE_TEMP;
    public static final CalAction TEMP_STORE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-233668885, "Lcom/yy/hiidostatis/message/module/sessionreport/DefaultCalAction;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-233668885, "Lcom/yy/hiidostatis/message/module/sessionreport/DefaultCalAction;");
                return;
            }
        }
        SUM = new CalAction() { // from class: com.yy.hiidostatis.message.module.sessionreport.DefaultCalAction.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.yy.hiidostatis.message.module.sessionreport.CalAction
            public CalValue cal(Number number, CalValue calValue) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, number, calValue)) == null) ? (DefaultCalAction.isInt(number) && DefaultCalAction.isInt(calValue.value)) ? calValue.updateValue(Long.valueOf(DefaultCalAction.safeToInt(number) + DefaultCalAction.safeToInt(calValue.value))) : calValue.updateValue(Double.valueOf(DefaultCalAction.safeToFloat(number) + DefaultCalAction.safeToFloat(calValue.value))) : (CalValue) invokeLL.objValue;
            }
        };
        AVERAGE = new CalAction() { // from class: com.yy.hiidostatis.message.module.sessionreport.DefaultCalAction.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.yy.hiidostatis.message.module.sessionreport.CalAction
            public CalValue cal(Number number, CalValue calValue) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, number, calValue)) == null) ? calValue.updateValue(Double.valueOf((DefaultCalAction.safeToFloat(number) + DefaultCalAction.safeToFloat(calValue.value)) / (calValue.times.get() + 1))) : (CalValue) invokeLL.objValue;
            }
        };
        MAX = new CalAction() { // from class: com.yy.hiidostatis.message.module.sessionreport.DefaultCalAction.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.yy.hiidostatis.message.module.sessionreport.CalAction
            public CalValue cal(Number number, CalValue calValue) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, number, calValue)) == null) {
                    if (calValue.value == null) {
                        return calValue.updateValue(number);
                    }
                    return (DefaultCalAction.isInt(number) && DefaultCalAction.isInt(calValue.value)) ? calValue.updateValue(Long.valueOf(Math.max(DefaultCalAction.safeToInt(number), DefaultCalAction.safeToInt(calValue.value)))) : calValue.updateValue(Double.valueOf(Math.max(DefaultCalAction.safeToFloat(number), DefaultCalAction.safeToFloat(calValue.value))));
                }
                return (CalValue) invokeLL.objValue;
            }
        };
        MIN = new CalAction() { // from class: com.yy.hiidostatis.message.module.sessionreport.DefaultCalAction.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.yy.hiidostatis.message.module.sessionreport.CalAction
            public CalValue cal(Number number, CalValue calValue) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, number, calValue)) == null) {
                    if (calValue.value == null) {
                        return calValue.updateValue(number);
                    }
                    return (DefaultCalAction.isInt(number) && DefaultCalAction.isInt(calValue.value)) ? calValue.updateValue(Long.valueOf(Math.min(DefaultCalAction.safeToInt(number), DefaultCalAction.safeToInt(calValue.value)))) : calValue.updateValue(Double.valueOf(Math.min(DefaultCalAction.safeToFloat(number), DefaultCalAction.safeToFloat(calValue.value))));
                }
                return (CalValue) invokeLL.objValue;
            }
        };
        TEMP_STORE = new CalAction() { // from class: com.yy.hiidostatis.message.module.sessionreport.DefaultCalAction.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.yy.hiidostatis.message.module.sessionreport.CalAction
            public CalValue cal(Number number, CalValue calValue) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, number, calValue)) == null) ? calValue.updateTempStorage(number) : (CalValue) invokeLL.objValue;
            }
        };
        SUM_DEVIATION = new CalAction() { // from class: com.yy.hiidostatis.message.module.sessionreport.DefaultCalAction.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.yy.hiidostatis.message.module.sessionreport.CalAction
            public CalValue cal(Number number, CalValue calValue) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, number, calValue)) == null) ? (DefaultCalAction.isInt(number) && DefaultCalAction.isInt((Number) calValue.tempStorage)) ? calValue.updateValue(Long.valueOf((DefaultCalAction.safeToInt(calValue.value) + DefaultCalAction.safeToInt(number)) - DefaultCalAction.safeToInt((Number) calValue.tempStorage))) : calValue.updateValue(Double.valueOf((DefaultCalAction.safeToInt(calValue.value) + DefaultCalAction.safeToFloat(number)) - DefaultCalAction.safeToFloat((Number) calValue.tempStorage))) : (CalValue) invokeLL.objValue;
            }
        };
        SUM_DEVIATION_AND_UPDATE_TEMP = new CalAction() { // from class: com.yy.hiidostatis.message.module.sessionreport.DefaultCalAction.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.yy.hiidostatis.message.module.sessionreport.CalAction
            public CalValue cal(Number number, CalValue calValue) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, number, calValue)) == null) ? (DefaultCalAction.isInt(number) && DefaultCalAction.isInt((Number) calValue.tempStorage)) ? calValue.updateValue(Long.valueOf((DefaultCalAction.safeToInt(calValue.value) + DefaultCalAction.safeToInt(number)) - DefaultCalAction.safeToInt((Number) calValue.tempStorage))).updateTempStorage(number) : calValue.updateValue(Double.valueOf((DefaultCalAction.safeToInt(calValue.value) + DefaultCalAction.safeToFloat(number)) - DefaultCalAction.safeToFloat((Number) calValue.tempStorage))).updateTempStorage(number) : (CalValue) invokeLL.objValue;
            }
        };
    }

    public DefaultCalAction() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean isInt(Number number) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, number)) == null) ? number == null || (number instanceof Long) || (number instanceof Integer) : invokeL.booleanValue;
    }

    public static double safeToFloat(Number number) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, number)) == null) {
            if (number == null) {
                return 0.0d;
            }
            return number.doubleValue();
        }
        return invokeL.doubleValue;
    }

    public static long safeToInt(Number number) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, number)) == null) {
            if (number == null) {
                return 0L;
            }
            return number.longValue();
        }
        return invokeL.longValue;
    }
}
