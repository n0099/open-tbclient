package com.dxmpay.wallet.base.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.utils.ResUtils;
/* loaded from: classes2.dex */
public class BorderTipTextView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f53756e;

    /* renamed from: f  reason: collision with root package name */
    public int f53757f;

    /* renamed from: g  reason: collision with root package name */
    public int f53758g;

    /* renamed from: h  reason: collision with root package name */
    public int f53759h;

    /* renamed from: i  reason: collision with root package name */
    public ColorStateList f53760i;

    /* renamed from: j  reason: collision with root package name */
    public Drawable f53761j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BorderTipTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f53756e = getPaddingLeft();
        this.f53757f = getPaddingRight();
        this.f53758g = getPaddingTop();
        this.f53759h = getPaddingBottom();
        this.f53760i = getTextColors();
        this.f53761j = getBackground();
    }

    public void setText(CharSequence charSequence, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, charSequence, z) == null) {
            if (z) {
                setBackgroundDrawable(ResUtils.getDrawable(getContext(), "dxm_wallet_base_tip_bg"));
                setTextColor(ResUtils.getColor(getContext(), "dxm_wallet_base_font_text6Color"));
                setText(charSequence);
                setPadding(6, 0, 6, 2);
                return;
            }
            setBackgroundDrawable(this.f53761j);
            setTextColor(this.f53760i);
            setText(charSequence);
            setPadding(this.f53756e, this.f53758g, this.f53757f, this.f53759h);
        }
    }
}
