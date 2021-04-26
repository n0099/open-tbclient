package d.a.i0.b1.m;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f48279a;

    /* renamed from: b  reason: collision with root package name */
    public String f48280b;

    /* renamed from: c  reason: collision with root package name */
    public int f48281c;

    /* renamed from: d  reason: collision with root package name */
    public int f48282d;

    /* renamed from: e  reason: collision with root package name */
    public int f48283e;

    /* renamed from: f  reason: collision with root package name */
    public String f48284f;

    /* renamed from: g  reason: collision with root package name */
    public int f48285g;

    /* renamed from: h  reason: collision with root package name */
    public int f48286h;

    public String a() {
        return this.f48284f;
    }

    public int b() {
        return this.f48285g;
    }

    public int c() {
        return this.f48286h;
    }

    public int d() {
        return this.f48282d;
    }

    public String e() {
        return this.f48280b;
    }

    public String f() {
        return this.f48279a;
    }

    public int g() {
        return this.f48281c;
    }

    public boolean h() {
        return !StringUtils.isNull(this.f48279a) && this.f48281c > 0 && this.f48282d > 0;
    }

    public boolean i() {
        return this.f48283e == 15;
    }

    public void j(PbContent pbContent) {
        if (pbContent == null) {
            return;
        }
        this.f48279a = pbContent.link;
        this.f48280b = pbContent.src;
        this.f48281c = pbContent.width.intValue();
        this.f48282d = pbContent.height.intValue();
        this.f48283e = pbContent.e_type.intValue();
        this.f48284f = pbContent.text;
        this.f48285g = pbContent.during_time.intValue();
        pbContent.count.intValue();
        this.f48286h = pbContent.origin_size.intValue();
    }
}
