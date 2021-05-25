package d.a.n0.e2.l.b;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import java.util.ArrayList;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes5.dex */
public class e implements d, PreLoadImageProvider {

    /* renamed from: e  reason: collision with root package name */
    public String f53666e;

    /* renamed from: f  reason: collision with root package name */
    public int f53667f;

    /* renamed from: g  reason: collision with root package name */
    public int f53668g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<PreLoadImageInfo> f53669h;

    /* renamed from: i  reason: collision with root package name */
    public String f53670i;

    public e(ExcContent excContent) {
        Long l;
        if (excContent == null || (l = excContent.type) == null || !l.equals(3L)) {
            return;
        }
        this.f53669h = new ArrayList<>(1);
        this.f53666e = excContent.src;
        String str = excContent.bsize;
        this.f53670i = str;
        if (str != null) {
            try {
                String[] split = str.split(",");
                this.f53667f = d.a.c.e.m.b.d(split[0], 0);
                this.f53668g = d.a.c.e.m.b.d(split[1], 0);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f53667f <= 0) {
            this.f53667f = 1;
        }
        if (this.f53668g <= 0) {
            this.f53668g = 1;
        }
        String str2 = excContent.cdn_src;
        PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
        preLoadImageInfo.procType = 17;
        preLoadImageInfo.height = this.f53668g;
        preLoadImageInfo.width = this.f53667f;
        if (StringUtils.isNull(str2)) {
            preLoadImageInfo.imgUrl = this.f53666e;
        } else {
            preLoadImageInfo.imgUrl = str2;
        }
        this.f53669h.add(preLoadImageInfo);
    }

    public int c(int i2) {
        if (i2 <= 0) {
            return 0;
        }
        return (i2 * this.f53668g) / this.f53667f;
    }

    public String d() {
        return this.f53666e;
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        return this.f53669h;
    }

    @Override // d.a.n0.e2.l.b.d
    public int getType() {
        return 3;
    }
}
