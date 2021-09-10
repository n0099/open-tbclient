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
    public volatile TTAppDownloadListener f68086a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f68087b;

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
        this.f68087b = new Handler(Looper.getMainLooper());
        this.f68086a = tTAppDownloadListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? this.f68086a != null : invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onDownloadActive(long j2, long j3, String str, String str2) throws RemoteException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2}) == null) || this.f68086a == null) {
            return;
        }
        b().post(new Runnable(this, j2, j3, str, str2) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f68089a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f68090b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f68091c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f68092d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f68093e;

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
                this.f68093e = this;
                this.f68089a = j2;
                this.f68090b = j3;
                this.f68091c = str;
                this.f68092d = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f68093e.c()) {
                    this.f68093e.f68086a.onDownloadActive(this.f68089a, this.f68090b, this.f68091c, this.f68092d);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onDownloadFailed(long j2, long j3, String str, String str2) throws RemoteException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2}) == null) || this.f68086a == null) {
            return;
        }
        b().post(new Runnable(this, j2, j3, str, str2) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f68099a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f68100b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f68101c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f68102d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f68103e;

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
                this.f68103e = this;
                this.f68099a = j2;
                this.f68100b = j3;
                this.f68101c = str;
                this.f68102d = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f68103e.c()) {
                    this.f68103e.f68086a.onDownloadFailed(this.f68099a, this.f68100b, this.f68101c, this.f68102d);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onDownloadFinished(long j2, String str, String str2) throws RemoteException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), str, str2}) == null) || this.f68086a == null) {
            return;
        }
        b().post(new Runnable(this, j2, str, str2) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f68104a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f68105b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f68106c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ e f68107d;

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
                this.f68107d = this;
                this.f68104a = j2;
                this.f68105b = str;
                this.f68106c = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f68107d.c()) {
                    this.f68107d.f68086a.onDownloadFinished(this.f68104a, this.f68105b, this.f68106c);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onDownloadPaused(long j2, long j3, String str, String str2) throws RemoteException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2}) == null) || this.f68086a == null) {
            return;
        }
        b().post(new Runnable(this, j2, j3, str, str2) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f68094a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f68095b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f68096c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f68097d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f68098e;

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
                this.f68098e = this;
                this.f68094a = j2;
                this.f68095b = j3;
                this.f68096c = str;
                this.f68097d = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f68098e.c()) {
                    this.f68098e.f68086a.onDownloadPaused(this.f68094a, this.f68095b, this.f68096c, this.f68097d);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onIdle() throws RemoteException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f68086a == null) {
            return;
        }
        b().post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f68088a;

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
                this.f68088a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f68088a.c()) {
                    this.f68088a.f68086a.onIdle();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onInstalled(String str, String str2) throws RemoteException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) || this.f68086a == null) {
            return;
        }
        b().post(new Runnable(this, str, str2) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f68108a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f68109b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ e f68110c;

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
                this.f68110c = this;
                this.f68108a = str;
                this.f68109b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f68110c.c()) {
                    TTAppDownloadListener tTAppDownloadListener = this.f68110c.f68086a;
                    String str3 = this.f68108a;
                    if (str3 == null) {
                        str3 = "";
                    }
                    String str4 = this.f68109b;
                    tTAppDownloadListener.onInstalled(str3, str4 != null ? str4 : "");
                }
            }
        });
    }

    private Handler b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            Handler handler = this.f68087b;
            if (handler == null) {
                Handler handler2 = new Handler(Looper.getMainLooper());
                this.f68087b = handler2;
                return handler2;
            }
            return handler;
        }
        return (Handler) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f68086a = null;
            this.f68087b = null;
        }
    }
}
