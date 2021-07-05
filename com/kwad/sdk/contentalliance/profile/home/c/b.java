package com.kwad.sdk.contentalliance.profile.home.c;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.profile.home.model.UserProfile;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.utils.ag;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.contentalliance.profile.home.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f35342b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f35343c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f35344d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f35345e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.profile.home.a.a f35346f;

    public b() {
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
        this.f35346f = new com.kwad.sdk.contentalliance.profile.home.a.a(this) { // from class: com.kwad.sdk.contentalliance.profile.home.c.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f35347a;

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
                this.f35347a = this;
            }

            @Override // com.kwad.sdk.contentalliance.profile.home.a.a
            public void a(@NonNull UserProfile userProfile) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, userProfile) == null) {
                    this.f35347a.a(userProfile);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull UserProfile userProfile) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, userProfile) == null) {
            this.f35344d.setText(ag.b(userProfile.ownerCount.fansCount));
            this.f35345e.setText(ag.b(userProfile.ownerCount.followCount));
            this.f35343c.setText(TextUtils.isEmpty(userProfile.authorName) ? "-" : userProfile.authorName);
        }
    }

    @Override // com.kwad.sdk.contentalliance.profile.home.b.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f35326a.f35332f.add(this.f35346f);
            KSImageLoader.loadCircleIcon(this.f35342b, ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f35326a.f35330d.mAuthorIcon, o().getResources().getDrawable(R.drawable.ksad_profile_author_icon));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f35326a.f35332f.remove(this.f35346f);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f35342b = (ImageView) b(R.id.ksad_profile_author_icon);
            this.f35343c = (TextView) b(R.id.ksad_profile_author_name);
            this.f35344d = (TextView) b(R.id.ksad_profile_fans_count);
            this.f35345e = (TextView) b(R.id.ksad_profile_follow_count);
        }
    }
}
