package com.repackage;

import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.Map;
/* loaded from: classes7.dex */
public interface x74<T> extends z74 {
    void a(T t);

    void c(T t);

    String d(T t);

    void e(T t, a94 a94Var);

    void f(T t);

    a94 h(T t, File file, long j, ReadableByteChannel readableByteChannel) throws IOException;

    void i(T t);

    void j(T t);

    Map<String, Object> k();
}
