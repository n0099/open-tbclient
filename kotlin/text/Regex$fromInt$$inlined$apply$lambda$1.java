package kotlin.text;

import kotlin.jvm.internal.Lambda;
/* loaded from: classes4.dex */
public final class Regex$fromInt$$inlined$apply$lambda$1 extends Lambda implements kotlin.jvm.a.b<T, Boolean> {
    final /* synthetic */ int $value$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Regex$fromInt$$inlined$apply$lambda$1(int i) {
        super(1);
        this.$value$inlined = i;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.a.b
    public /* synthetic */ Boolean invoke(Object obj) {
        return Boolean.valueOf(invoke((Enum) obj));
    }

    /* JADX WARN: Incorrect types in method signature: (TT;)Z */
    public final boolean invoke(Enum r3) {
        return (((e) r3).getMask() & this.$value$inlined) == ((e) r3).getValue();
    }
}
