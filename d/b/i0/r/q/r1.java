package d.b.i0.r.q;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes3.dex */
public class r1 {

    /* renamed from: a  reason: collision with root package name */
    public String f51619a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f51620b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f51621c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f51622d = "";

    /* renamed from: e  reason: collision with root package name */
    public int f51623e = -1;

    public String a() {
        return this.f51622d;
    }

    public int b() {
        return this.f51623e;
    }

    public String c() {
        return this.f51621c;
    }

    public String d() {
        return this.f51619a;
    }

    public String e() {
        return this.f51620b;
    }

    public void f(SchoolRecomUserInfo schoolRecomUserInfo) {
        if (schoolRecomUserInfo == null) {
            return;
        }
        this.f51619a = StringUtils.string(schoolRecomUserInfo.uid);
        this.f51620b = schoolRecomUserInfo.uname;
        this.f51621c = schoolRecomUserInfo.portrait;
        this.f51622d = schoolRecomUserInfo.institute;
        this.f51623e = schoolRecomUserInfo.is_liked.intValue();
    }
}
