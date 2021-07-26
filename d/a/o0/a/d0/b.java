package d.a.o0.a.d0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final long f44441a;

    /* renamed from: b  reason: collision with root package name */
    public final long f44442b;

    /* renamed from: c  reason: collision with root package name */
    public final String f44443c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, String> f44444d;

    public b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f44444d = new HashMap();
        this.f44442b = TimeUnit.MILLISECONDS.toSeconds(j);
        this.f44441a = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - j);
        this.f44443c = Long.toHexString(a(this.f44441a + "#" + this.f44442b));
        this.f44444d.put("timestamp", Long.toString(this.f44441a));
        this.f44444d.put("delta", Long.toString(this.f44442b));
        this.f44444d.put("rasign", this.f44443c);
    }

    public static b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new b(0L) : (b) invokeV.objValue;
    }

    public final long a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            CRC32 crc32 = new CRC32();
            crc32.reset();
            crc32.update(str.getBytes());
            return crc32.getValue();
        }
        return invokeL.longValue;
    }

    public String c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            return Long.toHexString(a(j + "#smartapp_formid"));
        }
        return (String) invokeJ.objValue;
    }

    public String d(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            return Long.toHexString(a(j + "#payid"));
        }
        return (String) invokeJ.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return super.toString() + " serverTime:" + this.f44441a + " delta:" + this.f44442b + " rasign:" + this.f44443c;
        }
        return (String) invokeV.objValue;
    }
}
