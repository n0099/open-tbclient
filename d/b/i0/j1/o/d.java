package d.b.i0.j1.o;

import android.util.SparseIntArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.BigImgCard;
import com.baidu.tieba.lego.card.model.ButtonCard;
import com.baidu.tieba.lego.card.model.CardGroup;
import com.baidu.tieba.lego.card.model.FocusListCard;
import com.baidu.tieba.lego.card.model.HorRankCard;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.model.ImmersiveVideoCardEx;
import com.baidu.tieba.lego.card.model.ImmersiveWebViewCard;
import com.baidu.tieba.lego.card.model.LPBigImgCard;
import com.baidu.tieba.lego.card.model.OnePicInfoCard;
import com.baidu.tieba.lego.card.model.PlayPicInfoCard;
import com.baidu.tieba.lego.card.model.RankDetailTrendCard;
import com.baidu.tieba.lego.card.model.RankScoreCard;
import com.baidu.tieba.lego.card.model.SingleLineCard;
import com.baidu.tieba.lego.card.model.WebViewCard;
import com.baidu.tieba.lego.card.view.BaseCardView;
import com.baidu.tieba.lego.card.view.BigImgView;
import com.baidu.tieba.lego.card.view.ButtonCardView;
import com.baidu.tieba.lego.card.view.FocusListCardView;
import com.baidu.tieba.lego.card.view.HorRankCardView;
import com.baidu.tieba.lego.card.view.ImmersiveVideoCardViewEx;
import com.baidu.tieba.lego.card.view.ImmersiveWebViewCardView;
import com.baidu.tieba.lego.card.view.LPBigImgCardView;
import com.baidu.tieba.lego.card.view.OnePicInfoCardView;
import com.baidu.tieba.lego.card.view.PlayPicInfoCardView;
import com.baidu.tieba.lego.card.view.RankDetailTrendCardView;
import com.baidu.tieba.lego.card.view.RankScoreCardView;
import com.baidu.tieba.lego.card.view.SingleLineCardView;
import com.baidu.tieba.lego.card.view.WebViewCardView;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d extends e {

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final d f57364a = new d();
    }

    public static d f() {
        return b.f57364a;
    }

    @Override // d.b.i0.j1.o.e
    public ICardInfo b(JSONObject jSONObject, int i) throws CardParseException {
        ICardInfo playPicInfoCard;
        if (i == 1) {
            playPicInfoCard = new PlayPicInfoCard(jSONObject);
        } else if (i == 2) {
            playPicInfoCard = new SingleLineCard(jSONObject);
        } else if (i == 3) {
            playPicInfoCard = new OnePicInfoCard(jSONObject);
        } else if (i == 5) {
            playPicInfoCard = new FocusListCard(jSONObject);
        } else if (i == 6) {
            playPicInfoCard = new HorRankCard(jSONObject);
        } else if (i == 7) {
            playPicInfoCard = new RankDetailTrendCard(jSONObject);
        } else if (i == 8) {
            playPicInfoCard = new RankScoreCard(jSONObject);
        } else if (i == 11) {
            playPicInfoCard = new CardGroup(jSONObject);
        } else if (i == 28) {
            playPicInfoCard = new ButtonCard(jSONObject);
        } else if (i == 18) {
            playPicInfoCard = new WebViewCard(jSONObject);
        } else if (i != 19) {
            switch (i) {
                case 21:
                    playPicInfoCard = new LPBigImgCard(jSONObject);
                    break;
                case 22:
                    playPicInfoCard = new ImmersiveVideoCardEx(jSONObject);
                    break;
                case 23:
                    playPicInfoCard = new ImmersiveWebViewCard(jSONObject);
                    break;
                default:
                    return null;
            }
        } else {
            playPicInfoCard = new BigImgCard(jSONObject);
        }
        return playPicInfoCard;
    }

    @Override // d.b.i0.j1.o.e
    public void c() {
        SparseIntArray sparseIntArray = e.f57365a;
        sparseIntArray.put(1, sparseIntArray.size() + 1);
        SparseIntArray sparseIntArray2 = e.f57365a;
        sparseIntArray2.put(2, sparseIntArray2.size() + 1);
        SparseIntArray sparseIntArray3 = e.f57365a;
        sparseIntArray3.put(3, sparseIntArray3.size() + 1);
        SparseIntArray sparseIntArray4 = e.f57365a;
        sparseIntArray4.put(5, sparseIntArray4.size() + 1);
        SparseIntArray sparseIntArray5 = e.f57365a;
        sparseIntArray5.put(6, sparseIntArray5.size() + 1);
        SparseIntArray sparseIntArray6 = e.f57365a;
        sparseIntArray6.put(7, sparseIntArray6.size() + 1);
        SparseIntArray sparseIntArray7 = e.f57365a;
        sparseIntArray7.put(8, sparseIntArray7.size() + 1);
        SparseIntArray sparseIntArray8 = e.f57365a;
        sparseIntArray8.put(18, sparseIntArray8.size() + 1);
        SparseIntArray sparseIntArray9 = e.f57365a;
        sparseIntArray9.put(19, sparseIntArray9.size() + 1);
        SparseIntArray sparseIntArray10 = e.f57365a;
        sparseIntArray10.put(21, sparseIntArray10.size() + 1);
        SparseIntArray sparseIntArray11 = e.f57365a;
        sparseIntArray11.put(22, sparseIntArray11.size() + 1);
        SparseIntArray sparseIntArray12 = e.f57365a;
        sparseIntArray12.put(23, sparseIntArray12.size() + 1);
        SparseIntArray sparseIntArray13 = e.f57365a;
        sparseIntArray13.put(28, sparseIntArray13.size() + 1);
        e.f57366b.put(1, BdUniqueId.gen());
        e.f57366b.put(2, BdUniqueId.gen());
        e.f57366b.put(3, BdUniqueId.gen());
        e.f57366b.put(5, BdUniqueId.gen());
        e.f57366b.put(6, BdUniqueId.gen());
        e.f57366b.put(7, BdUniqueId.gen());
        e.f57366b.put(8, BdUniqueId.gen());
        e.f57366b.put(18, BdUniqueId.gen());
        e.f57366b.put(19, BdUniqueId.gen());
        e.f57366b.put(21, BdUniqueId.gen());
        e.f57366b.put(22, BdUniqueId.gen());
        e.f57366b.put(23, BdUniqueId.gen());
        e.f57366b.put(28, BdUniqueId.gen());
    }

    @Override // d.b.i0.j1.o.e
    public String d() {
        return "lego_main";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.j1.o.e
    /* renamed from: e */
    public <T> BaseCardView a(TbPageContext<T> tbPageContext, ICardInfo iCardInfo, int i) {
        BaseCardView playPicInfoCardView;
        int cardType = iCardInfo == null ? -1 : iCardInfo.getCardType();
        if (cardType == 1) {
            playPicInfoCardView = new PlayPicInfoCardView(tbPageContext);
        } else if (cardType == 2) {
            playPicInfoCardView = new SingleLineCardView(tbPageContext);
        } else if (cardType == 3) {
            playPicInfoCardView = new OnePicInfoCardView(tbPageContext);
        } else if (cardType == 5) {
            playPicInfoCardView = new FocusListCardView(tbPageContext);
        } else if (cardType == 6) {
            playPicInfoCardView = new HorRankCardView(tbPageContext);
        } else if (cardType == 7) {
            playPicInfoCardView = new RankDetailTrendCardView(tbPageContext);
        } else if (cardType == 8) {
            playPicInfoCardView = new RankScoreCardView(tbPageContext);
        } else if (cardType == 18) {
            playPicInfoCardView = new WebViewCardView(tbPageContext);
        } else if (cardType == 19) {
            playPicInfoCardView = new BigImgView(tbPageContext);
        } else if (cardType != 28) {
            switch (cardType) {
                case 21:
                    playPicInfoCardView = new LPBigImgCardView(tbPageContext);
                    break;
                case 22:
                    playPicInfoCardView = new ImmersiveVideoCardViewEx(tbPageContext);
                    break;
                case 23:
                    playPicInfoCardView = new ImmersiveWebViewCardView(tbPageContext);
                    break;
                default:
                    return null;
            }
        } else {
            playPicInfoCardView = new ButtonCardView(tbPageContext);
        }
        return playPicInfoCardView;
    }

    public d() {
    }
}
