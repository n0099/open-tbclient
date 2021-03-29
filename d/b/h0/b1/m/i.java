package d.b.h0.b1.m;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f49982a;

    /* renamed from: b  reason: collision with root package name */
    public String f49983b;

    /* renamed from: c  reason: collision with root package name */
    public int f49984c;

    /* renamed from: d  reason: collision with root package name */
    public int f49985d;

    /* renamed from: e  reason: collision with root package name */
    public int f49986e;

    /* renamed from: f  reason: collision with root package name */
    public String f49987f;

    /* renamed from: g  reason: collision with root package name */
    public int f49988g;

    /* renamed from: h  reason: collision with root package name */
    public int f49989h;

    public String a() {
        return this.f49987f;
    }

    public int b() {
        return this.f49988g;
    }

    public int c() {
        return this.f49989h;
    }

    public int d() {
        return this.f49985d;
    }

    public String e() {
        return this.f49983b;
    }

    public String f() {
        return this.f49982a;
    }

    public int g() {
        return this.f49984c;
    }

    public boolean h() {
        return !StringUtils.isNull(this.f49982a) && this.f49984c > 0 && this.f49985d > 0;
    }

    public boolean i() {
        return this.f49986e == 15;
    }

    public void j(PbContent pbContent) {
        if (pbContent == null) {
            return;
        }
        this.f49982a = pbContent.link;
        this.f49983b = pbContent.src;
        this.f49984c = pbContent.width.intValue();
        this.f49985d = pbContent.height.intValue();
        this.f49986e = pbContent.e_type.intValue();
        this.f49987f = pbContent.text;
        this.f49988g = pbContent.during_time.intValue();
        pbContent.count.intValue();
        this.f49989h = pbContent.origin_size.intValue();
    }
}
