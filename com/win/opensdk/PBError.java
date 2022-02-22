package com.win.opensdk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes4.dex */
public class PBError {
    public static /* synthetic */ Interceptable $ic;
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

    /* renamed from: b  reason: collision with root package name */
    public String f61013b;

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
        SERVER_ERROR = new PBError(2004, "NET ERROR");
        PID_INVALID = new PBError(2005, "PID INVALID");
        PID_TYPE_ERROR = new PBError(2006, "PID ERROR");
        UNKNOWN = new PBError(2030, "UNKNOWN ERROR");
        NO_NETWORK = new PBError(2030, "No network available");
        NO_LOAD = new PBError(2031, "No Load");
        NO_RESUOURCE = new PBError(2031, "No Resources");
        LOAD_TIME_OUT = new PBError(2031, "Load Time Out");
        LOAD_TYPE_ERROR = new PBError(2031, "Load Type error");
    }

    public PBError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = i2;
        this.f61013b = str;
    }

    public int getCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
    }

    public String getMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f61013b : (String) invokeV.objValue;
    }

    public void setCode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.a = i2;
        }
    }

    public void setMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f61013b = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return "PBError{code=" + this.a + ", msg='" + this.f61013b + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
