package d.a.n0.e3.l0.d;

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
    public String f54119a;

    /* renamed from: c  reason: collision with root package name */
    public String f54121c;

    /* renamed from: d  reason: collision with root package name */
    public String f54122d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f54123e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f54124f;

    /* renamed from: b  reason: collision with root package name */
    public int f54120b = -1;

    /* renamed from: g  reason: collision with root package name */
    public boolean f54125g = true;

    public String a() {
        return this.f54122d;
    }

    public String b() {
        return this.f54121c;
    }

    public String c() {
        return this.f54119a;
    }

    public String d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", this.f54120b);
            jSONObject.put("message", this.f54121c);
            if (StringHelper.isJSONObject(this.f54122d)) {
                jSONObject.put("data", new JSONObject(this.f54122d));
            } else if (StringHelper.isJSONArray(this.f54122d)) {
                jSONObject.put("data", new JSONArray(this.f54122d));
            } else {
                jSONObject.put("data", this.f54122d);
            }
        } catch (JSONException e2) {
            BdLog.e(e2);
        }
        return jSONObject.toString();
    }

    public int e() {
        return this.f54120b;
    }

    public boolean f() {
        return this.f54125g;
    }

    public boolean g() {
        return this.f54120b > 0;
    }

    public boolean h() {
        return this.f54123e;
    }

    public boolean i() {
        return this.f54124f;
    }

    public boolean j() {
        return this.f54120b != -1;
    }

    public void k(boolean z) {
        this.f54125g = z;
    }

    public void l(String str) {
        this.f54122d = str;
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
        this.f54123e = z;
    }

    public void p(boolean z) {
        this.f54124f = z;
    }

    public void q(String str) {
        this.f54121c = str;
    }

    public void r(String str) {
        if (k.isEmpty(this.f54121c)) {
            this.f54121c = str;
        }
    }

    public void s(String str) {
        this.f54119a = str;
    }

    public void t(int i2) {
        this.f54120b = i2;
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
        if (this.f54120b == -1) {
            t(i2);
        }
    }
}
