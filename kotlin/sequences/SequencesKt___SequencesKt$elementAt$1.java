package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.common.others.IStringUtil;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, AdvanceSetting.NETWORK_TYPE, "", "invoke", "(I)Ljava/lang/Object;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes9.dex */
public final class SequencesKt___SequencesKt$elementAt$1 extends Lambda implements Function1<Integer, T> {
    public final /* synthetic */ int $index;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$elementAt$1(int i) {
        super(1);
        this.$index = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final T invoke(int i) {
        throw new IndexOutOfBoundsException("Sequence doesn't contain element at index " + this.$index + IStringUtil.EXTENSION_SEPARATOR);
    }
}
