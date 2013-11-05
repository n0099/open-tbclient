package org.msgpack.io;

import java.io.EOFException;
/* loaded from: classes.dex */
public class EndOfBufferException extends EOFException {
    public EndOfBufferException() {
    }

    public EndOfBufferException(String str) {
        super(str);
    }
}
