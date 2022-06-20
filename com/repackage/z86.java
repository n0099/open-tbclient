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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FaceGroupMakeActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.emotioncenter.data.EmotionCenterData;
import com.baidu.tieba.faceshop.emotioncenter.view.EmotionCenterChangeView;
import com.baidu.tieba.faceshop.emotioncenter.view.EmotionCenterForumView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.nq4;
import com.repackage.ot4;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class z86 implements View.OnClickListener, y86 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public pt4 c;
    public RelativeLayout d;
    public NoNetworkView e;
    public PbListView f;
    public View g;
    public RelativeLayout h;
    public TextView i;
    public ImageView j;
    public r86 k;
    public EmotionCenterForumView l;
    public EmotionCenterChangeView m;
    public s86 n;
    public EmotionCenterData o;
    public w86 p;
    public LinearLayout q;
    public ImageView r;
    public TextView s;
    public Animation t;
    public boolean u;
    public int v;
    public String w;
    public h45 x;

    /* loaded from: classes7.dex */
    public class a implements nq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(z86 z86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.nq4.e
        public void onClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                nq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements nq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(z86 z86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.nq4.e
        public void onClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                nq4Var.dismiss();
            }
        }
    }

    public z86(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.t = null;
        this.u = true;
        this.v = 0;
        this.w = "";
        this.a = tbPageContext;
        this.d = (RelativeLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d02cd, (ViewGroup) null);
        this.e = new NoNetworkView(tbPageContext.getPageActivity());
        this.e.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        if (ni.z()) {
            this.e.setVisibility(8);
        }
        this.d.addView(this.e);
        BdTypeListView bdTypeListView = (BdTypeListView) this.d.findViewById(R.id.obfuscated_res_0x7f090841);
        this.b = bdTypeListView;
        bdTypeListView.setDivider(null);
        pt4 pt4Var = new pt4(this.a);
        this.c = pt4Var;
        pt4Var.b0(bdUniqueId);
        this.b.setPullRefresh(this.c);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f = pbListView;
        pbListView.a();
        r86 r86Var = new r86(this.a);
        this.k = r86Var;
        r86Var.c().setVisibility(8);
        EmotionCenterForumView emotionCenterForumView = new EmotionCenterForumView(this.a);
        this.l = emotionCenterForumView;
        emotionCenterForumView.setVisibility(8);
        this.n = new s86(this.a, this.b);
        EmotionCenterChangeView emotionCenterChangeView = new EmotionCenterChangeView(this.a);
        this.m = emotionCenterChangeView;
        emotionCenterChangeView.setVisibility(8);
        this.b.addHeaderView(this.k.c());
        this.b.addHeaderView(this.l);
        this.b.addHeaderView(this.m);
        this.g = this.d.findViewById(R.id.obfuscated_res_0x7f09083f);
        this.h = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f09083f);
        this.i = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090103);
        this.j = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090db8);
        this.g.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090886);
        this.q = linearLayout;
        linearLayout.setClickable(false);
        this.q.setOnClickListener(this);
        this.q.setVisibility(8);
        this.r = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f092261);
        this.s = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090105);
        t();
    }

    @Override // com.repackage.y86
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.a.getPageActivity(), 25021)));
        }
    }

    @Override // com.repackage.y86
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.v == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.a.getPageActivity(), true, 25021)));
            } else if (TextUtils.isEmpty(this.w)) {
            } else {
                nq4 nq4Var = new nq4(this.a.getPageActivity());
                nq4Var.setMessage(this.w);
                nq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f041f, new a(this));
                nq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0366, new b(this));
                nq4Var.create(this.a).show();
            }
        }
    }

    public void c(EmotionCenterData emotionCenterData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, emotionCenterData) == null) || emotionCenterData == null) {
            return;
        }
        this.o = emotionCenterData;
        if (!ListUtils.isEmpty(emotionCenterData.package_list)) {
            ArrayList arrayList = new ArrayList();
            for (EmotionPackageData emotionPackageData : emotionCenterData.package_list) {
                u86 u86Var = new u86();
                u86Var.a = emotionPackageData;
                arrayList.add(u86Var);
            }
            this.n.a(arrayList);
        }
        this.n.c();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b.z();
        }
    }

    public void e() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (imageView = this.r) == null) {
            return;
        }
        imageView.clearAnimation();
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.v : invokeV.intValue;
    }

    public final Animation g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.t == null) {
                this.t = AnimationUtils.loadAnimation(this.a.getPageActivity(), R.anim.obfuscated_res_0x7f010102);
                this.t.setInterpolator(new LinearInterpolator());
                this.t.setFillAfter(true);
            }
            return this.t;
        }
        return (Animation) invokeV.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.e : (View) invokeV.objValue;
    }

    public ViewGroup i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.d : (ViewGroup) invokeV.objValue;
    }

    public EmotionCenterChangeView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.m : (EmotionCenterChangeView) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            PbListView pbListView = this.f;
            if (pbListView != null) {
                pbListView.f();
            }
            this.b.setNextPage(null);
        }
    }

    public void l() {
        h45 h45Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (h45Var = this.x) == null) {
            return;
        }
        h45Var.dettachView(this.d);
        this.x = null;
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.f.p(R.color.CAM_X0204);
            this.f.d(i);
            this.c.H(i);
            this.n.c();
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0201);
            this.b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0201);
            this.e.d(this.a, i);
            EmotionCenterForumView emotionCenterForumView = this.l;
            if (emotionCenterForumView != null) {
                emotionCenterForumView.b(i);
            }
            RelativeLayout relativeLayout = this.h;
            if (relativeLayout != null) {
                SkinManager.setBackgroundColor(relativeLayout, R.color.cp_bg_line_d_alpha90, i);
            }
            TextView textView = this.i;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0302, i);
            }
            ImageView imageView = this.j;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, R.drawable.emotion_bar_add_icon);
            }
            if (this.q != null) {
                SkinManager.setBackgroundColor(this.h, R.color.cp_bg_line_d_alpha90, i);
            }
            ImageView imageView2 = this.r;
            if (imageView2 != null) {
                SkinManager.setImageResource(imageView2, R.drawable.emotion_uploading_bar_refresh);
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            w86 w86Var = this.p;
            if (w86Var != null) {
                w86Var.dismiss();
            }
            e();
            this.q.setVisibility(8);
            this.g.setVisibility(0);
        }
    }

    public void o(EmotionCenterData emotionCenterData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, emotionCenterData) == null) || emotionCenterData == null) {
            return;
        }
        l();
        if (ListUtils.isEmpty(this.m.getDataList())) {
            this.m.d();
            this.m.setVisibility(0);
        }
        this.o = emotionCenterData;
        if (this.u) {
            this.v = ng.e(emotionCenterData.is_bazhu, 0);
            this.w = emotionCenterData.bazhu_message;
            this.u = false;
        }
        if (emotionCenterData.banner != null) {
            this.k.c().setVisibility(0);
            this.k.f(this.a.getUniqueId());
            this.k.e(new v86(emotionCenterData.banner));
            this.k.g();
        }
        if (emotionCenterData.forum != null) {
            this.l.setVisibility(0);
            this.l.setData(emotionCenterData.forum);
        }
        if (!ListUtils.isEmpty(emotionCenterData.package_list)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new t86());
            for (EmotionPackageData emotionPackageData : emotionCenterData.package_list) {
                u86 u86Var = new u86();
                u86Var.a = emotionPackageData;
                arrayList.add(u86Var);
            }
            this.n.d(arrayList);
        }
        this.n.c();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view2) == null) {
            if (view2 == this.g) {
                if (this.o == null) {
                    return;
                }
                if (this.v != 0) {
                    if (this.p == null) {
                        w86 w86Var = new w86(this.a.getPageActivity(), this.v);
                        this.p = w86Var;
                        w86Var.d(this);
                    }
                    this.p.c(TbadkCoreApplication.getInst().getSkinType());
                    Rect rect = new Rect();
                    this.a.getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    this.p.showAtLocation(this.d, 81, 0, this.a.getPageActivity().getWindow().getDecorView().getHeight() - rect.bottom);
                    return;
                }
                a();
            } else if (view2 == this.q) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.a.getPageActivity(), this.v == 1, 25021)));
            }
        }
    }

    public void p(ot4.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, gVar) == null) {
            this.c.f(gVar);
        }
    }

    public void q(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, pVar) == null) {
            this.b.setOnSrollToBottomListener(pVar);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            w86 w86Var = this.p;
            if (w86Var != null) {
                w86Var.dismiss();
            }
            v();
            this.q.setVisibility(0);
            this.g.setVisibility(8);
            SkinManager.setBackgroundColor(this.q, R.color.CAM_X0201);
            SkinManager.setImageResource(this.r, R.drawable.emotion_uploading_bar_refresh);
            SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0302);
            this.s.setText(R.string.obfuscated_res_0x7f0f055a);
            this.q.setClickable(false);
        }
    }

    public void s() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (pbListView = this.f) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.b.setNextPage(this.f);
        }
        this.f.O();
        this.f.Q();
    }

    public void t() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (tbPageContext = this.a) == null || this.d == null) {
            return;
        }
        h45 h45Var = new h45(tbPageContext.getPageActivity());
        this.x = h45Var;
        h45Var.attachView(this.d, false);
        this.x.onChangeSkinType();
    }

    public void u() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (pbListView = this.f) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.b.setNextPage(this.f);
        }
        this.f.C(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09fa));
        this.f.f();
    }

    public void v() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (imageView = this.r) == null) {
            return;
        }
        imageView.startAnimation(g());
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            w86 w86Var = this.p;
            if (w86Var != null) {
                w86Var.dismiss();
            }
            e();
            this.q.setVisibility(0);
            this.g.setVisibility(8);
            SkinManager.setBackgroundColor(this.q, R.color.CAM_X0201);
            SkinManager.setImageResource(this.r, R.drawable.emotion_update_fail);
            SkinManager.setViewTextColor(this.s, (int) R.color.common_color_10037);
            this.s.setText(R.string.obfuscated_res_0x7f0f0533);
            this.q.setClickable(true);
        }
    }

    public void x(EmotionPackageData emotionPackageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, emotionPackageData) == null) || emotionPackageData == null) {
            return;
        }
        EmotionCenterChangeView emotionCenterChangeView = this.m;
        if (emotionCenterChangeView != null) {
            emotionCenterChangeView.f(emotionPackageData);
        }
        s86 s86Var = this.n;
        if (s86Var != null) {
            s86Var.e(emotionPackageData);
        }
    }
}
