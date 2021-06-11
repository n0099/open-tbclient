package com.kwai.player.vr;

import android.util.SparseArray;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
/* loaded from: classes7.dex */
public class KwaiMesh {
    public static final int sPositionDataSize = 3;
    public static final int sTextureCoordinateDataSize = 2;
    public ShortBuffer mIndicesBuffer;
    public int mNumIndices;
    public SparseArray<FloatBuffer> mTexCoordinateBuffers = new SparseArray<>(2);
    public SparseArray<FloatBuffer> mVerticesBuffers = new SparseArray<>(2);

    public ShortBuffer getIndicesBuffer() {
        return this.mIndicesBuffer;
    }

    public int getNumIndices() {
        return this.mNumIndices;
    }

    public FloatBuffer getTexCoordinateBuffer(int i2) {
        return this.mTexCoordinateBuffers.get(i2);
    }

    public FloatBuffer getVerticesBuffer(int i2) {
        return this.mVerticesBuffers.get(i2);
    }

    public void setIndicesBuffer(ShortBuffer shortBuffer) {
        this.mIndicesBuffer = shortBuffer;
    }

    public void setNumIndices(int i2) {
        this.mNumIndices = i2;
    }

    public void setTexCoordinateBuffer(int i2, FloatBuffer floatBuffer) {
        this.mTexCoordinateBuffers.put(i2, floatBuffer);
    }

    public void setVerticesBuffer(int i2, FloatBuffer floatBuffer) {
        this.mVerticesBuffers.put(i2, floatBuffer);
    }
}
