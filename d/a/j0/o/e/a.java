package d.a.j0.o.e;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.ad.download.mvp.IDownloadModel;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.recapp.constants.Cmatch;
import com.baidu.tieba.tbadkCore.data.AppData;
import d.a.j0.s2.x;
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
    public final d.a.j0.s2.b0.l.a f57104a;

    /* renamed from: b  reason: collision with root package name */
    public final int f57105b;

    /* renamed from: c  reason: collision with root package name */
    public final int f57106c;

    /* renamed from: d  reason: collision with root package name */
    public final int f57107d;

    /* renamed from: e  reason: collision with root package name */
    public final List<String> f57108e;

    /* renamed from: f  reason: collision with root package name */
    public final List<d.a.j0.s2.b0.l.b> f57109f;

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
            a.this.f57104a.c(numArr[0], numArr[1]);
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
            a.this.f57104a.d(strArr[0]);
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class d extends BdAsyncTask<Integer, Integer, List<d.a.j0.s2.b0.l.b>> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<d.a.j0.s2.b0.l.b> doInBackground(Integer... numArr) {
            if (numArr == null || numArr.length <= 1 || numArr[0] == null || numArr[1] == null) {
                return null;
            }
            return a.this.f57104a.f(numArr[0], numArr[1]);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<d.a.j0.s2.b0.l.b> list) {
            super.onPostExecute(list);
            if (d.a.j0.j1.o.k.a.e(list)) {
                return;
            }
            a.this.f57109f.addAll(list);
        }
    }

    /* loaded from: classes4.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public static final a f57113a = new a();
    }

    /* loaded from: classes4.dex */
    public class f extends BdAsyncTask<d.a.j0.s2.b0.l.b, Integer, Void> {
        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(d.a.j0.s2.b0.l.b... bVarArr) {
            if (bVarArr == null || bVarArr.length <= 0 || bVarArr[0] == null) {
                return null;
            }
            a.this.f57104a.g(bVarArr[0]);
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
        return e.f57113a;
    }

    public final d.a.j0.s2.b0.l.b c(IDownloadModel iDownloadModel) {
        d.a.j0.s2.b0.l.b bVar = new d.a.j0.s2.b0.l.b();
        bVar.f60145f = iDownloadModel.getAppJson();
        bVar.f60141b = iDownloadModel.getPkgName();
        bVar.f60140a = iDownloadModel.getDownloadKey();
        bVar.f60143d = 0;
        bVar.f60144e = System.currentTimeMillis();
        bVar.f60142c = System.currentTimeMillis();
        return bVar;
    }

    public final boolean d(@NonNull Cmatch cmatch) {
        d.a.j0.s2.b0.l.b bVar;
        if (!this.f57108e.contains(cmatch.value) || d.a.j0.j1.o.k.a.e(this.f57109f) || (bVar = (d.a.j0.s2.b0.l.b) d.a.j0.j1.o.k.a.d(this.f57109f, 0)) == null) {
            return false;
        }
        return this.f57106c <= ((int) ((System.currentTimeMillis() - bVar.f60144e) / 60000));
    }

    public final void e(String str) {
        new c().execute(str);
    }

    public final void f(String str) {
        Iterator<d.a.j0.s2.b0.l.b> it = this.f57109f.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().f60140a, str)) {
                it.remove();
            }
        }
        e(str);
    }

    public final App h(@NonNull App app, @NonNull Cmatch cmatch) {
        d.a.j0.s2.b0.l.b bVar;
        if (d.a.j0.j1.o.k.a.e(this.f57109f)) {
            return null;
        }
        Iterator<d.a.j0.s2.b0.l.b> it = this.f57109f.iterator();
        while (true) {
            if (!it.hasNext()) {
                bVar = null;
                break;
            }
            bVar = it.next();
            if (!x.q(bVar.f60141b)) {
                break;
            }
            bVar.f60147h = 2;
            o(bVar);
            it.remove();
        }
        if (bVar == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(bVar.f60145f);
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
        if (cmatch == Cmatch.PB_BANNER && d.a.j0.s2.a.h(app) == 14 && !d.a.j0.s2.a.o(app)) {
            return false;
        }
        if (cmatch == Cmatch.VIDEO_PB_COMMENT) {
            return (d.a.j0.s2.a.h(app) == 14 || d.a.j0.s2.a.h(app) == 7) ? false : true;
        }
        return true;
    }

    public void k(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (d.a.j0.s2.b0.l.b bVar : this.f57109f) {
            if (bVar != null && TextUtils.equals(bVar.f60140a, str)) {
                p(bVar);
            }
        }
    }

    public void l(DownloadStatus downloadStatus, IDownloadModel iDownloadModel) {
        if (TextUtils.isEmpty(iDownloadModel.getDownloadKey()) || TextUtils.isEmpty(iDownloadModel.getPkgName())) {
            return;
        }
        d.a.j0.s2.b0.l.b c2 = c(iDownloadModel);
        if (downloadStatus == DownloadStatus.STATUS_INSTALL_SUCCESS) {
            c2.f60147h = 2;
            this.f57109f.remove(c2);
        } else {
            c2.f60147h = 1;
            if (!this.f57109f.contains(c2)) {
                this.f57109f.add(0, c2);
            }
        }
        o(c2);
    }

    public final void m(int i2, int i3) {
        try {
            new d().execute(Integer.valueOf(i2), Integer.valueOf(i3));
        } catch (Exception unused) {
        }
    }

    public App n(App app, Cmatch cmatch) {
        if (d(cmatch) && app != null && d.a.j0.s2.a.m(app)) {
            return h(app, cmatch);
        }
        return null;
    }

    public final void o(d.a.j0.s2.b0.l.b bVar) {
        new f().execute(bVar);
    }

    public final void p(@NonNull d.a.j0.s2.b0.l.b bVar) {
        int i2 = bVar.f60143d + 1;
        bVar.f60143d = i2;
        if (i2 >= this.f57105b) {
            f(bVar.f60140a);
            return;
        }
        bVar.f60144e = System.currentTimeMillis();
        o(bVar);
    }

    public a() {
        this.f57104a = d.a.j0.s2.b0.l.a.e();
        this.f57105b = d.a.j0.a.e().c();
        this.f57106c = d.a.j0.a.e().b();
        this.f57107d = d.a.j0.a.e().a();
        String d2 = d.a.j0.a.e().d();
        if (TextUtils.isEmpty(d2)) {
            this.f57108e = new ArrayList();
        } else {
            this.f57108e = Arrays.asList(d2.split("_"));
        }
        this.f57109f = Collections.synchronizedList(new ArrayList());
        m(this.f57107d, this.f57105b);
        new b().execute(Integer.valueOf(this.f57107d), Integer.valueOf(this.f57105b));
    }
}
