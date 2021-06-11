package com.yy.hiidostatis.inner.implementation;

import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.cipher.Coder;
import com.yy.hiidostatis.message.utils.NoNull;
import java.io.Serializable;
import java.util.UUID;
/* loaded from: classes7.dex */
public class TaskData implements Serializable {
    public static final String MAGIC_MD5 = "hd!@#$%";
    public static final long serialVersionUID = -3875880932357283826L;
    public String act;
    public long aid;
    public String appkey;
    public String content;
    public int crepid;
    public String dataId;
    public long order;
    public int packId;
    public int remain;
    public long time;
    public int tryTimes;
    public String verifyMd5;

    public TaskData(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.time = currentTimeMillis;
        this.order = currentTimeMillis;
        this.act = str;
    }

    public String createDataId() {
        try {
            return UUID.randomUUID().toString().replaceAll("-", "");
        } catch (Throwable unused) {
            return String.valueOf((long) (Math.random() * 1.0E9d));
        }
    }

    public String createVerifyMd5() {
        try {
            return Coder.encryptMD5(String.format("%s%s", this.content, MAGIC_MD5));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public boolean equals(Object obj) {
        return hashCode() == obj.hashCode();
    }

    public String getAct() {
        return this.act;
    }

    public long getAid() {
        return this.aid;
    }

    public String getAppkey() {
        if (!NoNull.isEmpty(this.appkey)) {
            return this.appkey;
        }
        return Util.parseParam(this.content, "appkey");
    }

    public String getContent() {
        return this.content;
    }

    public int getCrepid() {
        return this.crepid;
    }

    public String getDataId() {
        return this.dataId;
    }

    public long getOrder() {
        return this.order;
    }

    public int getPackId() {
        return this.packId;
    }

    public int getRemain() {
        return this.remain;
    }

    public long getTime() {
        return this.time;
    }

    public int getTryTimes() {
        return this.tryTimes;
    }

    public String getVerifyMd5() {
        return this.verifyMd5;
    }

    public int hashCode() {
        return getDataId().hashCode();
    }

    public void setAid(long j) {
        this.aid = j;
    }

    public void setAppkey(String str) {
        this.appkey = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setCrepid(int i2) {
        this.crepid = i2;
    }

    public void setDataId(String str) {
        this.dataId = str;
    }

    public void setOrder(long j) {
        this.order = j;
    }

    public void setPackId(int i2) {
        this.packId = i2;
    }

    public void setRemain(int i2) {
        this.remain = i2;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public void setTryTimes(int i2) {
        this.tryTimes = i2;
    }

    public void setVerifyMd5(String str) {
        this.verifyMd5 = str;
    }

    public boolean verifyMd5() {
        return getVerifyMd5() == null || getVerifyMd5().trim().length() == 0 || getVerifyMd5().equals(createVerifyMd5());
    }
}
