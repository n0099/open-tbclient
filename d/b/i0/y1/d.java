package d.b.i0.y1;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.tieba.faceshop.UserCollectModel;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import com.baidu.tieba.newfaceshop.NewFaceSyncDownloadModel;
import com.baidu.tieba.newfaceshop.NewFaceSyncUploadModel;
import com.baidu.tieba.newfaceshop.message.GetCloudFaceGroupMessage;
import d.b.c.e.p.l;
import d.b.i0.l0.u;
import d.b.i0.l0.w;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: g  reason: collision with root package name */
    public static volatile d f64035g;

    /* renamed from: a  reason: collision with root package name */
    public NewFaceSyncUploadModel f64036a = new NewFaceSyncUploadModel();

    /* renamed from: b  reason: collision with root package name */
    public NewFaceSyncDownloadModel f64037b = new NewFaceSyncDownloadModel();

    /* renamed from: c  reason: collision with root package name */
    public NewFaceGroupDownloadModel f64038c = new NewFaceGroupDownloadModel();

    /* renamed from: d  reason: collision with root package name */
    public w f64039d = new w();

    /* renamed from: e  reason: collision with root package name */
    public boolean f64040e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f64041f;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            List<MyEmotionGroupData> f2 = d.b.i0.y1.c.i().f();
            if (f2 == null) {
                return;
            }
            if (f2.isEmpty()) {
                str = UserCollectModel.ALL_DELETE;
            } else {
                StringBuilder sb = new StringBuilder();
                int i = 0;
                for (int i2 = 0; i2 < f2.size() && i < 30; i2++) {
                    MyEmotionGroupData myEmotionGroupData = f2.get(i2);
                    if (myEmotionGroupData != null) {
                        sb.append(myEmotionGroupData.getGroupId());
                        if (i2 < f2.size() - 1) {
                            sb.append("_");
                        }
                        i++;
                    }
                }
                str = sb.toString();
            }
            d.this.f64036a.s(str);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.i0.y1.e.a {

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ GetCloudFaceGroupMessage f64044e;

            public a(GetCloudFaceGroupMessage getCloudFaceGroupMessage) {
                this.f64044e = getCloudFaceGroupMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f64039d.f(this.f64044e.getCollectEmotionList());
            }
        }

        public b() {
        }

        @Override // d.b.i0.y1.e.a
        public void a(GetCloudFaceGroupMessage getCloudFaceGroupMessage) {
            if (getCloudFaceGroupMessage == null) {
                d.this.f64041f = false;
                d.this.f64040e = false;
                return;
            }
            if (getCloudFaceGroupMessage.getCollectUpdateTime() <= d.k()) {
                d.this.f64041f = false;
                if (getCloudFaceGroupMessage.getCollectUpdateTime() < d.k()) {
                    new UserCollectModel().s();
                }
                u.s().n();
            } else if (getCloudFaceGroupMessage.getCollectEmotionList() == null) {
                d.this.f64041f = false;
            } else {
                d.b.i0.y1.a.b().a(new a(getCloudFaceGroupMessage));
            }
            if (getCloudFaceGroupMessage.getFaceGroupUpdateTime() <= d.l()) {
                d.this.f64040e = false;
                if (getCloudFaceGroupMessage.getFaceGroupUpdateTime() < d.l()) {
                    d.this.w();
                }
                d.b.i0.y1.c.i().e();
            } else if (getCloudFaceGroupMessage.getFaceGroupData() != null) {
                d.this.p(getCloudFaceGroupMessage.getFaceGroupData());
            } else {
                d.this.f64040e = false;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f64046e;

        public c(List list) {
            this.f64046e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.i0.y1.c.i().b(true);
            List<MyEmotionGroupData> f2 = d.b.i0.y1.c.i().f();
            ArrayList arrayList = new ArrayList();
            if (f2 != null) {
                for (MyEmotionGroupData myEmotionGroupData : f2) {
                    arrayList.add(myEmotionGroupData.getGroupId());
                }
            }
            d.this.h(this.f64046e, arrayList);
        }
    }

    /* renamed from: d.b.i0.y1.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1720d implements d.b.i0.y1.e.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f64048a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f64049b;

        public C1720d(AtomicInteger atomicInteger, List list) {
            this.f64048a = atomicInteger;
            this.f64049b = list;
        }

        @Override // d.b.i0.y1.e.b
        public void onFail(String str) {
            if (this.f64048a.decrementAndGet() == 0) {
                d.this.q(this.f64049b);
            }
        }

        @Override // d.b.i0.y1.e.b
        public void onProgress(int i) {
        }

        @Override // d.b.i0.y1.e.b
        public void onSuccess(String str) {
            if (this.f64048a.decrementAndGet() == 0) {
                d.this.q(this.f64049b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f64051e;

        public e(List list) {
            this.f64051e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.q(this.f64051e);
        }
    }

    public static String j() {
        return TbadkCoreApplication.getCurrentAccount() == null ? "" : String.valueOf(Math.abs(TbadkCoreApplication.getCurrentAccount().hashCode()));
    }

    public static long k() {
        d.b.h0.r.d0.b j = d.b.h0.r.d0.b.j();
        return j.l("face_collect_update_time" + j(), 0L);
    }

    public static long l() {
        d.b.h0.r.d0.b j = d.b.h0.r.d0.b.j();
        return j.l("face_group_update_time" + j(), 0L);
    }

    public static d m() {
        if (f64035g == null) {
            synchronized (d.class) {
                if (f64035g == null) {
                    f64035g = new d();
                }
            }
        }
        return f64035g;
    }

    public static void s(long j) {
        d.b.h0.r.d0.b j2 = d.b.h0.r.d0.b.j();
        j2.w("face_collect_update_time" + j(), j);
    }

    public static void t(long j) {
        d.b.h0.r.d0.b j2 = d.b.h0.r.d0.b.j();
        j2.w("face_group_update_time" + j(), j);
    }

    public final void h(List<String> list, List<String> list2) {
        if (list2 != null) {
            ArrayList arrayList = new ArrayList();
            for (String str : list2) {
                if (!TextUtils.isEmpty(str) && !list.contains(str)) {
                    arrayList.add(str);
                }
            }
            if (!arrayList.isEmpty()) {
                d.b.i0.y1.c.i().c(arrayList, false);
            }
        }
        i(list, list2);
    }

    public final void i(List<String> list, List<String> list2) {
        if (list != null && !list.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList();
            for (String str : list) {
                if (!list2.contains(str)) {
                    arrayList.add(str);
                }
            }
            if (!arrayList.isEmpty()) {
                AtomicInteger atomicInteger = new AtomicInteger(arrayList.size());
                for (String str2 : arrayList) {
                    this.f64038c.s(str2, Boolean.FALSE, new C1720d(atomicInteger, list));
                }
                return;
            }
            r(list);
            return;
        }
        this.f64040e = false;
    }

    public boolean n() {
        return this.f64041f;
    }

    public boolean o() {
        return this.f64040e;
    }

    public final void p(List<String> list) {
        d.b.i0.y1.a.b().a(new c(list));
    }

    public final void q(List<String> list) {
        if (d.b.i0.y1.c.i().j(list, false)) {
            t(System.currentTimeMillis());
        }
        this.f64040e = false;
    }

    public final void r(List<String> list) {
        if (l.B()) {
            d.b.i0.y1.a.b().a(new e(list));
        } else {
            q(list);
        }
    }

    public void u(boolean z) {
        this.f64041f = z;
    }

    public void v() {
        this.f64040e = true;
        this.f64041f = true;
        this.f64037b.s(new b());
    }

    public void w() {
        d.b.i0.y1.a.b().a(new a());
    }
}
