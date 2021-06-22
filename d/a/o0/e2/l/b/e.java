package d.a.o0.e2.l.b;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import java.util.ArrayList;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes5.dex */
public class e implements d, PreLoadImageProvider {

    /* renamed from: e  reason: collision with root package name */
    public String f57480e;

    /* renamed from: f  reason: collision with root package name */
    public int f57481f;

    /* renamed from: g  reason: collision with root package name */
    public int f57482g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<PreLoadImageInfo> f57483h;

    /* renamed from: i  reason: collision with root package name */
    public String f57484i;

    public e(ExcContent excContent) {
        Long l;
        if (excContent == null || (l = excContent.type) == null || !l.equals(3L)) {
            return;
        }
        this.f57483h = new ArrayList<>(1);
        this.f57480e = excContent.src;
        String str = excContent.bsize;
        this.f57484i = str;
        if (str != null) {
            try {
                String[] split = str.split(",");
                this.f57481f = d.a.c.e.m.b.d(split[0], 0);
                this.f57482g = d.a.c.e.m.b.d(split[1], 0);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f57481f <= 0) {
            this.f57481f = 1;
        }
        if (this.f57482g <= 0) {
            this.f57482g = 1;
        }
        String str2 = excContent.cdn_src;
        PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
        preLoadImageInfo.procType = 17;
        preLoadImageInfo.height = this.f57482g;
        preLoadImageInfo.width = this.f57481f;
        if (StringUtils.isNull(str2)) {
            preLoadImageInfo.imgUrl = this.f57480e;
        } else {
            preLoadImageInfo.imgUrl = str2;
        }
        this.f57483h.add(preLoadImageInfo);
    }

    public int c(int i2) {
        if (i2 <= 0) {
            return 0;
        }
        return (i2 * this.f57482g) / this.f57481f;
    }

    public String d() {
        return this.f57480e;
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        return this.f57483h;
    }

    @Override // d.a.o0.e2.l.b.d
    public int getType() {
        return 3;
    }
}
