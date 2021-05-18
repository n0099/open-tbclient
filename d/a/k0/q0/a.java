package d.a.k0.q0;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.j0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<a2> f58214a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f58215b;

    /* renamed from: c  reason: collision with root package name */
    public String f58216c;

    /* renamed from: d  reason: collision with root package name */
    public int f58217d;

    /* renamed from: e  reason: collision with root package name */
    public List<FrsTabInfo> f58218e;

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<FrsTabInfo> f58219f;

    /* renamed from: g  reason: collision with root package name */
    public x0 f58220g;

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static a f58221a = new a();
    }

    public static a h() {
        return b.f58221a;
    }

    public boolean a(a2 a2Var) {
        if (a2Var == null) {
            return false;
        }
        if (this.f58214a.size() > 29) {
            x0 x0Var = this.f58220g;
            if (x0Var != null) {
                x0Var.b(2);
            }
            return false;
        }
        this.f58214a.add(a2Var);
        x0 x0Var2 = this.f58220g;
        if (x0Var2 != null) {
            x0Var2.c(this.f58214a.size(), 2);
            return true;
        }
        return true;
    }

    public void b() {
        for (a2 a2Var : this.f58214a) {
            if (a2Var != null) {
                a2Var.W3(false);
            }
        }
        this.f58214a.clear();
        x0 x0Var = this.f58220g;
        if (x0Var != null) {
            x0Var.c(0, 2);
        }
    }

    public void c() {
        this.f58216c = null;
        this.f58217d = -1;
        List<FrsTabInfo> list = this.f58218e;
        if (list != null) {
            list.clear();
        }
        SparseArray<FrsTabInfo> sparseArray = this.f58219f;
        if (sparseArray != null) {
            sparseArray.clear();
        }
    }

    public void d() {
        if (ListUtils.isEmpty(this.f58214a)) {
            return;
        }
        this.f58214a.clear();
        x0 x0Var = this.f58220g;
        if (x0Var != null) {
            x0Var.c(this.f58214a.size(), 2);
        }
    }

    public int e() {
        return this.f58217d;
    }

    public String f() {
        return this.f58216c;
    }

    public List<FrsTabInfo> g() {
        return this.f58218e;
    }

    public List<a2> i() {
        return this.f58214a;
    }

    public boolean j() {
        return this.f58215b;
    }

    public boolean k(int i2) {
        return this.f58219f.get(i2) != null && this.f58219f.get(i2).is_general_tab.intValue() == 1;
    }

    public void l(a2 a2Var) {
        this.f58214a.remove(a2Var);
        x0 x0Var = this.f58220g;
        if (x0Var != null) {
            x0Var.c(this.f58214a.size(), 2);
        }
    }

    public void m(int i2, int i3) {
        try {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_MOVE_AREA);
            JSONArray jSONArray = new JSONArray();
            for (a2 a2Var : h().i()) {
                if (a2Var != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("thread_id", a2Var.o0());
                    jSONObject.put("from_tab_id", a2Var.m1());
                    jSONObject.put("to_tab_id", i3);
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

    public void o(int i2) {
        this.f58217d = i2;
    }

    public void p(boolean z, boolean z2) {
        this.f58215b = z;
        x0 x0Var = this.f58220g;
        if (x0Var != null) {
            x0Var.a(z, z2, 2);
        }
    }

    public void q(String str) {
        this.f58216c = str;
    }

    public void r(List<FrsTabInfo> list) {
        this.f58218e = new ArrayList(list);
        this.f58219f = new SparseArray<>();
        for (FrsTabInfo frsTabInfo : this.f58218e) {
            if (frsTabInfo != null) {
                this.f58219f.append(frsTabInfo.tab_id.intValue(), frsTabInfo);
            }
        }
    }

    public void s(x0 x0Var) {
        this.f58220g = x0Var;
    }

    public a() {
        this.f58217d = -1;
        this.f58214a = new ArrayList();
    }
}
