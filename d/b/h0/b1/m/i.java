package d.b.h0.b1.m;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f50375a;

    /* renamed from: b  reason: collision with root package name */
    public String f50376b;

    /* renamed from: c  reason: collision with root package name */
    public int f50377c;

    /* renamed from: d  reason: collision with root package name */
    public int f50378d;

    /* renamed from: e  reason: collision with root package name */
    public int f50379e;

    /* renamed from: f  reason: collision with root package name */
    public String f50380f;

    /* renamed from: g  reason: collision with root package name */
    public int f50381g;

    /* renamed from: h  reason: collision with root package name */
    public int f50382h;

    public String a() {
        return this.f50380f;
    }

    public int b() {
        return this.f50381g;
    }

    public int c() {
        return this.f50382h;
    }

    public int d() {
        return this.f50378d;
    }

    public String e() {
        return this.f50376b;
    }

    public String f() {
        return this.f50375a;
    }

    public int g() {
        return this.f50377c;
    }

    public boolean h() {
        return !StringUtils.isNull(this.f50375a) && this.f50377c > 0 && this.f50378d > 0;
    }

    public boolean i() {
        return this.f50379e == 15;
    }

    public void j(PbContent pbContent) {
        if (pbContent == null) {
            return;
        }
        this.f50375a = pbContent.link;
        this.f50376b = pbContent.src;
        this.f50377c = pbContent.width.intValue();
        this.f50378d = pbContent.height.intValue();
        this.f50379e = pbContent.e_type.intValue();
        this.f50380f = pbContent.text;
        this.f50381g = pbContent.during_time.intValue();
        pbContent.count.intValue();
        this.f50382h = pbContent.origin_size.intValue();
    }
}
