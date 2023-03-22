package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
/* loaded from: classes9.dex */
public final class LazyScopeAdapter extends AbstractScopeAdapter {
    public final NotNullLazyValue<MemberScope> scope;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue<? extends kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope> */
    /* JADX WARN: Multi-variable type inference failed */
    public LazyScopeAdapter(NotNullLazyValue<? extends MemberScope> notNullLazyValue) {
        this.scope = notNullLazyValue;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter
    public MemberScope getWorkerScope() {
        return this.scope.invoke();
    }
}
