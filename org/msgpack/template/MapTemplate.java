package org.msgpack.template;

import java.util.Map;
import org.msgpack.MessageTypeException;
/* loaded from: classes.dex */
public class MapTemplate<K, V> extends AbstractTemplate<Map<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    private d<K> f3087a;
    private d<V> b;

    @Override // org.msgpack.template.d
    public /* bridge */ /* synthetic */ void a(org.msgpack.packer.a aVar, Object obj, boolean z) {
        a(aVar, (Map) ((Map) obj), z);
    }

    public MapTemplate(d<K> dVar, d<V> dVar2) {
        this.f3087a = dVar;
        this.b = dVar2;
    }

    public void a(org.msgpack.packer.a aVar, Map<K, V> map, boolean z) {
        if (!(map instanceof Map)) {
            if (map == null) {
                if (z) {
                    throw new MessageTypeException("Attempted to write null");
                }
                aVar.d();
                return;
            }
            throw new MessageTypeException("Target is not a Map but " + map.getClass());
        }
        aVar.d(map.size());
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.f3087a.a(aVar, entry.getKey());
            this.b.a(aVar, entry.getValue());
        }
        aVar.b();
    }
}
