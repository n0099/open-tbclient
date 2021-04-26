package d.a.j0.d2.l.b;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import java.util.ArrayList;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes3.dex */
public class e implements d, PreLoadImageProvider {

    /* renamed from: e  reason: collision with root package name */
    public String f52753e;

    /* renamed from: f  reason: collision with root package name */
    public int f52754f;

    /* renamed from: g  reason: collision with root package name */
    public int f52755g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<PreLoadImageInfo> f52756h;

    /* renamed from: i  reason: collision with root package name */
    public String f52757i;

    public e(ExcContent excContent) {
        Long l;
        if (excContent == null || (l = excContent.type) == null || !l.equals(3L)) {
            return;
        }
        this.f52756h = new ArrayList<>(1);
        this.f52753e = excContent.src;
        String str = excContent.bsize;
        this.f52757i = str;
        if (str != null) {
            try {
                String[] split = str.split(",");
                this.f52754f = d.a.c.e.m.b.d(split[0], 0);
                this.f52755g = d.a.c.e.m.b.d(split[1], 0);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f52754f <= 0) {
            this.f52754f = 1;
        }
        if (this.f52755g <= 0) {
            this.f52755g = 1;
        }
        String str2 = excContent.cdn_src;
        PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
        preLoadImageInfo.procType = 17;
        preLoadImageInfo.height = this.f52755g;
        preLoadImageInfo.width = this.f52754f;
        if (StringUtils.isNull(str2)) {
            preLoadImageInfo.imgUrl = this.f52753e;
        } else {
            preLoadImageInfo.imgUrl = str2;
        }
        this.f52756h.add(preLoadImageInfo);
    }

    public int c(int i2) {
        if (i2 <= 0) {
            return 0;
        }
        return (i2 * this.f52755g) / this.f52754f;
    }

    public String d() {
        return this.f52753e;
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        return this.f52756h;
    }

    @Override // d.a.j0.d2.l.b.d
    public int getType() {
        return 3;
    }
}
