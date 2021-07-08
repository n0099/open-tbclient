package com.idlefish.flutterboost.log;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public interface ILog {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class LogLevelEnum {
        public static final /* synthetic */ LogLevelEnum[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final LogLevelEnum DEBUG;
        public static final LogLevelEnum ERROR;
        public static final LogLevelEnum INFO;
        public static final LogLevelEnum VERBOSE;
        public static final LogLevelEnum WARNING;
        public transient /* synthetic */ FieldHolder $fh;
        public String logLevelName;
        public int loglevel;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1796548155, "Lcom/idlefish/flutterboost/log/ILog$LogLevelEnum;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1796548155, "Lcom/idlefish/flutterboost/log/ILog$LogLevelEnum;");
                    return;
                }
            }
            VERBOSE = new LogLevelEnum("VERBOSE", 0, 0, "V");
            DEBUG = new LogLevelEnum("DEBUG", 1, 1, "D");
            INFO = new LogLevelEnum("INFO", 2, 2, "I");
            WARNING = new LogLevelEnum("WARNING", 3, 3, "W");
            LogLevelEnum logLevelEnum = new LogLevelEnum("ERROR", 4, 4, "E");
            ERROR = logLevelEnum;
            $VALUES = new LogLevelEnum[]{VERBOSE, DEBUG, INFO, WARNING, logLevelEnum};
        }

        public LogLevelEnum(String str, int i2, int i3, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.loglevel = i3;
            this.logLevelName = str2;
        }

        public static LogLevelEnum valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LogLevelEnum) Enum.valueOf(LogLevelEnum.class, str) : (LogLevelEnum) invokeL.objValue;
        }

        public static LogLevelEnum[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LogLevelEnum[]) $VALUES.clone() : (LogLevelEnum[]) invokeV.objValue;
        }

        public String getLogLevelName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.logLevelName : (String) invokeV.objValue;
        }

        public int getLoglevel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.loglevel : invokeV.intValue;
        }
    }

    void e(String str, String str2);

    void e(String str, String str2, Throwable th);
}
