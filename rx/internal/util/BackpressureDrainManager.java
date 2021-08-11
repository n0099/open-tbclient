package rx.internal.util;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.f;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class BackpressureDrainManager extends AtomicLong implements f {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 2826241102729529449L;
    public transient /* synthetic */ FieldHolder $fh;
    public final a actual;
    public boolean emitting;
    public Throwable exception;
    public volatile boolean terminated;

    /* loaded from: classes2.dex */
    public interface a {
        void a(Throwable th);

        boolean accept(Object obj);

        Object peek();

        Object poll();
    }

    public BackpressureDrainManager(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.actual = aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0031, code lost:
        if (r9 == 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003a, code lost:
        monitor-enter(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x003b, code lost:
        r1 = r13.terminated;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0041, code lost:
        if (r5.peek() == null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0043, code lost:
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0045, code lost:
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0051, code lost:
        if (get() != Long.MAX_VALUE) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0053, code lost:
        if (r2 != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0055, code lost:
        if (r1 != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0057, code lost:
        r13.emitting = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0059, code lost:
        monitor-exit(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x005a, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x005b, code lost:
        r2 = Long.MAX_VALUE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x005f, code lost:
        r9 = addAndGet(-r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0065, code lost:
        if (r9 == 0) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0067, code lost:
        if (r2 != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0069, code lost:
        if (r1 == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x006b, code lost:
        if (r2 == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x006e, code lost:
        r2 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0071, code lost:
        r13.emitting = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0073, code lost:
        monitor-exit(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0074, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0075, code lost:
        r1 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0077, code lost:
        monitor-exit(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0078, code lost:
        throw r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drain() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
            return;
        }
        synchronized (this) {
            if (this.emitting) {
                return;
            }
            boolean z = true;
            this.emitting = true;
            boolean z2 = this.terminated;
            long j2 = get();
            try {
                a aVar = this.actual;
                while (true) {
                    int i2 = 0;
                    while (true) {
                        int i3 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
                        try {
                            if (i3 > 0 || z2) {
                                if (z2) {
                                    if (aVar.peek() == null) {
                                        aVar.a(this.exception);
                                        return;
                                    }
                                }
                                Object poll = aVar.poll();
                                if (poll != null) {
                                    if (aVar.accept(poll)) {
                                        return;
                                    }
                                    j2--;
                                    i2++;
                                }
                            }
                            try {
                                break;
                            } catch (Throwable th) {
                                th = th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (!z) {
                                synchronized (this) {
                                    this.emitting = false;
                                }
                            }
                            throw th;
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                z = false;
            }
        }
    }

    public boolean isTerminated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.terminated : invokeV.booleanValue;
    }

    @Override // i.f
    public void request(long j2) {
        boolean z;
        long j3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) || j2 == 0) {
            return;
        }
        while (true) {
            long j4 = get();
            boolean z2 = true;
            z = j4 == 0;
            if (j4 == Long.MAX_VALUE) {
                break;
            }
            if (j2 == Long.MAX_VALUE) {
                j3 = j2;
            } else {
                j3 = j4 <= Long.MAX_VALUE - j2 ? j4 + j2 : Long.MAX_VALUE;
                z2 = z;
            }
            if (compareAndSet(j4, j3)) {
                z = z2;
                break;
            }
        }
        if (z) {
            drain();
        }
    }

    public void terminate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.terminated = true;
        }
    }

    public void terminateAndDrain() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.terminated = true;
            drain();
        }
    }

    public void terminate(Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, th) == null) || this.terminated) {
            return;
        }
        this.exception = th;
        this.terminated = true;
    }

    public void terminateAndDrain(Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, th) == null) || this.terminated) {
            return;
        }
        this.exception = th;
        this.terminated = true;
        drain();
    }
}
