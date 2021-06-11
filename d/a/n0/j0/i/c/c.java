package d.a.n0.j0.i.c;

import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import d.a.m0.z0.l0;
import java.util.ArrayList;
import java.util.List;
import tbclient.BaijiahaoInfo;
import tbclient.GetInfluenceRank.DataRes;
import tbclient.NewGodInfo;
import tbclient.RankRuler;
import tbclient.User;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public a f59662a;

    /* renamed from: c  reason: collision with root package name */
    public b f59664c;

    /* renamed from: d  reason: collision with root package name */
    public String f59665d;

    /* renamed from: e  reason: collision with root package name */
    public String f59666e;

    /* renamed from: f  reason: collision with root package name */
    public long f59667f;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f59663b = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public boolean f59668g = true;

    public final b a(User user) {
        NewGodInfo newGodInfo;
        if (user == null) {
            return null;
        }
        b bVar = new b();
        bVar.f59654a = user.level_influence;
        bVar.f59656c = b(user);
        BaijiahaoInfo baijiahaoInfo = user.baijiahao_info;
        boolean z = false;
        if (baijiahaoInfo != null) {
            bVar.f59657d = baijiahaoInfo.auth_desc;
            Integer num = baijiahaoInfo.auth_id;
            bVar.f59660g = (num == null || num.intValue() == 0) ? false : true;
        }
        if (!bVar.f59660g && (newGodInfo = user.new_god_data) != null && newGodInfo.status.intValue() == 3) {
            bVar.f59657d = user.new_god_data.field_name + l0.c(user.new_god_data);
            bVar.f59661h = true;
        }
        if (user.influence == null) {
            bVar.f59658e = "";
        } else {
            bVar.f59658e = String.format(TbadkCoreApplication.getInst().getString(R.string.influence), StringHelper.numFormatOverWanNa(user.influence.intValue()));
        }
        MetaData metaData = new MetaData();
        metaData.parserProtobuf(user);
        Integer num2 = user.has_concerned;
        if (num2 != null && num2.intValue() != 0) {
            z = true;
        }
        metaData.setIsLike(z);
        bVar.f59659f = metaData;
        if (metaData.getAvater() != null && metaData.getAvater().startsWith("http")) {
            bVar.f59655b = metaData.getAvater();
        } else {
            bVar.f59655b = TbConfig.getPhotoSmallAddress() + metaData.getAvater();
        }
        return bVar;
    }

    public final String b(User user) {
        if (user == null) {
            return "";
        }
        BaijiahaoInfo baijiahaoInfo = user.baijiahao_info;
        String str = baijiahaoInfo != null ? baijiahaoInfo.name : "";
        if (TextUtils.isEmpty(str)) {
            str = user.name_show;
        }
        return TextUtils.isEmpty(str) ? TbadkCoreApplication.getInst().getString(R.string.user_name_default_txt) : str;
    }

    public void c(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f59662a = new a();
        if (!ListUtils.isEmpty(dataRes.user_rank) && dataRes.user_rank.get(0) != null) {
            this.f59662a.f59649b = b(dataRes.user_rank.get(0));
            MetaData metaData = new MetaData();
            metaData.parserProtobuf(dataRes.user_rank.get(0));
            this.f59662a.f59650c = metaData;
            String avatarH = metaData.getAvatarH();
            if (TextUtils.isEmpty(avatarH)) {
                avatarH = metaData.getAvater();
            }
            if (avatarH != null && avatarH.startsWith("http")) {
                this.f59662a.f59652e = avatarH;
            } else {
                a aVar = this.f59662a;
                aVar.f59652e = "http://tb.himg.baidu.com/sys/portraith/item/" + avatarH;
            }
        }
        a aVar2 = this.f59662a;
        Long l = dataRes.timestamp;
        aVar2.f59651d = l == null ? 0L : l.longValue();
        this.f59662a.f59653f = dataRes.field_info;
        if (!ListUtils.isEmpty(dataRes.user_rank)) {
            for (User user : dataRes.user_rank) {
                if (user != null) {
                    this.f59663b.add(a(user));
                }
            }
        }
        this.f59664c = a(dataRes.current_user);
        RankRuler rankRuler = dataRes.rank_description;
        if (rankRuler != null) {
            this.f59665d = rankRuler.top_link;
            this.f59666e = rankRuler.bottom_link;
        }
        Long l2 = dataRes.timestamp;
        this.f59667f = l2 != null ? l2.longValue() : 0L;
        Boolean bool = dataRes.has_more;
        this.f59668g = bool != null ? bool.booleanValue() : false;
    }
}
