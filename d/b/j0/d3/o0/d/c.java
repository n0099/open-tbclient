package d.b.j0.d3.o0.d;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.tbadkCore.videoupload.VideoBlockUploadResult;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import d.b.c.e.p.q;
import d.b.j0.t1.g;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes5.dex */
public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public NetWork f55404a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f55405b = false;

    /* renamed from: c  reason: collision with root package name */
    public final String f55406c;

    /* renamed from: d  reason: collision with root package name */
    public final int f55407d;

    /* renamed from: e  reason: collision with root package name */
    public final int f55408e;

    /* renamed from: f  reason: collision with root package name */
    public e f55409f;

    /* renamed from: g  reason: collision with root package name */
    public g f55410g;

    public c(String str, int i, int i2, g gVar) {
        this.f55406c = str;
        this.f55408e = i;
        this.f55407d = i2 / i;
        this.f55410g = gVar;
    }

    @Override // d.b.j0.d3.o0.d.b
    public VideoFinishResult a(String str, int i) throws IOException {
        long j;
        VideoBlockUploadResult i2;
        String str2;
        String str3 = null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            d.b.j0.d3.o0.b.a();
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            String b2 = q.b(FileHelper.GetStreamFromFile(file));
            if (!StringUtils.isNull(b2)) {
                b2 = b2.toLowerCase();
            }
            String str4 = b2;
            d.b.j0.d3.o0.c c2 = d.b.j0.d3.o0.b.c(str4);
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, r.f7699a);
            long length = file.length();
            int d2 = d(length, this.f55408e);
            int d3 = d(d2, this.f55407d);
            String str5 = c2 != null ? c2.f55397a : null;
            int i3 = c2 != null ? c2.f55398b : 0;
            if (i3 < d2 && randomAccessFile.skipBytes(this.f55408e * i3) < this.f55408e * i3) {
                randomAccessFile.close();
                return null;
            }
            String str6 = str5;
            int i4 = i3;
            VideoBlockUploadResult videoBlockUploadResult = null;
            while (i4 < d2) {
                f(i4, d2, 10);
                int i5 = i4 + 1;
                int i6 = i4;
                VideoBlockUploadResult videoBlockUploadResult2 = videoBlockUploadResult;
                byte[] c3 = c(randomAccessFile, i4, d2, length);
                f(i6, d2, 25);
                if (c3 == null || c3.length <= 0) {
                    j = length;
                    videoBlockUploadResult = videoBlockUploadResult2;
                } else {
                    f(i6, d2, 40);
                    j = length;
                    this.f55404a = e(str4, length, d3, str6);
                    f(i6, d2, 55);
                    if (i5 == d2) {
                        i2 = j(c3, i5, d3, d2);
                    } else if (i5 % this.f55407d == 0) {
                        VideoBlockUploadResult h2 = h(c3, i5, d3, d2);
                        str2 = h2.upload_id;
                        videoBlockUploadResult = h2;
                        f(i6, d2, 80);
                        if (videoBlockUploadResult == null && !videoBlockUploadResult.isSuccess()) {
                            videoFinishResult.setUserMessage(videoBlockUploadResult.getErrorMessage());
                            videoFinishResult.setErrorNo(videoBlockUploadResult.getErrorCode());
                            g gVar = this.f55410g;
                            if (gVar != null) {
                                gVar.d(305, videoBlockUploadResult.getErrorCode(), videoBlockUploadResult.getErrorMessage());
                            }
                            if (videoFinishResult.getErrorNo() == 320033) {
                                d.b.j0.d3.o0.b.b(str4);
                            }
                            randomAccessFile.close();
                            TiebaStatic.log(new StatisticItem("c12024").param("params", videoBlockUploadResult.getErrorMessage()));
                            return videoFinishResult;
                        }
                        d.b.j0.d3.o0.b.d(str4, str2, i5);
                        f(i6, d2, 100);
                        str6 = str2;
                    } else {
                        i2 = i(i5, c3, d3, d2);
                    }
                    videoBlockUploadResult = i2;
                    str2 = str6;
                    f(i6, d2, 80);
                    if (videoBlockUploadResult == null) {
                    }
                    d.b.j0.d3.o0.b.d(str4, str2, i5);
                    f(i6, d2, 100);
                    str6 = str2;
                }
                i4 = i5;
                length = j;
                str3 = null;
            }
            videoFinishResult.setErrorMessage(str3);
            videoFinishResult.setErrorNo(0);
            if (videoBlockUploadResult != null) {
                videoFinishResult.setVideoUrl(videoBlockUploadResult.video_url);
            }
            d.b.j0.d3.o0.b.b(str4);
            videoFinishResult.setVideoMd5(str4);
            randomAccessFile.close();
            g gVar2 = this.f55410g;
            if (gVar2 != null) {
                gVar2.j();
            }
            return videoFinishResult;
        }
        return null;
    }

    @Override // d.b.j0.d3.o0.d.b
    public void b(e eVar) {
        this.f55409f = eVar;
    }

    public final byte[] c(RandomAccessFile randomAccessFile, int i, int i2, long j) {
        int i3;
        if (randomAccessFile != null && i >= 0) {
            if (i == i2 - 1) {
                i3 = (int) (j - (i * this.f55408e));
            } else {
                i3 = this.f55408e;
            }
            byte[] bArr = new byte[i3];
            boolean z = false;
            try {
                z = randomAccessFile.read(bArr, 0, i3) != -1;
            } catch (IOException unused) {
            }
            if (z) {
                return bArr;
            }
        }
        return null;
    }

    @Override // d.b.j0.d3.o0.d.b
    public void cancel() {
        this.f55405b = true;
        NetWork netWork = this.f55404a;
        if (netWork != null) {
            netWork.cancelNetConnect();
        }
    }

    public final int d(long j, int i) {
        long j2;
        long j3 = i;
        if (j % j3 == 0) {
            j2 = j / j3;
        } else {
            j2 = (j / j3) + 1;
        }
        return (int) j2;
    }

    public final NetWork e(String str, long j, int i, String str2) {
        NetWork netWork = new NetWork();
        netWork.addPostData("forum_id", this.f55406c);
        netWork.addPostData(HttpRequest.TBS, TbadkCoreApplication.getInst().getTbs());
        netWork.addPostData("total_length", String.valueOf(j));
        netWork.addPostData(VideoFinishResult.KEY_VIDEO_MD5, str);
        netWork.addPostData("block_num", String.valueOf(i));
        netWork.addPostData("upload_id", str2);
        return netWork;
    }

    public final void f(int i, int i2, int i3) {
        e eVar = this.f55409f;
        if (eVar != null) {
            eVar.onProgressUpdate((i + (i3 / 100.0f)) / i2);
        }
    }

    public final VideoBlockUploadResult g(NetWork netWork) {
        int netErrorCode;
        String errMsg;
        VideoBlockUploadResult videoBlockUploadResult = new VideoBlockUploadResult();
        if (this.f55405b) {
            netErrorCode = netWork.getServerErrorCode();
            errMsg = netWork.getErrorString();
        } else {
            String postMultiNetData = netWork.postMultiNetData();
            if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                OrmObject objectWithJsonStr = OrmObject.objectWithJsonStr(postMultiNetData, VideoBlockUploadResult.class);
                if (objectWithJsonStr instanceof VideoBlockUploadResult) {
                    VideoBlockUploadResult videoBlockUploadResult2 = (VideoBlockUploadResult) objectWithJsonStr;
                    if (videoBlockUploadResult2.isSuccess()) {
                        netErrorCode = videoBlockUploadResult2.getErrorCode();
                        String errorMessage = videoBlockUploadResult2.getErrorMessage();
                        videoBlockUploadResult.upload_id = videoBlockUploadResult2.upload_id;
                        videoBlockUploadResult.video_url = videoBlockUploadResult2.video_url;
                        errMsg = errorMessage;
                    }
                }
                errMsg = null;
                netErrorCode = 0;
            } else if (netWork.getNetErrorCode() == 200) {
                netErrorCode = netWork.getServerErrorCode();
                errMsg = netWork.getErrorString();
            } else {
                netErrorCode = netWork.getNetErrorCode();
                errMsg = TbErrInfo.getErrMsg(-7);
            }
        }
        videoBlockUploadResult.setErrorNo(netErrorCode);
        videoBlockUploadResult.setErrorMessage(errMsg);
        return videoBlockUploadResult;
    }

    public final VideoBlockUploadResult h(byte[] bArr, int i, int i2, int i3) {
        int i4 = this.f55407d;
        int i5 = i / i4;
        k(this.f55404a, i4, bArr.length, i5 == i2 ? i3 - ((i5 - 1) * i4) : i4, i5, bArr);
        NetWork netWork = this.f55404a;
        netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_BLOCK);
        return g(this.f55404a);
    }

    public final VideoBlockUploadResult i(int i, byte[] bArr, int i2, int i3) {
        int i4 = this.f55407d;
        int i5 = i % i4;
        int length = bArr.length;
        int i6 = (i / i4) + 1;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * i4);
        }
        k(this.f55404a, i5, length, i4, i6, bArr);
        NetWork netWork = this.f55404a;
        netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_CHUNK);
        return g(this.f55404a);
    }

    public final VideoBlockUploadResult j(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5;
        int length = bArr.length;
        int i6 = this.f55407d;
        if (i % i6 == 0) {
            i4 = i / i6;
        } else {
            i4 = (i / i6) + 1;
        }
        int i7 = i4;
        if (i7 == i2) {
            i5 = i3 - ((i7 - 1) * this.f55407d);
        } else {
            i5 = this.f55407d;
        }
        k(this.f55404a, i5, length, i5, i7, bArr);
        NetWork netWork = this.f55404a;
        netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_FILE);
        return g(this.f55404a);
    }

    public final void k(NetWork netWork, int i, long j, int i2, int i3, byte[] bArr) {
        if (netWork == null) {
            return;
        }
        netWork.addPostData("chunk_no", String.valueOf(i));
        netWork.addPostData("chunk_length", String.valueOf(j));
        netWork.addPostData("chunk_num", String.valueOf(i2));
        netWork.addPostData("block_no", String.valueOf(i3));
        netWork.addPostData("video_chunk", bArr);
    }
}
