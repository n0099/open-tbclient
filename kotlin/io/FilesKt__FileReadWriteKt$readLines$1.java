package kotlin.io;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.ArrayList;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
import kotlin.l;
@kotlin.h
/* loaded from: classes7.dex */
final class FilesKt__FileReadWriteKt$readLines$1 extends Lambda implements kotlin.jvm.a.b<String, l> {
    final /* synthetic */ ArrayList $result;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FilesKt__FileReadWriteKt$readLines$1(ArrayList arrayList) {
        super(1);
        this.$result = arrayList;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.a.b
    public /* bridge */ /* synthetic */ l invoke(String str) {
        invoke2(str);
        return l.nto;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        q.m(str, AdvanceSetting.NETWORK_TYPE);
        this.$result.add(str);
    }
}
