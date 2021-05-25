package g.a.b.b;

import com.baidu.tbadk.core.data.SmallTailInfo;
import g.a.a.a;
/* loaded from: classes7.dex */
public class c implements g.a.a.a {

    /* renamed from: a  reason: collision with root package name */
    public Object f68286a;

    /* renamed from: b  reason: collision with root package name */
    public Object f68287b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f68288c;

    /* renamed from: d  reason: collision with root package name */
    public a.InterfaceC1913a f68289d;

    /* loaded from: classes7.dex */
    public static class a implements a.InterfaceC1913a {

        /* renamed from: a  reason: collision with root package name */
        public String f68290a;

        /* renamed from: b  reason: collision with root package name */
        public g.a.a.b f68291b;

        public a(int i2, String str, g.a.a.b bVar, g.a.a.c.b bVar2) {
            this.f68290a = str;
            this.f68291b = bVar;
        }

        public String a() {
            return this.f68290a;
        }

        public g.a.a.b b() {
            return this.f68291b;
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
            return c(h.f68304h);
        }
    }

    public c(a.InterfaceC1913a interfaceC1913a, Object obj, Object obj2, Object[] objArr) {
        this.f68289d = interfaceC1913a;
        this.f68286a = obj;
        this.f68287b = obj2;
        this.f68288c = objArr;
    }

    @Override // g.a.a.a
    public Object getTarget() {
        return this.f68287b;
    }

    public final String toString() {
        return this.f68289d.toString();
    }
}
