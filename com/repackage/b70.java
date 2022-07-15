package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
/* loaded from: classes5.dex */
public class b70 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Boolean a;
    public Boolean b;
    public Socket c;
    public InputStream d;
    public OutputStream e;

    public b70() {
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
        Boolean bool = Boolean.FALSE;
        this.a = bool;
        this.b = bool;
        this.c = null;
        this.d = null;
        this.e = null;
    }
}
