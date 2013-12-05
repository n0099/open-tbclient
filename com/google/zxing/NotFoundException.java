package com.google.zxing;
/* loaded from: classes.dex */
public final class NotFoundException extends ReaderException {

    /* renamed from: a  reason: collision with root package name */
    private static final NotFoundException f2834a = new NotFoundException();

    private NotFoundException() {
    }

    public static NotFoundException getNotFoundInstance() {
        return f2834a;
    }
}
