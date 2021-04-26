package d.a.j0.q0.h1;

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
    public String f57749e;

    /* renamed from: f  reason: collision with root package name */
    public String f57750f;

    /* renamed from: g  reason: collision with root package name */
    public String f57751g;

    /* renamed from: h  reason: collision with root package name */
    public String f57752h;

    /* renamed from: i  reason: collision with root package name */
    public List<MediaData> f57753i;
    public int j;
    public boolean k = false;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return l;
    }

    public String h() {
        return this.f57751g;
    }

    public String l() {
        return this.f57750f;
    }

    public String m() {
        return this.f57749e;
    }

    public String p() {
        return this.f57752h;
    }

    public boolean s() {
        return this.k;
    }

    public List<MediaData> t() {
        return this.f57753i;
    }

    public int u() {
        return this.j;
    }

    public void v(AdInfo adInfo) {
        if (adInfo == null) {
            return;
        }
        this.f57749e = adInfo.portrait;
        this.f57750f = adInfo.ad_name;
        this.f57751g = adInfo.ad_desc;
        this.f57752h = adInfo.ad_url;
        this.j = adInfo.show_rule.intValue();
        if (adInfo.media != null) {
            this.f57753i = new ArrayList();
            for (Media media : adInfo.media) {
                MediaData mediaData = new MediaData();
                mediaData.parserProtobuf(media);
                this.f57753i.add(mediaData);
            }
        }
    }

    public void w(boolean z) {
        this.k = z;
    }
}
