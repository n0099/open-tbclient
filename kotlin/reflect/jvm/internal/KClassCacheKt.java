package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.pcollections.HashPMap;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a-\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\b\b\u0000\u0010\u0004*\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0000¢\u0006\u0004\b\b\u0010\t\"2\u0010\r\u001a\u001e\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00030\u00030\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"", "clearKClassCache", "()V", "", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "jClass", "Lkotlin/reflect/jvm/internal/KClassImpl;", "getOrCreateKotlinClass", "(Ljava/lang/Class;)Lkotlin/reflect/jvm/internal/KClassImpl;", "Lkotlin/reflect/jvm/internal/pcollections/HashPMap;", "", "kotlin.jvm.PlatformType", "K_CLASS_CACHE", "Lkotlin/reflect/jvm/internal/pcollections/HashPMap;", "kotlin-reflection"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class KClassCacheKt {
    public static HashPMap<String, Object> K_CLASS_CACHE;

    static {
        HashPMap<String, Object> empty = HashPMap.empty();
        Intrinsics.checkExpressionValueIsNotNull(empty, "HashPMap.empty<String, Any>()");
        K_CLASS_CACHE = empty;
    }

    public static final void clearKClassCache() {
        HashPMap<String, Object> empty = HashPMap.empty();
        Intrinsics.checkExpressionValueIsNotNull(empty, "HashPMap.empty()");
        K_CLASS_CACHE = empty;
    }

    public static final <T> KClassImpl<T> getOrCreateKotlinClass(Class<T> cls) {
        Class<T> cls2;
        String name = cls.getName();
        Object obj = K_CLASS_CACHE.get(name);
        Class<T> cls3 = null;
        if (obj instanceof WeakReference) {
            KClassImpl<T> kClassImpl = (KClassImpl) ((WeakReference) obj).get();
            if (kClassImpl != null) {
                cls3 = kClassImpl.getJClass();
            }
            if (Intrinsics.areEqual(cls3, cls)) {
                return kClassImpl;
            }
        } else if (obj != null) {
            for (WeakReference weakReference : (WeakReference[]) obj) {
                KClassImpl<T> kClassImpl2 = (KClassImpl) weakReference.get();
                if (kClassImpl2 != null) {
                    cls2 = kClassImpl2.getJClass();
                } else {
                    cls2 = null;
                }
                if (Intrinsics.areEqual(cls2, cls)) {
                    return kClassImpl2;
                }
            }
            int length = ((Object[]) obj).length;
            WeakReference[] weakReferenceArr = new WeakReference[length + 1];
            System.arraycopy(obj, 0, weakReferenceArr, 0, length);
            KClassImpl<T> kClassImpl3 = new KClassImpl<>(cls);
            weakReferenceArr[length] = new WeakReference(kClassImpl3);
            HashPMap<String, Object> plus = K_CLASS_CACHE.plus(name, weakReferenceArr);
            Intrinsics.checkExpressionValueIsNotNull(plus, "K_CLASS_CACHE.plus(name, newArray)");
            K_CLASS_CACHE = plus;
            return kClassImpl3;
        }
        KClassImpl<T> kClassImpl4 = new KClassImpl<>(cls);
        HashPMap<String, Object> plus2 = K_CLASS_CACHE.plus(name, new WeakReference(kClassImpl4));
        Intrinsics.checkExpressionValueIsNotNull(plus2, "K_CLASS_CACHE.plus(name, WeakReference(newKClass))");
        K_CLASS_CACHE = plus2;
        return kClassImpl4;
    }
}
