package com.facebook.cache.disk;

import java.io.IOException;
import java.util.Collection;
/* loaded from: classes2.dex */
public interface c {

    /* loaded from: classes2.dex */
    public interface a {
        String getId();

        long getSize();

        long getTimestamp();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(com.facebook.cache.common.h hVar, Object obj) throws IOException;

        com.facebook.a.a aA(Object obj) throws IOException;

        boolean cEv();
    }

    long a(a aVar) throws IOException;

    void cEr();

    Collection<a> cEs() throws IOException;

    boolean isExternal();

    b q(String str, Object obj) throws IOException;

    com.facebook.a.a r(String str, Object obj) throws IOException;

    boolean s(String str, Object obj) throws IOException;
}
