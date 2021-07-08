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
/* loaded from: classes5.dex */
public class e extends ITTAppDownloadListener.Stub {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile TTAppDownloadListener f31574a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f31575b;

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
        this.f31575b = new Handler(Looper.getMainLooper());
        this.f31574a = tTAppDownloadListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? this.f31574a != null : invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onDownloadActive(long j, long j2, String str, String str2) throws RemoteException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, str2}) == null) || this.f31574a == null) {
            return;
        }
        b().post(new Runnable(this, j, j2, str, str2) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f31577a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f31578b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f31579c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f31580d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f31581e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Long.valueOf(j), Long.valueOf(j2), str, str2};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f31581e = this;
                this.f31577a = j;
                this.f31578b = j2;
                this.f31579c = str;
                this.f31580d = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f31581e.c()) {
                    this.f31581e.f31574a.onDownloadActive(this.f31577a, this.f31578b, this.f31579c, this.f31580d);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onDownloadFailed(long j, long j2, String str, String str2) throws RemoteException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, str2}) == null) || this.f31574a == null) {
            return;
        }
        b().post(new Runnable(this, j, j2, str, str2) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f31587a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f31588b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f31589c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f31590d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f31591e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Long.valueOf(j), Long.valueOf(j2), str, str2};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f31591e = this;
                this.f31587a = j;
                this.f31588b = j2;
                this.f31589c = str;
                this.f31590d = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f31591e.c()) {
                    this.f31591e.f31574a.onDownloadFailed(this.f31587a, this.f31588b, this.f31589c, this.f31590d);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onDownloadFinished(long j, String str, String str2) throws RemoteException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), str, str2}) == null) || this.f31574a == null) {
            return;
        }
        b().post(new Runnable(this, j, str, str2) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f31592a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f31593b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f31594c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ e f31595d;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Long.valueOf(j), str, str2};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f31595d = this;
                this.f31592a = j;
                this.f31593b = str;
                this.f31594c = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f31595d.c()) {
                    this.f31595d.f31574a.onDownloadFinished(this.f31592a, this.f31593b, this.f31594c);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onDownloadPaused(long j, long j2, String str, String str2) throws RemoteException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, str2}) == null) || this.f31574a == null) {
            return;
        }
        b().post(new Runnable(this, j, j2, str, str2) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f31582a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f31583b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f31584c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f31585d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f31586e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Long.valueOf(j), Long.valueOf(j2), str, str2};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f31586e = this;
                this.f31582a = j;
                this.f31583b = j2;
                this.f31584c = str;
                this.f31585d = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f31586e.c()) {
                    this.f31586e.f31574a.onDownloadPaused(this.f31582a, this.f31583b, this.f31584c, this.f31585d);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onIdle() throws RemoteException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f31574a == null) {
            return;
        }
        b().post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f31576a;

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
                this.f31576a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f31576a.c()) {
                    this.f31576a.f31574a.onIdle();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onInstalled(String str, String str2) throws RemoteException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) || this.f31574a == null) {
            return;
        }
        b().post(new Runnable(this, str, str2) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f31596a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f31597b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ e f31598c;

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
                this.f31598c = this;
                this.f31596a = str;
                this.f31597b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f31598c.c()) {
                    this.f31598c.f31574a.onInstalled(this.f31596a, this.f31597b);
                }
            }
        });
    }

    private Handler b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            Handler handler = this.f31575b;
            if (handler == null) {
                Handler handler2 = new Handler(Looper.getMainLooper());
                this.f31575b = handler2;
                return handler2;
            }
            return handler;
        }
        return (Handler) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f31574a = null;
            this.f31575b = null;
        }
    }
}
