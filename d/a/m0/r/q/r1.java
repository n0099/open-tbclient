package d.a.m0.r.q;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes3.dex */
public class r1 {

    /* renamed from: a  reason: collision with root package name */
    public String f53790a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f53791b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f53792c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f53793d = "";

    /* renamed from: e  reason: collision with root package name */
    public int f53794e = -1;

    public String a() {
        return this.f53793d;
    }

    public int b() {
        return this.f53794e;
    }

    public String c() {
        return this.f53792c;
    }

    public String d() {
        return this.f53790a;
    }

    public String e() {
        return this.f53791b;
    }

    public void f(SchoolRecomUserInfo schoolRecomUserInfo) {
        if (schoolRecomUserInfo == null) {
            return;
        }
        this.f53790a = StringUtils.string(schoolRecomUserInfo.uid);
        this.f53791b = schoolRecomUserInfo.uname;
        this.f53792c = schoolRecomUserInfo.portrait;
        this.f53793d = schoolRecomUserInfo.institute;
        this.f53794e = schoolRecomUserInfo.is_liked.intValue();
    }
}
