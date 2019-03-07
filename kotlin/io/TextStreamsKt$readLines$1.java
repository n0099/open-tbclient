package kotlin.io;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.ArrayList;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
final class TextStreamsKt$readLines$1 extends Lambda implements kotlin.jvm.a.b<String, kotlin.e> {
    final /* synthetic */ ArrayList $result;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextStreamsKt$readLines$1(ArrayList arrayList) {
        super(1);
        this.$result = arrayList;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.a.b
    public /* bridge */ /* synthetic */ kotlin.e invoke(String str) {
        invoke2(str);
        return kotlin.e.jRO;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        p.k(str, AdvanceSetting.NETWORK_TYPE);
        this.$result.add(str);
    }
}
