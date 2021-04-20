package d.b.i0.d3;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes3.dex */
public class k implements d.b.c.j.e.n {
    public static final String l = TbadkCoreApplication.getInst().getString(R.string.default_bar_manager_select_title);

    /* renamed from: e  reason: collision with root package name */
    public String f54911e;

    /* renamed from: f  reason: collision with root package name */
    public int f54912f;

    /* renamed from: g  reason: collision with root package name */
    public String f54913g;

    /* renamed from: h  reason: collision with root package name */
    public String f54914h;
    public String i;
    public int j;
    public int k;

    public int a() {
        return this.k;
    }

    public String e() {
        return this.f54914h;
    }

    public int f() {
        return this.j;
    }

    public String g() {
        return this.f54911e;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }

    public String j() {
        return this.i;
    }

    public String k() {
        return this.f54913g;
    }

    public int l() {
        return this.f54912f;
    }

    public void n(StarEnter starEnter) {
        p(starEnter.icon);
        r(starEnter.time.intValue());
        s(starEnter.title);
        v(starEnter.type.intValue());
        t(starEnter.url);
        u(starEnter.weight.intValue());
        q(starEnter.rank_num.intValue());
        o(starEnter.bazhu_mark.intValue());
        if (StringUtils.isNull(this.f54911e) && this.k == 1) {
            this.f54911e = l;
        }
        this.f54914h = starEnter.obj_id;
        this.i = starEnter.text;
    }

    public void o(int i) {
        this.k = i;
    }

    public void p(String str) {
    }

    public void q(int i) {
        this.j = i;
    }

    public void r(int i) {
    }

    public void s(String str) {
        this.f54911e = str;
    }

    public void t(String str) {
        this.f54913g = str;
    }

    public void u(int i) {
    }

    public void v(int i) {
        this.f54912f = i;
    }
}
