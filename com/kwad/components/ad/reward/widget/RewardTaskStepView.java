package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.i.c;
import com.kwad.sdk.widget.DividerView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class RewardTaskStepView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String no;
    public List<c> wG;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RewardTaskStepView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.wG = new ArrayList();
        je();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RewardTaskStepView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.wG = new ArrayList();
        je();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RewardTaskStepView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.wG = new ArrayList();
        je();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @RequiresApi(api = 21)
    public RewardTaskStepView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.wG = new ArrayList();
        je();
    }

    private void a(int i, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Integer.valueOf(i), str, str2, Boolean.valueOf(z)}) == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(z ? R.layout.obfuscated_res_0x7f0d046d : R.layout.obfuscated_res_0x7f0d046e, (ViewGroup) this, false);
            if (z) {
                a(viewGroup, str);
            } else {
                a(viewGroup, i, str2);
            }
            addView(viewGroup);
        }
    }

    private void a(ViewGroup viewGroup, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65541, this, viewGroup, i, str) == null) {
            ((TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0911fc)).setText(String.format(str, this.no));
            ((TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0911fb)).setText(String.valueOf(i));
        }
    }

    public static void a(ViewGroup viewGroup, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, viewGroup, str) == null) {
            ((TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0911fc)).setText(str);
        }
    }

    private void ac(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65543, this, z) == null) {
            DividerView dividerView = (DividerView) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d046b, (ViewGroup) this, false);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703a8);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703a6);
            dividerView.setDividerColor(getResources().getColor(z ? R.color.obfuscated_res_0x7f060784 : R.color.obfuscated_res_0x7f060786));
            addView(dividerView, dimensionPixelSize, dimensionPixelSize2);
        }
    }

    private void je() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            setOrientation(1);
        }
    }

    private void jf() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            int size = this.wG.size();
            int i = 0;
            while (i < size) {
                c cVar = this.wG.get(i);
                int i2 = i + 1;
                a(i2, cVar.iv(), cVar.iw(), cVar.isCompleted());
                if (i < size - 1) {
                    ac(this.wG.get(i2).isCompleted());
                }
                i = i2;
            }
        }
    }

    public final void a(List<c> list, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, list, str) == null) || list == null || list.isEmpty()) {
            return;
        }
        this.no = str;
        this.wG.clear();
        this.wG.addAll(list);
        jf();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            super.onDraw(canvas);
        }
    }
}
