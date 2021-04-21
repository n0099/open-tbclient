package d.b.j0.j1.p;

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
    public final e f57883a;

    /* renamed from: c  reason: collision with root package name */
    public String f57885c;

    /* renamed from: d  reason: collision with root package name */
    public String f57886d;

    /* renamed from: e  reason: collision with root package name */
    public String f57887e;

    /* renamed from: f  reason: collision with root package name */
    public List<d> f57888f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f57889g;
    public String i;
    public int j;

    /* renamed from: b  reason: collision with root package name */
    public List<ICardInfo> f57884b = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public int f57890h = 1;
    public boolean k = false;
    public boolean l = false;
    public boolean m = false;

    public c(e eVar) {
        this.f57883a = eVar;
    }

    @Override // d.b.j0.j1.p.a
    public int a() {
        return this.f57890h;
    }

    @Override // d.b.j0.j1.p.a
    public boolean b() {
        return this.f57889g;
    }

    @Override // d.b.j0.j1.p.a
    public boolean c() {
        List<ICardInfo> list = this.f57884b;
        return list != null && list.size() > 0;
    }

    @Override // d.b.j0.j1.p.a
    public void d(boolean z, Message message, boolean z2, int i) {
        if (z) {
            this.l = true;
        } else {
            this.k = true;
        }
        DataRes dataRes = (DataRes) message;
        if (dataRes == null) {
            return;
        }
        this.f57889g = dataRes.has_more.intValue() == 1;
        if (!TextUtils.isEmpty(dataRes.page_info)) {
            try {
                JSONObject jSONObject = new JSONObject(dataRes.page_info);
                JSONObject optJSONObject = jSONObject.optJSONObject("title");
                if (optJSONObject != null) {
                    this.f57885c = optJSONObject.optString("name");
                    this.f57886d = optJSONObject.optString("url");
                    this.f57887e = optJSONObject.optString("urlNight");
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("buttons");
                if (optJSONArray != null) {
                    if (this.f57888f == null) {
                        this.f57888f = new ArrayList();
                    } else {
                        this.f57888f.clear();
                    }
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject2 != null) {
                            d dVar = new d();
                            dVar.b(optJSONObject2);
                            if (dVar.a()) {
                                this.f57888f.add(dVar);
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
            for (int i3 = 0; i3 < dataRes.cards.size(); i3++) {
                ICardInfo i4 = d.b.j0.j1.o.b.i(dataRes.cards.get(i3));
                if (i4 != null && i4.isValid()) {
                    arrayList.add(i4);
                }
                if (i3 == dataRes.cards.size() - 1 && i4 != null) {
                    p(i4.getFlipId());
                }
            }
        }
        if (z2) {
            this.f57884b.addAll(arrayList);
            this.f57890h = i;
            return;
        }
        this.f57890h = 1;
        this.f57884b = arrayList;
    }

    @Override // d.b.j0.j1.p.a
    public List<ICardInfo> e() {
        return this.f57884b;
    }

    public List<d> f() {
        return this.f57888f;
    }

    public String g() {
        return this.i;
    }

    public int h() {
        return this.j;
    }

    public e i() {
        return this.f57883a;
    }

    public String j() {
        return this.f57885c;
    }

    public String k() {
        return this.f57886d;
    }

    public String l() {
        return this.f57887e;
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
        this.i = str;
    }

    public void q(int i) {
        this.j = i;
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
                    this.f57885c = optJSONObject.optString("name");
                    this.f57886d = optJSONObject.optString("url");
                    this.f57887e = optJSONObject.optString("urlNight");
                }
                JSONArray optJSONArray = jSONObject2.optJSONArray("buttons");
                if (optJSONArray != null) {
                    if (this.f57888f == null) {
                        this.f57888f = new ArrayList();
                    } else {
                        this.f57888f.clear();
                    }
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                        if (optJSONObject2 != null) {
                            d dVar = new d();
                            dVar.b(optJSONObject2);
                            if (dVar.a()) {
                                this.f57888f.add(dVar);
                            }
                        }
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("cards");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    ICardInfo i3 = d.b.j0.j1.o.b.i(optJSONArray2.getString(i2));
                    if (i3 != null && i3.isValid()) {
                        arrayList.add(i3);
                    }
                    if (i2 == optJSONArray2.length() - 1 && i3 != null) {
                        p(i3.getFlipId());
                    }
                }
            }
            this.f57884b = arrayList;
            if (c()) {
                this.m = true;
            } else {
                this.m = false;
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
