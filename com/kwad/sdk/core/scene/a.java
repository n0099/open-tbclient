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
    public static a f71865a;

    /* renamed from: b  reason: collision with root package name */
    public static Object f71866b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, URLPackage> f71867c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, URLPackage> f71868d;

    /* renamed from: e  reason: collision with root package name */
    public final URLPackage f71869e;

    /* renamed from: f  reason: collision with root package name */
    public final EntryPackage f71870f;

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
        f71866b = new Object();
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
        this.f71867c = new HashMap<>();
        this.f71868d = new HashMap<>();
        this.f71869e = new URLPackage("", 0);
        this.f71870f = new EntryPackage("", 0);
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f71865a == null) {
                synchronized (f71866b) {
                    if (f71865a == null) {
                        f71865a = new a();
                    }
                }
            }
            return f71865a;
        }
        return (a) invokeV.objValue;
    }

    @Nullable
    public URLPackage a(@NonNull String str) {
        InterceptResult invokeL;
        URLPackage uRLPackage;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? (TextUtils.isEmpty(str) || (uRLPackage = this.f71867c.get(str)) == null || (uRLPackage instanceof EntryPackage)) ? this.f71869e : uRLPackage : (URLPackage) invokeL.objValue;
    }

    public EntryPackage b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                URLPackage uRLPackage = this.f71867c.get(str);
                int size = this.f71867c.size();
                for (int i2 = 0; uRLPackage != null && !(uRLPackage instanceof EntryPackage) && i2 < size; i2++) {
                    String str2 = uRLPackage.identity;
                    if (TextUtils.isEmpty(str2)) {
                        break;
                    }
                    uRLPackage = this.f71867c.get(str2);
                }
                if (uRLPackage instanceof EntryPackage) {
                    return (EntryPackage) uRLPackage;
                }
            }
            return this.f71870f;
        }
        return (EntryPackage) invokeL.objValue;
    }
}
