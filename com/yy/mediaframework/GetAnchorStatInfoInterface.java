package com.yy.mediaframework;
/* loaded from: classes4.dex */
public class GetAnchorStatInfoInterface {

    /* loaded from: classes4.dex */
    public interface IGetCurrentCameraEncodeStatInfo {
        int onGetAnchorCurrentBitRate();

        String onGetAnchorCurrentDIPRate();

        int onGetAnchorCurrentFrameRate();
    }

    /* loaded from: classes4.dex */
    public interface IGetImageFilterInfo {
        float onGetBeautyLevel();

        float onGetFaceLiftLevel();

        boolean onGetHasBeauty();

        boolean onGetHasDynamicSticker();

        boolean onGetHasFaceLift();

        boolean onGetHasSticker();
    }
}
