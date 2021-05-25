package d.a.n0.r0.h1;

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
    public String f58632e;

    /* renamed from: f  reason: collision with root package name */
    public String f58633f;

    /* renamed from: g  reason: collision with root package name */
    public String f58634g;

    /* renamed from: h  reason: collision with root package name */
    public String f58635h;

    /* renamed from: i  reason: collision with root package name */
    public List<MediaData> f58636i;
    public int j;
    public boolean k = false;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return l;
    }

    public String h() {
        return this.f58634g;
    }

    public String l() {
        return this.f58633f;
    }

    public String m() {
        return this.f58632e;
    }

    public String p() {
        return this.f58635h;
    }

    public boolean s() {
        return this.k;
    }

    public List<MediaData> t() {
        return this.f58636i;
    }

    public int u() {
        return this.j;
    }

    public void v(AdInfo adInfo) {
        if (adInfo == null) {
            return;
        }
        this.f58632e = adInfo.portrait;
        this.f58633f = adInfo.ad_name;
        this.f58634g = adInfo.ad_desc;
        this.f58635h = adInfo.ad_url;
        this.j = adInfo.show_rule.intValue();
        if (adInfo.media != null) {
            this.f58636i = new ArrayList();
            for (Media media : adInfo.media) {
                MediaData mediaData = new MediaData();
                mediaData.parserProtobuf(media);
                this.f58636i.add(mediaData);
            }
        }
    }

    public void w(boolean z) {
        this.k = z;
    }
}
