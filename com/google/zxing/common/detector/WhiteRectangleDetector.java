package com.google.zxing.common.detector;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
/* loaded from: classes8.dex */
public final class WhiteRectangleDetector {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CORR = 1;
    public static final int INIT_SIZE = 10;
    public transient /* synthetic */ FieldHolder $fh;
    public final int downInit;
    public final int height;
    public final BitMatrix image;
    public final int leftInit;
    public final int rightInit;
    public final int upInit;
    public final int width;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WhiteRectangleDetector(BitMatrix bitMatrix) throws NotFoundException {
        this(bitMatrix, 10, bitMatrix.getWidth() / 2, bitMatrix.getHeight() / 2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitMatrix};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((BitMatrix) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public WhiteRectangleDetector(BitMatrix bitMatrix, int i, int i2, int i3) throws NotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitMatrix, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.image = bitMatrix;
        this.height = bitMatrix.getHeight();
        int width = bitMatrix.getWidth();
        this.width = width;
        int i6 = i / 2;
        int i7 = i2 - i6;
        this.leftInit = i7;
        int i8 = i2 + i6;
        this.rightInit = i8;
        int i9 = i3 - i6;
        this.upInit = i9;
        int i10 = i3 + i6;
        this.downInit = i10;
        if (i9 >= 0 && i7 >= 0 && i10 < this.height && i8 < width) {
            return;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private ResultPoint[] centerEdges(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, this, resultPoint, resultPoint2, resultPoint3, resultPoint4)) == null) {
            float x = resultPoint.getX();
            float y = resultPoint.getY();
            float x2 = resultPoint2.getX();
            float y2 = resultPoint2.getY();
            float x3 = resultPoint3.getX();
            float y3 = resultPoint3.getY();
            float x4 = resultPoint4.getX();
            float y4 = resultPoint4.getY();
            return x < ((float) this.width) / 2.0f ? new ResultPoint[]{new ResultPoint(x4 - 1.0f, y4 + 1.0f), new ResultPoint(x2 + 1.0f, y2 + 1.0f), new ResultPoint(x3 - 1.0f, y3 - 1.0f), new ResultPoint(x + 1.0f, y - 1.0f)} : new ResultPoint[]{new ResultPoint(x4 + 1.0f, y4 + 1.0f), new ResultPoint(x2 + 1.0f, y2 - 1.0f), new ResultPoint(x3 - 1.0f, y3 + 1.0f), new ResultPoint(x - 1.0f, y - 1.0f)};
        }
        return (ResultPoint[]) invokeLLLL.objValue;
    }

    private ResultPoint getBlackPointOnSegment(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            int round = MathUtils.round(MathUtils.distance(f, f2, f3, f4));
            float f5 = round;
            float f6 = (f3 - f) / f5;
            float f7 = (f4 - f2) / f5;
            for (int i = 0; i < round; i++) {
                float f8 = i;
                int round2 = MathUtils.round((f8 * f6) + f);
                int round3 = MathUtils.round((f8 * f7) + f2);
                if (this.image.get(round2, round3)) {
                    return new ResultPoint(round2, round3);
                }
            }
            return null;
        }
        return (ResultPoint) invokeCommon.objValue;
    }

    private boolean containsBlackPoint(int i, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            if (z) {
                while (i <= i2) {
                    if (this.image.get(i, i3)) {
                        return true;
                    }
                    i++;
                }
                return false;
            }
            while (i <= i2) {
                if (this.image.get(i3, i)) {
                    return true;
                }
                i++;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public ResultPoint[] detect() throws NotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i = this.leftInit;
            int i2 = this.rightInit;
            int i3 = this.upInit;
            int i4 = this.downInit;
            boolean z = false;
            boolean z2 = true;
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            while (z2) {
                boolean z8 = true;
                boolean z9 = false;
                while (true) {
                    if ((z8 || !z3) && i2 < this.width) {
                        z8 = containsBlackPoint(i3, i4, i2, false);
                        if (z8) {
                            i2++;
                            z3 = true;
                            z9 = true;
                        } else if (!z3) {
                            i2++;
                        }
                    }
                }
                if (i2 < this.width) {
                    boolean z10 = true;
                    while (true) {
                        if ((z10 || !z4) && i4 < this.height) {
                            z10 = containsBlackPoint(i, i2, i4, true);
                            if (z10) {
                                i4++;
                                z4 = true;
                                z9 = true;
                            } else if (!z4) {
                                i4++;
                            }
                        }
                    }
                    if (i4 < this.height) {
                        boolean z11 = true;
                        while (true) {
                            if ((z11 || !z5) && i >= 0) {
                                z11 = containsBlackPoint(i3, i4, i, false);
                                if (z11) {
                                    i--;
                                    z5 = true;
                                    z9 = true;
                                } else if (!z5) {
                                    i--;
                                }
                            }
                        }
                        if (i >= 0) {
                            z2 = z9;
                            boolean z12 = true;
                            while (true) {
                                if ((z12 || !z7) && i3 >= 0) {
                                    z12 = containsBlackPoint(i, i2, i3, true);
                                    if (z12) {
                                        i3--;
                                        z2 = true;
                                        z7 = true;
                                    } else if (!z7) {
                                        i3--;
                                    }
                                }
                            }
                            if (i3 >= 0) {
                                if (z2) {
                                    z6 = true;
                                }
                            }
                        }
                    }
                }
                z = true;
                break;
            }
            if (!z && z6) {
                int i5 = i2 - i;
                ResultPoint resultPoint = null;
                ResultPoint resultPoint2 = null;
                for (int i6 = 1; resultPoint2 == null && i6 < i5; i6++) {
                    resultPoint2 = getBlackPointOnSegment(i, i4 - i6, i + i6, i4);
                }
                if (resultPoint2 != null) {
                    ResultPoint resultPoint3 = null;
                    for (int i7 = 1; resultPoint3 == null && i7 < i5; i7++) {
                        resultPoint3 = getBlackPointOnSegment(i, i3 + i7, i + i7, i3);
                    }
                    if (resultPoint3 != null) {
                        ResultPoint resultPoint4 = null;
                        for (int i8 = 1; resultPoint4 == null && i8 < i5; i8++) {
                            resultPoint4 = getBlackPointOnSegment(i2, i3 + i8, i2 - i8, i3);
                        }
                        if (resultPoint4 != null) {
                            for (int i9 = 1; resultPoint == null && i9 < i5; i9++) {
                                resultPoint = getBlackPointOnSegment(i2, i4 - i9, i2 - i9, i4);
                            }
                            if (resultPoint != null) {
                                return centerEdges(resultPoint, resultPoint2, resultPoint4, resultPoint3);
                            }
                            throw NotFoundException.getNotFoundInstance();
                        }
                        throw NotFoundException.getNotFoundInstance();
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
                throw NotFoundException.getNotFoundInstance();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return (ResultPoint[]) invokeV.objValue;
    }
}
