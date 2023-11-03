package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.net.listener.DiaoqiJsonListener;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.heytap.msp.push.mode.MessageStat;
import com.tencent.open.SocialConstants;
import com.tencent.open.SocialOperation;
import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;
import kotlin.reflect.jvm.internal.KProperty1Impl;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u00020\u00032\u00020\u0004:\u0001\"B+\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u0019\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001d\u0010\u001eB\u0019\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b\u001d\u0010!J\u0017\u0010\u0006\u001a\u00028\u00012\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0018\u0010\n\u001a\u00028\u00012\u0006\u0010\u0005\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\n\u0010\u0007R<\u0010\u000e\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001 \r*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\f0\f0\u000b8\b@\bX\u0088\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lkotlin/reflect/jvm/internal/KProperty1Impl;", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlin/reflect/KProperty1;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", SocialConstants.PARAM_RECEIVER, CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, "(Ljava/lang/Object;)Ljava/lang/Object;", "", "getDelegate", DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST, "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "kotlin.jvm.PlatformType", "_getter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/Lazy;", "Ljava/lang/reflect/Field;", "delegateField", "Lkotlin/Lazy;", "getGetter", "()Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "getter", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "", "name", SocialOperation.GAME_SIGNATURE, "boundReceiver", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "descriptor", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "Getter", "kotlin-reflection"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public class KProperty1Impl<T, R> extends KPropertyImpl<R> implements KProperty1<T, R> {
    public final ReflectProperties.LazyVal<Getter<T, R>> _getter;
    public final Lazy<Field> delegateField;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0006\b\u0003\u0010\u0002 \u00012\u00020\u00032\u00020\u0004B\u001b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\b¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0006\u001a\u00028\u00032\u0006\u0010\u0005\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007R(\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", ExifInterface.GPS_DIRECTION_TRUE, "R", "kotlin/reflect/KProperty1$Getter", "kotlin/reflect/jvm/internal/KPropertyImpl$Getter", SocialConstants.PARAM_RECEIVER, DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST, "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/reflect/jvm/internal/KProperty1Impl;", MessageStat.PROPERTY, "Lkotlin/reflect/jvm/internal/KProperty1Impl;", "getProperty", "()Lkotlin/reflect/jvm/internal/KProperty1Impl;", "<init>", "(Lkotlin/reflect/jvm/internal/KProperty1Impl;)V", "kotlin-reflection"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Getter<T, R> extends KPropertyImpl.Getter<R> implements KProperty1.Getter<T, R> {
        public final KProperty1Impl<T, R> property;

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.reflect.jvm.internal.KProperty1Impl<T, ? extends R> */
        /* JADX WARN: Multi-variable type inference failed */
        public Getter(KProperty1Impl<T, ? extends R> kProperty1Impl) {
            this.property = kProperty1Impl;
        }

        @Override // kotlin.jvm.functions.Function1
        public R invoke(T t) {
            return getProperty().get(t);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.KProperty.Accessor
        public KProperty1Impl<T, R> getProperty() {
            return this.property;
        }
    }

    public KProperty1Impl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, Object obj) {
        super(kDeclarationContainerImpl, str, str2, obj);
        ReflectProperties.LazyVal<Getter<T, R>> lazy = ReflectProperties.lazy(new Function0<Getter<T, ? extends R>>() { // from class: kotlin.reflect.jvm.internal.KProperty1Impl$_getter$1
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final KProperty1Impl.Getter<T, R> invoke() {
                return new KProperty1Impl.Getter<>(KProperty1Impl.this);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(lazy, "ReflectProperties.lazy { Getter(this) }");
        this._getter = lazy;
        this.delegateField = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<Field>() { // from class: kotlin.reflect.jvm.internal.KProperty1Impl$delegateField$1
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final Field invoke() {
                return KProperty1Impl.this.computeDelegateField();
            }
        });
    }

    public KProperty1Impl(KDeclarationContainerImpl kDeclarationContainerImpl, PropertyDescriptor propertyDescriptor) {
        super(kDeclarationContainerImpl, propertyDescriptor);
        ReflectProperties.LazyVal<Getter<T, R>> lazy = ReflectProperties.lazy(new Function0<Getter<T, ? extends R>>() { // from class: kotlin.reflect.jvm.internal.KProperty1Impl$_getter$1
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final KProperty1Impl.Getter<T, R> invoke() {
                return new KProperty1Impl.Getter<>(KProperty1Impl.this);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(lazy, "ReflectProperties.lazy { Getter(this) }");
        this._getter = lazy;
        this.delegateField = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<Field>() { // from class: kotlin.reflect.jvm.internal.KProperty1Impl$delegateField$1
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final Field invoke() {
                return KProperty1Impl.this.computeDelegateField();
            }
        });
    }

    @Override // kotlin.reflect.KProperty1
    public R get(T t) {
        return getGetter().call(t);
    }

    @Override // kotlin.reflect.KProperty1
    public Object getDelegate(T t) {
        return getDelegate(this.delegateField.getValue(), t);
    }

    @Override // kotlin.jvm.functions.Function1
    public R invoke(T t) {
        return get(t);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.KPropertyImpl, kotlin.reflect.KProperty
    public Getter<T, R> getGetter() {
        Getter<T, R> invoke = this._getter.invoke();
        Intrinsics.checkExpressionValueIsNotNull(invoke, "_getter()");
        return invoke;
    }
}
