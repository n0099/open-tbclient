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
/* loaded from: classes2.dex */
public class e implements d.b.i0.c3.p0.a {

    /* renamed from: a  reason: collision with root package name */
    public d.b.b.e.q.f f42792a;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f42797f;

    /* renamed from: c  reason: collision with root package name */
    public String f42794c = null;

    /* renamed from: d  reason: collision with root package name */
    public g f42795d = null;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f42796e = new c();

    /* renamed from: b  reason: collision with root package name */
    public Handler f42793b = new Handler();

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f42798e;

        public a(e eVar, String str) {
            this.f42798e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.h0.r.g0.a.a(d.b.h0.r.g0.a.b(this.f42798e));
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f42799e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f42800f;

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                eVar.f42792a.onShowErr(4, eVar.f42797f.getString(R.string.voice_error_file_md5));
                h.f42050a = 1;
            }
        }

        /* renamed from: d.b.f.a.a.e$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0577b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f42803e;

            public RunnableC0577b(String str) {
                this.f42803e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                h.f42050a = 1;
                b bVar = b.this;
                e.this.f42792a.onSendVoice(this.f42803e, bVar.f42800f);
            }
        }

        public b(String str, int i) {
            this.f42799e = str;
            this.f42800f = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = d.b.h0.r.g0.b.b.c(d.b.h0.r.g0.a.d(this.f42799e)).f50586a;
            if (e.this.f42793b != null) {
                e.this.f42793b.removeCallbacks(e.this.f42796e);
                if (StringUtils.isNull(str)) {
                    e.this.f42793b.post(new a());
                } else {
                    e.this.f42793b.post(new RunnableC0577b(str));
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.b.e.q.f fVar = e.this.f42792a;
            if (fVar == null || h.f42050a != 2) {
                return;
            }
            fVar.onStopingRecorder();
        }
    }

    /* loaded from: classes2.dex */
    public class d implements g {
        public d() {
        }

        @Override // d.b.b.e.q.g
        public void a(int i) {
            d.b.b.e.q.f fVar = e.this.f42792a;
            if (fVar == null) {
                return;
            }
            fVar.onShowRecordTime(i / 1000);
        }

        @Override // d.b.b.e.q.e
        public void b(int i) {
            d.b.b.e.q.f fVar = e.this.f42792a;
            if (fVar == null) {
                return;
            }
            fVar.onShowRecording(i);
        }

        @Override // d.b.b.e.q.e
        public void c(String str, int i) {
            e.this.o();
            h.f42050a = 1;
            if (e.this.f42794c != null && str != null) {
                e eVar = e.this;
                d.b.b.e.q.f fVar = eVar.f42792a;
                if (fVar == null) {
                    return;
                }
                if (i > 1000) {
                    if (!str.endsWith(eVar.f42794c)) {
                        FieldBuilder fieldBuilder = new FieldBuilder();
                        fieldBuilder.append("file", str);
                        fieldBuilder.append("dur", Integer.valueOf(i));
                        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", fieldBuilder.toString());
                        return;
                    }
                    e eVar2 = e.this;
                    String str2 = eVar2.f42794c;
                    double d2 = i;
                    Double.isNaN(d2);
                    eVar2.m(str2, (int) Math.round((d2 * 1.0d) / 1000.0d));
                    e.this.f42794c = null;
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
            h.f42050a = 1;
        }

        @Override // d.b.b.e.q.e
        public void error(int i, String str) {
            e.this.o();
            TiebaStatic.voiceError(i, "RecoreCallback.error: " + str, "");
            e eVar = e.this;
            if (eVar.f42792a == null) {
                h.f42050a = 1;
            } else if (i == 7) {
                if (eVar.f42794c == null) {
                    TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
                    return;
                }
                e eVar2 = e.this;
                eVar2.m(eVar2.f42794c, d.b.b.e.q.d.f42049a / 1000);
                e.this.f42794c = null;
                e eVar3 = e.this;
                eVar3.f42792a.onShowErr(3, eVar3.f42797f.getString(R.string.voice_record_timeout_tip));
            } else {
                h.f42050a = 1;
                if (i == 8) {
                    i = 2;
                }
                e.this.f42792a.onShowErr(i, str);
                TiebaStatic.voiceError(i, "RecoreCallback.err: " + str, "");
            }
        }

        public /* synthetic */ d(e eVar, a aVar) {
            this();
        }
    }

    static {
        h.f42050a = 1;
    }

    public static e n() {
        return new e();
    }

    @Override // d.b.i0.c3.p0.a
    public void a(String str) {
        stopRecord();
        q(false);
        d.b.b.e.q.f fVar = this.f42792a;
        if (fVar != null) {
            fVar.onDeletedVoice(str);
        }
        Handler handler = this.f42793b;
        if (handler == null) {
            return;
        }
        handler.postDelayed(new a(this, str), 200L);
    }

    @Override // d.b.i0.c3.p0.a
    public void b(d.b.b.e.q.f fVar) {
        this.f42792a = fVar;
    }

    @Override // d.b.i0.c3.p0.a
    public boolean c(d.b.b.e.q.f fVar, int i) {
        TbPageContext<?> tbPageContext;
        if (fVar == null || (tbPageContext = this.f42797f) == null || !PermissionUtil.checkWriteExternalStorage(tbPageContext.getPageActivity())) {
            return false;
        }
        this.f42792a = fVar;
        if (!FileHelper.checkSD()) {
            String sdErrorString = FileHelper.getSdErrorString();
            if (sdErrorString == null) {
                sdErrorString = h.a(R.string.voice_error_sdcard);
            }
            this.f42792a.onShowErr(0, sdErrorString);
            return false;
        }
        q(true);
        String e2 = d.b.h0.r.g0.a.e();
        this.f42794c = e2;
        String c2 = d.b.h0.r.g0.a.c(e2);
        if (this.f42795d == null) {
            this.f42795d = new d(this, null);
        }
        d.b.f.a.a.a.g();
        o();
        boolean f2 = d.b.f.a.a.a.f(c2, i, this.f42795d);
        if (f2) {
            this.f42792a.onStartedRecorder(true);
            h.f42050a = 2;
        } else {
            h.f42050a = 1;
            d.b.f.a.a.a.g();
            FieldBuilder fieldBuilder = new FieldBuilder();
            fieldBuilder.append("voiceType", Integer.valueOf(i));
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", fieldBuilder.toString());
            this.f42792a.onStartedRecorder(false);
        }
        return f2;
    }

    @Override // d.b.i0.c3.p0.a
    public boolean d() {
        return h.f42050a == 1;
    }

    @Override // d.b.i0.c3.p0.a
    public void e(TbPageContext<?> tbPageContext) {
        this.f42797f = tbPageContext;
    }

    @Override // d.b.i0.c3.p0.a
    public void f() {
        d.b.f.a.a.a.e();
    }

    public final void m(String str, int i) {
        if (str == null || i < 1) {
            return;
        }
        h.f42050a = 3;
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
        TbPageContext<?> tbPageContext = this.f42797f;
        if (tbPageContext != null && tbPageContext.getPageActivity() != null) {
            MediaService.stopMy(this.f42797f.getPageActivity());
        }
        Handler handler = this.f42793b;
        if (handler != null) {
            handler.removeCallbacks(this.f42796e);
        }
        this.f42797f = null;
        this.f42792a = null;
        this.f42793b = null;
    }

    @Override // d.b.i0.c3.p0.a
    public void stopRecord() {
        d.b.f.a.a.a.g();
        Handler handler = this.f42793b;
        if (handler != null) {
            handler.postDelayed(this.f42796e, 100L);
        }
        o();
    }
}
