package com.repackage;

import android.app.Application;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.runtime.InitException;
import com.baidu.nps.runtime.resources.ResourcesHookUtil;
import com.baidu.nps.utils.Constant;
import com.baidu.nps.utils.ContextHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class i61 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BundleInfo a;
    public j61 b;
    public k61 c;

    public i61(BundleInfo bundleInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bundleInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = null;
        if (a(bundleInfo)) {
            this.a = bundleInfo;
            return;
        }
        e61.j().s(bundleInfo);
        throw new InitException(22, "bad param bundleInfo:" + bundleInfo.toString());
    }

    public static i61 b(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bundleInfo)) == null) {
            i61 i61Var = new i61(bundleInfo);
            i61Var.d();
            return i61Var;
        }
        return (i61) invokeL.objValue;
    }

    public final boolean a(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundleInfo)) == null) {
            if (bundleInfo == null || TextUtils.isEmpty(bundleInfo.getPackageName())) {
                return false;
            }
            Application applicationContext = ContextHolder.getApplicationContext();
            StringBuilder sb = new StringBuilder();
            sb.append(bundleInfo.getPackageName());
            sb.append(Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
            return r61.d(applicationContext, sb.toString()).exists();
        }
        return invokeL.booleanValue;
    }

    public ClassLoader c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (ClassLoader) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (e()) {
                if (Build.VERSION.SDK_INT < 21) {
                    if (!g()) {
                        throw new InitException(20, "resources init error");
                    }
                    return;
                } else if (!f()) {
                    throw new InitException(20, "resources init error");
                } else {
                    return;
                }
            }
            throw new InitException(16, "class loader init error");
        }
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Application applicationContext = ContextHolder.getApplicationContext();
            this.b = new j61(r61.d(applicationContext, this.a.getPackageName() + Constant.FILE.SUFFIX.BUNDLE_SUFFIX).getAbsolutePath(), r61.f(applicationContext, this.a.getPackageName()).getAbsolutePath(), r61.e(applicationContext, this.a.getPackageName()).getAbsolutePath(), applicationContext);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final synchronized boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                try {
                    Application applicationContext = ContextHolder.getApplicationContext();
                    Resources a = t51.c().a();
                    Resources b = t51.c().b();
                    Resources[] d = t51.c().d();
                    m61.a().b(applicationContext);
                    String absolutePath = r61.d(applicationContext, this.a.getPackageName() + Constant.FILE.SUFFIX.BUNDLE_SUFFIX).getAbsolutePath();
                    ResourcesHookUtil.hookResources(a, absolutePath);
                    ResourcesHookUtil.hookResources(b, absolutePath);
                    if (d != null) {
                        for (Resources resources : d) {
                            ResourcesHookUtil.hookResources(resources, absolutePath);
                        }
                    }
                } catch (Exception unused) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final synchronized boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                Application applicationContext = ContextHolder.getApplicationContext();
                String absolutePath = r61.d(applicationContext, this.a.getPackageName() + Constant.FILE.SUFFIX.BUNDLE_SUFFIX).getAbsolutePath();
                String str = applicationContext.getApplicationInfo().sourceDir;
                try {
                    AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                    ResourcesHookUtil.hookAssets(assetManager, absolutePath);
                    ResourcesHookUtil.hookAssets(assetManager, str);
                    Resources a = t51.c().a();
                    this.c = new k61(assetManager, a.getDisplayMetrics(), a.getConfiguration(), a);
                } catch (Exception e) {
                    if (q61.a()) {
                        Log.e("Runtime", "resource", e);
                        return false;
                    }
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public synchronized Resources getResources(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, resources)) == null) {
            synchronized (this) {
                if (Build.VERSION.SDK_INT < 21) {
                    return this.c;
                }
                Application applicationContext = ContextHolder.getApplicationContext();
                String absolutePath = r61.d(applicationContext, this.a.getPackageName() + Constant.FILE.SUFFIX.BUNDLE_SUFFIX).getAbsolutePath();
                AssetManager assets = resources.getAssets();
                if (ResourcesHookUtil.hookAssets(assets, absolutePath)) {
                    if (this.c == null || this.c.getAssets().hashCode() != assets.hashCode()) {
                        this.c = new k61(assets, resources.getDisplayMetrics(), resources.getConfiguration(), resources);
                    }
                    return this.c;
                }
                throw new InitException(21, "resources hook error");
            }
        }
        return (Resources) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? super.toString() : (String) invokeV.objValue;
    }
}
