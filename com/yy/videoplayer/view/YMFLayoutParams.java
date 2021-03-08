package com.yy.videoplayer.view;

import android.graphics.Bitmap;
import com.yy.videoplayer.utils.YMFLog;
/* loaded from: classes6.dex */
public class YMFLayoutParams {
    private static final String TAG = "YMFLayoutParams";
    public YMFVideoPosition[] mDrawPosition;
    public int mTotalVideoCnt;
    public Bitmap background = null;
    public YMFVideoPosition backgroudPosition = null;

    public YMFLayoutParams(int i) {
        this.mTotalVideoCnt = -1;
        this.mTotalVideoCnt = i;
        this.mDrawPosition = new YMFVideoPosition[i];
    }

    public static void clonePosition(YMFVideoPosition yMFVideoPosition, YMFVideoPosition yMFVideoPosition2) {
        if (yMFVideoPosition == null || yMFVideoPosition2 == null) {
            YMFLog.info(null, "[Render  ]", "clonePosition src:" + yMFVideoPosition + " dst:" + yMFVideoPosition2);
            return;
        }
        yMFVideoPosition2.mIndex = yMFVideoPosition.mIndex;
        yMFVideoPosition2.mX = yMFVideoPosition.mX;
        yMFVideoPosition2.mY = yMFVideoPosition.mY;
        yMFVideoPosition2.mWidth = yMFVideoPosition.mWidth;
        yMFVideoPosition2.mHeight = yMFVideoPosition.mHeight;
    }
}
