package d.b.i0.c3.l0.d;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import d.b.b.e.p.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f53493a;

    /* renamed from: c  reason: collision with root package name */
    public String f53495c;

    /* renamed from: d  reason: collision with root package name */
    public String f53496d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f53497e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f53498f;

    /* renamed from: b  reason: collision with root package name */
    public int f53494b = -1;

    /* renamed from: g  reason: collision with root package name */
    public boolean f53499g = true;

    public String a() {
        return this.f53496d;
    }

    public String b() {
        return this.f53495c;
    }

    public String c() {
        return this.f53493a;
    }

    public String d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", this.f53494b);
            jSONObject.put("message", this.f53495c);
            if (StringHelper.isJSONObject(this.f53496d)) {
                jSONObject.put("data", new JSONObject(this.f53496d));
            } else if (StringHelper.isJSONArray(this.f53496d)) {
                jSONObject.put("data", new JSONArray(this.f53496d));
            } else {
                jSONObject.put("data", this.f53496d);
            }
        } catch (JSONException e2) {
            BdLog.e(e2);
        }
        return jSONObject.toString();
    }

    public int e() {
        return this.f53494b;
    }

    public boolean f() {
        return this.f53499g;
    }

    public boolean g() {
        return this.f53494b > 0;
    }

    public boolean h() {
        return this.f53497e;
    }

    public boolean i() {
        return this.f53498f;
    }

    public boolean j() {
        return this.f53494b != -1;
    }

    public void k(boolean z) {
        this.f53499g = z;
    }

    public void l(String str) {
        this.f53496d = str;
    }

    public void m() {
        r(TbadkCoreApplication.getInst().getString(R.string.na_business_error));
        u(401);
    }

    public void n(String str) {
        r(str);
        u(401);
    }

    public void o(boolean z) {
        this.f53497e = z;
    }

    public void p(boolean z) {
        this.f53498f = z;
    }

    public void q(String str) {
        this.f53495c = str;
    }

    public void r(String str) {
        if (k.isEmpty(this.f53495c)) {
            this.f53495c = str;
        }
    }

    public void s(String str) {
        this.f53493a = str;
    }

    public void t(int i) {
        this.f53494b = i;
        if (i == 0) {
            r(TbadkCoreApplication.getInst().getString(R.string.scheme_action_status_ok));
        } else if (i == 101) {
            r(TbadkCoreApplication.getInst().getString(R.string.scheme_action_status_scheme_parse_fail));
        } else if (i == 301) {
            r(TbadkCoreApplication.getInst().getString(R.string.scheme_action_security_check_fail));
        } else if (i == 201) {
            r(TbadkCoreApplication.getInst().getString(R.string.scheme_action_can_not_find_module));
        } else if (i != 202) {
        } else {
            r(TbadkCoreApplication.getInst().getString(R.string.scheme_action_can_not_find_action));
        }
    }

    public void u(int i) {
        if (this.f53494b == -1) {
            t(i);
        }
    }
}
