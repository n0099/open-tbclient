package com.yy.gslbsdk.db;

import java.io.Serializable;
/* loaded from: classes10.dex */
public class ProbeTB implements Serializable {
    public static final String HOST = "host";
    public static final String ID = "_id";
    public static final String METHOD = "method";
    public static final String PROTOCOL = "protocol";
    public static final String URL = "url";
    public static final long serialVersionUID = 6056101090291377949L;
    public int id = -1;
    public String host = null;
    public int protocol = -1;
    public int method = -1;
    public String url = null;

    public String getHost() {
        return this.host;
    }

    public int getId() {
        return this.id;
    }

    public int getMethod() {
        return this.method;
    }

    public int getProtocol() {
        return this.protocol;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ProbeTB)) {
            return false;
        }
        ProbeTB probeTB = (ProbeTB) obj;
        if (!probeTB.host.equals(this.host) || probeTB.protocol != this.protocol || probeTB.method != this.method || !probeTB.url.equals(this.url)) {
            return false;
        }
        return true;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setMethod(int i) {
        this.method = i;
    }

    public void setProtocol(int i) {
        this.protocol = i;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
