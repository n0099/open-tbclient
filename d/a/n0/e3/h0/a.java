package d.a.n0.e3.h0;

import com.baidu.adp.lib.util.BdLog;
import tbclient.ActHot;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f57675a;

    /* renamed from: b  reason: collision with root package name */
    public int f57676b;

    /* renamed from: c  reason: collision with root package name */
    public int f57677c;

    /* renamed from: d  reason: collision with root package name */
    public String f57678d;

    /* renamed from: e  reason: collision with root package name */
    public String f57679e;

    /* renamed from: f  reason: collision with root package name */
    public String f57680f;

    public String a() {
        return this.f57680f;
    }

    public int b() {
        return this.f57677c;
    }

    public String c() {
        return this.f57675a;
    }

    public int d() {
        return this.f57676b;
    }

    public String e() {
        return this.f57678d;
    }

    public String f() {
        return this.f57679e;
    }

    public void g(ActHot actHot) {
        if (actHot == null) {
            return;
        }
        String str = actHot.bsize;
        if (str != null) {
            try {
                String[] split = str.split(",");
                this.f57676b = d.a.c.e.m.b.d(split[0], 1);
                this.f57677c = d.a.c.e.m.b.d(split[1], 1);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f57676b <= 0) {
            this.f57676b = 1;
        }
        if (this.f57677c <= 0) {
            this.f57677c = 1;
        }
        this.f57675a = actHot.img_src;
        this.f57678d = actHot.link;
        this.f57679e = actHot.author_name;
        this.f57680f = actHot.img_des;
        actHot.img_type.intValue();
    }
}
