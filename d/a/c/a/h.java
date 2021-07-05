package d.a.c.a;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static h f43868d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Resources f43869a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<String> f43870b;

    /* renamed from: c  reason: collision with root package name */
    public HashSet<String> f43871c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1754304654, "Ld/a/c/a/h;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1754304654, "Ld/a/c/a/h;");
        }
    }

    public h() {
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
        this.f43869a = null;
        this.f43870b = null;
        this.f43871c = null;
    }

    public static h a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f43868d == null) {
                synchronized (h.class) {
                    if (f43868d == null) {
                        f43868d = new h();
                    }
                }
            }
            return f43868d;
        }
        return (h) invokeV.objValue;
    }

    public synchronized Resources b() {
        InterceptResult invokeV;
        Resources resources;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                resources = this.f43869a;
            }
            return resources;
        }
        return (Resources) invokeV.objValue;
    }

    public synchronized void c(String str, String str2) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            synchronized (this) {
                if (!TextUtils.isEmpty(str2)) {
                    if (this.f43869a != null) {
                        if (!TextUtils.isEmpty(str)) {
                            if (this.f43871c == null) {
                                this.f43871c = new HashSet<>();
                            }
                            if (this.f43871c.contains(str)) {
                                d.a.c.h.h.a.b().o("plugin_load", "repeat_inject_res", str, str2);
                            }
                            this.f43871c.add(str);
                        }
                        if (this.f43870b == null) {
                            this.f43870b = new ArrayList<>();
                        }
                        if (this.f43870b.contains(str2)) {
                            return;
                        }
                        if (Build.VERSION.SDK_INT >= 20) {
                            d.a.c.h.k.d.a(this.f43869a.getAssets(), V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Object[]{str2});
                        } else {
                            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                            if (this.f43870b.size() > 0) {
                                Iterator<String> it = this.f43870b.iterator();
                                while (it.hasNext()) {
                                    d.a.c.h.k.d.a(assetManager, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Object[]{it.next()});
                                }
                            }
                            d.a.c.h.k.d.a(assetManager, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Object[]{str2});
                            d.a.c.h.k.d.a(assetManager, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Object[]{BdBaseApplication.getInst().getApp().getPackageCodePath()});
                            this.f43869a = new Resources(assetManager, this.f43869a.getDisplayMetrics(), this.f43869a.getConfiguration());
                        }
                        this.f43870b.add(str2);
                        return;
                    }
                    throw new RuntimeException("hostResources is null");
                }
                throw new IllegalArgumentException("param resPath is null");
            }
        }
    }

    public synchronized void d(Resources resources) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, resources) == null) {
            synchronized (this) {
                this.f43869a = resources;
            }
        }
    }
}
