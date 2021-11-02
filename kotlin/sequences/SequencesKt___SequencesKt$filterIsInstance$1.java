package kotlin.sequences;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "R", AdvanceSetting.NETWORK_TYPE, "", "invoke"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class SequencesKt___SequencesKt$filterIsInstance$1 extends Lambda implements Function1<Object, Boolean> {
    public static final SequencesKt___SequencesKt$filterIsInstance$1 INSTANCE = new SequencesKt___SequencesKt$filterIsInstance$1();

    public SequencesKt___SequencesKt$filterIsInstance$1() {
        super(1);
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
        return Boolean.valueOf(invoke2(obj));
    }

    /* JADX DEBUG: Return type fixed from 'boolean' to match base method */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean, java.lang.Boolean] */
    @Override // kotlin.jvm.functions.Function1
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Boolean invoke2(Object obj) {
        Intrinsics.reifiedOperationMarker(3, "R");
        return obj instanceof Object;
    }
}
