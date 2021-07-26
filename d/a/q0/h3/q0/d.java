package d.a.q0.h3.q0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.UploadedImageInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ubc.UBCManager;
import d.a.p0.t.c.q;
import d.a.p0.t.c.r;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
        }
    }

    public static void b(WriteData writeData, ErrorData errorData, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, null, writeData, errorData, str) == null) || writeData == null || writeData.getAsyncPublishStatData() == null) {
            return;
        }
        c asyncPublishStatData = writeData.getAsyncPublishStatData();
        asyncPublishStatData.f58771d = System.currentTimeMillis();
        if (errorData != null && errorData.getError_code() == 0) {
            asyncPublishStatData.f58772e = 0;
        } else if (errorData != null) {
            asyncPublishStatData.f58772e = errorData.error_code;
            asyncPublishStatData.f58773f = errorData.error_msg;
        } else {
            asyncPublishStatData.f58772e = -17;
            asyncPublishStatData.f58773f = TbadkCoreApplication.getInst().getApp().getString(R.string.neterror);
        }
        e(asyncPublishStatData);
        a("上传结束（endAsyncPublish）: id =" + asyncPublishStatData.f58770c + "    endTime = " + asyncPublishStatData.f58771d);
    }

    public static void c(WriteData writeData, ImageFileInfo imageFileInfo, ImageUploadResult imageUploadResult) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, writeData, imageFileInfo, imageUploadResult) == null) || writeData == null || imageFileInfo == null || writeData.getAsyncPublishStatData() == null || writeData.getAsyncPublishStatData().f58774g == null || (aVar = writeData.getAsyncPublishStatData().f58774g.f58767e.get(Long.valueOf(imageFileInfo.startUploadTime))) == null) {
            return;
        }
        aVar.f58755b = System.currentTimeMillis();
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null && !TextUtils.isEmpty(uploadedPicInfo.toPostString())) {
                aVar.f58756c = 0;
                aVar.f58758e = uploadedPicInfo.toPostString();
            } else {
                aVar.f58756c = imageUploadResult.error_code;
                aVar.f58757d = imageUploadResult.error_msg;
            }
        } else {
            aVar.f58756c = -53;
            aVar.f58757d = TbadkCoreApplication.getInst().getString(R.string.upload_error);
        }
        a("结束单张上传图片（endAsyncPublishImage）: path =" + imageFileInfo.getFilePath());
        a("结束单张上传图片（网络耗时）: time = " + (aVar.f58755b - aVar.m));
    }

    public static void d(WriteData writeData, ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, writeData, errorData) == null) || writeData == null || writeData.getAsyncPublishStatData() == null || writeData.getAsyncPublishStatData().f58774g == null) {
            return;
        }
        b bVar = writeData.getAsyncPublishStatData().f58774g;
        bVar.f58764b = System.currentTimeMillis();
        if (errorData == null) {
            bVar.f58765c = 0;
        } else {
            bVar.f58765c = errorData.error_code;
            bVar.f58766d = errorData.error_msg;
        }
        a("结束上传多张图片（endAsyncPublishImages）: id =" + bVar.f58763a + "    endTime = " + bVar.f58764b);
    }

    public static void e(@NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, cVar) == null) {
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ext", cVar.b());
                uBCManager.onEvent("4259", jSONObject);
                a("【打点】-【结束】endAsyncPublishStat: id = " + cVar.f58768a);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            j(cVar);
        }
    }

    public static void f(WriteData writeData, VideoFinishResult videoFinishResult) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, writeData, videoFinishResult) == null) || writeData == null || writeData.getAsyncPublishStatData() == null || writeData.getAsyncPublishStatData().f58776i == null) {
            return;
        }
        e eVar = writeData.getAsyncPublishStatData().f58776i;
        eVar.f58778b = System.currentTimeMillis();
        if (videoFinishResult == null) {
            eVar.f58782f = -53;
        } else if (videoFinishResult.isSuccess()) {
            eVar.f58782f = 0;
            eVar.f58784h = videoFinishResult.getVideoMd5();
            eVar.f58785i = videoFinishResult.getVideoUrl();
        } else {
            eVar.f58782f = videoFinishResult.getErrorNo();
            eVar.f58783g = videoFinishResult.getUserMessage();
        }
        a("上传视频结束（endAsyncPublishVideo）: id =" + eVar.f58777a + "    endTime = " + eVar.f58778b);
    }

    public static void g(WriteData writeData, ImageUploadResult imageUploadResult) {
        ImageUploadResult.PicDetailedInfo picDetailedInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, writeData, imageUploadResult) == null) || writeData == null || writeData.getAsyncPublishStatData() == null || writeData.getAsyncPublishStatData().j == null) {
            return;
        }
        a aVar = writeData.getAsyncPublishStatData().j;
        aVar.f58755b = System.currentTimeMillis();
        if (imageUploadResult == null) {
            aVar.f58756c = -53;
        } else {
            ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
            if (picinfo != null && (picDetailedInfo = picinfo.bigPic) != null && !StringUtils.isNull(picDetailedInfo.picUrl)) {
                aVar.f58756c = 0;
                aVar.f58758e = imageUploadResult.picInfo.bigPic.picUrl;
            } else {
                aVar.f58756c = imageUploadResult.error_code;
                aVar.f58757d = imageUploadResult.error_msg;
            }
        }
        a("上传视频首帧结束（endAsyncPublishVideoFirstFrame）: id =" + aVar.f58754a + "    endTime = " + aVar.f58755b);
    }

    public static void h(WriteData writeData, r rVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, writeData, rVar) == null) || writeData == null || writeData.getAsyncPublishStatData() == null || writeData.getAsyncPublishStatData().f58775h == null) {
            return;
        }
        f fVar = writeData.getAsyncPublishStatData().f58775h;
        fVar.f58787b = System.currentTimeMillis();
        if (rVar != null && rVar.d()) {
            q a2 = rVar.a();
            if (a2 != null) {
                fVar.f58789d = 0;
                fVar.f58791f = a2.b();
            } else {
                fVar.f58789d = rVar.b();
                fVar.f58790e = rVar.c();
            }
        } else if (rVar != null) {
            fVar.f58789d = rVar.b();
            fVar.f58790e = rVar.c();
        } else {
            fVar.f58789d = TbErrInfo.ERR_VOI_SEND;
        }
        a("上传声音结束（endAsyncPublishVoice）: id =" + fVar.f58786a + "    endTime = " + fVar.f58787b);
    }

    public static void i(WriteData writeData, ImageFileInfo imageFileInfo, String str, int[] iArr, long j) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{writeData, imageFileInfo, str, iArr, Long.valueOf(j)}) == null) || writeData == null || imageFileInfo == null || writeData.getAsyncPublishStatData() == null || writeData.getAsyncPublishStatData().f58774g == null || (aVar = writeData.getAsyncPublishStatData().f58774g.f58767e.get(Long.valueOf(imageFileInfo.startUploadTime))) == null) {
            return;
        }
        aVar.m = System.currentTimeMillis();
        aVar.p = str;
        aVar.q = iArr[0];
        aVar.r = iArr[1];
        aVar.s = j;
        a("压缩结束（endCompressImage）: path =" + str + "\n   w =" + iArr[0] + " h =" + iArr[1] + "  size =" + (((float) j) / 1048576.0f) + "MB");
    }

    public static void j(@NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, cVar) == null) {
            try {
                d.a.d.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
                statsItem.b("action", "async_publish_end");
                statsItem.b("extId", String.valueOf(cVar.f58768a));
                statsItem.b("parentId", String.valueOf(cVar.f58769b));
                statsItem.b("startTime", String.valueOf(cVar.f58770c));
                statsItem.b("endTime", String.valueOf(cVar.f58771d));
                statsItem.b("errorCode", String.valueOf(cVar.f58772e));
                statsItem.b("errorMessage", cVar.f58773f);
                String str = "";
                statsItem.b("imagesData", cVar.f58774g == null ? "" : cVar.f58774g.a().toString());
                statsItem.b("voiceData", cVar.f58775h == null ? "" : cVar.f58775h.a().toString());
                statsItem.b("videoData", cVar.f58776i == null ? "" : cVar.f58776i.a().toString());
                if (cVar.j != null) {
                    str = cVar.j.a().toString();
                }
                statsItem.b("videoFirstFrame", str);
                BdStatisticsManager.getInstance().performance("thread", statsItem);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void k(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, writeData) == null) || writeData == null || writeData.startPublishTime() <= 0) {
            return;
        }
        c cVar = new c(writeData);
        writeData.setAsyncPublishStatData(cVar);
        a("开始后台上传（startAsyncPublish） id = " + cVar.f58768a + "  parentId = " + cVar.f58769b);
        n(cVar);
    }

    public static void l(WriteData writeData, ImageFileInfo imageFileInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65547, null, writeData, imageFileInfo) == null) || writeData == null || imageFileInfo == null || writeData.getAsyncPublishStatData() == null || writeData.getAsyncPublishStatData().f58774g == null) {
            return;
        }
        writeData.getAsyncPublishStatData().f58774g.f58767e.put(Long.valueOf(imageFileInfo.startUploadTime), new a(imageFileInfo));
        a("多张图片开始上传(startAsyncPublishImage): path =" + imageFileInfo.getFilePath());
    }

    public static void m(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, null, writeData) == null) || writeData == null || writeData.getAsyncPublishStatData() == null) {
            return;
        }
        c asyncPublishStatData = writeData.getAsyncPublishStatData();
        asyncPublishStatData.f58774g = new b();
        a("多张图片开始上传（startAsyncPublishImages）: startTime = " + asyncPublishStatData.f58774g.f58763a);
    }

    public static void n(@NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, cVar) == null) {
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ext", cVar.a());
                uBCManager.onEvent("4260", jSONObject);
                a("【打点】-【点击】startAsyncPublishStat: id = " + cVar.f58768a);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            s(cVar);
        }
    }

    public static void o(WriteData writeData, VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65550, null, writeData, videoInfo) == null) || writeData == null || videoInfo == null || writeData.getAsyncPublishStatData() == null) {
            return;
        }
        c asyncPublishStatData = writeData.getAsyncPublishStatData();
        e eVar = new e(videoInfo);
        asyncPublishStatData.f58776i = eVar;
        eVar.f58781e = FileHelper.getFileSize(videoInfo.getVideoPath());
        a("开始上传视频（startAsyncPublishVideo）: id =" + videoInfo.getVideoPath());
    }

    public static void p(WriteData writeData, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65551, null, writeData, str) == null) || writeData == null || TextUtils.isEmpty(str) || writeData.getAsyncPublishStatData() == null) {
            return;
        }
        c asyncPublishStatData = writeData.getAsyncPublishStatData();
        a aVar = new a(str);
        asyncPublishStatData.j = aVar;
        aVar.f58760g = FileHelper.getFileSize(str);
        a("开始上传视频首帧（startAsyncPublishVideoFirstFrame): path =" + asyncPublishStatData.j.f58759f);
    }

    public static void q(WriteData writeData, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(65552, null, writeData, j) == null) || writeData == null || writeData.getAsyncPublishStatData() == null || TextUtils.isEmpty(writeData.getVoice())) {
            return;
        }
        c asyncPublishStatData = writeData.getAsyncPublishStatData();
        f fVar = new f(writeData.getVoice());
        fVar.f58792g = j;
        asyncPublishStatData.f58775h = fVar;
        a("开始上传声音（startAsyncPublishVoice）: id =" + fVar.f58788c);
    }

    public static void r(WriteData writeData, ImageFileInfo imageFileInfo, String str, int[] iArr, long j, boolean z, boolean z2, boolean z3, String str2) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{writeData, imageFileInfo, str, iArr, Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), str2}) == null) || writeData == null || imageFileInfo == null || writeData.getAsyncPublishStatData() == null || writeData.getAsyncPublishStatData().f58774g == null || (aVar = writeData.getAsyncPublishStatData().f58774g.f58767e.get(Long.valueOf(imageFileInfo.startUploadTime))) == null) {
            return;
        }
        aVar.l = System.currentTimeMillis();
        aVar.f58759f = str;
        aVar.f58761h = iArr[0];
        aVar.f58762i = iArr[1];
        aVar.f58760g = j;
        aVar.j = z;
        aVar.k = z2;
        aVar.n = z3;
        aVar.o = str2;
        a("开始压缩（startCompressImage）: path =" + str + "\n   w =" + iArr[0] + " h =" + iArr[1] + "  size =" + (((float) j) / 1048576.0f) + "MB\n   isLongImage =" + z + "  isHeifImage =" + z2 + " resize =" + z3 + " uploadStrategy =" + str2);
    }

    public static void s(@NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, cVar) == null) {
            d.a.d.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
            statsItem.b("action", "async_publish_start");
            statsItem.b("extId", String.valueOf(cVar.f58768a));
            statsItem.b("parentId", String.valueOf(cVar.f58769b));
            statsItem.b("startTime", String.valueOf(cVar.f58770c));
            BdStatisticsManager.getInstance().performance("thread", statsItem);
        }
    }
}
