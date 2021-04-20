package com.googlecode.mp4parser.util;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class Matrix {

    /* renamed from: a  reason: collision with root package name */
    public double f31364a;

    /* renamed from: b  reason: collision with root package name */
    public double f31365b;

    /* renamed from: c  reason: collision with root package name */
    public double f31366c;

    /* renamed from: d  reason: collision with root package name */
    public double f31367d;
    public double tx;
    public double ty;
    public double u;
    public double v;
    public double w;
    public static final Matrix ROTATE_0 = new Matrix(1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    public static final Matrix ROTATE_90 = new Matrix(0.0d, 1.0d, -1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    public static final Matrix ROTATE_180 = new Matrix(-1.0d, 0.0d, 0.0d, -1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    public static final Matrix ROTATE_270 = new Matrix(0.0d, -1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);

    public Matrix(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        this.u = d6;
        this.v = d7;
        this.w = d8;
        this.f31364a = d2;
        this.f31365b = d3;
        this.f31366c = d4;
        this.f31367d = d5;
        this.tx = d9;
        this.ty = d10;
    }

    public static Matrix fromByteBuffer(ByteBuffer byteBuffer) {
        return fromFileOrder(IsoTypeReader.readFixedPoint1616(byteBuffer), IsoTypeReader.readFixedPoint1616(byteBuffer), IsoTypeReader.readFixedPoint0230(byteBuffer), IsoTypeReader.readFixedPoint1616(byteBuffer), IsoTypeReader.readFixedPoint1616(byteBuffer), IsoTypeReader.readFixedPoint0230(byteBuffer), IsoTypeReader.readFixedPoint1616(byteBuffer), IsoTypeReader.readFixedPoint1616(byteBuffer), IsoTypeReader.readFixedPoint0230(byteBuffer));
    }

    public static Matrix fromFileOrder(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        return new Matrix(d2, d3, d5, d6, d4, d7, d10, d8, d9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Matrix.class != obj.getClass()) {
            return false;
        }
        Matrix matrix = (Matrix) obj;
        return Double.compare(matrix.f31364a, this.f31364a) == 0 && Double.compare(matrix.f31365b, this.f31365b) == 0 && Double.compare(matrix.f31366c, this.f31366c) == 0 && Double.compare(matrix.f31367d, this.f31367d) == 0 && Double.compare(matrix.tx, this.tx) == 0 && Double.compare(matrix.ty, this.ty) == 0 && Double.compare(matrix.u, this.u) == 0 && Double.compare(matrix.v, this.v) == 0 && Double.compare(matrix.w, this.w) == 0;
    }

    public void getContent(ByteBuffer byteBuffer) {
        IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.f31364a);
        IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.f31365b);
        IsoTypeWriter.writeFixedPoint0230(byteBuffer, this.u);
        IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.f31366c);
        IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.f31367d);
        IsoTypeWriter.writeFixedPoint0230(byteBuffer, this.v);
        IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.tx);
        IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.ty);
        IsoTypeWriter.writeFixedPoint0230(byteBuffer, this.w);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.u);
        long doubleToLongBits2 = Double.doubleToLongBits(this.v);
        long doubleToLongBits3 = Double.doubleToLongBits(this.w);
        long doubleToLongBits4 = Double.doubleToLongBits(this.f31364a);
        long doubleToLongBits5 = Double.doubleToLongBits(this.f31365b);
        long doubleToLongBits6 = Double.doubleToLongBits(this.f31366c);
        long doubleToLongBits7 = Double.doubleToLongBits(this.f31367d);
        long doubleToLongBits8 = Double.doubleToLongBits(this.tx);
        long doubleToLongBits9 = Double.doubleToLongBits(this.ty);
        return (((((((((((((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)))) * 31) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)))) * 31) + ((int) (doubleToLongBits6 ^ (doubleToLongBits6 >>> 32)))) * 31) + ((int) (doubleToLongBits7 ^ (doubleToLongBits7 >>> 32)))) * 31) + ((int) (doubleToLongBits8 ^ (doubleToLongBits8 >>> 32)))) * 31) + ((int) (doubleToLongBits9 ^ (doubleToLongBits9 >>> 32)));
    }

    public String toString() {
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
        return "Matrix{u=" + this.u + ", v=" + this.v + ", w=" + this.w + ", a=" + this.f31364a + ", b=" + this.f31365b + ", c=" + this.f31366c + ", d=" + this.f31367d + ", tx=" + this.tx + ", ty=" + this.ty + '}';
    }
}
