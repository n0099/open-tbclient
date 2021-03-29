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
import d.b.b.e.q.g;
import d.b.b.e.q.h;
/* loaded from: classes.dex */
public class e implements d.b.i0.c3.p0.a {

    /* renamed from: a  reason: collision with root package name */
    public d.b.b.e.q.f f42793a;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f42798f;

    /* renamed from: c  reason: collision with root package name */
    public String f42795c = null;

    /* renamed from: d  reason: collision with root package name */
    public g f42796d = null;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f42797e = new c();

    /* renamed from: b  reason: collision with root package name */
    public Handler f42794b = new Handler();

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f42799e;

        public a(e eVar, String str) {
            this.f42799e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.h0.r.g0.a.a(d.b.h0.r.g0.a.b(this.f42799e));
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f42800e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f42801f;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                eVar.f42793a.onShowErr(4, eVar.f42798f.getString(R.string.voice_error_file_md5));
                h.f42051a = 1;
            }
        }

        /* renamed from: d.b.f.a.a.e$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0578b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f42804e;

            public RunnableC0578b(String str) {
                this.f42804e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                h.f42051a = 1;
                b bVar = b.this;
                e.this.f42793a.onSendVoice(this.f42804e, bVar.f42801f);
            }
        }

        public b(String str, int i) {
            this.f42800e = str;
            this.f42801f = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = d.b.h0.r.g0.b.b.c(d.b.h0.r.g0.a.d(this.f42800e)).f50587a;
            if (e.this.f42794b != null) {
                e.this.f42794b.removeCallbacks(e.this.f42797e);
                if (StringUtils.isNull(str)) {
                    e.this.f42794b.post(new a());
                } else {
                    e.this.f42794b.post(new RunnableC0578b(str));
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
            d.b.b.e.q.f fVar = e.this.f42793a;
            if (fVar == null || h.f42051a != 2) {
                return;
            }
            fVar.onStopingRecorder();
        }
    }

    /* loaded from: classes.dex */
    public class d implements g {
        public d() {
        }

        @Override // d.b.b.e.q.g
        public void a(int i) {
            d.b.b.e.q.f fVar = e.this.f42793a;
            if (fVar == null) {
                return;
            }
            fVar.onShowRecordTime(i / 1000);
        }

        @Override // d.b.b.e.q.e
        public void b(int i) {
            d.b.b.e.q.f fVar = e.this.f42793a;
            if (fVar == null) {
                return;
            }
            fVar.onShowRecording(i);
        }

        @Override // d.b.b.e.q.e
        public void c(String str, int i) {
            e.this.o();
            h.f42051a = 1;
            if (e.this.f42795c != null && str != null) {
                e eVar = e.this;
                d.b.b.e.q.f fVar = eVar.f42793a;
                if (fVar == null) {
                    return;
                }
                if (i > 1000) {
                    if (!str.endsWith(eVar.f42795c)) {
                        FieldBuilder fieldBuilder = new FieldBuilder();
                        fieldBuilder.append("file", str);
                        fieldBuilder.append("dur", Integer.valueOf(i));
                        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", fieldBuilder.toString());
                        return;
                    }
                    e eVar2 = e.this;
                    eVar2.m(eVar2.f42795c, (int) Math.round((i * 1.0d) / 1000.0d));
                    e.this.f42795c = null;
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

        @Override // d.b.b.e.q.g
        public void e() {
            h.f42051a = 1;
        }

        @Override // d.b.b.e.q.e
        public void error(int i, String str) {
            e.this.o();
            TiebaStatic.voiceError(i, "RecoreCallback.error: " + str, "");
            e eVar = e.this;
            if (eVar.f42793a == null) {
                h.f42051a = 1;
            } else if (i == 7) {
                if (eVar.f42795c == null) {
                    TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
                    return;
                }
                e eVar2 = e.this;
                eVar2.m(eVar2.f42795c, d.b.b.e.q.d.f42050a / 1000);
                e.this.f42795c = null;
                e eVar3 = e.this;
                eVar3.f42793a.onShowErr(3, eVar3.f42798f.getString(R.string.voice_record_timeout_tip));
            } else {
                h.f42051a = 1;
                if (i == 8) {
                    i = 2;
                }
                e.this.f42793a.onShowErr(i, str);
                TiebaStatic.voiceError(i, "RecoreCallback.err: " + str, "");
            }
        }

        public /* synthetic */ d(e eVar, a aVar) {
            this();
        }
    }

    static {
        h.f42051a = 1;
    }

    public static e n() {
        return new e();
    }

    @Override // d.b.i0.c3.p0.a
    public void a(String str) {
        stopRecord();
        q(false);
        d.b.b.e.q.f fVar = this.f42793a;
        if (fVar != null) {
            fVar.onDeletedVoice(str);
        }
        Handler handler = this.f42794b;
        if (handler == null) {
            return;
        }
        handler.postDelayed(new a(this, str), 200L);
    }

    @Override // d.b.i0.c3.p0.a
    public void b(d.b.b.e.q.f fVar) {
        this.f42793a = fVar;
    }

    @Override // d.b.i0.c3.p0.a
    public boolean c(d.b.b.e.q.f fVar, int i) {
        TbPageContext<?> tbPageContext;
        if (fVar == null || (tbPageContext = this.f42798f) == null || !PermissionUtil.checkWriteExternalStorage(tbPageContext.getPageActivity())) {
            return false;
        }
        this.f42793a = fVar;
        if (!FileHelper.checkSD()) {
            String sdErrorString = FileHelper.getSdErrorString();
            if (sdErrorString == null) {
                sdErrorString = h.a(R.string.voice_error_sdcard);
            }
            this.f42793a.onShowErr(0, sdErrorString);
            return false;
        }
        q(true);
        String e2 = d.b.h0.r.g0.a.e();
        this.f42795c = e2;
        String c2 = d.b.h0.r.g0.a.c(e2);
        if (this.f42796d == null) {
            this.f42796d = new d(this, null);
        }
        d.b.f.a.a.a.g();
        o();
        boolean f2 = d.b.f.a.a.a.f(c2, i, this.f42796d);
        if (f2) {
            this.f42793a.onStartedRecorder(true);
            h.f42051a = 2;
        } else {
            h.f42051a = 1;
            d.b.f.a.a.a.g();
            FieldBuilder fieldBuilder = new FieldBuilder();
            fieldBuilder.append("voiceType", Integer.valueOf(i));
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", fieldBuilder.toString());
            this.f42793a.onStartedRecorder(false);
        }
        return f2;
    }

    @Override // d.b.i0.c3.p0.a
    public boolean d() {
        return h.f42051a == 1;
    }

    @Override // d.b.i0.c3.p0.a
    public void e(TbPageContext<?> tbPageContext) {
        this.f42798f = tbPageContext;
    }

    @Override // d.b.i0.c3.p0.a
    public void f() {
        d.b.f.a.a.a.e();
    }

    public final void m(String str, int i) {
        if (str == null || i < 1) {
            return;
        }
        h.f42051a = 3;
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

    @Override // d.b.i0.c3.p0.a
    public void release() {
        stopRecord();
        TbPageContext<?> tbPageContext = this.f42798f;
        if (tbPageContext != null && tbPageContext.getPageActivity() != null) {
            MediaService.stopMy(this.f42798f.getPageActivity());
        }
        Handler handler = this.f42794b;
        if (handler != null) {
            handler.removeCallbacks(this.f42797e);
        }
        this.f42798f = null;
        this.f42793a = null;
        this.f42794b = null;
    }

    @Override // d.b.i0.c3.p0.a
    public void stopRecord() {
        d.b.f.a.a.a.g();
        Handler handler = this.f42794b;
        if (handler != null) {
            handler.postDelayed(this.f42797e, 100L);
        }
        o();
    }
}
