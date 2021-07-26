package d.a.q0.n1.o;

import android.util.SparseIntArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final d f61162a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(629433370, "Ld/a/q0/n1/o/d$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(629433370, "Ld/a/q0/n1/o/d$b;");
                    return;
                }
            }
            f61162a = new d(null);
        }
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    public static d f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.f61162a : (d) invokeV.objValue;
    }

    @Override // d.a.q0.n1.o.e
    public ICardInfo b(JSONObject jSONObject, int i2) throws CardParseException {
        InterceptResult invokeLI;
        ICardInfo playPicInfoCard;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, i2)) == null) {
            if (i2 == 1) {
                playPicInfoCard = new PlayPicInfoCard(jSONObject);
            } else if (i2 == 2) {
                playPicInfoCard = new SingleLineCard(jSONObject);
            } else if (i2 == 3) {
                playPicInfoCard = new OnePicInfoCard(jSONObject);
            } else if (i2 == 5) {
                playPicInfoCard = new FocusListCard(jSONObject);
            } else if (i2 == 6) {
                playPicInfoCard = new HorRankCard(jSONObject);
            } else if (i2 == 7) {
                playPicInfoCard = new RankDetailTrendCard(jSONObject);
            } else if (i2 == 8) {
                playPicInfoCard = new RankScoreCard(jSONObject);
            } else if (i2 == 11) {
                playPicInfoCard = new CardGroup(jSONObject);
            } else if (i2 == 28) {
                playPicInfoCard = new ButtonCard(jSONObject);
            } else if (i2 == 18) {
                playPicInfoCard = new WebViewCard(jSONObject);
            } else if (i2 != 19) {
                switch (i2) {
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
        return (ICardInfo) invokeLI.objValue;
    }

    @Override // d.a.q0.n1.o.e
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SparseIntArray sparseIntArray = e.f61163a;
            sparseIntArray.put(1, sparseIntArray.size() + 1);
            SparseIntArray sparseIntArray2 = e.f61163a;
            sparseIntArray2.put(2, sparseIntArray2.size() + 1);
            SparseIntArray sparseIntArray3 = e.f61163a;
            sparseIntArray3.put(3, sparseIntArray3.size() + 1);
            SparseIntArray sparseIntArray4 = e.f61163a;
            sparseIntArray4.put(5, sparseIntArray4.size() + 1);
            SparseIntArray sparseIntArray5 = e.f61163a;
            sparseIntArray5.put(6, sparseIntArray5.size() + 1);
            SparseIntArray sparseIntArray6 = e.f61163a;
            sparseIntArray6.put(7, sparseIntArray6.size() + 1);
            SparseIntArray sparseIntArray7 = e.f61163a;
            sparseIntArray7.put(8, sparseIntArray7.size() + 1);
            SparseIntArray sparseIntArray8 = e.f61163a;
            sparseIntArray8.put(18, sparseIntArray8.size() + 1);
            SparseIntArray sparseIntArray9 = e.f61163a;
            sparseIntArray9.put(19, sparseIntArray9.size() + 1);
            SparseIntArray sparseIntArray10 = e.f61163a;
            sparseIntArray10.put(21, sparseIntArray10.size() + 1);
            SparseIntArray sparseIntArray11 = e.f61163a;
            sparseIntArray11.put(22, sparseIntArray11.size() + 1);
            SparseIntArray sparseIntArray12 = e.f61163a;
            sparseIntArray12.put(23, sparseIntArray12.size() + 1);
            SparseIntArray sparseIntArray13 = e.f61163a;
            sparseIntArray13.put(28, sparseIntArray13.size() + 1);
            e.f61164b.put(1, BdUniqueId.gen());
            e.f61164b.put(2, BdUniqueId.gen());
            e.f61164b.put(3, BdUniqueId.gen());
            e.f61164b.put(5, BdUniqueId.gen());
            e.f61164b.put(6, BdUniqueId.gen());
            e.f61164b.put(7, BdUniqueId.gen());
            e.f61164b.put(8, BdUniqueId.gen());
            e.f61164b.put(18, BdUniqueId.gen());
            e.f61164b.put(19, BdUniqueId.gen());
            e.f61164b.put(21, BdUniqueId.gen());
            e.f61164b.put(22, BdUniqueId.gen());
            e.f61164b.put(23, BdUniqueId.gen());
            e.f61164b.put(28, BdUniqueId.gen());
        }
    }

    @Override // d.a.q0.n1.o.e
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "lego_main" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.n1.o.e
    /* renamed from: e */
    public <T> BaseCardView a(TbPageContext<T> tbPageContext, ICardInfo iCardInfo, int i2) {
        InterceptResult invokeLLI;
        BaseCardView playPicInfoCardView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, tbPageContext, iCardInfo, i2)) == null) {
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
        return (BaseCardView) invokeLLI.objValue;
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
