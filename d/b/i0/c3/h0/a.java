package d.b.i0.c3.h0;

import com.baidu.adp.lib.util.BdLog;
import tbclient.ActHot;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f53365a;

    /* renamed from: b  reason: collision with root package name */
    public int f53366b;

    /* renamed from: c  reason: collision with root package name */
    public int f53367c;

    /* renamed from: d  reason: collision with root package name */
    public String f53368d;

    /* renamed from: e  reason: collision with root package name */
    public String f53369e;

    /* renamed from: f  reason: collision with root package name */
    public String f53370f;

    public String a() {
        return this.f53370f;
    }

    public int b() {
        return this.f53367c;
    }

    public String c() {
        return this.f53365a;
    }

    public int d() {
        return this.f53366b;
    }

    public String e() {
        return this.f53368d;
    }

    public String f() {
        return this.f53369e;
    }

    public void g(ActHot actHot) {
        if (actHot == null) {
            return;
        }
        String str = actHot.bsize;
        if (str != null) {
            try {
                String[] split = str.split(",");
                this.f53366b = d.b.b.e.m.b.d(split[0], 1);
                this.f53367c = d.b.b.e.m.b.d(split[1], 1);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f53366b <= 0) {
            this.f53366b = 1;
        }
        if (this.f53367c <= 0) {
            this.f53367c = 1;
        }
        this.f53365a = actHot.img_src;
        this.f53368d = actHot.link;
        this.f53369e = actHot.author_name;
        this.f53370f = actHot.img_des;
        actHot.img_type.intValue();
    }
}
