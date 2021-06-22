package g.a.b.b;

import com.baidu.tbadk.core.data.SmallTailInfo;
import g.a.a.a;
/* loaded from: classes8.dex */
public class c implements g.a.a.a {

    /* renamed from: a  reason: collision with root package name */
    public Object f71646a;

    /* renamed from: b  reason: collision with root package name */
    public Object f71647b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f71648c;

    /* renamed from: d  reason: collision with root package name */
    public a.InterfaceC1965a f71649d;

    /* loaded from: classes8.dex */
    public static class a implements a.InterfaceC1965a {

        /* renamed from: a  reason: collision with root package name */
        public String f71650a;

        /* renamed from: b  reason: collision with root package name */
        public g.a.a.b f71651b;

        public a(int i2, String str, g.a.a.b bVar, g.a.a.c.b bVar2) {
            this.f71650a = str;
            this.f71651b = bVar;
        }

        public String a() {
            return this.f71650a;
        }

        public g.a.a.b b() {
            return this.f71651b;
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
            return c(h.f71664h);
        }
    }

    public c(a.InterfaceC1965a interfaceC1965a, Object obj, Object obj2, Object[] objArr) {
        this.f71649d = interfaceC1965a;
        this.f71646a = obj;
        this.f71647b = obj2;
        this.f71648c = objArr;
    }

    @Override // g.a.a.a
    public Object getTarget() {
        return this.f71647b;
    }

    public final String toString() {
        return this.f71649d.toString();
    }
}
