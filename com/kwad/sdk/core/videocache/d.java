package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f36670d;

    /* renamed from: e  reason: collision with root package name */
    public static final Pattern f36671e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f36672a;

    /* renamed from: b  reason: collision with root package name */
    public final long f36673b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f36674c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1359207638, "Lcom/kwad/sdk/core/videocache/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1359207638, "Lcom/kwad/sdk/core/videocache/d;");
                return;
            }
        }
        f36670d = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
        f36671e = Pattern.compile("GET /(.*) HTTP");
    }

    public d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        j.a(str);
        long a2 = a(str);
        this.f36673b = Math.max(0L, a2);
        this.f36674c = a2 >= 0;
        this.f36672a = b(str);
    }

    private long a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            Matcher matcher = f36670d.matcher(str);
            if (matcher.find()) {
                return Long.parseLong(matcher.group(1));
            }
            return -1L;
        }
        return invokeL.longValue;
    }

    public static d a(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65539, null, inputStream)) != null) {
            return (d) invokeL.objValue;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (TextUtils.isEmpty(readLine)) {
                return new d(sb.toString());
            }
            sb.append(readLine);
            sb.append('\n');
        }
    }

    private String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, this, str)) == null) {
            Matcher matcher = f36671e.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
            throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
        }
        return (String) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "GetRequest{rangeOffset=" + this.f36673b + ", partial=" + this.f36674c + ", uri='" + this.f36672a + "'}";
        }
        return (String) invokeV.objValue;
    }
}
