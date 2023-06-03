package com.yy.render;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes10.dex */
public interface ITransDataListener extends IInterface {

    /* loaded from: classes10.dex */
    public static class Default implements ITransDataListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.yy.render.ITransDataListener
        public void log(String str, int i, String str2, String str3) throws RemoteException {
        }

        @Override // com.yy.render.ITransDataListener
        public void transBitmap(String str, Bitmap bitmap) throws RemoteException {
        }

        @Override // com.yy.render.ITransDataListener
        public String transBitmapForStr(String str, Bitmap bitmap) throws RemoteException {
            return null;
        }

        @Override // com.yy.render.ITransDataListener
        public void transBundle(String str, Bundle bundle) throws RemoteException {
        }

        @Override // com.yy.render.ITransDataListener
        public String transBundleForStr(String str, Bundle bundle) throws RemoteException {
            return null;
        }

        @Override // com.yy.render.ITransDataListener
        public void transData(String str, String str2) throws RemoteException {
        }

        @Override // com.yy.render.ITransDataListener
        public String transDataForStr(String str, String str2) throws RemoteException {
            return null;
        }
    }

    void log(String str, int i, String str2, String str3) throws RemoteException;

    void transBitmap(String str, Bitmap bitmap) throws RemoteException;

    String transBitmapForStr(String str, Bitmap bitmap) throws RemoteException;

    void transBundle(String str, Bundle bundle) throws RemoteException;

    String transBundleForStr(String str, Bundle bundle) throws RemoteException;

    void transData(String str, String str2) throws RemoteException;

    String transDataForStr(String str, String str2) throws RemoteException;

    /* loaded from: classes10.dex */
    public static abstract class Stub extends Binder implements ITransDataListener {
        public static final String DESCRIPTOR = "com.yy.render.ITransDataListener";
        public static final int TRANSACTION_log = 7;
        public static final int TRANSACTION_transBitmap = 5;
        public static final int TRANSACTION_transBitmapForStr = 6;
        public static final int TRANSACTION_transBundle = 3;
        public static final int TRANSACTION_transBundleForStr = 4;
        public static final int TRANSACTION_transData = 1;
        public static final int TRANSACTION_transDataForStr = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        /* loaded from: classes10.dex */
        public static class Proxy implements ITransDataListener {
            public static ITransDataListener sDefaultImpl;
            public IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.yy.render.ITransDataListener
            public void log(String str, int i, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().log(str, i, str2, str3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.yy.render.ITransDataListener
            public void transBitmap(String str, Bitmap bitmap) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (bitmap != null) {
                        obtain.writeInt(1);
                        bitmap.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().transBitmap(str, bitmap);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.yy.render.ITransDataListener
            public String transBitmapForStr(String str, Bitmap bitmap) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (bitmap != null) {
                        obtain.writeInt(1);
                        bitmap.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().transBitmapForStr(str, bitmap);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.yy.render.ITransDataListener
            public void transBundle(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().transBundle(str, bundle);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.yy.render.ITransDataListener
            public String transBundleForStr(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().transBundleForStr(str, bundle);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.yy.render.ITransDataListener
            public String transDataForStr(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().transDataForStr(str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.yy.render.ITransDataListener
            public void transData(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().transData(str, str2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ITransDataListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static ITransDataListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ITransDataListener)) {
                return (ITransDataListener) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static boolean setDefaultImpl(ITransDataListener iTransDataListener) {
            if (Proxy.sDefaultImpl == null) {
                if (iTransDataListener != null) {
                    Proxy.sDefaultImpl = iTransDataListener;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                Bundle bundle = null;
                Bitmap bitmap = null;
                Bitmap bitmap2 = null;
                Bundle bundle2 = null;
                switch (i) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        transData(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        String transDataForStr = transDataForStr(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(transDataForStr);
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        String readString = parcel.readString();
                        if (parcel.readInt() != 0) {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        transBundle(readString, bundle);
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        String readString2 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        String transBundleForStr = transBundleForStr(readString2, bundle2);
                        parcel2.writeNoException();
                        parcel2.writeString(transBundleForStr);
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        String readString3 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            bitmap2 = (Bitmap) Bitmap.CREATOR.createFromParcel(parcel);
                        }
                        transBitmap(readString3, bitmap2);
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        String readString4 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            bitmap = (Bitmap) Bitmap.CREATOR.createFromParcel(parcel);
                        }
                        String transBitmapForStr = transBitmapForStr(readString4, bitmap);
                        parcel2.writeNoException();
                        parcel2.writeString(transBitmapForStr);
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        log(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }
    }
}
