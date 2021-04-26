package d.a.j0.d2.k.e.b1;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionImageActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.AlaUserInfoData;
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
import d.a.c.e.p.k;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final String f52236f = TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";

    /* renamed from: a  reason: collision with root package name */
    public final d.a.j0.d2.k.a f52237a;

    /* renamed from: b  reason: collision with root package name */
    public final View.OnClickListener f52238b = new View$OnClickListenerC1172a();

    /* renamed from: c  reason: collision with root package name */
    public final View.OnClickListener f52239c = new b(this);

    /* renamed from: d  reason: collision with root package name */
    public final View.OnClickListener f52240d = new c();

    /* renamed from: e  reason: collision with root package name */
    public final TbRichTextView.w f52241e = new d();

    /* renamed from: d.a.j0.d2.k.e.b1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1172a implements View.OnClickListener {
        public View$OnClickListenerC1172a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            String str3;
            AlaInfoData alaInfoData;
            String str4;
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
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(a.this.f52237a.getPageContext().getPageActivity(), null, str6, true)));
                    return;
                }
            }
            String str7 = view.getTag(R.id.tag_virtual_user_url) instanceof String ? (String) view.getTag(R.id.tag_virtual_user_url) : null;
            if (str7 != null) {
                if (ViewHelper.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                    UrlManager.getInstance().dealOneLink(a.this.f52237a.getPageContext(), new String[]{str7});
                }
            } else if (str2 != null) {
                if (alaInfoData != null && (i2 == 1 || alaInfoData.live_status == 1)) {
                    if (alaInfoData.isLegalYYLiveData()) {
                        YYLiveUtil.jumpYYLiveRoom(a.this.f52237a.getPageContext(), alaInfoData);
                        return;
                    } else if (alaInfoData.isChushou) {
                        UrlManager urlManager = UrlManager.getInstance();
                        TbPageContext pageContext = a.this.f52237a.getPageContext();
                        urlManager.dealOneLink(pageContext, new String[]{"tiebachushou://liveroom?roomid=" + alaInfoData.thirdRoomId + "&livetype=" + alaInfoData.thirdLiveType});
                        return;
                    } else if (alaInfoData.live_id > 0) {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = alaInfoData.live_id;
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(view.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_REPLY_PORTRAIT, null, false, "")));
                        return;
                    } else {
                        return;
                    }
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(a.this.f52237a.getPageContext().getPageActivity(), str2, str3, a.this.f52237a.getFromForumName(), AddFriendActivityConfig.TYPE_PB_HEAD)));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b(a aVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag(R.id.tag_user_id) instanceof String) {
                d.a.i0.l.a.o(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), a.f52236f + "?user_id=" + ((String) view.getTag(R.id.tag_user_id)), true, true, true);
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 2));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ViewHelper.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                String str = view.getTag() != null ? (String) view.getTag() : null;
                if (str != null) {
                    UrlManager.getInstance().dealOneLink(a.this.f52237a.getPageContext(), new String[]{str});
                }
                TiebaStatic.eventStat(a.this.f52237a.getPageContext().getPageActivity(), "consume_2", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements TbRichTextView.w {
        public d() {
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.w
        public void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i2, int i3) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2902011, new EmotionImageActivityConfig(a.this.f52237a.getPageContext().getPageActivity(), str, str2, str3, str4, str5, str6, 1, i2, i3)));
        }
    }

    public a(d.a.j0.d2.k.a aVar) {
        this.f52237a = aVar;
    }
}
