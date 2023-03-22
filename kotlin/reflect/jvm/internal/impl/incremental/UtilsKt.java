package kotlin.reflect.jvm.internal.impl.incremental;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LocationInfo;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.incremental.components.Position;
import kotlin.reflect.jvm.internal.impl.incremental.components.ScopeKind;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
/* loaded from: classes9.dex */
public final class UtilsKt {
    public static final void record(LookupTracker lookupTracker, LookupLocation lookupLocation, ClassDescriptor classDescriptor, Name name) {
        LocationInfo location;
        Position no_position;
        if (lookupTracker != LookupTracker.DO_NOTHING.INSTANCE && (location = lookupLocation.getLocation()) != null) {
            if (lookupTracker.getRequiresPosition()) {
                no_position = location.getPosition();
            } else {
                no_position = Position.Companion.getNO_POSITION();
            }
            String filePath = location.getFilePath();
            String asString = DescriptorUtils.getFqName(classDescriptor).asString();
            Intrinsics.checkExpressionValueIsNotNull(asString, "DescriptorUtils.getFqName(scopeOwner).asString()");
            ScopeKind scopeKind = ScopeKind.CLASSIFIER;
            String asString2 = name.asString();
            Intrinsics.checkExpressionValueIsNotNull(asString2, "name.asString()");
            lookupTracker.record(filePath, no_position, asString, scopeKind, asString2);
        }
    }

    public static final void record(LookupTracker lookupTracker, LookupLocation lookupLocation, PackageFragmentDescriptor packageFragmentDescriptor, Name name) {
        String asString = packageFragmentDescriptor.getFqName().asString();
        Intrinsics.checkExpressionValueIsNotNull(asString, "scopeOwner.fqName.asString()");
        String asString2 = name.asString();
        Intrinsics.checkExpressionValueIsNotNull(asString2, "name.asString()");
        recordPackageLookup(lookupTracker, lookupLocation, asString, asString2);
    }

    public static final void recordPackageLookup(LookupTracker lookupTracker, LookupLocation lookupLocation, String str, String str2) {
        LocationInfo location;
        Position no_position;
        if (lookupTracker != LookupTracker.DO_NOTHING.INSTANCE && (location = lookupLocation.getLocation()) != null) {
            if (lookupTracker.getRequiresPosition()) {
                no_position = location.getPosition();
            } else {
                no_position = Position.Companion.getNO_POSITION();
            }
            lookupTracker.record(location.getFilePath(), no_position, str, ScopeKind.PACKAGE, str2);
        }
    }
}
