package com.facebook.cache.disk;

import java.io.IOException;
import java.util.Collection;
/* loaded from: classes5.dex */
public interface c {

    /* loaded from: classes5.dex */
    public interface a {
        String getId();

        long getSize();

        long getTimestamp();
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(com.facebook.cache.common.h hVar, Object obj) throws IOException;

        com.facebook.a.a aZ(Object obj) throws IOException;

        boolean etv();
    }

    b F(String str, Object obj) throws IOException;

    com.facebook.a.a G(String str, Object obj) throws IOException;

    boolean H(String str, Object obj) throws IOException;

    long Zj(String str) throws IOException;

    long a(a aVar) throws IOException;

    void etr();

    Collection<a> ets() throws IOException;

    boolean isExternal();
}
