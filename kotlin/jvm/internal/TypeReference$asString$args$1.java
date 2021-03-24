package kotlin.jvm.internal;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KTypeProjection;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, "Lkotlin/reflect/KTypeProjection;", "invoke"}, k = 3, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class TypeReference$asString$args$1 extends Lambda implements Function1<KTypeProjection, String> {
    public final /* synthetic */ TypeReference this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TypeReference$asString$args$1(TypeReference typeReference) {
        super(1);
        this.this$0 = typeReference;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function1
    public final String invoke(KTypeProjection kTypeProjection) {
        String asString;
        asString = this.this$0.asString(kTypeProjection);
        return asString;
    }
}
