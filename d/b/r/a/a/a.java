package d.b.r.a.a;

import android.content.Context;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.android.imsdk.upload.action.track.Connection;
import com.baidu.android.imsdk.upload.action.track.Request;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d.b.r.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class RunnableC1777a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IMPushPb.ActionType f65254e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f65255f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Object f65256g;

        public RunnableC1777a(IMPushPb.ActionType actionType, Context context, Object obj) {
            this.f65254e = actionType;
            this.f65255f = context;
            this.f65256g = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = b.f65257a[this.f65254e.ordinal()];
            if (i == 1) {
                d.b.r.a.a.c.e(this.f65255f, (Connection) this.f65256g);
            } else if (i != 2) {
            } else {
                d.b.r.a.a.c.f(this.f65255f, (Request) this.f65256g);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f65257a;

        static {
            int[] iArr = new int[IMPushPb.ActionType.values().length];
            f65257a = iArr;
            try {
                iArr[IMPushPb.ActionType.CONNECTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f65257a[IMPushPb.ActionType.REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public Context f65258a;

        /* renamed from: b  reason: collision with root package name */
        public Connection f65259b;

        public c(Context context) {
            Connection connection = new Connection();
            this.f65259b = connection;
            this.f65258a = context;
            connection.startTime = -1L;
            connection.stopTime = -1L;
            connection.reason = "";
            connection.retryTime = -1L;
            connection.retryCount = -1L;
            connection.ext = "";
            connection.aliasId = -1L;
        }

        public c a(long j) {
            this.f65259b.aliasId = j;
            return this;
        }

        public void b() {
            a.b(this.f65258a, IMPushPb.ActionType.CONNECTION, this.f65259b);
        }

        public c c(String str) {
            this.f65259b.ext = str;
            return this;
        }

        public c d(String str) {
            this.f65259b.reason = str;
            return this;
        }

        public c e(long j) {
            this.f65259b.retryCount = j;
            return this;
        }

        public c f(long j) {
            this.f65259b.startTime = j;
            return this;
        }

        public c g(long j) {
            this.f65259b.stopTime = j;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public Context f65260a;

        /* renamed from: b  reason: collision with root package name */
        public Request f65261b;

        public d(Context context) {
            Request request = new Request();
            this.f65261b = request;
            this.f65260a = context;
            request.method = "";
            request.requestId = "";
            request.timestamp = -1L;
            request.responseTime = -1L;
            request.errorCode = -1L;
            request.ext = "";
            request.aliasId = -1L;
        }

        public d a(long j) {
            this.f65261b.aliasId = j;
            return this;
        }

        public void b() {
            a.b(this.f65260a, IMPushPb.ActionType.REQUEST, this.f65261b);
        }

        public d c(long j) {
            this.f65261b.errorCode = j;
            return this;
        }

        public d d(String str) {
            this.f65261b.ext = str;
            return this;
        }

        public d e(String str) {
            this.f65261b.method = str;
            return this;
        }

        public d f(String str) {
            this.f65261b.requestId = str;
            return this;
        }

        public d g(long j) {
            this.f65261b.timestamp = j;
            return this;
        }

        public d h(long j) {
            this.f65261b.responseTime = j;
            return this;
        }
    }

    public static void b(Context context, IMPushPb.ActionType actionType, Object obj) {
        Context applicationContext = context.getApplicationContext();
        if (d.b.r.a.a.d.j(applicationContext)) {
            d.b.r.a.f.a.a(applicationContext).b(new RunnableC1777a(actionType, applicationContext, obj));
        }
    }
}
