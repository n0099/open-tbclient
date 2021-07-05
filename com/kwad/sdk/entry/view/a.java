package com.kwad.sdk.entry.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsEntryElement;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ao;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class a extends com.kwad.sdk.widget.b implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.core.response.model.a f37302a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.widget.c f37303b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f37304c;

    /* renamed from: d  reason: collision with root package name */
    public KsEntryElement.OnFeedClickListener f37305d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, @Nullable AttributeSet attributeSet) {
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
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            int a2 = ao.a(getContext(), 5.0f);
            if (this.f37304c == null) {
                TextView textView = new TextView(getContext());
                this.f37304c = textView;
                textView.setTextSize(10.0f);
                this.f37304c.setTextColor(Color.parseColor("#9c9c9c"));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 3;
                layoutParams.topMargin = a2;
                layoutParams.rightMargin = getSourceRightMargin();
                this.f37304c.setLayoutParams(layoutParams);
                addView(this.f37304c);
            }
            if (this.f37303b == null) {
                com.kwad.sdk.widget.c cVar = new com.kwad.sdk.widget.c(getContext());
                this.f37303b = cVar;
                cVar.setGravity(16);
                this.f37303b.setTextSize(18.0f);
                this.f37303b.setTextColor(Color.parseColor("#323232"));
                this.f37303b.setCompoundDrawablePadding(ao.a(getContext(), 2.0f));
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.bottomMargin = ao.a(getContext(), 8.0f);
                this.f37303b.setLayoutParams(layoutParams2);
                this.f37303b.setMaxEms(15);
                this.f37303b.setMaxLines(1);
                Drawable drawable = getResources().getDrawable(R.drawable.ksad_entrytitle_arrow);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.f37303b.setCompoundDrawables(null, null, drawable, null);
                this.f37303b.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.entry.view.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f37306a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f37306a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            List<AdTemplate> realShowData = this.f37306a.getRealShowData();
                            if (realShowData.size() < 1) {
                                return;
                            }
                            int size = realShowData.size() - 1;
                            this.f37306a.a(realShowData.get(size), size, view, 2);
                        }
                    }
                });
                addView(this.f37303b, 0);
            }
        }
    }

    @Override // com.kwad.sdk.widget.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            e.a(this.f37302a);
        }
    }

    public void a(AdTemplate adTemplate, int i2, View view, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{adTemplate, Integer.valueOf(i2), view, Integer.valueOf(i3)}) == null) || this.f37305d == null) {
            return;
        }
        com.kwad.sdk.entry.model.a aVar = new com.kwad.sdk.entry.model.a(this.f37302a);
        aVar.a(adTemplate);
        com.kwad.sdk.entry.a.a(aVar);
        e.a(adTemplate, this.f37302a.f36566e, i3);
        this.f37305d.handleFeedClick(this.f37302a.f36562a, i2, view);
    }

    @Override // com.kwad.sdk.entry.view.c
    public boolean a(com.kwad.sdk.core.response.model.a aVar) {
        InterceptResult invokeL;
        LinearLayout.LayoutParams layoutParams;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) {
            this.f37302a = aVar;
            if (aVar == null) {
                removeAllViews();
                return false;
            }
            boolean b2 = b();
            String entrySourceDesc = getEntrySourceDesc();
            if (entrySourceDesc != null) {
                this.f37304c.setText(entrySourceDesc);
            } else {
                if (TextUtils.isEmpty(aVar.f36563b)) {
                    aVar.f36563b = "来自 快手推荐";
                }
                this.f37304c.setText(aVar.f36563b);
            }
            int entrySourcePos = getEntrySourcePos();
            if (entrySourcePos != 0) {
                if (entrySourcePos != 1) {
                    layoutParams = (LinearLayout.LayoutParams) this.f37304c.getLayoutParams();
                    i2 = 5;
                } else {
                    layoutParams = (LinearLayout.LayoutParams) this.f37304c.getLayoutParams();
                    i2 = 3;
                }
                layoutParams.gravity = i2;
                this.f37304c.setLayoutParams(layoutParams);
                this.f37304c.setVisibility(0);
            } else {
                this.f37304c.setVisibility(8);
            }
            if (getEntryTitlePos() != 1 || TextUtils.isEmpty(this.f37302a.f36567f)) {
                this.f37303b.setVisibility(8);
            } else {
                this.f37303b.setText(this.f37302a.f36567f);
                this.f37303b.setVisibility(0);
            }
            return b2;
        }
        return invokeL.booleanValue;
    }

    public abstract boolean b();

    public String getEntrySourceDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int getEntrySourcePos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f37302a.f36564c : invokeV.intValue;
    }

    public int getEntryTitlePos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f37302a.f36568g : invokeV.intValue;
    }

    @NonNull
    public abstract List<AdTemplate> getRealShowData();

    public int getSourceRightMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onFinishInflate();
            c();
        }
    }

    @Override // com.kwad.sdk.entry.view.c
    public void setOnfeedClickListener(KsEntryElement.OnFeedClickListener onFeedClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onFeedClickListener) == null) {
            this.f37305d = onFeedClickListener;
        }
    }
}
