package d.a.j0.b1.m;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f49107a;

    /* renamed from: b  reason: collision with root package name */
    public String f49108b;

    /* renamed from: c  reason: collision with root package name */
    public int f49109c;

    /* renamed from: d  reason: collision with root package name */
    public int f49110d;

    /* renamed from: e  reason: collision with root package name */
    public int f49111e;

    /* renamed from: f  reason: collision with root package name */
    public String f49112f;

    /* renamed from: g  reason: collision with root package name */
    public int f49113g;

    /* renamed from: h  reason: collision with root package name */
    public int f49114h;

    public String a() {
        return this.f49112f;
    }

    public int b() {
        return this.f49113g;
    }

    public int c() {
        return this.f49114h;
    }

    public int d() {
        return this.f49110d;
    }

    public String e() {
        return this.f49108b;
    }

    public String f() {
        return this.f49107a;
    }

    public int g() {
        return this.f49109c;
    }

    public boolean h() {
        return !StringUtils.isNull(this.f49107a) && this.f49109c > 0 && this.f49110d > 0;
    }

    public boolean i() {
        return this.f49111e == 15;
    }

    public void j(PbContent pbContent) {
        if (pbContent == null) {
            return;
        }
        this.f49107a = pbContent.link;
        this.f49108b = pbContent.src;
        this.f49109c = pbContent.width.intValue();
        this.f49110d = pbContent.height.intValue();
        this.f49111e = pbContent.e_type.intValue();
        this.f49112f = pbContent.text;
        this.f49113g = pbContent.during_time.intValue();
        pbContent.count.intValue();
        this.f49114h = pbContent.origin_size.intValue();
    }
}
