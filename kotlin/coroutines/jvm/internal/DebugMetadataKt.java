package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001f\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\t\u001a\u0013\u0010\n\u001a\u00020\u0000*\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a\u001b\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f*\u00020\u0006H\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0010*\u00020\u0006H\u0001¢\u0006\u0004\b\u0011\u0010\u0012\"\u0016\u0010\u0014\u001a\u00020\u00008\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"", "expected", "actual", "", "checkDebugMetadataVersion", "(II)V", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "Lkotlin/coroutines/jvm/internal/DebugMetadata;", "getDebugMetadataAnnotation", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)Lkotlin/coroutines/jvm/internal/DebugMetadata;", "getLabel", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)I", "", "", "getSpilledVariableFieldMapping", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)[Ljava/lang/String;", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)Ljava/lang/StackTraceElement;", "getStackTraceElementImpl", "COROUTINES_DEBUG_METADATA_VERSION", "I", "kotlin-stdlib"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class DebugMetadataKt {
    public static final int COROUTINES_DEBUG_METADATA_VERSION = 1;

    public static final void checkDebugMetadataVersion(int i2, int i3) {
        if (i3 <= i2) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i2 + ", got " + i3 + ". Please update the Kotlin standard library.").toString());
    }

    public static final DebugMetadata getDebugMetadataAnnotation(BaseContinuationImpl baseContinuationImpl) {
        return (DebugMetadata) baseContinuationImpl.getClass().getAnnotation(DebugMetadata.class);
    }

    public static final int getLabel(BaseContinuationImpl baseContinuationImpl) {
        try {
            Field field = baseContinuationImpl.getClass().getDeclaredField("label");
            Intrinsics.checkNotNullExpressionValue(field, "field");
            field.setAccessible(true);
            Object obj = field.get(baseContinuationImpl);
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "getSpilledVariableFieldMapping")
    public static final String[] getSpilledVariableFieldMapping(BaseContinuationImpl getSpilledVariableFieldMapping) {
        Intrinsics.checkNotNullParameter(getSpilledVariableFieldMapping, "$this$getSpilledVariableFieldMapping");
        DebugMetadata debugMetadataAnnotation = getDebugMetadataAnnotation(getSpilledVariableFieldMapping);
        if (debugMetadataAnnotation != null) {
            checkDebugMetadataVersion(1, debugMetadataAnnotation.v());
            ArrayList arrayList = new ArrayList();
            int label = getLabel(getSpilledVariableFieldMapping);
            int[] i2 = debugMetadataAnnotation.i();
            int length = i2.length;
            for (int i3 = 0; i3 < length; i3++) {
                if (i2[i3] == label) {
                    arrayList.add(debugMetadataAnnotation.s()[i3]);
                    arrayList.add(debugMetadataAnnotation.n()[i3]);
                }
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                return (String[]) array;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        return null;
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "getStackTraceElement")
    public static final StackTraceElement getStackTraceElement(BaseContinuationImpl getStackTraceElementImpl) {
        String str;
        Intrinsics.checkNotNullParameter(getStackTraceElementImpl, "$this$getStackTraceElementImpl");
        DebugMetadata debugMetadataAnnotation = getDebugMetadataAnnotation(getStackTraceElementImpl);
        if (debugMetadataAnnotation != null) {
            checkDebugMetadataVersion(1, debugMetadataAnnotation.v());
            int label = getLabel(getStackTraceElementImpl);
            int i2 = label < 0 ? -1 : debugMetadataAnnotation.l()[label];
            String moduleName = ModuleNameRetriever.INSTANCE.getModuleName(getStackTraceElementImpl);
            if (moduleName == null) {
                str = debugMetadataAnnotation.c();
            } else {
                str = moduleName + '/' + debugMetadataAnnotation.c();
            }
            return new StackTraceElement(str, debugMetadataAnnotation.m(), debugMetadataAnnotation.f(), i2);
        }
        return null;
    }
}
