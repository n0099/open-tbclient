package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, AdvanceSetting.NETWORK_TYPE, "invoke", "(Ljava/lang/Object;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes8.dex */
public final class AbstractCollection$toString$1 extends Lambda implements Function1<E, CharSequence> {
    public final /* synthetic */ AbstractCollection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractCollection$toString$1(AbstractCollection abstractCollection) {
        super(1);
        this.this$0 = abstractCollection;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    public final CharSequence invoke(E e) {
        if (e == this.this$0) {
            return "(this Collection)";
        }
        return String.valueOf(e);
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(Object obj) {
        return invoke((AbstractCollection$toString$1) obj);
    }
}
