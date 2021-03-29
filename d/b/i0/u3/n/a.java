package d.b.i0.u3.n;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.b.b.e.d.l;
import d.b.h0.z0.f0;
import d.b.h0.z0.h0;
import d.b.h0.z0.n;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: d.b.i0.u3.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1617a extends f0<Integer> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f61650a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f61651b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f61652c;

        public C1617a(int i, String str, String str2) {
            this.f61650a = i;
            this.f61651b = str;
            this.f61652c = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.b.h0.z0.f0
        public Integer doInBackground() {
            int i = this.f61650a;
            d.b.h0.r.r.a f2 = d.b.h0.r.r.a.f();
            l<String> g2 = f2.g("tb.write_privacy_state_space" + this.f61651b);
            if (g2 != null) {
                i = d.b.b.e.m.b.d(g2.get(this.f61652c), this.f61650a);
            }
            return Integer.valueOf(i);
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements n<Integer> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f61653a;

        public b(c cVar) {
            this.f61653a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Integer num) {
            c cVar = this.f61653a;
            if (cVar != null) {
                cVar.a(num.intValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(int i);
    }

    public static void a(String str, int i, c cVar) {
        if (StringUtils.isNull(str) || cVar == null) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (StringUtils.isNull(currentAccount)) {
            return;
        }
        h0.b(new C1617a(i, currentAccount, str), new b(cVar));
    }

    public static void b(String str, int i) {
        if (StringUtils.isNull(str)) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (StringUtils.isNull(currentAccount)) {
            return;
        }
        d.b.h0.r.r.a f2 = d.b.h0.r.r.a.f();
        l<String> g2 = f2.g("tb.write_privacy_state_space" + currentAccount);
        if (g2 != null) {
            g2.a(str, String.valueOf(i));
        }
    }
}
