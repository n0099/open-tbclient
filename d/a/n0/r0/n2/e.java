package d.a.n0.r0.n2;

import android.app.Activity;
import android.util.LongSparseArray;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public f f62834a;

    /* renamed from: b  reason: collision with root package name */
    public LongSparseArray<Integer> f62835b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.r0.x1.c f62836c;

    /* renamed from: d  reason: collision with root package name */
    public d f62837d;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.r0.o2.f f62838e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f62839f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f62840g;

        public a(e eVar, d.a.n0.r0.o2.f fVar, String str, String str2) {
            this.f62838e = fVar;
            this.f62839f = str;
            this.f62840g = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.n0.r0.o2.f fVar = this.f62838e;
            if (fVar != null) {
                fVar.q(this.f62839f, this.f62840g);
            }
            TiebaStatic.log(new StatisticItem("c13982").param("fid", this.f62840g).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public e() {
        this.f62834a = null;
        this.f62834a = new f();
        this.f62835b = new LongSparseArray<>();
    }

    public int a(long j) {
        if (j == 0) {
            return 0;
        }
        Integer num = this.f62835b.get(j);
        if (num == null) {
            this.f62835b.put(j, 1);
            return 1;
        }
        this.f62835b.put(j, Integer.valueOf(num.intValue() + 1));
        return num.intValue() + 1;
    }

    public void b(long j) {
        if (j != 0) {
            this.f62835b.remove(j);
        }
    }

    public void c(String str, String str2) {
        this.f62834a.b(str, str2);
    }

    public void d() {
        d.a.n0.r0.x1.c cVar = this.f62836c;
        if (cVar != null) {
            cVar.m();
        }
    }

    public f e() {
        return this.f62834a;
    }

    public void f(Activity activity, String str, String str2) {
        if (activity == null || !this.f62837d.c()) {
            return;
        }
        if (this.f62836c == null) {
            this.f62836c = new d.a.n0.r0.x1.c(activity, R.id.frs_guide_delete_forum_tip);
        }
        this.f62836c.p(str);
        this.f62836c.q(str2);
        this.f62836c.r();
    }

    public boolean g(String str, String str2) {
        f fVar;
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || "0".equals(str) || "0".equals(str2) || (fVar = this.f62834a) == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() - fVar.f(str, str2);
        if (currentTimeMillis < 3600000) {
            return false;
        }
        if (this.f62834a.e(str, str2) <= 3 || currentTimeMillis >= 2592000000L) {
            long c2 = this.f62834a.c(str, str2);
            if (c2 == 0 || System.currentTimeMillis() - c2 > 604800000) {
                return this.f62834a.d(str, str2);
            }
            return true;
        }
        return false;
    }

    public void h(Activity activity, String str, String str2, String str3, d.a.n0.r0.o2.f fVar) {
        if (activity == null) {
            return;
        }
        if (this.f62836c == null) {
            this.f62836c = new d.a.n0.r0.x1.c(activity, R.id.frs_guide_tip);
        }
        if (!StringUtils.isNull(str3)) {
            this.f62836c.n(str3);
        }
        this.f62836c.o(new a(this, fVar, str, str2));
        this.f62836c.s();
        TiebaStatic.log(new StatisticItem("c13894").param("fid", str2).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public e(String str, String str2) {
        this.f62834a = null;
        this.f62837d = new d(str, str2);
    }
}
