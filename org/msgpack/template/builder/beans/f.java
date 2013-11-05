package org.msgpack.template.builder.beans;

import java.util.Comparator;
/* loaded from: classes.dex */
class f implements Comparator<PropertyDescriptor> {
    private f() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(f fVar) {
        this();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(PropertyDescriptor propertyDescriptor, PropertyDescriptor propertyDescriptor2) {
        return propertyDescriptor.b().compareTo(propertyDescriptor2.b());
    }
}
