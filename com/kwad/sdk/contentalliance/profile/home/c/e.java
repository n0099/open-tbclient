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
    public com.kwad.sdk.contentalliance.profile.home.c f33191b;

    /* renamed from: c  reason: collision with root package name */
    public ViewPager f33192c;

    /* renamed from: d  reason: collision with root package name */
    public ProfileHomeParam f33193d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.profile.home.a.a f33194e = new com.kwad.sdk.contentalliance.profile.home.a.a() { // from class: com.kwad.sdk.contentalliance.profile.home.c.e.1
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
        a2.a(o, 0, this.f33192c);
        Bundle bundle = new Bundle();
        ProfileTabVideoParam profileTabVideoParam = new ProfileTabVideoParam();
        profileTabVideoParam.mEntryScene = this.f33193d.mEntryScene;
        profileTabVideoParam.mURLPackage = ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f33157a.f33159b.getUrlPackage();
        ProfileHomeParam profileHomeParam = this.f33193d;
        profileTabVideoParam.mCurrentPhotoId = profileHomeParam.mCurrentPhotoId;
        profileTabVideoParam.mAuthorId = profileHomeParam.mAuthorId;
        profileTabVideoParam.mTabId = tabInfo.tabId;
        profileTabVideoParam.mTabName = tabInfo.tabName;
        bundle.putSerializable("KEY_PROFILE_TAB_VIDEO_PARAM", profileTabVideoParam);
        arrayList.add(new com.kwad.sdk.lib.widget.viewpager.tabstrip.b(a2, com.kwad.sdk.contentalliance.profile.tabvideo.c.class, bundle));
        this.f33191b.a(arrayList);
        a(tabInfo.tabName);
    }

    private void a(String str) {
        com.kwad.sdk.core.report.e.a(((com.kwad.sdk.contentalliance.profile.home.b.a) this).f33157a.f33159b, str);
    }

    @Override // com.kwad.sdk.contentalliance.profile.home.b.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.profile.home.b.b bVar = ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f33157a;
        this.f33191b = bVar.f33158a;
        this.f33192c = bVar.f33160c;
        this.f33193d = bVar.f33161d;
        bVar.f33163f.add(this.f33194e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f33157a.f33163f.remove(this.f33194e);
    }
}
