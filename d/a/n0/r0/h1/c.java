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
    public String f62323e;

    /* renamed from: f  reason: collision with root package name */
    public String f62324f;

    /* renamed from: g  reason: collision with root package name */
    public String f62325g;

    /* renamed from: h  reason: collision with root package name */
    public String f62326h;

    /* renamed from: i  reason: collision with root package name */
    public List<MediaData> f62327i;
    public int j;
    public boolean k = false;

    public String c() {
        return this.f62325g;
    }

    public String g() {
        return this.f62324f;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return l;
    }

    public String i() {
        return this.f62323e;
    }

    public String k() {
        return this.f62326h;
    }

    public boolean o() {
        return this.k;
    }

    public List<MediaData> p() {
        return this.f62327i;
    }

    public int q() {
        return this.j;
    }

    public void t(AdInfo adInfo) {
        if (adInfo == null) {
            return;
        }
        this.f62323e = adInfo.portrait;
        this.f62324f = adInfo.ad_name;
        this.f62325g = adInfo.ad_desc;
        this.f62326h = adInfo.ad_url;
        this.j = adInfo.show_rule.intValue();
        if (adInfo.media != null) {
            this.f62327i = new ArrayList();
            for (Media media : adInfo.media) {
                MediaData mediaData = new MediaData();
                mediaData.parserProtobuf(media);
                this.f62327i.add(mediaData);
            }
        }
    }

    public void w(boolean z) {
        this.k = z;
    }
}
