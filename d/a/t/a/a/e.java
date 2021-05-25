package d.a.t.a.a;

import android.content.Context;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.android.imsdk.upload.action.track.Connection;
import com.baidu.android.imsdk.upload.action.track.Request;
/* loaded from: classes2.dex */
public class e {

    /* loaded from: classes2.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IMPushPb.ActionType f64531e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f64532f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Object f64533g;

        public a(IMPushPb.ActionType actionType, Context context, Object obj) {
            this.f64531e = actionType;
            this.f64532f = context;
            this.f64533g = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2 = b.f64534a[this.f64531e.ordinal()];
            if (i2 == 1) {
                f.f(this.f64532f, (Connection) this.f64533g);
            } else if (i2 != 2) {
            } else {
                f.g(this.f64532f, (Request) this.f64533g);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f64534a;

        static {
            int[] iArr = new int[IMPushPb.ActionType.values().length];
            f64534a = iArr;
            try {
                iArr[IMPushPb.ActionType.CONNECTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f64534a[IMPushPb.ActionType.REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public Context f64535a;

        /* renamed from: b  reason: collision with root package name */
        public Request f64536b;

        public c(Context context) {
            Request request = new Request();
            this.f64536b = request;
            this.f64535a = context;
            request.method = "";
            request.requestId = "";
            request.timestamp = -1L;
            request.responseTime = -1L;
            request.errorCode = -1L;
            request.ext = "";
            request.aliasId = -1L;
        }

        public c a(long j) {
            this.f64536b.aliasId = j;
            return this;
        }

        public void b() {
            e.b(this.f64535a, IMPushPb.ActionType.REQUEST, this.f64536b);
        }

        public c c(long j) {
            this.f64536b.errorCode = j;
            return this;
        }

        public c d(String str) {
            this.f64536b.ext = str;
            return this;
        }

        public c e(String str) {
            this.f64536b.method = str;
            return this;
        }

        public c f(String str) {
            this.f64536b.requestId = str;
            return this;
        }
    }

    public static void b(Context context, IMPushPb.ActionType actionType, Object obj) {
        Context applicationContext = context.getApplicationContext();
        if (g.f(applicationContext)) {
            d.a.t.a.g.a.a(applicationContext).b(new a(actionType, applicationContext, obj));
        }
    }
}
