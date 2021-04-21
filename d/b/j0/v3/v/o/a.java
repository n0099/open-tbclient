package d.b.j0.v3.v.o;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.MediaScannerClient;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.R;
import com.baidu.tieba.video.EditVideoData;
import com.baidu.tieba.write.write.WriteActivity;
import com.baidu.tieba.write.write.video.PreviewVideoView;
import com.google.protobuf.CodedInputStream;
import d.b.c.e.p.k;
import java.io.File;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f64010a;

    /* renamed from: b  reason: collision with root package name */
    public PreviewVideoView f64011b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f64012c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f64013d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f64014e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f64015f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.j0.q3.b f64016g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.j0.b0.b f64017h;
    public VideoInfo i;
    public EditVideoData j;
    public int k = 0;
    public View.OnClickListener l = new View$OnClickListenerC1708a();

    /* renamed from: d.b.j0.v3.v.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1708a implements View.OnClickListener {
        public View$OnClickListenerC1708a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.f64015f) {
                if (view == a.this.f64011b.f22298g) {
                    if (a.this.f64010a.getPageActivity() instanceof WriteActivity) {
                        a.this.o();
                        ((WriteActivity) a.this.f64010a.getPageActivity()).showPicOrVideo(true, false);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001373));
                        return;
                    }
                    return;
                } else if (a.this.k != 1) {
                    a.this.l();
                    return;
                } else {
                    return;
                }
            }
            a.this.v();
        }
    }

    /* loaded from: classes5.dex */
    public class b extends d.b.j0.q3.b {

        /* renamed from: d.b.j0.v3.v.o.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1709a implements Runnable {
            public RunnableC1709a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.x(1, 50);
            }
        }

        /* renamed from: d.b.j0.v3.v.o.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1710b implements Runnable {
            public RunnableC1710b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.x(3, 0);
                a.this.u();
            }
        }

        /* loaded from: classes5.dex */
        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.x(1, 100);
            }
        }

        /* loaded from: classes5.dex */
        public class d implements Runnable {
            public d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.x(3, 0);
                a.this.u();
            }
        }

        /* loaded from: classes5.dex */
        public class e implements Runnable {
            public e() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.x(2, 100);
                if (a.this.f64010a == null || !(a.this.f64010a.getPageActivity() instanceof WriteActivity)) {
                    return;
                }
                ((WriteActivity) a.this.f64010a.getPageActivity()).refreshPostButton();
            }
        }

        public b(BaseActivity baseActivity, EditVideoData editVideoData) {
            super(baseActivity, editVideoData);
        }

        @Override // d.b.j0.q3.b
        public void c() {
            super.c();
        }

        @Override // d.b.j0.q3.b
        public void d(int i, String str) {
            super.d(i, str);
            a.this.f64010a.getPageActivity().runOnUiThread(new d());
        }

        @Override // d.b.j0.q3.b
        public void e() {
            a.this.f64010a.getPageActivity().runOnUiThread(new c());
        }

        @Override // d.b.j0.q3.b
        public void f(VideoInfo videoInfo) {
            super.f(videoInfo);
            String videoPath = videoInfo.getVideoPath();
            if (!k.isEmpty(videoPath) && videoPath.contains(d.b.j0.q3.c.f60979c)) {
                File file = new File(videoPath);
                videoPath = d.b.j0.q3.c.f60980d + file.getName();
                FileHelper.copyFile(file.getAbsolutePath(), videoPath);
            }
            try {
                a.this.w(a.this.f64010a.getPageActivity(), videoPath);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            a.this.j.finalPath = videoPath;
            a.this.i.setVideoPath(videoPath);
            a.this.i.setThumbPath(this.f60971c);
            a.this.f64011b.j(videoPath);
            a.this.f64010a.getPageActivity().runOnUiThread(new e());
        }

        @Override // d.b.j0.q3.b
        public void g(int i, String str) {
            super.g(i, str);
            a.this.f64010a.getPageActivity().runOnUiThread(new RunnableC1710b());
        }

        @Override // d.b.j0.q3.b
        public void h() {
            a.this.f64010a.getPageActivity().runOnUiThread(new RunnableC1709a());
        }
    }

    public a(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.f64010a = tbPageContext;
        PreviewVideoView previewVideoView = (PreviewVideoView) view.findViewById(R.id.write_video_preview);
        this.f64011b = previewVideoView;
        previewVideoView.setOnClickListener(this.l);
        this.f64012c = (LinearLayout) view.findViewById(R.id.write_video_mix_state_layout);
        this.f64013d = (TextView) view.findViewById(R.id.write_video_state_text);
        this.f64014e = (TextView) view.findViewById(R.id.write_video_percent);
        TextView textView = (TextView) view.findViewById(R.id.write_video_retry);
        this.f64015f = textView;
        textView.setOnClickListener(this.l);
        k();
    }

    public void k() {
        this.f64011b.d();
        SkinManager.setViewTextColor(this.f64013d, this.k == 3 ? R.color.CAM_X0301 : R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f64014e, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f64015f, R.color.CAM_X0302);
    }

    public final void l() {
        WriteActivity writeActivity;
        WriteData writeData;
        TbPageContext tbPageContext = this.f64010a;
        if (tbPageContext == null || !(tbPageContext.getPageActivity() instanceof WriteActivity) || (writeData = (writeActivity = (WriteActivity) this.f64010a.getPageActivity()).getWriteData()) == null) {
            return;
        }
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.copy(this.i);
        videoInfo.setVideoPath(this.j.originPath);
        videoInfo.getEditVideoData().finalPath = null;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.f64010a.getPageActivity(), writeActivity.getCallFrom(), writeData.getForumName(), writeData.getForumId(), "", videoInfo);
        editVideoActivityConfig.setProZone(writeData.getProZone());
        editVideoActivityConfig.setStatisticFrom(writeData.getStatisticFrom());
        editVideoActivityConfig.setFrsTabInfo(writeActivity.getFrsTabInfoData());
        editVideoActivityConfig.setFrom(writeActivity.getFrom());
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT);
        AntiData antiData = new AntiData();
        antiData.voice_message = writeActivity.mDisableAudioMessage;
        antiData.setIfVoice(writeActivity.isVoiceEnable);
        editVideoActivityConfig.setExtraData(antiData, writeActivity.mPrefixData, writeData.getFirstDir(), writeData.getSecondDir());
        editVideoActivityConfig.getIntent().setFlags(536870912);
        editVideoActivityConfig.getIntent().setFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
    }

    public final void m() {
        d.b.j0.q3.b bVar = this.f64016g;
        if (bVar == null) {
            this.f64016g = new b((WriteActivity) this.f64010a.getPageActivity(), this.j);
        } else {
            bVar.j(this.j);
        }
        this.f64016g.i(false);
    }

    public boolean n() {
        PreviewVideoView previewVideoView = this.f64011b;
        return previewVideoView != null && previewVideoView.getVisibility() == 0;
    }

    public void o() {
        d.b.j0.q3.b bVar = this.f64016g;
        if (bVar != null) {
            bVar.i(true);
        }
        d.b.j0.b0.b bVar2 = this.f64017h;
        if (bVar2 != null) {
            bVar2.cancel();
        }
    }

    public void p() {
        this.f64011b.k();
    }

    public void q() {
        EditVideoData editVideoData = this.j;
        if (editVideoData == null || !editVideoData.isLegal()) {
            return;
        }
        this.f64011b.j(this.j.finalPath);
    }

    public void r() {
        this.f64011b.h();
    }

    public void s() {
        this.f64011b.e();
    }

    public void t(VideoInfo videoInfo, boolean z) {
        if (videoInfo == null) {
            this.j = null;
        } else {
            this.j = videoInfo.getEditVideoData();
        }
        this.i = videoInfo;
        EditVideoData editVideoData = this.j;
        if (editVideoData != null && editVideoData.isLegal()) {
            this.f64012c.setVisibility(0);
            this.f64011b.setVisibility(0);
            this.f64011b.setVideoInfo(this.j);
            if (z) {
                this.f64011b.l(1.0f);
                return;
            }
            return;
        }
        this.f64012c.setVisibility(8);
        this.f64011b.setVisibility(8);
        this.f64011b.i();
        d.b.j0.q3.b bVar = this.f64016g;
        if (bVar != null) {
            bVar.i(true);
        }
        d.b.j0.b0.b bVar2 = this.f64017h;
        if (bVar2 != null) {
            bVar2.cancel();
        }
    }

    public final void u() {
        TbPageContext tbPageContext = this.f64010a;
        if (tbPageContext == null || !(tbPageContext.getPageActivity() instanceof WriteActivity)) {
            return;
        }
        ((WriteActivity) this.f64010a.getPageActivity()).showTip(this.f64010a.getString(R.string.write_video_mix_fail));
    }

    public void v() {
        if (this.j == null) {
            return;
        }
        m();
        x(1, 10);
        d.b.j0.b0.b bVar = (d.b.j0.b0.b) MessageManager.getInstance().runTask(2921466, d.b.j0.b0.b.class, this.f64016g).getData();
        this.f64017h = bVar;
        if (bVar != null) {
            bVar.start();
        } else {
            x(3, 0);
        }
    }

    public final void w(Context context, String str) {
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                new MediaScannerClient(context).saveVideo(str);
                Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                intent.setData(Uri.fromFile(new File(str)));
                context.sendBroadcast(intent);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public final void x(int i, int i2) {
        this.f64014e.setText(String.format(this.f64010a.getString(R.string.video_mix_percent), Integer.valueOf(i2)));
        if (i != this.k) {
            this.k = i;
            SkinManager.setViewTextColor(this.f64013d, i == 3 ? R.color.CAM_X0301 : R.color.CAM_X0107);
            if (i == 1) {
                this.f64013d.setText(this.f64010a.getString(R.string.video_mixing));
                this.f64014e.setVisibility(0);
                this.f64015f.setVisibility(8);
            } else if (i == 3) {
                this.f64013d.setText(this.f64010a.getString(R.string.video_mix_failed));
                this.f64014e.setVisibility(8);
                this.f64015f.setVisibility(0);
            } else {
                this.f64013d.setText(this.f64010a.getString(R.string.video_mix_success));
                this.f64014e.setVisibility(8);
                this.f64015f.setVisibility(8);
            }
        }
        this.f64011b.l(i2 / 100.0f);
    }
}
