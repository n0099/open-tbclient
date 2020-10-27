package tv.chushou.basis.rxjava.entity;

import io.reactivex.c.g;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.b;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import tv.chushou.basis.rxjava.thread.EventThread;
/* loaded from: classes6.dex */
public class SubscriberEvent extends Event {
    private final int hashCode;
    private final Method method;
    private b subject;
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

    public SubscriberEvent(Object obj, Method method, EventThread eventThread) {
        if (obj == null) {
            throw new NullPointerException("SubscriberEvent target cannot be null.");
        }
        if (method == null) {
            throw new NullPointerException("SubscriberEvent method cannot be null.");
        }
        if (eventThread == null) {
            throw new NullPointerException("SubscriberEvent thread cannot be null.");
        }
        this.target = obj;
        this.method = method;
        this.thread = eventThread;
        method.setAccessible(true);
        initObservable();
        this.hashCode = ((method.hashCode() + 31) * 31) + obj.hashCode();
    }

    private void initObservable() {
        this.subject = PublishSubject.exw();
        this.subject.d(EventThread.getScheduler(this.thread)).b(new g() { // from class: tv.chushou.basis.rxjava.entity.SubscriberEvent.1
            @Override // io.reactivex.c.g
            public void accept(Object obj) {
                try {
                    if (SubscriberEvent.this.valid) {
                        SubscriberEvent.this.handleEvent(obj);
                    }
                } catch (InvocationTargetException e) {
                    SubscriberEvent.this.throwRuntimeException("Could not dispatch event: " + obj.getClass() + " to subscriber " + SubscriberEvent.this, e);
                }
            }
        });
    }

    public boolean isValid() {
        return this.valid;
    }

    public void invalidate() {
        this.valid = false;
    }

    public void handle(Object obj) {
        this.subject.onNext(obj);
    }

    public b getSubject() {
        return this.subject;
    }

    protected void handleEvent(Object obj) throws InvocationTargetException {
        if (!this.valid) {
            throw new IllegalStateException(toString() + " has been invalidated and can no longer handle events.");
        }
        try {
            this.method.invoke(this.target, obj);
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
        return "[SubscriberEvent " + this.method + "]";
    }

    public int hashCode() {
        return this.hashCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            SubscriberEvent subscriberEvent = (SubscriberEvent) obj;
            return this.method.equals(subscriberEvent.method) && this.target == subscriberEvent.target;
        }
        return false;
    }
}
