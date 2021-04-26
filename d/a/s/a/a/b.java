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
    public static int f63847a;

    /* loaded from: classes2.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f63848e;

        public a(Context context) {
            this.f63848e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.i(this.f63848e);
        }
    }

    /* renamed from: d.a.s.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1735b implements IMPushUploadResponseListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f63849a;

        public C1735b(Context context) {
            this.f63849a = context;
        }

        @Override // com.baidu.android.imsdk.upload.action.IMPushUploadResponseListener
        public void uploadResponse(int i2, String str) {
            d.a.s.a.g.d.a("LcpTrackManager", "uploadIMData response :" + i2 + ", msg :" + str);
            d.a.s.a.a.d.r(this.f63849a);
            if (i2 == 0) {
                b.g(this.f63849a);
                int unused = b.f63847a = 0;
                return;
            }
            int i3 = 1;
            if (b.f63847a < 1) {
                b.i(this.f63849a);
                b.e();
                return;
            }
            int unused2 = b.f63847a = 0;
            int h2 = d.a.s.a.a.d.h(this.f63849a);
            if (h2 >= 3) {
                b.g(this.f63849a);
            } else {
                i3 = 1 + h2;
            }
            d.a.s.a.a.d.q(this.f63849a, i3);
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f63850e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ IMPushPb.Action f63851f;

        public c(Context context, IMPushPb.Action action) {
            this.f63850e = context;
            this.f63851f = action;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.h(this.f63850e, this.f63851f);
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements IMPushUploadResponseListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f63852a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ byte[] f63853b;

        public d(Context context, byte[] bArr) {
            this.f63852a = context;
            this.f63853b = bArr;
        }

        @Override // com.baidu.android.imsdk.upload.action.IMPushUploadResponseListener
        public void uploadResponse(int i2, String str) {
            d.a.s.a.g.d.a("LcpTrackManager", "uploadInitData response :" + i2 + ", msg :" + str);
            if (i2 != 0) {
                IMPushUploadManager.getInstance(this.f63852a).requestUpload(null, this.f63853b, "", null);
            }
        }
    }

    public static /* synthetic */ int e() {
        int i2 = f63847a;
        f63847a = i2 + 1;
        return i2;
    }

    public static void g(Context context) {
        d.a.s.a.a.d.b(context);
        f63847a = 0;
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
            IMPushUploadManager.getInstance(context).requestUpload(null, c2, "", new C1735b(context));
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
