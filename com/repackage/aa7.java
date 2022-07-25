package com.repackage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AgreeMeActivityConfig;
import com.baidu.tbadk.core.atomData.AtMeActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.OfficialBarFeedActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.ReplyMeActivityConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.im.model.IMUserListHttpResponseMsg;
import com.baidu.tieba.im.model.IMUserListModel;
import com.baidu.tieba.imMessageCenter.StrangerListActivityConfig;
import com.baidu.tieba.imMessageCenter.im.chat.notify.MessageAggregationListAdapter;
import com.baidu.tieba.imMessageCenter.im.model.IMOfficialMaskModel;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
import com.baidu.tieba.imMessageCenter.im.view.ShutDownValidateTipView;
import com.baidu.tieba.imMessageCenter.mention.ChatAggregationFragment;
import com.baidu.tieba.imMessageCenter.recforum.model.MsgRecForumHttpResMessage;
import com.baidu.tieba.imMessageCenter.recforum.model.MsgRecForumNetMessage;
import com.baidu.tieba.imMessageCenter.recforum.model.MsgRecForumSocketResMessage;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.gu4;
import com.repackage.or4;
import com.repackage.va7;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.Page;
import tbclient.RecommendForumInfo;
/* loaded from: classes5.dex */
public class aa7 extends b9<ChatAggregationFragment> implements gu4.g, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView A;
    public TextView B;
    public MessageRedDotView C;
    public View D;
    public ImageView E;
    public TextView F;
    public MessageRedDotView G;
    public View H;
    public ImageView I;
    public TextView J;
    public MessageRedDotView K;
    public View L;
    public gr4 M;
    public int N;
    public int O;
    public boolean P;
    public boolean Q;
    public va7 R;
    public boolean S;
    public boolean T;
    public boolean U;
    public IMOfficialMaskModel V;
    public IMUserListModel W;
    public AbsListView.OnScrollListener X;
    public final gu4.g Y;
    public CustomMessageListener Z;
    public final ChatAggregationFragment a;
    public za a0;
    public ImMessageCenterModel b;
    public CustomMessageListener b0;
    public ImMessageCenterShowItemData c;
    public va7.b c0;
    public BdSwipeRefreshLayout d;
    public final AdapterView.OnItemClickListener d0;
    public hu4 e;
    public final AdapterView.OnItemLongClickListener e0;
    public BdListView f;
    public final CustomMessageListener f0;
    public NavigationBarShadowView g;
    public t47 g0;
    public MessageAggregationListAdapter h;
    public final CustomMessageListener h0;
    public ShutDownValidateTipView i;
    public final u47 i0;
    public mr4 j;
    public final CustomMessageListener j0;
    public or4.e k;
    public NoDataView l;
    public boolean m;
    public RelativeLayout n;
    public View o;
    public boolean p;
    public boolean q;
    public HttpMessageListener q0;
    public boolean r;
    public int s;
    public View t;
    public View u;
    public View v;
    public ImageView w;
    public TextView x;
    public MessageRedDotView y;
    public View z;

    /* loaded from: classes5.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa7 a;

        public a(aa7 aa7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa7Var;
        }

        public final void a(ImMessageCenterShowItemData imMessageCenterShowItemData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, imMessageCenterShowItemData) == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_ITEM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", "1").param("obj_param1", imMessageCenterShowItemData.getUnReadCount()).param(TiebaStatic.Params.FRIEND_UID, imMessageCenterShowItemData.getFriendId()));
                if (imMessageCenterShowItemData.getUnReadCount() > 0) {
                    oy4.f0().a0(oy4.f0().w() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(this.a.a.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0, imMessageCenterShowItemData.getRelation() == 1 ? 1 : 0);
                    personalChatActivityConfig.setFrom(3);
                    if (this.a.mContext != null && this.a.mContext.getUniqueId() != null) {
                        personalChatActivityConfig.setLastUniqueId(this.a.mContext.getUniqueId().getId());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || i < 0) {
                return;
            }
            ImMessageCenterShowItemData item = this.a.h.getItem(i);
            if (item == null || item.getDataType() != 2) {
                TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                StatisticItem statisticItem = new StatisticItem("c13720");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                String ownerName = item.getOwnerName();
                if (TextUtils.isEmpty(ownerName)) {
                    a(item);
                    statisticItem.param("obj_type", 6);
                } else if (ownerName.equals("1")) {
                    if (!l97.b(this.a.a.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                        return;
                    }
                    TiebaStatic.eventStat(this.a.a.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.a.a.getPageContext().getPageActivity(), ng.g(item.getFriendId(), 0L), item.getFriendName(), 0L, "msg_lstb")));
                } else if (ownerName.equals("5")) {
                    TiebaStatic.log("c12931");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialBarFeedActivityConfig(this.a.a.getPageContext().getPageActivity())));
                } else if (ownerName.equals("8")) {
                    if (!l97.a(this.a.a.getPageContext().getOrignalPage(), 2002006)) {
                        return;
                    }
                    long g = ng.g(item.getFriendId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(this.a.a.getPageContext().getPageActivity(), g, item.getFriendNameShow(), item.getFriendPortrait(), 0, item.getUserType())));
                    if ("801001117".equals(String.valueOf(g))) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SITE_SERVICE_ENTRANCE).param("uid", TbadkCoreApplication.getCurrentAccount()));
                    } else if ("3222425470".equals(String.valueOf(g))) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SYSTEM_SERVICE).param("uid", TbadkCoreApplication.getCurrentAccount()));
                    }
                } else if (ownerName.equals("7")) {
                    TiebaStatic.log(new StatisticItem("c12614"));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(this.a.a.getPageContext().getPageActivity())));
                    statisticItem.param("obj_type", 6);
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_ITEM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", "2").param("obj_param1", item.getUnReadCount()).param(TiebaStatic.Params.FRIEND_UID, item.getFriendId()));
                    return;
                } else {
                    a(item);
                    statisticItem.param("obj_type", 6);
                }
                if (!TextUtils.isEmpty(item.getFriendName())) {
                    if ("贴吧热榜".equals(item.getFriendName())) {
                        statisticItem.param("obj_type", 8);
                    } else if ("贴吧荣誉墙".equals(item.getFriendName())) {
                        statisticItem.param("obj_type", 9);
                    } else if ("贴吧精选".equals(item.getFriendName())) {
                        statisticItem.param("obj_type", 10);
                    } else if ("贴吧活动".equals(item.getFriendName())) {
                        statisticItem.param("obj_type", 4);
                    } else if ("吧广播".equals(item.getFriendName())) {
                        statisticItem.param("obj_type", 5);
                    }
                }
                TiebaStatic.log(statisticItem);
                if (TextUtils.isEmpty(item.getFriendName()) || !this.a.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f13af).equals(item.getFriendName())) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c14446").param("uid", TbadkCoreApplication.getCurrentAccount()));
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.mContext.getPageActivity()).createNormalCfg(item.getForumName(), FrsActivityConfig.FRS_FROM_IM_REC_FORUM)));
            StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.IM_REC_FORUM_ITEM_CLICK);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem2.param("fid", item.getForumId());
            statisticItem2.param("fname", item.getForumName());
            TiebaStatic.log(statisticItem2);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements AdapterView.OnItemLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa7 a;

        public b(aa7 aa7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa7Var;
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)})) == null) {
                aa7 aa7Var = this.a;
                aa7Var.c = aa7Var.h.getItem(i);
                if (this.a.c == null || this.a.c.getDataType() != 2) {
                    aa7 aa7Var2 = this.a;
                    if (aa7Var2.g0(aa7Var2.c)) {
                        if (this.a.j != null) {
                            TiebaStatic.log("c12932");
                            this.a.j.m();
                            if (this.a.a != null && this.a.a.getActivity() != null) {
                                long uptimeMillis = SystemClock.uptimeMillis();
                                this.a.a.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                            }
                        }
                        return true;
                    }
                    adapterView.setHapticFeedbackEnabled(false);
                    return true;
                }
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public c(aa7 aa7Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa7Var, alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (alertDialog = this.a) == null) {
                return;
            }
            alertDialog.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ ImMessageCenterShowItemData b;
        public final /* synthetic */ aa7 c;

        public d(aa7 aa7Var, AlertDialog alertDialog, ImMessageCenterShowItemData imMessageCenterShowItemData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa7Var, alertDialog, imMessageCenterShowItemData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = aa7Var;
            this.a = alertDialog;
            this.b = imMessageCenterShowItemData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                AlertDialog alertDialog = this.a;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                StatisticItem statisticItem = new StatisticItem("c14670");
                statisticItem.param("obj_type", m97.a(this.b) ? 1 : 2);
                TiebaStatic.log(statisticItem);
                this.c.b.asyncDeleteItem(this.b, this.c.i0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements or4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ImMessageCenterShowItemData b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ aa7 g;

        public e(aa7 aa7Var, String str, ImMessageCenterShowItemData imMessageCenterShowItemData, String str2, String str3, String str4, String str5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa7Var, str, imMessageCenterShowItemData, str2, str3, str4, str5};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = aa7Var;
            this.a = str;
            this.b = imMessageCenterShowItemData;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = str5;
        }

        @Override // com.repackage.or4.e
        public void N(or4 or4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, or4Var, i, view2) == null) {
                if (this.g.j != null && this.g.j.isShowing() && this.g.a != null) {
                    this.g.j.dismiss();
                }
                String charSequence = ((EMTextView) view2).getText().toString();
                if (this.a.equals(charSequence)) {
                    TiebaStatic.log("c12933");
                    StatisticItem statisticItem = new StatisticItem("c14665");
                    statisticItem.param("obj_type", m97.a(this.b) ? 1 : 2);
                    TiebaStatic.log(statisticItem);
                    this.g.F0(this.b);
                } else if (this.c.equals(charSequence)) {
                    StatisticItem statisticItem2 = new StatisticItem("c14664");
                    statisticItem2.param("obj_type", 1);
                    TiebaStatic.log(statisticItem2);
                    b97.c(this.b.getFriendId(), true);
                } else if (this.d.equals(charSequence)) {
                    StatisticItem statisticItem3 = new StatisticItem("c14664");
                    statisticItem3.param("obj_type", 2);
                    TiebaStatic.log(statisticItem3);
                    b97.c(this.b.getFriendId(), false);
                } else if (this.e.equals(charSequence)) {
                    if (this.g.V != null) {
                        StatisticItem statisticItem4 = new StatisticItem("c14669");
                        statisticItem4.param("obj_type", 1);
                        TiebaStatic.log(statisticItem4);
                        this.g.V.A(true, this.b.getFriendId());
                    }
                } else if (!this.f.equals(charSequence) || this.g.V == null) {
                } else {
                    StatisticItem statisticItem5 = new StatisticItem("c14669");
                    statisticItem5.param("obj_type", 2);
                    TiebaStatic.log(statisticItem5);
                    this.g.V.A(false, this.b.getFriendId());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(aa7 aa7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2016002) {
                this.a.i0(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016004) {
                this.a.h0(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016007) {
                this.a.k0(customResponsedMessage);
                this.a.z0(false);
                this.a.u0();
            } else if (customResponsedMessage.getCmd() == 2016001) {
                this.a.b.setData(null, this.a.g0);
            } else if (customResponsedMessage.getCmd() == 2016010) {
                if (this.a.h != null) {
                    this.a.h.notifyDataSetChanged();
                }
            } else if (customResponsedMessage.getCmd() != 2016011 || this.a.h == null) {
            } else {
                this.a.h.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements t47 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa7 a;

        public g(aa7 aa7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa7Var;
        }

        @Override // com.repackage.t47
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.Y();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa7 a;

        public h(aa7 aa7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f.F();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(aa7 aa7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                this.a.j0(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements u47 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa7 a;

        public j(aa7 aa7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa7Var;
        }

        @Override // com.repackage.u47
        public void onCanceled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.P();
            }
        }

        @Override // com.repackage.u47
        public void onPostExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.P();
                this.a.a.showToast(R.string.obfuscated_res_0x7f0f04ac, false);
                this.a.Y();
            }
        }

        @Override // com.repackage.u47
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.H0();
            }
        }

        @Override // com.repackage.u47
        public void onProgressUpdate(int i, String str, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) || this.a.M == null) {
                return;
            }
            this.a.M.b(i);
        }
    }

    /* loaded from: classes5.dex */
    public class k implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa7 a;

        public k(aa7 aa7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa7Var;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) && i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                this.a.g.a();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) {
                if (i != 0) {
                    if (i == 1 || i == 2) {
                        this.a.g.c();
                        return;
                    }
                    return;
                }
                View childAt = absListView.getChildAt(0);
                if (childAt == null || childAt.getTop() != 0) {
                    return;
                }
                this.a.g.a();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(aa7 aa7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage)) {
                this.a.a0((NewsNotifyMessage) customResponsedMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(aa7 aa7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            HashMap<String, ImMessageCenterPojo> hashMap;
            ImMessageCenterPojo imMessageCenterPojo;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof IMUserListHttpResponseMsg)) {
                IMUserListHttpResponseMsg iMUserListHttpResponseMsg = (IMUserListHttpResponseMsg) httpResponsedMessage;
                if (this.a.b == null || ListUtils.isEmpty(this.a.b.getData()) || (hashMap = iMUserListHttpResponseMsg.changedList) == null || hashMap.isEmpty()) {
                    return;
                }
                for (ImMessageCenterShowItemData imMessageCenterShowItemData : this.a.b.getData()) {
                    if (imMessageCenterShowItemData != null && iMUserListHttpResponseMsg.changedList.containsKey(imMessageCenterShowItemData.getFriendId()) && (imMessageCenterPojo = iMUserListHttpResponseMsg.changedList.get(imMessageCenterShowItemData.getFriendId())) != null) {
                        imMessageCenterShowItemData.setFriendNameShow(imMessageCenterPojo.getNameShow());
                        imMessageCenterShowItemData.setRelation(imMessageCenterPojo.getIsFriend());
                        imMessageCenterShowItemData.setUserExtraData(imMessageCenterPojo.getImUserExtraData());
                    }
                }
                this.a.Y();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements gu4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa7 a;

        public n(aa7 aa7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa7Var;
        }

        @Override // com.repackage.gu4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!ni.z()) {
                    if (this.a.d != null) {
                        this.a.d.setRefreshing(false);
                        return;
                    }
                    return;
                }
                this.a.z0(true);
                this.a.l0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(aa7 aa7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001371 || this.a.U) {
                return;
            }
            this.a.w0();
            this.a.Y();
        }
    }

    /* loaded from: classes5.dex */
    public class p extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(aa7 aa7Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa7Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa7Var;
        }

        @Override // com.repackage.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z = responsedMessage instanceof MsgRecForumHttpResMessage;
                if (z || (responsedMessage instanceof MsgRecForumSocketResMessage)) {
                    if (responsedMessage.getError() != 0) {
                        if (this.a.Q || this.a.a == null || responsedMessage.getError() == -100000303) {
                            return;
                        }
                        this.a.a.showToast(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0c17));
                        this.a.Q = true;
                        return;
                    }
                    List<RecommendForumInfo> list = null;
                    if (z) {
                        MsgRecForumHttpResMessage msgRecForumHttpResMessage = (MsgRecForumHttpResMessage) responsedMessage;
                        list = msgRecForumHttpResMessage.forumList;
                        Page page = msgRecForumHttpResMessage.pageInfo;
                    } else if (responsedMessage instanceof MsgRecForumSocketResMessage) {
                        MsgRecForumSocketResMessage msgRecForumSocketResMessage = (MsgRecForumSocketResMessage) responsedMessage;
                        list = msgRecForumSocketResMessage.forumList;
                        Page page2 = msgRecForumSocketResMessage.pageInfo;
                    }
                    this.a.C0(list);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(aa7 aa7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921691) {
                this.a.b.queryMarkTopStatus((String) customResponsedMessage.getData());
                this.a.b.sortList();
                this.a.h.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa7 a;

        public r(aa7 aa7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                yt4.k().u("is_shut_down_validate", true);
                this.a.D0(false);
                this.a.E0(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s implements va7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa7 a;

        public s(aa7 aa7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa7Var;
        }

        @Override // com.repackage.va7.b
        public void onClose() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.R == null) {
                return;
            }
            this.a.f.removeHeaderView(this.a.R.e());
            this.a.S = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa7(ChatAggregationFragment chatAggregationFragment) {
        super((TbPageContext) h9.a(chatAggregationFragment.getPageContext().getPageActivity()));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {chatAggregationFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = null;
        this.f = null;
        this.h = null;
        this.j = null;
        this.m = true;
        this.p = false;
        this.q = false;
        this.r = true;
        this.s = 16;
        this.P = true;
        this.Q = false;
        this.S = false;
        this.T = false;
        this.U = false;
        this.X = new k(this);
        this.Y = new n(this);
        this.Z = new o(this, 2001371);
        this.a0 = new p(this, CmdConfigHttp.CMD_HTTP_GET_MSG_REC_FORUM_LIST, 309712);
        this.b0 = new q(this, 2921691);
        this.c0 = new s(this);
        this.d0 = new a(this);
        this.e0 = new b(this);
        this.f0 = new f(this, 0);
        this.g0 = new g(this);
        this.h0 = new i(this, 2001120);
        this.i0 = new j(this);
        this.j0 = new l(this, 2001120);
        this.q0 = new m(this, CmdConfigHttp.CMD_GET_USER_LIST);
        this.a = chatAggregationFragment;
    }

    public void A0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.q = z;
        }
    }

    public final void C0(List<RecommendForumInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ImMessageCenterShowItemData imMessageCenterShowItemData = new ImMessageCenterShowItemData();
        imMessageCenterShowItemData.setDataType(1);
        arrayList.add(imMessageCenterShowItemData);
        ImMessageCenterShowItemData imMessageCenterShowItemData2 = new ImMessageCenterShowItemData();
        imMessageCenterShowItemData2.setDataType(3);
        arrayList.add(imMessageCenterShowItemData2);
        for (RecommendForumInfo recommendForumInfo : list) {
            if (recommendForumInfo != null && !StringUtils.isNull(recommendForumInfo.forum_name)) {
                ImMessageCenterShowItemData imMessageCenterShowItemData3 = new ImMessageCenterShowItemData();
                imMessageCenterShowItemData3.setDataType(2);
                imMessageCenterShowItemData3.setAvatar(recommendForumInfo.avatar);
                imMessageCenterShowItemData3.setForumId(recommendForumInfo.forum_id.longValue());
                imMessageCenterShowItemData3.setForumName(recommendForumInfo.forum_name);
                imMessageCenterShowItemData3.setIsLike(recommendForumInfo.is_like.intValue());
                imMessageCenterShowItemData3.setMemberCount(recommendForumInfo.member_count.intValue());
                imMessageCenterShowItemData3.setSlogan(recommendForumInfo.slogan);
                imMessageCenterShowItemData3.setThreadCount(recommendForumInfo.thread_count.intValue());
                arrayList.add(imMessageCenterShowItemData3);
            }
        }
        ImMessageCenterShowItemData imMessageCenterShowItemData4 = new ImMessageCenterShowItemData();
        imMessageCenterShowItemData4.setDataType(4);
        arrayList.add(imMessageCenterShowItemData4);
        if (this.h.getCount() == 0) {
            this.h.r(arrayList);
        }
    }

    public void D0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.m = z;
        }
    }

    public void E0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                if (!T() || this.i.getVisibility() == 0) {
                    return;
                }
                this.i.setVisibility(0);
            } else if (this.i.getVisibility() != 8) {
                this.i.setVisibility(8);
            }
        }
    }

    public void F0(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, imMessageCenterShowItemData) == null) || TbadkCoreApplication.getInst().getCurrentActivity() == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f1463, TBAlertConfig.OperateBtnStyle.ALERT);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f1462, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(TbadkCoreApplication.getInst().getCurrentActivity());
        tBAlertBuilder.t(R.string.obfuscated_res_0x7f0f13e1);
        tBAlertBuilder.l(R.string.obfuscated_res_0x7f0f11e7);
        tBAlertBuilder.n(true);
        tBAlertBuilder.r(aVar2, aVar);
        tBAlertBuilder.i(false);
        AlertDialog w = tBAlertBuilder.w();
        aVar2.a(new c(this, w));
        aVar.a(new d(this, w, imMessageCenterShowItemData));
    }

    public void G0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && z) {
            t0();
        }
    }

    public final void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            P();
            if (this.M == null) {
                this.M = w57.m().p(getPageContext().getPageActivity());
            }
            this.M.show();
            this.M.b(0);
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f == null) {
            return;
        }
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.mContext.getPageActivity()).areNotificationsEnabled();
        StatisticItem statisticItem = new StatisticItem("c13616");
        statisticItem.param("obj_type", areNotificationsEnabled ? 1 : 2);
        TiebaStatic.log(statisticItem);
        if (areNotificationsEnabled) {
            va7 va7Var = this.R;
            if (va7Var != null) {
                this.f.removeHeaderView(va7Var.e());
                this.S = false;
                return;
            }
            return;
        }
        long m2 = yt4.k().m("key_im_open_notification_close_time", 0L);
        if (this.S) {
            return;
        }
        if (m2 == 0 || System.currentTimeMillis() - m2 > 604800000) {
            if (this.R == null) {
                va7 va7Var2 = new va7(this.mContext);
                this.R = va7Var2;
                va7Var2.g(this.c0);
            }
            this.f.x(this.R.e(), 0);
            this.S = true;
        }
    }

    public final void P() {
        gr4 gr4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (gr4Var = this.M) != null && gr4Var.isShowing()) {
            this.M.dismiss();
            this.M = null;
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.b = new ImMessageCenterModel();
            D0(!yt4.k().h("is_shut_down_validate", false));
            this.V = new IMOfficialMaskModel();
            this.W = new IMUserListModel(this.a.getPageContext(), this.a.getUniqueId());
        }
    }

    public final void R(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view2) == null) {
            this.n = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0905d8);
            ShutDownValidateTipView shutDownValidateTipView = (ShutDownValidateTipView) view2.findViewById(R.id.obfuscated_res_0x7f09243d);
            this.i = shutDownValidateTipView;
            shutDownValidateTipView.setVisibility(8);
            this.i.setShutDownClickListener(new r(this));
            this.g = (NavigationBarShadowView) view2.findViewById(R.id.obfuscated_res_0x7f091553);
            BdListView bdListView = (BdListView) view2.findViewById(R.id.obfuscated_res_0x7f0905d9);
            this.f = bdListView;
            bdListView.setDividerHeight(0);
            MessageAggregationListAdapter messageAggregationListAdapter = new MessageAggregationListAdapter(this.a.getPageContext().getPageActivity());
            this.h = messageAggregationListAdapter;
            messageAggregationListAdapter.T(this.a.getPageContext());
            this.h.Q(this);
            this.f.setAdapter((ListAdapter) this.h);
            this.f.setOnItemClickListener(this.d0);
            this.f.setOnItemLongClickListener(this.e0);
            this.f.setOnScrollListener(this.X);
            View inflate = View.inflate(this.mContext.getPageActivity(), R.layout.obfuscated_res_0x7f0d055d, null);
            this.u = inflate;
            this.v = inflate.findViewById(R.id.obfuscated_res_0x7f0902b4);
            this.w = (ImageView) this.u.findViewById(R.id.obfuscated_res_0x7f0902b3);
            this.x = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f0902b7);
            this.y = (MessageRedDotView) this.u.findViewById(R.id.obfuscated_res_0x7f0902b5);
            this.z = this.u.findViewById(R.id.obfuscated_res_0x7f090150);
            this.A = (ImageView) this.u.findViewById(R.id.obfuscated_res_0x7f09014f);
            this.B = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f090154);
            this.C = (MessageRedDotView) this.u.findViewById(R.id.obfuscated_res_0x7f090151);
            this.D = this.u.findViewById(R.id.obfuscated_res_0x7f091acb);
            this.E = (ImageView) this.u.findViewById(R.id.obfuscated_res_0x7f091aca);
            this.F = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f091ace);
            this.G = (MessageRedDotView) this.u.findViewById(R.id.obfuscated_res_0x7f091acc);
            this.H = this.u.findViewById(R.id.obfuscated_res_0x7f09094a);
            this.I = (ImageView) this.u.findViewById(R.id.obfuscated_res_0x7f090949);
            this.J = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f09094e);
            this.K = (MessageRedDotView) this.u.findViewById(R.id.obfuscated_res_0x7f09094b);
            this.L = this.u.findViewById(R.id.obfuscated_res_0x7f091d1e);
            this.y.setThreeDotMode(2);
            this.C.setThreeDotMode(2);
            this.G.setThreeDotMode(2);
            this.K.setThreeDotMode(2);
            this.y.setShadowEnabled(false);
            this.C.setShadowEnabled(false);
            this.G.setShadowEnabled(false);
            this.v.setOnClickListener(this);
            this.z.setOnClickListener(this);
            this.D.setOnClickListener(this);
            this.H.setOnClickListener(this);
            this.f.addHeaderView(this.u);
            O();
            this.d = (BdSwipeRefreshLayout) view2.findViewById(R.id.obfuscated_res_0x7f091acd);
            if (this.e == null) {
                hu4 hu4Var = new hu4(this.a.getPageContext());
                this.e = hu4Var;
                hu4Var.f(this.Y);
            }
            this.e.b0(getPageContext().getUniqueId());
            this.d.setProgressView(this.e);
            this.t = new View(this.a.getFragmentActivity());
            this.t.setLayoutParams(new AbsListView.LayoutParams(-1, pi.f(this.a.getFragmentActivity(), R.dimen.obfuscated_res_0x7f07024d)));
            this.f.addFooterView(this.t);
        }
    }

    public final boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? TbadkCoreApplication.isLogin() : invokeV.booleanValue;
    }

    public boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public void U(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) || bundle == null) {
            return;
        }
        this.s = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.s);
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f0);
            MessageManager.getInstance().unRegisterListener(this.h0);
            MessageManager.getInstance().unRegisterListener(this.j0);
            if (this.U) {
                MessageManager.getInstance().unRegisterListener(this.a0);
                MessageManager.getInstance().unRegisterTask(309712);
                MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_HTTP_GET_MSG_REC_FORUM_LIST);
            }
            MessageManager.getInstance().unRegisterListener(this.Z);
            MessageManager.getInstance().unRegisterListener(this.b0);
            MessageManager.getInstance().unRegisterListener(this.q0);
        }
    }

    public void W() {
        MessageAggregationListAdapter messageAggregationListAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (messageAggregationListAdapter = this.h) == null) {
            return;
        }
        messageAggregationListAdapter.notifyDataSetChanged();
    }

    public boolean X(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, tbPageContext, i2)) == null) {
            NoDataView noDataView = this.l;
            if (noDataView != null) {
                noDataView.f(this.a.getPageContext(), i2);
            }
            ShutDownValidateTipView shutDownValidateTipView = this.i;
            if (shutDownValidateTipView != null) {
                shutDownValidateTipView.b(i2);
            }
            MessageAggregationListAdapter messageAggregationListAdapter = this.h;
            if (messageAggregationListAdapter != null) {
                messageAggregationListAdapter.notifyDataSetChanged();
            }
            if (tbPageContext != null) {
                tbPageContext.getLayoutMode().j(this.n);
            }
            hu4 hu4Var = this.e;
            if (hu4Var != null) {
                hu4Var.H(i2);
            }
            SkinManager.setBackgroundColor(this.n, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.x, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.B, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.F, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.J, (int) R.color.CAM_X0105);
            WebPManager.setMaskDrawable(this.w, R.drawable.obfuscated_res_0x7f0807d6, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setMaskDrawable(this.A, R.drawable.obfuscated_res_0x7f0807d8, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setMaskDrawable(this.E, R.drawable.obfuscated_res_0x7f0807d9, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setMaskDrawable(this.I, R.drawable.obfuscated_res_0x7f0807d7, WebPManager.ResourceStateType.NORMAL_PRESS);
            SkinManager.setBackgroundColor(this.L, R.color.CAM_X0203);
            MessageRedDotView messageRedDotView = this.y;
            if (messageRedDotView != null) {
                messageRedDotView.e();
            }
            MessageRedDotView messageRedDotView2 = this.C;
            if (messageRedDotView2 != null) {
                messageRedDotView2.e();
            }
            MessageRedDotView messageRedDotView3 = this.G;
            if (messageRedDotView3 != null) {
                messageRedDotView3.e();
            }
            MessageRedDotView messageRedDotView4 = this.K;
            if (messageRedDotView4 != null) {
                messageRedDotView4.e();
            }
            va7 va7Var = this.R;
            if (va7Var != null) {
                va7Var.f(i2);
                return true;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public final void Y() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (bdListView = this.f) == null || this.b == null) {
            return;
        }
        bdListView.A(0L);
        if (this.b.getData() != null && this.b.getData().size() > 0) {
            this.h.r(this.b.getData());
            if (this.T) {
                return;
            }
            this.T = true;
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.IM_TAB_SHOW_KEY);
            statisticItem.param("obj_param1", "0").param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            return;
        }
        MsgRecForumNetMessage msgRecForumNetMessage = new MsgRecForumNetMessage();
        msgRecForumNetMessage.mPn = 1;
        msgRecForumNetMessage.mRn = 15;
        msgRecForumNetMessage.userId = Long.valueOf(TbadkCoreApplication.getCurrentAccountId());
        this.a.sendMessage(msgRecForumNetMessage);
        if (this.T) {
            return;
        }
        this.T = true;
        StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.IM_TAB_SHOW_KEY);
        statisticItem2.param("obj_param1", "1").param("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(statisticItem2);
    }

    public View Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            this.o = LayoutInflater.from(getActivity()).inflate(R.layout.obfuscated_res_0x7f0d01ce, (ViewGroup) null, false);
            Q();
            R(this.o);
            TiebaStatic.eventStat(getActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
            if (!this.U) {
                w0();
            }
            v0();
            f0();
            return this.o;
        }
        return (View) invokeV.objValue;
    }

    public void a0(NewsNotifyMessage newsNotifyMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, newsNotifyMessage) == null) || newsNotifyMessage == null) {
            return;
        }
        this.N = newsNotifyMessage.getMsgAtme();
        this.O = newsNotifyMessage.getMsgAgree();
        o0(this.N);
        n0(this.O);
        q0(newsNotifyMessage.getMsgFans());
        s0(newsNotifyMessage.getMsgReplyme());
    }

    public void b0(boolean z) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || !z || (bdListView = this.f) == null || bdListView.getWrappedAdapter() == null || this.f.getWrappedAdapter().getCount() > 0) {
            return;
        }
        qg.a().post(new h(this));
    }

    public void d0(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, intent) == null) || intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
        this.s = intExtra;
        if (intExtra == -1) {
            return;
        }
        A0(true);
        e0();
    }

    @Override // com.repackage.gu4.g
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            MessageAggregationListAdapter messageAggregationListAdapter = this.h;
            if (messageAggregationListAdapter != null && messageAggregationListAdapter.getCount() == 0) {
                A0(true);
            }
            if (this.r || this.q) {
                this.r = false;
                this.q = false;
                l0();
            }
            boolean S = S();
            if (this.p != S) {
                this.p = S;
            }
            NoDataView noDataView = this.l;
            if (noDataView != null) {
                noDataView.d(this.a.getPageContext());
            }
            O();
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.f.F();
            this.p = S();
        }
    }

    public final boolean g0(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, imMessageCenterShowItemData)) == null) {
            String string = this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f04b7);
            String string2 = this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f13f4);
            String string3 = this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0376);
            String string4 = this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f089e);
            String string5 = this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f089f);
            String str2 = imMessageCenterShowItemData.getMarkTopIndex() > 0 ? string3 : string2;
            if (imMessageCenterShowItemData.getGroupSetting() != null) {
                str = imMessageCenterShowItemData.getGroupSetting().isAcceptNotify() ? string4 : string5;
            } else {
                str = string4;
            }
            e eVar = new e(this, string, imMessageCenterShowItemData, string2, string3, string4, string5);
            ArrayList arrayList = new ArrayList(5);
            if (m97.a(imMessageCenterShowItemData)) {
                arrayList.add(str2);
                arrayList.add(string);
            } else if (!m97.b(imMessageCenterShowItemData)) {
                return false;
            } else {
                arrayList.add(str);
                arrayList.add(string);
            }
            this.k = eVar;
            this.j = new mr4(this.a.getPageContext());
            this.j.j(null, (String[]) arrayList.toArray(new String[arrayList.size()]), this.k);
            return true;
        }
        return invokeL.booleanValue;
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.a.getPageContext().getPageActivity() : (Activity) invokeV.objValue;
    }

    public final void h0(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterModel imMessageCenterModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryChangedMessage)) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (memoryChangedMessage.getType() == 1) {
                ImMessageCenterModel imMessageCenterModel2 = this.b;
                if (imMessageCenterModel2 != null) {
                    imMessageCenterModel2.insertOrUpdate(data, this.g0);
                }
            } else if (memoryChangedMessage.getType() != 2 || (imMessageCenterModel = this.b) == null) {
            } else {
                imMessageCenterModel.remove(data, this.g0);
            }
        }
    }

    public final void i0(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048604, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        }
    }

    public final void j0(ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, responsedMessage) == null) || responsedMessage == null) {
            return;
        }
        if (!(responsedMessage instanceof NewsNotifyMessage)) {
            BdLog.e("transform error");
        } else {
            p0();
        }
    }

    public final void k0(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterModel imMessageCenterModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048606, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ResponsedMemoryListMessage)) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() != 1 || (imMessageCenterModel = this.b) == null) {
                return;
            }
            imMessageCenterModel.setData(data, this.g0);
        }
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        }
    }

    public final void n0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            if (i2 > 0) {
                if (qy4.d().f() == 0) {
                    i2 = 0;
                }
                this.C.setThreeDotMode(2);
                this.C.f(i2);
                this.C.setVisibility(0);
                return;
            }
            this.C.setVisibility(8);
        }
    }

    public final void o0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            if (i2 > 0) {
                if (qy4.d().f() == 0) {
                    i2 = 0;
                }
                this.y.setThreeDotMode(2);
                this.y.f(i2);
                this.y.setVisibility(0);
                return;
            }
            this.y.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, view2) == null) {
            StatisticItem statisticItem = new StatisticItem("c13720");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (view2 == this.v) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_AT_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", this.N > 0 ? 1 : 2).param("obj_param1", this.N));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtMeActivityConfig(getPageContext().getPageActivity())));
                oy4.f0().j();
                oy4.f0().Y(0);
                this.N = 0;
                o0(0);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
                statisticItem.param("obj_type", 1);
            } else if (view2 == this.z) {
                TiebaStatic.log(new StatisticItem("c12926").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", this.O > 0 ? 1 : 2).param("obj_param1", this.O));
                StatisticItem statisticItem2 = new StatisticItem("c12926");
                MessageRedDotView messageRedDotView = this.C;
                if (messageRedDotView != null && messageRedDotView.getVisibility() == 0) {
                    statisticItem2.addParam("obj_type", 1);
                } else {
                    statisticItem2.addParam("obj_type", 2);
                }
                statisticItem2.eventStat();
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AgreeMeActivityConfig(getPageContext().getPageActivity())));
                oy4.f0().h();
                oy4.f0().X(0);
                this.O = 0;
                n0(0);
                statisticItem.param("obj_type", 2);
            } else if (view2 == this.D) {
                int z = oy4.f0().z();
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_REPLY_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", z > 0 ? 1 : 2).param("obj_param1", z));
                ReplyMeActivityConfig replyMeActivityConfig = new ReplyMeActivityConfig(getPageContext().getPageActivity());
                replyMeActivityConfig.setFrom(1);
                d9<T> d9Var = this.mContext;
                if (d9Var != 0 && d9Var.getUniqueId() != null) {
                    replyMeActivityConfig.setLastUniqueId(this.mContext.getUniqueId().getId());
                }
                replyMeActivityConfig.setReplyNumber(z);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, replyMeActivityConfig));
                oy4.f0().o();
                oy4.f0().d0(0);
                s0(0);
            } else if (view2 == this.H) {
                int x = oy4.f0().x();
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_FANS_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", x > 0 ? 1 : 2).param("obj_param1", x));
                PersonRedTipManager.getInstance().updateRedTipState(2, false, true);
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 6));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.mContext.getPageActivity(), false, TbadkCoreApplication.getCurrentAccount(), 0)));
                oy4.f0().l();
                oy4.f0().b0(0);
                q0(0);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void p0() {
        MessageAggregationListAdapter messageAggregationListAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || (messageAggregationListAdapter = this.h) == null) {
            return;
        }
        messageAggregationListAdapter.notifyDataSetChanged();
    }

    public final void q0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            if (i2 > 0) {
                if (qy4.d().f() == 0) {
                    i2 = 0;
                }
                this.K.setThreeDotMode(2);
                this.K.f(i2);
                this.K.setVisibility(0);
                return;
            }
            this.K.setVisibility(8);
        }
    }

    public void r0() {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || (bdSwipeRefreshLayout = this.d) == null || bdSwipeRefreshLayout.r()) {
            return;
        }
        z0(true);
    }

    public final void s0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            if (i2 > 0) {
                if (qy4.d().f() == 0) {
                    i2 = 0;
                }
                this.G.setThreeDotMode(2);
                this.G.f(i2);
                this.G.setVisibility(0);
                return;
            }
            this.G.setVisibility(8);
        }
    }

    public void t0() {
        IMUserListModel iMUserListModel;
        ImMessageCenterModel imMessageCenterModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || (iMUserListModel = this.W) == null || (imMessageCenterModel = this.b) == null) {
            return;
        }
        iMUserListModel.request(true, imMessageCenterModel.getUids());
    }

    public void u0() {
        IMUserListModel iMUserListModel;
        ImMessageCenterModel imMessageCenterModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || (iMUserListModel = this.W) == null || (imMessageCenterModel = this.b) == null || !this.P) {
            return;
        }
        iMUserListModel.request(false, imMessageCenterModel.getUids());
        this.P = false;
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.a.registerListener(2016004, this.f0);
            this.a.registerListener(2016001, this.f0);
            this.a.registerListener(2016010, this.f0);
            this.a.registerListener(2016007, this.f0);
            this.a.registerListener(2016011, this.f0);
            this.a.registerListener(2016002, this.f0);
            this.a.registerListener(this.h0);
            this.a.registerListener(this.j0);
            this.a.registerListener(this.Z);
            this.a.registerListener(this.b0);
            this.a.registerListener(this.q0);
        }
    }

    public final void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            na5 na5Var = new na5(309712);
            na5Var.setResponsedClass(MsgRecForumSocketResMessage.class);
            na5Var.g(true);
            na5Var.h(false);
            na5Var.f(SocketMessageTask.DupLicateMode.NONE);
            MessageManager.getInstance().registerTask(na5Var);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_GET_MSG_REC_FORUM_LIST, wh8.a("c/f/forum/getMsgRecForumlist", 309712));
            tbHttpMessageTask.setResponsedClass(MsgRecForumHttpResMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.a.registerListener(this.a0);
            this.U = true;
        }
    }

    public void x0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.r = z;
        }
    }

    public void z0(boolean z) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048620, this, z) == null) || this.d == null) {
            return;
        }
        if (z && (bdListView = this.f) != null && bdListView.getFirstVisiblePosition() != 0) {
            this.f.setSelection(0);
        }
        this.d.setRefreshing(z);
    }
}
