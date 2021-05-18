package d.a.k0.d3.h0;

import com.baidu.adp.lib.util.BdLog;
import tbclient.ActHot;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f53773a;

    /* renamed from: b  reason: collision with root package name */
    public int f53774b;

    /* renamed from: c  reason: collision with root package name */
    public int f53775c;

    /* renamed from: d  reason: collision with root package name */
    public String f53776d;

    /* renamed from: e  reason: collision with root package name */
    public String f53777e;

    /* renamed from: f  reason: collision with root package name */
    public String f53778f;

    public String a() {
        return this.f53778f;
    }

    public int b() {
        return this.f53775c;
    }

    public String c() {
        return this.f53773a;
    }

    public int d() {
        return this.f53774b;
    }

    public String e() {
        return this.f53776d;
    }

    public String f() {
        return this.f53777e;
    }

    public void g(ActHot actHot) {
        if (actHot == null) {
            return;
        }
        String str = actHot.bsize;
        if (str != null) {
            try {
                String[] split = str.split(",");
                this.f53774b = d.a.c.e.m.b.d(split[0], 1);
                this.f53775c = d.a.c.e.m.b.d(split[1], 1);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f53774b <= 0) {
            this.f53774b = 1;
        }
        if (this.f53775c <= 0) {
            this.f53775c = 1;
        }
        this.f53773a = actHot.img_src;
        this.f53776d = actHot.link;
        this.f53777e = actHot.author_name;
        this.f53778f = actHot.img_des;
        actHot.img_type.intValue();
    }
}
