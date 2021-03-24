package d.b.i0.x1;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.tieba.faceshop.UserCollectModel;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import com.baidu.tieba.newfaceshop.NewFaceSyncDownloadModel;
import com.baidu.tieba.newfaceshop.NewFaceSyncUploadModel;
import com.baidu.tieba.newfaceshop.message.GetCloudFaceGroupMessage;
import d.b.b.e.p.l;
import d.b.i0.l0.u;
import d.b.i0.l0.w;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: g  reason: collision with root package name */
    public static volatile d f62349g;

    /* renamed from: a  reason: collision with root package name */
    public NewFaceSyncUploadModel f62350a = new NewFaceSyncUploadModel();

    /* renamed from: b  reason: collision with root package name */
    public NewFaceSyncDownloadModel f62351b = new NewFaceSyncDownloadModel();

    /* renamed from: c  reason: collision with root package name */
    public NewFaceGroupDownloadModel f62352c = new NewFaceGroupDownloadModel();

    /* renamed from: d  reason: collision with root package name */
    public w f62353d = new w();

    /* renamed from: e  reason: collision with root package name */
    public boolean f62354e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f62355f;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            List<MyEmotionGroupData> f2 = d.b.i0.x1.c.i().f();
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
            d.this.f62350a.s(str);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b.i0.x1.e.a {

        /* loaded from: classes4.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ GetCloudFaceGroupMessage f62358e;

            public a(GetCloudFaceGroupMessage getCloudFaceGroupMessage) {
                this.f62358e = getCloudFaceGroupMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f62353d.f(this.f62358e.getCollectEmotionList());
            }
        }

        public b() {
        }

        @Override // d.b.i0.x1.e.a
        public void a(GetCloudFaceGroupMessage getCloudFaceGroupMessage) {
            if (getCloudFaceGroupMessage == null) {
                d.this.f62355f = false;
                d.this.f62354e = false;
                return;
            }
            if (getCloudFaceGroupMessage.getCollectUpdateTime() <= d.k()) {
                d.this.f62355f = false;
                if (getCloudFaceGroupMessage.getCollectUpdateTime() < d.k()) {
                    new UserCollectModel().s();
                }
                u.s().n();
            } else if (getCloudFaceGroupMessage.getCollectEmotionList() == null) {
                d.this.f62355f = false;
            } else {
                d.b.i0.x1.a.b().a(new a(getCloudFaceGroupMessage));
            }
            if (getCloudFaceGroupMessage.getFaceGroupUpdateTime() <= d.l()) {
                d.this.f62354e = false;
                if (getCloudFaceGroupMessage.getFaceGroupUpdateTime() < d.l()) {
                    d.this.w();
                }
                d.b.i0.x1.c.i().e();
            } else if (getCloudFaceGroupMessage.getFaceGroupData() != null) {
                d.this.p(getCloudFaceGroupMessage.getFaceGroupData());
            } else {
                d.this.f62354e = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f62360e;

        public c(List list) {
            this.f62360e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.i0.x1.c.i().b(true);
            List<MyEmotionGroupData> f2 = d.b.i0.x1.c.i().f();
            ArrayList arrayList = new ArrayList();
            if (f2 != null) {
                for (MyEmotionGroupData myEmotionGroupData : f2) {
                    arrayList.add(myEmotionGroupData.getGroupId());
                }
            }
            d.this.h(this.f62360e, arrayList);
        }
    }

    /* renamed from: d.b.i0.x1.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1660d implements d.b.i0.x1.e.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f62362a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f62363b;

        public C1660d(AtomicInteger atomicInteger, List list) {
            this.f62362a = atomicInteger;
            this.f62363b = list;
        }

        @Override // d.b.i0.x1.e.b
        public void onFail(String str) {
            if (this.f62362a.decrementAndGet() == 0) {
                d.this.q(this.f62363b);
            }
        }

        @Override // d.b.i0.x1.e.b
        public void onProgress(int i) {
        }

        @Override // d.b.i0.x1.e.b
        public void onSuccess(String str) {
            if (this.f62362a.decrementAndGet() == 0) {
                d.this.q(this.f62363b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f62365e;

        public e(List list) {
            this.f62365e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.q(this.f62365e);
        }
    }

    public static String j() {
        return TbadkCoreApplication.getCurrentAccount() == null ? "" : String.valueOf(Math.abs(TbadkCoreApplication.getCurrentAccount().hashCode()));
    }

    public static long k() {
        d.b.h0.r.d0.b i = d.b.h0.r.d0.b.i();
        return i.k("face_collect_update_time" + j(), 0L);
    }

    public static long l() {
        d.b.h0.r.d0.b i = d.b.h0.r.d0.b.i();
        return i.k("face_group_update_time" + j(), 0L);
    }

    public static d m() {
        if (f62349g == null) {
            synchronized (d.class) {
                if (f62349g == null) {
                    f62349g = new d();
                }
            }
        }
        return f62349g;
    }

    public static void s(long j) {
        d.b.h0.r.d0.b i = d.b.h0.r.d0.b.i();
        i.v("face_collect_update_time" + j(), j);
    }

    public static void t(long j) {
        d.b.h0.r.d0.b i = d.b.h0.r.d0.b.i();
        i.v("face_group_update_time" + j(), j);
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
                d.b.i0.x1.c.i().c(arrayList, false);
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
                    this.f62352c.s(str2, Boolean.FALSE, new C1660d(atomicInteger, list));
                }
                return;
            }
            r(list);
            return;
        }
        this.f62354e = false;
    }

    public boolean n() {
        return this.f62355f;
    }

    public boolean o() {
        return this.f62354e;
    }

    public final void p(List<String> list) {
        d.b.i0.x1.a.b().a(new c(list));
    }

    public final void q(List<String> list) {
        if (d.b.i0.x1.c.i().j(list, false)) {
            t(System.currentTimeMillis());
        }
        this.f62354e = false;
    }

    public final void r(List<String> list) {
        if (l.B()) {
            d.b.i0.x1.a.b().a(new e(list));
        } else {
            q(list);
        }
    }

    public void u(boolean z) {
        this.f62355f = z;
    }

    public void v() {
        this.f62354e = true;
        this.f62355f = true;
        this.f62351b.s(new b());
    }

    public void w() {
        d.b.i0.x1.a.b().a(new a());
    }
}
