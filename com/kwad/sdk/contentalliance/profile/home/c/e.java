package com.kwad.sdk.contentalliance.profile.home.c;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.contentalliance.profile.home.ProfileHomeParam;
import com.kwad.sdk.contentalliance.profile.home.model.UserProfile;
import com.kwad.sdk.contentalliance.profile.tabvideo.ProfileTabVideoParam;
import com.kwad.sdk.lib.widget.viewpager.tabstrip.PagerSlidingTabStrip;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class e extends com.kwad.sdk.contentalliance.profile.home.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.profile.home.c f35361b;

    /* renamed from: c  reason: collision with root package name */
    public ViewPager f35362c;

    /* renamed from: d  reason: collision with root package name */
    public ProfileHomeParam f35363d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.profile.home.a.a f35364e;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35364e = new com.kwad.sdk.contentalliance.profile.home.a.a(this) { // from class: com.kwad.sdk.contentalliance.profile.home.c.e.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f35365a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f35365a = this;
            }

            @Override // com.kwad.sdk.contentalliance.profile.home.a.a
            public void a(@NonNull UserProfile userProfile) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, userProfile) == null) {
                    this.f35365a.a(userProfile);
                }
            }
        };
    }

    private PagerSlidingTabStrip.c a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, str, str2)) == null) ? new PagerSlidingTabStrip.c(str, str2) : (PagerSlidingTabStrip.c) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull UserProfile userProfile) {
        Context o;
        List<UserProfile.TabInfo> list;
        UserProfile.TabInfo tabInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, userProfile) == null) || (o = o()) == null || (list = userProfile.tabList) == null || list.isEmpty() || (tabInfo = list.get(0)) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        PagerSlidingTabStrip.c a2 = a(String.valueOf(tabInfo.tabId), tabInfo.tabName);
        a2.a(o, 0, this.f35362c);
        Bundle bundle = new Bundle();
        ProfileTabVideoParam profileTabVideoParam = new ProfileTabVideoParam();
        profileTabVideoParam.mEntryScene = this.f35363d.mEntryScene;
        profileTabVideoParam.mURLPackage = ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f35326a.f35328b.getUrlPackage();
        ProfileHomeParam profileHomeParam = this.f35363d;
        profileTabVideoParam.mCurrentPhotoId = profileHomeParam.mCurrentPhotoId;
        profileTabVideoParam.mAuthorId = profileHomeParam.mAuthorId;
        profileTabVideoParam.mTabId = tabInfo.tabId;
        profileTabVideoParam.mTabName = tabInfo.tabName;
        bundle.putSerializable("KEY_PROFILE_TAB_VIDEO_PARAM", profileTabVideoParam);
        arrayList.add(new com.kwad.sdk.lib.widget.viewpager.tabstrip.b(a2, com.kwad.sdk.contentalliance.profile.tabvideo.c.class, bundle));
        this.f35361b.a(arrayList);
        a(tabInfo.tabName);
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, this, str) == null) {
            com.kwad.sdk.core.report.e.a(((com.kwad.sdk.contentalliance.profile.home.b.a) this).f35326a.f35328b, str);
        }
    }

    @Override // com.kwad.sdk.contentalliance.profile.home.b.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.contentalliance.profile.home.b.b bVar = ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f35326a;
            this.f35361b = bVar.f35327a;
            this.f35362c = bVar.f35329c;
            this.f35363d = bVar.f35330d;
            bVar.f35332f.add(this.f35364e);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f35326a.f35332f.remove(this.f35364e);
        }
    }
}
