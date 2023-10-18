package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes10.dex */
public final class RawTypeImpl$render$1 extends Lambda implements Function2<String, String, Boolean> {
    public static final RawTypeImpl$render$1 INSTANCE = new RawTypeImpl$render$1();

    public RawTypeImpl$render$1() {
        super(2);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(String str, String str2) {
        return Boolean.valueOf(invoke2(str, str2));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(String str, String str2) {
        if (!Intrinsics.areEqual(str, StringsKt__StringsKt.removePrefix(str2, (CharSequence) "out ")) && !Intrinsics.areEqual(str2, "*")) {
            return false;
        }
        return true;
    }
}
