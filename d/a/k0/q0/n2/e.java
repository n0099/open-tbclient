package d.a.k0.q0.n2;

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
    public f f59002a;

    /* renamed from: b  reason: collision with root package name */
    public LongSparseArray<Integer> f59003b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.k0.q0.x1.c f59004c;

    /* renamed from: d  reason: collision with root package name */
    public d f59005d;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.k0.q0.o2.f f59006e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f59007f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f59008g;

        public a(e eVar, d.a.k0.q0.o2.f fVar, String str, String str2) {
            this.f59006e = fVar;
            this.f59007f = str;
            this.f59008g = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.k0.q0.o2.f fVar = this.f59006e;
            if (fVar != null) {
                fVar.q(this.f59007f, this.f59008g);
            }
            TiebaStatic.log(new StatisticItem("c13982").param("fid", this.f59008g).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public e() {
        this.f59002a = null;
        this.f59002a = new f();
        this.f59003b = new LongSparseArray<>();
    }

    public int a(long j) {
        if (j == 0) {
            return 0;
        }
        Integer num = this.f59003b.get(j);
        if (num == null) {
            this.f59003b.put(j, 1);
            return 1;
        }
        this.f59003b.put(j, Integer.valueOf(num.intValue() + 1));
        return num.intValue() + 1;
    }

    public void b(long j) {
        if (j != 0) {
            this.f59003b.remove(j);
        }
    }

    public void c(String str, String str2) {
        this.f59002a.b(str, str2);
    }

    public void d() {
        d.a.k0.q0.x1.c cVar = this.f59004c;
        if (cVar != null) {
            cVar.m();
        }
    }

    public f e() {
        return this.f59002a;
    }

    public void f(Activity activity, String str, String str2) {
        if (activity == null || !this.f59005d.c()) {
            return;
        }
        if (this.f59004c == null) {
            this.f59004c = new d.a.k0.q0.x1.c(activity, R.id.frs_guide_delete_forum_tip);
        }
        this.f59004c.p(str);
        this.f59004c.q(str2);
        this.f59004c.r();
    }

    public boolean g(String str, String str2) {
        f fVar;
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || "0".equals(str) || "0".equals(str2) || (fVar = this.f59002a) == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() - fVar.f(str, str2);
        if (currentTimeMillis < VideoCloudSetting.HOUR_MILLISECOND) {
            return false;
        }
        if (this.f59002a.e(str, str2) <= 3 || currentTimeMillis >= 2592000000L) {
            long c2 = this.f59002a.c(str, str2);
            if (c2 == 0 || System.currentTimeMillis() - c2 > 604800000) {
                return this.f59002a.d(str, str2);
            }
            return true;
        }
        return false;
    }

    public void h(Activity activity, String str, String str2, String str3, d.a.k0.q0.o2.f fVar) {
        if (activity == null) {
            return;
        }
        if (this.f59004c == null) {
            this.f59004c = new d.a.k0.q0.x1.c(activity, R.id.frs_guide_tip);
        }
        if (!StringUtils.isNull(str3)) {
            this.f59004c.n(str3);
        }
        this.f59004c.o(new a(this, fVar, str, str2));
        this.f59004c.s();
        TiebaStatic.log(new StatisticItem("c13894").param("fid", str2).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public e(String str, String str2) {
        this.f59002a = null;
        this.f59005d = new d(str, str2);
    }
}
