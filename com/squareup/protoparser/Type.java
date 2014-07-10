package com.squareup.protoparser;

import java.util.List;
/* loaded from: classes.dex */
public interface Type {
    String getFullyQualifiedName();

    String getName();

    List<Type> getNestedTypes();
}
