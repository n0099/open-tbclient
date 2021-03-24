package d.b.c.m.e;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.b.i0.i1.o.h.b;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements d.b.i0.i1.o.h.b {

    /* renamed from: f  reason: collision with root package name */
    public String f42518f;

    /* renamed from: g  reason: collision with root package name */
    public String f42519g;

    /* renamed from: h  reason: collision with root package name */
    public String f42520h;
    public String i;
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
    public int f42517e = 3;
    public ArrayList<String> u = new ArrayList<>();
    public ArrayList<String> v = new ArrayList<>();

    public int a() {
        return this.f42517e;
    }

    public String b() {
        if (StringUtils.isNull(this.o)) {
            return TbadkCoreApplication.getInst().getResources().getString(R.string.check_detail);
        }
        return this.o;
    }

    public boolean c() {
        return this.f42517e == 2;
    }

    public boolean d() {
        String str;
        if (a() != 0) {
            return a() == 1 && (str = this.l) != null && (str.startsWith("http://") || this.l.startsWith("https://"));
        }
        String str2 = this.k;
        return str2 != null && (str2.startsWith("http://") || this.k.startsWith("https://"));
    }

    public void e(int i) {
        this.f42517e = i;
    }

    @Override // d.b.i0.i1.o.h.b
    public b.a getParallelCharge() {
        if (this.w == null) {
            b.a aVar = new b.a();
            this.w = aVar;
            aVar.f55925c = this.u;
            aVar.f55926d = this.v;
        }
        return this.w;
    }
}
