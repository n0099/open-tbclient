package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class SafeParcelReader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
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
    public static Bundle a(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, parcel, i)) == null) {
            int o = o(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (o == 0) {
                return null;
            }
            Bundle readBundle = parcel.readBundle();
            parcel.setDataPosition(dataPosition + o);
            return readBundle;
        }
        return (Bundle) invokeLI.objValue;
    }

    @NonNull
    public static int[] b(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, parcel, i)) == null) {
            int o = o(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (o == 0) {
                return null;
            }
            int[] createIntArray = parcel.createIntArray();
            parcel.setDataPosition(dataPosition + o);
            return createIntArray;
        }
        return (int[]) invokeLI.objValue;
    }

    @NonNull
    public static <T extends Parcelable> T c(@NonNull Parcel parcel, int i, @NonNull Parcelable.Creator<T> creator) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65538, null, parcel, i, creator)) == null) {
            int o = o(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (o == 0) {
                return null;
            }
            T createFromParcel = creator.createFromParcel(parcel);
            parcel.setDataPosition(dataPosition + o);
            return createFromParcel;
        }
        return (T) invokeLIL.objValue;
    }

    @NonNull
    public static String d(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, parcel, i)) == null) {
            int o = o(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (o == 0) {
                return null;
            }
            String readString = parcel.readString();
            parcel.setDataPosition(dataPosition + o);
            return readString;
        }
        return (String) invokeLI.objValue;
    }

    @NonNull
    public static ArrayList<String> e(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, parcel, i)) == null) {
            int o = o(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (o == 0) {
                return null;
            }
            ArrayList<String> createStringArrayList = parcel.createStringArrayList();
            parcel.setDataPosition(dataPosition + o);
            return createStringArrayList;
        }
        return (ArrayList) invokeLI.objValue;
    }

    @NonNull
    public static <T> T[] f(@NonNull Parcel parcel, int i, @NonNull Parcelable.Creator<T> creator) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65541, null, parcel, i, creator)) == null) {
            int o = o(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (o == 0) {
                return null;
            }
            T[] tArr = (T[]) parcel.createTypedArray(creator);
            parcel.setDataPosition(dataPosition + o);
            return tArr;
        }
        return (T[]) ((Object[]) invokeLIL.objValue);
    }

    public static void g(@NonNull Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65542, null, parcel, i) == null) || parcel.dataPosition() == i) {
            return;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(i);
        throw new ParseException(sb.toString(), parcel);
    }

    public static int h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) ? (char) i : invokeI.intValue;
    }

    public static boolean i(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, parcel, i)) == null) {
            r(parcel, i, 4);
            return parcel.readInt() != 0;
        }
        return invokeLI.booleanValue;
    }

    public static float j(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, parcel, i)) == null) {
            r(parcel, i, 4);
            return parcel.readFloat();
        }
        return invokeLI.floatValue;
    }

    public static int k(@NonNull Parcel parcel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, parcel)) == null) ? parcel.readInt() : invokeL.intValue;
    }

    @NonNull
    public static IBinder l(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65547, null, parcel, i)) == null) {
            int o = o(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (o == 0) {
                return null;
            }
            IBinder readStrongBinder = parcel.readStrongBinder();
            parcel.setDataPosition(dataPosition + o);
            return readStrongBinder;
        }
        return (IBinder) invokeLI.objValue;
    }

    public static int m(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65548, null, parcel, i)) == null) {
            r(parcel, i, 4);
            return parcel.readInt();
        }
        return invokeLI.intValue;
    }

    public static long n(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65549, null, parcel, i)) == null) {
            r(parcel, i, 8);
            return parcel.readLong();
        }
        return invokeLI.longValue;
    }

    public static int o(@NonNull Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65550, null, parcel, i)) == null) ? (i & (-65536)) != -65536 ? (char) (i >> 16) : parcel.readInt() : invokeLI.intValue;
    }

    public static void p(@NonNull Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65551, null, parcel, i) == null) {
            parcel.setDataPosition(parcel.dataPosition() + o(parcel, i));
        }
    }

    public static int q(@NonNull Parcel parcel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, parcel)) == null) {
            int k = k(parcel);
            int o = o(parcel, k);
            int dataPosition = parcel.dataPosition();
            if (h(k) != 20293) {
                String valueOf = String.valueOf(Integer.toHexString(k));
                throw new ParseException(valueOf.length() != 0 ? "Expected object header. Got 0x".concat(valueOf) : new String("Expected object header. Got 0x"), parcel);
            }
            int i = o + dataPosition;
            if (i < dataPosition || i > parcel.dataSize()) {
                StringBuilder sb = new StringBuilder(54);
                sb.append("Size read is invalid start=");
                sb.append(dataPosition);
                sb.append(" end=");
                sb.append(i);
                throw new ParseException(sb.toString(), parcel);
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static void r(Parcel parcel, int i, int i2) {
        int o;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65553, null, parcel, i, i2) == null) || (o = o(parcel, i)) == i2) {
            return;
        }
        String hexString = Integer.toHexString(o);
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
        sb.append("Expected size ");
        sb.append(i2);
        sb.append(" got ");
        sb.append(o);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        throw new ParseException(sb.toString(), parcel);
    }
}
