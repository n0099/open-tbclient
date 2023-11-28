package com.kwad.sdk.core.webview;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.bg;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    public WebView NP;
    public ViewGroup Ov;
    public com.kwad.sdk.widget.e aCG;
    @Nullable
    public af aCH;
    public boolean aCI = true;
    public boolean aCJ = true;
    public List<AdTemplate> aCK = null;
    public AdResultData mAdResultData;
    @Nullable
    public JSONObject mReportExtData;
    public int mScreenOrientation;

    public final List<AdTemplate> FD() {
        List<AdTemplate> list = this.aCK;
        if (list != null && list.size() > 0) {
            return this.aCK;
        }
        return this.mAdResultData.getAdTemplateList();
    }

    public final boolean FE() {
        if (FD() != null && FD().size() != 0) {
            return false;
        }
        return true;
    }

    public final AdTemplate getAdTemplate() {
        List<AdTemplate> list = this.aCK;
        if (list != null && list.size() > 0) {
            return this.aCK.get(0);
        }
        return com.kwad.sdk.core.response.b.c.m(this.mAdResultData);
    }

    public final AdResultData hi() {
        AdResultData adResultData = this.mAdResultData;
        if (adResultData != null) {
            return adResultData;
        }
        if (this.aCK != null) {
            AdResultData adResultData2 = new AdResultData();
            adResultData2.setAdTemplateList(this.aCK);
            return adResultData2;
        }
        return null;
    }

    public final AdTemplate cH(String str) {
        if (TextUtils.isEmpty(str)) {
            return getAdTemplate();
        }
        for (AdTemplate adTemplate : FD()) {
            if (bg.isEquals(str, String.valueOf(com.kwad.sdk.core.response.b.e.dZ(adTemplate)))) {
                return adTemplate;
            }
        }
        return null;
    }

    public final void d(AdResultData adResultData) {
        this.mAdResultData = adResultData;
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.aCK = arrayList;
        arrayList.add(adTemplate);
    }

    public final void setAdTemplateList(List<AdTemplate> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (AdTemplate adTemplate : list) {
            arrayList.add(adTemplate);
        }
        this.aCK = arrayList;
    }
}
