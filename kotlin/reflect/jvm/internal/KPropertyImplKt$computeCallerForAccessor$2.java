package kotlin.reflect.jvm.internal;

import com.baidu.searchbox.net.listener.DiaoqiJsonListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"isNotNullProperty", "", DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class KPropertyImplKt$computeCallerForAccessor$2 extends Lambda implements Function0<Boolean> {
    public final /* synthetic */ KPropertyImpl.Accessor $this_computeCallerForAccessor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KPropertyImplKt$computeCallerForAccessor$2(KPropertyImpl.Accessor accessor) {
        super(0);
        this.$this_computeCallerForAccessor = accessor;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        return !TypeUtils.isNullableType(this.$this_computeCallerForAccessor.getProperty().getDescriptor().getType());
    }
}
