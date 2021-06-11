package d.a.n0.e3.i0;

import android.location.Address;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventType;
import d.a.c.e.p.j;
import d.a.c.e.p.k;
import d.a.m0.b0.f;
import d.a.m0.r.q.i1;
import d.a.m0.s.c.q;
import d.a.m0.s.c.r;
import d.a.n0.e3.o0.d.e;
import d.a.n0.u1.g;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {
    public static final String k = TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS;
    public static final String l = TbConfig.SERVER_ADDRESS + TbConfig.REPLY_THREAD_ADDRESS;
    public static final String m = TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_FOR_SHARE_ADDRESS;

    /* renamed from: b  reason: collision with root package name */
    public ErrorData f57742b;

    /* renamed from: d  reason: collision with root package name */
    public AntiData f57744d;

    /* renamed from: e  reason: collision with root package name */
    public f f57745e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.e3.o0.a f57746f;

    /* renamed from: g  reason: collision with root package name */
    public c f57747g;

    /* renamed from: h  reason: collision with root package name */
    public g f57748h;

    /* renamed from: i  reason: collision with root package name */
    public SpanGroupManager f57749i;
    public String j;

    /* renamed from: a  reason: collision with root package name */
    public NetWork f57741a = null;

    /* renamed from: c  reason: collision with root package name */
    public boolean f57743c = false;

    /* renamed from: d.a.n0.e3.i0.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1352a implements f.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteData f57750a;

        public C1352a(a aVar, WriteData writeData) {
            this.f57750a = writeData;
        }

        @Override // d.a.m0.b0.f.b
        public void a(String str, Object obj, long j, long j2, int i2, int i3) {
            d.a.n0.e3.q0.b.a("发帖：发送图片 进度 = " + i2 + "/" + i3 + " :" + j + "/" + j2 + "   ，" + str);
            int i4 = (int) (90.0f / ((float) i3));
            float f2 = (((float) j) / 2.0f) / ((float) j2);
            if (f2 > 1.0f) {
                f2 = 1.0f;
            }
            i1.g(this.f57750a, (int) (((f2 + i2) - 1.0f) * i4)).e(true);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements e {

        /* renamed from: a  reason: collision with root package name */
        public int f57751a = 0;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ WriteData f57752b;

        public b(WriteData writeData) {
            this.f57752b = writeData;
        }

        @Override // d.a.n0.e3.o0.d.e
        public void onProgressUpdate(float f2) {
            d.a.n0.e3.q0.b.a("发帖：开始上传视频 percent = " + f2);
            int i2 = (int) (f2 * 90.0f);
            i1.g(this.f57752b, i2).e(true);
            if (i2 != this.f57751a) {
                this.f57751a = i2;
                a.this.f(i2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(int i2);
    }

    public a() {
        this.f57742b = null;
        this.f57742b = new ErrorData();
    }

    public void b() {
        this.f57743c = true;
        NetWork netWork = this.f57741a;
        if (netWork != null) {
            netWork.cancelNetConnect();
        }
        f fVar = this.f57745e;
        if (fVar != null) {
            fVar.a();
        }
        d.a.n0.e3.o0.a aVar = this.f57746f;
        if (aVar != null) {
            aVar.a();
        }
    }

    public AntiData c() {
        return this.f57744d;
    }

    public ErrorData d() {
        return this.f57742b;
    }

    public boolean e() {
        NetWork netWork = this.f57741a;
        if (netWork == null) {
            return false;
        }
        return netWork.getNetContext().getResponse().isRequestSuccess();
    }

    public final void f(int i2) {
        c cVar = this.f57747g;
        if (cVar != null) {
            cVar.a(i2);
        }
    }

    public ImageUploadResult g(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        if (this.f57745e == null) {
            this.f57745e = new f("HTTPWriteService.postImageData");
        }
        return this.f57745e.g(imageFileInfo, z);
    }

    public String h(WriteData writeData, boolean z) {
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
        String str8 = null;
        if (writeData == null) {
            return null;
        }
        d.a.n0.e3.q0.b.a("发帖：postWriteData 开始");
        NetWork netWork = new NetWork();
        this.f57741a = netWork;
        netWork.getNetContext().getRequest().mIsNeedTbs = true;
        this.f57741a.setNeedSig(true);
        this.f57741a.addPostData("authsid", writeData.getAuthSid());
        if (!TextUtils.isEmpty(this.j)) {
            content = this.j;
            writeData.setSpanGroupString(content);
        } else {
            SpanGroupManager spanGroupManager = this.f57749i;
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
        d.a.n0.e3.q0.b.a("发帖：发帖类型：" + writeData.getType());
        if (writeData.getType() == 3) {
            d.a.n0.e3.q0.b.a("发帖：SHARE_SDK：设置数据");
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.f57741a.addPostData("vcode", writeData.getVcode());
            }
            if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.f57741a.addPostData("tag", "11");
            }
            this.f57741a.addPostData("newVcode", "1");
            this.f57741a.addPostData("content", str9);
            this.f57741a.setUrl(m);
            this.f57741a.addPostData("fname", writeData.getForumName());
            if (!TextUtils.isEmpty(writeData.getTitle())) {
                this.f57741a.addPostData("title", writeData.getTitle());
            }
            if (!StringUtils.isNull(writeData.getPostPrefix())) {
                this.f57741a.addPostData("post_prefix", writeData.getPostPrefix());
            }
            this.f57741a.addPostData("apiKey", writeData.getShareApiKey());
            this.f57741a.addPostData("appName", writeData.getShareAppName());
            this.f57741a.addPostData("signKey", writeData.getShareSignKey());
            this.f57741a.addPostData("summary_title", writeData.getShareSummaryTitle());
            this.f57741a.addPostData("summary_content", writeData.getShareSummaryContent());
            this.f57741a.addPostData("summary_img", writeData.getShareSummaryImg());
            this.f57741a.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(writeData.getShareSummaryImgWidth()));
            this.f57741a.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(writeData.getShareSummaryImgHeight()));
            this.f57741a.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, writeData.getShareSummaryImgType());
            this.f57741a.addPostData("referUrl", writeData.getShareReferUrl());
            str5 = str9;
        } else {
            d.a.n0.e3.q0.b.a("发帖：开始分段数据发送");
            if (z && writeData.isHasImages()) {
                d.a.n0.e3.q0.b.a("发帖：发送图片 开始");
                if (this.f57745e == null) {
                    f fVar = new f("HTTPWriteService.postWriteData");
                    this.f57745e = fVar;
                    fVar.d(new C1352a(this, writeData), writeData);
                }
                if (writeData.getType() == 6) {
                    d.a.n0.e3.q0.b.a("发帖：发送图片 上传图片 开始 1");
                    if (this.f57745e.n(writeData.getWriteImagesInfo(), true) != null) {
                        this.f57742b.setError_code(-53);
                        this.f57742b.setError_msg(TbadkCoreApplication.getInst().getString(R.string.upload_error));
                        d.a.n0.e3.q0.b.a("发帖：发送图片 上传图片 错误 1");
                        return null;
                    }
                    d.a.n0.e3.q0.b.a("发帖：发送图片 上传图片 完成 1");
                } else {
                    d.a.n0.e3.q0.b.a("发帖：发送图片 上传图片 开始 2");
                    this.f57745e.m = writeData.isBJHPost();
                    ErrorData n = this.f57745e.n(writeData.getWriteImagesInfo(), true);
                    if (n != null) {
                        this.f57742b.setError_code(-53);
                        this.f57742b.setError_msg(n.getError_msg());
                        d.a.n0.e3.q0.b.a("发帖：发送图片 上传图片 错误 2");
                        return null;
                    }
                    d.a.n0.e3.q0.b.a("发帖：发送图片 上传图片 完成 2");
                }
            }
            if (this.f57743c) {
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
            d.a.n0.e3.q0.b.a("声音文件 = " + voice);
            if (voice == null || z2) {
                str = returnVoiceMd5;
            } else {
                d.a.n0.e3.q0.b.a("发帖：发送声音 开始");
                d.a.m0.r.g0.c.b bVar = new d.a.m0.r.g0.c.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                bVar.a("type", 1);
                String storeFile = FileHelper.getStoreFile(voice, 1);
                r d2 = bVar.d(storeFile);
                if (d2 != null && d2.d()) {
                    q a2 = d2.a();
                    if (a2 != null) {
                        String b2 = a2.b();
                        d.a.m0.r.g0.b.b.b(writeData.getVoice(), b2);
                        writeData.setReturnVoiceMd5(b2);
                        d.a.n0.e3.q0.b.a("发帖：发送声音 完成 1");
                        str = b2;
                    } else {
                        FieldBuilder fieldBuilder = new FieldBuilder();
                        fieldBuilder.append("ErrCode", Integer.valueOf(d2.b()));
                        fieldBuilder.append("ErrMsg", d2.c());
                        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "audioUploadData is null", fieldBuilder.toString());
                        this.f57742b.setError_code(d2.b());
                        this.f57742b.setError_msg(d2.c());
                        d.a.n0.e3.q0.b.a("发帖：发送声音 失败 1");
                        return null;
                    }
                } else {
                    FieldBuilder fieldBuilder2 = new FieldBuilder();
                    fieldBuilder2.append("audioFile", storeFile);
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "uploadService.upload null or fail", fieldBuilder2.toString());
                    if (d2 != null) {
                        this.f57742b.setError_code(d2.b());
                        this.f57742b.setError_msg(d2.c());
                    }
                    d.a.n0.e3.q0.b.a("发帖：发送声音 失败 2");
                    return null;
                }
            }
            if (this.f57743c) {
                return null;
            }
            VideoInfo videoInfo = writeData.getVideoInfo();
            if (videoInfo != null) {
                if (videoInfo.needUploadVideo()) {
                    this.f57746f = new d.a.n0.e3.o0.a(this.f57748h);
                    d.a.n0.e3.q0.b.a("发帖：开始上传视频");
                    str2 = "post_prefix";
                    VideoFinishResult e2 = this.f57746f.e(writeData.getForumId(), videoInfo.getVideoPath(), videoInfo.getVideoDuration(), new b(writeData));
                    if (e2 == null) {
                        this.f57742b.setError_code(-53);
                        this.f57742b.setError_msg(TbadkCoreApplication.getInst().getString(R.string.upload_error));
                        d.a.n0.e3.q0.b.a("发帖：开始上传视频 失败 1");
                        return null;
                    } else if (e2.isSuccess()) {
                        videoInfo.setVideoMd5(e2.getVideoMd5());
                        videoInfo.setVideoUrl(e2.getVideoUrl());
                        d.a.n0.e3.q0.b.a("发帖：开始上传视频 成功 ");
                    } else {
                        this.f57742b.setError_code(e2.getErrorNo());
                        this.f57742b.setError_msg(e2.getUserMessage());
                        d.a.n0.e3.q0.b.a("发帖：开始上传视频 失败 2");
                        return null;
                    }
                } else {
                    str2 = "post_prefix";
                }
                if (videoInfo.needUploadThunmb()) {
                    d.a.n0.e3.q0.b.a("发帖：开始上传首帧图 开始 ");
                    if (this.f57745e == null) {
                        this.f57745e = new f("HTTPWriteService.postWriteData");
                    }
                    ImageUploadResult j = this.f57745e.j(videoInfo.getThumbPath(), false);
                    if (j != null) {
                        videoInfo.setThumbId(j.picId);
                        ImageUploadResult.picInfo picinfo = j.picInfo;
                        if (picinfo != null && (picDetailedInfo = picinfo.bigPic) != null && !StringUtils.isNull(picDetailedInfo.picUrl)) {
                            d.a.n0.e3.q0.a.f().s(j.picInfo.bigPic.picUrl);
                        }
                    }
                    d.a.n0.e3.q0.b.a("发帖：开始上传首帧图 完成 ");
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
                        jSONObject.put("music_id", jSONArray4);
                    }
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                this.f57741a.addPostData("video_other", jSONObject.toString());
            } else {
                str2 = "post_prefix";
            }
            d.a.n0.e3.q0.b.a("发帖：上传视频结束 完全完成 ");
            if (this.f57743c) {
                return null;
            }
            d.a.n0.e3.q0.b.a("发帖：其他数据设置开始 ");
            this.f57741a.addPostData("anonymous", "1");
            this.f57741a.addPostData("can_no_forum", writeData.isCanNoForum() ? "1" : "0");
            this.f57741a.addPostData("is_feedback", writeData.isUserFeedback() ? "1" : "0");
            this.f57741a.addPostData("takephoto_num", String.valueOf(writeData.getTakePhotoNum()));
            this.f57741a.addPostData("entrance_type", String.valueOf(writeData.getEntranceType()));
            if (str != null) {
                this.f57741a.addPostData("voice_md5", str);
                this.f57741a.addPostData("during_time", String.valueOf(voiceDuringTime));
            }
            String imagesCodeForPost = writeData.getImagesCodeForPost();
            if (writeData.getType() != 6) {
                if (writeData.getType() == 7 && TextUtils.isEmpty(writeData.getTitle()) && TextUtils.isEmpty(str) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(str9) && writeData.getVideoInfo() == null) {
                    this.f57742b.setError_code(-53);
                    this.f57742b.setError_msg(TbadkCoreApplication.getInst().getString(R.string.sand_fail));
                    return null;
                }
                if ((!(writeData.getType() == 0 || writeData.getType() == 9) || TextUtils.isEmpty(writeData.getTitle())) && TextUtils.isEmpty(str) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(str9) && writeData.getVideoInfo() == null && writeData.getType() != 7 && !writeData.isLinkThread() && writeData.getWriteVoteData() == null) {
                    this.f57742b.setError_code(-53);
                    this.f57742b.setError_msg(TbadkCoreApplication.getInst().getString(R.string.sand_fail));
                    return null;
                }
            }
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.f57741a.addPostData("vcode", writeData.getVcode());
            }
            if (!StringUtils.isNull(writeData.getVcodeMD5())) {
                this.f57741a.addPostData("vcode_md5", writeData.getVcodeMD5());
            }
            if (!StringUtils.isNull(writeData.getVcodeType())) {
                this.f57741a.addPostData("vcode_type", writeData.getVcodeType());
            }
            if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.f57741a.addPostData("vcode_tag", "12");
            }
            Address h2 = d.a.c.e.i.a.l().h(false);
            if (!TextUtils.isEmpty(writeData.getTopicId())) {
                this.f57741a.addPostData("topic_id", writeData.getTopicId());
            }
            this.f57741a.addPostData("new_vcode", "1");
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
            String b3 = d.a.n0.l0.a.b(str4);
            if (!TextUtils.isEmpty(str3)) {
                str3 = d.a.n0.l0.a.b(str3);
            }
            this.f57741a.addPostData("content", b3);
            this.f57741a.addPostData("reply_uid", writeData.getReplyId());
            if (!TextUtils.isEmpty(writeData.getMemeText())) {
                this.f57741a.addPostData("meme_text", writeData.getMemeText());
            }
            if (!TextUtils.isEmpty(writeData.getMemeContSign())) {
                this.f57741a.addPostData("meme_cont_sign", writeData.getMemeContSign());
            }
            if (!TextUtils.isEmpty(writeData.getItem_id())) {
                this.f57741a.addPostData(LegoListActivityConfig.ITEM_ID, writeData.getItem_id());
            }
            if (!TextUtils.isEmpty(writeData.getComment_head())) {
                this.f57741a.addPostData("comment_head", writeData.getComment_head());
            }
            d.a.n0.e3.q0.b.a("设置数据");
            int type = writeData.getType();
            str5 = str9;
            if (type != 0) {
                str7 = str3;
                str6 = title;
                if (type == 1) {
                    this.f57741a.setUrl(l);
                    this.f57741a.addPostData("fid", writeData.getForumId());
                    this.f57741a.addPostData("from_fourm_id", writeData.getFromForumId());
                    this.f57741a.addPostData("v_fid", writeData.getVForumId());
                    this.f57741a.addPostData("v_fname", writeData.getVForumName());
                    this.f57741a.addPostData("tid", writeData.getThreadId());
                    this.f57741a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                    this.f57741a.addPostData("is_ad", writeData.getIsAd() ? "1" : "0");
                    this.f57741a.addPostData("is_barrage", writeData.isBarrage() ? "1" : "0");
                    this.f57741a.addPostData("barrage_time", String.valueOf(writeData.getBarrageTime()));
                    if (writeData.isFrsReply()) {
                        this.f57741a.addPostData("st_param", "frs");
                    }
                    if (d.a.m0.w.w.a.a().b() == 1) {
                        this.f57741a.addPostData("ptype", "4");
                    }
                    if (!StringUtils.isNull(writeData.sourceFrom)) {
                        this.f57741a.addPostData("post_from", writeData.sourceFrom);
                    }
                    if (writeData.getBaijiahaoData() != null) {
                        this.f57741a.addPostData("ori_ugc_nid", writeData.getBaijiahaoData().oriUgcNid);
                        this.f57741a.addPostData("ori_ugc_tid", writeData.getBaijiahaoData().oriUgcTid);
                        this.f57741a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(writeData.getBaijiahaoData().oriUgcType));
                        this.f57741a.addPostData("ori_ugc_vid", writeData.getBaijiahaoData().oriUgcVid);
                    }
                    d.a.n0.e3.q0.g.a(this.f57741a, writeData);
                } else if (type == 2) {
                    this.f57741a.setUrl(l);
                    this.f57741a.addPostData("fid", writeData.getForumId());
                    this.f57741a.addPostData("from_fourm_id", writeData.getFromForumId());
                    this.f57741a.addPostData("v_fid", writeData.getVForumId());
                    this.f57741a.addPostData("v_fname", writeData.getVForumName());
                    this.f57741a.addPostData("tid", writeData.getThreadId());
                    this.f57741a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                    this.f57741a.addPostData("quote_id", String.valueOf(writeData.getFloor()));
                    this.f57741a.addPostData("is_twzhibo_thread", String.valueOf(0));
                    this.f57741a.addPostData("floor_num", String.valueOf(writeData.getFloorNum()));
                    if (writeData.getRepostId() != null) {
                        this.f57741a.addPostData("repostid", writeData.getRepostId());
                    }
                    this.f57741a.addPostData("is_ad", writeData.getIsAd() ? "1" : "0");
                    this.f57741a.addPostData("is_addition", writeData.isAddition() ? "1" : "0");
                    this.f57741a.addPostData("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                    this.f57741a.addPostData("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                    if (writeData.isAddition()) {
                        this.f57741a.addPostData("st_type", "conadd");
                    }
                    if (!StringUtils.isNull(writeData.sourceFrom)) {
                        this.f57741a.addPostData("post_from", writeData.sourceFrom);
                    }
                    if (writeData.getBaijiahaoData() != null) {
                        this.f57741a.addPostData("ori_ugc_nid", writeData.getBaijiahaoData().oriUgcNid);
                        this.f57741a.addPostData("ori_ugc_tid", writeData.getBaijiahaoData().oriUgcTid);
                        this.f57741a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(writeData.getBaijiahaoData().oriUgcType));
                        this.f57741a.addPostData("ori_ugc_vid", writeData.getBaijiahaoData().oriUgcVid);
                    }
                } else if (type == 4) {
                    String str14 = str2;
                    this.f57741a.setUrl(k);
                    this.f57741a.addPostData("fid", writeData.getForumId());
                    this.f57741a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                    if (!TextUtils.isEmpty(writeData.getTitle())) {
                        this.f57741a.addPostData("title", writeData.getTitle());
                    }
                    if (!StringUtils.isNull(writeData.getPostPrefix())) {
                        this.f57741a.addPostData(str14, writeData.getPostPrefix());
                    }
                    this.f57741a.addPostData("thread_type", EventType.GiftEventID.SEND_GIFT_TO_MULTIUSER_FAIL);
                    d.a.n0.e3.q0.g.a(this.f57741a, writeData);
                } else if (type == 5) {
                    this.f57741a.setUrl(l);
                    this.f57741a.addPostData("fid", writeData.getForumId());
                    this.f57741a.addPostData("tid", writeData.getThreadId());
                    this.f57741a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                    this.f57741a.addPostData("is_twzhibo_thread", String.valueOf(1));
                    if (writeData.getBaijiahaoData() != null) {
                        this.f57741a.addPostData("ori_ugc_nid", writeData.getBaijiahaoData().oriUgcNid);
                        this.f57741a.addPostData("ori_ugc_tid", writeData.getBaijiahaoData().oriUgcTid);
                        this.f57741a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(writeData.getBaijiahaoData().oriUgcType));
                        this.f57741a.addPostData("ori_ugc_vid", writeData.getBaijiahaoData().oriUgcVid);
                    }
                    d.a.n0.e3.q0.g.a(this.f57741a, writeData);
                } else if (type == 6) {
                    this.f57741a.setUrl(k);
                    this.f57741a.addPostData("fid", writeData.getForumId());
                    this.f57741a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                    this.f57741a.addPostData("thread_type", String.valueOf(36));
                    if (!TextUtils.isEmpty(writeData.getTitle())) {
                        this.f57741a.addPostData("title", writeData.getTitle());
                    }
                    if (!StringUtils.isNull(writeData.getPostPrefix())) {
                        this.f57741a.addPostData(str2, writeData.getPostPrefix());
                    }
                    this.f57741a.addPostData("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.f57741a.addPostData("st_type", "notitle");
                    }
                    d.a.n0.e3.q0.g.a(this.f57741a, writeData);
                } else if (type != 7 && type != 9) {
                    if (writeData.isCanNoForum()) {
                        this.f57741a.addPostData("fid", "0");
                        this.f57741a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, "");
                        this.f57741a.addPostData("transform_forums", writeData.getTransmitForumData());
                    } else {
                        this.f57741a.addPostData("fid", writeData.getForumId());
                        this.f57741a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                    }
                }
                str8 = imagesCodeForPost;
            } else {
                str6 = title;
                str7 = str3;
            }
            String str15 = str2;
            this.f57741a.setUrl(k);
            if (writeData.isCanNoForum()) {
                this.f57741a.addPostData("fid", "0");
                this.f57741a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, "");
                this.f57741a.addPostData("transform_forums", writeData.getTransmitForumData());
            } else {
                this.f57741a.addPostData("fid", writeData.getForumId());
                this.f57741a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
            }
            this.f57741a.addPostData("is_hide", writeData.isPrivacy() ? "1" : "0");
            this.f57741a.addPostData("is_repost_to_dynamic", writeData.isToDynamic() ? "1" : "0");
            if (writeData.getVideoId() != null) {
                this.f57741a.addPostData("video_id", writeData.getVideoId());
                if (writeData.getOriginalVideoCover() != null) {
                    this.f57741a.addPostData("origin_video_cover", writeData.getOriginalVideoCover());
                }
                if (writeData.getOriginalVideoTitle() != null) {
                    this.f57741a.addPostData("origin_video_title", writeData.getOriginalVideoTitle());
                }
            }
            if (writeData.isShareThread()) {
                this.f57741a.addPostData("is_share", "1");
                this.f57741a.addPostData("from_tid", writeData.getOriginalThreadId());
            }
            if (writeData.getProZone() >= 0) {
                this.f57741a.addPostData(EditVideoActivityConfig.KEY_PRO_ZONE, String.valueOf(writeData.getProZone()));
            }
            this.f57741a.addPostData(IntentConfig.CALL_FROM, writeData.getStatisticFrom() + "");
            if (!TextUtils.isEmpty(str6)) {
                this.f57741a.addPostData("title", str6);
            }
            if (!TextUtils.isEmpty(str7)) {
                this.f57741a.addPostData("video_abstract", str7);
            }
            if (!StringUtils.isNull(writeData.getPostPrefix())) {
                this.f57741a.addPostData(str15, writeData.getPostPrefix());
            }
            this.f57741a.addPostData("is_ntitle", writeData.isNoTitle() ? "1" : "0");
            if (writeData.isNoTitle()) {
                this.f57741a.addPostData("st_type", "notitle");
            }
            if (h2 != null && TbadkCoreApplication.getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(writeData.getForumId())) {
                this.f57741a.addPostData("lbs", String.valueOf(h2.getLatitude()) + "," + String.valueOf(h2.getLongitude()));
            }
            d.a.n0.e3.q0.g.a(this.f57741a, writeData);
            if (writeData.getCategoryFrom() >= 0) {
                this.f57741a.addPostData("fromCategoryId", String.valueOf(writeData.getCategoryFrom()));
            }
            if (writeData.getCategoryTo() >= 0) {
                this.f57741a.addPostData("toCategoryId", String.valueOf(writeData.getCategoryTo()));
            }
            if (writeData.getType() == 7) {
                this.f57741a.addPostData("is_bottle", String.valueOf(1));
            }
            if (writeData.getRecommendExt() != null) {
                this.f57741a.addPostData("recommend_ext", writeData.getRecommendExt());
            }
            if (writeData.isLinkThread()) {
                this.f57741a.addPostData("link_url", writeData.getLinkUrl());
                this.f57741a.addPostData("link_url_code", writeData.getLinkUrlCode() == null ? "" : writeData.getLinkUrlCode());
            }
            this.f57741a.addPostData("is_link_thread", writeData.isLinkThread() ? "1" : "0");
            if (writeData.isShareThread()) {
                if (writeData.getOriBaijiahaoData() != null) {
                    this.f57741a.addPostData("ori_ugc_nid", writeData.getOriBaijiahaoData().oriUgcNid);
                    this.f57741a.addPostData("ori_ugc_vid", writeData.getOriBaijiahaoData().oriUgcVid);
                    this.f57741a.addPostData("ori_ugc_tid", writeData.getOriBaijiahaoData().oriUgcTid);
                    this.f57741a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(writeData.getOriBaijiahaoData().oriUgcType));
                }
            } else if (writeData.getBaijiahaoData() != null) {
                this.f57741a.addPostData("ori_ugc_nid", writeData.getBaijiahaoData().oriUgcNid);
                this.f57741a.addPostData("ori_ugc_vid", writeData.getBaijiahaoData().oriUgcVid);
                this.f57741a.addPostData("ori_ugc_tid", writeData.getBaijiahaoData().oriUgcTid);
                this.f57741a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(writeData.getBaijiahaoData().oriUgcType));
            }
            if (writeData.getTabId() > 0) {
                this.f57741a.addPostData("tab_name", writeData.getTabName());
                this.f57741a.addPostData("tab_id", String.valueOf(writeData.getTabId()));
                this.f57741a.addPostData("is_general_tab", String.valueOf(writeData.getIsGeneralTab()));
            }
            this.f57741a.addPostData("is_forum_business_account", writeData.isForumBusinessAccount ? "1" : "0");
            str8 = imagesCodeForPost;
        }
        if (writeData.isPostLatLng()) {
            String lat = writeData.getLat() == null ? "" : writeData.getLat();
            String lng = writeData.getLng() != null ? writeData.getLng() : "";
            this.f57741a.addPostData("real_lat", lat);
            this.f57741a.addPostData("real_lng", lng);
        }
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.f57741a.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
        }
        d.a.n0.e3.q0.b.a("发帖：其他数据设置开始 发送");
        i1.g(writeData, 93).e(true);
        String postNetData = this.f57741a.postNetData();
        d.a.n0.e3.q0.b.a("发帖：其他数据设置开始 结束 进度到 95");
        i1.g(writeData, 95).e(true);
        f(95);
        if (this.f57741a.getNetContext().getResponse().isRequestSuccess()) {
            this.f57742b.parserJson(postNetData);
        } else {
            this.f57742b.setError_code(this.f57741a.isNetSuccess() ? this.f57741a.getServerErrorCode() : this.f57741a.getNetErrorCode());
            this.f57742b.setError_msg(this.f57741a.getErrorString());
        }
        if (this.f57742b.error_code != 0 && !j.z()) {
            this.f57742b.setError_msg(TbadkCoreApplication.getInst().getApp().getString(R.string.neterror));
        } else if (this.f57742b.error_code != 0 && writeData.isHasImages()) {
            if (k.isEmpty(str5 + str8)) {
                this.f57742b.setError_msg(TbadkCoreApplication.getInst().getApp().getString(R.string.img_upload_error));
            }
        }
        try {
            AntiData antiData = new AntiData();
            this.f57744d = antiData;
            antiData.parserJson(new JSONObject(postNetData).optJSONObject("anti_stat"));
        } catch (Exception unused) {
        }
        if (this.f57744d.getBlock_stat() == 0 && this.f57742b.error_code == 0 && this.f57741a.getNetContext() != null && this.f57741a.getNetContext().getRequest() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921344, this.f57741a.getNetContext().getRequest().getNetWorkParam()));
        }
        f(100);
        d.a.n0.e3.q0.b.a("发帖：处理整个 发帖过程 结束数据 完成 进度到 100");
        return postNetData;
    }

    public void i(c cVar) {
        this.f57747g = cVar;
    }

    public void j(SpanGroupManager spanGroupManager) {
        this.f57749i = spanGroupManager;
    }

    public void k(String str) {
        this.j = str;
    }

    public void l(g gVar) {
        this.f57748h = gVar;
    }
}
