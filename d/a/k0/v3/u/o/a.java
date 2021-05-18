package d.a.k0.v3.u.o;

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
import d.a.c.e.p.k;
import java.io.File;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62981a;

    /* renamed from: b  reason: collision with root package name */
    public PreviewVideoView f62982b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f62983c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f62984d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f62985e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f62986f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.k0.q3.b f62987g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.k0.b0.b f62988h;

    /* renamed from: i  reason: collision with root package name */
    public VideoInfo f62989i;
    public EditVideoData j;
    public int k = 0;
    public View.OnClickListener l = new View$OnClickListenerC1710a();

    /* renamed from: d.a.k0.v3.u.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1710a implements View.OnClickListener {
        public View$OnClickListenerC1710a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.f62986f) {
                if (view == a.this.f62982b.f22234g) {
                    if (a.this.f62981a.getPageActivity() instanceof WriteActivity) {
                        a.this.o();
                        ((WriteActivity) a.this.f62981a.getPageActivity()).showPicOrVideo(true, false);
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
    public class b extends d.a.k0.q3.b {

        /* renamed from: d.a.k0.v3.u.o.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1711a implements Runnable {
            public RunnableC1711a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.x(1, 50);
            }
        }

        /* renamed from: d.a.k0.v3.u.o.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1712b implements Runnable {
            public RunnableC1712b() {
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
                if (a.this.f62981a == null || !(a.this.f62981a.getPageActivity() instanceof WriteActivity)) {
                    return;
                }
                ((WriteActivity) a.this.f62981a.getPageActivity()).refreshPostButton();
            }
        }

        public b(BaseActivity baseActivity, EditVideoData editVideoData) {
            super(baseActivity, editVideoData);
        }

        @Override // d.a.k0.q3.b
        public void c() {
            super.c();
        }

        @Override // d.a.k0.q3.b
        public void d(int i2, String str) {
            super.d(i2, str);
            a.this.f62981a.getPageActivity().runOnUiThread(new d());
        }

        @Override // d.a.k0.q3.b
        public void e() {
            a.this.f62981a.getPageActivity().runOnUiThread(new c());
        }

        @Override // d.a.k0.q3.b
        public void f(VideoInfo videoInfo) {
            super.f(videoInfo);
            String videoPath = videoInfo.getVideoPath();
            if (!k.isEmpty(videoPath) && videoPath.contains(d.a.k0.q3.c.f59854c)) {
                File file = new File(videoPath);
                videoPath = d.a.k0.q3.c.f59855d + file.getName();
                FileHelper.copyFile(file.getAbsolutePath(), videoPath);
            }
            try {
                a.this.w(a.this.f62981a.getPageActivity(), videoPath);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            a.this.j.finalPath = videoPath;
            a.this.f62989i.setVideoPath(videoPath);
            a.this.f62989i.setThumbPath(this.f59846c);
            a.this.f62982b.j(videoPath);
            a.this.f62981a.getPageActivity().runOnUiThread(new e());
        }

        @Override // d.a.k0.q3.b
        public void g(int i2, String str) {
            super.g(i2, str);
            a.this.f62981a.getPageActivity().runOnUiThread(new RunnableC1712b());
        }

        @Override // d.a.k0.q3.b
        public void h() {
            a.this.f62981a.getPageActivity().runOnUiThread(new RunnableC1711a());
        }
    }

    public a(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.f62981a = tbPageContext;
        PreviewVideoView previewVideoView = (PreviewVideoView) view.findViewById(R.id.write_video_preview);
        this.f62982b = previewVideoView;
        previewVideoView.setOnClickListener(this.l);
        this.f62983c = (LinearLayout) view.findViewById(R.id.write_video_mix_state_layout);
        this.f62984d = (TextView) view.findViewById(R.id.write_video_state_text);
        this.f62985e = (TextView) view.findViewById(R.id.write_video_percent);
        TextView textView = (TextView) view.findViewById(R.id.write_video_retry);
        this.f62986f = textView;
        textView.setOnClickListener(this.l);
        k();
    }

    public void k() {
        this.f62982b.d();
        SkinManager.setViewTextColor(this.f62984d, this.k == 3 ? R.color.CAM_X0301 : R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f62985e, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f62986f, R.color.CAM_X0302);
    }

    public final void l() {
        WriteActivity writeActivity;
        WriteData writeData;
        TbPageContext tbPageContext = this.f62981a;
        if (tbPageContext == null || !(tbPageContext.getPageActivity() instanceof WriteActivity) || (writeData = (writeActivity = (WriteActivity) this.f62981a.getPageActivity()).getWriteData()) == null) {
            return;
        }
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.copy(this.f62989i);
        videoInfo.setVideoPath(this.j.originPath);
        videoInfo.getEditVideoData().finalPath = null;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.f62981a.getPageActivity(), writeActivity.getCallFrom(), writeData.getForumName(), writeData.getForumId(), "", videoInfo);
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
        d.a.k0.q3.b bVar = this.f62987g;
        if (bVar == null) {
            this.f62987g = new b((WriteActivity) this.f62981a.getPageActivity(), this.j);
        } else {
            bVar.j(this.j);
        }
        this.f62987g.i(false);
    }

    public boolean n() {
        PreviewVideoView previewVideoView = this.f62982b;
        return previewVideoView != null && previewVideoView.getVisibility() == 0;
    }

    public void o() {
        d.a.k0.q3.b bVar = this.f62987g;
        if (bVar != null) {
            bVar.i(true);
        }
        d.a.k0.b0.b bVar2 = this.f62988h;
        if (bVar2 != null) {
            bVar2.cancel();
        }
    }

    public void p() {
        this.f62982b.k();
    }

    public void q() {
        EditVideoData editVideoData = this.j;
        if (editVideoData == null || !editVideoData.isLegal()) {
            return;
        }
        this.f62982b.j(this.j.finalPath);
    }

    public void r() {
        this.f62982b.h();
    }

    public void s() {
        this.f62982b.e();
    }

    public void t(VideoInfo videoInfo, boolean z) {
        if (videoInfo == null) {
            this.j = null;
        } else {
            this.j = videoInfo.getEditVideoData();
        }
        this.f62989i = videoInfo;
        EditVideoData editVideoData = this.j;
        if (editVideoData != null && editVideoData.isLegal()) {
            this.f62983c.setVisibility(0);
            this.f62982b.setVisibility(0);
            this.f62982b.setVideoInfo(this.j);
            if (z) {
                this.f62982b.l(1.0f);
                return;
            }
            return;
        }
        this.f62983c.setVisibility(8);
        this.f62982b.setVisibility(8);
        this.f62982b.i();
        d.a.k0.q3.b bVar = this.f62987g;
        if (bVar != null) {
            bVar.i(true);
        }
        d.a.k0.b0.b bVar2 = this.f62988h;
        if (bVar2 != null) {
            bVar2.cancel();
        }
    }

    public final void u() {
        TbPageContext tbPageContext = this.f62981a;
        if (tbPageContext == null || !(tbPageContext.getPageActivity() instanceof WriteActivity)) {
            return;
        }
        ((WriteActivity) this.f62981a.getPageActivity()).showTip(this.f62981a.getString(R.string.write_video_mix_fail));
    }

    public void v() {
        if (this.j == null) {
            return;
        }
        m();
        x(1, 10);
        d.a.k0.b0.b bVar = (d.a.k0.b0.b) MessageManager.getInstance().runTask(2921466, d.a.k0.b0.b.class, this.f62987g).getData();
        this.f62988h = bVar;
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

    public final void x(int i2, int i3) {
        this.f62985e.setText(String.format(this.f62981a.getString(R.string.video_mix_percent), Integer.valueOf(i3)));
        if (i2 != this.k) {
            this.k = i2;
            SkinManager.setViewTextColor(this.f62984d, i2 == 3 ? R.color.CAM_X0301 : R.color.CAM_X0107);
            if (i2 == 1) {
                this.f62984d.setText(this.f62981a.getString(R.string.video_mixing));
                this.f62985e.setVisibility(0);
                this.f62986f.setVisibility(8);
            } else if (i2 == 3) {
                this.f62984d.setText(this.f62981a.getString(R.string.video_mix_failed));
                this.f62985e.setVisibility(8);
                this.f62986f.setVisibility(0);
            } else {
                this.f62984d.setText(this.f62981a.getString(R.string.video_mix_success));
                this.f62985e.setVisibility(8);
                this.f62986f.setVisibility(8);
            }
        }
        this.f62982b.l(i3 / 100.0f);
    }
}
