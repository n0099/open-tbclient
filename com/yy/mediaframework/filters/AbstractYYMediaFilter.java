package com.yy.mediaframework.filters;

import com.yy.mediaframework.IMediaFilter;
import com.yy.mediaframework.model.YYMediaSample;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public abstract class AbstractYYMediaFilter implements IMediaFilter {
    protected ArrayList<IMediaFilter> mDownStreamList = new ArrayList<>();
    protected int mImageWidth = 0;
    protected int mImageHeight = 0;
    protected int mOutputWidth = 0;
    protected int mOutputHeight = 0;
    final float[] SLAVE_VEX_RIGHT_BOTTOM = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, -1.0f, 1.0f, -1.0f};
    protected FloatBuffer mSlaveVertexBuffer = ByteBuffer.allocateDirect(this.SLAVE_VEX_RIGHT_BOTTOM.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractYYMediaFilter() {
        this.mSlaveVertexBuffer.put(this.SLAVE_VEX_RIGHT_BOTTOM).position(0);
    }

    public void setImageSize(int i, int i2) {
        this.mImageHeight = i2;
        this.mImageWidth = i;
    }

    public boolean checkImageSizeUpdated(int i, int i2, boolean z) {
        if (i == this.mImageWidth && i2 == this.mImageHeight) {
            return false;
        }
        if (z) {
            this.mImageWidth = i;
            this.mImageHeight = i2;
        }
        return true;
    }

    public boolean checkOuptuSizeUpdate(int i, int i2, boolean z) {
        if (i == this.mOutputWidth && i2 == this.mOutputHeight) {
            return false;
        }
        if (z) {
            this.mOutputWidth = i;
            this.mOutputHeight = i2;
        }
        return true;
    }

    public void setOutputSize(int i, int i2) {
        this.mOutputWidth = i;
        this.mOutputHeight = i2;
    }

    @Override // com.yy.mediaframework.IMediaFilter
    public boolean processMediaSample(YYMediaSample yYMediaSample, Object obj) {
        return false;
    }

    public AbstractYYMediaFilter addDownStream(IMediaFilter iMediaFilter) {
        if (this.mDownStreamList.indexOf(iMediaFilter) < 0) {
            this.mDownStreamList.add(iMediaFilter);
        }
        return this;
    }

    public void removeDownStream(IMediaFilter iMediaFilter) {
        this.mDownStreamList.remove(iMediaFilter);
    }

    public void removeAllDownStream() {
        this.mDownStreamList.clear();
    }

    public boolean deliverToDownStream(YYMediaSample yYMediaSample) {
        Iterator<IMediaFilter> it = this.mDownStreamList.iterator();
        while (it.hasNext()) {
            it.next().processMediaSample(yYMediaSample, this);
        }
        return false;
    }

    public void deInit() {
    }
}
