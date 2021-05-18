package d.a.k0.d2.l.b;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import java.util.ArrayList;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes5.dex */
public class e implements d, PreLoadImageProvider {

    /* renamed from: e  reason: collision with root package name */
    public String f53456e;

    /* renamed from: f  reason: collision with root package name */
    public int f53457f;

    /* renamed from: g  reason: collision with root package name */
    public int f53458g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<PreLoadImageInfo> f53459h;

    /* renamed from: i  reason: collision with root package name */
    public String f53460i;

    public e(ExcContent excContent) {
        Long l;
        if (excContent == null || (l = excContent.type) == null || !l.equals(3L)) {
            return;
        }
        this.f53459h = new ArrayList<>(1);
        this.f53456e = excContent.src;
        String str = excContent.bsize;
        this.f53460i = str;
        if (str != null) {
            try {
                String[] split = str.split(",");
                this.f53457f = d.a.c.e.m.b.d(split[0], 0);
                this.f53458g = d.a.c.e.m.b.d(split[1], 0);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f53457f <= 0) {
            this.f53457f = 1;
        }
        if (this.f53458g <= 0) {
            this.f53458g = 1;
        }
        String str2 = excContent.cdn_src;
        PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
        preLoadImageInfo.procType = 17;
        preLoadImageInfo.height = this.f53458g;
        preLoadImageInfo.width = this.f53457f;
        if (StringUtils.isNull(str2)) {
            preLoadImageInfo.imgUrl = this.f53456e;
        } else {
            preLoadImageInfo.imgUrl = str2;
        }
        this.f53459h.add(preLoadImageInfo);
    }

    public int c(int i2) {
        if (i2 <= 0) {
            return 0;
        }
        return (i2 * this.f53458g) / this.f53457f;
    }

    public String d() {
        return this.f53456e;
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        return this.f53459h;
    }

    @Override // d.a.k0.d2.l.b.d
    public int getType() {
        return 3;
    }
}
