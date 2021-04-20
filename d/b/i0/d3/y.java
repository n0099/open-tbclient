package d.b.i0.d3;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes3.dex */
public class y {

    /* loaded from: classes3.dex */
    public static class a extends BdAsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteData f55059a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f55060b;

        public a(WriteData writeData, String str) {
            this.f55059a = writeData;
            this.f55060b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            d.b.c.e.d.l<String> g2 = d.b.h0.r.r.a.f().g("tb.pb_editor");
            WriteData writeData = this.f55059a;
            if (writeData != null && writeData.hasContentToSave()) {
                g2.e(y.d(this.f55060b), this.f55059a.toDraftString(), 604800000L);
                return null;
            }
            g2.remove(y.d(this.f55060b));
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends BdAsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteData f55061a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f55062b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f55063c;

        public b(WriteData writeData, boolean z, String str) {
            this.f55061a = writeData;
            this.f55062b = z;
            this.f55063c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            WriteData writeData;
            WriteData writeData2;
            d.b.c.e.d.l<String> g2 = d.b.h0.r.r.a.f().g("tb.pb_editor");
            WriteData writeData3 = this.f55061a;
            if (writeData3 != null && writeData3.hasContentToSave() && !this.f55062b) {
                String draftString = this.f55061a.toDraftString();
                g2.e(y.c(this.f55063c), draftString, 604800000L);
                if ("0".equals(this.f55063c) || (writeData2 = this.f55061a) == null || writeData2.getStatisticFrom() != 1) {
                    return null;
                }
                g2.e(y.c("0"), draftString, 604800000L);
                return null;
            }
            g2.remove(y.c(this.f55063c));
            if ("0".equals(this.f55063c) || (writeData = this.f55061a) == null || writeData.getStatisticFrom() != 1) {
                return null;
            }
            g2.remove(y.c("0"));
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends BdAsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteData f55064a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f55065b;

        public c(WriteData writeData, String str) {
            this.f55064a = writeData;
            this.f55065b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            d.b.c.e.d.l<String> g2 = d.b.h0.r.r.a.f().g("tb.pb_editor");
            WriteData writeData = this.f55064a;
            if (writeData != null && writeData.hasContentToSave()) {
                g2.e(y.e(this.f55065b), this.f55064a.toDraftString(), 604800000L);
                return null;
            }
            g2.remove(y.e(this.f55065b));
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void onDraftLoaded(WriteData writeData);
    }

    /* loaded from: classes3.dex */
    public static class e extends BdAsyncTask<String, String, WriteData> {

        /* renamed from: a  reason: collision with root package name */
        public final d f55066a;

        /* renamed from: b  reason: collision with root package name */
        public final String f55067b;

        public e(String str, d dVar) {
            setPriority(3);
            this.f55066a = dVar;
            this.f55067b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public WriteData doInBackground(String... strArr) {
            String str;
            try {
                str = d.b.h0.r.r.a.f().g("tb.pb_editor").get(this.f55067b);
            } catch (Exception unused) {
                str = null;
            }
            return WriteData.fromDraftString(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(WriteData writeData) {
            super.onPostExecute(writeData);
            d dVar = this.f55066a;
            if (dVar != null) {
                dVar.onDraftLoaded(writeData);
            }
        }
    }

    public static String a(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@evapost" + str;
    }

    public static String b(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@evaluate" + str;
    }

    public static String c(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@frs" + str;
    }

    public static String d(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@pb" + str;
    }

    public static String e(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@subpb" + str;
    }

    public static String f(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@topic" + str;
    }

    public static void g(String str, d dVar) {
        if (str != null) {
            new e(b(str), dVar).execute(new String[0]);
        } else if (dVar != null) {
            dVar.onDraftLoaded(null);
        }
    }

    public static void h(String str, d dVar) {
        if (!d.b.c.e.p.k.isEmpty(str)) {
            new e(c(str), dVar).execute(new String[0]);
        } else if (dVar != null) {
            dVar.onDraftLoaded(null);
        }
    }

    public static void i(String str, d dVar) {
        if (!d.b.c.e.p.k.isEmpty(str)) {
            new e(d(str), dVar).execute(new String[0]);
        } else if (dVar != null) {
            dVar.onDraftLoaded(null);
        }
    }

    public static void j(String str, d dVar) {
        if (!d.b.c.e.p.k.isEmpty(str)) {
            new e(e(str), dVar).execute(new String[0]);
        } else if (dVar != null) {
            dVar.onDraftLoaded(null);
        }
    }

    public static void k(String str, d dVar) {
        if (!d.b.c.e.p.k.isEmpty(str)) {
            new e(f(str), dVar).execute(new String[0]);
        } else if (dVar != null) {
            dVar.onDraftLoaded(null);
        }
    }

    public static void l(String str, d dVar) {
        if (!d.b.c.e.p.k.isEmpty(str)) {
            new e(a(str), dVar).execute(new String[0]);
        } else if (dVar != null) {
            dVar.onDraftLoaded(null);
        }
    }

    public static void m(String str, WriteData writeData) {
        if (str == null) {
            return;
        }
        d.b.c.e.d.l<String> g2 = d.b.h0.r.r.a.f().g("tb.pb_editor");
        if (writeData != null && writeData.hasContentToSave()) {
            g2.e(b(str), writeData.toDraftString(), 604800000L);
            g2.e(b(""), writeData.toDraftString(), 604800000L);
            return;
        }
        g2.remove(b(str));
        g2.remove(b(""));
    }

    public static void n(String str, WriteData writeData) {
        o(str, writeData, false);
    }

    public static void o(String str, WriteData writeData, boolean z) {
        if (d.b.c.e.p.k.isEmpty(str)) {
            return;
        }
        new b(writeData, z, str).execute(new Void[0]);
    }

    public static void p(String str, WriteData writeData) {
        if (d.b.c.e.p.k.isEmpty(str)) {
            return;
        }
        new a(writeData, str).execute(new Void[0]);
    }

    public static void q(String str, WriteData writeData) {
        if (d.b.c.e.p.k.isEmpty(str)) {
            return;
        }
        new c(writeData, str).execute(new Void[0]);
    }

    public static void r(String str, WriteData writeData) {
        if (d.b.c.e.p.k.isEmpty(str)) {
            return;
        }
        d.b.c.e.d.l<String> g2 = d.b.h0.r.r.a.f().g("tb.pb_editor");
        if (writeData != null && writeData.hasContentToSave()) {
            g2.i(f(str), writeData.toDraftString(), 604800000L);
        } else {
            g2.d(f(str));
        }
    }

    public static void s(String str, WriteData writeData) {
        if (d.b.c.e.p.k.isEmpty(str)) {
            return;
        }
        d.b.c.e.d.l<String> g2 = d.b.h0.r.r.a.f().g("tb.pb_editor");
        if (writeData != null) {
            g2.i(a(str), writeData.toDraftString(), 604800000L);
        } else {
            g2.d(a(str));
        }
    }
}
