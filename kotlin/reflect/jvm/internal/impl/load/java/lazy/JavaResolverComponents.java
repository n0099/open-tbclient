package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.components.SamConversionResolver;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
/* loaded from: classes10.dex */
public final class JavaResolverComponents {
    public final AnnotationTypeQualifierResolver annotationTypeQualifierResolver;
    public final DeserializedDescriptorResolver deserializedDescriptorResolver;
    public final ErrorReporter errorReporter;
    public final JavaClassFinder finder;
    public final JavaClassesTracker javaClassesTracker;
    public final JavaPropertyInitializerEvaluator javaPropertyInitializerEvaluator;
    public final JavaResolverCache javaResolverCache;
    public final KotlinClassFinder kotlinClassFinder;
    public final NewKotlinTypeChecker kotlinTypeChecker;
    public final LookupTracker lookupTracker;
    public final ModuleDescriptor module;
    public final ModuleClassResolver moduleClassResolver;
    public final PackagePartProvider packagePartProvider;
    public final ReflectionTypes reflectionTypes;
    public final SamConversionResolver samConversionResolver;
    public final JavaResolverSettings settings;
    public final SignatureEnhancement signatureEnhancement;
    public final SignaturePropagator signaturePropagator;
    public final JavaSourceElementFactory sourceElementFactory;
    public final StorageManager storageManager;
    public final SupertypeLoopChecker supertypeLoopChecker;

    public JavaResolverComponents(StorageManager storageManager, JavaClassFinder javaClassFinder, KotlinClassFinder kotlinClassFinder, DeserializedDescriptorResolver deserializedDescriptorResolver, SignaturePropagator signaturePropagator, ErrorReporter errorReporter, JavaResolverCache javaResolverCache, JavaPropertyInitializerEvaluator javaPropertyInitializerEvaluator, SamConversionResolver samConversionResolver, JavaSourceElementFactory javaSourceElementFactory, ModuleClassResolver moduleClassResolver, PackagePartProvider packagePartProvider, SupertypeLoopChecker supertypeLoopChecker, LookupTracker lookupTracker, ModuleDescriptor moduleDescriptor, ReflectionTypes reflectionTypes, AnnotationTypeQualifierResolver annotationTypeQualifierResolver, SignatureEnhancement signatureEnhancement, JavaClassesTracker javaClassesTracker, JavaResolverSettings javaResolverSettings, NewKotlinTypeChecker newKotlinTypeChecker) {
        this.storageManager = storageManager;
        this.finder = javaClassFinder;
        this.kotlinClassFinder = kotlinClassFinder;
        this.deserializedDescriptorResolver = deserializedDescriptorResolver;
        this.signaturePropagator = signaturePropagator;
        this.errorReporter = errorReporter;
        this.javaResolverCache = javaResolverCache;
        this.javaPropertyInitializerEvaluator = javaPropertyInitializerEvaluator;
        this.samConversionResolver = samConversionResolver;
        this.sourceElementFactory = javaSourceElementFactory;
        this.moduleClassResolver = moduleClassResolver;
        this.packagePartProvider = packagePartProvider;
        this.supertypeLoopChecker = supertypeLoopChecker;
        this.lookupTracker = lookupTracker;
        this.module = moduleDescriptor;
        this.reflectionTypes = reflectionTypes;
        this.annotationTypeQualifierResolver = annotationTypeQualifierResolver;
        this.signatureEnhancement = signatureEnhancement;
        this.javaClassesTracker = javaClassesTracker;
        this.settings = javaResolverSettings;
        this.kotlinTypeChecker = newKotlinTypeChecker;
    }

    public final AnnotationTypeQualifierResolver getAnnotationTypeQualifierResolver() {
        return this.annotationTypeQualifierResolver;
    }

    public final DeserializedDescriptorResolver getDeserializedDescriptorResolver() {
        return this.deserializedDescriptorResolver;
    }

    public final ErrorReporter getErrorReporter() {
        return this.errorReporter;
    }

    public final JavaClassFinder getFinder() {
        return this.finder;
    }

    public final JavaClassesTracker getJavaClassesTracker() {
        return this.javaClassesTracker;
    }

    public final JavaPropertyInitializerEvaluator getJavaPropertyInitializerEvaluator() {
        return this.javaPropertyInitializerEvaluator;
    }

    public final JavaResolverCache getJavaResolverCache() {
        return this.javaResolverCache;
    }

    public final KotlinClassFinder getKotlinClassFinder() {
        return this.kotlinClassFinder;
    }

    public final NewKotlinTypeChecker getKotlinTypeChecker() {
        return this.kotlinTypeChecker;
    }

    public final LookupTracker getLookupTracker() {
        return this.lookupTracker;
    }

    public final ModuleDescriptor getModule() {
        return this.module;
    }

    public final ModuleClassResolver getModuleClassResolver() {
        return this.moduleClassResolver;
    }

    public final PackagePartProvider getPackagePartProvider() {
        return this.packagePartProvider;
    }

    public final ReflectionTypes getReflectionTypes() {
        return this.reflectionTypes;
    }

    public final JavaResolverSettings getSettings() {
        return this.settings;
    }

    public final SignatureEnhancement getSignatureEnhancement() {
        return this.signatureEnhancement;
    }

    public final SignaturePropagator getSignaturePropagator() {
        return this.signaturePropagator;
    }

    public final JavaSourceElementFactory getSourceElementFactory() {
        return this.sourceElementFactory;
    }

    public final StorageManager getStorageManager() {
        return this.storageManager;
    }

    public final SupertypeLoopChecker getSupertypeLoopChecker() {
        return this.supertypeLoopChecker;
    }

    public final JavaResolverComponents replace(JavaResolverCache javaResolverCache) {
        return new JavaResolverComponents(this.storageManager, this.finder, this.kotlinClassFinder, this.deserializedDescriptorResolver, this.signaturePropagator, this.errorReporter, javaResolverCache, this.javaPropertyInitializerEvaluator, this.samConversionResolver, this.sourceElementFactory, this.moduleClassResolver, this.packagePartProvider, this.supertypeLoopChecker, this.lookupTracker, this.module, this.reflectionTypes, this.annotationTypeQualifierResolver, this.signatureEnhancement, this.javaClassesTracker, this.settings, this.kotlinTypeChecker);
    }
}
