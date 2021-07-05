package com.kwad.sdk.entry.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ai;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class EntryTyp4View extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public TextView f37271c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f37272d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f37273e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f37274f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f37275g;

    /* renamed from: h  reason: collision with root package name */
    public PhotoInfo f37276h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.b<AdTemplate> f37277i;
    public View.OnClickListener j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntryTyp4View(Context context) {
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
        this.f37277i = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.j = new View.OnClickListener(this) { // from class: com.kwad.sdk.entry.view.EntryTyp4View.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ EntryTyp4View f37278a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f37278a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    EntryTyp4View entryTyp4View = this.f37278a;
                    entryTyp4View.a(entryTyp4View.f37275g, 0, view, 1);
                }
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntryTyp4View(Context context, @Nullable AttributeSet attributeSet) {
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
        this.f37277i = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.j = new View.OnClickListener(this) { // from class: com.kwad.sdk.entry.view.EntryTyp4View.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ EntryTyp4View f37278a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f37278a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    EntryTyp4View entryTyp4View = this.f37278a;
                    entryTyp4View.a(entryTyp4View.f37275g, 0, view, 1);
                }
            }
        };
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.f37271c = (TextView) findViewById(R.id.ksad_entryitem4_title);
            this.f37272d = (ImageView) findViewById(R.id.ksad_entryitem4_background);
            this.f37273e = (ImageView) findViewById(R.id.ksad_entryitem4_thumb);
            this.f37274f = (TextView) findViewById(R.id.ksad_entryitem4_duration);
            RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.ksad_entryitem4_container);
            ratioFrameLayout.setRatio(0.56f);
            ratioFrameLayout.setOnClickListener(this.j);
            this.f37271c.setOnClickListener(this.j);
        }
    }

    private boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, this)) == null) {
            com.kwad.sdk.core.response.model.c E = d.E(this.f37276h);
            return E.b() * 16 > E.c() * 9;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.entry.view.a, com.kwad.sdk.widget.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            e.b(this.f37275g, ((a) this).f37302a.f36566e);
        }
    }

    @Override // com.kwad.sdk.entry.view.a
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.f37277i.clear();
            Iterator<AdTemplate> it = ((a) this).f37302a.k.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AdTemplate next = it.next();
                if (!next.needHide && !com.kwad.sdk.core.response.b.c.c(next)) {
                    this.f37277i.add(next);
                    break;
                }
            }
            if (this.f37277i.size() > 0) {
                AdTemplate adTemplate = this.f37277i.get(0);
                this.f37275g = adTemplate;
                this.f37276h = adTemplate.photoInfo;
            } else {
                this.f37275g = null;
            }
            if (this.f37275g == null) {
                return false;
            }
            if (((a) this).f37302a.f36569h != 1 || TextUtils.isEmpty(this.f37276h.baseInfo.videoDesc)) {
                this.f37271c.setVisibility(8);
            } else {
                this.f37271c.setText(this.f37276h.baseInfo.videoDesc);
                this.f37271c.setVisibility(0);
            }
            String a2 = ai.a(this.f37276h.videoInfo.duration);
            if (((a) this).f37302a.f36569h == 1) {
                this.f37274f.setText(a2);
                this.f37274f.setVisibility(0);
            } else {
                this.f37274f.setVisibility(8);
            }
            if (g()) {
                this.f37273e.setScaleType(ImageView.ScaleType.FIT_CENTER);
                this.f37272d.setVisibility(0);
                String h2 = d.h(this.f37276h);
                com.kwad.sdk.glide.c.b(this.f37272d.getContext()).a(h2).a(getContext().getResources().getDrawable(R.drawable.ksad_entry_blur_def_bg)).b(getContext().getResources().getDrawable(R.drawable.ksad_entry_blur_def_bg)).c(getContext().getResources().getDrawable(R.drawable.ksad_entry_blur_def_bg)).a((com.kwad.sdk.glide.request.e) new com.kwad.sdk.c(h2, this.f37275g)).a(this.f37272d);
                com.kwad.sdk.core.d.a.a("EntryTyp4View", "blurBackgroundUrl=" + h2 + " blurCoverUrl=" + this.f37276h.coverInfo.blurCoverUrl);
            } else {
                this.f37273e.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.f37272d.setVisibility(8);
            }
            String a3 = d.E(this.f37276h).a();
            com.kwad.sdk.glide.c.b(this.f37273e.getContext()).a(a3).a(getContext().getResources().getDrawable(R.drawable.ksad_loading_entry)).b(getContext().getResources().getDrawable(R.drawable.ksad_loading_entry)).c(getContext().getResources().getDrawable(R.drawable.ksad_loading_entry)).a((com.kwad.sdk.glide.request.e) new com.kwad.sdk.c(a3, this.f37275g)).a(this.f37273e);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.entry.view.a
    public String getEntrySourceDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (TextUtils.isEmpty(((a) this).f37302a.f36563b)) {
                ((a) this).f37302a.f36563b = "快手推荐";
            }
            StringBuilder sb = new StringBuilder();
            com.kwad.sdk.core.response.model.a aVar = ((a) this).f37302a;
            if (aVar.f36564c != 0) {
                sb.append(aVar.f36563b);
                sb.append("   ");
            }
            if (((a) this).f37302a.j != 0) {
                sb.append(ag.a(this.f37276h.baseInfo.commentCount, "0"));
                sb.append(" 评论");
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.entry.view.a
    public int getEntrySourcePos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int entrySourcePos = super.getEntrySourcePos();
            return entrySourcePos == 0 ? ((a) this).f37302a.j : entrySourcePos;
        }
        return invokeV.intValue;
    }

    @Override // com.kwad.sdk.entry.view.a
    public List<AdTemplate> getRealShowData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f37277i : (List) invokeV.objValue;
    }

    @Override // com.kwad.sdk.entry.view.a, android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onFinishInflate();
            c();
        }
    }
}
