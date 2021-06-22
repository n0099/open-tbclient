package d.a.o0.z1;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.tieba.faceshop.UserCollectModel;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import com.baidu.tieba.newfaceshop.NewFaceSyncDownloadModel;
import com.baidu.tieba.newfaceshop.NewFaceSyncUploadModel;
import com.baidu.tieba.newfaceshop.message.GetCloudFaceGroupMessage;
import d.a.c.e.p.l;
import d.a.o0.m0.u;
import d.a.o0.m0.w;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: g  reason: collision with root package name */
    public static volatile d f67462g;

    /* renamed from: a  reason: collision with root package name */
    public NewFaceSyncUploadModel f67463a = new NewFaceSyncUploadModel();

    /* renamed from: b  reason: collision with root package name */
    public NewFaceSyncDownloadModel f67464b = new NewFaceSyncDownloadModel();

    /* renamed from: c  reason: collision with root package name */
    public NewFaceGroupDownloadModel f67465c = new NewFaceGroupDownloadModel();

    /* renamed from: d  reason: collision with root package name */
    public w f67466d = new w();

    /* renamed from: e  reason: collision with root package name */
    public boolean f67467e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f67468f;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            List<MyEmotionGroupData> f2 = d.a.o0.z1.c.i().f();
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
            d.this.f67463a.w(str);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d.a.o0.z1.e.a {

        /* loaded from: classes5.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ GetCloudFaceGroupMessage f67471e;

            public a(GetCloudFaceGroupMessage getCloudFaceGroupMessage) {
                this.f67471e = getCloudFaceGroupMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f67466d.f(this.f67471e.getCollectEmotionList());
            }
        }

        public b() {
        }

        @Override // d.a.o0.z1.e.a
        public void a(GetCloudFaceGroupMessage getCloudFaceGroupMessage) {
            if (getCloudFaceGroupMessage == null) {
                d.this.f67468f = false;
                d.this.f67467e = false;
                return;
            }
            if (getCloudFaceGroupMessage.getCollectUpdateTime() <= d.k()) {
                d.this.f67468f = false;
                if (getCloudFaceGroupMessage.getCollectUpdateTime() < d.k()) {
                    new UserCollectModel().w();
                }
                u.s().n();
            } else if (getCloudFaceGroupMessage.getCollectEmotionList() == null) {
                d.this.f67468f = false;
            } else {
                d.a.o0.z1.a.b().a(new a(getCloudFaceGroupMessage));
            }
            if (getCloudFaceGroupMessage.getFaceGroupUpdateTime() <= d.l()) {
                d.this.f67467e = false;
                if (getCloudFaceGroupMessage.getFaceGroupUpdateTime() < d.l()) {
                    d.this.w();
                }
                d.a.o0.z1.c.i().e();
            } else if (getCloudFaceGroupMessage.getFaceGroupData() != null) {
                d.this.p(getCloudFaceGroupMessage.getFaceGroupData());
            } else {
                d.this.f67467e = false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f67473e;

        public c(List list) {
            this.f67473e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.o0.z1.c.i().b(true);
            List<MyEmotionGroupData> f2 = d.a.o0.z1.c.i().f();
            ArrayList arrayList = new ArrayList();
            if (f2 != null) {
                for (MyEmotionGroupData myEmotionGroupData : f2) {
                    arrayList.add(myEmotionGroupData.getGroupId());
                }
            }
            d.this.h(this.f67473e, arrayList);
        }
    }

    /* renamed from: d.a.o0.z1.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1822d implements d.a.o0.z1.e.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f67475a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f67476b;

        public C1822d(AtomicInteger atomicInteger, List list) {
            this.f67475a = atomicInteger;
            this.f67476b = list;
        }

        @Override // d.a.o0.z1.e.b
        public void onFail(String str) {
            if (this.f67475a.decrementAndGet() == 0) {
                d.this.q(this.f67476b);
            }
        }

        @Override // d.a.o0.z1.e.b
        public void onProgress(int i2) {
        }

        @Override // d.a.o0.z1.e.b
        public void onSuccess(String str) {
            if (this.f67475a.decrementAndGet() == 0) {
                d.this.q(this.f67476b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f67478e;

        public e(List list) {
            this.f67478e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.q(this.f67478e);
        }
    }

    public static String j() {
        return TbadkCoreApplication.getCurrentAccount() == null ? "" : String.valueOf(Math.abs(TbadkCoreApplication.getCurrentAccount().hashCode()));
    }

    public static long k() {
        d.a.n0.r.d0.b j = d.a.n0.r.d0.b.j();
        return j.l("face_collect_update_time" + j(), 0L);
    }

    public static long l() {
        d.a.n0.r.d0.b j = d.a.n0.r.d0.b.j();
        return j.l("face_group_update_time" + j(), 0L);
    }

    public static d m() {
        if (f67462g == null) {
            synchronized (d.class) {
                if (f67462g == null) {
                    f67462g = new d();
                }
            }
        }
        return f67462g;
    }

    public static void s(long j) {
        d.a.n0.r.d0.b j2 = d.a.n0.r.d0.b.j();
        j2.w("face_collect_update_time" + j(), j);
    }

    public static void t(long j) {
        d.a.n0.r.d0.b j2 = d.a.n0.r.d0.b.j();
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
                d.a.o0.z1.c.i().c(arrayList, false);
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
                    this.f67465c.w(str2, Boolean.FALSE, new C1822d(atomicInteger, list));
                }
                return;
            }
            r(list);
            return;
        }
        this.f67467e = false;
    }

    public boolean n() {
        return this.f67468f;
    }

    public boolean o() {
        return this.f67467e;
    }

    public final void p(List<String> list) {
        d.a.o0.z1.a.b().a(new c(list));
    }

    public final void q(List<String> list) {
        if (d.a.o0.z1.c.i().j(list, false)) {
            t(System.currentTimeMillis());
        }
        this.f67467e = false;
    }

    public final void r(List<String> list) {
        if (l.C()) {
            d.a.o0.z1.a.b().a(new e(list));
        } else {
            q(list);
        }
    }

    public void u(boolean z) {
        this.f67468f = z;
    }

    public void v() {
        this.f67467e = true;
        this.f67468f = true;
        this.f67464b.w(new b());
    }

    public void w() {
        d.a.o0.z1.a.b().a(new a());
    }
}
