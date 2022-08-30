package com.kwad.sdk.core.webview;

import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.widget.e;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class b {
    public WebView Fv;
    public ViewGroup Gl;
    public e agd;
    @Nullable
    public ad age;
    public boolean agf = true;
    public boolean agg = true;
    public List<AdTemplate> agh = null;
    @Nullable
    public JSONObject mReportExtData;
    public int mScreenOrientation;

    public final AdTemplate getAdTemplate() {
        List<AdTemplate> list = this.agh;
        if (list == null || list.size() == 0) {
            return null;
        }
        return this.agh.get(0);
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        ArrayList arrayList = new ArrayList();
        this.agh = arrayList;
        arrayList.add(adTemplate);
    }

    public final void setAdTemplateList(List<AdTemplate> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (AdTemplate adTemplate : list) {
            arrayList.add(adTemplate);
        }
        this.agh = arrayList;
    }

    public final List<AdTemplate> wg() {
        return this.agh;
    }

    public final boolean wh() {
        List<AdTemplate> list = this.agh;
        return list == null || list.size() == 0;
    }
}
