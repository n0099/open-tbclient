package d.a.o0.e3.l0.d;

import android.os.Build;
import android.webkit.WebView;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.h5power.DescriptionTableInfo;
import d.a.c.e.p.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<a> f57946a = new ArrayList<>();

    public void a(a aVar) {
        this.f57946a.add(aVar);
    }

    public final void b(WebView webView, String str, String str2) {
        if (webView == null || k.isEmpty(str) || k.isEmpty(str2)) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
            return;
        }
        webView.loadUrl("javascript:" + str + "&&" + str + "('" + str2 + "')");
    }

    public c c(e eVar, c cVar) {
        if (cVar == null) {
            cVar = new c();
        }
        if (ActionJsonData.TAG_NOTIFICATION.equals(eVar.c()) && "addObserver".equals(eVar.a())) {
            Iterator<a> it = this.f57946a.iterator();
            while (it.hasNext()) {
                cVar = it.next().addObserver(eVar.d(), cVar, true);
                if (cVar.i()) {
                    return cVar;
                }
            }
            if (!cVar.i()) {
                cVar.u(202);
                cVar.r(TbadkCoreApplication.getInst().getString(R.string.can_find_notification_name));
            }
        } else {
            String c2 = eVar.c();
            if (!k.isEmpty(c2) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c2)) {
                cVar.u(201);
                return cVar;
            }
            Iterator<a> it2 = this.f57946a.iterator();
            while (it2.hasNext()) {
                cVar = it2.next().dispatch(eVar, cVar);
                if (cVar.h()) {
                    return cVar;
                }
            }
            if (!cVar.h()) {
                cVar.u(202);
            }
        }
        return cVar;
    }

    public void d(WebView webView, c cVar) {
        if (webView == null || cVar == null || !cVar.j()) {
            return;
        }
        b(webView, cVar.c(), cVar.d());
    }

    public void e(WebView webView, List<c> list) {
        if (webView == null || ListUtils.isEmpty(list)) {
            return;
        }
        for (c cVar : list) {
            if (cVar != null && cVar.j()) {
                b(webView, cVar.c(), cVar.d());
            }
        }
    }

    public List<c> f(String str, HashMap hashMap) {
        List<c> list = null;
        if (k.isEmpty(str)) {
            return null;
        }
        Iterator<a> it = this.f57946a.iterator();
        while (it.hasNext()) {
            list = it.next().processNotification(str, hashMap);
            if (!ListUtils.isEmpty(list)) {
                break;
            }
        }
        return list;
    }
}
