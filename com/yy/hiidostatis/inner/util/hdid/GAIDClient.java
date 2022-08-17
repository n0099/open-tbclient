package com.yy.hiidostatis.inner.util.hdid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.log.L;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes8.dex */
public class GAIDClient {
    public static /* synthetic */ Interceptable $ic;
    public static AdInfo mAdInfo;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.yy.hiidostatis.inner.util.hdid.GAIDClient$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static final class AdInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String advertisingId;
        public final boolean limitAdTrackingEnabled;

        public AdInfo(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.advertisingId = str;
            this.limitAdTrackingEnabled = z;
        }

        public String getId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.advertisingId : (String) invokeV.objValue;
        }

        public boolean isLimitAdTrackingEnabled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.limitAdTrackingEnabled : invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class AdvertisingInterface implements IInterface {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public IBinder binder;

        public AdvertisingInterface(IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iBinder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.binder = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.binder : (IBinder) invokeV.objValue;
        }

        public String getId() throws RemoteException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    this.binder.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            return (String) invokeV.objValue;
        }

        public boolean isLimitAdTrackingEnabled(boolean z) throws RemoteException {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    obtain.writeInt(z ? 1 : 0);
                    this.binder.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            return invokeZ.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1095309564, "Lcom/yy/hiidostatis/inner/util/hdid/GAIDClient;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1095309564, "Lcom/yy/hiidostatis/inner/util/hdid/GAIDClient;");
        }
    }

    public GAIDClient() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, MOVE_EXCEPTION, THROW, CONSTRUCTOR, THROW, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public static AdInfo getAdvertisingIdInfo(Context context) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65538, null, context)) != null) {
            return (AdInfo) invokeL.objValue;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            try {
                context.getPackageManager().getPackageInfo("com.android.vending", 0);
                AdvertisingConnection advertisingConnection = new AdvertisingConnection(null);
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                if (context.bindService(intent, advertisingConnection, 1)) {
                    try {
                        AdvertisingInterface advertisingInterface = new AdvertisingInterface(advertisingConnection.getBinder());
                        return new AdInfo(advertisingInterface.getId(), advertisingInterface.isLimitAdTrackingEnabled(true));
                    } finally {
                    }
                } else {
                    throw new IOException("Google Play connection failed");
                }
            } finally {
                Exception exc = new Exception(th);
            }
        } else {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
    }

    public static AdInfo getAdvertisingIdInfoReflect(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                Object invoke = Class.forName("com.repackage.lm9").getMethod("getAdvertisingIdInfo", Context.class).invoke(null, context);
                if (invoke != null) {
                    Class<?> cls = Class.forName("com.repackage.lm9$a");
                    return new AdInfo((String) cls.getMethod("getId", new Class[0]).invoke(invoke, new Object[0]), ((Boolean) cls.getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(invoke, null)).booleanValue());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return null;
        }
        return (AdInfo) invokeL.objValue;
    }

    public static String getGAID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            AdInfo adInfo = mAdInfo;
            if (adInfo != null) {
                return adInfo.getId();
            }
            synchronized (GAIDClient.class) {
                if (mAdInfo != null) {
                    return mAdInfo.advertisingId;
                }
                AdInfo init = init(context);
                mAdInfo = init;
                return init.getId();
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AdInfo init(Context context) {
        InterceptResult invokeL;
        AdInfo adInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            try {
                adInfo = getAdvertisingIdInfoReflect(context);
                try {
                    if (adInfo == null) {
                        adInfo = getAdvertisingIdInfo(context);
                        if (adInfo != null) {
                            L.brief("getAdvertisingIdInfo succeed. gaid=%s,isLimitAdTrackingEnabled=%b", adInfo.getId(), Boolean.valueOf(adInfo.isLimitAdTrackingEnabled()));
                        }
                    } else {
                        L.brief("getAdvertisingIdInfoReflect succeed. gaid=%s,isLimitAdTrackingEnabled=%b", adInfo.getId(), Boolean.valueOf(adInfo.isLimitAdTrackingEnabled()));
                    }
                } catch (Throwable th) {
                    th = th;
                    th.printStackTrace();
                    if (adInfo != null) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                adInfo = null;
            }
            if (adInfo != null) {
                L.brief("get gaid failed, create null AdInfo ", new Object[0]);
                return new AdInfo(null, false);
            }
            return adInfo;
        }
        return (AdInfo) invokeL.objValue;
    }

    /* loaded from: classes8.dex */
    public static final class AdvertisingConnection implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final LinkedBlockingQueue<IBinder> queue;
        public boolean retrieved;

        public AdvertisingConnection() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.retrieved = false;
            this.queue = new LinkedBlockingQueue<>(1);
        }

        public IBinder getBinder() throws InterruptedException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (!this.retrieved) {
                    this.retrieved = true;
                    return this.queue.take();
                }
                throw new IllegalStateException();
            }
            return (IBinder) invokeV.objValue;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName, iBinder) == null) {
                try {
                    this.queue.put(iBinder);
                } catch (InterruptedException e) {
                    L.debug(this, e.getMessage(), new Object[0]);
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, componentName) == null) {
            }
        }

        public /* synthetic */ AdvertisingConnection(AnonymousClass1 anonymousClass1) {
            this();
        }
    }
}
