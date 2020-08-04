package com.facebook.cache.disk;

import java.io.IOException;
import java.util.Collection;
/* loaded from: classes3.dex */
public interface c {

    /* loaded from: classes3.dex */
    public interface a {
        String getId();

        long getSize();

        long getTimestamp();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(com.facebook.cache.common.h hVar, Object obj) throws IOException;

        com.facebook.a.a aM(Object obj) throws IOException;

        boolean dBS();
    }

    b C(String str, Object obj) throws IOException;

    com.facebook.a.a D(String str, Object obj) throws IOException;

    boolean E(String str, Object obj) throws IOException;

    long Ri(String str) throws IOException;

    long a(a aVar) throws IOException;

    void dBO();

    Collection<a> dBP() throws IOException;

    boolean isExternal();
}
