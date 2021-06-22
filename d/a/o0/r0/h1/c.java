package d.a.o0.r0.h1;

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
    public String f62448e;

    /* renamed from: f  reason: collision with root package name */
    public String f62449f;

    /* renamed from: g  reason: collision with root package name */
    public String f62450g;

    /* renamed from: h  reason: collision with root package name */
    public String f62451h;

    /* renamed from: i  reason: collision with root package name */
    public List<MediaData> f62452i;
    public int j;
    public boolean k = false;

    public String c() {
        return this.f62450g;
    }

    public String g() {
        return this.f62449f;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return l;
    }

    public String i() {
        return this.f62448e;
    }

    public String k() {
        return this.f62451h;
    }

    public boolean o() {
        return this.k;
    }

    public List<MediaData> p() {
        return this.f62452i;
    }

    public int q() {
        return this.j;
    }

    public void t(AdInfo adInfo) {
        if (adInfo == null) {
            return;
        }
        this.f62448e = adInfo.portrait;
        this.f62449f = adInfo.ad_name;
        this.f62450g = adInfo.ad_desc;
        this.f62451h = adInfo.ad_url;
        this.j = adInfo.show_rule.intValue();
        if (adInfo.media != null) {
            this.f62452i = new ArrayList();
            for (Media media : adInfo.media) {
                MediaData mediaData = new MediaData();
                mediaData.parserProtobuf(media);
                this.f62452i.add(mediaData);
            }
        }
    }

    public void w(boolean z) {
        this.k = z;
    }
}
