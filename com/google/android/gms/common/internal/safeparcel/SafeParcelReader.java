package com.google.android.gms.common.internal.safeparcel;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class SafeParcelReader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SafeParcelReader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int getFieldId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65577, null, i)) == null) ? (char) i : invokeI.intValue;
    }

    /* loaded from: classes7.dex */
    public static class ParseException extends RuntimeException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public ParseException(@NonNull String str, @NonNull Parcel parcel) {
            super(r2.toString());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, parcel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            int dataPosition = parcel.dataPosition();
            int dataSize = parcel.dataSize();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 41);
            sb.append(str);
            sb.append(" Parcel: pos=");
            sb.append(dataPosition);
            sb.append(" size=");
            sb.append(dataSize);
        }
    }

    @NonNull
    public static BigDecimal createBigDecimal(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return null;
            }
            byte[] createByteArray = parcel.createByteArray();
            int readInt = parcel.readInt();
            parcel.setDataPosition(dataPosition + readSize);
            return new BigDecimal(new BigInteger(createByteArray), readInt);
        }
        return (BigDecimal) invokeLI.objValue;
    }

    @NonNull
    public static BigDecimal[] createBigDecimalArray(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return null;
            }
            int readInt = parcel.readInt();
            BigDecimal[] bigDecimalArr = new BigDecimal[readInt];
            for (int i2 = 0; i2 < readInt; i2++) {
                bigDecimalArr[i2] = new BigDecimal(new BigInteger(parcel.createByteArray()), parcel.readInt());
            }
            parcel.setDataPosition(dataPosition + readSize);
            return bigDecimalArr;
        }
        return (BigDecimal[]) invokeLI.objValue;
    }

    @NonNull
    public static BigInteger[] createBigIntegerArray(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return null;
            }
            int readInt = parcel.readInt();
            BigInteger[] bigIntegerArr = new BigInteger[readInt];
            for (int i2 = 0; i2 < readInt; i2++) {
                bigIntegerArr[i2] = new BigInteger(parcel.createByteArray());
            }
            parcel.setDataPosition(dataPosition + readSize);
            return bigIntegerArr;
        }
        return (BigInteger[]) invokeLI.objValue;
    }

    @NonNull
    public static ArrayList<Boolean> createBooleanList(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return null;
            }
            ArrayList<Boolean> arrayList = new ArrayList<>();
            int readInt = parcel.readInt();
            for (int i2 = 0; i2 < readInt; i2++) {
                if (parcel.readInt() != 0) {
                    z = true;
                } else {
                    z = false;
                }
                arrayList.add(Boolean.valueOf(z));
            }
            parcel.setDataPosition(dataPosition + readSize);
            return arrayList;
        }
        return (ArrayList) invokeLI.objValue;
    }

    @NonNull
    public static byte[][] createByteArrayArray(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return null;
            }
            int readInt = parcel.readInt();
            byte[][] bArr = new byte[readInt];
            for (int i2 = 0; i2 < readInt; i2++) {
                bArr[i2] = parcel.createByteArray();
            }
            parcel.setDataPosition(dataPosition + readSize);
            return bArr;
        }
        return (byte[][]) invokeLI.objValue;
    }

    @NonNull
    public static SparseArray<byte[]> createByteArraySparseArray(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return null;
            }
            int readInt = parcel.readInt();
            SparseArray<byte[]> sparseArray = new SparseArray<>(readInt);
            for (int i2 = 0; i2 < readInt; i2++) {
                sparseArray.append(parcel.readInt(), parcel.createByteArray());
            }
            parcel.setDataPosition(dataPosition + readSize);
            return sparseArray;
        }
        return (SparseArray) invokeLI.objValue;
    }

    @NonNull
    public static ArrayList<Double> createDoubleList(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65549, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return null;
            }
            ArrayList<Double> arrayList = new ArrayList<>();
            int readInt = parcel.readInt();
            for (int i2 = 0; i2 < readInt; i2++) {
                arrayList.add(Double.valueOf(parcel.readDouble()));
            }
            parcel.setDataPosition(dataPosition + readSize);
            return arrayList;
        }
        return (ArrayList) invokeLI.objValue;
    }

    @NonNull
    public static SparseArray<Double> createDoubleSparseArray(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65550, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return null;
            }
            SparseArray<Double> sparseArray = new SparseArray<>();
            int readInt = parcel.readInt();
            for (int i2 = 0; i2 < readInt; i2++) {
                sparseArray.append(parcel.readInt(), Double.valueOf(parcel.readDouble()));
            }
            parcel.setDataPosition(dataPosition + readSize);
            return sparseArray;
        }
        return (SparseArray) invokeLI.objValue;
    }

    @NonNull
    public static ArrayList<Float> createFloatList(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65552, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return null;
            }
            ArrayList<Float> arrayList = new ArrayList<>();
            int readInt = parcel.readInt();
            for (int i2 = 0; i2 < readInt; i2++) {
                arrayList.add(Float.valueOf(parcel.readFloat()));
            }
            parcel.setDataPosition(dataPosition + readSize);
            return arrayList;
        }
        return (ArrayList) invokeLI.objValue;
    }

    @NonNull
    public static SparseArray<Float> createFloatSparseArray(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65553, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return null;
            }
            SparseArray<Float> sparseArray = new SparseArray<>();
            int readInt = parcel.readInt();
            for (int i2 = 0; i2 < readInt; i2++) {
                sparseArray.append(parcel.readInt(), Float.valueOf(parcel.readFloat()));
            }
            parcel.setDataPosition(dataPosition + readSize);
            return sparseArray;
        }
        return (SparseArray) invokeLI.objValue;
    }

    @NonNull
    public static SparseArray<IBinder> createIBinderSparseArray(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65556, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return null;
            }
            int readInt = parcel.readInt();
            SparseArray<IBinder> sparseArray = new SparseArray<>(readInt);
            for (int i2 = 0; i2 < readInt; i2++) {
                sparseArray.append(parcel.readInt(), parcel.readStrongBinder());
            }
            parcel.setDataPosition(dataPosition + readSize);
            return sparseArray;
        }
        return (SparseArray) invokeLI.objValue;
    }

    @NonNull
    public static ArrayList<Integer> createIntegerList(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65558, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return null;
            }
            ArrayList<Integer> arrayList = new ArrayList<>();
            int readInt = parcel.readInt();
            for (int i2 = 0; i2 < readInt; i2++) {
                arrayList.add(Integer.valueOf(parcel.readInt()));
            }
            parcel.setDataPosition(dataPosition + readSize);
            return arrayList;
        }
        return (ArrayList) invokeLI.objValue;
    }

    @NonNull
    public static ArrayList<Long> createLongList(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65560, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return null;
            }
            ArrayList<Long> arrayList = new ArrayList<>();
            int readInt = parcel.readInt();
            for (int i2 = 0; i2 < readInt; i2++) {
                arrayList.add(Long.valueOf(parcel.readLong()));
            }
            parcel.setDataPosition(dataPosition + readSize);
            return arrayList;
        }
        return (ArrayList) invokeLI.objValue;
    }

    @NonNull
    public static SparseIntArray createSparseIntArray(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65567, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return null;
            }
            SparseIntArray sparseIntArray = new SparseIntArray();
            int readInt = parcel.readInt();
            for (int i2 = 0; i2 < readInt; i2++) {
                sparseIntArray.append(parcel.readInt(), parcel.readInt());
            }
            parcel.setDataPosition(dataPosition + readSize);
            return sparseIntArray;
        }
        return (SparseIntArray) invokeLI.objValue;
    }

    @NonNull
    public static SparseLongArray createSparseLongArray(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65568, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return null;
            }
            SparseLongArray sparseLongArray = new SparseLongArray();
            int readInt = parcel.readInt();
            for (int i2 = 0; i2 < readInt; i2++) {
                sparseLongArray.append(parcel.readInt(), parcel.readLong());
            }
            parcel.setDataPosition(dataPosition + readSize);
            return sparseLongArray;
        }
        return (SparseLongArray) invokeLI.objValue;
    }

    @NonNull
    public static SparseArray<String> createStringSparseArray(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65572, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return null;
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            int readInt = parcel.readInt();
            for (int i2 = 0; i2 < readInt; i2++) {
                sparseArray.append(parcel.readInt(), parcel.readString());
            }
            parcel.setDataPosition(dataPosition + readSize);
            return sparseArray;
        }
        return (SparseArray) invokeLI.objValue;
    }

    @NonNull
    public static BigInteger createBigInteger(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return null;
            }
            byte[] createByteArray = parcel.createByteArray();
            parcel.setDataPosition(dataPosition + readSize);
            return new BigInteger(createByteArray);
        }
        return (BigInteger) invokeLI.objValue;
    }

    @NonNull
    public static boolean[] createBooleanArray(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return null;
            }
            boolean[] createBooleanArray = parcel.createBooleanArray();
            parcel.setDataPosition(dataPosition + readSize);
            return createBooleanArray;
        }
        return (boolean[]) invokeLI.objValue;
    }

    @NonNull
    public static Bundle createBundle(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return null;
            }
            Bundle readBundle = parcel.readBundle();
            parcel.setDataPosition(dataPosition + readSize);
            return readBundle;
        }
        return (Bundle) invokeLI.objValue;
    }

    @NonNull
    public static byte[] createByteArray(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return null;
            }
            byte[] createByteArray = parcel.createByteArray();
            parcel.setDataPosition(dataPosition + readSize);
            return createByteArray;
        }
        return (byte[]) invokeLI.objValue;
    }

    @NonNull
    public static char[] createCharArray(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65547, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return null;
            }
            char[] createCharArray = parcel.createCharArray();
            parcel.setDataPosition(dataPosition + readSize);
            return createCharArray;
        }
        return (char[]) invokeLI.objValue;
    }

    @NonNull
    public static double[] createDoubleArray(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65548, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return null;
            }
            double[] createDoubleArray = parcel.createDoubleArray();
            parcel.setDataPosition(dataPosition + readSize);
            return createDoubleArray;
        }
        return (double[]) invokeLI.objValue;
    }

    @NonNull
    public static float[] createFloatArray(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65551, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return null;
            }
            float[] createFloatArray = parcel.createFloatArray();
            parcel.setDataPosition(dataPosition + readSize);
            return createFloatArray;
        }
        return (float[]) invokeLI.objValue;
    }

    @NonNull
    public static IBinder[] createIBinderArray(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65554, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return null;
            }
            IBinder[] createBinderArray = parcel.createBinderArray();
            parcel.setDataPosition(dataPosition + readSize);
            return createBinderArray;
        }
        return (IBinder[]) invokeLI.objValue;
    }

    @NonNull
    public static ArrayList<IBinder> createIBinderList(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65555, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return null;
            }
            ArrayList<IBinder> createBinderArrayList = parcel.createBinderArrayList();
            parcel.setDataPosition(dataPosition + readSize);
            return createBinderArrayList;
        }
        return (ArrayList) invokeLI.objValue;
    }

    @NonNull
    public static int[] createIntArray(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65557, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return null;
            }
            int[] createIntArray = parcel.createIntArray();
            parcel.setDataPosition(dataPosition + readSize);
            return createIntArray;
        }
        return (int[]) invokeLI.objValue;
    }

    @NonNull
    public static long[] createLongArray(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65559, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return null;
            }
            long[] createLongArray = parcel.createLongArray();
            parcel.setDataPosition(dataPosition + readSize);
            return createLongArray;
        }
        return (long[]) invokeLI.objValue;
    }

    @NonNull
    public static Parcel createParcel(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65561, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return null;
            }
            Parcel obtain = Parcel.obtain();
            obtain.appendFrom(parcel, dataPosition, readSize);
            parcel.setDataPosition(dataPosition + readSize);
            return obtain;
        }
        return (Parcel) invokeLI.objValue;
    }

    @NonNull
    public static SparseBooleanArray createSparseBooleanArray(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65566, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return null;
            }
            SparseBooleanArray readSparseBooleanArray = parcel.readSparseBooleanArray();
            parcel.setDataPosition(dataPosition + readSize);
            return readSparseBooleanArray;
        }
        return (SparseBooleanArray) invokeLI.objValue;
    }

    @NonNull
    public static String createString(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65569, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return null;
            }
            String readString = parcel.readString();
            parcel.setDataPosition(dataPosition + readSize);
            return readString;
        }
        return (String) invokeLI.objValue;
    }

    @NonNull
    public static String[] createStringArray(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65570, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return null;
            }
            String[] createStringArray = parcel.createStringArray();
            parcel.setDataPosition(dataPosition + readSize);
            return createStringArray;
        }
        return (String[]) invokeLI.objValue;
    }

    @NonNull
    public static ArrayList<String> createStringList(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65571, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return null;
            }
            ArrayList<String> createStringArrayList = parcel.createStringArrayList();
            parcel.setDataPosition(dataPosition + readSize);
            return createStringArrayList;
        }
        return (ArrayList) invokeLI.objValue;
    }

    public static void ensureAtEnd(@NonNull Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65576, null, parcel, i) != null) || parcel.dataPosition() == i) {
            return;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(i);
        throw new ParseException(sb.toString(), parcel);
    }

    public static boolean readBoolean(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65578, null, parcel, i)) == null) {
            zzb(parcel, i, 4);
            if (parcel.readInt() != 0) {
                return true;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    @NonNull
    public static Boolean readBooleanObject(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65579, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            if (readSize == 0) {
                return null;
            }
            zza(parcel, i, readSize, 4);
            if (parcel.readInt() != 0) {
                z = true;
            } else {
                z = false;
            }
            return Boolean.valueOf(z);
        }
        return (Boolean) invokeLI.objValue;
    }

    public static byte readByte(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65580, null, parcel, i)) == null) {
            zzb(parcel, i, 4);
            return (byte) parcel.readInt();
        }
        return invokeLI.byteValue;
    }

    public static char readChar(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65581, null, parcel, i)) == null) {
            zzb(parcel, i, 4);
            return (char) parcel.readInt();
        }
        return invokeLI.charValue;
    }

    public static double readDouble(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65582, null, parcel, i)) == null) {
            zzb(parcel, i, 8);
            return parcel.readDouble();
        }
        return invokeLI.doubleValue;
    }

    @NonNull
    public static Double readDoubleObject(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65583, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            if (readSize == 0) {
                return null;
            }
            zza(parcel, i, readSize, 8);
            return Double.valueOf(parcel.readDouble());
        }
        return (Double) invokeLI.objValue;
    }

    public static float readFloat(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65584, null, parcel, i)) == null) {
            zzb(parcel, i, 4);
            return parcel.readFloat();
        }
        return invokeLI.floatValue;
    }

    @NonNull
    public static Float readFloatObject(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65585, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            if (readSize == 0) {
                return null;
            }
            zza(parcel, i, readSize, 4);
            return Float.valueOf(parcel.readFloat());
        }
        return (Float) invokeLI.objValue;
    }

    @NonNull
    public static IBinder readIBinder(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65587, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return null;
            }
            IBinder readStrongBinder = parcel.readStrongBinder();
            parcel.setDataPosition(dataPosition + readSize);
            return readStrongBinder;
        }
        return (IBinder) invokeLI.objValue;
    }

    public static int readInt(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65588, null, parcel, i)) == null) {
            zzb(parcel, i, 4);
            return parcel.readInt();
        }
        return invokeLI.intValue;
    }

    @NonNull
    public static Integer readIntegerObject(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65589, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            if (readSize == 0) {
                return null;
            }
            zza(parcel, i, readSize, 4);
            return Integer.valueOf(parcel.readInt());
        }
        return (Integer) invokeLI.objValue;
    }

    public static long readLong(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65591, null, parcel, i)) == null) {
            zzb(parcel, i, 8);
            return parcel.readLong();
        }
        return invokeLI.longValue;
    }

    @NonNull
    public static Long readLongObject(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65592, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            if (readSize == 0) {
                return null;
            }
            zza(parcel, i, readSize, 8);
            return Long.valueOf(parcel.readLong());
        }
        return (Long) invokeLI.objValue;
    }

    @NonNull
    public static PendingIntent readPendingIntent(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65593, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return null;
            }
            PendingIntent readPendingIntentOrNullFromParcel = PendingIntent.readPendingIntentOrNullFromParcel(parcel);
            parcel.setDataPosition(dataPosition + readSize);
            return readPendingIntentOrNullFromParcel;
        }
        return (PendingIntent) invokeLI.objValue;
    }

    public static short readShort(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65594, null, parcel, i)) == null) {
            zzb(parcel, i, 4);
            return (short) parcel.readInt();
        }
        return invokeLI.shortValue;
    }

    public static int readSize(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65595, null, parcel, i)) == null) {
            if ((i & (-65536)) != -65536) {
                return (char) (i >> 16);
            }
            return parcel.readInt();
        }
        return invokeLI.intValue;
    }

    public static void skipUnknownField(@NonNull Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65596, null, parcel, i) == null) {
            parcel.setDataPosition(parcel.dataPosition() + readSize(parcel, i));
        }
    }

    @NonNull
    public static Parcel[] createParcelArray(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65562, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
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
                    parcel.setDataPosition(dataPosition2 + readInt2);
                } else {
                    parcelArr[i2] = null;
                }
            }
            parcel.setDataPosition(dataPosition + readSize);
            return parcelArr;
        }
        return (Parcel[]) invokeLI.objValue;
    }

    @NonNull
    public static ArrayList<Parcel> createParcelList(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65563, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return null;
            }
            int readInt = parcel.readInt();
            ArrayList<Parcel> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < readInt; i2++) {
                int readInt2 = parcel.readInt();
                if (readInt2 != 0) {
                    int dataPosition2 = parcel.dataPosition();
                    Parcel obtain = Parcel.obtain();
                    obtain.appendFrom(parcel, dataPosition2, readInt2);
                    arrayList.add(obtain);
                    parcel.setDataPosition(dataPosition2 + readInt2);
                } else {
                    arrayList.add(null);
                }
            }
            parcel.setDataPosition(dataPosition + readSize);
            return arrayList;
        }
        return (ArrayList) invokeLI.objValue;
    }

    @NonNull
    public static SparseArray<Parcel> createParcelSparseArray(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65564, null, parcel, i)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return null;
            }
            int readInt = parcel.readInt();
            SparseArray<Parcel> sparseArray = new SparseArray<>();
            for (int i2 = 0; i2 < readInt; i2++) {
                int readInt2 = parcel.readInt();
                int readInt3 = parcel.readInt();
                if (readInt3 != 0) {
                    int dataPosition2 = parcel.dataPosition();
                    Parcel obtain = Parcel.obtain();
                    obtain.appendFrom(parcel, dataPosition2, readInt3);
                    sparseArray.append(readInt2, obtain);
                    parcel.setDataPosition(dataPosition2 + readInt3);
                } else {
                    sparseArray.append(readInt2, null);
                }
            }
            parcel.setDataPosition(dataPosition + readSize);
            return sparseArray;
        }
        return (SparseArray) invokeLI.objValue;
    }

    @NonNull
    public static <T extends Parcelable> T createParcelable(@NonNull Parcel parcel, int i, @NonNull Parcelable.Creator<T> creator) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65565, null, parcel, i, creator)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return null;
            }
            T createFromParcel = creator.createFromParcel(parcel);
            parcel.setDataPosition(dataPosition + readSize);
            return createFromParcel;
        }
        return (T) invokeLIL.objValue;
    }

    @NonNull
    public static <T> T[] createTypedArray(@NonNull Parcel parcel, int i, @NonNull Parcelable.Creator<T> creator) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65573, null, parcel, i, creator)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return null;
            }
            T[] tArr = (T[]) parcel.createTypedArray(creator);
            parcel.setDataPosition(dataPosition + readSize);
            return tArr;
        }
        return (T[]) ((Object[]) invokeLIL.objValue);
    }

    @NonNull
    public static <T> ArrayList<T> createTypedList(@NonNull Parcel parcel, int i, @NonNull Parcelable.Creator<T> creator) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65574, null, parcel, i, creator)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return null;
            }
            ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
            parcel.setDataPosition(dataPosition + readSize);
            return createTypedArrayList;
        }
        return (ArrayList) invokeLIL.objValue;
    }

    @NonNull
    public static <T> SparseArray<T> createTypedSparseArray(@NonNull Parcel parcel, int i, @NonNull Parcelable.Creator<T> creator) {
        InterceptResult invokeLIL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65575, null, parcel, i, creator)) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return null;
            }
            int readInt = parcel.readInt();
            SparseArray<T> sparseArray = new SparseArray<>();
            for (int i2 = 0; i2 < readInt; i2++) {
                int readInt2 = parcel.readInt();
                if (parcel.readInt() != 0) {
                    t = creator.createFromParcel(parcel);
                } else {
                    t = null;
                }
                sparseArray.append(readInt2, t);
            }
            parcel.setDataPosition(dataPosition + readSize);
            return sparseArray;
        }
        return (SparseArray) invokeLIL.objValue;
    }

    public static void zzb(Parcel parcel, int i, int i2) {
        int readSize;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(65599, null, parcel, i, i2) != null) || (readSize = readSize(parcel, i)) == i2) {
            return;
        }
        String hexString = Integer.toHexString(readSize);
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
        sb.append("Expected size ");
        sb.append(i2);
        sb.append(" got ");
        sb.append(readSize);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        throw new ParseException(sb.toString(), parcel);
    }

    public static int readHeader(@NonNull Parcel parcel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65586, null, parcel)) == null) {
            return parcel.readInt();
        }
        return invokeL.intValue;
    }

    public static void readList(@NonNull Parcel parcel, int i, @NonNull List list, @NonNull ClassLoader classLoader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65590, null, parcel, i, list, classLoader) == null) {
            int readSize = readSize(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (readSize == 0) {
                return;
            }
            parcel.readList(list, classLoader);
            parcel.setDataPosition(dataPosition + readSize);
        }
    }

    public static int validateObjectHeader(@NonNull Parcel parcel) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65597, null, parcel)) == null) {
            int readHeader = readHeader(parcel);
            int readSize = readSize(parcel, readHeader);
            int dataPosition = parcel.dataPosition();
            if (getFieldId(readHeader) != 20293) {
                String valueOf = String.valueOf(Integer.toHexString(readHeader));
                if (valueOf.length() != 0) {
                    str = "Expected object header. Got 0x".concat(valueOf);
                } else {
                    str = new String("Expected object header. Got 0x");
                }
                throw new ParseException(str, parcel);
            }
            int i = readSize + dataPosition;
            if (i >= dataPosition && i <= parcel.dataSize()) {
                return i;
            }
            StringBuilder sb = new StringBuilder(54);
            sb.append("Size read is invalid start=");
            sb.append(dataPosition);
            sb.append(" end=");
            sb.append(i);
            throw new ParseException(sb.toString(), parcel);
        }
        return invokeL.intValue;
    }

    public static void zza(Parcel parcel, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIII(65598, null, parcel, i, i2, i3) != null) || i2 == i3) {
            return;
        }
        String hexString = Integer.toHexString(i2);
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
        sb.append("Expected size ");
        sb.append(i3);
        sb.append(" got ");
        sb.append(i2);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        throw new ParseException(sb.toString(), parcel);
    }
}
