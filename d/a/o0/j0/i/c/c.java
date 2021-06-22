package d.a.o0.j0.i.c;

import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import d.a.n0.z0.l0;
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
    public a f59787a;

    /* renamed from: c  reason: collision with root package name */
    public b f59789c;

    /* renamed from: d  reason: collision with root package name */
    public String f59790d;

    /* renamed from: e  reason: collision with root package name */
    public String f59791e;

    /* renamed from: f  reason: collision with root package name */
    public long f59792f;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f59788b = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public boolean f59793g = true;

    public final b a(User user) {
        NewGodInfo newGodInfo;
        if (user == null) {
            return null;
        }
        b bVar = new b();
        bVar.f59779a = user.level_influence;
        bVar.f59781c = b(user);
        BaijiahaoInfo baijiahaoInfo = user.baijiahao_info;
        boolean z = false;
        if (baijiahaoInfo != null) {
            bVar.f59782d = baijiahaoInfo.auth_desc;
            Integer num = baijiahaoInfo.auth_id;
            bVar.f59785g = (num == null || num.intValue() == 0) ? false : true;
        }
        if (!bVar.f59785g && (newGodInfo = user.new_god_data) != null && newGodInfo.status.intValue() == 3) {
            bVar.f59782d = user.new_god_data.field_name + l0.c(user.new_god_data);
            bVar.f59786h = true;
        }
        if (user.influence == null) {
            bVar.f59783e = "";
        } else {
            bVar.f59783e = String.format(TbadkCoreApplication.getInst().getString(R.string.influence), StringHelper.numFormatOverWanNa(user.influence.intValue()));
        }
        MetaData metaData = new MetaData();
        metaData.parserProtobuf(user);
        Integer num2 = user.has_concerned;
        if (num2 != null && num2.intValue() != 0) {
            z = true;
        }
        metaData.setIsLike(z);
        bVar.f59784f = metaData;
        if (metaData.getAvater() != null && metaData.getAvater().startsWith("http")) {
            bVar.f59780b = metaData.getAvater();
        } else {
            bVar.f59780b = TbConfig.getPhotoSmallAddress() + metaData.getAvater();
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
        this.f59787a = new a();
        if (!ListUtils.isEmpty(dataRes.user_rank) && dataRes.user_rank.get(0) != null) {
            this.f59787a.f59774b = b(dataRes.user_rank.get(0));
            MetaData metaData = new MetaData();
            metaData.parserProtobuf(dataRes.user_rank.get(0));
            this.f59787a.f59775c = metaData;
            String avatarH = metaData.getAvatarH();
            if (TextUtils.isEmpty(avatarH)) {
                avatarH = metaData.getAvater();
            }
            if (avatarH != null && avatarH.startsWith("http")) {
                this.f59787a.f59777e = avatarH;
            } else {
                a aVar = this.f59787a;
                aVar.f59777e = "http://tb.himg.baidu.com/sys/portraith/item/" + avatarH;
            }
        }
        a aVar2 = this.f59787a;
        Long l = dataRes.timestamp;
        aVar2.f59776d = l == null ? 0L : l.longValue();
        this.f59787a.f59778f = dataRes.field_info;
        if (!ListUtils.isEmpty(dataRes.user_rank)) {
            for (User user : dataRes.user_rank) {
                if (user != null) {
                    this.f59788b.add(a(user));
                }
            }
        }
        this.f59789c = a(dataRes.current_user);
        RankRuler rankRuler = dataRes.rank_description;
        if (rankRuler != null) {
            this.f59790d = rankRuler.top_link;
            this.f59791e = rankRuler.bottom_link;
        }
        Long l2 = dataRes.timestamp;
        this.f59792f = l2 != null ? l2.longValue() : 0L;
        Boolean bool = dataRes.has_more;
        this.f59793g = bool != null ? bool.booleanValue() : false;
    }
}
