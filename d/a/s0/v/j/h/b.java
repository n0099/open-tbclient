package d.a.s0.v.j.h;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.v.j.d.f;
/* loaded from: classes9.dex */
public class b extends d.a.s0.a0.b<f> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView m;
    public ProgressBar n;
    public FrameLayout o;
    public TextView p;
    public TextView q;
    public TextView r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        s(l());
    }

    @Override // d.a.s0.a0.b
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.ala_person_center_list_head_item : invokeV.intValue;
    }

    @Override // d.a.s0.a0.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    public final void s(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            this.m = (TextView) view.findViewById(R.id.ala_person_center_level);
            this.q = (TextView) view.findViewById(R.id.level_name_curr);
            this.r = (TextView) view.findViewById(R.id.level_name_next);
            this.p = (TextView) view.findViewById(R.id.ala_person_center_tips);
            this.n = (ProgressBar) view.findViewById(R.id.ala_person_center_level_progress);
            this.o = (FrameLayout) view.findViewById(R.id.level_privilege_layout);
            l().setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.s0.a0.b
    /* renamed from: t */
    public void m(f fVar) {
        d.a.s0.v.j.d.c c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) || (c2 = fVar.c()) == null || c2.b() == null) {
            return;
        }
        String str = "LV." + c2.b().yy_level_id;
        if (!TextUtils.isEmpty(c2.b().yy_level_name)) {
            str = c2.b().yy_level_name + str;
            this.q.setText(c2.b().yy_level_name);
        }
        this.m.setText(str);
        if (c2.b().yy_levelup_exp <= c2.b().yy_level_exp) {
            this.q.setVisibility(8);
            this.r.setVisibility(8);
            this.p.setVisibility(8);
            this.n.setVisibility(8);
            return;
        }
        if (!TextUtils.isEmpty(c2.b().yy_level_next_name)) {
            this.r.setText(c2.b().yy_level_next_name);
        }
        long j = c2.b().yy_levelup_exp;
        long j2 = c2.b().yy_level_exp;
        this.n.setMax((int) j);
        this.n.setProgress((int) j2);
        if (TextUtils.isEmpty(c2.b().yy_level_next_name) || c2.b().yy_levelup_exp <= c2.b().yy_level_exp) {
            return;
        }
        String string = this.f57032f.getPageActivity().getResources().getString(R.string.ala_level_next_tips);
        int i2 = (int) ((((float) (c2.b().yy_levelup_exp - c2.b().yy_level_exp)) * 100.0f) / ((float) c2.b().yy_levelup_exp));
        if (i2 <= 0) {
            i2 = 1;
        }
        this.p.setText(String.format(string, c2.b().yy_level_next_name, i2 + "%"));
    }
}
