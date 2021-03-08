package com.thunder.livesdk;

import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class LiveTranscoding {
    private TranscodingImage mBackgroundImage;
    private MediaStreamLayout mMediaStreamLayout;
    private TranscodingTimestamp mTimestamp;
    private int mTransCodingMode;
    private CustomTranscodingOptions mTranscodingModeOptions;
    private String mAudioUrl = "";
    private String mLyricUrl = "";
    private String mMediaUrl = "";
    private ArrayList<TranscodingUser> mUserList = new ArrayList<>();
    private ArrayList<TranscodingText> mTextList = new ArrayList<>();
    private ArrayList<TranscodingImage> mImageList = new ArrayList<>();
    public int mTransCodingStreamType = 0;
    private int mBackgroundColor = 0;

    public String getAudioUrl() {
        return this.mAudioUrl;
    }

    public String getLyricUrl() {
        return this.mLyricUrl;
    }

    public String getMediaUrl() {
        return this.mMediaUrl;
    }

    public MediaStreamLayout getMediaStreamLayout() {
        return this.mMediaStreamLayout;
    }

    public void setTransCodingStreamType(int i) {
        this.mTransCodingStreamType = i;
    }

    public int getTransCodingStreamType() {
        return this.mTransCodingStreamType;
    }

    public void setCustomTranscodingOptions(CustomTranscodingOptions customTranscodingOptions) {
        this.mTranscodingModeOptions = customTranscodingOptions;
    }

    public CustomTranscodingOptions getCustomTranscodingOptions() {
        return this.mTranscodingModeOptions;
    }

    public void setBackgroundColor(int i) {
        this.mBackgroundColor = i;
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public void setBackgroundImage(TranscodingImage transcodingImage) {
        this.mBackgroundImage = transcodingImage;
    }

    public TranscodingImage getBackgroundImage() {
        return this.mBackgroundImage;
    }

    public void setTimestamp(TranscodingTimestamp transcodingTimestamp) {
        this.mTimestamp = transcodingTimestamp;
    }

    public TranscodingTimestamp getTimestamp() {
        return this.mTimestamp;
    }

    public void addTexts(ArrayList<TranscodingText> arrayList) {
        this.mTextList.clear();
        if (arrayList.size() > 3) {
            this.mTextList.addAll(arrayList.subList(0, 2));
        } else {
            this.mTextList.addAll(arrayList);
        }
    }

    public int getTextCount() {
        return this.mTextList.size();
    }

    public final ArrayList<TranscodingText> getTexts() {
        return this.mTextList;
    }

    public void addImages(ArrayList<TranscodingImage> arrayList) {
        this.mImageList.clear();
        if (arrayList.size() > 4) {
            this.mImageList.addAll(arrayList.subList(0, 3));
        } else {
            this.mImageList.addAll(arrayList);
        }
    }

    public int getImageCount() {
        return this.mImageList.size();
    }

    public final ArrayList<TranscodingImage> getImages() {
        return this.mImageList;
    }

    public int addUser(TranscodingUser transcodingUser) {
        if (this.mUserList != null) {
            this.mUserList.add(transcodingUser);
            return 0;
        }
        return 0;
    }

    public void setUsers(ArrayList<TranscodingUser> arrayList) {
        this.mUserList.clear();
        if (arrayList != null) {
            this.mUserList.addAll(arrayList);
        }
    }

    public final ArrayList<TranscodingUser> getUsers() {
        return this.mUserList;
    }

    public int removeUser(String str) {
        Iterator<TranscodingUser> it = this.mUserList.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().uid)) {
                it.remove();
            }
        }
        return 0;
    }

    public int removeAllUser() {
        this.mUserList.clear();
        return 0;
    }

    public int getUserCount() {
        if (this.mUserList == null || this.mUserList.isEmpty()) {
            return 0;
        }
        return this.mUserList.size();
    }

    public void setTransCodingMode(int i) {
        this.mTransCodingMode = i;
    }

    public int getTransCodingMode() {
        return this.mTransCodingMode;
    }

    /* loaded from: classes6.dex */
    public static class TranscodingUser {
        public String uid = "";
        public String roomId = "";
        public boolean bStandard = false;
        public int layoutX = 0;
        public int layoutY = 0;
        public int layoutW = 0;
        public int layoutH = 0;
        public int zOrder = 0;
        public boolean bCrop = false;
        public int cropX = 0;
        public int cropY = 0;
        public int cropW = 0;
        public int cropH = 0;
        public float alpha = 1.0f;
        public int audioRoom = 0;
        public int layoutShape = 0;

        public boolean equals(Object obj) {
            if (obj instanceof TranscodingUser) {
                TranscodingUser transcodingUser = (TranscodingUser) obj;
                return this.uid.equals(transcodingUser.uid) && this.roomId.equals(transcodingUser.roomId);
            }
            return false;
        }

        public int hashCode() {
            return (this.uid + this.roomId).hashCode();
        }

        public String toString() {
            return "{TranscodingUser: uid " + this.uid + ", roomId " + this.roomId + ", bStandard " + this.bStandard + ", x " + this.layoutX + ", y " + this.layoutY + ", w " + this.layoutW + ", h " + this.layoutH + ", zOrder " + this.zOrder + ", bCrop " + this.bCrop + ", cropX " + this.cropX + ", cropY " + this.cropY + ", cropW " + this.cropW + ", cropH " + this.cropH + ", alpha " + this.alpha + ", audioRoom " + this.audioRoom + ", layoutShape " + this.layoutShape + "}";
        }
    }

    /* loaded from: classes6.dex */
    public static class MediaStreamLayout {
        public int layoutX = 0;
        public int layoutY = 0;
        public int layoutW = 0;
        public int layoutH = 0;
        public int zOrder = 0;
        public boolean bCrop = true;
        public int cropX = 0;
        public int cropY = 0;
        public int cropW = 0;
        public int cropH = 0;
        public float alpha = 0.0f;

        public boolean equals(Object obj) {
            if (obj instanceof MediaStreamLayout) {
                MediaStreamLayout mediaStreamLayout = (MediaStreamLayout) obj;
                return this.layoutX == mediaStreamLayout.layoutX && this.layoutY == mediaStreamLayout.layoutY;
            }
            return false;
        }

        public int hashCode() {
            return String.valueOf(this.layoutX + this.layoutY + this.layoutW + this.layoutH).hashCode();
        }
    }

    public final int setAudioOnlyStandardSreamUrl(String str, String str2) {
        this.mAudioUrl = str;
        this.mLyricUrl = str2;
        this.mMediaUrl = "";
        this.mMediaStreamLayout = null;
        return 0;
    }

    public final int setMediaStandardSream(String str, MediaStreamLayout mediaStreamLayout) {
        this.mMediaUrl = str;
        this.mMediaStreamLayout = mediaStreamLayout;
        this.mAudioUrl = "";
        this.mLyricUrl = "";
        return 0;
    }
}
