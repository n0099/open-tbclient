package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class CmdObject extends BaseMediaObject {
    public static final String CMD_HOME = "home";
    public static final Parcelable.Creator<CmdObject> CREATOR = new Parcelable.Creator<CmdObject>() { // from class: com.sina.weibo.sdk.api.CmdObject.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CmdObject createFromParcel(Parcel parcel) {
            return new CmdObject(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CmdObject[] newArray(int i) {
            return new CmdObject[i];
        }
    };
    public String cmd;

    public CmdObject() {
    }

    public CmdObject(Parcel parcel) {
        this.cmd = parcel.readString();
    }

    @Override // com.sina.weibo.sdk.api.BaseMediaObject, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.sina.weibo.sdk.api.BaseMediaObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.cmd);
    }

    @Override // com.sina.weibo.sdk.api.BaseMediaObject
    public boolean checkArgs() {
        return (this.cmd == null || this.cmd.length() == 0 || this.cmd.length() > 1024) ? false : true;
    }

    @Override // com.sina.weibo.sdk.api.BaseMediaObject
    public int getObjType() {
        return 7;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sina.weibo.sdk.api.BaseMediaObject
    public BaseMediaObject toExtraMediaObject(String str) {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sina.weibo.sdk.api.BaseMediaObject
    public String toExtraMediaString() {
        return "";
    }
}
