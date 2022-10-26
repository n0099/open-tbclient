package com.kwad.sdk.core.webview;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.widget.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class b {
    public WebView Fv;
    public ViewGroup Gl;
    public e agd;
    public ad age;
    public boolean agf = true;
    public boolean agg = true;
    public List agh = null;
    public JSONObject mReportExtData;
    public int mScreenOrientation;

    public final AdTemplate getAdTemplate() {
        List list = this.agh;
        if (list == null || list.size() == 0) {
            return null;
        }
        return (AdTemplate) this.agh.get(0);
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        ArrayList arrayList = new ArrayList();
        this.agh = arrayList;
        arrayList.add(adTemplate);
    }

    public final void setAdTemplateList(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((AdTemplate) it.next());
        }
        this.agh = arrayList;
    }

    public final List wg() {
        return this.agh;
    }

    public final boolean wh() {
        List list = this.agh;
        return list == null || list.size() == 0;
    }
}
