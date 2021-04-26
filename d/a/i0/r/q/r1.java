package d.a.i0.r.q;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes3.dex */
public class r1 {

    /* renamed from: a  reason: collision with root package name */
    public String f49251a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f49252b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f49253c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f49254d = "";

    /* renamed from: e  reason: collision with root package name */
    public int f49255e = -1;

    public String a() {
        return this.f49254d;
    }

    public int b() {
        return this.f49255e;
    }

    public String c() {
        return this.f49253c;
    }

    public String d() {
        return this.f49251a;
    }

    public String e() {
        return this.f49252b;
    }

    public void f(SchoolRecomUserInfo schoolRecomUserInfo) {
        if (schoolRecomUserInfo == null) {
            return;
        }
        this.f49251a = StringUtils.string(schoolRecomUserInfo.uid);
        this.f49252b = schoolRecomUserInfo.uname;
        this.f49253c = schoolRecomUserInfo.portrait;
        this.f49254d = schoolRecomUserInfo.institute;
        this.f49255e = schoolRecomUserInfo.is_liked.intValue();
    }
}
