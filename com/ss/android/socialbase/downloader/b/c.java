package com.ss.android.socialbase.downloader.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.b.b;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;
/* loaded from: classes10.dex */
public interface c extends IInterface {
    DownloadInfo a(int i2, int i3) throws RemoteException;

    DownloadInfo a(int i2, long j2) throws RemoteException;

    DownloadInfo a(int i2, long j2, String str, String str2) throws RemoteException;

    List<DownloadInfo> a(String str) throws RemoteException;

    void a() throws RemoteException;

    void a(int i2, int i3, int i4, int i5) throws RemoteException;

    void a(int i2, int i3, int i4, long j2) throws RemoteException;

    void a(int i2, int i3, long j2) throws RemoteException;

    void a(int i2, List<com.ss.android.socialbase.downloader.model.b> list) throws RemoteException;

    void a(b bVar) throws RemoteException;

    void a(com.ss.android.socialbase.downloader.model.b bVar) throws RemoteException;

    boolean a(int i2) throws RemoteException;

    boolean a(DownloadInfo downloadInfo) throws RemoteException;

    DownloadInfo b(int i2) throws RemoteException;

    DownloadInfo b(int i2, long j2) throws RemoteException;

    List<DownloadInfo> b() throws RemoteException;

    List<DownloadInfo> b(String str) throws RemoteException;

    void b(int i2, List<com.ss.android.socialbase.downloader.model.b> list) throws RemoteException;

    void b(DownloadInfo downloadInfo) throws RemoteException;

    void b(com.ss.android.socialbase.downloader.model.b bVar) throws RemoteException;

    DownloadInfo c(int i2, long j2) throws RemoteException;

    List<com.ss.android.socialbase.downloader.model.b> c(int i2) throws RemoteException;

    List<DownloadInfo> c(String str) throws RemoteException;

    void c() throws RemoteException;

    DownloadInfo d(int i2, long j2) throws RemoteException;

    List<DownloadInfo> d(String str) throws RemoteException;

    void d(int i2) throws RemoteException;

    boolean d() throws RemoteException;

    DownloadInfo e(int i2, long j2) throws RemoteException;

    boolean e() throws RemoteException;

    boolean e(int i2) throws RemoteException;

    boolean f(int i2) throws RemoteException;

    DownloadInfo g(int i2) throws RemoteException;

    DownloadInfo h(int i2) throws RemoteException;

    DownloadInfo i(int i2) throws RemoteException;

    DownloadInfo j(int i2) throws RemoteException;

    /* loaded from: classes10.dex */
    public static abstract class a extends Binder implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            attachInterface(this, "com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        }

        public static c a(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                if (queryLocalInterface != null && (queryLocalInterface instanceof c)) {
                    return (c) queryLocalInterface;
                }
                return new C2059a(iBinder);
            }
            return (c) invokeL.objValue;
        }

        public static c f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? C2059a.f76087a : (c) invokeV.objValue;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (IBinder) invokeV.objValue;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), parcel, parcel2, Integer.valueOf(i3)})) == null) {
                if (i2 != 1598968902) {
                    switch (i2) {
                        case 1:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                            a();
                            parcel2.writeNoException();
                            return true;
                        case 2:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                            boolean a2 = a(parcel.readInt());
                            parcel2.writeNoException();
                            parcel2.writeInt(a2 ? 1 : 0);
                            return true;
                        case 3:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                            DownloadInfo b2 = b(parcel.readInt());
                            parcel2.writeNoException();
                            if (b2 != null) {
                                parcel2.writeInt(1);
                                b2.writeToParcel(parcel2, 1);
                            } else {
                                parcel2.writeInt(0);
                            }
                            return true;
                        case 4:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                            List<DownloadInfo> a3 = a(parcel.readString());
                            parcel2.writeNoException();
                            parcel2.writeTypedList(a3);
                            return true;
                        case 5:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                            List<DownloadInfo> b3 = b(parcel.readString());
                            parcel2.writeNoException();
                            parcel2.writeTypedList(b3);
                            return true;
                        case 6:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                            List<DownloadInfo> c2 = c(parcel.readString());
                            parcel2.writeNoException();
                            parcel2.writeTypedList(c2);
                            return true;
                        case 7:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                            List<DownloadInfo> d2 = d(parcel.readString());
                            parcel2.writeNoException();
                            parcel2.writeTypedList(d2);
                            return true;
                        case 8:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                            List<DownloadInfo> b4 = b();
                            parcel2.writeNoException();
                            parcel2.writeTypedList(b4);
                            return true;
                        case 9:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                            List<com.ss.android.socialbase.downloader.model.b> c3 = c(parcel.readInt());
                            parcel2.writeNoException();
                            parcel2.writeTypedList(c3);
                            return true;
                        case 10:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                            d(parcel.readInt());
                            parcel2.writeNoException();
                            return true;
                        case 11:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                            a(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.b.CREATOR.createFromParcel(parcel) : null);
                            parcel2.writeNoException();
                            return true;
                        case 12:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                            b(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.b.CREATOR.createFromParcel(parcel) : null);
                            parcel2.writeNoException();
                            return true;
                        case 13:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                            a(parcel.readInt(), parcel.readInt(), parcel.readLong());
                            parcel2.writeNoException();
                            return true;
                        case 14:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                            a(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                            parcel2.writeNoException();
                            return true;
                        case 15:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                            a(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                            parcel2.writeNoException();
                            return true;
                        case 16:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                            DownloadInfo a4 = a(parcel.readInt(), parcel.readInt());
                            parcel2.writeNoException();
                            if (a4 != null) {
                                parcel2.writeInt(1);
                                a4.writeToParcel(parcel2, 1);
                            } else {
                                parcel2.writeInt(0);
                            }
                            return true;
                        case 17:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                            boolean a5 = a(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                            parcel2.writeNoException();
                            parcel2.writeInt(a5 ? 1 : 0);
                            return true;
                        case 18:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                            boolean e2 = e(parcel.readInt());
                            parcel2.writeNoException();
                            parcel2.writeInt(e2 ? 1 : 0);
                            return true;
                        case 19:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                            boolean f2 = f(parcel.readInt());
                            parcel2.writeNoException();
                            parcel2.writeInt(f2 ? 1 : 0);
                            return true;
                        case 20:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                            c();
                            parcel2.writeNoException();
                            return true;
                        case 21:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                            DownloadInfo g2 = g(parcel.readInt());
                            parcel2.writeNoException();
                            if (g2 != null) {
                                parcel2.writeInt(1);
                                g2.writeToParcel(parcel2, 1);
                            } else {
                                parcel2.writeInt(0);
                            }
                            return true;
                        case 22:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                            DownloadInfo a6 = a(parcel.readInt(), parcel.readLong(), parcel.readString(), parcel.readString());
                            parcel2.writeNoException();
                            if (a6 != null) {
                                parcel2.writeInt(1);
                                a6.writeToParcel(parcel2, 1);
                            } else {
                                parcel2.writeInt(0);
                            }
                            return true;
                        case 23:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                            DownloadInfo a7 = a(parcel.readInt(), parcel.readLong());
                            parcel2.writeNoException();
                            if (a7 != null) {
                                parcel2.writeInt(1);
                                a7.writeToParcel(parcel2, 1);
                            } else {
                                parcel2.writeInt(0);
                            }
                            return true;
                        case 24:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                            DownloadInfo b5 = b(parcel.readInt(), parcel.readLong());
                            parcel2.writeNoException();
                            if (b5 != null) {
                                parcel2.writeInt(1);
                                b5.writeToParcel(parcel2, 1);
                            } else {
                                parcel2.writeInt(0);
                            }
                            return true;
                        case 25:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                            DownloadInfo h2 = h(parcel.readInt());
                            parcel2.writeNoException();
                            if (h2 != null) {
                                parcel2.writeInt(1);
                                h2.writeToParcel(parcel2, 1);
                            } else {
                                parcel2.writeInt(0);
                            }
                            return true;
                        case 26:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                            DownloadInfo c4 = c(parcel.readInt(), parcel.readLong());
                            parcel2.writeNoException();
                            if (c4 != null) {
                                parcel2.writeInt(1);
                                c4.writeToParcel(parcel2, 1);
                            } else {
                                parcel2.writeInt(0);
                            }
                            return true;
                        case 27:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                            DownloadInfo d3 = d(parcel.readInt(), parcel.readLong());
                            parcel2.writeNoException();
                            if (d3 != null) {
                                parcel2.writeInt(1);
                                d3.writeToParcel(parcel2, 1);
                            } else {
                                parcel2.writeInt(0);
                            }
                            return true;
                        case 28:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                            DownloadInfo e3 = e(parcel.readInt(), parcel.readLong());
                            parcel2.writeNoException();
                            if (e3 != null) {
                                parcel2.writeInt(1);
                                e3.writeToParcel(parcel2, 1);
                            } else {
                                parcel2.writeInt(0);
                            }
                            return true;
                        case 29:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                            DownloadInfo i4 = i(parcel.readInt());
                            parcel2.writeNoException();
                            if (i4 != null) {
                                parcel2.writeInt(1);
                                i4.writeToParcel(parcel2, 1);
                            } else {
                                parcel2.writeInt(0);
                            }
                            return true;
                        case 30:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                            DownloadInfo j2 = j(parcel.readInt());
                            parcel2.writeNoException();
                            if (j2 != null) {
                                parcel2.writeInt(1);
                                j2.writeToParcel(parcel2, 1);
                            } else {
                                parcel2.writeInt(0);
                            }
                            return true;
                        case 31:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                            boolean d4 = d();
                            parcel2.writeNoException();
                            parcel2.writeInt(d4 ? 1 : 0);
                            return true;
                        case 32:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                            boolean e4 = e();
                            parcel2.writeNoException();
                            parcel2.writeInt(e4 ? 1 : 0);
                            return true;
                        case 33:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                            b(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                            parcel2.writeNoException();
                            return true;
                        case 34:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                            a(parcel.readInt(), parcel.createTypedArrayList(com.ss.android.socialbase.downloader.model.b.CREATOR));
                            parcel2.writeNoException();
                            return true;
                        case 35:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                            b(parcel.readInt(), parcel.createTypedArrayList(com.ss.android.socialbase.downloader.model.b.CREATOR));
                            parcel2.writeNoException();
                            return true;
                        case 36:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                            a(b.a.a(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            return true;
                        default:
                            return super.onTransact(i2, parcel, parcel2, i3);
                    }
                }
                parcel2.writeString("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                return true;
            }
            return invokeCommon.booleanValue;
        }

        /* renamed from: com.ss.android.socialbase.downloader.b.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public static class C2059a implements c {
            public static /* synthetic */ Interceptable $ic;

            /* renamed from: a  reason: collision with root package name */
            public static c f76087a;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: b  reason: collision with root package name */
            public IBinder f76088b;

            public C2059a(IBinder iBinder) {
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
                this.f76088b = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.b.c
            public void a() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        if (!this.f76088b.transact(1, obtain, obtain2, 0) && a.f() != null) {
                            a.f().a();
                        } else {
                            obtain2.readException();
                        }
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
                return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f76088b : (IBinder) invokeV.objValue;
            }

            @Override // com.ss.android.socialbase.downloader.b.c
            public DownloadInfo b(int i2) throws RemoteException {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        obtain.writeInt(i2);
                        if (!this.f76088b.transact(3, obtain, obtain2, 0) && a.f() != null) {
                            return a.f().b(i2);
                        }
                        obtain2.readException();
                        return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (DownloadInfo) invokeI.objValue;
            }

            @Override // com.ss.android.socialbase.downloader.b.c
            public List<DownloadInfo> c(String str) throws RemoteException {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        obtain.writeString(str);
                        if (!this.f76088b.transact(6, obtain, obtain2, 0) && a.f() != null) {
                            return a.f().c(str);
                        }
                        obtain2.readException();
                        return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (List) invokeL.objValue;
            }

            @Override // com.ss.android.socialbase.downloader.b.c
            public List<DownloadInfo> d(String str) throws RemoteException {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        obtain.writeString(str);
                        if (!this.f76088b.transact(7, obtain, obtain2, 0) && a.f() != null) {
                            return a.f().d(str);
                        }
                        obtain2.readException();
                        return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (List) invokeL.objValue;
            }

            @Override // com.ss.android.socialbase.downloader.b.c
            public boolean e(int i2) throws RemoteException {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        obtain.writeInt(i2);
                        if (!this.f76088b.transact(18, obtain, obtain2, 0) && a.f() != null) {
                            return a.f().e(i2);
                        }
                        obtain2.readException();
                        return obtain2.readInt() != 0;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeI.booleanValue;
            }

            @Override // com.ss.android.socialbase.downloader.b.c
            public boolean f(int i2) throws RemoteException {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        obtain.writeInt(i2);
                        if (!this.f76088b.transact(19, obtain, obtain2, 0) && a.f() != null) {
                            return a.f().f(i2);
                        }
                        obtain2.readException();
                        return obtain2.readInt() != 0;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeI.booleanValue;
            }

            @Override // com.ss.android.socialbase.downloader.b.c
            public DownloadInfo g(int i2) throws RemoteException {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        obtain.writeInt(i2);
                        if (!this.f76088b.transact(21, obtain, obtain2, 0) && a.f() != null) {
                            return a.f().g(i2);
                        }
                        obtain2.readException();
                        return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (DownloadInfo) invokeI.objValue;
            }

            @Override // com.ss.android.socialbase.downloader.b.c
            public DownloadInfo h(int i2) throws RemoteException {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        obtain.writeInt(i2);
                        if (!this.f76088b.transact(25, obtain, obtain2, 0) && a.f() != null) {
                            return a.f().h(i2);
                        }
                        obtain2.readException();
                        return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (DownloadInfo) invokeI.objValue;
            }

            @Override // com.ss.android.socialbase.downloader.b.c
            public DownloadInfo i(int i2) throws RemoteException {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        obtain.writeInt(i2);
                        if (!this.f76088b.transact(29, obtain, obtain2, 0) && a.f() != null) {
                            return a.f().i(i2);
                        }
                        obtain2.readException();
                        return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (DownloadInfo) invokeI.objValue;
            }

            @Override // com.ss.android.socialbase.downloader.b.c
            public DownloadInfo j(int i2) throws RemoteException {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048612, this, i2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        obtain.writeInt(i2);
                        if (!this.f76088b.transact(30, obtain, obtain2, 0) && a.f() != null) {
                            return a.f().j(i2);
                        }
                        obtain2.readException();
                        return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (DownloadInfo) invokeI.objValue;
            }

            @Override // com.ss.android.socialbase.downloader.b.c
            public boolean a(int i2) throws RemoteException {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        obtain.writeInt(i2);
                        if (!this.f76088b.transact(2, obtain, obtain2, 0) && a.f() != null) {
                            return a.f().a(i2);
                        }
                        obtain2.readException();
                        return obtain2.readInt() != 0;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeI.booleanValue;
            }

            @Override // com.ss.android.socialbase.downloader.b.c
            public List<com.ss.android.socialbase.downloader.model.b> c(int i2) throws RemoteException {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        obtain.writeInt(i2);
                        if (!this.f76088b.transact(9, obtain, obtain2, 0) && a.f() != null) {
                            return a.f().c(i2);
                        }
                        obtain2.readException();
                        return obtain2.createTypedArrayList(com.ss.android.socialbase.downloader.model.b.CREATOR);
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (List) invokeI.objValue;
            }

            @Override // com.ss.android.socialbase.downloader.b.c
            public void d(int i2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        obtain.writeInt(i2);
                        if (!this.f76088b.transact(10, obtain, obtain2, 0) && a.f() != null) {
                            a.f().d(i2);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.b.c
            public DownloadInfo e(int i2, long j2) throws RemoteException {
                InterceptResult invokeCommon;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048605, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        obtain.writeInt(i2);
                        obtain.writeLong(j2);
                        if (!this.f76088b.transact(28, obtain, obtain2, 0) && a.f() != null) {
                            return a.f().e(i2, j2);
                        }
                        obtain2.readException();
                        return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (DownloadInfo) invokeCommon.objValue;
            }

            @Override // com.ss.android.socialbase.downloader.b.c
            public List<DownloadInfo> b(String str) throws RemoteException {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        obtain.writeString(str);
                        if (!this.f76088b.transact(5, obtain, obtain2, 0) && a.f() != null) {
                            return a.f().b(str);
                        }
                        obtain2.readException();
                        return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (List) invokeL.objValue;
            }

            @Override // com.ss.android.socialbase.downloader.b.c
            public List<DownloadInfo> a(String str) throws RemoteException {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        obtain.writeString(str);
                        if (!this.f76088b.transact(4, obtain, obtain2, 0) && a.f() != null) {
                            return a.f().a(str);
                        }
                        obtain2.readException();
                        return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (List) invokeL.objValue;
            }

            @Override // com.ss.android.socialbase.downloader.b.c
            public DownloadInfo d(int i2, long j2) throws RemoteException {
                InterceptResult invokeCommon;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        obtain.writeInt(i2);
                        obtain.writeLong(j2);
                        if (!this.f76088b.transact(27, obtain, obtain2, 0) && a.f() != null) {
                            return a.f().d(i2, j2);
                        }
                        obtain2.readException();
                        return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (DownloadInfo) invokeCommon.objValue;
            }

            @Override // com.ss.android.socialbase.downloader.b.c
            public void c() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        if (!this.f76088b.transact(20, obtain, obtain2, 0) && a.f() != null) {
                            a.f().c();
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.b.c
            public List<DownloadInfo> b() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        if (!this.f76088b.transact(8, obtain, obtain2, 0) && a.f() != null) {
                            return a.f().b();
                        }
                        obtain2.readException();
                        return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (List) invokeV.objValue;
            }

            @Override // com.ss.android.socialbase.downloader.b.c
            public boolean e() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        if (!this.f76088b.transact(32, obtain, obtain2, 0) && a.f() != null) {
                            return a.f().e();
                        }
                        obtain2.readException();
                        return obtain2.readInt() != 0;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeV.booleanValue;
            }

            @Override // com.ss.android.socialbase.downloader.b.c
            public void a(com.ss.android.socialbase.downloader.model.b bVar) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        if (bVar != null) {
                            obtain.writeInt(1);
                            bVar.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (!this.f76088b.transact(11, obtain, obtain2, 0) && a.f() != null) {
                            a.f().a(bVar);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.b.c
            public DownloadInfo c(int i2, long j2) throws RemoteException {
                InterceptResult invokeCommon;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        obtain.writeInt(i2);
                        obtain.writeLong(j2);
                        if (!this.f76088b.transact(26, obtain, obtain2, 0) && a.f() != null) {
                            return a.f().c(i2, j2);
                        }
                        obtain2.readException();
                        return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (DownloadInfo) invokeCommon.objValue;
            }

            @Override // com.ss.android.socialbase.downloader.b.c
            public void b(com.ss.android.socialbase.downloader.model.b bVar) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048596, this, bVar) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        if (bVar != null) {
                            obtain.writeInt(1);
                            bVar.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (!this.f76088b.transact(12, obtain, obtain2, 0) && a.f() != null) {
                            a.f().b(bVar);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.b.c
            public boolean d() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        if (!this.f76088b.transact(31, obtain, obtain2, 0) && a.f() != null) {
                            return a.f().d();
                        }
                        obtain2.readException();
                        return obtain2.readInt() != 0;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeV.booleanValue;
            }

            @Override // com.ss.android.socialbase.downloader.b.c
            public void a(int i2, int i3, long j2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        obtain.writeInt(i2);
                        obtain.writeInt(i3);
                        obtain.writeLong(j2);
                        if (!this.f76088b.transact(13, obtain, obtain2, 0) && a.f() != null) {
                            a.f().a(i2, i3, j2);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.b.c
            public DownloadInfo b(int i2, long j2) throws RemoteException {
                InterceptResult invokeCommon;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        obtain.writeInt(i2);
                        obtain.writeLong(j2);
                        if (!this.f76088b.transact(24, obtain, obtain2, 0) && a.f() != null) {
                            return a.f().b(i2, j2);
                        }
                        obtain2.readException();
                        return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (DownloadInfo) invokeCommon.objValue;
            }

            @Override // com.ss.android.socialbase.downloader.b.c
            public void a(int i2, int i3, int i4, long j2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j2)}) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        obtain.writeInt(i2);
                        obtain.writeInt(i3);
                        obtain.writeInt(i4);
                        obtain.writeLong(j2);
                        if (!this.f76088b.transact(14, obtain, obtain2, 0) && a.f() != null) {
                            a.f().a(i2, i3, i4, j2);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.b.c
            public void b(DownloadInfo downloadInfo) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048595, this, downloadInfo) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        if (downloadInfo != null) {
                            obtain.writeInt(1);
                            downloadInfo.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (!this.f76088b.transact(33, obtain, obtain2, 0) && a.f() != null) {
                            a.f().b(downloadInfo);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.b.c
            public void a(int i2, int i3, int i4, int i5) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIIII(1048581, this, i2, i3, i4, i5) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        obtain.writeInt(i2);
                        obtain.writeInt(i3);
                        obtain.writeInt(i4);
                        obtain.writeInt(i5);
                        if (!this.f76088b.transact(15, obtain, obtain2, 0) && a.f() != null) {
                            a.f().a(i2, i3, i4, i5);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.b.c
            public void b(int i2, List<com.ss.android.socialbase.downloader.model.b> list) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048594, this, i2, list) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        obtain.writeInt(i2);
                        obtain.writeTypedList(list);
                        if (!this.f76088b.transact(35, obtain, obtain2, 0) && a.f() != null) {
                            a.f().b(i2, list);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.b.c
            public DownloadInfo a(int i2, int i3) throws RemoteException {
                InterceptResult invokeII;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        obtain.writeInt(i2);
                        obtain.writeInt(i3);
                        if (!this.f76088b.transact(16, obtain, obtain2, 0) && a.f() != null) {
                            return a.f().a(i2, i3);
                        }
                        obtain2.readException();
                        return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (DownloadInfo) invokeII.objValue;
            }

            @Override // com.ss.android.socialbase.downloader.b.c
            public boolean a(DownloadInfo downloadInfo) throws RemoteException {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, downloadInfo)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        if (downloadInfo != null) {
                            obtain.writeInt(1);
                            downloadInfo.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (!this.f76088b.transact(17, obtain, obtain2, 0) && a.f() != null) {
                            return a.f().a(downloadInfo);
                        }
                        obtain2.readException();
                        return obtain2.readInt() != 0;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeL.booleanValue;
            }

            @Override // com.ss.android.socialbase.downloader.b.c
            public DownloadInfo a(int i2, long j2, String str, String str2) throws RemoteException {
                InterceptResult invokeCommon;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), str, str2})) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        obtain.writeInt(i2);
                        obtain.writeLong(j2);
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        if (!this.f76088b.transact(22, obtain, obtain2, 0) && a.f() != null) {
                            return a.f().a(i2, j2, str, str2);
                        }
                        obtain2.readException();
                        return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (DownloadInfo) invokeCommon.objValue;
            }

            @Override // com.ss.android.socialbase.downloader.b.c
            public DownloadInfo a(int i2, long j2) throws RemoteException {
                InterceptResult invokeCommon;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        obtain.writeInt(i2);
                        obtain.writeLong(j2);
                        if (!this.f76088b.transact(23, obtain, obtain2, 0) && a.f() != null) {
                            return a.f().a(i2, j2);
                        }
                        obtain2.readException();
                        return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (DownloadInfo) invokeCommon.objValue;
            }

            @Override // com.ss.android.socialbase.downloader.b.c
            public void a(int i2, List<com.ss.android.socialbase.downloader.model.b> list) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, list) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        obtain.writeInt(i2);
                        obtain.writeTypedList(list);
                        if (!this.f76088b.transact(34, obtain, obtain2, 0) && a.f() != null) {
                            a.f().a(i2, list);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.b.c
            public void a(b bVar) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                        if (!this.f76088b.transact(36, obtain, obtain2, 0) && a.f() != null) {
                            a.f().a(bVar);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }
        }
    }
}
