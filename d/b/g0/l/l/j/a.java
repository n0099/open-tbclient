package d.b.g0.l.l.j;

import com.baidu.swan.pms.model.PMSAppInfo;
import d.b.g0.l.k.f;
import d.b.g0.l.k.g;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<C1032a> f49368a;

    /* renamed from: d.b.g0.l.l.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1032a {

        /* renamed from: a  reason: collision with root package name */
        public int f49369a;

        /* renamed from: b  reason: collision with root package name */
        public String f49370b;

        /* renamed from: c  reason: collision with root package name */
        public int f49371c;

        /* renamed from: d  reason: collision with root package name */
        public f f49372d;

        /* renamed from: e  reason: collision with root package name */
        public List<g> f49373e;

        /* renamed from: f  reason: collision with root package name */
        public PMSAppInfo f49374f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f49375g;

        public boolean equals(Object obj) {
            f fVar;
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || (fVar = this.f49372d) == null || !(obj instanceof C1032a)) {
                return false;
            }
            return fVar.equals(((C1032a) obj).f49372d);
        }

        public int hashCode() {
            f fVar = this.f49372d;
            if (fVar == null) {
                return super.hashCode();
            }
            return fVar.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PMS Item: ");
            sb.append(this.f49370b);
            if (this.f49372d != null) {
                sb.append(",pkgMain=");
                sb.append(this.f49372d);
            }
            if (this.f49374f != null) {
                sb.append(",appInfo=");
                sb.append(this.f49374f);
            }
            return sb.toString();
        }
    }
}
