package com.kwad.sdk.contentalliance.detail.b;

import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public List<KsContentPage.SubShowItem> f32809a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, KsContentPage.SubShowItem> f32810b = new HashMap();

    public int a(AdTemplate adTemplate, int i2) {
        if (adTemplate == null) {
            return 0;
        }
        String str = adTemplate.mUniqueId;
        if (this.f32810b.containsKey(str)) {
            return 3;
        }
        if (adTemplate.contentType == 3) {
            com.kwad.sdk.core.d.a.a("ThirdModelManager", "检测到第三方广告位，开始尝试插入,position:" + i2);
            if (this.f32809a.size() > 0) {
                this.f32810b.put(str, this.f32809a.remove(0));
                com.kwad.sdk.core.d.a.a("ThirdModelManager", "检测到第三方广告位，插入成功,position:" + i2);
                return 3;
            } else if (adTemplate.adInfoList.size() > 0 && adTemplate.adInfoList.get(0) != null) {
                adTemplate.realShowType = 2;
                com.kwad.sdk.core.d.a.a("ThirdModelManager", "检测到第三方广告位，插入失败使用默认广告兜底,position:" + i2);
                return 2;
            } else {
                com.kwad.sdk.core.d.a.a("ThirdModelManager", "检测到第三方广告位，插入失败丢弃该位置，position:" + i2);
                e.i(adTemplate);
            }
        }
        return 0;
    }

    public KsContentPage.SubShowItem a(AdTemplate adTemplate) {
        return this.f32810b.get(adTemplate.mUniqueId);
    }

    public void a(KsContentPage.SubShowItem subShowItem) {
        if (this.f32809a.contains(subShowItem)) {
            return;
        }
        this.f32809a.add(subShowItem);
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
