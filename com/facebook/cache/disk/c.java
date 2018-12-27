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

        com.facebook.a.a am(Object obj) throws IOException;

        boolean bTp();
    }

    long a(a aVar) throws IOException;

    void bTl();

    Collection<a> bTm() throws IOException;

    boolean isExternal();

    b k(String str, Object obj) throws IOException;

    com.facebook.a.a l(String str, Object obj) throws IOException;

    boolean m(String str, Object obj) throws IOException;
}
