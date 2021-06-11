package com.yy.hiidostatis.message.bean;

import com.yy.hiidostatis.inner.util.cipher.TextUtils;
import java.io.UnsupportedEncodingException;
/* loaded from: classes7.dex */
public class Message {
    public byte[] content;
    public int count;
    public int length;
    public String msgId;
    public String urlParams;

    public Message(String str, int i2, String str2, byte[] bArr, int i3) {
        this.msgId = str;
        this.urlParams = str2;
        this.content = bArr;
        this.length = i3;
        this.count = i2;
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
        return this.count == 1;
    }

    public void setContent(byte[] bArr) {
        this.content = bArr;
    }

    public void setLength(int i2) {
        this.length = i2;
    }

    public void setMsgId(String str) {
        this.msgId = str;
    }

    public void setUrlParams(String str) {
        this.urlParams = str;
    }

    public byte[] toBody() {
        try {
            byte[] bytes = TextUtils.length2DecimalChar(this.length).getBytes("UTF-8");
            byte[] bArr = new byte[bytes.length + this.content.length];
            System.arraycopy(bytes, 0, bArr, 0, bytes.length);
            System.arraycopy(this.content, 0, bArr, bytes.length, this.content.length);
            return bArr;
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
