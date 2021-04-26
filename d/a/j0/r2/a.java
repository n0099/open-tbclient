package d.a.j0.r2;

import android.content.Intent;
import android.net.Uri;
import com.alibaba.fastjson.asm.Label;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import d.a.c.e.m.g;
import d.a.c.e.p.l;
import d.a.j0.f2.e;
import d.a.j0.u3.h;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static a f59871c;

    /* renamed from: a  reason: collision with root package name */
    public int f59872a = 0;

    /* renamed from: b  reason: collision with root package name */
    public e f59873b;

    /* renamed from: d.a.j0.r2.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1516a implements h.g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f59874a;

        public C1516a(TbPageContext tbPageContext) {
            this.f59874a = tbPageContext;
        }

        @Override // d.a.j0.u3.h.g
        public void onClick(int i2) {
            if (a.this.f59873b == null) {
                return;
            }
            a.this.f59873b.dismiss();
            a.this.f59873b = null;
            a.this.f59872a = i2;
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FIRST_CLICK_STAR).param("obj_type", a.this.f59872a));
            a.this.o(this.f59874a);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements h.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f59876a;

        public b(TbPageContext tbPageContext) {
            this.f59876a = tbPageContext;
        }

        @Override // d.a.j0.u3.h.e
        public void onClick() {
            if (a.this.f59873b == null) {
                return;
            }
            a.this.f59873b.dismiss();
            a.this.f59873b = null;
            if (a.this.f59872a == 1 || a.this.f59872a == 2) {
                a.this.h(this.f59876a);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FEEDBACK_CLICK_FEEDBACK));
                return;
            }
            a.this.i(this.f59876a);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_SCORE_CLICK_SCORE));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements h.d {
        public c() {
        }

        @Override // d.a.j0.u3.h.d
        public void onClick() {
            if (a.this.f59873b == null) {
                return;
            }
            a.this.f59873b.dismiss();
            a.this.f59873b = null;
            if (a.this.f59872a != 1 && a.this.f59872a != 2) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_SCORE_CLICK_CANCEL));
            } else {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FEEDBACK_CLICK_CANCEL));
            }
        }
    }

    public static a g() {
        if (f59871c == null) {
            synchronized (a.class) {
                if (f59871c == null) {
                    f59871c = new a();
                }
            }
        }
        return f59871c;
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
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            tbPageContext.getContext().startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void j() {
        String version = TbConfig.getVersion();
        if (version.equals(d.a.i0.r.d0.b.j().p("key_rate_version", ""))) {
            return;
        }
        d.a.i0.r.d0.b.j().x("key_rate_version", version);
        d.a.i0.r.d0.b.j().w("key_rate_version_time", new Date().getTime());
    }

    public final void k(TbPageContext tbPageContext) {
        if (tbPageContext == null || TbConfig.getVersionType() == 2) {
            return;
        }
        if (Long.valueOf(new Date().getTime()).longValue() - d.a.i0.r.d0.b.j().l("key_rate_version_time", 0L) < 86400000) {
            return;
        }
        String version = TbConfig.getVersion();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        d.a.i0.r.d0.b j = d.a.i0.r.d0.b.j();
        if (j.g("key_rate_same_version_is_score" + version + currentAccount, false)) {
            return;
        }
        d.a.i0.r.d0.b j2 = d.a.i0.r.d0.b.j();
        j2.t("key_rate_same_version_is_score" + version + currentAccount, true);
        n(tbPageContext);
    }

    public void l(TbPageContext tbPageContext) {
        if (tbPageContext == null) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        d.a.i0.r.d0.b j = d.a.i0.r.d0.b.j();
        int k = j.k("key_rate_like_count" + currentAccount, 0) + 1;
        if (k < 3) {
            if (k == 1) {
                Long valueOf = Long.valueOf(new Date().getTime());
                d.a.i0.r.d0.b j2 = d.a.i0.r.d0.b.j();
                j2.w("key_rate_first_like_time" + currentAccount, valueOf.longValue());
                d.a.i0.r.d0.b j3 = d.a.i0.r.d0.b.j();
                j3.v("key_rate_like_count" + currentAccount, k);
                return;
            }
            d.a.i0.r.d0.b j4 = d.a.i0.r.d0.b.j();
            j4.v("key_rate_like_count" + currentAccount, k);
            return;
        }
        d.a.i0.r.d0.b j5 = d.a.i0.r.d0.b.j();
        if (Long.valueOf(new Date().getTime()).longValue() - j5.l("key_rate_first_like_time" + currentAccount, 0L) < 86400000) {
            d.a.i0.r.d0.b j6 = d.a.i0.r.d0.b.j();
            j6.v("key_rate_like_count" + currentAccount, 0);
            k(tbPageContext);
            return;
        }
        d.a.i0.r.d0.b j7 = d.a.i0.r.d0.b.j();
        j7.v("key_rate_like_count" + currentAccount, 0);
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
        hVar.v(new C1516a(tbPageContext));
        e eVar = new e(tbPageContext.getContext(), hVar.j());
        this.f59873b = eVar;
        eVar.a(0.7f);
        g.j(this.f59873b, tbPageContext);
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FIRST_DIALOG_SHOW));
    }

    public void o(TbPageContext tbPageContext) {
        h.c cVar;
        if (tbPageContext == null) {
            return;
        }
        h hVar = new h(tbPageContext.getContext());
        int i2 = this.f59872a;
        if (i2 != 1 && i2 != 2) {
            hVar.y(tbPageContext.getContext().getString(R.string.go_shop_give_me_comment));
            cVar = new h.c(tbPageContext.getContext().getString(R.string.go_score), hVar);
        } else {
            hVar.y(tbPageContext.getContext().getString(R.string.help_my_improving_experience));
            cVar = new h.c(tbPageContext.getContext().getString(R.string.go_feedback), hVar);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        hVar.r(this.f59872a);
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
        this.f59873b = eVar;
        eVar.a(0.7f);
        g.j(this.f59873b, tbPageContext);
        int i3 = this.f59872a;
        if (i3 != 1 && i3 != 2) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_SCORE_DIALOG_SHOW));
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FEEDBACK_DIALOG_SHOW));
        }
    }
}
