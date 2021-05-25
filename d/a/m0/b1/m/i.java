package d.a.m0.b1.m;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f49132a;

    /* renamed from: b  reason: collision with root package name */
    public String f49133b;

    /* renamed from: c  reason: collision with root package name */
    public int f49134c;

    /* renamed from: d  reason: collision with root package name */
    public int f49135d;

    /* renamed from: e  reason: collision with root package name */
    public int f49136e;

    /* renamed from: f  reason: collision with root package name */
    public String f49137f;

    /* renamed from: g  reason: collision with root package name */
    public int f49138g;

    /* renamed from: h  reason: collision with root package name */
    public int f49139h;

    public String a() {
        return this.f49137f;
    }

    public int b() {
        return this.f49138g;
    }

    public int c() {
        return this.f49139h;
    }

    public int d() {
        return this.f49135d;
    }

    public String e() {
        return this.f49133b;
    }

    public String f() {
        return this.f49132a;
    }

    public int g() {
        return this.f49134c;
    }

    public boolean h() {
        return !StringUtils.isNull(this.f49132a) && this.f49134c > 0 && this.f49135d > 0;
    }

    public boolean i() {
        return this.f49136e == 15;
    }

    public void j(PbContent pbContent) {
        if (pbContent == null) {
            return;
        }
        this.f49132a = pbContent.link;
        this.f49133b = pbContent.src;
        this.f49134c = pbContent.width.intValue();
        this.f49135d = pbContent.height.intValue();
        this.f49136e = pbContent.e_type.intValue();
        this.f49137f = pbContent.text;
        this.f49138g = pbContent.during_time.intValue();
        pbContent.count.intValue();
        this.f49139h = pbContent.origin_size.intValue();
    }
}
