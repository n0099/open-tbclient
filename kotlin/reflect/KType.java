package kotlin.reflect;

import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038&@'X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\n8&@'X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lkotlin/reflect/KType;", "Lkotlin/reflect/KAnnotatedElement;", "Lkotlin/Any;", "", "Lkotlin/reflect/KTypeProjection;", "getArguments", "()Ljava/util/List;", "getArguments$annotations", "()V", "arguments", "Lkotlin/reflect/KClassifier;", "getClassifier", "()Lkotlin/reflect/KClassifier;", "getClassifier$annotations", "classifier", "", "isMarkedNullable", "()Z", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface KType extends KAnnotatedElement {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void getArguments$annotations() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void getClassifier$annotations() {
        }
    }

    List<KTypeProjection> getArguments();

    KClassifier getClassifier();

    boolean isMarkedNullable();
}
