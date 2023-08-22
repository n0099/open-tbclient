package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus;
/* loaded from: classes2.dex */
public final class NullabilityQualifierWithApplicability {
    public final NullabilityQualifierWithMigrationStatus nullabilityQualifier;
    public final Collection<AnnotationTypeQualifierResolver.QualifierApplicabilityType> qualifierApplicabilityTypes;

    public final NullabilityQualifierWithMigrationStatus component1() {
        return this.nullabilityQualifier;
    }

    public final Collection<AnnotationTypeQualifierResolver.QualifierApplicabilityType> component2() {
        return this.qualifierApplicabilityTypes;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof NullabilityQualifierWithApplicability) {
                NullabilityQualifierWithApplicability nullabilityQualifierWithApplicability = (NullabilityQualifierWithApplicability) obj;
                return Intrinsics.areEqual(this.nullabilityQualifier, nullabilityQualifierWithApplicability.nullabilityQualifier) && Intrinsics.areEqual(this.qualifierApplicabilityTypes, nullabilityQualifierWithApplicability.qualifierApplicabilityTypes);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus = this.nullabilityQualifier;
        int hashCode = (nullabilityQualifierWithMigrationStatus != null ? nullabilityQualifierWithMigrationStatus.hashCode() : 0) * 31;
        Collection<AnnotationTypeQualifierResolver.QualifierApplicabilityType> collection = this.qualifierApplicabilityTypes;
        return hashCode + (collection != null ? collection.hashCode() : 0);
    }

    public String toString() {
        return "NullabilityQualifierWithApplicability(nullabilityQualifier=" + this.nullabilityQualifier + ", qualifierApplicabilityTypes=" + this.qualifierApplicabilityTypes + SmallTailInfo.EMOTION_SUFFIX;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver$QualifierApplicabilityType> */
    /* JADX WARN: Multi-variable type inference failed */
    public NullabilityQualifierWithApplicability(NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, Collection<? extends AnnotationTypeQualifierResolver.QualifierApplicabilityType> collection) {
        this.nullabilityQualifier = nullabilityQualifierWithMigrationStatus;
        this.qualifierApplicabilityTypes = collection;
    }
}
