package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
/* loaded from: classes.dex */
public class ad {
    public static int a(Parcel parcel) {
        return b(parcel, 20293);
    }

    public static void a(Parcel parcel, int i) {
        c(parcel, i);
    }

    public static void a(Parcel parcel, int i, byte b) {
        b(parcel, i, 4);
        parcel.writeInt(b);
    }

    public static void a(Parcel parcel, int i, double d) {
        b(parcel, i, 8);
        parcel.writeDouble(d);
    }

    public static void a(Parcel parcel, int i, float f) {
        b(parcel, i, 4);
        parcel.writeFloat(f);
    }

    public static void a(Parcel parcel, int i, int i2) {
        b(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static void a(Parcel parcel, int i, long j) {
        b(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void a(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int b = b(parcel, i);
        parcel.writeBundle(bundle);
        c(parcel, b);
    }

    public static void a(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int b = b(parcel, i);
        parcel.writeStrongBinder(iBinder);
        c(parcel, b);
    }

    public static void a(Parcel parcel, int i, Parcel parcel2, boolean z) {
        if (parcel2 == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int b = b(parcel, i);
        parcel.appendFrom(parcel2, 0, parcel2.dataSize());
        c(parcel, b);
    }

    public static void a(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int b = b(parcel, i);
        parcelable.writeToParcel(parcel, i2);
        c(parcel, b);
    }

    public static void a(Parcel parcel, int i, String str, boolean z) {
        if (str == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int b = b(parcel, i);
        parcel.writeString(str);
        c(parcel, b);
    }

    public static void a(Parcel parcel, int i, List list, boolean z) {
        if (list == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int b = b(parcel, i);
        parcel.writeStringList(list);
        c(parcel, b);
    }

    public static void a(Parcel parcel, int i, short s) {
        b(parcel, i, 4);
        parcel.writeInt(s);
    }

    public static void a(Parcel parcel, int i, boolean z) {
        b(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void a(Parcel parcel, int i, byte[] bArr, boolean z) {
        if (bArr == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int b = b(parcel, i);
        parcel.writeByteArray(bArr);
        c(parcel, b);
    }

    public static void a(Parcel parcel, int i, Parcelable[] parcelableArr, int i2, boolean z) {
        if (parcelableArr == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int b = b(parcel, i);
        parcel.writeInt(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                a(parcel, parcelable, i2);
            }
        }
        c(parcel, b);
    }

    public static void a(Parcel parcel, int i, String[] strArr, boolean z) {
        if (strArr == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int b = b(parcel, i);
        parcel.writeStringArray(strArr);
        c(parcel, b);
    }

    private static void a(Parcel parcel, Parcelable parcelable, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    private static int b(Parcel parcel, int i) {
        parcel.writeInt((-65536) | i);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void b(Parcel parcel, int i, int i2) {
        if (i2 < 65535) {
            parcel.writeInt((i2 << 16) | i);
            return;
        }
        parcel.writeInt((-65536) | i);
        parcel.writeInt(i2);
    }

    public static void b(Parcel parcel, int i, List list, boolean z) {
        if (list == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int b = b(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            Parcelable parcelable = (Parcelable) list.get(i2);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                a(parcel, parcelable, 0);
            }
        }
        c(parcel, b);
    }

    private static void c(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(dataPosition - i);
        parcel.setDataPosition(dataPosition);
    }

    public static void c(Parcel parcel, int i, List list, boolean z) {
        if (list == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int b = b(parcel, i);
        parcel.writeList(list);
        c(parcel, b);
    }
}
