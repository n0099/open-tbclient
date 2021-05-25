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
    public static volatile d f63619g;

    /* renamed from: a  reason: collision with root package name */
    public NewFaceSyncUploadModel f63620a = new NewFaceSyncUploadModel();

    /* renamed from: b  reason: collision with root package name */
    public NewFaceSyncDownloadModel f63621b = new NewFaceSyncDownloadModel();

    /* renamed from: c  reason: collision with root package name */
    public NewFaceGroupDownloadModel f63622c = new NewFaceGroupDownloadModel();

    /* renamed from: d  reason: collision with root package name */
    public w f63623d = new w();

    /* renamed from: e  reason: collision with root package name */
    public boolean f63624e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f63625f;

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
            d.this.f63620a.s(str);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.n0.z1.e.a {

        /* loaded from: classes4.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ GetCloudFaceGroupMessage f63628e;

            public a(GetCloudFaceGroupMessage getCloudFaceGroupMessage) {
                this.f63628e = getCloudFaceGroupMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f63623d.f(this.f63628e.getCollectEmotionList());
            }
        }

        public b() {
        }

        @Override // d.a.n0.z1.e.a
        public void a(GetCloudFaceGroupMessage getCloudFaceGroupMessage) {
            if (getCloudFaceGroupMessage == null) {
                d.this.f63625f = false;
                d.this.f63624e = false;
                return;
            }
            if (getCloudFaceGroupMessage.getCollectUpdateTime() <= d.k()) {
                d.this.f63625f = false;
                if (getCloudFaceGroupMessage.getCollectUpdateTime() < d.k()) {
                    new UserCollectModel().s();
                }
                u.s().n();
            } else if (getCloudFaceGroupMessage.getCollectEmotionList() == null) {
                d.this.f63625f = false;
            } else {
                d.a.n0.z1.a.b().a(new a(getCloudFaceGroupMessage));
            }
            if (getCloudFaceGroupMessage.getFaceGroupUpdateTime() <= d.l()) {
                d.this.f63624e = false;
                if (getCloudFaceGroupMessage.getFaceGroupUpdateTime() < d.l()) {
                    d.this.w();
                }
                d.a.n0.z1.c.i().e();
            } else if (getCloudFaceGroupMessage.getFaceGroupData() != null) {
                d.this.p(getCloudFaceGroupMessage.getFaceGroupData());
            } else {
                d.this.f63624e = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f63630e;

        public c(List list) {
            this.f63630e = list;
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
            d.this.h(this.f63630e, arrayList);
        }
    }

    /* renamed from: d.a.n0.z1.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1760d implements d.a.n0.z1.e.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f63632a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f63633b;

        public C1760d(AtomicInteger atomicInteger, List list) {
            this.f63632a = atomicInteger;
            this.f63633b = list;
        }

        @Override // d.a.n0.z1.e.b
        public void a(String str) {
            if (this.f63632a.decrementAndGet() == 0) {
                d.this.q(this.f63633b);
            }
        }

        @Override // d.a.n0.z1.e.b
        public void onProgress(int i2) {
        }

        @Override // d.a.n0.z1.e.b
        public void onSuccess(String str) {
            if (this.f63632a.decrementAndGet() == 0) {
                d.this.q(this.f63633b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f63635e;

        public e(List list) {
            this.f63635e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.q(this.f63635e);
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
        if (f63619g == null) {
            synchronized (d.class) {
                if (f63619g == null) {
                    f63619g = new d();
                }
            }
        }
        return f63619g;
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
                    this.f63622c.s(str2, Boolean.FALSE, new C1760d(atomicInteger, list));
                }
                return;
            }
            r(list);
            return;
        }
        this.f63624e = false;
    }

    public boolean n() {
        return this.f63625f;
    }

    public boolean o() {
        return this.f63624e;
    }

    public final void p(List<String> list) {
        d.a.n0.z1.a.b().a(new c(list));
    }

    public final void q(List<String> list) {
        if (d.a.n0.z1.c.i().j(list, false)) {
            t(System.currentTimeMillis());
        }
        this.f63624e = false;
    }

    public final void r(List<String> list) {
        if (l.C()) {
            d.a.n0.z1.a.b().a(new e(list));
        } else {
            q(list);
        }
    }

    public void u(boolean z) {
        this.f63625f = z;
    }

    public void v() {
        this.f63624e = true;
        this.f63625f = true;
        this.f63621b.s(new b());
    }

    public void w() {
        d.a.n0.z1.a.b().a(new a());
    }
}
