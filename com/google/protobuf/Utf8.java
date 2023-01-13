package com.google.protobuf;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class Utf8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int COMPLETE = 0;
    public static final int MALFORMED = -1;
    public transient /* synthetic */ FieldHolder $fh;

    public static int incompleteStateFor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            if (i > -12) {
                return -1;
            }
            return i;
        }
        return invokeI.intValue;
    }

    public static int incompleteStateFor(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i, i2)) == null) {
            if (i > -12 || i2 > -65) {
                return -1;
            }
            return i ^ (i2 << 8);
        }
        return invokeII.intValue;
    }

    public static int incompleteStateFor(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65539, null, i, i2, i3)) == null) {
            if (i > -12 || i2 > -65 || i3 > -65) {
                return -1;
            }
            return (i ^ (i2 << 8)) ^ (i3 << 16);
        }
        return invokeIII.intValue;
    }

    public Utf8() {
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

    public static int incompleteStateFor(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, i, i2)) == null) {
            byte b = bArr[i - 1];
            int i3 = i2 - i;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        return incompleteStateFor(b, bArr[i], bArr[i + 1]);
                    }
                    throw new AssertionError();
                }
                return incompleteStateFor(b, bArr[i]);
            }
            return incompleteStateFor(b);
        }
        return invokeLII.intValue;
    }

    public static boolean isValidUtf8(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bArr)) == null) {
            return isValidUtf8(bArr, 0, bArr.length);
        }
        return invokeL.booleanValue;
    }

    public static boolean isValidUtf8(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65542, null, bArr, i, i2)) == null) {
            if (partialIsValidUtf8(bArr, i, i2) == 0) {
                return true;
            }
            return false;
        }
        return invokeLII.booleanValue;
    }

    public static int partialIsValidUtf8(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65544, null, bArr, i, i2)) == null) {
            while (i < i2 && bArr[i] >= 0) {
                i++;
            }
            if (i >= i2) {
                return 0;
            }
            return partialIsValidUtf8NonAscii(bArr, i, i2);
        }
        return invokeLII.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0019, code lost:
        if (r7[r8] > (-65)) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004a, code lost:
        if (r7[r8] > (-65)) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0083, code lost:
        if (r7[r8] > (-65)) goto L53;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int partialIsValidUtf8(int i, byte[] bArr, int i2, int i3) {
        InterceptResult invokeCommon;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Integer.valueOf(i), bArr, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (i != 0) {
                if (i2 >= i3) {
                    return i;
                }
                byte b = (byte) i;
                if (b < -32) {
                    if (b >= -62) {
                        i4 = i2 + 1;
                    }
                    return -1;
                } else if (b < -16) {
                    byte b2 = (byte) (~(i >> 8));
                    if (b2 == 0) {
                        int i5 = i2 + 1;
                        byte b3 = bArr[i2];
                        if (i5 >= i3) {
                            return incompleteStateFor(b, b3);
                        }
                        i2 = i5;
                        b2 = b3;
                    }
                    if (b2 <= -65 && ((b != -32 || b2 >= -96) && (b != -19 || b2 < -96))) {
                        i4 = i2 + 1;
                    }
                    return -1;
                } else {
                    byte b4 = (byte) (~(i >> 8));
                    byte b5 = 0;
                    if (b4 == 0) {
                        int i6 = i2 + 1;
                        b4 = bArr[i2];
                        if (i6 >= i3) {
                            return incompleteStateFor(b, b4);
                        }
                        i2 = i6;
                    } else {
                        b5 = (byte) (i >> 16);
                    }
                    if (b5 == 0) {
                        int i7 = i2 + 1;
                        b5 = bArr[i2];
                        if (i7 >= i3) {
                            return incompleteStateFor(b, b4, b5);
                        }
                        i2 = i7;
                    }
                    if (b4 <= -65 && (((b << 28) + (b4 + 112)) >> 30) == 0 && b5 <= -65) {
                        i4 = i2 + 1;
                    }
                    return -1;
                }
                i2 = i4;
            }
            return partialIsValidUtf8(bArr, i2, i3);
        }
        return invokeCommon.intValue;
    }

    public static int partialIsValidUtf8NonAscii(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65545, null, bArr, i, i2)) == null) {
            while (i < i2) {
                int i3 = i + 1;
                byte b = bArr[i];
                if (b < 0) {
                    if (b < -32) {
                        if (i3 >= i2) {
                            return b;
                        }
                        if (b >= -62) {
                            i = i3 + 1;
                            if (bArr[i3] > -65) {
                            }
                        }
                        return -1;
                    } else if (b < -16) {
                        if (i3 >= i2 - 1) {
                            return incompleteStateFor(bArr, i3, i2);
                        }
                        int i4 = i3 + 1;
                        byte b2 = bArr[i3];
                        if (b2 <= -65 && ((b != -32 || b2 >= -96) && (b != -19 || b2 < -96))) {
                            i = i4 + 1;
                            if (bArr[i4] > -65) {
                            }
                        }
                        return -1;
                    } else if (i3 >= i2 - 2) {
                        return incompleteStateFor(bArr, i3, i2);
                    } else {
                        int i5 = i3 + 1;
                        byte b3 = bArr[i3];
                        if (b3 <= -65 && (((b << 28) + (b3 + 112)) >> 30) == 0) {
                            int i6 = i5 + 1;
                            if (bArr[i5] <= -65) {
                                i3 = i6 + 1;
                                if (bArr[i6] > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                }
                i = i3;
            }
            return 0;
        }
        return invokeLII.intValue;
    }
}
