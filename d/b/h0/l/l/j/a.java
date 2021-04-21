package d.b.h0.l.l.j;

import com.baidu.swan.pms.model.PMSAppInfo;
import d.b.h0.l.k.f;
import d.b.h0.l.k.g;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<C1052a> f49697a;

    /* renamed from: d.b.h0.l.l.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1052a {

        /* renamed from: a  reason: collision with root package name */
        public int f49698a;

        /* renamed from: b  reason: collision with root package name */
        public String f49699b;

        /* renamed from: c  reason: collision with root package name */
        public int f49700c;

        /* renamed from: d  reason: collision with root package name */
        public f f49701d;

        /* renamed from: e  reason: collision with root package name */
        public List<g> f49702e;

        /* renamed from: f  reason: collision with root package name */
        public PMSAppInfo f49703f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f49704g;

        public boolean equals(Object obj) {
            f fVar;
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || (fVar = this.f49701d) == null || !(obj instanceof C1052a)) {
                return false;
            }
            return fVar.equals(((C1052a) obj).f49701d);
        }

        public int hashCode() {
            f fVar = this.f49701d;
            if (fVar == null) {
                return super.hashCode();
            }
            return fVar.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PMS Item: ");
            sb.append(this.f49699b);
            if (this.f49701d != null) {
                sb.append(",pkgMain=");
                sb.append(this.f49701d);
            }
            if (this.f49703f != null) {
                sb.append(",appInfo=");
                sb.append(this.f49703f);
            }
            return sb.toString();
        }
    }
}
