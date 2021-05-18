package d.a.k0.d3.o0.d;

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
import d.a.c.e.p.q;
import d.a.k0.t1.g;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class d implements b {

    /* renamed from: a  reason: collision with root package name */
    public long f53959a;

    /* renamed from: b  reason: collision with root package name */
    public String f53960b;

    /* renamed from: c  reason: collision with root package name */
    public String f53961c;

    /* renamed from: d  reason: collision with root package name */
    public final int f53962d;

    /* renamed from: e  reason: collision with root package name */
    public int f53963e;

    /* renamed from: f  reason: collision with root package name */
    public e f53964f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f53965g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.k0.d3.o0.d.f.a f53966h;

    /* renamed from: i  reason: collision with root package name */
    public g f53967i;

    public d(String str, int i2, g gVar) {
        this.f53961c = str;
        this.f53962d = i2;
        this.f53967i = gVar;
        File file = new File(str);
        if (file.exists()) {
            this.f53959a = file.length();
            this.f53960b = q.b(FileHelper.GetStreamFromFile(file));
            long j = this.f53959a;
            int i3 = this.f53962d;
            if (j % i3 == 0) {
                this.f53963e = (int) (j / i3);
            } else {
                this.f53963e = ((int) (j / i3)) + 1;
            }
        }
    }

    @Override // d.a.k0.d3.o0.d.b
    public void a(e eVar) {
        this.f53964f = eVar;
    }

    @Override // d.a.k0.d3.o0.d.b
    public VideoFinishResult b(String str, int i2) {
        a c2;
        if (StringUtils.isNull(str) || this.f53959a <= 0 || StringUtils.isNull(this.f53960b) || i2 <= 0 || this.f53965g) {
            return null;
        }
        d(10);
        long j = i2;
        a c3 = c(this.f53963e, j, false, null);
        if (c3 != null && !this.f53965g) {
            if (c3.f53951e != 0) {
                VideoFinishResult videoFinishResult = new VideoFinishResult();
                videoFinishResult.setErrorNo(c3.f53951e);
                videoFinishResult.setUserMessage(c3.f53950d);
                e(302, c3.f53951e, c3.f53950d);
                return videoFinishResult;
            }
            d(30);
            if (!StringUtils.isNull(c3.f53949c)) {
                VideoFinishResult videoFinishResult2 = new VideoFinishResult();
                videoFinishResult2.setVideoMd5(this.f53960b);
                videoFinishResult2.setVideoUrl(c3.f53949c);
                f();
                return videoFinishResult2;
            } else if (this.f53965g) {
                return null;
            } else {
                ArrayList<Integer> arrayList = c3.f53947a;
                if (ListUtils.isEmpty(arrayList)) {
                    arrayList = new ArrayList<>();
                    int i3 = 0;
                    while (i3 < this.f53963e) {
                        i3++;
                        arrayList.add(Integer.valueOf(i3));
                    }
                }
                String str2 = c3.f53948b;
                d.a.k0.d3.o0.d.f.d g2 = g(arrayList, str2, i2);
                if (g2 != null && !this.f53965g) {
                    if (g2.f53985b != 0) {
                        VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                        videoFinishResult3.setErrorNo(g2.f53985b);
                        videoFinishResult3.setUserMessage(g2.f53986c);
                        e(303, g2.f53985b, g2.f53986c);
                        return videoFinishResult3;
                    }
                    d(85);
                    if (!StringUtils.isNull(g2.f53984a)) {
                        VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                        videoFinishResult4.setVideoUrl(g2.f53984a);
                        videoFinishResult4.setVideoMd5(this.f53960b);
                        f();
                        return videoFinishResult4;
                    } else if (this.f53965g || (c2 = c(this.f53963e, j, true, str2)) == null) {
                        return null;
                    } else {
                        VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                        int i4 = c2.f53951e;
                        if (i4 == 0) {
                            videoFinishResult5.setVideoUrl(c2.f53949c);
                            videoFinishResult5.setVideoMd5(this.f53960b);
                            f();
                        } else {
                            videoFinishResult5.setErrorNo(i4);
                            videoFinishResult5.setUserMessage(c2.f53950d);
                            e(304, c2.f53951e, c2.f53950d);
                            TiebaStatic.log(new StatisticItem("c12024").param("params", c2.f53950d));
                        }
                        d(100);
                        return videoFinishResult5;
                    }
                }
            }
        }
        return null;
    }

    public final a c(int i2, long j, boolean z, String str) {
        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        netWork.addPostData("chunk_sum", String.valueOf(i2));
        netWork.addPostData("video_size", String.valueOf(this.f53959a));
        netWork.addPostData("chunk_size", String.valueOf(this.f53962d));
        netWork.addPostData("is_merge", String.valueOf(z ? 1 : 0));
        netWork.addPostData(VideoFinishResult.KEY_VIDEO_MD5, this.f53960b);
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
            aVar2.f53951e = netWork.getNetContext().getResponse().mServerErrorCode;
        } else {
            aVar2.f53951e = netWork.getNetContext().getResponse().mNetErrorCode;
        }
        aVar2.f53950d = netWork.getNetContext().getResponse().mErrorString;
        return aVar2;
    }

    @Override // d.a.k0.d3.o0.d.b
    public void cancel() {
        this.f53965g = true;
        d.a.k0.d3.o0.d.f.a aVar = this.f53966h;
        if (aVar != null) {
            aVar.a();
        }
    }

    public final void d(int i2) {
        e eVar = this.f53964f;
        if (eVar != null) {
            eVar.onProgressUpdate(i2 / 100.0f);
        }
    }

    public final void e(int i2, int i3, String str) {
        g gVar = this.f53967i;
        if (gVar != null) {
            gVar.f(i2, i3, str);
        }
    }

    public final void f() {
        g gVar = this.f53967i;
        if (gVar != null) {
            gVar.j();
        }
    }

    public final d.a.k0.d3.o0.d.f.d g(ArrayList<Integer> arrayList, String str, int i2) {
        if (ListUtils.isEmpty(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.f53966h = new d.a.k0.d3.o0.d.f.b(this.f53961c, this.f53962d, this.f53963e, this.f53959a, this.f53960b);
        } else {
            this.f53966h = new d.a.k0.d3.o0.d.f.c(this.f53961c, this.f53962d, this.f53963e, this.f53959a, this.f53960b);
        }
        this.f53966h.f(this.f53964f);
        d.a.k0.d3.o0.d.f.d g2 = this.f53966h.g(arrayList, str, i2);
        this.f53966h = null;
        return g2;
    }
}
