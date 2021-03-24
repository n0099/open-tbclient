package com.facebook.imagepipeline.producers;

import android.net.Uri;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes.dex */
public class FetchState {
    public final Consumer<EncodedImage> mConsumer;
    public final ProducerContext mContext;
    public long mLastIntermediateResultTimeMs = 0;
    public int mOnNewResultStatusFlags;
    @Nullable
    public BytesRange mResponseBytesRange;

    public FetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        this.mConsumer = consumer;
        this.mContext = producerContext;
    }

    public Consumer<EncodedImage> getConsumer() {
        return this.mConsumer;
    }

    public ProducerContext getContext() {
        return this.mContext;
    }

    public String getId() {
        return this.mContext.getId();
    }

    public long getLastIntermediateResultTimeMs() {
        return this.mLastIntermediateResultTimeMs;
    }

    public ProducerListener getListener() {
        return this.mContext.getListener();
    }

    public String getLogTag() {
        return this.mContext.getImageRequest().mLogTag;
    }

    public Map<String, String> getNetRequestHeader() {
        return this.mContext.getImageRequest().getNetRequestHeader();
    }

    public int getOnNewResultStatusFlags() {
        return this.mOnNewResultStatusFlags;
    }

    @Nullable
    public BytesRange getResponseBytesRange() {
        return this.mResponseBytesRange;
    }

    public String getTag() {
        return this.mContext.getImageRequest().mTag;
    }

    public Uri getUri() {
        return this.mContext.getImageRequest().getSourceUri();
    }

    public void setLastIntermediateResultTimeMs(long j) {
        this.mLastIntermediateResultTimeMs = j;
    }

    public void setOnNewResultStatusFlags(int i) {
        this.mOnNewResultStatusFlags = i;
    }

    public void setResponseBytesRange(BytesRange bytesRange) {
        this.mResponseBytesRange = bytesRange;
    }
}
