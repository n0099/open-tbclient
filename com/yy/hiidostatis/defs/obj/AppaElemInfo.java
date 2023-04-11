package com.yy.hiidostatis.defs.obj;

import com.yy.hiidostatis.inner.util.Util;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class AppaElemInfo extends ParamableElem implements Elem {
    public static final long serialVersionUID = 5075819899173282579L;
    public long dtime;
    public long ftime;
    public long ltime;
    public long stime;

    public AppaElemInfo() {
    }

    public AppaElemInfo copy() {
        AppaElemInfo appaElemInfo = new AppaElemInfo();
        appaElemInfo.dtime = this.dtime;
        appaElemInfo.ftime = this.ftime;
        appaElemInfo.ltime = this.ltime;
        appaElemInfo.stime = this.stime;
        appaElemInfo.addParams(new ArrayList(getParams()));
        return appaElemInfo;
    }

    public long getDelayedTime() {
        return this.dtime;
    }

    public long getFtime() {
        return this.ftime;
    }

    public long getLingerTime() {
        return this.ltime;
    }

    public long getStime() {
        return this.stime;
    }

    public String toString() {
        return "stime=" + this.stime + " ftime(millis)=" + this.ftime + " ltime(millis)=" + this.ltime + " dtime(millis)=" + this.dtime;
    }

    public AppaElemInfo(long j, long j2, long j3, long j4) {
        this.stime = j;
        this.ftime = j2;
        this.ltime = j3;
        this.dtime = j4;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.stime = objectInputStream.readLong();
        this.ftime = objectInputStream.readLong();
        this.ltime = objectInputStream.readLong();
        this.dtime = objectInputStream.readLong();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeLong(this.stime);
        objectOutputStream.writeLong(this.ftime);
        objectOutputStream.writeLong(this.ltime);
        objectOutputStream.writeLong(this.dtime);
    }

    public void setDtime(long j) {
        this.dtime = j;
    }

    public void setFtime(long j) {
        this.ftime = j;
    }

    public void setLingerTime(long j) {
        this.ltime = j;
    }

    public void setStime(long j) {
        this.stime = j;
    }

    @Override // com.yy.hiidostatis.defs.obj.Elem
    public String getStringRep() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.stime);
        sb.append(":");
        sb.append(this.ftime);
        sb.append(":");
        sb.append(this.ltime);
        sb.append(":");
        sb.append(this.dtime);
        sb.append(":");
        String connectedParams = getConnectedParams();
        if (!Util.empty(connectedParams)) {
            sb.append(Util.replaceEncode(connectedParams, ":"));
        }
        return sb.toString();
    }
}
