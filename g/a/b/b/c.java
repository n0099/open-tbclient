package g.a.b.b;

import com.baidu.tbadk.core.data.SmallTailInfo;
import g.a.a.a;
/* loaded from: classes7.dex */
public class c implements g.a.a.a {

    /* renamed from: a  reason: collision with root package name */
    public Object f67543a;

    /* renamed from: b  reason: collision with root package name */
    public Object f67544b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f67545c;

    /* renamed from: d  reason: collision with root package name */
    public a.InterfaceC1858a f67546d;

    /* loaded from: classes7.dex */
    public static class a implements a.InterfaceC1858a {

        /* renamed from: a  reason: collision with root package name */
        public String f67547a;

        /* renamed from: b  reason: collision with root package name */
        public g.a.a.b f67548b;

        public a(int i, String str, g.a.a.b bVar, g.a.a.c.b bVar2) {
            this.f67547a = str;
            this.f67548b = bVar;
        }

        public String a() {
            return this.f67547a;
        }

        public g.a.a.b b() {
            return this.f67548b;
        }

        public String c(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.d(a()));
            stringBuffer.append("(");
            stringBuffer.append(((f) b()).k(hVar));
            stringBuffer.append(SmallTailInfo.EMOTION_SUFFIX);
            return stringBuffer.toString();
        }

        public final String toString() {
            return c(h.f67561h);
        }
    }

    public c(a.InterfaceC1858a interfaceC1858a, Object obj, Object obj2, Object[] objArr) {
        this.f67546d = interfaceC1858a;
        this.f67543a = obj;
        this.f67544b = obj2;
        this.f67545c = objArr;
    }

    @Override // g.a.a.a
    public Object getTarget() {
        return this.f67544b;
    }

    public final String toString() {
        return this.f67546d.toString();
    }
}
