package com.repackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.gamevideo.view.GameVideoGridView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class zu6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public View b;
    public GameVideoGridView c;
    public uu6 d;
    public TextView e;
    public b f;
    public BdUniqueId g;
    public AdapterView.OnItemClickListener h;

    /* loaded from: classes7.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zu6 a;

        public a(zu6 zu6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zu6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zu6Var;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || this.a.d == null || i >= this.a.d.getCount() || this.a.d.getItem(i) == null || !(this.a.d.getItem(i) instanceof cv6)) {
                return;
            }
            cv6 cv6Var = (cv6) this.a.d.getItem(i);
            if (cv6Var.d == 1) {
                this.a.d.c(cv6Var.a);
                if (this.a.f != null) {
                    this.a.f.a(cv6Var);
                }
                this.a.d();
                xt4.k().w("key_game_video_tab_has_choosed_sub_class_id", cv6Var.a);
                xt4.k().y("key_game_video_tab_has_choosed_sub_class_name", cv6Var.b);
                TiebaStatic.log(new StatisticItem("c13485").param("obj_type", cv6Var.a));
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(cv6 cv6Var);
    }

    public zu6(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new a(this);
        this.a = tbPageContext;
        this.g = bdUniqueId;
        e();
    }

    public void c(ViewGroup viewGroup) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) || viewGroup == null || (view2 = this.b) == null) {
            return;
        }
        if (view2.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        viewGroup.addView(this.b);
        TiebaStatic.log("c13484");
    }

    public void d() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (view2 = this.b) == null || view2.getParent() == null) {
            return;
        }
        ((ViewGroup) this.b.getParent()).removeView(this.b);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0371, (ViewGroup) null);
            this.b = inflate;
            this.c = (GameVideoGridView) inflate.findViewById(R.id.obfuscated_res_0x7f090dd9);
            this.d = new uu6(this.a, 101, this.g);
            this.c.setNumColumns(4);
            this.c.setAdapter((ListAdapter) this.d);
            this.c.setOnItemClickListener(this.h);
            this.e = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090dda);
            f();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TextView textView = this.e;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
            }
            View view2 = this.b;
            if (view2 != null) {
                SkinManager.setBackgroundResource(view2, R.color.CAM_X0201);
            }
        }
    }

    public void g() {
        GameVideoGridView gameVideoGridView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (gameVideoGridView = this.c) == null) {
            return;
        }
        gameVideoGridView.d();
    }

    public void h(List<cv6> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.d.b(list);
        this.d.notifyDataSetChanged();
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f = bVar;
        }
    }
}
