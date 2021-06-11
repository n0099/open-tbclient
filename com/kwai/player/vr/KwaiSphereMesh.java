package com.kwai.player.vr;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
/* loaded from: classes7.dex */
public class KwaiSphereMesh extends KwaiBaseMesh {
    public static final String TAG = "KwaiSphereMesh";
    public static KwaiMesh kwaiMesh = new KwaiMesh();

    public static void generateSphere() {
        generateSphere(18.0f, 150);
    }

    public static void generateSphere(float f2, int i2) {
        float f3;
        int i3 = i2 / 2;
        int i4 = i3 + 1;
        int i5 = i2 + 1;
        int i6 = i4 * i5;
        float f4 = i2;
        float f5 = 6.2831855f / f4;
        int i7 = i6 * 3;
        float[] fArr = new float[i7];
        int i8 = i6 * 2;
        float[] fArr2 = new float[i8];
        int i9 = i3 * i2 * 6 * 6;
        short[] sArr = new short[i9];
        int i10 = 0;
        while (i10 < i4) {
            int i11 = 0;
            while (i11 < i5) {
                int i12 = (i10 * i5) + i11;
                int i13 = i12 * 3;
                int i14 = i4;
                int i15 = i8;
                double d2 = i10 * f5;
                double d3 = i11 * f5;
                fArr[i13 + 0] = (-f2) * ((float) Math.sin(d2)) * ((float) Math.sin(d3));
                fArr[i13 + 1] = ((float) Math.sin(f3 + 1.5707964f)) * f2;
                fArr[i13 + 2] = ((float) Math.sin(d2)) * f2 * ((float) Math.cos(d3));
                int i16 = i12 * 2;
                fArr2[i16 + 0] = i11 / f4;
                i3 = i3;
                fArr2[i16 + 1] = i10 / i3;
                i11++;
                i5 = i5;
                i4 = i14;
                i8 = i15;
                i9 = i9;
                f5 = f5;
                i7 = i7;
            }
            i10++;
            i7 = i7;
        }
        int i17 = i8;
        int i18 = i9;
        int i19 = i7;
        int i20 = i5;
        int i21 = 0;
        for (int i22 = 0; i22 < i3; i22++) {
            int i23 = 0;
            while (i23 < i2) {
                int i24 = i21 + 1;
                int i25 = i22 * i20;
                short s = (short) (i25 + i23);
                sArr[i21] = s;
                int i26 = i24 + 1;
                int i27 = (i22 + 1) * i20;
                sArr[i24] = (short) (i27 + i23);
                int i28 = i26 + 1;
                i23++;
                short s2 = (short) (i27 + i23);
                sArr[i26] = s2;
                int i29 = i28 + 1;
                sArr[i28] = s;
                int i30 = i29 + 1;
                sArr[i29] = s2;
                i21 = i30 + 1;
                sArr[i30] = (short) (i25 + i23);
            }
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i19 * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(i17 * 4);
        allocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
        asFloatBuffer2.put(fArr2);
        asFloatBuffer2.position(0);
        ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(i18 * 2);
        allocateDirect3.order(ByteOrder.nativeOrder());
        ShortBuffer asShortBuffer = allocateDirect3.asShortBuffer();
        asShortBuffer.put(sArr);
        asShortBuffer.position(0);
        kwaiMesh.setIndicesBuffer(asShortBuffer);
        kwaiMesh.setTexCoordinateBuffer(0, asFloatBuffer2);
        kwaiMesh.setTexCoordinateBuffer(1, asFloatBuffer2);
        kwaiMesh.setVerticesBuffer(0, asFloatBuffer);
        kwaiMesh.setVerticesBuffer(1, asFloatBuffer);
        kwaiMesh.setNumIndices(i18);
    }

    @Override // com.kwai.player.vr.KwaiBaseMesh
    public void genKwaiMesh() {
        generateSphere();
    }

    @Override // com.kwai.player.vr.KwaiBaseMesh
    public KwaiMesh getKwaiMesh() {
        return kwaiMesh;
    }
}
