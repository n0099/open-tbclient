package com.facebook.cache.disk;

import java.io.IOException;
import java.util.Collection;
/* loaded from: classes8.dex */
public interface c {

    /* loaded from: classes8.dex */
    public interface a {
        String getId();

        long getSize();

        long getTimestamp();
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(com.facebook.cache.common.h hVar, Object obj) throws IOException;

        com.facebook.a.a aO(Object obj) throws IOException;

        boolean dNS();
    }

    b B(String str, Object obj) throws IOException;

    com.facebook.a.a C(String str, Object obj) throws IOException;

    boolean D(String str, Object obj) throws IOException;

    long Um(String str) throws IOException;

    long a(a aVar) throws IOException;

    void dNO();

    Collection<a> dNP() throws IOException;

    boolean isExternal();
}
