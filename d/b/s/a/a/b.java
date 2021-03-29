package d.b.s.a.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.upload.action.IMPushUploadManager;
import com.baidu.android.imsdk.upload.action.IMPushUploadResponseListener;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.android.imsdk.upload.utils.RequsetNetworkUtils;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f64568a;

    /* loaded from: classes2.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f64569e;

        public a(Context context) {
            this.f64569e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.i(this.f64569e);
        }
    }

    /* renamed from: d.b.s.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1766b implements IMPushUploadResponseListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f64570a;

        public C1766b(Context context) {
            this.f64570a = context;
        }

        @Override // com.baidu.android.imsdk.upload.action.IMPushUploadResponseListener
        public void uploadResponse(int i, String str) {
            d.b.s.a.g.d.a("LcpTrackManager", "uploadIMData response :" + i + ", msg :" + str);
            d.b.s.a.a.d.r(this.f64570a);
            if (i == 0) {
                b.g(this.f64570a);
                int unused = b.f64568a = 0;
                return;
            }
            int i2 = 1;
            if (b.f64568a < 1) {
                b.i(this.f64570a);
                b.e();
                return;
            }
            int unused2 = b.f64568a = 0;
            int h2 = d.b.s.a.a.d.h(this.f64570a);
            if (h2 >= 3) {
                b.g(this.f64570a);
            } else {
                i2 = 1 + h2;
            }
            d.b.s.a.a.d.q(this.f64570a, i2);
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f64571e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ IMPushPb.Action f64572f;

        public c(Context context, IMPushPb.Action action) {
            this.f64571e = context;
            this.f64572f = action;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.h(this.f64571e, this.f64572f);
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements IMPushUploadResponseListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f64573a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ byte[] f64574b;

        public d(Context context, byte[] bArr) {
            this.f64573a = context;
            this.f64574b = bArr;
        }

        @Override // com.baidu.android.imsdk.upload.action.IMPushUploadResponseListener
        public void uploadResponse(int i, String str) {
            d.b.s.a.g.d.a("LcpTrackManager", "uploadInitData response :" + i + ", msg :" + str);
            if (i != 0) {
                IMPushUploadManager.getInstance(this.f64573a).requestUpload(null, this.f64574b, "", null);
            }
        }
    }

    public static /* synthetic */ int e() {
        int i = f64568a;
        f64568a = i + 1;
        return i;
    }

    public static void g(Context context) {
        d.b.s.a.a.d.b(context);
        f64568a = 0;
    }

    public static void h(Context context, @NonNull IMPushPb.Action action) {
        byte[] a2 = new d.b.s.a.a.c().a(context, action);
        if (a2 == null || a2.length >= 307200) {
            return;
        }
        IMPushUploadManager.getInstance(context).requestUpload(null, a2, "", new d(context, a2));
    }

    public static void i(Context context) {
        byte[] c2 = new d.b.s.a.a.c().c(context);
        StringBuilder sb = new StringBuilder();
        sb.append("RequestUpload payload.length = ");
        sb.append(c2 != null ? c2.length : 0);
        d.b.s.a.g.d.a("LcpTrackManager", sb.toString());
        if (c2 != null && c2.length < 307200 && c2.length > 0) {
            d.b.s.a.g.d.a("LcpTrackManager", "requestUpload begin");
            IMPushUploadManager.getInstance(context).requestUpload(null, c2, "", new C1766b(context));
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("RequestUpload payload.length = ");
        sb2.append(c2 != null ? c2.length : 0);
        sb2.append(", clear datas and no upload.");
        d.b.s.a.g.d.a("LcpTrackManager", sb2.toString());
        g(context);
    }

    public static void j(Context context, @NonNull IMPushPb.Action action) {
        if (context == null || !RequsetNetworkUtils.isConnected(context)) {
            return;
        }
        d.b.s.a.f.a.a(context).b(new c(context, action));
    }

    public static void k(Context context) {
        if (context != null && RequsetNetworkUtils.isConnected(context) && d.b.s.a.a.d.k(context) && d.b.s.a.a.d.j(context)) {
            d.b.s.a.f.a.a(context).b(new a(context));
        } else {
            d.b.s.a.g.d.b("LcpTrackManager", "uploadTrackActionData return");
        }
    }
}
