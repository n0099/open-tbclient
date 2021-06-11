package d.a.m0.b1.m;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f52806a;

    /* renamed from: b  reason: collision with root package name */
    public String f52807b;

    /* renamed from: c  reason: collision with root package name */
    public int f52808c;

    /* renamed from: d  reason: collision with root package name */
    public int f52809d;

    /* renamed from: e  reason: collision with root package name */
    public int f52810e;

    /* renamed from: f  reason: collision with root package name */
    public String f52811f;

    /* renamed from: g  reason: collision with root package name */
    public int f52812g;

    /* renamed from: h  reason: collision with root package name */
    public int f52813h;

    public String a() {
        return this.f52811f;
    }

    public int b() {
        return this.f52812g;
    }

    public int c() {
        return this.f52813h;
    }

    public int d() {
        return this.f52809d;
    }

    public String e() {
        return this.f52807b;
    }

    public String f() {
        return this.f52806a;
    }

    public int g() {
        return this.f52808c;
    }

    public boolean h() {
        return !StringUtils.isNull(this.f52806a) && this.f52808c > 0 && this.f52809d > 0;
    }

    public boolean i() {
        return this.f52810e == 15;
    }

    public void j(PbContent pbContent) {
        if (pbContent == null) {
            return;
        }
        this.f52806a = pbContent.link;
        this.f52807b = pbContent.src;
        this.f52808c = pbContent.width.intValue();
        this.f52809d = pbContent.height.intValue();
        this.f52810e = pbContent.e_type.intValue();
        this.f52811f = pbContent.text;
        this.f52812g = pbContent.during_time.intValue();
        pbContent.count.intValue();
        this.f52813h = pbContent.origin_size.intValue();
    }
}
