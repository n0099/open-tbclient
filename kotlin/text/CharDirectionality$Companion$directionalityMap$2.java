package kotlin.text;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.aa;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes2.dex */
final class CharDirectionality$Companion$directionalityMap$2 extends Lambda implements kotlin.jvm.a.a<Map<Integer, ? extends CharDirectionality>> {
    public static final CharDirectionality$Companion$directionalityMap$2 INSTANCE = new CharDirectionality$Companion$directionalityMap$2();

    CharDirectionality$Companion$directionalityMap$2() {
        super(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'java.util.Map<java.lang.Integer, kotlin.text.CharDirectionality>' to match base method */
    @Override // kotlin.jvm.a.a
    public final Map<Integer, ? extends CharDirectionality> invoke() {
        CharDirectionality[] values = CharDirectionality.values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.b.d.cM(aa.De(values.length), 16));
        for (CharDirectionality charDirectionality : values) {
            linkedHashMap.put(Integer.valueOf(charDirectionality.getValue()), charDirectionality);
        }
        return linkedHashMap;
    }
}
