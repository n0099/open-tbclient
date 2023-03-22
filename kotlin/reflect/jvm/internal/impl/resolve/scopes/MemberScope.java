package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
/* loaded from: classes9.dex */
public interface MemberScope extends ResolutionScope {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* loaded from: classes9.dex */
    public static final class DefaultImpls {
        public static void recordLookup(MemberScope memberScope, Name name, LookupLocation lookupLocation) {
            ResolutionScope.DefaultImpls.recordLookup(memberScope, name, lookupLocation);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation);

    Collection<? extends PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation);

    Set<Name> getFunctionNames();

    Set<Name> getVariableNames();

    /* loaded from: classes9.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final Function1<Name, Boolean> ALL_NAME_FILTER = new Function1<Name, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope$Companion$ALL_NAME_FILTER$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final boolean invoke2(Name name) {
                return true;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Name name) {
                return Boolean.valueOf(invoke2(name));
            }
        };

        public final Function1<Name, Boolean> getALL_NAME_FILTER() {
            return ALL_NAME_FILTER;
        }
    }

    /* loaded from: classes9.dex */
    public static final class Empty extends MemberScopeImpl {
        public static final Empty INSTANCE = new Empty();

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        public Set<Name> getFunctionNames() {
            return SetsKt__SetsKt.emptySet();
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        public Set<Name> getVariableNames() {
            return SetsKt__SetsKt.emptySet();
        }
    }
}
