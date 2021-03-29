package d.b.i0.q2;

import android.content.Intent;
import android.net.Uri;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import d.b.b.e.m.g;
import d.b.b.e.p.l;
import d.b.i0.e2.e;
import d.b.i0.t3.h;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static a f59599c;

    /* renamed from: a  reason: collision with root package name */
    public int f59600a = 0;

    /* renamed from: b  reason: collision with root package name */
    public e f59601b;

    /* renamed from: d.b.i0.q2.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1490a implements h.g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f59602a;

        public C1490a(TbPageContext tbPageContext) {
            this.f59602a = tbPageContext;
        }

        @Override // d.b.i0.t3.h.g
        public void a(int i) {
            if (a.this.f59601b == null) {
                return;
            }
            a.this.f59601b.dismiss();
            a.this.f59601b = null;
            a.this.f59600a = i;
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FIRST_CLICK_STAR).param("obj_type", a.this.f59600a));
            a.this.o(this.f59602a);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements h.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f59604a;

        public b(TbPageContext tbPageContext) {
            this.f59604a = tbPageContext;
        }

        @Override // d.b.i0.t3.h.e
        public void onClick() {
            if (a.this.f59601b == null) {
                return;
            }
            a.this.f59601b.dismiss();
            a.this.f59601b = null;
            if (a.this.f59600a == 1 || a.this.f59600a == 2) {
                a.this.h(this.f59604a);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FEEDBACK_CLICK_FEEDBACK));
                return;
            }
            a.this.i(this.f59604a);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_SCORE_CLICK_SCORE));
        }
    }

    /* loaded from: classes5.dex */
    public class c implements h.d {
        public c() {
        }

        @Override // d.b.i0.t3.h.d
        public void onClick() {
            if (a.this.f59601b == null) {
                return;
            }
            a.this.f59601b.dismiss();
            a.this.f59601b = null;
            if (a.this.f59600a != 1 && a.this.f59600a != 2) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_SCORE_CLICK_CANCEL));
            } else {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FEEDBACK_CLICK_CANCEL));
            }
        }
    }

    public static a g() {
        if (f59599c == null) {
            synchronized (a.class) {
                if (f59599c == null) {
                    f59599c = new a();
                }
            }
        }
        return f59599c;
    }

    public final void h(TbPageContext tbPageContext) {
        if (tbPageContext == null) {
            return;
        }
        UrlManager.getInstance().dealOneLink((TbPageContext<?>) tbPageContext, new String[]{TbConfig.URL_FEED_BACK}, true);
    }

    public final void i(TbPageContext tbPageContext) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + TbadkCoreApplication.getInst().getPackageName()));
            intent.addFlags(268435456);
            tbPageContext.getContext().startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void j() {
        String version = TbConfig.getVersion();
        if (version.equals(d.b.h0.r.d0.b.i().o("key_rate_version", ""))) {
            return;
        }
        d.b.h0.r.d0.b.i().w("key_rate_version", version);
        d.b.h0.r.d0.b.i().v("key_rate_version_time", new Date().getTime());
    }

    public final void k(TbPageContext tbPageContext) {
        if (tbPageContext == null || TbConfig.getVersionType() == 2) {
            return;
        }
        if (Long.valueOf(new Date().getTime()).longValue() - d.b.h0.r.d0.b.i().k("key_rate_version_time", 0L) < 86400000) {
            return;
        }
        String version = TbConfig.getVersion();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        d.b.h0.r.d0.b i = d.b.h0.r.d0.b.i();
        if (i.g("key_rate_same_version_is_score" + version + currentAccount, false)) {
            return;
        }
        d.b.h0.r.d0.b i2 = d.b.h0.r.d0.b.i();
        i2.s("key_rate_same_version_is_score" + version + currentAccount, true);
        n(tbPageContext);
    }

    public void l(TbPageContext tbPageContext) {
        if (tbPageContext == null) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        d.b.h0.r.d0.b i = d.b.h0.r.d0.b.i();
        int j = i.j("key_rate_like_count" + currentAccount, 0) + 1;
        if (j < 3) {
            if (j == 1) {
                Long valueOf = Long.valueOf(new Date().getTime());
                d.b.h0.r.d0.b i2 = d.b.h0.r.d0.b.i();
                i2.v("key_rate_first_like_time" + currentAccount, valueOf.longValue());
                d.b.h0.r.d0.b i3 = d.b.h0.r.d0.b.i();
                i3.u("key_rate_like_count" + currentAccount, j);
                return;
            }
            d.b.h0.r.d0.b i4 = d.b.h0.r.d0.b.i();
            i4.u("key_rate_like_count" + currentAccount, j);
            return;
        }
        d.b.h0.r.d0.b i5 = d.b.h0.r.d0.b.i();
        if (Long.valueOf(new Date().getTime()).longValue() - i5.k("key_rate_first_like_time" + currentAccount, 0L) < 86400000) {
            d.b.h0.r.d0.b i6 = d.b.h0.r.d0.b.i();
            i6.u("key_rate_like_count" + currentAccount, 0);
            k(tbPageContext);
            return;
        }
        d.b.h0.r.d0.b i7 = d.b.h0.r.d0.b.i();
        i7.u("key_rate_like_count" + currentAccount, 0);
    }

    public void m(TbPageContext tbPageContext) {
        if (tbPageContext == null) {
            return;
        }
        k(tbPageContext);
    }

    public void n(TbPageContext tbPageContext) {
        if (tbPageContext == null) {
            return;
        }
        h hVar = new h(tbPageContext.getContext());
        hVar.y(tbPageContext.getContext().getString(R.string.is_tieba_pleased));
        hVar.o(8);
        hVar.s(0);
        int g2 = l.g(tbPageContext.getContext(), R.dimen.ds86);
        int g3 = l.g(tbPageContext.getContext(), R.dimen.ds138);
        int g4 = l.g(tbPageContext.getContext(), R.dimen.ds27);
        hVar.x(R.dimen.ds28);
        hVar.w(0, g2, 0, g4);
        hVar.q(0, 0, 0, g3);
        hVar.p(true);
        hVar.v(new C1490a(tbPageContext));
        e eVar = new e(tbPageContext.getContext(), hVar.j());
        this.f59601b = eVar;
        eVar.a(0.7f);
        g.j(this.f59601b, tbPageContext);
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FIRST_DIALOG_SHOW));
    }

    public void o(TbPageContext tbPageContext) {
        h.c cVar;
        if (tbPageContext == null) {
            return;
        }
        h hVar = new h(tbPageContext.getContext());
        int i = this.f59600a;
        if (i != 1 && i != 2) {
            hVar.y(tbPageContext.getContext().getString(R.string.go_shop_give_me_comment));
            cVar = new h.c(tbPageContext.getContext().getString(R.string.go_score), hVar);
        } else {
            hVar.y(tbPageContext.getContext().getString(R.string.help_my_improving_experience));
            cVar = new h.c(tbPageContext.getContext().getString(R.string.go_feedback), hVar);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        hVar.r(this.f59600a);
        hVar.s(0);
        hVar.o(0);
        hVar.p(false);
        l.g(tbPageContext.getContext(), R.dimen.ds42);
        int g2 = l.g(tbPageContext.getContext(), R.dimen.ds32);
        l.g(tbPageContext.getContext(), R.dimen.ds51);
        hVar.w(0, l.g(tbPageContext.getContext(), R.dimen.ds21), 0, 0);
        hVar.q(0, g2, 0, g2);
        cVar.h(new b(tbPageContext));
        hVar.u(new c());
        hVar.t(arrayList);
        e eVar = new e(tbPageContext.getContext(), hVar.j());
        this.f59601b = eVar;
        eVar.a(0.7f);
        g.j(this.f59601b, tbPageContext);
        int i2 = this.f59600a;
        if (i2 != 1 && i2 != 2) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_SCORE_DIALOG_SHOW));
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FEEDBACK_DIALOG_SHOW));
        }
    }
}
