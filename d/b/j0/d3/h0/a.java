package d.b.j0.d3.h0;

import com.baidu.adp.lib.util.BdLog;
import tbclient.ActHot;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f55229a;

    /* renamed from: b  reason: collision with root package name */
    public int f55230b;

    /* renamed from: c  reason: collision with root package name */
    public int f55231c;

    /* renamed from: d  reason: collision with root package name */
    public String f55232d;

    /* renamed from: e  reason: collision with root package name */
    public String f55233e;

    /* renamed from: f  reason: collision with root package name */
    public String f55234f;

    public String a() {
        return this.f55234f;
    }

    public int b() {
        return this.f55231c;
    }

    public String c() {
        return this.f55229a;
    }

    public int d() {
        return this.f55230b;
    }

    public String e() {
        return this.f55232d;
    }

    public String f() {
        return this.f55233e;
    }

    public void g(ActHot actHot) {
        if (actHot == null) {
            return;
        }
        String str = actHot.bsize;
        if (str != null) {
            try {
                String[] split = str.split(",");
                this.f55230b = d.b.c.e.m.b.d(split[0], 1);
                this.f55231c = d.b.c.e.m.b.d(split[1], 1);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f55230b <= 0) {
            this.f55230b = 1;
        }
        if (this.f55231c <= 0) {
            this.f55231c = 1;
        }
        this.f55229a = actHot.img_src;
        this.f55232d = actHot.link;
        this.f55233e = actHot.author_name;
        this.f55234f = actHot.img_des;
        actHot.img_type.intValue();
    }
}
