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
    public volatile TTAppDownloadListener f67706a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f67707b;

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
        this.f67707b = new Handler(Looper.getMainLooper());
        this.f67706a = tTAppDownloadListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? this.f67706a != null : invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onDownloadActive(long j2, long j3, String str, String str2) throws RemoteException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2}) == null) || this.f67706a == null) {
            return;
        }
        b().post(new Runnable(this, j2, j3, str, str2) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f67709a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f67710b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f67711c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f67712d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f67713e;

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
                this.f67713e = this;
                this.f67709a = j2;
                this.f67710b = j3;
                this.f67711c = str;
                this.f67712d = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f67713e.c()) {
                    this.f67713e.f67706a.onDownloadActive(this.f67709a, this.f67710b, this.f67711c, this.f67712d);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onDownloadFailed(long j2, long j3, String str, String str2) throws RemoteException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2}) == null) || this.f67706a == null) {
            return;
        }
        b().post(new Runnable(this, j2, j3, str, str2) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f67719a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f67720b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f67721c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f67722d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f67723e;

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
                this.f67723e = this;
                this.f67719a = j2;
                this.f67720b = j3;
                this.f67721c = str;
                this.f67722d = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f67723e.c()) {
                    this.f67723e.f67706a.onDownloadFailed(this.f67719a, this.f67720b, this.f67721c, this.f67722d);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onDownloadFinished(long j2, String str, String str2) throws RemoteException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), str, str2}) == null) || this.f67706a == null) {
            return;
        }
        b().post(new Runnable(this, j2, str, str2) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f67724a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f67725b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f67726c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ e f67727d;

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
                this.f67727d = this;
                this.f67724a = j2;
                this.f67725b = str;
                this.f67726c = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f67727d.c()) {
                    this.f67727d.f67706a.onDownloadFinished(this.f67724a, this.f67725b, this.f67726c);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onDownloadPaused(long j2, long j3, String str, String str2) throws RemoteException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2}) == null) || this.f67706a == null) {
            return;
        }
        b().post(new Runnable(this, j2, j3, str, str2) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f67714a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f67715b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f67716c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f67717d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f67718e;

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
                this.f67718e = this;
                this.f67714a = j2;
                this.f67715b = j3;
                this.f67716c = str;
                this.f67717d = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f67718e.c()) {
                    this.f67718e.f67706a.onDownloadPaused(this.f67714a, this.f67715b, this.f67716c, this.f67717d);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onIdle() throws RemoteException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f67706a == null) {
            return;
        }
        b().post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f67708a;

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
                this.f67708a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f67708a.c()) {
                    this.f67708a.f67706a.onIdle();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onInstalled(String str, String str2) throws RemoteException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) || this.f67706a == null) {
            return;
        }
        b().post(new Runnable(this, str, str2) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f67728a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f67729b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ e f67730c;

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
                this.f67730c = this;
                this.f67728a = str;
                this.f67729b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f67730c.c()) {
                    TTAppDownloadListener tTAppDownloadListener = this.f67730c.f67706a;
                    String str3 = this.f67728a;
                    if (str3 == null) {
                        str3 = "";
                    }
                    String str4 = this.f67729b;
                    tTAppDownloadListener.onInstalled(str3, str4 != null ? str4 : "");
                }
            }
        });
    }

    private Handler b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            Handler handler = this.f67707b;
            if (handler == null) {
                Handler handler2 = new Handler(Looper.getMainLooper());
                this.f67707b = handler2;
                return handler2;
            }
            return handler;
        }
        return (Handler) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f67706a = null;
            this.f67707b = null;
        }
    }
}
