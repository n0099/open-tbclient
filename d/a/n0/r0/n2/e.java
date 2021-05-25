package d.a.n0.r0.n2;

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
    public f f59143a;

    /* renamed from: b  reason: collision with root package name */
    public LongSparseArray<Integer> f59144b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.r0.x1.c f59145c;

    /* renamed from: d  reason: collision with root package name */
    public d f59146d;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.r0.o2.f f59147e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f59148f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f59149g;

        public a(e eVar, d.a.n0.r0.o2.f fVar, String str, String str2) {
            this.f59147e = fVar;
            this.f59148f = str;
            this.f59149g = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.n0.r0.o2.f fVar = this.f59147e;
            if (fVar != null) {
                fVar.q(this.f59148f, this.f59149g);
            }
            TiebaStatic.log(new StatisticItem("c13982").param("fid", this.f59149g).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public e() {
        this.f59143a = null;
        this.f59143a = new f();
        this.f59144b = new LongSparseArray<>();
    }

    public int a(long j) {
        if (j == 0) {
            return 0;
        }
        Integer num = this.f59144b.get(j);
        if (num == null) {
            this.f59144b.put(j, 1);
            return 1;
        }
        this.f59144b.put(j, Integer.valueOf(num.intValue() + 1));
        return num.intValue() + 1;
    }

    public void b(long j) {
        if (j != 0) {
            this.f59144b.remove(j);
        }
    }

    public void c(String str, String str2) {
        this.f59143a.b(str, str2);
    }

    public void d() {
        d.a.n0.r0.x1.c cVar = this.f59145c;
        if (cVar != null) {
            cVar.m();
        }
    }

    public f e() {
        return this.f59143a;
    }

    public void f(Activity activity, String str, String str2) {
        if (activity == null || !this.f59146d.c()) {
            return;
        }
        if (this.f59145c == null) {
            this.f59145c = new d.a.n0.r0.x1.c(activity, R.id.frs_guide_delete_forum_tip);
        }
        this.f59145c.p(str);
        this.f59145c.q(str2);
        this.f59145c.r();
    }

    public boolean g(String str, String str2) {
        f fVar;
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || "0".equals(str) || "0".equals(str2) || (fVar = this.f59143a) == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() - fVar.f(str, str2);
        if (currentTimeMillis < VideoCloudSetting.HOUR_MILLISECOND) {
            return false;
        }
        if (this.f59143a.e(str, str2) <= 3 || currentTimeMillis >= 2592000000L) {
            long c2 = this.f59143a.c(str, str2);
            if (c2 == 0 || System.currentTimeMillis() - c2 > 604800000) {
                return this.f59143a.d(str, str2);
            }
            return true;
        }
        return false;
    }

    public void h(Activity activity, String str, String str2, String str3, d.a.n0.r0.o2.f fVar) {
        if (activity == null) {
            return;
        }
        if (this.f59145c == null) {
            this.f59145c = new d.a.n0.r0.x1.c(activity, R.id.frs_guide_tip);
        }
        if (!StringUtils.isNull(str3)) {
            this.f59145c.n(str3);
        }
        this.f59145c.o(new a(this, fVar, str, str2));
        this.f59145c.s();
        TiebaStatic.log(new StatisticItem("c13894").param("fid", str2).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public e(String str, String str2) {
        this.f59143a = null;
        this.f59146d = new d(str, str2);
    }
}
