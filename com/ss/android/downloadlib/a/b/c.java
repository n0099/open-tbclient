package com.ss.android.downloadlib.a.b;

import android.annotation.SuppressLint;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import c.p.a.d.b.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.downloadlib.a.b.d;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public interface c extends IInterface {

    /* loaded from: classes10.dex */
    public static abstract class a extends Binder implements c {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static String f75271a = "";
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.ss.android.downloadlib.a.b.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public static class C2044a implements c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public IBinder f75272a;

            public C2044a(IBinder iBinder) {
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
                if (TextUtils.isEmpty(a.f75271a)) {
                    JSONObject v = l.v();
                    String unused = a.f75271a = c.p.a.e.a.h.d.b(v.optString(r.f42062a), v.optString("s"));
                }
                this.f75272a = iBinder;
            }

            @Override // com.ss.android.downloadlib.a.b.c
            public void a(b bVar, d dVar) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, dVar) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(a.f75271a);
                        if (bVar != null) {
                            obtain.writeInt(1);
                            bVar.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                        this.f75272a.transact(1, obtain, obtain2, 0);
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
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f75272a : (IBinder) invokeV.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(125104189, "Lcom/ss/android/downloadlib/a/b/c$a;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(125104189, "Lcom/ss/android/downloadlib/a/b/c$a;");
            }
        }

        @Override // android.os.Binder
        @SuppressLint({"WrongConstant"})
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), parcel, parcel2, Integer.valueOf(i3)})) == null) {
                if (i2 == 1598968902) {
                    parcel2.writeString(f75271a);
                    return true;
                }
                if (i2 != 1) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel.enforceInterface(f75271a);
                a(parcel.readInt() != 0 ? b.CREATOR.createFromParcel(parcel) : null, d.a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            return invokeCommon.booleanValue;
        }

        public static c a(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface(f75271a);
                if (queryLocalInterface != null && (queryLocalInterface instanceof c)) {
                    return (c) queryLocalInterface;
                }
                return new C2044a(iBinder);
            }
            return (c) invokeL.objValue;
        }
    }

    void a(b bVar, d dVar) throws RemoteException;
}
