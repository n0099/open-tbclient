package g.a.b.b;

import com.baidu.tbadk.core.data.SmallTailInfo;
import g.a.a.a;
/* loaded from: classes7.dex */
public class c implements g.a.a.a {

    /* renamed from: a  reason: collision with root package name */
    public Object f68554a;

    /* renamed from: b  reason: collision with root package name */
    public Object f68555b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f68556c;

    /* renamed from: d  reason: collision with root package name */
    public a.InterfaceC1894a f68557d;

    /* loaded from: classes7.dex */
    public static class a implements a.InterfaceC1894a {

        /* renamed from: a  reason: collision with root package name */
        public String f68558a;

        /* renamed from: b  reason: collision with root package name */
        public g.a.a.b f68559b;

        public a(int i, String str, g.a.a.b bVar, g.a.a.c.b bVar2) {
            this.f68558a = str;
            this.f68559b = bVar;
        }

        public String a() {
            return this.f68558a;
        }

        public g.a.a.b b() {
            return this.f68559b;
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
            return c(h.f68572h);
        }
    }

    public c(a.InterfaceC1894a interfaceC1894a, Object obj, Object obj2, Object[] objArr) {
        this.f68557d = interfaceC1894a;
        this.f68554a = obj;
        this.f68555b = obj2;
        this.f68556c = objArr;
    }

    @Override // g.a.a.a
    public Object getTarget() {
        return this.f68555b;
    }

    public final String toString() {
        return this.f68557d.toString();
    }
}
