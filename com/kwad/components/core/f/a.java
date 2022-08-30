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
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
    public static /* synthetic */ Interceptable $ic;
    public static SimpleDateFormat EB;
    public transient /* synthetic */ FieldHolder $fh;
    public int ED;
    public long EE;

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
        EB = new SimpleDateFormat("yyyy-MM-dd");
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

    public final boolean h(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            com.kwad.sdk.core.e.b.d("AdForceActiveInfo", "checkAndAddCount forceActiveIntervalHour: " + i + ", forceActiveThreshold: " + i2);
            if (this.EE <= 0) {
                ni();
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            String format = EB.format(new Date(this.EE));
            String format2 = EB.format(new Date(currentTimeMillis));
            com.kwad.sdk.core.e.b.d("AdForceActiveInfo", "checkAndAddCount lastDate: " + format + ", currentDate: " + format2);
            if (!format.equals(format2)) {
                this.ED = 0;
                ni();
                return true;
            }
            long j = this.EE + (i * 60 * 60 * 1000);
            com.kwad.sdk.core.e.b.d("AdForceActiveInfo", "checkAndAddCount minTimestamp: " + j + ", currentActiveCount: " + this.ED);
            if (j >= currentTimeMillis || this.ED > i2) {
                return false;
            }
            ni();
            return true;
        }
        return invokeII.booleanValue;
    }

    public final void ni() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.EE = System.currentTimeMillis();
            this.ED++;
            com.kwad.sdk.core.e.b.d("AdForceActiveInfo", "doAddCount, lastForceActiveTimestamp: " + this.EE + ", currentActiveCount " + this.ED);
        }
    }
}
