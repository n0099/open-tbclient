package d.a.j0.y1;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.tieba.faceshop.UserCollectModel;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import com.baidu.tieba.newfaceshop.NewFaceSyncDownloadModel;
import com.baidu.tieba.newfaceshop.NewFaceSyncUploadModel;
import com.baidu.tieba.newfaceshop.message.GetCloudFaceGroupMessage;
import d.a.c.e.p.l;
import d.a.j0.l0.u;
import d.a.j0.l0.w;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: g  reason: collision with root package name */
    public static volatile d f62731g;

    /* renamed from: a  reason: collision with root package name */
    public NewFaceSyncUploadModel f62732a = new NewFaceSyncUploadModel();

    /* renamed from: b  reason: collision with root package name */
    public NewFaceSyncDownloadModel f62733b = new NewFaceSyncDownloadModel();

    /* renamed from: c  reason: collision with root package name */
    public NewFaceGroupDownloadModel f62734c = new NewFaceGroupDownloadModel();

    /* renamed from: d  reason: collision with root package name */
    public w f62735d = new w();

    /* renamed from: e  reason: collision with root package name */
    public boolean f62736e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f62737f;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            List<MyEmotionGroupData> f2 = d.a.j0.y1.c.i().f();
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
            d.this.f62732a.s(str);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.j0.y1.e.a {

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ GetCloudFaceGroupMessage f62740e;

            public a(GetCloudFaceGroupMessage getCloudFaceGroupMessage) {
                this.f62740e = getCloudFaceGroupMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f62735d.f(this.f62740e.getCollectEmotionList());
            }
        }

        public b() {
        }

        @Override // d.a.j0.y1.e.a
        public void a(GetCloudFaceGroupMessage getCloudFaceGroupMessage) {
            if (getCloudFaceGroupMessage == null) {
                d.this.f62737f = false;
                d.this.f62736e = false;
                return;
            }
            if (getCloudFaceGroupMessage.getCollectUpdateTime() <= d.k()) {
                d.this.f62737f = false;
                if (getCloudFaceGroupMessage.getCollectUpdateTime() < d.k()) {
                    new UserCollectModel().s();
                }
                u.s().n();
            } else if (getCloudFaceGroupMessage.getCollectEmotionList() == null) {
                d.this.f62737f = false;
            } else {
                d.a.j0.y1.a.b().a(new a(getCloudFaceGroupMessage));
            }
            if (getCloudFaceGroupMessage.getFaceGroupUpdateTime() <= d.l()) {
                d.this.f62736e = false;
                if (getCloudFaceGroupMessage.getFaceGroupUpdateTime() < d.l()) {
                    d.this.w();
                }
                d.a.j0.y1.c.i().e();
            } else if (getCloudFaceGroupMessage.getFaceGroupData() != null) {
                d.this.p(getCloudFaceGroupMessage.getFaceGroupData());
            } else {
                d.this.f62736e = false;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f62742e;

        public c(List list) {
            this.f62742e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.j0.y1.c.i().b(true);
            List<MyEmotionGroupData> f2 = d.a.j0.y1.c.i().f();
            ArrayList arrayList = new ArrayList();
            if (f2 != null) {
                for (MyEmotionGroupData myEmotionGroupData : f2) {
                    arrayList.add(myEmotionGroupData.getGroupId());
                }
            }
            d.this.h(this.f62742e, arrayList);
        }
    }

    /* renamed from: d.a.j0.y1.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1680d implements d.a.j0.y1.e.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f62744a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f62745b;

        public C1680d(AtomicInteger atomicInteger, List list) {
            this.f62744a = atomicInteger;
            this.f62745b = list;
        }

        @Override // d.a.j0.y1.e.b
        public void onFail(String str) {
            if (this.f62744a.decrementAndGet() == 0) {
                d.this.q(this.f62745b);
            }
        }

        @Override // d.a.j0.y1.e.b
        public void onProgress(int i2) {
        }

        @Override // d.a.j0.y1.e.b
        public void onSuccess(String str) {
            if (this.f62744a.decrementAndGet() == 0) {
                d.this.q(this.f62745b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f62747e;

        public e(List list) {
            this.f62747e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.q(this.f62747e);
        }
    }

    public static String j() {
        return TbadkCoreApplication.getCurrentAccount() == null ? "" : String.valueOf(Math.abs(TbadkCoreApplication.getCurrentAccount().hashCode()));
    }

    public static long k() {
        d.a.i0.r.d0.b j = d.a.i0.r.d0.b.j();
        return j.l("face_collect_update_time" + j(), 0L);
    }

    public static long l() {
        d.a.i0.r.d0.b j = d.a.i0.r.d0.b.j();
        return j.l("face_group_update_time" + j(), 0L);
    }

    public static d m() {
        if (f62731g == null) {
            synchronized (d.class) {
                if (f62731g == null) {
                    f62731g = new d();
                }
            }
        }
        return f62731g;
    }

    public static void s(long j) {
        d.a.i0.r.d0.b j2 = d.a.i0.r.d0.b.j();
        j2.w("face_collect_update_time" + j(), j);
    }

    public static void t(long j) {
        d.a.i0.r.d0.b j2 = d.a.i0.r.d0.b.j();
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
                d.a.j0.y1.c.i().c(arrayList, false);
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
                    this.f62734c.s(str2, Boolean.FALSE, new C1680d(atomicInteger, list));
                }
                return;
            }
            r(list);
            return;
        }
        this.f62736e = false;
    }

    public boolean n() {
        return this.f62737f;
    }

    public boolean o() {
        return this.f62736e;
    }

    public final void p(List<String> list) {
        d.a.j0.y1.a.b().a(new c(list));
    }

    public final void q(List<String> list) {
        if (d.a.j0.y1.c.i().j(list, false)) {
            t(System.currentTimeMillis());
        }
        this.f62736e = false;
    }

    public final void r(List<String> list) {
        if (l.C()) {
            d.a.j0.y1.a.b().a(new e(list));
        } else {
            q(list);
        }
    }

    public void u(boolean z) {
        this.f62737f = z;
    }

    public void v() {
        this.f62736e = true;
        this.f62737f = true;
        this.f62733b.s(new b());
    }

    public void w() {
        d.a.j0.y1.a.b().a(new a());
    }
}
