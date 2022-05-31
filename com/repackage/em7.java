package com.repackage;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FaceGroupMakeActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.tieba.newfaceshop.facemake.FaceGroupDraft;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class em7 implements View.OnClickListener, y76 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public View b;
    public View c;
    public View d;
    public ImageView e;
    public ImageView f;
    public TextView g;
    public TextView h;
    public Animation i;
    public TbPageContext j;
    public int k;
    public w76 l;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ em7 a;

        /* renamed from: com.repackage.em7$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0409a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ a b;

            public RunnableC0409a(a aVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.a >= 30) {
                        li.O(this.b.a.j.getPageActivity(), String.format(this.b.a.j.getString(R.string.obfuscated_res_0x7f0f0542), 30));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.b.a.j.getPageActivity(), true, 25021)));
                    }
                }
            }
        }

        public a(em7 em7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {em7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = em7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                List<MyEmotionGroupData> f = jl7.i().f();
                mg.a().post(new RunnableC0409a(this, f == null ? 0 : f.size()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ em7 a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ b b;

            public a(b bVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.a >= 30) {
                        li.O(this.b.a.j.getPageActivity(), String.format(this.b.a.j.getString(R.string.obfuscated_res_0x7f0f0542), 30));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.b.a.j.getPageActivity(), 25021)));
                    }
                }
            }
        }

        public b(em7 em7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {em7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = em7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                List<MyEmotionGroupData> f = jl7.i().f();
                mg.a().post(new a(this, f == null ? 0 : f.size()));
            }
        }
    }

    public em7(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = null;
        this.j = tbPageContext;
        this.k = i;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0258, (ViewGroup) null);
        this.c = inflate;
        this.a = inflate.findViewById(R.id.obfuscated_res_0x7f090883);
        View findViewById = this.c.findViewById(R.id.obfuscated_res_0x7f090884);
        this.b = findViewById;
        findViewById.setOnClickListener(this);
        this.a.setVisibility(0);
        View findViewById2 = this.c.findViewById(R.id.obfuscated_res_0x7f090888);
        this.d = findViewById2;
        findViewById2.setClickable(false);
        this.d.setOnClickListener(this);
        this.d.setVisibility(8);
        this.e = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f092273);
        this.f = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f090dc7);
        this.g = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090103);
        this.h = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090102);
    }

    @Override // com.repackage.y76
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            gl7.b().a(new b(this));
        }
    }

    @Override // com.repackage.y76
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            gl7.b().a(new a(this));
        }
    }

    public void d() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (imageView = this.e) == null) {
            return;
        }
        imageView.clearAnimation();
    }

    public final Animation e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.i == null) {
                this.i = AnimationUtils.loadAnimation(this.j.getPageActivity(), R.anim.obfuscated_res_0x7f010100);
                this.i.setInterpolator(new LinearInterpolator());
                this.i.setFillAfter(true);
            }
            return this.i;
        }
        return (Animation) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c : (View) invokeV.objValue;
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            View view2 = this.a;
            if (view2 != null) {
                SkinManager.setBackgroundColor(view2, R.color.cp_bg_line_d_alpha90, i);
            }
            TextView textView = this.h;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0302, i);
            }
            ImageView imageView = this.f;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, R.drawable.emotion_bar_add_icon);
            }
            TextView textView2 = this.g;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, R.color.CAM_X0302, i);
            }
            View view3 = this.d;
            if (view3 != null) {
                SkinManager.setBackgroundColor(view3, R.color.cp_bg_line_d_alpha90, i);
            }
            ImageView imageView2 = this.e;
            if (imageView2 != null) {
                SkinManager.setImageResource(imageView2, R.drawable.emotion_uploading_bar_refresh);
            }
        }
    }

    public void h() {
        w76 w76Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (w76Var = this.l) != null && w76Var.isShowing()) {
            this.l.dismiss();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            w76 w76Var = this.l;
            if (w76Var != null) {
                w76Var.dismiss();
            }
            d();
            this.d.setVisibility(8);
            this.a.setVisibility(0);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            w76 w76Var = this.l;
            if (w76Var != null) {
                w76Var.dismiss();
            }
            k();
            this.d.setVisibility(0);
            this.a.setVisibility(8);
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0201);
            SkinManager.setImageResource(this.e, R.drawable.emotion_uploading_bar_refresh);
            SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0302);
            this.h.setText(R.string.obfuscated_res_0x7f0f0566);
            this.d.setClickable(false);
        }
    }

    public void k() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (imageView = this.e) == null) {
            return;
        }
        imageView.startAnimation(e());
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            FaceGroupDraft k = tl7.l().k();
            if (k != null && TextUtils.isEmpty(k.getFailMsg())) {
                li.O(this.j.getPageActivity(), k.getFailMsg());
            }
            m(null);
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            w76 w76Var = this.l;
            if (w76Var != null) {
                w76Var.dismiss();
            }
            d();
            this.d.setVisibility(0);
            this.a.setVisibility(8);
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0201);
            SkinManager.setImageResource(this.e, R.drawable.emotion_update_fail);
            SkinManager.setViewTextColor(this.h, (int) R.color.common_color_10037);
            if (!TextUtils.isEmpty(str)) {
                this.h.setText(str);
            } else {
                this.h.setText(R.string.obfuscated_res_0x7f0f053f);
            }
            this.d.setClickable(true);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view2) == null) {
            if (this.b != null && view2.getId() == this.b.getId() && this.b.isShown()) {
                if (this.k == 1) {
                    if (this.l == null) {
                        w76 w76Var = new w76(this.j.getPageActivity(), this.k);
                        this.l = w76Var;
                        w76Var.d(this);
                    }
                    this.l.c(TbadkCoreApplication.getInst().getSkinType());
                    Rect rect = new Rect();
                    this.j.getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    this.l.showAtLocation(this.c, 81, 0, this.j.getPageActivity().getWindow().getDecorView().getHeight() - rect.bottom);
                } else {
                    a();
                }
            }
            if (this.d != null && view2.getId() == this.d.getId() && this.d.isShown()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.j.getPageActivity(), this.k == 1, 25021)));
            }
        }
    }

    public void update(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, obj) == null) {
        }
    }
}
