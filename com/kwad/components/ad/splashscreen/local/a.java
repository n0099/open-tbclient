package com.kwad.components.ad.splashscreen.local;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.json.annotation.KsJson;
import java.text.SimpleDateFormat;
import java.util.Date;
@KsJson
/* loaded from: classes5.dex */
public class a extends com.kwad.sdk.core.response.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public static SimpleDateFormat c;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public int b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1461866079, "Lcom/kwad/components/ad/splashscreen/local/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1461866079, "Lcom/kwad/components/ad/splashscreen/local/a;");
                return;
            }
        }
        c = new SimpleDateFormat("yyyy-MM-dd");
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = -1L;
        this.b = -1;
    }

    public a(long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = -1L;
        this.b = -1;
        this.a = j;
        this.b = 1;
    }

    public final boolean a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            int i2 = this.b;
            return i2 > 0 && i2 >= i;
        }
        return invokeI.booleanValue;
    }

    public final boolean a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            if (this.a > 0 && j > 0) {
                try {
                    return c.format(new Date(this.a)).equals(c.format(new Date(j)));
                } catch (Exception e) {
                    com.kwad.sdk.core.d.b.b(e);
                }
            }
            return false;
        }
        return invokeJ.booleanValue;
    }
}
