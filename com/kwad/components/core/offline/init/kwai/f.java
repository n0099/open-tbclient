package com.kwad.components.core.offline.init.kwai;

import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.offline.api.core.IOfflineHostApi;
import com.kwad.components.offline.api.core.api.IAsync;
import com.kwad.components.offline.api.core.api.ICrash;
import com.kwad.components.offline.api.core.api.IDownloader;
import com.kwad.components.offline.api.core.api.IEncrypt;
import com.kwad.components.offline.api.core.api.IEnvironment;
import com.kwad.components.offline.api.core.api.IImageLoader;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.core.api.INet;
import com.kwad.components.offline.api.core.api.IOfflineCompoLogcat;
import com.kwad.components.offline.api.core.api.IZipper;
import com.kwad.sdk.core.report.k;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class f implements IOfflineHostApi {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IAsync a;
    public IEnvironment b;
    public IZipper c;
    public INet d;
    public IEncrypt e;
    public IOfflineCompoLogcat f;
    public ICrash g;
    public ILoggerReporter h;
    public IDownloader i;
    public IImageLoader j;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IAsync async() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.a == null) {
                this.a = new a();
            }
            return this.a;
        }
        return (IAsync) invokeV.objValue;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ICrash crash() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.g == null) {
                this.g = new ICrash(this) { // from class: com.kwad.components.core.offline.init.kwai.f.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ f a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // com.kwad.components.offline.api.core.api.ICrash
                    public final void gatherException(Throwable th) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, th) == null) {
                            com.kwad.sdk.service.a.a(th);
                        }
                    }
                };
            }
            return this.g;
        }
        return (ICrash) invokeV.objValue;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IDownloader downloader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.i == null) {
                this.i = new IDownloader(this) { // from class: com.kwad.components.core.offline.init.kwai.f.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ f a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // com.kwad.components.offline.api.core.api.IDownloader
                    @WorkerThread
                    public final boolean downloadSync(File file, String str) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, file, str)) == null) ? com.kwad.sdk.core.download.a.a(str, file) : invokeLL.booleanValue;
                    }
                };
            }
            return this.i;
        }
        return (IDownloader) invokeV.objValue;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IEncrypt encrypt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.e == null) {
                this.e = new b();
            }
            return this.e;
        }
        return (IEncrypt) invokeV.objValue;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IEnvironment env() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.b == null) {
                this.b = new c();
            }
            return this.b;
        }
        return (IEnvironment) invokeV.objValue;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IImageLoader imageLoader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.j == null) {
                this.j = new d();
            }
            return this.j;
        }
        return (IImageLoader) invokeV.objValue;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IOfflineCompoLogcat log() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f == null) {
                this.f = new g();
            }
            return this.f;
        }
        return (IOfflineCompoLogcat) invokeV.objValue;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ILoggerReporter loggerReporter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.h == null) {
                this.h = new ILoggerReporter(this) { // from class: com.kwad.components.core.offline.init.kwai.f.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ f a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // com.kwad.components.offline.api.core.api.ILoggerReporter
                    public final void reportEvent(String str, BusinessType businessType, String str2, JSONObject jSONObject) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLLLL(1048576, this, str, businessType, str2, jSONObject) == null) {
                            k.a(str, businessType, str2, jSONObject);
                        }
                    }

                    @Override // com.kwad.components.offline.api.core.api.ILoggerReporter
                    public final void reportEventWithRatio(float f, String str, BusinessType businessType, String str2, JSONObject jSONObject) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), str, businessType, str2, jSONObject}) == null) {
                            k.a(f, str, businessType, com.kwai.adclient.kscommerciallogger.model.d.t, str2, jSONObject);
                        }
                    }
                };
            }
            return this.h;
        }
        return (ILoggerReporter) invokeV.objValue;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final INet net() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.d == null) {
                this.d = new e();
            }
            return this.d;
        }
        return (INet) invokeV.objValue;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IZipper zipper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.c == null) {
                this.c = new i();
            }
            return this.c;
        }
        return (IZipper) invokeV.objValue;
    }
}
