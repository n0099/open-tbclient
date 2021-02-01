package com.yy.mediaframework;

import android.content.Context;
/* loaded from: classes4.dex */
public class VideoLibAPI {
    private static final String ASSETS_PATH = "baseoppo.png";
    private static VideoLibAPI sInstance = null;
    private YMFLiveAPI mVideoPublisher = YMFLiveAPI.getInstance();

    private VideoLibAPI() {
    }

    public static VideoLibAPI instance() {
        if (sInstance == null) {
            synchronized (VideoLibAPI.class) {
                if (sInstance == null) {
                    sInstance = new VideoLibAPI();
                }
            }
        }
        return sInstance;
    }

    public boolean initVideoLib(long j, long j2, Context context) {
        YYVideoSDK.getInstance().initSDK(context, "1", "Demo", "0.1", "Demo", "yyvideolib");
        return true;
    }

    public YMFLiveAPI getPublisher() {
        return this.mVideoPublisher;
    }
}
