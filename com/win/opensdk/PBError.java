package com.win.opensdk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class PBError {
    public static /* synthetic */ Interceptable $ic;
    public static final PBError JSON_ERROR;
    public static final PBError LOAD_TIME_OUT;
    public static final PBError LOAD_TOO_FREQUENTLY;
    public static final PBError LOAD_TYPE_ERROR;
    public static final PBError NO_FILL;
    public static final PBError NO_LOAD;
    public static final PBError NO_NETWORK;
    public static final PBError NO_RESUOURCE;
    public static final PBError PID_INVALID;
    public static final PBError PID_TYPE_ERROR;
    public static final PBError SERVER_ERROR;
    public static final PBError TIMEOUT;
    public static final PBError UNKNOWN;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(14169905, "Lcom/win/opensdk/PBError;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(14169905, "Lcom/win/opensdk/PBError;");
                return;
            }
        }
        NO_FILL = new PBError(2001, "NO FILL");
        TIMEOUT = new PBError(2002, "TIME OUT");
        LOAD_TOO_FREQUENTLY = new PBError(2003, "LOAD TOO FREQUENTLY");
        JSON_ERROR = new PBError(2004, "JSON ERROR");
        PID_INVALID = new PBError(2005, "PID INVALID");
        PID_TYPE_ERROR = new PBError(2006, "PID ERROR");
        SERVER_ERROR = new PBError(2007, "NET ERROR");
        UNKNOWN = new PBError(2030, "UNKNOWN ERROR");
        NO_NETWORK = new PBError(2030, "No network available");
        NO_LOAD = new PBError(2031, "No Load");
        NO_RESUOURCE = new PBError(2031, "No Resources");
        LOAD_TIME_OUT = new PBError(2031, "Load Time Out");
        LOAD_TYPE_ERROR = new PBError(2031, "Load Type error");
    }

    public PBError(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = i;
        this.b = str;
    }

    public int getCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
    }

    public String getMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public void setCode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.a = i;
        }
    }

    public void setMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.b = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return "PBError{code=" + this.a + ", msg='" + this.b + "'}";
        }
        return (String) invokeV.objValue;
    }
}
