package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes6.dex */
public class gm8 implements fm8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NetWork a;
    public boolean b;
    public final String c;
    public final int d;
    public final int e;
    public im8 f;
    public wl7 g;

    public gm8(String str, int i, int i2, wl7 wl7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2), wl7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = false;
        this.c = str;
        this.e = i;
        this.d = i2 / i;
        this.g = wl7Var;
    }

    @Override // com.repackage.fm8
    public void a(im8 im8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, im8Var) == null) {
            this.f = im8Var;
        }
    }

    @Override // com.repackage.fm8
    public VideoFinishResult b(String str, int i) throws IOException {
        InterceptResult invokeLI;
        long j;
        VideoBlockUploadResult i2;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) {
            String str3 = null;
            if (StringUtils.isNull(str)) {
                return null;
            }
            File file = new File(str);
            if (file.exists()) {
                cm8.a();
                VideoFinishResult videoFinishResult = new VideoFinishResult();
                String b = ui.b(FileHelper.GetStreamFromFile(file));
                if (!StringUtils.isNull(b)) {
                    b = b.toLowerCase();
                }
                String str4 = b;
                dm8 c = cm8.c(str4);
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
                long length = file.length();
                int d = d(length, this.e);
                int d2 = d(d, this.d);
                String str5 = c != null ? c.a : null;
                int i3 = c != null ? c.b : 0;
                if (i3 < d && randomAccessFile.skipBytes(this.e * i3) < this.e * i3) {
                    randomAccessFile.close();
                    return null;
                }
                String str6 = str5;
                int i4 = i3;
                VideoBlockUploadResult videoBlockUploadResult = null;
                while (i4 < d) {
                    f(i4, d, 10);
                    int i5 = i4 + 1;
                    int i6 = i4;
                    VideoBlockUploadResult videoBlockUploadResult2 = videoBlockUploadResult;
                    byte[] c2 = c(randomAccessFile, i4, d, length);
                    f(i6, d, 25);
                    if (c2 == null || c2.length <= 0) {
                        j = length;
                        videoBlockUploadResult = videoBlockUploadResult2;
                    } else {
                        f(i6, d, 40);
                        j = length;
                        this.a = e(str4, length, d2, str6);
                        f(i6, d, 55);
                        if (i5 == d) {
                            i2 = j(c2, i5, d2, d);
                        } else if (i5 % this.d == 0) {
                            VideoBlockUploadResult h = h(c2, i5, d2, d);
                            str2 = h.upload_id;
                            videoBlockUploadResult = h;
                            f(i6, d, 80);
                            if (videoBlockUploadResult == null && !videoBlockUploadResult.isSuccess()) {
                                videoFinishResult.setUserMessage(videoBlockUploadResult.getErrorMessage());
                                videoFinishResult.setErrorNo(videoBlockUploadResult.getErrorCode());
                                wl7 wl7Var = this.g;
                                if (wl7Var != null) {
                                    wl7Var.f(305, videoBlockUploadResult.getErrorCode(), videoBlockUploadResult.getErrorMessage());
                                }
                                if (videoFinishResult.getErrorNo() == 320033) {
                                    cm8.b(str4);
                                }
                                randomAccessFile.close();
                                TiebaStatic.log(new StatisticItem("c12024").param("params", videoBlockUploadResult.getErrorMessage()));
                                return videoFinishResult;
                            }
                            cm8.d(str4, str2, i5);
                            f(i6, d, 100);
                            str6 = str2;
                        } else {
                            i2 = i(i5, c2, d2, d);
                        }
                        videoBlockUploadResult = i2;
                        str2 = str6;
                        f(i6, d, 80);
                        if (videoBlockUploadResult == null) {
                        }
                        cm8.d(str4, str2, i5);
                        f(i6, d, 100);
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
                cm8.b(str4);
                videoFinishResult.setVideoMd5(str4);
                randomAccessFile.close();
                wl7 wl7Var2 = this.g;
                if (wl7Var2 != null) {
                    wl7Var2.j();
                }
                return videoFinishResult;
            }
            return null;
        }
        return (VideoFinishResult) invokeLI.objValue;
    }

    public final byte[] c(RandomAccessFile randomAccessFile, int i, int i2, long j) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{randomAccessFile, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            if (randomAccessFile != null && i >= 0) {
                if (i == i2 - 1) {
                    i3 = (int) (j - (i * this.e));
                } else {
                    i3 = this.e;
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
        return (byte[]) invokeCommon.objValue;
    }

    @Override // com.repackage.fm8
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b = true;
            NetWork netWork = this.a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
        }
    }

    public final int d(long j, int i) {
        InterceptResult invokeCommon;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)})) == null) {
            long j3 = i;
            if (j % j3 == 0) {
                j2 = j / j3;
            } else {
                j2 = (j / j3) + 1;
            }
            return (int) j2;
        }
        return invokeCommon.intValue;
    }

    public final NetWork e(String str, long j, int i, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{str, Long.valueOf(j), Integer.valueOf(i), str2})) == null) {
            NetWork netWork = new NetWork();
            netWork.addPostData("forum_id", this.c);
            netWork.addPostData(HttpRequest.TBS, TbadkCoreApplication.getInst().getTbs());
            netWork.addPostData("total_length", String.valueOf(j));
            netWork.addPostData(VideoFinishResult.KEY_VIDEO_MD5, str);
            netWork.addPostData("block_num", String.valueOf(i));
            netWork.addPostData("upload_id", str2);
            return netWork;
        }
        return (NetWork) invokeCommon.objValue;
    }

    public final void f(int i, int i2, int i3) {
        im8 im8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048582, this, i, i2, i3) == null) || (im8Var = this.f) == null) {
            return;
        }
        im8Var.onProgressUpdate((i + (i3 / 100.0f)) / i2);
    }

    public final VideoBlockUploadResult g(NetWork netWork) {
        InterceptResult invokeL;
        int netErrorCode;
        String errMsg;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, netWork)) == null) {
            VideoBlockUploadResult videoBlockUploadResult = new VideoBlockUploadResult();
            if (this.b) {
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
        return (VideoBlockUploadResult) invokeL.objValue;
    }

    public final VideoBlockUploadResult h(byte[] bArr, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr, i, i2, i3)) == null) {
            int i4 = this.d;
            int i5 = i / i4;
            k(this.a, i4, bArr.length, i5 == i2 ? i3 - ((i5 - 1) * i4) : i4, i5, bArr);
            NetWork netWork = this.a;
            netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_BLOCK);
            return g(this.a);
        }
        return (VideoBlockUploadResult) invokeLIII.objValue;
    }

    public final VideoBlockUploadResult i(int i, byte[] bArr, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), bArr, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            int i4 = this.d;
            int i5 = i % i4;
            int length = bArr.length;
            int i6 = (i / i4) + 1;
            if (i6 == i2) {
                i4 = i3 - ((i6 - 1) * i4);
            }
            k(this.a, i5, length, i4, i6, bArr);
            NetWork netWork = this.a;
            netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_CHUNK);
            return g(this.a);
        }
        return (VideoBlockUploadResult) invokeCommon.objValue;
    }

    public final VideoBlockUploadResult j(byte[] bArr, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(1048586, this, bArr, i, i2, i3)) == null) {
            int length = bArr.length;
            int i6 = this.d;
            if (i % i6 == 0) {
                i4 = i / i6;
            } else {
                i4 = (i / i6) + 1;
            }
            int i7 = i4;
            if (i7 == i2) {
                i5 = i3 - ((i7 - 1) * this.d);
            } else {
                i5 = this.d;
            }
            k(this.a, i5, length, i5, i7, bArr);
            NetWork netWork = this.a;
            netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_FILE);
            return g(this.a);
        }
        return (VideoBlockUploadResult) invokeLIII.objValue;
    }

    public final void k(NetWork netWork, int i, long j, int i2, int i3, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{netWork, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), bArr}) == null) || netWork == null) {
            return;
        }
        netWork.addPostData("chunk_no", String.valueOf(i));
        netWork.addPostData("chunk_length", String.valueOf(j));
        netWork.addPostData("chunk_num", String.valueOf(i2));
        netWork.addPostData("block_no", String.valueOf(i3));
        netWork.addPostData("video_chunk", bArr);
    }
}
