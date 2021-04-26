package d.a.j0.d3;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes5.dex */
public class k implements d.a.c.j.e.n {
    public static final String l = TbadkCoreApplication.getInst().getString(R.string.default_bar_manager_select_title);

    /* renamed from: e  reason: collision with root package name */
    public String f53171e;

    /* renamed from: f  reason: collision with root package name */
    public int f53172f;

    /* renamed from: g  reason: collision with root package name */
    public String f53173g;

    /* renamed from: h  reason: collision with root package name */
    public String f53174h;

    /* renamed from: i  reason: collision with root package name */
    public String f53175i;
    public int j;
    public int k;

    public int c() {
        return this.k;
    }

    public String e() {
        return this.f53174h;
    }

    public int f() {
        return this.j;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }

    public String h() {
        return this.f53171e;
    }

    public String i() {
        return this.f53175i;
    }

    public String k() {
        return this.f53173g;
    }

    public int l() {
        return this.f53172f;
    }

    public void m(StarEnter starEnter) {
        p(starEnter.icon);
        r(starEnter.time.intValue());
        s(starEnter.title);
        v(starEnter.type.intValue());
        t(starEnter.url);
        u(starEnter.weight.intValue());
        q(starEnter.rank_num.intValue());
        o(starEnter.bazhu_mark.intValue());
        if (StringUtils.isNull(this.f53171e) && this.k == 1) {
            this.f53171e = l;
        }
        this.f53174h = starEnter.obj_id;
        this.f53175i = starEnter.text;
    }

    public void o(int i2) {
        this.k = i2;
    }

    public void p(String str) {
    }

    public void q(int i2) {
        this.j = i2;
    }

    public void r(int i2) {
    }

    public void s(String str) {
        this.f53171e = str;
    }

    public void t(String str) {
        this.f53173g = str;
    }

    public void u(int i2) {
    }

    public void v(int i2) {
        this.f53172f = i2;
    }
}
