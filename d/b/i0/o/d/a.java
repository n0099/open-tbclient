package d.b.i0.o.d;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.ad.download.mvp.IDownloadModel;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.recapp.constants.Cmatch;
import com.baidu.tieba.tbadkCore.data.AppData;
import d.b.i0.r2.t;
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
    public final d.b.i0.r2.x.l.a f57196a;

    /* renamed from: b  reason: collision with root package name */
    public final int f57197b;

    /* renamed from: c  reason: collision with root package name */
    public final int f57198c;

    /* renamed from: d  reason: collision with root package name */
    public final int f57199d;

    /* renamed from: e  reason: collision with root package name */
    public final List<String> f57200e;

    /* renamed from: f  reason: collision with root package name */
    public final List<d.b.i0.r2.x.l.b> f57201f;

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
            a.this.f57196a.c(numArr[0], numArr[1]);
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
            a.this.f57196a.d(strArr[0]);
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class d extends BdAsyncTask<Integer, Integer, List<d.b.i0.r2.x.l.b>> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<d.b.i0.r2.x.l.b> doInBackground(Integer... numArr) {
            if (numArr == null || numArr.length <= 1 || numArr[0] == null || numArr[1] == null) {
                return null;
            }
            return a.this.f57196a.f(numArr[0], numArr[1]);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<d.b.i0.r2.x.l.b> list) {
            super.onPostExecute(list);
            if (d.b.i0.i1.o.k.a.e(list)) {
                return;
            }
            a.this.f57201f.addAll(list);
        }
    }

    /* loaded from: classes4.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public static final a f57205a = new a();
    }

    /* loaded from: classes4.dex */
    public class f extends BdAsyncTask<d.b.i0.r2.x.l.b, Integer, Void> {
        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(d.b.i0.r2.x.l.b... bVarArr) {
            if (bVarArr == null || bVarArr.length <= 0 || bVarArr[0] == null) {
                return null;
            }
            a.this.f57196a.g(bVarArr[0]);
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
        return e.f57205a;
    }

    public final d.b.i0.r2.x.l.b c(IDownloadModel iDownloadModel) {
        d.b.i0.r2.x.l.b bVar = new d.b.i0.r2.x.l.b();
        bVar.f59942f = iDownloadModel.getAppJson();
        bVar.f59938b = iDownloadModel.getPkgName();
        bVar.f59937a = iDownloadModel.getDownloadKey();
        bVar.f59940d = 0;
        bVar.f59941e = System.currentTimeMillis();
        bVar.f59939c = System.currentTimeMillis();
        return bVar;
    }

    public final boolean d(@NonNull Cmatch cmatch) {
        d.b.i0.r2.x.l.b bVar;
        if (!this.f57200e.contains(cmatch.value) || d.b.i0.i1.o.k.a.e(this.f57201f) || (bVar = (d.b.i0.r2.x.l.b) d.b.i0.i1.o.k.a.d(this.f57201f, 0)) == null) {
            return false;
        }
        return this.f57198c <= ((int) ((System.currentTimeMillis() - bVar.f59941e) / 60000));
    }

    public final void e(String str) {
        new c().execute(str);
    }

    public final void f(String str) {
        Iterator<d.b.i0.r2.x.l.b> it = this.f57201f.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().f59937a, str)) {
                it.remove();
            }
        }
        e(str);
    }

    public final App h(@NonNull App app, @NonNull Cmatch cmatch) {
        d.b.i0.r2.x.l.b bVar;
        if (d.b.i0.i1.o.k.a.e(this.f57201f)) {
            return null;
        }
        Iterator<d.b.i0.r2.x.l.b> it = this.f57201f.iterator();
        while (true) {
            if (!it.hasNext()) {
                bVar = null;
                break;
            }
            bVar = it.next();
            if (!t.q(bVar.f59938b)) {
                break;
            }
            bVar.f59944h = 2;
            o(bVar);
            it.remove();
        }
        if (bVar == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(bVar.f59942f);
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
        if (cmatch == Cmatch.PB_BANNER && d.b.i0.r2.a.h(app) == 14 && !d.b.i0.r2.a.o(app)) {
            return false;
        }
        if (cmatch == Cmatch.VIDEO_PB_COMMENT) {
            return (d.b.i0.r2.a.h(app) == 14 || d.b.i0.r2.a.h(app) == 7) ? false : true;
        }
        return true;
    }

    public void k(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (d.b.i0.r2.x.l.b bVar : this.f57201f) {
            if (bVar != null && TextUtils.equals(bVar.f59937a, str)) {
                p(bVar);
            }
        }
    }

    public void l(DownloadStatus downloadStatus, IDownloadModel iDownloadModel) {
        if (TextUtils.isEmpty(iDownloadModel.getDownloadKey()) || TextUtils.isEmpty(iDownloadModel.getPkgName())) {
            return;
        }
        d.b.i0.r2.x.l.b c2 = c(iDownloadModel);
        if (downloadStatus == DownloadStatus.STATUS_INSTALL_SUCCESS) {
            c2.f59944h = 2;
            this.f57201f.remove(c2);
        } else {
            c2.f59944h = 1;
            if (!this.f57201f.contains(c2)) {
                this.f57201f.add(0, c2);
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
        if (d(cmatch) && app != null && d.b.i0.r2.a.m(app)) {
            return h(app, cmatch);
        }
        return null;
    }

    public final void o(d.b.i0.r2.x.l.b bVar) {
        new f().execute(bVar);
    }

    public final void p(@NonNull d.b.i0.r2.x.l.b bVar) {
        int i = bVar.f59940d + 1;
        bVar.f59940d = i;
        if (i >= this.f57197b) {
            f(bVar.f59937a);
            return;
        }
        bVar.f59941e = System.currentTimeMillis();
        o(bVar);
    }

    public a() {
        this.f57196a = d.b.i0.r2.x.l.a.e();
        this.f57197b = d.b.i0.a.e().c();
        this.f57198c = d.b.i0.a.e().b();
        this.f57199d = d.b.i0.a.e().a();
        String d2 = d.b.i0.a.e().d();
        if (TextUtils.isEmpty(d2)) {
            this.f57200e = new ArrayList();
        } else {
            this.f57200e = Arrays.asList(d2.split("_"));
        }
        this.f57201f = Collections.synchronizedList(new ArrayList());
        m(this.f57199d, this.f57197b);
        new b().execute(Integer.valueOf(this.f57199d), Integer.valueOf(this.f57197b));
    }
}
