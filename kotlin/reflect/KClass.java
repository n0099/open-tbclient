package kotlin.reflect;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H¦\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H'¢\u0006\u0004\b\u000f\u0010\nR\"\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00110\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\u00020\b8&@'X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0019\u001a\u00020\b8&@'X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0018\u001a\u0004\b\u0019\u0010\u0016R\u001c\u0010\u001b\u001a\u00020\b8&@'X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001b\u0010\u0016R\u001c\u0010\u001d\u001a\u00020\b8&@'X§\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001d\u0010\u0016R\u001c\u0010\u001f\u001a\u00020\b8&@'X§\u0004¢\u0006\f\u0012\u0004\b \u0010\u0018\u001a\u0004\b\u001f\u0010\u0016R\u001c\u0010!\u001a\u00020\b8&@'X§\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0018\u001a\u0004\b!\u0010\u0016R\u001c\u0010#\u001a\u00020\b8&@'X§\u0004¢\u0006\f\u0012\u0004\b$\u0010\u0018\u001a\u0004\b#\u0010\u0016R\u001c\u0010%\u001a\u00020\b8&@'X§\u0004¢\u0006\f\u0012\u0004\b&\u0010\u0018\u001a\u0004\b%\u0010\u0016R \u0010)\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030'0\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0013R \u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0013R\u0018\u0010.\u001a\u0004\u0018\u00018\u00008&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R*\u00107\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0000038&@'X§\u0004¢\u0006\f\u0012\u0004\b6\u0010\u0018\u001a\u0004\b4\u00105R\u0018\u00109\u001a\u0004\u0018\u00010/8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b8\u00101R\"\u0010=\u001a\b\u0012\u0004\u0012\u00020:038&@'X§\u0004¢\u0006\f\u0012\u0004\b<\u0010\u0018\u001a\u0004\b;\u00105R\"\u0010A\u001a\b\u0012\u0004\u0012\u00020>038&@'X§\u0004¢\u0006\f\u0012\u0004\b@\u0010\u0018\u001a\u0004\b?\u00105R\u001e\u0010F\u001a\u0004\u0018\u00010B8&@'X§\u0004¢\u0006\f\u0012\u0004\bE\u0010\u0018\u001a\u0004\bC\u0010D¨\u0006G"}, d2 = {"Lkotlin/reflect/KClass;", "", "T", "Lkotlin/reflect/KDeclarationContainer;", "Lkotlin/reflect/KAnnotatedElement;", "Lkotlin/reflect/KClassifier;", "Lkotlin/Any;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "value", "isInstance", "", "Lkotlin/reflect/KFunction;", "getConstructors", "()Ljava/util/Collection;", "constructors", "isAbstract", "()Z", "isAbstract$annotations", "()V", "isCompanion", "isCompanion$annotations", "isData", "isData$annotations", "isFinal", "isFinal$annotations", "isFun", "isFun$annotations", "isInner", "isInner$annotations", "isOpen", "isOpen$annotations", "isSealed", "isSealed$annotations", "Lkotlin/reflect/KCallable;", "getMembers", "members", "getNestedClasses", "nestedClasses", "getObjectInstance", "()Ljava/lang/Object;", "objectInstance", "", "getQualifiedName", "()Ljava/lang/String;", "qualifiedName", "", "getSealedSubclasses", "()Ljava/util/List;", "getSealedSubclasses$annotations", "sealedSubclasses", "getSimpleName", "simpleName", "Lkotlin/reflect/KType;", "getSupertypes", "getSupertypes$annotations", "supertypes", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "getTypeParameters$annotations", "typeParameters", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "getVisibility$annotations", "visibility", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface KClass<T> extends KDeclarationContainer, KAnnotatedElement, KClassifier {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        @SinceKotlin(version = "1.3")
        public static /* synthetic */ void getSealedSubclasses$annotations() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void getSupertypes$annotations() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void getTypeParameters$annotations() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void getVisibility$annotations() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void isAbstract$annotations() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void isCompanion$annotations() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void isData$annotations() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void isFinal$annotations() {
        }

        @SinceKotlin(version = "1.4")
        public static /* synthetic */ void isFun$annotations() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void isInner$annotations() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void isOpen$annotations() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void isSealed$annotations() {
        }
    }

    boolean equals(Object obj);

    Collection<KFunction<T>> getConstructors();

    @Override // kotlin.reflect.KDeclarationContainer
    Collection<KCallable<?>> getMembers();

    Collection<KClass<?>> getNestedClasses();

    T getObjectInstance();

    String getQualifiedName();

    List<KClass<? extends T>> getSealedSubclasses();

    String getSimpleName();

    List<KType> getSupertypes();

    List<KTypeParameter> getTypeParameters();

    KVisibility getVisibility();

    int hashCode();

    boolean isAbstract();

    boolean isCompanion();

    boolean isData();

    boolean isFinal();

    boolean isFun();

    boolean isInner();

    @SinceKotlin(version = "1.1")
    boolean isInstance(Object obj);

    boolean isOpen();

    boolean isSealed();
}
