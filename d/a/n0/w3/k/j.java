package d.a.n0.w3.k;

import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoConvertUtil;
import com.baidu.tieba.write.video.AlbumVideoCompressingDialogView;
import d.a.c.e.p.l;
import d.a.m0.r.s.a;
import d.a.n0.u1.k;
import java.io.File;
/* loaded from: classes5.dex */
public class j implements d.a.n0.r3.d, Handler.Callback {
    public int A;
    public final CustomMessageListener B;

    /* renamed from: e  reason: collision with root package name */
    public BaseFragmentActivity f62860e;

    /* renamed from: f  reason: collision with root package name */
    public String f62861f;

    /* renamed from: g  reason: collision with root package name */
    public String f62862g;

    /* renamed from: h  reason: collision with root package name */
    public String f62863h;

    /* renamed from: i  reason: collision with root package name */
    public String f62864i;
    public VideoFileInfo j;
    public String k;
    public AlbumVideoCompressingDialogView o;
    public VideoConvertUtil p;
    public Handler q;
    public d.a.n0.u1.g r;
    public boolean s;
    public FrsTabInfoData t;
    public String u;
    public boolean l = false;
    public boolean m = false;
    public boolean n = false;
    public PostPrefixData v = null;
    public AntiData w = null;
    public String x = "";
    public String y = "";
    public int z = -1;

    /* loaded from: classes5.dex */
    public class a implements a.e {
        public a(j jVar) {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                Intent intent = new Intent();
                intent.putExtra(AlbumActivityConfig.FINISH_SELF, true);
                j.this.f62860e.setResult(-1, intent);
                j.this.f62860e.finish();
            }
        }
    }

    public j(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.r = kVar.get();
        }
        d.a.n0.u1.g gVar = this.r;
        if (gVar != null) {
            gVar.g();
        }
        this.B = new b(2001374);
        this.f62860e = baseFragmentActivity;
        this.f62861f = str;
        this.f62862g = str2;
        this.f62863h = str3;
        VideoConvertUtil videoConvertUtil = new VideoConvertUtil(baseFragmentActivity);
        this.p = videoConvertUtil;
        videoConvertUtil.t(this);
        this.q = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.B);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    public static VideoFileInfo e(String str) {
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            VideoFileInfo videoFileInfo = new VideoFileInfo();
            videoFileInfo.videoPath = str;
            videoFileInfo.lastModified = file.lastModified();
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                try {
                    try {
                        mediaMetadataRetriever.setDataSource(str);
                        videoFileInfo.videoDuration = d.a.c.e.m.b.d(mediaMetadataRetriever.extractMetadata(9), 0);
                        videoFileInfo.mimeType = mediaMetadataRetriever.extractMetadata(12);
                        videoFileInfo.videoWidth = d.a.c.e.m.b.d(mediaMetadataRetriever.extractMetadata(18), 0);
                        videoFileInfo.videoHeight = d.a.c.e.m.b.d(mediaMetadataRetriever.extractMetadata(19), 0);
                        mediaMetadataRetriever.release();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        mediaMetadataRetriever.release();
                    }
                } catch (Throwable th) {
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            return videoFileInfo;
        }
        return null;
    }

    @Override // d.a.n0.r3.d
    public void a(int i2) {
        this.q.sendEmptyMessage(2);
    }

    @Override // d.a.n0.r3.d
    public void b() {
    }

    public final void d() {
        VideoConvertUtil videoConvertUtil = this.p;
        if (videoConvertUtil != null) {
            videoConvertUtil.a();
        }
        this.n = true;
        if (this.k != null) {
            File file = new File(this.k);
            if (file.exists()) {
                file.delete();
            }
        }
        h();
        this.k = null;
    }

    public final void f(boolean z) {
        VideoFileInfo e2 = e(this.k);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.k);
        videoInfo.setVideoDuration(e2.videoDuration / 1000);
        videoInfo.setVideoWidth(e2.videoWidth);
        videoInfo.setVideoHeight(e2.videoHeight);
        videoInfo.setVideoLength(new File(e2.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.f62860e, this.f62864i, this.f62861f, this.f62862g, this.f62863h, videoInfo);
        editVideoActivityConfig.setProZone(this.z);
        editVideoActivityConfig.setStatisticFrom(this.A);
        editVideoActivityConfig.setFrsTabInfo(this.t);
        editVideoActivityConfig.setFrom(this.u);
        editVideoActivityConfig.setExtraData(this.w, this.v, this.x, this.y);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
        this.m = false;
        this.k = null;
        d.a.n0.u1.g gVar = this.r;
        if (gVar != null) {
            gVar.d();
        }
    }

    public void g(VideoFileInfo videoFileInfo, String str, String str2) {
        this.j = videoFileInfo;
        this.f62864i = str;
        this.u = str2;
        if (videoFileInfo == null || this.f62860e == null) {
            return;
        }
        if (videoFileInfo.videoDuration > 600000) {
            t();
            return;
        }
        VideoConvertUtil videoConvertUtil = this.p;
        if (videoConvertUtil == null || !videoConvertUtil.r()) {
            String str3 = this.j.videoPath;
            if (TextUtils.isEmpty(str3)) {
                l.L(this.f62860e, R.string.mv_local_video_video_not_exist);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str3));
                n(107);
            } else if (!new File(str3).exists()) {
                l.L(this.f62860e, R.string.mv_local_video_video_not_exist);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str3));
                n(106);
            } else if (XiaoyingUtil.isXiaoyingInstalled() && !XiaoyingUtil.isXiaoyingForbidden()) {
                if (VideoConvertUtil.p(str3) >= 1500000) {
                    if (VideoConvertUtil.m()) {
                        this.k = new File(VideoConvertUtil.n, "tieba_" + VideoConvertUtil.v(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.p.s(1);
                        this.p.n(str3, this.k);
                        s();
                        this.m = false;
                        this.n = false;
                        return;
                    }
                    return;
                }
                VideoFileInfo videoFileInfo2 = this.j;
                if (videoFileInfo2 != null) {
                    if (videoFileInfo2.videoDuration < 15000) {
                        this.k = new File(VideoConvertUtil.n, "tieba_" + VideoConvertUtil.v(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.p.s(2);
                        this.p.n(str3, this.k);
                        s();
                        this.m = false;
                        this.n = false;
                        return;
                    }
                    this.k = videoFileInfo2.videoPath;
                    f(false);
                    n(102);
                }
            } else {
                VideoFileInfo videoFileInfo3 = this.j;
                if (videoFileInfo3 != null) {
                    this.k = videoFileInfo3.videoPath;
                    f(false);
                    n(102);
                }
            }
        }
    }

    public final void h() {
        RelativeLayout relativeLayout = (RelativeLayout) this.f62860e.findViewById(R.id.parent);
        if (relativeLayout == null || this.o.getParent() == null) {
            return;
        }
        relativeLayout.removeView(this.o);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        this.q.removeMessages(5);
        int i2 = message.what;
        if (i2 == 1) {
            this.q.removeMessages(1);
            AlbumVideoCompressingDialogView albumVideoCompressingDialogView = this.o;
            if (albumVideoCompressingDialogView != null && albumVideoCompressingDialogView.b()) {
                this.o.setPercent(message.arg1);
            }
            Handler handler = this.q;
            handler.sendMessageDelayed(handler.obtainMessage(5), 60000L);
        } else if (i2 == 2) {
            if (!this.n) {
                l.L(this.f62860e, R.string.mv_local_video_compress_failed);
                n(103);
            }
            this.s = false;
            this.m = false;
            h();
        } else if (i2 == 3) {
            this.s = false;
            this.m = true;
            if (!StringUtils.isNull(this.k)) {
                File file = new File(this.k);
                this.k = this.k.replace("_tiebaconverting.mp4", ".mp4");
                file.renameTo(new File(this.k));
            }
            h();
            if (!this.l) {
                f(true);
                d.a.n0.u1.g gVar = this.r;
                if (gVar != null) {
                    gVar.d();
                }
            }
        } else if (i2 == 4) {
            this.s = false;
            this.m = false;
            h();
            n(104);
        } else if (i2 == 5) {
            this.s = false;
            l.L(this.f62860e, R.string.mv_local_video_compress_failed);
            VideoConvertUtil videoConvertUtil = this.p;
            if (videoConvertUtil != null && videoConvertUtil.r()) {
                d();
            }
            n(105);
        }
        return true;
    }

    public boolean i() {
        return this.s;
    }

    public void j() {
        VideoConvertUtil videoConvertUtil = this.p;
        if (videoConvertUtil != null) {
            videoConvertUtil.o();
        }
        Handler handler = this.q;
        if (handler != null) {
            handler.removeMessages(5);
        }
        d.a.n0.u1.g gVar = this.r;
        if (gVar != null) {
            gVar.k("album");
        }
        MessageManager.getInstance().unRegisterListener(this.B);
    }

    public void k() {
        if (this.m && !TextUtils.isEmpty(this.k) && new File(this.k).exists()) {
            f(true);
            n(101);
        }
        d.a.n0.u1.g gVar = this.r;
        if (gVar != null) {
            gVar.e("album");
        }
    }

    public void l() {
        this.l = false;
    }

    public void m() {
        this.l = true;
    }

    public final void n(int i2) {
        d.a.n0.u1.g gVar = this.r;
        if (gVar != null) {
            gVar.i(i2, "album");
        }
    }

    public void o(AntiData antiData, PostPrefixData postPrefixData, String str, String str2) {
        this.w = antiData;
        this.v = postPrefixData;
        this.x = str;
        this.y = str2;
    }

    @Override // d.a.n0.r3.d
    public void onConvertAborted() {
        this.q.sendEmptyMessage(4);
    }

    @Override // d.a.n0.r3.d
    public void onConvertFailed() {
        this.q.sendEmptyMessage(2);
    }

    @Override // d.a.n0.r3.d
    public void onConvertProgress(int i2) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.arg1 = i2;
        this.q.sendMessage(obtain);
    }

    @Override // d.a.n0.r3.d
    public void onConvertSuccess() {
        this.q.sendEmptyMessage(3);
    }

    public void p(FrsTabInfoData frsTabInfoData) {
        this.t = frsTabInfoData;
    }

    public void q(int i2) {
        this.z = i2;
    }

    public void r(int i2) {
        this.A = i2;
    }

    public final void s() {
        RelativeLayout relativeLayout = (RelativeLayout) this.f62860e.findViewById(R.id.parent);
        if (relativeLayout != null) {
            if (this.o == null) {
                this.o = new AlbumVideoCompressingDialogView(this.f62860e);
            }
            if (this.o.getParent() != null) {
                return;
            }
            relativeLayout.addView(this.o);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.addRule(13);
            this.o.setLayoutParams(layoutParams);
        }
        this.o.setPercent(0);
        this.s = true;
    }

    public final void t() {
        d.a.m0.r.s.a positiveButton = new d.a.m0.r.s.a(this.f62860e).setTitle(R.string.mv_local_video_too_long).setPositiveButton(R.string.group_create_private_isee, new a(this));
        positiveButton.create(this.f62860e.getPageContext());
        positiveButton.setCanceledOnTouchOutside(false);
        positiveButton.show();
    }
}
