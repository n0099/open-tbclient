package d.b.h0.r.q;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes3.dex */
public class r1 {

    /* renamed from: a  reason: collision with root package name */
    public String f51283a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f51284b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f51285c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f51286d = "";

    /* renamed from: e  reason: collision with root package name */
    public int f51287e = -1;

    public String a() {
        return this.f51286d;
    }

    public int b() {
        return this.f51287e;
    }

    public String c() {
        return this.f51285c;
    }

    public String d() {
        return this.f51283a;
    }

    public String e() {
        return this.f51284b;
    }

    public void f(SchoolRecomUserInfo schoolRecomUserInfo) {
        if (schoolRecomUserInfo == null) {
            return;
        }
        this.f51283a = StringUtils.string(schoolRecomUserInfo.uid);
        this.f51284b = schoolRecomUserInfo.uname;
        this.f51285c = schoolRecomUserInfo.portrait;
        this.f51286d = schoolRecomUserInfo.institute;
        this.f51287e = schoolRecomUserInfo.is_liked.intValue();
    }
}
