package kotlin.jvm.internal;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.reflect.KType;
@SinceKotlin(version = "1.4")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u00012\u00020\u0002R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lkotlin/jvm/internal/KTypeBase;", "Lkotlin/reflect/KType;", "Lkotlin/Any;", "Ljava/lang/reflect/Type;", "getJavaType", "()Ljava/lang/reflect/Type;", "javaType", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public interface KTypeBase extends KType {
    Type getJavaType();
}
