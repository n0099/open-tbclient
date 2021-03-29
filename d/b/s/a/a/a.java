package d.b.s.a.a;

import android.content.Context;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.android.imsdk.upload.action.track.Connection;
import com.baidu.android.imsdk.upload.action.track.Request;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d.b.s.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class RunnableC1765a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IMPushPb.ActionType f64560e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f64561f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Object f64562g;

        public RunnableC1765a(IMPushPb.ActionType actionType, Context context, Object obj) {
            this.f64560e = actionType;
            this.f64561f = context;
            this.f64562g = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = b.f64563a[this.f64560e.ordinal()];
            if (i == 1) {
                d.b.s.a.a.c.e(this.f64561f, (Connection) this.f64562g);
            } else if (i != 2) {
            } else {
                d.b.s.a.a.c.f(this.f64561f, (Request) this.f64562g);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f64563a;

        static {
            int[] iArr = new int[IMPushPb.ActionType.values().length];
            f64563a = iArr;
            try {
                iArr[IMPushPb.ActionType.CONNECTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f64563a[IMPushPb.ActionType.REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public Context f64564a;

        /* renamed from: b  reason: collision with root package name */
        public Connection f64565b;

        public c(Context context) {
            Connection connection = new Connection();
            this.f64565b = connection;
            this.f64564a = context;
            connection.startTime = -1L;
            connection.stopTime = -1L;
            connection.reason = "";
            connection.retryTime = -1L;
            connection.retryCount = -1L;
            connection.ext = "";
            connection.aliasId = -1L;
        }

        public c a(long j) {
            this.f64565b.aliasId = j;
            return this;
        }

        public void b() {
            a.b(this.f64564a, IMPushPb.ActionType.CONNECTION, this.f64565b);
        }

        public c c(String str) {
            this.f64565b.ext = str;
            return this;
        }

        public c d(String str) {
            this.f64565b.reason = str;
            return this;
        }

        public c e(long j) {
            this.f64565b.retryCount = j;
            return this;
        }

        public c f(long j) {
            this.f64565b.startTime = j;
            return this;
        }

        public c g(long j) {
            this.f64565b.stopTime = j;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public Context f64566a;

        /* renamed from: b  reason: collision with root package name */
        public Request f64567b;

        public d(Context context) {
            Request request = new Request();
            this.f64567b = request;
            this.f64566a = context;
            request.method = "";
            request.requestId = "";
            request.timestamp = -1L;
            request.responseTime = -1L;
            request.errorCode = -1L;
            request.ext = "";
            request.aliasId = -1L;
        }

        public d a(long j) {
            this.f64567b.aliasId = j;
            return this;
        }

        public void b() {
            a.b(this.f64566a, IMPushPb.ActionType.REQUEST, this.f64567b);
        }

        public d c(long j) {
            this.f64567b.errorCode = j;
            return this;
        }

        public d d(String str) {
            this.f64567b.ext = str;
            return this;
        }

        public d e(String str) {
            this.f64567b.method = str;
            return this;
        }

        public d f(String str) {
            this.f64567b.requestId = str;
            return this;
        }

        public d g(long j) {
            this.f64567b.timestamp = j;
            return this;
        }

        public d h(long j) {
            this.f64567b.responseTime = j;
            return this;
        }
    }

    public static void b(Context context, IMPushPb.ActionType actionType, Object obj) {
        Context applicationContext = context.getApplicationContext();
        if (d.b.s.a.a.d.j(applicationContext)) {
            d.b.s.a.f.a.a(applicationContext).b(new RunnableC1765a(actionType, applicationContext, obj));
        }
    }
}
