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
/* loaded from: classes3.dex */
public class a {
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f56327b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f56328c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f56329d;

    /* renamed from: e  reason: collision with root package name */
    public WebView f56330e;

    /* renamed from: f  reason: collision with root package name */
    public b f56331f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public ac f56332g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f56333h = true;

    /* renamed from: i  reason: collision with root package name */
    public boolean f56334i = true;

    /* renamed from: j  reason: collision with root package name */
    public List<AdTemplate> f56335j = null;

    public AdTemplate a() {
        List<AdTemplate> list = this.f56335j;
        if (list == null || list.size() == 0) {
            return null;
        }
        return this.f56335j.get(0);
    }

    @Nullable
    public AdTemplate a(long j2) {
        List<AdTemplate> list;
        if (j2 >= 0 && (list = this.f56335j) != null) {
            for (AdTemplate adTemplate : list) {
                if (d.y(adTemplate) == j2) {
                    return adTemplate;
                }
            }
        }
        return null;
    }

    public void a(AdTemplate adTemplate) {
        ArrayList arrayList = new ArrayList();
        this.f56335j = arrayList;
        arrayList.add(adTemplate);
    }

    public void a(List<AdTemplate> list) {
        this.f56335j = list;
    }

    public List<AdTemplate> b() {
        return this.f56335j;
    }

    public boolean c() {
        List<AdTemplate> list = this.f56335j;
        return list == null || list.size() == 0;
    }
}
