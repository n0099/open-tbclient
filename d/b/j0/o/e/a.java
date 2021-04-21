package d.b.j0.o.e;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.ad.download.mvp.IDownloadModel;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.recapp.constants.Cmatch;
import com.baidu.tieba.tbadkCore.data.AppData;
import d.b.j0.s2.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.App;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final d.b.j0.s2.a0.l.a f59081a;

    /* renamed from: b  reason: collision with root package name */
    public final int f59082b;

    /* renamed from: c  reason: collision with root package name */
    public final int f59083c;

    /* renamed from: d  reason: collision with root package name */
    public final int f59084d;

    /* renamed from: e  reason: collision with root package name */
    public final List<String> f59085e;

    /* renamed from: f  reason: collision with root package name */
    public final List<d.b.j0.s2.a0.l.b> f59086f;

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Integer, Integer, Void> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Integer... numArr) {
            if (numArr == null || numArr.length <= 1 || numArr[0] == null || numArr[1] == null) {
                return null;
            }
            a.this.f59081a.c(numArr[0], numArr[1]);
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends BdAsyncTask<String, Integer, Void> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(String... strArr) {
            if (strArr == null || strArr.length <= 0 || strArr[0] == null) {
                return null;
            }
            a.this.f59081a.d(strArr[0]);
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class d extends BdAsyncTask<Integer, Integer, List<d.b.j0.s2.a0.l.b>> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<d.b.j0.s2.a0.l.b> doInBackground(Integer... numArr) {
            if (numArr == null || numArr.length <= 1 || numArr[0] == null || numArr[1] == null) {
                return null;
            }
            return a.this.f59081a.f(numArr[0], numArr[1]);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<d.b.j0.s2.a0.l.b> list) {
            super.onPostExecute(list);
            if (d.b.j0.j1.o.k.a.e(list)) {
                return;
            }
            a.this.f59086f.addAll(list);
        }
    }

    /* loaded from: classes4.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public static final a f59090a = new a();
    }

    /* loaded from: classes4.dex */
    public class f extends BdAsyncTask<d.b.j0.s2.a0.l.b, Integer, Void> {
        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(d.b.j0.s2.a0.l.b... bVarArr) {
            if (bVarArr == null || bVarArr.length <= 0 || bVarArr[0] == null) {
                return null;
            }
            a.this.f59081a.g(bVarArr[0]);
            return null;
        }
    }

    public static String g(AppData appData) {
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        if (appData == null || (iLegoAdvert = appData.legoCard) == null) {
            return null;
        }
        return iLegoAdvert.getDownloadKey();
    }

    public static a i() {
        return e.f59090a;
    }

    public final d.b.j0.s2.a0.l.b c(IDownloadModel iDownloadModel) {
        d.b.j0.s2.a0.l.b bVar = new d.b.j0.s2.a0.l.b();
        bVar.f61963f = iDownloadModel.getAppJson();
        bVar.f61959b = iDownloadModel.getPkgName();
        bVar.f61958a = iDownloadModel.getDownloadKey();
        bVar.f61961d = 0;
        bVar.f61962e = System.currentTimeMillis();
        bVar.f61960c = System.currentTimeMillis();
        return bVar;
    }

    public final boolean d(@NonNull Cmatch cmatch) {
        d.b.j0.s2.a0.l.b bVar;
        if (!this.f59085e.contains(cmatch.value) || d.b.j0.j1.o.k.a.e(this.f59086f) || (bVar = (d.b.j0.s2.a0.l.b) d.b.j0.j1.o.k.a.d(this.f59086f, 0)) == null) {
            return false;
        }
        return this.f59083c <= ((int) ((System.currentTimeMillis() - bVar.f61962e) / 60000));
    }

    public final void e(String str) {
        new c().execute(str);
    }

    public final void f(String str) {
        Iterator<d.b.j0.s2.a0.l.b> it = this.f59086f.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().f61958a, str)) {
                it.remove();
            }
        }
        e(str);
    }

    public final App h(@NonNull App app, @NonNull Cmatch cmatch) {
        d.b.j0.s2.a0.l.b bVar;
        if (d.b.j0.j1.o.k.a.e(this.f59086f)) {
            return null;
        }
        Iterator<d.b.j0.s2.a0.l.b> it = this.f59086f.iterator();
        while (true) {
            if (!it.hasNext()) {
                bVar = null;
                break;
            }
            bVar = it.next();
            if (!w.q(bVar.f61959b)) {
                break;
            }
            bVar.f61965h = 2;
            o(bVar);
            it.remove();
        }
        if (bVar == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(bVar.f61963f);
            jSONObject.put("pos_name", app.pos_name);
            App parseFromJson = App.parseFromJson(jSONObject);
            if (j(cmatch, parseFromJson)) {
                return parseFromJson;
            }
            return null;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final boolean j(Cmatch cmatch, App app) {
        if (cmatch == Cmatch.PB_BANNER && d.b.j0.s2.a.h(app) == 14 && !d.b.j0.s2.a.o(app)) {
            return false;
        }
        if (cmatch == Cmatch.VIDEO_PB_COMMENT) {
            return (d.b.j0.s2.a.h(app) == 14 || d.b.j0.s2.a.h(app) == 7) ? false : true;
        }
        return true;
    }

    public void k(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (d.b.j0.s2.a0.l.b bVar : this.f59086f) {
            if (bVar != null && TextUtils.equals(bVar.f61958a, str)) {
                p(bVar);
            }
        }
    }

    public void l(DownloadStatus downloadStatus, IDownloadModel iDownloadModel) {
        if (TextUtils.isEmpty(iDownloadModel.getDownloadKey()) || TextUtils.isEmpty(iDownloadModel.getPkgName())) {
            return;
        }
        d.b.j0.s2.a0.l.b c2 = c(iDownloadModel);
        if (downloadStatus == DownloadStatus.STATUS_INSTALL_SUCCESS) {
            c2.f61965h = 2;
            this.f59086f.remove(c2);
        } else {
            c2.f61965h = 1;
            if (!this.f59086f.contains(c2)) {
                this.f59086f.add(0, c2);
            }
        }
        o(c2);
    }

    public final void m(int i, int i2) {
        try {
            new d().execute(Integer.valueOf(i), Integer.valueOf(i2));
        } catch (Exception unused) {
        }
    }

    public App n(App app, Cmatch cmatch) {
        if (d(cmatch) && app != null && d.b.j0.s2.a.m(app)) {
            return h(app, cmatch);
        }
        return null;
    }

    public final void o(d.b.j0.s2.a0.l.b bVar) {
        new f().execute(bVar);
    }

    public final void p(@NonNull d.b.j0.s2.a0.l.b bVar) {
        int i = bVar.f61961d + 1;
        bVar.f61961d = i;
        if (i >= this.f59082b) {
            f(bVar.f61958a);
            return;
        }
        bVar.f61962e = System.currentTimeMillis();
        o(bVar);
    }

    public a() {
        this.f59081a = d.b.j0.s2.a0.l.a.e();
        this.f59082b = d.b.j0.a.e().c();
        this.f59083c = d.b.j0.a.e().b();
        this.f59084d = d.b.j0.a.e().a();
        String d2 = d.b.j0.a.e().d();
        if (TextUtils.isEmpty(d2)) {
            this.f59085e = new ArrayList();
        } else {
            this.f59085e = Arrays.asList(d2.split("_"));
        }
        this.f59086f = Collections.synchronizedList(new ArrayList());
        m(this.f59084d, this.f59082b);
        new b().execute(Integer.valueOf(this.f59084d), Integer.valueOf(this.f59082b));
    }
}
