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
    public volatile TTAppDownloadListener f67906a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f67907b;

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
        this.f67907b = new Handler(Looper.getMainLooper());
        this.f67906a = tTAppDownloadListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? this.f67906a != null : invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onDownloadActive(long j2, long j3, String str, String str2) throws RemoteException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2}) == null) || this.f67906a == null) {
            return;
        }
        b().post(new Runnable(this, j2, j3, str, str2) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f67909a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f67910b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f67911c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f67912d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f67913e;

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
                this.f67913e = this;
                this.f67909a = j2;
                this.f67910b = j3;
                this.f67911c = str;
                this.f67912d = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f67913e.c()) {
                    this.f67913e.f67906a.onDownloadActive(this.f67909a, this.f67910b, this.f67911c, this.f67912d);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onDownloadFailed(long j2, long j3, String str, String str2) throws RemoteException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2}) == null) || this.f67906a == null) {
            return;
        }
        b().post(new Runnable(this, j2, j3, str, str2) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f67919a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f67920b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f67921c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f67922d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f67923e;

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
                this.f67923e = this;
                this.f67919a = j2;
                this.f67920b = j3;
                this.f67921c = str;
                this.f67922d = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f67923e.c()) {
                    this.f67923e.f67906a.onDownloadFailed(this.f67919a, this.f67920b, this.f67921c, this.f67922d);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onDownloadFinished(long j2, String str, String str2) throws RemoteException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), str, str2}) == null) || this.f67906a == null) {
            return;
        }
        b().post(new Runnable(this, j2, str, str2) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f67924a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f67925b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f67926c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ e f67927d;

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
                this.f67927d = this;
                this.f67924a = j2;
                this.f67925b = str;
                this.f67926c = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f67927d.c()) {
                    this.f67927d.f67906a.onDownloadFinished(this.f67924a, this.f67925b, this.f67926c);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onDownloadPaused(long j2, long j3, String str, String str2) throws RemoteException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2}) == null) || this.f67906a == null) {
            return;
        }
        b().post(new Runnable(this, j2, j3, str, str2) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f67914a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f67915b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f67916c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f67917d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f67918e;

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
                this.f67918e = this;
                this.f67914a = j2;
                this.f67915b = j3;
                this.f67916c = str;
                this.f67917d = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f67918e.c()) {
                    this.f67918e.f67906a.onDownloadPaused(this.f67914a, this.f67915b, this.f67916c, this.f67917d);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onIdle() throws RemoteException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f67906a == null) {
            return;
        }
        b().post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f67908a;

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
                this.f67908a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f67908a.c()) {
                    this.f67908a.f67906a.onIdle();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onInstalled(String str, String str2) throws RemoteException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) || this.f67906a == null) {
            return;
        }
        b().post(new Runnable(this, str, str2) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f67928a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f67929b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ e f67930c;

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
                this.f67930c = this;
                this.f67928a = str;
                this.f67929b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f67930c.c()) {
                    TTAppDownloadListener tTAppDownloadListener = this.f67930c.f67906a;
                    String str3 = this.f67928a;
                    if (str3 == null) {
                        str3 = "";
                    }
                    String str4 = this.f67929b;
                    tTAppDownloadListener.onInstalled(str3, str4 != null ? str4 : "");
                }
            }
        });
    }

    private Handler b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            Handler handler = this.f67907b;
            if (handler == null) {
                Handler handler2 = new Handler(Looper.getMainLooper());
                this.f67907b = handler2;
                return handler2;
            }
            return handler;
        }
        return (Handler) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f67906a = null;
            this.f67907b = null;
        }
    }
}
