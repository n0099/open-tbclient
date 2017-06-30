package com.xiaomi.metok.geofencing;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;
/* loaded from: classes2.dex */
public interface c extends IInterface {

    /* loaded from: classes2.dex */
    public static abstract class a extends Binder implements c {

        /* renamed from: com.xiaomi.metok.geofencing.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0099a implements c {
            private IBinder a;

            C0099a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.xiaomi.metok.geofencing.c
            public String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.metok.geofencing.IGeoFencing");
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaomi.metok.geofencing.c
            public void a(double d, double d2, float f, long j, PendingIntent pendingIntent, String str, String str2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.metok.geofencing.IGeoFencing");
                    obtain.writeDouble(d);
                    obtain.writeDouble(d2);
                    obtain.writeFloat(f);
                    obtain.writeLong(j);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.xiaomi.metok.geofencing.c
            public void a(double d, double d2, float f, long j, String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.metok.geofencing.IGeoFencing");
                    obtain.writeDouble(d);
                    obtain.writeDouble(d2);
                    obtain.writeFloat(f);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.a.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.xiaomi.metok.geofencing.c
            public void a(PendingIntent pendingIntent) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.metok.geofencing.IGeoFencing");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(9, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.xiaomi.metok.geofencing.c
            public void a(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.metok.geofencing.IGeoFencing");
                    obtain.writeString(str);
                    this.a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.xiaomi.metok.geofencing.c
            public void a(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.metok.geofencing.IGeoFencing");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.xiaomi.metok.geofencing.c
            public void a(List<String> list, String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.metok.geofencing.IGeoFencing");
                    obtain.writeStringList(list);
                    obtain.writeString(str);
                    this.a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.xiaomi.metok.geofencing.c
            public int b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.metok.geofencing.IGeoFencing");
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaomi.metok.geofencing.c
            public List<String> b(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.metok.geofencing.IGeoFencing");
                    obtain.writeString(str);
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createStringArrayList();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.metok.geofencing.IGeoFencing");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof c)) ? new C0099a(iBinder) : (c) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.xiaomi.metok.geofencing.IGeoFencing");
                    a(parcel.createStringArrayList(), parcel.readString());
                    return true;
                case 2:
                    parcel.enforceInterface("com.xiaomi.metok.geofencing.IGeoFencing");
                    a(parcel.readString());
                    return true;
                case 3:
                    parcel.enforceInterface("com.xiaomi.metok.geofencing.IGeoFencing");
                    String a = a();
                    parcel2.writeNoException();
                    parcel2.writeString(a);
                    return true;
                case 4:
                    parcel.enforceInterface("com.xiaomi.metok.geofencing.IGeoFencing");
                    List<String> b = b(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeStringList(b);
                    return true;
                case 5:
                    parcel.enforceInterface("com.xiaomi.metok.geofencing.IGeoFencing");
                    int b2 = b();
                    parcel2.writeNoException();
                    parcel2.writeInt(b2);
                    return true;
                case 6:
                    parcel.enforceInterface("com.xiaomi.metok.geofencing.IGeoFencing");
                    a(parcel.readDouble(), parcel.readDouble(), parcel.readFloat(), parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
                    return true;
                case 7:
                    parcel.enforceInterface("com.xiaomi.metok.geofencing.IGeoFencing");
                    a(parcel.readDouble(), parcel.readDouble(), parcel.readFloat(), parcel.readLong(), parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString());
                    return true;
                case 8:
                    parcel.enforceInterface("com.xiaomi.metok.geofencing.IGeoFencing");
                    a(parcel.readString(), parcel.readString());
                    return true;
                case 9:
                    parcel.enforceInterface("com.xiaomi.metok.geofencing.IGeoFencing");
                    a(parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.xiaomi.metok.geofencing.IGeoFencing");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String a();

    void a(double d, double d2, float f, long j, PendingIntent pendingIntent, String str, String str2);

    void a(double d, double d2, float f, long j, String str, String str2, String str3);

    void a(PendingIntent pendingIntent);

    void a(String str);

    void a(String str, String str2);

    void a(List<String> list, String str);

    int b();

    List<String> b(String str);
}
