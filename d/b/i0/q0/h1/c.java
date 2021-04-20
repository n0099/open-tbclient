package d.b.i0.q0.h1;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes4.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId l = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f59264e;

    /* renamed from: f  reason: collision with root package name */
    public String f59265f;

    /* renamed from: g  reason: collision with root package name */
    public String f59266g;

    /* renamed from: h  reason: collision with root package name */
    public String f59267h;
    public List<MediaData> i;
    public int j;
    public boolean k = false;

    public String g() {
        return this.f59266g;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return l;
    }

    public String j() {
        return this.f59265f;
    }

    public String n() {
        return this.f59264e;
    }

    public String o() {
        return this.f59267h;
    }

    public boolean s() {
        return this.k;
    }

    public List<MediaData> t() {
        return this.i;
    }

    public int u() {
        return this.j;
    }

    public void v(AdInfo adInfo) {
        if (adInfo == null) {
            return;
        }
        this.f59264e = adInfo.portrait;
        this.f59265f = adInfo.ad_name;
        this.f59266g = adInfo.ad_desc;
        this.f59267h = adInfo.ad_url;
        this.j = adInfo.show_rule.intValue();
        if (adInfo.media != null) {
            this.i = new ArrayList();
            for (Media media : adInfo.media) {
                MediaData mediaData = new MediaData();
                mediaData.parserProtobuf(media);
                this.i.add(mediaData);
            }
        }
    }

    public void w(boolean z) {
        this.k = z;
    }
}
