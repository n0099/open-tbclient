package kotlin.contracts;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.ContractsDsl;
@SinceKotlin(version = "1.3")
@ContractsDsl
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H§\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlin/contracts/SimpleEffect;", "Lkotlin/contracts/Effect;", "Lkotlin/Any;", "", "booleanExpression", "Lkotlin/contracts/ConditionalEffect;", "implies", "(Z)Lkotlin/contracts/ConditionalEffect;", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@ExperimentalContracts
/* loaded from: classes9.dex */
public interface SimpleEffect extends Effect {
    @ContractsDsl
    @ExperimentalContracts
    ConditionalEffect implies(boolean z);
}
