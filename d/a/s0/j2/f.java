package d.a.s0.j2;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.dialog.RoundLinearLayout;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class f extends d.a.c.a.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RoundLinearLayout f62355a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f62356b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f62357c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f62358d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f62359e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f62360f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f62361g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f62362h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f62363i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.c.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62360f = tbPageContext;
        l(tbPageContext, onClickListener);
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f62358d : (View) invokeV.objValue;
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f62356b : (View) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f62359e : (View) invokeV.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f62363i : (View) invokeV.objValue;
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f62357c : (View) invokeV.objValue;
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f62355a : (View) invokeV.objValue;
    }

    public final void l(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, tbPageContext, onClickListener) == null) {
            RoundLinearLayout roundLinearLayout = (RoundLinearLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
            this.f62355a = roundLinearLayout;
            roundLinearLayout.setRadius(TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds31));
            TextView textView = (TextView) this.f62355a.findViewById(R.id.person_info_more_view_item_friend);
            this.f62356b = textView;
            textView.setOnClickListener(onClickListener);
            TextView textView2 = (TextView) this.f62355a.findViewById(R.id.person_info_more_view_item_report);
            this.f62357c = textView2;
            textView2.setOnClickListener(onClickListener);
            TextView textView3 = (TextView) this.f62355a.findViewById(R.id.person_info_more_view_item_black);
            this.f62358d = textView3;
            textView3.setOnClickListener(onClickListener);
            TextView textView4 = (TextView) this.f62355a.findViewById(R.id.person_info_more_view_item_mute);
            this.f62359e = textView4;
            textView4.setOnClickListener(onClickListener);
            TextView textView5 = (TextView) this.f62355a.findViewById(R.id.person_info_more_view_item_cancel);
            this.f62361g = textView5;
            textView5.setOnClickListener(onClickListener);
            this.f62362h = (TextView) this.f62355a.findViewById(R.id.person_info_more_view_item_username);
            TextView textView6 = (TextView) this.f62355a.findViewById(R.id.person_info_item_remove_fans_view);
            this.f62363i = textView6;
            textView6.setOnClickListener(onClickListener);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            SkinManager.setBackgroundResource(this.f62355a, R.color.CAM_X0211);
            SkinManager.setViewTextColorSelector(this.f62358d, R.color.CAM_X0105);
            SkinManager.setViewTextColorSelector(this.f62356b, R.color.CAM_X0105);
            SkinManager.setViewTextColorSelector(this.f62357c, R.color.CAM_X0105);
            SkinManager.setViewTextColorSelector(this.f62359e, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f62362h, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColorSelector(this.f62363i, R.color.CAM_X0105);
            SkinManager.setViewTextColorSelector(this.f62361g, R.color.CAM_X0107);
        }
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f62359e.setVisibility(0);
            if (i2 == 0) {
                this.f62359e.setText(this.f62360f.getResources().getString(R.string.mute));
            } else if (i2 == 1) {
                this.f62359e.setText(this.f62360f.getResources().getString(R.string.un_mute));
            }
        }
    }

    public void o(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (z) {
                this.f62356b.setText(R.string.remove_friend);
            } else {
                this.f62356b.setText(R.string.frs_recommend_friend_item_add);
            }
            if (z2) {
                this.f62358d.setText(R.string.remove_block_chat);
            } else {
                this.f62358d.setText(R.string.block_chat_message);
            }
            if (z3) {
                this.f62363i.setVisibility(0);
            } else {
                this.f62363i.setVisibility(8);
            }
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.f62362h.setVisibility(8);
                return;
            }
            this.f62362h.setVisibility(0);
            this.f62362h.setText(String.format(this.f62360f.getResources().getString(R.string.more_info_username), str));
        }
    }
}
