package com.kwai.player.vr;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
/* loaded from: classes3.dex */
public class KwaiSphereMesh extends KwaiBaseMesh {
    private static final String TAG = "KwaiSphereMesh";
    private static KwaiMesh kwaiMesh = new KwaiMesh();

    public static void generateSphere() {
        generateSphere(18.0f, 150);
    }

    private static void generateSphere(float f, int i) {
        int i2 = i / 2;
        int i3 = (i2 + 1) * (i + 1);
        float f2 = 6.2831855f / i;
        float[] fArr = new float[i3 * 3];
        float[] fArr2 = new float[i3 * 2];
        short[] sArr = new short[i2 * i * 6 * 6];
        float f3 = 2.0f / i;
        float f4 = 1.0f / i;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= i2 + 1) {
                break;
            }
            for (int i6 = 0; i6 < i + 1; i6++) {
                int i7 = (((i + 1) * i5) + i6) * 3;
                if (fArr != null) {
                    fArr[i7 + 0] = (-f) * ((float) Math.sin(i5 * f2)) * ((float) Math.sin(i6 * f2));
                    fArr[i7 + 1] = ((float) Math.sin(1.5707964f + (i5 * f2))) * f;
                    fArr[i7 + 2] = ((float) Math.sin(i5 * f2)) * f * ((float) Math.cos(i6 * f2));
                }
                if (fArr2 != null) {
                    int i8 = (((i + 1) * i5) + i6) * 2;
                    fArr2[i8 + 0] = i6 / i;
                    fArr2[i8 + 1] = i5 / i2;
                }
            }
            i4 = i5 + 1;
        }
        int i9 = 0;
        if (sArr != null) {
            for (int i10 = 0; i10 < i2; i10++) {
                for (int i11 = 0; i11 < i; i11++) {
                    int i12 = i9 + 1;
                    sArr[i9] = (short) (((i + 1) * i10) + i11);
                    int i13 = i12 + 1;
                    sArr[i12] = (short) (((i10 + 1) * (i + 1)) + i11);
                    int i14 = i13 + 1;
                    sArr[i13] = (short) (((i10 + 1) * (i + 1)) + i11 + 1);
                    int i15 = i14 + 1;
                    sArr[i14] = (short) (((i + 1) * i10) + i11);
                    int i16 = i15 + 1;
                    sArr[i15] = (short) (((i10 + 1) * (i + 1)) + i11 + 1);
                    i9 = i16 + 1;
                    sArr[i16] = (short) (((i + 1) * i10) + i11 + 1);
                }
            }
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(fArr2.length * 4);
        allocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
        asFloatBuffer2.put(fArr2);
        asFloatBuffer2.position(0);
        ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(sArr.length * 2);
        allocateDirect3.order(ByteOrder.nativeOrder());
        ShortBuffer asShortBuffer = allocateDirect3.asShortBuffer();
        asShortBuffer.put(sArr);
        asShortBuffer.position(0);
        kwaiMesh.setIndicesBuffer(asShortBuffer);
        kwaiMesh.setTexCoordinateBuffer(0, asFloatBuffer2);
        kwaiMesh.setTexCoordinateBuffer(1, asFloatBuffer2);
        kwaiMesh.setVerticesBuffer(0, asFloatBuffer);
        kwaiMesh.setVerticesBuffer(1, asFloatBuffer);
        kwaiMesh.setNumIndices(sArr.length);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwai.player.vr.KwaiBaseMesh
    public void genKwaiMesh() {
        generateSphere();
    }

    @Override // com.kwai.player.vr.KwaiBaseMesh
    public KwaiMesh getKwaiMesh() {
        return kwaiMesh;
    }
}
