package kotlin.collections;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.Map;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes2.dex */
final class AbstractMap$toString$1 extends Lambda implements kotlin.jvm.a.b<Map.Entry<? extends K, ? extends V>, String> {
    final /* synthetic */ e this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractMap$toString$1(e eVar) {
        super(1);
        this.this$0 = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.a.b
    public final String invoke(Map.Entry<? extends K, ? extends V> entry) {
        String b;
        kotlin.jvm.internal.p.i(entry, AdvanceSetting.NETWORK_TYPE);
        b = this.this$0.b(entry);
        return b;
    }
}
