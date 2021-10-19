package com.ss.android.socialbase.downloader.depend;

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
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes10.dex */
public interface i extends IInterface {
    int a() throws RemoteException;

    void a(DownloadInfo downloadInfo) throws RemoteException;

    void a(DownloadInfo downloadInfo, BaseException baseException) throws RemoteException;

    void b(DownloadInfo downloadInfo) throws RemoteException;

    void b(DownloadInfo downloadInfo, BaseException baseException) throws RemoteException;

    void c(DownloadInfo downloadInfo) throws RemoteException;

    void c(DownloadInfo downloadInfo, BaseException baseException) throws RemoteException;

    void d(DownloadInfo downloadInfo) throws RemoteException;

    void e(DownloadInfo downloadInfo) throws RemoteException;

    void f(DownloadInfo downloadInfo) throws RemoteException;

    void g(DownloadInfo downloadInfo) throws RemoteException;

    void h(DownloadInfo downloadInfo) throws RemoteException;

    void i(DownloadInfo downloadInfo) throws RemoteException;

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
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
        }

        public static i a(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                if (queryLocalInterface != null && (queryLocalInterface instanceof i)) {
                    return (i) queryLocalInterface;
                }
                return new C2070a(iBinder);
            }
            return (i) invokeL.objValue;
        }

        public static i b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? C2070a.f76227a : (i) invokeV.objValue;
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
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                            int a2 = a();
                            parcel2.writeNoException();
                            parcel2.writeInt(a2);
                            return true;
                        case 2:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                            a(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                            parcel2.writeNoException();
                            return true;
                        case 3:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                            b(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                            parcel2.writeNoException();
                            return true;
                        case 4:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                            c(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                            parcel2.writeNoException();
                            return true;
                        case 5:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                            d(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                            parcel2.writeNoException();
                            return true;
                        case 6:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                            e(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                            parcel2.writeNoException();
                            return true;
                        case 7:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                            a(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? BaseException.CREATOR.createFromParcel(parcel) : null);
                            parcel2.writeNoException();
                            return true;
                        case 8:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                            f(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                            parcel2.writeNoException();
                            return true;
                        case 9:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                            g(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                            parcel2.writeNoException();
                            return true;
                        case 10:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                            h(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                            parcel2.writeNoException();
                            return true;
                        case 11:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                            b(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? BaseException.CREATOR.createFromParcel(parcel) : null);
                            parcel2.writeNoException();
                            return true;
                        case 12:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                            c(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? BaseException.CREATOR.createFromParcel(parcel) : null);
                            parcel2.writeNoException();
                            return true;
                        case 13:
                            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                            i(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                            parcel2.writeNoException();
                            return true;
                        default:
                            return super.onTransact(i2, parcel, parcel2, i3);
                    }
                }
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                return true;
            }
            return invokeCommon.booleanValue;
        }

        /* renamed from: com.ss.android.socialbase.downloader.depend.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public static class C2070a implements i {
            public static /* synthetic */ Interceptable $ic;

            /* renamed from: a  reason: collision with root package name */
            public static i f76227a;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: b  reason: collision with root package name */
            public IBinder f76228b;

            public C2070a(IBinder iBinder) {
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
                this.f76228b = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public int a() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                        if (!this.f76228b.transact(1, obtain, obtain2, 0) && a.b() != null) {
                            return a.b().a();
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

            @Override // android.os.IInterface
            public IBinder asBinder() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f76228b : (IBinder) invokeV.objValue;
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void b(DownloadInfo downloadInfo) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048580, this, downloadInfo) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                        if (downloadInfo != null) {
                            obtain.writeInt(1);
                            downloadInfo.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (!this.f76228b.transact(3, obtain, obtain2, 0) && a.b() != null) {
                            a.b().b(downloadInfo);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void c(DownloadInfo downloadInfo) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048582, this, downloadInfo) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                        if (downloadInfo != null) {
                            obtain.writeInt(1);
                            downloadInfo.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (!this.f76228b.transact(4, obtain, obtain2, 0) && a.b() != null) {
                            a.b().c(downloadInfo);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void d(DownloadInfo downloadInfo) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, downloadInfo) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                        if (downloadInfo != null) {
                            obtain.writeInt(1);
                            downloadInfo.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (!this.f76228b.transact(5, obtain, obtain2, 0) && a.b() != null) {
                            a.b().d(downloadInfo);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void e(DownloadInfo downloadInfo) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048585, this, downloadInfo) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                        if (downloadInfo != null) {
                            obtain.writeInt(1);
                            downloadInfo.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (!this.f76228b.transact(6, obtain, obtain2, 0) && a.b() != null) {
                            a.b().e(downloadInfo);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void f(DownloadInfo downloadInfo) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048586, this, downloadInfo) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                        if (downloadInfo != null) {
                            obtain.writeInt(1);
                            downloadInfo.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (!this.f76228b.transact(8, obtain, obtain2, 0) && a.b() != null) {
                            a.b().f(downloadInfo);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void g(DownloadInfo downloadInfo) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048587, this, downloadInfo) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                        if (downloadInfo != null) {
                            obtain.writeInt(1);
                            downloadInfo.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (!this.f76228b.transact(9, obtain, obtain2, 0) && a.b() != null) {
                            a.b().g(downloadInfo);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void h(DownloadInfo downloadInfo) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048588, this, downloadInfo) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                        if (downloadInfo != null) {
                            obtain.writeInt(1);
                            downloadInfo.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (!this.f76228b.transact(10, obtain, obtain2, 0) && a.b() != null) {
                            a.b().h(downloadInfo);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void i(DownloadInfo downloadInfo) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048589, this, downloadInfo) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                        if (downloadInfo != null) {
                            obtain.writeInt(1);
                            downloadInfo.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (!this.f76228b.transact(13, obtain, obtain2, 0) && a.b() != null) {
                            a.b().i(downloadInfo);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void a(DownloadInfo downloadInfo) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                        if (downloadInfo != null) {
                            obtain.writeInt(1);
                            downloadInfo.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (!this.f76228b.transact(2, obtain, obtain2, 0) && a.b() != null) {
                            a.b().a(downloadInfo);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void b(DownloadInfo downloadInfo, BaseException baseException) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048581, this, downloadInfo, baseException) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                        if (downloadInfo != null) {
                            obtain.writeInt(1);
                            downloadInfo.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (baseException != null) {
                            obtain.writeInt(1);
                            baseException.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (!this.f76228b.transact(11, obtain, obtain2, 0) && a.b() != null) {
                            a.b().b(downloadInfo, baseException);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void c(DownloadInfo downloadInfo, BaseException baseException) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048583, this, downloadInfo, baseException) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                        if (downloadInfo != null) {
                            obtain.writeInt(1);
                            downloadInfo.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (baseException != null) {
                            obtain.writeInt(1);
                            baseException.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (!this.f76228b.transact(12, obtain, obtain2, 0) && a.b() != null) {
                            a.b().c(downloadInfo, baseException);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void a(DownloadInfo downloadInfo, BaseException baseException) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo, baseException) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                        if (downloadInfo != null) {
                            obtain.writeInt(1);
                            downloadInfo.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (baseException != null) {
                            obtain.writeInt(1);
                            baseException.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (!this.f76228b.transact(7, obtain, obtain2, 0) && a.b() != null) {
                            a.b().a(downloadInfo, baseException);
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
