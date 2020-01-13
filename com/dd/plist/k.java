package com.dd.plist;

import java.io.UnsupportedEncodingException;
/* loaded from: classes5.dex */
public class k extends i implements Comparable<Object> {
    private String content;

    public k(byte[] bArr, String str) throws UnsupportedEncodingException {
        this.content = new String(bArr, str);
    }

    public k(String str) {
        this.content = str;
    }

    public String getContent() {
        return this.content;
    }

    public boolean equals(Object obj) {
        if (obj instanceof k) {
            return this.content.equals(((k) obj).content);
        }
        return false;
    }

    public int hashCode() {
        return this.content.hashCode();
    }

    public String toString() {
        return this.content;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj instanceof k) {
            return getContent().compareTo(((k) obj).getContent());
        }
        if (obj instanceof String) {
            return getContent().compareTo((String) obj);
        }
        return -1;
    }
}
