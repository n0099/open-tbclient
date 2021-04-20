package d.b.i0.j1;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.squareup.wire.Wire;
import d.b.h0.z0.f0;
import d.b.h0.z0.h0;
import d.b.h0.z0.n;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.Lego.DataRes;
/* loaded from: classes4.dex */
public class h {

    /* renamed from: d  reason: collision with root package name */
    public boolean f57321d;

    /* renamed from: h  reason: collision with root package name */
    public final BdListView f57325h;
    public final d.b.i0.j1.n.a i;
    public long j;
    public String k;

    /* renamed from: a  reason: collision with root package name */
    public c f57318a = null;

    /* renamed from: b  reason: collision with root package name */
    public final List<ICardInfo> f57319b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    public int f57320c = 1;

    /* renamed from: e  reason: collision with root package name */
    public String f57322e = "";

    /* renamed from: f  reason: collision with root package name */
    public boolean f57323f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f57324g = false;

    /* loaded from: classes4.dex */
    public class a extends f0<DataRes> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.c.e.d.l f57326a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f57327b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f57328c;

        public a(h hVar, d.b.c.e.d.l lVar, long j, String str) {
            this.f57326a = lVar;
            this.f57327b = j;
            this.f57328c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.f0
        /* renamed from: a */
        public DataRes doInBackground() {
            d.b.c.e.d.l lVar = this.f57326a;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f57327b);
            sb.append("_");
            sb.append(TextUtils.isEmpty(this.f57328c) ? "" : this.f57328c);
            byte[] bArr = (byte[]) lVar.get(sb.toString());
            if (bArr != null && bArr.length != 0) {
                try {
                    return (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
                } catch (IOException e2) {
                    BdLog.e(e2);
                }
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements n<DataRes> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            h.this.h(dataRes);
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(long j, String str);

        void b(List<d.b.i0.j1.p.d> list);

        void c(int i, String str);

        void d(String str, String str2, String str3, List<d.b.i0.j1.p.e> list);

        void onError(int i, String str);

        void onSuccess();
    }

    public h(BdListView bdListView, d.b.i0.j1.n.a aVar) {
        this.f57325h = bdListView;
        this.i = aVar;
    }

    public List<ICardInfo> b() {
        return this.f57319b;
    }

    public boolean c() {
        return this.f57321d;
    }

    public final boolean d() {
        return this.f57323f;
    }

    public final void e(long j, String str) {
        h0.b(new a(this, d.b.h0.r.r.a.f().d("tb.lego_update"), j, str), new b());
    }

    public final void f(long j, String str) {
        c cVar = this.f57318a;
        if (cVar != null) {
            cVar.a(j, str);
        }
    }

    public void g() {
        if (d() || this.f57318a == null) {
            return;
        }
        this.f57320c++;
        k(true);
        this.f57318a.c(this.f57320c, this.f57322e);
    }

    public final void h(DataRes dataRes) {
        c cVar;
        this.f57324g = true;
        if (dataRes != null) {
            if (j(true, dataRes) && (cVar = this.f57318a) != null) {
                cVar.onSuccess();
            }
            f(this.j, this.k);
            return;
        }
        f(this.j, this.k);
    }

    public void i(boolean z, DataRes dataRes, int i, String str) {
        k(false);
        if (z) {
            this.f57325h.z();
        }
        if (i == 0 && dataRes != null && j(z, dataRes)) {
            c cVar = this.f57318a;
            if (cVar != null) {
                cVar.onSuccess();
            }
            if (z) {
                n(dataRes);
            }
        } else if (this.f57319b.size() > 0) {
            c cVar2 = this.f57318a;
            if (cVar2 != null) {
                cVar2.onError(1, str);
            }
        } else {
            c cVar3 = this.f57318a;
            if (cVar3 != null) {
                cVar3.onError(2, str);
            }
        }
    }

    public final boolean j(boolean z, DataRes dataRes) {
        String str;
        String str2;
        String str3;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (dataRes == null) {
            return false;
        }
        if (z) {
            this.f57319b.clear();
        }
        this.f57321d = dataRes.has_more.intValue() == 1;
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject3 = new JSONObject(dataRes.page_info);
            JSONArray optJSONArray = jSONObject3.optJSONArray("tab");
            JSONObject optJSONObject = jSONObject3.optJSONObject("title");
            if (optJSONObject != null) {
                str2 = optJSONObject.optString("name");
                str3 = optJSONObject.optString("url");
                str = optJSONObject.optString("urlNight");
            } else {
                str = "";
                str2 = str;
                str3 = str2;
            }
            if (optJSONArray != null) {
                int i = 0;
                while (i < optJSONArray.length()) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                    if (optJSONObject2 != null) {
                        d.b.i0.j1.p.e eVar = new d.b.i0.j1.p.e();
                        eVar.f57480c = optJSONObject2.optString("title");
                        jSONObject2 = jSONObject3;
                        eVar.f57478a = optJSONObject2.optLong("page_id");
                        optJSONObject2.optInt("page_type");
                        eVar.f57481d = optJSONObject2.optInt("rn");
                        eVar.f57479b = optJSONObject2.optString(LegoListActivityConfig.ITEM_ID);
                        eVar.f57482e = optJSONObject2.optString("params");
                        eVar.b();
                        arrayList.add(eVar);
                    } else {
                        jSONObject2 = jSONObject3;
                    }
                    i++;
                    jSONObject3 = jSONObject2;
                }
                jSONObject = jSONObject3;
                this.f57318a.d(str2, str3, str, arrayList);
            } else {
                jSONObject = jSONObject3;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("buttons");
            if (optJSONArray2 != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i2);
                    if (optJSONObject3 != null) {
                        d.b.i0.j1.p.d dVar = new d.b.i0.j1.p.d();
                        dVar.b(optJSONObject3);
                        if (dVar.a()) {
                            arrayList2.add(dVar);
                        }
                    }
                }
                this.f57318a.b(arrayList2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (dataRes.cards != null) {
            for (int i3 = 0; i3 < dataRes.cards.size(); i3++) {
                ICardInfo i4 = d.b.i0.j1.o.b.i(dataRes.cards.get(i3));
                if (i4 != null && i4.isValid()) {
                    this.f57319b.add(i4);
                }
            }
        }
        if (this.f57319b.size() == 0) {
            return false;
        }
        try {
            this.f57322e = this.f57319b.get(this.f57319b.size() - 1).getFlipId();
        } catch (Exception unused) {
            this.f57322e = "";
        }
        this.i.C(this.f57319b);
        return true;
    }

    public final void k(boolean z) {
        this.f57323f = z;
    }

    public void l(c cVar) {
        this.f57318a = cVar;
    }

    public void m(long j, String str) {
        this.f57320c = 1;
        this.j = j;
        this.k = str;
        if (this.f57319b.size() == 0 && !this.f57324g) {
            e(j, str);
        } else {
            f(j, str);
        }
    }

    public final void n(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        d.b.c.e.d.l<byte[]> d2 = d.b.h0.r.r.a.f().d("tb.lego_update");
        StringBuilder sb = new StringBuilder();
        sb.append(this.j);
        sb.append("_");
        sb.append(TextUtils.isEmpty(this.k) ? "" : this.k);
        d2.a(sb.toString(), dataRes.toByteArray());
    }
}
