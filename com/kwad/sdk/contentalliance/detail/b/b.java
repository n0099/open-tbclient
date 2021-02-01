package com.kwad.sdk.contentalliance.detail.b;

import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private List<KsContentPage.SubShowItem> f8402a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private Map<String, KsContentPage.SubShowItem> f8403b = new HashMap();

    public int a(AdTemplate adTemplate, int i) {
        if (adTemplate == null) {
            return 0;
        }
        String str = adTemplate.mUniqueId;
        if (this.f8403b.containsKey(str)) {
            return 3;
        }
        if (adTemplate.contentType == 3) {
            com.kwad.sdk.core.d.a.a("ThirdModelManager", "检测到第三方广告位，开始尝试插入,position:" + i);
            if (this.f8402a.size() > 0) {
                this.f8403b.put(str, this.f8402a.remove(0));
                com.kwad.sdk.core.d.a.a("ThirdModelManager", "检测到第三方广告位，插入成功,position:" + i);
                return 3;
            } else if (adTemplate.adInfoList.size() <= 0 || adTemplate.adInfoList.get(0) == null) {
                com.kwad.sdk.core.d.a.a("ThirdModelManager", "检测到第三方广告位，插入失败丢弃该位置，position:" + i);
                e.i(adTemplate);
                return 0;
            } else {
                adTemplate.realShowType = 2;
                com.kwad.sdk.core.d.a.a("ThirdModelManager", "检测到第三方广告位，插入失败使用默认广告兜底,position:" + i);
                return 2;
            }
        }
        return 0;
    }

    public KsContentPage.SubShowItem a(AdTemplate adTemplate) {
        return this.f8403b.get(adTemplate.mUniqueId);
    }

    public void a(KsContentPage.SubShowItem subShowItem) {
        if (this.f8402a.contains(subShowItem)) {
            return;
        }
        this.f8402a.add(subShowItem);
    }

    public void a(List<KsContentPage.SubShowItem> list) {
        if (list == null) {
            return;
        }
        for (KsContentPage.SubShowItem subShowItem : list) {
            a(subShowItem);
        }
    }
}
