package com.yy.hiidostatis.message.bean;

import com.yy.hiidostatis.inner.util.cipher.TextUtils;
import java.io.UnsupportedEncodingException;
/* loaded from: classes8.dex */
public class Message {
    public byte[] content;
    public int count;
    public int length;
    public String msgId;
    public String urlParams;

    public Message(String str, int i, String str2, byte[] bArr, int i2) {
        this.msgId = str;
        this.urlParams = str2;
        this.content = bArr;
        this.length = i2;
        this.count = i;
    }

    public byte[] getContent() {
        return this.content;
    }

    public int getLength() {
        return this.length;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public String getUrlParams() {
        return this.urlParams;
    }

    public boolean isSingle() {
        if (this.count == 1) {
            return true;
        }
        return false;
    }

    public byte[] toBody() {
        try {
            byte[] bytes = TextUtils.length2DecimalChar(this.length).getBytes("UTF-8");
            byte[] bArr = new byte[bytes.length + this.content.length];
            System.arraycopy(bytes, 0, bArr, 0, bytes.length);
            System.arraycopy(this.content, 0, bArr, bytes.length, this.content.length);
            return bArr;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setContent(byte[] bArr) {
        this.content = bArr;
    }

    public void setLength(int i) {
        this.length = i;
    }

    public void setMsgId(String str) {
        this.msgId = str;
    }

    public void setUrlParams(String str) {
        this.urlParams = str;
    }
}
