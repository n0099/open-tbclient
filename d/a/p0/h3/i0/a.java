package d.a.p0.h3.i0;

import android.location.Address;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.core.util.FieldBuilder;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventType;
import d.a.c.e.p.j;
import d.a.c.e.p.k;
import d.a.o0.b0.f;
import d.a.o0.r.q.j1;
import d.a.o0.s.c.q;
import d.a.o0.s.c.r;
import d.a.p0.h3.o0.d.e;
import d.a.p0.x1.g;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final String k;
    public static final String l;
    public static final String m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NetWork f58027a;

    /* renamed from: b  reason: collision with root package name */
    public ErrorData f58028b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f58029c;

    /* renamed from: d  reason: collision with root package name */
    public AntiData f58030d;

    /* renamed from: e  reason: collision with root package name */
    public f f58031e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.p0.h3.o0.a f58032f;

    /* renamed from: g  reason: collision with root package name */
    public c f58033g;

    /* renamed from: h  reason: collision with root package name */
    public g f58034h;

    /* renamed from: i  reason: collision with root package name */
    public SpanGroupManager f58035i;
    public String j;

    /* renamed from: d.a.p0.h3.i0.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1448a implements f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteData f58036a;

        public C1448a(a aVar, WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, writeData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58036a = writeData;
        }

        @Override // d.a.o0.b0.f.b
        public void a(String str, Object obj, long j, long j2, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, obj, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
                d.a.p0.h3.q0.b.a("发帖：发送图片 进度 = " + i2 + "/" + i3 + " :" + j + "/" + j2 + "   ，" + str);
                int i4 = (int) (90.0f / ((float) i3));
                float f2 = (((float) j) / 2.0f) / ((float) j2);
                if (f2 > 1.0f) {
                    f2 = 1.0f;
                }
                j1.h(this.f58036a, (int) (((f2 + i2) - 1.0f) * i4)).f(true);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f58037a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ WriteData f58038b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f58039c;

        public b(a aVar, WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, writeData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58039c = aVar;
            this.f58038b = writeData;
            this.f58037a = 0;
        }

        @Override // d.a.p0.h3.o0.d.e
        public void onProgressUpdate(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
                d.a.p0.h3.q0.b.a("发帖：开始上传视频 percent = " + f2);
                int i2 = (int) (f2 * 90.0f);
                j1.h(this.f58038b, i2).f(true);
                if (i2 != this.f58037a) {
                    this.f58037a = i2;
                    this.f58039c.f(i2);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void a(int i2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1882455448, "Ld/a/p0/h3/i0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1882455448, "Ld/a/p0/h3/i0/a;");
                return;
            }
        }
        k = TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS;
        l = TbConfig.SERVER_ADDRESS + TbConfig.REPLY_THREAD_ADDRESS;
        m = TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_FOR_SHARE_ADDRESS;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f58027a = null;
        this.f58028b = null;
        this.f58029c = false;
        this.f58028b = new ErrorData();
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f58029c = true;
            NetWork netWork = this.f58027a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            f fVar = this.f58031e;
            if (fVar != null) {
                fVar.a();
            }
            d.a.p0.h3.o0.a aVar = this.f58032f;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public AntiData c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f58030d : (AntiData) invokeV.objValue;
    }

    public ErrorData d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f58028b : (ErrorData) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            NetWork netWork = this.f58027a;
            if (netWork == null) {
                return false;
            }
            return netWork.getNetContext().getResponse().isRequestSuccess();
        }
        return invokeV.booleanValue;
    }

    public final void f(int i2) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || (cVar = this.f58033g) == null) {
            return;
        }
        cVar.a(i2);
    }

    public ImageUploadResult g(ImageFileInfo imageFileInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048581, this, imageFileInfo, z)) == null) {
            if (imageFileInfo == null) {
                return null;
            }
            if (this.f58031e == null) {
                this.f58031e = new f("HTTPWriteService.postImageData");
            }
            return this.f58031e.g(imageFileInfo, z);
        }
        return (ImageUploadResult) invokeLZ.objValue;
    }

    public String h(WriteData writeData, boolean z) {
        InterceptResult invokeLZ;
        String content;
        String returnVoiceMd5;
        boolean z2;
        String str;
        String str2;
        String str3;
        String str4;
        String title;
        String str5;
        String str6;
        String str7;
        ImageUploadResult.PicDetailedInfo picDetailedInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, writeData, z)) == null) {
            String str8 = null;
            if (writeData == null) {
                return null;
            }
            d.a.p0.h3.q0.b.a("发帖：postWriteData 开始");
            NetWork netWork = new NetWork();
            this.f58027a = netWork;
            netWork.getNetContext().getRequest().mIsNeedTbs = true;
            this.f58027a.setNeedSig(true);
            this.f58027a.addPostData("authsid", writeData.getAuthSid());
            if (!TextUtils.isEmpty(this.j)) {
                content = this.j;
                writeData.setSpanGroupString(content);
            } else {
                SpanGroupManager spanGroupManager = this.f58035i;
                if (spanGroupManager != null) {
                    content = spanGroupManager.t();
                    writeData.setSpanGroupString(content);
                } else if (!TextUtils.isEmpty(writeData.getSpanGroupString())) {
                    content = writeData.getSpanGroupString();
                } else {
                    content = writeData.getContent();
                }
            }
            if (writeData.getSubPbReplyPrefix() != null) {
                content = writeData.getSubPbReplyPrefix() + content;
            }
            if (!TextUtils.isEmpty(writeData.getZhongcePrefix())) {
                content = writeData.getZhongcePrefix() + content;
            }
            String str9 = content;
            d.a.p0.h3.q0.b.a("发帖：发帖类型：" + writeData.getType());
            if (writeData.getType() == 3) {
                d.a.p0.h3.q0.b.a("发帖：SHARE_SDK：设置数据");
                if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                    this.f58027a.addPostData("vcode", writeData.getVcode());
                }
                if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                    this.f58027a.addPostData("tag", "11");
                }
                this.f58027a.addPostData("newVcode", "1");
                this.f58027a.addPostData("content", str9);
                this.f58027a.setUrl(m);
                this.f58027a.addPostData("fname", writeData.getForumName());
                if (!TextUtils.isEmpty(writeData.getTitle())) {
                    this.f58027a.addPostData("title", writeData.getTitle());
                }
                if (!StringUtils.isNull(writeData.getPostPrefix())) {
                    this.f58027a.addPostData("post_prefix", writeData.getPostPrefix());
                }
                this.f58027a.addPostData("apiKey", writeData.getShareApiKey());
                this.f58027a.addPostData("appName", writeData.getShareAppName());
                this.f58027a.addPostData("signKey", writeData.getShareSignKey());
                this.f58027a.addPostData("summary_title", writeData.getShareSummaryTitle());
                this.f58027a.addPostData("summary_content", writeData.getShareSummaryContent());
                this.f58027a.addPostData("summary_img", writeData.getShareSummaryImg());
                this.f58027a.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(writeData.getShareSummaryImgWidth()));
                this.f58027a.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(writeData.getShareSummaryImgHeight()));
                this.f58027a.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, writeData.getShareSummaryImgType());
                this.f58027a.addPostData("referUrl", writeData.getShareReferUrl());
                str5 = str9;
            } else {
                d.a.p0.h3.q0.b.a("发帖：开始分段数据发送");
                if (z && writeData.isHasImages()) {
                    d.a.p0.h3.q0.b.a("发帖：发送图片 开始");
                    if (this.f58031e == null) {
                        f fVar = new f("HTTPWriteService.postWriteData");
                        this.f58031e = fVar;
                        fVar.d(new C1448a(this, writeData), writeData);
                    }
                    if (writeData.getType() == 6) {
                        d.a.p0.h3.q0.b.a("发帖：发送图片 上传图片 开始 1");
                        if (this.f58031e.n(writeData.getWriteImagesInfo(), true) != null) {
                            this.f58028b.setError_code(-53);
                            this.f58028b.setError_msg(TbadkCoreApplication.getInst().getString(R.string.upload_error));
                            d.a.p0.h3.q0.b.a("发帖：发送图片 上传图片 错误 1");
                            return null;
                        }
                        d.a.p0.h3.q0.b.a("发帖：发送图片 上传图片 完成 1");
                    } else {
                        d.a.p0.h3.q0.b.a("发帖：发送图片 上传图片 开始 2");
                        this.f58031e.m = writeData.isBJHPost();
                        ErrorData n = this.f58031e.n(writeData.getWriteImagesInfo(), true);
                        if (n != null) {
                            this.f58028b.setError_code(-53);
                            this.f58028b.setError_msg(n.getError_msg());
                            d.a.p0.h3.q0.b.a("发帖：发送图片 上传图片 错误 2");
                            return null;
                        }
                        d.a.p0.h3.q0.b.a("发帖：发送图片 上传图片 完成 2");
                    }
                }
                if (this.f58029c) {
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
                d.a.p0.h3.q0.b.a("声音文件 = " + voice);
                if (voice == null || z2) {
                    str = returnVoiceMd5;
                } else {
                    d.a.p0.h3.q0.b.a("发帖：发送声音 开始");
                    d.a.o0.r.g0.c.b bVar = new d.a.o0.r.g0.c.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                    bVar.a("type", 1);
                    String storeFile = FileHelper.getStoreFile(voice, 1);
                    r d2 = bVar.d(storeFile);
                    if (d2 != null && d2.d()) {
                        q a2 = d2.a();
                        if (a2 != null) {
                            String b2 = a2.b();
                            d.a.o0.r.g0.b.b.b(writeData.getVoice(), b2);
                            writeData.setReturnVoiceMd5(b2);
                            d.a.p0.h3.q0.b.a("发帖：发送声音 完成 1");
                            str = b2;
                        } else {
                            FieldBuilder fieldBuilder = new FieldBuilder();
                            fieldBuilder.append("ErrCode", Integer.valueOf(d2.b()));
                            fieldBuilder.append("ErrMsg", d2.c());
                            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "audioUploadData is null", fieldBuilder.toString());
                            this.f58028b.setError_code(d2.b());
                            this.f58028b.setError_msg(d2.c());
                            d.a.p0.h3.q0.b.a("发帖：发送声音 失败 1");
                            return null;
                        }
                    } else {
                        FieldBuilder fieldBuilder2 = new FieldBuilder();
                        fieldBuilder2.append("audioFile", storeFile);
                        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "uploadService.upload null or fail", fieldBuilder2.toString());
                        if (d2 != null) {
                            this.f58028b.setError_code(d2.b());
                            this.f58028b.setError_msg(d2.c());
                        }
                        d.a.p0.h3.q0.b.a("发帖：发送声音 失败 2");
                        return null;
                    }
                }
                if (this.f58029c) {
                    return null;
                }
                VideoInfo videoInfo = writeData.getVideoInfo();
                if (videoInfo != null) {
                    if (videoInfo.needUploadVideo()) {
                        this.f58032f = new d.a.p0.h3.o0.a(this.f58034h);
                        d.a.p0.h3.q0.b.a("发帖：开始上传视频");
                        str2 = "post_prefix";
                        VideoFinishResult e2 = this.f58032f.e(writeData.getForumId(), videoInfo.getVideoPath(), videoInfo.getVideoDuration(), new b(this, writeData));
                        if (e2 == null) {
                            this.f58028b.setError_code(-53);
                            this.f58028b.setError_msg(TbadkCoreApplication.getInst().getString(R.string.upload_error));
                            d.a.p0.h3.q0.b.a("发帖：开始上传视频 失败 1");
                            return null;
                        } else if (e2.isSuccess()) {
                            videoInfo.setVideoMd5(e2.getVideoMd5());
                            videoInfo.setVideoUrl(e2.getVideoUrl());
                            d.a.p0.h3.q0.b.a("发帖：开始上传视频 成功 ");
                        } else {
                            this.f58028b.setError_code(e2.getErrorNo());
                            this.f58028b.setError_msg(e2.getUserMessage());
                            d.a.p0.h3.q0.b.a("发帖：开始上传视频 失败 2");
                            return null;
                        }
                    } else {
                        str2 = "post_prefix";
                    }
                    if (videoInfo.needUploadThunmb()) {
                        d.a.p0.h3.q0.b.a("发帖：开始上传首帧图 开始 ");
                        if (this.f58031e == null) {
                            this.f58031e = new f("HTTPWriteService.postWriteData");
                        }
                        ImageUploadResult j = this.f58031e.j(videoInfo.getThumbPath(), false);
                        if (j != null) {
                            videoInfo.setThumbId(j.picId);
                            ImageUploadResult.picInfo picinfo = j.picInfo;
                            if (picinfo != null && (picDetailedInfo = picinfo.bigPic) != null && !StringUtils.isNull(picDetailedInfo.picUrl)) {
                                d.a.p0.h3.q0.a.g().u(j.picInfo.bigPic.picUrl);
                            }
                        }
                        d.a.p0.h3.q0.b.a("发帖：开始上传首帧图 完成 ");
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        if (!ListUtils.isEmpty(videoInfo.getStickListInfo())) {
                            JSONArray jSONArray = new JSONArray();
                            for (String str10 : videoInfo.getStickListInfo()) {
                                jSONArray.put(str10);
                            }
                            jSONObject.put("sticker_id", jSONArray);
                        }
                        if (!ListUtils.isEmpty(videoInfo.getBeautifyListInfo())) {
                            JSONArray jSONArray2 = new JSONArray();
                            for (String str11 : videoInfo.getBeautifyListInfo()) {
                                jSONArray2.put(str11);
                            }
                            jSONObject.put("beautify_level", jSONArray2);
                        }
                        if (!ListUtils.isEmpty(videoInfo.getFilterListInfo())) {
                            JSONArray jSONArray3 = new JSONArray();
                            for (String str12 : videoInfo.getFilterListInfo()) {
                                jSONArray3.put(str12);
                            }
                            jSONObject.put("filter_id", jSONArray3);
                        }
                        if (!ListUtils.isEmpty(videoInfo.getMusicListInfo())) {
                            JSONArray jSONArray4 = new JSONArray();
                            for (String str13 : videoInfo.getMusicListInfo()) {
                                jSONArray4.put(str13);
                            }
                            jSONObject.put(CloudMusicActivityConfig.MUSIC_ID, jSONArray4);
                        }
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                    this.f58027a.addPostData("video_other", jSONObject.toString());
                } else {
                    str2 = "post_prefix";
                }
                d.a.p0.h3.q0.b.a("发帖：上传视频结束 完全完成 ");
                if (this.f58029c) {
                    return null;
                }
                d.a.p0.h3.q0.b.a("发帖：其他数据设置开始 ");
                this.f58027a.addPostData("anonymous", "1");
                this.f58027a.addPostData("can_no_forum", writeData.isCanNoForum() ? "1" : "0");
                this.f58027a.addPostData("is_feedback", writeData.isUserFeedback() ? "1" : "0");
                this.f58027a.addPostData("takephoto_num", String.valueOf(writeData.getTakePhotoNum()));
                this.f58027a.addPostData("entrance_type", String.valueOf(writeData.getEntranceType()));
                if (str != null) {
                    this.f58027a.addPostData("voice_md5", str);
                    this.f58027a.addPostData("during_time", String.valueOf(voiceDuringTime));
                }
                String imagesCodeForPost = writeData.getImagesCodeForPost();
                if (writeData.getType() != 6) {
                    if (writeData.getType() == 7 && TextUtils.isEmpty(writeData.getTitle()) && TextUtils.isEmpty(str) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(str9) && writeData.getVideoInfo() == null) {
                        this.f58028b.setError_code(-53);
                        this.f58028b.setError_msg(TbadkCoreApplication.getInst().getString(R.string.sand_fail));
                        return null;
                    }
                    if ((!(writeData.getType() == 0 || writeData.getType() == 9) || TextUtils.isEmpty(writeData.getTitle())) && TextUtils.isEmpty(str) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(str9) && writeData.getVideoInfo() == null && writeData.getType() != 7 && !writeData.isLinkThread() && writeData.getWriteVoteData() == null) {
                        this.f58028b.setError_code(-53);
                        this.f58028b.setError_msg(TbadkCoreApplication.getInst().getString(R.string.sand_fail));
                        return null;
                    }
                }
                if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                    this.f58027a.addPostData("vcode", writeData.getVcode());
                }
                if (!StringUtils.isNull(writeData.getVcodeMD5())) {
                    this.f58027a.addPostData("vcode_md5", writeData.getVcodeMD5());
                }
                if (!StringUtils.isNull(writeData.getVcodeType())) {
                    this.f58027a.addPostData("vcode_type", writeData.getVcodeType());
                }
                if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                    this.f58027a.addPostData("vcode_tag", "12");
                }
                Address h2 = d.a.c.e.i.a.l().h(false);
                if (!TextUtils.isEmpty(writeData.getTopicId())) {
                    this.f58027a.addPostData("topic_id", writeData.getTopicId());
                }
                this.f58027a.addPostData("new_vcode", "1");
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().hasUpload()) {
                    String buildContent = writeData.getVideoInfo().buildContent();
                    title = writeData.getTitle();
                    str4 = buildContent + imagesCodeForPost;
                    str3 = str9 + imagesCodeForPost;
                    writeData.setIsNoTitle(k.isEmpty(title));
                } else {
                    str3 = null;
                    str4 = str9 + imagesCodeForPost;
                    title = writeData.getTitle();
                }
                String voteContentForPost = writeData.getVoteContentForPost();
                if (!StringUtils.isNull(voteContentForPost)) {
                    str4 = str4 + voteContentForPost;
                }
                EmotionUtil.statisticsEmotionUse(str4);
                String b3 = d.a.p0.o0.a.b(str4);
                if (!TextUtils.isEmpty(str3)) {
                    str3 = d.a.p0.o0.a.b(str3);
                }
                this.f58027a.addPostData("content", b3);
                this.f58027a.addPostData("reply_uid", writeData.getReplyId());
                if (!TextUtils.isEmpty(writeData.getMemeText())) {
                    this.f58027a.addPostData("meme_text", writeData.getMemeText());
                }
                if (!TextUtils.isEmpty(writeData.getMemeContSign())) {
                    this.f58027a.addPostData("meme_cont_sign", writeData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(writeData.getItem_id())) {
                    this.f58027a.addPostData(LegoListActivityConfig.ITEM_ID, writeData.getItem_id());
                }
                if (!TextUtils.isEmpty(writeData.getComment_head())) {
                    this.f58027a.addPostData("comment_head", writeData.getComment_head());
                }
                d.a.p0.h3.q0.b.a("设置数据");
                int type = writeData.getType();
                str5 = str9;
                if (type != 0) {
                    str7 = str3;
                    str6 = title;
                    if (type == 1) {
                        this.f58027a.setUrl(l);
                        this.f58027a.addPostData("fid", writeData.getForumId());
                        this.f58027a.addPostData("from_fourm_id", writeData.getFromForumId());
                        this.f58027a.addPostData("v_fid", writeData.getVForumId());
                        this.f58027a.addPostData("v_fname", writeData.getVForumName());
                        this.f58027a.addPostData("tid", writeData.getThreadId());
                        this.f58027a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                        this.f58027a.addPostData("is_ad", writeData.getIsAd() ? "1" : "0");
                        this.f58027a.addPostData("is_barrage", writeData.isBarrage() ? "1" : "0");
                        this.f58027a.addPostData("barrage_time", String.valueOf(writeData.getBarrageTime()));
                        if (writeData.isFrsReply()) {
                            this.f58027a.addPostData("st_param", "frs");
                        }
                        if (d.a.o0.w.w.a.a().b() == 1) {
                            this.f58027a.addPostData("ptype", "4");
                        }
                        if (!StringUtils.isNull(writeData.sourceFrom)) {
                            this.f58027a.addPostData("post_from", writeData.sourceFrom);
                        }
                        if (writeData.getBaijiahaoData() != null) {
                            this.f58027a.addPostData("ori_ugc_nid", writeData.getBaijiahaoData().oriUgcNid);
                            this.f58027a.addPostData("ori_ugc_tid", writeData.getBaijiahaoData().oriUgcTid);
                            this.f58027a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(writeData.getBaijiahaoData().oriUgcType));
                            this.f58027a.addPostData("ori_ugc_vid", writeData.getBaijiahaoData().oriUgcVid);
                        }
                        d.a.p0.h3.q0.g.a(this.f58027a, writeData);
                    } else if (type == 2) {
                        this.f58027a.setUrl(l);
                        this.f58027a.addPostData("fid", writeData.getForumId());
                        this.f58027a.addPostData("from_fourm_id", writeData.getFromForumId());
                        this.f58027a.addPostData("v_fid", writeData.getVForumId());
                        this.f58027a.addPostData("v_fname", writeData.getVForumName());
                        this.f58027a.addPostData("tid", writeData.getThreadId());
                        this.f58027a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                        this.f58027a.addPostData("quote_id", String.valueOf(writeData.getFloor()));
                        this.f58027a.addPostData("is_twzhibo_thread", String.valueOf(0));
                        this.f58027a.addPostData("floor_num", String.valueOf(writeData.getFloorNum()));
                        if (writeData.getRepostId() != null) {
                            this.f58027a.addPostData("repostid", writeData.getRepostId());
                        }
                        this.f58027a.addPostData("is_ad", writeData.getIsAd() ? "1" : "0");
                        this.f58027a.addPostData("is_addition", writeData.isAddition() ? "1" : "0");
                        this.f58027a.addPostData("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                        this.f58027a.addPostData("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                        if (writeData.isAddition()) {
                            this.f58027a.addPostData("st_type", "conadd");
                        }
                        if (!StringUtils.isNull(writeData.sourceFrom)) {
                            this.f58027a.addPostData("post_from", writeData.sourceFrom);
                        }
                        if (writeData.getBaijiahaoData() != null) {
                            this.f58027a.addPostData("ori_ugc_nid", writeData.getBaijiahaoData().oriUgcNid);
                            this.f58027a.addPostData("ori_ugc_tid", writeData.getBaijiahaoData().oriUgcTid);
                            this.f58027a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(writeData.getBaijiahaoData().oriUgcType));
                            this.f58027a.addPostData("ori_ugc_vid", writeData.getBaijiahaoData().oriUgcVid);
                        }
                    } else if (type == 4) {
                        String str14 = str2;
                        this.f58027a.setUrl(k);
                        this.f58027a.addPostData("fid", writeData.getForumId());
                        this.f58027a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                        if (!TextUtils.isEmpty(writeData.getTitle())) {
                            this.f58027a.addPostData("title", writeData.getTitle());
                        }
                        if (!StringUtils.isNull(writeData.getPostPrefix())) {
                            this.f58027a.addPostData(str14, writeData.getPostPrefix());
                        }
                        this.f58027a.addPostData("thread_type", EventType.GiftEventID.SEND_GIFT_TO_MULTIUSER_FAIL);
                        d.a.p0.h3.q0.g.a(this.f58027a, writeData);
                    } else if (type == 5) {
                        this.f58027a.setUrl(l);
                        this.f58027a.addPostData("fid", writeData.getForumId());
                        this.f58027a.addPostData("tid", writeData.getThreadId());
                        this.f58027a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                        this.f58027a.addPostData("is_twzhibo_thread", String.valueOf(1));
                        if (writeData.getBaijiahaoData() != null) {
                            this.f58027a.addPostData("ori_ugc_nid", writeData.getBaijiahaoData().oriUgcNid);
                            this.f58027a.addPostData("ori_ugc_tid", writeData.getBaijiahaoData().oriUgcTid);
                            this.f58027a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(writeData.getBaijiahaoData().oriUgcType));
                            this.f58027a.addPostData("ori_ugc_vid", writeData.getBaijiahaoData().oriUgcVid);
                        }
                        d.a.p0.h3.q0.g.a(this.f58027a, writeData);
                    } else if (type == 6) {
                        this.f58027a.setUrl(k);
                        this.f58027a.addPostData("fid", writeData.getForumId());
                        this.f58027a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                        this.f58027a.addPostData("thread_type", String.valueOf(36));
                        if (!TextUtils.isEmpty(writeData.getTitle())) {
                            this.f58027a.addPostData("title", writeData.getTitle());
                        }
                        if (!StringUtils.isNull(writeData.getPostPrefix())) {
                            this.f58027a.addPostData(str2, writeData.getPostPrefix());
                        }
                        this.f58027a.addPostData("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                        if (writeData.isNoTitle()) {
                            this.f58027a.addPostData("st_type", "notitle");
                        }
                        d.a.p0.h3.q0.g.a(this.f58027a, writeData);
                    } else if (type != 7 && type != 9) {
                        if (writeData.isCanNoForum()) {
                            this.f58027a.addPostData("fid", "0");
                            this.f58027a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, "");
                            this.f58027a.addPostData("transform_forums", writeData.getTransmitForumData());
                        } else {
                            this.f58027a.addPostData("fid", writeData.getForumId());
                            this.f58027a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                        }
                    }
                    str8 = imagesCodeForPost;
                } else {
                    str6 = title;
                    str7 = str3;
                }
                String str15 = str2;
                this.f58027a.setUrl(k);
                if (writeData.isCanNoForum()) {
                    this.f58027a.addPostData("fid", "0");
                    this.f58027a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, "");
                    this.f58027a.addPostData("transform_forums", writeData.getTransmitForumData());
                } else {
                    this.f58027a.addPostData("fid", writeData.getForumId());
                    this.f58027a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                }
                this.f58027a.addPostData("is_hide", writeData.isPrivacy() ? "1" : "0");
                this.f58027a.addPostData("is_repost_to_dynamic", writeData.isToDynamic() ? "1" : "0");
                if (writeData.getVideoId() != null) {
                    this.f58027a.addPostData("video_id", writeData.getVideoId());
                    if (writeData.getOriginalVideoCover() != null) {
                        this.f58027a.addPostData("origin_video_cover", writeData.getOriginalVideoCover());
                    }
                    if (writeData.getOriginalVideoTitle() != null) {
                        this.f58027a.addPostData("origin_video_title", writeData.getOriginalVideoTitle());
                    }
                }
                if (writeData.isShareThread()) {
                    this.f58027a.addPostData("is_share", "1");
                    this.f58027a.addPostData("from_tid", writeData.getOriginalThreadId());
                }
                if (writeData.getProZone() >= 0) {
                    this.f58027a.addPostData(EditVideoActivityConfig.KEY_PRO_ZONE, String.valueOf(writeData.getProZone()));
                }
                this.f58027a.addPostData(IntentConfig.CALL_FROM, writeData.getStatisticFrom() + "");
                if (!TextUtils.isEmpty(str6)) {
                    this.f58027a.addPostData("title", str6);
                }
                if (!TextUtils.isEmpty(str7)) {
                    this.f58027a.addPostData("video_abstract", str7);
                }
                if (!StringUtils.isNull(writeData.getPostPrefix())) {
                    this.f58027a.addPostData(str15, writeData.getPostPrefix());
                }
                this.f58027a.addPostData("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                if (writeData.isNoTitle()) {
                    this.f58027a.addPostData("st_type", "notitle");
                }
                if (h2 != null && TbadkCoreApplication.getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(writeData.getForumId())) {
                    this.f58027a.addPostData("lbs", String.valueOf(h2.getLatitude()) + "," + String.valueOf(h2.getLongitude()));
                }
                d.a.p0.h3.q0.g.a(this.f58027a, writeData);
                if (writeData.getCategoryFrom() >= 0) {
                    this.f58027a.addPostData("fromCategoryId", String.valueOf(writeData.getCategoryFrom()));
                }
                if (writeData.getCategoryTo() >= 0) {
                    this.f58027a.addPostData("toCategoryId", String.valueOf(writeData.getCategoryTo()));
                }
                if (writeData.getType() == 7) {
                    this.f58027a.addPostData("is_bottle", String.valueOf(1));
                }
                if (writeData.getRecommendExt() != null) {
                    this.f58027a.addPostData("recommend_ext", writeData.getRecommendExt());
                }
                if (writeData.isLinkThread()) {
                    this.f58027a.addPostData("link_url", writeData.getLinkUrl());
                    this.f58027a.addPostData("link_url_code", writeData.getLinkUrlCode() == null ? "" : writeData.getLinkUrlCode());
                }
                this.f58027a.addPostData("is_link_thread", writeData.isLinkThread() ? "1" : "0");
                if (writeData.isShareThread()) {
                    if (writeData.getOriBaijiahaoData() != null) {
                        this.f58027a.addPostData("ori_ugc_nid", writeData.getOriBaijiahaoData().oriUgcNid);
                        this.f58027a.addPostData("ori_ugc_vid", writeData.getOriBaijiahaoData().oriUgcVid);
                        this.f58027a.addPostData("ori_ugc_tid", writeData.getOriBaijiahaoData().oriUgcTid);
                        this.f58027a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(writeData.getOriBaijiahaoData().oriUgcType));
                    }
                } else if (writeData.getBaijiahaoData() != null) {
                    this.f58027a.addPostData("ori_ugc_nid", writeData.getBaijiahaoData().oriUgcNid);
                    this.f58027a.addPostData("ori_ugc_vid", writeData.getBaijiahaoData().oriUgcVid);
                    this.f58027a.addPostData("ori_ugc_tid", writeData.getBaijiahaoData().oriUgcTid);
                    this.f58027a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(writeData.getBaijiahaoData().oriUgcType));
                }
                if (writeData.getTabId() > 0) {
                    this.f58027a.addPostData("tab_name", writeData.getTabName());
                    this.f58027a.addPostData("tab_id", String.valueOf(writeData.getTabId()));
                    this.f58027a.addPostData("is_general_tab", String.valueOf(writeData.getIsGeneralTab()));
                }
                this.f58027a.addPostData("is_forum_business_account", writeData.isForumBusinessAccount ? "1" : "0");
                str8 = imagesCodeForPost;
            }
            if (writeData.isPostLatLng()) {
                String lat = writeData.getLat() == null ? "" : writeData.getLat();
                String lng = writeData.getLng() != null ? writeData.getLng() : "";
                this.f58027a.addPostData("real_lat", lat);
                this.f58027a.addPostData("real_lng", lng);
            }
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                this.f58027a.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
            }
            if (writeData.isWork()) {
                this.f58027a.addPostData("is_works", "1");
            }
            d.a.p0.h3.q0.b.a("发帖：其他数据设置开始 发送");
            j1.h(writeData, 93).f(true);
            String postNetData = this.f58027a.postNetData();
            d.a.p0.h3.q0.b.a("发帖：其他数据设置开始 结束 进度到 95");
            j1.h(writeData, 95).f(true);
            f(95);
            if (this.f58027a.getNetContext().getResponse().isRequestSuccess()) {
                this.f58028b.parserJson(postNetData);
            } else {
                this.f58028b.setError_code(this.f58027a.isNetSuccess() ? this.f58027a.getServerErrorCode() : this.f58027a.getNetErrorCode());
                this.f58028b.setError_msg(this.f58027a.getErrorString());
            }
            if (this.f58028b.error_code != 0 && !j.z()) {
                this.f58028b.setError_msg(TbadkCoreApplication.getInst().getApp().getString(R.string.neterror));
            } else if (this.f58028b.error_code != 0 && writeData.isHasImages()) {
                if (k.isEmpty(str5 + str8)) {
                    this.f58028b.setError_msg(TbadkCoreApplication.getInst().getApp().getString(R.string.img_upload_error));
                }
            }
            try {
                AntiData antiData = new AntiData();
                this.f58030d = antiData;
                antiData.parserJson(new JSONObject(postNetData).optJSONObject("anti_stat"));
            } catch (Exception unused) {
            }
            if (this.f58030d.getBlock_stat() == 0 && this.f58028b.error_code == 0 && this.f58027a.getNetContext() != null && this.f58027a.getNetContext().getRequest() != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921344, this.f58027a.getNetContext().getRequest().getNetWorkParam()));
            }
            f(100);
            d.a.p0.h3.q0.b.a("发帖：处理整个 发帖过程 结束数据 完成 进度到 100");
            return postNetData;
        }
        return (String) invokeLZ.objValue;
    }

    public void i(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            this.f58033g = cVar;
        }
    }

    public void j(SpanGroupManager spanGroupManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, spanGroupManager) == null) {
            this.f58035i = spanGroupManager;
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.j = str;
        }
    }

    public void l(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
            this.f58034h = gVar;
        }
    }
}
