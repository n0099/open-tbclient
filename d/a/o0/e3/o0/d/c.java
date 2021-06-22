package d.a.o0.e3.o0.d;

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
import d.a.c.e.p.q;
import d.a.o0.u1.g;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes5.dex */
public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public NetWork f57979a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f57980b = false;

    /* renamed from: c  reason: collision with root package name */
    public final String f57981c;

    /* renamed from: d  reason: collision with root package name */
    public final int f57982d;

    /* renamed from: e  reason: collision with root package name */
    public final int f57983e;

    /* renamed from: f  reason: collision with root package name */
    public e f57984f;

    /* renamed from: g  reason: collision with root package name */
    public g f57985g;

    public c(String str, int i2, int i3, g gVar) {
        this.f57981c = str;
        this.f57983e = i2;
        this.f57982d = i3 / i2;
        this.f57985g = gVar;
    }

    @Override // d.a.o0.e3.o0.d.b
    public void a(e eVar) {
        this.f57984f = eVar;
    }

    @Override // d.a.o0.e3.o0.d.b
    public VideoFinishResult b(String str, int i2) throws IOException {
        long j;
        VideoBlockUploadResult i3;
        String str2;
        String str3 = null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            d.a.o0.e3.o0.b.a();
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            String b2 = q.b(FileHelper.GetStreamFromFile(file));
            if (!StringUtils.isNull(b2)) {
                b2 = b2.toLowerCase();
            }
            String str4 = b2;
            d.a.o0.e3.o0.c c2 = d.a.o0.e3.o0.b.c(str4);
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, r.f7715a);
            long length = file.length();
            int d2 = d(length, this.f57983e);
            int d3 = d(d2, this.f57982d);
            String str5 = c2 != null ? c2.f57972a : null;
            int i4 = c2 != null ? c2.f57973b : 0;
            if (i4 < d2 && randomAccessFile.skipBytes(this.f57983e * i4) < this.f57983e * i4) {
                randomAccessFile.close();
                return null;
            }
            String str6 = str5;
            int i5 = i4;
            VideoBlockUploadResult videoBlockUploadResult = null;
            while (i5 < d2) {
                f(i5, d2, 10);
                int i6 = i5 + 1;
                int i7 = i5;
                VideoBlockUploadResult videoBlockUploadResult2 = videoBlockUploadResult;
                byte[] c3 = c(randomAccessFile, i5, d2, length);
                f(i7, d2, 25);
                if (c3 == null || c3.length <= 0) {
                    j = length;
                    videoBlockUploadResult = videoBlockUploadResult2;
                } else {
                    f(i7, d2, 40);
                    j = length;
                    this.f57979a = e(str4, length, d3, str6);
                    f(i7, d2, 55);
                    if (i6 == d2) {
                        i3 = j(c3, i6, d3, d2);
                    } else if (i6 % this.f57982d == 0) {
                        VideoBlockUploadResult h2 = h(c3, i6, d3, d2);
                        str2 = h2.upload_id;
                        videoBlockUploadResult = h2;
                        f(i7, d2, 80);
                        if (videoBlockUploadResult == null && !videoBlockUploadResult.isSuccess()) {
                            videoFinishResult.setUserMessage(videoBlockUploadResult.getErrorMessage());
                            videoFinishResult.setErrorNo(videoBlockUploadResult.getErrorCode());
                            g gVar = this.f57985g;
                            if (gVar != null) {
                                gVar.f(305, videoBlockUploadResult.getErrorCode(), videoBlockUploadResult.getErrorMessage());
                            }
                            if (videoFinishResult.getErrorNo() == 320033) {
                                d.a.o0.e3.o0.b.b(str4);
                            }
                            randomAccessFile.close();
                            TiebaStatic.log(new StatisticItem("c12024").param("params", videoBlockUploadResult.getErrorMessage()));
                            return videoFinishResult;
                        }
                        d.a.o0.e3.o0.b.d(str4, str2, i6);
                        f(i7, d2, 100);
                        str6 = str2;
                    } else {
                        i3 = i(i6, c3, d3, d2);
                    }
                    videoBlockUploadResult = i3;
                    str2 = str6;
                    f(i7, d2, 80);
                    if (videoBlockUploadResult == null) {
                    }
                    d.a.o0.e3.o0.b.d(str4, str2, i6);
                    f(i7, d2, 100);
                    str6 = str2;
                }
                i5 = i6;
                length = j;
                str3 = null;
            }
            videoFinishResult.setErrorMessage(str3);
            videoFinishResult.setErrorNo(0);
            if (videoBlockUploadResult != null) {
                videoFinishResult.setVideoUrl(videoBlockUploadResult.video_url);
            }
            d.a.o0.e3.o0.b.b(str4);
            videoFinishResult.setVideoMd5(str4);
            randomAccessFile.close();
            g gVar2 = this.f57985g;
            if (gVar2 != null) {
                gVar2.j();
            }
            return videoFinishResult;
        }
        return null;
    }

    public final byte[] c(RandomAccessFile randomAccessFile, int i2, int i3, long j) {
        int i4;
        if (randomAccessFile != null && i2 >= 0) {
            if (i2 == i3 - 1) {
                i4 = (int) (j - (i2 * this.f57983e));
            } else {
                i4 = this.f57983e;
            }
            byte[] bArr = new byte[i4];
            boolean z = false;
            try {
                z = randomAccessFile.read(bArr, 0, i4) != -1;
            } catch (IOException unused) {
            }
            if (z) {
                return bArr;
            }
        }
        return null;
    }

    @Override // d.a.o0.e3.o0.d.b
    public void cancel() {
        this.f57980b = true;
        NetWork netWork = this.f57979a;
        if (netWork != null) {
            netWork.cancelNetConnect();
        }
    }

    public final int d(long j, int i2) {
        long j2;
        long j3 = i2;
        if (j % j3 == 0) {
            j2 = j / j3;
        } else {
            j2 = (j / j3) + 1;
        }
        return (int) j2;
    }

    public final NetWork e(String str, long j, int i2, String str2) {
        NetWork netWork = new NetWork();
        netWork.addPostData("forum_id", this.f57981c);
        netWork.addPostData(HttpRequest.TBS, TbadkCoreApplication.getInst().getTbs());
        netWork.addPostData("total_length", String.valueOf(j));
        netWork.addPostData(VideoFinishResult.KEY_VIDEO_MD5, str);
        netWork.addPostData("block_num", String.valueOf(i2));
        netWork.addPostData("upload_id", str2);
        return netWork;
    }

    public final void f(int i2, int i3, int i4) {
        e eVar = this.f57984f;
        if (eVar != null) {
            eVar.onProgressUpdate((i2 + (i4 / 100.0f)) / i3);
        }
    }

    public final VideoBlockUploadResult g(NetWork netWork) {
        int netErrorCode;
        String errMsg;
        VideoBlockUploadResult videoBlockUploadResult = new VideoBlockUploadResult();
        if (this.f57980b) {
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

    public final VideoBlockUploadResult h(byte[] bArr, int i2, int i3, int i4) {
        int i5 = this.f57982d;
        int i6 = i2 / i5;
        k(this.f57979a, i5, bArr.length, i6 == i3 ? i4 - ((i6 - 1) * i5) : i5, i6, bArr);
        NetWork netWork = this.f57979a;
        netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_BLOCK);
        return g(this.f57979a);
    }

    public final VideoBlockUploadResult i(int i2, byte[] bArr, int i3, int i4) {
        int i5 = this.f57982d;
        int i6 = i2 % i5;
        int length = bArr.length;
        int i7 = (i2 / i5) + 1;
        if (i7 == i3) {
            i5 = i4 - ((i7 - 1) * i5);
        }
        k(this.f57979a, i6, length, i5, i7, bArr);
        NetWork netWork = this.f57979a;
        netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_CHUNK);
        return g(this.f57979a);
    }

    public final VideoBlockUploadResult j(byte[] bArr, int i2, int i3, int i4) {
        int i5;
        int i6;
        int length = bArr.length;
        int i7 = this.f57982d;
        if (i2 % i7 == 0) {
            i5 = i2 / i7;
        } else {
            i5 = (i2 / i7) + 1;
        }
        int i8 = i5;
        if (i8 == i3) {
            i6 = i4 - ((i8 - 1) * this.f57982d);
        } else {
            i6 = this.f57982d;
        }
        k(this.f57979a, i6, length, i6, i8, bArr);
        NetWork netWork = this.f57979a;
        netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_FILE);
        return g(this.f57979a);
    }

    public final void k(NetWork netWork, int i2, long j, int i3, int i4, byte[] bArr) {
        if (netWork == null) {
            return;
        }
        netWork.addPostData("chunk_no", String.valueOf(i2));
        netWork.addPostData("chunk_length", String.valueOf(j));
        netWork.addPostData("chunk_num", String.valueOf(i3));
        netWork.addPostData("block_no", String.valueOf(i4));
        netWork.addPostData("video_chunk", bArr);
    }
}
