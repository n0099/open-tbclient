package com.facebook.cache.disk;

import java.io.IOException;
import java.util.Collection;
/* loaded from: classes17.dex */
public interface c {

    /* loaded from: classes17.dex */
    public interface a {
        String getId();

        long getSize();

        long getTimestamp();
    }

    /* loaded from: classes17.dex */
    public interface b {
        void a(com.facebook.cache.common.h hVar, Object obj) throws IOException;

        com.facebook.a.a aY(Object obj) throws IOException;

        boolean ejv();
    }

    b C(String str, Object obj) throws IOException;

    com.facebook.a.a D(String str, Object obj) throws IOException;

    boolean E(String str, Object obj) throws IOException;

    long XE(String str) throws IOException;

    long a(a aVar) throws IOException;

    void ejr();

    Collection<a> ejs() throws IOException;

    boolean isExternal();
}
