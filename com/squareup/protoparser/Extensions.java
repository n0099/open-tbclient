package com.squareup.protoparser;
/* loaded from: classes.dex */
public final class Extensions {
    private final String documentation;
    private final int end;
    private final int start;

    public Extensions(String str, int i, int i2) {
        this.documentation = str;
        this.start = i;
        this.end = i2;
    }

    public String getDocumentation() {
        return this.documentation;
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }
}
