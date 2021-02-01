package com.thunder.livesdk;

import android.graphics.Bitmap;
import com.thunder.livesdk.video.ThunderMultiVideoViewCoordinate;
import com.yy.videoplayer.videoview.VideoPosition;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class ThunderMultiVideoViewParam {
    public Bitmap mBgBitmap;
    @Deprecated
    public VideoPosition mBgPosition;
    public ThunderMultiVideoViewCoordinate mBgViewPosition;
    @Deprecated
    public ArrayList<VideoPosition> mVideoPositions;
    public ArrayList<ThunderMultiVideoViewCoordinate> mVideoViewPositions;
    public Object mView;
    public int mViewId;

    public ThunderMultiVideoViewParam() {
        this.mViewId = -1;
        this.mView = null;
    }

    public ThunderMultiVideoViewParam(Bitmap bitmap, ArrayList<ThunderMultiVideoViewCoordinate> arrayList, ThunderMultiVideoViewCoordinate thunderMultiVideoViewCoordinate) {
        this.mViewId = -1;
        this.mView = null;
        this.mBgBitmap = bitmap;
        this.mVideoViewPositions = arrayList;
        this.mBgViewPosition = thunderMultiVideoViewCoordinate;
    }

    public ThunderMultiVideoViewParam(int i, Object obj, Bitmap bitmap, ArrayList<ThunderMultiVideoViewCoordinate> arrayList, ThunderMultiVideoViewCoordinate thunderMultiVideoViewCoordinate) {
        this.mViewId = -1;
        this.mView = null;
        this.mViewId = i;
        this.mView = obj;
        this.mBgBitmap = bitmap;
        this.mVideoViewPositions = arrayList;
        this.mBgViewPosition = thunderMultiVideoViewCoordinate;
    }

    @Deprecated
    public ThunderMultiVideoViewParam(ArrayList<VideoPosition> arrayList, VideoPosition videoPosition, Bitmap bitmap) {
        this.mViewId = -1;
        this.mView = null;
        this.mVideoPositions = arrayList;
        this.mBgPosition = videoPosition;
        this.mBgBitmap = bitmap;
    }

    @Deprecated
    public ThunderMultiVideoViewParam(ArrayList<VideoPosition> arrayList, VideoPosition videoPosition, Bitmap bitmap, int i, Object obj) {
        this.mViewId = -1;
        this.mView = null;
        this.mVideoPositions = arrayList;
        this.mBgPosition = videoPosition;
        this.mBgBitmap = bitmap;
        this.mViewId = i;
        this.mView = obj;
    }

    public String toString() {
        Iterator<ThunderMultiVideoViewCoordinate> it;
        String str = ("" + this.mViewId + "," + this.mView) + " bg:[" + this.mBgBitmap + "," + (this.mBgViewPosition == null ? "null" : this.mBgViewPosition.toString()) + "],";
        if (this.mVideoViewPositions != null && this.mVideoViewPositions.size() != 0) {
            String str2 = str + "[";
            while (true) {
                String str3 = str2;
                if (this.mVideoViewPositions.iterator().hasNext()) {
                    str2 = str3 + it.next().toString() + ",";
                } else {
                    return str3 + "]";
                }
            }
        } else {
            return str;
        }
    }
}
