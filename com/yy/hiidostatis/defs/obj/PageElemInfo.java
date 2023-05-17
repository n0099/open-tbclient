package com.yy.hiidostatis.defs.obj;

import com.yy.hiidostatis.inner.util.Util;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class PageElemInfo extends ParamableElem implements Elem {
    public static final long serialVersionUID = -5734456734934257499L;
    public long dtime;
    public long ltime;
    public String npage;
    public String page;
    public long stime;

    public PageElemInfo() {
    }

    public PageElemInfo copy() {
        PageElemInfo pageElemInfo = new PageElemInfo();
        pageElemInfo.dtime = this.dtime;
        pageElemInfo.ltime = this.ltime;
        pageElemInfo.stime = this.stime;
        pageElemInfo.page = this.page;
        pageElemInfo.npage = this.npage;
        pageElemInfo.addParams(new ArrayList(getParams()));
        return pageElemInfo;
    }

    public long getDelayedTime() {
        return this.dtime;
    }

    public String getDestinationPage() {
        return this.npage;
    }

    public long getLingerTime() {
        return this.ltime;
    }

    public String getPage() {
        return this.page;
    }

    public long getStime() {
        return this.stime;
    }

    public boolean isValid() {
        if (!Util.empty(this.page) && !Util.empty(this.npage)) {
            return true;
        }
        return false;
    }

    public PageElemInfo(String str, String str2, long j, long j2, long j3) {
        this.page = str;
        this.npage = str2;
        this.ltime = j;
        this.dtime = j2;
        this.stime = j3;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.page = (String) objectInputStream.readObject();
        this.npage = (String) objectInputStream.readObject();
        this.ltime = objectInputStream.readLong();
        this.dtime = objectInputStream.readLong();
        this.stime = objectInputStream.readLong();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.page);
        objectOutputStream.writeObject(this.npage);
        objectOutputStream.writeLong(this.ltime);
        objectOutputStream.writeLong(this.dtime);
        objectOutputStream.writeLong(this.stime);
    }

    public void setDestinationPage(String str) {
        this.npage = str;
    }

    public void setDtime(long j) {
        this.dtime = j;
    }

    public void setLtime(long j) {
        this.ltime = j;
    }

    public void setPage(String str) {
        this.page = str;
    }

    public void setStime(long j) {
        this.stime = j;
    }

    @Override // com.yy.hiidostatis.defs.obj.Elem
    public String getStringRep() {
        StringBuilder sb = new StringBuilder();
        sb.append(Util.replaceEncode(this.page, ":"));
        sb.append(":");
        sb.append(Util.replaceEncode(this.npage, ":"));
        sb.append(":");
        sb.append(this.stime);
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

    public String toString() {
        return " page=" + this.page + ", dest page=" + this.npage + ", stime=" + this.stime + ", lingertime=" + this.ltime + ", dtime=" + this.dtime;
    }
}
