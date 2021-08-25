package com.bytedance.sdk.openadsdk.multipro.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.IBinderPool;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f67855c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f67856a;

    /* renamed from: b  reason: collision with root package name */
    public IBinderPool f67857b;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f67858d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f67859e;

    /* renamed from: f  reason: collision with root package name */
    public long f67860f;

    /* renamed from: g  reason: collision with root package name */
    public ServiceConnection f67861g;

    /* renamed from: h  reason: collision with root package name */
    public IBinder.DeathRecipient f67862h;

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67859e = new Object();
        this.f67860f = 0L;
        this.f67861g = new ServiceConnection(this) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f67863a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f67863a = this;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, componentName, iBinder) == null) {
                    this.f67863a.f67857b = IBinderPool.Stub.asInterface(iBinder);
                    try {
                        this.f67863a.f67857b.asBinder().linkToDeath(this.f67863a.f67862h, 0);
                    } catch (RemoteException e2) {
                        k.c("MultiProcess", "onServiceConnected throws :", e2);
                    }
                    this.f67863a.f67858d.countDown();
                    k.b("MultiProcess", "onServiceConnected - binderService consume time ：" + (System.currentTimeMillis() - this.f67863a.f67860f));
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                    k.c("MultiProcess", "BinderPool......onServiceDisconnected");
                }
            }
        };
        this.f67862h = new IBinder.DeathRecipient(this) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f67864a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f67864a = this;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    k.d("MultiProcess", "binder died.");
                    this.f67864a.f67857b.asBinder().unlinkToDeath(this.f67864a.f67862h, 0);
                    this.f67864a.f67857b = null;
                    this.f67864a.a();
                }
            }
        };
        this.f67856a = context.getApplicationContext();
        a();
    }

    public static a a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f67855c == null) {
                synchronized (a.class) {
                    if (f67855c == null) {
                        f67855c = new a(context);
                    }
                }
            }
            return f67855c;
        }
        return (a) invokeL.objValue;
    }

    public IBinder a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            try {
                if (this.f67857b != null) {
                    return this.f67857b.queryBinder(i2);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (IBinder) invokeI.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            synchronized (this) {
                k.c("MultiProcess", "BinderPool......connectBinderPoolService");
                this.f67858d = new CountDownLatch(1);
                try {
                    this.f67856a.bindService(new Intent(this.f67856a, BinderPoolService.class), this.f67861g, 1);
                    this.f67860f = System.currentTimeMillis();
                    this.f67858d.await();
                } catch (Exception e2) {
                    k.c("MultiProcess", "connectBinderPoolService throws: ", e2);
                }
            }
        }
    }
}
