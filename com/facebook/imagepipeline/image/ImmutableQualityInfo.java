package com.facebook.imagepipeline.image;
/* loaded from: classes5.dex */
public class ImmutableQualityInfo implements QualityInfo {
    public static final QualityInfo FULL_QUALITY = of(Integer.MAX_VALUE, true, true);
    public boolean mIsOfFullQuality;
    public boolean mIsOfGoodEnoughQuality;
    public int mQuality;

    public ImmutableQualityInfo(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.mIsOfGoodEnoughQuality = z;
        this.mIsOfFullQuality = z2;
    }

    public static QualityInfo of(int i, boolean z, boolean z2) {
        return new ImmutableQualityInfo(i, z, z2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableQualityInfo) {
            ImmutableQualityInfo immutableQualityInfo = (ImmutableQualityInfo) obj;
            return this.mQuality == immutableQualityInfo.mQuality && this.mIsOfGoodEnoughQuality == immutableQualityInfo.mIsOfGoodEnoughQuality && this.mIsOfFullQuality == immutableQualityInfo.mIsOfFullQuality;
        }
        return false;
    }

    @Override // com.facebook.imagepipeline.image.QualityInfo
    public int getQuality() {
        return this.mQuality;
    }

    public int hashCode() {
        return (this.mQuality ^ (this.mIsOfGoodEnoughQuality ? 4194304 : 0)) ^ (this.mIsOfFullQuality ? 8388608 : 0);
    }

    @Override // com.facebook.imagepipeline.image.QualityInfo
    public boolean isOfFullQuality() {
        return this.mIsOfFullQuality;
    }

    @Override // com.facebook.imagepipeline.image.QualityInfo
    public boolean isOfGoodEnoughQuality() {
        return this.mIsOfGoodEnoughQuality;
    }
}
