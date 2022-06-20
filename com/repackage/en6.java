package com.repackage;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewCommonUtil;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class en6 implements hn6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public en6() {
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

    @Override // com.repackage.hn6
    public void a(@NonNull View view2, @NonNull View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, onClickListener) == null) {
            ViewCommonUtil.setViewWidthHeight(view2.findViewById(R.id.obfuscated_res_0x7f090bb2), -3, UtilHelper.getDimenPixelSize(R.dimen.tbds117));
            TbTabLayout tbTabLayout = (TbTabLayout) view2.findViewById(R.id.obfuscated_res_0x7f090baf);
            tbTabLayout.setHorizontalFadingEdgeEnabled(true);
            tbTabLayout.setFadingEdgeLength(UtilHelper.getDimenPixelSize(R.dimen.tbds78));
            ViewCommonUtil.setViewMargin(tbTabLayout, -1, UtilHelper.getDimenPixelSize(R.dimen.M_H_X001), -1, -1);
            ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090b93);
            imageView.setVisibility(0);
            WebPManager.setPureDrawable(imageView, R.drawable.obfuscated_res_0x7f0805ed, R.color.CAM_X1107, null);
            imageView.setOnClickListener(onClickListener);
            imageView.setTag(R.id.obfuscated_res_0x7f09061c, LogicField.SEARCH_BTN);
        }
    }
}
