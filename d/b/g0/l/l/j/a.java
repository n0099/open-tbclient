package d.b.g0.l.l.j;

import com.baidu.swan.pms.model.PMSAppInfo;
import d.b.g0.l.k.f;
import d.b.g0.l.k.g;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<C1019a> f48975a;

    /* renamed from: d.b.g0.l.l.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1019a {

        /* renamed from: a  reason: collision with root package name */
        public int f48976a;

        /* renamed from: b  reason: collision with root package name */
        public String f48977b;

        /* renamed from: c  reason: collision with root package name */
        public int f48978c;

        /* renamed from: d  reason: collision with root package name */
        public f f48979d;

        /* renamed from: e  reason: collision with root package name */
        public List<g> f48980e;

        /* renamed from: f  reason: collision with root package name */
        public PMSAppInfo f48981f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f48982g;

        public boolean equals(Object obj) {
            f fVar;
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || (fVar = this.f48979d) == null || !(obj instanceof C1019a)) {
                return false;
            }
            return fVar.equals(((C1019a) obj).f48979d);
        }

        public int hashCode() {
            f fVar = this.f48979d;
            if (fVar == null) {
                return super.hashCode();
            }
            return fVar.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PMS Item: ");
            sb.append(this.f48977b);
            if (this.f48979d != null) {
                sb.append(",pkgMain=");
                sb.append(this.f48979d);
            }
            if (this.f48981f != null) {
                sb.append(",appInfo=");
                sb.append(this.f48981f);
            }
            return sb.toString();
        }
    }
}
