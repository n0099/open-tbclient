package d.a.j0.r.q;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes3.dex */
public class r1 {

    /* renamed from: a  reason: collision with root package name */
    public String f50070a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f50071b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f50072c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f50073d = "";

    /* renamed from: e  reason: collision with root package name */
    public int f50074e = -1;

    public String a() {
        return this.f50073d;
    }

    public int b() {
        return this.f50074e;
    }

    public String c() {
        return this.f50072c;
    }

    public String d() {
        return this.f50070a;
    }

    public String e() {
        return this.f50071b;
    }

    public void f(SchoolRecomUserInfo schoolRecomUserInfo) {
        if (schoolRecomUserInfo == null) {
            return;
        }
        this.f50070a = StringUtils.string(schoolRecomUserInfo.uid);
        this.f50071b = schoolRecomUserInfo.uname;
        this.f50072c = schoolRecomUserInfo.portrait;
        this.f50073d = schoolRecomUserInfo.institute;
        this.f50074e = schoolRecomUserInfo.is_liked.intValue();
    }
}
