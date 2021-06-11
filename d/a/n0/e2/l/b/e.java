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
    public String f57355e;

    /* renamed from: f  reason: collision with root package name */
    public int f57356f;

    /* renamed from: g  reason: collision with root package name */
    public int f57357g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<PreLoadImageInfo> f57358h;

    /* renamed from: i  reason: collision with root package name */
    public String f57359i;

    public e(ExcContent excContent) {
        Long l;
        if (excContent == null || (l = excContent.type) == null || !l.equals(3L)) {
            return;
        }
        this.f57358h = new ArrayList<>(1);
        this.f57355e = excContent.src;
        String str = excContent.bsize;
        this.f57359i = str;
        if (str != null) {
            try {
                String[] split = str.split(",");
                this.f57356f = d.a.c.e.m.b.d(split[0], 0);
                this.f57357g = d.a.c.e.m.b.d(split[1], 0);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f57356f <= 0) {
            this.f57356f = 1;
        }
        if (this.f57357g <= 0) {
            this.f57357g = 1;
        }
        String str2 = excContent.cdn_src;
        PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
        preLoadImageInfo.procType = 17;
        preLoadImageInfo.height = this.f57357g;
        preLoadImageInfo.width = this.f57356f;
        if (StringUtils.isNull(str2)) {
            preLoadImageInfo.imgUrl = this.f57355e;
        } else {
            preLoadImageInfo.imgUrl = str2;
        }
        this.f57358h.add(preLoadImageInfo);
    }

    public int c(int i2) {
        if (i2 <= 0) {
            return 0;
        }
        return (i2 * this.f57357g) / this.f57356f;
    }

    public String d() {
        return this.f57355e;
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        return this.f57358h;
    }

    @Override // d.a.n0.e2.l.b.d
    public int getType() {
        return 3;
    }
}
