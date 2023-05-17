package org.aspectj.lang.reflect;
/* loaded from: classes10.dex */
public class NoSuchPointcutException extends Exception {
    public static final long serialVersionUID = 3256444698657634352L;
    public String name;

    public NoSuchPointcutException(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
