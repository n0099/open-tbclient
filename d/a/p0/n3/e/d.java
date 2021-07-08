package d.a.p0.n3.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalBackgroundPreviewActivityConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.themeCenter.background.BackgroundSetRequestMessage;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f60914a;

    /* renamed from: b  reason: collision with root package name */
    public int f60915b;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f60916c;

    /* renamed from: d  reason: collision with root package name */
    public int f60917d;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60916c = null;
        this.f60917d = -1;
        this.f60914a = tbPageContext;
        this.f60916c = bdUniqueId;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f60915b : invokeV.intValue;
    }

    public void b(DressItemData dressItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dressItemData) == null) || dressItemData == null || dressItemData.getPropsId() == 0) {
            return;
        }
        PersonalBackgroundPreviewActivityConfig personalBackgroundPreviewActivityConfig = new PersonalBackgroundPreviewActivityConfig(this.f60914a.getPageActivity(), dressItemData.getPropsId(), dressItemData.getInUse() ? 1 : 0);
        personalBackgroundPreviewActivityConfig.setFrom(this.f60917d);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, personalBackgroundPreviewActivityConfig));
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f60917d = i2;
        }
    }

    public void d(int i2, String str, DressItemData dressItemData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), str, dressItemData, Boolean.valueOf(z)}) == null) {
            int i3 = dressItemData.getFreeUserLevel() == 101 ? 9 : 0;
            if (StringUtils.isNull(str)) {
                return;
            }
            if (i2 == d.a.p0.n3.c.f60868a) {
                int i4 = this.f60917d;
                d.a.p0.n3.b.d(this.f60914a, z ? 4 : 2, str, i3, i4 == 1 ? MemberPayStatistic.REFER_PAGE_PERSONALITY_BACKGROUND_TRY : i4 == 0 ? MemberPayStatistic.REFER_PAGE_ALL_BACKGROUND_TRY : "", MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
            } else if (i2 == d.a.p0.n3.c.f60869b) {
                d.a.p0.n3.b.c(this.f60914a, z ? 4 : 2, str, i3);
            }
        }
    }

    public void e(DressItemData dressItemData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048580, this, dressItemData, z) == null) || dressItemData == null) {
            return;
        }
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.f60914a.getPageActivity());
            return;
        }
        this.f60915b = dressItemData.getPropsId();
        BackgroundSetRequestMessage backgroundSetRequestMessage = new BackgroundSetRequestMessage();
        backgroundSetRequestMessage.setFromDetail(z);
        backgroundSetRequestMessage.setRequestUniqueId(this.f60916c);
        backgroundSetRequestMessage.setPropId(this.f60915b);
        MessageManager.getInstance().sendMessage(backgroundSetRequestMessage);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921004));
    }
}
