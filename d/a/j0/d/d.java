package d.a.j0.d;

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
import d.a.c.e.p.j;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static View.OnClickListener f49223a = new a();

    /* loaded from: classes3.dex */
    public static class a implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                return;
            }
            if (!j.z()) {
                l.L(view.getContext(), R.string.no_network_guide);
                return;
            }
            b bVar = (b) view.getTag();
            AlaUserInfoData alaUserInfoData = bVar.f49218a;
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
            int i2 = bVar.f49219b;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (i2 == 1) {
                TiebaStatic.log(new StatisticItem("c11850").param("uid", currentAccount));
            } else if (i2 == 2 || i2 == 3 || i2 == 4) {
                TiebaStatic.log(new StatisticItem("c11851").param("uid", currentAccount));
            } else if (i2 == 5) {
                TiebaStatic.log(new StatisticItem("c11852").param("uid", currentAccount));
            } else if (i2 == 7) {
                if (alaUserInfoData.ala_id != 0) {
                    TiebaStatic.log(new StatisticItem("c11855").param("uid", currentAccount).param("click_uid", alaUserInfoData.ala_id).param(IFavorStateServiceKt.KEY_FAVOR_LIVE_STATUS, alaUserInfoData.live_status));
                }
                TiebaStatic.log(new StatisticItem("c12542"));
                if (bVar.f49220c && !StringUtils.isNull(alaUserInfoData.sex)) {
                    BdToast.i(view.getContext(), String.format(view.getContext().getString(R.string.person_privacy_toast), alaUserInfoData.sex), R.drawable.icon_pure_toast_mistake40_svg, true).q();
                    return;
                }
            }
            int i3 = bVar.f49219b;
            MessageManager.getInstance().sendMessage(new CustomMessage(2911003, new AlaLiveRoomActivityConfig(view.getContext(), alaLiveInfoCoreData, i3 == 5 ? AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_ATTENTION : i3 == 7 ? AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY : AlaLiveRoomActivityConfig.FROM_TYPE_TAIL_LIGHT, null, false, "")));
        }
    }

    public static TextView a(Context context) {
        if (context == null || MessageManager.getInstance().findTask(2911003) == null) {
            return null;
        }
        TextView textView = (TextView) LayoutInflater.from(context).inflate(R.layout.ala_tail_view_layout, (ViewGroup) null);
        textView.setOnClickListener(f49223a);
        return textView;
    }
}
