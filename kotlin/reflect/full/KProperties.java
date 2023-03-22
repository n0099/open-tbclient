package kotlin.reflect.full;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;
import kotlin.reflect.jvm.internal.KPropertyImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a1\u0010\u0002\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0004*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlin/reflect/KProperty1;", "", "getExtensionDelegate", "(Lkotlin/reflect/KProperty1;)Ljava/lang/Object;", "D", "Lkotlin/reflect/KProperty2;", SocialConstants.PARAM_RECEIVER, "(Lkotlin/reflect/KProperty2;Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@JvmName(name = "KProperties")
/* loaded from: classes9.dex */
public final class KProperties {
    @SinceKotlin(version = "1.1")
    public static final Object getExtensionDelegate(KProperty1<?, ?> kProperty1) {
        return kProperty1.getDelegate(KPropertyImpl.Companion.getEXTENSION_PROPERTY_DELEGATE());
    }

    @SinceKotlin(version = "1.1")
    public static final <D> Object getExtensionDelegate(KProperty2<D, ?, ?> kProperty2, D d) {
        return kProperty2.getDelegate(d, KPropertyImpl.Companion.getEXTENSION_PROPERTY_DELEGATE());
    }
}
