package d.a.s.a.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.upload.action.IMPushUploadManager;
import com.baidu.android.imsdk.upload.action.IMPushUploadResponseListener;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.android.imsdk.upload.utils.RequsetNetworkUtils;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f64534a;

    /* loaded from: classes2.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f64535e;

        public a(Context context) {
            this.f64535e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.i(this.f64535e);
        }
    }

    /* renamed from: d.a.s.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1799b implements IMPushUploadResponseListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f64536a;

        public C1799b(Context context) {
            this.f64536a = context;
        }

        @Override // com.baidu.android.imsdk.upload.action.IMPushUploadResponseListener
        public void uploadResponse(int i2, String str) {
            d.a.s.a.g.d.a("LcpTrackManager", "uploadIMData response :" + i2 + ", msg :" + str);
            d.a.s.a.a.d.r(this.f64536a);
            if (i2 == 0) {
                b.g(this.f64536a);
                int unused = b.f64534a = 0;
                return;
            }
            int i3 = 1;
            if (b.f64534a < 1) {
                b.i(this.f64536a);
                b.e();
                return;
            }
            int unused2 = b.f64534a = 0;
            int h2 = d.a.s.a.a.d.h(this.f64536a);
            if (h2 >= 3) {
                b.g(this.f64536a);
            } else {
                i3 = 1 + h2;
            }
            d.a.s.a.a.d.q(this.f64536a, i3);
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f64537e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ IMPushPb.Action f64538f;

        public c(Context context, IMPushPb.Action action) {
            this.f64537e = context;
            this.f64538f = action;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.h(this.f64537e, this.f64538f);
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements IMPushUploadResponseListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f64539a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ byte[] f64540b;

        public d(Context context, byte[] bArr) {
            this.f64539a = context;
            this.f64540b = bArr;
        }

        @Override // com.baidu.android.imsdk.upload.action.IMPushUploadResponseListener
        public void uploadResponse(int i2, String str) {
            d.a.s.a.g.d.a("LcpTrackManager", "uploadInitData response :" + i2 + ", msg :" + str);
            if (i2 != 0) {
                IMPushUploadManager.getInstance(this.f64539a).requestUpload(null, this.f64540b, "", null);
            }
        }
    }

    public static /* synthetic */ int e() {
        int i2 = f64534a;
        f64534a = i2 + 1;
        return i2;
    }

    public static void g(Context context) {
        d.a.s.a.a.d.b(context);
        f64534a = 0;
    }

    public static void h(Context context, @NonNull IMPushPb.Action action) {
        byte[] a2 = new d.a.s.a.a.c().a(context, action);
        if (a2 == null || a2.length >= 307200) {
            return;
        }
        IMPushUploadManager.getInstance(context).requestUpload(null, a2, "", new d(context, a2));
    }

    public static void i(Context context) {
        byte[] c2 = new d.a.s.a.a.c().c(context);
        StringBuilder sb = new StringBuilder();
        sb.append("RequestUpload payload.length = ");
        sb.append(c2 != null ? c2.length : 0);
        d.a.s.a.g.d.a("LcpTrackManager", sb.toString());
        if (c2 != null && c2.length < 307200 && c2.length > 0) {
            d.a.s.a.g.d.a("LcpTrackManager", "requestUpload begin");
            IMPushUploadManager.getInstance(context).requestUpload(null, c2, "", new C1799b(context));
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("RequestUpload payload.length = ");
        sb2.append(c2 != null ? c2.length : 0);
        sb2.append(", clear datas and no upload.");
        d.a.s.a.g.d.a("LcpTrackManager", sb2.toString());
        g(context);
    }

    public static void j(Context context, @NonNull IMPushPb.Action action) {
        if (context == null || !RequsetNetworkUtils.isConnected(context)) {
            return;
        }
        d.a.s.a.f.a.a(context).b(new c(context, action));
    }

    public static void k(Context context) {
        if (context != null && RequsetNetworkUtils.isConnected(context) && d.a.s.a.a.d.k(context) && d.a.s.a.a.d.j(context)) {
            d.a.s.a.f.a.a(context).b(new a(context));
        } else {
            d.a.s.a.g.d.b("LcpTrackManager", "uploadTrackActionData return");
        }
    }
}
