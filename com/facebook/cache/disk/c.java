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

        com.facebook.a.a bb(Object obj) throws IOException;

        boolean esl();
    }

    b D(String str, Object obj) throws IOException;

    com.facebook.a.a E(String str, Object obj) throws IOException;

    boolean F(String str, Object obj) throws IOException;

    long Zv(String str) throws IOException;

    long a(a aVar) throws IOException;

    void esh();

    Collection<a> esi() throws IOException;

    boolean isExternal();
}
