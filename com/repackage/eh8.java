package com.repackage;

import android.location.Address;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.PublishProgressData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.core.util.FieldBuilder;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.ImageUploader;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.switchs.UploadPicParallelSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class eh8 {
    public static /* synthetic */ Interceptable $ic;
    public static final String k;
    public static final String l;
    public static final String m;
    public transient /* synthetic */ FieldHolder $fh;
    public NetWork a;
    public ErrorData b;
    public boolean c;
    public AntiData d;
    public ImageUploader e;
    public gi8 f;
    public c g;
    public hj7 h;
    public SpanGroupManager i;
    public String j;

    /* loaded from: classes5.dex */
    public class a implements ImageUploader.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteImagesInfo a;
        public final /* synthetic */ WriteData b;

        public a(eh8 eh8Var, WriteImagesInfo writeImagesInfo, WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eh8Var, writeImagesInfo, writeData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeImagesInfo;
            this.b = writeData;
        }

        @Override // com.baidu.tbadk.img.ImageUploader.b
        public void a(String str, Object obj, long j, long j2, int i, int i2) {
            int i3;
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, obj, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
                xi8.a("发帖：发送图片 进度 = " + i + "/" + i2 + " :" + j + "/" + j2 + "   ，" + str);
                WriteImagesInfo writeImagesInfo = this.a;
                if (writeImagesInfo == null || (i3 = writeImagesInfo.hasUploadFileSize) <= 0 || (i4 = writeImagesInfo.allImageFileSize) <= 0) {
                    return;
                }
                float f = (i3 * 1.0f) / i4;
                PublishProgressData.valueOf(this.b, (int) ((f <= 1.0f ? f : 1.0f) * 90.0f)).send(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ni8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final /* synthetic */ WriteData b;
        public final /* synthetic */ eh8 c;

        public b(eh8 eh8Var, WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eh8Var, writeData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = eh8Var;
            this.b = writeData;
            this.a = 0;
        }

        @Override // com.repackage.ni8
        public void onProgressUpdate(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048576, this, f) == null) {
                xi8.a("发帖：开始上传视频 percent = " + f);
                int i = (int) (f * 90.0f);
                PublishProgressData.valueOf(this.b, i).send(true);
                if (i != this.a) {
                    this.a = i;
                    this.c.f(i);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(int i);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755737508, "Lcom/repackage/eh8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755737508, "Lcom/repackage/eh8;");
                return;
            }
        }
        k = TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS;
        l = TbConfig.SERVER_ADDRESS + TbConfig.REPLY_THREAD_ADDRESS;
        m = TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_FOR_SHARE_ADDRESS;
    }

    public eh8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = false;
        this.b = new ErrorData();
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c = true;
            NetWork netWork = this.a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            ImageUploader imageUploader = this.e;
            if (imageUploader != null) {
                imageUploader.cancel();
            }
            gi8 gi8Var = this.f;
            if (gi8Var != null) {
                gi8Var.a();
            }
        }
    }

    public AntiData c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d : (AntiData) invokeV.objValue;
    }

    public ErrorData d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (ErrorData) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            NetWork netWork = this.a;
            if (netWork == null) {
                return false;
            }
            return netWork.getNetContext().getResponse().isRequestSuccess();
        }
        return invokeV.booleanValue;
    }

    public final void f(int i) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || (cVar = this.g) == null) {
            return;
        }
        cVar.a(i);
    }

    public String g(WriteData writeData, boolean z) {
        InterceptResult invokeLZ;
        String content;
        String returnVoiceMd5;
        boolean z2;
        String str;
        String str2;
        String title;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        ImageUploadResult.PicDetailedInfo picDetailedInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048581, this, writeData, z)) == null) {
            String str9 = null;
            if (writeData == null) {
                return null;
            }
            xi8.a("发帖：postWriteData 开始");
            NetWork netWork = new NetWork();
            this.a = netWork;
            netWork.getNetContext().getRequest().mIsNeedTbs = true;
            this.a.setNeedSig(true);
            this.a.addPostData("authsid", writeData.getAuthSid());
            if (!TextUtils.isEmpty(this.j)) {
                content = this.j;
                writeData.setSpanGroupString(content);
            } else {
                SpanGroupManager spanGroupManager = this.i;
                if (spanGroupManager != null) {
                    content = spanGroupManager.E();
                    writeData.setSpanGroupString(content);
                } else if (!TextUtils.isEmpty(writeData.getSpanGroupString())) {
                    content = writeData.getSpanGroupString();
                } else {
                    content = writeData.getContent();
                }
            }
            if (writeData.getPortrait() != null && writeData.getName() != null && writeData.getSubPbReplyPrefix() != null) {
                content = "回复 #(reply, " + writeData.getPortrait() + StringUtil.ARRAY_ELEMENT_SEPARATOR + writeData.getName() + ") :" + content;
            } else if (writeData.getSubPbReplyPrefix() != null) {
                content = writeData.getSubPbReplyPrefix() + content;
            }
            if (!TextUtils.isEmpty(writeData.getZhongcePrefix())) {
                content = writeData.getZhongcePrefix() + content;
            }
            String str10 = content;
            xi8.a("发帖：发帖类型：" + writeData.getType());
            String str11 = "1";
            if (writeData.getType() == 3) {
                xi8.a("发帖：SHARE_SDK：设置数据");
                if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                    this.a.addPostData("vcode", writeData.getVcode());
                }
                if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                    this.a.addPostData("tag", "11");
                }
                this.a.addPostData("newVcode", "1");
                this.a.addPostData("content", str10);
                this.a.setUrl(m);
                this.a.addPostData("fname", writeData.getForumName());
                if (!TextUtils.isEmpty(writeData.getTitle())) {
                    this.a.addPostData("title", writeData.getTitle());
                }
                if (!StringUtils.isNull(writeData.getPostPrefix())) {
                    this.a.addPostData("post_prefix", writeData.getPostPrefix());
                }
                this.a.addPostData("apiKey", writeData.getShareApiKey());
                this.a.addPostData("appName", writeData.getShareAppName());
                this.a.addPostData("signKey", writeData.getShareSignKey());
                this.a.addPostData("summary_title", writeData.getShareSummaryTitle());
                this.a.addPostData("summary_content", writeData.getShareSummaryContent());
                this.a.addPostData("summary_img", writeData.getShareSummaryImg());
                this.a.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(writeData.getShareSummaryImgWidth()));
                this.a.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(writeData.getShareSummaryImgHeight()));
                this.a.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, writeData.getShareSummaryImgType());
                this.a.addPostData("referUrl", writeData.getShareReferUrl());
                str6 = str10;
            } else {
                xi8.a("发帖：开始分段数据发送");
                if (z && writeData.isHasImages()) {
                    WriteImagesInfo writeImagesInfo = writeData.getWriteImagesInfo();
                    if (writeImagesInfo != null) {
                        writeImagesInfo.needImageParallel = UploadPicParallelSwitch.isOn();
                        writeImagesInfo.imageChunkSize = ys4.k().l("key_upload_pic_chunk_size", 0);
                        writeImagesInfo.imageUploadConcurrency = ys4.k().l("key_upload_pic_parallel_count", 0);
                        writeImagesInfo.imageChunkRetry = ys4.k().l("key_upload_pic_chunk_retry", 0);
                        if (writeImagesInfo.imageUploadConcurrency < 1) {
                            writeImagesInfo.imageUploadConcurrency = 1;
                        }
                    }
                    vi8.n(writeData);
                    xi8.a("发帖：发送图片 开始");
                    if (this.e == null) {
                        ImageUploader imageUploader = new ImageUploader("HTTPWriteService.postWriteData");
                        this.e = imageUploader;
                        imageUploader.setWriteData(writeData);
                        this.e.setMultiImageUploadProgressCallback(new a(this, writeImagesInfo, writeData), writeData);
                    }
                    if (writeData.startPublishTime() > 0 && writeImagesInfo != null) {
                        if (writeImagesInfo.needImageParallel) {
                            this.e.setChunkSize(104857600);
                        } else {
                            int i = writeImagesInfo.imageChunkSize;
                            if (i > 9) {
                                this.e.setChunkSize(i * 1024);
                            } else {
                                this.e.setChunkSize(512000);
                            }
                        }
                    }
                    if (writeData.getType() == 6) {
                        xi8.a("发帖：发送图片 上传图片 开始 1");
                        ErrorData uploadMustAllSuccInBackground = this.e.uploadMustAllSuccInBackground(writeData.getWriteImagesInfo(), true);
                        if (uploadMustAllSuccInBackground != null) {
                            this.b.setError_code(uploadMustAllSuccInBackground.getError_code());
                            this.b.setError_msg(uploadMustAllSuccInBackground.getError_msg());
                            xi8.a("发帖：发送图片 上传图片 错误 1");
                            vi8.e(writeData, uploadMustAllSuccInBackground);
                            return null;
                        }
                        xi8.a("发帖：发送图片 上传图片 完成 1");
                    } else {
                        xi8.a("发帖：发送图片 上传图片 开始 2");
                        this.e.isFromBJH = writeData.isBJHPost();
                        ErrorData uploadMustAllSuccInBackground2 = this.e.uploadMustAllSuccInBackground(writeData.getWriteImagesInfo(), true);
                        if (uploadMustAllSuccInBackground2 != null) {
                            this.b.setError_code(uploadMustAllSuccInBackground2.getError_code());
                            this.b.setError_msg(uploadMustAllSuccInBackground2.getError_msg());
                            xi8.a("发帖：发送图片 上传图片 错误 2");
                            vi8.e(writeData, uploadMustAllSuccInBackground2);
                            return null;
                        }
                        xi8.a("发帖：发送图片 上传图片 完成 2");
                    }
                    vi8.e(writeData, null);
                }
                if (this.c) {
                    this.b.setError_code(-54);
                    return null;
                }
                String voice = writeData.getVoice();
                int voiceDuringTime = writeData.getVoiceDuringTime();
                if (writeData.getReturnVoiceMd5() == null) {
                    returnVoiceMd5 = null;
                    z2 = false;
                } else {
                    returnVoiceMd5 = writeData.getReturnVoiceMd5();
                    z2 = true;
                }
                xi8.a("声音文件 = " + voice);
                if (voice == null || z2) {
                    str = returnVoiceMd5;
                } else {
                    xi8.a("发帖：发送声音 开始");
                    bv4 bv4Var = new bv4(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                    bv4Var.a("type", 1);
                    String storeFile = FileHelper.getStoreFile(voice, 1);
                    vi8.r(writeData, FileHelper.getFileSize(storeFile));
                    yv4 d = bv4Var.d(storeFile);
                    if (d != null && d.d()) {
                        xv4 a2 = d.a();
                        if (a2 != null) {
                            String b2 = a2.b();
                            yu4.b(writeData.getVoice(), b2);
                            writeData.setReturnVoiceMd5(b2);
                            vi8.i(writeData, d);
                            xi8.a("发帖：发送声音 完成 1");
                            str = b2;
                        } else {
                            FieldBuilder fieldBuilder = new FieldBuilder();
                            fieldBuilder.append("ErrCode", Integer.valueOf(d.b()));
                            fieldBuilder.append("ErrMsg", d.c());
                            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "audioUploadData is null", fieldBuilder.toString());
                            this.b.setError_code(d.b());
                            this.b.setError_msg(d.c());
                            xi8.a("发帖：发送声音 失败 1");
                            vi8.i(writeData, d);
                            return null;
                        }
                    } else {
                        FieldBuilder fieldBuilder2 = new FieldBuilder();
                        fieldBuilder2.append("audioFile", storeFile);
                        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "uploadService.upload null or fail", fieldBuilder2.toString());
                        if (d != null) {
                            this.b.setError_code(d.b());
                            this.b.setError_msg(d.c());
                        }
                        vi8.i(writeData, d);
                        xi8.a("发帖：发送声音 失败 2");
                        return null;
                    }
                }
                if (this.c) {
                    this.b.setError_code(-54);
                    return null;
                }
                VideoInfo videoInfo = writeData.getVideoInfo();
                if (videoInfo != null) {
                    if (videoInfo.needUploadVideo()) {
                        vi8.p(writeData, videoInfo);
                        this.f = new gi8(this.h);
                        xi8.a("发帖：开始上传视频");
                        VideoFinishResult e = this.f.e(writeData.getForumId(), videoInfo.getVideoPath(), videoInfo.getVideoDuration(), new b(this, writeData));
                        vi8.g(writeData, e);
                        if (e == null) {
                            this.b.setError_code(-53);
                            this.b.setError_msg(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f14d7));
                            xi8.a("发帖：开始上传视频 失败 1");
                            return null;
                        } else if (e.isSuccess()) {
                            videoInfo.setVideoMd5(e.getVideoMd5());
                            videoInfo.setVideoUrl(e.getVideoUrl());
                            xi8.a("发帖：开始上传视频 成功 ");
                        } else {
                            this.b.setError_code(e.getErrorNo());
                            this.b.setError_msg(e.getUserMessage());
                            xi8.a("发帖：开始上传视频 失败 2");
                            return null;
                        }
                    }
                    if (videoInfo.needUploadThunmb()) {
                        xi8.a("发帖：开始上传首帧图 开始 ");
                        if (this.e == null) {
                            ImageUploader imageUploader2 = new ImageUploader("HTTPWriteService.postWriteData");
                            this.e = imageUploader2;
                            imageUploader2.setWriteData(writeData);
                        }
                        vi8.q(writeData, videoInfo.getThumbPath());
                        ImageUploadResult uploadInBackground = this.e.uploadInBackground(videoInfo.getThumbPath(), false);
                        vi8.h(writeData, uploadInBackground);
                        if (uploadInBackground != null) {
                            videoInfo.setThumbId(uploadInBackground.picId);
                            ImageUploadResult.picInfo picinfo = uploadInBackground.picInfo;
                            if (picinfo != null && (picDetailedInfo = picinfo.bigPic) != null && !StringUtils.isNull(picDetailedInfo.picUrl)) {
                                wi8.k().E(uploadInBackground.picInfo.bigPic.picUrl);
                            }
                        }
                        xi8.a("发帖：开始上传首帧图 完成 ");
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        if (!ListUtils.isEmpty(videoInfo.getStickListInfo())) {
                            JSONArray jSONArray = new JSONArray();
                            for (String str12 : videoInfo.getStickListInfo()) {
                                jSONArray.put(str12);
                            }
                            jSONObject.put("sticker_id", jSONArray);
                        }
                        if (!ListUtils.isEmpty(videoInfo.getBeautifyListInfo())) {
                            JSONArray jSONArray2 = new JSONArray();
                            for (String str13 : videoInfo.getBeautifyListInfo()) {
                                jSONArray2.put(str13);
                            }
                            jSONObject.put("beautify_level", jSONArray2);
                        }
                        if (!ListUtils.isEmpty(videoInfo.getFilterListInfo())) {
                            JSONArray jSONArray3 = new JSONArray();
                            for (String str14 : videoInfo.getFilterListInfo()) {
                                jSONArray3.put(str14);
                            }
                            jSONObject.put("filter_id", jSONArray3);
                        }
                        if (!ListUtils.isEmpty(videoInfo.getMusicListInfo())) {
                            JSONArray jSONArray4 = new JSONArray();
                            for (String str15 : videoInfo.getMusicListInfo()) {
                                jSONArray4.put(str15);
                            }
                            jSONObject.put(CloudMusicActivityConfig.MUSIC_ID, jSONArray4);
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    this.a.addPostData("video_other", jSONObject.toString());
                }
                xi8.a("发帖：上传视频结束 完全完成 ");
                if (this.c) {
                    this.b.setError_code(-54);
                    return null;
                }
                xi8.a("发帖：其他数据设置开始 ");
                this.a.addPostData("anonymous", "1");
                this.a.addPostData("can_no_forum", writeData.isCanNoForum() ? "1" : "0");
                this.a.addPostData("is_feedback", writeData.isUserFeedback() ? "1" : "0");
                this.a.addPostData("takephoto_num", String.valueOf(writeData.getTakePhotoNum()));
                this.a.addPostData("entrance_type", String.valueOf(writeData.getEntranceType()));
                if (str != null) {
                    this.a.addPostData("voice_md5", str);
                    this.a.addPostData("during_time", String.valueOf(voiceDuringTime));
                }
                String imagesCodeForPost = writeData.getImagesCodeForPost();
                if (writeData.getType() != 6) {
                    if (writeData.getType() == 7 && TextUtils.isEmpty(writeData.getTitle()) && TextUtils.isEmpty(str) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(str10) && writeData.getVideoInfo() == null) {
                        this.b.setError_code(-53);
                        this.b.setError_msg(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1021));
                        return null;
                    }
                    if ((!(writeData.getType() == 0 || writeData.getType() == 9) || TextUtils.isEmpty(writeData.getTitle())) && TextUtils.isEmpty(str) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(str10) && writeData.getVideoInfo() == null && writeData.getType() != 7 && !writeData.isLinkThread() && writeData.getWriteVoteData() == null) {
                        this.b.setError_code(-53);
                        this.b.setError_msg(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1021));
                        return null;
                    }
                }
                if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                    this.a.addPostData("vcode", writeData.getVcode());
                }
                if (!StringUtils.isNull(writeData.getVcodeMD5())) {
                    this.a.addPostData("vcode_md5", writeData.getVcodeMD5());
                }
                if (!StringUtils.isNull(writeData.getVcodeType())) {
                    this.a.addPostData("vcode_type", writeData.getVcodeType());
                }
                if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                    this.a.addPostData("vcode_tag", "12");
                }
                Address j = gf.n().j(false);
                if (!TextUtils.isEmpty(writeData.getTopicId())) {
                    this.a.addPostData("topic_id", writeData.getTopicId());
                }
                this.a.addPostData("new_vcode", "1");
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().hasUpload()) {
                    String buildContent = writeData.getVideoInfo().buildContent();
                    str5 = writeData.getTitle();
                    str4 = buildContent + imagesCodeForPost;
                    StringBuilder sb = new StringBuilder();
                    sb.append(StringUtils.isNull(str10) ? "" : str10);
                    sb.append(imagesCodeForPost);
                    str3 = sb.toString();
                    writeData.setIsNoTitle(ki.isEmpty(str5));
                } else {
                    if (writeData.isRichTextEditorMode()) {
                        StringBuilder sb2 = new StringBuilder();
                        for (Object obj : writeData.getServerRichContentData()) {
                            if (obj instanceof String) {
                                sb2.append(obj);
                            } else if (obj instanceof ImageFileInfo) {
                                ImageFileInfo imageFileInfo = (ImageFileInfo) obj;
                                if (imageFileInfo.isAlreadyUploadedToServer()) {
                                    sb2.append("\n");
                                    sb2.append(imageFileInfo.getServerImageCode());
                                }
                            }
                        }
                        str2 = sb2.toString();
                        title = writeData.getTitle();
                    } else {
                        str2 = str10 + imagesCodeForPost;
                        title = writeData.getTitle();
                    }
                    String str16 = title;
                    str3 = null;
                    str4 = str2;
                    str5 = str16;
                }
                if (writeData.isLocalChannelDynamic() && !TextUtils.isEmpty(writeData.getLocalChannelTopic())) {
                    str5 = "#" + writeData.getLocalChannelTopic() + "#" + str5;
                }
                String voteContentForPost = writeData.getVoteContentForPost();
                if (!StringUtils.isNull(voteContentForPost)) {
                    str4 = str4 + voteContentForPost;
                }
                EmotionUtil.statisticsEmotionUse(str4);
                String c2 = o66.c(str4);
                if (!TextUtils.isEmpty(str3)) {
                    str3 = o66.c(str3);
                }
                if (writeData.getItemDatas() != null && writeData.getItemDatas().size() > 0) {
                    c2 = c2 + writeData.getAssociatedItemsForPost();
                }
                this.a.addPostData("content", c2);
                this.a.addPostData("reply_uid", writeData.getReplyId());
                if (!TextUtils.isEmpty(writeData.getMemeText())) {
                    this.a.addPostData("meme_text", writeData.getMemeText());
                }
                if (!TextUtils.isEmpty(writeData.getMemeContSign())) {
                    this.a.addPostData("meme_cont_sign", writeData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(writeData.getItem_id())) {
                    this.a.addPostData("item_id", writeData.getItem_id());
                }
                if (!TextUtils.isEmpty(writeData.getComment_head())) {
                    this.a.addPostData("comment_head", writeData.getComment_head());
                }
                if (writeData.getClassAndTagData() != null && !TextUtils.isEmpty(writeData.getClassAndTagData().toPostJson())) {
                    this.a.addPostData("works_tag", writeData.getClassAndTagData().toPostJson());
                }
                xi8.a("设置数据");
                int type = writeData.getType();
                str6 = str10;
                String str17 = str3;
                if (type != 0) {
                    str8 = str5;
                    str7 = "1";
                    if (type == 1) {
                        this.a.setUrl(l);
                        this.a.addPostData("fid", writeData.getForumId());
                        this.a.addPostData("from_fourm_id", writeData.getFromForumId());
                        this.a.addPostData("v_fid", writeData.getVForumId());
                        this.a.addPostData("v_fname", writeData.getVForumName());
                        this.a.addPostData("tid", writeData.getThreadId());
                        this.a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                        this.a.addPostData("is_ad", writeData.getIsAd() ? str7 : "0");
                        this.a.addPostData("is_barrage", writeData.isBarrage() ? str7 : "0");
                        this.a.addPostData("barrage_time", String.valueOf(writeData.getBarrageTime()));
                        if (writeData.isFrsReply()) {
                            this.a.addPostData("st_param", "frs");
                        }
                        if (t15.a().b() == 1) {
                            this.a.addPostData("ptype", "4");
                        }
                        if (!StringUtils.isNull(writeData.sourceFrom)) {
                            this.a.addPostData("post_from", writeData.sourceFrom);
                        }
                        if (writeData.getBaijiahaoData() != null) {
                            this.a.addPostData("ori_ugc_nid", writeData.getBaijiahaoData().oriUgcNid);
                            this.a.addPostData("ori_ugc_tid", writeData.getBaijiahaoData().oriUgcTid);
                            this.a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(writeData.getBaijiahaoData().oriUgcType));
                            this.a.addPostData("ori_ugc_vid", writeData.getBaijiahaoData().oriUgcVid);
                        }
                        cj8.a(this.a, writeData);
                    } else if (type == 2) {
                        this.a.setUrl(l);
                        this.a.addPostData("fid", writeData.getForumId());
                        this.a.addPostData("from_fourm_id", writeData.getFromForumId());
                        this.a.addPostData("v_fid", writeData.getVForumId());
                        this.a.addPostData("v_fname", writeData.getVForumName());
                        this.a.addPostData("tid", writeData.getThreadId());
                        this.a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                        this.a.addPostData("quote_id", String.valueOf(writeData.getFloor()));
                        this.a.addPostData("is_twzhibo_thread", String.valueOf(0));
                        this.a.addPostData("floor_num", String.valueOf(writeData.getFloorNum()));
                        if (writeData.getRepostId() != null) {
                            this.a.addPostData("repostid", writeData.getRepostId());
                        }
                        if (writeData.getReSubPostId() != null) {
                            this.a.addPostData("sub_post_id", writeData.getReSubPostId());
                        }
                        this.a.addPostData("is_ad", writeData.getIsAd() ? str7 : "0");
                        this.a.addPostData("is_addition", writeData.isAddition() ? str7 : "0");
                        this.a.addPostData("is_giftpost", writeData.isGiftPost() ? str7 : "0");
                        this.a.addPostData("is_giftpost", writeData.isGiftPost() ? str7 : "0");
                        if (writeData.isAddition()) {
                            this.a.addPostData("st_type", "conadd");
                        }
                        if (!StringUtils.isNull(writeData.sourceFrom)) {
                            this.a.addPostData("post_from", writeData.sourceFrom);
                        }
                        if (writeData.getBaijiahaoData() != null) {
                            this.a.addPostData("ori_ugc_nid", writeData.getBaijiahaoData().oriUgcNid);
                            this.a.addPostData("ori_ugc_tid", writeData.getBaijiahaoData().oriUgcTid);
                            this.a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(writeData.getBaijiahaoData().oriUgcType));
                            this.a.addPostData("ori_ugc_vid", writeData.getBaijiahaoData().oriUgcVid);
                        }
                    } else if (type == 4) {
                        this.a.setUrl(k);
                        this.a.addPostData("fid", writeData.getForumId());
                        this.a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                        if (!TextUtils.isEmpty(writeData.getTitle())) {
                            this.a.addPostData("title", writeData.getTitle());
                        }
                        if (!StringUtils.isNull(writeData.getPostPrefix())) {
                            this.a.addPostData("post_prefix", writeData.getPostPrefix());
                        }
                        this.a.addPostData("thread_type", "33");
                        cj8.a(this.a, writeData);
                    } else if (type == 5) {
                        this.a.setUrl(l);
                        this.a.addPostData("fid", writeData.getForumId());
                        this.a.addPostData("tid", writeData.getThreadId());
                        this.a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                        this.a.addPostData("is_twzhibo_thread", String.valueOf(1));
                        if (writeData.getBaijiahaoData() != null) {
                            this.a.addPostData("ori_ugc_nid", writeData.getBaijiahaoData().oriUgcNid);
                            this.a.addPostData("ori_ugc_tid", writeData.getBaijiahaoData().oriUgcTid);
                            this.a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(writeData.getBaijiahaoData().oriUgcType));
                            this.a.addPostData("ori_ugc_vid", writeData.getBaijiahaoData().oriUgcVid);
                        }
                        cj8.a(this.a, writeData);
                    } else if (type == 6) {
                        this.a.setUrl(k);
                        this.a.addPostData("fid", writeData.getForumId());
                        this.a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                        this.a.addPostData("thread_type", String.valueOf(36));
                        if (!TextUtils.isEmpty(writeData.getTitle())) {
                            this.a.addPostData("title", writeData.getTitle());
                        }
                        if (!StringUtils.isNull(writeData.getPostPrefix())) {
                            this.a.addPostData("post_prefix", writeData.getPostPrefix());
                        }
                        this.a.addPostData("is_ntitle", writeData.isNoTitle() ? str7 : "0");
                        if (writeData.isNoTitle()) {
                            this.a.addPostData("st_type", "notitle");
                        }
                        cj8.a(this.a, writeData);
                    } else if (type != 7 && type != 9) {
                        if (writeData.isCanNoForum()) {
                            this.a.addPostData("fid", "0");
                            this.a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, "");
                            this.a.addPostData("transform_forums", writeData.getTransmitForumData());
                        } else {
                            this.a.addPostData("fid", writeData.getForumId());
                            this.a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                        }
                    }
                    str11 = str7;
                    str9 = imagesCodeForPost;
                } else {
                    str7 = "1";
                    str8 = str5;
                }
                this.a.setUrl(k);
                l(writeData);
                if (writeData.isCanNoForum()) {
                    this.a.addPostData("fid", "0");
                    this.a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, "");
                    this.a.addPostData("transform_forums", writeData.getTransmitForumData());
                } else {
                    this.a.addPostData("fid", writeData.getForumId());
                    this.a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                }
                this.a.addPostData("is_hide", writeData.isPrivacy() ? str7 : "0");
                this.a.addPostData("is_repost_to_dynamic", writeData.isToDynamic() ? str7 : "0");
                if (writeData.getVideoId() != null) {
                    this.a.addPostData("video_id", writeData.getVideoId());
                    if (writeData.getOriginalVideoCover() != null) {
                        this.a.addPostData("origin_video_cover", writeData.getOriginalVideoCover());
                    }
                    if (writeData.getOriginalVideoTitle() != null) {
                        this.a.addPostData("origin_video_title", writeData.getOriginalVideoTitle());
                    }
                }
                if (writeData.isShareThread()) {
                    str11 = str7;
                    this.a.addPostData("is_share", str11);
                    this.a.addPostData("from_tid", writeData.getOriginalThreadId());
                } else {
                    str11 = str7;
                }
                if (writeData.getProZone() >= 0) {
                    this.a.addPostData(EditVideoActivityConfig.KEY_PRO_ZONE, String.valueOf(writeData.getProZone()));
                }
                this.a.addPostData(IntentConfig.CALL_FROM, writeData.getStatisticFrom() + "");
                if (!TextUtils.isEmpty(str8)) {
                    this.a.addPostData("title", str8);
                }
                if (!TextUtils.isEmpty(str17)) {
                    this.a.addPostData(AlbumFloatActivityConfig.VIDEO_ABSTRACT, str17);
                }
                if (!StringUtils.isNull(writeData.getPostPrefix())) {
                    this.a.addPostData("post_prefix", writeData.getPostPrefix());
                }
                this.a.addPostData("is_ntitle", writeData.isNoTitle() ? str11 : "0");
                if (writeData.isNoTitle()) {
                    this.a.addPostData("st_type", "notitle");
                }
                if (j != null && TbadkCoreApplication.getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(writeData.getForumId())) {
                    this.a.addPostData("lbs", String.valueOf(j.getLatitude()) + "," + String.valueOf(j.getLongitude()));
                }
                cj8.a(this.a, writeData);
                if (writeData.getCategoryFrom() >= 0) {
                    this.a.addPostData("fromCategoryId", String.valueOf(writeData.getCategoryFrom()));
                }
                if (writeData.getCategoryTo() >= 0) {
                    this.a.addPostData("toCategoryId", String.valueOf(writeData.getCategoryTo()));
                }
                if (writeData.getType() == 7) {
                    this.a.addPostData("is_bottle", String.valueOf(1));
                }
                if (writeData.getRecommendExt() != null) {
                    this.a.addPostData("recommend_ext", writeData.getRecommendExt());
                }
                if (writeData.isLinkThread()) {
                    this.a.addPostData("link_url", writeData.getLinkUrl());
                    this.a.addPostData("link_url_code", writeData.getLinkUrlCode() == null ? "" : writeData.getLinkUrlCode());
                }
                this.a.addPostData("is_link_thread", writeData.isLinkThread() ? str11 : "0");
                if (writeData.isShareThread()) {
                    if (writeData.getOriBaijiahaoData() != null) {
                        this.a.addPostData("ori_ugc_nid", writeData.getOriBaijiahaoData().oriUgcNid);
                        this.a.addPostData("ori_ugc_vid", writeData.getOriBaijiahaoData().oriUgcVid);
                        this.a.addPostData("ori_ugc_tid", writeData.getOriBaijiahaoData().oriUgcTid);
                        this.a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(writeData.getOriBaijiahaoData().oriUgcType));
                    }
                } else if (writeData.getBaijiahaoData() != null) {
                    this.a.addPostData("ori_ugc_nid", writeData.getBaijiahaoData().oriUgcNid);
                    this.a.addPostData("ori_ugc_vid", writeData.getBaijiahaoData().oriUgcVid);
                    this.a.addPostData("ori_ugc_tid", writeData.getBaijiahaoData().oriUgcTid);
                    this.a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(writeData.getBaijiahaoData().oriUgcType));
                }
                if (writeData.getTabId() > 0) {
                    this.a.addPostData("tab_name", writeData.getTabName());
                    this.a.addPostData("tab_id", String.valueOf(writeData.getTabId()));
                    this.a.addPostData("is_general_tab", String.valueOf(writeData.getIsGeneralTab()));
                }
                this.a.addPostData("is_forum_business_account", writeData.isForumBusinessAccount ? str11 : "0");
                str9 = imagesCodeForPost;
            }
            if (writeData.isPostLatLng()) {
                String lat = writeData.getLat() == null ? "" : writeData.getLat();
                String lng = writeData.getLng() != null ? writeData.getLng() : "";
                this.a.addPostData("real_lat", lat);
                this.a.addPostData("real_lng", lng);
            }
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                this.a.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
            }
            if (writeData.isWork()) {
                this.a.addPostData("is_works", str11);
            }
            this.a.addPostData("is_pictxt", writeData.isRichTextEditorMode() ? str11 : "0");
            xi8.a("发帖：其他数据设置开始 发送");
            PublishProgressData.valueOf(writeData, 93).send(true);
            String postNetData = this.a.postNetData();
            xi8.a("发帖：其他数据设置开始 结束 进度到 95");
            PublishProgressData.valueOf(writeData, 95).send(true);
            f(95);
            if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                this.b.parserJson(postNetData);
            } else {
                this.b.setError_code(this.a.isNetSuccess() ? this.a.getServerErrorCode() : this.a.getNetErrorCode());
                this.b.setError_msg(this.a.getErrorString());
            }
            if (this.b.error_code != 0 && !ji.z()) {
                this.b.setError_msg(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0c33));
            } else if (this.b.error_code != 0 && writeData.isHasImages()) {
                if (ki.isEmpty(str6 + str9)) {
                    this.b.setError_msg(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f08d3));
                }
            }
            try {
                AntiData antiData = new AntiData();
                this.d = antiData;
                antiData.parserJson(new JSONObject(postNetData).optJSONObject("anti_stat"));
            } catch (Exception unused) {
            }
            if (this.d.getBlock_stat() == 0 && this.b.error_code == 0 && this.a.getNetContext() != null && this.a.getNetContext().getRequest() != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921344, this.a.getNetContext().getRequest()));
            }
            f(100);
            xi8.a("发帖：处理整个 发帖过程 结束数据 完成 进度到 100");
            return postNetData;
        }
        return (String) invokeLZ.objValue;
    }

    public void h(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.g = cVar;
        }
    }

    public void i(SpanGroupManager spanGroupManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, spanGroupManager) == null) {
            this.i = spanGroupManager;
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.j = str;
        }
    }

    public void k(hj7 hj7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, hj7Var) == null) {
            this.h = hj7Var;
        }
    }

    public void l(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, writeData) == null) || writeData == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_POST_THREAD_AT_USE_CONDITION);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        if (ki.isEmpty(writeData.getAtUidListString())) {
            statisticItem.param("obj_param1", "0");
        } else {
            statisticItem.param("obj_param1", "1");
            statisticItem.param(TiebaStatic.Params.FRIEND_UID, writeData.getAtUidListString());
        }
        TiebaStatic.log(statisticItem);
    }
}
