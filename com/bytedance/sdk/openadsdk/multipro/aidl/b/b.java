package com.bytedance.sdk.openadsdk.multipro.aidl.b;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.ICommonPermissionListener;
import com.bytedance.sdk.openadsdk.r.c;
/* loaded from: classes6.dex */
public class b extends ICommonPermissionListener.Stub {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f31438a;

    /* renamed from: b  reason: collision with root package name */
    public c.a f31439b;

    public b(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31438a = new Handler(Looper.getMainLooper());
        this.f31439b = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ICommonPermissionListener
    public void onDenied(String str) throws RemoteException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            a(new Runnable(this, str) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f31441a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f31442b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f31442b = this;
                    this.f31441a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f31442b.f31439b == null) {
                        return;
                    }
                    this.f31442b.f31439b.a(this.f31441a);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ICommonPermissionListener
    public void onGranted() throws RemoteException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f31440a;

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
                    this.f31440a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f31440a.f31439b == null) {
                        return;
                    }
                    this.f31440a.f31439b.a();
                }
            });
        }
    }

    private void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, runnable) == null) {
            if (this.f31438a == null) {
                this.f31438a = new Handler(Looper.getMainLooper());
            }
            this.f31438a.post(runnable);
        }
    }
}
