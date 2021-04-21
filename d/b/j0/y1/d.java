package d.b.j0.y1;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.tieba.faceshop.UserCollectModel;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import com.baidu.tieba.newfaceshop.NewFaceSyncDownloadModel;
import com.baidu.tieba.newfaceshop.NewFaceSyncUploadModel;
import com.baidu.tieba.newfaceshop.message.GetCloudFaceGroupMessage;
import d.b.c.e.p.l;
import d.b.j0.l0.u;
import d.b.j0.l0.w;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: g  reason: collision with root package name */
    public static volatile d f64456g;

    /* renamed from: a  reason: collision with root package name */
    public NewFaceSyncUploadModel f64457a = new NewFaceSyncUploadModel();

    /* renamed from: b  reason: collision with root package name */
    public NewFaceSyncDownloadModel f64458b = new NewFaceSyncDownloadModel();

    /* renamed from: c  reason: collision with root package name */
    public NewFaceGroupDownloadModel f64459c = new NewFaceGroupDownloadModel();

    /* renamed from: d  reason: collision with root package name */
    public w f64460d = new w();

    /* renamed from: e  reason: collision with root package name */
    public boolean f64461e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f64462f;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            List<MyEmotionGroupData> f2 = d.b.j0.y1.c.i().f();
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
            d.this.f64457a.s(str);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.j0.y1.e.a {

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ GetCloudFaceGroupMessage f64465e;

            public a(GetCloudFaceGroupMessage getCloudFaceGroupMessage) {
                this.f64465e = getCloudFaceGroupMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f64460d.f(this.f64465e.getCollectEmotionList());
            }
        }

        public b() {
        }

        @Override // d.b.j0.y1.e.a
        public void a(GetCloudFaceGroupMessage getCloudFaceGroupMessage) {
            if (getCloudFaceGroupMessage == null) {
                d.this.f64462f = false;
                d.this.f64461e = false;
                return;
            }
            if (getCloudFaceGroupMessage.getCollectUpdateTime() <= d.k()) {
                d.this.f64462f = false;
                if (getCloudFaceGroupMessage.getCollectUpdateTime() < d.k()) {
                    new UserCollectModel().s();
                }
                u.s().n();
            } else if (getCloudFaceGroupMessage.getCollectEmotionList() == null) {
                d.this.f64462f = false;
            } else {
                d.b.j0.y1.a.b().a(new a(getCloudFaceGroupMessage));
            }
            if (getCloudFaceGroupMessage.getFaceGroupUpdateTime() <= d.l()) {
                d.this.f64461e = false;
                if (getCloudFaceGroupMessage.getFaceGroupUpdateTime() < d.l()) {
                    d.this.w();
                }
                d.b.j0.y1.c.i().e();
            } else if (getCloudFaceGroupMessage.getFaceGroupData() != null) {
                d.this.p(getCloudFaceGroupMessage.getFaceGroupData());
            } else {
                d.this.f64461e = false;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f64467e;

        public c(List list) {
            this.f64467e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.j0.y1.c.i().b(true);
            List<MyEmotionGroupData> f2 = d.b.j0.y1.c.i().f();
            ArrayList arrayList = new ArrayList();
            if (f2 != null) {
                for (MyEmotionGroupData myEmotionGroupData : f2) {
                    arrayList.add(myEmotionGroupData.getGroupId());
                }
            }
            d.this.h(this.f64467e, arrayList);
        }
    }

    /* renamed from: d.b.j0.y1.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1743d implements d.b.j0.y1.e.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f64469a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f64470b;

        public C1743d(AtomicInteger atomicInteger, List list) {
            this.f64469a = atomicInteger;
            this.f64470b = list;
        }

        @Override // d.b.j0.y1.e.b
        public void onFail(String str) {
            if (this.f64469a.decrementAndGet() == 0) {
                d.this.q(this.f64470b);
            }
        }

        @Override // d.b.j0.y1.e.b
        public void onProgress(int i) {
        }

        @Override // d.b.j0.y1.e.b
        public void onSuccess(String str) {
            if (this.f64469a.decrementAndGet() == 0) {
                d.this.q(this.f64470b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f64472e;

        public e(List list) {
            this.f64472e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.q(this.f64472e);
        }
    }

    public static String j() {
        return TbadkCoreApplication.getCurrentAccount() == null ? "" : String.valueOf(Math.abs(TbadkCoreApplication.getCurrentAccount().hashCode()));
    }

    public static long k() {
        d.b.i0.r.d0.b j = d.b.i0.r.d0.b.j();
        return j.l("face_collect_update_time" + j(), 0L);
    }

    public static long l() {
        d.b.i0.r.d0.b j = d.b.i0.r.d0.b.j();
        return j.l("face_group_update_time" + j(), 0L);
    }

    public static d m() {
        if (f64456g == null) {
            synchronized (d.class) {
                if (f64456g == null) {
                    f64456g = new d();
                }
            }
        }
        return f64456g;
    }

    public static void s(long j) {
        d.b.i0.r.d0.b j2 = d.b.i0.r.d0.b.j();
        j2.w("face_collect_update_time" + j(), j);
    }

    public static void t(long j) {
        d.b.i0.r.d0.b j2 = d.b.i0.r.d0.b.j();
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
                d.b.j0.y1.c.i().c(arrayList, false);
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
                    this.f64459c.s(str2, Boolean.FALSE, new C1743d(atomicInteger, list));
                }
                return;
            }
            r(list);
            return;
        }
        this.f64461e = false;
    }

    public boolean n() {
        return this.f64462f;
    }

    public boolean o() {
        return this.f64461e;
    }

    public final void p(List<String> list) {
        d.b.j0.y1.a.b().a(new c(list));
    }

    public final void q(List<String> list) {
        if (d.b.j0.y1.c.i().j(list, false)) {
            t(System.currentTimeMillis());
        }
        this.f64461e = false;
    }

    public final void r(List<String> list) {
        if (l.B()) {
            d.b.j0.y1.a.b().a(new e(list));
        } else {
            q(list);
        }
    }

    public void u(boolean z) {
        this.f64462f = z;
    }

    public void v() {
        this.f64461e = true;
        this.f64462f = true;
        this.f64458b.s(new b());
    }

    public void w() {
        d.b.j0.y1.a.b().a(new a());
    }
}
