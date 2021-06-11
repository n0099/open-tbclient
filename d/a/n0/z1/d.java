package d.a.n0.z1;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.tieba.faceshop.UserCollectModel;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import com.baidu.tieba.newfaceshop.NewFaceSyncDownloadModel;
import com.baidu.tieba.newfaceshop.NewFaceSyncUploadModel;
import com.baidu.tieba.newfaceshop.message.GetCloudFaceGroupMessage;
import d.a.c.e.p.l;
import d.a.n0.m0.u;
import d.a.n0.m0.w;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: g  reason: collision with root package name */
    public static volatile d f67337g;

    /* renamed from: a  reason: collision with root package name */
    public NewFaceSyncUploadModel f67338a = new NewFaceSyncUploadModel();

    /* renamed from: b  reason: collision with root package name */
    public NewFaceSyncDownloadModel f67339b = new NewFaceSyncDownloadModel();

    /* renamed from: c  reason: collision with root package name */
    public NewFaceGroupDownloadModel f67340c = new NewFaceGroupDownloadModel();

    /* renamed from: d  reason: collision with root package name */
    public w f67341d = new w();

    /* renamed from: e  reason: collision with root package name */
    public boolean f67342e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f67343f;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            List<MyEmotionGroupData> f2 = d.a.n0.z1.c.i().f();
            if (f2 == null) {
                return;
            }
            if (f2.isEmpty()) {
                str = UserCollectModel.ALL_DELETE;
            } else {
                StringBuilder sb = new StringBuilder();
                int i2 = 0;
                for (int i3 = 0; i3 < f2.size() && i2 < 30; i3++) {
                    MyEmotionGroupData myEmotionGroupData = f2.get(i3);
                    if (myEmotionGroupData != null) {
                        sb.append(myEmotionGroupData.getGroupId());
                        if (i3 < f2.size() - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                str = sb.toString();
            }
            d.this.f67338a.w(str);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.n0.z1.e.a {

        /* loaded from: classes4.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ GetCloudFaceGroupMessage f67346e;

            public a(GetCloudFaceGroupMessage getCloudFaceGroupMessage) {
                this.f67346e = getCloudFaceGroupMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f67341d.f(this.f67346e.getCollectEmotionList());
            }
        }

        public b() {
        }

        @Override // d.a.n0.z1.e.a
        public void a(GetCloudFaceGroupMessage getCloudFaceGroupMessage) {
            if (getCloudFaceGroupMessage == null) {
                d.this.f67343f = false;
                d.this.f67342e = false;
                return;
            }
            if (getCloudFaceGroupMessage.getCollectUpdateTime() <= d.k()) {
                d.this.f67343f = false;
                if (getCloudFaceGroupMessage.getCollectUpdateTime() < d.k()) {
                    new UserCollectModel().w();
                }
                u.s().n();
            } else if (getCloudFaceGroupMessage.getCollectEmotionList() == null) {
                d.this.f67343f = false;
            } else {
                d.a.n0.z1.a.b().a(new a(getCloudFaceGroupMessage));
            }
            if (getCloudFaceGroupMessage.getFaceGroupUpdateTime() <= d.l()) {
                d.this.f67342e = false;
                if (getCloudFaceGroupMessage.getFaceGroupUpdateTime() < d.l()) {
                    d.this.w();
                }
                d.a.n0.z1.c.i().e();
            } else if (getCloudFaceGroupMessage.getFaceGroupData() != null) {
                d.this.p(getCloudFaceGroupMessage.getFaceGroupData());
            } else {
                d.this.f67342e = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f67348e;

        public c(List list) {
            this.f67348e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.n0.z1.c.i().b(true);
            List<MyEmotionGroupData> f2 = d.a.n0.z1.c.i().f();
            ArrayList arrayList = new ArrayList();
            if (f2 != null) {
                for (MyEmotionGroupData myEmotionGroupData : f2) {
                    arrayList.add(myEmotionGroupData.getGroupId());
                }
            }
            d.this.h(this.f67348e, arrayList);
        }
    }

    /* renamed from: d.a.n0.z1.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1818d implements d.a.n0.z1.e.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f67350a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f67351b;

        public C1818d(AtomicInteger atomicInteger, List list) {
            this.f67350a = atomicInteger;
            this.f67351b = list;
        }

        @Override // d.a.n0.z1.e.b
        public void onFail(String str) {
            if (this.f67350a.decrementAndGet() == 0) {
                d.this.q(this.f67351b);
            }
        }

        @Override // d.a.n0.z1.e.b
        public void onProgress(int i2) {
        }

        @Override // d.a.n0.z1.e.b
        public void onSuccess(String str) {
            if (this.f67350a.decrementAndGet() == 0) {
                d.this.q(this.f67351b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f67353e;

        public e(List list) {
            this.f67353e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.q(this.f67353e);
        }
    }

    public static String j() {
        return TbadkCoreApplication.getCurrentAccount() == null ? "" : String.valueOf(Math.abs(TbadkCoreApplication.getCurrentAccount().hashCode()));
    }

    public static long k() {
        d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
        return j.l("face_collect_update_time" + j(), 0L);
    }

    public static long l() {
        d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
        return j.l("face_group_update_time" + j(), 0L);
    }

    public static d m() {
        if (f67337g == null) {
            synchronized (d.class) {
                if (f67337g == null) {
                    f67337g = new d();
                }
            }
        }
        return f67337g;
    }

    public static void s(long j) {
        d.a.m0.r.d0.b j2 = d.a.m0.r.d0.b.j();
        j2.w("face_collect_update_time" + j(), j);
    }

    public static void t(long j) {
        d.a.m0.r.d0.b j2 = d.a.m0.r.d0.b.j();
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
                d.a.n0.z1.c.i().c(arrayList, false);
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
                    this.f67340c.w(str2, Boolean.FALSE, new C1818d(atomicInteger, list));
                }
                return;
            }
            r(list);
            return;
        }
        this.f67342e = false;
    }

    public boolean n() {
        return this.f67343f;
    }

    public boolean o() {
        return this.f67342e;
    }

    public final void p(List<String> list) {
        d.a.n0.z1.a.b().a(new c(list));
    }

    public final void q(List<String> list) {
        if (d.a.n0.z1.c.i().j(list, false)) {
            t(System.currentTimeMillis());
        }
        this.f67342e = false;
    }

    public final void r(List<String> list) {
        if (l.C()) {
            d.a.n0.z1.a.b().a(new e(list));
        } else {
            q(list);
        }
    }

    public void u(boolean z) {
        this.f67343f = z;
    }

    public void v() {
        this.f67342e = true;
        this.f67343f = true;
        this.f67339b.w(new b());
    }

    public void w() {
        d.a.n0.z1.a.b().a(new a());
    }
}
