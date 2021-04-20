package d.b.i0.q0;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.h0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<a2> f59012a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f59013b;

    /* renamed from: c  reason: collision with root package name */
    public String f59014c;

    /* renamed from: d  reason: collision with root package name */
    public int f59015d;

    /* renamed from: e  reason: collision with root package name */
    public List<FrsTabInfo> f59016e;

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<FrsTabInfo> f59017f;

    /* renamed from: g  reason: collision with root package name */
    public x0 f59018g;

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static a f59019a = new a();
    }

    public static a h() {
        return b.f59019a;
    }

    public boolean a(a2 a2Var) {
        if (a2Var == null) {
            return false;
        }
        if (this.f59012a.size() > 29) {
            x0 x0Var = this.f59018g;
            if (x0Var != null) {
                x0Var.a(2);
            }
            return false;
        }
        this.f59012a.add(a2Var);
        x0 x0Var2 = this.f59018g;
        if (x0Var2 != null) {
            x0Var2.c(this.f59012a.size(), 2);
            return true;
        }
        return true;
    }

    public void b() {
        for (a2 a2Var : this.f59012a) {
            if (a2Var != null) {
                a2Var.U3(false);
            }
        }
        this.f59012a.clear();
        x0 x0Var = this.f59018g;
        if (x0Var != null) {
            x0Var.c(0, 2);
        }
    }

    public void c() {
        this.f59014c = null;
        this.f59015d = -1;
        List<FrsTabInfo> list = this.f59016e;
        if (list != null) {
            list.clear();
        }
        SparseArray<FrsTabInfo> sparseArray = this.f59017f;
        if (sparseArray != null) {
            sparseArray.clear();
        }
    }

    public void d() {
        if (ListUtils.isEmpty(this.f59012a)) {
            return;
        }
        this.f59012a.clear();
        x0 x0Var = this.f59018g;
        if (x0Var != null) {
            x0Var.c(this.f59012a.size(), 2);
        }
    }

    public int e() {
        return this.f59015d;
    }

    public String f() {
        return this.f59014c;
    }

    public List<FrsTabInfo> g() {
        return this.f59016e;
    }

    public List<a2> i() {
        return this.f59012a;
    }

    public boolean j() {
        return this.f59013b;
    }

    public boolean k(int i) {
        return this.f59017f.get(i) != null && this.f59017f.get(i).is_general_tab.intValue() == 1;
    }

    public void l(a2 a2Var) {
        this.f59012a.remove(a2Var);
        x0 x0Var = this.f59018g;
        if (x0Var != null) {
            x0Var.c(this.f59012a.size(), 2);
        }
    }

    public void m(int i, int i2) {
        try {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_MOVE_AREA);
            JSONArray jSONArray = new JSONArray();
            for (a2 a2Var : h().i()) {
                if (a2Var != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("thread_id", a2Var.o0());
                    jSONObject.put("from_tab_id", a2Var.m1());
                    jSONObject.put("to_tab_id", i2);
                    jSONArray.put(jSONObject);
                }
            }
            httpMessage.addParam("threads", jSONArray.toString());
            httpMessage.addParam("forum_id", h().f());
            MessageManager.getInstance().sendMessage(httpMessage);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void n() {
        p(false, false);
        b();
    }

    public void o(int i) {
        this.f59015d = i;
    }

    public void p(boolean z, boolean z2) {
        this.f59013b = z;
        x0 x0Var = this.f59018g;
        if (x0Var != null) {
            x0Var.b(z, z2, 2);
        }
    }

    public void q(String str) {
        this.f59014c = str;
    }

    public void r(List<FrsTabInfo> list) {
        this.f59016e = new ArrayList(list);
        this.f59017f = new SparseArray<>();
        for (FrsTabInfo frsTabInfo : this.f59016e) {
            if (frsTabInfo != null) {
                this.f59017f.append(frsTabInfo.tab_id.intValue(), frsTabInfo);
            }
        }
    }

    public void s(x0 x0Var) {
        this.f59018g = x0Var;
    }

    public a() {
        this.f59015d = -1;
        this.f59012a = new ArrayList();
    }
}
