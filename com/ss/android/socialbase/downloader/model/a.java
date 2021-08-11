package com.ss.android.socialbase.downloader.model;

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
import com.ss.android.socialbase.downloader.depend.af;
import com.ss.android.socialbase.downloader.depend.ai;
import com.ss.android.socialbase.downloader.depend.e;
import com.ss.android.socialbase.downloader.depend.f;
import com.ss.android.socialbase.downloader.depend.g;
import com.ss.android.socialbase.downloader.depend.h;
import com.ss.android.socialbase.downloader.depend.i;
import com.ss.android.socialbase.downloader.depend.j;
import com.ss.android.socialbase.downloader.depend.l;
import com.ss.android.socialbase.downloader.depend.p;
import com.ss.android.socialbase.downloader.depend.v;
import com.ss.android.socialbase.downloader.depend.z;
/* loaded from: classes10.dex */
public interface a extends IInterface {
    int a(int i2) throws RemoteException;

    i a(int i2, int i3) throws RemoteException;

    DownloadInfo a() throws RemoteException;

    e b() throws RemoteException;

    i b(int i2) throws RemoteException;

    l c(int i2) throws RemoteException;

    z c() throws RemoteException;

    af d() throws RemoteException;

    h e() throws RemoteException;

    f f() throws RemoteException;

    v g() throws RemoteException;

    ai h() throws RemoteException;

    p i() throws RemoteException;

    j j() throws RemoteException;

    g k() throws RemoteException;

    int l() throws RemoteException;

    /* renamed from: com.ss.android.socialbase.downloader.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static abstract class AbstractBinderC2071a extends Binder implements a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public AbstractBinderC2071a() {
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
            attachInterface(this, "com.ss.android.socialbase.downloader.model.DownloadAidlTask");
        }

        public static a a(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                    return (a) queryLocalInterface;
                }
                return new C2072a(iBinder);
            }
            return (a) invokeL.objValue;
        }

        public static a m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? C2072a.f75605a : (a) invokeV.objValue;
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
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                            DownloadInfo a2 = a();
                            parcel2.writeNoException();
                            if (a2 != null) {
                                parcel2.writeInt(1);
                                a2.writeToParcel(parcel2, 1);
                            } else {
                                parcel2.writeInt(0);
                            }
                            return true;
                        case 2:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                            e b2 = b();
                            parcel2.writeNoException();
                            parcel2.writeStrongBinder(b2 != null ? b2.asBinder() : null);
                            return true;
                        case 3:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                            int a3 = a(parcel.readInt());
                            parcel2.writeNoException();
                            parcel2.writeInt(a3);
                            return true;
                        case 4:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                            i a4 = a(parcel.readInt(), parcel.readInt());
                            parcel2.writeNoException();
                            parcel2.writeStrongBinder(a4 != null ? a4.asBinder() : null);
                            return true;
                        case 5:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                            i b3 = b(parcel.readInt());
                            parcel2.writeNoException();
                            parcel2.writeStrongBinder(b3 != null ? b3.asBinder() : null);
                            return true;
                        case 6:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                            z c2 = c();
                            parcel2.writeNoException();
                            parcel2.writeStrongBinder(c2 != null ? c2.asBinder() : null);
                            return true;
                        case 7:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                            af d2 = d();
                            parcel2.writeNoException();
                            parcel2.writeStrongBinder(d2 != null ? d2.asBinder() : null);
                            return true;
                        case 8:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                            h e2 = e();
                            parcel2.writeNoException();
                            parcel2.writeStrongBinder(e2 != null ? e2.asBinder() : null);
                            return true;
                        case 9:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                            f f2 = f();
                            parcel2.writeNoException();
                            parcel2.writeStrongBinder(f2 != null ? f2.asBinder() : null);
                            return true;
                        case 10:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                            v g2 = g();
                            parcel2.writeNoException();
                            parcel2.writeStrongBinder(g2 != null ? g2.asBinder() : null);
                            return true;
                        case 11:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                            ai h2 = h();
                            parcel2.writeNoException();
                            parcel2.writeStrongBinder(h2 != null ? h2.asBinder() : null);
                            return true;
                        case 12:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                            p i4 = i();
                            parcel2.writeNoException();
                            parcel2.writeStrongBinder(i4 != null ? i4.asBinder() : null);
                            return true;
                        case 13:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                            j j2 = j();
                            parcel2.writeNoException();
                            parcel2.writeStrongBinder(j2 != null ? j2.asBinder() : null);
                            return true;
                        case 14:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                            g k = k();
                            parcel2.writeNoException();
                            parcel2.writeStrongBinder(k != null ? k.asBinder() : null);
                            return true;
                        case 15:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                            int l = l();
                            parcel2.writeNoException();
                            parcel2.writeInt(l);
                            return true;
                        case 16:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                            l c3 = c(parcel.readInt());
                            parcel2.writeNoException();
                            parcel2.writeStrongBinder(c3 != null ? c3.asBinder() : null);
                            return true;
                        default:
                            return super.onTransact(i2, parcel, parcel2, i3);
                    }
                }
                parcel2.writeString("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                return true;
            }
            return invokeCommon.booleanValue;
        }

        /* renamed from: com.ss.android.socialbase.downloader.model.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public static class C2072a implements a {
            public static /* synthetic */ Interceptable $ic;

            /* renamed from: a  reason: collision with root package name */
            public static a f75605a;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: b  reason: collision with root package name */
            public IBinder f75606b;

            public C2072a(IBinder iBinder) {
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
                this.f75606b = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public DownloadInfo a() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        if (!this.f75606b.transact(1, obtain, obtain2, 0) && AbstractBinderC2071a.m() != null) {
                            return AbstractBinderC2071a.m().a();
                        }
                        obtain2.readException();
                        return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (DownloadInfo) invokeV.objValue;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f75606b : (IBinder) invokeV.objValue;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public e b() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        if (!this.f75606b.transact(2, obtain, obtain2, 0) && AbstractBinderC2071a.m() != null) {
                            return AbstractBinderC2071a.m().b();
                        }
                        obtain2.readException();
                        return e.a.a(obtain2.readStrongBinder());
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (e) invokeV.objValue;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public z c() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        if (!this.f75606b.transact(6, obtain, obtain2, 0) && AbstractBinderC2071a.m() != null) {
                            return AbstractBinderC2071a.m().c();
                        }
                        obtain2.readException();
                        return z.a.a(obtain2.readStrongBinder());
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (z) invokeV.objValue;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public af d() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        if (!this.f75606b.transact(7, obtain, obtain2, 0) && AbstractBinderC2071a.m() != null) {
                            return AbstractBinderC2071a.m().d();
                        }
                        obtain2.readException();
                        return af.a.a(obtain2.readStrongBinder());
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (af) invokeV.objValue;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public h e() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        if (!this.f75606b.transact(8, obtain, obtain2, 0) && AbstractBinderC2071a.m() != null) {
                            return AbstractBinderC2071a.m().e();
                        }
                        obtain2.readException();
                        return h.a.a(obtain2.readStrongBinder());
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (h) invokeV.objValue;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public f f() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        if (!this.f75606b.transact(9, obtain, obtain2, 0) && AbstractBinderC2071a.m() != null) {
                            return AbstractBinderC2071a.m().f();
                        }
                        obtain2.readException();
                        return f.a.a(obtain2.readStrongBinder());
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (f) invokeV.objValue;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public v g() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        if (!this.f75606b.transact(10, obtain, obtain2, 0) && AbstractBinderC2071a.m() != null) {
                            return AbstractBinderC2071a.m().g();
                        }
                        obtain2.readException();
                        return v.a.a(obtain2.readStrongBinder());
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (v) invokeV.objValue;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public ai h() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        if (!this.f75606b.transact(11, obtain, obtain2, 0) && AbstractBinderC2071a.m() != null) {
                            return AbstractBinderC2071a.m().h();
                        }
                        obtain2.readException();
                        return ai.a.a(obtain2.readStrongBinder());
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (ai) invokeV.objValue;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public p i() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        if (!this.f75606b.transact(12, obtain, obtain2, 0) && AbstractBinderC2071a.m() != null) {
                            return AbstractBinderC2071a.m().i();
                        }
                        obtain2.readException();
                        return p.a.a(obtain2.readStrongBinder());
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (p) invokeV.objValue;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public j j() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        if (!this.f75606b.transact(13, obtain, obtain2, 0) && AbstractBinderC2071a.m() != null) {
                            return AbstractBinderC2071a.m().j();
                        }
                        obtain2.readException();
                        return j.a.a(obtain2.readStrongBinder());
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (j) invokeV.objValue;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public g k() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        if (!this.f75606b.transact(14, obtain, obtain2, 0) && AbstractBinderC2071a.m() != null) {
                            return AbstractBinderC2071a.m().k();
                        }
                        obtain2.readException();
                        return g.a.a(obtain2.readStrongBinder());
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (g) invokeV.objValue;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public int l() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        if (!this.f75606b.transact(15, obtain, obtain2, 0) && AbstractBinderC2071a.m() != null) {
                            return AbstractBinderC2071a.m().l();
                        }
                        obtain2.readException();
                        return obtain2.readInt();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeV.intValue;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public i b(int i2) throws RemoteException {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        obtain.writeInt(i2);
                        if (!this.f75606b.transact(5, obtain, obtain2, 0) && AbstractBinderC2071a.m() != null) {
                            return AbstractBinderC2071a.m().b(i2);
                        }
                        obtain2.readException();
                        return i.a.a(obtain2.readStrongBinder());
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (i) invokeI.objValue;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public l c(int i2) throws RemoteException {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        obtain.writeInt(i2);
                        if (!this.f75606b.transact(16, obtain, obtain2, 0) && AbstractBinderC2071a.m() != null) {
                            return AbstractBinderC2071a.m().c(i2);
                        }
                        obtain2.readException();
                        return l.a.a(obtain2.readStrongBinder());
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (l) invokeI.objValue;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public int a(int i2) throws RemoteException {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        obtain.writeInt(i2);
                        if (!this.f75606b.transact(3, obtain, obtain2, 0) && AbstractBinderC2071a.m() != null) {
                            return AbstractBinderC2071a.m().a(i2);
                        }
                        obtain2.readException();
                        return obtain2.readInt();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeI.intValue;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public i a(int i2, int i3) throws RemoteException {
                InterceptResult invokeII;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        obtain.writeInt(i2);
                        obtain.writeInt(i3);
                        if (!this.f75606b.transact(4, obtain, obtain2, 0) && AbstractBinderC2071a.m() != null) {
                            return AbstractBinderC2071a.m().a(i2, i3);
                        }
                        obtain2.readException();
                        return i.a.a(obtain2.readStrongBinder());
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (i) invokeII.objValue;
            }
        }
    }
}
