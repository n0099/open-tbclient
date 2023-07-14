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
/* loaded from: classes10.dex */
public interface b extends IInterface {

    /* loaded from: classes10.dex */
    public static abstract class a extends Binder implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.kwai.filedownloader.b.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public static class C0702a implements b {
            public static /* synthetic */ Interceptable $ic;
            public static b avL;
            public transient /* synthetic */ FieldHolder $fh;
            public IBinder mRemote;

            public C0702a(IBinder iBinder) {
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
                this.mRemote = iBinder;
            }

            @Override // com.kwai.filedownloader.b.b
            public final void DW() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        if (this.mRemote.transact(15, obtain, obtain2, 0) || a.DX() == null) {
                            obtain2.readException();
                        } else {
                            a.DX().DW();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.kwai.filedownloader.b.b
            public final boolean Z(String str, String str2) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        if (this.mRemote.transact(3, obtain, obtain2, 0) || a.DX() == null) {
                            obtain2.readException();
                            return obtain2.readInt() != 0;
                        }
                        return a.DX().Z(str, str2);
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeLL.booleanValue;
            }

            @Override // com.kwai.filedownloader.b.b
            public final void a(com.kwai.filedownloader.b.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                        if (this.mRemote.transact(1, obtain, null, 1) || a.DX() == null) {
                            return;
                        }
                        a.DX().a(aVar);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mRemote : (IBinder) invokeV.objValue;
            }

            @Override // com.kwai.filedownloader.b.b
            public final void b(com.kwai.filedownloader.b.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                        if (this.mRemote.transact(2, obtain, null, 1) || a.DX() == null) {
                            return;
                        }
                        a.DX().b(aVar);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // com.kwai.filedownloader.b.b
            public final void b(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwai.filedownloader.c.b bVar, boolean z3) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeCommon(1048581, this, new Object[]{str, str2, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), bVar, Boolean.valueOf(z3)}) != null) {
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    int i4 = 1;
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(z2 ? 1 : 0);
                    if (bVar != null) {
                        obtain.writeInt(1);
                        bVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!z3) {
                        i4 = 0;
                    }
                    obtain.writeInt(i4);
                    try {
                        if (this.mRemote.transact(4, obtain, obtain2, 0) || a.DX() == null) {
                            obtain2.readException();
                        } else {
                            a.DX().b(str, str2, z, i, i2, i3, z2, bVar, z3);
                        }
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
            public final boolean bW(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        obtain.writeInt(i);
                        if (this.mRemote.transact(5, obtain, obtain2, 0) || a.DX() == null) {
                            obtain2.readException();
                            return obtain2.readInt() != 0;
                        }
                        return a.DX().bW(i);
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeI.booleanValue;
            }

            @Override // com.kwai.filedownloader.b.b
            public final byte bX(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        obtain.writeInt(i);
                        if (this.mRemote.transact(10, obtain, obtain2, 0) || a.DX() == null) {
                            obtain2.readException();
                            return obtain2.readByte();
                        }
                        return a.DX().bX(i);
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeI.byteValue;
            }

            @Override // com.kwai.filedownloader.b.b
            public final boolean bY(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        obtain.writeInt(i);
                        if (this.mRemote.transact(14, obtain, obtain2, 0) || a.DX() == null) {
                            obtain2.readException();
                            return obtain2.readInt() != 0;
                        }
                        return a.DX().bY(i);
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeI.booleanValue;
            }

            @Override // com.kwai.filedownloader.b.b
            public final boolean cq(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        obtain.writeInt(i);
                        if (this.mRemote.transact(7, obtain, obtain2, 0) || a.DX() == null) {
                            obtain2.readException();
                            return obtain2.readInt() != 0;
                        }
                        return a.DX().cq(i);
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeI.booleanValue;
            }

            @Override // com.kwai.filedownloader.b.b
            public final long cr(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        obtain.writeInt(i);
                        if (this.mRemote.transact(8, obtain, obtain2, 0) || a.DX() == null) {
                            obtain2.readException();
                            return obtain2.readLong();
                        }
                        return a.DX().cr(i);
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeI.longValue;
            }

            @Override // com.kwai.filedownloader.b.b
            public final long cs(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        obtain.writeInt(i);
                        if (this.mRemote.transact(9, obtain, obtain2, 0) || a.DX() == null) {
                            obtain2.readException();
                            return obtain2.readLong();
                        }
                        return a.DX().cs(i);
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeI.longValue;
            }

            @Override // com.kwai.filedownloader.b.b
            public final boolean isIdle() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        if (this.mRemote.transact(11, obtain, obtain2, 0) || a.DX() == null) {
                            obtain2.readException();
                            return obtain2.readInt() != 0;
                        }
                        return a.DX().isIdle();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeV.booleanValue;
            }

            @Override // com.kwai.filedownloader.b.b
            public final void pauseAllTasks() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        if (this.mRemote.transact(6, obtain, obtain2, 0) || a.DX() == null) {
                            obtain2.readException();
                        } else {
                            a.DX().pauseAllTasks();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.kwai.filedownloader.b.b
            public final void startForeground(int i, Notification notification) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048590, this, i, notification) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        obtain.writeInt(i);
                        if (notification != null) {
                            obtain.writeInt(1);
                            notification.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (this.mRemote.transact(12, obtain, null, 1) || a.DX() == null) {
                            return;
                        }
                        a.DX().startForeground(i, notification);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // com.kwai.filedownloader.b.b
            public final void stopForeground(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        obtain.writeInt(z ? 1 : 0);
                        if (this.mRemote.transact(13, obtain, null, 1) || a.DX() == null) {
                            return;
                        }
                        a.DX().stopForeground(z);
                    } finally {
                        obtain.recycle();
                    }
                }
            }
        }

        public a() {
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
            attachInterface(this, "com.kwai.filedownloader.i.IFileDownloadIPCService");
        }

        public static b DX() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? C0702a.avL : (b) invokeV.objValue;
        }

        public static b a(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new C0702a(iBinder) : (b) queryLocalInterface;
            }
            return (b) invokeL.objValue;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (IBinder) invokeV.objValue;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), parcel, parcel2, Integer.valueOf(i2)})) == null) {
                if (i == 1598968902) {
                    parcel2.writeString("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    return true;
                }
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        a(a.AbstractBinderC0700a.c(parcel.readStrongBinder()));
                        return true;
                    case 2:
                        parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        b(a.AbstractBinderC0700a.c(parcel.readStrongBinder()));
                        return true;
                    case 3:
                        parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        boolean Z = Z(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(Z ? 1 : 0);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        b(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0 ? com.kwai.filedownloader.c.b.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        boolean bW = bW(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(bW ? 1 : 0);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        pauseAllTasks();
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        boolean cq = cq(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(cq ? 1 : 0);
                        return true;
                    case 8:
                        parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        long cr = cr(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeLong(cr);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        long cs = cs(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeLong(cs);
                        return true;
                    case 10:
                        parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        byte bX = bX(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeByte(bX);
                        return true;
                    case 11:
                        parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        boolean isIdle = isIdle();
                        parcel2.writeNoException();
                        parcel2.writeInt(isIdle ? 1 : 0);
                        return true;
                    case 12:
                        parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        startForeground(parcel.readInt(), parcel.readInt() != 0 ? (Notification) Notification.CREATOR.createFromParcel(parcel) : null);
                        return true;
                    case 13:
                        parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        stopForeground(parcel.readInt() != 0);
                        return true;
                    case 14:
                        parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        boolean bY = bY(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(bY ? 1 : 0);
                        return true;
                    case 15:
                        parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                        DW();
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            return invokeCommon.booleanValue;
        }
    }

    void DW();

    boolean Z(String str, String str2);

    void a(com.kwai.filedownloader.b.a aVar);

    void b(com.kwai.filedownloader.b.a aVar);

    void b(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwai.filedownloader.c.b bVar, boolean z3);

    boolean bW(int i);

    byte bX(int i);

    boolean bY(int i);

    boolean cq(int i);

    long cr(int i);

    long cs(int i);

    boolean isIdle();

    void pauseAllTasks();

    void startForeground(int i, Notification notification);

    void stopForeground(boolean z);
}
