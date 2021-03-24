package d.b.i0.p0.m2;

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
    public f f57908a;

    /* renamed from: b  reason: collision with root package name */
    public LongSparseArray<Integer> f57909b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.p0.x1.c f57910c;

    /* renamed from: d  reason: collision with root package name */
    public d f57911d;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.p0.n2.f f57912e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f57913f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f57914g;

        public a(e eVar, d.b.i0.p0.n2.f fVar, String str, String str2) {
            this.f57912e = fVar;
            this.f57913f = str;
            this.f57914g = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.i0.p0.n2.f fVar = this.f57912e;
            if (fVar != null) {
                fVar.q(this.f57913f, this.f57914g);
            }
            TiebaStatic.log(new StatisticItem("c13982").param("fid", this.f57914g).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public e() {
        this.f57908a = null;
        this.f57908a = new f();
        this.f57909b = new LongSparseArray<>();
    }

    public int a(long j) {
        if (j == 0) {
            return 0;
        }
        Integer num = this.f57909b.get(j);
        if (num == null) {
            this.f57909b.put(j, 1);
            return 1;
        }
        this.f57909b.put(j, Integer.valueOf(num.intValue() + 1));
        return num.intValue() + 1;
    }

    public void b(long j) {
        if (j != 0) {
            this.f57909b.remove(j);
        }
    }

    public void c(String str, String str2) {
        this.f57908a.b(str, str2);
    }

    public void d() {
        d.b.i0.p0.x1.c cVar = this.f57910c;
        if (cVar != null) {
            cVar.m();
        }
    }

    public f e() {
        return this.f57908a;
    }

    public void f(Activity activity, String str, String str2) {
        if (activity == null || !this.f57911d.c()) {
            return;
        }
        if (this.f57910c == null) {
            this.f57910c = new d.b.i0.p0.x1.c(activity, R.id.frs_guide_delete_forum_tip);
        }
        this.f57910c.p(str);
        this.f57910c.q(str2);
        this.f57910c.r();
    }

    public boolean g(String str, String str2) {
        f fVar;
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || "0".equals(str) || "0".equals(str2) || (fVar = this.f57908a) == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() - fVar.f(str, str2);
        if (currentTimeMillis < VideoCloudSetting.HOUR_MILLISECOND) {
            return false;
        }
        if (this.f57908a.e(str, str2) <= 3 || currentTimeMillis >= 2592000000L) {
            long c2 = this.f57908a.c(str, str2);
            if (c2 == 0 || System.currentTimeMillis() - c2 > 604800000) {
                return this.f57908a.d(str, str2);
            }
            return true;
        }
        return false;
    }

    public void h(Activity activity, String str, String str2, String str3, d.b.i0.p0.n2.f fVar) {
        if (activity == null) {
            return;
        }
        if (this.f57910c == null) {
            this.f57910c = new d.b.i0.p0.x1.c(activity, R.id.frs_guide_tip);
        }
        if (!StringUtils.isNull(str3)) {
            this.f57910c.n(str3);
        }
        this.f57910c.o(new a(this, fVar, str, str2));
        this.f57910c.s();
        TiebaStatic.log(new StatisticItem("c13894").param("fid", str2).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public e(String str, String str2) {
        this.f57908a = null;
        this.f57911d = new d(str, str2);
    }
}
