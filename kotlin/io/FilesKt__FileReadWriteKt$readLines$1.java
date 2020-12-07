package kotlin.io;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.ArrayList;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes17.dex */
final class FilesKt__FileReadWriteKt$readLines$1 extends Lambda implements kotlin.jvm.a.b<String, kotlin.h> {
    final /* synthetic */ ArrayList $result;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FilesKt__FileReadWriteKt$readLines$1(ArrayList arrayList) {
        super(1);
        this.$result = arrayList;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.a.b
    public /* bridge */ /* synthetic */ kotlin.h invoke(String str) {
        invoke2(str);
        return kotlin.h.pJY;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        p.o(str, AdvanceSetting.NETWORK_TYPE);
        this.$result.add(str);
    }
}
