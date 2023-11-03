package kotlin.reflect.full;

import androidx.exifinterface.media.ExifInterface;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KAnnotatedElement;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\"\u0010\u0003\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\u0087\b¢\u0006\u0004\b\u0003\u0010\u0004\u001a \u0010\u0006\u001a\u00020\u0005\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\u0087\b¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/KAnnotatedElement;", "findAnnotation", "(Lkotlin/reflect/KAnnotatedElement;)Ljava/lang/annotation/Annotation;", "", "hasAnnotation", "(Lkotlin/reflect/KAnnotatedElement;)Z", "kotlin-reflection"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@JvmName(name = "KAnnotatedElements")
/* loaded from: classes2.dex */
public final class KAnnotatedElements {
    @SinceKotlin(version = "1.1")
    public static final /* synthetic */ <T extends Annotation> T findAnnotation(KAnnotatedElement kAnnotatedElement) {
        Object obj;
        Iterator<T> it = kAnnotatedElement.getAnnotations().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                if (((Annotation) obj) instanceof Annotation) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        Intrinsics.reifiedOperationMarker(1, "T?");
        return (T) obj;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final /* synthetic */ <T extends Annotation> boolean hasAnnotation(KAnnotatedElement kAnnotatedElement) {
        Object obj;
        Iterator<T> it = kAnnotatedElement.getAnnotations().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                if (((Annotation) obj) instanceof Annotation) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        Intrinsics.reifiedOperationMarker(1, "T?");
        if (((Annotation) obj) != null) {
            return true;
        }
        return false;
    }
}
