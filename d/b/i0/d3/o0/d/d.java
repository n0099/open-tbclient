package d.b.i0.d3.o0.d;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import d.b.c.e.p.q;
import d.b.i0.t1.g;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class d implements b {

    /* renamed from: a  reason: collision with root package name */
    public long f54990a;

    /* renamed from: b  reason: collision with root package name */
    public String f54991b;

    /* renamed from: c  reason: collision with root package name */
    public String f54992c;

    /* renamed from: d  reason: collision with root package name */
    public final int f54993d;

    /* renamed from: e  reason: collision with root package name */
    public int f54994e;

    /* renamed from: f  reason: collision with root package name */
    public e f54995f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f54996g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.d3.o0.d.f.a f54997h;
    public g i;

    public d(String str, int i, g gVar) {
        this.f54992c = str;
        this.f54993d = i;
        this.i = gVar;
        File file = new File(str);
        if (file.exists()) {
            this.f54990a = file.length();
            this.f54991b = q.b(FileHelper.GetStreamFromFile(file));
            long j = this.f54990a;
            int i2 = this.f54993d;
            if (j % i2 == 0) {
                this.f54994e = (int) (j / i2);
            } else {
                this.f54994e = ((int) (j / i2)) + 1;
            }
        }
    }

    @Override // d.b.i0.d3.o0.d.b
    public VideoFinishResult a(String str, int i) {
        a c2;
        if (StringUtils.isNull(str) || this.f54990a <= 0 || StringUtils.isNull(this.f54991b) || i <= 0 || this.f54996g) {
            return null;
        }
        d(10);
        long j = i;
        a c3 = c(this.f54994e, j, false, null);
        if (c3 != null && !this.f54996g) {
            if (c3.f54982e != 0) {
                VideoFinishResult videoFinishResult = new VideoFinishResult();
                videoFinishResult.setErrorNo(c3.f54982e);
                videoFinishResult.setUserMessage(c3.f54981d);
                e(302, c3.f54982e, c3.f54981d);
                return videoFinishResult;
            }
            d(30);
            if (!StringUtils.isNull(c3.f54980c)) {
                VideoFinishResult videoFinishResult2 = new VideoFinishResult();
                videoFinishResult2.setVideoMd5(this.f54991b);
                videoFinishResult2.setVideoUrl(c3.f54980c);
                f();
                return videoFinishResult2;
            } else if (this.f54996g) {
                return null;
            } else {
                ArrayList<Integer> arrayList = c3.f54978a;
                if (ListUtils.isEmpty(arrayList)) {
                    arrayList = new ArrayList<>();
                    int i2 = 0;
                    while (i2 < this.f54994e) {
                        i2++;
                        arrayList.add(Integer.valueOf(i2));
                    }
                }
                String str2 = c3.f54979b;
                d.b.i0.d3.o0.d.f.d g2 = g(arrayList, str2, i);
                if (g2 != null && !this.f54996g) {
                    if (g2.f55013b != 0) {
                        VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                        videoFinishResult3.setErrorNo(g2.f55013b);
                        videoFinishResult3.setUserMessage(g2.f55014c);
                        e(303, g2.f55013b, g2.f55014c);
                        return videoFinishResult3;
                    }
                    d(85);
                    if (!StringUtils.isNull(g2.f55012a)) {
                        VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                        videoFinishResult4.setVideoUrl(g2.f55012a);
                        videoFinishResult4.setVideoMd5(this.f54991b);
                        f();
                        return videoFinishResult4;
                    } else if (this.f54996g || (c2 = c(this.f54994e, j, true, str2)) == null) {
                        return null;
                    } else {
                        VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                        int i3 = c2.f54982e;
                        if (i3 == 0) {
                            videoFinishResult5.setVideoUrl(c2.f54980c);
                            videoFinishResult5.setVideoMd5(this.f54991b);
                            f();
                        } else {
                            videoFinishResult5.setErrorNo(i3);
                            videoFinishResult5.setUserMessage(c2.f54981d);
                            e(304, c2.f54982e, c2.f54981d);
                            TiebaStatic.log(new StatisticItem("c12024").param("params", c2.f54981d));
                        }
                        d(100);
                        return videoFinishResult5;
                    }
                }
            }
        }
        return null;
    }

    @Override // d.b.i0.d3.o0.d.b
    public void b(e eVar) {
        this.f54995f = eVar;
    }

    public final a c(int i, long j, boolean z, String str) {
        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        netWork.addPostData("chunk_sum", String.valueOf(i));
        netWork.addPostData("video_size", String.valueOf(this.f54990a));
        netWork.addPostData("chunk_size", String.valueOf(this.f54993d));
        netWork.addPostData("is_merge", String.valueOf(z ? 1 : 0));
        netWork.addPostData(VideoFinishResult.KEY_VIDEO_MD5, this.f54991b);
        netWork.addPostData("video_len", String.valueOf(j));
        netWork.addPostData(HttpRequest.TBS, TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            netWork.addPostData("upload_id", str);
        }
        String postNetData = netWork.postNetData();
        if (netWork.getNetContext().getResponse().isRequestSuccess()) {
            if (StringUtils.isNull(postNetData)) {
                return null;
            }
            a aVar = new a();
            aVar.a(postNetData);
            return aVar;
        }
        a aVar2 = new a();
        if (netWork.getNetContext().getResponse().isNetSuccess()) {
            aVar2.f54982e = netWork.getNetContext().getResponse().mServerErrorCode;
        } else {
            aVar2.f54982e = netWork.getNetContext().getResponse().mNetErrorCode;
        }
        aVar2.f54981d = netWork.getNetContext().getResponse().mErrorString;
        return aVar2;
    }

    @Override // d.b.i0.d3.o0.d.b
    public void cancel() {
        this.f54996g = true;
        d.b.i0.d3.o0.d.f.a aVar = this.f54997h;
        if (aVar != null) {
            aVar.a();
        }
    }

    public final void d(int i) {
        e eVar = this.f54995f;
        if (eVar != null) {
            eVar.onProgressUpdate(i / 100.0f);
        }
    }

    public final void e(int i, int i2, String str) {
        g gVar = this.i;
        if (gVar != null) {
            gVar.d(i, i2, str);
        }
    }

    public final void f() {
        g gVar = this.i;
        if (gVar != null) {
            gVar.j();
        }
    }

    public final d.b.i0.d3.o0.d.f.d g(ArrayList<Integer> arrayList, String str, int i) {
        if (ListUtils.isEmpty(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.f54997h = new d.b.i0.d3.o0.d.f.b(this.f54992c, this.f54993d, this.f54994e, this.f54990a, this.f54991b);
        } else {
            this.f54997h = new d.b.i0.d3.o0.d.f.c(this.f54992c, this.f54993d, this.f54994e, this.f54990a, this.f54991b);
        }
        this.f54997h.f(this.f54995f);
        d.b.i0.d3.o0.d.f.d g2 = this.f54997h.g(arrayList, str, i);
        this.f54997h = null;
        return g2;
    }
}
