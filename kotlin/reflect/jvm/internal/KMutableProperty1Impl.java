package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.net.listener.DiaoqiJsonListener;
import com.heytap.msp.push.mode.MessageStat;
import com.tencent.open.SocialConstants;
import com.tencent.open.SocialOperation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.jvm.internal.KMutableProperty1Impl;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u00032\u00020\u0004:\u0001\u001eB+\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aB\u0019\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u0019\u0010\u001dJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\b\u0010\tR<\u0010\r\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001 \f*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000b0\u000b0\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\"\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, d2 = {"Lkotlin/reflect/jvm/internal/KMutableProperty1Impl;", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlin/reflect/KMutableProperty1;", "Lkotlin/reflect/jvm/internal/KProperty1Impl;", SocialConstants.PARAM_RECEIVER, "value", "", "set", "(Ljava/lang/Object;Ljava/lang/Object;)V", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KMutableProperty1Impl$Setter;", "kotlin.jvm.PlatformType", "_setter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "getSetter", "()Lkotlin/reflect/jvm/internal/KMutableProperty1Impl$Setter;", "setter", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "", "name", SocialOperation.GAME_SIGNATURE, "", "boundReceiver", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "descriptor", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "Setter", "kotlin-reflection"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class KMutableProperty1Impl<T, R> extends KProperty1Impl<T, R> implements KMutableProperty1<T, R> {
    public final ReflectProperties.LazyVal<Setter<T, R>> _setter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u00032\u00020\u0004B\u001b\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\n¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00028\u00022\u0006\u0010\u0006\u001a\u00028\u0003H\u0096\u0002¢\u0006\u0004\b\b\u0010\tR(\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\n8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lkotlin/reflect/jvm/internal/KMutableProperty1Impl$Setter;", ExifInterface.GPS_DIRECTION_TRUE, "R", "kotlin/reflect/KMutableProperty1$Setter", "kotlin/reflect/jvm/internal/KPropertyImpl$Setter", SocialConstants.PARAM_RECEIVER, "value", "", DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST, "(Ljava/lang/Object;Ljava/lang/Object;)V", "Lkotlin/reflect/jvm/internal/KMutableProperty1Impl;", MessageStat.PROPERTY, "Lkotlin/reflect/jvm/internal/KMutableProperty1Impl;", "getProperty", "()Lkotlin/reflect/jvm/internal/KMutableProperty1Impl;", "<init>", "(Lkotlin/reflect/jvm/internal/KMutableProperty1Impl;)V", "kotlin-reflection"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes10.dex */
    public static final class Setter<T, R> extends KPropertyImpl.Setter<R> implements KMutableProperty1.Setter<T, R> {
        public final KMutableProperty1Impl<T, R> property;

        public Setter(KMutableProperty1Impl<T, R> kMutableProperty1Impl) {
            this.property = kMutableProperty1Impl;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.KProperty.Accessor
        public KMutableProperty1Impl<T, R> getProperty() {
            return this.property;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2) {
            invoke2((Setter<T, R>) obj, obj2);
            return Unit.INSTANCE;
        }

        /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function2.invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public void invoke2(T t, R r) {
            getProperty().set(t, r);
        }
    }

    public KMutableProperty1Impl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, Object obj) {
        super(kDeclarationContainerImpl, str, str2, obj);
        ReflectProperties.LazyVal<Setter<T, R>> lazy = ReflectProperties.lazy(new Function0<Setter<T, R>>() { // from class: kotlin.reflect.jvm.internal.KMutableProperty1Impl$_setter$1
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final KMutableProperty1Impl.Setter<T, R> invoke() {
                return new KMutableProperty1Impl.Setter<>(KMutableProperty1Impl.this);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(lazy, "ReflectProperties.lazy { Setter(this) }");
        this._setter = lazy;
    }

    public KMutableProperty1Impl(KDeclarationContainerImpl kDeclarationContainerImpl, PropertyDescriptor propertyDescriptor) {
        super(kDeclarationContainerImpl, propertyDescriptor);
        ReflectProperties.LazyVal<Setter<T, R>> lazy = ReflectProperties.lazy(new Function0<Setter<T, R>>() { // from class: kotlin.reflect.jvm.internal.KMutableProperty1Impl$_setter$1
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final KMutableProperty1Impl.Setter<T, R> invoke() {
                return new KMutableProperty1Impl.Setter<>(KMutableProperty1Impl.this);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(lazy, "ReflectProperties.lazy { Setter(this) }");
        this._setter = lazy;
    }

    @Override // kotlin.reflect.KMutableProperty1
    public void set(T t, R r) {
        getSetter().call(t, r);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.KMutableProperty1, kotlin.reflect.KMutableProperty
    public Setter<T, R> getSetter() {
        Setter<T, R> invoke = this._setter.invoke();
        Intrinsics.checkExpressionValueIsNotNull(invoke, "_setter()");
        return invoke;
    }
}
