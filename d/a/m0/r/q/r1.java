package d.a.m0.r.q;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes3.dex */
public class r1 {

    /* renamed from: a  reason: collision with root package name */
    public String f50114a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f50115b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f50116c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f50117d = "";

    /* renamed from: e  reason: collision with root package name */
    public int f50118e = -1;

    public String a() {
        return this.f50117d;
    }

    public int b() {
        return this.f50118e;
    }

    public String c() {
        return this.f50116c;
    }

    public String d() {
        return this.f50114a;
    }

    public String e() {
        return this.f50115b;
    }

    public void f(SchoolRecomUserInfo schoolRecomUserInfo) {
        if (schoolRecomUserInfo == null) {
            return;
        }
        this.f50114a = StringUtils.string(schoolRecomUserInfo.uid);
        this.f50115b = schoolRecomUserInfo.uname;
        this.f50116c = schoolRecomUserInfo.portrait;
        this.f50117d = schoolRecomUserInfo.institute;
        this.f50118e = schoolRecomUserInfo.is_liked.intValue();
    }
}
