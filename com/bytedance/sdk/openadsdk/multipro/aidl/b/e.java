package com.bytedance.sdk.openadsdk.multipro.aidl.b;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.ITTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
/* loaded from: classes9.dex */
public class e extends ITTAppDownloadListener.Stub {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile TTAppDownloadListener f68432a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f68433b;

    public e(TTAppDownloadListener tTAppDownloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tTAppDownloadListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68433b = new Handler(Looper.getMainLooper());
        this.f68432a = tTAppDownloadListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? this.f68432a != null : invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onDownloadActive(long j2, long j3, String str, String str2) throws RemoteException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2}) == null) || this.f68432a == null) {
            return;
        }
        b().post(new Runnable(this, j2, j3, str, str2) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f68435a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f68436b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f68437c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f68438d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f68439e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Long.valueOf(j2), Long.valueOf(j3), str, str2};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f68439e = this;
                this.f68435a = j2;
                this.f68436b = j3;
                this.f68437c = str;
                this.f68438d = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f68439e.c()) {
                    this.f68439e.f68432a.onDownloadActive(this.f68435a, this.f68436b, this.f68437c, this.f68438d);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onDownloadFailed(long j2, long j3, String str, String str2) throws RemoteException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2}) == null) || this.f68432a == null) {
            return;
        }
        b().post(new Runnable(this, j2, j3, str, str2) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f68445a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f68446b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f68447c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f68448d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f68449e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Long.valueOf(j2), Long.valueOf(j3), str, str2};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f68449e = this;
                this.f68445a = j2;
                this.f68446b = j3;
                this.f68447c = str;
                this.f68448d = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f68449e.c()) {
                    this.f68449e.f68432a.onDownloadFailed(this.f68445a, this.f68446b, this.f68447c, this.f68448d);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onDownloadFinished(long j2, String str, String str2) throws RemoteException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), str, str2}) == null) || this.f68432a == null) {
            return;
        }
        b().post(new Runnable(this, j2, str, str2) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f68450a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f68451b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f68452c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ e f68453d;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Long.valueOf(j2), str, str2};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f68453d = this;
                this.f68450a = j2;
                this.f68451b = str;
                this.f68452c = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f68453d.c()) {
                    this.f68453d.f68432a.onDownloadFinished(this.f68450a, this.f68451b, this.f68452c);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onDownloadPaused(long j2, long j3, String str, String str2) throws RemoteException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2}) == null) || this.f68432a == null) {
            return;
        }
        b().post(new Runnable(this, j2, j3, str, str2) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f68440a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f68441b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f68442c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f68443d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f68444e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Long.valueOf(j2), Long.valueOf(j3), str, str2};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f68444e = this;
                this.f68440a = j2;
                this.f68441b = j3;
                this.f68442c = str;
                this.f68443d = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f68444e.c()) {
                    this.f68444e.f68432a.onDownloadPaused(this.f68440a, this.f68441b, this.f68442c, this.f68443d);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onIdle() throws RemoteException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f68432a == null) {
            return;
        }
        b().post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f68434a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f68434a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f68434a.c()) {
                    this.f68434a.f68432a.onIdle();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onInstalled(String str, String str2) throws RemoteException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) || this.f68432a == null) {
            return;
        }
        b().post(new Runnable(this, str, str2) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f68454a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f68455b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ e f68456c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, str, str2};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f68456c = this;
                this.f68454a = str;
                this.f68455b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f68456c.c()) {
                    TTAppDownloadListener tTAppDownloadListener = this.f68456c.f68432a;
                    String str3 = this.f68454a;
                    if (str3 == null) {
                        str3 = "";
                    }
                    String str4 = this.f68455b;
                    tTAppDownloadListener.onInstalled(str3, str4 != null ? str4 : "");
                }
            }
        });
    }

    private Handler b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            Handler handler = this.f68433b;
            if (handler == null) {
                Handler handler2 = new Handler(Looper.getMainLooper());
                this.f68433b = handler2;
                return handler2;
            }
            return handler;
        }
        return (Handler) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f68432a = null;
            this.f68433b = null;
        }
    }
}
