package com.kwad.sdk.contentalliance.tube.detail.b;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.tube.b;
import com.kwad.sdk.contentalliance.tube.model.TubeInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.utils.ag;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.contentalliance.tube.detail.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public TextView f35656b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f35657c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f35658d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f35659e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f35660f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f35661g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f35662h;

    /* renamed from: i  reason: collision with root package name */
    public b.a f35663i;

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
        this.f35663i = new b.a(this) { // from class: com.kwad.sdk.contentalliance.tube.detail.b.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f35664a;

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
                this.f35664a = this;
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
                if (interceptable2 == null || interceptable2.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, adResultData) == null) {
                    b bVar = this.f35664a;
                    bVar.a(((com.kwad.sdk.contentalliance.tube.detail.a.a) bVar).f35629a.f35631b.mTubeInfo);
                }
            }

            @Override // com.kwad.sdk.contentalliance.tube.b.a
            public void b(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048579, this, z) == null) {
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TubeInfo tubeInfo) {
        TextView textView;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, tubeInfo) == null) {
            if (tubeInfo == null) {
                tubeInfo = new TubeInfo();
            }
            String string = o().getString(R.string.ksad_text_placeholder);
            this.f35656b.setText(ag.a(tubeInfo.name, string));
            this.f35657c.setText(ag.a(tubeInfo.authorName, string));
            this.f35658d.setVisibility(0);
            this.f35662h.setVisibility(0);
            String str = "";
            if (tubeInfo.totalEpisodeCount >= 0) {
                str = "" + tubeInfo.totalEpisodeCount;
            }
            if (tubeInfo.isFinished) {
                String string2 = o().getString(R.string.ksad_tube_update_finished_format_text);
                textView = this.f35659e;
                format = String.format(string2, ag.a(str, string));
            } else {
                String string3 = o().getString(R.string.ksad_tube_update_unfinished_format_text);
                textView = this.f35659e;
                format = String.format(string3, ag.a(str, string));
            }
            textView.setText(format);
            this.f35660f.setText(ag.a(tubeInfo.summary, string));
            this.f35661g.setVisibility(0);
        }
    }

    @Override // com.kwad.sdk.contentalliance.tube.detail.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f35629a.f35633d.add(this.f35663i);
            com.kwad.sdk.core.d.a.a("TubeDetailHeaderPresenter", "TubeDetailHeaderPresenter onBind");
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f35629a.f35633d.remove(this.f35663i);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            com.kwad.sdk.core.d.a.a("TubeDetailHeaderPresenter", "TubeDetailHeaderPresenter onCreate");
            this.f35661g = (LinearLayout) b(R.id.ksad_tube_author_info_area);
            this.f35658d = (TextView) b(R.id.ksad_tube_author_name_label);
            this.f35656b = (TextView) b(R.id.ksad_tube_name);
            this.f35657c = (TextView) b(R.id.ksad_tube_author_name);
            this.f35659e = (TextView) b(R.id.ksad_tube_update_info);
            this.f35660f = (TextView) b(R.id.ksad_tube_description);
            this.f35662h = (ImageView) b(R.id.ksad_tube_divider_line);
        }
    }
}
