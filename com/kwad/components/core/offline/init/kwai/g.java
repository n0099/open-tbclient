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
import com.kwad.components.offline.api.core.api.ICache;
import com.kwad.components.offline.api.core.api.ICrash;
import com.kwad.components.offline.api.core.api.IDownloader;
import com.kwad.components.offline.api.core.api.IEncrypt;
import com.kwad.components.offline.api.core.api.IEnvironment;
import com.kwad.components.offline.api.core.api.IImageLoader;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.core.api.INet;
import com.kwad.components.offline.api.core.api.IOfflineCompoLogcat;
import com.kwad.components.offline.api.core.api.IZipper;
import com.kwad.components.offline.api.core.video.IVideo;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.report.k;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.SubBusinessType;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class g implements IOfflineHostApi {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IAsync EP;
    public IEnvironment EQ;
    public IZipper ER;
    public INet ES;
    public IEncrypt ET;
    public IOfflineCompoLogcat EU;
    public ICrash EV;
    public ILoggerReporter EW;
    public IDownloader EX;
    public IImageLoader EY;
    public IVideo EZ;
    public ICache Fa;

    public g() {
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
            if (this.EP == null) {
                this.EP = new a();
            }
            return this.EP;
        }
        return (IAsync) invokeV.objValue;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ICache cache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.Fa == null) {
                this.Fa = new b();
            }
            return this.Fa;
        }
        return (ICache) invokeV.objValue;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ICrash crash() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.EV == null) {
                this.EV = new ICrash(this) { // from class: com.kwad.components.core.offline.init.kwai.g.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ g Fb;

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
                        this.Fb = this;
                    }

                    @Override // com.kwad.components.offline.api.core.api.ICrash
                    public final void gatherException(Throwable th) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, th) == null) {
                            com.kwad.sdk.service.a.gatherException(th);
                        }
                    }
                };
            }
            return this.EV;
        }
        return (ICrash) invokeV.objValue;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IDownloader downloader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.EX == null) {
                this.EX = new IDownloader(this) { // from class: com.kwad.components.core.offline.init.kwai.g.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ g Fb;

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
                        this.Fb = this;
                    }

                    @Override // com.kwad.components.offline.api.core.api.IDownloader
                    @WorkerThread
                    public final boolean downloadSync(File file, String str) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, file, str)) == null) ? com.kwad.sdk.core.download.a.c(str, file) : invokeLL.booleanValue;
                    }
                };
            }
            return this.EX;
        }
        return (IDownloader) invokeV.objValue;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IEncrypt encrypt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.ET == null) {
                this.ET = new c();
            }
            return this.ET;
        }
        return (IEncrypt) invokeV.objValue;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IEnvironment env() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.EQ == null) {
                this.EQ = new d();
            }
            return this.EQ;
        }
        return (IEnvironment) invokeV.objValue;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IImageLoader imageLoader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.EY == null) {
                this.EY = new e();
            }
            return this.EY;
        }
        return (IImageLoader) invokeV.objValue;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IOfflineCompoLogcat log() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.EU == null) {
                this.EU = new h();
            }
            return this.EU;
        }
        return (IOfflineCompoLogcat) invokeV.objValue;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ILoggerReporter loggerReporter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.EW == null) {
                this.EW = new ILoggerReporter(this) { // from class: com.kwad.components.core.offline.init.kwai.g.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ g Fb;

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
                        this.Fb = this;
                    }

                    @Override // com.kwad.components.offline.api.core.api.ILoggerReporter
                    public final void reportEvent(double d, String str, BusinessType businessType, String str2, JSONObject jSONObject) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Double.valueOf(d), str, businessType, str2, jSONObject}) == null) {
                            k.a(d, str, businessType, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.d.asl, str2, jSONObject);
                        }
                    }
                };
            }
            return this.EW;
        }
        return (ILoggerReporter) invokeV.objValue;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final INet net() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.ES == null) {
                this.ES = new f();
            }
            return this.ES;
        }
        return (INet) invokeV.objValue;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final float tkLoggerSamplingRate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? com.kwad.sdk.core.config.d.aX(KsAdSDKImpl.get().getContext()) : invokeV.floatValue;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IVideo video() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.EZ == null) {
                this.EZ = new com.kwad.components.core.offline.init.a.e();
            }
            return this.EZ;
        }
        return (IVideo) invokeV.objValue;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IZipper zipper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.ER == null) {
                this.ER = new j();
            }
            return this.ER;
        }
        return (IZipper) invokeV.objValue;
    }
}
