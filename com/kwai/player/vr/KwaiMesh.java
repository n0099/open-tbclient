package com.kwai.player.vr;

import android.util.SparseArray;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
/* loaded from: classes6.dex */
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

    public FloatBuffer getTexCoordinateBuffer(int i) {
        return this.mTexCoordinateBuffers.get(i);
    }

    public FloatBuffer getVerticesBuffer(int i) {
        return this.mVerticesBuffers.get(i);
    }

    public void setIndicesBuffer(ShortBuffer shortBuffer) {
        this.mIndicesBuffer = shortBuffer;
    }

    public void setNumIndices(int i) {
        this.mNumIndices = i;
    }

    public void setTexCoordinateBuffer(int i, FloatBuffer floatBuffer) {
        this.mTexCoordinateBuffers.put(i, floatBuffer);
    }

    public void setVerticesBuffer(int i, FloatBuffer floatBuffer) {
        this.mVerticesBuffers.put(i, floatBuffer);
    }
}
