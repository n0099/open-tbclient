package d.b.f.a.a;

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
import d.b.c.e.q.g;
import d.b.c.e.q.h;
/* loaded from: classes.dex */
public class e implements d.b.i0.d3.p0.a {

    /* renamed from: a  reason: collision with root package name */
    public d.b.c.e.q.f f43185a;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f43190f;

    /* renamed from: c  reason: collision with root package name */
    public String f43187c = null;

    /* renamed from: d  reason: collision with root package name */
    public g f43188d = null;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f43189e = new c();

    /* renamed from: b  reason: collision with root package name */
    public Handler f43186b = new Handler();

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f43191e;

        public a(e eVar, String str) {
            this.f43191e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.h0.r.g0.a.a(d.b.h0.r.g0.a.b(this.f43191e));
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f43192e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43193f;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                eVar.f43185a.onShowErr(4, eVar.f43190f.getString(R.string.voice_error_file_md5));
                h.f42548a = 1;
            }
        }

        /* renamed from: d.b.f.a.a.e$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0590b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43196e;

            public RunnableC0590b(String str) {
                this.f43196e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                h.f42548a = 1;
                b bVar = b.this;
                e.this.f43185a.onSendVoice(this.f43196e, bVar.f43193f);
            }
        }

        public b(String str, int i) {
            this.f43192e = str;
            this.f43193f = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = d.b.h0.r.g0.b.b.c(d.b.h0.r.g0.a.d(this.f43192e)).f50994a;
            if (e.this.f43186b != null) {
                e.this.f43186b.removeCallbacks(e.this.f43189e);
                if (StringUtils.isNull(str)) {
                    e.this.f43186b.post(new a());
                } else {
                    e.this.f43186b.post(new RunnableC0590b(str));
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
            d.b.c.e.q.f fVar = e.this.f43185a;
            if (fVar == null || h.f42548a != 2) {
                return;
            }
            fVar.onStopingRecorder();
        }
    }

    /* loaded from: classes.dex */
    public class d implements g {
        public d() {
        }

        @Override // d.b.c.e.q.g
        public void a(int i) {
            d.b.c.e.q.f fVar = e.this.f43185a;
            if (fVar == null) {
                return;
            }
            fVar.onShowRecordTime(i / 1000);
        }

        @Override // d.b.c.e.q.e
        public void b(int i) {
            d.b.c.e.q.f fVar = e.this.f43185a;
            if (fVar == null) {
                return;
            }
            fVar.onShowRecording(i);
        }

        @Override // d.b.c.e.q.e
        public void c(String str, int i) {
            e.this.o();
            h.f42548a = 1;
            if (e.this.f43187c != null && str != null) {
                e eVar = e.this;
                d.b.c.e.q.f fVar = eVar.f43185a;
                if (fVar == null) {
                    return;
                }
                if (i > 1000) {
                    if (!str.endsWith(eVar.f43187c)) {
                        FieldBuilder fieldBuilder = new FieldBuilder();
                        fieldBuilder.append("file", str);
                        fieldBuilder.append("dur", Integer.valueOf(i));
                        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", fieldBuilder.toString());
                        return;
                    }
                    e eVar2 = e.this;
                    eVar2.m(eVar2.f43187c, (int) Math.round((i * 1.0d) / 1000.0d));
                    e.this.f43187c = null;
                    return;
                }
                fVar.onShowErr(2, h.a(R.string.voice_record_short_tip));
                FieldBuilder fieldBuilder2 = new FieldBuilder();
                fieldBuilder2.append("file", str);
                fieldBuilder2.append("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_LEN, "voice too short", fieldBuilder2.toString());
                return;
            }
            FieldBuilder fieldBuilder3 = new FieldBuilder();
            fieldBuilder3.append("file", str);
            fieldBuilder3.append("dur", Integer.valueOf(i));
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILE, "RecoreCallback.succ: file is null", fieldBuilder3.toString());
        }

        @Override // d.b.c.e.q.g
        public void e() {
            h.f42548a = 1;
        }

        @Override // d.b.c.e.q.e
        public void error(int i, String str) {
            e.this.o();
            TiebaStatic.voiceError(i, "RecoreCallback.error: " + str, "");
            e eVar = e.this;
            if (eVar.f43185a == null) {
                h.f42548a = 1;
            } else if (i == 7) {
                if (eVar.f43187c == null) {
                    TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
                    return;
                }
                e eVar2 = e.this;
                eVar2.m(eVar2.f43187c, d.b.c.e.q.d.f42547a / 1000);
                e.this.f43187c = null;
                e eVar3 = e.this;
                eVar3.f43185a.onShowErr(3, eVar3.f43190f.getString(R.string.voice_record_timeout_tip));
            } else {
                h.f42548a = 1;
                if (i == 8) {
                    i = 2;
                }
                e.this.f43185a.onShowErr(i, str);
                TiebaStatic.voiceError(i, "RecoreCallback.err: " + str, "");
            }
        }

        public /* synthetic */ d(e eVar, a aVar) {
            this();
        }
    }

    static {
        h.f42548a = 1;
    }

    public static e n() {
        return new e();
    }

    @Override // d.b.i0.d3.p0.a
    public void a(String str) {
        stopRecord();
        q(false);
        d.b.c.e.q.f fVar = this.f43185a;
        if (fVar != null) {
            fVar.onDeletedVoice(str);
        }
        Handler handler = this.f43186b;
        if (handler == null) {
            return;
        }
        handler.postDelayed(new a(this, str), 200L);
    }

    @Override // d.b.i0.d3.p0.a
    public void b(d.b.c.e.q.f fVar) {
        this.f43185a = fVar;
    }

    @Override // d.b.i0.d3.p0.a
    public boolean c(d.b.c.e.q.f fVar, int i) {
        TbPageContext<?> tbPageContext;
        if (fVar == null || (tbPageContext = this.f43190f) == null || !PermissionUtil.checkWriteExternalStorage(tbPageContext.getPageActivity())) {
            return false;
        }
        this.f43185a = fVar;
        if (!FileHelper.checkSD()) {
            String sdErrorString = FileHelper.getSdErrorString();
            if (sdErrorString == null) {
                sdErrorString = h.a(R.string.voice_error_sdcard);
            }
            this.f43185a.onShowErr(0, sdErrorString);
            return false;
        }
        q(true);
        String e2 = d.b.h0.r.g0.a.e();
        this.f43187c = e2;
        String c2 = d.b.h0.r.g0.a.c(e2);
        if (this.f43188d == null) {
            this.f43188d = new d(this, null);
        }
        d.b.f.a.a.a.g();
        o();
        boolean f2 = d.b.f.a.a.a.f(c2, i, this.f43188d);
        if (f2) {
            this.f43185a.onStartedRecorder(true);
            h.f42548a = 2;
        } else {
            h.f42548a = 1;
            d.b.f.a.a.a.g();
            FieldBuilder fieldBuilder = new FieldBuilder();
            fieldBuilder.append("voiceType", Integer.valueOf(i));
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", fieldBuilder.toString());
            this.f43185a.onStartedRecorder(false);
        }
        return f2;
    }

    @Override // d.b.i0.d3.p0.a
    public boolean d() {
        return h.f42548a == 1;
    }

    @Override // d.b.i0.d3.p0.a
    public void e(TbPageContext<?> tbPageContext) {
        this.f43190f = tbPageContext;
    }

    @Override // d.b.i0.d3.p0.a
    public void f() {
        d.b.f.a.a.a.e();
    }

    public final void m(String str, int i) {
        if (str == null || i < 1) {
            return;
        }
        h.f42548a = 3;
        new Thread(new b(str, i)).start();
    }

    public final void o() {
        p();
    }

    public final void p() {
    }

    public void q(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001273, Boolean.valueOf(z)));
    }

    @Override // d.b.i0.d3.p0.a
    public void release() {
        stopRecord();
        TbPageContext<?> tbPageContext = this.f43190f;
        if (tbPageContext != null && tbPageContext.getPageActivity() != null) {
            MediaService.stopMy(this.f43190f.getPageActivity());
        }
        Handler handler = this.f43186b;
        if (handler != null) {
            handler.removeCallbacks(this.f43189e);
        }
        this.f43190f = null;
        this.f43185a = null;
        this.f43186b = null;
    }

    @Override // d.b.i0.d3.p0.a
    public void stopRecord() {
        d.b.f.a.a.a.g();
        Handler handler = this.f43186b;
        if (handler != null) {
            handler.postDelayed(this.f43189e, 100L);
        }
        o();
    }
}
