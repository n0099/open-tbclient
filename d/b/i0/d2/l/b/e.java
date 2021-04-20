package d.b.i0.d2.l.b;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import java.util.ArrayList;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes3.dex */
public class e implements d, PreLoadImageProvider {

    /* renamed from: e  reason: collision with root package name */
    public String f54512e;

    /* renamed from: f  reason: collision with root package name */
    public int f54513f;

    /* renamed from: g  reason: collision with root package name */
    public int f54514g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<PreLoadImageInfo> f54515h;
    public String i;

    public e(ExcContent excContent) {
        Long l;
        if (excContent == null || (l = excContent.type) == null || !l.equals(3L)) {
            return;
        }
        this.f54515h = new ArrayList<>(1);
        this.f54512e = excContent.src;
        String str = excContent.bsize;
        this.i = str;
        if (str != null) {
            try {
                String[] split = str.split(",");
                this.f54513f = d.b.c.e.m.b.d(split[0], 0);
                this.f54514g = d.b.c.e.m.b.d(split[1], 0);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f54513f <= 0) {
            this.f54513f = 1;
        }
        if (this.f54514g <= 0) {
            this.f54514g = 1;
        }
        String str2 = excContent.cdn_src;
        PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
        preLoadImageInfo.procType = 17;
        preLoadImageInfo.height = this.f54514g;
        preLoadImageInfo.width = this.f54513f;
        if (StringUtils.isNull(str2)) {
            preLoadImageInfo.imgUrl = this.f54512e;
        } else {
            preLoadImageInfo.imgUrl = str2;
        }
        this.f54515h.add(preLoadImageInfo);
    }

    public int c(int i) {
        if (i <= 0) {
            return 0;
        }
        return (i * this.f54514g) / this.f54513f;
    }

    public String d() {
        return this.f54512e;
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        return this.f54515h;
    }

    @Override // d.b.i0.d2.l.b.d
    public int getType() {
        return 3;
    }
}
