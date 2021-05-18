package d.a.f.a.a;

import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.FieldBuilder;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.voice.service.MediaService;
import com.baidu.tieba.R;
import d.a.c.e.q.g;
import d.a.c.e.q.h;
/* loaded from: classes.dex */
public class e implements d.a.k0.d3.p0.a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.e.q.f f39939a;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f39944f;

    /* renamed from: c  reason: collision with root package name */
    public String f39941c = null;

    /* renamed from: d  reason: collision with root package name */
    public g f39942d = null;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f39943e = new c();

    /* renamed from: b  reason: collision with root package name */
    public Handler f39940b = new Handler();

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f39945e;

        public a(e eVar, String str) {
            this.f39945e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.j0.r.g0.a.a(d.a.j0.r.g0.a.b(this.f39945e));
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f39946e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f39947f;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                eVar.f39939a.onShowErr(4, eVar.f39944f.getString(R.string.voice_error_file_md5));
                h.f39246a = 1;
            }
        }

        /* renamed from: d.a.f.a.a.e$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0535b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f39950e;

            public RunnableC0535b(String str) {
                this.f39950e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                h.f39246a = 1;
                b bVar = b.this;
                e.this.f39939a.onSendVoice(this.f39950e, bVar.f39947f);
            }
        }

        public b(String str, int i2) {
            this.f39946e = str;
            this.f39947f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = d.a.j0.r.g0.b.b.c(d.a.j0.r.g0.a.d(this.f39946e)).f49776a;
            if (e.this.f39940b != null) {
                e.this.f39940b.removeCallbacks(e.this.f39943e);
                if (StringUtils.isNull(str)) {
                    e.this.f39940b.post(new a());
                } else {
                    e.this.f39940b.post(new RunnableC0535b(str));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.c.e.q.f fVar = e.this.f39939a;
            if (fVar == null || h.f39246a != 2) {
                return;
            }
            fVar.onStopingRecorder();
        }
    }

    /* loaded from: classes.dex */
    public class d implements g {
        public d() {
        }

        @Override // d.a.c.e.q.g
        public void a(int i2) {
            d.a.c.e.q.f fVar = e.this.f39939a;
            if (fVar == null) {
                return;
            }
            fVar.onShowRecordTime(i2 / 1000);
        }

        @Override // d.a.c.e.q.e
        public void b(int i2) {
            d.a.c.e.q.f fVar = e.this.f39939a;
            if (fVar == null) {
                return;
            }
            fVar.onShowRecording(i2);
        }

        @Override // d.a.c.e.q.e
        public void c(String str, int i2) {
            e.this.o();
            h.f39246a = 1;
            if (e.this.f39941c != null && str != null) {
                e eVar = e.this;
                d.a.c.e.q.f fVar = eVar.f39939a;
                if (fVar == null) {
                    return;
                }
                if (i2 > 1000) {
                    if (!str.endsWith(eVar.f39941c)) {
                        FieldBuilder fieldBuilder = new FieldBuilder();
                        fieldBuilder.append("file", str);
                        fieldBuilder.append("dur", Integer.valueOf(i2));
                        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", fieldBuilder.toString());
                        return;
                    }
                    e eVar2 = e.this;
                    eVar2.m(eVar2.f39941c, (int) Math.round((i2 * 1.0d) / 1000.0d));
                    e.this.f39941c = null;
                    return;
                }
                fVar.onShowErr(2, h.a(R.string.voice_record_short_tip));
                FieldBuilder fieldBuilder2 = new FieldBuilder();
                fieldBuilder2.append("file", str);
                fieldBuilder2.append("dur", Integer.valueOf(i2));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_LEN, "voice too short", fieldBuilder2.toString());
                return;
            }
            FieldBuilder fieldBuilder3 = new FieldBuilder();
            fieldBuilder3.append("file", str);
            fieldBuilder3.append("dur", Integer.valueOf(i2));
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILE, "RecoreCallback.succ: file is null", fieldBuilder3.toString());
        }

        @Override // d.a.c.e.q.g
        public void e() {
            h.f39246a = 1;
        }

        @Override // d.a.c.e.q.e
        public void error(int i2, String str) {
            e.this.o();
            TiebaStatic.voiceError(i2, "RecoreCallback.error: " + str, "");
            e eVar = e.this;
            if (eVar.f39939a == null) {
                h.f39246a = 1;
            } else if (i2 == 7) {
                if (eVar.f39941c == null) {
                    TiebaStatic.voiceError(i2, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
                    return;
                }
                e eVar2 = e.this;
                eVar2.m(eVar2.f39941c, d.a.c.e.q.d.f39245a / 1000);
                e.this.f39941c = null;
                e eVar3 = e.this;
                eVar3.f39939a.onShowErr(3, eVar3.f39944f.getString(R.string.voice_record_timeout_tip));
            } else {
                h.f39246a = 1;
                if (i2 == 8) {
                    i2 = 2;
                }
                e.this.f39939a.onShowErr(i2, str);
                TiebaStatic.voiceError(i2, "RecoreCallback.err: " + str, "");
            }
        }

        public /* synthetic */ d(e eVar, a aVar) {
            this();
        }
    }

    static {
        h.f39246a = 1;
    }

    public static e n() {
        return new e();
    }

    @Override // d.a.k0.d3.p0.a
    public void a(String str) {
        stopRecord();
        q(false);
        d.a.c.e.q.f fVar = this.f39939a;
        if (fVar != null) {
            fVar.onDeletedVoice(str);
        }
        Handler handler = this.f39940b;
        if (handler == null) {
            return;
        }
        handler.postDelayed(new a(this, str), 200L);
    }

    @Override // d.a.k0.d3.p0.a
    public boolean b(d.a.c.e.q.f fVar, int i2) {
        TbPageContext<?> tbPageContext;
        if (fVar == null || (tbPageContext = this.f39944f) == null || !PermissionUtil.checkWriteExternalStorage(tbPageContext.getPageActivity())) {
            return false;
        }
        this.f39939a = fVar;
        if (!FileHelper.checkSD()) {
            String sdErrorString = FileHelper.getSdErrorString();
            if (sdErrorString == null) {
                sdErrorString = h.a(R.string.voice_error_sdcard);
            }
            this.f39939a.onShowErr(0, sdErrorString);
            return false;
        }
        q(true);
        String e2 = d.a.j0.r.g0.a.e();
        this.f39941c = e2;
        String c2 = d.a.j0.r.g0.a.c(e2);
        if (this.f39942d == null) {
            this.f39942d = new d(this, null);
        }
        d.a.f.a.a.a.g();
        o();
        boolean f2 = d.a.f.a.a.a.f(c2, i2, this.f39942d);
        if (f2) {
            this.f39939a.onStartedRecorder(true);
            h.f39246a = 2;
        } else {
            h.f39246a = 1;
            d.a.f.a.a.a.g();
            FieldBuilder fieldBuilder = new FieldBuilder();
            fieldBuilder.append("voiceType", Integer.valueOf(i2));
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", fieldBuilder.toString());
            this.f39939a.onStartedRecorder(false);
        }
        return f2;
    }

    @Override // d.a.k0.d3.p0.a
    public void c(TbPageContext<?> tbPageContext) {
        this.f39944f = tbPageContext;
    }

    @Override // d.a.k0.d3.p0.a
    public void d() {
        d.a.f.a.a.a.e();
    }

    @Override // d.a.k0.d3.p0.a
    public void e(d.a.c.e.q.f fVar) {
        this.f39939a = fVar;
    }

    @Override // d.a.k0.d3.p0.a
    public boolean f() {
        return h.f39246a == 1;
    }

    public final void m(String str, int i2) {
        if (str == null || i2 < 1) {
            return;
        }
        h.f39246a = 3;
        new Thread(new b(str, i2)).start();
    }

    public final void o() {
        p();
    }

    public final void p() {
    }

    public void q(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001273, Boolean.valueOf(z)));
    }

    @Override // d.a.k0.d3.p0.a
    public void release() {
        stopRecord();
        TbPageContext<?> tbPageContext = this.f39944f;
        if (tbPageContext != null && tbPageContext.getPageActivity() != null) {
            MediaService.stopMy(this.f39944f.getPageActivity());
        }
        Handler handler = this.f39940b;
        if (handler != null) {
            handler.removeCallbacks(this.f39943e);
        }
        this.f39944f = null;
        this.f39939a = null;
        this.f39940b = null;
    }

    @Override // d.a.k0.d3.p0.a
    public void stopRecord() {
        d.a.f.a.a.a.g();
        Handler handler = this.f39940b;
        if (handler != null) {
            handler.postDelayed(this.f39943e, 100L);
        }
        o();
    }
}
