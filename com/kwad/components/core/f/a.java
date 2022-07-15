package com.kwad.components.core.f;

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
public class a extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
    public static /* synthetic */ Interceptable $ic;
    public static SimpleDateFormat c;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public long b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1273632416, "Lcom/kwad/components/core/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1273632416, "Lcom/kwad/components/core/f/a;");
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
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = System.currentTimeMillis();
            this.a++;
            com.kwad.sdk.core.d.b.a("AdForceActiveInfo", "doAddCount, lastForceActiveTimestamp: " + this.b + ", currentActiveCount " + this.a);
        }
    }

    public final boolean a(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2)) == null) {
            com.kwad.sdk.core.d.b.a("AdForceActiveInfo", "checkAndAddCount forceActiveIntervalHour: " + i + ", forceActiveThreshold: " + i2);
            if (this.b <= 0) {
                a();
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            String format = c.format(new Date(this.b));
            String format2 = c.format(new Date(currentTimeMillis));
            com.kwad.sdk.core.d.b.a("AdForceActiveInfo", "checkAndAddCount lastDate: " + format + ", currentDate: " + format2);
            if (!format.equals(format2)) {
                this.a = 0;
                a();
                return true;
            }
            long j = this.b + (i * 60 * 60 * 1000);
            com.kwad.sdk.core.d.b.a("AdForceActiveInfo", "checkAndAddCount minTimestamp: " + j + ", currentActiveCount: " + this.a);
            if (j >= currentTimeMillis || this.a > i2) {
                return false;
            }
            a();
            return true;
        }
        return invokeII.booleanValue;
    }
}
