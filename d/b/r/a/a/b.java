package d.b.r.a.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.upload.action.IMPushUploadManager;
import com.baidu.android.imsdk.upload.action.IMPushUploadResponseListener;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.android.imsdk.upload.utils.RequsetNetworkUtils;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f65262a;

    /* loaded from: classes2.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f65263e;

        public a(Context context) {
            this.f65263e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.i(this.f65263e);
        }
    }

    /* renamed from: d.b.r.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1778b implements IMPushUploadResponseListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f65264a;

        public C1778b(Context context) {
            this.f65264a = context;
        }

        @Override // com.baidu.android.imsdk.upload.action.IMPushUploadResponseListener
        public void uploadResponse(int i, String str) {
            d.b.r.a.g.d.a("LcpTrackManager", "uploadIMData response :" + i + ", msg :" + str);
            d.b.r.a.a.d.r(this.f65264a);
            if (i == 0) {
                b.g(this.f65264a);
                int unused = b.f65262a = 0;
                return;
            }
            int i2 = 1;
            if (b.f65262a < 1) {
                b.i(this.f65264a);
                b.e();
                return;
            }
            int unused2 = b.f65262a = 0;
            int h2 = d.b.r.a.a.d.h(this.f65264a);
            if (h2 >= 3) {
                b.g(this.f65264a);
            } else {
                i2 = 1 + h2;
            }
            d.b.r.a.a.d.q(this.f65264a, i2);
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f65265e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ IMPushPb.Action f65266f;

        public c(Context context, IMPushPb.Action action) {
            this.f65265e = context;
            this.f65266f = action;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.h(this.f65265e, this.f65266f);
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements IMPushUploadResponseListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f65267a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ byte[] f65268b;

        public d(Context context, byte[] bArr) {
            this.f65267a = context;
            this.f65268b = bArr;
        }

        @Override // com.baidu.android.imsdk.upload.action.IMPushUploadResponseListener
        public void uploadResponse(int i, String str) {
            d.b.r.a.g.d.a("LcpTrackManager", "uploadInitData response :" + i + ", msg :" + str);
            if (i != 0) {
                IMPushUploadManager.getInstance(this.f65267a).requestUpload(null, this.f65268b, "", null);
            }
        }
    }

    public static /* synthetic */ int e() {
        int i = f65262a;
        f65262a = i + 1;
        return i;
    }

    public static void g(Context context) {
        d.b.r.a.a.d.b(context);
        f65262a = 0;
    }

    public static void h(Context context, @NonNull IMPushPb.Action action) {
        byte[] a2 = new d.b.r.a.a.c().a(context, action);
        if (a2 == null || a2.length >= 307200) {
            return;
        }
        IMPushUploadManager.getInstance(context).requestUpload(null, a2, "", new d(context, a2));
    }

    public static void i(Context context) {
        byte[] c2 = new d.b.r.a.a.c().c(context);
        StringBuilder sb = new StringBuilder();
        sb.append("RequestUpload payload.length = ");
        sb.append(c2 != null ? c2.length : 0);
        d.b.r.a.g.d.a("LcpTrackManager", sb.toString());
        if (c2 != null && c2.length < 307200 && c2.length > 0) {
            d.b.r.a.g.d.a("LcpTrackManager", "requestUpload begin");
            IMPushUploadManager.getInstance(context).requestUpload(null, c2, "", new C1778b(context));
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("RequestUpload payload.length = ");
        sb2.append(c2 != null ? c2.length : 0);
        sb2.append(", clear datas and no upload.");
        d.b.r.a.g.d.a("LcpTrackManager", sb2.toString());
        g(context);
    }

    public static void j(Context context, @NonNull IMPushPb.Action action) {
        if (context == null || !RequsetNetworkUtils.isConnected(context)) {
            return;
        }
        d.b.r.a.f.a.a(context).b(new c(context, action));
    }

    public static void k(Context context) {
        if (context != null && RequsetNetworkUtils.isConnected(context) && d.b.r.a.a.d.k(context) && d.b.r.a.a.d.j(context)) {
            d.b.r.a.f.a.a(context).b(new a(context));
        } else {
            d.b.r.a.g.d.b("LcpTrackManager", "uploadTrackActionData return");
        }
    }
}
