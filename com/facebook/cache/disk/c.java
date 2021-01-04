package com.facebook.cache.disk;

import java.io.IOException;
import java.util.Collection;
/* loaded from: classes6.dex */
public interface c {

    /* loaded from: classes6.dex */
    public interface a {
        String getId();

        long getSize();

        long getTimestamp();
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(com.facebook.cache.common.h hVar, Object obj) throws IOException;

        com.facebook.a.a aZ(Object obj) throws IOException;

        boolean etr();
    }

    b F(String str, Object obj) throws IOException;

    com.facebook.a.a G(String str, Object obj) throws IOException;

    boolean H(String str, Object obj) throws IOException;

    long Zk(String str) throws IOException;

    long a(a aVar) throws IOException;

    void etn();

    Collection<a> eto() throws IOException;

    boolean isExternal();
}
