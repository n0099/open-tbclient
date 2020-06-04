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

        com.facebook.a.a aL(Object obj) throws IOException;

        boolean dtY();
    }

    b C(String str, Object obj) throws IOException;

    com.facebook.a.a D(String str, Object obj) throws IOException;

    boolean E(String str, Object obj) throws IOException;

    long PK(String str) throws IOException;

    long a(a aVar) throws IOException;

    void dtU();

    Collection<a> dtV() throws IOException;

    boolean isExternal();
}
