package org.msgpack.template;

import java.util.Collection;
import org.msgpack.MessageTypeException;
/* loaded from: classes.dex */
public class CollectionTemplate<E> extends AbstractTemplate<Collection<E>> {

    /* renamed from: a  reason: collision with root package name */
    private d<E> f2908a;

    @Override // org.msgpack.template.d
    public /* bridge */ /* synthetic */ void a(org.msgpack.packer.a aVar, Object obj, boolean z) {
        a(aVar, (Collection) ((Collection) obj), z);
    }

    public CollectionTemplate(d<E> dVar) {
        this.f2908a = dVar;
    }

    public void a(org.msgpack.packer.a aVar, Collection<E> collection, boolean z) {
        if (collection == null) {
            if (z) {
                throw new MessageTypeException("Attempted to write null");
            }
            aVar.d();
            return;
        }
        aVar.c(collection.size());
        for (E e : collection) {
            this.f2908a.a(aVar, e);
        }
        aVar.a();
    }
}
