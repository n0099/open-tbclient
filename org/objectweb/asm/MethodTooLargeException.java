package org.objectweb.asm;
/* loaded from: classes9.dex */
public final class MethodTooLargeException extends IndexOutOfBoundsException {
    public static final long serialVersionUID = 6807380416709738314L;
    public final String className;
    public final int codeSize;
    public final String descriptor;
    public final String methodName;

    public MethodTooLargeException(String str, String str2, String str3, int i) {
        super("Method too large: " + str + "." + str2 + " " + str3);
        this.className = str;
        this.methodName = str2;
        this.descriptor = str3;
        this.codeSize = i;
    }

    public String getClassName() {
        return this.className;
    }

    public int getCodeSize() {
        return this.codeSize;
    }

    public String getDescriptor() {
        return this.descriptor;
    }

    public String getMethodName() {
        return this.methodName;
    }
}
