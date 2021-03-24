package com.kwad.sdk.contentalliance.profile.home.c;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import com.kwad.sdk.contentalliance.profile.home.ProfileHomeParam;
import com.kwad.sdk.contentalliance.profile.home.model.UserProfile;
import com.kwad.sdk.contentalliance.profile.tabvideo.ProfileTabVideoParam;
import com.kwad.sdk.lib.widget.viewpager.tabstrip.PagerSlidingTabStrip;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class e extends com.kwad.sdk.contentalliance.profile.home.b.a {

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.profile.home.c f32901b;

    /* renamed from: c  reason: collision with root package name */
    public ViewPager f32902c;

    /* renamed from: d  reason: collision with root package name */
    public ProfileHomeParam f32903d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.profile.home.a.a f32904e = new com.kwad.sdk.contentalliance.profile.home.a.a() { // from class: com.kwad.sdk.contentalliance.profile.home.c.e.1
        @Override // com.kwad.sdk.contentalliance.profile.home.a.a
        public void a(@NonNull UserProfile userProfile) {
            e.this.a(userProfile);
        }
    };

    private PagerSlidingTabStrip.c a(String str, String str2) {
        return new PagerSlidingTabStrip.c(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull UserProfile userProfile) {
        List<UserProfile.TabInfo> list;
        UserProfile.TabInfo tabInfo;
        Context o = o();
        if (o == null || (list = userProfile.tabList) == null || list.isEmpty() || (tabInfo = list.get(0)) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        PagerSlidingTabStrip.c a2 = a(String.valueOf(tabInfo.tabId), tabInfo.tabName);
        a2.a(o, 0, this.f32902c);
        Bundle bundle = new Bundle();
        ProfileTabVideoParam profileTabVideoParam = new ProfileTabVideoParam();
        profileTabVideoParam.mEntryScene = this.f32903d.mEntryScene;
        profileTabVideoParam.mURLPackage = ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f32867a.f32869b.getUrlPackage();
        ProfileHomeParam profileHomeParam = this.f32903d;
        profileTabVideoParam.mCurrentPhotoId = profileHomeParam.mCurrentPhotoId;
        profileTabVideoParam.mAuthorId = profileHomeParam.mAuthorId;
        profileTabVideoParam.mTabId = tabInfo.tabId;
        profileTabVideoParam.mTabName = tabInfo.tabName;
        bundle.putSerializable("KEY_PROFILE_TAB_VIDEO_PARAM", profileTabVideoParam);
        arrayList.add(new com.kwad.sdk.lib.widget.viewpager.tabstrip.b(a2, com.kwad.sdk.contentalliance.profile.tabvideo.c.class, bundle));
        this.f32901b.a(arrayList);
        a(tabInfo.tabName);
    }

    private void a(String str) {
        com.kwad.sdk.core.report.e.a(((com.kwad.sdk.contentalliance.profile.home.b.a) this).f32867a.f32869b, str);
    }

    @Override // com.kwad.sdk.contentalliance.profile.home.b.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.profile.home.b.b bVar = ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f32867a;
        this.f32901b = bVar.f32868a;
        this.f32902c = bVar.f32870c;
        this.f32903d = bVar.f32871d;
        bVar.f32873f.add(this.f32904e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f32867a.f32873f.remove(this.f32904e);
    }
}
