package com.kwad.sdk.core.webview;

import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.download.a.b;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.ac;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {
    public int a;
    public AdBaseFrameLayout b;
    @Nullable
    public JSONObject c;
    public ViewGroup d;
    public WebView e;
    public b f;
    @Nullable
    public ac g;
    public boolean h = true;
    public boolean i = true;
    public List<AdTemplate> j = null;

    public AdTemplate a() {
        List<AdTemplate> list = this.j;
        if (list == null || list.size() == 0) {
            return null;
        }
        return this.j.get(0);
    }

    @Nullable
    public AdTemplate a(long j) {
        List<AdTemplate> list;
        if (j >= 0 && (list = this.j) != null) {
            for (AdTemplate adTemplate : list) {
                if (d.y(adTemplate) == j) {
                    return adTemplate;
                }
            }
        }
        return null;
    }

    public void a(AdTemplate adTemplate) {
        ArrayList arrayList = new ArrayList();
        this.j = arrayList;
        arrayList.add(adTemplate);
    }

    public void a(List<AdTemplate> list) {
        this.j = list;
    }

    public List<AdTemplate> b() {
        return this.j;
    }

    public boolean c() {
        List<AdTemplate> list = this.j;
        return list == null || list.size() == 0;
    }
}
