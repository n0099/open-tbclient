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
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.o;
import com.kwai.sodler.lib.a.g;
import com.kwai.sodler.lib.ext.PluginError;
import java.io.File;
/* loaded from: classes8.dex */
public final class e implements com.kwai.sodler.lib.a.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g.a axk;
    public final Context mContext;

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
        this.mContext = context.getApplicationContext();
    }

    @TargetApi(11)
    private void a(int i, @NonNull com.kwai.sodler.lib.a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65537, this, i, fVar) == null) {
            if (i == 0) {
                com.kwai.sodler.lib.c.b k = f.k(fVar);
                if (k != null) {
                    StringBuilder sb = new StringBuilder("Download new plugin, version = ");
                    sb.append(k.version);
                    sb.append(", url = ");
                    sb.append(k.ayA);
                    fVar.cG(3);
                    fVar.fa(k.ayA);
                    fVar.ad(k.ayB);
                    fVar.eZ(k.ayC);
                    fVar.eT(k.version);
                    return;
                }
            } else if (i != -1) {
                return;
            }
            fVar.cG(-3);
        }
    }

    public static void a(com.kwai.sodler.lib.a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, fVar) == null) {
            new StringBuilder("onCanceled state = ").append(fVar.getState());
            fVar.cG(-7);
            fVar.Fk().Fc().o(fVar);
        }
    }

    private void a(com.kwai.sodler.lib.a.f fVar, PluginError.UpdateError updateError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, fVar, updateError) == null) {
            new StringBuilder("onError state = ").append(fVar.getState());
            fVar.cG(-4);
            fVar.q(updateError);
            fVar.Fx();
            b(fVar);
        }
    }

    private void a(com.kwai.sodler.lib.a.f fVar, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, fVar, file) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            Log.v("Sodler.update", "start download:" + fVar.getId());
            g.a aVar = this.axk;
            if (aVar == null) {
                throw new PluginError.UpdateError("update ", 2008);
            }
            aVar.a(fVar, file);
            Log.v("Sodler.update", "finish download:" + fVar.getId() + " cost:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public static void b(com.kwai.sodler.lib.a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, fVar) == null) {
            new StringBuilder("onPostUpdate state = ").append(fVar.getState());
            fVar.Fk().Fc().q(fVar);
        }
    }

    public static void c(com.kwai.sodler.lib.a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, fVar) == null) {
            new StringBuilder("onPreUpdate state = ").append(fVar.getState());
            fVar.Fk().Fc().p(fVar);
        }
    }

    private com.kwai.sodler.lib.a.f j(com.kwai.sodler.lib.a.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, fVar)) == null) {
            if (fVar.Fo()) {
                fVar.Fk().Fa().eO(fVar.getId());
            }
            try {
                if (fVar.Fv() == null) {
                    fVar.Fk().Fb().e(fVar);
                }
            } catch (Exception e) {
                a.w("Sodler.update", "Request remote plugin info fail, error = " + e.toString());
                a.e("Sodler.update", e);
                fVar.cG(-2);
                fVar.q(new PluginError.UpdateError(e, 2006));
            }
            if (TextUtils.isEmpty(fVar.getId())) {
                a(-1, fVar);
                return fVar;
            }
            a(0, fVar);
            return fVar;
        }
        return (com.kwai.sodler.lib.a.f) invokeL.objValue;
    }

    @Override // com.kwai.sodler.lib.a.g
    public final com.kwai.sodler.lib.a.g b(g.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            this.axk = aVar;
            return this;
        }
        return (com.kwai.sodler.lib.a.g) invokeL.objValue;
    }

    @Override // com.kwai.sodler.lib.a.g
    public final com.kwai.sodler.lib.a.f i(@NonNull com.kwai.sodler.lib.a.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) {
            new StringBuilder("Start update, id = ").append(fVar.getId());
            fVar.eW("Update");
            c(fVar);
            j(fVar);
            if (fVar.isCanceled()) {
                a(fVar);
                return fVar;
            } else if (fVar.getState() == 2) {
                try {
                    fVar.Fk().Fa().ES();
                    try {
                        File e = fVar.Fk().Fa().e(fVar.getDownloadUrl(), false);
                        if (fVar.isCanceled()) {
                            a(fVar);
                            return fVar;
                        }
                        try {
                            o.a(this.mContext, null, e);
                            fVar.eX(e.getAbsolutePath());
                            fVar.cG(1);
                            b(fVar);
                            return fVar;
                        } catch (Throwable th) {
                            a.e("Sodler.update", th);
                            a(fVar, new PluginError.UpdateError(th, 2004));
                            return fVar;
                        }
                    } catch (Throwable th2) {
                        new StringBuilder("Can not get temp file, error = ").append(th2.getLocalizedMessage());
                        a.e("Sodler.update", th2);
                        a(fVar, new PluginError.UpdateError(th2, 2003));
                        return fVar;
                    }
                } catch (Throwable th3) {
                    a.e("Sodler.update", th3);
                    a(fVar, new PluginError.UpdateError(th3, 2005));
                    return fVar;
                }
            } else if (fVar.getState() != 3) {
                b(fVar);
                return fVar;
            } else {
                try {
                    fVar.Fk().Fa().ES();
                    try {
                        File e2 = fVar.Fk().Fa().e(fVar.getDownloadUrl(), fVar.Fk().EX().FF());
                        if (fVar.Ft() != null && e2.exists() && TextUtils.equals(ab.Y(e2), fVar.Ft())) {
                            fVar.eX(e2.getAbsolutePath());
                            fVar.cG(1);
                            b(fVar);
                            return fVar;
                        }
                        try {
                            a(fVar, e2);
                            fVar.eX(e2.getAbsolutePath());
                            fVar.cG(1);
                            b(fVar);
                            return fVar;
                        } catch (PluginError.CancelError unused) {
                            a(fVar);
                            return fVar;
                        } catch (PluginError.UpdateError e3) {
                            new StringBuilder("Download plugin fail, error = ").append(e3.getLocalizedMessage());
                            a.e("Sodler.update", e3);
                            fVar.q(e3);
                            a(fVar, e3);
                            return fVar;
                        }
                    } catch (Throwable th4) {
                        new StringBuilder("Can not get temp file, error = ").append(th4.getLocalizedMessage());
                        a.e("Sodler.update", th4);
                        a(fVar, new PluginError.UpdateError(th4, 2003));
                        return fVar;
                    }
                } catch (Throwable th5) {
                    a.e("Sodler.update", th5);
                    a(fVar, new PluginError.UpdateError(th5, 2005));
                    return fVar;
                }
            }
        }
        return (com.kwai.sodler.lib.a.f) invokeL.objValue;
    }
}
