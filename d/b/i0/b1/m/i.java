package d.b.i0.b1.m;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f50711a;

    /* renamed from: b  reason: collision with root package name */
    public String f50712b;

    /* renamed from: c  reason: collision with root package name */
    public int f50713c;

    /* renamed from: d  reason: collision with root package name */
    public int f50714d;

    /* renamed from: e  reason: collision with root package name */
    public int f50715e;

    /* renamed from: f  reason: collision with root package name */
    public String f50716f;

    /* renamed from: g  reason: collision with root package name */
    public int f50717g;

    /* renamed from: h  reason: collision with root package name */
    public int f50718h;

    public String a() {
        return this.f50716f;
    }

    public int b() {
        return this.f50717g;
    }

    public int c() {
        return this.f50718h;
    }

    public int d() {
        return this.f50714d;
    }

    public String e() {
        return this.f50712b;
    }

    public String f() {
        return this.f50711a;
    }

    public int g() {
        return this.f50713c;
    }

    public boolean h() {
        return !StringUtils.isNull(this.f50711a) && this.f50713c > 0 && this.f50714d > 0;
    }

    public boolean i() {
        return this.f50715e == 15;
    }

    public void j(PbContent pbContent) {
        if (pbContent == null) {
            return;
        }
        this.f50711a = pbContent.link;
        this.f50712b = pbContent.src;
        this.f50713c = pbContent.width.intValue();
        this.f50714d = pbContent.height.intValue();
        this.f50715e = pbContent.e_type.intValue();
        this.f50716f = pbContent.text;
        this.f50717g = pbContent.during_time.intValue();
        pbContent.count.intValue();
        this.f50718h = pbContent.origin_size.intValue();
    }
}
