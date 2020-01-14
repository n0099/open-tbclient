package com.facebook.cache.disk;

import java.io.IOException;
import java.util.Collection;
/* loaded from: classes12.dex */
public interface c {

    /* loaded from: classes12.dex */
    public interface a {
        String getId();

        long getSize();

        long getTimestamp();
    }

    /* loaded from: classes12.dex */
    public interface b {
        void a(com.facebook.cache.common.h hVar, Object obj) throws IOException;

        com.facebook.a.a aO(Object obj) throws IOException;

        boolean diN();
    }

    long Oy(String str) throws IOException;

    long a(a aVar) throws IOException;

    void diJ();

    Collection<a> diK() throws IOException;

    boolean isExternal();

    b u(String str, Object obj) throws IOException;

    com.facebook.a.a v(String str, Object obj) throws IOException;

    boolean w(String str, Object obj) throws IOException;
}
