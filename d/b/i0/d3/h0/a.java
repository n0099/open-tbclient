package d.b.i0.d3.h0;

import com.baidu.adp.lib.util.BdLog;
import tbclient.ActHot;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f54808a;

    /* renamed from: b  reason: collision with root package name */
    public int f54809b;

    /* renamed from: c  reason: collision with root package name */
    public int f54810c;

    /* renamed from: d  reason: collision with root package name */
    public String f54811d;

    /* renamed from: e  reason: collision with root package name */
    public String f54812e;

    /* renamed from: f  reason: collision with root package name */
    public String f54813f;

    public String a() {
        return this.f54813f;
    }

    public int b() {
        return this.f54810c;
    }

    public String c() {
        return this.f54808a;
    }

    public int d() {
        return this.f54809b;
    }

    public String e() {
        return this.f54811d;
    }

    public String f() {
        return this.f54812e;
    }

    public void g(ActHot actHot) {
        if (actHot == null) {
            return;
        }
        String str = actHot.bsize;
        if (str != null) {
            try {
                String[] split = str.split(",");
                this.f54809b = d.b.c.e.m.b.d(split[0], 1);
                this.f54810c = d.b.c.e.m.b.d(split[1], 1);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f54809b <= 0) {
            this.f54809b = 1;
        }
        if (this.f54810c <= 0) {
            this.f54810c = 1;
        }
        this.f54808a = actHot.img_src;
        this.f54811d = actHot.link;
        this.f54812e = actHot.author_name;
        this.f54813f = actHot.img_des;
        actHot.img_type.intValue();
    }
}
