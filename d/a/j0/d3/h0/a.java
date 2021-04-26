package d.a.j0.d3.h0;

import com.baidu.adp.lib.util.BdLog;
import tbclient.ActHot;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f53066a;

    /* renamed from: b  reason: collision with root package name */
    public int f53067b;

    /* renamed from: c  reason: collision with root package name */
    public int f53068c;

    /* renamed from: d  reason: collision with root package name */
    public String f53069d;

    /* renamed from: e  reason: collision with root package name */
    public String f53070e;

    /* renamed from: f  reason: collision with root package name */
    public String f53071f;

    public String a() {
        return this.f53071f;
    }

    public int b() {
        return this.f53068c;
    }

    public String c() {
        return this.f53066a;
    }

    public int d() {
        return this.f53067b;
    }

    public String e() {
        return this.f53069d;
    }

    public String f() {
        return this.f53070e;
    }

    public void g(ActHot actHot) {
        if (actHot == null) {
            return;
        }
        String str = actHot.bsize;
        if (str != null) {
            try {
                String[] split = str.split(",");
                this.f53067b = d.a.c.e.m.b.d(split[0], 1);
                this.f53068c = d.a.c.e.m.b.d(split[1], 1);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f53067b <= 0) {
            this.f53067b = 1;
        }
        if (this.f53068c <= 0) {
            this.f53068c = 1;
        }
        this.f53066a = actHot.img_src;
        this.f53069d = actHot.link;
        this.f53070e = actHot.author_name;
        this.f53071f = actHot.img_des;
        actHot.img_type.intValue();
    }
}
