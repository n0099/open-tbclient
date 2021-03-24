package d.b.h0.b1.m;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f49981a;

    /* renamed from: b  reason: collision with root package name */
    public String f49982b;

    /* renamed from: c  reason: collision with root package name */
    public int f49983c;

    /* renamed from: d  reason: collision with root package name */
    public int f49984d;

    /* renamed from: e  reason: collision with root package name */
    public int f49985e;

    /* renamed from: f  reason: collision with root package name */
    public String f49986f;

    /* renamed from: g  reason: collision with root package name */
    public int f49987g;

    /* renamed from: h  reason: collision with root package name */
    public int f49988h;

    public String a() {
        return this.f49986f;
    }

    public int b() {
        return this.f49987g;
    }

    public int c() {
        return this.f49988h;
    }

    public int d() {
        return this.f49984d;
    }

    public String e() {
        return this.f49982b;
    }

    public String f() {
        return this.f49981a;
    }

    public int g() {
        return this.f49983c;
    }

    public boolean h() {
        return !StringUtils.isNull(this.f49981a) && this.f49983c > 0 && this.f49984d > 0;
    }

    public boolean i() {
        return this.f49985e == 15;
    }

    public void j(PbContent pbContent) {
        if (pbContent == null) {
            return;
        }
        this.f49981a = pbContent.link;
        this.f49982b = pbContent.src;
        this.f49983c = pbContent.width.intValue();
        this.f49984d = pbContent.height.intValue();
        this.f49985e = pbContent.e_type.intValue();
        this.f49986f = pbContent.text;
        this.f49987g = pbContent.during_time.intValue();
        pbContent.count.intValue();
        this.f49988h = pbContent.origin_size.intValue();
    }
}
