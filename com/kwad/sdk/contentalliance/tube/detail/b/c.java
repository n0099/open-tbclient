package com.kwad.sdk.contentalliance.tube.detail.b;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.tube.b;
import com.kwad.sdk.contentalliance.tube.view.WarpLinearLayout;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.utils.ao;
import java.util.List;
/* loaded from: classes7.dex */
public class c extends com.kwad.sdk.contentalliance.tube.detail.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public WarpLinearLayout f35665b;

    /* renamed from: c  reason: collision with root package name */
    public b.a f35666c;

    public c() {
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
        this.f35666c = new b.a(this) { // from class: com.kwad.sdk.contentalliance.tube.detail.b.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f35667a;

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
                this.f35667a = this;
            }

            @Override // com.kwad.sdk.contentalliance.tube.b.a
            public void a(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                }
            }

            @Override // com.kwad.sdk.contentalliance.tube.b.a
            public void a(boolean z, int i4, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i4), str}) == null) {
                }
            }

            @Override // com.kwad.sdk.contentalliance.tube.b.a
            public void a(boolean z, @NonNull AdResultData adResultData) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, adResultData) == null) || ((com.kwad.sdk.contentalliance.tube.detail.a.a) this.f35667a).f35629a.f35631b.mTubeInfo == null) {
                    return;
                }
                c cVar = this.f35667a;
                cVar.a(((com.kwad.sdk.contentalliance.tube.detail.a.a) cVar).f35629a.f35631b.mTubeInfo.tagList);
            }

            @Override // com.kwad.sdk.contentalliance.tube.b.a
            public void b(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048579, this, z) == null) {
                }
            }
        };
    }

    private View a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            TextView textView = new TextView(o());
            textView.setText(str);
            textView.setPadding(ao.a(o(), 8.0f), ao.a(o(), 2.0f), ao.a(o(), ao.a(o(), 2.0f)), ao.a(o(), 2.0f));
            textView.setTextSize(12.0f);
            textView.setBackground(o().getResources().getDrawable(R.drawable.ksad_tube_detail_tag_bg));
            textView.setTextColor(o().getResources().getColor(R.color.ksad_tube_detail_description_text));
            return textView;
        }
        return (View) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<String> list) {
        WarpLinearLayout warpLinearLayout;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, this, list) == null) {
            this.f35665b.removeAllViews();
            if (list == null || list.isEmpty()) {
                warpLinearLayout = this.f35665b;
                i2 = 8;
            } else {
                for (String str : list) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.rightMargin = ao.a(o(), 8.0f);
                    this.f35665b.addView(a(str), layoutParams);
                }
                warpLinearLayout = this.f35665b;
                i2 = 0;
            }
            warpLinearLayout.setVisibility(i2);
        }
    }

    @Override // com.kwad.sdk.contentalliance.tube.detail.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f35629a.f35633d.add(this.f35666c);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f35629a.f35633d.remove(this.f35666c);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            com.kwad.sdk.core.d.a.a("TubeHeaderTagListPresenter", "TubeHeaderTagListPresenter onCreate");
            this.f35665b = (WarpLinearLayout) b(R.id.ksad_tube_tag_list_container);
        }
    }
}
