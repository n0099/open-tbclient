package com.repackage;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.my5;
/* loaded from: classes6.dex */
public abstract class kx5<T extends my5> extends jx5<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout i;
    public TextView j;
    public TextView k;
    public TextView l;
    public View m;
    public View n;
    public View o;
    public ImageView p;
    public LinearLayout q;
    public View r;
    public View s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kx5(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.q = null;
        s(h());
    }

    @Override // com.repackage.jx5
    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d018e : invokeV.intValue;
    }

    @Override // com.repackage.jx5
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            if (this.a != i) {
                r();
            }
            this.a = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view2) == null) && this.l == view2 && view2 != null && (view2.getTag() instanceof String)) {
            String str = (String) view2.getTag();
            if (StringUtils.isNull(str)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(g(), new String[]{str});
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (c() != null && c().equals(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_HOME)) {
                SkinManager.setViewTextColor(this.j, R.color.CAM_X0109, 1);
                this.p.setVisibility(8);
            } else {
                SkinManager.setViewTextColor(this.j, R.color.CAM_X0106, 1);
                SkinManager.setImageResource(this.p, R.drawable.icon_arrow_tab);
            }
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0109, 1);
            SkinManager.setBackgroundColor(h(), R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.m, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.n, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.o, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.r, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.s, R.color.CAM_X0204);
        }
    }

    public final void s(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            this.i = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090f4c);
            this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090f40);
            this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090f67);
            this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090f2c);
            this.m = view2.findViewById(R.id.obfuscated_res_0x7f0907d5);
            this.n = view2.findViewById(R.id.obfuscated_res_0x7f0907d2);
            this.o = view2.findViewById(R.id.obfuscated_res_0x7f0907cf);
            this.q = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0904d1);
            this.r = view2.findViewById(R.id.obfuscated_res_0x7f0907c3);
            this.s = view2.findViewById(R.id.obfuscated_res_0x7f0907c4);
            this.p = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090f66);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.jx5
    /* renamed from: t */
    public void i(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, t) == null) {
            if (t == null) {
                h().setVisibility(8);
                return;
            }
            this.j.setText(t.mGroupTitle);
            int i = t.mRightIconResId;
            if (i > 0) {
                this.k.setBackgroundResource(i);
            }
            if (t.showTopDivider) {
                this.s.setVisibility(0);
            } else {
                this.s.setVisibility(8);
            }
            if (t.showBottomDivider) {
                this.r.setVisibility(0);
            } else {
                this.r.setVisibility(8);
            }
            if (!StringUtils.isNull(t.mBottomText)) {
                this.l.setVisibility(0);
                this.o.setVisibility(0);
                this.n.setVisibility(0);
                this.l.setText(t.mBottomText);
                String str = t.mBottomLink;
                if (StringUtils.isNull(str)) {
                    return;
                }
                this.l.setTag(str);
                this.l.setOnClickListener(this);
                return;
            }
            this.l.setVisibility(8);
            this.o.setVisibility(8);
            this.n.setVisibility(8);
        }
    }
}
