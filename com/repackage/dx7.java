package com.repackage;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
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
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbCommentFloatActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dx7 {
    public static /* synthetic */ Interceptable $ic;
    public static final String f;
    public transient /* synthetic */ FieldHolder $fh;
    public final ht7 a;
    public final View.OnClickListener b;
    public final View.OnClickListener c;
    public final View.OnClickListener d;
    public final TbRichTextView.x e;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx7 a;

        public a(dx7 dx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dx7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            String str2;
            String str3;
            AlaInfoData alaInfoData;
            String str4;
            String str5;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int i = -1;
                if (view2 instanceof HeadImageView) {
                    HeadImageView headImageView = (HeadImageView) view2;
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
                        str5 = userId;
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
                        str5 = userId;
                        if (!ni.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            StatisticItem statisticItem2 = new StatisticItem("c13267");
                            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                            statisticItem2.param("fid", fid);
                            statisticItem2.param("tid", tid);
                            statisticItem2.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                            TiebaStatic.log(statisticItem2);
                        }
                    }
                    i = liveStatus;
                    str3 = userName;
                    str4 = tid;
                    str2 = str5;
                } else {
                    if (view2.getTag(R.id.obfuscated_res_0x7f091ea3) instanceof String) {
                        str = (String) view2.getTag(R.id.obfuscated_res_0x7f091ea3);
                    } else {
                        str = view2.getTag() instanceof String ? (String) view2.getTag() : null;
                    }
                    String str6 = view2.getTag(R.id.obfuscated_res_0x7f091eab) instanceof String ? (String) view2.getTag(R.id.obfuscated_res_0x7f091eab) : null;
                    str2 = ((view2.getTag() instanceof SparseArray) && (((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091ea3) instanceof String)) ? (String) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091ea3) : str;
                    str3 = str6;
                    alaInfoData = null;
                    str4 = null;
                }
                if (view2.getTag(R.id.obfuscated_res_0x7f091e9a) instanceof StatisticItem) {
                    TiebaStatic.log((StatisticItem) view2.getTag(R.id.obfuscated_res_0x7f091e9a));
                }
                if (view2.getTag(R.id.obfuscated_res_0x7f091e7c) != null && (view2.getTag(R.id.obfuscated_res_0x7f091e7c) instanceof String)) {
                    String str7 = (String) view2.getTag(R.id.obfuscated_res_0x7f091e7c);
                    if (!TextUtils.isEmpty(str7) && ViewHelper.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.a.a.getPageContext().getPageActivity(), null, str7, true)));
                        return;
                    }
                }
                String str8 = view2.getTag(R.id.obfuscated_res_0x7f091ead) instanceof String ? (String) view2.getTag(R.id.obfuscated_res_0x7f091ead) : null;
                if (str8 != null) {
                    if (!ViewHelper.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(this.a.a.getPageContext(), new String[]{str8});
                } else if (str2 != null) {
                    if (alaInfoData != null && (i == 1 || alaInfoData.live_status == 1)) {
                        if (alaInfoData.isLegalYYLiveData()) {
                            YYLiveUtil.jumpYYLiveRoom(this.a.a.getPageContext(), alaInfoData);
                            TbPageContext pageContext = this.a.a.getPageContext();
                            YyExtData yyExtData = alaInfoData.mYyExtData;
                            String str9 = yyExtData.mSid;
                            String str10 = yyExtData.mSsid;
                            String str11 = yyExtData.mTemplateId;
                            YYLiveUtil.jumpToYYLiveRoom(pageContext, str9, str10, str11, "" + alaInfoData.roomId, YYLiveUtil.SOURCE_PB_LIVE_HEAD);
                        }
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.a.getPageContext().getPageActivity(), str2, str3, this.a.a.getFromForumName(), AddFriendActivityConfig.TYPE_PB_HEAD, str4, null)));
                    }
                }
                if (this.a.a instanceof PbCommentFloatActivity) {
                    StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                    statisticItem3.param("fid", ((PbCommentFloatActivity) this.a.a).getPbModel().getForumId());
                    statisticItem3.param("tid", ((PbCommentFloatActivity) this.a.a).getPbModel().l1());
                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem3.param("post_id", ((PbCommentFloatActivity) this.a.a).getPbModel().r0());
                    statisticItem3.param("obj_source", 1);
                    statisticItem3.param("obj_type", 6);
                    statisticItem3.param("obj_locate", ((PbCommentFloatActivity) this.a.a).getFromVideoPageType());
                    TiebaStatic.log(statisticItem3);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(dx7 dx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (view2.getTag(R.id.obfuscated_res_0x7f091ea3) instanceof String)) {
                vl4.q(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f14ad), dx7.f + "?user_id=" + ((String) view2.getTag(R.id.obfuscated_res_0x7f091ea3)) + "&opacity=0", true, true, true);
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 2));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx7 a;

        public c(dx7 dx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dx7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && ViewHelper.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                String str = view2.getTag() != null ? (String) view2.getTag() : null;
                if (str != null) {
                    UrlManager.getInstance().dealOneLink(this.a.a.getPageContext(), new String[]{str});
                }
                TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements TbRichTextView.x {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx7 a;

        public d(dx7 dx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dx7Var;
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.x
        public void a(View view2, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, str2, str3, str4, str5, str6, Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902011, new EmotionImageActivityConfig(this.a.a.getPageContext().getPageActivity(), str, str2, str3, str4, str5, str6, 1, i, i2)));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755751954, "Lcom/repackage/dx7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755751954, "Lcom/repackage/dx7;");
                return;
            }
        }
        f = TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    }

    public dx7(ht7 ht7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ht7Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new a(this);
        this.c = new b(this);
        this.d = new c(this);
        this.e = new d(this);
        this.a = ht7Var;
    }
}
