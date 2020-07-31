package kotlin.text;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.af;
import kotlin.jvm.internal.Lambda;
@kotlin.h
/* loaded from: classes7.dex */
final class CharCategory$Companion$categoryMap$2 extends Lambda implements kotlin.jvm.a.a<Map<Integer, ? extends CharCategory>> {
    public static final CharCategory$Companion$categoryMap$2 INSTANCE = new CharCategory$Companion$categoryMap$2();

    CharCategory$Companion$categoryMap$2() {
        super(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'java.util.Map<java.lang.Integer, kotlin.text.CharCategory>' to match base method */
    @Override // kotlin.jvm.a.a
    public final Map<Integer, ? extends CharCategory> invoke() {
        CharCategory[] values = CharCategory.values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.b.l.ea(af.Ls(values.length), 16));
        for (CharCategory charCategory : values) {
            linkedHashMap.put(Integer.valueOf(charCategory.getValue()), charCategory);
        }
        return linkedHashMap;
    }
}
