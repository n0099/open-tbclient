package d.a.o0.e3.l0.d;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import d.a.c.e.p.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f57933a;

    /* renamed from: c  reason: collision with root package name */
    public String f57935c;

    /* renamed from: d  reason: collision with root package name */
    public String f57936d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f57937e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f57938f;

    /* renamed from: b  reason: collision with root package name */
    public int f57934b = -1;

    /* renamed from: g  reason: collision with root package name */
    public boolean f57939g = true;

    public String a() {
        return this.f57936d;
    }

    public String b() {
        return this.f57935c;
    }

    public String c() {
        return this.f57933a;
    }

    public String d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", this.f57934b);
            jSONObject.put("message", this.f57935c);
            if (StringHelper.isJSONObject(this.f57936d)) {
                jSONObject.put("data", new JSONObject(this.f57936d));
            } else if (StringHelper.isJSONArray(this.f57936d)) {
                jSONObject.put("data", new JSONArray(this.f57936d));
            } else {
                jSONObject.put("data", this.f57936d);
            }
        } catch (JSONException e2) {
            BdLog.e(e2);
        }
        return jSONObject.toString();
    }

    public int e() {
        return this.f57934b;
    }

    public boolean f() {
        return this.f57939g;
    }

    public boolean g() {
        return this.f57934b > 0;
    }

    public boolean h() {
        return this.f57937e;
    }

    public boolean i() {
        return this.f57938f;
    }

    public boolean j() {
        return this.f57934b != -1;
    }

    public void k(boolean z) {
        this.f57939g = z;
    }

    public void l(String str) {
        this.f57936d = str;
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
        this.f57937e = z;
    }

    public void p(boolean z) {
        this.f57938f = z;
    }

    public void q(String str) {
        this.f57935c = str;
    }

    public void r(String str) {
        if (k.isEmpty(this.f57935c)) {
            this.f57935c = str;
        }
    }

    public void s(String str) {
        this.f57933a = str;
    }

    public void t(int i2) {
        this.f57934b = i2;
        if (i2 == 0) {
            r(TbadkCoreApplication.getInst().getString(R.string.scheme_action_status_ok));
        } else if (i2 == 101) {
            r(TbadkCoreApplication.getInst().getString(R.string.scheme_action_status_scheme_parse_fail));
        } else if (i2 == 301) {
            r(TbadkCoreApplication.getInst().getString(R.string.scheme_action_security_check_fail));
        } else if (i2 == 201) {
            r(TbadkCoreApplication.getInst().getString(R.string.scheme_action_can_not_find_module));
        } else if (i2 != 202) {
        } else {
            r(TbadkCoreApplication.getInst().getString(R.string.scheme_action_can_not_find_action));
        }
    }

    public void u(int i2) {
        if (this.f57934b == -1) {
            t(i2);
        }
    }
}
