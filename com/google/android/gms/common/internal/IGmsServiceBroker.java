package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
/* loaded from: classes8.dex */
public interface IGmsServiceBroker extends IInterface {
    @KeepForSdk
    void getService(@NonNull IGmsCallbacks iGmsCallbacks, @Nullable GetServiceRequest getServiceRequest) throws RemoteException;

    /* loaded from: classes8.dex */
    public static abstract class Stub extends Binder implements IGmsServiceBroker {
        @Override // android.os.IInterface
        @NonNull
        @KeepForSdk
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.common.internal.IGmsServiceBroker");
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i, @NonNull Parcel parcel, @Nullable Parcel parcel2, int i2) throws RemoteException {
            IGmsCallbacks zzaaVar;
            if (i > 16777215) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder readStrongBinder = parcel.readStrongBinder();
            GetServiceRequest getServiceRequest = null;
            if (readStrongBinder == null) {
                zzaaVar = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsCallbacks");
                if (queryLocalInterface instanceof IGmsCallbacks) {
                    zzaaVar = (IGmsCallbacks) queryLocalInterface;
                } else {
                    zzaaVar = new zzaa(readStrongBinder);
                }
            }
            if (i == 46) {
                if (parcel.readInt() != 0) {
                    getServiceRequest = GetServiceRequest.CREATOR.createFromParcel(parcel);
                }
                getService(zzaaVar, getServiceRequest);
                Preconditions.checkNotNull(parcel2);
                parcel2.writeNoException();
                return true;
            } else if (i == 47) {
                if (parcel.readInt() != 0) {
                    zzaj.CREATOR.createFromParcel(parcel);
                }
                throw new UnsupportedOperationException();
            } else {
                parcel.readInt();
                if (i != 4) {
                    parcel.readString();
                    if (i != 1) {
                        if (i != 2 && i != 23 && i != 25 && i != 27) {
                            if (i != 30) {
                                if (i != 34) {
                                    if (i != 41 && i != 43 && i != 37 && i != 38) {
                                        switch (i) {
                                            case 9:
                                                parcel.readString();
                                                parcel.createStringArray();
                                                parcel.readString();
                                                parcel.readStrongBinder();
                                                parcel.readString();
                                                if (parcel.readInt() != 0) {
                                                    Bundle bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                                                    break;
                                                }
                                                break;
                                            case 10:
                                                parcel.readString();
                                                parcel.createStringArray();
                                                break;
                                            case 19:
                                                parcel.readStrongBinder();
                                                if (parcel.readInt() != 0) {
                                                    Bundle bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                                                    break;
                                                }
                                                break;
                                        }
                                    }
                                } else {
                                    parcel.readString();
                                }
                            }
                            parcel.createStringArray();
                            parcel.readString();
                            if (parcel.readInt() != 0) {
                                Bundle bundle3 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                            }
                        }
                        if (parcel.readInt() != 0) {
                            Bundle bundle4 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                    } else {
                        parcel.readString();
                        parcel.createStringArray();
                        parcel.readString();
                        if (parcel.readInt() != 0) {
                            Bundle bundle5 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                    }
                }
                throw new UnsupportedOperationException();
            }
        }
    }
}
