package d.a.o0.e3.h0;

import com.baidu.adp.lib.util.BdLog;
import tbclient.ActHot;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f57800a;

    /* renamed from: b  reason: collision with root package name */
    public int f57801b;

    /* renamed from: c  reason: collision with root package name */
    public int f57802c;

    /* renamed from: d  reason: collision with root package name */
    public String f57803d;

    /* renamed from: e  reason: collision with root package name */
    public String f57804e;

    /* renamed from: f  reason: collision with root package name */
    public String f57805f;

    public String a() {
        return this.f57805f;
    }

    public int b() {
        return this.f57802c;
    }

    public String c() {
        return this.f57800a;
    }

    public int d() {
        return this.f57801b;
    }

    public String e() {
        return this.f57803d;
    }

    public String f() {
        return this.f57804e;
    }

    public void g(ActHot actHot) {
        if (actHot == null) {
            return;
        }
        String str = actHot.bsize;
        if (str != null) {
            try {
                String[] split = str.split(",");
                this.f57801b = d.a.c.e.m.b.d(split[0], 1);
                this.f57802c = d.a.c.e.m.b.d(split[1], 1);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f57801b <= 0) {
            this.f57801b = 1;
        }
        if (this.f57802c <= 0) {
            this.f57802c = 1;
        }
        this.f57800a = actHot.img_src;
        this.f57803d = actHot.link;
        this.f57804e = actHot.author_name;
        this.f57805f = actHot.img_des;
        actHot.img_type.intValue();
    }
}
