package d.a.o0.k1;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.squareup.wire.Wire;
import d.a.n0.z0.f0;
import d.a.n0.z0.h0;
import d.a.n0.z0.n;
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
    public boolean f60406d;

    /* renamed from: h  reason: collision with root package name */
    public final BdListView f60410h;

    /* renamed from: i  reason: collision with root package name */
    public final d.a.o0.k1.n.a f60411i;
    public long j;
    public String k;

    /* renamed from: a  reason: collision with root package name */
    public c f60403a = null;

    /* renamed from: b  reason: collision with root package name */
    public final List<ICardInfo> f60404b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    public int f60405c = 1;

    /* renamed from: e  reason: collision with root package name */
    public String f60407e = "";

    /* renamed from: f  reason: collision with root package name */
    public boolean f60408f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60409g = false;

    /* loaded from: classes4.dex */
    public class a extends f0<DataRes> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.c.e.d.l f60412a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f60413b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f60414c;

        public a(h hVar, d.a.c.e.d.l lVar, long j, String str) {
            this.f60412a = lVar;
            this.f60413b = j;
            this.f60414c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z0.f0
        /* renamed from: a */
        public DataRes doInBackground() {
            d.a.c.e.d.l lVar = this.f60412a;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f60413b);
            sb.append("_");
            sb.append(TextUtils.isEmpty(this.f60414c) ? "" : this.f60414c);
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
        @Override // d.a.n0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            h.this.h(dataRes);
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(List<d.a.o0.k1.p.d> list);

        void b(long j, String str);

        void c(int i2, String str);

        void d(String str, String str2, String str3, List<d.a.o0.k1.p.e> list);

        void onError(int i2, String str);

        void onSuccess();
    }

    public h(BdListView bdListView, d.a.o0.k1.n.a aVar) {
        this.f60410h = bdListView;
        this.f60411i = aVar;
    }

    public List<ICardInfo> b() {
        return this.f60404b;
    }

    public boolean c() {
        return this.f60406d;
    }

    public final boolean d() {
        return this.f60408f;
    }

    public final void e(long j, String str) {
        h0.b(new a(this, d.a.n0.r.r.a.f().d("tb.lego_update"), j, str), new b());
    }

    public final void f(long j, String str) {
        c cVar = this.f60403a;
        if (cVar != null) {
            cVar.b(j, str);
        }
    }

    public void g() {
        if (d() || this.f60403a == null) {
            return;
        }
        this.f60405c++;
        k(true);
        this.f60403a.c(this.f60405c, this.f60407e);
    }

    public final void h(DataRes dataRes) {
        c cVar;
        this.f60409g = true;
        if (dataRes != null) {
            if (j(true, dataRes) && (cVar = this.f60403a) != null) {
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
            this.f60410h.z();
        }
        if (i2 == 0 && dataRes != null && j(z, dataRes)) {
            c cVar = this.f60403a;
            if (cVar != null) {
                cVar.onSuccess();
            }
            if (z) {
                n(dataRes);
            }
        } else if (this.f60404b.size() > 0) {
            c cVar2 = this.f60403a;
            if (cVar2 != null) {
                cVar2.onError(1, str);
            }
        } else {
            c cVar3 = this.f60403a;
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
            this.f60404b.clear();
        }
        this.f60406d = dataRes.has_more.intValue() == 1;
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
                        d.a.o0.k1.p.e eVar = new d.a.o0.k1.p.e();
                        eVar.f60574c = optJSONObject2.optString("title");
                        jSONObject2 = jSONObject3;
                        eVar.f60572a = optJSONObject2.optLong("page_id");
                        optJSONObject2.optInt("page_type");
                        eVar.f60575d = optJSONObject2.optInt("rn");
                        eVar.f60573b = optJSONObject2.optString(LegoListActivityConfig.ITEM_ID);
                        eVar.f60576e = optJSONObject2.optString("params");
                        eVar.b();
                        arrayList.add(eVar);
                    } else {
                        jSONObject2 = jSONObject3;
                    }
                    i2++;
                    jSONObject3 = jSONObject2;
                }
                jSONObject = jSONObject3;
                this.f60403a.d(str2, str3, str, arrayList);
            } else {
                jSONObject = jSONObject3;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("buttons");
            if (optJSONArray2 != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i3);
                    if (optJSONObject3 != null) {
                        d.a.o0.k1.p.d dVar = new d.a.o0.k1.p.d();
                        dVar.b(optJSONObject3);
                        if (dVar.a()) {
                            arrayList2.add(dVar);
                        }
                    }
                }
                this.f60403a.a(arrayList2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (dataRes.cards != null) {
            for (int i4 = 0; i4 < dataRes.cards.size(); i4++) {
                ICardInfo i5 = d.a.o0.k1.o.b.i(dataRes.cards.get(i4));
                if (i5 != null && i5.isValid()) {
                    this.f60404b.add(i5);
                }
            }
        }
        if (this.f60404b.size() == 0) {
            return false;
        }
        try {
            this.f60407e = this.f60404b.get(this.f60404b.size() - 1).getFlipId();
        } catch (Exception unused) {
            this.f60407e = "";
        }
        this.f60411i.C(this.f60404b);
        return true;
    }

    public final void k(boolean z) {
        this.f60408f = z;
    }

    public void l(c cVar) {
        this.f60403a = cVar;
    }

    public void m(long j, String str) {
        this.f60405c = 1;
        this.j = j;
        this.k = str;
        if (this.f60404b.size() == 0 && !this.f60409g) {
            e(j, str);
        } else {
            f(j, str);
        }
    }

    public final void n(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        d.a.c.e.d.l<byte[]> d2 = d.a.n0.r.r.a.f().d("tb.lego_update");
        StringBuilder sb = new StringBuilder();
        sb.append(this.j);
        sb.append("_");
        sb.append(TextUtils.isEmpty(this.k) ? "" : this.k);
        d2.a(sb.toString(), dataRes.toByteArray());
    }
}
