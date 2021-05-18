package d.a.k0.j1;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.squareup.wire.Wire;
import d.a.j0.z0.f0;
import d.a.j0.z0.h0;
import d.a.j0.z0.n;
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
    public boolean f56412d;

    /* renamed from: h  reason: collision with root package name */
    public final BdListView f56416h;

    /* renamed from: i  reason: collision with root package name */
    public final d.a.k0.j1.n.a f56417i;
    public long j;
    public String k;

    /* renamed from: a  reason: collision with root package name */
    public c f56409a = null;

    /* renamed from: b  reason: collision with root package name */
    public final List<ICardInfo> f56410b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    public int f56411c = 1;

    /* renamed from: e  reason: collision with root package name */
    public String f56413e = "";

    /* renamed from: f  reason: collision with root package name */
    public boolean f56414f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56415g = false;

    /* loaded from: classes4.dex */
    public class a extends f0<DataRes> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.c.e.d.l f56418a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f56419b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f56420c;

        public a(h hVar, d.a.c.e.d.l lVar, long j, String str) {
            this.f56418a = lVar;
            this.f56419b = j;
            this.f56420c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.f0
        /* renamed from: a */
        public DataRes doInBackground() {
            d.a.c.e.d.l lVar = this.f56418a;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f56419b);
            sb.append("_");
            sb.append(TextUtils.isEmpty(this.f56420c) ? "" : this.f56420c);
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
        @Override // d.a.j0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            h.this.h(dataRes);
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(List<d.a.k0.j1.p.d> list);

        void b(long j, String str);

        void c(int i2, String str);

        void d(String str, String str2, String str3, List<d.a.k0.j1.p.e> list);

        void onError(int i2, String str);

        void onSuccess();
    }

    public h(BdListView bdListView, d.a.k0.j1.n.a aVar) {
        this.f56416h = bdListView;
        this.f56417i = aVar;
    }

    public List<ICardInfo> b() {
        return this.f56410b;
    }

    public boolean c() {
        return this.f56412d;
    }

    public final boolean d() {
        return this.f56414f;
    }

    public final void e(long j, String str) {
        h0.b(new a(this, d.a.j0.r.r.a.f().d("tb.lego_update"), j, str), new b());
    }

    public final void f(long j, String str) {
        c cVar = this.f56409a;
        if (cVar != null) {
            cVar.b(j, str);
        }
    }

    public void g() {
        if (d() || this.f56409a == null) {
            return;
        }
        this.f56411c++;
        k(true);
        this.f56409a.c(this.f56411c, this.f56413e);
    }

    public final void h(DataRes dataRes) {
        c cVar;
        this.f56415g = true;
        if (dataRes != null) {
            if (j(true, dataRes) && (cVar = this.f56409a) != null) {
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
            this.f56416h.z();
        }
        if (i2 == 0 && dataRes != null && j(z, dataRes)) {
            c cVar = this.f56409a;
            if (cVar != null) {
                cVar.onSuccess();
            }
            if (z) {
                n(dataRes);
            }
        } else if (this.f56410b.size() > 0) {
            c cVar2 = this.f56409a;
            if (cVar2 != null) {
                cVar2.onError(1, str);
            }
        } else {
            c cVar3 = this.f56409a;
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
            this.f56410b.clear();
        }
        this.f56412d = dataRes.has_more.intValue() == 1;
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
                        d.a.k0.j1.p.e eVar = new d.a.k0.j1.p.e();
                        eVar.f56580c = optJSONObject2.optString("title");
                        jSONObject2 = jSONObject3;
                        eVar.f56578a = optJSONObject2.optLong("page_id");
                        optJSONObject2.optInt("page_type");
                        eVar.f56581d = optJSONObject2.optInt("rn");
                        eVar.f56579b = optJSONObject2.optString(LegoListActivityConfig.ITEM_ID);
                        eVar.f56582e = optJSONObject2.optString("params");
                        eVar.b();
                        arrayList.add(eVar);
                    } else {
                        jSONObject2 = jSONObject3;
                    }
                    i2++;
                    jSONObject3 = jSONObject2;
                }
                jSONObject = jSONObject3;
                this.f56409a.d(str2, str3, str, arrayList);
            } else {
                jSONObject = jSONObject3;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("buttons");
            if (optJSONArray2 != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i3);
                    if (optJSONObject3 != null) {
                        d.a.k0.j1.p.d dVar = new d.a.k0.j1.p.d();
                        dVar.b(optJSONObject3);
                        if (dVar.a()) {
                            arrayList2.add(dVar);
                        }
                    }
                }
                this.f56409a.a(arrayList2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (dataRes.cards != null) {
            for (int i4 = 0; i4 < dataRes.cards.size(); i4++) {
                ICardInfo i5 = d.a.k0.j1.o.b.i(dataRes.cards.get(i4));
                if (i5 != null && i5.isValid()) {
                    this.f56410b.add(i5);
                }
            }
        }
        if (this.f56410b.size() == 0) {
            return false;
        }
        try {
            this.f56413e = this.f56410b.get(this.f56410b.size() - 1).getFlipId();
        } catch (Exception unused) {
            this.f56413e = "";
        }
        this.f56417i.C(this.f56410b);
        return true;
    }

    public final void k(boolean z) {
        this.f56414f = z;
    }

    public void l(c cVar) {
        this.f56409a = cVar;
    }

    public void m(long j, String str) {
        this.f56411c = 1;
        this.j = j;
        this.k = str;
        if (this.f56410b.size() == 0 && !this.f56415g) {
            e(j, str);
        } else {
            f(j, str);
        }
    }

    public final void n(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        d.a.c.e.d.l<byte[]> d2 = d.a.j0.r.r.a.f().d("tb.lego_update");
        StringBuilder sb = new StringBuilder();
        sb.append(this.j);
        sb.append("_");
        sb.append(TextUtils.isEmpty(this.k) ? "" : this.k);
        d2.a(sb.toString(), dataRes.toByteArray());
    }
}
