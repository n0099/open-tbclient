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

        boolean erU();
    }

    b E(String str, Object obj) throws IOException;

    com.facebook.a.a F(String str, Object obj) throws IOException;

    boolean G(String str, Object obj) throws IOException;

    long Zd(String str) throws IOException;

    long a(a aVar) throws IOException;

    void erQ();

    Collection<a> erR() throws IOException;

    boolean isExternal();
}
