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
/* loaded from: classes4.dex */
public class e extends com.kwad.sdk.contentalliance.profile.home.b.a {

    /* renamed from: b  reason: collision with root package name */
    private com.kwad.sdk.contentalliance.profile.home.c f8791b;
    private ViewPager c;
    private ProfileHomeParam d;
    private com.kwad.sdk.contentalliance.profile.home.a.a e = new com.kwad.sdk.contentalliance.profile.home.a.a() { // from class: com.kwad.sdk.contentalliance.profile.home.c.e.1
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
        a2.a(o, 0, this.c);
        Bundle bundle = new Bundle();
        ProfileTabVideoParam profileTabVideoParam = new ProfileTabVideoParam();
        profileTabVideoParam.mEntryScene = this.d.mEntryScene;
        profileTabVideoParam.mURLPackage = this.f8778a.f8780b.getUrlPackage();
        profileTabVideoParam.mCurrentPhotoId = this.d.mCurrentPhotoId;
        profileTabVideoParam.mAuthorId = this.d.mAuthorId;
        profileTabVideoParam.mTabId = tabInfo.tabId;
        profileTabVideoParam.mTabName = tabInfo.tabName;
        bundle.putSerializable("KEY_PROFILE_TAB_VIDEO_PARAM", profileTabVideoParam);
        arrayList.add(new com.kwad.sdk.lib.widget.viewpager.tabstrip.b(a2, com.kwad.sdk.contentalliance.profile.tabvideo.c.class, bundle));
        this.f8791b.a(arrayList);
        a(tabInfo.tabName);
    }

    private void a(String str) {
        com.kwad.sdk.core.report.e.a(this.f8778a.f8780b, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.profile.home.b.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f8791b = this.f8778a.f8779a;
        this.c = this.f8778a.c;
        this.d = this.f8778a.d;
        this.f8778a.f.add(this.e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f8778a.f.remove(this.e);
    }
}
