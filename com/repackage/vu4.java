package com.repackage;

import android.text.Editable;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupForegroundColorSpan;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class vu4 extends ru4<vu4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AtSelectData i;

    public vu4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static vu4 w(@NonNull vu4 vu4Var, @NonNull Editable editable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, vu4Var, editable)) == null) {
            vu4 vu4Var2 = new vu4();
            vu4Var2.b(vu4Var);
            vu4Var2.n(editable);
            return vu4Var2;
        }
        return (vu4) invokeLL.objValue;
    }

    @Override // com.repackage.ru4
    public void a(Editable editable, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048576, this, editable, i, i2, i3) == null) {
            super.a(editable, i, i2, i3);
        }
    }

    @Override // com.repackage.ru4
    public void p(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, editable) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("#(at, ");
            sb.append(this.i.getPortrait());
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(this.i.getNameShow());
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(this.i.getUid());
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            sb.append(" ");
            i(sb);
        }
    }

    @Override // com.repackage.ru4
    public void q(Editable editable, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, editable, i) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("#(at, ");
            sb.append(this.i.getPortrait());
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(this.i.getNameShow());
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            sb.append(" ");
            i(sb);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            o(true);
            s();
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            l(new SpanGroupForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0304)), f(), c(), 33);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ru4
    /* renamed from: t */
    public void b(vu4 vu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, vu4Var) == null) {
            super.b(vu4Var);
            this.i = vu4Var.i;
        }
    }

    public AtSelectData u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.i : (AtSelectData) invokeV.objValue;
    }

    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "@" + this.i.getNameShow() + " ";
        }
        return (String) invokeV.objValue;
    }

    public vu4(AtSelectData atSelectData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {atSelectData};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = atSelectData;
    }
}
