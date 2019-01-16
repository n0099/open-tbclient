package rx.internal.operators;

import rx.Notification;
import rx.d;
/* loaded from: classes2.dex */
public final class an<T> implements d.b<T, Notification<T>> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        static final an<Object> iJo = new an<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static an ceQ() {
        return a.iJo;
    }

    an() {
    }

    public rx.j<? super Notification<T>> call(final rx.j<? super T> jVar) {
        return new rx.j<Notification<T>>(jVar) { // from class: rx.internal.operators.an.1
            boolean terminated;

            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.e
            /* renamed from: b */
            public void onNext(Notification<T> notification) {
                switch (AnonymousClass2.iJn[notification.cen().ordinal()]) {
                    case 1:
                        if (!this.terminated) {
                            jVar.onNext(notification.getValue());
                            return;
                        }
                        return;
                    case 2:
                        onError(notification.cel());
                        return;
                    case 3:
                        onCompleted();
                        return;
                    default:
                        onError(new IllegalArgumentException("Unsupported notification type: " + notification));
                        return;
                }
            }

            @Override // rx.e
            public void onError(Throwable th) {
                if (!this.terminated) {
                    this.terminated = true;
                    jVar.onError(th);
                }
            }

            @Override // rx.e
            public void onCompleted() {
                if (!this.terminated) {
                    this.terminated = true;
                    jVar.onCompleted();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.operators.an$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] iJn = new int[Notification.Kind.values().length];

        static {
            try {
                iJn[Notification.Kind.OnNext.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iJn[Notification.Kind.OnError.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iJn[Notification.Kind.OnCompleted.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }
}
