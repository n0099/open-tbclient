package d.b.i0.q0.n2;

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
    public f f59758a;

    /* renamed from: b  reason: collision with root package name */
    public LongSparseArray<Integer> f59759b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.q0.x1.c f59760c;

    /* renamed from: d  reason: collision with root package name */
    public d f59761d;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.q0.o2.f f59762e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f59763f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f59764g;

        public a(e eVar, d.b.i0.q0.o2.f fVar, String str, String str2) {
            this.f59762e = fVar;
            this.f59763f = str;
            this.f59764g = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.i0.q0.o2.f fVar = this.f59762e;
            if (fVar != null) {
                fVar.q(this.f59763f, this.f59764g);
            }
            TiebaStatic.log(new StatisticItem("c13982").param("fid", this.f59764g).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public e() {
        this.f59758a = null;
        this.f59758a = new f();
        this.f59759b = new LongSparseArray<>();
    }

    public int a(long j) {
        if (j == 0) {
            return 0;
        }
        Integer num = this.f59759b.get(j);
        if (num == null) {
            this.f59759b.put(j, 1);
            return 1;
        }
        this.f59759b.put(j, Integer.valueOf(num.intValue() + 1));
        return num.intValue() + 1;
    }

    public void b(long j) {
        if (j != 0) {
            this.f59759b.remove(j);
        }
    }

    public void c(String str, String str2) {
        this.f59758a.b(str, str2);
    }

    public void d() {
        d.b.i0.q0.x1.c cVar = this.f59760c;
        if (cVar != null) {
            cVar.m();
        }
    }

    public f e() {
        return this.f59758a;
    }

    public void f(Activity activity, String str, String str2) {
        if (activity == null || !this.f59761d.c()) {
            return;
        }
        if (this.f59760c == null) {
            this.f59760c = new d.b.i0.q0.x1.c(activity, R.id.frs_guide_delete_forum_tip);
        }
        this.f59760c.p(str);
        this.f59760c.q(str2);
        this.f59760c.r();
    }

    public boolean g(String str, String str2) {
        f fVar;
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || "0".equals(str) || "0".equals(str2) || (fVar = this.f59758a) == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() - fVar.f(str, str2);
        if (currentTimeMillis < VideoCloudSetting.HOUR_MILLISECOND) {
            return false;
        }
        if (this.f59758a.e(str, str2) <= 3 || currentTimeMillis >= 2592000000L) {
            long c2 = this.f59758a.c(str, str2);
            if (c2 == 0 || System.currentTimeMillis() - c2 > 604800000) {
                return this.f59758a.d(str, str2);
            }
            return true;
        }
        return false;
    }

    public void h(Activity activity, String str, String str2, String str3, d.b.i0.q0.o2.f fVar) {
        if (activity == null) {
            return;
        }
        if (this.f59760c == null) {
            this.f59760c = new d.b.i0.q0.x1.c(activity, R.id.frs_guide_tip);
        }
        if (!StringUtils.isNull(str3)) {
            this.f59760c.n(str3);
        }
        this.f59760c.o(new a(this, fVar, str, str2));
        this.f59760c.s();
        TiebaStatic.log(new StatisticItem("c13894").param("fid", str2).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public e(String str, String str2) {
        this.f59758a = null;
        this.f59761d = new d(str, str2);
    }
}
