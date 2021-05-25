package d.a.n0.w3.m;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.a.c.e.d.l;
import d.a.m0.z0.f0;
import d.a.m0.z0.h0;
import d.a.m0.z0.n;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: d.a.n0.w3.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1715a extends f0<Integer> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f62877a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f62878b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f62879c;

        public C1715a(int i2, String str, String str2) {
            this.f62877a = i2;
            this.f62878b = str;
            this.f62879c = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.m0.z0.f0
        public Integer doInBackground() {
            int i2 = this.f62877a;
            d.a.m0.r.r.a f2 = d.a.m0.r.r.a.f();
            l<String> g2 = f2.g("tb.write_privacy_state_space" + this.f62878b);
            if (g2 != null) {
                i2 = d.a.c.e.m.b.d(g2.get(this.f62879c), this.f62877a);
            }
            return Integer.valueOf(i2);
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements n<Integer> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f62880a;

        public b(c cVar) {
            this.f62880a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Integer num) {
            c cVar = this.f62880a;
            if (cVar != null) {
                cVar.a(num.intValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(int i2);
    }

    public static void a(String str, int i2, c cVar) {
        if (StringUtils.isNull(str) || cVar == null) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (StringUtils.isNull(currentAccount)) {
            return;
        }
        h0.b(new C1715a(i2, currentAccount, str), new b(cVar));
    }

    public static void b(String str, int i2) {
        if (StringUtils.isNull(str)) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (StringUtils.isNull(currentAccount)) {
            return;
        }
        d.a.m0.r.r.a f2 = d.a.m0.r.r.a.f();
        l<String> g2 = f2.g("tb.write_privacy_state_space" + currentAccount);
        if (g2 != null) {
            g2.a(str, String.valueOf(i2));
        }
    }
}
