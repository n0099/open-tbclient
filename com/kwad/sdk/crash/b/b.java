package com.kwad.sdk.crash.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Set<String> f35499a;

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f35500b;

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
        this.f35499a = new HashSet();
        this.f35500b = new HashSet();
    }

    public synchronized void a(String[] strArr, String[] strArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, strArr, strArr2) == null) {
            synchronized (this) {
                if (strArr != null) {
                    try {
                        if (strArr.length > 0) {
                            for (String str : strArr) {
                                if (!TextUtils.isEmpty(str)) {
                                    this.f35499a.add(str);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (strArr2 != null && strArr2.length > 0) {
                    for (String str2 : strArr2) {
                        if (!TextUtils.isEmpty(str2)) {
                            this.f35500b.add(str2);
                        }
                    }
                }
            }
        }
    }

    public synchronized String[] a() {
        InterceptResult invokeV;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                strArr = (String[]) this.f35499a.toArray(new String[this.f35499a.size()]);
            }
            return strArr;
        }
        return (String[]) invokeV.objValue;
    }

    public synchronized String[] b() {
        InterceptResult invokeV;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                strArr = (String[]) this.f35500b.toArray(new String[this.f35500b.size()]);
            }
            return strArr;
        }
        return (String[]) invokeV.objValue;
    }
}
