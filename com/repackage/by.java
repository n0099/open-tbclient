package com.repackage;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class by extends sw implements gx<ThreadData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext e;
    public TbImageView f;
    public boolean g;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThemeCardInUserData a;
        public final /* synthetic */ by b;

        public a(by byVar, ThemeCardInUserData themeCardInUserData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {byVar, themeCardInUserData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = byVar;
            this.a = themeCardInUserData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(this.b.e.getPageActivity(), this.a.getCardId())));
            }
        }
    }

    public by(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = true;
        this.e = tbPageContext;
        h(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(pi.f(tbPageContext.getPageActivity(), R.dimen.obfuscated_res_0x7f070263), pi.f(tbPageContext.getPageActivity(), R.dimen.obfuscated_res_0x7f0702d4));
        layoutParams.addRule(11);
        layoutParams.topMargin = pi.f(tbPageContext.getPageActivity(), R.dimen.tbds30);
        layoutParams.rightMargin = pi.f(tbPageContext.getPageActivity(), R.dimen.tbds30);
        i(layoutParams);
        TbImageView tbImageView = new TbImageView(tbPageContext.getPageActivity());
        this.f = tbImageView;
        g(tbImageView);
    }

    public void l(ThreadData threadData) {
        MetaData author;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) || threadData == null || this.f == null || (author = threadData.getAuthor()) == null) {
            return;
        }
        ThemeCardInUserData themeCard = author.getThemeCard();
        if (themeCard != null && !StringUtils.isNull(themeCard.getCardImageUrlAndroid()) && !threadData.isHeadLinePost) {
            if (this.g && (this.f.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f.getLayoutParams();
                layoutParams.rightMargin = pi.f(this.e.getPageActivity(), R.dimen.tbds106);
                this.f.setLayoutParams(layoutParams);
            }
            this.f.setVisibility(0);
            this.f.setImageDrawable(null);
            this.f.J(themeCard.getCardImageUrlAndroid(), 10, false);
            this.f.setOnClickListener(new a(this, themeCard));
            return;
        }
        this.f.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.gx
    /* renamed from: m */
    public void a(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) == null) {
            l(threadData);
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.g = z;
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            this.f.setPageId(bdUniqueId);
        }
    }
}
