package kotlin.jvm.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KParameter;
import kotlin.reflect.KVisibility;
/* loaded from: classes2.dex */
public abstract class CallableReference implements Serializable, kotlin.reflect.b {
    public static final Object NO_RECEIVER = NoReceiver.kkt;
    private transient kotlin.reflect.b kks;
    protected final Object receiver;

    protected abstract kotlin.reflect.b computeReflected();

    /* loaded from: classes2.dex */
    private static class NoReceiver implements Serializable {
        private static final NoReceiver kkt = new NoReceiver();

        private NoReceiver() {
        }

        private Object readResolve() throws ObjectStreamException {
            return kkt;
        }
    }

    public CallableReference() {
        this(NO_RECEIVER);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CallableReference(Object obj) {
        this.receiver = obj;
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    public kotlin.reflect.b compute() {
        kotlin.reflect.b bVar = this.kks;
        if (bVar == null) {
            kotlin.reflect.b computeReflected = computeReflected();
            this.kks = computeReflected;
            return computeReflected;
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public kotlin.reflect.b getReflected() {
        kotlin.reflect.b compute = compute();
        if (compute == this) {
            throw new KotlinReflectionNotSupportedError();
        }
        return compute;
    }

    public kotlin.reflect.d getOwner() {
        throw new AbstractMethodError();
    }

    public String getName() {
        throw new AbstractMethodError();
    }

    public String getSignature() {
        throw new AbstractMethodError();
    }

    @Override // kotlin.reflect.b
    public List<KParameter> getParameters() {
        return getReflected().getParameters();
    }

    @Override // kotlin.reflect.b
    public kotlin.reflect.n getReturnType() {
        return getReflected().getReturnType();
    }

    @Override // kotlin.reflect.a
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    @Override // kotlin.reflect.b
    public List<Object> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // kotlin.reflect.b
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // kotlin.reflect.b
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    @Override // kotlin.reflect.b
    public KVisibility getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // kotlin.reflect.b
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // kotlin.reflect.b
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // kotlin.reflect.b
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }
}
