package d.a.h0.l.l.j;

import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.h0.l.k.f;
import d.a.h0.l.k.g;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<C0991a> f47209a;

    /* renamed from: d.a.h0.l.l.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0991a {

        /* renamed from: a  reason: collision with root package name */
        public int f47210a;

        /* renamed from: b  reason: collision with root package name */
        public String f47211b;

        /* renamed from: c  reason: collision with root package name */
        public int f47212c;

        /* renamed from: d  reason: collision with root package name */
        public f f47213d;

        /* renamed from: e  reason: collision with root package name */
        public List<g> f47214e;

        /* renamed from: f  reason: collision with root package name */
        public PMSAppInfo f47215f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f47216g;

        public boolean equals(Object obj) {
            f fVar;
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || (fVar = this.f47213d) == null || !(obj instanceof C0991a)) {
                return false;
            }
            return fVar.equals(((C0991a) obj).f47213d);
        }

        public int hashCode() {
            f fVar = this.f47213d;
            if (fVar == null) {
                return super.hashCode();
            }
            return fVar.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PMS Item: ");
            sb.append(this.f47211b);
            if (this.f47213d != null) {
                sb.append(",pkgMain=");
                sb.append(this.f47213d);
            }
            if (this.f47215f != null) {
                sb.append(",appInfo=");
                sb.append(this.f47215f);
            }
            return sb.toString();
        }
    }
}
