package org.msgpack.template.builder;

import java.lang.reflect.Type;
/* loaded from: classes.dex */
public interface f {
    <T> org.msgpack.template.d<T> a(Class<T> cls, org.msgpack.template.a aVar);

    <T> org.msgpack.template.d<T> a(Type type);

    <T> org.msgpack.template.d<T> b(Type type);

    boolean b(Type type, boolean z);
}
