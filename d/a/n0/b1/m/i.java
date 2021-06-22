package d.a.n0.b1.m;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f52913a;

    /* renamed from: b  reason: collision with root package name */
    public String f52914b;

    /* renamed from: c  reason: collision with root package name */
    public int f52915c;

    /* renamed from: d  reason: collision with root package name */
    public int f52916d;

    /* renamed from: e  reason: collision with root package name */
    public int f52917e;

    /* renamed from: f  reason: collision with root package name */
    public String f52918f;

    /* renamed from: g  reason: collision with root package name */
    public int f52919g;

    /* renamed from: h  reason: collision with root package name */
    public int f52920h;

    public String a() {
        return this.f52918f;
    }

    public int b() {
        return this.f52919g;
    }

    public int c() {
        return this.f52920h;
    }

    public int d() {
        return this.f52916d;
    }

    public String e() {
        return this.f52914b;
    }

    public String f() {
        return this.f52913a;
    }

    public int g() {
        return this.f52915c;
    }

    public boolean h() {
        return !StringUtils.isNull(this.f52913a) && this.f52915c > 0 && this.f52916d > 0;
    }

    public boolean i() {
        return this.f52917e == 15;
    }

    public void j(PbContent pbContent) {
        if (pbContent == null) {
            return;
        }
        this.f52913a = pbContent.link;
        this.f52914b = pbContent.src;
        this.f52915c = pbContent.width.intValue();
        this.f52916d = pbContent.height.intValue();
        this.f52917e = pbContent.e_type.intValue();
        this.f52918f = pbContent.text;
        this.f52919g = pbContent.during_time.intValue();
        pbContent.count.intValue();
        this.f52920h = pbContent.origin_size.intValue();
    }
}
