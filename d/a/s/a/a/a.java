package d.a.s.a.a;

import android.content.Context;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.android.imsdk.upload.action.track.Connection;
import com.baidu.android.imsdk.upload.action.track.Request;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d.a.s.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class RunnableC1798a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IMPushPb.ActionType f64526e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f64527f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Object f64528g;

        public RunnableC1798a(IMPushPb.ActionType actionType, Context context, Object obj) {
            this.f64526e = actionType;
            this.f64527f = context;
            this.f64528g = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2 = b.f64529a[this.f64526e.ordinal()];
            if (i2 == 1) {
                d.a.s.a.a.c.e(this.f64527f, (Connection) this.f64528g);
            } else if (i2 != 2) {
            } else {
                d.a.s.a.a.c.f(this.f64527f, (Request) this.f64528g);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f64529a;

        static {
            int[] iArr = new int[IMPushPb.ActionType.values().length];
            f64529a = iArr;
            try {
                iArr[IMPushPb.ActionType.CONNECTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f64529a[IMPushPb.ActionType.REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public Context f64530a;

        /* renamed from: b  reason: collision with root package name */
        public Connection f64531b;

        public c(Context context) {
            Connection connection = new Connection();
            this.f64531b = connection;
            this.f64530a = context;
            connection.startTime = -1L;
            connection.stopTime = -1L;
            connection.reason = "";
            connection.retryTime = -1L;
            connection.retryCount = -1L;
            connection.ext = "";
            connection.aliasId = -1L;
        }

        public c a(long j) {
            this.f64531b.aliasId = j;
            return this;
        }

        public void b() {
            a.b(this.f64530a, IMPushPb.ActionType.CONNECTION, this.f64531b);
        }

        public c c(String str) {
            this.f64531b.ext = str;
            return this;
        }

        public c d(String str) {
            this.f64531b.reason = str;
            return this;
        }

        public c e(long j) {
            this.f64531b.retryCount = j;
            return this;
        }

        public c f(long j) {
            this.f64531b.startTime = j;
            return this;
        }

        public c g(long j) {
            this.f64531b.stopTime = j;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public Context f64532a;

        /* renamed from: b  reason: collision with root package name */
        public Request f64533b;

        public d(Context context) {
            Request request = new Request();
            this.f64533b = request;
            this.f64532a = context;
            request.method = "";
            request.requestId = "";
            request.timestamp = -1L;
            request.responseTime = -1L;
            request.errorCode = -1L;
            request.ext = "";
            request.aliasId = -1L;
        }

        public d a(long j) {
            this.f64533b.aliasId = j;
            return this;
        }

        public void b() {
            a.b(this.f64532a, IMPushPb.ActionType.REQUEST, this.f64533b);
        }

        public d c(long j) {
            this.f64533b.errorCode = j;
            return this;
        }

        public d d(String str) {
            this.f64533b.ext = str;
            return this;
        }

        public d e(String str) {
            this.f64533b.method = str;
            return this;
        }

        public d f(String str) {
            this.f64533b.requestId = str;
            return this;
        }

        public d g(long j) {
            this.f64533b.timestamp = j;
            return this;
        }

        public d h(long j) {
            this.f64533b.responseTime = j;
            return this;
        }
    }

    public static void b(Context context, IMPushPb.ActionType actionType, Object obj) {
        Context applicationContext = context.getApplicationContext();
        if (d.a.s.a.a.d.j(applicationContext)) {
            d.a.s.a.f.a.a(applicationContext).b(new RunnableC1798a(actionType, applicationContext, obj));
        }
    }
}
