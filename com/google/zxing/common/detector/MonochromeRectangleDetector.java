package com.google.zxing.common.detector;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
@Deprecated
/* loaded from: classes2.dex */
public final class MonochromeRectangleDetector {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_MODULES = 32;
    public transient /* synthetic */ FieldHolder $fh;
    public final BitMatrix image;

    public MonochromeRectangleDetector(BitMatrix bitMatrix) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitMatrix};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.image = bitMatrix;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0035 A[EDGE_INSN: B:74:0x0035->B:24:0x0035 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x006b A[EDGE_INSN: B:93:0x006b->B:49:0x006b ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int[] blackWhiteRange(int i2, int i3, int i4, int i5, boolean z) {
        InterceptResult invokeCommon;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z)})) == null) {
            int i8 = (i4 + i5) / 2;
            int i9 = i8;
            while (i9 >= i4) {
                BitMatrix bitMatrix = this.image;
                if (z) {
                    if (!bitMatrix.get(i9, i2)) {
                        i7 = i9;
                        while (true) {
                            i7--;
                            if (i7 >= i4) {
                                break;
                            }
                            BitMatrix bitMatrix2 = this.image;
                            if (z) {
                                if (bitMatrix2.get(i7, i2)) {
                                    break;
                                }
                            } else if (bitMatrix2.get(i2, i7)) {
                                break;
                            }
                        }
                        int i10 = i9 - i7;
                        if (i7 >= i4 || i10 > i3) {
                            break;
                            break;
                        }
                        i9 = i7;
                    } else {
                        i9--;
                    }
                } else if (bitMatrix.get(i2, i9)) {
                    i9--;
                } else {
                    i7 = i9;
                    while (true) {
                        i7--;
                        if (i7 >= i4) {
                        }
                    }
                    int i102 = i9 - i7;
                    if (i7 >= i4) {
                        break;
                    }
                    i9 = i7;
                }
            }
            int i11 = i9 + 1;
            while (i8 < i5) {
                BitMatrix bitMatrix3 = this.image;
                if (z) {
                    if (!bitMatrix3.get(i8, i2)) {
                        i6 = i8;
                        while (true) {
                            i6++;
                            if (i6 < i5) {
                                break;
                            }
                            BitMatrix bitMatrix4 = this.image;
                            if (z) {
                                if (bitMatrix4.get(i6, i2)) {
                                    break;
                                }
                            } else if (bitMatrix4.get(i2, i6)) {
                                break;
                            }
                        }
                        int i12 = i6 - i8;
                        if (i6 < i5 || i12 > i3) {
                            break;
                            break;
                        }
                        i8 = i6;
                    } else {
                        i8++;
                    }
                } else if (bitMatrix3.get(i2, i8)) {
                    i8++;
                } else {
                    i6 = i8;
                    while (true) {
                        i6++;
                        if (i6 < i5) {
                        }
                    }
                    int i122 = i6 - i8;
                    if (i6 < i5) {
                        break;
                    }
                    i8 = i6;
                }
            }
            int i13 = i8 - 1;
            if (i13 > i11) {
                return new int[]{i11, i13};
            }
            return null;
        }
        return (int[]) invokeCommon.objValue;
    }

    private ResultPoint findCornerFromCenter(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) throws NotFoundException {
        InterceptResult invokeCommon;
        int[] blackWhiteRange;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10)})) == null) {
            int[] iArr = null;
            int i11 = i2;
            int i12 = i6;
            while (i12 < i9 && i12 >= i8 && i11 < i5 && i11 >= i4) {
                if (i3 == 0) {
                    blackWhiteRange = blackWhiteRange(i12, i10, i4, i5, true);
                } else {
                    blackWhiteRange = blackWhiteRange(i11, i10, i8, i9, false);
                }
                if (blackWhiteRange == null) {
                    if (iArr != null) {
                        if (i3 == 0) {
                            int i13 = i12 - i7;
                            if (iArr[0] < i2) {
                                if (iArr[1] > i2) {
                                    return new ResultPoint(iArr[i7 > 0 ? (char) 0 : (char) 1], i13);
                                }
                                return new ResultPoint(iArr[0], i13);
                            }
                            return new ResultPoint(iArr[1], i13);
                        }
                        int i14 = i11 - i3;
                        if (iArr[0] < i6) {
                            if (iArr[1] > i6) {
                                return new ResultPoint(i14, iArr[i3 < 0 ? (char) 0 : (char) 1]);
                            }
                            return new ResultPoint(i14, iArr[0]);
                        }
                        return new ResultPoint(i14, iArr[1]);
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
                i12 += i7;
                i11 += i3;
                iArr = blackWhiteRange;
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return (ResultPoint) invokeCommon.objValue;
    }

    public ResultPoint[] detect() throws NotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int height = this.image.getHeight();
            int width = this.image.getWidth();
            int i2 = height / 2;
            int i3 = width / 2;
            int max = Math.max(1, height / 256);
            int max2 = Math.max(1, width / 256);
            int i4 = -max;
            int i5 = i3 / 2;
            int y = ((int) findCornerFromCenter(i3, 0, 0, width, i2, i4, 0, height, i5).getY()) - 1;
            int i6 = i2 / 2;
            ResultPoint findCornerFromCenter = findCornerFromCenter(i3, -max2, 0, width, i2, 0, y, height, i6);
            int x = ((int) findCornerFromCenter.getX()) - 1;
            ResultPoint findCornerFromCenter2 = findCornerFromCenter(i3, max2, x, width, i2, 0, y, height, i6);
            int x2 = ((int) findCornerFromCenter2.getX()) + 1;
            ResultPoint findCornerFromCenter3 = findCornerFromCenter(i3, 0, x, x2, i2, max, y, height, i5);
            return new ResultPoint[]{findCornerFromCenter(i3, 0, x, x2, i2, i4, y, ((int) findCornerFromCenter3.getY()) + 1, i3 / 4), findCornerFromCenter, findCornerFromCenter2, findCornerFromCenter3};
        }
        return (ResultPoint[]) invokeV.objValue;
    }
}
