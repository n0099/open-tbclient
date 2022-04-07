package com.repackage;

import android.util.SparseIntArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.switchs.PreInitMainTabViewSwitch;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.model.VideoMiddlePageAdCard;
import com.baidu.tieba.recapp.lego.view.AdCardMultiPicView;
import com.baidu.tieba.recapp.lego.view.AdCardSinglePicView;
import com.baidu.tieba.recapp.lego.view.AdCardSmallPicVideoView;
import com.baidu.tieba.recapp.lego.view.AdCardSmallPicView;
import com.baidu.tieba.recapp.lego.view.AdCardVideoView;
import com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView;
import com.baidu.tieba.recapp.lego.view.form.FormCardView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class yb8 extends wc7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public yb8() {
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

    @Override // com.repackage.wc7
    public <T> pd7 a(TbPageContext<T> tbPageContext, ICardInfo iCardInfo, int i) {
        InterceptResult invokeLLI;
        pd7 formCardView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, tbPageContext, iCardInfo, i)) == null) {
            int cardType = iCardInfo == null ? -1 : iCardInfo.getCardType();
            if (cardType != 17) {
                if (cardType == 27) {
                    formCardView = new FormCardView(tbPageContext);
                } else if (cardType == 33) {
                    formCardView = new VideoMiddlePageAdView(tbPageContext);
                } else if (cardType != 34) {
                    return null;
                }
                return formCardView;
            }
            return e(tbPageContext, iCardInfo, i);
        }
        return (pd7) invokeLLI.objValue;
    }

    @Override // com.repackage.wc7
    public ICardInfo b(JSONObject jSONObject, int i) throws CardParseException {
        InterceptResult invokeLI;
        ICardInfo adCard;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, i)) == null) {
            if (i != 17) {
                if (i == 27) {
                    adCard = new FormCard(jSONObject);
                } else if (i == 33) {
                    adCard = new VideoMiddlePageAdCard(jSONObject);
                } else if (i != 34) {
                    return null;
                }
                return adCard;
            }
            adCard = new AdCard(jSONObject);
            return adCard;
        }
        return (ICardInfo) invokeLI.objValue;
    }

    @Override // com.repackage.wc7
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SparseIntArray sparseIntArray = wc7.a;
            sparseIntArray.put(17, sparseIntArray.size() + 1);
            SparseIntArray sparseIntArray2 = wc7.a;
            sparseIntArray2.put(27, sparseIntArray2.size() + 1);
            SparseIntArray sparseIntArray3 = wc7.a;
            sparseIntArray3.put(33, sparseIntArray3.size() + 1);
            SparseIntArray sparseIntArray4 = wc7.a;
            sparseIntArray4.put(34, sparseIntArray4.size() + 1);
            wc7.b.put(17, BdUniqueId.gen());
            wc7.b.put(27, BdUniqueId.gen());
            wc7.b.put(33, BdUniqueId.gen());
            wc7.b.put(34, BdUniqueId.gen());
        }
    }

    @Override // com.repackage.wc7
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "lego_for_RecApp" : (String) invokeV.objValue;
    }

    public final BaseLegoCardView e(TbPageContext<?> tbPageContext, ICardInfo iCardInfo, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, tbPageContext, iCardInfo, i)) == null) {
            AdCardVideoView adCardVideoView = null;
            if (iCardInfo instanceof AdCard) {
                AdCard adCard = (AdCard) iCardInfo;
                int cardType = adCard.getCardType();
                if (cardType != 17 && cardType != 34) {
                    BdLog.e("RecAppLegoFactory: specifyAdCardView got wrong card type!");
                    return null;
                }
                int i2 = adCard.goodsStyle;
                if (i2 != 2) {
                    if (i2 != 6) {
                        if (i2 != 7) {
                            if (i2 != 8) {
                                switch (i2) {
                                    case 12:
                                        return new AdCardSmallPicVideoView(tbPageContext);
                                    case 13:
                                        return new AdCardSmallPicView(tbPageContext);
                                    case 14:
                                        break;
                                    default:
                                        return null;
                                }
                            }
                        }
                        if (PreInitMainTabViewSwitch.getIsOn()) {
                            AdCardVideoView adCardVideoView2 = (AdCardVideoView) q45.b().g;
                            if (adCardVideoView2 != null) {
                                adCardVideoView2.setBusinessType(i);
                            }
                            q45.b().g = null;
                            adCardVideoView = adCardVideoView2;
                        }
                        return adCardVideoView == null ? new AdCardVideoView(tbPageContext, i) : adCardVideoView;
                    }
                    if (PreInitMainTabViewSwitch.getIsOn()) {
                        q45.b().f = null;
                        adCardVideoView = (AdCardMultiPicView) q45.b().f;
                    }
                    return adCardVideoView == null ? new AdCardMultiPicView(tbPageContext) : adCardVideoView;
                }
                if (PreInitMainTabViewSwitch.getIsOn()) {
                    q45.b().e = null;
                    adCardVideoView = (AdCardSinglePicView) q45.b().e;
                }
                return adCardVideoView == null ? new AdCardSinglePicView(tbPageContext) : adCardVideoView;
            }
            return null;
        }
        return (BaseLegoCardView) invokeLLI.objValue;
    }
}
