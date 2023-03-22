package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.baidu.android.common.others.IStringUtil;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
/* loaded from: classes9.dex */
public final class SignatureBuildingComponents {
    public static final SignatureBuildingComponents INSTANCE = new SignatureBuildingComponents();

    public final LinkedHashSet<String> inClass(String str, String... strArr) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        for (String str2 : strArr) {
            linkedHashSet.add(str + IStringUtil.EXTENSION_SEPARATOR + str2);
        }
        return linkedHashSet;
    }

    public final LinkedHashSet<String> inJavaLang(String str, String... strArr) {
        return inClass(javaLang(str), (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final LinkedHashSet<String> inJavaUtil(String str, String... strArr) {
        return inClass(javaUtil(str), (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final String signature(String str, String str2) {
        return str + IStringUtil.EXTENSION_SEPARATOR + str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String escapeClassName(String str) {
        if (str.length() > 1) {
            return 'L' + str + WebvttCueParser.CHAR_SEMI_COLON;
        }
        return str;
    }

    public final String javaFunction(String str) {
        return "java/util/function/" + str;
    }

    public final String javaLang(String str) {
        return "java/lang/" + str;
    }

    public final String javaUtil(String str) {
        return "java/util/" + str;
    }

    public final String[] constructors(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add("<init>(" + str + ")V");
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final String jvmDescriptor(String str, List<String> list, String str2) {
        return str + '(' + CollectionsKt___CollectionsKt.joinToString$default(list, "", null, null, 0, null, new Function1<String, String>() { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents$jvmDescriptor$1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String str3) {
                String escapeClassName;
                escapeClassName = SignatureBuildingComponents.INSTANCE.escapeClassName(str3);
                return escapeClassName;
            }
        }, 30, null) + ')' + escapeClassName(str2);
    }

    public final String signature(ClassDescriptor classDescriptor, String str) {
        return signature(MethodSignatureMappingKt.getInternalName(classDescriptor), str);
    }
}
