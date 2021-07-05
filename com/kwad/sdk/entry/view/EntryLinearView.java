package com.kwad.sdk.entry.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class EntryLinearView extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.b<AdTemplate> f37237c;

    /* renamed from: d  reason: collision with root package name */
    public EntryPhotoView f37238d;

    /* renamed from: e  reason: collision with root package name */
    public EntryPhotoView f37239e;

    /* renamed from: f  reason: collision with root package name */
    public List<AdTemplate> f37240f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f37241g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntryLinearView(Context context) {
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
        this.f37237c = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.f37241g = new View.OnClickListener(this) { // from class: com.kwad.sdk.entry.view.EntryLinearView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ EntryLinearView f37242a;

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
                this.f37242a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    this.f37242a.a(((EntryPhotoView) view).getTemplateData(), view == this.f37242a.f37239e ? 1 : 0, view, 1);
                }
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntryLinearView(Context context, @Nullable AttributeSet attributeSet) {
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
        this.f37237c = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.f37241g = new View.OnClickListener(this) { // from class: com.kwad.sdk.entry.view.EntryLinearView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ EntryLinearView f37242a;

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
                this.f37242a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    this.f37242a.a(((EntryPhotoView) view).getTemplateData(), view == this.f37242a.f37239e ? 1 : 0, view, 1);
                }
            }
        };
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            EntryPhotoView entryPhotoView = (EntryPhotoView) findViewById(R.id.ksad_entry2_photoleft);
            this.f37238d = entryPhotoView;
            entryPhotoView.setRatio(1.33f);
            this.f37238d.a(true, true);
            EntryPhotoView entryPhotoView2 = (EntryPhotoView) findViewById(R.id.ksad_entry2_photoright);
            this.f37239e = entryPhotoView2;
            entryPhotoView2.setRatio(1.33f);
            this.f37239e.a(true, true);
            this.f37239e.setOnClickListener(this.f37241g);
            this.f37238d.setOnClickListener(this.f37241g);
        }
    }

    @Override // com.kwad.sdk.entry.view.a
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.f37237c.clear();
            List<AdTemplate> list = ((a) this).f37302a.k;
            this.f37240f = list;
            for (AdTemplate adTemplate : list) {
                if (!adTemplate.needHide) {
                    this.f37237c.add(adTemplate);
                }
                if (this.f37237c.size() >= 2) {
                    break;
                }
            }
            if (this.f37237c.size() <= 1) {
                setVisibility(8);
                return false;
            }
            this.f37238d.a(0, ((a) this).f37302a.f36566e);
            this.f37238d.a(this.f37237c.get(0), ((a) this).f37302a);
            this.f37238d.setLikeViewPos(((a) this).f37302a.f36565d);
            this.f37238d.setAdShowStyle(1);
            this.f37239e.a(1, ((a) this).f37302a.f36566e);
            this.f37239e.a(this.f37237c.get(1), ((a) this).f37302a);
            this.f37239e.setLikeViewPos(((a) this).f37302a.f36565d);
            this.f37239e.setAdShowStyle(1);
            setVisibility(0);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.entry.view.a
    public List<AdTemplate> getRealShowData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f37237c : (List) invokeV.objValue;
    }

    @Override // com.kwad.sdk.entry.view.a, android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onFinishInflate();
            c();
        }
    }

    public void setRealShowItem(List<AdTemplate> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f37240f = list;
        }
    }
}
