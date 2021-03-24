package com.facebook.binaryresource;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public interface BinaryResource {
    InputStream openStream() throws IOException;

    byte[] read() throws IOException;

    long size();
}
