package d.a.j0.d3;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes5.dex */
public class y {

    /* loaded from: classes5.dex */
    public static class a extends BdAsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteData f53326a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f53327b;

        public a(WriteData writeData, String str) {
            this.f53326a = writeData;
            this.f53327b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            d.a.c.e.d.l<String> g2 = d.a.i0.r.r.a.f().g("tb.pb_editor");
            WriteData writeData = this.f53326a;
            if (writeData != null && writeData.hasContentToSave()) {
                g2.e(y.d(this.f53327b), this.f53326a.toDraftString(), 604800000L);
                return null;
            }
            g2.remove(y.d(this.f53327b));
            return null;
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends BdAsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteData f53328a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f53329b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f53330c;

        public b(WriteData writeData, boolean z, String str) {
            this.f53328a = writeData;
            this.f53329b = z;
            this.f53330c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            WriteData writeData;
            WriteData writeData2;
            d.a.c.e.d.l<String> g2 = d.a.i0.r.r.a.f().g("tb.pb_editor");
            WriteData writeData3 = this.f53328a;
            if (writeData3 != null && writeData3.hasContentToSave() && !this.f53329b) {
                String draftString = this.f53328a.toDraftString();
                g2.e(y.c(this.f53330c), draftString, 604800000L);
                if ("0".equals(this.f53330c) || (writeData2 = this.f53328a) == null || writeData2.getStatisticFrom() != 1) {
                    return null;
                }
                g2.e(y.c("0"), draftString, 604800000L);
                return null;
            }
            g2.remove(y.c(this.f53330c));
            if ("0".equals(this.f53330c) || (writeData = this.f53328a) == null || writeData.getStatisticFrom() != 1) {
                return null;
            }
            g2.remove(y.c("0"));
            return null;
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends BdAsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteData f53331a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f53332b;

        public c(WriteData writeData, String str) {
            this.f53331a = writeData;
            this.f53332b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            d.a.c.e.d.l<String> g2 = d.a.i0.r.r.a.f().g("tb.pb_editor");
            WriteData writeData = this.f53331a;
            if (writeData != null && writeData.hasContentToSave()) {
                g2.e(y.e(this.f53332b), this.f53331a.toDraftString(), 604800000L);
                return null;
            }
            g2.remove(y.e(this.f53332b));
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
        public final d f53333a;

        /* renamed from: b  reason: collision with root package name */
        public final String f53334b;

        public e(String str, d dVar) {
            setPriority(3);
            this.f53333a = dVar;
            this.f53334b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public WriteData doInBackground(String... strArr) {
            String str;
            try {
                str = d.a.i0.r.r.a.f().g("tb.pb_editor").get(this.f53334b);
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
            d dVar = this.f53333a;
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
        if (!d.a.c.e.p.k.isEmpty(str)) {
            new e(c(str), dVar).execute(new String[0]);
        } else if (dVar != null) {
            dVar.onDraftLoaded(null);
        }
    }

    public static void i(String str, d dVar) {
        if (!d.a.c.e.p.k.isEmpty(str)) {
            new e(d(str), dVar).execute(new String[0]);
        } else if (dVar != null) {
            dVar.onDraftLoaded(null);
        }
    }

    public static void j(String str, d dVar) {
        if (!d.a.c.e.p.k.isEmpty(str)) {
            new e(e(str), dVar).execute(new String[0]);
        } else if (dVar != null) {
            dVar.onDraftLoaded(null);
        }
    }

    public static void k(String str, d dVar) {
        if (!d.a.c.e.p.k.isEmpty(str)) {
            new e(f(str), dVar).execute(new String[0]);
        } else if (dVar != null) {
            dVar.onDraftLoaded(null);
        }
    }

    public static void l(String str, d dVar) {
        if (!d.a.c.e.p.k.isEmpty(str)) {
            new e(a(str), dVar).execute(new String[0]);
        } else if (dVar != null) {
            dVar.onDraftLoaded(null);
        }
    }

    public static void m(String str, WriteData writeData) {
        if (str == null) {
            return;
        }
        d.a.c.e.d.l<String> g2 = d.a.i0.r.r.a.f().g("tb.pb_editor");
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
        if (d.a.c.e.p.k.isEmpty(str)) {
            return;
        }
        new b(writeData, z, str).execute(new Void[0]);
    }

    public static void p(String str, WriteData writeData) {
        if (d.a.c.e.p.k.isEmpty(str)) {
            return;
        }
        new a(writeData, str).execute(new Void[0]);
    }

    public static void q(String str, WriteData writeData) {
        if (d.a.c.e.p.k.isEmpty(str)) {
            return;
        }
        new c(writeData, str).execute(new Void[0]);
    }

    public static void r(String str, WriteData writeData) {
        if (d.a.c.e.p.k.isEmpty(str)) {
            return;
        }
        d.a.c.e.d.l<String> g2 = d.a.i0.r.r.a.f().g("tb.pb_editor");
        if (writeData != null && writeData.hasContentToSave()) {
            g2.i(f(str), writeData.toDraftString(), 604800000L);
        } else {
            g2.d(f(str));
        }
    }

    public static void s(String str, WriteData writeData) {
        if (d.a.c.e.p.k.isEmpty(str)) {
            return;
        }
        d.a.c.e.d.l<String> g2 = d.a.i0.r.r.a.f().g("tb.pb_editor");
        if (writeData != null) {
            g2.i(a(str), writeData.toDraftString(), 604800000L);
        } else {
            g2.d(a(str));
        }
    }
}
