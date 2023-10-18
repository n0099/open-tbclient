package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.net.listener.DiaoqiJsonListener;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.heytap.msp.push.mode.MessageStat;
import com.tencent.open.SocialOperation;
import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty2;
import kotlin.reflect.jvm.internal.KProperty2Impl;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0006\b\u0002\u0010\u0003 \u00012\u00020\u00042\u00020\u0005:\u0001#B!\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001d\u001a\u00020\u001b¢\u0006\u0004\b\u001e\u0010\u001fB\u0019\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\u001e\u0010\"J\u001f\u0010\b\u001a\u00028\u00022\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u000b\u0010\tJ \u0010\f\u001a\u00028\u00022\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0004\b\f\u0010\tRH\u0010\u0010\u001a4\u00120\u0012.\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002 \u000f*\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u000e0\u000e0\r8\b@\bX\u0088\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R(\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000e8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lkotlin/reflect/jvm/internal/KProperty2Impl;", "D", ExifInterface.LONGITUDE_EAST, "R", "Lkotlin/reflect/KProperty2;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "receiver1", "receiver2", CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "", "getDelegate", DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST, "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KProperty2Impl$Getter;", "kotlin.jvm.PlatformType", "_getter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/Lazy;", "Ljava/lang/reflect/Field;", "delegateField", "Lkotlin/Lazy;", "getGetter", "()Lkotlin/reflect/jvm/internal/KProperty2Impl$Getter;", "getter", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "", "name", SocialOperation.GAME_SIGNATURE, "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;)V", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "descriptor", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "Getter", "kotlin-reflection"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public class KProperty2Impl<D, E, R> extends KPropertyImpl<R> implements KProperty2<D, E, R> {
    public final ReflectProperties.LazyVal<Getter<D, E, R>> _getter;
    public final Lazy<Field> delegateField;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0003\u0010\u0001*\u0004\b\u0004\u0010\u0002*\u0006\b\u0005\u0010\u0003 \u00012\u00020\u00042\u00020\u0005B!\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\n¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\b\u001a\u00028\u00052\u0006\u0010\u0006\u001a\u00028\u00032\u0006\u0010\u0007\u001a\u00028\u0004H\u0096\u0002¢\u0006\u0004\b\b\u0010\tR.\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\n8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lkotlin/reflect/jvm/internal/KProperty2Impl$Getter;", "D", ExifInterface.LONGITUDE_EAST, "R", "kotlin/reflect/KProperty2$Getter", "kotlin/reflect/jvm/internal/KPropertyImpl$Getter", "receiver1", "receiver2", DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/reflect/jvm/internal/KProperty2Impl;", MessageStat.PROPERTY, "Lkotlin/reflect/jvm/internal/KProperty2Impl;", "getProperty", "()Lkotlin/reflect/jvm/internal/KProperty2Impl;", "<init>", "(Lkotlin/reflect/jvm/internal/KProperty2Impl;)V", "kotlin-reflection"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes10.dex */
    public static final class Getter<D, E, R> extends KPropertyImpl.Getter<R> implements KProperty2.Getter<D, E, R> {
        public final KProperty2Impl<D, E, R> property;

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.reflect.jvm.internal.KProperty2Impl<D, E, ? extends R> */
        /* JADX WARN: Multi-variable type inference failed */
        public Getter(KProperty2Impl<D, E, ? extends R> kProperty2Impl) {
            this.property = kProperty2Impl;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.KProperty.Accessor
        public KProperty2Impl<D, E, R> getProperty() {
            return this.property;
        }

        @Override // kotlin.jvm.functions.Function2
        public R invoke(D d, E e) {
            return getProperty().get(d, e);
        }
    }

    public KProperty2Impl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2) {
        super(kDeclarationContainerImpl, str, str2, CallableReference.NO_RECEIVER);
        ReflectProperties.LazyVal<Getter<D, E, R>> lazy = ReflectProperties.lazy(new Function0<Getter<D, E, ? extends R>>() { // from class: kotlin.reflect.jvm.internal.KProperty2Impl$_getter$1
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final KProperty2Impl.Getter<D, E, R> invoke() {
                return new KProperty2Impl.Getter<>(KProperty2Impl.this);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(lazy, "ReflectProperties.lazy { Getter(this) }");
        this._getter = lazy;
        this.delegateField = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<Field>() { // from class: kotlin.reflect.jvm.internal.KProperty2Impl$delegateField$1
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final Field invoke() {
                return KProperty2Impl.this.computeDelegateField();
            }
        });
    }

    public KProperty2Impl(KDeclarationContainerImpl kDeclarationContainerImpl, PropertyDescriptor propertyDescriptor) {
        super(kDeclarationContainerImpl, propertyDescriptor);
        ReflectProperties.LazyVal<Getter<D, E, R>> lazy = ReflectProperties.lazy(new Function0<Getter<D, E, ? extends R>>() { // from class: kotlin.reflect.jvm.internal.KProperty2Impl$_getter$1
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final KProperty2Impl.Getter<D, E, R> invoke() {
                return new KProperty2Impl.Getter<>(KProperty2Impl.this);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(lazy, "ReflectProperties.lazy { Getter(this) }");
        this._getter = lazy;
        this.delegateField = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<Field>() { // from class: kotlin.reflect.jvm.internal.KProperty2Impl$delegateField$1
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final Field invoke() {
                return KProperty2Impl.this.computeDelegateField();
            }
        });
    }

    @Override // kotlin.reflect.KProperty2
    public R get(D d, E e) {
        return getGetter().call(d, e);
    }

    @Override // kotlin.reflect.KProperty2
    public Object getDelegate(D d, E e) {
        return getDelegate(this.delegateField.getValue(), (Object) d);
    }

    @Override // kotlin.jvm.functions.Function2
    public R invoke(D d, E e) {
        return get(d, e);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.KPropertyImpl, kotlin.reflect.KProperty
    public Getter<D, E, R> getGetter() {
        Getter<D, E, R> invoke = this._getter.invoke();
        Intrinsics.checkExpressionValueIsNotNull(invoke, "_getter()");
        return invoke;
    }
}
