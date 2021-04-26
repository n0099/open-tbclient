package d.a.j0.d3.o0.d;

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
import d.a.j0.t1.g;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class d implements b {

    /* renamed from: a  reason: collision with root package name */
    public long f53252a;

    /* renamed from: b  reason: collision with root package name */
    public String f53253b;

    /* renamed from: c  reason: collision with root package name */
    public String f53254c;

    /* renamed from: d  reason: collision with root package name */
    public final int f53255d;

    /* renamed from: e  reason: collision with root package name */
    public int f53256e;

    /* renamed from: f  reason: collision with root package name */
    public e f53257f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f53258g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.j0.d3.o0.d.f.a f53259h;

    /* renamed from: i  reason: collision with root package name */
    public g f53260i;

    public d(String str, int i2, g gVar) {
        this.f53254c = str;
        this.f53255d = i2;
        this.f53260i = gVar;
        File file = new File(str);
        if (file.exists()) {
            this.f53252a = file.length();
            this.f53253b = q.b(FileHelper.GetStreamFromFile(file));
            long j = this.f53252a;
            int i3 = this.f53255d;
            if (j % i3 == 0) {
                this.f53256e = (int) (j / i3);
            } else {
                this.f53256e = ((int) (j / i3)) + 1;
            }
        }
    }

    @Override // d.a.j0.d3.o0.d.b
    public void a(e eVar) {
        this.f53257f = eVar;
    }

    @Override // d.a.j0.d3.o0.d.b
    public VideoFinishResult b(String str, int i2) {
        a c2;
        if (StringUtils.isNull(str) || this.f53252a <= 0 || StringUtils.isNull(this.f53253b) || i2 <= 0 || this.f53258g) {
            return null;
        }
        d(10);
        long j = i2;
        a c3 = c(this.f53256e, j, false, null);
        if (c3 != null && !this.f53258g) {
            if (c3.f53244e != 0) {
                VideoFinishResult videoFinishResult = new VideoFinishResult();
                videoFinishResult.setErrorNo(c3.f53244e);
                videoFinishResult.setUserMessage(c3.f53243d);
                e(302, c3.f53244e, c3.f53243d);
                return videoFinishResult;
            }
            d(30);
            if (!StringUtils.isNull(c3.f53242c)) {
                VideoFinishResult videoFinishResult2 = new VideoFinishResult();
                videoFinishResult2.setVideoMd5(this.f53253b);
                videoFinishResult2.setVideoUrl(c3.f53242c);
                f();
                return videoFinishResult2;
            } else if (this.f53258g) {
                return null;
            } else {
                ArrayList<Integer> arrayList = c3.f53240a;
                if (ListUtils.isEmpty(arrayList)) {
                    arrayList = new ArrayList<>();
                    int i3 = 0;
                    while (i3 < this.f53256e) {
                        i3++;
                        arrayList.add(Integer.valueOf(i3));
                    }
                }
                String str2 = c3.f53241b;
                d.a.j0.d3.o0.d.f.d g2 = g(arrayList, str2, i2);
                if (g2 != null && !this.f53258g) {
                    if (g2.f53278b != 0) {
                        VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                        videoFinishResult3.setErrorNo(g2.f53278b);
                        videoFinishResult3.setUserMessage(g2.f53279c);
                        e(303, g2.f53278b, g2.f53279c);
                        return videoFinishResult3;
                    }
                    d(85);
                    if (!StringUtils.isNull(g2.f53277a)) {
                        VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                        videoFinishResult4.setVideoUrl(g2.f53277a);
                        videoFinishResult4.setVideoMd5(this.f53253b);
                        f();
                        return videoFinishResult4;
                    } else if (this.f53258g || (c2 = c(this.f53256e, j, true, str2)) == null) {
                        return null;
                    } else {
                        VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                        int i4 = c2.f53244e;
                        if (i4 == 0) {
                            videoFinishResult5.setVideoUrl(c2.f53242c);
                            videoFinishResult5.setVideoMd5(this.f53253b);
                            f();
                        } else {
                            videoFinishResult5.setErrorNo(i4);
                            videoFinishResult5.setUserMessage(c2.f53243d);
                            e(304, c2.f53244e, c2.f53243d);
                            TiebaStatic.log(new StatisticItem("c12024").param("params", c2.f53243d));
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
        netWork.addPostData("video_size", String.valueOf(this.f53252a));
        netWork.addPostData("chunk_size", String.valueOf(this.f53255d));
        netWork.addPostData("is_merge", String.valueOf(z ? 1 : 0));
        netWork.addPostData(VideoFinishResult.KEY_VIDEO_MD5, this.f53253b);
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
            aVar2.f53244e = netWork.getNetContext().getResponse().mServerErrorCode;
        } else {
            aVar2.f53244e = netWork.getNetContext().getResponse().mNetErrorCode;
        }
        aVar2.f53243d = netWork.getNetContext().getResponse().mErrorString;
        return aVar2;
    }

    @Override // d.a.j0.d3.o0.d.b
    public void cancel() {
        this.f53258g = true;
        d.a.j0.d3.o0.d.f.a aVar = this.f53259h;
        if (aVar != null) {
            aVar.a();
        }
    }

    public final void d(int i2) {
        e eVar = this.f53257f;
        if (eVar != null) {
            eVar.onProgressUpdate(i2 / 100.0f);
        }
    }

    public final void e(int i2, int i3, String str) {
        g gVar = this.f53260i;
        if (gVar != null) {
            gVar.f(i2, i3, str);
        }
    }

    public final void f() {
        g gVar = this.f53260i;
        if (gVar != null) {
            gVar.j();
        }
    }

    public final d.a.j0.d3.o0.d.f.d g(ArrayList<Integer> arrayList, String str, int i2) {
        if (ListUtils.isEmpty(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.f53259h = new d.a.j0.d3.o0.d.f.b(this.f53254c, this.f53255d, this.f53256e, this.f53252a, this.f53253b);
        } else {
            this.f53259h = new d.a.j0.d3.o0.d.f.c(this.f53254c, this.f53255d, this.f53256e, this.f53252a, this.f53253b);
        }
        this.f53259h.f(this.f53257f);
        d.a.j0.d3.o0.d.f.d g2 = this.f53259h.g(arrayList, str, i2);
        this.f53259h = null;
        return g2;
    }
}
