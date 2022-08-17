package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.oy;
/* loaded from: classes6.dex */
public class mx extends tw implements ix, hx<ThreadData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final RelativeLayout e;
    public final LinearLayout f;
    public View g;
    public View h;
    public View i;
    public ImageView j;
    public TextView k;
    public ThreadData l;
    public boolean m;
    public boolean n;
    public CustomMessageListener o;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(mx mxVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mxVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mxVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ThreadData) && ((ThreadData) customResponsedMessage.getData()) == this.a.l) {
                this.a.r();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx a;

        public b(mx mxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mxVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.j == null || this.a.l == null || this.a.k == null || this.a.l.isTransportThread() || !this.a.n) {
                return;
            }
            if (this.a.l.isMarkToDel() || !le6.f().i()) {
                if (this.a.l.isMarkToMove() || !ke6.h().j()) {
                    le6.f().l(this.a.l);
                    this.a.l.setMarkToDel(false);
                    ke6.h().l(this.a.l);
                    this.a.l.setMarkToMove(false);
                } else if (ke6.h().a(this.a.l)) {
                    this.a.l.setMarkToMove(true);
                }
            } else if (le6.f().a(this.a.l)) {
                this.a.l.setMarkToDel(true);
            }
            this.a.r();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, this.a.l));
        }
    }

    public mx(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = false;
        this.n = true;
        this.o = new a(this, 2921402);
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d05ac, (ViewGroup) null);
        this.g = inflate;
        this.h = inflate.findViewById(R.id.obfuscated_res_0x7f091581);
        this.f = (LinearLayout) this.g.findViewById(R.id.obfuscated_res_0x7f09157b);
        this.h.setAlpha(0.5f);
        View findViewById = this.g.findViewById(R.id.obfuscated_res_0x7f091580);
        this.i = findViewById;
        findViewById.setAlpha(0.5f);
        this.j = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f091474);
        this.e = (RelativeLayout) this.g.findViewById(R.id.obfuscated_res_0x7f09157c);
        this.k = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091476);
        g(this.g);
        this.g.setFocusable(true);
        this.g.setOnClickListener(new b(this));
        h(-1);
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).registerListener(this.o);
        } else if (context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) context).registerListener(this.o);
        }
    }

    @Override // com.repackage.tw
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.repackage.tw
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.repackage.ix
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) {
            if (!this.l.isMarkToDel() && !this.l.isMarkToMove()) {
                WebPManager.setPureDrawable(this.j, R.drawable.obfuscated_res_0x7f080938, R.color.CAM_X0107, null);
            } else {
                WebPManager.setPureDrawable(this.j, R.drawable.obfuscated_res_0x7f080935, R.color.CAM_X0304, null);
            }
            ms4 d = ms4.d(this.h);
            d.n(R.string.J_X06);
            d.m(this.m ? 2 : 1);
            d.f(R.color.CAM_X0201);
            ms4 d2 = ms4.d(this.i);
            d2.n(R.string.J_X06);
            d2.m(2);
            d2.f(R.color.CAM_X0201);
            ms4.d(this.k).A(R.string.F_X01);
            SkinManager.setViewTextColor(this.k, (this.l.isMarkToDel() || this.l.isMarkToMove()) ? R.color.CAM_X0302 : R.drawable.selector_comment_and_prise_item_text_color);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.hx
    /* renamed from: p */
    public void a(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, threadData) == null) {
            this.l = threadData;
            this.n = threadData.getType() != ThreadData.TYPE_FAKE_VIDEO && (threadData == null || threadData.getAuthor() == null || !threadData.getAuthor().isForumBusinessAccount() || threadData.isSelf()) && threadData != null && (!threadData.isTiePlusCantDeleteUnion() || threadData.isSelf());
            if (!le6.f().i() && !ke6.h().j()) {
                this.d.o(new oy.a(4, Boolean.TRUE));
                this.g.setVisibility(8);
                return;
            }
            this.g.setVisibility(0);
            this.d.o(new oy.a(4, Boolean.FALSE));
            r();
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.m = z;
        }
    }

    public final void r() {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (threadData = this.l) == null) {
            return;
        }
        int i = 4;
        this.h.setVisibility((threadData.isMarkToDel() || this.l.isMarkToMove() || !this.n) ? 0 : 4);
        this.i.setVisibility((this.l.isMarkToDel() || this.l.isMarkToMove()) ? 0 : 0);
        if (this.m) {
            this.e.setVisibility(0);
            if (this.n) {
                this.j.setVisibility(0);
                this.k.setVisibility(0);
                boolean isMarkToDel = this.l.isMarkToDel();
                int i2 = R.color.CAM_X0304;
                if (!isMarkToDel && !this.l.isMarkToMove()) {
                    WebPManager.setPureDrawable(this.j, R.drawable.obfuscated_res_0x7f080938, R.color.CAM_X0107, null);
                } else {
                    WebPManager.setPureDrawable(this.j, R.drawable.obfuscated_res_0x7f080935, R.color.CAM_X0304, null);
                }
                TextView textView = this.k;
                if (!this.l.isMarkToDel() && !this.l.isMarkToMove()) {
                    i2 = R.drawable.selector_comment_and_prise_item_text_color;
                }
                SkinManager.setViewTextColor(textView, i2);
                return;
            }
            this.j.setVisibility(8);
            this.k.setVisibility(8);
            return;
        }
        this.e.setVisibility(8);
        this.j.setVisibility(8);
        this.k.setVisibility(8);
    }

    public void s(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
        }
    }

    public void t(int i, ey eyVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, eyVar) == null) {
            this.f.setWeightSum(i);
            if (this.f.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.f.getLayoutParams()).setMargins(eyVar.f, eyVar.d, eyVar.g, eyVar.e);
            }
        }
    }
}
