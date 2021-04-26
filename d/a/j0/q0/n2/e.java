package d.a.j0.q0.n2;

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
    public f f58260a;

    /* renamed from: b  reason: collision with root package name */
    public LongSparseArray<Integer> f58261b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.j0.q0.x1.c f58262c;

    /* renamed from: d  reason: collision with root package name */
    public d f58263d;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.q0.o2.f f58264e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f58265f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f58266g;

        public a(e eVar, d.a.j0.q0.o2.f fVar, String str, String str2) {
            this.f58264e = fVar;
            this.f58265f = str;
            this.f58266g = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.j0.q0.o2.f fVar = this.f58264e;
            if (fVar != null) {
                fVar.q(this.f58265f, this.f58266g);
            }
            TiebaStatic.log(new StatisticItem("c13982").param("fid", this.f58266g).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public e() {
        this.f58260a = null;
        this.f58260a = new f();
        this.f58261b = new LongSparseArray<>();
    }

    public int a(long j) {
        if (j == 0) {
            return 0;
        }
        Integer num = this.f58261b.get(j);
        if (num == null) {
            this.f58261b.put(j, 1);
            return 1;
        }
        this.f58261b.put(j, Integer.valueOf(num.intValue() + 1));
        return num.intValue() + 1;
    }

    public void b(long j) {
        if (j != 0) {
            this.f58261b.remove(j);
        }
    }

    public void c(String str, String str2) {
        this.f58260a.b(str, str2);
    }

    public void d() {
        d.a.j0.q0.x1.c cVar = this.f58262c;
        if (cVar != null) {
            cVar.m();
        }
    }

    public f e() {
        return this.f58260a;
    }

    public void f(Activity activity, String str, String str2) {
        if (activity == null || !this.f58263d.c()) {
            return;
        }
        if (this.f58262c == null) {
            this.f58262c = new d.a.j0.q0.x1.c(activity, R.id.frs_guide_delete_forum_tip);
        }
        this.f58262c.p(str);
        this.f58262c.q(str2);
        this.f58262c.r();
    }

    public boolean g(String str, String str2) {
        f fVar;
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || "0".equals(str) || "0".equals(str2) || (fVar = this.f58260a) == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() - fVar.f(str, str2);
        if (currentTimeMillis < VideoCloudSetting.HOUR_MILLISECOND) {
            return false;
        }
        if (this.f58260a.e(str, str2) <= 3 || currentTimeMillis >= 2592000000L) {
            long c2 = this.f58260a.c(str, str2);
            if (c2 == 0 || System.currentTimeMillis() - c2 > 604800000) {
                return this.f58260a.d(str, str2);
            }
            return true;
        }
        return false;
    }

    public void h(Activity activity, String str, String str2, String str3, d.a.j0.q0.o2.f fVar) {
        if (activity == null) {
            return;
        }
        if (this.f58262c == null) {
            this.f58262c = new d.a.j0.q0.x1.c(activity, R.id.frs_guide_tip);
        }
        if (!StringUtils.isNull(str3)) {
            this.f58262c.n(str3);
        }
        this.f58262c.o(new a(this, fVar, str, str2));
        this.f58262c.s();
        TiebaStatic.log(new StatisticItem("c13894").param("fid", str2).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public e(String str, String str2) {
        this.f58260a = null;
        this.f58263d = new d(str, str2);
    }
}
