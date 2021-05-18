package d.a.k0.d3.l0;

import android.webkit.JsPromptResult;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.e.p.k;
import d.a.k0.d3.l0.d.e;
import d.a.k0.d3.l0.d.f;
import d.a.k0.d3.l0.d.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<b> f53902a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public f f53903b = new f();

    public void a(b bVar) {
        if (bVar != null) {
            this.f53902a.add(bVar);
        }
        if (this.f53903b == null || bVar == null || bVar.getClass().getAnnotation(d.a.e.a.a.class) == null) {
            return;
        }
        try {
            this.f53903b.a((d.a.k0.d3.l0.d.a) Class.forName("com.baidu.tieba.h5power." + bVar.getClass().getSimpleName() + d.a.k0.d3.l0.d.a.PROXY_CLASS_NAME_SUFFIX).getConstructor(bVar.getClass()).newInstance(bVar));
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    public boolean b(WebView webView, String str, JsPromptResult jsPromptResult) {
        if (str.startsWith("tiebaapp")) {
            e(webView, str);
            return false;
        }
        return c(str, jsPromptResult);
    }

    public boolean c(String str, JsPromptResult jsPromptResult) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("interfaceName");
            String optString2 = jSONObject.optString("methodName");
            String optString3 = jSONObject.optString("param");
            if (!StringUtils.isNull(optString) && !StringUtils.isNull(optString2) && !StringUtils.isNull(optString3)) {
                return d(optString, optString2, optString3, jsPromptResult);
            }
        } catch (JSONException unused) {
        }
        return false;
    }

    public final boolean d(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (ListUtils.getCount(this.f53902a) > 0) {
            Iterator<b> it = this.f53902a.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.dealJsInterface(str, str2, str3, jsPromptResult)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public final void e(WebView webView, String str) {
        if (this.f53903b == null) {
            return;
        }
        e eVar = new e();
        d.a.k0.d3.l0.d.c cVar = new d.a.k0.d3.l0.d.c();
        String a2 = g.a(str);
        eVar.f(a2);
        String d2 = g.d(str);
        eVar.h(d2);
        String b2 = g.b(str);
        cVar.s(b2);
        if (k.isEmpty(a2) || k.isEmpty(d2) || k.isEmpty(b2)) {
            cVar.u(101);
        }
        try {
            eVar.j(g.f(str));
        } catch (JSONException unused) {
            eVar.j(new JSONObject());
            cVar.u(101);
        }
        eVar.i(g.e(str));
        eVar.g(g.c(str));
        d.a.k0.d3.l0.d.c c2 = this.f53903b.c(eVar, cVar);
        if (c2.f()) {
            this.f53903b.d(webView, c2);
        }
    }

    public void f() {
        this.f53902a.clear();
    }

    public void g(b bVar) {
        if (bVar != null) {
            this.f53902a.remove(bVar);
        }
    }

    public void h(WebView webView, String str, @Nullable HashMap hashMap) {
        f fVar = this.f53903b;
        if (fVar == null) {
            return;
        }
        this.f53903b.e(webView, fVar.f(str, hashMap));
    }
}
