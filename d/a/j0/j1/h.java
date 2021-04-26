package d.a.j0.j1;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.squareup.wire.Wire;
import d.a.i0.z0.f0;
import d.a.i0.z0.h0;
import d.a.i0.z0.n;
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
    public boolean f55705d;

    /* renamed from: h  reason: collision with root package name */
    public final BdListView f55709h;

    /* renamed from: i  reason: collision with root package name */
    public final d.a.j0.j1.n.a f55710i;
    public long j;
    public String k;

    /* renamed from: a  reason: collision with root package name */
    public c f55702a = null;

    /* renamed from: b  reason: collision with root package name */
    public final List<ICardInfo> f55703b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    public int f55704c = 1;

    /* renamed from: e  reason: collision with root package name */
    public String f55706e = "";

    /* renamed from: f  reason: collision with root package name */
    public boolean f55707f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f55708g = false;

    /* loaded from: classes4.dex */
    public class a extends f0<DataRes> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.c.e.d.l f55711a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f55712b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f55713c;

        public a(h hVar, d.a.c.e.d.l lVar, long j, String str) {
            this.f55711a = lVar;
            this.f55712b = j;
            this.f55713c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.z0.f0
        /* renamed from: a */
        public DataRes doInBackground() {
            d.a.c.e.d.l lVar = this.f55711a;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f55712b);
            sb.append("_");
            sb.append(TextUtils.isEmpty(this.f55713c) ? "" : this.f55713c);
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
        @Override // d.a.i0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            h.this.h(dataRes);
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(List<d.a.j0.j1.p.d> list);

        void b(long j, String str);

        void c(int i2, String str);

        void d(String str, String str2, String str3, List<d.a.j0.j1.p.e> list);

        void onError(int i2, String str);

        void onSuccess();
    }

    public h(BdListView bdListView, d.a.j0.j1.n.a aVar) {
        this.f55709h = bdListView;
        this.f55710i = aVar;
    }

    public List<ICardInfo> b() {
        return this.f55703b;
    }

    public boolean c() {
        return this.f55705d;
    }

    public final boolean d() {
        return this.f55707f;
    }

    public final void e(long j, String str) {
        h0.b(new a(this, d.a.i0.r.r.a.f().d("tb.lego_update"), j, str), new b());
    }

    public final void f(long j, String str) {
        c cVar = this.f55702a;
        if (cVar != null) {
            cVar.b(j, str);
        }
    }

    public void g() {
        if (d() || this.f55702a == null) {
            return;
        }
        this.f55704c++;
        k(true);
        this.f55702a.c(this.f55704c, this.f55706e);
    }

    public final void h(DataRes dataRes) {
        c cVar;
        this.f55708g = true;
        if (dataRes != null) {
            if (j(true, dataRes) && (cVar = this.f55702a) != null) {
                cVar.onSuccess();
            }
            f(this.j, this.k);
            return;
        }
        f(this.j, this.k);
    }

    public void i(boolean z, DataRes dataRes, int i2, String str) {
        k(false);
        if (z) {
            this.f55709h.z();
        }
        if (i2 == 0 && dataRes != null && j(z, dataRes)) {
            c cVar = this.f55702a;
            if (cVar != null) {
                cVar.onSuccess();
            }
            if (z) {
                n(dataRes);
            }
        } else if (this.f55703b.size() > 0) {
            c cVar2 = this.f55702a;
            if (cVar2 != null) {
                cVar2.onError(1, str);
            }
        } else {
            c cVar3 = this.f55702a;
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
            this.f55703b.clear();
        }
        this.f55705d = dataRes.has_more.intValue() == 1;
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
                int i2 = 0;
                while (i2 < optJSONArray.length()) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                    if (optJSONObject2 != null) {
                        d.a.j0.j1.p.e eVar = new d.a.j0.j1.p.e();
                        eVar.f55873c = optJSONObject2.optString("title");
                        jSONObject2 = jSONObject3;
                        eVar.f55871a = optJSONObject2.optLong("page_id");
                        optJSONObject2.optInt("page_type");
                        eVar.f55874d = optJSONObject2.optInt("rn");
                        eVar.f55872b = optJSONObject2.optString(LegoListActivityConfig.ITEM_ID);
                        eVar.f55875e = optJSONObject2.optString("params");
                        eVar.b();
                        arrayList.add(eVar);
                    } else {
                        jSONObject2 = jSONObject3;
                    }
                    i2++;
                    jSONObject3 = jSONObject2;
                }
                jSONObject = jSONObject3;
                this.f55702a.d(str2, str3, str, arrayList);
            } else {
                jSONObject = jSONObject3;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("buttons");
            if (optJSONArray2 != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i3);
                    if (optJSONObject3 != null) {
                        d.a.j0.j1.p.d dVar = new d.a.j0.j1.p.d();
                        dVar.b(optJSONObject3);
                        if (dVar.a()) {
                            arrayList2.add(dVar);
                        }
                    }
                }
                this.f55702a.a(arrayList2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (dataRes.cards != null) {
            for (int i4 = 0; i4 < dataRes.cards.size(); i4++) {
                ICardInfo i5 = d.a.j0.j1.o.b.i(dataRes.cards.get(i4));
                if (i5 != null && i5.isValid()) {
                    this.f55703b.add(i5);
                }
            }
        }
        if (this.f55703b.size() == 0) {
            return false;
        }
        try {
            this.f55706e = this.f55703b.get(this.f55703b.size() - 1).getFlipId();
        } catch (Exception unused) {
            this.f55706e = "";
        }
        this.f55710i.C(this.f55703b);
        return true;
    }

    public final void k(boolean z) {
        this.f55707f = z;
    }

    public void l(c cVar) {
        this.f55702a = cVar;
    }

    public void m(long j, String str) {
        this.f55704c = 1;
        this.j = j;
        this.k = str;
        if (this.f55703b.size() == 0 && !this.f55708g) {
            e(j, str);
        } else {
            f(j, str);
        }
    }

    public final void n(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        d.a.c.e.d.l<byte[]> d2 = d.a.i0.r.r.a.f().d("tb.lego_update");
        StringBuilder sb = new StringBuilder();
        sb.append(this.j);
        sb.append("_");
        sb.append(TextUtils.isEmpty(this.k) ? "" : this.k);
        d2.a(sb.toString(), dataRes.toByteArray());
    }
}
