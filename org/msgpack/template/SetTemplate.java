package org.msgpack.template;

import java.util.Set;
import org.msgpack.MessageTypeException;
/* loaded from: classes.dex */
public class SetTemplate<E> extends AbstractTemplate<Set<E>> {

    /* renamed from: a  reason: collision with root package name */
    private d<E> f2911a;

    @Override // org.msgpack.template.d
    public /* bridge */ /* synthetic */ void a(org.msgpack.packer.a aVar, Object obj, boolean z) {
        a(aVar, (Set) ((Set) obj), z);
    }

    public SetTemplate(d<E> dVar) {
        this.f2911a = dVar;
    }

    public void a(org.msgpack.packer.a aVar, Set<E> set, boolean z) {
        if (!(set instanceof Set)) {
            if (set == null) {
                if (z) {
                    throw new MessageTypeException("Attempted to write null");
                }
                aVar.d();
                return;
            }
            throw new MessageTypeException("Target is not a List but " + set.getClass());
        }
        aVar.c(set.size());
        for (E e : set) {
            this.f2911a.a(aVar, e);
        }
        aVar.a();
    }
}
