package com.kwad.sdk.contentalliance.trends.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.TrendInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ao;
/* loaded from: classes7.dex */
public class TrendListItemView extends com.kwad.sdk.widget.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RoundAngleImageView f35534a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f35535b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f35536c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f35537d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f35538e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f35539f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f35540g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f35541h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f35542i;
    public TrendInfo j;
    public SceneImpl k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrendListItemView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new TrendInfo();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrendListItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = new TrendInfo();
    }

    @Override // com.kwad.sdk.widget.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            if (this.f35542i) {
                return;
            }
            SceneImpl sceneImpl = this.k;
            TrendInfo trendInfo = this.j;
            e.c(sceneImpl, trendInfo.trendId, trendInfo.name);
            this.f35542i = true;
        }
    }

    public void a(@NonNull TrendInfo trendInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, trendInfo, z) == null) {
            this.j = trendInfo;
            this.f35541h = z;
            setBackgroundColor(z ? 234881023 : 16777215);
            KSImageLoader.loadImage(this.f35534a, trendInfo.coverUrl, (AdTemplate) null, KSImageLoader.IMGOPTION_TREND);
            this.f35535b.setText(String.valueOf(trendInfo.rank));
            if (trendInfo.rank <= 3) {
                this.f35535b.setVisibility(8);
                this.f35539f.setVisibility(0);
                this.f35539f.setImageDrawable(ab.b(getContext(), String.format("ksad_trend_list_logo_%d", Integer.valueOf(trendInfo.rank))));
            } else {
                this.f35535b.setVisibility(0);
                this.f35539f.setVisibility(8);
                this.f35535b.setTextColor(-2130706433);
            }
            this.f35536c.setText(trendInfo.name);
            this.f35537d.setText(String.format(getContext().getString(R.string.ksad_trend_list_item_photo_count_format), Integer.valueOf(trendInfo.photoCount)));
            if (TextUtils.isEmpty(trendInfo.iconUrl)) {
                this.f35540g.setVisibility(8);
            } else {
                this.f35540g.setVisibility(0);
                KSImageLoader.loadImage(this.f35540g, trendInfo.iconUrl, null);
            }
            this.f35538e.setText(String.format(getContext().getString(R.string.ksad_photo_hot_enter_watch_count_format), ag.b(trendInfo.viewCount)));
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(R.id.ksad_photo_hot_list_item_photo);
            this.f35534a = roundAngleImageView;
            roundAngleImageView.setRadius(ao.a(getContext(), 4.0f));
            this.f35535b = (TextView) findViewById(R.id.ksad_photo_hot_list_item_index);
            this.f35536c = (TextView) findViewById(R.id.ksad_photo_hot_list_item_name);
            this.f35537d = (TextView) findViewById(R.id.ksad_photo_hot_enter_photo_count);
            this.f35538e = (TextView) findViewById(R.id.ksad_photo_hot_enter_watch_count);
            this.f35539f = (ImageView) findViewById(R.id.ksad_trend_list_logo);
            this.f35540g = (ImageView) findViewById(R.id.ksad_photo_hot_list_item_icon);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onFinishInflate();
            b();
        }
    }

    public void setAdScene(SceneImpl sceneImpl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, sceneImpl) == null) {
            this.k = sceneImpl;
        }
    }
}
