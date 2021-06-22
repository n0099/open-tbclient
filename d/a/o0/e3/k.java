package d.a.o0.e3;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes5.dex */
public class k implements d.a.c.k.e.n {
    public static final String l = TbadkCoreApplication.getInst().getString(R.string.default_bar_manager_select_title);

    /* renamed from: e  reason: collision with root package name */
    public String f57905e;

    /* renamed from: f  reason: collision with root package name */
    public int f57906f;

    /* renamed from: g  reason: collision with root package name */
    public String f57907g;

    /* renamed from: h  reason: collision with root package name */
    public String f57908h;

    /* renamed from: i  reason: collision with root package name */
    public String f57909i;
    public int j;
    public int k;

    public int b() {
        return this.k;
    }

    public String c() {
        return this.f57908h;
    }

    public int e() {
        return this.j;
    }

    public String g() {
        return this.f57905e;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }

    public String h() {
        return this.f57909i;
    }

    public String i() {
        return this.f57907g;
    }

    public int k() {
        return this.f57906f;
    }

    public void l(StarEnter starEnter) {
        o(starEnter.icon);
        q(starEnter.time.intValue());
        s(starEnter.title);
        v(starEnter.type.intValue());
        t(starEnter.url);
        u(starEnter.weight.intValue());
        p(starEnter.rank_num.intValue());
        n(starEnter.bazhu_mark.intValue());
        if (StringUtils.isNull(this.f57905e) && this.k == 1) {
            this.f57905e = l;
        }
        this.f57908h = starEnter.obj_id;
        this.f57909i = starEnter.text;
    }

    public void n(int i2) {
        this.k = i2;
    }

    public void o(String str) {
    }

    public void p(int i2) {
        this.j = i2;
    }

    public void q(int i2) {
    }

    public void s(String str) {
        this.f57905e = str;
    }

    public void t(String str) {
        this.f57907g = str;
    }

    public void u(int i2) {
    }

    public void v(int i2) {
        this.f57906f = i2;
    }
}
