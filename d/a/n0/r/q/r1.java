package d.a.n0.r.q;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes3.dex */
public class r1 {

    /* renamed from: a  reason: collision with root package name */
    public String f53897a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f53898b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f53899c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f53900d = "";

    /* renamed from: e  reason: collision with root package name */
    public int f53901e = -1;

    public String a() {
        return this.f53900d;
    }

    public int b() {
        return this.f53901e;
    }

    public String c() {
        return this.f53899c;
    }

    public String d() {
        return this.f53897a;
    }

    public String e() {
        return this.f53898b;
    }

    public void f(SchoolRecomUserInfo schoolRecomUserInfo) {
        if (schoolRecomUserInfo == null) {
            return;
        }
        this.f53897a = StringUtils.string(schoolRecomUserInfo.uid);
        this.f53898b = schoolRecomUserInfo.uname;
        this.f53899c = schoolRecomUserInfo.portrait;
        this.f53900d = schoolRecomUserInfo.institute;
        this.f53901e = schoolRecomUserInfo.is_liked.intValue();
    }
}
