package com.meizu.cloud.pushsdk.handler;

import android.text.TextUtils;
import com.baidu.searchbox.aperf.bosuploader.ContentUtil;
import com.meizu.cloud.pushsdk.c.f.e;
import java.io.Serializable;
import java.util.Map;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes10.dex */
public class MzPushMessage implements Serializable {
    public static final String TAG = "MzPushMessage";
    public String content;
    public int notifyId;
    public int pushType;
    public String selfDefineContentString;
    public String taskId;
    public String title;

    public static MzPushMessage fromMessageV3(MessageV3 messageV3) {
        MzPushMessage mzPushMessage = new MzPushMessage();
        mzPushMessage.setTitle(messageV3.getTitle());
        mzPushMessage.setContent(messageV3.getContent());
        mzPushMessage.setTaskId(messageV3.getTaskId());
        mzPushMessage.setPushType(0);
        mzPushMessage.setNotifyId(com.meizu.cloud.pushsdk.notification.model.a.b(messageV3));
        mzPushMessage.setSelfDefineContentString(selfDefineContentString(messageV3.getWebUrl(), messageV3.getParamsMap()));
        return mzPushMessage;
    }

    public static String selfDefineContentString(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            if (map != null) {
                str = map.get(ContentUtil.RESULT_KEY_SK);
                if (TextUtils.isEmpty(str)) {
                    str = e.a((Map) map).toString();
                }
            } else {
                str = null;
            }
        }
        c.l.a.a.a.b(TAG, "self json " + str);
        return str;
    }

    public String getContent() {
        return this.content;
    }

    public int getNotifyId() {
        return this.notifyId;
    }

    public int getPushType() {
        return this.pushType;
    }

    public String getSelfDefineContentString() {
        return this.selfDefineContentString;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setNotifyId(int i2) {
        this.notifyId = i2;
    }

    public void setPushType(int i2) {
        this.pushType = i2;
    }

    public void setSelfDefineContentString(String str) {
        this.selfDefineContentString = str;
    }

    public void setTaskId(String str) {
        this.taskId = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "MzPushMessage{title='" + this.title + ExtendedMessageFormat.QUOTE + ", content='" + this.content + ExtendedMessageFormat.QUOTE + ", pushType=" + this.pushType + ", taskId='" + this.taskId + ExtendedMessageFormat.QUOTE + ", selfDefineContentString='" + this.selfDefineContentString + ExtendedMessageFormat.QUOTE + ", notifyId=" + this.notifyId + ExtendedMessageFormat.END_FE;
    }
}
