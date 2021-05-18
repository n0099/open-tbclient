package d.a.k0.y1;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.tieba.faceshop.UserCollectModel;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import com.baidu.tieba.newfaceshop.NewFaceSyncDownloadModel;
import com.baidu.tieba.newfaceshop.NewFaceSyncUploadModel;
import com.baidu.tieba.newfaceshop.message.GetCloudFaceGroupMessage;
import d.a.c.e.p.l;
import d.a.k0.l0.u;
import d.a.k0.l0.w;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: g  reason: collision with root package name */
    public static volatile d f63455g;

    /* renamed from: a  reason: collision with root package name */
    public NewFaceSyncUploadModel f63456a = new NewFaceSyncUploadModel();

    /* renamed from: b  reason: collision with root package name */
    public NewFaceSyncDownloadModel f63457b = new NewFaceSyncDownloadModel();

    /* renamed from: c  reason: collision with root package name */
    public NewFaceGroupDownloadModel f63458c = new NewFaceGroupDownloadModel();

    /* renamed from: d  reason: collision with root package name */
    public w f63459d = new w();

    /* renamed from: e  reason: collision with root package name */
    public boolean f63460e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f63461f;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            List<MyEmotionGroupData> f2 = d.a.k0.y1.c.i().f();
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
            d.this.f63456a.s(str);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.k0.y1.e.a {

        /* loaded from: classes4.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ GetCloudFaceGroupMessage f63464e;

            public a(GetCloudFaceGroupMessage getCloudFaceGroupMessage) {
                this.f63464e = getCloudFaceGroupMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f63459d.f(this.f63464e.getCollectEmotionList());
            }
        }

        public b() {
        }

        @Override // d.a.k0.y1.e.a
        public void a(GetCloudFaceGroupMessage getCloudFaceGroupMessage) {
            if (getCloudFaceGroupMessage == null) {
                d.this.f63461f = false;
                d.this.f63460e = false;
                return;
            }
            if (getCloudFaceGroupMessage.getCollectUpdateTime() <= d.k()) {
                d.this.f63461f = false;
                if (getCloudFaceGroupMessage.getCollectUpdateTime() < d.k()) {
                    new UserCollectModel().s();
                }
                u.s().n();
            } else if (getCloudFaceGroupMessage.getCollectEmotionList() == null) {
                d.this.f63461f = false;
            } else {
                d.a.k0.y1.a.b().a(new a(getCloudFaceGroupMessage));
            }
            if (getCloudFaceGroupMessage.getFaceGroupUpdateTime() <= d.l()) {
                d.this.f63460e = false;
                if (getCloudFaceGroupMessage.getFaceGroupUpdateTime() < d.l()) {
                    d.this.w();
                }
                d.a.k0.y1.c.i().e();
            } else if (getCloudFaceGroupMessage.getFaceGroupData() != null) {
                d.this.p(getCloudFaceGroupMessage.getFaceGroupData());
            } else {
                d.this.f63460e = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f63466e;

        public c(List list) {
            this.f63466e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.k0.y1.c.i().b(true);
            List<MyEmotionGroupData> f2 = d.a.k0.y1.c.i().f();
            ArrayList arrayList = new ArrayList();
            if (f2 != null) {
                for (MyEmotionGroupData myEmotionGroupData : f2) {
                    arrayList.add(myEmotionGroupData.getGroupId());
                }
            }
            d.this.h(this.f63466e, arrayList);
        }
    }

    /* renamed from: d.a.k0.y1.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1745d implements d.a.k0.y1.e.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f63468a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f63469b;

        public C1745d(AtomicInteger atomicInteger, List list) {
            this.f63468a = atomicInteger;
            this.f63469b = list;
        }

        @Override // d.a.k0.y1.e.b
        public void a(String str) {
            if (this.f63468a.decrementAndGet() == 0) {
                d.this.q(this.f63469b);
            }
        }

        @Override // d.a.k0.y1.e.b
        public void onProgress(int i2) {
        }

        @Override // d.a.k0.y1.e.b
        public void onSuccess(String str) {
            if (this.f63468a.decrementAndGet() == 0) {
                d.this.q(this.f63469b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f63471e;

        public e(List list) {
            this.f63471e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.q(this.f63471e);
        }
    }

    public static String j() {
        return TbadkCoreApplication.getCurrentAccount() == null ? "" : String.valueOf(Math.abs(TbadkCoreApplication.getCurrentAccount().hashCode()));
    }

    public static long k() {
        d.a.j0.r.d0.b j = d.a.j0.r.d0.b.j();
        return j.l("face_collect_update_time" + j(), 0L);
    }

    public static long l() {
        d.a.j0.r.d0.b j = d.a.j0.r.d0.b.j();
        return j.l("face_group_update_time" + j(), 0L);
    }

    public static d m() {
        if (f63455g == null) {
            synchronized (d.class) {
                if (f63455g == null) {
                    f63455g = new d();
                }
            }
        }
        return f63455g;
    }

    public static void s(long j) {
        d.a.j0.r.d0.b j2 = d.a.j0.r.d0.b.j();
        j2.w("face_collect_update_time" + j(), j);
    }

    public static void t(long j) {
        d.a.j0.r.d0.b j2 = d.a.j0.r.d0.b.j();
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
                d.a.k0.y1.c.i().c(arrayList, false);
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
                    this.f63458c.s(str2, Boolean.FALSE, new C1745d(atomicInteger, list));
                }
                return;
            }
            r(list);
            return;
        }
        this.f63460e = false;
    }

    public boolean n() {
        return this.f63461f;
    }

    public boolean o() {
        return this.f63460e;
    }

    public final void p(List<String> list) {
        d.a.k0.y1.a.b().a(new c(list));
    }

    public final void q(List<String> list) {
        if (d.a.k0.y1.c.i().j(list, false)) {
            t(System.currentTimeMillis());
        }
        this.f63460e = false;
    }

    public final void r(List<String> list) {
        if (l.C()) {
            d.a.k0.y1.a.b().a(new e(list));
        } else {
            q(list);
        }
    }

    public void u(boolean z) {
        this.f63461f = z;
    }

    public void v() {
        this.f63460e = true;
        this.f63461f = true;
        this.f63457b.s(new b());
    }

    public void w() {
        d.a.k0.y1.a.b().a(new a());
    }
}
