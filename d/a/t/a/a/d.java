package d.a.t.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.upload.action.IMPushUploadManager;
import com.baidu.android.imsdk.upload.action.IMPushUploadResponseListener;
import com.baidu.android.imsdk.upload.utils.RequsetNetworkUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: c  reason: collision with root package name */
    public static volatile d f68235c;

    /* renamed from: d  reason: collision with root package name */
    public static AtomicBoolean f68236d = new AtomicBoolean(false);

    /* renamed from: a  reason: collision with root package name */
    public d.a.t.a.a.a f68237a;

    /* renamed from: b  reason: collision with root package name */
    public f f68238b = new f();

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f68239e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f68240f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f68241g;

        public a(Context context, String str, int i2) {
            this.f68239e = context;
            this.f68240f = str;
            this.f68241g = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.j(this.f68239e, this.f68240f, this.f68241g);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements IMPushUploadResponseListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f68243a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f68244b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f68245c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f68246d;

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                d.this.g(bVar.f68243a, bVar.f68244b, bVar.f68245c, bVar.f68246d);
            }
        }

        public b(Context context, String str, List list, int i2) {
            this.f68243a = context;
            this.f68244b = str;
            this.f68245c = list;
            this.f68246d = i2;
        }

        @Override // com.baidu.android.imsdk.upload.action.IMPushUploadResponseListener
        public void uploadResponse(int i2, String str) {
            d.f68236d.set(false);
            if (i2 == 0) {
                d.this.f68237a.f().execute(new a());
            }
        }
    }

    public d(Context context) {
        this.f68237a = d.a.t.a.a.a.h(context);
    }

    public static d h(Context context) {
        if (f68235c == null) {
            synchronized (d.class) {
                if (f68235c == null) {
                    f68235c = new d(context);
                }
            }
        }
        return f68235c;
    }

    public static Boolean i() {
        return Boolean.valueOf(f68236d.get());
    }

    public synchronized void e(Context context, String str, int i2) {
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (!TextUtils.isEmpty(str) && context != null && RequsetNetworkUtils.isConnected(context) && g.f(context) && g.e(context, Integer.parseInt(str))) {
            if (this.f68237a != null) {
                this.f68237a.f().execute(new a(context, str, i2));
            }
            return;
        }
        d.a.t.a.h.e.a("FlowTrackManager", "flow 无网、参数不对、未命中小流量不上报");
    }

    public void f() {
        d.a.t.a.a.a aVar = this.f68237a;
        if (aVar != null) {
            aVar.c();
        }
    }

    public final void g(Context context, String str, List<h> list, int i2) {
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (h hVar : list) {
            if (hVar != null) {
                arrayList.add(hVar.b());
            }
        }
        d.a.t.a.h.e.a("FlowTrackManager", "flow clear上报成功的数据");
        d.a.t.a.d.a.i(context).d(str, arrayList);
        if (d.a.t.a.d.a.i(context).h(str) > 0) {
            j(context, str, i2);
        }
    }

    public final void j(Context context, String str, int i2) {
        d.a.t.a.h.e.a("FlowTrackManager", "flow begin uplodFlow~~~");
        f68236d.set(true);
        ArrayList arrayList = new ArrayList();
        f fVar = this.f68238b;
        if (fVar != null) {
            byte[] c2 = fVar.c(context, str, arrayList, i2);
            if (c2 != null && arrayList.size() > 0) {
                if (c2.length >= 307200) {
                    d.a.t.a.h.e.a("FlowTrackManager", "flow 上报数据长度超过300k");
                    f68236d.set(false);
                    return;
                }
                IMPushUploadManager.getInstance(context).requestUpload(null, c2, "", new b(context, str, arrayList, i2));
                return;
            }
            d.a.t.a.h.e.a("FlowTrackManager", "flow 上报数据为空");
            f68236d.set(false);
        }
    }
}
