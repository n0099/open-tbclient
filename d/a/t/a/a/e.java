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
        public final /* synthetic */ IMPushPb.ActionType f68249e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f68250f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Object f68251g;

        public a(IMPushPb.ActionType actionType, Context context, Object obj) {
            this.f68249e = actionType;
            this.f68250f = context;
            this.f68251g = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2 = b.f68252a[this.f68249e.ordinal()];
            if (i2 == 1) {
                f.f(this.f68250f, (Connection) this.f68251g);
            } else if (i2 != 2) {
            } else {
                f.g(this.f68250f, (Request) this.f68251g);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f68252a;

        static {
            int[] iArr = new int[IMPushPb.ActionType.values().length];
            f68252a = iArr;
            try {
                iArr[IMPushPb.ActionType.CONNECTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f68252a[IMPushPb.ActionType.REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public Context f68253a;

        /* renamed from: b  reason: collision with root package name */
        public Request f68254b;

        public c(Context context) {
            Request request = new Request();
            this.f68254b = request;
            this.f68253a = context;
            request.method = "";
            request.requestId = "";
            request.timestamp = -1L;
            request.responseTime = -1L;
            request.errorCode = -1L;
            request.ext = "";
            request.aliasId = -1L;
        }

        public c a(long j) {
            this.f68254b.aliasId = j;
            return this;
        }

        public void b() {
            e.b(this.f68253a, IMPushPb.ActionType.REQUEST, this.f68254b);
        }

        public c c(long j) {
            this.f68254b.errorCode = j;
            return this;
        }

        public c d(String str) {
            this.f68254b.ext = str;
            return this;
        }

        public c e(String str) {
            this.f68254b.method = str;
            return this;
        }

        public c f(String str) {
            this.f68254b.requestId = str;
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
