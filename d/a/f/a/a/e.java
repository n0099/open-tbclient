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
public class e implements d.a.j0.d3.p0.a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.e.q.f f40694a;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f40699f;

    /* renamed from: c  reason: collision with root package name */
    public String f40696c = null;

    /* renamed from: d  reason: collision with root package name */
    public g f40697d = null;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f40698e = new c();

    /* renamed from: b  reason: collision with root package name */
    public Handler f40695b = new Handler();

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f40700e;

        public a(e eVar, String str) {
            this.f40700e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.i0.r.g0.a.a(d.a.i0.r.g0.a.b(this.f40700e));
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f40701e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f40702f;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                eVar.f40694a.onShowErr(4, eVar.f40699f.getString(R.string.voice_error_file_md5));
                h.f40001a = 1;
            }
        }

        /* renamed from: d.a.f.a.a.e$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0548b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f40705e;

            public RunnableC0548b(String str) {
                this.f40705e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                h.f40001a = 1;
                b bVar = b.this;
                e.this.f40694a.onSendVoice(this.f40705e, bVar.f40702f);
            }
        }

        public b(String str, int i2) {
            this.f40701e = str;
            this.f40702f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = d.a.i0.r.g0.b.b.c(d.a.i0.r.g0.a.d(this.f40701e)).f48946a;
            if (e.this.f40695b != null) {
                e.this.f40695b.removeCallbacks(e.this.f40698e);
                if (StringUtils.isNull(str)) {
                    e.this.f40695b.post(new a());
                } else {
                    e.this.f40695b.post(new RunnableC0548b(str));
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
            d.a.c.e.q.f fVar = e.this.f40694a;
            if (fVar == null || h.f40001a != 2) {
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
            d.a.c.e.q.f fVar = e.this.f40694a;
            if (fVar == null) {
                return;
            }
            fVar.onShowRecordTime(i2 / 1000);
        }

        @Override // d.a.c.e.q.e
        public void b(int i2) {
            d.a.c.e.q.f fVar = e.this.f40694a;
            if (fVar == null) {
                return;
            }
            fVar.onShowRecording(i2);
        }

        @Override // d.a.c.e.q.e
        public void c(String str, int i2) {
            e.this.o();
            h.f40001a = 1;
            if (e.this.f40696c != null && str != null) {
                e eVar = e.this;
                d.a.c.e.q.f fVar = eVar.f40694a;
                if (fVar == null) {
                    return;
                }
                if (i2 > 1000) {
                    if (!str.endsWith(eVar.f40696c)) {
                        FieldBuilder fieldBuilder = new FieldBuilder();
                        fieldBuilder.append("file", str);
                        fieldBuilder.append("dur", Integer.valueOf(i2));
                        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", fieldBuilder.toString());
                        return;
                    }
                    e eVar2 = e.this;
                    eVar2.m(eVar2.f40696c, (int) Math.round((i2 * 1.0d) / 1000.0d));
                    e.this.f40696c = null;
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
            h.f40001a = 1;
        }

        @Override // d.a.c.e.q.e
        public void error(int i2, String str) {
            e.this.o();
            TiebaStatic.voiceError(i2, "RecoreCallback.error: " + str, "");
            e eVar = e.this;
            if (eVar.f40694a == null) {
                h.f40001a = 1;
            } else if (i2 == 7) {
                if (eVar.f40696c == null) {
                    TiebaStatic.voiceError(i2, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
                    return;
                }
                e eVar2 = e.this;
                eVar2.m(eVar2.f40696c, d.a.c.e.q.d.f40000a / 1000);
                e.this.f40696c = null;
                e eVar3 = e.this;
                eVar3.f40694a.onShowErr(3, eVar3.f40699f.getString(R.string.voice_record_timeout_tip));
            } else {
                h.f40001a = 1;
                if (i2 == 8) {
                    i2 = 2;
                }
                e.this.f40694a.onShowErr(i2, str);
                TiebaStatic.voiceError(i2, "RecoreCallback.err: " + str, "");
            }
        }

        public /* synthetic */ d(e eVar, a aVar) {
            this();
        }
    }

    static {
        h.f40001a = 1;
    }

    public static e n() {
        return new e();
    }

    @Override // d.a.j0.d3.p0.a
    public void a(String str) {
        stopRecord();
        q(false);
        d.a.c.e.q.f fVar = this.f40694a;
        if (fVar != null) {
            fVar.onDeletedVoice(str);
        }
        Handler handler = this.f40695b;
        if (handler == null) {
            return;
        }
        handler.postDelayed(new a(this, str), 200L);
    }

    @Override // d.a.j0.d3.p0.a
    public boolean b(d.a.c.e.q.f fVar, int i2) {
        TbPageContext<?> tbPageContext;
        if (fVar == null || (tbPageContext = this.f40699f) == null || !PermissionUtil.checkWriteExternalStorage(tbPageContext.getPageActivity())) {
            return false;
        }
        this.f40694a = fVar;
        if (!FileHelper.checkSD()) {
            String sdErrorString = FileHelper.getSdErrorString();
            if (sdErrorString == null) {
                sdErrorString = h.a(R.string.voice_error_sdcard);
            }
            this.f40694a.onShowErr(0, sdErrorString);
            return false;
        }
        q(true);
        String e2 = d.a.i0.r.g0.a.e();
        this.f40696c = e2;
        String c2 = d.a.i0.r.g0.a.c(e2);
        if (this.f40697d == null) {
            this.f40697d = new d(this, null);
        }
        d.a.f.a.a.a.g();
        o();
        boolean f2 = d.a.f.a.a.a.f(c2, i2, this.f40697d);
        if (f2) {
            this.f40694a.onStartedRecorder(true);
            h.f40001a = 2;
        } else {
            h.f40001a = 1;
            d.a.f.a.a.a.g();
            FieldBuilder fieldBuilder = new FieldBuilder();
            fieldBuilder.append("voiceType", Integer.valueOf(i2));
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", fieldBuilder.toString());
            this.f40694a.onStartedRecorder(false);
        }
        return f2;
    }

    @Override // d.a.j0.d3.p0.a
    public void c(TbPageContext<?> tbPageContext) {
        this.f40699f = tbPageContext;
    }

    @Override // d.a.j0.d3.p0.a
    public void d() {
        d.a.f.a.a.a.e();
    }

    @Override // d.a.j0.d3.p0.a
    public void e(d.a.c.e.q.f fVar) {
        this.f40694a = fVar;
    }

    @Override // d.a.j0.d3.p0.a
    public boolean f() {
        return h.f40001a == 1;
    }

    public final void m(String str, int i2) {
        if (str == null || i2 < 1) {
            return;
        }
        h.f40001a = 3;
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

    @Override // d.a.j0.d3.p0.a
    public void release() {
        stopRecord();
        TbPageContext<?> tbPageContext = this.f40699f;
        if (tbPageContext != null && tbPageContext.getPageActivity() != null) {
            MediaService.stopMy(this.f40699f.getPageActivity());
        }
        Handler handler = this.f40695b;
        if (handler != null) {
            handler.removeCallbacks(this.f40698e);
        }
        this.f40699f = null;
        this.f40694a = null;
        this.f40695b = null;
    }

    @Override // d.a.j0.d3.p0.a
    public void stopRecord() {
        d.a.f.a.a.a.g();
        Handler handler = this.f40695b;
        if (handler != null) {
            handler.postDelayed(this.f40698e, 100L);
        }
        o();
    }
}
