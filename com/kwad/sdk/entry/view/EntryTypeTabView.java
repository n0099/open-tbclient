package com.kwad.sdk.entry.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.view.g;
import com.kwad.sdk.glide.request.e;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.widget.RadiusPvFrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class EntryTypeTabView extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public TextView f37279c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f37280d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f37281e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f37282f;

    /* renamed from: g  reason: collision with root package name */
    public PhotoInfo f37283g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.b<AdTemplate> f37284h;

    /* renamed from: i  reason: collision with root package name */
    public RadiusPvFrameLayout f37285i;
    public volatile boolean j;
    public g k;
    public g.a l;
    public boolean m;
    public View.OnClickListener n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntryTypeTabView(Context context) {
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
        this.f37284h = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.j = false;
        this.l = new g.a(this) { // from class: com.kwad.sdk.entry.view.EntryTypeTabView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ EntryTypeTabView f37286a;

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
                this.f37286a = this;
            }

            @Override // com.kwad.sdk.core.view.g.a
            public void a(boolean z) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) && z && !this.f37286a.j) {
                    this.f37286a.j = true;
                    if (this.f37286a.k != null) {
                        this.f37286a.k.c();
                    }
                    this.f37286a.g();
                }
            }
        };
        this.n = new View.OnClickListener(this) { // from class: com.kwad.sdk.entry.view.EntryTypeTabView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ EntryTypeTabView f37287a;

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
                this.f37287a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    int i4 = this.f37287a.f37279c == view ? 2 : 1;
                    EntryTypeTabView entryTypeTabView = this.f37287a;
                    entryTypeTabView.a(entryTypeTabView.f37282f, 0, this.f37287a.f37280d, i4);
                }
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntryTypeTabView(Context context, @Nullable AttributeSet attributeSet) {
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
        this.f37284h = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.j = false;
        this.l = new g.a(this) { // from class: com.kwad.sdk.entry.view.EntryTypeTabView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ EntryTypeTabView f37286a;

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
                this.f37286a = this;
            }

            @Override // com.kwad.sdk.core.view.g.a
            public void a(boolean z) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) && z && !this.f37286a.j) {
                    this.f37286a.j = true;
                    if (this.f37286a.k != null) {
                        this.f37286a.k.c();
                    }
                    this.f37286a.g();
                }
            }
        };
        this.n = new View.OnClickListener(this) { // from class: com.kwad.sdk.entry.view.EntryTypeTabView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ EntryTypeTabView f37287a;

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
                this.f37287a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    int i4 = this.f37287a.f37279c == view ? 2 : 1;
                    EntryTypeTabView entryTypeTabView = this.f37287a;
                    entryTypeTabView.a(entryTypeTabView.f37282f, 0, this.f37287a.f37280d, i4);
                }
            }
        };
    }

    private void a(@NonNull ImageView imageView, int i2, int i3) {
        ImageView.ScaleType scaleType;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, this, imageView, i2, i3) == null) {
            ViewGroup.LayoutParams layoutParams = this.f37285i.getLayoutParams();
            Context context = getContext();
            if (i3 >= i2) {
                layoutParams.width = ao.a(context, 247.0f);
                layoutParams.height = ao.a(getContext(), 330.0f);
                this.f37285i.setRatio(1.3333334f);
                if (i3 * 3 < i2 * 4) {
                    scaleType = ImageView.ScaleType.CENTER_INSIDE;
                }
                scaleType = ImageView.ScaleType.CENTER_CROP;
            } else {
                int c2 = ao.c(context) - ao.a(getContext(), 32.0f);
                layoutParams.width = c2;
                layoutParams.height = (int) ((c2 * 16.0f) / 9.0f);
                this.f37285i.setRatio(0.5625f);
                if (i3 * 16 > i2 * 9) {
                    scaleType = ImageView.ScaleType.FIT_CENTER;
                }
                scaleType = ImageView.ScaleType.CENTER_CROP;
            }
            imageView.setScaleType(scaleType);
            this.f37285i.setLayoutParams(layoutParams);
            com.kwad.sdk.core.d.a.a("EntryType5View", "w*h=" + layoutParams.width + " * " + layoutParams.height);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            a(this.f37282f, 0, this.f37280d, 3);
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.f37279c = (TextView) findViewById(R.id.ksad_entryitem5_title);
            this.f37280d = (ImageView) findViewById(R.id.ksad_entryitem5_thumb);
            this.f37281e = (TextView) findViewById(R.id.ksad_entryitem5_like_count);
            RadiusPvFrameLayout radiusPvFrameLayout = (RadiusPvFrameLayout) findViewById(R.id.ksad_entryitem5_container);
            this.f37285i = radiusPvFrameLayout;
            radiusPvFrameLayout.setRadius(ao.a(getContext(), 4.0f));
            this.f37285i.setOnClickListener(this.n);
            this.f37279c.setOnClickListener(this.n);
            c();
        }
    }

    private boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) ? this.m && com.ksad.download.d.b.b(getContext()) : invokeV.booleanValue;
    }

    private void j() {
        TextView textView;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            String str = this.f37283g.baseInfo.videoDesc;
            if (TextUtils.isEmpty(str)) {
                textView = this.f37279c;
                i2 = 8;
            } else {
                this.f37279c.setText(str);
                textView = this.f37279c;
                i2 = 0;
            }
            textView.setVisibility(i2);
        }
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            com.kwad.sdk.core.response.model.c E = d.E(this.f37283g);
            String a2 = E.a();
            a(this.f37280d, E.c(), E.b());
            com.kwad.sdk.glide.c.b(getContext()).a(a2).a(getContext().getResources().getDrawable(R.drawable.ksad_loading_entry)).c(getContext().getResources().getDrawable(R.drawable.ksad_loading_entry)).a((e) new com.kwad.sdk.c(a2, this.f37282f)).a(this.f37280d);
        }
    }

    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            this.f37281e.setText(String.format(getContext().getString(R.string.ksad_entry_tab_like_format), ag.a(d.m(this.f37283g), "0")));
        }
    }

    @Override // com.kwad.sdk.entry.view.a, com.kwad.sdk.widget.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.core.report.e.b(this.f37282f, ((a) this).f37302a.f36566e);
        }
    }

    @Override // com.kwad.sdk.entry.view.a
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.f37284h.clear();
            Iterator<AdTemplate> it = ((a) this).f37302a.k.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AdTemplate next = it.next();
                if (!next.needHide) {
                    this.f37284h.add(next);
                    break;
                }
            }
            if (this.f37284h.size() > 0) {
                AdTemplate adTemplate = this.f37284h.get(0);
                this.f37282f = adTemplate;
                this.f37283g = adTemplate.photoInfo;
            } else {
                this.f37282f = null;
            }
            if (this.f37282f == null) {
                return false;
            }
            j();
            l();
            k();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && i() && this.k == null) {
            g gVar = new g(this.f37280d, 60);
            this.k = gVar;
            gVar.a(this.l);
            this.k.a();
        }
    }

    @Override // com.kwad.sdk.entry.view.a
    public int getEntrySourcePos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.kwad.sdk.entry.view.a
    @NonNull
    public List<AdTemplate> getRealShowData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f37284h : (List) invokeV.objValue;
    }

    @Override // com.kwad.sdk.widget.b, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDetachedFromWindow();
            g gVar = this.k;
            if (gVar != null) {
                gVar.c();
            }
        }
    }

    @Override // com.kwad.sdk.entry.view.a, android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onFinishInflate();
            h();
        }
    }

    public void setEnableSlideAutoOpen(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.m = z;
            c();
        }
    }
}
