package com.ss.android.downloadlib.a.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.downloadlib.addownload.j;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public interface d extends IInterface {

    /* loaded from: classes3.dex */
    public static abstract class a extends Binder implements d {
        public static /* synthetic */ Interceptable $ic = null;
        public static String a = "";
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.ss.android.downloadlib.a.b.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C2159a implements d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public IBinder a;

            public C2159a(IBinder iBinder) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iBinder};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                if (TextUtils.isEmpty(a.a)) {
                    JSONObject i4 = j.i();
                    String unused = a.a = com.ss.android.socialbase.appdownloader.f.c.a(i4.optString("t"), i4.optString("s"));
                }
                this.a = iBinder;
            }

            @Override // com.ss.android.downloadlib.a.b.d
            public void a(b bVar) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(a.a);
                        if (bVar != null) {
                            obtain.writeInt(1);
                            bVar.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        this.a.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (IBinder) invokeV.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(125133980, "Lcom/ss/android/downloadlib/a/b/d$a;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(125133980, "Lcom/ss/android/downloadlib/a/b/d$a;");
            }
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), parcel, parcel2, Integer.valueOf(i3)})) == null) {
                if (i2 == 1) {
                    parcel.enforceInterface(a);
                    a(parcel.readInt() != 0 ? b.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                } else if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                } else {
                    parcel2.writeString(a);
                    return true;
                }
            }
            return invokeCommon.booleanValue;
        }

        public static d a(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface(a);
                if (queryLocalInterface != null && (queryLocalInterface instanceof d)) {
                    return (d) queryLocalInterface;
                }
                return new C2159a(iBinder);
            }
            return (d) invokeL.objValue;
        }
    }

    void a(b bVar) throws RemoteException;
}
