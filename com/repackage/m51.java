package com.repackage;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.WebView;
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
import java.util.concurrent.CountDownLatch;
/* loaded from: classes6.dex */
public class m51 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BundleInfo a;
    public n51 b;
    public boolean c;
    public o51 d;

    public m51(BundleInfo bundleInfo) {
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
        this.c = false;
        this.d = null;
        if (a(bundleInfo)) {
            this.a = bundleInfo;
            return;
        }
        throw new InitException(22, "bad param bundleInfo:" + bundleInfo.toString());
    }

    public static m51 b(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bundleInfo)) == null) {
            m51 m51Var = new m51(bundleInfo);
            m51Var.d();
            return m51Var;
        }
        return (m51) invokeL.objValue;
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
            return s51.d(applicationContext, sb.toString()).exists();
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
                if (!f()) {
                    throw new InitException(20, "resources init error");
                }
                return;
            }
            throw new InitException(16, "class loader init error");
        }
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Application applicationContext = ContextHolder.getApplicationContext();
            this.b = new n51(s51.d(applicationContext, this.a.getPackageName() + Constant.FILE.SUFFIX.BUNDLE_SUFFIX).getAbsolutePath(), s51.f(applicationContext, this.a.getPackageName()).getAbsolutePath(), s51.e(applicationContext, this.a.getPackageName()).getAbsolutePath(), applicationContext);
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
                    Resources a = y41.c().a();
                    Resources b = y41.c().b();
                    Resources[] d = y41.c().d();
                    if (!this.c) {
                        g(applicationContext);
                        this.c = true;
                    }
                    String absolutePath = s51.d(applicationContext, this.a.getPackageName() + Constant.FILE.SUFFIX.BUNDLE_SUFFIX).getAbsolutePath();
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

    public final void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                c51.a().c();
                try {
                    new WebView(context);
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            new p51(context, countDownLatch).sendMessage(Message.obtain());
            try {
                countDownLatch.await();
            } catch (Exception unused2) {
            }
        }
    }

    public synchronized Resources getResources(Resources resources) {
        InterceptResult invokeL;
        o51 o51Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, resources)) == null) {
            synchronized (this) {
                Application applicationContext = ContextHolder.getApplicationContext();
                String absolutePath = s51.d(applicationContext, this.a.getPackageName() + Constant.FILE.SUFFIX.BUNDLE_SUFFIX).getAbsolutePath();
                AssetManager assets = resources.getAssets();
                if (ResourcesHookUtil.hookAssets(assets, absolutePath)) {
                    if (this.d == null || this.d.getAssets().hashCode() != assets.hashCode()) {
                        this.d = new o51(assets, resources.getDisplayMetrics(), resources.getConfiguration(), resources);
                    }
                    o51Var = this.d;
                } else {
                    throw new InitException(21, "resources hook error");
                }
            }
            return o51Var;
        }
        return (Resources) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? super.toString() : (String) invokeV.objValue;
    }
}
