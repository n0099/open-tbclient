package tv.chushou.basis.rxjava.entity;

import io.reactivex.BackpressureStrategy;
import io.reactivex.g;
import io.reactivex.h;
import io.reactivex.i;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import tv.chushou.basis.rxjava.thread.EventThread;
/* loaded from: classes5.dex */
public class ProducerEvent extends Event {
    private final int hashCode;
    private final Method method;
    private final Object target;
    private final EventThread thread;
    private boolean valid = true;

    @Override // tv.chushou.basis.rxjava.entity.Event
    public /* bridge */ /* synthetic */ void throwRuntimeException(String str, Throwable th) {
        super.throwRuntimeException(str, th);
    }

    @Override // tv.chushou.basis.rxjava.entity.Event
    public /* bridge */ /* synthetic */ void throwRuntimeException(String str, InvocationTargetException invocationTargetException) {
        super.throwRuntimeException(str, invocationTargetException);
    }

    public ProducerEvent(Object obj, Method method, EventThread eventThread) {
        if (obj == null) {
            throw new NullPointerException("EventProducer target cannot be null.");
        }
        if (method == null) {
            throw new NullPointerException("EventProducer method cannot be null.");
        }
        this.target = obj;
        this.thread = eventThread;
        this.method = method;
        method.setAccessible(true);
        this.hashCode = ((method.hashCode() + 31) * 31) + obj.hashCode();
    }

    public boolean isValid() {
        return this.valid;
    }

    public void invalidate() {
        this.valid = false;
    }

    public g produce() {
        return g.a(new i() { // from class: tv.chushou.basis.rxjava.entity.ProducerEvent.1
            @Override // io.reactivex.i
            public void subscribe(h hVar) throws Exception {
                try {
                    hVar.onNext(ProducerEvent.this.produceEvent());
                    hVar.onComplete();
                } catch (InvocationTargetException e) {
                    ProducerEvent.this.throwRuntimeException("Producer " + ProducerEvent.this + " threw an exception.", e);
                }
            }
        }, BackpressureStrategy.BUFFER).b(EventThread.getScheduler(this.thread));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object produceEvent() throws InvocationTargetException {
        if (!this.valid) {
            throw new IllegalStateException(toString() + " has been invalidated and can no longer produce events.");
        }
        try {
            return this.method.invoke(this.target, new Object[0]);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InvocationTargetException e2) {
            if (e2.getCause() instanceof Error) {
                throw ((Error) e2.getCause());
            }
            throw e2;
        }
    }

    public String toString() {
        return "[EventProducer " + this.method + "]";
    }

    public int hashCode() {
        return this.hashCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ProducerEvent producerEvent = (ProducerEvent) obj;
            return this.method.equals(producerEvent.method) && this.target == producerEvent.target;
        }
        return false;
    }

    public Object getTarget() {
        return this.target;
    }
}
