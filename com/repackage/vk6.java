package com.repackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.GameShareData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.BlurDrawable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
/* loaded from: classes7.dex */
public class vk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public TbImageView B;
    public LinearLayout C;
    public TextView D;
    public TextView E;
    public TextView F;
    public TextView G;
    public TextView H;
    public h I;
    public BlurDrawable J;
    public FrameLayout a;
    public FrameLayout b;
    public ImageView c;
    public LinearLayout d;
    public FrameLayout e;
    public ColumnLayout f;
    public TbImageView g;
    public TbImageView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public RadioButton l;
    public RadioButton m;
    public RadioButton n;
    public RadioButton o;
    public RadioButton p;
    public RadioButton[] q;
    public TextView r;
    public TbImageView s;
    public TextView t;
    public RadioButton u;
    public RadioButton v;
    public RadioButton w;
    public RadioButton x;
    public RadioButton y;
    public RadioButton[] z;

    /* loaded from: classes7.dex */
    public class a implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vk6 a;

        public a(vk6 vk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vk6Var;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                this.a.g.setVisibility(0);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vk6 a;

        public b(vk6 vk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vk6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Bitmap g;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (g = this.a.g()) == null || this.a.I == null) {
                return;
            }
            this.a.I.onWeixinShare(g);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vk6 a;

        public c(vk6 vk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vk6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Bitmap g;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (g = this.a.g()) == null || this.a.I == null) {
                return;
            }
            this.a.I.onWxFriendsShare(g);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vk6 a;

        public d(vk6 vk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vk6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Bitmap g;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (g = this.a.g()) == null || this.a.I == null) {
                return;
            }
            this.a.I.onQQShare(g);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vk6 a;

        public e(vk6 vk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vk6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Bitmap g;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (g = this.a.g()) == null || this.a.I == null) {
                return;
            }
            this.a.I.onSinaShare(g);
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vk6 a;

        public f(vk6 vk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vk6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.I == null) {
                return;
            }
            this.a.I.onCancel();
        }
    }

    /* loaded from: classes7.dex */
    public class g extends hg<fo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vk6 a;

        public g(vk6 vk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vk6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.hg
        public void onLoaded(fo foVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, foVar, str, i) == null) {
                super.onLoaded((g) foVar, str, i);
                if (foVar == null || foVar.p() == null) {
                    UtilHelper.showToast(this.a.a.getContext(), (int) R.string.obfuscated_res_0x7f0f111a);
                    if (this.a.I != null) {
                        this.a.I.onCancel();
                    }
                }
                this.a.J = new BlurDrawable(this.a.a.getContext());
                this.a.J.init(2, 4, foVar.p());
                this.a.J.drawBlur();
                this.a.c.setImageBitmap(this.a.J.getBlurredBitmap());
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface h {
        void onCancel();

        void onQQShare(Bitmap bitmap);

        void onSinaShare(Bitmap bitmap);

        void onWeixinShare(Bitmap bitmap);

        void onWxFriendsShare(Bitmap bitmap);
    }

    public vk6(Context context, h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.I = hVar;
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0039, (ViewGroup) null);
        this.a = frameLayout;
        this.b = (FrameLayout) frameLayout.findViewById(R.id.obfuscated_res_0x7f090c5d);
        this.c = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090c5c);
        this.d = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090c59);
        this.e = (FrameLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090c69);
        this.f = (ColumnLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090c68);
        TbImageView tbImageView = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090c67);
        this.g = tbImageView;
        tbImageView.setVisibility(4);
        this.g.setDefaultBg(new ColorDrawable(this.a.getResources().getColor(R.color.transparent)));
        this.g.setDrawerType(1);
        this.g.setRadius(context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5));
        this.g.setEvent(new a(this));
        TbImageView tbImageView2 = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090c64);
        this.h = tbImageView2;
        tbImageView2.setDrawerType(1);
        this.h.setRadius(context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5));
        this.i = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090c65);
        this.j = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090c63);
        this.k = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090c66);
        this.l = (RadioButton) this.a.findViewById(R.id.obfuscated_res_0x7f090c6c);
        this.m = (RadioButton) this.a.findViewById(R.id.obfuscated_res_0x7f090c6d);
        this.n = (RadioButton) this.a.findViewById(R.id.obfuscated_res_0x7f090c6e);
        this.o = (RadioButton) this.a.findViewById(R.id.obfuscated_res_0x7f090c6f);
        RadioButton radioButton = (RadioButton) this.a.findViewById(R.id.obfuscated_res_0x7f090c70);
        this.p = radioButton;
        this.q = new RadioButton[]{this.l, this.m, this.n, this.o, radioButton};
        this.r = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090c5a);
        TbImageView tbImageView3 = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090c72);
        this.s = tbImageView3;
        tbImageView3.setDrawerType(1);
        this.s.setIsRound(true);
        this.t = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090c71);
        this.u = (RadioButton) this.a.findViewById(R.id.obfuscated_res_0x7f090c73);
        this.v = (RadioButton) this.a.findViewById(R.id.obfuscated_res_0x7f090c74);
        this.w = (RadioButton) this.a.findViewById(R.id.obfuscated_res_0x7f090c75);
        this.x = (RadioButton) this.a.findViewById(R.id.obfuscated_res_0x7f090c76);
        RadioButton radioButton2 = (RadioButton) this.a.findViewById(R.id.obfuscated_res_0x7f090c77);
        this.y = radioButton2;
        this.z = new RadioButton[]{this.u, this.v, this.w, this.x, radioButton2};
        this.A = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090c6b);
        this.B = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090c6a);
        this.C = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090c5e);
        TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090c61);
        this.D = textView;
        textView.setOnClickListener(new b(this));
        TextView textView2 = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090c62);
        this.E = textView2;
        textView2.setOnClickListener(new c(this));
        TextView textView3 = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090c5f);
        this.F = textView3;
        textView3.setOnClickListener(new d(this));
        TextView textView4 = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090c60);
        this.G = textView4;
        textView4.setOnClickListener(new e(this));
        TextView textView5 = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090c58);
        this.H = textView5;
        textView5.setOnClickListener(new f(this));
    }

    public Bitmap g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.b.buildDrawingCache();
            return this.b.getDrawingCache();
        }
        return (Bitmap) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d.getBottom() : invokeV.intValue;
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    public void j() {
        BlurDrawable blurDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (blurDrawable = this.J) == null) {
            return;
        }
        blurDrawable.onDestroy();
        this.J = null;
    }

    public final void k(int i, RadioButton[] radioButtonArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i, radioButtonArr) == null) && radioButtonArr != null && radioButtonArr.length == 5) {
            if (i < 0) {
                i = 0;
            } else if (i > 10) {
                i = 10;
            }
            int i2 = i / 2;
            for (int i3 = 0; i3 < radioButtonArr.length; i3++) {
                if (radioButtonArr[i3] != null) {
                    if (i3 < i2) {
                        radioButtonArr[i3].setChecked(true);
                    } else {
                        radioButtonArr[i3].setChecked(false);
                    }
                }
            }
        }
    }

    public final void l(GameShareData gameShareData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, gameShareData) == null) || gameShareData == null) {
            return;
        }
        this.h.K(gameShareData.gameIconUrl, 10, false);
        this.i.setText(gameShareData.gameName);
        this.j.setText(gameShareData.gameDescription);
        this.k.setText(new DecimalFormat(".0").format(gameShareData.gameScore));
        k((int) gameShareData.gameScore, this.q);
    }

    public void m(GameShareData gameShareData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, gameShareData) == null) {
            l(gameShareData);
            n(gameShareData);
            StringBuilder sb = new StringBuilder();
            sb.append("“ ");
            sb.append(gameShareData.gameComment);
            sb.append(" ”");
            this.r.setText(sb);
            if (this.J == null) {
                ig.h().m(gameShareData.gameIconUrl, 10, new g(this), null);
            }
            this.g.K(gameShareData.headBgUrl, 10, false);
            this.B.K(gameShareData.shareQRCodeUrl, 10, false);
        }
    }

    public final void n(GameShareData gameShareData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, gameShareData) == null) || gameShareData == null) {
            return;
        }
        this.s.K(gameShareData.userPortrait, 12, false);
        this.t.setText(gameShareData.userName);
        k((int) gameShareData.userScore, this.z);
    }
}
