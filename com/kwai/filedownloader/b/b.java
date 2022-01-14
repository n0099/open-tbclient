package com.kwai.filedownloader.b;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.b.a;
/* loaded from: classes3.dex */
public interface b extends IInterface {

    /* loaded from: classes3.dex */
    public static abstract class a extends Binder implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.kwai.filedownloader.b.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C2159a implements b {
            public static /* synthetic */ Interceptable $ic;
            public static b a;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: b  reason: collision with root package name */
            public IBinder f58164b;

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
                this.f58164b = iBinder;
            }

            @Override // com.kwai.filedownloader.b.b
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        if (this.f58164b.transact(6, obtain, obtain2, 0) || a.d() == null) {
                            obtain2.readException();
                        } else {
                            a.d().a();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.kwai.filedownloader.b.b
            public void a(int i2, Notification notification) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, notification) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        obtain.writeInt(i2);
                        if (notification != null) {
                            obtain.writeInt(1);
                            notification.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (this.f58164b.transact(12, obtain, null, 1) || a.d() == null) {
                            return;
                        }
                        a.d().a(i2, notification);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // com.kwai.filedownloader.b.b
            public void a(com.kwai.filedownloader.b.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                        if (this.f58164b.transact(1, obtain, null, 1) || a.d() == null) {
                            return;
                        }
                        a.d().a(aVar);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // com.kwai.filedownloader.b.b
            public void a(String str, String str2, boolean z, int i2, int i3, int i4, boolean z2, com.kwai.filedownloader.c.b bVar, boolean z3) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z2), bVar, Boolean.valueOf(z3)}) != null) {
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    int i5 = 1;
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    obtain.writeInt(z2 ? 1 : 0);
                    if (bVar != null) {
                        obtain.writeInt(1);
                        bVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!z3) {
                        i5 = 0;
                    }
                    obtain.writeInt(i5);
                    try {
                        if (this.f58164b.transact(4, obtain, obtain2, 0) || a.d() == null) {
                            obtain2.readException();
                            obtain2.recycle();
                            obtain.recycle();
                            return;
                        }
                        a.d().a(str, str2, z, i2, i3, i4, z2, bVar, z3);
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

            @Override // com.kwai.filedownloader.b.b
            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        obtain.writeInt(z ? 1 : 0);
                        if (this.f58164b.transact(13, obtain, null, 1) || a.d() == null) {
                            return;
                        }
                        a.d().a(z);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // com.kwai.filedownloader.b.b
            public boolean a(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        obtain.writeInt(i2);
                        if (this.f58164b.transact(5, obtain, obtain2, 0) || a.d() == null) {
                            obtain2.readException();
                            return obtain2.readInt() != 0;
                        }
                        return a.d().a(i2);
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeI.booleanValue;
            }

            @Override // com.kwai.filedownloader.b.b
            public boolean a(String str, String str2) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        if (this.f58164b.transact(3, obtain, obtain2, 0) || a.d() == null) {
                            obtain2.readException();
                            return obtain2.readInt() != 0;
                        }
                        return a.d().a(str, str2);
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeLL.booleanValue;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f58164b : (IBinder) invokeV.objValue;
            }

            @Override // com.kwai.filedownloader.b.b
            public void b(com.kwai.filedownloader.b.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                        if (this.f58164b.transact(2, obtain, null, 1) || a.d() == null) {
                            return;
                        }
                        a.d().b(aVar);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // com.kwai.filedownloader.b.b
            public boolean b() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        if (this.f58164b.transact(11, obtain, obtain2, 0) || a.d() == null) {
                            obtain2.readException();
                            return obtain2.readInt() != 0;
                        }
                        return a.d().b();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeV.booleanValue;
            }

            @Override // com.kwai.filedownloader.b.b
            public boolean b(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        obtain.writeInt(i2);
                        if (this.f58164b.transact(7, obtain, obtain2, 0) || a.d() == null) {
                            obtain2.readException();
                            return obtain2.readInt() != 0;
                        }
                        return a.d().b(i2);
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeI.booleanValue;
            }

            @Override // com.kwai.filedownloader.b.b
            public long c(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        obtain.writeInt(i2);
                        if (this.f58164b.transact(8, obtain, obtain2, 0) || a.d() == null) {
                            obtain2.readException();
                            return obtain2.readLong();
                        }
                        return a.d().c(i2);
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeI.longValue;
            }

            @Override // com.kwai.filedownloader.b.b
            public void c() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        if (this.f58164b.transact(15, obtain, obtain2, 0) || a.d() == null) {
                            obtain2.readException();
                        } else {
                            a.d().c();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.kwai.filedownloader.b.b
            public long d(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        obtain.writeInt(i2);
                        if (this.f58164b.transact(9, obtain, obtain2, 0) || a.d() == null) {
                            obtain2.readException();
                            return obtain2.readLong();
                        }
                        return a.d().d(i2);
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeI.longValue;
            }

            @Override // com.kwai.filedownloader.b.b
            public byte e(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        obtain.writeInt(i2);
                        if (this.f58164b.transact(10, obtain, obtain2, 0) || a.d() == null) {
                            obtain2.readException();
                            return obtain2.readByte();
                        }
                        return a.d().e(i2);
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeI.byteValue;
            }

            @Override // com.kwai.filedownloader.b.b
            public boolean f(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        obtain.writeInt(i2);
                        if (this.f58164b.transact(14, obtain, obtain2, 0) || a.d() == null) {
                            obtain2.readException();
                            return obtain2.readInt() != 0;
                        }
                        return a.d().f(i2);
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeI.booleanValue;
            }
        }

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
            attachInterface(this, "com.kwai.filedownloader.i.IFileDownloadIPCService");
        }

        public static b a(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new C2159a(iBinder) : (b) queryLocalInterface;
            }
            return (b) invokeL.objValue;
        }

        public static b d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? C2159a.a : (b) invokeV.objValue;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (IBinder) invokeV.objValue;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), parcel, parcel2, Integer.valueOf(i3)})) == null) {
                if (i2 == 1598968902) {
                    parcel2.writeString("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    return true;
                }
                switch (i2) {
                    case 1:
                        parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        a(a.AbstractBinderC2157a.a(parcel.readStrongBinder()));
                        return true;
                    case 2:
                        parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        b(a.AbstractBinderC2157a.a(parcel.readStrongBinder()));
                        return true;
                    case 3:
                        parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        boolean a = a(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(a ? 1 : 0);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        a(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0 ? com.kwai.filedownloader.c.b.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        boolean a2 = a(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(a2 ? 1 : 0);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        a();
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        boolean b2 = b(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(b2 ? 1 : 0);
                        return true;
                    case 8:
                        parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        long c2 = c(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeLong(c2);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        long d2 = d(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeLong(d2);
                        return true;
                    case 10:
                        parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        byte e2 = e(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeByte(e2);
                        return true;
                    case 11:
                        parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        boolean b3 = b();
                        parcel2.writeNoException();
                        parcel2.writeInt(b3 ? 1 : 0);
                        return true;
                    case 12:
                        parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        a(parcel.readInt(), parcel.readInt() != 0 ? (Notification) Notification.CREATOR.createFromParcel(parcel) : null);
                        return true;
                    case 13:
                        parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        a(parcel.readInt() != 0);
                        return true;
                    case 14:
                        parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        boolean f2 = f(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(f2 ? 1 : 0);
                        return true;
                    case 15:
                        parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        c();
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i2, parcel, parcel2, i3);
                }
            }
            return invokeCommon.booleanValue;
        }
    }

    void a();

    void a(int i2, Notification notification);

    void a(com.kwai.filedownloader.b.a aVar);

    void a(String str, String str2, boolean z, int i2, int i3, int i4, boolean z2, com.kwai.filedownloader.c.b bVar, boolean z3);

    void a(boolean z);

    boolean a(int i2);

    boolean a(String str, String str2);

    void b(com.kwai.filedownloader.b.a aVar);

    boolean b();

    boolean b(int i2);

    long c(int i2);

    void c();

    long d(int i2);

    byte e(int i2);

    boolean f(int i2);
}
