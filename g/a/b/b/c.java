package g.a.b.b;

import com.baidu.tbadk.core.data.SmallTailInfo;
import g.a.a.a;
/* loaded from: classes7.dex */
public class c implements g.a.a.a {

    /* renamed from: a  reason: collision with root package name */
    public Object f67557a;

    /* renamed from: b  reason: collision with root package name */
    public Object f67558b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f67559c;

    /* renamed from: d  reason: collision with root package name */
    public a.InterfaceC1845a f67560d;

    /* loaded from: classes7.dex */
    public static class a implements a.InterfaceC1845a {

        /* renamed from: a  reason: collision with root package name */
        public String f67561a;

        /* renamed from: b  reason: collision with root package name */
        public g.a.a.b f67562b;

        public a(int i2, String str, g.a.a.b bVar, g.a.a.c.b bVar2) {
            this.f67561a = str;
            this.f67562b = bVar;
        }

        public String a() {
            return this.f67561a;
        }

        public g.a.a.b b() {
            return this.f67562b;
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
            return c(h.f67575h);
        }
    }

    public c(a.InterfaceC1845a interfaceC1845a, Object obj, Object obj2, Object[] objArr) {
        this.f67560d = interfaceC1845a;
        this.f67557a = obj;
        this.f67558b = obj2;
        this.f67559c = objArr;
    }

    @Override // g.a.a.a
    public Object getTarget() {
        return this.f67558b;
    }

    public final String toString() {
        return this.f67560d.toString();
    }
}
