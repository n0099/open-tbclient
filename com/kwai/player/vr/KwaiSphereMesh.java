package com.kwai.player.vr;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
/* loaded from: classes6.dex */
public class KwaiSphereMesh extends KwaiBaseMesh {
    public static final String TAG = "KwaiSphereMesh";
    public static KwaiMesh kwaiMesh = new KwaiMesh();

    public static void generateSphere() {
        generateSphere(18.0f, 150);
    }

    public static void generateSphere(float f2, int i) {
        float f3;
        int i2 = i / 2;
        int i3 = i2 + 1;
        int i4 = i + 1;
        int i5 = i3 * i4;
        float f4 = i;
        float f5 = 6.2831855f / f4;
        int i6 = i5 * 3;
        float[] fArr = new float[i6];
        int i7 = i5 * 2;
        float[] fArr2 = new float[i7];
        int i8 = i2 * i * 6 * 6;
        short[] sArr = new short[i8];
        int i9 = 0;
        while (i9 < i3) {
            int i10 = 0;
            while (i10 < i4) {
                int i11 = (i9 * i4) + i10;
                int i12 = i11 * 3;
                int i13 = i3;
                int i14 = i7;
                double d2 = i9 * f5;
                double d3 = i10 * f5;
                fArr[i12 + 0] = (-f2) * ((float) Math.sin(d2)) * ((float) Math.sin(d3));
                fArr[i12 + 1] = ((float) Math.sin(f3 + 1.5707964f)) * f2;
                fArr[i12 + 2] = ((float) Math.sin(d2)) * f2 * ((float) Math.cos(d3));
                int i15 = i11 * 2;
                fArr2[i15 + 0] = i10 / f4;
                i2 = i2;
                fArr2[i15 + 1] = i9 / i2;
                i10++;
                i4 = i4;
                i3 = i13;
                i7 = i14;
                i8 = i8;
                f5 = f5;
                i6 = i6;
            }
            i9++;
            i6 = i6;
        }
        int i16 = i7;
        int i17 = i8;
        int i18 = i6;
        int i19 = i4;
        int i20 = 0;
        for (int i21 = 0; i21 < i2; i21++) {
            int i22 = 0;
            while (i22 < i) {
                int i23 = i20 + 1;
                int i24 = i21 * i19;
                short s = (short) (i24 + i22);
                sArr[i20] = s;
                int i25 = i23 + 1;
                int i26 = (i21 + 1) * i19;
                sArr[i23] = (short) (i26 + i22);
                int i27 = i25 + 1;
                i22++;
                short s2 = (short) (i26 + i22);
                sArr[i25] = s2;
                int i28 = i27 + 1;
                sArr[i27] = s;
                int i29 = i28 + 1;
                sArr[i28] = s2;
                i20 = i29 + 1;
                sArr[i29] = (short) (i24 + i22);
            }
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i18 * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(i16 * 4);
        allocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
        asFloatBuffer2.put(fArr2);
        asFloatBuffer2.position(0);
        ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(i17 * 2);
        allocateDirect3.order(ByteOrder.nativeOrder());
        ShortBuffer asShortBuffer = allocateDirect3.asShortBuffer();
        asShortBuffer.put(sArr);
        asShortBuffer.position(0);
        kwaiMesh.setIndicesBuffer(asShortBuffer);
        kwaiMesh.setTexCoordinateBuffer(0, asFloatBuffer2);
        kwaiMesh.setTexCoordinateBuffer(1, asFloatBuffer2);
        kwaiMesh.setVerticesBuffer(0, asFloatBuffer);
        kwaiMesh.setVerticesBuffer(1, asFloatBuffer);
        kwaiMesh.setNumIndices(i17);
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
