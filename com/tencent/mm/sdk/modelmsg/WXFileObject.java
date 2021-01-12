package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import java.io.File;
/* loaded from: classes14.dex */
public class WXFileObject implements WXMediaMessage.IMediaObject {
    private static final int CONTENT_LENGTH_LIMIT = 10485760;
    private static final String TAG = "MicroMsg.SDK.WXFileObject";
    private int contentLengthLimit;
    public byte[] fileData;
    public String filePath;

    public WXFileObject() {
        this.contentLengthLimit = 10485760;
        this.fileData = null;
        this.filePath = null;
    }

    public WXFileObject(String str) {
        this.contentLengthLimit = 10485760;
        this.filePath = str;
    }

    public WXFileObject(byte[] bArr) {
        this.contentLengthLimit = 10485760;
        this.fileData = bArr;
    }

    private int getFileSize(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        File file = new File(str);
        if (file.exists()) {
            return (int) file.length();
        }
        return 0;
    }

    @Override // com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        if ((this.fileData == null || this.fileData.length == 0) && (this.filePath == null || this.filePath.length() == 0)) {
            a.a(TAG, "checkArgs fail, both arguments is null");
            return false;
        } else if (this.fileData != null && this.fileData.length > this.contentLengthLimit) {
            a.a(TAG, "checkArgs fail, fileData is too large");
            return false;
        } else if (this.filePath == null || getFileSize(this.filePath) <= this.contentLengthLimit) {
            return true;
        } else {
            a.a(TAG, "checkArgs fail, fileSize is too large");
            return false;
        }
    }

    @Override // com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putByteArray("_wxfileobject_fileData", this.fileData);
        bundle.putString("_wxfileobject_filePath", this.filePath);
    }

    public void setContentLengthLimit(int i) {
        this.contentLengthLimit = i;
    }

    public void setFileData(byte[] bArr) {
        this.fileData = bArr;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    @Override // com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 6;
    }

    @Override // com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.fileData = bundle.getByteArray("_wxfileobject_fileData");
        this.filePath = bundle.getString("_wxfileobject_filePath");
    }
}
