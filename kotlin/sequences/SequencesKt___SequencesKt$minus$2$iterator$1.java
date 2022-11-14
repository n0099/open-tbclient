package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, AdvanceSetting.NETWORK_TYPE, "invoke", "(Ljava/lang/Object;)Z"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes8.dex */
public final class SequencesKt___SequencesKt$minus$2$iterator$1 extends Lambda implements Function1<T, Boolean> {
    public final /* synthetic */ HashSet $other;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$minus$2$iterator$1(HashSet hashSet) {
        super(1);
        this.$other = hashSet;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
        return Boolean.valueOf(invoke2((SequencesKt___SequencesKt$minus$2$iterator$1) obj));
    }

    /* JADX DEBUG: Return type fixed from 'boolean' to match base method */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean, java.lang.Boolean] */
    @Override // kotlin.jvm.functions.Function1
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Boolean invoke2(T t) {
        return this.$other.contains(t);
    }
}
