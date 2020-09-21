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

        com.facebook.a.a aQ(Object obj) throws IOException;

        boolean dRZ();
    }

    b B(String str, Object obj) throws IOException;

    com.facebook.a.a C(String str, Object obj) throws IOException;

    boolean D(String str, Object obj) throws IOException;

    long UO(String str) throws IOException;

    long a(a aVar) throws IOException;

    void dRV();

    Collection<a> dRW() throws IOException;

    boolean isExternal();
}
