package d.b.i0.c3;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes5.dex */
public class y {

    /* loaded from: classes5.dex */
    public static class a extends BdAsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteData f53614a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f53615b;

        public a(WriteData writeData, String str) {
            this.f53614a = writeData;
            this.f53615b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            d.b.b.e.d.l<String> g2 = d.b.h0.r.r.a.f().g("tb.pb_editor");
            WriteData writeData = this.f53614a;
            if (writeData != null && writeData.hasContentToSave()) {
                g2.e(y.d(this.f53615b), this.f53614a.toDraftString(), 604800000L);
                return null;
            }
            g2.remove(y.d(this.f53615b));
            return null;
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends BdAsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteData f53616a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f53617b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f53618c;

        public b(WriteData writeData, boolean z, String str) {
            this.f53616a = writeData;
            this.f53617b = z;
            this.f53618c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            WriteData writeData;
            WriteData writeData2;
            d.b.b.e.d.l<String> g2 = d.b.h0.r.r.a.f().g("tb.pb_editor");
            WriteData writeData3 = this.f53616a;
            if (writeData3 != null && writeData3.hasContentToSave() && !this.f53617b) {
                String draftString = this.f53616a.toDraftString();
                g2.e(y.c(this.f53618c), draftString, 604800000L);
                if ("0".equals(this.f53618c) || (writeData2 = this.f53616a) == null || writeData2.getStatisticFrom() != 1) {
                    return null;
                }
                g2.e(y.c("0"), draftString, 604800000L);
                return null;
            }
            g2.remove(y.c(this.f53618c));
            if ("0".equals(this.f53618c) || (writeData = this.f53616a) == null || writeData.getStatisticFrom() != 1) {
                return null;
            }
            g2.remove(y.c("0"));
            return null;
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends BdAsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteData f53619a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f53620b;

        public c(WriteData writeData, String str) {
            this.f53619a = writeData;
            this.f53620b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            d.b.b.e.d.l<String> g2 = d.b.h0.r.r.a.f().g("tb.pb_editor");
            WriteData writeData = this.f53619a;
            if (writeData != null && writeData.hasContentToSave()) {
                g2.e(y.e(this.f53620b), this.f53619a.toDraftString(), 604800000L);
                return null;
            }
            g2.remove(y.e(this.f53620b));
            return null;
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        void onDraftLoaded(WriteData writeData);
    }

    /* loaded from: classes5.dex */
    public static class e extends BdAsyncTask<String, String, WriteData> {

        /* renamed from: a  reason: collision with root package name */
        public final d f53621a;

        /* renamed from: b  reason: collision with root package name */
        public final String f53622b;

        public e(String str, d dVar) {
            setPriority(3);
            this.f53621a = dVar;
            this.f53622b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public WriteData doInBackground(String... strArr) {
            String str;
            try {
                str = d.b.h0.r.r.a.f().g("tb.pb_editor").get(this.f53622b);
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
            d dVar = this.f53621a;
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
        if (!d.b.b.e.p.k.isEmpty(str)) {
            new e(c(str), dVar).execute(new String[0]);
        } else if (dVar != null) {
            dVar.onDraftLoaded(null);
        }
    }

    public static void i(String str, d dVar) {
        if (!d.b.b.e.p.k.isEmpty(str)) {
            new e(d(str), dVar).execute(new String[0]);
        } else if (dVar != null) {
            dVar.onDraftLoaded(null);
        }
    }

    public static void j(String str, d dVar) {
        if (!d.b.b.e.p.k.isEmpty(str)) {
            new e(e(str), dVar).execute(new String[0]);
        } else if (dVar != null) {
            dVar.onDraftLoaded(null);
        }
    }

    public static void k(String str, d dVar) {
        if (!d.b.b.e.p.k.isEmpty(str)) {
            new e(f(str), dVar).execute(new String[0]);
        } else if (dVar != null) {
            dVar.onDraftLoaded(null);
        }
    }

    public static void l(String str, d dVar) {
        if (!d.b.b.e.p.k.isEmpty(str)) {
            new e(a(str), dVar).execute(new String[0]);
        } else if (dVar != null) {
            dVar.onDraftLoaded(null);
        }
    }

    public static void m(String str, WriteData writeData) {
        if (str == null) {
            return;
        }
        d.b.b.e.d.l<String> g2 = d.b.h0.r.r.a.f().g("tb.pb_editor");
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
        if (d.b.b.e.p.k.isEmpty(str)) {
            return;
        }
        new b(writeData, z, str).execute(new Void[0]);
    }

    public static void p(String str, WriteData writeData) {
        if (d.b.b.e.p.k.isEmpty(str)) {
            return;
        }
        new a(writeData, str).execute(new Void[0]);
    }

    public static void q(String str, WriteData writeData) {
        if (d.b.b.e.p.k.isEmpty(str)) {
            return;
        }
        new c(writeData, str).execute(new Void[0]);
    }

    public static void r(String str, WriteData writeData) {
        if (d.b.b.e.p.k.isEmpty(str)) {
            return;
        }
        d.b.b.e.d.l<String> g2 = d.b.h0.r.r.a.f().g("tb.pb_editor");
        if (writeData != null && writeData.hasContentToSave()) {
            g2.i(f(str), writeData.toDraftString(), 604800000L);
        } else {
            g2.d(f(str));
        }
    }

    public static void s(String str, WriteData writeData) {
        if (d.b.b.e.p.k.isEmpty(str)) {
            return;
        }
        d.b.b.e.d.l<String> g2 = d.b.h0.r.r.a.f().g("tb.pb_editor");
        if (writeData != null) {
            g2.i(a(str), writeData.toDraftString(), 604800000L);
        } else {
            g2.d(a(str));
        }
    }
}
