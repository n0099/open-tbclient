package com.googlecode.mp4parser.util;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import java.nio.ByteBuffer;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes3.dex */
public class Matrix {
    public static /* synthetic */ Interceptable $ic;
    public static final Matrix ROTATE_0;
    public static final Matrix ROTATE_180;
    public static final Matrix ROTATE_270;
    public static final Matrix ROTATE_90;
    public transient /* synthetic */ FieldHolder $fh;
    public double a;

    /* renamed from: b  reason: collision with root package name */
    public double f54989b;

    /* renamed from: c  reason: collision with root package name */
    public double f54990c;

    /* renamed from: d  reason: collision with root package name */
    public double f54991d;
    public double tx;
    public double ty;
    public double u;
    public double v;
    public double w;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-972206213, "Lcom/googlecode/mp4parser/util/Matrix;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-972206213, "Lcom/googlecode/mp4parser/util/Matrix;");
                return;
            }
        }
        ROTATE_0 = new Matrix(1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
        ROTATE_90 = new Matrix(0.0d, 1.0d, -1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
        ROTATE_180 = new Matrix(-1.0d, 0.0d, 0.0d, -1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
        ROTATE_270 = new Matrix(0.0d, -1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    }

    public Matrix(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5), Double.valueOf(d6), Double.valueOf(d7), Double.valueOf(d8), Double.valueOf(d9), Double.valueOf(d10)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.u = d6;
        this.v = d7;
        this.w = d8;
        this.a = d2;
        this.f54989b = d3;
        this.f54990c = d4;
        this.f54991d = d5;
        this.tx = d9;
        this.ty = d10;
    }

    public static Matrix fromByteBuffer(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, byteBuffer)) == null) ? fromFileOrder(IsoTypeReader.readFixedPoint1616(byteBuffer), IsoTypeReader.readFixedPoint1616(byteBuffer), IsoTypeReader.readFixedPoint0230(byteBuffer), IsoTypeReader.readFixedPoint1616(byteBuffer), IsoTypeReader.readFixedPoint1616(byteBuffer), IsoTypeReader.readFixedPoint0230(byteBuffer), IsoTypeReader.readFixedPoint1616(byteBuffer), IsoTypeReader.readFixedPoint1616(byteBuffer), IsoTypeReader.readFixedPoint0230(byteBuffer)) : (Matrix) invokeL.objValue;
    }

    public static Matrix fromFileOrder(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5), Double.valueOf(d6), Double.valueOf(d7), Double.valueOf(d8), Double.valueOf(d9), Double.valueOf(d10)})) == null) ? new Matrix(d2, d3, d5, d6, d4, d7, d10, d8, d9) : (Matrix) invokeCommon.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Matrix.class != obj.getClass()) {
                return false;
            }
            Matrix matrix = (Matrix) obj;
            return Double.compare(matrix.a, this.a) == 0 && Double.compare(matrix.f54989b, this.f54989b) == 0 && Double.compare(matrix.f54990c, this.f54990c) == 0 && Double.compare(matrix.f54991d, this.f54991d) == 0 && Double.compare(matrix.tx, this.tx) == 0 && Double.compare(matrix.ty, this.ty) == 0 && Double.compare(matrix.u, this.u) == 0 && Double.compare(matrix.v, this.v) == 0 && Double.compare(matrix.w, this.w) == 0;
        }
        return invokeL.booleanValue;
    }

    public void getContent(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteBuffer) == null) {
            IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.a);
            IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.f54989b);
            IsoTypeWriter.writeFixedPoint0230(byteBuffer, this.u);
            IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.f54990c);
            IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.f54991d);
            IsoTypeWriter.writeFixedPoint0230(byteBuffer, this.v);
            IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.tx);
            IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.ty);
            IsoTypeWriter.writeFixedPoint0230(byteBuffer, this.w);
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            long doubleToLongBits = Double.doubleToLongBits(this.u);
            long doubleToLongBits2 = Double.doubleToLongBits(this.v);
            long doubleToLongBits3 = Double.doubleToLongBits(this.w);
            long doubleToLongBits4 = Double.doubleToLongBits(this.a);
            long doubleToLongBits5 = Double.doubleToLongBits(this.f54989b);
            long doubleToLongBits6 = Double.doubleToLongBits(this.f54990c);
            long doubleToLongBits7 = Double.doubleToLongBits(this.f54991d);
            long doubleToLongBits8 = Double.doubleToLongBits(this.tx);
            long doubleToLongBits9 = Double.doubleToLongBits(this.ty);
            return (((((((((((((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)))) * 31) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)))) * 31) + ((int) (doubleToLongBits6 ^ (doubleToLongBits6 >>> 32)))) * 31) + ((int) (doubleToLongBits7 ^ (doubleToLongBits7 >>> 32)))) * 31) + ((int) (doubleToLongBits8 ^ (doubleToLongBits8 >>> 32)))) * 31) + ((int) (doubleToLongBits9 ^ (doubleToLongBits9 >>> 32)));
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (equals(ROTATE_0)) {
                return "Rotate 0°";
            }
            if (equals(ROTATE_90)) {
                return "Rotate 90°";
            }
            if (equals(ROTATE_180)) {
                return "Rotate 180°";
            }
            if (equals(ROTATE_270)) {
                return "Rotate 270°";
            }
            return "Matrix{u=" + this.u + ", v=" + this.v + ", w=" + this.w + ", a=" + this.a + ", b=" + this.f54989b + ", c=" + this.f54990c + ", d=" + this.f54991d + ", tx=" + this.tx + ", ty=" + this.ty + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
