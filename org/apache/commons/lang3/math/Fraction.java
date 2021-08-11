package org.apache.commons.lang3.math;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public final class Fraction extends Number implements Comparable<Fraction> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Fraction FOUR_FIFTHS;
    public static final Fraction ONE;
    public static final Fraction ONE_FIFTH;
    public static final Fraction ONE_HALF;
    public static final Fraction ONE_QUARTER;
    public static final Fraction ONE_THIRD;
    public static final Fraction THREE_FIFTHS;
    public static final Fraction THREE_QUARTERS;
    public static final Fraction TWO_FIFTHS;
    public static final Fraction TWO_QUARTERS;
    public static final Fraction TWO_THIRDS;
    public static final Fraction ZERO;
    public static final long serialVersionUID = 65382027393090L;
    public transient /* synthetic */ FieldHolder $fh;
    public final int denominator;
    public transient int hashCode;
    public final int numerator;
    public transient String toProperString;
    public transient String toString;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-635028275, "Lorg/apache/commons/lang3/math/Fraction;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-635028275, "Lorg/apache/commons/lang3/math/Fraction;");
                return;
            }
        }
        ZERO = new Fraction(0, 1);
        ONE = new Fraction(1, 1);
        ONE_HALF = new Fraction(1, 2);
        ONE_THIRD = new Fraction(1, 3);
        TWO_THIRDS = new Fraction(2, 3);
        ONE_QUARTER = new Fraction(1, 4);
        TWO_QUARTERS = new Fraction(2, 4);
        THREE_QUARTERS = new Fraction(3, 4);
        ONE_FIFTH = new Fraction(1, 5);
        TWO_FIFTHS = new Fraction(2, 5);
        THREE_FIFTHS = new Fraction(3, 5);
        FOUR_FIFTHS = new Fraction(4, 5);
    }

    public Fraction(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.hashCode = 0;
        this.toString = null;
        this.toProperString = null;
        this.numerator = i2;
        this.denominator = i3;
    }

    public static int addAndCheck(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i2, i3)) == null) {
            long j2 = i2 + i3;
            if (j2 < -2147483648L || j2 > 2147483647L) {
                throw new ArithmeticException("overflow: add");
            }
            return (int) j2;
        }
        return invokeII.intValue;
    }

    private Fraction addSub(Fraction fraction, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, this, fraction, z)) == null) {
            if (fraction != null) {
                if (this.numerator == 0) {
                    return z ? fraction : fraction.negate();
                } else if (fraction.numerator == 0) {
                    return this;
                } else {
                    int greatestCommonDivisor = greatestCommonDivisor(this.denominator, fraction.denominator);
                    if (greatestCommonDivisor == 1) {
                        int mulAndCheck = mulAndCheck(this.numerator, fraction.denominator);
                        int mulAndCheck2 = mulAndCheck(fraction.numerator, this.denominator);
                        return new Fraction(z ? addAndCheck(mulAndCheck, mulAndCheck2) : subAndCheck(mulAndCheck, mulAndCheck2), mulPosAndCheck(this.denominator, fraction.denominator));
                    }
                    BigInteger multiply = BigInteger.valueOf(this.numerator).multiply(BigInteger.valueOf(fraction.denominator / greatestCommonDivisor));
                    BigInteger multiply2 = BigInteger.valueOf(fraction.numerator).multiply(BigInteger.valueOf(this.denominator / greatestCommonDivisor));
                    BigInteger add = z ? multiply.add(multiply2) : multiply.subtract(multiply2);
                    int intValue = add.mod(BigInteger.valueOf(greatestCommonDivisor)).intValue();
                    int greatestCommonDivisor2 = intValue == 0 ? greatestCommonDivisor : greatestCommonDivisor(intValue, greatestCommonDivisor);
                    BigInteger divide = add.divide(BigInteger.valueOf(greatestCommonDivisor2));
                    if (divide.bitLength() <= 31) {
                        return new Fraction(divide.intValue(), mulPosAndCheck(this.denominator / greatestCommonDivisor, fraction.denominator / greatestCommonDivisor2));
                    }
                    throw new ArithmeticException("overflow: numerator too large after multiply");
                }
            }
            throw new IllegalArgumentException("The fraction must not be null");
        }
        return (Fraction) invokeLZ.objValue;
    }

    public static Fraction getFraction(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(AdIconUtil.AD_TEXT_ID, null, i2, i3)) == null) {
            if (i3 != 0) {
                if (i3 < 0) {
                    if (i2 == Integer.MIN_VALUE || i3 == Integer.MIN_VALUE) {
                        throw new ArithmeticException("overflow: can't negate");
                    }
                    i2 = -i2;
                    i3 = -i3;
                }
                return new Fraction(i2, i3);
            }
            throw new ArithmeticException("The denominator must not be zero");
        }
        return (Fraction) invokeII.objValue;
    }

    public static Fraction getReducedFraction(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65544, null, i2, i3)) == null) {
            if (i3 != 0) {
                if (i2 == 0) {
                    return ZERO;
                }
                if (i3 == Integer.MIN_VALUE && (i2 & 1) == 0) {
                    i2 /= 2;
                    i3 /= 2;
                }
                if (i3 < 0) {
                    if (i2 == Integer.MIN_VALUE || i3 == Integer.MIN_VALUE) {
                        throw new ArithmeticException("overflow: can't negate");
                    }
                    i2 = -i2;
                    i3 = -i3;
                }
                int greatestCommonDivisor = greatestCommonDivisor(i2, i3);
                return new Fraction(i2 / greatestCommonDivisor, i3 / greatestCommonDivisor);
            }
            throw new ArithmeticException("The denominator must not be zero");
        }
        return (Fraction) invokeII.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0035, code lost:
        if (r3 != 1) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0037, code lost:
        r0 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0039, code lost:
        r0 = -(r6 / 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x003e, code lost:
        if ((r0 & 1) != 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0040, code lost:
        r0 = r0 / 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0043, code lost:
        if (r0 <= 0) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0045, code lost:
        r6 = -r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0047, code lost:
        r7 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0048, code lost:
        r0 = (r7 - r6) / 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x004c, code lost:
        if (r0 != 0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0053, code lost:
        return (-r6) * (1 << r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int greatestCommonDivisor(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65545, null, i2, i3)) == null) {
            if (i2 == 0 || i3 == 0) {
                if (i2 != Integer.MIN_VALUE && i3 != Integer.MIN_VALUE) {
                    return Math.abs(i2) + Math.abs(i3);
                }
                throw new ArithmeticException("overflow: gcd is 2^31");
            } else if (Math.abs(i2) == 1 || Math.abs(i3) == 1) {
                return 1;
            } else {
                if (i2 > 0) {
                    i2 = -i2;
                }
                if (i3 > 0) {
                    i3 = -i3;
                }
                int i4 = 0;
                while (true) {
                    int i5 = i2 & 1;
                    if (i5 != 0 || (i3 & 1) != 0 || i4 >= 31) {
                        break;
                    }
                    i2 /= 2;
                    i3 /= 2;
                    i4++;
                }
                throw new ArithmeticException("overflow: gcd is 2^31");
            }
        }
        return invokeII.intValue;
    }

    public static int mulAndCheck(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65546, null, i2, i3)) == null) {
            long j2 = i2 * i3;
            if (j2 < -2147483648L || j2 > 2147483647L) {
                throw new ArithmeticException("overflow: mul");
            }
            return (int) j2;
        }
        return invokeII.intValue;
    }

    public static int mulPosAndCheck(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65547, null, i2, i3)) == null) {
            long j2 = i2 * i3;
            if (j2 <= 2147483647L) {
                return (int) j2;
            }
            throw new ArithmeticException("overflow: mulPos");
        }
        return invokeII.intValue;
    }

    public static int subAndCheck(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65548, null, i2, i3)) == null) {
            long j2 = i2 - i3;
            if (j2 < -2147483648L || j2 > 2147483647L) {
                throw new ArithmeticException("overflow: add");
            }
            return (int) j2;
        }
        return invokeII.intValue;
    }

    public Fraction abs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.numerator >= 0 ? this : negate() : (Fraction) invokeV.objValue;
    }

    public Fraction add(Fraction fraction) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fraction)) == null) ? addSub(fraction, true) : (Fraction) invokeL.objValue;
    }

    public Fraction divideBy(Fraction fraction) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, fraction)) == null) {
            if (fraction != null) {
                if (fraction.numerator != 0) {
                    return multiplyBy(fraction.invert());
                }
                throw new ArithmeticException("The fraction to divide by must not be zero");
            }
            throw new IllegalArgumentException("The fraction must not be null");
        }
        return (Fraction) invokeL.objValue;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.numerator / this.denominator : invokeV.doubleValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Fraction) {
                Fraction fraction = (Fraction) obj;
                return getNumerator() == fraction.getNumerator() && getDenominator() == fraction.getDenominator();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // java.lang.Number
    public float floatValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.numerator / this.denominator : invokeV.floatValue;
    }

    public int getDenominator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.denominator : invokeV.intValue;
    }

    public int getNumerator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.numerator : invokeV.intValue;
    }

    public int getProperNumerator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? Math.abs(this.numerator % this.denominator) : invokeV.intValue;
    }

    public int getProperWhole() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.numerator / this.denominator : invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.hashCode == 0) {
                this.hashCode = ((getNumerator() + 629) * 37) + getDenominator();
            }
            return this.hashCode;
        }
        return invokeV.intValue;
    }

    @Override // java.lang.Number
    public int intValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.numerator / this.denominator : invokeV.intValue;
    }

    public Fraction invert() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            int i2 = this.numerator;
            if (i2 != 0) {
                if (i2 != Integer.MIN_VALUE) {
                    if (i2 < 0) {
                        return new Fraction(-this.denominator, -i2);
                    }
                    return new Fraction(this.denominator, i2);
                }
                throw new ArithmeticException("overflow: can't negate numerator");
            }
            throw new ArithmeticException("Unable to invert zero.");
        }
        return (Fraction) invokeV.objValue;
    }

    @Override // java.lang.Number
    public long longValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.numerator / this.denominator : invokeV.longValue;
    }

    public Fraction multiplyBy(Fraction fraction) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, fraction)) == null) {
            if (fraction != null) {
                int i2 = this.numerator;
                if (i2 != 0 && fraction.numerator != 0) {
                    int greatestCommonDivisor = greatestCommonDivisor(i2, fraction.denominator);
                    int greatestCommonDivisor2 = greatestCommonDivisor(fraction.numerator, this.denominator);
                    return getReducedFraction(mulAndCheck(this.numerator / greatestCommonDivisor, fraction.numerator / greatestCommonDivisor2), mulPosAndCheck(this.denominator / greatestCommonDivisor2, fraction.denominator / greatestCommonDivisor));
                }
                return ZERO;
            }
            throw new IllegalArgumentException("The fraction must not be null");
        }
        return (Fraction) invokeL.objValue;
    }

    public Fraction negate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            int i2 = this.numerator;
            if (i2 != Integer.MIN_VALUE) {
                return new Fraction(-i2, this.denominator);
            }
            throw new ArithmeticException("overflow: too large to negate");
        }
        return (Fraction) invokeV.objValue;
    }

    public Fraction pow(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            if (i2 == 1) {
                return this;
            }
            if (i2 == 0) {
                return ONE;
            }
            if (i2 < 0) {
                if (i2 == Integer.MIN_VALUE) {
                    return invert().pow(2).pow(-(i2 / 2));
                }
                return invert().pow(-i2);
            }
            Fraction multiplyBy = multiplyBy(this);
            if (i2 % 2 == 0) {
                return multiplyBy.pow(i2 / 2);
            }
            return multiplyBy.pow(i2 / 2).multiplyBy(this);
        }
        return (Fraction) invokeI.objValue;
    }

    public Fraction reduce() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            int i2 = this.numerator;
            if (i2 == 0) {
                return equals(ZERO) ? this : ZERO;
            }
            int greatestCommonDivisor = greatestCommonDivisor(Math.abs(i2), this.denominator);
            return greatestCommonDivisor == 1 ? this : getFraction(this.numerator / greatestCommonDivisor, this.denominator / greatestCommonDivisor);
        }
        return (Fraction) invokeV.objValue;
    }

    public Fraction subtract(Fraction fraction) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, fraction)) == null) ? addSub(fraction, false) : (Fraction) invokeL.objValue;
    }

    public String toProperString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.toProperString == null) {
                int i2 = this.numerator;
                if (i2 == 0) {
                    this.toProperString = "0";
                } else {
                    int i3 = this.denominator;
                    if (i2 == i3) {
                        this.toProperString = "1";
                    } else if (i2 == i3 * (-1)) {
                        this.toProperString = "-1";
                    } else {
                        if (i2 > 0) {
                            i2 = -i2;
                        }
                        if (i2 < (-this.denominator)) {
                            int properNumerator = getProperNumerator();
                            if (properNumerator == 0) {
                                this.toProperString = Integer.toString(getProperWhole());
                            } else {
                                this.toProperString = getProperWhole() + " " + properNumerator + "/" + getDenominator();
                            }
                        } else {
                            this.toProperString = getNumerator() + "/" + getDenominator();
                        }
                    }
                }
            }
            return this.toProperString;
        }
        return (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.toString == null) {
                this.toString = getNumerator() + "/" + getDenominator();
            }
            return this.toString;
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(Fraction fraction) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fraction)) == null) {
            if (this == fraction) {
                return 0;
            }
            if ((this.numerator == fraction.numerator && this.denominator == fraction.denominator) || this.numerator * fraction.denominator == fraction.numerator * this.denominator) {
                return 0;
            }
            return i2 < 0 ? -1 : 1;
        }
        return invokeL.intValue;
    }

    public static Fraction getFraction(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(AdIconUtil.BAIDU_LOGO_ID, null, i2, i3, i4)) == null) {
            if (i4 != 0) {
                if (i4 >= 0) {
                    if (i3 >= 0) {
                        long j2 = i2 < 0 ? (i2 * i4) - i3 : (i2 * i4) + i3;
                        if (j2 >= -2147483648L && j2 <= 2147483647L) {
                            return new Fraction((int) j2, i4);
                        }
                        throw new ArithmeticException("Numerator too large to represent as an Integer.");
                    }
                    throw new ArithmeticException("The numerator must not be negative");
                }
                throw new ArithmeticException("The denominator must not be negative");
            }
            throw new ArithmeticException("The denominator must not be zero");
        }
        return (Fraction) invokeIII.objValue;
    }

    public static Fraction getFraction(double d2) {
        InterceptResult invokeCommon;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Double.valueOf(d2)})) == null) {
            int i4 = d2 < 0.0d ? -1 : 1;
            double abs = Math.abs(d2);
            if (abs > 2.147483647E9d || Double.isNaN(abs)) {
                throw new ArithmeticException("The value must not be greater than Integer.MAX_VALUE or NaN");
            }
            int i5 = (int) abs;
            double d3 = abs - i5;
            int i6 = (int) d3;
            double d4 = 1.0d;
            double d5 = d3 - i6;
            double d6 = Double.MAX_VALUE;
            int i7 = i4;
            int i8 = 1;
            int i9 = 0;
            int i10 = 0;
            int i11 = 1;
            int i12 = 1;
            while (true) {
                int i13 = (int) (d4 / d5);
                double d7 = d6;
                double d8 = d4 - (i13 * d5);
                int i14 = (i6 * i8) + i9;
                int i15 = (i6 * i10) + i11;
                d6 = Math.abs(d3 - (i14 / i15));
                i2 = i12 + 1;
                if (d7 <= d6 || i15 > 10000 || i15 <= 0) {
                    break;
                }
                i3 = 25;
                if (i2 >= 25) {
                    break;
                }
                i12 = i2;
                int i16 = i10;
                i10 = i15;
                i6 = i13;
                i9 = i8;
                i8 = i14;
                i11 = i16;
                d4 = d5;
                d5 = d8;
            }
            i3 = 25;
            if (i2 != i3) {
                return getReducedFraction((i8 + (i5 * i10)) * i7, i10);
            }
            throw new ArithmeticException("Unable to convert double to fraction");
        }
        return (Fraction) invokeCommon.objValue;
    }

    public static Fraction getFraction(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (str != null) {
                if (str.indexOf(46) >= 0) {
                    return getFraction(Double.parseDouble(str));
                }
                int indexOf = str.indexOf(32);
                if (indexOf > 0) {
                    int parseInt = Integer.parseInt(str.substring(0, indexOf));
                    String substring = str.substring(indexOf + 1);
                    int indexOf2 = substring.indexOf(47);
                    if (indexOf2 >= 0) {
                        return getFraction(parseInt, Integer.parseInt(substring.substring(0, indexOf2)), Integer.parseInt(substring.substring(indexOf2 + 1)));
                    }
                    throw new NumberFormatException("The fraction could not be parsed as the format X Y/Z");
                }
                int indexOf3 = str.indexOf(47);
                if (indexOf3 < 0) {
                    return getFraction(Integer.parseInt(str), 1);
                }
                return getFraction(Integer.parseInt(str.substring(0, indexOf3)), Integer.parseInt(str.substring(indexOf3 + 1)));
            }
            throw new IllegalArgumentException("The string must not be null");
        }
        return (Fraction) invokeL.objValue;
    }
}
