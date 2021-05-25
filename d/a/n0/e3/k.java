package d.a.n0.e3;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes5.dex */
public class k implements d.a.c.j.e.n {
    public static final String l = TbadkCoreApplication.getInst().getString(R.string.default_bar_manager_select_title);

    /* renamed from: e  reason: collision with root package name */
    public String f54091e;

    /* renamed from: f  reason: collision with root package name */
    public int f54092f;

    /* renamed from: g  reason: collision with root package name */
    public String f54093g;

    /* renamed from: h  reason: collision with root package name */
    public String f54094h;

    /* renamed from: i  reason: collision with root package name */
    public String f54095i;
    public int j;
    public int k;

    public int c() {
        return this.k;
    }

    public String e() {
        return this.f54094h;
    }

    public int f() {
        return this.j;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }

    public String h() {
        return this.f54091e;
    }

    public String i() {
        return this.f54095i;
    }

    public String k() {
        return this.f54093g;
    }

    public int l() {
        return this.f54092f;
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
        if (StringUtils.isNull(this.f54091e) && this.k == 1) {
            this.f54091e = l;
        }
        this.f54094h = starEnter.obj_id;
        this.f54095i = starEnter.text;
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
        this.f54091e = str;
    }

    public void t(String str) {
        this.f54093g = str;
    }

    public void u(int i2) {
    }

    public void v(int i2) {
        this.f54092f = i2;
    }
}
