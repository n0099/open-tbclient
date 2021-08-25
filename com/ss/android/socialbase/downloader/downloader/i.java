package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
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
import com.ss.android.socialbase.downloader.depend.ak;
import com.ss.android.socialbase.downloader.depend.g;
import com.ss.android.socialbase.downloader.depend.i;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.a;
import com.ss.android.socialbase.downloader.model.b;
import java.util.List;
/* loaded from: classes10.dex */
public interface i extends IInterface {
    int a(String str, String str2) throws RemoteException;

    List<DownloadInfo> a(String str) throws RemoteException;

    void a() throws RemoteException;

    void a(int i2) throws RemoteException;

    void a(int i2, int i3) throws RemoteException;

    void a(int i2, int i3, int i4, int i5) throws RemoteException;

    void a(int i2, int i3, int i4, long j2) throws RemoteException;

    void a(int i2, int i3, long j2) throws RemoteException;

    void a(int i2, int i3, com.ss.android.socialbase.downloader.depend.i iVar, int i4, boolean z) throws RemoteException;

    void a(int i2, int i3, com.ss.android.socialbase.downloader.depend.i iVar, int i4, boolean z, boolean z2) throws RemoteException;

    void a(int i2, long j2) throws RemoteException;

    void a(int i2, Notification notification) throws RemoteException;

    void a(int i2, z zVar) throws RemoteException;

    void a(int i2, List<b> list) throws RemoteException;

    void a(int i2, boolean z) throws RemoteException;

    void a(ak akVar) throws RemoteException;

    void a(com.ss.android.socialbase.downloader.model.a aVar) throws RemoteException;

    void a(b bVar) throws RemoteException;

    void a(List<String> list) throws RemoteException;

    void a(boolean z) throws RemoteException;

    boolean a(DownloadInfo downloadInfo) throws RemoteException;

    DownloadInfo b(String str, String str2) throws RemoteException;

    List<DownloadInfo> b() throws RemoteException;

    List<DownloadInfo> b(String str) throws RemoteException;

    void b(int i2, int i3, com.ss.android.socialbase.downloader.depend.i iVar, int i4, boolean z) throws RemoteException;

    void b(int i2, List<b> list) throws RemoteException;

    void b(int i2, boolean z) throws RemoteException;

    void b(List<String> list) throws RemoteException;

    boolean b(int i2) throws RemoteException;

    boolean b(DownloadInfo downloadInfo) throws RemoteException;

    List<DownloadInfo> c(String str) throws RemoteException;

    void c(int i2) throws RemoteException;

    void c(int i2, boolean z) throws RemoteException;

    boolean c() throws RemoteException;

    List<DownloadInfo> d(String str) throws RemoteException;

    void d(int i2) throws RemoteException;

    void d(int i2, boolean z) throws RemoteException;

    boolean d() throws RemoteException;

    long e(int i2) throws RemoteException;

    List<DownloadInfo> e(String str) throws RemoteException;

    void e() throws RemoteException;

    int f(int i2) throws RemoteException;

    boolean f() throws RemoteException;

    boolean g(int i2) throws RemoteException;

    DownloadInfo h(int i2) throws RemoteException;

    List<b> i(int i2) throws RemoteException;

    void j(int i2) throws RemoteException;

    boolean k(int i2) throws RemoteException;

    void l(int i2) throws RemoteException;

    int m(int i2) throws RemoteException;

    boolean n(int i2) throws RemoteException;

    void o(int i2) throws RemoteException;

    boolean p(int i2) throws RemoteException;

    z q(int i2) throws RemoteException;

    af r(int i2) throws RemoteException;

    g s(int i2) throws RemoteException;

    /* loaded from: classes10.dex */
    public static abstract class a extends Binder implements i {
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
            attachInterface(this, "com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        }

        public static i a(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                if (queryLocalInterface != null && (queryLocalInterface instanceof i)) {
                    return (i) queryLocalInterface;
                }
                return new C2072a(iBinder);
            }
            return (i) invokeL.objValue;
        }

        public static i g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? C2072a.f75719a : (i) invokeV.objValue;
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
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            a(a.AbstractBinderC2075a.a(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            return true;
                        case 2:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            a(parcel.readInt());
                            parcel2.writeNoException();
                            return true;
                        case 3:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            a(parcel.readInt(), parcel.readInt() != 0);
                            parcel2.writeNoException();
                            return true;
                        case 4:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            boolean b2 = b(parcel.readInt());
                            parcel2.writeNoException();
                            parcel2.writeInt(b2 ? 1 : 0);
                            return true;
                        case 5:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            c(parcel.readInt());
                            parcel2.writeNoException();
                            return true;
                        case 6:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            d(parcel.readInt());
                            parcel2.writeNoException();
                            return true;
                        case 7:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            a();
                            parcel2.writeNoException();
                            return true;
                        case 8:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            long e2 = e(parcel.readInt());
                            parcel2.writeNoException();
                            parcel2.writeLong(e2);
                            return true;
                        case 9:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            int f2 = f(parcel.readInt());
                            parcel2.writeNoException();
                            parcel2.writeInt(f2);
                            return true;
                        case 10:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            boolean g2 = g(parcel.readInt());
                            parcel2.writeNoException();
                            parcel2.writeInt(g2 ? 1 : 0);
                            return true;
                        case 11:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            DownloadInfo h2 = h(parcel.readInt());
                            parcel2.writeNoException();
                            if (h2 != null) {
                                parcel2.writeInt(1);
                                h2.writeToParcel(parcel2, 1);
                            } else {
                                parcel2.writeInt(0);
                            }
                            return true;
                        case 12:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            List<DownloadInfo> a2 = a(parcel.readString());
                            parcel2.writeNoException();
                            parcel2.writeTypedList(a2);
                            return true;
                        case 13:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            List<b> i4 = i(parcel.readInt());
                            parcel2.writeNoException();
                            parcel2.writeTypedList(i4);
                            return true;
                        case 14:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            int a3 = a(parcel.readString(), parcel.readString());
                            parcel2.writeNoException();
                            parcel2.writeInt(a3);
                            return true;
                        case 15:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            DownloadInfo b3 = b(parcel.readString(), parcel.readString());
                            parcel2.writeNoException();
                            if (b3 != null) {
                                parcel2.writeInt(1);
                                b3.writeToParcel(parcel2, 1);
                            } else {
                                parcel2.writeInt(0);
                            }
                            return true;
                        case 16:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            List<DownloadInfo> b4 = b(parcel.readString());
                            parcel2.writeNoException();
                            parcel2.writeTypedList(b4);
                            return true;
                        case 17:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            List<DownloadInfo> c2 = c(parcel.readString());
                            parcel2.writeNoException();
                            parcel2.writeTypedList(c2);
                            return true;
                        case 18:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            List<DownloadInfo> d2 = d(parcel.readString());
                            parcel2.writeNoException();
                            parcel2.writeTypedList(d2);
                            return true;
                        case 19:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            List<DownloadInfo> b5 = b();
                            parcel2.writeNoException();
                            parcel2.writeTypedList(b5);
                            return true;
                        case 20:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            a(parcel.createStringArrayList());
                            parcel2.writeNoException();
                            return true;
                        case 21:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            b(parcel.createStringArrayList());
                            parcel2.writeNoException();
                            return true;
                        case 22:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            b(parcel.readInt(), parcel.readInt() != 0);
                            parcel2.writeNoException();
                            return true;
                        case 23:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            c(parcel.readInt(), parcel.readInt() != 0);
                            parcel2.writeNoException();
                            return true;
                        case 24:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            j(parcel.readInt());
                            parcel2.writeNoException();
                            return true;
                        case 25:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            a(parcel.readInt(), parcel.readInt(), i.a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0);
                            parcel2.writeNoException();
                            return true;
                        case 26:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            b(parcel.readInt(), parcel.readInt(), i.a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0);
                            parcel2.writeNoException();
                            return true;
                        case 27:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            a(parcel.readInt(), parcel.readInt(), i.a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
                            parcel2.writeNoException();
                            return true;
                        case 28:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            boolean a4 = a(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                            parcel2.writeNoException();
                            parcel2.writeInt(a4 ? 1 : 0);
                            return true;
                        case 29:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            a(parcel.readInt(), parcel.readInt() != 0 ? (Notification) Notification.CREATOR.createFromParcel(parcel) : null);
                            return true;
                        case 30:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            a(parcel.readInt() != 0);
                            return true;
                        case 31:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            boolean c3 = c();
                            parcel2.writeNoException();
                            parcel2.writeInt(c3 ? 1 : 0);
                            return true;
                        case 32:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            List<DownloadInfo> e3 = e(parcel.readString());
                            parcel2.writeNoException();
                            parcel2.writeTypedList(e3);
                            return true;
                        case 33:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            boolean k = k(parcel.readInt());
                            parcel2.writeNoException();
                            parcel2.writeInt(k ? 1 : 0);
                            return true;
                        case 34:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            l(parcel.readInt());
                            parcel2.writeNoException();
                            return true;
                        case 35:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            boolean d3 = d();
                            parcel2.writeNoException();
                            parcel2.writeInt(d3 ? 1 : 0);
                            return true;
                        case 36:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            d(parcel.readInt(), parcel.readInt() != 0);
                            parcel2.writeNoException();
                            return true;
                        case 37:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            int m = m(parcel.readInt());
                            parcel2.writeNoException();
                            parcel2.writeInt(m);
                            return true;
                        case 38:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            a(parcel.readInt() != 0 ? b.CREATOR.createFromParcel(parcel) : null);
                            parcel2.writeNoException();
                            return true;
                        case 39:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            boolean b6 = b(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                            parcel2.writeNoException();
                            parcel2.writeInt(b6 ? 1 : 0);
                            return true;
                        case 40:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            boolean n = n(parcel.readInt());
                            parcel2.writeNoException();
                            parcel2.writeInt(n ? 1 : 0);
                            return true;
                        case 41:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            o(parcel.readInt());
                            parcel2.writeNoException();
                            return true;
                        case 42:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            a(parcel.readInt(), parcel.readInt(), parcel.readLong());
                            parcel2.writeNoException();
                            return true;
                        case 43:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            a(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                            parcel2.writeNoException();
                            return true;
                        case 44:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            a(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                            parcel2.writeNoException();
                            return true;
                        case 45:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            boolean p = p(parcel.readInt());
                            parcel2.writeNoException();
                            parcel2.writeInt(p ? 1 : 0);
                            return true;
                        case 46:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            e();
                            parcel2.writeNoException();
                            return true;
                        case 47:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            a(parcel.readInt(), parcel.createTypedArrayList(b.CREATOR));
                            parcel2.writeNoException();
                            return true;
                        case 48:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            b(parcel.readInt(), parcel.createTypedArrayList(b.CREATOR));
                            parcel2.writeNoException();
                            return true;
                        case 49:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            a(ak.a.a(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            return true;
                        case 50:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            a(parcel.readInt(), parcel.readInt());
                            parcel2.writeNoException();
                            return true;
                        case 51:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            z q = q(parcel.readInt());
                            parcel2.writeNoException();
                            parcel2.writeStrongBinder(q != null ? q.asBinder() : null);
                            return true;
                        case 52:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            af r = r(parcel.readInt());
                            parcel2.writeNoException();
                            parcel2.writeStrongBinder(r != null ? r.asBinder() : null);
                            return true;
                        case 53:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            a(parcel.readInt(), z.a.a(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            return true;
                        case 54:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            g s = s(parcel.readInt());
                            parcel2.writeNoException();
                            parcel2.writeStrongBinder(s != null ? s.asBinder() : null);
                            return true;
                        case 55:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            boolean f3 = f();
                            parcel2.writeNoException();
                            parcel2.writeInt(f3 ? 1 : 0);
                            return true;
                        case 56:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                            a(parcel.readInt(), parcel.readLong());
                            parcel2.writeNoException();
                            return true;
                        default:
                            return super.onTransact(i2, parcel, parcel2, i3);
                    }
                }
                parcel2.writeString("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                return true;
            }
            return invokeCommon.booleanValue;
        }

        /* renamed from: com.ss.android.socialbase.downloader.downloader.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public static class C2072a implements i {
            public static /* synthetic */ Interceptable $ic;

            /* renamed from: a  reason: collision with root package name */
            public static i f75719a;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: b  reason: collision with root package name */
            public IBinder f75720b;

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
                this.f75720b = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void a(com.ss.android.socialbase.downloader.model.a aVar) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                        if (!this.f75720b.transact(1, obtain, obtain2, 0) && a.g() != null) {
                            a.g().a(aVar);
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
                return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f75720b : (IBinder) invokeV.objValue;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public boolean b(int i2) throws RemoteException {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeInt(i2);
                        if (!this.f75720b.transact(4, obtain, obtain2, 0) && a.g() != null) {
                            return a.g().b(i2);
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

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void c(int i2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeInt(i2);
                        if (!this.f75720b.transact(5, obtain, obtain2, 0) && a.g() != null) {
                            a.g().c(i2);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void d(int i2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeInt(i2);
                        if (!this.f75720b.transact(6, obtain, obtain2, 0) && a.g() != null) {
                            a.g().d(i2);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public long e(int i2) throws RemoteException {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048615, this, i2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeInt(i2);
                        if (!this.f75720b.transact(8, obtain, obtain2, 0) && a.g() != null) {
                            return a.g().e(i2);
                        }
                        obtain2.readException();
                        return obtain2.readLong();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeI.longValue;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public int f(int i2) throws RemoteException {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048618, this, i2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeInt(i2);
                        if (!this.f75720b.transact(9, obtain, obtain2, 0) && a.g() != null) {
                            return a.g().f(i2);
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

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public boolean g(int i2) throws RemoteException {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048620, this, i2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeInt(i2);
                        if (!this.f75720b.transact(10, obtain, obtain2, 0) && a.g() != null) {
                            return a.g().g(i2);
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

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public DownloadInfo h(int i2) throws RemoteException {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048621, this, i2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeInt(i2);
                        if (!this.f75720b.transact(11, obtain, obtain2, 0) && a.g() != null) {
                            return a.g().h(i2);
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

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public List<b> i(int i2) throws RemoteException {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048622, this, i2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeInt(i2);
                        if (!this.f75720b.transact(13, obtain, obtain2, 0) && a.g() != null) {
                            return a.g().i(i2);
                        }
                        obtain2.readException();
                        return obtain2.createTypedArrayList(b.CREATOR);
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (List) invokeI.objValue;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void j(int i2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeInt(i2);
                        if (!this.f75720b.transact(24, obtain, obtain2, 0) && a.g() != null) {
                            a.g().j(i2);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public boolean k(int i2) throws RemoteException {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048624, this, i2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeInt(i2);
                        if (!this.f75720b.transact(33, obtain, obtain2, 0) && a.g() != null) {
                            return a.g().k(i2);
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

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void l(int i2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeInt(i2);
                        if (!this.f75720b.transact(34, obtain, obtain2, 0) && a.g() != null) {
                            a.g().l(i2);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public int m(int i2) throws RemoteException {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048626, this, i2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeInt(i2);
                        if (!this.f75720b.transact(37, obtain, obtain2, 0) && a.g() != null) {
                            return a.g().m(i2);
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

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public boolean n(int i2) throws RemoteException {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048627, this, i2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeInt(i2);
                        if (!this.f75720b.transact(40, obtain, obtain2, 0) && a.g() != null) {
                            return a.g().n(i2);
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

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void o(int i2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048628, this, i2) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeInt(i2);
                        if (!this.f75720b.transact(41, obtain, obtain2, 0) && a.g() != null) {
                            a.g().o(i2);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public boolean p(int i2) throws RemoteException {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048629, this, i2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeInt(i2);
                        if (!this.f75720b.transact(45, obtain, obtain2, 0) && a.g() != null) {
                            return a.g().p(i2);
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

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public z q(int i2) throws RemoteException {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048630, this, i2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeInt(i2);
                        if (!this.f75720b.transact(51, obtain, obtain2, 0) && a.g() != null) {
                            return a.g().q(i2);
                        }
                        obtain2.readException();
                        return z.a.a(obtain2.readStrongBinder());
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (z) invokeI.objValue;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public af r(int i2) throws RemoteException {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048631, this, i2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeInt(i2);
                        if (!this.f75720b.transact(52, obtain, obtain2, 0) && a.g() != null) {
                            return a.g().r(i2);
                        }
                        obtain2.readException();
                        return af.a.a(obtain2.readStrongBinder());
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (af) invokeI.objValue;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public g s(int i2) throws RemoteException {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048632, this, i2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeInt(i2);
                        if (!this.f75720b.transact(54, obtain, obtain2, 0) && a.g() != null) {
                            return a.g().s(i2);
                        }
                        obtain2.readException();
                        return g.a.a(obtain2.readStrongBinder());
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (g) invokeI.objValue;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void a(int i2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeInt(i2);
                        if (!this.f75720b.transact(2, obtain, obtain2, 0) && a.g() != null) {
                            a.g().a(i2);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public List<DownloadInfo> c(String str) throws RemoteException {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeString(str);
                        if (!this.f75720b.transact(17, obtain, obtain2, 0) && a.g() != null) {
                            return a.g().c(str);
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

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public List<DownloadInfo> d(String str) throws RemoteException {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeString(str);
                        if (!this.f75720b.transact(18, obtain, obtain2, 0) && a.g() != null) {
                            return a.g().d(str);
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

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public DownloadInfo b(String str, String str2) throws RemoteException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, str, str2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        if (!this.f75720b.transact(15, obtain, obtain2, 0) && a.g() != null) {
                            return a.g().b(str, str2);
                        }
                        obtain2.readException();
                        return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (DownloadInfo) invokeLL.objValue;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public List<DownloadInfo> e(String str) throws RemoteException {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, str)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeString(str);
                        if (!this.f75720b.transact(32, obtain, obtain2, 0) && a.g() != null) {
                            return a.g().e(str);
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

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public boolean f() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        if (!this.f75720b.transact(55, obtain, obtain2, 0) && a.g() != null) {
                            return a.g().f();
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

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void a(int i2, boolean z) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeInt(i2);
                        obtain.writeInt(z ? 1 : 0);
                        if (!this.f75720b.transact(3, obtain, obtain2, 0) && a.g() != null) {
                            a.g().a(i2, z);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void c(int i2, boolean z) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeInt(i2);
                        obtain.writeInt(z ? 1 : 0);
                        if (!this.f75720b.transact(23, obtain, obtain2, 0) && a.g() != null) {
                            a.g().c(i2, z);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public boolean d() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        if (!this.f75720b.transact(35, obtain, obtain2, 0) && a.g() != null) {
                            return a.g().d();
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

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void e() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        if (!this.f75720b.transact(46, obtain, obtain2, 0) && a.g() != null) {
                            a.g().e();
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public List<DownloadInfo> b(String str) throws RemoteException {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeString(str);
                        if (!this.f75720b.transact(16, obtain, obtain2, 0) && a.g() != null) {
                            return a.g().b(str);
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

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void a() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        if (!this.f75720b.transact(7, obtain, obtain2, 0) && a.g() != null) {
                            a.g().a();
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void d(int i2, boolean z) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeInt(i2);
                        obtain.writeInt(z ? 1 : 0);
                        if (!this.f75720b.transact(36, obtain, obtain2, 0) && a.g() != null) {
                            a.g().d(i2, z);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public boolean c() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        if (!this.f75720b.transact(31, obtain, obtain2, 0) && a.g() != null) {
                            return a.g().c();
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

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public List<DownloadInfo> b() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        if (!this.f75720b.transact(19, obtain, obtain2, 0) && a.g() != null) {
                            return a.g().b();
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

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public List<DownloadInfo> a(String str) throws RemoteException {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeString(str);
                        if (!this.f75720b.transact(12, obtain, obtain2, 0) && a.g() != null) {
                            return a.g().a(str);
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

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void b(List<String> list) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048604, this, list) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeStringList(list);
                        if (!this.f75720b.transact(21, obtain, obtain2, 0) && a.g() != null) {
                            a.g().b(list);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public int a(String str, String str2) throws RemoteException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        if (!this.f75720b.transact(14, obtain, obtain2, 0) && a.g() != null) {
                            return a.g().a(str, str2);
                        }
                        obtain2.readException();
                        return obtain2.readInt();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeLL.intValue;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void b(int i2, boolean z) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeInt(i2);
                        obtain.writeInt(z ? 1 : 0);
                        if (!this.f75720b.transact(22, obtain, obtain2, 0) && a.g() != null) {
                            a.g().b(i2, z);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void a(List<String> list) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048594, this, list) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeStringList(list);
                        if (!this.f75720b.transact(20, obtain, obtain2, 0) && a.g() != null) {
                            a.g().a(list);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void b(int i2, int i3, com.ss.android.socialbase.downloader.depend.i iVar, int i4, boolean z) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iVar, Integer.valueOf(i4), Boolean.valueOf(z)}) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeInt(i2);
                        obtain.writeInt(i3);
                        obtain.writeStrongBinder(iVar != null ? iVar.asBinder() : null);
                        obtain.writeInt(i4);
                        obtain.writeInt(z ? 1 : 0);
                        if (!this.f75720b.transact(26, obtain, obtain2, 0) && a.g() != null) {
                            a.g().b(i2, i3, iVar, i4, z);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void a(int i2, int i3, com.ss.android.socialbase.downloader.depend.i iVar, int i4, boolean z) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iVar, Integer.valueOf(i4), Boolean.valueOf(z)}) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeInt(i2);
                        obtain.writeInt(i3);
                        obtain.writeStrongBinder(iVar != null ? iVar.asBinder() : null);
                        obtain.writeInt(i4);
                        obtain.writeInt(z ? 1 : 0);
                        if (!this.f75720b.transact(25, obtain, obtain2, 0) && a.g() != null) {
                            a.g().a(i2, i3, iVar, i4, z);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public boolean b(DownloadInfo downloadInfo) throws RemoteException {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, downloadInfo)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        if (downloadInfo != null) {
                            obtain.writeInt(1);
                            downloadInfo.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (!this.f75720b.transact(39, obtain, obtain2, 0) && a.g() != null) {
                            return a.g().b(downloadInfo);
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

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void a(int i2, int i3, com.ss.android.socialbase.downloader.depend.i iVar, int i4, boolean z, boolean z2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iVar, Integer.valueOf(i4), Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) {
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeStrongBinder(iVar != null ? iVar.asBinder() : null);
                    obtain.writeInt(i4);
                    int i5 = 1;
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i5 = 0;
                    }
                    obtain.writeInt(i5);
                    try {
                        if (!this.f75720b.transact(27, obtain, obtain2, 0) && a.g() != null) {
                            a.g().a(i2, i3, iVar, i4, z, z2);
                            obtain2.recycle();
                            obtain.recycle();
                            return;
                        }
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } catch (Throwable th) {
                        th = th;
                        obtain2.recycle();
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void b(int i2, List<b> list) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048602, this, i2, list) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeInt(i2);
                        obtain.writeTypedList(list);
                        if (!this.f75720b.transact(48, obtain, obtain2, 0) && a.g() != null) {
                            a.g().b(i2, list);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public boolean a(DownloadInfo downloadInfo) throws RemoteException {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, downloadInfo)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        if (downloadInfo != null) {
                            obtain.writeInt(1);
                            downloadInfo.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (!this.f75720b.transact(28, obtain, obtain2, 0) && a.g() != null) {
                            return a.g().a(downloadInfo);
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

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void a(int i2, Notification notification) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048587, this, i2, notification) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeInt(i2);
                        if (notification != null) {
                            obtain.writeInt(1);
                            notification.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (this.f75720b.transact(29, obtain, null, 1) || a.g() == null) {
                            return;
                        }
                        a.g().a(i2, notification);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void a(boolean z) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeInt(z ? 1 : 0);
                        if (this.f75720b.transact(30, obtain, null, 1) || a.g() == null) {
                            return;
                        }
                        a.g().a(z);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void a(b bVar) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        if (bVar != null) {
                            obtain.writeInt(1);
                            bVar.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (!this.f75720b.transact(38, obtain, obtain2, 0) && a.g() != null) {
                            a.g().a(bVar);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void a(int i2, int i3, long j2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeInt(i2);
                        obtain.writeInt(i3);
                        obtain.writeLong(j2);
                        if (!this.f75720b.transact(42, obtain, obtain2, 0) && a.g() != null) {
                            a.g().a(i2, i3, j2);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void a(int i2, int i3, int i4, long j2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j2)}) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeInt(i2);
                        obtain.writeInt(i3);
                        obtain.writeInt(i4);
                        obtain.writeLong(j2);
                        if (!this.f75720b.transact(43, obtain, obtain2, 0) && a.g() != null) {
                            a.g().a(i2, i3, i4, j2);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void a(int i2, int i3, int i4, int i5) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIIII(1048581, this, i2, i3, i4, i5) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeInt(i2);
                        obtain.writeInt(i3);
                        obtain.writeInt(i4);
                        obtain.writeInt(i5);
                        if (!this.f75720b.transact(44, obtain, obtain2, 0) && a.g() != null) {
                            a.g().a(i2, i3, i4, i5);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void a(int i2, List<b> list) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048589, this, i2, list) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeInt(i2);
                        obtain.writeTypedList(list);
                        if (!this.f75720b.transact(47, obtain, obtain2, 0) && a.g() != null) {
                            a.g().a(i2, list);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void a(ak akVar) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048591, this, akVar) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeStrongBinder(akVar != null ? akVar.asBinder() : null);
                        if (!this.f75720b.transact(49, obtain, obtain2, 0) && a.g() != null) {
                            a.g().a(akVar);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void a(int i2, int i3) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeInt(i2);
                        obtain.writeInt(i3);
                        if (!this.f75720b.transact(50, obtain, obtain2, 0) && a.g() != null) {
                            a.g().a(i2, i3);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void a(int i2, z zVar) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048588, this, i2, zVar) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeInt(i2);
                        obtain.writeStrongBinder(zVar != null ? zVar.asBinder() : null);
                        if (!this.f75720b.transact(53, obtain, obtain2, 0) && a.g() != null) {
                            a.g().a(i2, zVar);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void a(int i2, long j2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        obtain.writeInt(i2);
                        obtain.writeLong(j2);
                        if (!this.f75720b.transact(56, obtain, obtain2, 0) && a.g() != null) {
                            a.g().a(i2, j2);
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
