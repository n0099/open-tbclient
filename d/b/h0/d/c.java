package d.b.h0.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.live.interfaces.service.bd.IFavorStateServiceKt;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import d.b.b.e.p.j;
import d.b.b.e.p.l;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static View.OnClickListener f50091a = new a();

    /* loaded from: classes3.dex */
    public static class a implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof d.b.h0.d.a)) {
                return;
            }
            if (!j.z()) {
                l.K(view.getContext(), R.string.no_network_guide);
                return;
            }
            d.b.h0.d.a aVar = (d.b.h0.d.a) view.getTag();
            AlaUserInfoData alaUserInfoData = aVar.f50086a;
            if (alaUserInfoData == null) {
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            long j = alaUserInfoData.anchor_live;
            if (j != 0) {
                alaLiveInfoCoreData.liveID = j;
            } else {
                long j2 = alaUserInfoData.enter_live;
                if (j2 != 0) {
                    alaLiveInfoCoreData.liveID = j2;
                } else {
                    long j3 = alaUserInfoData.live_id;
                    if (j3 == 0) {
                        return;
                    }
                    alaLiveInfoCoreData.liveID = j3;
                }
            }
            int i = aVar.f50087b;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (i == 1) {
                TiebaStatic.log(new StatisticItem("c11850").param("uid", currentAccount));
            } else if (i == 2 || i == 3 || i == 4) {
                TiebaStatic.log(new StatisticItem("c11851").param("uid", currentAccount));
            } else if (i == 5) {
                TiebaStatic.log(new StatisticItem("c11852").param("uid", currentAccount));
            } else if (i == 7) {
                if (alaUserInfoData.ala_id != 0) {
                    TiebaStatic.log(new StatisticItem("c11855").param("uid", currentAccount).param("click_uid", alaUserInfoData.ala_id).param(IFavorStateServiceKt.KEY_FAVOR_LIVE_STATUS, alaUserInfoData.live_status));
                }
                TiebaStatic.log(new StatisticItem("c12542"));
                if (aVar.f50088c && !StringUtils.isNull(alaUserInfoData.sex)) {
                    BdToast.i(view.getContext(), String.format(view.getContext().getString(R.string.person_privacy_toast), alaUserInfoData.sex), R.drawable.icon_pure_toast_mistake40_svg, true).q();
                    return;
                }
            }
            int i2 = aVar.f50087b;
            MessageManager.getInstance().sendMessage(new CustomMessage(2911003, new AlaLiveRoomActivityConfig(view.getContext(), alaLiveInfoCoreData, i2 == 5 ? AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_ATTENTION : i2 == 7 ? AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY : AlaLiveRoomActivityConfig.FROM_TYPE_TAIL_LIGHT, null, false, "")));
        }
    }

    public static TextView a(Context context) {
        if (context == null || MessageManager.getInstance().findTask(2911003) == null) {
            return null;
        }
        TextView textView = (TextView) LayoutInflater.from(context).inflate(R.layout.ala_tail_view_layout, (ViewGroup) null);
        textView.setOnClickListener(f50091a);
        return textView;
    }
}
