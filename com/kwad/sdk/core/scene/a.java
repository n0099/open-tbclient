package com.kwad.sdk.core.scene;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static a f72065a;

    /* renamed from: b  reason: collision with root package name */
    public static Object f72066b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, URLPackage> f72067c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, URLPackage> f72068d;

    /* renamed from: e  reason: collision with root package name */
    public final URLPackage f72069e;

    /* renamed from: f  reason: collision with root package name */
    public final EntryPackage f72070f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-368347694, "Lcom/kwad/sdk/core/scene/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-368347694, "Lcom/kwad/sdk/core/scene/a;");
                return;
            }
        }
        f72066b = new Object();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f72067c = new HashMap<>();
        this.f72068d = new HashMap<>();
        this.f72069e = new URLPackage("", 0);
        this.f72070f = new EntryPackage("", 0);
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f72065a == null) {
                synchronized (f72066b) {
                    if (f72065a == null) {
                        f72065a = new a();
                    }
                }
            }
            return f72065a;
        }
        return (a) invokeV.objValue;
    }

    @Nullable
    public URLPackage a(@NonNull String str) {
        InterceptResult invokeL;
        URLPackage uRLPackage;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? (TextUtils.isEmpty(str) || (uRLPackage = this.f72067c.get(str)) == null || (uRLPackage instanceof EntryPackage)) ? this.f72069e : uRLPackage : (URLPackage) invokeL.objValue;
    }

    public EntryPackage b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                URLPackage uRLPackage = this.f72067c.get(str);
                int size = this.f72067c.size();
                for (int i2 = 0; uRLPackage != null && !(uRLPackage instanceof EntryPackage) && i2 < size; i2++) {
                    String str2 = uRLPackage.identity;
                    if (TextUtils.isEmpty(str2)) {
                        break;
                    }
                    uRLPackage = this.f72067c.get(str2);
                }
                if (uRLPackage instanceof EntryPackage) {
                    return (EntryPackage) uRLPackage;
                }
            }
            return this.f72070f;
        }
        return (EntryPackage) invokeL.objValue;
    }
}
