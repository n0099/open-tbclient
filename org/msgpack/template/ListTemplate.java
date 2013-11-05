package org.msgpack.template;

import java.util.List;
import org.msgpack.MessageTypeException;
/* loaded from: classes.dex */
public class ListTemplate<E> extends AbstractTemplate<List<E>> {

    /* renamed from: a  reason: collision with root package name */
    private d<E> f2871a;

    @Override // org.msgpack.template.d
    public /* bridge */ /* synthetic */ void a(org.msgpack.packer.a aVar, Object obj, boolean z) {
        a(aVar, (List) ((List) obj), z);
    }

    public ListTemplate(d<E> dVar) {
        this.f2871a = dVar;
    }

    public void a(org.msgpack.packer.a aVar, List<E> list, boolean z) {
        if (!(list instanceof List)) {
            if (list == null) {
                if (z) {
                    throw new MessageTypeException("Attempted to write null");
                }
                aVar.d();
                return;
            }
            throw new MessageTypeException("Target is not a List but " + list.getClass());
        }
        aVar.c(list.size());
        for (E e : list) {
            this.f2871a.a(aVar, e);
        }
        aVar.a();
    }
}
