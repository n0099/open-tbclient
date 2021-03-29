package d.b.i0.i1;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.wallet.BaiduWalletServiceProviderMap;
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
/* loaded from: classes3.dex */
public class h {

    /* renamed from: d  reason: collision with root package name */
    public boolean f55874d;

    /* renamed from: h  reason: collision with root package name */
    public final BdListView f55878h;
    public final d.b.i0.i1.n.a i;
    public long j;
    public String k;

    /* renamed from: a  reason: collision with root package name */
    public c f55871a = null;

    /* renamed from: b  reason: collision with root package name */
    public final List<ICardInfo> f55872b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    public int f55873c = 1;

    /* renamed from: e  reason: collision with root package name */
    public String f55875e = "";

    /* renamed from: f  reason: collision with root package name */
    public boolean f55876f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f55877g = false;

    /* loaded from: classes3.dex */
    public class a extends f0<DataRes> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.b.e.d.l f55879a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f55880b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f55881c;

        public a(h hVar, d.b.b.e.d.l lVar, long j, String str) {
            this.f55879a = lVar;
            this.f55880b = j;
            this.f55881c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.f0
        /* renamed from: a */
        public DataRes doInBackground() {
            d.b.b.e.d.l lVar = this.f55879a;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f55880b);
            sb.append("_");
            sb.append(TextUtils.isEmpty(this.f55881c) ? "" : this.f55881c);
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public interface c {
        void a(long j, String str);

        void b(List<d.b.i0.i1.p.d> list);

        void c(int i, String str);

        void d(String str, String str2, String str3, List<d.b.i0.i1.p.e> list);

        void onError(int i, String str);

        void onSuccess();
    }

    public h(BdListView bdListView, d.b.i0.i1.n.a aVar) {
        this.f55878h = bdListView;
        this.i = aVar;
    }

    public List<ICardInfo> b() {
        return this.f55872b;
    }

    public boolean c() {
        return this.f55874d;
    }

    public final boolean d() {
        return this.f55876f;
    }

    public final void e(long j, String str) {
        h0.b(new a(this, d.b.h0.r.r.a.f().d("tb.lego_update"), j, str), new b());
    }

    public final void f(long j, String str) {
        c cVar = this.f55871a;
        if (cVar != null) {
            cVar.a(j, str);
        }
    }

    public void g() {
        if (d() || this.f55871a == null) {
            return;
        }
        this.f55873c++;
        k(true);
        this.f55871a.c(this.f55873c, this.f55875e);
    }

    public final void h(DataRes dataRes) {
        c cVar;
        this.f55877g = true;
        if (dataRes != null) {
            if (j(true, dataRes) && (cVar = this.f55871a) != null) {
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
            this.f55878h.z();
        }
        if (i == 0 && dataRes != null && j(z, dataRes)) {
            c cVar = this.f55871a;
            if (cVar != null) {
                cVar.onSuccess();
            }
            if (z) {
                n(dataRes);
            }
        } else if (this.f55872b.size() > 0) {
            c cVar2 = this.f55871a;
            if (cVar2 != null) {
                cVar2.onError(1, str);
            }
        } else {
            c cVar3 = this.f55871a;
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
            this.f55872b.clear();
        }
        this.f55874d = dataRes.has_more.intValue() == 1;
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject3 = new JSONObject(dataRes.page_info);
            JSONArray optJSONArray = jSONObject3.optJSONArray(BaiduWalletServiceProviderMap.PLUGIN_TAB);
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
                        d.b.i0.i1.p.e eVar = new d.b.i0.i1.p.e();
                        eVar.f56033c = optJSONObject2.optString("title");
                        jSONObject2 = jSONObject3;
                        eVar.f56031a = optJSONObject2.optLong("page_id");
                        optJSONObject2.optInt("page_type");
                        eVar.f56034d = optJSONObject2.optInt("rn");
                        eVar.f56032b = optJSONObject2.optString(LegoListActivityConfig.ITEM_ID);
                        eVar.f56035e = optJSONObject2.optString("params");
                        eVar.b();
                        arrayList.add(eVar);
                    } else {
                        jSONObject2 = jSONObject3;
                    }
                    i++;
                    jSONObject3 = jSONObject2;
                }
                jSONObject = jSONObject3;
                this.f55871a.d(str2, str3, str, arrayList);
            } else {
                jSONObject = jSONObject3;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("buttons");
            if (optJSONArray2 != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i2);
                    if (optJSONObject3 != null) {
                        d.b.i0.i1.p.d dVar = new d.b.i0.i1.p.d();
                        dVar.b(optJSONObject3);
                        if (dVar.a()) {
                            arrayList2.add(dVar);
                        }
                    }
                }
                this.f55871a.b(arrayList2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (dataRes.cards != null) {
            for (int i3 = 0; i3 < dataRes.cards.size(); i3++) {
                ICardInfo i4 = d.b.i0.i1.o.b.i(dataRes.cards.get(i3));
                if (i4 != null && i4.isValid()) {
                    this.f55872b.add(i4);
                }
            }
        }
        if (this.f55872b.size() == 0) {
            return false;
        }
        try {
            this.f55875e = this.f55872b.get(this.f55872b.size() - 1).getFlipId();
        } catch (Exception unused) {
            this.f55875e = "";
        }
        this.i.C(this.f55872b);
        return true;
    }

    public final void k(boolean z) {
        this.f55876f = z;
    }

    public void l(c cVar) {
        this.f55871a = cVar;
    }

    public void m(long j, String str) {
        this.f55873c = 1;
        this.j = j;
        this.k = str;
        if (this.f55872b.size() == 0 && !this.f55877g) {
            e(j, str);
        } else {
            f(j, str);
        }
    }

    public final void n(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        d.b.b.e.d.l<byte[]> d2 = d.b.h0.r.r.a.f().d("tb.lego_update");
        StringBuilder sb = new StringBuilder();
        sb.append(this.j);
        sb.append("_");
        sb.append(TextUtils.isEmpty(this.k) ? "" : this.k);
        d2.a(sb.toString(), dataRes.toByteArray());
    }
}
