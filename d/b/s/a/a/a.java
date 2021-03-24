package d.b.s.a.a;

import android.content.Context;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.android.imsdk.upload.action.track.Connection;
import com.baidu.android.imsdk.upload.action.track.Request;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d.b.s.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class RunnableC1764a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IMPushPb.ActionType f64559e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f64560f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Object f64561g;

        public RunnableC1764a(IMPushPb.ActionType actionType, Context context, Object obj) {
            this.f64559e = actionType;
            this.f64560f = context;
            this.f64561g = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = b.f64562a[this.f64559e.ordinal()];
            if (i == 1) {
                d.b.s.a.a.c.e(this.f64560f, (Connection) this.f64561g);
            } else if (i != 2) {
            } else {
                d.b.s.a.a.c.f(this.f64560f, (Request) this.f64561g);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f64562a;

        static {
            int[] iArr = new int[IMPushPb.ActionType.values().length];
            f64562a = iArr;
            try {
                iArr[IMPushPb.ActionType.CONNECTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f64562a[IMPushPb.ActionType.REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public Context f64563a;

        /* renamed from: b  reason: collision with root package name */
        public Connection f64564b;

        public c(Context context) {
            Connection connection = new Connection();
            this.f64564b = connection;
            this.f64563a = context;
            connection.startTime = -1L;
            connection.stopTime = -1L;
            connection.reason = "";
            connection.retryTime = -1L;
            connection.retryCount = -1L;
            connection.ext = "";
            connection.aliasId = -1L;
        }

        public c a(long j) {
            this.f64564b.aliasId = j;
            return this;
        }

        public void b() {
            a.b(this.f64563a, IMPushPb.ActionType.CONNECTION, this.f64564b);
        }

        public c c(String str) {
            this.f64564b.ext = str;
            return this;
        }

        public c d(String str) {
            this.f64564b.reason = str;
            return this;
        }

        public c e(long j) {
            this.f64564b.retryCount = j;
            return this;
        }

        public c f(long j) {
            this.f64564b.startTime = j;
            return this;
        }

        public c g(long j) {
            this.f64564b.stopTime = j;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public Context f64565a;

        /* renamed from: b  reason: collision with root package name */
        public Request f64566b;

        public d(Context context) {
            Request request = new Request();
            this.f64566b = request;
            this.f64565a = context;
            request.method = "";
            request.requestId = "";
            request.timestamp = -1L;
            request.responseTime = -1L;
            request.errorCode = -1L;
            request.ext = "";
            request.aliasId = -1L;
        }

        public d a(long j) {
            this.f64566b.aliasId = j;
            return this;
        }

        public void b() {
            a.b(this.f64565a, IMPushPb.ActionType.REQUEST, this.f64566b);
        }

        public d c(long j) {
            this.f64566b.errorCode = j;
            return this;
        }

        public d d(String str) {
            this.f64566b.ext = str;
            return this;
        }

        public d e(String str) {
            this.f64566b.method = str;
            return this;
        }

        public d f(String str) {
            this.f64566b.requestId = str;
            return this;
        }

        public d g(long j) {
            this.f64566b.timestamp = j;
            return this;
        }

        public d h(long j) {
            this.f64566b.responseTime = j;
            return this;
        }
    }

    public static void b(Context context, IMPushPb.ActionType actionType, Object obj) {
        Context applicationContext = context.getApplicationContext();
        if (d.b.s.a.a.d.j(applicationContext)) {
            d.b.s.a.f.a.a(applicationContext).b(new RunnableC1764a(actionType, applicationContext, obj));
        }
    }
}
