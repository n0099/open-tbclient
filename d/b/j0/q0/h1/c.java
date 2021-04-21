package d.b.j0.q0.h1;

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
    public String f59685e;

    /* renamed from: f  reason: collision with root package name */
    public String f59686f;

    /* renamed from: g  reason: collision with root package name */
    public String f59687g;

    /* renamed from: h  reason: collision with root package name */
    public String f59688h;
    public List<MediaData> i;
    public int j;
    public boolean k = false;

    public String g() {
        return this.f59687g;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return l;
    }

    public String j() {
        return this.f59686f;
    }

    public String n() {
        return this.f59685e;
    }

    public String o() {
        return this.f59688h;
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
        this.f59685e = adInfo.portrait;
        this.f59686f = adInfo.ad_name;
        this.f59687g = adInfo.ad_desc;
        this.f59688h = adInfo.ad_url;
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
