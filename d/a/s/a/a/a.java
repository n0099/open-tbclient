package d.a.s.a.a;

import android.content.Context;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.android.imsdk.upload.action.track.Connection;
import com.baidu.android.imsdk.upload.action.track.Request;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d.a.s.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class RunnableC1734a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IMPushPb.ActionType f63839e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f63840f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Object f63841g;

        public RunnableC1734a(IMPushPb.ActionType actionType, Context context, Object obj) {
            this.f63839e = actionType;
            this.f63840f = context;
            this.f63841g = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2 = b.f63842a[this.f63839e.ordinal()];
            if (i2 == 1) {
                d.a.s.a.a.c.e(this.f63840f, (Connection) this.f63841g);
            } else if (i2 != 2) {
            } else {
                d.a.s.a.a.c.f(this.f63840f, (Request) this.f63841g);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f63842a;

        static {
            int[] iArr = new int[IMPushPb.ActionType.values().length];
            f63842a = iArr;
            try {
                iArr[IMPushPb.ActionType.CONNECTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f63842a[IMPushPb.ActionType.REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public Context f63843a;

        /* renamed from: b  reason: collision with root package name */
        public Connection f63844b;

        public c(Context context) {
            Connection connection = new Connection();
            this.f63844b = connection;
            this.f63843a = context;
            connection.startTime = -1L;
            connection.stopTime = -1L;
            connection.reason = "";
            connection.retryTime = -1L;
            connection.retryCount = -1L;
            connection.ext = "";
            connection.aliasId = -1L;
        }

        public c a(long j) {
            this.f63844b.aliasId = j;
            return this;
        }

        public void b() {
            a.b(this.f63843a, IMPushPb.ActionType.CONNECTION, this.f63844b);
        }

        public c c(String str) {
            this.f63844b.ext = str;
            return this;
        }

        public c d(String str) {
            this.f63844b.reason = str;
            return this;
        }

        public c e(long j) {
            this.f63844b.retryCount = j;
            return this;
        }

        public c f(long j) {
            this.f63844b.startTime = j;
            return this;
        }

        public c g(long j) {
            this.f63844b.stopTime = j;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public Context f63845a;

        /* renamed from: b  reason: collision with root package name */
        public Request f63846b;

        public d(Context context) {
            Request request = new Request();
            this.f63846b = request;
            this.f63845a = context;
            request.method = "";
            request.requestId = "";
            request.timestamp = -1L;
            request.responseTime = -1L;
            request.errorCode = -1L;
            request.ext = "";
            request.aliasId = -1L;
        }

        public d a(long j) {
            this.f63846b.aliasId = j;
            return this;
        }

        public void b() {
            a.b(this.f63845a, IMPushPb.ActionType.REQUEST, this.f63846b);
        }

        public d c(long j) {
            this.f63846b.errorCode = j;
            return this;
        }

        public d d(String str) {
            this.f63846b.ext = str;
            return this;
        }

        public d e(String str) {
            this.f63846b.method = str;
            return this;
        }

        public d f(String str) {
            this.f63846b.requestId = str;
            return this;
        }

        public d g(long j) {
            this.f63846b.timestamp = j;
            return this;
        }

        public d h(long j) {
            this.f63846b.responseTime = j;
            return this;
        }
    }

    public static void b(Context context, IMPushPb.ActionType actionType, Object obj) {
        Context applicationContext = context.getApplicationContext();
        if (d.a.s.a.a.d.j(applicationContext)) {
            d.a.s.a.f.a.a(applicationContext).b(new RunnableC1734a(actionType, applicationContext, obj));
        }
    }
}
