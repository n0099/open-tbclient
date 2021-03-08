package com.yy.videoplayer;
/* loaded from: classes6.dex */
public class VideoRenderNotify {
    public int mDecodeStamp;
    public int mHeight;
    public boolean mIgnoreStatistic;
    public long mPts;
    public long mRenderStamp;
    public long mStreamId;
    public long mUserGroupId;
    public int mWidth;

    public VideoRenderNotify(long j, long j2, long j3, long j4, long j5, boolean z) {
        this.mUserGroupId = 0L;
        this.mStreamId = 0L;
        this.mPts = 0L;
        this.mRenderStamp = 0L;
        this.mDecodeStamp = 0;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mIgnoreStatistic = false;
        this.mUserGroupId = j;
        this.mStreamId = j2;
        this.mPts = j3;
        this.mRenderStamp = j4;
        this.mDecodeStamp = (int) j5;
        this.mIgnoreStatistic = z;
    }

    public VideoRenderNotify(long j, long j2, long j3, long j4, long j5, int i, int i2, boolean z) {
        this.mUserGroupId = 0L;
        this.mStreamId = 0L;
        this.mPts = 0L;
        this.mRenderStamp = 0L;
        this.mDecodeStamp = 0;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mIgnoreStatistic = false;
        this.mUserGroupId = j;
        this.mStreamId = j2;
        this.mPts = j3;
        this.mRenderStamp = j4;
        this.mDecodeStamp = (int) j5;
        this.mWidth = i;
        this.mHeight = i2;
        this.mIgnoreStatistic = z;
    }
}
