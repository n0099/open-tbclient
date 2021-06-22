package d.a.y.d;
/* loaded from: classes2.dex */
public class a implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public String[] f68700e;

    /* renamed from: h  reason: collision with root package name */
    public String f68703h;

    /* renamed from: f  reason: collision with root package name */
    public String f68701f = null;

    /* renamed from: g  reason: collision with root package name */
    public boolean f68702g = false;

    /* renamed from: i  reason: collision with root package name */
    public C1880a f68704i = new C1880a();
    public b j = new b();

    /* renamed from: d.a.y.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1880a implements Cloneable {

        /* renamed from: e  reason: collision with root package name */
        public int f68705e = 0;

        /* renamed from: f  reason: collision with root package name */
        public float f68706f = 0.0f;

        /* renamed from: g  reason: collision with root package name */
        public float f68707g = 0.0f;

        /* JADX DEBUG: Method merged with bridge method */
        /* renamed from: b */
        public C1880a clone() {
            C1880a c1880a = (C1880a) super.clone();
            c1880a.f68705e = this.f68705e;
            c1880a.f68706f = this.f68706f;
            c1880a.f68707g = this.f68707g;
            return c1880a;
        }

        public boolean c() {
            int i2 = this.f68705e;
            if (i2 < 0 || i2 > 1) {
                return false;
            }
            float f2 = this.f68706f;
            if (f2 < 0.0f || f2 > 16.0f) {
                return false;
            }
            float f3 = this.f68707g;
            return f3 >= 0.0f && f3 <= 24.0f;
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Cloneable {

        /* renamed from: e  reason: collision with root package name */
        public int f68708e;

        /* renamed from: f  reason: collision with root package name */
        public int f68709f;

        /* renamed from: g  reason: collision with root package name */
        public int f68710g;

        /* renamed from: h  reason: collision with root package name */
        public int f68711h = 0;

        /* renamed from: i  reason: collision with root package name */
        public float f68712i = 0.0f;
        public float j = 0.0f;

        /* JADX DEBUG: Method merged with bridge method */
        /* renamed from: b */
        public b clone() {
            b bVar = (b) super.clone();
            bVar.f68708e = this.f68708e;
            bVar.f68709f = this.f68709f;
            bVar.f68710g = this.f68710g;
            bVar.f68711h = this.f68711h;
            bVar.f68712i = this.f68712i;
            bVar.j = this.j;
            return bVar;
        }
    }

    public a(String str) {
        this.f68703h = null;
        this.f68703h = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: b */
    public a clone() {
        a aVar = (a) super.clone();
        String[] strArr = this.f68700e;
        aVar.f68700e = strArr != null ? (String[]) strArr.clone() : null;
        aVar.f68701f = new String(this.f68701f);
        aVar.f68702g = this.f68702g;
        aVar.f68704i = this.f68704i.clone();
        aVar.j = this.j.clone();
        return aVar;
    }

    public boolean c() {
        C1880a c1880a = this.f68704i;
        return (c1880a != null ? Boolean.valueOf(c1880a.c()) : null).booleanValue();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n======================");
        sb.append(this.f68703h);
        sb.append(" Player Server config information====================== \n");
        sb.append("host : \n");
        int i2 = 0;
        while (true) {
            String[] strArr = this.f68700e;
            if (strArr == null || i2 >= strArr.length) {
                break;
            }
            sb.append("    " + this.f68700e[i2] + "\n");
            i2++;
        }
        sb.append("cntlId : \n    " + this.f68701f + ";\n");
        sb.append("pcdnSwitch : \n    " + this.f68702g + ";\n");
        sb.append("CdnConfig : \n    ");
        sb.append("sle : " + this.f68704i.f68705e + ", sl_rate : " + this.f68704i.f68706f + ", split_rate : " + this.f68704i.f68707g + ";\n");
        sb.append("PrefetchConfig : \n    ");
        sb.append("duration : " + this.j.f68708e + " pcdnEnable : " + this.j.f68709f + " p2pEnable : " + this.j.f68710g + " sl : " + this.j.f68711h + " sle : " + this.j.f68712i + " split_rate : " + this.j.j + ";\n");
        return sb.toString();
    }
}
