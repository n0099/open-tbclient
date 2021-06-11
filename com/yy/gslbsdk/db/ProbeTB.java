package com.yy.gslbsdk.db;

import java.io.Serializable;
/* loaded from: classes7.dex */
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

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ProbeTB)) {
            return false;
        }
        ProbeTB probeTB = (ProbeTB) obj;
        return probeTB.host.equals(this.host) && probeTB.protocol == this.protocol && probeTB.method == this.method && probeTB.url.equals(this.url);
    }

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

    public void setHost(String str) {
        this.host = str;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public void setMethod(int i2) {
        this.method = i2;
    }

    public void setProtocol(int i2) {
        this.protocol = i2;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
