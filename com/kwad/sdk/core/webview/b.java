package com.kwad.sdk.core.webview;

import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.widget.e;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class b {
    public int a;
    public e b;
    @Nullable
    public JSONObject c;
    public ViewGroup d;
    public WebView e;
    @Nullable
    public ab f;
    public boolean g = true;
    public boolean h = true;
    public List<AdTemplate> i = null;

    public final AdTemplate a() {
        List<AdTemplate> list = this.i;
        if (list == null || list.size() == 0) {
            return null;
        }
        return this.i.get(0);
    }

    public final void a(AdTemplate adTemplate) {
        ArrayList arrayList = new ArrayList();
        this.i = arrayList;
        arrayList.add(adTemplate);
    }

    public final void a(List<AdTemplate> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (AdTemplate adTemplate : list) {
            arrayList.add(adTemplate);
        }
        this.i = arrayList;
    }

    public final List<AdTemplate> b() {
        return this.i;
    }

    public final boolean c() {
        List<AdTemplate> list = this.i;
        return list == null || list.size() == 0;
    }
}
