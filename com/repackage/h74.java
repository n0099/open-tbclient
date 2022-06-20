package com.repackage;

import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.Map;
/* loaded from: classes6.dex */
public interface h74<T> extends j74 {
    void a(T t);

    void c(T t);

    String d(T t);

    void e(T t, k84 k84Var);

    void f(T t);

    k84 h(T t, File file, long j, ReadableByteChannel readableByteChannel) throws IOException;

    void i(T t);

    void j(T t);

    Map<String, Object> k();
}
