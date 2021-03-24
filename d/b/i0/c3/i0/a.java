package d.b.i0.c3.i0;

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
import com.tencent.connect.common.Constants;
import d.b.b.e.p.j;
import d.b.b.e.p.k;
import d.b.h0.b0.f;
import d.b.h0.r.q.i1;
import d.b.h0.s.c.o;
import d.b.h0.s.c.p;
import d.b.i0.c3.o0.d.e;
import d.b.i0.s1.g;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {
    public static final String k = TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS;
    public static final String l = TbConfig.SERVER_ADDRESS + TbConfig.REPLY_THREAD_ADDRESS;
    public static final String m = TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_FOR_SHARE_ADDRESS;

    /* renamed from: b  reason: collision with root package name */
    public ErrorData f53429b;

    /* renamed from: d  reason: collision with root package name */
    public AntiData f53431d;

    /* renamed from: e  reason: collision with root package name */
    public f f53432e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.c3.o0.a f53433f;

    /* renamed from: g  reason: collision with root package name */
    public c f53434g;

    /* renamed from: h  reason: collision with root package name */
    public g f53435h;
    public SpanGroupManager i;
    public String j;

    /* renamed from: a  reason: collision with root package name */
    public NetWork f53428a = null;

    /* renamed from: c  reason: collision with root package name */
    public boolean f53430c = false;

    /* renamed from: d.b.i0.c3.i0.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1185a implements f.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteData f53436a;

        public C1185a(a aVar, WriteData writeData) {
            this.f53436a = writeData;
        }

        @Override // d.b.h0.b0.f.b
        public void a(String str, Object obj, long j, long j2, int i, int i2) {
            d.b.i0.c3.q0.b.a("发帖：发送图片 进度 = " + i + "/" + i2 + " :" + j + "/" + j2 + "   ，" + str);
            int i3 = (int) (90.0f / ((float) i2));
            float f2 = (((float) j) / 2.0f) / ((float) j2);
            if (f2 > 1.0f) {
                f2 = 1.0f;
            }
            i1.g(this.f53436a, (int) (((f2 + i) - 1.0f) * i3)).e(true);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements e {

        /* renamed from: a  reason: collision with root package name */
        public int f53437a = 0;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ WriteData f53438b;

        public b(WriteData writeData) {
            this.f53438b = writeData;
        }

        @Override // d.b.i0.c3.o0.d.e
        public void onProgressUpdate(float f2) {
            d.b.i0.c3.q0.b.a("发帖：开始上传视频 percent = " + f2);
            int i = (int) (f2 * 90.0f);
            i1.g(this.f53438b, i).e(true);
            if (i != this.f53437a) {
                this.f53437a = i;
                a.this.f(i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(int i);
    }

    public a() {
        this.f53429b = null;
        this.f53429b = new ErrorData();
    }

    public void b() {
        this.f53430c = true;
        NetWork netWork = this.f53428a;
        if (netWork != null) {
            netWork.cancelNetConnect();
        }
        f fVar = this.f53432e;
        if (fVar != null) {
            fVar.a();
        }
        d.b.i0.c3.o0.a aVar = this.f53433f;
        if (aVar != null) {
            aVar.a();
        }
    }

    public AntiData c() {
        return this.f53431d;
    }

    public ErrorData d() {
        return this.f53429b;
    }

    public boolean e() {
        NetWork netWork = this.f53428a;
        if (netWork == null) {
            return false;
        }
        return netWork.getNetContext().getResponse().isRequestSuccess();
    }

    public final void f(int i) {
        c cVar = this.f53434g;
        if (cVar != null) {
            cVar.a(i);
        }
    }

    public ImageUploadResult g(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        if (this.f53432e == null) {
            this.f53432e = new f("HTTPWriteService.postImageData");
        }
        return this.f53432e.g(imageFileInfo, z);
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
        d.b.i0.c3.q0.b.a("发帖：postWriteData 开始");
        NetWork netWork = new NetWork();
        this.f53428a = netWork;
        netWork.getNetContext().getRequest().mIsNeedTbs = true;
        this.f53428a.setNeedSig(true);
        this.f53428a.addPostData("authsid", writeData.getAuthSid());
        if (!TextUtils.isEmpty(this.j)) {
            content = this.j;
            writeData.setSpanGroupString(content);
        } else {
            SpanGroupManager spanGroupManager = this.i;
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
        d.b.i0.c3.q0.b.a("发帖：发帖类型：" + writeData.getType());
        if (writeData.getType() == 3) {
            d.b.i0.c3.q0.b.a("发帖：SHARE_SDK：设置数据");
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.f53428a.addPostData("vcode", writeData.getVcode());
            }
            if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.f53428a.addPostData("tag", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
            }
            this.f53428a.addPostData("newVcode", "1");
            this.f53428a.addPostData("content", str9);
            this.f53428a.setUrl(m);
            this.f53428a.addPostData("fname", writeData.getForumName());
            if (!TextUtils.isEmpty(writeData.getTitle())) {
                this.f53428a.addPostData("title", writeData.getTitle());
            }
            if (!StringUtils.isNull(writeData.getPostPrefix())) {
                this.f53428a.addPostData("post_prefix", writeData.getPostPrefix());
            }
            this.f53428a.addPostData("apiKey", writeData.getShareApiKey());
            this.f53428a.addPostData("appName", writeData.getShareAppName());
            this.f53428a.addPostData("signKey", writeData.getShareSignKey());
            this.f53428a.addPostData("summary_title", writeData.getShareSummaryTitle());
            this.f53428a.addPostData("summary_content", writeData.getShareSummaryContent());
            this.f53428a.addPostData("summary_img", writeData.getShareSummaryImg());
            this.f53428a.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(writeData.getShareSummaryImgWidth()));
            this.f53428a.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(writeData.getShareSummaryImgHeight()));
            this.f53428a.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, writeData.getShareSummaryImgType());
            this.f53428a.addPostData("referUrl", writeData.getShareReferUrl());
            str5 = str9;
        } else {
            d.b.i0.c3.q0.b.a("发帖：开始分段数据发送");
            if (z && writeData.isHasImages()) {
                d.b.i0.c3.q0.b.a("发帖：发送图片 开始");
                if (this.f53432e == null) {
                    f fVar = new f("HTTPWriteService.postWriteData");
                    this.f53432e = fVar;
                    fVar.d(new C1185a(this, writeData), writeData);
                }
                if (writeData.getType() == 6) {
                    d.b.i0.c3.q0.b.a("发帖：发送图片 上传图片 开始 1");
                    if (this.f53432e.n(writeData.getWriteImagesInfo(), true) != null) {
                        this.f53429b.setError_code(-53);
                        this.f53429b.setError_msg(TbadkCoreApplication.getInst().getString(R.string.upload_error));
                        d.b.i0.c3.q0.b.a("发帖：发送图片 上传图片 错误 1");
                        return null;
                    }
                    d.b.i0.c3.q0.b.a("发帖：发送图片 上传图片 完成 1");
                } else {
                    d.b.i0.c3.q0.b.a("发帖：发送图片 上传图片 开始 2");
                    this.f53432e.m = writeData.isBJHPost();
                    ErrorData n = this.f53432e.n(writeData.getWriteImagesInfo(), true);
                    if (n != null) {
                        this.f53429b.setError_code(-53);
                        this.f53429b.setError_msg(n.getError_msg());
                        d.b.i0.c3.q0.b.a("发帖：发送图片 上传图片 错误 2");
                        return null;
                    }
                    d.b.i0.c3.q0.b.a("发帖：发送图片 上传图片 完成 2");
                }
            }
            if (this.f53430c) {
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
            d.b.i0.c3.q0.b.a("声音文件 = " + voice);
            if (voice == null || z2) {
                str = returnVoiceMd5;
            } else {
                d.b.i0.c3.q0.b.a("发帖：发送声音 开始");
                d.b.h0.r.g0.c.b bVar = new d.b.h0.r.g0.c.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                bVar.a("type", 1);
                String storeFile = FileHelper.getStoreFile(voice, 1);
                p d2 = bVar.d(storeFile);
                if (d2 != null && d2.d()) {
                    o a2 = d2.a();
                    if (a2 != null) {
                        String b2 = a2.b();
                        d.b.h0.r.g0.b.b.b(writeData.getVoice(), b2);
                        writeData.setReturnVoiceMd5(b2);
                        d.b.i0.c3.q0.b.a("发帖：发送声音 完成 1");
                        str = b2;
                    } else {
                        FieldBuilder fieldBuilder = new FieldBuilder();
                        fieldBuilder.append("ErrCode", Integer.valueOf(d2.b()));
                        fieldBuilder.append("ErrMsg", d2.c());
                        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "audioUploadData is null", fieldBuilder.toString());
                        this.f53429b.setError_code(d2.b());
                        this.f53429b.setError_msg(d2.c());
                        d.b.i0.c3.q0.b.a("发帖：发送声音 失败 1");
                        return null;
                    }
                } else {
                    FieldBuilder fieldBuilder2 = new FieldBuilder();
                    fieldBuilder2.append("audioFile", storeFile);
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "uploadService.upload null or fail", fieldBuilder2.toString());
                    if (d2 != null) {
                        this.f53429b.setError_code(d2.b());
                        this.f53429b.setError_msg(d2.c());
                    }
                    d.b.i0.c3.q0.b.a("发帖：发送声音 失败 2");
                    return null;
                }
            }
            if (this.f53430c) {
                return null;
            }
            VideoInfo videoInfo = writeData.getVideoInfo();
            if (videoInfo != null) {
                if (videoInfo.needUploadVideo()) {
                    this.f53433f = new d.b.i0.c3.o0.a(this.f53435h);
                    d.b.i0.c3.q0.b.a("发帖：开始上传视频");
                    str2 = "post_prefix";
                    VideoFinishResult e2 = this.f53433f.e(writeData.getForumId(), videoInfo.getVideoPath(), videoInfo.getVideoDuration(), new b(writeData));
                    if (e2 == null) {
                        this.f53429b.setError_code(-53);
                        this.f53429b.setError_msg(TbadkCoreApplication.getInst().getString(R.string.upload_error));
                        d.b.i0.c3.q0.b.a("发帖：开始上传视频 失败 1");
                        return null;
                    } else if (e2.isSuccess()) {
                        videoInfo.setVideoMd5(e2.getVideoMd5());
                        videoInfo.setVideoUrl(e2.getVideoUrl());
                        d.b.i0.c3.q0.b.a("发帖：开始上传视频 成功 ");
                    } else {
                        this.f53429b.setError_code(e2.getErrorNo());
                        this.f53429b.setError_msg(e2.getUserMessage());
                        d.b.i0.c3.q0.b.a("发帖：开始上传视频 失败 2");
                        return null;
                    }
                } else {
                    str2 = "post_prefix";
                }
                if (videoInfo.needUploadThunmb()) {
                    d.b.i0.c3.q0.b.a("发帖：开始上传首帧图 开始 ");
                    if (this.f53432e == null) {
                        this.f53432e = new f("HTTPWriteService.postWriteData");
                    }
                    ImageUploadResult j = this.f53432e.j(videoInfo.getThumbPath(), false);
                    if (j != null) {
                        videoInfo.setThumbId(j.picId);
                        ImageUploadResult.picInfo picinfo = j.picInfo;
                        if (picinfo != null && (picDetailedInfo = picinfo.bigPic) != null && !StringUtils.isNull(picDetailedInfo.picUrl)) {
                            d.b.i0.c3.q0.a.f().s(j.picInfo.bigPic.picUrl);
                        }
                    }
                    d.b.i0.c3.q0.b.a("发帖：开始上传首帧图 完成 ");
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
                this.f53428a.addPostData("video_other", jSONObject.toString());
            } else {
                str2 = "post_prefix";
            }
            d.b.i0.c3.q0.b.a("发帖：上传视频结束 完全完成 ");
            if (this.f53430c) {
                return null;
            }
            d.b.i0.c3.q0.b.a("发帖：其他数据设置开始 ");
            this.f53428a.addPostData("anonymous", "1");
            this.f53428a.addPostData("can_no_forum", writeData.isCanNoForum() ? "1" : "0");
            this.f53428a.addPostData("is_feedback", writeData.isUserFeedback() ? "1" : "0");
            this.f53428a.addPostData("takephoto_num", String.valueOf(writeData.getTakePhotoNum()));
            this.f53428a.addPostData("entrance_type", String.valueOf(writeData.getEntranceType()));
            if (str != null) {
                this.f53428a.addPostData("voice_md5", str);
                this.f53428a.addPostData("during_time", String.valueOf(voiceDuringTime));
            }
            String imagesCodeForPost = writeData.getImagesCodeForPost();
            if (writeData.getType() != 6) {
                if (writeData.getType() == 7 && TextUtils.isEmpty(writeData.getTitle()) && TextUtils.isEmpty(str) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(str9) && writeData.getVideoInfo() == null) {
                    this.f53429b.setError_code(-53);
                    this.f53429b.setError_msg(TbadkCoreApplication.getInst().getString(R.string.sand_fail));
                    return null;
                }
                if ((!(writeData.getType() == 0 || writeData.getType() == 9) || TextUtils.isEmpty(writeData.getTitle())) && TextUtils.isEmpty(str) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(str9) && writeData.getVideoInfo() == null && writeData.getType() != 7 && !writeData.isLinkThread() && writeData.getWriteVoteData() == null) {
                    this.f53429b.setError_code(-53);
                    this.f53429b.setError_msg(TbadkCoreApplication.getInst().getString(R.string.sand_fail));
                    return null;
                }
            }
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.f53428a.addPostData("vcode", writeData.getVcode());
            }
            if (!StringUtils.isNull(writeData.getVcodeMD5())) {
                this.f53428a.addPostData("vcode_md5", writeData.getVcodeMD5());
            }
            if (!StringUtils.isNull(writeData.getVcodeType())) {
                this.f53428a.addPostData("vcode_type", writeData.getVcodeType());
            }
            if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.f53428a.addPostData("vcode_tag", Constants.VIA_REPORT_TYPE_SET_AVATAR);
            }
            Address h2 = d.b.b.e.i.a.l().h(false);
            if (!TextUtils.isEmpty(writeData.getTopicId())) {
                this.f53428a.addPostData("topic_id", writeData.getTopicId());
            }
            this.f53428a.addPostData("new_vcode", "1");
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
            String b3 = d.b.i0.k0.a.b(str4);
            if (!TextUtils.isEmpty(str3)) {
                str3 = d.b.i0.k0.a.b(str3);
            }
            this.f53428a.addPostData("content", b3);
            this.f53428a.addPostData("reply_uid", writeData.getReplyId());
            if (!TextUtils.isEmpty(writeData.getMemeText())) {
                this.f53428a.addPostData("meme_text", writeData.getMemeText());
            }
            if (!TextUtils.isEmpty(writeData.getMemeContSign())) {
                this.f53428a.addPostData("meme_cont_sign", writeData.getMemeContSign());
            }
            if (!TextUtils.isEmpty(writeData.getItem_id())) {
                this.f53428a.addPostData(LegoListActivityConfig.ITEM_ID, writeData.getItem_id());
            }
            if (!TextUtils.isEmpty(writeData.getComment_head())) {
                this.f53428a.addPostData("comment_head", writeData.getComment_head());
            }
            d.b.i0.c3.q0.b.a("设置数据");
            int type = writeData.getType();
            str5 = str9;
            if (type != 0) {
                str7 = str3;
                str6 = title;
                if (type == 1) {
                    this.f53428a.setUrl(l);
                    this.f53428a.addPostData("fid", writeData.getForumId());
                    this.f53428a.addPostData("from_fourm_id", writeData.getFromForumId());
                    this.f53428a.addPostData("v_fid", writeData.getVForumId());
                    this.f53428a.addPostData("v_fname", writeData.getVForumName());
                    this.f53428a.addPostData("tid", writeData.getThreadId());
                    this.f53428a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                    this.f53428a.addPostData("is_ad", writeData.getIsAd() ? "1" : "0");
                    this.f53428a.addPostData("is_barrage", writeData.isBarrage() ? "1" : "0");
                    this.f53428a.addPostData("barrage_time", String.valueOf(writeData.getBarrageTime()));
                    if (writeData.isFrsReply()) {
                        this.f53428a.addPostData("st_param", "frs");
                    }
                    if (d.b.h0.w.w.a.a().b() == 1) {
                        this.f53428a.addPostData("ptype", "4");
                    }
                    if (!StringUtils.isNull(writeData.sourceFrom)) {
                        this.f53428a.addPostData("post_from", writeData.sourceFrom);
                    }
                    if (writeData.getBaijiahaoData() != null) {
                        this.f53428a.addPostData("ori_ugc_nid", writeData.getBaijiahaoData().oriUgcNid);
                        this.f53428a.addPostData("ori_ugc_tid", writeData.getBaijiahaoData().oriUgcTid);
                        this.f53428a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(writeData.getBaijiahaoData().oriUgcType));
                        this.f53428a.addPostData("ori_ugc_vid", writeData.getBaijiahaoData().oriUgcVid);
                    }
                    d.b.i0.c3.q0.g.a(this.f53428a, writeData);
                } else if (type == 2) {
                    this.f53428a.setUrl(l);
                    this.f53428a.addPostData("fid", writeData.getForumId());
                    this.f53428a.addPostData("from_fourm_id", writeData.getFromForumId());
                    this.f53428a.addPostData("v_fid", writeData.getVForumId());
                    this.f53428a.addPostData("v_fname", writeData.getVForumName());
                    this.f53428a.addPostData("tid", writeData.getThreadId());
                    this.f53428a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                    this.f53428a.addPostData("quote_id", String.valueOf(writeData.getFloor()));
                    this.f53428a.addPostData("is_twzhibo_thread", String.valueOf(0));
                    this.f53428a.addPostData("floor_num", String.valueOf(writeData.getFloorNum()));
                    if (writeData.getRepostId() != null) {
                        this.f53428a.addPostData("repostid", writeData.getRepostId());
                    }
                    this.f53428a.addPostData("is_ad", writeData.getIsAd() ? "1" : "0");
                    this.f53428a.addPostData("is_addition", writeData.isAddition() ? "1" : "0");
                    this.f53428a.addPostData("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                    this.f53428a.addPostData("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                    if (writeData.isAddition()) {
                        this.f53428a.addPostData("st_type", "conadd");
                    }
                    if (!StringUtils.isNull(writeData.sourceFrom)) {
                        this.f53428a.addPostData("post_from", writeData.sourceFrom);
                    }
                    if (writeData.getBaijiahaoData() != null) {
                        this.f53428a.addPostData("ori_ugc_nid", writeData.getBaijiahaoData().oriUgcNid);
                        this.f53428a.addPostData("ori_ugc_tid", writeData.getBaijiahaoData().oriUgcTid);
                        this.f53428a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(writeData.getBaijiahaoData().oriUgcType));
                        this.f53428a.addPostData("ori_ugc_vid", writeData.getBaijiahaoData().oriUgcVid);
                    }
                } else if (type == 4) {
                    String str14 = str2;
                    this.f53428a.setUrl(k);
                    this.f53428a.addPostData("fid", writeData.getForumId());
                    this.f53428a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                    if (!TextUtils.isEmpty(writeData.getTitle())) {
                        this.f53428a.addPostData("title", writeData.getTitle());
                    }
                    if (!StringUtils.isNull(writeData.getPostPrefix())) {
                        this.f53428a.addPostData(str14, writeData.getPostPrefix());
                    }
                    this.f53428a.addPostData("thread_type", "33");
                    d.b.i0.c3.q0.g.a(this.f53428a, writeData);
                } else if (type == 5) {
                    this.f53428a.setUrl(l);
                    this.f53428a.addPostData("fid", writeData.getForumId());
                    this.f53428a.addPostData("tid", writeData.getThreadId());
                    this.f53428a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                    this.f53428a.addPostData("is_twzhibo_thread", String.valueOf(1));
                    if (writeData.getBaijiahaoData() != null) {
                        this.f53428a.addPostData("ori_ugc_nid", writeData.getBaijiahaoData().oriUgcNid);
                        this.f53428a.addPostData("ori_ugc_tid", writeData.getBaijiahaoData().oriUgcTid);
                        this.f53428a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(writeData.getBaijiahaoData().oriUgcType));
                        this.f53428a.addPostData("ori_ugc_vid", writeData.getBaijiahaoData().oriUgcVid);
                    }
                    d.b.i0.c3.q0.g.a(this.f53428a, writeData);
                } else if (type == 6) {
                    this.f53428a.setUrl(k);
                    this.f53428a.addPostData("fid", writeData.getForumId());
                    this.f53428a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                    this.f53428a.addPostData("thread_type", String.valueOf(36));
                    if (!TextUtils.isEmpty(writeData.getTitle())) {
                        this.f53428a.addPostData("title", writeData.getTitle());
                    }
                    if (!StringUtils.isNull(writeData.getPostPrefix())) {
                        this.f53428a.addPostData(str2, writeData.getPostPrefix());
                    }
                    this.f53428a.addPostData("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.f53428a.addPostData("st_type", "notitle");
                    }
                    d.b.i0.c3.q0.g.a(this.f53428a, writeData);
                } else if (type != 7 && type != 9) {
                    if (writeData.isCanNoForum()) {
                        this.f53428a.addPostData("fid", "0");
                        this.f53428a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, "");
                        this.f53428a.addPostData("transform_forums", writeData.getTransmitForumData());
                    } else {
                        this.f53428a.addPostData("fid", writeData.getForumId());
                        this.f53428a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                    }
                }
                str8 = imagesCodeForPost;
            } else {
                str6 = title;
                str7 = str3;
            }
            String str15 = str2;
            this.f53428a.setUrl(k);
            if (writeData.isCanNoForum()) {
                this.f53428a.addPostData("fid", "0");
                this.f53428a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, "");
                this.f53428a.addPostData("transform_forums", writeData.getTransmitForumData());
            } else {
                this.f53428a.addPostData("fid", writeData.getForumId());
                this.f53428a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
            }
            this.f53428a.addPostData("is_hide", writeData.isPrivacy() ? "1" : "0");
            this.f53428a.addPostData("is_repost_to_dynamic", writeData.isToDynamic() ? "1" : "0");
            if (writeData.getVideoId() != null) {
                this.f53428a.addPostData("video_id", writeData.getVideoId());
                if (writeData.getOriginalVideoCover() != null) {
                    this.f53428a.addPostData("origin_video_cover", writeData.getOriginalVideoCover());
                }
                if (writeData.getOriginalVideoTitle() != null) {
                    this.f53428a.addPostData("origin_video_title", writeData.getOriginalVideoTitle());
                }
            }
            if (writeData.isShareThread()) {
                this.f53428a.addPostData("is_share", "1");
                this.f53428a.addPostData("from_tid", writeData.getOriginalThreadId());
            }
            if (writeData.getProZone() >= 0) {
                this.f53428a.addPostData(EditVideoActivityConfig.KEY_PRO_ZONE, String.valueOf(writeData.getProZone()));
            }
            this.f53428a.addPostData(IntentConfig.CALL_FROM, writeData.getStatisticFrom() + "");
            if (!TextUtils.isEmpty(str6)) {
                this.f53428a.addPostData("title", str6);
            }
            if (!TextUtils.isEmpty(str7)) {
                this.f53428a.addPostData("video_abstract", str7);
            }
            if (!StringUtils.isNull(writeData.getPostPrefix())) {
                this.f53428a.addPostData(str15, writeData.getPostPrefix());
            }
            this.f53428a.addPostData("is_ntitle", writeData.isNoTitle() ? "1" : "0");
            if (writeData.isNoTitle()) {
                this.f53428a.addPostData("st_type", "notitle");
            }
            if (h2 != null && TbadkCoreApplication.getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(writeData.getForumId())) {
                this.f53428a.addPostData("lbs", String.valueOf(h2.getLatitude()) + "," + String.valueOf(h2.getLongitude()));
            }
            d.b.i0.c3.q0.g.a(this.f53428a, writeData);
            if (writeData.getCategoryFrom() >= 0) {
                this.f53428a.addPostData("fromCategoryId", String.valueOf(writeData.getCategoryFrom()));
            }
            if (writeData.getCategoryTo() >= 0) {
                this.f53428a.addPostData("toCategoryId", String.valueOf(writeData.getCategoryTo()));
            }
            if (writeData.getType() == 7) {
                this.f53428a.addPostData("is_bottle", String.valueOf(1));
            }
            if (writeData.getRecommendExt() != null) {
                this.f53428a.addPostData("recommend_ext", writeData.getRecommendExt());
            }
            if (writeData.isLinkThread()) {
                this.f53428a.addPostData("link_url", writeData.getLinkUrl());
                this.f53428a.addPostData("link_url_code", writeData.getLinkUrlCode() == null ? "" : writeData.getLinkUrlCode());
            }
            this.f53428a.addPostData("is_link_thread", writeData.isLinkThread() ? "1" : "0");
            if (writeData.isShareThread()) {
                if (writeData.getOriBaijiahaoData() != null) {
                    this.f53428a.addPostData("ori_ugc_nid", writeData.getOriBaijiahaoData().oriUgcNid);
                    this.f53428a.addPostData("ori_ugc_vid", writeData.getOriBaijiahaoData().oriUgcVid);
                    this.f53428a.addPostData("ori_ugc_tid", writeData.getOriBaijiahaoData().oriUgcTid);
                    this.f53428a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(writeData.getOriBaijiahaoData().oriUgcType));
                }
            } else if (writeData.getBaijiahaoData() != null) {
                this.f53428a.addPostData("ori_ugc_nid", writeData.getBaijiahaoData().oriUgcNid);
                this.f53428a.addPostData("ori_ugc_vid", writeData.getBaijiahaoData().oriUgcVid);
                this.f53428a.addPostData("ori_ugc_tid", writeData.getBaijiahaoData().oriUgcTid);
                this.f53428a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(writeData.getBaijiahaoData().oriUgcType));
            }
            if (writeData.getTabId() > 0) {
                this.f53428a.addPostData("tab_name", writeData.getTabName());
                this.f53428a.addPostData("tab_id", String.valueOf(writeData.getTabId()));
                this.f53428a.addPostData("is_general_tab", String.valueOf(writeData.getIsGeneralTab()));
            }
            this.f53428a.addPostData("is_forum_business_account", writeData.isForumBusinessAccount ? "1" : "0");
            str8 = imagesCodeForPost;
        }
        if (writeData.isPostLatLng()) {
            String lat = writeData.getLat() == null ? "" : writeData.getLat();
            String lng = writeData.getLng() != null ? writeData.getLng() : "";
            this.f53428a.addPostData("real_lat", lat);
            this.f53428a.addPostData("real_lng", lng);
        }
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.f53428a.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
        }
        d.b.i0.c3.q0.b.a("发帖：其他数据设置开始 发送");
        i1.g(writeData, 93).e(true);
        String postNetData = this.f53428a.postNetData();
        d.b.i0.c3.q0.b.a("发帖：其他数据设置开始 结束 进度到 95");
        i1.g(writeData, 95).e(true);
        f(95);
        if (this.f53428a.getNetContext().getResponse().isRequestSuccess()) {
            this.f53429b.parserJson(postNetData);
        } else {
            this.f53429b.setError_code(this.f53428a.isNetSuccess() ? this.f53428a.getServerErrorCode() : this.f53428a.getNetErrorCode());
            this.f53429b.setError_msg(this.f53428a.getErrorString());
        }
        if (this.f53429b.error_code != 0 && !j.z()) {
            this.f53429b.setError_msg(TbadkCoreApplication.getInst().getApp().getString(R.string.neterror));
        } else if (this.f53429b.error_code != 0 && writeData.isHasImages()) {
            if (k.isEmpty(str5 + str8)) {
                this.f53429b.setError_msg(TbadkCoreApplication.getInst().getApp().getString(R.string.img_upload_error));
            }
        }
        try {
            AntiData antiData = new AntiData();
            this.f53431d = antiData;
            antiData.parserJson(new JSONObject(postNetData).optJSONObject("anti_stat"));
        } catch (Exception unused) {
        }
        if (this.f53431d.getBlock_stat() == 0 && this.f53429b.error_code == 0 && this.f53428a.getNetContext() != null && this.f53428a.getNetContext().getRequest() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921344, this.f53428a.getNetContext().getRequest().getNetWorkParam()));
        }
        f(100);
        d.b.i0.c3.q0.b.a("发帖：处理整个 发帖过程 结束数据 完成 进度到 100");
        return postNetData;
    }

    public void i(c cVar) {
        this.f53434g = cVar;
    }

    public void j(SpanGroupManager spanGroupManager) {
        this.i = spanGroupManager;
    }

    public void k(String str) {
        this.j = str;
    }

    public void l(g gVar) {
        this.f53435h = gVar;
    }
}
