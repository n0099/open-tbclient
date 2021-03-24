package d.b.i0.r2.z;

import android.util.SparseIntArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.model.VideoMiddlePageAdCard;
import com.baidu.tieba.recapp.lego.view.AdCardLoopPicView;
import com.baidu.tieba.recapp.lego.view.AdCardMultiPicView;
import com.baidu.tieba.recapp.lego.view.AdCardSinglePicView;
import com.baidu.tieba.recapp.lego.view.AdCardSmallPicVideoView;
import com.baidu.tieba.recapp.lego.view.AdCardSmallPicView;
import com.baidu.tieba.recapp.lego.view.AdCardVideoView;
import com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView;
import com.baidu.tieba.recapp.lego.view.form.FormCardView;
import d.b.i0.i1.o.e;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a extends e {
    @Override // d.b.i0.i1.o.e
    public <T> d.b.i0.i1.o.l.e a(TbPageContext<T> tbPageContext, ICardInfo iCardInfo, int i) {
        d.b.i0.i1.o.l.e formCardView;
        int cardType = iCardInfo == null ? -1 : iCardInfo.getCardType();
        if (cardType != 17 && cardType != 26) {
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

    @Override // d.b.i0.i1.o.e
    public ICardInfo b(JSONObject jSONObject, int i) throws CardParseException {
        ICardInfo adCard;
        if (i != 17 && i != 26) {
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

    @Override // d.b.i0.i1.o.e
    public void c() {
        SparseIntArray sparseIntArray = e.f55917a;
        sparseIntArray.put(17, sparseIntArray.size() + 1);
        SparseIntArray sparseIntArray2 = e.f55917a;
        sparseIntArray2.put(26, sparseIntArray2.size() + 1);
        SparseIntArray sparseIntArray3 = e.f55917a;
        sparseIntArray3.put(27, sparseIntArray3.size() + 1);
        SparseIntArray sparseIntArray4 = e.f55917a;
        sparseIntArray4.put(33, sparseIntArray4.size() + 1);
        SparseIntArray sparseIntArray5 = e.f55917a;
        sparseIntArray5.put(34, sparseIntArray5.size() + 1);
        e.f55918b.put(17, BdUniqueId.gen());
        e.f55918b.put(26, BdUniqueId.gen());
        e.f55918b.put(27, BdUniqueId.gen());
        e.f55918b.put(33, BdUniqueId.gen());
        e.f55918b.put(34, BdUniqueId.gen());
    }

    @Override // d.b.i0.i1.o.e
    public String d() {
        return "lego_for_RecApp";
    }

    public final BaseLegoCardView e(TbPageContext<?> tbPageContext, ICardInfo iCardInfo, int i) {
        if (iCardInfo instanceof AdCard) {
            AdCard adCard = (AdCard) iCardInfo;
            int cardType = adCard.getCardType();
            if (cardType != 17 && cardType != 34) {
                if (cardType == 26) {
                    return new AdCardLoopPicView(tbPageContext);
                }
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
                    return new AdCardVideoView(tbPageContext);
                }
                return new AdCardMultiPicView(tbPageContext);
            }
            return new AdCardSinglePicView(tbPageContext);
        }
        return null;
    }
}
