package com.kwai.sodler.lib;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.o;
import com.kwad.sdk.utils.z;
import com.kwai.sodler.lib.a.g;
import com.kwai.sodler.lib.ext.PluginError;
import java.io.File;
/* loaded from: classes5.dex */
public final class e implements com.kwai.sodler.lib.a.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public g.a b;

    public e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context.getApplicationContext();
    }

    @TargetApi(11)
    private void a(int i, @NonNull com.kwai.sodler.lib.a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65537, this, i, fVar) == null) {
            if (i == 0) {
                com.kwai.sodler.lib.c.b a = f.a(fVar);
                if (a != null) {
                    StringBuilder sb = new StringBuilder("Download new plugin, version = ");
                    sb.append(a.b);
                    sb.append(", url = ");
                    sb.append(a.c);
                    fVar.a(3);
                    fVar.f(a.c);
                    fVar.a(a.d);
                    fVar.e(a.f);
                    fVar.a(a.b);
                    return;
                }
            } else if (i != -1) {
                return;
            }
            fVar.a(-3);
        }
    }

    private void a(com.kwai.sodler.lib.a.f fVar, PluginError.UpdateError updateError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, fVar, updateError) == null) {
            new StringBuilder("onError state = ").append(fVar.c());
            fVar.a(-4);
            fVar.a(updateError);
            fVar.t();
            d(fVar);
        }
    }

    private void a(com.kwai.sodler.lib.a.f fVar, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, fVar, file) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            Log.v("Sodler.update", "start download:" + fVar.i());
            g.a aVar = this.b;
            if (aVar == null) {
                throw new PluginError.UpdateError("update ", 2008);
            }
            aVar.a(fVar, file);
            Log.v("Sodler.update", "finish download:" + fVar.i() + " cost:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public static void b(com.kwai.sodler.lib.a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, fVar) == null) {
            new StringBuilder("onPreUpdate state = ").append(fVar.c());
            fVar.b().h().b(fVar);
        }
    }

    public static void c(com.kwai.sodler.lib.a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, fVar) == null) {
            new StringBuilder("onCanceled state = ").append(fVar.c());
            fVar.a(-7);
            fVar.b().h().a(fVar);
        }
    }

    public static void d(com.kwai.sodler.lib.a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, fVar) == null) {
            new StringBuilder("onPostUpdate state = ").append(fVar.c());
            fVar.b().h().c(fVar);
        }
    }

    private com.kwai.sodler.lib.a.f e(com.kwai.sodler.lib.a.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, fVar)) == null) {
            if (fVar.j()) {
                fVar.b().f().a(fVar.i());
            }
            try {
                if (fVar.r() == null) {
                    fVar.b().g().a(fVar);
                }
            } catch (Exception e) {
                a.b("Sodler.update", "Request remote plugin info fail, error = " + e.toString());
                a.a("Sodler.update", e);
                fVar.a(-2);
                fVar.a(new PluginError.UpdateError(e, 2006));
            }
            if (TextUtils.isEmpty(fVar.i())) {
                a(-1, fVar);
                return fVar;
            }
            a(0, fVar);
            return fVar;
        }
        return (com.kwai.sodler.lib.a.f) invokeL.objValue;
    }

    @Override // com.kwai.sodler.lib.a.g
    public final com.kwai.sodler.lib.a.f a(@NonNull com.kwai.sodler.lib.a.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
            new StringBuilder("Start update, id = ").append(fVar.i());
            fVar.b("Update");
            b(fVar);
            e(fVar);
            if (fVar.f()) {
                c(fVar);
                return fVar;
            } else if (fVar.c() == 2) {
                try {
                    fVar.b().f().a();
                    try {
                        File a = fVar.b().f().a(fVar.p(), false);
                        if (fVar.f()) {
                            c(fVar);
                            return fVar;
                        }
                        try {
                            o.a(this.a, (String) null, a);
                            fVar.c(a.getAbsolutePath());
                            fVar.a(1);
                            d(fVar);
                            return fVar;
                        } catch (Throwable th) {
                            a.a("Sodler.update", th);
                            a(fVar, new PluginError.UpdateError(th, 2004));
                            return fVar;
                        }
                    } catch (Throwable th2) {
                        new StringBuilder("Can not get temp file, error = ").append(th2.getLocalizedMessage());
                        a.a("Sodler.update", th2);
                        a(fVar, new PluginError.UpdateError(th2, 2003));
                        return fVar;
                    }
                } catch (Throwable th3) {
                    a.a("Sodler.update", th3);
                    a(fVar, new PluginError.UpdateError(th3, 2005));
                    return fVar;
                }
            } else if (fVar.c() != 3) {
                d(fVar);
                return fVar;
            } else {
                try {
                    fVar.b().f().a();
                    try {
                        File a2 = fVar.b().f().a(fVar.p(), fVar.b().c().i());
                        if (fVar.o() != null && a2.exists() && TextUtils.equals(z.a(a2), fVar.o())) {
                            fVar.c(a2.getAbsolutePath());
                            fVar.a(1);
                            d(fVar);
                            return fVar;
                        }
                        try {
                            a(fVar, a2);
                            fVar.c(a2.getAbsolutePath());
                            fVar.a(1);
                            d(fVar);
                            return fVar;
                        } catch (PluginError.CancelError unused) {
                            c(fVar);
                            return fVar;
                        } catch (PluginError.UpdateError e) {
                            new StringBuilder("Download plugin fail, error = ").append(e.getLocalizedMessage());
                            a.a("Sodler.update", e);
                            fVar.a(e);
                            a(fVar, e);
                            return fVar;
                        }
                    } catch (Throwable th4) {
                        new StringBuilder("Can not get temp file, error = ").append(th4.getLocalizedMessage());
                        a.a("Sodler.update", th4);
                        a(fVar, new PluginError.UpdateError(th4, 2003));
                        return fVar;
                    }
                } catch (Throwable th5) {
                    a.a("Sodler.update", th5);
                    a(fVar, new PluginError.UpdateError(th5, 2005));
                    return fVar;
                }
            }
        }
        return (com.kwai.sodler.lib.a.f) invokeL.objValue;
    }

    @Override // com.kwai.sodler.lib.a.g
    public final com.kwai.sodler.lib.a.g a(g.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            this.b = aVar;
            return this;
        }
        return (com.kwai.sodler.lib.a.g) invokeL.objValue;
    }
}
