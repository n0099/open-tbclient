package com.facebook.cache.disk;

import java.io.IOException;
import java.util.Collection;
/* loaded from: classes13.dex */
public interface c {

    /* loaded from: classes13.dex */
    public interface a {
        String getId();

        long getSize();

        long getTimestamp();
    }

    /* loaded from: classes13.dex */
    public interface b {
        void a(com.facebook.cache.common.h hVar, Object obj) throws IOException;

        com.facebook.a.a aH(Object obj) throws IOException;

        boolean dmq();
    }

    com.facebook.a.a A(String str, Object obj) throws IOException;

    boolean B(String str, Object obj) throws IOException;

    long NV(String str) throws IOException;

    long a(a aVar) throws IOException;

    void dmm();

    Collection<a> dmn() throws IOException;

    boolean isExternal();

    b z(String str, Object obj) throws IOException;
}
