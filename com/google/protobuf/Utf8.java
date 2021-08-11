package com.google.protobuf;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public final class Utf8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int COMPLETE = 0;
    public static final int MALFORMED = -1;
    public transient /* synthetic */ FieldHolder $fh;

    public Utf8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int incompleteStateFor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            if (i2 > -12) {
                return -1;
            }
            return i2;
        }
        return invokeI.intValue;
    }

    public static int incompleteStateFor(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i2, i3)) == null) {
            if (i2 > -12 || i3 > -65) {
                return -1;
            }
            return i2 ^ (i3 << 8);
        }
        return invokeII.intValue;
    }

    public static int incompleteStateFor(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65539, null, i2, i3, i4)) == null) {
            if (i2 > -12 || i3 > -65 || i4 > -65) {
                return -1;
            }
            return (i2 ^ (i3 << 8)) ^ (i4 << 16);
        }
        return invokeIII.intValue;
    }

    public static int incompleteStateFor(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, i2, i3)) == null) {
            byte b2 = bArr[i2 - 1];
            int i4 = i3 - i2;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 == 2) {
                        return incompleteStateFor(b2, bArr[i2], bArr[i2 + 1]);
                    }
                    throw new AssertionError();
                }
                return incompleteStateFor(b2, bArr[i2]);
            }
            return incompleteStateFor(b2);
        }
        return invokeLII.intValue;
    }

    public static boolean isValidUtf8(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bArr)) == null) ? isValidUtf8(bArr, 0, bArr.length) : invokeL.booleanValue;
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
    public static int partialIsValidUtf8(int i2, byte[] bArr, int i3, int i4) {
        InterceptResult invokeCommon;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Integer.valueOf(i2), bArr, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (i2 != 0) {
                if (i3 >= i4) {
                    return i2;
                }
                byte b2 = (byte) i2;
                if (b2 < -32) {
                    if (b2 >= -62) {
                        i5 = i3 + 1;
                    }
                    return -1;
                } else if (b2 < -16) {
                    byte b3 = (byte) (~(i2 >> 8));
                    if (b3 == 0) {
                        int i6 = i3 + 1;
                        byte b4 = bArr[i3];
                        if (i6 >= i4) {
                            return incompleteStateFor(b2, b4);
                        }
                        i3 = i6;
                        b3 = b4;
                    }
                    if (b3 <= -65 && ((b2 != -32 || b3 >= -96) && (b2 != -19 || b3 < -96))) {
                        i5 = i3 + 1;
                    }
                    return -1;
                } else {
                    byte b5 = (byte) (~(i2 >> 8));
                    byte b6 = 0;
                    if (b5 == 0) {
                        int i7 = i3 + 1;
                        b5 = bArr[i3];
                        if (i7 >= i4) {
                            return incompleteStateFor(b2, b5);
                        }
                        i3 = i7;
                    } else {
                        b6 = (byte) (i2 >> 16);
                    }
                    if (b6 == 0) {
                        int i8 = i3 + 1;
                        b6 = bArr[i3];
                        if (i8 >= i4) {
                            return incompleteStateFor(b2, b5, b6);
                        }
                        i3 = i8;
                    }
                    if (b5 <= -65 && (((b2 << 28) + (b5 + 112)) >> 30) == 0 && b6 <= -65) {
                        i5 = i3 + 1;
                    }
                    return -1;
                }
                i3 = i5;
            }
            return partialIsValidUtf8(bArr, i3, i4);
        }
        return invokeCommon.intValue;
    }

    public static int partialIsValidUtf8NonAscii(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65545, null, bArr, i2, i3)) == null) {
            while (i2 < i3) {
                int i4 = i2 + 1;
                byte b2 = bArr[i2];
                if (b2 < 0) {
                    if (b2 < -32) {
                        if (i4 >= i3) {
                            return b2;
                        }
                        if (b2 >= -62) {
                            i2 = i4 + 1;
                            if (bArr[i4] > -65) {
                            }
                        }
                        return -1;
                    } else if (b2 >= -16) {
                        if (i4 >= i3 - 2) {
                            return incompleteStateFor(bArr, i4, i3);
                        }
                        int i5 = i4 + 1;
                        byte b3 = bArr[i4];
                        if (b3 <= -65 && (((b2 << 28) + (b3 + 112)) >> 30) == 0) {
                            int i6 = i5 + 1;
                            if (bArr[i5] <= -65) {
                                i4 = i6 + 1;
                                if (bArr[i6] > -65) {
                                }
                            }
                        }
                        return -1;
                    } else if (i4 >= i3 - 1) {
                        return incompleteStateFor(bArr, i4, i3);
                    } else {
                        int i7 = i4 + 1;
                        byte b4 = bArr[i4];
                        if (b4 <= -65 && ((b2 != -32 || b4 >= -96) && (b2 != -19 || b4 < -96))) {
                            i2 = i7 + 1;
                            if (bArr[i7] > -65) {
                            }
                        }
                        return -1;
                    }
                }
                i2 = i4;
            }
            return 0;
        }
        return invokeLII.intValue;
    }

    public static boolean isValidUtf8(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(AdIconUtil.BAIDU_LOGO_ID, null, bArr, i2, i3)) == null) ? partialIsValidUtf8(bArr, i2, i3) == 0 : invokeLII.booleanValue;
    }

    public static int partialIsValidUtf8(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65544, null, bArr, i2, i3)) == null) {
            while (i2 < i3 && bArr[i2] >= 0) {
                i2++;
            }
            if (i2 >= i3) {
                return 0;
            }
            return partialIsValidUtf8NonAscii(bArr, i2, i3);
        }
        return invokeLII.intValue;
    }
}
