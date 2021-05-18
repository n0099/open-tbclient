package g.a.b.b;

import com.baidu.tbadk.core.data.SmallTailInfo;
import g.a.a.a;
/* loaded from: classes7.dex */
public class c implements g.a.a.a {

    /* renamed from: a  reason: collision with root package name */
    public Object f68243a;

    /* renamed from: b  reason: collision with root package name */
    public Object f68244b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f68245c;

    /* renamed from: d  reason: collision with root package name */
    public a.InterfaceC1909a f68246d;

    /* loaded from: classes7.dex */
    public static class a implements a.InterfaceC1909a {

        /* renamed from: a  reason: collision with root package name */
        public String f68247a;

        /* renamed from: b  reason: collision with root package name */
        public g.a.a.b f68248b;

        public a(int i2, String str, g.a.a.b bVar, g.a.a.c.b bVar2) {
            this.f68247a = str;
            this.f68248b = bVar;
        }

        public String a() {
            return this.f68247a;
        }

        public g.a.a.b b() {
            return this.f68248b;
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
            return c(h.f68261h);
        }
    }

    public c(a.InterfaceC1909a interfaceC1909a, Object obj, Object obj2, Object[] objArr) {
        this.f68246d = interfaceC1909a;
        this.f68243a = obj;
        this.f68244b = obj2;
        this.f68245c = objArr;
    }

    @Override // g.a.a.a
    public Object getTarget() {
        return this.f68244b;
    }

    public final String toString() {
        return this.f68246d.toString();
    }
}
