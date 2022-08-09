package com.repackage;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class hl7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NoNetworkView a;
    public NavigationBar b;
    public BdListView c;
    public View d;
    public fl7 e;
    public View f;
    public TbImageView g;
    public TextView h;
    public MemberTaskCenterActivity i;

    public hl7(MemberTaskCenterActivity memberTaskCenterActivity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {memberTaskCenterActivity, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = memberTaskCenterActivity;
        memberTaskCenterActivity.setContentView(R.layout.obfuscated_res_0x7f0d0569);
        this.d = memberTaskCenterActivity.findViewById(R.id.obfuscated_res_0x7f091c31);
        this.a = (NoNetworkView) memberTaskCenterActivity.findViewById(R.id.obfuscated_res_0x7f09255d);
        NavigationBar navigationBar = (NavigationBar) memberTaskCenterActivity.findViewById(R.id.obfuscated_res_0x7f09255b);
        this.b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.b.setTitleText(R.string.obfuscated_res_0x7f0f0ac2);
        this.c = (BdListView) memberTaskCenterActivity.findViewById(R.id.obfuscated_res_0x7f0914d7);
        this.f = LayoutInflater.from(memberTaskCenterActivity.getActivity()).inflate(R.layout.obfuscated_res_0x7f0d056a, (ViewGroup) null);
        BdListViewHelper.d(memberTaskCenterActivity.getActivity(), this.c, BdListViewHelper.HeadType.DEFAULT);
        TbImageView tbImageView = (TbImageView) this.f.findViewById(R.id.obfuscated_res_0x7f09014a);
        this.g = tbImageView;
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.h = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f090730);
        this.g.setOnClickListener(onClickListener);
        fl7 fl7Var = new fl7(memberTaskCenterActivity);
        this.e = fl7Var;
        fl7Var.d(onClickListener);
        this.c.addHeaderView(this.f);
        this.c.setAdapter((ListAdapter) this.e);
    }

    public final SpannableString a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            SpannableString spannableString = new SpannableString(str + str2);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)), 0, str.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301)), str.length(), spannableString.length(), 33);
            return spannableString;
        }
        return (SpannableString) invokeLL.objValue;
    }

    public BdListView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : (BdListView) invokeV.objValue;
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : (View) invokeV.objValue;
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.b.onChangeSkinType(this.i.getPageContext(), i);
            this.a.d(this.i.getPageContext(), i);
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0205);
        }
    }

    public void e(String str, List<cl7> list, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, list, Long.valueOf(j)}) == null) {
            this.g.K(str, 10, false);
            this.h.setText(a(this.i.getResources().getString(R.string.obfuscated_res_0x7f0f047f), String.valueOf(j)));
            this.e.c(list);
            this.e.notifyDataSetChanged();
        }
    }
}
