package d.b.s.a.a;

import android.content.Context;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.android.imsdk.upload.action.track.Connection;
import com.baidu.android.imsdk.upload.action.track.Request;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d.b.s.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class RunnableC1796a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IMPushPb.ActionType f65518e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f65519f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Object f65520g;

        public RunnableC1796a(IMPushPb.ActionType actionType, Context context, Object obj) {
            this.f65518e = actionType;
            this.f65519f = context;
            this.f65520g = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = b.f65521a[this.f65518e.ordinal()];
            if (i == 1) {
                d.b.s.a.a.c.e(this.f65519f, (Connection) this.f65520g);
            } else if (i != 2) {
            } else {
                d.b.s.a.a.c.f(this.f65519f, (Request) this.f65520g);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f65521a;

        static {
            int[] iArr = new int[IMPushPb.ActionType.values().length];
            f65521a = iArr;
            try {
                iArr[IMPushPb.ActionType.CONNECTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f65521a[IMPushPb.ActionType.REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public Context f65522a;

        /* renamed from: b  reason: collision with root package name */
        public Connection f65523b;

        public c(Context context) {
            Connection connection = new Connection();
            this.f65523b = connection;
            this.f65522a = context;
            connection.startTime = -1L;
            connection.stopTime = -1L;
            connection.reason = "";
            connection.retryTime = -1L;
            connection.retryCount = -1L;
            connection.ext = "";
            connection.aliasId = -1L;
        }

        public c a(long j) {
            this.f65523b.aliasId = j;
            return this;
        }

        public void b() {
            a.b(this.f65522a, IMPushPb.ActionType.CONNECTION, this.f65523b);
        }

        public c c(String str) {
            this.f65523b.ext = str;
            return this;
        }

        public c d(String str) {
            this.f65523b.reason = str;
            return this;
        }

        public c e(long j) {
            this.f65523b.retryCount = j;
            return this;
        }

        public c f(long j) {
            this.f65523b.startTime = j;
            return this;
        }

        public c g(long j) {
            this.f65523b.stopTime = j;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public Context f65524a;

        /* renamed from: b  reason: collision with root package name */
        public Request f65525b;

        public d(Context context) {
            Request request = new Request();
            this.f65525b = request;
            this.f65524a = context;
            request.method = "";
            request.requestId = "";
            request.timestamp = -1L;
            request.responseTime = -1L;
            request.errorCode = -1L;
            request.ext = "";
            request.aliasId = -1L;
        }

        public d a(long j) {
            this.f65525b.aliasId = j;
            return this;
        }

        public void b() {
            a.b(this.f65524a, IMPushPb.ActionType.REQUEST, this.f65525b);
        }

        public d c(long j) {
            this.f65525b.errorCode = j;
            return this;
        }

        public d d(String str) {
            this.f65525b.ext = str;
            return this;
        }

        public d e(String str) {
            this.f65525b.method = str;
            return this;
        }

        public d f(String str) {
            this.f65525b.requestId = str;
            return this;
        }

        public d g(long j) {
            this.f65525b.timestamp = j;
            return this;
        }

        public d h(long j) {
            this.f65525b.responseTime = j;
            return this;
        }
    }

    public static void b(Context context, IMPushPb.ActionType actionType, Object obj) {
        Context applicationContext = context.getApplicationContext();
        if (d.b.s.a.a.d.j(applicationContext)) {
            d.b.s.a.f.a.a(applicationContext).b(new RunnableC1796a(actionType, applicationContext, obj));
        }
    }
}
