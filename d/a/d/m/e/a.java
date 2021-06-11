package d.a.d.m.e;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.a.n0.k1.o.h.b;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements d.a.n0.k1.o.h.b {

    /* renamed from: f  reason: collision with root package name */
    public String f43246f;

    /* renamed from: g  reason: collision with root package name */
    public String f43247g;

    /* renamed from: h  reason: collision with root package name */
    public String f43248h;

    /* renamed from: i  reason: collision with root package name */
    public String f43249i;
    public int j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public boolean r;
    public int s;
    public int t;
    public b.a w;

    /* renamed from: e  reason: collision with root package name */
    public int f43245e = 3;
    public ArrayList<String> u = new ArrayList<>();
    public ArrayList<String> v = new ArrayList<>();

    public int a() {
        return this.f43245e;
    }

    public String b() {
        if (StringUtils.isNull(this.o)) {
            return TbadkCoreApplication.getInst().getResources().getString(R.string.check_detail);
        }
        return this.o;
    }

    public boolean c() {
        return this.f43245e == 2;
    }

    public boolean d() {
        String str;
        if (a() != 0) {
            return a() == 1 && (str = this.l) != null && (str.startsWith("http://") || this.l.startsWith("https://"));
        }
        String str2 = this.k;
        return str2 != null && (str2.startsWith("http://") || this.k.startsWith("https://"));
    }

    public void e(int i2) {
        this.f43245e = i2;
    }

    @Override // d.a.n0.k1.o.h.b
    public b.a getParallelCharge() {
        if (this.w == null) {
            b.a aVar = new b.a();
            this.w = aVar;
            aVar.f60335c = this.u;
            aVar.f60336d = this.v;
        }
        return this.w;
    }
}
