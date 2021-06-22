package d.a.o0.t2.f0;

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
import com.baidu.tieba.recapp.lego.view.AdCardMultiPicView;
import com.baidu.tieba.recapp.lego.view.AdCardSinglePicView;
import com.baidu.tieba.recapp.lego.view.AdCardSmallPicVideoView;
import com.baidu.tieba.recapp.lego.view.AdCardSmallPicView;
import com.baidu.tieba.recapp.lego.view.AdCardVideoView;
import com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView;
import com.baidu.tieba.recapp.lego.view.form.FormCardView;
import d.a.o0.k1.o.e;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a extends e {
    @Override // d.a.o0.k1.o.e
    public <T> d.a.o0.k1.o.l.e a(TbPageContext<T> tbPageContext, ICardInfo iCardInfo, int i2) {
        d.a.o0.k1.o.l.e formCardView;
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
        return e(tbPageContext, iCardInfo, i2);
    }

    @Override // d.a.o0.k1.o.e
    public ICardInfo b(JSONObject jSONObject, int i2) throws CardParseException {
        ICardInfo adCard;
        if (i2 != 17) {
            if (i2 == 27) {
                adCard = new FormCard(jSONObject);
            } else if (i2 == 33) {
                adCard = new VideoMiddlePageAdCard(jSONObject);
            } else if (i2 != 34) {
                return null;
            }
            return adCard;
        }
        adCard = new AdCard(jSONObject);
        return adCard;
    }

    @Override // d.a.o0.k1.o.e
    public void c() {
        SparseIntArray sparseIntArray = e.f60452a;
        sparseIntArray.put(17, sparseIntArray.size() + 1);
        SparseIntArray sparseIntArray2 = e.f60452a;
        sparseIntArray2.put(27, sparseIntArray2.size() + 1);
        SparseIntArray sparseIntArray3 = e.f60452a;
        sparseIntArray3.put(33, sparseIntArray3.size() + 1);
        SparseIntArray sparseIntArray4 = e.f60452a;
        sparseIntArray4.put(34, sparseIntArray4.size() + 1);
        e.f60453b.put(17, BdUniqueId.gen());
        e.f60453b.put(27, BdUniqueId.gen());
        e.f60453b.put(33, BdUniqueId.gen());
        e.f60453b.put(34, BdUniqueId.gen());
    }

    @Override // d.a.o0.k1.o.e
    public String d() {
        return "lego_for_RecApp";
    }

    public final BaseLegoCardView e(TbPageContext<?> tbPageContext, ICardInfo iCardInfo, int i2) {
        if (iCardInfo instanceof AdCard) {
            AdCard adCard = (AdCard) iCardInfo;
            int cardType = adCard.getCardType();
            if (cardType != 17 && cardType != 34) {
                BdLog.e("RecAppLegoFactory: specifyAdCardView got wrong card type!");
                return null;
            }
            int i3 = adCard.goodsStyle;
            if (i3 != 2) {
                if (i3 != 6) {
                    if (i3 != 7) {
                        if (i3 != 8) {
                            switch (i3) {
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
