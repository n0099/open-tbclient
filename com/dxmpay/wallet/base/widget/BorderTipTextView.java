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
/* loaded from: classes9.dex */
public class BorderTipTextView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f69201e;

    /* renamed from: f  reason: collision with root package name */
    public int f69202f;

    /* renamed from: g  reason: collision with root package name */
    public int f69203g;

    /* renamed from: h  reason: collision with root package name */
    public int f69204h;

    /* renamed from: i  reason: collision with root package name */
    public ColorStateList f69205i;

    /* renamed from: j  reason: collision with root package name */
    public Drawable f69206j;

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
        this.f69201e = getPaddingLeft();
        this.f69202f = getPaddingRight();
        this.f69203g = getPaddingTop();
        this.f69204h = getPaddingBottom();
        this.f69205i = getTextColors();
        this.f69206j = getBackground();
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
            setBackgroundDrawable(this.f69206j);
            setTextColor(this.f69205i);
            setText(charSequence);
            setPadding(this.f69201e, this.f69203g, this.f69202f, this.f69204h);
        }
    }
}
