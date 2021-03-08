package com.yy.mediaframework.inteligence.coderate;

import android.os.Handler;
import com.yy.mediaframework.utils.YMFLog;
/* loaded from: classes6.dex */
public class DefaultCodeRateByFrame implements ICodeRateByFrame {
    static final int MAX_CODE_RATE = 2000000;
    static final int MIN_CODE_RATE = 800000;
    protected int mConfigCodeRate;
    protected int mConfigFrameRate;
    protected int mCurrentCodeRate;
    protected int mCurrentCodeRatePerFrame;
    protected int mCurrentFrameRate;
    protected int mLastSuggestCodeRate;
    protected int mNotifyStep;
    protected float mRatio;
    protected int mSuggestCodeRate;

    @Override // com.yy.mediaframework.inteligence.coderate.ICodeRateByFrame
    public void init(int i, int i2, int i3, Handler handler) {
        YMFLog.info(this, "[Encoder ]", "init coderate:%d, framerate:%d, notifystep:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        if (handler == null) {
            throw new RuntimeException("handler must not be null");
        }
        if (i <= 0 || i2 <= 0 || i3 <= 0) {
            throw new RuntimeException("coderate/framerate/notifystep must not less than 0");
        }
        this.mConfigCodeRate = i;
        this.mConfigFrameRate = i2;
        this.mNotifyStep = i3;
        this.mSuggestCodeRate = i;
        this.mCurrentFrameRate = i2;
        this.mCurrentCodeRate = i;
        this.mCurrentCodeRatePerFrame = this.mCurrentCodeRate / this.mCurrentFrameRate;
        this.mLastSuggestCodeRate = this.mSuggestCodeRate;
        this.mRatio = 1.0f;
    }

    @Override // com.yy.mediaframework.inteligence.coderate.ICodeRateByFrame
    public void publishCurrentFrameRate(int i, int i2) {
        if (i <= 0) {
            YMFLog.error(this, "[Encoder ]", "publish currentFrameRate less than 0");
            return;
        }
        this.mCurrentFrameRate = i;
        this.mCurrentCodeRate = i2;
        this.mCurrentCodeRatePerFrame = i2 / i;
        int i3 = this.mLastSuggestCodeRate / this.mConfigFrameRate;
        this.mRatio = i3 / this.mCurrentCodeRatePerFrame;
        if (this.mRatio > 1.2d) {
            this.mRatio = 1.2f;
        } else if (this.mRatio < 0.8d) {
            this.mRatio = 0.8f;
        }
        YMFLog.info(this, "[Encoder ]", "Current SuggestCodeRate:%d LastSuggestCodeRate:%d currentCodeRate:%d currentFrameRate:%d lastSuggestCodeRatePerFrame:%d CurrentCodeRatePerFrame:%d ratio:%f", Integer.valueOf(this.mSuggestCodeRate), Integer.valueOf(this.mLastSuggestCodeRate), Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(this.mCurrentCodeRatePerFrame), Float.valueOf(this.mRatio));
        this.mLastSuggestCodeRate = this.mSuggestCodeRate;
    }

    @Override // com.yy.mediaframework.inteligence.coderate.ICodeRateByFrame
    public void publishNetworkCodeRate(int i) {
        YMFLog.info(this, "[Encoder ]", "Network notify CodeRate:%d CurrentCodeRate:%d suggestCodeRate:%d", Integer.valueOf(i), Integer.valueOf(this.mCurrentCodeRate), Integer.valueOf(this.mSuggestCodeRate));
        if (this.mCurrentFrameRate <= 0 || this.mConfigFrameRate <= 0) {
            YMFLog.warn(this, "[Encoder ]", "Error current:%d or config framerate:%d", Integer.valueOf(this.mCurrentFrameRate), Integer.valueOf(this.mConfigFrameRate));
            return;
        }
        if (this.mCurrentFrameRate == this.mConfigFrameRate) {
            YMFLog.info(null, "[Encoder ]", "Network current FrameRate equals to config FrameRate");
            this.mSuggestCodeRate = i;
        } else {
            this.mSuggestCodeRate = (int) ((i / this.mCurrentFrameRate) * this.mConfigFrameRate * this.mRatio);
            if (this.mSuggestCodeRate <= 0) {
                this.mSuggestCodeRate = 800000;
            } else if (this.mSuggestCodeRate > 2000000) {
                this.mSuggestCodeRate = 2000000;
            }
            YMFLog.info(null, "[Encoder ]", "setNetworkBitrateSuggest do codeByFrame:" + this.mSuggestCodeRate);
        }
        YMFLog.info(null, "[Encoder ]", "Network adjust CodeRate:%d ratio:%f", Integer.valueOf(this.mSuggestCodeRate), Float.valueOf(this.mRatio));
    }

    @Override // com.yy.mediaframework.inteligence.coderate.ICodeRateByFrame
    public int getSuggestCodeRate() {
        return this.mSuggestCodeRate;
    }

    @Override // com.yy.mediaframework.inteligence.coderate.ICodeRateByFrame
    public void release() {
        YMFLog.info(null, "[Encoder ]", "release");
    }
}
