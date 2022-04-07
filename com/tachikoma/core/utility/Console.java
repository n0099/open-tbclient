package com.tachikoma.core.utility;

import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.Tachikoma;
import java.io.PrintStream;
@Keep
/* loaded from: classes8.dex */
public class Console {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mIsShowLog;

    public Console() {
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

    public void err(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.mIsShowLog) {
            if (Tachikoma.getInstance().logger() != null) {
                Tachikoma.getInstance().logger().e("tachikoma[ERROR]", str);
                return;
            }
            PrintStream printStream = System.out;
            printStream.println("[ERROR] " + str);
        }
    }

    public void log(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && this.mIsShowLog) {
            if (Tachikoma.getInstance().logger() != null) {
                Tachikoma.getInstance().logger().i("tachikoma[INFO]", str);
                return;
            }
            PrintStream printStream = System.out;
            printStream.println("tachikoma [INFO] " + str);
        }
    }

    public void setShowLog(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.mIsShowLog = z;
        }
    }
}
