package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ac {

    /* loaded from: classes.dex */
    public class a extends RuntimeException {
        public a(String str, Parcel parcel) {
            super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
        }
    }

    public static int a(int i) {
        return 65535 & i;
    }

    public static int a(Parcel parcel) {
        return parcel.readInt();
    }

    public static int a(Parcel parcel, int i) {
        return (i & (-65536)) != -65536 ? (i >> 16) & 65535 : parcel.readInt();
    }

    public static Parcelable a(Parcel parcel, int i, Parcelable.Creator creator) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(a2 + dataPosition);
        return parcelable;
    }

    private static void a(Parcel parcel, int i, int i2) {
        int a2 = a(parcel, i);
        if (a2 != i2) {
            throw new a("Expected size " + i2 + " got " + a2 + " (0x" + Integer.toHexString(a2) + ")", parcel);
        }
    }

    public static void a(Parcel parcel, int i, List list, ClassLoader classLoader) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return;
        }
        parcel.readList(list, classLoader);
        parcel.setDataPosition(a2 + dataPosition);
    }

    public static int b(Parcel parcel) {
        int a2 = a(parcel);
        int a3 = a(parcel, a2);
        int dataPosition = parcel.dataPosition();
        if (a(a2) != 20293) {
            throw new a("Expected object header. Got 0x" + Integer.toHexString(a2), parcel);
        }
        int i = dataPosition + a3;
        if (i < dataPosition || i > parcel.dataSize()) {
            throw new a("Size read is invalid start=" + dataPosition + " end=" + i, parcel);
        }
        return i;
    }

    public static void b(Parcel parcel, int i) {
        parcel.setDataPosition(a(parcel, i) + parcel.dataPosition());
    }

    public static Object[] b(Parcel parcel, int i, Parcelable.Creator creator) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        Object[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(a2 + dataPosition);
        return createTypedArray;
    }

    public static ArrayList c(Parcel parcel, int i, Parcelable.Creator creator) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        ArrayList createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(a2 + dataPosition);
        return createTypedArrayList;
    }

    public static boolean c(Parcel parcel, int i) {
        a(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static byte d(Parcel parcel, int i) {
        a(parcel, i, 4);
        return (byte) parcel.readInt();
    }

    public static short e(Parcel parcel, int i) {
        a(parcel, i, 4);
        return (short) parcel.readInt();
    }

    public static int f(Parcel parcel, int i) {
        a(parcel, i, 4);
        return parcel.readInt();
    }

    public static long g(Parcel parcel, int i) {
        a(parcel, i, 8);
        return parcel.readLong();
    }

    public static BigInteger h(Parcel parcel, int i) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(a2 + dataPosition);
        return new BigInteger(createByteArray);
    }

    public static float i(Parcel parcel, int i) {
        a(parcel, i, 4);
        return parcel.readFloat();
    }

    public static double j(Parcel parcel, int i) {
        a(parcel, i, 8);
        return parcel.readDouble();
    }

    public static BigDecimal k(Parcel parcel, int i) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        int readInt = parcel.readInt();
        parcel.setDataPosition(a2 + dataPosition);
        return new BigDecimal(new BigInteger(createByteArray), readInt);
    }

    public static String l(Parcel parcel, int i) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(a2 + dataPosition);
        return readString;
    }

    public static IBinder m(Parcel parcel, int i) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(a2 + dataPosition);
        return readStrongBinder;
    }

    public static Bundle n(Parcel parcel, int i) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(a2 + dataPosition);
        return readBundle;
    }

    public static byte[] o(Parcel parcel, int i) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(a2 + dataPosition);
        return createByteArray;
    }

    public static boolean[] p(Parcel parcel, int i) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        boolean[] createBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(a2 + dataPosition);
        return createBooleanArray;
    }

    public static int[] q(Parcel parcel, int i) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(a2 + dataPosition);
        return createIntArray;
    }

    public static long[] r(Parcel parcel, int i) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        long[] createLongArray = parcel.createLongArray();
        parcel.setDataPosition(a2 + dataPosition);
        return createLongArray;
    }

    public static BigInteger[] s(Parcel parcel, int i) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            bigIntegerArr[i2] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + a2);
        return bigIntegerArr;
    }

    public static float[] t(Parcel parcel, int i) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        float[] createFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(a2 + dataPosition);
        return createFloatArray;
    }

    public static double[] u(Parcel parcel, int i) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        double[] createDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(a2 + dataPosition);
        return createDoubleArray;
    }

    public static BigDecimal[] v(Parcel parcel, int i) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            byte[] createByteArray = parcel.createByteArray();
            bigDecimalArr[i2] = new BigDecimal(new BigInteger(createByteArray), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + a2);
        return bigDecimalArr;
    }

    public static String[] w(Parcel parcel, int i) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(a2 + dataPosition);
        return createStringArray;
    }

    public static ArrayList x(Parcel parcel, int i) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(a2 + dataPosition);
        return createStringArrayList;
    }

    public static Parcel y(Parcel parcel, int i) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.appendFrom(parcel, dataPosition, a2);
        parcel.setDataPosition(a2 + dataPosition);
        return obtain;
    }

    public static Parcel[] z(Parcel parcel, int i) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        Parcel[] parcelArr = new Parcel[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            int readInt2 = parcel.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = parcel.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                parcelArr[i2] = obtain;
                parcel.setDataPosition(readInt2 + dataPosition2);
            } else {
                parcelArr[i2] = null;
            }
        }
        parcel.setDataPosition(dataPosition + a2);
        return parcelArr;
    }
}
