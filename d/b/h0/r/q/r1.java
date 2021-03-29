package d.b.h0.r.q;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes3.dex */
public class r1 {

    /* renamed from: a  reason: collision with root package name */
    public String f50876a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f50877b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f50878c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f50879d = "";

    /* renamed from: e  reason: collision with root package name */
    public int f50880e = -1;

    public String a() {
        return this.f50879d;
    }

    public int b() {
        return this.f50880e;
    }

    public String c() {
        return this.f50878c;
    }

    public String d() {
        return this.f50876a;
    }

    public String e() {
        return this.f50877b;
    }

    public void f(SchoolRecomUserInfo schoolRecomUserInfo) {
        if (schoolRecomUserInfo == null) {
            return;
        }
        this.f50876a = StringUtils.string(schoolRecomUserInfo.uid);
        this.f50877b = schoolRecomUserInfo.uname;
        this.f50878c = schoolRecomUserInfo.portrait;
        this.f50879d = schoolRecomUserInfo.institute;
        this.f50880e = schoolRecomUserInfo.is_liked.intValue();
    }
}
