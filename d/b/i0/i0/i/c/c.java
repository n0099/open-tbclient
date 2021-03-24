package d.b.i0.i0.i.c;

import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import d.b.h0.z0.l0;
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
    public a f55607a;

    /* renamed from: c  reason: collision with root package name */
    public b f55609c;

    /* renamed from: d  reason: collision with root package name */
    public String f55610d;

    /* renamed from: e  reason: collision with root package name */
    public String f55611e;

    /* renamed from: f  reason: collision with root package name */
    public long f55612f;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f55608b = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public boolean f55613g = true;

    public final b a(User user) {
        NewGodInfo newGodInfo;
        if (user == null) {
            return null;
        }
        b bVar = new b();
        bVar.f55599a = user.level_influence;
        bVar.f55601c = b(user);
        BaijiahaoInfo baijiahaoInfo = user.baijiahao_info;
        boolean z = false;
        if (baijiahaoInfo != null) {
            bVar.f55602d = baijiahaoInfo.auth_desc;
            Integer num = baijiahaoInfo.auth_id;
            bVar.f55605g = (num == null || num.intValue() == 0) ? false : true;
        }
        if (!bVar.f55605g && (newGodInfo = user.new_god_data) != null && newGodInfo.status.intValue() == 3) {
            bVar.f55602d = user.new_god_data.field_name + l0.b(user.new_god_data);
            bVar.f55606h = true;
        }
        if (user.influence == null) {
            bVar.f55603e = "";
        } else {
            bVar.f55603e = String.format(TbadkCoreApplication.getInst().getString(R.string.influence), StringHelper.numFormatOverWanNa(user.influence.intValue()));
        }
        MetaData metaData = new MetaData();
        metaData.parserProtobuf(user);
        Integer num2 = user.has_concerned;
        if (num2 != null && num2.intValue() != 0) {
            z = true;
        }
        metaData.setIsLike(z);
        bVar.f55604f = metaData;
        if (metaData.getAvater() != null && metaData.getAvater().startsWith("http")) {
            bVar.f55600b = metaData.getAvater();
        } else {
            bVar.f55600b = TbConfig.getPhotoSmallAddress() + metaData.getAvater();
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
        this.f55607a = new a();
        if (!ListUtils.isEmpty(dataRes.user_rank) && dataRes.user_rank.get(0) != null) {
            this.f55607a.f55594b = b(dataRes.user_rank.get(0));
            MetaData metaData = new MetaData();
            metaData.parserProtobuf(dataRes.user_rank.get(0));
            this.f55607a.f55595c = metaData;
            String avatarH = metaData.getAvatarH();
            if (TextUtils.isEmpty(avatarH)) {
                avatarH = metaData.getAvater();
            }
            if (avatarH != null && avatarH.startsWith("http")) {
                this.f55607a.f55597e = avatarH;
            } else {
                a aVar = this.f55607a;
                aVar.f55597e = "http://tb.himg.baidu.com/sys/portraith/item/" + avatarH;
            }
        }
        a aVar2 = this.f55607a;
        Long l = dataRes.timestamp;
        aVar2.f55596d = l == null ? 0L : l.longValue();
        this.f55607a.f55598f = dataRes.field_info;
        if (!ListUtils.isEmpty(dataRes.user_rank)) {
            for (User user : dataRes.user_rank) {
                if (user != null) {
                    this.f55608b.add(a(user));
                }
            }
        }
        this.f55609c = a(dataRes.current_user);
        RankRuler rankRuler = dataRes.rank_description;
        if (rankRuler != null) {
            this.f55610d = rankRuler.top_link;
            this.f55611e = rankRuler.bottom_link;
        }
        Long l2 = dataRes.timestamp;
        this.f55612f = l2 != null ? l2.longValue() : 0L;
        Boolean bool = dataRes.has_more;
        this.f55613g = bool != null ? bool.booleanValue() : false;
    }
}
