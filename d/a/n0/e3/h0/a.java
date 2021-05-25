package d.a.n0.e3.h0;

import com.baidu.adp.lib.util.BdLog;
import tbclient.ActHot;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f53986a;

    /* renamed from: b  reason: collision with root package name */
    public int f53987b;

    /* renamed from: c  reason: collision with root package name */
    public int f53988c;

    /* renamed from: d  reason: collision with root package name */
    public String f53989d;

    /* renamed from: e  reason: collision with root package name */
    public String f53990e;

    /* renamed from: f  reason: collision with root package name */
    public String f53991f;

    public String a() {
        return this.f53991f;
    }

    public int b() {
        return this.f53988c;
    }

    public String c() {
        return this.f53986a;
    }

    public int d() {
        return this.f53987b;
    }

    public String e() {
        return this.f53989d;
    }

    public String f() {
        return this.f53990e;
    }

    public void g(ActHot actHot) {
        if (actHot == null) {
            return;
        }
        String str = actHot.bsize;
        if (str != null) {
            try {
                String[] split = str.split(",");
                this.f53987b = d.a.c.e.m.b.d(split[0], 1);
                this.f53988c = d.a.c.e.m.b.d(split[1], 1);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f53987b <= 0) {
            this.f53987b = 1;
        }
        if (this.f53988c <= 0) {
            this.f53988c = 1;
        }
        this.f53986a = actHot.img_src;
        this.f53989d = actHot.link;
        this.f53990e = actHot.author_name;
        this.f53991f = actHot.img_des;
        actHot.img_type.intValue();
    }
}
