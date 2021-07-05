package d.a.s0.h2.k.e.c1;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionImageActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final String f60412f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final d.a.s0.h2.k.a f60413a;

    /* renamed from: b  reason: collision with root package name */
    public final View.OnClickListener f60414b;

    /* renamed from: c  reason: collision with root package name */
    public final View.OnClickListener f60415c;

    /* renamed from: d  reason: collision with root package name */
    public final View.OnClickListener f60416d;

    /* renamed from: e  reason: collision with root package name */
    public final TbRichTextView.w f60417e;

    /* renamed from: d.a.s0.h2.k.e.c1.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1461a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f60418e;

        public View$OnClickListenerC1461a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60418e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            String str3;
            AlaInfoData alaInfoData;
            String str4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int i2 = -1;
                if (view instanceof HeadImageView) {
                    HeadImageView headImageView = (HeadImageView) view;
                    String userId = headImageView.getUserId();
                    String userName = headImageView.getUserName();
                    String fid = headImageView.getFid();
                    String tid = headImageView.getTid();
                    String fName = headImageView.getFName();
                    int floor = headImageView.getFloor();
                    alaInfoData = headImageView.getAlaInfo();
                    int liveStatus = headImageView.getLiveStatus();
                    if (alaInfoData != null && (liveStatus == 1 || alaInfoData.live_status == 1)) {
                        StatisticItem statisticItem = new StatisticItem("c13715");
                        statisticItem.param("fid", fid);
                        statisticItem.param("fname", fName);
                        AlaUserInfoData alaUserInfoData = alaInfoData.user_info;
                        str4 = userId;
                        statisticItem.param("obj_param1", alaUserInfoData != null ? alaUserInfoData.user_id : 0L);
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem.param("tid", tid);
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, floor);
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, YYLiveUtil.calculateLiveType(alaInfoData));
                        if (alaInfoData.mYyExtData != null) {
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, TiebaStatic.YYValues.YY_LIVE);
                            TiebaStaticHelper.addYYParam(statisticItem, alaInfoData.mYyExtData);
                        }
                        TiebaStatic.log(statisticItem);
                    } else {
                        str4 = userId;
                        if (!k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            StatisticItem statisticItem2 = new StatisticItem("c13267");
                            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                            statisticItem2.param("fid", fid);
                            statisticItem2.param("tid", tid);
                            statisticItem2.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                            TiebaStatic.log(statisticItem2);
                        }
                    }
                    i2 = liveStatus;
                    str3 = userName;
                    str2 = str4;
                } else {
                    if (view.getTag(R.id.tag_user_id) instanceof String) {
                        str = (String) view.getTag(R.id.tag_user_id);
                    } else {
                        str = view.getTag() instanceof String ? (String) view.getTag() : null;
                    }
                    String str5 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                    if ((view.getTag() instanceof SparseArray) && (((SparseArray) view.getTag()).get(R.id.tag_user_id) instanceof String)) {
                        str = (String) ((SparseArray) view.getTag()).get(R.id.tag_user_id);
                    }
                    str2 = str;
                    str3 = str5;
                    alaInfoData = null;
                }
                if (view.getTag(R.id.tag_statistic_item) instanceof StatisticItem) {
                    TiebaStatic.log((StatisticItem) view.getTag(R.id.tag_statistic_item));
                }
                if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                    String str6 = (String) view.getTag(R.id.tag_nick_name_activity);
                    if (!TextUtils.isEmpty(str6) && ViewHelper.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.f60418e.f60413a.getPageContext().getPageActivity(), null, str6, true)));
                        return;
                    }
                }
                String str7 = view.getTag(R.id.tag_virtual_user_url) instanceof String ? (String) view.getTag(R.id.tag_virtual_user_url) : null;
                if (str7 != null) {
                    if (ViewHelper.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        UrlManager.getInstance().dealOneLink(this.f60418e.f60413a.getPageContext(), new String[]{str7});
                    }
                } else if (str2 != null) {
                    if (alaInfoData != null && (i2 == 1 || alaInfoData.live_status == 1)) {
                        if (alaInfoData.isLegalYYLiveData()) {
                            YYLiveUtil.jumpYYLiveRoom(this.f60418e.f60413a.getPageContext(), alaInfoData);
                            TbPageContext pageContext = this.f60418e.f60413a.getPageContext();
                            YyExtData yyExtData = alaInfoData.mYyExtData;
                            String str8 = yyExtData.mSid;
                            String str9 = yyExtData.mSsid;
                            String str10 = yyExtData.mTemplateId;
                            YYLiveUtil.jumpToYYLiveRoom(pageContext, str8, str9, str10, "" + alaInfoData.roomId, YYLiveUtil.SOURCE_PB_LIVE_HEAD);
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f60418e.f60413a.getPageContext().getPageActivity(), str2, str3, this.f60418e.f60413a.getFromForumName(), AddFriendActivityConfig.TYPE_PB_HEAD)));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (view.getTag(R.id.tag_user_id) instanceof String)) {
                d.a.r0.l.a.o(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), a.f60412f + "?user_id=" + ((String) view.getTag(R.id.tag_user_id)), true, true, true);
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 2));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f60419e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60419e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                String str = view.getTag() != null ? (String) view.getTag() : null;
                if (str != null) {
                    UrlManager.getInstance().dealOneLink(this.f60419e.f60413a.getPageContext(), new String[]{str});
                }
                TiebaStatic.eventStat(this.f60419e.f60413a.getPageContext().getPageActivity(), "consume_2", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements TbRichTextView.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f60420a;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60420a = aVar;
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.w
        public void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, str, str2, str3, str4, str5, str6, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902011, new EmotionImageActivityConfig(this.f60420a.f60413a.getPageContext().getPageActivity(), str, str2, str3, str4, str5, str6, 1, i2, i3)));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-91051275, "Ld/a/s0/h2/k/e/c1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-91051275, "Ld/a/s0/h2/k/e/c1/a;");
                return;
            }
        }
        f60412f = TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    }

    public a(d.a.s0.h2.k.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f60414b = new View$OnClickListenerC1461a(this);
        this.f60415c = new b(this);
        this.f60416d = new c(this);
        this.f60417e = new d(this);
        this.f60413a = aVar;
    }
}
