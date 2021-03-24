package d.b.i0.p0;

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
    public final List<a2> f57312a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f57313b;

    /* renamed from: c  reason: collision with root package name */
    public String f57314c;

    /* renamed from: d  reason: collision with root package name */
    public int f57315d;

    /* renamed from: e  reason: collision with root package name */
    public List<FrsTabInfo> f57316e;

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<FrsTabInfo> f57317f;

    /* renamed from: g  reason: collision with root package name */
    public x0 f57318g;

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static a f57319a = new a();
    }

    public static a h() {
        return b.f57319a;
    }

    public boolean a(a2 a2Var) {
        if (a2Var == null) {
            return false;
        }
        if (this.f57312a.size() > 29) {
            x0 x0Var = this.f57318g;
            if (x0Var != null) {
                x0Var.a(2);
            }
            return false;
        }
        this.f57312a.add(a2Var);
        x0 x0Var2 = this.f57318g;
        if (x0Var2 != null) {
            x0Var2.c(this.f57312a.size(), 2);
            return true;
        }
        return true;
    }

    public void b() {
        for (a2 a2Var : this.f57312a) {
            if (a2Var != null) {
                a2Var.T3(false);
            }
        }
        this.f57312a.clear();
        x0 x0Var = this.f57318g;
        if (x0Var != null) {
            x0Var.c(0, 2);
        }
    }

    public void c() {
        this.f57314c = null;
        this.f57315d = -1;
        List<FrsTabInfo> list = this.f57316e;
        if (list != null) {
            list.clear();
        }
        SparseArray<FrsTabInfo> sparseArray = this.f57317f;
        if (sparseArray != null) {
            sparseArray.clear();
        }
    }

    public void d() {
        if (ListUtils.isEmpty(this.f57312a)) {
            return;
        }
        this.f57312a.clear();
        x0 x0Var = this.f57318g;
        if (x0Var != null) {
            x0Var.c(this.f57312a.size(), 2);
        }
    }

    public int e() {
        return this.f57315d;
    }

    public String f() {
        return this.f57314c;
    }

    public List<FrsTabInfo> g() {
        return this.f57316e;
    }

    public List<a2> i() {
        return this.f57312a;
    }

    public boolean j() {
        return this.f57313b;
    }

    public boolean k(int i) {
        return this.f57317f.get(i) != null && this.f57317f.get(i).is_general_tab.intValue() == 1;
    }

    public void l(a2 a2Var) {
        this.f57312a.remove(a2Var);
        x0 x0Var = this.f57318g;
        if (x0Var != null) {
            x0Var.c(this.f57312a.size(), 2);
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
        this.f57315d = i;
    }

    public void p(boolean z, boolean z2) {
        this.f57313b = z;
        x0 x0Var = this.f57318g;
        if (x0Var != null) {
            x0Var.b(z, z2, 2);
        }
    }

    public void q(String str) {
        this.f57314c = str;
    }

    public void r(List<FrsTabInfo> list) {
        this.f57316e = new ArrayList(list);
        this.f57317f = new SparseArray<>();
        for (FrsTabInfo frsTabInfo : this.f57316e) {
            if (frsTabInfo != null) {
                this.f57317f.append(frsTabInfo.tab_id.intValue(), frsTabInfo);
            }
        }
    }

    public void s(x0 x0Var) {
        this.f57318g = x0Var;
    }

    public a() {
        this.f57315d = -1;
        this.f57312a = new ArrayList();
    }
}
