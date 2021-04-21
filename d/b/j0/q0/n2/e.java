package d.b.j0.q0.n2;

import android.app.Activity;
import android.util.LongSparseArray;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.webkit.sdk.VideoCloudSetting;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public f f60179a;

    /* renamed from: b  reason: collision with root package name */
    public LongSparseArray<Integer> f60180b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.j0.q0.x1.c f60181c;

    /* renamed from: d  reason: collision with root package name */
    public d f60182d;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.j0.q0.o2.f f60183e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f60184f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f60185g;

        public a(e eVar, d.b.j0.q0.o2.f fVar, String str, String str2) {
            this.f60183e = fVar;
            this.f60184f = str;
            this.f60185g = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.j0.q0.o2.f fVar = this.f60183e;
            if (fVar != null) {
                fVar.q(this.f60184f, this.f60185g);
            }
            TiebaStatic.log(new StatisticItem("c13982").param("fid", this.f60185g).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public e() {
        this.f60179a = null;
        this.f60179a = new f();
        this.f60180b = new LongSparseArray<>();
    }

    public int a(long j) {
        if (j == 0) {
            return 0;
        }
        Integer num = this.f60180b.get(j);
        if (num == null) {
            this.f60180b.put(j, 1);
            return 1;
        }
        this.f60180b.put(j, Integer.valueOf(num.intValue() + 1));
        return num.intValue() + 1;
    }

    public void b(long j) {
        if (j != 0) {
            this.f60180b.remove(j);
        }
    }

    public void c(String str, String str2) {
        this.f60179a.b(str, str2);
    }

    public void d() {
        d.b.j0.q0.x1.c cVar = this.f60181c;
        if (cVar != null) {
            cVar.m();
        }
    }

    public f e() {
        return this.f60179a;
    }

    public void f(Activity activity, String str, String str2) {
        if (activity == null || !this.f60182d.c()) {
            return;
        }
        if (this.f60181c == null) {
            this.f60181c = new d.b.j0.q0.x1.c(activity, R.id.frs_guide_delete_forum_tip);
        }
        this.f60181c.p(str);
        this.f60181c.q(str2);
        this.f60181c.r();
    }

    public boolean g(String str, String str2) {
        f fVar;
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || "0".equals(str) || "0".equals(str2) || (fVar = this.f60179a) == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() - fVar.f(str, str2);
        if (currentTimeMillis < VideoCloudSetting.HOUR_MILLISECOND) {
            return false;
        }
        if (this.f60179a.e(str, str2) <= 3 || currentTimeMillis >= 2592000000L) {
            long c2 = this.f60179a.c(str, str2);
            if (c2 == 0 || System.currentTimeMillis() - c2 > 604800000) {
                return this.f60179a.d(str, str2);
            }
            return true;
        }
        return false;
    }

    public void h(Activity activity, String str, String str2, String str3, d.b.j0.q0.o2.f fVar) {
        if (activity == null) {
            return;
        }
        if (this.f60181c == null) {
            this.f60181c = new d.b.j0.q0.x1.c(activity, R.id.frs_guide_tip);
        }
        if (!StringUtils.isNull(str3)) {
            this.f60181c.n(str3);
        }
        this.f60181c.o(new a(this, fVar, str, str2));
        this.f60181c.s();
        TiebaStatic.log(new StatisticItem("c13894").param("fid", str2).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public e(String str, String str2) {
        this.f60179a = null;
        this.f60182d = new d(str, str2);
    }
}
