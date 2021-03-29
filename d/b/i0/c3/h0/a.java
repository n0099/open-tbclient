package d.b.i0.c3.h0;

import com.baidu.adp.lib.util.BdLog;
import tbclient.ActHot;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f53366a;

    /* renamed from: b  reason: collision with root package name */
    public int f53367b;

    /* renamed from: c  reason: collision with root package name */
    public int f53368c;

    /* renamed from: d  reason: collision with root package name */
    public String f53369d;

    /* renamed from: e  reason: collision with root package name */
    public String f53370e;

    /* renamed from: f  reason: collision with root package name */
    public String f53371f;

    public String a() {
        return this.f53371f;
    }

    public int b() {
        return this.f53368c;
    }

    public String c() {
        return this.f53366a;
    }

    public int d() {
        return this.f53367b;
    }

    public String e() {
        return this.f53369d;
    }

    public String f() {
        return this.f53370e;
    }

    public void g(ActHot actHot) {
        if (actHot == null) {
            return;
        }
        String str = actHot.bsize;
        if (str != null) {
            try {
                String[] split = str.split(",");
                this.f53367b = d.b.b.e.m.b.d(split[0], 1);
                this.f53368c = d.b.b.e.m.b.d(split[1], 1);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f53367b <= 0) {
            this.f53367b = 1;
        }
        if (this.f53368c <= 0) {
            this.f53368c = 1;
        }
        this.f53366a = actHot.img_src;
        this.f53369d = actHot.link;
        this.f53370e = actHot.author_name;
        this.f53371f = actHot.img_des;
        actHot.img_type.intValue();
    }
}
