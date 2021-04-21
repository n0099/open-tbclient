package d.b.j0.d2.l.b;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import java.util.ArrayList;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes3.dex */
public class e implements d, PreLoadImageProvider {

    /* renamed from: e  reason: collision with root package name */
    public String f54933e;

    /* renamed from: f  reason: collision with root package name */
    public int f54934f;

    /* renamed from: g  reason: collision with root package name */
    public int f54935g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<PreLoadImageInfo> f54936h;
    public String i;

    public e(ExcContent excContent) {
        Long l;
        if (excContent == null || (l = excContent.type) == null || !l.equals(3L)) {
            return;
        }
        this.f54936h = new ArrayList<>(1);
        this.f54933e = excContent.src;
        String str = excContent.bsize;
        this.i = str;
        if (str != null) {
            try {
                String[] split = str.split(",");
                this.f54934f = d.b.c.e.m.b.d(split[0], 0);
                this.f54935g = d.b.c.e.m.b.d(split[1], 0);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f54934f <= 0) {
            this.f54934f = 1;
        }
        if (this.f54935g <= 0) {
            this.f54935g = 1;
        }
        String str2 = excContent.cdn_src;
        PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
        preLoadImageInfo.procType = 17;
        preLoadImageInfo.height = this.f54935g;
        preLoadImageInfo.width = this.f54934f;
        if (StringUtils.isNull(str2)) {
            preLoadImageInfo.imgUrl = this.f54933e;
        } else {
            preLoadImageInfo.imgUrl = str2;
        }
        this.f54936h.add(preLoadImageInfo);
    }

    public int c(int i) {
        if (i <= 0) {
            return 0;
        }
        return (i * this.f54935g) / this.f54934f;
    }

    public String d() {
        return this.f54933e;
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        return this.f54936h;
    }

    @Override // d.b.j0.d2.l.b.d
    public int getType() {
        return 3;
    }
}
