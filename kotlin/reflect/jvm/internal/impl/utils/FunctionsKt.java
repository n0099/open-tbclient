package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
/* loaded from: classes2.dex */
public final class FunctionsKt {
    public static final Function1<Object, Object> IDENTITY = new Function1<Object, Object>() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$IDENTITY$1
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return obj;
        }
    };
    public static final Function1<Object, Boolean> ALWAYS_TRUE = new Function1<Object, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$ALWAYS_TRUE$1
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
            return Boolean.valueOf(invoke2(obj));
        }

        /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function1.invoke(Ljava/lang/Object;)Ljava/lang/Object; */
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final boolean invoke2(Object obj) {
            return true;
        }
    };
    public static final Function1<Object, Object> ALWAYS_NULL = new Function1() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$ALWAYS_NULL$1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        public final Void invoke(Object obj) {
            return null;
        }
    };
    public static final Function1<Object, Unit> DO_NOTHING = new Function1<Object, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$DO_NOTHING$1
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2(obj);
            return Unit.INSTANCE;
        }

        /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function1.invoke(Ljava/lang/Object;)Ljava/lang/Object; */
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Object obj) {
        }
    };
    public static final Function2<Object, Object, Unit> DO_NOTHING_2 = new Function2<Object, Object, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$DO_NOTHING_2$1
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2) {
            invoke2(obj, obj2);
            return Unit.INSTANCE;
        }

        /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function2.invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Object obj, Object obj2) {
        }
    };
    public static final Function3<Object, Object, Object, Unit> DO_NOTHING_3 = new Function3<Object, Object, Object, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$DO_NOTHING_3$1
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2, Object obj3) {
            invoke2(obj, obj2, obj3);
            return Unit.INSTANCE;
        }

        /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function3.invoke(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Object obj, Object obj2, Object obj3) {
        }
    };

    public static final <T> Function1<T, Boolean> alwaysTrue() {
        return (Function1<T, Boolean>) ALWAYS_TRUE;
    }

    public static final Function3<Object, Object, Object, Unit> getDO_NOTHING_3() {
        return DO_NOTHING_3;
    }
}
