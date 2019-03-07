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

        com.facebook.a.a aB(Object obj) throws IOException;

        boolean csV();
    }

    long a(a aVar) throws IOException;

    void csR();

    Collection<a> csS() throws IOException;

    boolean isExternal();

    b n(String str, Object obj) throws IOException;

    com.facebook.a.a o(String str, Object obj) throws IOException;

    boolean p(String str, Object obj) throws IOException;
}
