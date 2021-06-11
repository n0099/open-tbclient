package d.a.y.d;
/* loaded from: classes2.dex */
public class a implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public String[] f68596e;

    /* renamed from: h  reason: collision with root package name */
    public String f68599h;

    /* renamed from: f  reason: collision with root package name */
    public String f68597f = null;

    /* renamed from: g  reason: collision with root package name */
    public boolean f68598g = false;

    /* renamed from: i  reason: collision with root package name */
    public C1877a f68600i = new C1877a();
    public b j = new b();

    /* renamed from: d.a.y.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1877a implements Cloneable {

        /* renamed from: e  reason: collision with root package name */
        public int f68601e = 0;

        /* renamed from: f  reason: collision with root package name */
        public float f68602f = 0.0f;

        /* renamed from: g  reason: collision with root package name */
        public float f68603g = 0.0f;

        /* JADX DEBUG: Method merged with bridge method */
        /* renamed from: b */
        public C1877a clone() {
            C1877a c1877a = (C1877a) super.clone();
            c1877a.f68601e = this.f68601e;
            c1877a.f68602f = this.f68602f;
            c1877a.f68603g = this.f68603g;
            return c1877a;
        }

        public boolean c() {
            int i2 = this.f68601e;
            if (i2 < 0 || i2 > 1) {
                return false;
            }
            float f2 = this.f68602f;
            if (f2 < 0.0f || f2 > 16.0f) {
                return false;
            }
            float f3 = this.f68603g;
            return f3 >= 0.0f && f3 <= 24.0f;
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Cloneable {

        /* renamed from: e  reason: collision with root package name */
        public int f68604e;

        /* renamed from: f  reason: collision with root package name */
        public int f68605f;

        /* renamed from: g  reason: collision with root package name */
        public int f68606g;

        /* renamed from: h  reason: collision with root package name */
        public int f68607h = 0;

        /* renamed from: i  reason: collision with root package name */
        public float f68608i = 0.0f;
        public float j = 0.0f;

        /* JADX DEBUG: Method merged with bridge method */
        /* renamed from: b */
        public b clone() {
            b bVar = (b) super.clone();
            bVar.f68604e = this.f68604e;
            bVar.f68605f = this.f68605f;
            bVar.f68606g = this.f68606g;
            bVar.f68607h = this.f68607h;
            bVar.f68608i = this.f68608i;
            bVar.j = this.j;
            return bVar;
        }
    }

    public a(String str) {
        this.f68599h = null;
        this.f68599h = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: b */
    public a clone() {
        a aVar = (a) super.clone();
        String[] strArr = this.f68596e;
        aVar.f68596e = strArr != null ? (String[]) strArr.clone() : null;
        aVar.f68597f = new String(this.f68597f);
        aVar.f68598g = this.f68598g;
        aVar.f68600i = this.f68600i.clone();
        aVar.j = this.j.clone();
        return aVar;
    }

    public boolean c() {
        C1877a c1877a = this.f68600i;
        return (c1877a != null ? Boolean.valueOf(c1877a.c()) : null).booleanValue();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n======================");
        sb.append(this.f68599h);
        sb.append(" Player Server config information====================== \n");
        sb.append("host : \n");
        int i2 = 0;
        while (true) {
            String[] strArr = this.f68596e;
            if (strArr == null || i2 >= strArr.length) {
                break;
            }
            sb.append("    " + this.f68596e[i2] + "\n");
            i2++;
        }
        sb.append("cntlId : \n    " + this.f68597f + ";\n");
        sb.append("pcdnSwitch : \n    " + this.f68598g + ";\n");
        sb.append("CdnConfig : \n    ");
        sb.append("sle : " + this.f68600i.f68601e + ", sl_rate : " + this.f68600i.f68602f + ", split_rate : " + this.f68600i.f68603g + ";\n");
        sb.append("PrefetchConfig : \n    ");
        sb.append("duration : " + this.j.f68604e + " pcdnEnable : " + this.j.f68605f + " p2pEnable : " + this.j.f68606g + " sl : " + this.j.f68607h + " sle : " + this.j.f68608i + " split_rate : " + this.j.j + ";\n");
        return sb.toString();
    }
}
