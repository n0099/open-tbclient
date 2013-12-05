package com.google.zxing;
/* loaded from: classes.dex */
public final class ChecksumException extends ReaderException {

    /* renamed from: a  reason: collision with root package name */
    private static final ChecksumException f2830a = new ChecksumException();

    private ChecksumException() {
    }

    public static ChecksumException getChecksumInstance() {
        return f2830a;
    }
}
