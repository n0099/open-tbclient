package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Personalized.CardForum;
import tbclient.Personalized.PersonalForum;
/* loaded from: classes6.dex */
public class ny6 extends ty5 implements cz5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CardForum e;

    public ny6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) ? i == 1 : invokeI.booleanValue;
    }

    @Override // com.repackage.cz5
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.showTopDivider = z;
        }
    }

    @Override // com.repackage.cz5
    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            CardForum cardForum = this.e;
            if (cardForum != null) {
                return cardForum.position.intValue();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.cz5
    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? ListUtils.getCount(getDataList()) > 0 : invokeV.booleanValue;
    }

    public void s(CardForum cardForum) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, cardForum) == null) || cardForum == null) {
            return;
        }
        this.e = cardForum;
        this.mGroupTitle = cardForum.card_title;
        if (cardForum.position != null) {
            k(g() + cardForum.position.intValue());
        } else {
            k(g() + 0);
        }
        if (ListUtils.getCount(cardForum.forum_list) > 0) {
            for (PersonalForum personalForum : cardForum.forum_list) {
                if (personalForum != null && !TextUtils.isEmpty(personalForum.forum_name) && personalForum.forum_id.longValue() > 0) {
                    sy5 sy5Var = new sy5();
                    sy5Var.b = personalForum.avatar;
                    sy5Var.c = personalForum.forum_name;
                    sy5Var.d = ng.e("" + personalForum.forum_id, -1);
                    sy5Var.e = personalForum.is_like.intValue() == 1;
                    c(sy5Var);
                }
            }
        }
    }

    @Override // com.repackage.cz5
    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.showBottomDivider = z;
        }
    }
}
