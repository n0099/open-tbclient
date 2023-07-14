package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
/* loaded from: classes2.dex */
public interface ResolutionScope {
    /* renamed from: getContributedClassifier */
    ClassifierDescriptor mo2103getContributedClassifier(Name name, LookupLocation lookupLocation);

    Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1);

    Collection<? extends FunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation);

    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Collection getContributedDescriptors$default(ResolutionScope resolutionScope, DescriptorKindFilter descriptorKindFilter, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    descriptorKindFilter = DescriptorKindFilter.ALL;
                }
                Function1<Name, Boolean> function12 = function1;
                if ((i & 2) != 0) {
                    function12 = MemberScope.Companion.getALL_NAME_FILTER();
                }
                return resolutionScope.getContributedDescriptors(descriptorKindFilter, function12);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContributedDescriptors");
        }

        public static void recordLookup(ResolutionScope resolutionScope, Name name, LookupLocation lookupLocation) {
            resolutionScope.getContributedFunctions(name, lookupLocation);
        }
    }
}
