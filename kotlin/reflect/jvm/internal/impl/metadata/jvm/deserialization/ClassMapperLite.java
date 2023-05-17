package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.common.others.IStringUtil;
import com.google.android.exoplayer2.source.dash.manifest.UrlTemplate;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes10.dex */
public final class ClassMapperLite {
    public static final ClassMapperLite INSTANCE = new ClassMapperLite();
    public static final Map<String, String> map;

    static {
        int i;
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        List listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"Boolean", "Z", "Char", "C", "Byte", "B", "Short", ExifInterface.LATITUDE_SOUTH, "Int", "I", "Float", "F", "Long", "J", "Double", "D"});
        IntProgression step = RangesKt___RangesKt.step(CollectionsKt__CollectionsKt.getIndices(listOf), 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if (step2 < 0 ? first >= last : first <= last) {
            while (true) {
                linkedHashMap.put("kotlin/" + ((String) listOf.get(first)), listOf.get(first + 1));
                linkedHashMap.put("kotlin/" + ((String) listOf.get(first)) + "Array", '[' + ((String) listOf.get(i)));
                if (first == last) {
                    break;
                }
                first += step2;
            }
        }
        linkedHashMap.put("kotlin/Unit", ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        Function2<String, String, Unit> function2 = new Function2<String, String, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.ClassMapperLite$map$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, String str2) {
                invoke2(str, str2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str, String str2) {
                linkedHashMap.put("kotlin/" + str, 'L' + str2 + WebvttCueParser.CHAR_SEMI_COLON);
            }
        };
        function2.invoke2("Any", "java/lang/Object");
        function2.invoke2("Nothing", "java/lang/Void");
        function2.invoke2("Annotation", "java/lang/annotation/Annotation");
        for (String str : CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"String", "CharSequence", "Throwable", "Cloneable", UrlTemplate.NUMBER, "Comparable", "Enum"})) {
            function2.invoke2(str, "java/lang/" + str);
        }
        for (String str2 : CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"Iterator", "Collection", "List", "Set", "Map", "ListIterator"})) {
            function2.invoke2("collections/" + str2, "java/util/" + str2);
            function2.invoke2("collections/Mutable" + str2, "java/util/" + str2);
        }
        function2.invoke2("collections/Iterable", "java/lang/Iterable");
        function2.invoke2("collections/MutableIterable", "java/lang/Iterable");
        function2.invoke2("collections/Map.Entry", "java/util/Map$Entry");
        function2.invoke2("collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        for (int i2 = 0; i2 <= 22; i2++) {
            function2.invoke2("Function" + i2, "kotlin/jvm/functions/Function" + i2);
            function2.invoke2("reflect/KFunction" + i2, "kotlin/reflect/KFunction");
        }
        for (String str3 : CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum"})) {
            function2.invoke2(str3 + ".Companion", "kotlin/jvm/internal/" + str3 + "CompanionObject");
        }
        map = linkedHashMap;
    }

    @JvmStatic
    public static final String mapClass(String str) {
        String str2 = map.get(str);
        if (str2 == null) {
            return 'L' + StringsKt__StringsJVMKt.replace$default(str, (char) IStringUtil.EXTENSION_SEPARATOR, '$', false, 4, (Object) null) + WebvttCueParser.CHAR_SEMI_COLON;
        }
        return str2;
    }
}
