package d.b.h0.r.q;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes3.dex */
public class r1 {

    /* renamed from: a  reason: collision with root package name */
    public String f50875a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f50876b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f50877c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f50878d = "";

    /* renamed from: e  reason: collision with root package name */
    public int f50879e = -1;

    public String a() {
        return this.f50878d;
    }

    public int b() {
        return this.f50879e;
    }

    public String c() {
        return this.f50877c;
    }

    public String d() {
        return this.f50875a;
    }

    public String e() {
        return this.f50876b;
    }

    public void f(SchoolRecomUserInfo schoolRecomUserInfo) {
        if (schoolRecomUserInfo == null) {
            return;
        }
        this.f50875a = StringUtils.string(schoolRecomUserInfo.uid);
        this.f50876b = schoolRecomUserInfo.uname;
        this.f50877c = schoolRecomUserInfo.portrait;
        this.f50878d = schoolRecomUserInfo.institute;
        this.f50879e = schoolRecomUserInfo.is_liked.intValue();
    }
}
