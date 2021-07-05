package com.kwad.sdk.emotion.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f37190a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f37191b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f37192c;

    /* renamed from: d  reason: collision with root package name */
    public String f37193d;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37191b = new ConcurrentHashMap();
        this.f37192c = new ConcurrentHashMap();
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f37190a == null) {
                synchronized (b.class) {
                    if (f37190a == null) {
                        f37190a = new b();
                    }
                }
            }
            return f37190a;
        }
        return (b) invokeV.objValue;
    }

    public String a(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            return (z ? this.f37192c : this.f37191b).get(str);
        }
        return (String) invokeLZ.objValue;
    }

    public void a(String str) {
        File[] listFiles;
        File[] listFiles2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f37193d = str + File.separator + "message_emoji_resource";
            File file = new File(this.f37193d);
            if (!file.exists()) {
                file.mkdir();
            }
            File file2 = new File(b());
            if (file2.exists() && file2.isDirectory() && (listFiles2 = file2.listFiles()) != null) {
                for (File file3 : listFiles2) {
                    int lastIndexOf = file3.getName().lastIndexOf(46);
                    if (lastIndexOf > 0) {
                        this.f37191b.put(file3.getName().substring(0, lastIndexOf), file3.getAbsolutePath());
                    }
                }
            }
            File file4 = new File(c());
            if (file4.exists() && file4.isDirectory() && (listFiles = file4.listFiles()) != null) {
                for (File file5 : listFiles) {
                    int lastIndexOf2 = file5.getName().lastIndexOf(46);
                    if (lastIndexOf2 > 0) {
                        this.f37192c.put(file5.getName().substring(0, lastIndexOf2), file5.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void a(String str, String str2, boolean z) {
        Map<String, String> map;
        StringBuilder sb;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, str, str2, z) == null) {
            if (z) {
                map = this.f37192c;
                sb = new StringBuilder();
                b2 = c();
            } else {
                map = this.f37191b;
                sb = new StringBuilder();
                b2 = b();
            }
            sb.append(b2);
            sb.append(File.separator);
            sb.append(str2);
            map.put(str, sb.toString());
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (TextUtils.isEmpty(this.f37193d)) {
                return "";
            }
            return this.f37193d + File.separator + "small";
        }
        return (String) invokeV.objValue;
    }

    public boolean b(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, str, z)) == null) {
            return (z ? this.f37192c : this.f37191b).containsKey(str);
        }
        return invokeLZ.booleanValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (TextUtils.isEmpty(this.f37193d)) {
                return "";
            }
            return this.f37193d + File.separator + "big";
        }
        return (String) invokeV.objValue;
    }
}
