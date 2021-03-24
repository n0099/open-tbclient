package d.b.i0.c2.l.b;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import java.util.ArrayList;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes5.dex */
public class e implements d, PreLoadImageProvider {

    /* renamed from: e  reason: collision with root package name */
    public String f53102e;

    /* renamed from: f  reason: collision with root package name */
    public int f53103f;

    /* renamed from: g  reason: collision with root package name */
    public int f53104g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<PreLoadImageInfo> f53105h;
    public String i;

    public e(ExcContent excContent) {
        Long l;
        if (excContent == null || (l = excContent.type) == null || !l.equals(3L)) {
            return;
        }
        this.f53105h = new ArrayList<>(1);
        this.f53102e = excContent.src;
        String str = excContent.bsize;
        this.i = str;
        if (str != null) {
            try {
                String[] split = str.split(",");
                this.f53103f = d.b.b.e.m.b.d(split[0], 0);
                this.f53104g = d.b.b.e.m.b.d(split[1], 0);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f53103f <= 0) {
            this.f53103f = 1;
        }
        if (this.f53104g <= 0) {
            this.f53104g = 1;
        }
        String str2 = excContent.cdn_src;
        PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
        preLoadImageInfo.procType = 17;
        preLoadImageInfo.height = this.f53104g;
        preLoadImageInfo.width = this.f53103f;
        if (StringUtils.isNull(str2)) {
            preLoadImageInfo.imgUrl = this.f53102e;
        } else {
            preLoadImageInfo.imgUrl = str2;
        }
        this.f53105h.add(preLoadImageInfo);
    }

    public int c(int i) {
        if (i <= 0) {
            return 0;
        }
        return (i * this.f53104g) / this.f53103f;
    }

    public String d() {
        return this.f53102e;
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        return this.f53105h;
    }

    @Override // d.b.i0.c2.l.b.d
    public int getType() {
        return 3;
    }
}
