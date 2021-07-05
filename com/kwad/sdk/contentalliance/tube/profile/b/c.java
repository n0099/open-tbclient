package com.kwad.sdk.contentalliance.tube.profile.b;

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
import com.kwad.sdk.contentalliance.tube.model.TubeInfo;
import com.kwad.sdk.contentalliance.tube.model.TubeProfileResultData;
import com.kwad.sdk.contentalliance.tube.profile.TubeProfileParam;
import com.kwad.sdk.utils.ag;
/* loaded from: classes7.dex */
public class c extends com.kwad.sdk.contentalliance.tube.profile.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f35731b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f35732c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f35733d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f35734e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f35735f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f35736g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f35737h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.tube.profile.e f35738i;

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
        this.f35738i = new com.kwad.sdk.contentalliance.tube.profile.e(this) { // from class: com.kwad.sdk.contentalliance.tube.profile.b.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f35739a;

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
                this.f35739a = this;
            }

            @Override // com.kwad.sdk.contentalliance.tube.profile.e
            public void a(@NonNull TubeProfileResultData tubeProfileResultData) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, tubeProfileResultData) == null) {
                    this.f35739a.a(tubeProfileResultData.tubeProfile.tubeInfo);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull TubeInfo tubeInfo) {
        TextView textView;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, tubeInfo) == null) {
            String string = o().getString(R.string.ksad_text_placeholder);
            this.f35732c.setText(ag.a(tubeInfo.name, string));
            this.f35733d.setText(ag.a(tubeInfo.authorName, string));
            this.f35734e.setVisibility(0);
            this.f35737h.setVisibility(0);
            int i2 = tubeInfo.totalEpisodeCount;
            String valueOf = i2 < 0 ? "" : String.valueOf(i2);
            if (tubeInfo.isFinished) {
                String string2 = o().getString(R.string.ksad_tube_update_finished_format_text);
                textView = this.f35735f;
                format = String.format(string2, ag.a(valueOf, string));
            } else {
                String string3 = o().getString(R.string.ksad_tube_update_unfinished_format_text);
                textView = this.f35735f;
                format = String.format(string3, ag.a(valueOf, string));
            }
            textView.setText(format);
            this.f35736g.setText(ag.a(tubeInfo.summary, string));
            this.f35731b.setVisibility(0);
        }
    }

    @Override // com.kwad.sdk.contentalliance.tube.profile.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.core.d.a.a("TubeProfileHeaderPresenter", "TubeProfileHeaderPresenter onBind");
            ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f35705a.f35710e.add(this.f35738i);
            TubeProfileParam tubeProfileParam = ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f35705a.f35708c;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f35705a.f35710e.remove(this.f35738i);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            com.kwad.sdk.core.d.a.a("TubeProfileHeaderPresenter", "TubeProfileHeaderPresenter onCreate");
            this.f35731b = (LinearLayout) b(R.id.ksad_tube_author_info_area);
            this.f35732c = (TextView) b(R.id.ksad_tube_name);
            this.f35733d = (TextView) b(R.id.ksad_tube_author_name);
            this.f35734e = (TextView) b(R.id.ksad_tube_author_name_label);
            this.f35735f = (TextView) b(R.id.ksad_tube_update_info);
            this.f35736g = (TextView) b(R.id.ksad_tube_description);
            this.f35737h = (ImageView) b(R.id.ksad_tube_divider_line);
        }
    }
}
