package d.a.o0.k1.p;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.Lego.DataRes;
/* loaded from: classes4.dex */
public class c implements a {

    /* renamed from: a  reason: collision with root package name */
    public final e f60555a;

    /* renamed from: c  reason: collision with root package name */
    public String f60557c;

    /* renamed from: d  reason: collision with root package name */
    public String f60558d;

    /* renamed from: e  reason: collision with root package name */
    public String f60559e;

    /* renamed from: f  reason: collision with root package name */
    public List<d> f60560f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60561g;

    /* renamed from: i  reason: collision with root package name */
    public String f60563i;
    public int j;

    /* renamed from: b  reason: collision with root package name */
    public List<ICardInfo> f60556b = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public int f60562h = 1;
    public boolean k = false;
    public boolean l = false;
    public boolean m = false;

    public c(e eVar) {
        this.f60555a = eVar;
    }

    @Override // d.a.o0.k1.p.a
    public boolean a() {
        return this.f60561g;
    }

    @Override // d.a.o0.k1.p.a
    public boolean b() {
        List<ICardInfo> list = this.f60556b;
        return list != null && list.size() > 0;
    }

    @Override // d.a.o0.k1.p.a
    public int c() {
        return this.f60562h;
    }

    @Override // d.a.o0.k1.p.a
    public void d(boolean z, Message message, boolean z2, int i2) {
        if (z) {
            this.l = true;
        } else {
            this.k = true;
        }
        DataRes dataRes = (DataRes) message;
        if (dataRes == null) {
            return;
        }
        this.f60561g = dataRes.has_more.intValue() == 1;
        if (!TextUtils.isEmpty(dataRes.page_info)) {
            try {
                JSONObject jSONObject = new JSONObject(dataRes.page_info);
                JSONObject optJSONObject = jSONObject.optJSONObject("title");
                if (optJSONObject != null) {
                    this.f60557c = optJSONObject.optString("name");
                    this.f60558d = optJSONObject.optString("url");
                    this.f60559e = optJSONObject.optString("urlNight");
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("buttons");
                if (optJSONArray != null) {
                    if (this.f60560f == null) {
                        this.f60560f = new ArrayList();
                    } else {
                        this.f60560f.clear();
                    }
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                        if (optJSONObject2 != null) {
                            d dVar = new d();
                            dVar.b(optJSONObject2);
                            if (dVar.a()) {
                                this.f60560f.add(dVar);
                            }
                        }
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        ArrayList arrayList = new ArrayList();
        if (dataRes.cards != null) {
            for (int i4 = 0; i4 < dataRes.cards.size(); i4++) {
                ICardInfo i5 = d.a.o0.k1.o.b.i(dataRes.cards.get(i4));
                if (i5 != null && i5.isValid()) {
                    arrayList.add(i5);
                }
                if (i4 == dataRes.cards.size() - 1 && i5 != null) {
                    p(i5.getFlipId());
                }
            }
        }
        if (z2) {
            this.f60556b.addAll(arrayList);
            this.f60562h = i2;
            return;
        }
        this.f60562h = 1;
        this.f60556b = arrayList;
    }

    @Override // d.a.o0.k1.p.a
    public List<ICardInfo> e() {
        return this.f60556b;
    }

    public List<d> f() {
        return this.f60560f;
    }

    public String g() {
        return this.f60563i;
    }

    public int h() {
        return this.j;
    }

    public e i() {
        return this.f60555a;
    }

    public String j() {
        return this.f60557c;
    }

    public String k() {
        return this.f60558d;
    }

    public String l() {
        return this.f60559e;
    }

    public boolean m() {
        return this.k;
    }

    public boolean n() {
        return this.l;
    }

    public boolean o() {
        return this.m;
    }

    public void p(String str) {
        this.f60563i = str;
    }

    public void q(int i2) {
        this.j = i2;
    }

    public void r(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("page_info");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016455, optString));
            if (!TextUtils.isEmpty(optString)) {
                JSONObject jSONObject2 = new JSONObject(optString);
                JSONObject optJSONObject = jSONObject2.optJSONObject("title");
                if (optJSONObject != null) {
                    this.f60557c = optJSONObject.optString("name");
                    this.f60558d = optJSONObject.optString("url");
                    this.f60559e = optJSONObject.optString("urlNight");
                }
                JSONArray optJSONArray = jSONObject2.optJSONArray("buttons");
                if (optJSONArray != null) {
                    if (this.f60560f == null) {
                        this.f60560f = new ArrayList();
                    } else {
                        this.f60560f.clear();
                    }
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject2 != null) {
                            d dVar = new d();
                            dVar.b(optJSONObject2);
                            if (dVar.a()) {
                                this.f60560f.add(dVar);
                            }
                        }
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("cards");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray2 != null) {
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    ICardInfo i4 = d.a.o0.k1.o.b.i(optJSONArray2.getString(i3));
                    if (i4 != null && i4.isValid()) {
                        arrayList.add(i4);
                    }
                    if (i3 == optJSONArray2.length() - 1 && i4 != null) {
                        p(i4.getFlipId());
                    }
                }
            }
            this.f60556b = arrayList;
            if (b()) {
                this.m = true;
            } else {
                this.m = false;
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
