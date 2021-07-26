package d.a.d.a;

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
/* loaded from: classes7.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static h f41388d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Resources f41389a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<String> f41390b;

    /* renamed from: c  reason: collision with root package name */
    public HashSet<String> f41391c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1725675503, "Ld/a/d/a/h;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1725675503, "Ld/a/d/a/h;");
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
        this.f41389a = null;
        this.f41390b = null;
        this.f41391c = null;
    }

    public static h a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f41388d == null) {
                synchronized (h.class) {
                    if (f41388d == null) {
                        f41388d = new h();
                    }
                }
            }
            return f41388d;
        }
        return (h) invokeV.objValue;
    }

    public synchronized Resources b() {
        InterceptResult invokeV;
        Resources resources;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                resources = this.f41389a;
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
                    if (this.f41389a != null) {
                        if (!TextUtils.isEmpty(str)) {
                            if (this.f41391c == null) {
                                this.f41391c = new HashSet<>();
                            }
                            if (this.f41391c.contains(str)) {
                                d.a.d.h.h.a.b().o("plugin_load", "repeat_inject_res", str, str2);
                            }
                            this.f41391c.add(str);
                        }
                        if (this.f41390b == null) {
                            this.f41390b = new ArrayList<>();
                        }
                        if (this.f41390b.contains(str2)) {
                            return;
                        }
                        if (Build.VERSION.SDK_INT >= 20) {
                            d.a.d.h.k.d.a(this.f41389a.getAssets(), V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Object[]{str2});
                        } else {
                            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                            if (this.f41390b.size() > 0) {
                                Iterator<String> it = this.f41390b.iterator();
                                while (it.hasNext()) {
                                    d.a.d.h.k.d.a(assetManager, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Object[]{it.next()});
                                }
                            }
                            d.a.d.h.k.d.a(assetManager, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Object[]{str2});
                            d.a.d.h.k.d.a(assetManager, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Object[]{BdBaseApplication.getInst().getApp().getPackageCodePath()});
                            this.f41389a = new Resources(assetManager, this.f41389a.getDisplayMetrics(), this.f41389a.getConfiguration());
                        }
                        this.f41390b.add(str2);
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
                this.f41389a = resources;
            }
        }
    }
}
