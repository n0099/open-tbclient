package com.repackage;

import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class f27 extends y8<MsglistActivity<?>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView b;
    public ImageView c;
    public HorizontalScrollView d;
    public LinearLayout e;
    public int f;
    public ef g;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f27 a;

        public a(f27 f27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f27Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.g == null) {
                return;
            }
            this.a.g.onItemViewClick(view2, 18, this.a.f, 0L);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GifView a;
        public final /* synthetic */ m37 b;
        public final /* synthetic */ int c;
        public final /* synthetic */ f27 d;

        public b(f27 f27Var, GifView gifView, m37 m37Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f27Var, gifView, m37Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = f27Var;
            this.a = gifView;
            this.b = m37Var;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.getBdImage() != null && this.a.getBdImage().w()) {
                this.b.c = this.a.getBdImage().r();
                this.b.d = this.a.getBdImage().m();
                if (this.d.g != null) {
                    new StatisticItem("c14658").addParam("uid", TbadkCoreApplication.getCurrentAccount()).eventStat();
                    this.d.g.onItemViewClick(view2, 19, this.d.f, this.c);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f27(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.obfuscated_res_0x7f0d0544);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((b9) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        this.b = (TextView) b(R.id.obfuscated_res_0x7f091429);
        this.c = (ImageView) b(R.id.obfuscated_res_0x7f091426);
        this.d = (HorizontalScrollView) b(R.id.obfuscated_res_0x7f091428);
        this.e = (LinearLayout) b(R.id.obfuscated_res_0x7f091427);
        this.b.setText(R.string.obfuscated_res_0x7f0f08b0);
        this.c.setOnClickListener(new a(this));
    }

    public final GifView i(m37 m37Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, m37Var, i)) == null) {
            GifView gifView = new GifView(this.e.getContext());
            gifView.setDrawerType(1);
            gifView.setConrers(15);
            gifView.setRadiusById(R.string.J_X05);
            gifView.setShowStaticDrawable(false);
            gifView.setPlaceHolder(2);
            gifView.j0(m37Var.b, 38);
            gifView.setOnClickListener(new b(this, gifView, m37Var, i));
            return gifView;
        }
        return (GifView) invokeLI.objValue;
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            HorizontalScrollView horizontalScrollView = this.d;
            if (horizontalScrollView != null) {
                wq4 d = wq4.d(horizontalScrollView);
                d.n(R.string.J_X05);
                d.f(R.color.CAM_X0201);
            }
            TextView textView = this.b;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0107);
            }
            ImageView imageView = this.c;
            if (imageView != null) {
                WebPManager.setPureDrawable(imageView, R.drawable.obfuscated_res_0x7f080936, R.color.CAM_X0111, null);
            }
        }
    }

    public void k(ef efVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, efVar) == null) {
            this.g = efVar;
        }
    }

    public void l(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, chatMessage) == null) || this.e == null || chatMessage == null || chatMessage.getIceBreakEmotions() == null) {
            return;
        }
        this.e.removeAllViews();
        int f = li.f(this.e.getContext(), R.dimen.tbds260);
        int f2 = li.f(this.e.getContext(), R.dimen.M_W_X004);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f, f);
        layoutParams.setMargins(0, 0, f2, 0);
        for (int i = 0; i < chatMessage.getIceBreakEmotions().size(); i++) {
            this.e.addView(i(chatMessage.getIceBreakEmotions().get(i), i), layoutParams);
        }
        new StatisticItem("c14661").addParam("uid", TbadkCoreApplication.getCurrentAccount()).eventStat();
    }
}
