package com.kwad.sdk.contentalliance.profile.home.c;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.profile.home.model.UserProfile;
import com.kwad.sdk.utils.ao;
/* loaded from: classes7.dex */
public class f extends com.kwad.sdk.contentalliance.profile.home.b.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f35366b;

    /* renamed from: c  reason: collision with root package name */
    public View f35367c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f35368d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.profile.home.a.a f35369e;

    public f() {
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
        this.f35369e = new com.kwad.sdk.contentalliance.profile.home.a.a(this) { // from class: com.kwad.sdk.contentalliance.profile.home.c.f.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f35370a;

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
                this.f35370a = this;
            }

            @Override // com.kwad.sdk.contentalliance.profile.home.a.a
            public void a(@NonNull UserProfile userProfile) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, userProfile) == null) {
                    this.f35370a.f35368d.setText(userProfile.authorName);
                }
            }
        };
    }

    private void e() {
        Activity m;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && (m = m()) != null && com.kwad.sdk.utils.d.a(m)) {
            int a2 = ao.a(o());
            ViewGroup.LayoutParams layoutParams = this.f35366b.getLayoutParams();
            layoutParams.height += a2;
            this.f35366b.setLayoutParams(layoutParams);
            ViewGroup viewGroup = this.f35366b;
            viewGroup.setPadding(viewGroup.getPaddingLeft(), a2, this.f35366b.getPaddingRight(), this.f35366b.getPaddingBottom());
        }
    }

    @Override // com.kwad.sdk.contentalliance.profile.home.b.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.f35367c.setOnClickListener(this);
            e();
            ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f35326a.f35332f.add(this.f35369e);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f35326a.f35332f.remove(this.f35369e);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f35366b = (ViewGroup) b(R.id.ksad_profile_title_bar);
            this.f35367c = b(R.id.ksad_profile_left_back);
            this.f35368d = (TextView) b(R.id.ksad_profile_title);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity m;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && view == this.f35367c && (m = m()) != null) {
            m.finish();
        }
    }
}
