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
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static a f36579a;

    /* renamed from: b  reason: collision with root package name */
    public static Object f36580b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, URLPackage> f36581c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, URLPackage> f36582d;

    /* renamed from: e  reason: collision with root package name */
    public URLPackage f36583e;

    /* renamed from: f  reason: collision with root package name */
    public final URLPackage f36584f;

    /* renamed from: g  reason: collision with root package name */
    public final EntryPackage f36585g;

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
        f36580b = new Object();
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
        this.f36581c = new HashMap<>();
        this.f36582d = new HashMap<>();
        this.f36584f = new URLPackage("", 0);
        this.f36585g = new EntryPackage("", 0);
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f36579a == null) {
                synchronized (f36580b) {
                    if (f36579a == null) {
                        f36579a = new a();
                    }
                }
            }
            return f36579a;
        }
        return (a) invokeV.objValue;
    }

    private void a(String str, @NonNull URLPackage uRLPackage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, this, str, uRLPackage) == null) || this.f36581c.containsKey(str)) {
            return;
        }
        this.f36581c.put(str, uRLPackage);
    }

    @Nullable
    public URLPackage a(@NonNull String str) {
        InterceptResult invokeL;
        URLPackage uRLPackage;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? (TextUtils.isEmpty(str) || (uRLPackage = this.f36581c.get(str)) == null || (uRLPackage instanceof EntryPackage)) ? this.f36584f : uRLPackage : (URLPackage) invokeL.objValue;
    }

    public void a(@NonNull SceneImpl sceneImpl) {
        URLPackage urlPackage;
        String str;
        URLPackage uRLPackage;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sceneImpl) == null) || (urlPackage = sceneImpl.getUrlPackage()) == null) {
            return;
        }
        this.f36582d.put(urlPackage.identity, urlPackage);
        URLPackage uRLPackage2 = this.f36583e;
        if (uRLPackage2 != null) {
            if (!urlPackage.identity.equals(uRLPackage2.identity)) {
                str = urlPackage.identity;
                uRLPackage = this.f36583e;
            }
            this.f36583e = urlPackage;
        }
        str = urlPackage.identity;
        uRLPackage = this.f36584f;
        a(str, uRLPackage);
        this.f36583e = urlPackage;
    }

    public void a(String str, SceneImpl sceneImpl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, sceneImpl) == null) {
            a(str, "", sceneImpl);
        }
    }

    public void a(String str, String str2, SceneImpl sceneImpl) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, sceneImpl) == null) || str == null || sceneImpl == null || sceneImpl.getUrlPackage() == null) {
            return;
        }
        EntryPackage entryPackage = new EntryPackage();
        entryPackage.entryPageSource = str;
        entryPackage.entryId = str2;
        a(sceneImpl.getUrlPackage().identity, entryPackage);
    }

    public EntryPackage b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                URLPackage uRLPackage = this.f36581c.get(str);
                int size = this.f36581c.size();
                for (int i2 = 0; uRLPackage != null && !(uRLPackage instanceof EntryPackage) && i2 < size; i2++) {
                    String str2 = uRLPackage.identity;
                    if (TextUtils.isEmpty(str2)) {
                        break;
                    }
                    uRLPackage = this.f36581c.get(str2);
                }
                if (uRLPackage instanceof EntryPackage) {
                    return (EntryPackage) uRLPackage;
                }
            }
            return this.f36585g;
        }
        return (EntryPackage) invokeL.objValue;
    }

    public void c(@NonNull String str) {
        URLPackage uRLPackage;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f36582d.remove(str);
            if (this.f36582d.size() == 0 && (uRLPackage = this.f36583e) != null && uRLPackage.identity.equals(str)) {
                this.f36583e = null;
            }
        }
    }
}
