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
    public static volatile d f68317c;

    /* renamed from: d  reason: collision with root package name */
    public static AtomicBoolean f68318d = new AtomicBoolean(false);

    /* renamed from: a  reason: collision with root package name */
    public d.a.t.a.a.a f68319a;

    /* renamed from: b  reason: collision with root package name */
    public f f68320b = new f();

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f68321e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f68322f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f68323g;

        public a(Context context, String str, int i2) {
            this.f68321e = context;
            this.f68322f = str;
            this.f68323g = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.j(this.f68321e, this.f68322f, this.f68323g);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements IMPushUploadResponseListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f68325a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f68326b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f68327c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f68328d;

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                d.this.g(bVar.f68325a, bVar.f68326b, bVar.f68327c, bVar.f68328d);
            }
        }

        public b(Context context, String str, List list, int i2) {
            this.f68325a = context;
            this.f68326b = str;
            this.f68327c = list;
            this.f68328d = i2;
        }

        @Override // com.baidu.android.imsdk.upload.action.IMPushUploadResponseListener
        public void uploadResponse(int i2, String str) {
            d.f68318d.set(false);
            if (i2 == 0) {
                d.this.f68319a.f().execute(new a());
            }
        }
    }

    public d(Context context) {
        this.f68319a = d.a.t.a.a.a.h(context);
    }

    public static d h(Context context) {
        if (f68317c == null) {
            synchronized (d.class) {
                if (f68317c == null) {
                    f68317c = new d(context);
                }
            }
        }
        return f68317c;
    }

    public static Boolean i() {
        return Boolean.valueOf(f68318d.get());
    }

    public synchronized void e(Context context, String str, int i2) {
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (!TextUtils.isEmpty(str) && context != null && RequsetNetworkUtils.isConnected(context) && g.f(context) && g.e(context, Integer.parseInt(str))) {
            if (this.f68319a != null) {
                this.f68319a.f().execute(new a(context, str, i2));
            }
            return;
        }
        d.a.t.a.h.e.a("FlowTrackManager", "flow 无网、参数不对、未命中小流量不上报");
    }

    public void f() {
        d.a.t.a.a.a aVar = this.f68319a;
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
        f68318d.set(true);
        ArrayList arrayList = new ArrayList();
        f fVar = this.f68320b;
        if (fVar != null) {
            byte[] c2 = fVar.c(context, str, arrayList, i2);
            if (c2 != null && arrayList.size() > 0) {
                if (c2.length >= 307200) {
                    d.a.t.a.h.e.a("FlowTrackManager", "flow 上报数据长度超过300k");
                    f68318d.set(false);
                    return;
                }
                IMPushUploadManager.getInstance(context).requestUpload(null, c2, "", new b(context, str, arrayList, i2));
                return;
            }
            d.a.t.a.h.e.a("FlowTrackManager", "flow 上报数据为空");
            f68318d.set(false);
        }
    }
}
